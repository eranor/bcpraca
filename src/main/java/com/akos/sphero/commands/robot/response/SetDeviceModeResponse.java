package com.akos.sphero.commands.robot.response;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SetDeviceModeResponse extends DeviceResponse {
    public SetDeviceModeResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }
}
