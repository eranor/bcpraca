package com.akos.models.modules;


import com.akos.gui.modules.Type;

/**
 * Created by Ákos on 2015. 12. 16.
 * Email: akoshervay@gmail.com
 */
public interface IModuleModel {

    Type getType();

    void setType(Type type);

    String getName();

    void setName(String name);

    String[] getCompiledValue();

}
