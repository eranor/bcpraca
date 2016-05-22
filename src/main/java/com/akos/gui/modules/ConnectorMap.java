package com.akos.gui.modules;

import javafx.geometry.Side;

import java.util.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ConnectorMap extends HashMap<Side, List<ModuleConnector>> {


    public void addConnector(ModuleConnector.ConnectorType type, Side side) {
        if (!containsKey(side))
            put(side, new ArrayList<>());
        get(side).add(new ModuleConnector(type, side));
    }

}
