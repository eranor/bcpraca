package com.akos.gui.controllers;

import com.akos.gui.dialogs.NewProgramDialog;
import com.akos.gui.jfx_components.NewProgramDialogPane;
import com.akos.gui.modules.CFXMLLoader;
import com.akos.models.services.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by Ákos on 2015. 12. 06.
 * Email: akoshervay@gmail.com
 */

public class MenuController extends AbstractController implements Initializable {
    public MenuItem newProjectMenuItem;
    public MenuItem saveProjectMenuItem;
    public MenuItem saveAsProjectMenuItem;
    public MenuItem loadProjectMenuItem;
    public MenuItem closeProjectMenuItem;
    public MenuItem exitProgramMenuItem;
    public MenuItem undoStepMenuItem;
    public MenuItem redoStepMenuItem;
    public MenuItem deleteMenuItem;
    public MenuItem aboutMenuItem;
    public MenuItem documentationMenuItem;
    public MenuItem helpMenuItem;
    public MenuBar menuView;

    Stage connectionStage = null;
    Stage spheroLogStage = null;
    Stage fileLogStage = null;
    private Stage orbbasicStage = null;

    public MenuController(MainService mainService) {
        super(mainService);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        disableMenuElements();
        mainService.currentProgramProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                enableMenuElements();
            } else {
                disableMenuElements();
            }
        });
    }

    private void disableMenuElements() {
        saveProjectMenuItem.setDisable(true);
        saveAsProjectMenuItem.setDisable(true);
        closeProjectMenuItem.setDisable(true);
    }

    private void enableMenuElements() {
        saveProjectMenuItem.setDisable(false);
        saveAsProjectMenuItem.setDisable(false);
        closeProjectMenuItem.setDisable(false);
    }

    public void onNewProjectAction(ActionEvent actionEvent) {
        NewProgramDialog dialog = new NewProgramDialog(new NewProgramDialogPane(mainService));
        Optional<Program> result = dialog.showAndWait();
        if (result.isPresent()) {
            if (mainService.updatePrograms(result.get())) {
                mainService.setCurrentProgram(result.get());
            }
        }
    }

    public void onSaveProjectAction(ActionEvent actionEvent) {
        Alert closeProgramDialog = new Alert(Alert.AlertType.CONFIRMATION);
        closeProgramDialog.showAndWait();
    }

    public void onSaveAsProjectAction(ActionEvent actionEvent) {
        Alert closeProgramDialog = new Alert(Alert.AlertType.CONFIRMATION);
        closeProgramDialog.showAndWait();
    }

    public void onLoadProjectAction(ActionEvent actionEvent) {
        Alert closeProgramDialog = new Alert(Alert.AlertType.CONFIRMATION);
        closeProgramDialog.showAndWait();
    }

    public void onCloseProjectAction(ActionEvent actionEvent) {
        Alert closeProgramDialog = new Alert(Alert.AlertType.CONFIRMATION);
        closeProgramDialog.showAndWait();
    }

    public void onExitProgramAction(ActionEvent actionEvent) {
        Alert closeProgramDialog = new Alert(Alert.AlertType.CONFIRMATION);
        closeProgramDialog.setContentText("Do you really want to exit the program?");
        Optional<ButtonType> result = closeProgramDialog.showAndWait();
        if (result.get() == ButtonType.OK) {
            ((Stage) menuView.getScene().getWindow()).close();
        }


    }

    public void fileLogMenuButtonClick(ActionEvent actionEvent) {
        if (fileLogStage == null) {
            fileLogStage = new Stage();
            fileLogStage.setTitle("Window title");
            fileLogStage.setScene(new Scene(new Group(), 260, 230, Color.LIGHTCYAN));
            fileLogStage.show();
        } else {
            fileLogStage.toFront();
        }
    }

    public void spheroConnectionScreenMenuButtonClick(ActionEvent actionEvent) throws IOException {
        if (connectionStage == null) {
            connectionStage = new Stage();
            connectionStage.setTitle("Sphero Connection Screen");
            connectionStage.setScene(new Scene(CFXMLLoader.loadWithCallback("com/akos/fxml/gui/ConnectionScreen.fxml", this)));
            connectionStage.show();
        } else {
            connectionStage.toFront();
        }
    }


    public void spheroOrbbasicWindowClick(ActionEvent actionEvent) {
        if (orbbasicStage == null) {
            orbbasicStage = new Stage();
            orbbasicStage.setTitle("Sphero Connection Screen");
            orbbasicStage.setScene(new Scene(CFXMLLoader.loadWithCallback("com/akos/fxml/gui/OrbbasicScreen.fxml", this)));
            orbbasicStage.show();
        } else {
            orbbasicStage.toFront();
        }
    }
}
