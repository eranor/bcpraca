package com.akos.gui.dialogs;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.*;

/**
 * Created by Ákos on 2015. 11. 23.
 * Email: akoshervay@gmail.com
 */
public class ErrorDialog extends Stage {
    public ErrorDialog(Window parent) {
        this.initModality(Modality.APPLICATION_MODAL);
        this.initStyle(StageStyle.UNDECORATED);
        this.initOwner(parent);
        Button closeButton = new Button("Close");
        closeButton.setOnAction((event) -> this.close());
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(10));
        dialogVbox.alignmentProperty().setValue(Pos.CENTER);
        dialogVbox.getChildren().addAll(new Text("Failed with device search: "), closeButton);
        Scene dialogScene = new Scene(dialogVbox);
        this.setScene(dialogScene);
    }
}
