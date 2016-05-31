package com.akos.modules.specific;

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

        connectorMap.addConnector(ModuleConnector.ConnectorType.IN, Side.TOP, 0);

        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);
    }

}
