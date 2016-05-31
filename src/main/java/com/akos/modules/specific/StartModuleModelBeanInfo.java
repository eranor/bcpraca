package com.akos.modules.specific;

import com.akos.modules.AModuleModelBeanInfo;

import java.beans.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class StartModuleModelBeanInfo extends AModuleModelBeanInfo {

    private static final BeanDescriptor beanDescriptor = new BeanDescriptor(StartModuleModelBeanInfo.class);

    static {
        beanDescriptor.setDisplayName("Start Module Bean");
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
        return beanDescriptor;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        super.getPropertyDescriptors();
        try {
            propDescriptors.add(new PropertyDescriptor("setting", StartModuleModel.class, "getSetting", "setSetting"));
            propDescriptors.get(propDescriptors.size() - 1).setDisplayName("Program setting");

        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return propDescriptors.toArray(new PropertyDescriptor[propDescriptors.size()]);
    }
}
