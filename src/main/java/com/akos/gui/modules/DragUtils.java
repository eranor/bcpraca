package com.akos.gui.modules;

import com.akos.App;
import com.akos.models.services.SelectionModel;
import javafx.geometry.*;
import javafx.scene.input.*;

import java.util.Map;

public class DragUtils {

    public static void buildNodeDragHandlers(AbstractModule module) {
        module.setDragOffset(new Point2D(0.0, 0.0));

        module.setOnDragDetected(event -> {
            if (!event.isPrimaryButtonDown())
                return;
            module.getParent().setOnDragOver(null);
            module.getParent().setOnDragDropped(null);

            module.getParent().setOnDragOver(module.mCtxDragOver);
            module.getParent().setOnDragDropped(module.mCtxDragDropped);

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

            container.addData("type", module.model.getType());
            container.addData("data", module.model);
            content.put(DragDropContainer.DragNode, container);
            module.startDragAndDrop(TransferMode.ANY).setContent(content);

            event.consume();
        });


        module.mCtxDragOver = event -> {
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


        module.mCtxDragDropped = event -> {
            module.getParent().setOnDragOver(null);
            module.getParent().setOnDragDropped(null);
            module.toFront();
            event.setDropCompleted(true);
            event.consume();
        };
    }

    public static void relocateToPoint(Draggable node, Point2D point) {
        Point2D localCoords = node.getParent().sceneToLocal(point);
        node.relocate(localCoords.subtract(node.getDragOffset()));
    }


    public static void buildLinkDragHandlers(AbstractFunctionModule module) {
        ModuleLink mLink = new ModuleLink();

        module.mLinkHandleDragDetected = event -> {
            module.getParent().setOnDragOver(null);
            module.getParent().setOnDragDropped(null);
            module.getParent().setOnDragOver(module.mContextLinkDragOver);
            module.getParent().setOnDragDropped(module.mContextLinkDragDropped);

            ModuleConnector source = (ModuleConnector) event.getSource();
            Side side = module.connectorMap.entrySet().stream()
                    .filter(sl -> sl.getValue().contains(source))
                    .map(Map.Entry::getKey).findAny().orElse(null);
            mLink.setStartSide(side);
            mLink.bindDirection();

            module.helper_pane.getChildren().add(0, mLink);

            mLink.setVisible(false);

            Point2D p = module.localToParent(new Point2D(source.getLayoutX() + (source.getWidth() / 2.0),
                    source.getLayoutY() + (source.getHeight() / 2.0)));
            mLink.setStart(new Point2D(p.getX(), p.getY()));

            ClipboardContent content = new ClipboardContent();
            DragDropContainer container = new DragDropContainer();

            container.addData("source", new String[]{module.getId(), source.getId()});

            content.put(DragDropContainer.AddLink, container);

            module.startDragAndDrop(TransferMode.ANY).setContent(content);

            event.consume();
        };

        module.mLinkHandleDragDropped = event -> {
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

        module.mContextLinkDragOver = event -> {
            event.acceptTransferModes(TransferMode.ANY);
            if (!mLink.isVisible())
                mLink.setVisible(true);
            mLink.setEnd(new Point2D(event.getX(), event.getY()));
            event.consume();
        };

        module.mContextLinkDragDropped = event -> {
            module.getParent().setOnDragOver(null);
            module.getParent().setOnDragDropped(null);
            event.setDropCompleted(true);

            mLink.setVisible(false);
            module.helper_pane.getChildren().remove(0);

            event.consume();
        };

        module.connectorMap.forEach((side, mcs) -> mcs.forEach(mc -> {
            mc.setOnDragDetected(module.mLinkHandleDragDetected);
            mc.setOnDragDropped(module.mLinkHandleDragDropped);
        }));
    }

}