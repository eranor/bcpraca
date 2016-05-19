package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SetMotionTimeoutCommand extends DeviceCommand {
    private final int timeBeforeTimeout;

    public SetMotionTimeoutCommand(int timeBeforeTimeout) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.SET_MOTION_TIMEOUT);
        this.timeBeforeTimeout = timeBeforeTimeout;
    }

    public float getTimeBeforeTimeout() {
        return (float) this.timeBeforeTimeout;
    }

    public byte[] getData() {
        return new byte[]{(byte) (this.timeBeforeTimeout >> 8), (byte) this.timeBeforeTimeout};
    }
}


