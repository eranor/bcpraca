package com.akos.models.modules;

import java.beans.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ForLoopModuleModelBeanInfo extends AModuleModelBeanInfo {

    private static final BeanDescriptor beanDescriptor = new BeanDescriptor(ForLoopModuleModelBeanInfo.class);

    static {
        beanDescriptor.setDisplayName("ForLoop Module Bean");
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
        return beanDescriptor;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        super.getPropertyDescriptors();

        return propDescriptors.toArray(new PropertyDescriptor[propDescriptors.size()]);
    }
}
