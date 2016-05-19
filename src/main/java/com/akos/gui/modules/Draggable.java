package com.akos.gui.modules;

import javafx.geometry.Point2D;
import javafx.scene.Node;

/**
 * Created by Ákos on 2015. 12. 22.
 * Email: akoshervay@gmail.com
 */
public interface Draggable {

    void setDragOffset(Point2D newOffset);

    Point2D getDragOffset();

    Node getParent();

    void relocate(double x, double y);
}
