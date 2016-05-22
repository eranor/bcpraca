package com.akos.models.modules;

import com.akos.gui.modules.specialized.variables.VariableModuleType;

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
