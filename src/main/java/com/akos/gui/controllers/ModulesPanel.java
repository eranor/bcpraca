package com.akos.gui.controllers;

import com.akos.modules.*;
import com.akos.modules.ModuleType;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

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
            module.labelModuleName.setText(type.getDisplayName());
            module.labelModuleName.setFont(new Font(module.labelFont.getName(), 26));
            module.deactivate();
            modulesContainer.getChildren().add(module);
            VBox.setMargin(module, new Insets(-20, -30, -10, -30));
            module.setScaleX(module.getScaleX() * 2 / 3);
            module.setScaleY(module.getScaleY() * 2 / 3);

        }

    }
}
