package com.akos.gui.modules;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

/**
 * Created by Ákos on 2015. 12. 11.
 * Email: akoshervay@gmail.com
 */


public class ModulePreview extends ImageView {

    ClipboardContent content;

    public ModulePreview() {
        super();
        this.setVisible(false);
        this.setOpacity(0.65);
        this.setId("preview-module");
    }

    public void show(IGraphicModule module, Point2D point) {
        this.setImage(module.getView().snapshot(null, null));
        this.setManaged(false);
        this.relocateToPoint(point);

        ClipboardContent content = new ClipboardContent();
        DragDropContainer container = new DragDropContainer();

        container.addData("type", module.getType());
        content.put(DragDropContainer.AddNode, container);

        this.startDragAndDrop(TransferMode.ANY).setContent(content);
        this.setVisible(true);
        this.setMouseTransparent(true);
    }

    public void hide() {
        this.setImage(null);
        this.setVisible(false);
    }

    public void relocateToPoint(Point2D point) {
        Point2D localCoords = getParent().sceneToLocal(point);

        relocate((int) (localCoords.getX() - (getBoundsInLocal().getWidth() / 2)),
                (int) (localCoords.getY() - (getBoundsInLocal().getHeight() / 2)));
    }

}
