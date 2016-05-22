package com.akos.sphero.commands.robot.response;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class GetDeviceModeResponse extends DeviceResponse {
    public static final int DeviceModeNormal = 0;
    public static final int DeviceModeUserHack = 1;
    private int deviceMode;

    protected GetDeviceModeResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }

    protected void parseData() {
        super.parseData();
        if (this.getResponseCode() == ResponseCode.OK) {
            this.deviceMode = this.getPacket()[5];
        }

    }

    public int getDeviceMode() {
        return this.deviceMode;
    }
}