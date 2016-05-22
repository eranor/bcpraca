package com.akos.gui.controllers.right_panel;

import org.controlsfx.control.PropertySheet;
import org.controlsfx.validation.Validator;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public interface ValidatedPropertyItem extends PropertySheet.Item {

    Validator<?> getValidator();

}
