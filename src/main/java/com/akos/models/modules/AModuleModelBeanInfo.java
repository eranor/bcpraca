package com.akos.models.modules;


import com.akos.App;

import java.beans.*;
import java.util.*;


/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public abstract class AModuleModelBeanInfo extends SimpleBeanInfo {


    protected List<PropertyDescriptor> propDescriptors = new ArrayList<>();

    @Override
    public int getDefaultPropertyIndex() {
        return 0;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            final PropertyDescriptor name = new PropertyDescriptor("name", RollModuleModel.class, "getName", "setName");
            name.setDisplayName(App.localization.getString("module.property.name"));
            final PropertyDescriptor type = new PropertyDescriptor("type", RollModuleModel.class, "getType", "setType");
            type.setDisplayName(App.localization.getString("module.property.type"));

            propDescriptors.addAll(Arrays.asList(name, type));

        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return propDescriptors.toArray(new PropertyDescriptor[propDescriptors.size()]);
    }
}
