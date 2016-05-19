package com.akos.sphero.commands.robot.response;

import com.akos.sphero.common.internal.*;
import com.akos.sphero.utils.ByteUtil;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class GetUserRGBColorResponse extends DeviceResponse {
    private short redIntensity;
    private short greenIntensity;
    private short blueIntensity;

    protected GetUserRGBColorResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
        if(this.getResponseCode() == ResponseCode.OK) {
            this.redIntensity = ByteUtil.convertUnsignedToShort(packet[5]);
            this.greenIntensity = ByteUtil.convertUnsignedToShort(packet[6]);
            this.blueIntensity = ByteUtil.convertUnsignedToShort(packet[7]);
            //this.redIntensity = ByteUtil.convertUnsignedToShort(packet[5]);
            //this.greenIntensity = ByteUtil.convertUnsignedToShort(packet[6]);
            //this.blueIntensity = ByteUtil.convertUnsignedToShort(packet[7]);
        }

    }

    public short getRedIntensity() {
        return this.redIntensity;
    }

    public short getGreenIntensity() {
        return this.greenIntensity;
    }

    public short getBlueIntensity() {
        return this.blueIntensity;
    }
}