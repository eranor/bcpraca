package com.akos.modules;

import javafx.beans.property.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public abstract class AVariableModuleModel extends AModuleModel {

    public enum VariableMode {
        READ, WRITE
    }

    transient ObjectProperty<VariableMode> variableMode = new SimpleObjectProperty<>(this, "variableMode", VariableMode.READ);


    public AVariableModuleModel(Type type) {
        super(type);
    }

    public VariableMode getVariableMode() {
        return variableMode.get();
    }

    public ObjectProperty<VariableMode> variableModeProperty() {
        return variableMode;
    }

    public void setVariableMode(VariableMode variableMode) {
        this.variableMode.set(variableMode);
    }
}
