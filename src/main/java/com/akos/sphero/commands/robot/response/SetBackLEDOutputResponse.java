package com.akos.sphero.commands.robot.response;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SetBackLEDOutputResponse extends DeviceResponse {
    public SetBackLEDOutputResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }
}