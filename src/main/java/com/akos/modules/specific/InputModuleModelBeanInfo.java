package com.akos.modules.specific;

import com.akos.modules.AModuleModelBeanInfo;

import java.beans.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class InputModuleModelBeanInfo extends AModuleModelBeanInfo {

    private static final BeanDescriptor beanDescriptor = new BeanDescriptor(InputModuleModelBeanInfo.class);

    static {
        beanDescriptor.setDisplayName("Input Module Bean");
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
        return beanDescriptor;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        super.getPropertyDescriptors();
        createDescriptor(InputModuleModelBeanInfo.class, "variable");
        createDescriptor(InputModuleModelBeanInfo.class, "timeout");
        createDescriptor(InputModuleModelBeanInfo.class, "onfailed");
        return propDescriptors.toArray(new PropertyDescriptor[propDescriptors.size()]);
    }
}
