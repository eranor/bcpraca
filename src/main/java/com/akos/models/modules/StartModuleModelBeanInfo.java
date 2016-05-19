package com.akos.models.modules;

import com.akos.gui.controllers.right_panel.SliderPropertyEditor;
import com.akos.gui.modules.beans.ValidatedPropertyDescriptor;
import org.controlsfx.validation.*;

import java.beans.*;
import java.util.Objects;

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
