package com.akos.gui.controllers;


import com.akos.models.services.MainService;
import com.akos.sphero.Robot;
import com.akos.sphero.commands.robot.OrbBasicController;
import javafx.application.Platform;
import javafx.concurrent.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import org.fxmisc.richtext.*;
import org.fxmisc.undo.UndoManagerFactory;
import org.reactfx.EventSource;

import java.net.URL;
import java.util.*;
import java.util.regex.*;

/**
 * Created by Ákos on 2015. 12. 06.
 * Email: akoshervay@gmail.com
 */


public class OrbbasicScreen extends AbstractController implements Initializable {

    public BorderPane view;
    public CodeArea codeArea;


    public OrbbasicScreen(MainService mainService) {
        super(mainService);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        codeArea.richChanges().filter(ch -> !ch.getInserted().equals(ch.getRemoved()))
                .subscribe(change -> {
                    codeArea.setStyleSpans(0, computeHighlighting(codeArea.getText()));
                    codeArea.getUndoManager().mark();
                });
        codeArea.setUndoManager(UndoManagerFactory.unlimitedHistoryFactory());
        codeArea.getStylesheets().add(getClass().getClassLoader().getResource("com/akos/css/code-style.css").toExternalForm());
    }

    private static final String[] VARIABLES = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z",
            "timerA", "timerB", "timerC", "ctrl", "speed",
            "yaw", "pitch", "roll", "accelX", "accelY",
            "accelZ", "gyroX", "gyroY", "gyroZ", "Vbatt",
            "cmdroll", "spdval", "hdgval", "cmdrgb", "redval",
            "grnval", "bluval", "isconn", "dshake", "accelone",
            "xpos", "ypos", "Qzero", "Qone", "Qtwo", "Qthree",
    };

    private static final String[] FUNCTIONS = new String[]{
            "sqrt", "rnd", "abs"
    };

    private static final String[] STATEMENTS = new String[]{
            "print", "input", "delay", "end", "RGB", "LEDC", "backLED",
            "random", "goroll", "heading", "raw", "locate", "basflg",
            "data", "rstr", "read", "tron", "troff", "reset", "sleep",
            "macrun", "mackill", "macstat", "goto", "gosub"
            , "for", "to", "next", "if", "then", "else"
    };


    private static final String VARIABLE_PATTERN = "\\b(" + String.join("|", VARIABLES) + ")\\b";
    private static final String FUNCTION_PATTERN = "\\b(" + String.join("|", FUNCTIONS) + ")\\b";
    private static final String STATEMENT_PATTERN = "\\b(" + String.join("|", STATEMENTS) + ")\\b";
    private static final String PAREN_PATTERN = "\\(|\\)";
    private static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    private static final String COMMENT_PATTERN = "\'.+";

    private static final Pattern PATTERN = Pattern.compile(
            "(?<VARIABLES>" + VARIABLE_PATTERN + ")"
                    + "|(?<FUNCTIONS>" + FUNCTION_PATTERN + ")"
                    + "|(?<STATEMENTS>" + STATEMENT_PATTERN + ")"
                    + "|(?<PAREN>" + PAREN_PATTERN + ")"
                    + "|(?<STRING>" + STRING_PATTERN + ")"
                    + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
    );

    private static StyleSpans<Collection<String>> computeHighlighting(String text) {
        Matcher matcher = PATTERN.matcher(text);
        int lastKwEnd = 0;
        StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();
        while (matcher.find()) {
            String styleClass;
            if (matcher.group("VARIABLES") != null) styleClass = "variable";
            else if (matcher.group("FUNCTIONS") != null) styleClass = "function";
            else if (matcher.group("STATEMENTS") != null) styleClass = "statement";
            else if (matcher.group("PAREN") != null) styleClass = "paren";
            else if (matcher.group("STRING") != null) styleClass = "string";
            else if (matcher.group("COMMENT") != null) styleClass = "comment";
            else styleClass = null;
            assert styleClass != null;
            spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
            spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
            lastKwEnd = matcher.end();
        }
        spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
        return spansBuilder.create();
    }

    public void sendCommand(ActionEvent actionEvent) {
        Robot r = mainService.getRobot();
        if (mainService.getRobot() != null) {
            Platform.runLater(() -> {
                OrbBasicController controller = new OrbBasicController(r);
                r.connect();
                controller.eraseStorage();
                controller.setProgram(codeArea.getText().getBytes());
                controller.loadProgram();
                controller.executeProgram();
            });
        }
    }

    public void abortCommand(ActionEvent actionEvent) {
        Robot r = mainService.getRobot();
        if (mainService.getRobot() != null) {
            Platform.runLater(() -> {
                OrbBasicController controller = new OrbBasicController(r);
                r.connect();
                controller.eraseStorage();
                controller.abortProgram();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r.disconnect();
            });
        }
    }
}