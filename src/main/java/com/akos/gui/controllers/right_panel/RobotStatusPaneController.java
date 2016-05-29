package com.akos.gui.controllers.right_panel;


import com.akos.gui.Utils;
import com.akos.gui.controllers.AbstractController;
import com.akos.services.*;
import com.akos.sphero.Robot;
import com.akos.sphero.commands.robot.OrbBasicController;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.SetChangeListener;
import javafx.concurrent.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.controlsfx.glyphfont.Glyph;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ákos on 2015. 12. 21.
 * Email: akoshervay@gmail.com
 */


public class RobotStatusPaneController extends AbstractController implements Initializable {
    public Label robotNameLabel;
    public Label robotAddressLabel;

    public VBox rightPaneTabBody;
    public ChoiceBox<Program> currentProgramsChoiceBox;
    public TitledPane robotStatusPaneView;
    public Button robotSendCurrentProgram;
    public Button robotRunCurrentProgram;
    public Button robotAbortCurrentProgram;

    private SimpleObjectProperty<Program> selectedProgram;


    public RobotStatusPaneController(MainService mainService) {
        super(mainService);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectedProgram = new SimpleObjectProperty<>(this, "selectedProgram", null);

        mainService.robotProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                robotNameLabel.setText(newValue.getName());
                robotAddressLabel.setText(newValue.getFormattedAddress());
            }
        });
        mainService.getPrograms().addListener((SetChangeListener<? super Program>) change -> {
            currentProgramsChoiceBox.getItems().setAll(change.getSet());
        });

        robotSendCurrentProgram.setGraphic(Glyph.create("FontAwesome|DOWNLOAD").sizeFactor(2).color(Color.ORANGE).useGradientEffect());
        robotRunCurrentProgram.setGraphic(Glyph.create("FontAwesome|PLAY").sizeFactor(2).color(Color.GREEN).useGradientEffect());
        robotAbortCurrentProgram.setGraphic(Glyph.create("FontAwesome|REMOVE").sizeFactor(2).color(Color.RED).useGradientEffect());

        selectedProgram.bind(currentProgramsChoiceBox.valueProperty());
    }

    public void sendCurrentProgram(ActionEvent actionEvent) {
        Robot r = mainService.getRobot();
        if (Utils.hasRobotSelected(mainService)) {
            Service<?> service = new Service<Void>() {
                @Override
                protected Task<Void> createTask() {
                    return new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                            OrbBasicController controller = new OrbBasicController(r);
                            r.connect();
                            controller.eraseStorage();
                            String p = mainService.getCurrentProgram().compile();
                            System.out.println(p);
                            controller.setProgram(p.getBytes());
                            return null;
                        }
                    };
                }
            };
            service.setOnSucceeded(event -> {
                if (r.isConnected())
                    r.disconnect();
            });
            service.reset();
            service.start();
        }
    }

    public void abortCurrentProgram(ActionEvent actionEvent) {
        Robot r = mainService.getRobot();
        if (Utils.hasRobotSelected(mainService)) {
            Service<?> service = new Service<Void>() {
                @Override
                protected Task<Void> createTask() {
                    return new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                            OrbBasicController controller = new OrbBasicController(r);
                            if (!r.isConnected())
                                r.connect();
                            controller.eraseStorage();
                            controller.abortProgram();
                            return null;
                        }
                    };
                }
            };
            service.setOnSucceeded(event -> {
                if (r.isConnected())
                    r.disconnect();
            });
            service.reset();
            service.start();
        }
    }


    public void runProgram(ActionEvent actionEvent) {
        Robot r = mainService.getRobot();
        if (Utils.hasRobotSelected(mainService)) {
            Service<?> service = new Service<Void>() {
                @Override
                protected Task<Void> createTask() {
                    return new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                            OrbBasicController controller = new OrbBasicController(r);
                            if (!r.isConnected())
                                r.connect();
                            controller.loadProgram();
                            controller.executeProgram();
                            return null;
                        }
                    };
                }
            };
            service.reset();
            service.start();
        }
    }

}
