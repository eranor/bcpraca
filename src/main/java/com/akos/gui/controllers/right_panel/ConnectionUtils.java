package com.akos.gui.controllers.right_panel;

import com.akos.models.services.MainService;

public class ConnectionUtils {
    public static boolean hasRobotSelected(MainService mainService) {
        if (mainService.getRobot() != null) {
            return true;
        } else {
            Notifications.create().title("Warning").text("No robot selected to send program to.")
                    .hideAfter(Duration.seconds(3)).position(Pos.BOTTOM_RIGHT).owner(App.primaryStage)
                    .hideCloseButton().darkStyle().showWarning();
            return false;
        }
    }
}