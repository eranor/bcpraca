package com.akos.models.modules;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class StartModuleModel extends AModuleModel {

    public enum StartSetting {
        LOOP, SEQUENCE
    }

    private StartSetting setting = StartSetting.SEQUENCE;

    public StartModuleModel() {
        super(ModuleType.StartModule);

    }

    public StartModuleModel(ModuleType type, String name) {
        super(type, name);
    }

    @Override
    public String[] getCompiledValue() {
        switch (setting) {
            case SEQUENCE:
                return new String[]{"print \"StartSequence\""};
            case LOOP:
                return new String[]{"print \"StartLoop\""};
        }
        return null;
    }

    public StartSetting getSetting() {
        return setting;
    }

    public void setSetting(StartSetting setting) {
        this.setting = setting;
    }
}
