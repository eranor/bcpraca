package com.akos.sphero.commands.core.response;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class SetDeviceNameResponse extends DeviceResponse {
    private static final long serialVersionUID = 990332812142308817L;

    protected SetDeviceNameResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }
}

