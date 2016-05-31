package com.akos.modules.specific;

import com.akos.modules.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class PrintModuleModel extends AModuleModel {

    private String value = "";

    public PrintModuleModel() {
        super(ModuleType.PrintModule);
    }

    @Override
    public String[] getCompiledValue() {
        return new String[]{"? " + value};
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
