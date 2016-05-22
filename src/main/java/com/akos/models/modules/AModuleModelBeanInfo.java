package com.akos.models.modules;


import com.akos.App;
import org.apache.commons.lang3.text.WordUtils;

import java.beans.*;
import java.lang.reflect.*;
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
        createDescriptor(AModuleModelBeanInfo.class, "name");
        createDescriptor(AModuleModelBeanInfo.class, "type");
        return propDescriptors.toArray(new PropertyDescriptor[propDescriptors.size()]);
    }

    public void createDescriptor(Class<?> cls, String name) {
        createDescriptor(cls, name, false);
    }

    public void createDescriptor(Class<?> cls, String name, boolean hidden) {
        createDescriptor(cls, name, hidden, null);
    }

    public void createDescriptor(Class<?> cls, String name, boolean hidden, Class<?> editorClass) {
        createDescriptor(cls, name, hidden, editorClass, null, null);
    }

    public void createDescriptor(Class<?> cls, String name, boolean hidden, Class<?> propertyDescriptorClass, Object arg) {
        createDescriptor(cls, name, hidden, null, propertyDescriptorClass, arg);
    }

    public void createDescriptor(Class<?> cls, String name, boolean hidden, Class<?> editorClass, Class<?> propertyDescriptorClass, Object arg) {
        Constructor<?> constructor = null;
        try {
            if (propertyDescriptorClass != null) {
                constructor = propertyDescriptorClass.getConstructor();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            Class<?> clazz = getPropDescClass(cls);
            String moduleName = cls.getSimpleName().replace("ModuleModelBeanInfo", "").toLowerCase();
            final String propName = WordUtils.capitalize(name);
            PropertyDescriptor desc = constructor != null ?
                    (PropertyDescriptor) constructor.newInstance(name, clazz, "get" + propName, "set" + propName, arg) :
                    new PropertyDescriptor(name, clazz, "get" + propName, "set" + propName);

            displayNameSetter(name, moduleName, desc);
            desc.setHidden(hidden);

            if (editorClass != null)
                desc.setPropertyEditorClass(editorClass);

            propDescriptors.add(desc);

        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | IntrospectionException e) {
            e.printStackTrace();
        }
    }

    protected Class<?> getPropDescClass(Class<?> cls) {
        String className = cls.getName().replace("BeanInfo", "");
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    protected void displayNameSetter(String name, String moduleName, PropertyDescriptor desc) {
        if (moduleName.equals("a"))
            desc.setDisplayName(App.localization.getString("module.property." + name));
        else {
            desc.setDisplayName(App.localization.getString(String.format("module.property.%s.%s", moduleName, name)));
        }
    }
}
