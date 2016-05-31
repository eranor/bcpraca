package com.akos.modules;


import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.fxml.*;
import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.CubicCurve;

import java.net.URL;
import java.util.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ModuleLink extends AnchorPane implements Initializable {
    @FXML
    CubicCurve link;

    AbstractFunctionModule start;
    AbstractFunctionModule end;

    private ModuleConnector startConn = null;
    private ModuleConnector endConn = null;
    private DoubleProperty startX = new SimpleDoubleProperty(this, "startX", 0);
    private DoubleProperty startY = new SimpleDoubleProperty(this, "startY", 0);
    private DoubleProperty endX = new SimpleDoubleProperty(this, "endX", 0);
    private DoubleProperty endY = new SimpleDoubleProperty(this, "endY", 0);
    private final DoubleProperty offsetX = new SimpleDoubleProperty();
    private final DoubleProperty offsetY = new SimpleDoubleProperty();


    public ModuleLink() {
        CFXMLLoader.load("com/akos/fxml/modules/ModuleLink.fxml", this);
        setId(UUID.randomUUID().toString());
    }


    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        setMouseTransparent(true);
        offsetX.set(50);
        offsetY.set(200);

        link.controlX1Property().bind(Bindings.add(link.startXProperty(), offsetX.multiply(startX)));
        link.controlX2Property().bind(Bindings.add(link.endXProperty(), offsetX.multiply(endX)));
        link.controlY1Property().bind(Bindings.add(link.startYProperty(), offsetY.multiply(startY)));
        link.controlY2Property().bind(Bindings.add(link.endYProperty(), offsetY.multiply(endY)));
    }

    public void bindDirection() {
        When whenX = new When(link.startXProperty().greaterThan(link.endXProperty()));
        When whenY = new When(link.startYProperty().greaterThan(link.endYProperty()));
        if (startConn.getSide().isVertical()) {
            startX.bind(whenX.then(-1.0).otherwise(1.0));
        } else {
            if (endConn != null) {
                link.controlX1Property().unbind();
                final NumberBinding otherwise = whenY.then(link.endXProperty()).otherwise(link.startXProperty());
                link.controlX1Property().bind(Bindings.add(otherwise, whenX.then(30.0).otherwise(-30.0)));

                link.controlY1Property().unbind();
                final NumberBinding multiply = Bindings.multiply(offsetY.multiply(startY), whenY.then(-1.0).otherwise(1.0));
                link.controlY1Property().bind(Bindings.add(link.startYProperty(), multiply));
            }
            startY.bind(whenY.then(-1.0).otherwise(1.0));
        }

        if (endConn != null) {
            if (endConn.getSide().isVertical()) {
                endX.bind(whenX.then(1.0).otherwise(-1.0));
            } else {
                if (startConn.getSide() == Side.RIGHT && endConn.getSide().isHorizontal()) {
                    startX.unbind();
                    link.controlX1Property().unbind();
                    link.controlX1Property().bind(Bindings.add(link.startXProperty(), offsetX.multiply(startX)));
                }
                link.controlX2Property().unbind();
                offsetX.bind(whenX.then(200).otherwise(70));
                final NumberBinding otherwise = whenY.then(link.startXProperty()).otherwise(link.endXProperty());
                link.controlX2Property().bind(Bindings.add(otherwise, whenX.then(-30.0).otherwise(30.0)));

                link.controlY2Property().unbind();
                offsetY.bind(whenY.then(200).otherwise(70));
                final NumberBinding multiply = Bindings.multiply(offsetY.multiply(endY), whenY.then(-1.0).otherwise(1.0));
                link.controlY2Property().bind(Bindings.add(link.endYProperty(), multiply));
                endY.bind(whenY.then(1.0).otherwise(-1.0));
            }
        } else {
            endY.bind(whenY.then(1.0).otherwise(-1.0));
        }

    }

    private void unbindControls() {
        link.controlX1Property().unbind();
        link.controlY1Property().unbind();
        link.controlX2Property().unbind();
        link.controlY2Property().unbind();
    }

    public void setStart(Point2D startPoint) {
        link.setStartX(startPoint.getX());
        link.setStartY(startPoint.getY());
    }

    public void setEnd(Point2D endPoint) {
        link.setEndX(endPoint.getX());
        link.setEndY(endPoint.getY());
    }


    public Parent getModule() {
        return this.getParent();
    }


    public void bindEnds() {
        start = (AbstractFunctionModule) startConn.getParent();
        end = (AbstractFunctionModule) endConn.getParent();
        link.startXProperty().bind(Bindings.add(startConn.layoutXProperty(), (startConn.getWidth() / 2)).add(start.layoutXProperty()));
        link.startYProperty().bind(Bindings.add(startConn.layoutYProperty(), (startConn.getHeight() / 2)).add(start.layoutYProperty()));
        link.endXProperty().bind(Bindings.add(endConn.layoutXProperty(), (endConn.getWidth() / 2)).add(end.layoutXProperty()));
        link.endYProperty().bind(Bindings.add(endConn.layoutYProperty(), (endConn.getHeight() / 2)).add(end.layoutYProperty()));

        startConn.setConnected(true);
        endConn.setConnected(endConn.getConnectorType() != ModuleConnector.ConnectorType.IN);
        start.registerLink(getId());
        end.registerLink(getId());
    }

    public void setStartConn(ModuleConnector startConn) {
        this.startConn = startConn;
    }

    public void setEndConn(ModuleConnector endConn) {
        this.endConn = endConn;
    }

}
