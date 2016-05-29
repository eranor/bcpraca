package com.akos.models.modules;


import com.akos.gui.modules.Type;

/**
 * Created by Ákos on 2015. 12. 16.
 * Email: akoshervay@gmail.com
 */

public enum ModuleType implements Type {
    StartModule("Start"),
    LEDModule("Led"),
    //WhileLoopModule("While"),
    ForLoopModule("For"),
    //ContainerModule,
    ConditionModule("If"),
    RollModule("Roll"),
    TimerModule("Timer"),
    SleepModule("Sleep"),
    EndModule("End"),
    //LocateModule("Set location"),
    //ResetModule("Reset Program"),
    //InputModule("Input");
    ;
    private final String displayName;

    ModuleType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
