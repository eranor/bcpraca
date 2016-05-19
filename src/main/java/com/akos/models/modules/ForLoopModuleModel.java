package com.akos.models.modules;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ForLoopModuleModel extends AModuleModel {



    public ForLoopModuleModel() {
        super(ModuleType.ForLoopModule);
    }

    @Override
    public String[] getCompiledValue() {
        return new String[0];
    }
}
