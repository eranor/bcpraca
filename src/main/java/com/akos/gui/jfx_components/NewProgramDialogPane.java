package com.akos.gui.jfx_components;


import com.akos.models.services.MainService;
import com.pixelduke.javafx.validation.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import org.controlsfx.validation.*;
import org.controlsfx.validation.decoration.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ákos on 2015. 12. 09.
 * Email: akoshervay@gmail.com
 */


public class NewProgramDialogPane extends DialogPane implements Initializable {
    public static final ButtonType buttonTypeOk = new ButtonType("Create", ButtonBar.ButtonData.OK_DONE);
    public static final ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);


    public TextField nameField;
    public TextField data1Field;
    public TextField data2Field;
    public RegexValidator requiredField1;
    public RequiredField requiredField2;
    public RequiredField requiredField3;
    public ErrorLabel duplicateProjectErrorLabel;


    private ValidationSupport validationSupport = new ValidationSupport();
    private MainService mainService;

    public NewProgramDialogPane(MainService mainService) {
        this.mainService = mainService;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/akos/fxml/gui/NewProgramDialog.fxml"), ResourceBundle.getBundle("Localization"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.lookupButton(buttonTypeOk).addEventFilter(ActionEvent.ACTION, event -> {
            if (validationSupport.isInvalid()) {
                event.consume();
            }
        });

        Validator<String> validateText = (control, value) -> {
            boolean invChar = value != null ? !value.matches("^([a-zA-Z0-9_-]*)$") : value == null;
            boolean checkLength = value != null ? !(value.length() > 2 && value.length() < 40) : value == null;
            boolean nameExists = mainService.getPrograms().stream().anyMatch(program -> program != null && program.getName().equals(value));
            if (invChar)
                return ValidationResult.fromMessageIf(control, "Invalid Character in name!", Severity.ERROR, invChar);
            else if (checkLength) {
                return ValidationResult.fromMessageIf(control, "The length must be between 2 and 40!", Severity.ERROR, checkLength);
            } else if (nameExists) {
                return ValidationResult.fromErrorIf(control, "Project with name already exists!", nameExists);
            }
            return null;
        };


        validationSupport.registerValidator(nameField, true, validateText);

        ValidationDecoration decorator = new GraphicValidationDecoration();
        validationSupport.setValidationDecorator(decorator);
    }

    public void setMainService(MainService mainService) {
        this.mainService = mainService;
    }
}
