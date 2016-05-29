package com.akos.modules.ConditionModule;

import com.akos.models.*;

import java.util.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ConditionModuleModel extends AModuleModel {

    private List<Relation> relations = new ArrayList<>();
    private Operator logicOperator = null;

    public ConditionModuleModel() {
        super(ModuleType.ConditionModule);
    }

    @Override
    public String[] getCompiledValue() {
        String result;
        if (logicOperator != null) {
            result = String.format("if %s %s %s then ", relations.get(0), logicOperator.name().toLowerCase(), relations.get(1));
        } else {
            result = String.format("if %s then ", relations.get(0));
        }
        return new String[]{result};
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
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
