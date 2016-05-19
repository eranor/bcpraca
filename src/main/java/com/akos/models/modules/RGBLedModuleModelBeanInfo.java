package com.akos.models.modules;

import java.beans.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class RGBLedModuleModelBeanInfo extends AModuleModelBeanInfo {

    private static final BeanDescriptor beanDescriptor = new BeanDescriptor(RGBLedModuleModelBeanInfo.class);

    static {
        beanDescriptor.setDisplayName("Roll Module Bean");
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
        return beanDescriptor;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        super.getPropertyDescriptors();

        createDescriptor(RGBLedModuleModelBeanInfo.class, "ledType");
        createDescriptor(RGBLedModuleModelBeanInfo.class, "color");
        createDescriptor(RGBLedModuleModelBeanInfo.class, "predefColor", true);
        createDescriptor(RGBLedModuleModelBeanInfo.class, "intensity", true);

        return propDescriptors.toArray(new PropertyDescriptor[propDescriptors.size()]);
    }
}
