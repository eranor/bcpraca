package com.akos.modules.StartModule;

import com.akos.modules.*;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.ToggleGroup;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class StartFunctionModule extends AbstractFunctionModule {

    @FXML
    ToggleGroup startModuleSetting;


    public StartFunctionModule() {
        super();
        CFXMLLoader.load("com/akos/fxml/modules/StartModule.fxml", this);
        setBackgroundType(BackgroundType.BLUE);

        connectorMap.addConnector(ModuleConnector.ConnectorType.OUT, Side.BOTTOM);

        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);
    }

}
