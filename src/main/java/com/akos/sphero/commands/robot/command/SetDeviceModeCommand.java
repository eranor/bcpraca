package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SetDeviceModeCommand extends DeviceCommand {
    public static final boolean DeviceModeNormal = false;
    public static final boolean DeviceModeUserHack = true;
    private final boolean mode;

    public SetDeviceModeCommand(boolean mode) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.SET_DEVICE_MODE);
        this.mode = mode;
    }

    public boolean getDeviceMode() {
        return this.mode;
    }

    public byte[] getData() {
        return new byte[]{(byte) (this.mode ? 1 : 0)};
    }
}
