package com.akos.modules.TimerModule;

import com.akos.modules.*;
import javafx.geometry.Side;


public class TimerFunctionModule extends AbstractFunctionModule {


    public TimerFunctionModule() {
        super();
        CFXMLLoader.load("com/akos/fxml/modules/TimerModule.fxml", this);
        setBackgroundType(BackgroundType.GREEN);

        connectorMap.addConnector(ModuleConnector.ConnectorType.IN, Side.TOP);
        connectorMap.addConnector(ModuleConnector.ConnectorType.OUT, Side.BOTTOM);

        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);
    }
}
