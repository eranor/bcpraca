package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SelfLevelCommand extends DeviceCommand {
    public static final int OPTION_START = 1;
    public static final int OPTION_KEEP_HEADING = 2;
    public static final int OPTION_SLEEP_AFTER = 4;
    public static final int OPTION_CONTROL_SYSTEM_ON = 8;
    private final int options;
    private final int angleLimit;
    private final int timeout;
    private final int accuracy;

    public SelfLevelCommand(int options, int angleLimit, int timeout, int accuracy) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.SELF_LEVEL);
        this.options = options;
        this.angleLimit = angleLimit;
        this.timeout = timeout;
        this.accuracy = accuracy;
    }

    public int getOptions() {
        return this.options;
    }

    public int getAngleLimit() {
        return this.angleLimit;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public int getAccuracy() {
        return this.accuracy;
    }

    public byte[] getData() {
        return new byte[]{(byte) this.options, (byte) this.angleLimit, (byte) this.timeout, (byte) this.accuracy};
    }
}
