package com.akos.modules.specific;


import com.akos.modules.*;
import javafx.geometry.Side;

/**
 * Created by Ákos on 2015. 12. 10.
 * Email: akoshervay@gmail.com
 */

public class WhileLoopFunctionModule extends AbstractFunctionModule {

    public WhileLoopFunctionModule() {
        super();
        CFXMLLoader.load("com/akos/fxml/modules/WhileLoopModule.fxml", this);
        setBackgroundType(BackgroundType.BLUE);

        connectorMap.addConnector(ModuleConnector.ConnectorType.IN, Side.TOP, 0);
        connectorMap.addConnector(ModuleConnector.ConnectorType.OUT, Side.RIGHT, 1);
        connectorMap.addConnector(ModuleConnector.ConnectorType.IN, Side.RIGHT, 0);
        connectorMap.addConnector(ModuleConnector.ConnectorType.OUT, Side.BOTTOM, 2);

        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);


    }


}
