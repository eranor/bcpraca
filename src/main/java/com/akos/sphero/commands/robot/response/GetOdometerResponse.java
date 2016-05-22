package com.akos.sphero.commands.robot.response;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class GetOdometerResponse extends DeviceResponse {
    private long distance;

    protected GetOdometerResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }

    protected void parseData() {
        super.parseData();
        this.distance = this.getDataUint32Value();
    }

    public long getDistanceInCentimeters() {
        return this.distance;
    }
}