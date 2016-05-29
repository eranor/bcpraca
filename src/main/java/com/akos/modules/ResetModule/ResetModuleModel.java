package com.akos.modules.ResetModule;


import com.akos.models.AModuleModel;
import com.akos.modules.Type;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ResetModuleModel extends AModuleModel {


    public ResetModuleModel(Type type) {
        super(type);
    }

    @Override
    public String[] getCompiledValue() {
        return new String[]{"reset"};
    }
}
