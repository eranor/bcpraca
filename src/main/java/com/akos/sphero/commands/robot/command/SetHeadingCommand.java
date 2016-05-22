package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SetHeadingCommand extends DeviceCommand {
    private final float heading;

    public SetHeadingCommand(float heading) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.SET_HEADING);
        this.heading = heading;
    }

    public float getHeading() {
        return this.heading;
    }

    public byte[] getData() {
        return new byte[]{(byte) ((int) this.heading >> 8), (byte) ((int) this.heading)};
    }
}
