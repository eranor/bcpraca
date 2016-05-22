package com.akos.gui.controllers.right_panel;

import com.akos.gui.modules.beans.ValidatedPropertyDescriptor;
import javafx.scene.control.Control;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.control.PropertySheet.Item;
import org.controlsfx.property.BeanProperty;
import org.controlsfx.property.editor.*;
import org.controlsfx.validation.ValidationSupport;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class CustomPropertyEditorFactory extends DefaultPropertyEditorFactory {

    private final ValidationSupport support;
    private final PropertySheet sheet;

    public CustomPropertyEditorFactory(PropertySheet sheet, ValidationSupport support) {
        super();
        this.sheet = sheet;
        this.support = support;
    }

    @Override
    public PropertyEditor<?> call(Item item) {
        BeanProperty bp;

        if (item instanceof BeanProperty) {
            bp = (BeanProperty) item;
            if (bp.getValue() instanceof Integer) {
                PropertyEditor<?> editor = Editors.createNumericEditor(item);
                if (bp.getPropertyDescriptor() instanceof ValidatedPropertyDescriptor) {
                    support.registerValidator((Control) editor.getEditor(), true,
                            ((ValidatedPropertyDescriptor) bp.getPropertyDescriptor()).getValidator());
                }
                return editor;
            }

        }
        return super.call(item);
    }
}
