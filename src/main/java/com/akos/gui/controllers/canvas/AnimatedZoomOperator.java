package com.akos.gui.controllers.canvas;

import javafx.animation.*;
import javafx.beans.property.*;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.*;
import javafx.util.Duration;

/**
 * Created by Ákos on 2015. 12. 17.
 * Email: akoshervay@gmail.com
 */
public class AnimatedZoomOperator {

    private Timeline timeline;

    private final DoubleProperty zoomProperty = new SimpleDoubleProperty(1.4);

    public AnimatedZoomOperator() {
        this.timeline = new Timeline(60);
    }

    public void zoom(ScrollPane scrollPane, Node node, ScrollEvent event) {
        if (event.getDeltaY() <= 0)
            zoomProperty.set(1 / zoomProperty.get());
        double newScaleX = node.getScaleX() * zoomProperty.get();
        double newScaleY = node.getScaleY() * zoomProperty.get();
        double fx = (newScaleX / node.getScaleX()) - 1;
        double fy = (newScaleY / node.getScaleY()) - 1;

        Bounds bounds = node.localToScene(node.getBoundsInLocal());
        double dx = (event.getSceneX() - (bounds.getWidth() / 2 + bounds.getMinX())) / 1000;
        double dy = (event.getSceneY() - (bounds.getHeight() / 2 + bounds.getMinY())) / 1000;
        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(200), new KeyValue(node.scaleXProperty(), newScaleX),
                        new KeyValue(scrollPane.hvalueProperty(), scrollPane.getHvalue() + fx * dx),
                        new KeyValue(node.scaleYProperty(), newScaleY),
                        new KeyValue(scrollPane.vvalueProperty(), scrollPane.getVvalue() + fy * dy))
        );
        timeline.play();
    }

    public void zoom(ScrollPane scrollPane, Node node, ZoomEvent event) {
        double newScaleX = node.getScaleX() * event.getZoomFactor();
        double newScaleY = node.getScaleY() * event.getZoomFactor();
        double fx = (newScaleX / node.getScaleX()) - 1;
        double fy = (newScaleY / node.getScaleY()) - 1;

        Bounds bounds = node.localToScene(node.getBoundsInLocal());
        double dx = (event.getSceneX() - (bounds.getWidth() / 2 + bounds.getMinX()));
        double dy = (event.getSceneY() - (bounds.getHeight() / 2 + bounds.getMinY()));

        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().addAll(
                //new KeyFrame(Duration.millis(100), new KeyValue(scrollPane.hmaxProperty(), scrollPane.getHmax() * newScaleX)),
                //new KeyFrame(Duration.millis(100), new KeyValue(scrollPane.vmaxProperty(), scrollPane.getVmax() * newScaleY)),
                new KeyFrame(Duration.millis(200), new KeyValue(node.scaleXProperty(), newScaleX)),
                new KeyFrame(Duration.millis(200), new KeyValue(node.scaleYProperty(), newScaleY))
        );
        timeline.play();
    }
}