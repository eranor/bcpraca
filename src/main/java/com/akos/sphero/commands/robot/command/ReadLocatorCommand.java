package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ReadLocatorCommand extends DeviceCommand {

    public ReadLocatorCommand() {
        super(VirtualDeviceId.ROBOT, RobotCommandId.READ_LOCATOR);
    }
}
