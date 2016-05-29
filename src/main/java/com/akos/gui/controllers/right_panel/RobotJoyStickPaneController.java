package com.akos.gui.controllers.right_panel;


import com.akos.gui.controllers.AbstractController;
import com.akos.services.MainService;
import com.akos.sphero.Robot;
import com.akos.sphero.commands.robot.command.*;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.concurrent.*;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import org.controlsfx.control.PlusMinusSlider;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;


/**
 * Created by Ákos on 2015. 12. 21.
 * Email: akoshervay@gmail.com
 */


public class RobotJoystickPaneController extends AbstractController implements Initializable {
    public TitledPane robotJoystickPaneView;
    public VBox rightPaneTabBody;
    public Pane joystickMovePane;
    public Knob joystickKnob;
    public Circle joystickBackground;
    public ToggleButton connectToRobot;
    public HBox calibrationPanel;
    public PlusMinusSlider calibrateSlider;
    public Button calibrateButton;

    private Point2D orgScene;
    private Point2D center = new Point2D(65, 65);
    private double bgr;
    private double r;
    private int heading = 0;


    public RobotJoystickPaneController(MainService mainService) {
        super(mainService);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rightPaneTabBody.getChildren().remove(calibrationPanel);
        rightPaneTabBody.getChildren().remove(joystickMovePane);
        bgr = joystickBackground.getRadius();
        r = bgr - 15;

        calibrateSlider.setOnValueChanged(event1 -> {
            heading = Math.abs((int) (heading + event1.getValue() * 10)) % 360;
            if (mainService.getRobot().isConnected()) {
                System.out.println(heading);
                mainService.getRobot().send(new RollCommand(heading, 0.0f, RollCommand.State.CALIBRATE));
            }
        });

        calibrateButton.setOnAction(event -> {
            final Robot robot = mainService.getRobot();
            if (robot.isConnected()) {
                Task t = new Task() {
                    @Override
                    protected Object call() throws Exception {
                        robot.send(new SetBackLEDOutputCommand(0));
                        robot.send(new SetRGBLEDOutputCommand(0f, 255f, 0f));
                        return null;
                    }
                };
                rightPaneTabBody.getChildren().add(joystickMovePane);
                rightPaneTabBody.getChildren().remove(calibrationPanel);
                Platform.runLater(t);
            }
        });
        Service<?> connection = new Service() {
            @Override
            protected Task createTask() {
                return new Task() {
                    @Override
                    protected Object call() throws Exception {
                        final Robot robot = mainService.getRobot();
                        return CompletableFuture.runAsync(robot::connect)
                                .thenRun(() -> {
                                    robot.send(new SetBackLEDOutputCommand(1));
                                    robot.send(new SetRGBLEDOutputCommand(0f, 0f, 0f));
                                    robot.send(new SetStabilizationCommand(true));
                                    connectToRobot.setText(connectToRobot.getText().replace("on", "off"));
                                }).get();
                    }

                };
            }
        };

        connectToRobot.selectedProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue) {
                        if (com.akos.gui.Utils.hasRobotSelected(mainService)) {
                            rightPaneTabBody.getChildren().add(0, calibrationPanel);
                            connection.restart();
                        } else {
                            connectToRobot.setSelected(false);
                        }
                    } else {
                        if (mainService.getRobot() != null && mainService.getRobot().isConnected()) {
                            connectToRobot.setText(connectToRobot.getText().replace("off", "on"));
                            rightPaneTabBody.getChildren().remove(calibrationPanel);
                            rightPaneTabBody.getChildren().remove(joystickMovePane);
                            mainService.getRobot().disconnect();
                        }
                    }

                }
        );
        joystickBackground.setOnMousePressed(event -> joystickKnob.fireEvent(event));
        joystickBackground.setOnMouseReleased(event -> joystickKnob.fireEvent(event));
        joystickBackground.setOnMouseDragged(event -> joystickKnob.fireEvent(event));

        joystickKnob.setOnMousePressed(event ->

                {
                    orgScene = new Point2D(event.getSceneX(), event.getSceneY());
                    Point2D p = joystickMovePane.sceneToLocal(orgScene).subtract(35, 35);
                    joystickKnob.relocate(center.distance(p) < r ? p : getPointOnCircle(p));
                    fade(1);
                }

        );
        joystickKnob.setOnMouseDragged(event ->

                {
                    Point2D newScene = new Point2D(event.getSceneX(), event.getSceneY());
                    Point2D p = joystickMovePane.sceneToLocal(newScene).subtract(35, 35);

                    float velocity = com.akos.gui.Utils.scaleToRange(center.distance(p), 0, bgr, 0, 1);
                    heading = (int) get360Degree(getAngleFromCenter(p));

                    CompletableFuture.runAsync(() -> mainService.getRobot().send(new RollCommand(heading, velocity)));
                    joystickKnob.relocate(center.distance(p) < r ? p : getPointOnCircle(p));
                }

        );
        joystickKnob.setOnMouseReleased(event ->

                {
                    CompletableFuture.runAsync(() ->
                            mainService.getRobot().send(new RollCommand(heading, 1, RollCommand.State.STOP)));
                    joystickKnob.relocate(center);
                    fade(0.5);
                }

        );
    }

    protected void fade(double opacity) {
        Timeline a = new Timeline(60);
        a.getKeyFrames().clear();
        a.getKeyFrames().add(new KeyFrame(Duration.millis(200), new KeyValue(joystickKnob.opacityProperty(), opacity)));
        a.play();
    }

    private Point2D getPointOnCircle(Point2D np) {
        double x = center.getX() + r * Math.sin(getAngleFromCenter(np));
        double y = center.getY() + r * Math.cos(getAngleFromCenter(np));
        return new Point2D(x, y);
    }

    private double getAngleFromCenter(Point2D np) {
        return Math.atan2(np.getX() - bgr, np.getY() - bgr);
    }

    private double get360Degree(double rad) {
        return Math.abs(rad > 0 ? 360 - Math.toDegrees(rad) : -Math.toDegrees(rad));
    }
}
