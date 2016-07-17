package com.akos.modules.specific;

import com.akos.modules.*;
import javafx.geometry.Side;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class VariableFunctionModule extends AbstractFunctionModule {


    public VariableFunctionModule() {
        super();
        CFXMLLoader.load("com/akos/fxml/modules/VariableModule.fxml", this);
        setBackgroundType(BackgroundType.BLUE);

        connectorMap.addConnector(ModuleConnector.ConnectorType.IN, Side.TOP, 0);
        connectorMap.addConnector(ModuleConnector.ConnectorType.OUT, Side.BOTTOM, 1);

        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);
    }
}
