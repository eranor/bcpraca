package com.akos.modules.EndModule;

import com.akos.models.*;

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
