package com.akos.modules;


import com.akos.modules.Type;

/**
 * Created by Ákos on 2015. 12. 16.
 * Email: akoshervay@gmail.com
 */

public enum ModuleType implements Type {
    StartModule("Start"),
    LEDModule("Led"),
    WhileLoopModule("While"),
    ForLoopModule("For"),
    VariableModule("Variable"),
    ConditionModule("If"),
    RollModule("Roll"),
    TimerModule("Timer"),
    SleepModule("Sleep"),
    EndModule("End"),
    LocateModule("Set location"),
    PrintModule("Print"),
    InputModule("Input"),
    EndIfModule("End If");

    private final String displayName;

    ModuleType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
