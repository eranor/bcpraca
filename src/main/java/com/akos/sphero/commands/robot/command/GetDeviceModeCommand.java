package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class GetDeviceModeCommand extends DeviceCommand {
    public GetDeviceModeCommand() {
        super(VirtualDeviceId.ROBOT, RobotCommandId.GET_DEVICE_MODE);
    }
}

