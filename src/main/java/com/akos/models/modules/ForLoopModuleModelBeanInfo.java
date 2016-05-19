package com.akos.models.modules;

import java.beans.*;
import java.util.Arrays;

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
        try {
            PropertyDescriptor variable = new PropertyDescriptor("variable", ForLoopModuleModel.class, "getVariable", "setVariable");
            variable.setDisplayName("Variable");
            PropertyDescriptor startValue = new PropertyDescriptor("startValue", ForLoopModuleModel.class, "getStartValue", "setStartValue");
            startValue.setDisplayName("Start Value");
            PropertyDescriptor endValue = new PropertyDescriptor("endValue", ForLoopModuleModel.class, "getEndValue", "setEndValue");
            endValue.setDisplayName("End Value");
            PropertyDescriptor stepValue = new PropertyDescriptor("stepValue", ForLoopModuleModel.class, "getStepValue", "setStepValue");
            stepValue.setDisplayName("Step Value");
            propDescriptors.addAll(Arrays.asList(variable, startValue, endValue, stepValue));
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return propDescriptors.toArray(new PropertyDescriptor[propDescriptors.size()]);
    }
}
