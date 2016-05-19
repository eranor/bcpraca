package com.akos.gui.controllers.canvas;

import javafx.beans.property.*;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class GriddedPane extends Pane implements Initializable {

    DoubleProperty gridWidth = new SimpleDoubleProperty(this, "gridWidth", 15);
    DoubleProperty gridHeight = new SimpleDoubleProperty(this, "gridHeight", 15);

    public GriddedPane() {
        super();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    protected void layoutChildren() {
        getChildren().clear();
        setMouseTransparent(true);
        toBack();
        for (int i = 0; i < getHeight(); i += getGridWidth())
            getChildren().add(makeLine(0, i, getWidth(), i, "x"));
        for (int i = 0; i < getWidth(); i += getGridHeight())
            getChildren().add(makeLine(i, 0, i, getHeight(), "y"));
    }

    public void redrawLines() {
        for (Node n : getChildren()) {
            Line l = (Line) n;
            if (l.getUserData().equals("x")) {
                l.setEndX(getWidth());
            } else if (l.getUserData().equals("y")) {
                l.setEndY(getHeight());
            }
        }
    }

    private Line makeLine(double sx, double sy, double ex, double ey, String data) {
        final Line line = new Line(sx, sy, ex, ey);
        if (ex % (getGridWidth() * 10) == 0.0) {
            line.setStroke(Color.BLACK);
            line.setStrokeWidth(0.3);
        } else if (ey % (getGridHeight() * 10) == 0.0) {
            line.setStroke(Color.BLACK);
            line.setStrokeWidth(0.3);
        } else {
            line.setStroke(Color.GRAY);
            line.setStrokeWidth(0.1);
        }
        line.setUserData(data);
        return line;
    }

    public double getGridWidth() {
        return gridWidth.get();
    }

    public DoubleProperty gridWidthProperty() {
        return gridWidth;
    }

    public void setGridWidth(double gridWidth) {
        this.gridWidth.set(gridWidth);
    }

    public double getGridHeight() {
        return gridHeight.get();
    }

    public DoubleProperty gridHeightProperty() {
        return gridHeight;
    }

    public void setGridHeight(double gridHeight) {
        this.gridHeight.set(gridHeight);
    }
}
