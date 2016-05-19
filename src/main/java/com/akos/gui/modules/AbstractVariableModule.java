package com.akos.gui.modules;

import javafx.beans.DefaultProperty;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


@DefaultProperty("extension")
public abstract class AbstractVariableModule extends AbstractModule implements Initializable {

    @FXML
    AnchorPane view;

    @FXML
    Rectangle background;

    @FXML
    VBox extension;

    public AbstractVariableModule() {
        super();
        CFXMLLoader.load("com/akos/fxml/modules/AbstractVariable.fxml", this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DragUtils.buildNodeDragHandlers(this);
        extension.setMouseTransparent(true);

    }

    public ObservableList<Node> getExtension() {
        return extension.getChildren();
    }

}
