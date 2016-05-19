package com.akos.sphero.commands.robot.response;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SetRotationRateResponse extends DeviceResponse {
    protected SetRotationRateResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }

    public byte getDeviceId() {
        return getCommand().getDeviceId();
    }

    public byte getCommandId() {
        return getCommand().getCommandId();
    }
}

