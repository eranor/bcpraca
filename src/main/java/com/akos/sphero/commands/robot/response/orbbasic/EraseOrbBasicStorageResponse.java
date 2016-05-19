package com.akos.sphero.commands.robot.response.orbbasic;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class EraseOrbBasicStorageResponse extends DeviceResponse {
    public EraseOrbBasicStorageResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }
}
