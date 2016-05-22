package com.akos.gui.modules;

import com.akos.models.modules.*;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.*;


public abstract class AbstractModule extends AnchorPane implements IGraphicModule, Draggable {

    private Point2D dragOffset;
    private BackgroundType backgroundType;

    protected IModuleModel model;
    protected Pane background = null;
    protected EventHandler<DragEvent> mCtxDragOver;
    protected EventHandler<DragEvent> mCtxDragDropped;

    public AbstractModule() {

    }

    public void setBackgroundType(BackgroundType type) {
        if (background != null && getChildren().contains(background))
            getChildren().remove(background);
        switch (type) {
            case GREEN:
                background = (Pane) CFXMLLoader.noController("com/akos/fxml/modules/modules2_BG_Green.fxml", this);
                break;
            case BLUE:
                background = (Pane) CFXMLLoader.noController("com/akos/fxml/modules/modules2_BG_Blue.fxml", this);
                break;
            case ORANGE:
                background = (Pane) CFXMLLoader.noController("com/akos/fxml/modules/modules2_BG_Orange.fxml", this);
                break;
        }
        getChildren().add(0, background);
        background.setMouseTransparent(true);
        background.minWidthProperty().bind(minWidthProperty());
        background.minHeightProperty().bind(minHeightProperty());
        background.maxWidthProperty().bind(maxWidthProperty());
        background.maxHeightProperty().bind(maxHeightProperty());
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

    @Override
    public void relocate(Point2D point) {
        relocate(point.getX(), point.getY());
    }
}
