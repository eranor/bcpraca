package com.akos.gui.modules.specialized;


import com.akos.gui.modules.*;
import javafx.geometry.Side;

import java.util.*;

/**
 * Created by Ákos on 2015. 12. 10.
 * Email: akoshervay@gmail.com
 */

public class ForLoopFunctionModule extends AbstractFunctionModule {

    public ForLoopFunctionModule() {
        super();
        CFXMLLoader.load("com/akos/fxml/modules/ForLoopModule.fxml", this);
        this.getStylesheets().add("com/akos/css/modules/ForLoopModule.css");
        List<ModuleConnector> topConnectors = Collections.singletonList(new ModuleConnector(ModuleConnector.ConnectorType.IN, Side.TOP));
        connectorMap.put(Side.TOP, topConnectors);
        List<ModuleConnector> rightConnectors = new ArrayList<>();
        rightConnectors.add(new ModuleConnector(ModuleConnector.ConnectorType.OUT, Side.RIGHT));
        rightConnectors.add(new ModuleConnector(ModuleConnector.ConnectorType.IN, Side.RIGHT));
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
