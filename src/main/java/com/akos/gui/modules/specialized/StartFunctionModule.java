package com.akos.gui.modules.specialized;

import com.akos.gui.modules.*;
import javafx.fxml.*;
import javafx.geometry.Side;
import javafx.scene.control.*;

import java.util.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class StartFunctionModule extends AbstractFunctionModule {

    @FXML
    ToggleGroup startModuleSetting;


    public StartFunctionModule() {
        super();
        moduleBackgroundGreen.setVisible(true);
        moduleBackgroundGreen.setDisable(false);
        moduleBackgroundBlue.setVisible(false);
        moduleBackgroundBlue.setDisable(true);

        CFXMLLoader.load("com/akos/fxml/modules/StartModule.fxml", this);
        List<ModuleConnector> bottomConnectors = Collections.singletonList(new ModuleConnector(ModuleConnector.ConnectorType.OUT, Side.BOTTOM));
        connectorMap.put(Side.BOTTOM, bottomConnectors);

        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);
    }

}
