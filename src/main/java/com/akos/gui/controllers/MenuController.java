package com.akos.gui.controllers;

import com.akos.App;
import com.akos.gui.Utils;
import com.akos.modules.CFXMLLoader;
import com.akos.services.*;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.*;
import org.apache.logging.log4j.*;
import org.controlsfx.control.NotificationPane;
import org.controlsfx.validation.*;
import org.controlsfx.validation.decoration.*;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * Created by Ákos on 2015. 12. 06.
 * Email: akoshervay@gmail.com
 */

public class MenuController extends AbstractController implements Initializable {

    private static final Logger logger = LogManager.getLogger(MenuController.class);

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

    private Stage connectionStage = null;
    private Stage orbbasicStage = null;
    private ValidationSupport validationSupport = new ValidationSupport();

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
        TextInputDialog dlg = new TextInputDialog("");
        dlg.setTitle("New Program");
        dlg.getDialogPane().setContentText("Set the name of the program");
        dlg.initModality(Modality.APPLICATION_MODAL);
        dlg.initOwner(menuView.getScene().getWindow());
        dlg.initStyle(StageStyle.UNIFIED);
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

        Platform.runLater(() -> validationSupport.registerValidator(dlg.getEditor(), true, validateText));
        ValidationDecoration decorator = new GraphicValidationDecoration();
        validationSupport.setValidationDecorator(decorator);

        dlg.showAndWait().ifPresent(result -> {
            Program p = new Program(result);
            if (mainService.updatePrograms(p)) {
                mainService.setCurrentProgram(p);
            }
        });

    }

    public void onSaveProjectAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter ef = new FileChooser.ExtensionFilter("ORB files (*.orb)", "*.orb");
        fileChooser.getExtensionFilters().add(ef);
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File file = fileChooser.showSaveDialog(App.primaryStage);
        Utils.doSingleTask(new Task<Void>() {
            @Override
            protected Void call() {
                FileWriter writer = null;
                try {
                    writer = new FileWriter(file);
                    writer.write("asd");
                    writer.close();
                } catch (IOException e) {
                    logger.log(Level.ERROR, e);
                }
                return null;
            }
        });
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

    public void showConnectionScreen(ActionEvent actionEvent) {
        if (connectionStage == null) {
            connectionStage = new Stage();
            connectionStage.setTitle("Sphero Connection Screen");
            connectionStage.setScene(new Scene(CFXMLLoader.loadWithCallback("com/akos/fxml/gui/ConnectionScreen.fxml", this)));
            connectionStage.show();
        } else {
            connectionStage.show();
            connectionStage.toFront();
        }
    }

    public void showOrbbasicConsole(ActionEvent actionEvent) {
        if (orbbasicStage == null) {
            orbbasicStage = new Stage();
            orbbasicStage.setTitle("Sphero OrbBasic Console");
            orbbasicStage.setScene(new Scene(CFXMLLoader.loadWithCallback("com/akos/fxml/gui/OrbbasicScreen.fxml", this)));

            orbbasicStage.setOnShown(event -> {
                NotificationPane pane = ((NotificationPane) orbbasicStage.getScene().getRoot());
                pane.show("You don't need to write line numbers, just use the one on the side.");
            });
            orbbasicStage.show();
        } else {
            orbbasicStage.show();
            orbbasicStage.toFront();
        }
    }
}
