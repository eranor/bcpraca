package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;
import com.akos.sphero.utils.Utils;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class SetRGBLEDOutputCommand extends DeviceCommand {

    private final int red;
    private final int green;
    private final int blue;
    private final boolean userDefault;

    public SetRGBLEDOutputCommand(float red, float green, float blue) {
        this((int) (Utils.limit(red, 0.0F, 1.0F) * 255.0F), (int) (Utils.limit(green, 0.0F, 1.0F) * 255.0F), (int) (Utils.limit(blue, 0.0F, 1.0F) * 255.0F));
    }

    /**
     * @deprecated
     */
    @Deprecated
    public SetRGBLEDOutputCommand(int r, int g, int b) {
        this(r, g, b, false);
    }

    public SetRGBLEDOutputCommand(byte[] packet) {
        this(packet[6],packet[7],packet[8], packet[9] == 1);
    }

    public SetRGBLEDOutputCommand(int r, int g, int b, boolean userDefault) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.RGB_LED_OUTPUT);
        this.red = Utils.limit(r, 0, 255);
        this.green = Utils.limit(g, 0, 255);
        this.blue = Utils.limit(b, 0, 255);
        this.userDefault = userDefault;
        this.setResponseRequested(false);
    }

    public int getRed() {
        return this.red;
    }

    public int getGreen() {
        return this.green;
    }

    public int getBlue() {
        return this.blue;
    }

    public boolean isUserDefault() {
        return this.userDefault;
    }

    public byte[] getData() {
        return new byte[]{(byte) this.red, (byte) this.green, (byte) this.blue, (byte) (this.userDefault ? 1 : 0)};
    }

}

