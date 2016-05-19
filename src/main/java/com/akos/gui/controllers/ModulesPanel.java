package com.akos.gui.controllers;

import com.akos.gui.modules.*;
import com.akos.gui.modules.specialized.variables.VariableModuleType;
import com.akos.models.modules.ModuleType;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ákos on 2015. 12. 06.
 * Email: akoshervay@gmail.com
 */


public class ModulesPanel extends Accordion implements Initializable {

    public ModuleFactory factory = ModuleFactory.getInstance();
    public AnchorPane view;
    public Accordion accordion;
    public ScrollPane scrollPane;
    public VBox modulesContainer;
    public VBox variablesContainer;

    public ModulesPanel() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/akos/fxml/gui/ModulesPanel.fxml"), ResourceBundle.getBundle("Localization"));
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
        for (ModuleType type : ModuleType.values()) {
            AbstractModule module = factory.getModule(type);
            if (module instanceof AbstractFunctionModule)
                ((AbstractFunctionModule) module).labelModuleName.setText(type.toString());

            module.deactivate();
            module.setMaxSize(64, 47.223);
            modulesContainer.getChildren().add(module);
            module.setScaleX(module.getScaleX() * 3 / 4);
            module.setScaleY(module.getScaleY() * 3 / 4);

        }
        for (VariableModuleType type : VariableModuleType.values()) {
            AbstractModule module = factory.getModule(type);
            variablesContainer.getChildren().add(module);
            requestParentLayout();
            module.deactivate();
            module.setScaleX(module.getScaleX() * 3 / 4);
            module.setScaleY(module.getScaleY() * 3 / 4);
        }

    }
}
