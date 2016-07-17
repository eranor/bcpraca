package com.akos.modules.specific;

import com.akos.modules.AModuleModelBeanInfo;

import java.beans.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class PrintModuleModelBeanInfo extends AModuleModelBeanInfo {

    private static final BeanDescriptor beanDescriptor = new BeanDescriptor(PrintModuleModelBeanInfo.class);

    static {
        beanDescriptor.setDisplayName("Print Module Bean");
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
        return beanDescriptor;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        super.getPropertyDescriptors();
        createDescriptor(PrintModuleModelBeanInfo.class, "value");
        return propDescriptors.toArray(new PropertyDescriptor[propDescriptors.size()]);
    }
}
