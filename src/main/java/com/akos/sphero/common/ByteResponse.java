package com.akos.sphero.common;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class ByteResponse extends DeviceResponse {
    public ByteResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }

    public String toString() {
        return "<" + this.getClass().getSimpleName() +
                String.format(" dev=0x%02x", this.getCommand().getDeviceId()) +
                String.format(" cmd=0x%02x", this.getCommand().getCommandId()) +
                String.format(" seq=0x%02x ", this.getSequenceNumber()) +
                this.getCode() +
                '>';
    }
}
