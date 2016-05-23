package com.akos.gui.controllers.right_panel;


import com.akos.gui.controllers.AbstractController;
import com.akos.models.services.MainService;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.*;

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
    Point2D orgTranslate, orgScene;


    public RobotJoyStickPaneController(MainService mainService) {
        super(mainService);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        joystickKnob.setOnMousePressed(event -> {
            orgScene = new Point2D(event.getSceneX(), event.getSceneY());
            orgTranslate = new Point2D(((Knob) (event.getSource())).getTranslateX(), ((Knob) (event.getSource())).getTranslateY());
        });
        joystickKnob.setOnMouseDragged(event -> {
            Point2D newscene = new Point2D(event.getSceneX(), event.getSceneY());
            Point2D newTranslate = orgTranslate.add(newscene.subtract(orgScene));
            double new_value = scaleToRange(orgScene.distance(newscene),0,rightPaneTabBody.getWidth()/2,0,100);
            System.out.println(new_value);
            if (joystickMovePane.getLayoutBounds().contains(((Knob) (event.getSource())).getBoundsInParent())) {
                ((Knob) (event.getSource())).setTranslateX(newTranslate.getX());
                ((Knob) (event.getSource())).setTranslateY(newTranslate.getY());
            } else {
                ((Knob) (event.getSource())).setTranslateX(newTranslate.getX());
                ((Knob) (event.getSource())).setTranslateY(newTranslate.getY());
            }
        });
        joystickKnob.setOnMouseReleased(event -> {
            ((Knob) (event.getSource())).setTranslateX(0);
            ((Knob) (event.getSource())).setTranslateY(0);
        });
    }

    private double scaleToRange(double oldValue, double oldMin, double oldMax, double newMin, double newMax) {
        double oldRange = (oldMax - oldMin);
        return oldRange == 0 ? newMin : (((oldValue - oldMin) * (newMax - newMin)) / oldRange) + newMin;
    }


}
