package com.akos.sphero.commands.robot.response.orbbasic;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class AbortOrbBasicProgramResponse extends DeviceResponse {

    public AbortOrbBasicProgramResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }
}

