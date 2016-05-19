package com.akos.models.modules;

import java.beans.*;
import java.util.Arrays;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class RGBLedModuleModelBeanInfo extends AModuleModelBeanInfo {

    private static final BeanDescriptor beanDescriptor = new BeanDescriptor(RGBLedModuleModelBeanInfo.class);

    static {
        beanDescriptor.setDisplayName("Roll Module Bean");
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
        return beanDescriptor;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        super.getPropertyDescriptors();
        try {
            PropertyDescriptor ledType = new PropertyDescriptor("ledType", RGBLedModuleModel.class, "getLedType", "setLedType");
            ledType.setDisplayName("Led Type");

            PropertyDescriptor color = new PropertyDescriptor("color", RGBLedModuleModel.class, "getColor", "setColor");
            color.setDisplayName("Led Color");

            PropertyDescriptor predefColor = new PropertyDescriptor("predefColor", RGBLedModuleModel.class, "getPredefColor", "setPredefColor");
            predefColor.setDisplayName("Led Color");
            predefColor.setHidden(true);

            PropertyDescriptor intensity = new PropertyDescriptor("intensity", RGBLedModuleModel.class, "getIntensity", "setIntensity");
            intensity.setDisplayName("Intensity");
            intensity.setHidden(true);

            propDescriptors.addAll(Arrays.asList(ledType, color, predefColor, intensity));

        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return propDescriptors.toArray(new PropertyDescriptor[propDescriptors.size()]);
    }
}
