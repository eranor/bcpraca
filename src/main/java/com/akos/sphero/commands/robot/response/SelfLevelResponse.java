package com.akos.sphero.commands.robot.response;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SelfLevelResponse extends DeviceResponse {
    protected SelfLevelResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }
}
