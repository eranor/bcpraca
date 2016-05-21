package com.akos.gui.modules;

import com.akos.models.modules.IModuleModel;
import javafx.fxml.Initializable;
import javafx.scene.Node;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public interface IGraphicModule extends Initializable {

    Type getType();

    IModuleModel getModel();

    void setModel(IModuleModel module);

    Node getView();

    void removeLink(String id);

    void removeLinks();


}
