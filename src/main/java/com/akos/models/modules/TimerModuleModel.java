package com.akos.models.modules;

import com.akos.gui.modules.specialized.variables.VariableModuleType;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class TimerModuleModel extends AModuleModel {

    public enum TimerType {
        A, B, C
    }

    private TimerType timerType;
    private int value;

    public TimerModuleModel() {
        super(ModuleType.TimerModule);
    }

    @Override
    public String[] getCompiledValue() {
        return new String[0];
    }

    public TimerType getTimerType() {
        return timerType;
    }

    public void setTimerType(TimerType timerType) {
        this.timerType = timerType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
