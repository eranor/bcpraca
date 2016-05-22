package com.akos.sphero.common.internal;

import com.akos.sphero.common.internal.ids.*;

import java.io.ByteArrayOutputStream;
import java.util.Date;

/**
 * Created by Ákos on 2016. 01. 04.
 *
 * @author: Orbotix
 * @author: Ákos Hervay (modifier)
 * Email: akoshervay@gmail.com
 */
public abstract class DeviceCommand extends DeviceMessage {
    private static final long serialVersionUID = -6945274555416464955L;

    private Date timestamp = null;
    private boolean keepAlive = true;
    private boolean responseRequested = true;
    private byte deviceId;
    private byte commandId;
    private byte localSequenceNumber;
    private static byte sequenceNumber = 0;

    public DeviceCommand() {
        this.timestamp = this.getTimeStamp();
    }

    protected DeviceCommand(VirtualDeviceId dId, Id cId) {
        this();
        this.deviceId = dId.getValue();
        this.commandId = cId.getValue();
    }

    public byte getSequenceNumber() {
        return localSequenceNumber;
    }

    public byte getDeviceId() {
        return this.deviceId;
    }

    public byte getCommandId() {
        return this.commandId;
    }

    protected Date getTransmitTimeStamp() {
        return this.timestamp;
    }

    protected void setTransmitTimeStamp(Date timeStamp) {
        this.timestamp = timeStamp;
    }

    protected long getTimeToTransmit() {
        Date time = this.getTimeStamp();
        return this.timestamp.getTime() - time.getTime();
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public void setResponseRequested(boolean responseRequested) {
        this.responseRequested = responseRequested;
    }

    public boolean isResponseRequested() {
        return this.responseRequested;
    }

    public boolean isKeepAlive() {
        return this.keepAlive;
    }

    public byte[] getData() {
        return null;
    }

    @Override
    public byte[] getPacket() {
        this.pack();
        return super.getPacket();
    }

    protected void pack() {
        byte[] data = this.getData();
        int dataLen = data != null ? data.length : 0;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        buffer.write(SOP.DEFAULT.getValue());
        if (this.isResponseRequested()) {
            buffer.write(this.isKeepAlive() ? SOP.DEFAULT.getValue() : SOP.NORESET.getValue());
        } else {
            setAsync(true);
            buffer.write(this.isKeepAlive() ? SOP.ASYNC.getValue() : SOP.NORESET_ASYNC.getValue());
        }
        buffer.write(this.deviceId);
        buffer.write(this.commandId);
        localSequenceNumber = sequenceNumber++;
        buffer.write(localSequenceNumber);
        buffer.write(dataLen + 1);
        buffer.write(data != null ? data : new byte[0], 0, dataLen);
        buffer.write(computeChecksum(buffer.toByteArray(), buffer.size() + 1));
        this.setPacket(buffer.toByteArray());
    }

    public String toString() {
        return String.format("<%s seq=0x%02x>", this.getClass().getSimpleName(), this.getSequenceNumber());
    }
}
