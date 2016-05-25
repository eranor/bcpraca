package com.akos.gui.controllers.right_panel;

import com.akos.gui.controllers.AbstractController;
import com.akos.gui.modules.AbstractFunctionModule;
import com.akos.gui.modules.beans.ValidatedPropertyDescriptor;
import com.akos.models.services.MainService;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.BeanProperty;
import org.controlsfx.property.editor.*;
import org.controlsfx.validation.ValidationSupport;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ákos on 2015. 12. 21.
 * Email: akoshervay@gmail.com
 */

public class ModulePropertiesPaneController extends AbstractController implements Initializable {

    public TitledPane modulePropertiesPaneView;
    public PropertySheet modulePropertySheet;

    ValidationSupport support = new ValidationSupport();

    public ModulePropertiesPaneController(MainService mainService) {
        super(mainService);

        mainService.getSelectionModel().selectedNodeProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue instanceof AbstractFunctionModule)
                        if (newValue != null) {
                            ((AbstractFunctionModule) newValue).updatePropertySheet(modulePropertySheet);
                            modulePropertiesPaneView.setExpanded(true);
                        } else {
                            ((AbstractFunctionModule) oldValue).labelModuleName.textProperty();
                            modulePropertySheet.getItems().clear();
                            modulePropertiesPaneView.setExpanded(false);
                        }
                }
        );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final ValidationSupport support1 = support;
        modulePropertySheet.setPropertyEditorFactory(new DefaultPropertyEditorFactory() {
            private final ValidationSupport support = support1;

            @Override
            public PropertyEditor<?> call(PropertySheet.Item item) {
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
        });
    }
}
