package com.akos.sphero.commands.robot.response;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class RollResponse extends DeviceResponse {

    private static final long serialVersionUID = 1393874447017472175L;

    public RollResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }
}
