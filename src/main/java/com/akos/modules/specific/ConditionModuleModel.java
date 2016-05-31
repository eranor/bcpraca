package com.akos.modules.specific;

import com.akos.modules.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ConditionModuleModel extends AModuleModel {

    private String relation1 = "";
    private String relation2 = "";
    private Operator logicOperator = null;

    public ConditionModuleModel() {
        super(ModuleType.ConditionModule);
    }

    @Override
    public String[] getCompiledValue() {
        String result;
        if (logicOperator != null) {
            result = String.format("if %s %s %s then ",relation1 , logicOperator.name().toLowerCase(), relation2);
        } else {
            result = String.format("if %s then ", relation1);
        }
        return new String[]{result};
    }

    public String getRelation1() {
        return relation1;
    }

    public void setRelation1(String relation1) {
        this.relation1 = relation1;
    }

    public String getRelation2() {
        return relation2;
    }

    public void setRelation2(String relation2) {
        this.relation2 = relation2;
    }

    public Operator getLogicOperator() {
        return logicOperator;
    }

    public void setLogicOperator(Operator logicOperator) {
        this.logicOperator = logicOperator;
    }

    private enum Operator {
        AND, OR
    }
}
