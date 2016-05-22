package com.akos.gui.modules.specialized;

import com.akos.gui.modules.*;
import javafx.geometry.Side;


public class SleepFunctionModule extends AbstractFunctionModule {


    public SleepFunctionModule() {
        super();
        CFXMLLoader.load("com/akos/fxml/modules/SleepModule.fxml", this);
        setBackgroundType(BackgroundType.GREEN);

        connectorMap.addConnector(ModuleConnector.ConnectorType.IN, Side.TOP);
        connectorMap.addConnector(ModuleConnector.ConnectorType.OUT, Side.BOTTOM);

        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);
    }
}
