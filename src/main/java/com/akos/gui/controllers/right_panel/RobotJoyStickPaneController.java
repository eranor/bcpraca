package com.akos.gui.controllers.right_panel;


import com.akos.gui.controllers.AbstractController;
import com.akos.models.services.MainService;
import javafx.fxml.Initializable;
import javafx.scene.control.TitledPane;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ákos on 2015. 12. 21.
 * Email: akoshervay@gmail.com
 */


public class RobotJoyStickPaneController extends AbstractController implements Initializable {
    public TitledPane robotJoysickPaneView;
    public VBox rightPaneTabBody;
    public Pane joystickMovePane;
    public Circle joystickKnob;


    public RobotJoyStickPaneController(MainService mainService) {
        super(mainService);
        joystickKnob.setOnDragDetected(event -> {
            joystickKnob.startDragAndDrop(TransferMode.ANY);
        });
        joystickKnob.setOnDragOver(event -> {

        });

        joystickKnob.setOnDragDone(event -> {

        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
