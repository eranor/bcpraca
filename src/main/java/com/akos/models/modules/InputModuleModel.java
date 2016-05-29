package com.akos.models.modules;

import com.akos.gui.modules.Type;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class InputModuleModel extends AModuleModel {

    private String[] values;

    public InputModuleModel(Type type) {
        super(type);
    }

    @Override
    public String[] getCompiledValue() {
        StringBuilder sb = new StringBuilder("input");
        for (String s : values) {
            sb.append(",").append(s);
        }
        return new String[]{sb.toString()};
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
}
