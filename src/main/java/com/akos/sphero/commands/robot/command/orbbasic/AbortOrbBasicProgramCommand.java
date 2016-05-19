package com.akos.sphero.commands.robot.command.orbbasic;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class AbortOrbBasicProgramCommand extends DeviceCommand {

    public AbortOrbBasicProgramCommand() {
        super(VirtualDeviceId.ROBOT, RobotCommandId.ORB_BASIC_ABORT_PROGRAM);
    }
}


