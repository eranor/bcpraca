package com.akos.models.modules;

import com.akos.gui.modules.Type;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class EndModuleModel extends AModuleModel {


    public EndModuleModel() {
        super(ModuleType.EndModule);
    }

    @Override
    public String[] getCompiledValue() {
        return new String[]{"end"};
    }
}
