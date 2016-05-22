package com.akos.gui.modules;


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

    private Side startSide = Side.TOP;
    private Side endSide = Side.BOTTOM;
    private DoubleProperty startX = new SimpleDoubleProperty(this, "startX", 0);
    private DoubleProperty startY = new SimpleDoubleProperty(this, "startY", 0);
    private DoubleProperty endX = new SimpleDoubleProperty(this, "endX", 0);
    private DoubleProperty endY = new SimpleDoubleProperty(this, "endY", 0);
    private final DoubleProperty mControlOffsetX = new SimpleDoubleProperty();
    private final DoubleProperty mControlOffsetY = new SimpleDoubleProperty();


    public ModuleLink() {
        CFXMLLoader.load("com/akos/fxml/modules/ModuleLink.fxml", this);
        setId(UUID.randomUUID().toString());
    }


    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        setMouseTransparent(true);
        mControlOffsetX.set(100);
        mControlOffsetY.set(50);

        link.controlX1Property().bind(Bindings.add(link.startXProperty(), mControlOffsetX.multiply(startX)));
        link.controlX2Property().bind(Bindings.add(link.endXProperty(), mControlOffsetX.multiply(endX)));
        link.controlY1Property().bind(Bindings.add(link.startYProperty(), mControlOffsetY.multiply(startY)));
        link.controlY2Property().bind(Bindings.add(link.endYProperty(), mControlOffsetY.multiply(endY)));
    }

    public void bindDirection() {
        if (startSide.isVertical())
            startX.bind(new When(link.startXProperty().greaterThan(link.endXProperty())).then(-1.0).otherwise(1.0));
        else
            startY.bind(new When(link.startYProperty().greaterThan(link.endYProperty())).then(-1.0).otherwise(1.0));

        if (endSide.isVertical())
            endX.bind(new When(link.startXProperty().greaterThan(link.endXProperty())).then(1.0).otherwise(-1.0));
        else
            endY.bind(new When(link.startYProperty().greaterThan(link.endYProperty())).then(1.0).otherwise(-1.0));
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


    public void bindEnds(ModuleConnector s, ModuleConnector t) {
        start = (AbstractFunctionModule) s.getParent();
        end = (AbstractFunctionModule) t.getParent();
        link.startXProperty().bind(Bindings.add(s.layoutXProperty(), (s.getWidth() / 2)).add(start.layoutXProperty()));
        link.startYProperty().bind(Bindings.add(s.layoutYProperty(), (s.getHeight() / 2)).add(start.layoutYProperty()));
        link.endXProperty().bind(Bindings.add(t.layoutXProperty(), (t.getWidth() / 2)).add(end.layoutXProperty()));
        link.endYProperty().bind(Bindings.add(t.layoutYProperty(), (t.getHeight() / 2)).add(end.layoutYProperty()));

        start.registerLink(getId());
        end.registerLink(getId());
    }

    public void setStartSide(Side startSide) {
        this.startSide = startSide;
    }

    public void setEndSide(Side endSide) {
        this.endSide = endSide;
    }

}
