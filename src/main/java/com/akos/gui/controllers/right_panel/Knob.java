package com.akos.gui.controllers.right_panel;

import com.akos.modules.Draggable;
import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class Knob extends Circle implements Draggable {

    private Point2D dragOffset;

    @Override
    public void setDragOffset(Point2D newOffset) {
        this.dragOffset = newOffset;
    }

    @Override
    public Point2D getDragOffset() {
        return dragOffset;
    }

    @Override
    public void relocate(Point2D point) {
        super.relocate(point.getX(), point.getY());
    }
}

