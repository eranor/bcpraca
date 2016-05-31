package com.akos.modules.specific;

import com.akos.gui.controllers.right_panel.SliderPropertyEditor;
import com.akos.modules.AModuleModelBeanInfo;
import org.controlsfx.validation.*;

import java.beans.*;
import java.util.Objects;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class RollModuleModelBeanInfo extends AModuleModelBeanInfo {

    private static final BeanDescriptor beanDescriptor = new BeanDescriptor(RollModuleModelBeanInfo.class);

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

        Validator<String> headingValidator = (c, value) -> {
            boolean isNull = !Objects.equals(value, "") ? value.equals("") : Objects.equals(value, "");
            boolean inRange = !(Objects.equals(value, "") || value.matches("\\s+")) ? Integer.valueOf(value) > -1 && Integer.valueOf(value) <= 359 :
                    value == "";
            try {
                if (isNull)
                    return ValidationResult.fromError(c, "Value must be set!");
                else if (!inRange) {
                    return ValidationResult.fromError(c, "Value must be between 0 and 359!");
                }
                return null;
            } catch (NumberFormatException e) {
                return ValidationResult.fromError(c, "Value must be between 0 and 359!");
            }
        };

        createDescriptor(RollModuleModelBeanInfo.class, "heading");
        createDescriptor(RollModuleModelBeanInfo.class, "speedSlider", true, SliderPropertyEditor.class);
        createDescriptor(RollModuleModelBeanInfo.class, "mode");

        return propDescriptors.toArray(new PropertyDescriptor[propDescriptors.size()]);
    }
}
