package com.akos.modules.specific;

import com.akos.modules.*;

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
