package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class CommitRAMProgramToFlashCommand extends DeviceCommand {

    public CommitRAMProgramToFlashCommand() {
        super(VirtualDeviceId.ROBOT, RobotCommandId.COMMIT_RAM_TO_FLASH);
    }

    @Override
    public byte[] getData() {
        return new byte[0];
    }
}


