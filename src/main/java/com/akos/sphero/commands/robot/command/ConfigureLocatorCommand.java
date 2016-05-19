package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class ConfigureLocatorCommand extends DeviceCommand {
    public static final int ROTATE_WITH_CALIBRATE_FLAG_OFF = 0;
    public static final int ROTATE_WITH_CALIBRATE_FLAG_ON = 1;
    private final int flag;
    private final int newX;
    private final int newY;
    private final int newYaw;

    public ConfigureLocatorCommand(int flag, int newX, int newY, int newYaw) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.CONFIGURE_LOCATOR);
        this.flag = flag;
        this.newX = newX;
        this.newY = newY;
        this.newYaw = newYaw;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getNewPositionX() {
        return this.newX;
    }

    public int getNewPositionY() {
        return this.newY;
    }

    public int getNewYawTare() {
        return this.newYaw;
    }

    public byte[] getData() {
        return new byte[]{(byte) this.flag, (byte) (this.newX >> 8), (byte) this.newX, (byte) (this.newY >> 8), (byte) this.newY, (byte) (this.newYaw >> 8), (byte) this.newYaw};
    }
}
