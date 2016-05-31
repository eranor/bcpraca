package com.akos.modules.specific;

import com.akos.modules.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class WhileLoopModuleModel extends AModuleModel {

    private String relation = "";

    public WhileLoopModuleModel() {
        super(ModuleType.WhileLoopModule);
    }

    @Override
    public String[] getCompiledValue() {
        return new String[]{"if " + relation + " then"};
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
