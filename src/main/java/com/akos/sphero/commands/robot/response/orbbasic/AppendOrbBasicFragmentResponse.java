package com.akos.sphero.commands.robot.response.orbbasic;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class AppendOrbBasicFragmentResponse extends DeviceResponse {
    public AppendOrbBasicFragmentResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }
}
