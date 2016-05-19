package com.akos.models.modules;


import com.akos.gui.modules.Type;

/**
 * Created by Ákos on 2015. 12. 16.
 * Email: akoshervay@gmail.com
 */
public enum ModuleType implements Type {
    StartModule,
    BackLEDModule,
    //WhileLoopModule,
    ForLoopModule,
    //ContainerModule,
    ConditionModule,
    RollModule, TimerModule, SleepModule, EndModule;

    @Override
    public String getName() {
        return "ModuleType";
    }
}
