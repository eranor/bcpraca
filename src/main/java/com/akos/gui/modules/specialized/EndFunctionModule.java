package com.akos.gui.modules.specialized;

import com.akos.gui.modules.*;
import javafx.geometry.Side;

import java.util.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class EndFunctionModule extends AbstractFunctionModule {


    public EndFunctionModule() {
        super();
        moduleBackgroundBlue.setVisible(true);
        moduleBackgroundBlue.setDisable(false);
        moduleBackgroundGreen.setVisible(false);
        moduleBackgroundGreen.setDisable(true);

        CFXMLLoader.load("com/akos/fxml/modules/EndModule.fxml", this);
        List<ModuleConnector> topConnectors = Collections.singletonList(new ModuleConnector(ModuleConnector.ConnectorType.IN, Side.TOP));
        connectorMap.put(Side.TOP, topConnectors);

        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);
    }

}
