package com.akos.gui.controllers.right_panel;


import com.akos.gui.controllers.AbstractController;
import com.akos.models.services.*;
import com.akos.sphero.Robot;
import com.akos.sphero.commands.robot.OrbBasicController;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.SetChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ákos on 2015. 12. 21.
 * Email: akoshervay@gmail.com
 */


public class RobotStatusPaneController extends AbstractController implements Initializable {
    public Label robotNameLabel;
    public Label robotAddressLabel;
    public Label robotConnectionAddressLabel;
    public Button robotRunCurrentProgram;
    public VBox rightPaneTabBody;
    public ChoiceBox<Program> currentProgramsChoiceBox;
    public TitledPane robotStatusPaneView;
    public Button robotSendCurrentProgram;

    private SimpleObjectProperty<Program> selectedProgram;


    public RobotStatusPaneController(MainService mainService) {
        super(mainService);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectedProgram = new SimpleObjectProperty<>(this, "selectedProgram", null);

        setRobotDataChangeListener();
        setProgramListChangeListener();
        setRunButtonOnActionEvent();

        selectedProgram.bind(currentProgramsChoiceBox.valueProperty());
    }

    private void setRobotDataChangeListener() {
        mainService.robotProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                robotNameLabel.setText(newValue.getName());
                robotAddressLabel.setText(newValue.getAddress());
                robotConnectionAddressLabel.setText(newValue.getConnectionURL().substring(0, 15) + "...");
            }
        });
    }

    private void setProgramListChangeListener() {
        mainService.getPrograms().addListener((SetChangeListener<? super Program>) change -> {
            currentProgramsChoiceBox.getItems().setAll(change.getSet());
        });
    }

    private void setRunButtonOnActionEvent() {

    }


    public void sendCurrentProgram(ActionEvent actionEvent) {
        Robot r = mainService.getRobot();
        if (mainService.getRobot() != null) {
            Platform.runLater(() -> {
                OrbBasicController controller = new OrbBasicController(r);
                r.connect();
                controller.eraseStorage();
                String p = mainService.getCurrentProgram().compile();
                /*String s1 = "10 X = 1\n" +
                        "20 backLED X\n" +
                        "30 delay 100\n" +
                        "40 X = X + 1\n" +
                        "45 print accelX, accelY, accelZ\n" +
                        "50 if X < 256 then goto 20\n" +
                        "60 goto 10";*/
                System.out.println(p);
                controller.setProgram(p.getBytes());
                controller.loadProgram();
                controller.executeProgram();
            });
        }
    }

    public void abortCurrentProgram(ActionEvent actionEvent) {
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
