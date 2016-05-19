package com.akos.sphero.commands.robot.response;

import com.akos.sphero.common.internal.*;
import com.akos.sphero.utils.ByteUtil;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class GetChassisIdResponse extends DeviceResponse {
    private int chassisId;

    protected GetChassisIdResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }

    protected void parseData() {
        byte[] packet = this.getPacket();
        if (this.getResponseCode() == ResponseCode.OK) {
            byte[] var2 = new byte[packet[4] - 1];
            System.arraycopy(packet, 5, var2, 0, var2.length);
            this.chassisId = ByteUtil.convertBytesTo16BitInt(var2);
        }

    }

    public int getChassisId() {
        return this.chassisId;
    }
}

