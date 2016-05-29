package com.akos.modules.RGBLedModule;

import com.akos.modules.*;
import javafx.geometry.Side;


public class RGBLedFunctionModule extends AbstractFunctionModule {


    public RGBLedFunctionModule() {
        super();
        CFXMLLoader.load("com/akos/fxml/modules/RGBLedModule.fxml", this);
        setBackgroundType(BackgroundType.GREEN);

        connectorMap.addConnector(ModuleConnector.ConnectorType.IN, Side.TOP);
        connectorMap.addConnector(ModuleConnector.ConnectorType.OUT, Side.BOTTOM);

        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);
    }
}
