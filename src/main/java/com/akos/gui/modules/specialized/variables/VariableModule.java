package com.akos.gui.modules.specialized.variables;


import com.akos.gui.modules.*;
import javafx.fxml.*;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ákos on 2015. 12. 10.
 * Email: akoshervay@gmail.com
 */


public class VariableModule extends AbstractVariableModule {
    @FXML
    public Label typeLabel;
    @FXML
    public Label valueLabel;

    public VariableModule() {
        super();
        CFXMLLoader.load("com/akos/fxml/modules/VariableModule.fxml", this);
    }


    public enum VariableType {
        String,
        Integer,
        Double
    }
}



