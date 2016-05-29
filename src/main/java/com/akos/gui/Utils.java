package com.akos.gui;

import com.akos.App;
import com.akos.models.services.MainService;
import javafx.animation.*;
import javafx.concurrent.*;
import javafx.geometry.Pos;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.lang.reflect.Field;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class Utils {

    /**
     * <p>
     * Hack TooltipBehavior for edit the timing,
     * the feature request is currently scheduled for integration into Java 9.
     */
    public static void hackTooltipStartTiming(Tooltip tooltip) {
        try {
            Field fieldBehavior = tooltip.getClass().getDeclaredField("BEHAVIOR");
            fieldBehavior.setAccessible(true);
            Object objBehavior = fieldBehavior.get(tooltip);

            Field fieldTimer = objBehavior.getClass().getDeclaredField("activationTimer");
            fieldTimer.setAccessible(true);
            Timeline objTimer = (Timeline) fieldTimer.get(objBehavior);

            objTimer.getKeyFrames().clear();
            objTimer.getKeyFrames().add(new KeyFrame(new Duration(250)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static boolean hasRobotSelected(MainService mainService) {
        if (mainService.getRobot() != null) {
            return true;
        } else {
            Notifications.create().title("Warning").text("No robot selected to send program to.")
                    .hideAfter(Duration.seconds(3)).position(Pos.BOTTOM_RIGHT).owner(App.primaryStage)
                    .hideCloseButton().darkStyle().showWarning();
            return false;
        }
    }

    public static <V> Service<V> doSingleTask(Task<V> task) {
        Service<V> s = new Service<V>() {
            @Override
            protected Task<V> createTask() {
                return task;
            }
        };
        s.reset();
        s.start();
        return s;
    }
}
