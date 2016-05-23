package com.akos.gui.controllers.right_panel;


import com.akos.gui.controllers.AbstractController;
import com.akos.models.services.MainService;
import com.akos.sphero.commands.robot.command.RollCommand;
import javafx.animation.*;
import javafx.concurrent.*;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import org.controlsfx.control.*;

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
    public Knob joystickKnob;
    public Circle joystickBackground;
    public ToggleSwitch connectoToRobot;
    public VBox calibrationPanel;
    public PlusMinusSlider calibrateSlider;
    public Button calibrateButton;

    Point2D orgScene;
    Point2D center = new Point2D(65, 65);
    double bgr;
    double r;
    int heading;


    public RobotJoyStickPaneController(MainService mainService) {
        super(mainService);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bgr = joystickBackground.getRadius();
        r = bgr - 15;

        connectoToRobot.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                mainService.getRobot().connect();
            } else {
                mainService.getRobot().disconnect();
            }
        });

        joystickKnob.setOnMousePressed(event -> {
            orgScene = new Point2D(event.getSceneX(), event.getSceneY());
            fade(1);
        });
        joystickKnob.setOnMouseDragged(event -> {
            Point2D newScene = new Point2D(event.getSceneX(), event.getSceneY());
            Point2D p = joystickMovePane.sceneToLocal(newScene).subtract(35, 35);
            double new_value = scaleToRange(center.distance(p), 0, bgr, 0, 100);
            System.out.println(new_value);
            heading = (int) get360Degree(getAngleFromCenter(p));
            mainService.getRobot().send(new RollCommand(heading, (float) new_value));
            joystickKnob.relocate(center.distance(p) < r ? p : getPointOnCircle(p));
        });
        joystickKnob.setOnMouseReleased(event -> {
            mainService.getRobot().send(new RollCommand(heading, 0, RollCommand.State.STOP));
            joystickKnob.relocate(center);
            fade(0.5);
        });
    }

    protected void fade(double opacity) {
        Timeline a = new Timeline(60);
        a.getKeyFrames().clear();
        a.getKeyFrames().add(new KeyFrame(Duration.millis(200), new KeyValue(joystickKnob.opacityProperty(), opacity)));
        a.play();
    }

    private double scaleToRange(double oldValue, double oldMin, double oldMax, double newMin, double newMax) {
        double oldRange = (oldMax - oldMin);
        double r = (((oldValue - oldMin) * (newMax - newMin)) / oldRange) + newMin;
        return oldRange == 0 ? newMin : r >= newMax ? newMax : r;
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
        return rad > 0 ? Math.toDegrees(rad) : 180 + Math.toDegrees(-rad);
    }
}
