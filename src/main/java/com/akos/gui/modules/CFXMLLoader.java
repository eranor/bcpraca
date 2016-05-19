package com.akos.gui.modules;

import com.akos.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ResourceBundle;

public class CFXMLLoader {
    public static Parent load(String fxml, Object controller) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(controller.getClass().getClassLoader().getResource(fxml));
        loader.setController(controller);
        loader.setRoot(controller);
        loader.setResources(ResourceBundle.getBundle("Localization"));
        try {
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Parent loadWithCallback(String fxml, Object controller) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(controller.getClass().getClassLoader().getResource(fxml));
        loader.setControllerFactory(App.callback);
        //loader.setController(controller);
        //loader.setRoot(controller);
        loader.setResources(ResourceBundle.getBundle("Localization"));
        try {
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void justLoad(String fxml, Object controller) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(controller.getClass().getClassLoader().getResource(fxml));
        loader.setController(controller);
        loader.setRoot(controller);
        loader.setResources(ResourceBundle.getBundle("Localization"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}