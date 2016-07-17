package com.akos.modules.specific;


import com.akos.modules.AModuleModel;
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
