package com.akos.modules.PrintModule;

import com.akos.models.AModuleModel;
import com.akos.modules.Type;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class PrintModuleModel extends AModuleModel {


    public PrintModuleModel(Type type) {
        super(type);
    }

    @Override
    public String[] getCompiledValue() {
        return new String[0];
    }
}
