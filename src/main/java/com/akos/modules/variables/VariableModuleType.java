package com.akos.modules.variables;

import com.akos.modules.Type;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public enum VariableModuleType implements Type {
    VariableModule;

    @Override
    public String getDisplayName() {
        return "VariableModuleType";
    }
}
