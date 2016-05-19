package com.akos.gui.controllers.right_panel;


import com.akos.gui.controllers.AbstractController;
import com.akos.models.services.*;
import com.akos.sphero.common.internal.DeviceResponse;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.*;

/**
 * Created by Ákos on 2015. 12. 21.
 * Email: akoshervay@gmail.com
 */


public class RobotConsolePaneController extends AbstractController implements Initializable {


    public TitledPane robotConsoleView;
    public VBox rightPaneTabBody;
    public TextArea consoleTextArea;
    private SimpleObjectProperty<Program> selectedProgram;


    public RobotConsolePaneController(MainService mainService) {
        super(mainService);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Thread t = new Thread(() -> {
            System.out.println("Watcher started");
            while (true) {
                if (mainService.getRobot() != null) {
                    ArrayList<DeviceResponse> responses = mainService.getRobot().getAllPackets();
                    if (responses.size() > 0)
                        responses.forEach(deviceResponse -> Platform.runLater(() ->
                                consoleTextArea.appendText(deviceResponse.toString() + "\n")));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

}
