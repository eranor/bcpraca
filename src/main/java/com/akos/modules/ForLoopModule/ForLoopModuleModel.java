package com.akos.modules.ForLoopModule;

import com.akos.models.*;

import java.util.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ForLoopModuleModel extends AModuleModel {

    private LoopVariable variable = LoopVariable.T;
    private int startValue = 0;
    private int endValue = 10;
    private int stepValue = 1;

    public ForLoopModuleModel() {
        super(ModuleType.ForLoopModule);
    }

    @Override
    public String[] getCompiledValue() {
        List<String> result = new ArrayList<>();
        String body = String.format("for %s=%d to %d", variable, startValue, endValue);
        if (stepValue > 1) {
            body += String.format(" step %d", stepValue);
        }
        result.add(body);
        result.add(String.format("next %s", variable));
        return (String[]) result.toArray();
    }

    public LoopVariable getVariable() {
        return variable;
    }

    public void setVariable(LoopVariable variable) {
        this.variable = variable;
    }

    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
    }

    public int getEndValue() {
        return endValue;
    }

    public void setEndValue(int endValue) {
        this.endValue = endValue;
    }

    public int getStepValue() {
        return stepValue;
    }

    public void setStepValue(int stepValue) {
        this.stepValue = stepValue;
    }
}
