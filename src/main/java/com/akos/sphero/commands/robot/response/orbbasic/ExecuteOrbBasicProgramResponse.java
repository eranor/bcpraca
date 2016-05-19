package com.akos.sphero.commands.robot.response.orbbasic;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class ExecuteOrbBasicProgramResponse extends DeviceResponse {
    public ExecuteOrbBasicProgramResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }
}
