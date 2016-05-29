package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;
import com.sun.javafx.util.Utils;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SetBackLEDOutputCommand extends DeviceCommand {
    private final float a;

    public SetBackLEDOutputCommand(float brightness) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.BACK_LED_OUTPUT);
        this.a = (float) Utils.clamp((double) brightness, 0.0D, 1.0D);
    }

    public float getBrightness() {
        return this.a;
    }

    public byte[] getData() {
        return new byte[]{(byte) ((int) (255.0D * (double) this.a))};
    }
}