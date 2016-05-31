package com.akos.modules.specific;

import com.akos.modules.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class InputModuleModel extends AModuleModel {

    private String variable;

    private int timeout = 0;
    private int onfailed = 0;

    public InputModuleModel() {
        super(ModuleType.InputModule);
    }

    @Override
    public String[] getCompiledValue() {
        StringBuilder sb = new StringBuilder("input");
        sb.append(" ").append(variable);
        if (timeout > 0) {
            sb.append(",").append(timeout).append(",").append(onfailed);
        }
        return new String[]{sb.toString()};
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getOnfailed() {
        return onfailed;
    }

    public void setOnfailed(int onfailed) {
        this.onfailed = onfailed;
    }
}
