package com.akos.models.modules;

import com.akos.gui.controllers.right_panel.SliderPropertyEditor;
import com.akos.gui.modules.beans.ValidatedPropertyDescriptor;
import org.controlsfx.validation.*;

import java.beans.*;
import java.util.Objects;

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
