package com.akos.models;

import com.akos.modules.variables.VariableModuleType;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class VariableModuleModel extends AVariableModuleModel {


    public VariableModuleModel() {
        super(VariableModuleType.VariableModule);
    }

    @Override
    public String[] getCompiledValue() {
        return new String[0];
    }
}
