package com.akos.models.services;

import com.akos.gui.modules.Type;
import com.akos.models.modules.ModuleType;

import java.util.HashMap;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ModuleCounter {

    private static final HashMap<Type, Integer> moduleCountMap = new HashMap<>();

    public static int getNext(Type moduleType) {
        if (!moduleCountMap.containsKey(moduleType)) {
            moduleCountMap.put(moduleType, 1);
            return 1;
        } else {
            moduleCountMap.put(moduleType, moduleCountMap.get(moduleType) + 1);
            return moduleCountMap.get(moduleType);
        }
    }


}
