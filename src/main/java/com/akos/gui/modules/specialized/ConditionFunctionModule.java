package com.akos.gui.modules.specialized;


import com.akos.gui.modules.*;
import javafx.geometry.Side;

import java.util.*;

/**
 * Created by Ákos on 2015. 12. 16.
 * Email: akoshervay@gmail.com
 */

public class ConditionFunctionModule extends AbstractFunctionModule {

    public ConditionFunctionModule() {
        super();
        CFXMLLoader.load("com/akos/fxml/modules/ConditionModule.fxml", this);
        List<ModuleConnector> topConnectors = Collections.singletonList(new ModuleConnector(ModuleConnector.ConnectorType.IN, Side.TOP));
        connectorMap.put(Side.TOP, topConnectors);
        List<ModuleConnector> rightConnectors = Collections.singletonList(new ModuleConnector(ModuleConnector.ConnectorType.OUT, Side.RIGHT));
        connectorMap.put(Side.RIGHT, rightConnectors);
        List<ModuleConnector> bottomConnectors = Collections.singletonList(new ModuleConnector(ModuleConnector.ConnectorType.OUT, Side.BOTTOM));
        connectorMap.put(Side.BOTTOM, bottomConnectors);
        buildConnectors();
        DragUtils.buildLinkDragHandlers(this);

        moduleBackgroundBlue.setVisible(true);
        moduleBackgroundBlue.setDisable(false);
        moduleBackgroundGreen.setVisible(false);
        moduleBackgroundGreen.setDisable(true);
    }



}
