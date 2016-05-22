package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class GetPermanentOptionFlagsCommand extends DeviceCommand {
    public GetPermanentOptionFlagsCommand() {
        super(VirtualDeviceId.ROBOT, RobotCommandId.GET_OPTION_FLAGS);
    }
}
