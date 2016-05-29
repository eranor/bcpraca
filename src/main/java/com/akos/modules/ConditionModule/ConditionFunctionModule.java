package com.akos.modules.ConditionModule;


import com.akos.modules.*;
import javafx.geometry.Side;

/**
 * Created by Ákos on 2015. 12. 16.
 * Email: akoshervay@gmail.com
 */

public class ConditionFunctionModule extends AbstractFunctionModule {

    public ConditionFunctionModule() {
        super();
        CFXMLLoader.load("com/akos/fxml/modules/ConditionModule.fxml", this);
        setBackgroundType(BackgroundType.BLUE);
        connectorMap.addConnector(ModuleConnector.ConnectorType.IN, Side.TOP);
        connectorMap.addConnector(ModuleConnector.ConnectorType.IN, Side.TOP);
        connectorMap.addConnector(ModuleConnector.ConnectorType.TRUE, Side.BOTTOM);
        connectorMap.addConnector(ModuleConnector.ConnectorType.FALSE, Side.BOTTOM);

        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);
    }


}
