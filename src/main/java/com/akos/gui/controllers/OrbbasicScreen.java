package com.akos.gui.controllers;


import com.akos.gui.Utils;
import com.akos.language.*;
import com.akos.services.MainService;
import com.akos.sphero.Robot;
import com.akos.sphero.commands.robot.OrbBasicController;
import javafx.application.Platform;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.*;
import org.antlr.v4.runtime.*;
import org.controlsfx.control.NotificationPane;
import org.fxmisc.richtext.*;
import org.fxmisc.undo.UndoManagerFactory;

import java.net.URL;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

/**
 * Created by Ákos on 2015. 12. 06.
 * Email: akoshervay@gmail.com
 */


public class OrbbasicScreen extends AbstractController implements Initializable {

    public TextArea codeArea;
    public NotificationPane notificationPane;


    public OrbbasicScreen(MainService mainService) {
        super(mainService);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        codeArea.richChanges().filter(ch -> !ch.getInserted().equals(ch.getRemoved()))
                .subscribe(change -> {
                    codeArea.setStyleSpans(0, computeHighlighting(codeArea.getText()));
                    codeArea.getUndoManager().mark();
                });
        codeArea.setUndoManager(UndoManagerFactory.unlimitedHistoryFactory());
        codeArea.getStylesheets().add(getClass().getClassLoader().getResource("com/akos/css/code-style.css").toExternalForm());*/
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
        if (Utils.hasRobotSelected(mainService)) {
            Platform.runLater(() -> {
                OrbBasicController controller = new OrbBasicController(r);

                final String text = codeArea.getText();
                StringBuffer sb = new StringBuffer();
                final String[] split = text.split("\n");
                for (int i = 0; i < split.length; i++) {
                    if (!split[i].matches("")) {
                        sb.append(i).append(" ").append(split[i]).append("\n");
                    }
                }
                OrbbasicLexer lexer = new OrbbasicLexer(new ANTLRInputStream(sb.toString()));
                ObservableList<String> errors = FXCollections.emptyObservableList();
                DescriptiveErrorListener errorListener = new DescriptiveErrorListener(errors);

                lexer.removeErrorListeners();
                lexer.addErrorListener(errorListener);
                CommonTokenStream tokens = new CommonTokenStream(lexer);

                OrbbasicParser parser = new OrbbasicParser(tokens);
                parser.removeErrorListeners();
                parser.addErrorListener(errorListener);
                OrbbasicParser.ProgContext c = parser.prog();
                if (errors.size() > 0) {
                    Alert dlg = new Alert(Alert.AlertType.ERROR, "");
                    dlg.initModality(Modality.WINDOW_MODAL);
                    final Window owner = codeArea.getScene().getWindow();
                    dlg.initOwner(owner);
                    dlg.setTitle("Error");
                    dlg.getDialogPane().setHeaderText("Exception Encountered");
                    String s = errors.stream().collect(Collectors.joining("\n"));
                    dlg.getDialogPane().setContentText(s);
                    dlg.show();
                } else {
                    r.connect();
                    controller.eraseStorage();
                    controller.setProgram(text.getBytes());
                    controller.loadProgram();
                    controller.executeProgram();
                }
            });
        }
    }

    public void abortCommand(ActionEvent actionEvent) {
        Robot r = mainService.getRobot();
        if (Utils.hasRobotSelected(mainService)) {
            Platform.runLater(() -> {
                OrbBasicController controller = new OrbBasicController(r);
                if (!r.isConnected()) r.connect();
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

    public void runCommand(ActionEvent actionEvent) {
        Robot r = mainService.getRobot();
        if (Utils.hasRobotSelected(mainService)) {
            Platform.runLater(() -> {
                OrbBasicController controller = new OrbBasicController(r);
                if (!r.isConnected()) r.connect();
                controller.loadProgram();
                controller.executeProgram();
            });
        }
    }
}