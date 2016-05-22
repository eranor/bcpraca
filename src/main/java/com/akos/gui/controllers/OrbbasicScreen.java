package com.akos.gui.controllers;


import com.akos.models.services.MainService;
import com.akos.sphero.Robot;
import com.akos.sphero.commands.robot.OrbBasicController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ákos on 2015. 12. 06.
 * Email: akoshervay@gmail.com
 */


public class OrbbasicScreen extends AbstractController implements Initializable {

    public TextArea textArea;

    public OrbbasicScreen(MainService mainService) {
        super(mainService);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void sendCommand(ActionEvent actionEvent) {
        Robot r = mainService.getRobot();
        if (mainService.getRobot() != null) {
            Platform.runLater(() -> {
                OrbBasicController controller = new OrbBasicController(r);
                r.connect();
                controller.eraseStorage();
                controller.setProgram(textArea.getText().getBytes());
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