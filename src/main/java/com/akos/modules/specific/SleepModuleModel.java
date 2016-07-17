package com.akos.modules.specific;

import com.akos.modules.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class SleepModuleModel extends AModuleModel {

    private int duration;

    public SleepModuleModel() {
        super(ModuleType.SleepModule);
    }

    @Override
    public String[] getCompiledValue() {
        return new String[]{String.format("delay %d", duration)};
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
