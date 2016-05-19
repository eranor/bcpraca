package com.akos.gui.modules;

import com.akos.models.modules.*;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.AnchorPane;


public abstract class AbstractModule extends AnchorPane implements IGraphicModule, Draggable {

    protected IModuleModel model;
    private Point2D dragOffset;

    protected EventHandler<DragEvent> mCtxDragOver;
    protected EventHandler<DragEvent> mCtxDragDropped;

    public AbstractModule() {
    }

    public void activate() {
        for (Node n : getChildren()) {
            n.setDisable(false);
            n.setMouseTransparent(false);
        }
    }

    public void deactivate() {
        for (Node n : getChildren()) {
            n.setDisable(true);
            n.setMouseTransparent(true);
        }
    }

    public IModuleModel getModel() {
        return model;
    }

    public void setModel(IModuleModel model) {
        this.model = model;
    }

    public void setModule(AModuleModel module) {
        this.model = module;
    }

    @Override
    public Type getType() {
        return model.getType();
    }

    @Override
    public Node getView() {
        return this;
    }

    @Override
    public Point2D getDragOffset() {
        return dragOffset;
    }

    @Override
    public void setDragOffset(Point2D newOffset) {
        this.dragOffset = newOffset;
    }
}
