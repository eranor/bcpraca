package com.akos.sphero.commands.core.response;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class SleepResponse extends DeviceResponse {

    private static final long serialVersionUID = 123881116066935044L;

    public SleepResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }
}
