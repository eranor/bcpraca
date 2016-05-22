package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;
import com.sun.javafx.Utils;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SetRotationRateCommand extends DeviceCommand {
    public static final byte COMMAND_ID = 3;
    private final float rotationRate;

    public SetRotationRateCommand(float rate) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.ROTATION_RATE);
        if (rate >= 0.0F && rate <= 1.0F) {
            this.rotationRate = (float) Utils.clamp((double) rate, 0.0D, 1.0D);
        } else {
            throw new IllegalArgumentException("Expects Rate from 0.0 to 1.0 inclusive");
        }
    }

    public float getRate() {
        return this.rotationRate;
    }

    public byte[] getData() {
        return new byte[]{(byte) ((int) ((double) this.rotationRate * 255.0D))};
    }
}
