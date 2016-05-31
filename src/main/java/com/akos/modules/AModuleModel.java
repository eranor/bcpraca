package com.akos.modules;


import com.akos.services.ModuleCounter;
import javafx.beans.property.*;

import java.io.*;

/**
 * Created by Ákos on 2015. 12. 16.
 * Email: akoshervay@gmail.com
 */
public abstract class AModuleModel implements IModuleModel, Serializable {

    private transient SimpleObjectProperty<Type> type;
    private transient StringProperty name;


    public AModuleModel(Type type) {
        this(type, String.format("%s", type.getDisplayName()));
    }

    public AModuleModel(Type type, String name) {
        this.name = new SimpleStringProperty(this, "name", name);
        this.type = new SimpleObjectProperty<>(this, "type", type);
    }

    @Override
    public Type getType() {
        return type.get();
    }

    public SimpleObjectProperty<Type> typeProperty() {
        return type;
    }

    public void setType(Type type) {
        this.type.set(type);
    }

    @Override
    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    abstract public String[] getCompiledValue();

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeChars(getName());
        s.writeObject(getType());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        name = new SimpleStringProperty(s.readUTF());
        type = new SimpleObjectProperty<>((Type) s.readObject());
    }

}
