package com.akos.modules.specific;

import com.akos.modules.AModuleModelBeanInfo;

import java.beans.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class LocateModuleModelBeanInfo extends AModuleModelBeanInfo {

    private static final BeanDescriptor beanDescriptor = new BeanDescriptor(LocateModuleModelBeanInfo.class);

    static {
        beanDescriptor.setDisplayName("Locate Module Bean");
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
        return beanDescriptor;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        super.getPropertyDescriptors();
        createDescriptor(LocateModuleModelBeanInfo.class, "xval");
        createDescriptor(LocateModuleModelBeanInfo.class, "yval");
        return propDescriptors.toArray(new PropertyDescriptor[propDescriptors.size()]);
    }
}
