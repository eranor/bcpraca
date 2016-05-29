package com.akos.models.modules;

import com.akos.gui.modules.Type;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class LocateModuleModel extends AModuleModel {

    private String xval, yval;

    public LocateModuleModel(Type type) {
        super(type);
    }

    @Override
    public String[] getCompiledValue() {
        return new String[]{"locate " + xval + ", " + yval};
    }

    public String getXval() {
        return xval;
    }

    public void setXval(String xval) {
        this.xval = xval;
    }

    public String getYval() {
        return yval;
    }

    public void setYval(String yval) {
        this.yval = yval;
    }
}
