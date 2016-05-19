package com.akos.gui.controllers.right_panel;

import javafx.beans.value.ObservableValue;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.BeanProperty;
import org.controlsfx.property.editor.PropertyEditor;

import java.beans.PropertyDescriptor;
import java.util.Optional;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


/*
* Custom PropertySheet Item
* */
public class CustomBeanProperty extends BeanProperty {



    public CustomBeanProperty(Object bean, PropertyDescriptor propertyDescriptor) {
        super(bean, propertyDescriptor);
    }
}
