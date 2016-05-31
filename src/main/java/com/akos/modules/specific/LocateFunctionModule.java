package com.akos.modules.specific;

import com.akos.modules.*;
import javafx.geometry.Side;


public class LocateFunctionModule extends AbstractFunctionModule {


    public LocateFunctionModule() {
        super();
        CFXMLLoader.load("com/akos/fxml/modules/LocationModule.fxml", this);
        setBackgroundType(BackgroundType.GREEN);

        connectorMap.addConnector(ModuleConnector.ConnectorType.IN, Side.TOP, 0);
        connectorMap.addConnector(ModuleConnector.ConnectorType.OUT, Side.BOTTOM, 1);

        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);
    }
}
