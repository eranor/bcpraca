package com.akos.gui.controllers.right_panel;


import com.akos.gui.controllers.AbstractController;
import com.akos.services.*;
import com.akos.sphero.commands.async.orbbasic.*;
import com.akos.sphero.common.internal.DeviceResponse;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.*;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.apache.logging.log4j.*;

import java.net.URL;
import java.util.*;

/**
 * Created by Ákos on 2015. 12. 21.
 * Email: akoshervay@gmail.com
 */


public class RobotConsolePaneController extends AbstractController implements Initializable {

    private static final Logger logger = LogManager.getLogger(RobotConsolePaneController.class);
    public TitledPane robotConsoleView;
    public VBox rightPaneTabBody;
    public TextArea consoleTextArea;
    private SimpleObjectProperty<Program> selectedProgram;


    public RobotConsolePaneController(MainService mainService) {
        super(mainService);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ScheduledService<?> s = new ScheduledService<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        if (mainService.getRobot() != null) {
                            ArrayList<DeviceResponse> responses = mainService.getRobot().getAllPackets();
                            if (responses.size() > 0) {
                                responses.forEach(deviceResponse -> {
                                    if (deviceResponse instanceof OrbBasicPrintMessageAsyncData) {
                                        consoleTextArea.appendText(((OrbBasicPrintMessageAsyncData) deviceResponse).getMessage() + "\n");
                                    } else if (deviceResponse instanceof OrbBasicErrorASCIIAsyncData) {
                                        consoleTextArea.appendText(((OrbBasicErrorASCIIAsyncData) deviceResponse).getErrorASCII() + "\n");
                                    } else if (deviceResponse instanceof OrbBasicErrorBinaryAsyncData) {
                                        consoleTextArea.appendText(Arrays.toString(((OrbBasicErrorBinaryAsyncData) deviceResponse).getErrorBinary()) + "\n");
                                    }
                                });
                            }
                        }
                        return null;
                    }
                };
            }
        };
        s.setDelay(Duration.millis(100));
        s.start();
        logger.debug("Watcher started");
    }

}
