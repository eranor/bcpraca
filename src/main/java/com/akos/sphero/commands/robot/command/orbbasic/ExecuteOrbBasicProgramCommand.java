package com.akos.sphero.commands.robot.command.orbbasic;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class ExecuteOrbBasicProgramCommand extends DeviceCommand {

    private final boolean storageType;
    private final int startingLine;

    public ExecuteOrbBasicProgramCommand(boolean storageType, int startingLine) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.ORB_BASIC_EXECUTE_PROGRAM);
        this.storageType = storageType;
        this.startingLine = startingLine;
    }

    public boolean getStorageType() {
        return this.storageType;
    }

    public int getStartingLine() {
        return this.startingLine;
    }

    public byte[] getData() {
        return new byte[]{(byte) (this.storageType ? 1 : 0), (byte) (this.startingLine >> 8), (byte) this.startingLine};
    }
}


