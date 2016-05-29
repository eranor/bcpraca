package com.akos.modules.RollModule;

import com.akos.modules.*;
import javafx.geometry.Side;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class RollFunctionModule extends AbstractFunctionModule {

    public RollFunctionModule() {
        super();
        CFXMLLoader.load("com/akos/fxml/modules/RollModule.fxml", this);
        setBackgroundType(BackgroundType.GREEN);

        connectorMap.addConnector(ModuleConnector.ConnectorType.IN, Side.TOP);
        connectorMap.addConnector(ModuleConnector.ConnectorType.OUT, Side.BOTTOM);

        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);
    }

}
