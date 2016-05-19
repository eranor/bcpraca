package com.akos.gui.modules.specialized;

import com.akos.gui.modules.*;
import javafx.geometry.Side;

import java.util.*;


public class SleepFunctionModule extends AbstractFunctionModule {


    public SleepFunctionModule() {
        super();
        moduleBackgroundGreen.setVisible(true);
        moduleBackgroundGreen.setDisable(false);
        moduleBackgroundBlue.setVisible(false);
        moduleBackgroundBlue.setDisable(true);
        CFXMLLoader.load("com/akos/fxml/modules/SleepModule.fxml", this);


        List<ModuleConnector> topConnectors = Collections.singletonList(new ModuleConnector(ModuleConnector.ConnectorType.IN, Side.TOP));
        connectorMap.put(Side.TOP, topConnectors);
        List<ModuleConnector> bottomConnectors = Collections.singletonList(new ModuleConnector(ModuleConnector.ConnectorType.OUT, Side.BOTTOM));
        connectorMap.put(Side.BOTTOM, bottomConnectors);

        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);
    }
}
