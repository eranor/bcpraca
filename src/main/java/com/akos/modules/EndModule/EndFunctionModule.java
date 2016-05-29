package com.akos.modules.EndModule;

import com.akos.modules.*;
import javafx.geometry.Side;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class EndFunctionModule extends AbstractFunctionModule {


    public EndFunctionModule() {
        super();
        CFXMLLoader.load("com/akos/fxml/modules/EndModule.fxml", this);
        setBackgroundType(BackgroundType.BLUE);

        connectorMap.addConnector(ModuleConnector.ConnectorType.IN, Side.TOP);

        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);
    }

}
