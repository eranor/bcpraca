package com.akos.modules.specific;

import com.akos.modules.*;
import com.akos.modules.variables.VariableModuleType;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class VariableModuleModel extends AModuleModel {

    private String value = "";

    public VariableModuleModel() {
        super(ModuleType.VariableModule);
    }

    @Override
    public String[] getCompiledValue() {
        return new String[]{value};
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
