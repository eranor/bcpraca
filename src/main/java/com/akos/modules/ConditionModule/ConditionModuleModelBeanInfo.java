package com.akos.modules.ConditionModule;

import com.akos.models.AModuleModelBeanInfo;

import java.beans.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ConditionModuleModelBeanInfo extends AModuleModelBeanInfo {

    private static final BeanDescriptor beanDescriptor = new BeanDescriptor(ConditionModuleModelBeanInfo.class);

    static {
        beanDescriptor.setDisplayName("Condition Model Bean");
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
