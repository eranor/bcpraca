package com.akos.sphero.commands.robot.command.orbbasic;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class EraseOrbBasicStorageCommand extends DeviceCommand {
    private final boolean storageType;

    public EraseOrbBasicStorageCommand(boolean storageType) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.ORB_BASIC_ERASE_STORAGE);
        this.storageType = storageType;
    }

    public boolean getStorageType() {
        return this.storageType;
    }

    public byte[] getData() {
        return new byte[]{(byte) (this.storageType ? 1 : 0)};
    }
}


