package com.akos.gui.dialogs;

import com.akos.gui.jfx_components.NewProgramDialogPane;
import com.akos.models.services.Program;
import javafx.scene.control.*;
import javafx.stage.*;

/**
 * Created by Ákos on 2015. 12. 09.
 * Email: akoshervay@gmail.com
 */


public class NewProgramDialog extends Dialog<Program> {

    public NewProgramDialog(DialogPane dialogPane) {
        this.setDialogPane(dialogPane);
        this.setTitle("New program");
        this.initModality(Modality.APPLICATION_MODAL);
        this.initStyle(StageStyle.DECORATED);
        this.setResultConverter(param -> {
            if (param == NewProgramDialogPane.buttonTypeOk) {
                return new Program(((NewProgramDialogPane) getDialogPane()).nameField.getText());
            }
            return null;
        });
    }
}
