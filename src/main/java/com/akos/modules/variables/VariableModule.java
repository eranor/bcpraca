package com.akos.modules.variables;


import com.akos.modules.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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

    @Override
    public void removeLink(String id) {

    }

    @Override
    public void removeLinks() {

    }


    public enum VariableType {
        String,
        Integer,
        Double
    }
}



