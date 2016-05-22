package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;
import com.sun.javafx.Utils;


/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class BoostCommand extends DeviceCommand {
    private final float time;
    private final float heading;

    public BoostCommand(float time, float heading) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.BOOST);
        this.time = (float) Utils.clamp((double) time, 0.0D, 25.5D);
        this.heading = (float) ((int) heading % 360);
    }

    public byte[] getData() {
        return new byte[]{(byte) ((int) ((double) this.time * 10.0D)), (byte) ((int) this.heading >> 8), (byte) ((int) this.heading)};
    }
}

