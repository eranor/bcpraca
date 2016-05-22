package com.akos.gui.controllers.right_panel;

import org.controlsfx.property.BeanProperty;

import java.beans.PropertyDescriptor;

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
