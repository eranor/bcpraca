package com.akos.sphero.common.internal;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Orbotix
 */
public abstract class DeviceMessage implements Serializable {

    private static final long serialVersionUID = 7835601662529402641L;

    private final Date timestamp = new Date();
    private byte[] packet;
    private boolean isAsync = false;

    public DeviceMessage() {
    }

    public Date getTimeStamp() {
        return this.timestamp;
    }

    public byte[] getPacket() {
        return this.packet;
    }

    protected void setPacket(byte[] packet) {
        this.packet = packet;
    }

    public boolean isAsync() {
        return isAsync;
    }

    public void setAsync(boolean async) {
        isAsync = async;
    }

    public int describeContents() {
        return 0;
    }

    protected byte computeChecksum(byte[] byteArray, int length) {
        byte checksum = 0;                           // + checksum is last byte in the packet
        for (int i = 2; i < (length - 1); i++) {     // + sum of all bytes starting after the
            checksum += byteArray[i];                //   first two SOP bytes until the end
        }                                            //   of the data payload.
        return (byte) (~checksum);                   // + bit-wise inverse
    }
}
