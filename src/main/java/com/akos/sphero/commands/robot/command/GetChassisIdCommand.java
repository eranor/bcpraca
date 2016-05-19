package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class GetChassisIdCommand extends DeviceCommand {
    public GetChassisIdCommand() {
        super(VirtualDeviceId.ROBOT, RobotCommandId.GET_CHASSIS_ID);
    }
}