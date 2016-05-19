package com.akos.models.modules;

import com.akos.gui.controllers.right_panel.SliderPropertyEditor;
import com.akos.gui.modules.beans.ValidatedPropertyDescriptor;
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
        try {
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

            propDescriptors.add(new ValidatedPropertyDescriptor("heading", RollModuleModel.class, "getHeading", "setHeading", headingValidator));
            propDescriptors.get(propDescriptors.size() - 1).setDisplayName("Heading");
            PropertyDescriptor speed = new PropertyDescriptor("speedSlider", RollModuleModel.class, "getSpeedSlider", "setSpeedSlider");
            speed.setDisplayName("Speed");
            speed.setPropertyEditorClass(SliderPropertyEditor.class);
            propDescriptors.add(speed);
            propDescriptors.add(new PropertyDescriptor("mode", RollModuleModel.class, "getMode", "setMode"));
            propDescriptors.get(propDescriptors.size() - 1).setDisplayName("Motor mode");
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return propDescriptors.toArray(new PropertyDescriptor[propDescriptors.size()]);
    }
}
