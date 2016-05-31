package com.akos.modules.specific;

import com.akos.modules.AModuleModelBeanInfo;

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
        createDescriptor(ConditionModuleModelBeanInfo.class, "relation1");
        createDescriptor(ConditionModuleModelBeanInfo.class, "logicOperator");
        createDescriptor(ConditionModuleModelBeanInfo.class, "relation2");
        return propDescriptors.toArray(new PropertyDescriptor[propDescriptors.size()]);
    }
}
