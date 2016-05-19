package com.akos.gui.controllers.canvas;

import com.akos.gui.modules.AbstractFunctionModule;
import com.akos.models.services.SelectionModel;
import javafx.collections.ObservableSet;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;


/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class RectangleSelection {

    private final DragContext dragContext = new DragContext();
    private Rectangle rect;
    private Pane group;
    private SelectionModel selectionModel;

    public RectangleSelection(Pane group) {
        this.group = group;
    }

    public void startSelection(SelectionModel selectionModel, MouseEvent event) {
        this.selectionModel = selectionModel;

        group.setOnMouseDragged(null);
        group.setOnMouseReleased(null);

        group.setOnMouseDragged(onMouseDraggedEventHandler);
        group.setOnMouseReleased(onMouseReleasedEventHandler);

        Point2D localMousePos = group.sceneToLocal(event.getSceneX(), event.getSceneY());

        dragContext.mouseAnchorX = localMousePos.getX();
        dragContext.mouseAnchorY = localMousePos.getY();

        rect = new Rectangle(dragContext.mouseAnchorX, dragContext.mouseAnchorY, 0, 0);
        rect.setStroke(Color.GRAY);
        rect.setStrokeWidth(0.5);
        rect.getStrokeDashArray().addAll(3d);
        rect.setStrokeLineCap(StrokeLineCap.SQUARE);
        rect.setFill(Color.LIGHTBLUE.deriveColor(0, 1.2, 1, 0.3));

        group.getChildren().add(rect);
    }

    EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
            if (event.getButton() == MouseButton.SECONDARY) {
                event.consume();
            }
            Point2D localMousePos = group.sceneToLocal(event.getSceneX(), event.getSceneY());
            double localX = localMousePos.getX();
            double localY = localMousePos.getY();
            double offsetX = localX - dragContext.mouseAnchorX;
            double offsetY = localY - dragContext.mouseAnchorY;

            if (offsetX > 0)
                rect.setWidth(offsetX);
            else {
                rect.setX(localX);
                rect.setWidth(dragContext.mouseAnchorX - rect.getX());
            }

            if (offsetY > 0) {
                rect.setHeight(offsetY);
            } else {
                rect.setY(localY);
                rect.setHeight(dragContext.mouseAnchorY - rect.getY());
            }
            event.consume();

        }
    };

    EventHandler<MouseEvent> onMouseReleasedEventHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
            if (event.getButton() == MouseButton.SECONDARY) {
                event.consume();
            }
            if (!event.isShiftDown() && !event.isControlDown()) {
                selectionModel.clear();
            }
            group.setOnMouseDragged(null);
            group.setOnMouseReleased(null);

            group.getChildren().stream()
                    .filter(node -> node instanceof AbstractFunctionModule)
                    .filter(node -> node.getBoundsInParent().intersects(rect.getBoundsInParent()))
                    .forEach(node -> {
                        if (event.isShiftDown()) {
                            selectionModel.add(node);
                        } else if (event.isControlDown()) {
                            if (selectionModel.contains(node)) selectionModel.remove(node);
                            else selectionModel.add(node);
                        } else selectionModel.add(node);
                    });

            final ObservableSet<Node> selection = selectionModel.getSelection();
            selectionModel.setSelectedNode(selection.size() == 1 ? selection.iterator().next() : null);

            rect.setX(0);
            rect.setY(0);
            rect.setWidth(0);
            rect.setHeight(0);

            group.getChildren().remove(rect);
            event.consume();

        }
    };
}
