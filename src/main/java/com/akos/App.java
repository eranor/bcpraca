package com.akos;

import com.akos.models.services.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.junit.BeforeClass;

import java.lang.reflect.*;
import java.util.ResourceBundle;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class App extends Application {

    public static MainService mainService = new InMemoryMainService();
    public static final ResourceBundle localization = ResourceBundle.getBundle("Localization");
    public static Stage primaryStage;

    @BeforeClass
    public static void installSvgLoader() {

    }

    public static Callback<Class<?>, Object> callback = type -> {
        Constructor cstr = null;
        for (Constructor c : type.getDeclaredConstructors()) {
            for (Class<?> cls : c.getParameterTypes()) {
                if (cls == MainService.class) cstr = c;
            }
        }
        try {
            return cstr != null ? cstr.newInstance(mainService) : type.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    };

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/akos/fxml/gui/Main.fxml"), localization);
        loader.setControllerFactory(callback);
        Scene scene = new Scene(loader.load());
        stage.setTitle(localization.getString("main.screenTitle"));
        scene.getStylesheets().add(getCSS(getClass(), "com/akos/css/gui/Main.css"));
        stage.setScene(scene);
        stage.show();
    }

    public static String getCSS(Class clazz, String uri) {
        return clazz.getClassLoader().getResource(uri).toExternalForm();
    }

    public static void main(String[] args) {
        launch(args);
    }

}