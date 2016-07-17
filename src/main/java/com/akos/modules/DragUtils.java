package com.akos.modules;

import com.akos.App;
import com.akos.services.SelectionModel;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;

import java.io.Serializable;

public class DragUtils {

    public static void buildNodeDragHandlers(AbstractModule module) {
        EventHandler<DragEvent> mCtxDragOver = event -> {
            event.acceptTransferModes(TransferMode.ANY);

            final Point2DSerial scenePoint = new Point2DSerial(event.getSceneX(), event.getSceneY());
            relocateToPoint(module, scenePoint);

            SelectionModel sm = App.mainService.getSelectionModel();
            if (sm.selectedCount() > 1) {
                sm.getSelection().stream()
                        .filter(n -> n != module)
                        .forEach((node) -> relocateToPoint((Draggable) node, scenePoint));
            }
            event.consume();
        };

        EventHandler<DragEvent> mCtxDragDropped = event -> {
            module.getParent().setOnDragOver(null);
            module.getParent().setOnDragDropped(null);
            module.toFront();
            event.setDropCompleted(true);
            event.consume();
        };

        module.setDragOffset(new Point2D(0.0, 0.0));

        module.setOnDragDetected(event -> {
            if (!event.isPrimaryButtonDown())
                return;
            module.getParent().setOnDragOver(null);
            module.getParent().setOnDragDropped(null);

            module.getParent().setOnDragOver(mCtxDragOver);
            module.getParent().setOnDragDropped(mCtxDragDropped);

            final Point2D newOffset = new Point2D(event.getX(), event.getY());
            final Point2D point = new Point2D(event.getSceneX(), event.getSceneY());

            module.setDragOffset(newOffset);

            relocateToPoint(module, point);

            SelectionModel sm = App.mainService.getSelectionModel();
            if (sm.selectedCount() > 1) {
                sm.getSelection().stream().filter(n -> n != module).forEach(node -> {
                    Point2D moduleOffset = new Point2D(node.getLayoutX() - module.getLayoutX(), node.getLayoutY() - module.getLayoutY());
                    ((Draggable) node).setDragOffset(newOffset.subtract(moduleOffset));
                    relocateToPoint((Draggable) node, point);
                });
            }

            ClipboardContent content = new ClipboardContent();
            DragDropContainer container = new DragDropContainer();

            container.addData("type", module.getModel().getType());
            container.addData("data", module.getModel());
            content.put(DragDropContainer.DragNode, container);
            module.startDragAndDrop(TransferMode.ANY).setContent(content);

            event.consume();
        });


    }

    public static void relocateToPoint(Draggable node, Point2D point) {
        Point2D localCoords = node.getParent().sceneToLocal(point);
        node.relocate(localCoords.subtract(node.getDragOffset()));
    }


    public static void buildLinkDragHandlers(AbstractFunctionModule module) {
        ModuleLink mLink = new ModuleLink();

        EventHandler<DragEvent> mContextLinkDragOver = event -> {
            event.acceptTransferModes(TransferMode.ANY);
            if (!mLink.isVisible())
                mLink.setVisible(true);
            mLink.setEnd(new Point2D(event.getX(), event.getY()));
            event.consume();
        };

        EventHandler<DragEvent> mContextLinkDragDropped = event -> {
            module.getParent().setOnDragOver(null);
            module.getParent().setOnDragDropped(null);
            event.setDropCompleted(true);

            mLink.setVisible(false);
            module.helper_pane.getChildren().remove(0);

            event.consume();
        };

        EventHandler<MouseEvent> mLinkHandleDragDetected = event -> {
            module.getParent().setOnDragOver(null);
            module.getParent().setOnDragDropped(null);
            module.getParent().setOnDragOver(mContextLinkDragOver);
            module.getParent().setOnDragDropped(mContextLinkDragDropped);

            ModuleConnector startConn = (ModuleConnector) event.getSource();
            mLink.setStartConn(startConn);
            mLink.bindDirection();

            module.helper_pane.getChildren().add(0, mLink);

            mLink.setVisible(false);

            Point2D p = module.localToParent(new Point2D(startConn.getLayoutX() + (startConn.getWidth() / 2.0),
                    startConn.getLayoutY() + (startConn.getHeight() / 2.0)));
            mLink.setStart(new Point2D(p.getX(), p.getY()));

            ClipboardContent content = new ClipboardContent();
            DragDropContainer container = new DragDropContainer();

            container.addData("source", new String[]{module.getId(), startConn.getId()});

            content.put(DragDropContainer.AddLink, container);

            module.startDragAndDrop(TransferMode.ANY).setContent(content);

            event.consume();
        };

        EventHandler<DragEvent> mLinkHandleDragDropped = event -> {
            module.getParent().setOnDragOver(null);
            module.getParent().setOnDragDropped(null);
            DragDropContainer container =
                    (DragDropContainer) event.getDragboard().getContent(DragDropContainer.AddLink);
            if (container == null)
                return;
            ClipboardContent content = new ClipboardContent();
            ModuleConnector source = (ModuleConnector) event.getSource();
            container.addData("target", new String[]{module.getId(), source.getId()});
            content.put(DragDropContainer.AddLink, container);
            event.getDragboard().setContent(content);
            event.setDropCompleted(true);

            mLink.setVisible(false);
            module.helper_pane.getChildren().remove(0);
            event.consume();
        };

        module.connectorMap.forEach((side, mcs) -> mcs.forEach(mc -> {
            mc.setOnDragDetected(mLinkHandleDragDetected);
            mc.setOnDragDropped(mLinkHandleDragDropped);
        }));


        module.parentProperty().addListener((observable, oldValue, newValue) -> {
            if (module.getParent() instanceof AnchorPane)
                module.helper_pane = (AnchorPane) module.getParent();
        });
    }

    public static class Point2DSerial extends Point2D implements Serializable {

        public Point2DSerial(double x, double y) {
            super(x, y);
        }
    }
}