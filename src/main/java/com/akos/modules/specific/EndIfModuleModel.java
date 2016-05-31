package com.akos.modules.specific;

import com.akos.modules.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class EndIfModuleModel extends AModuleModel {


    public EndIfModuleModel() {
        super(ModuleType.EndIfModule);
    }

    @Override
    public String[] getCompiledValue() {
        return new String[]{""};
    }
}
