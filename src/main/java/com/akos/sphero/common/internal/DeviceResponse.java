package com.akos.sphero.common.internal;

import com.akos.sphero.utils.ByteUtil;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class DeviceResponse extends DeviceMessage {
    protected static final int TOTAL_PACKET_PREFIX_LENGTH = 5;
    private static final long serialVersionUID = 9119285665649631505L;
    private boolean errorFree = false;
    private DeviceCommand command;

    public DeviceResponse() {

    }


    public DeviceResponse(byte[] packet, DeviceCommand command) {
        this.setPacket(packet);
        this.command = command;
        byte checksum = computeChecksum(packet, packet.length);
        this.errorFree = (checksum == packet[packet.length - 1]);
        if (!errorFree) {
            System.err.println("Invalid checksum detected. " + String.format("%02X vs %02X", checksum, packet[packet.length - 1]));
        }
        this.parseData();
    }

    protected void parseData() {
    }

    public ResponseCode getCode() {
        return ResponseCode.byteToResponseCode(this.getPacket()[2]);
    }

    public ResponseCode getResponseCode() {
        return this.getCode();
    }

    public byte getSequenceNumber() {
        return this.getPacket()[3];
    }

    public DeviceCommand getCommand() {
        return this.command;
    }

    protected long getReceivedTimeStamp() {
        return this.getTimeStamp().getTime();
    }

    public long getDataUint32Value() {
        byte[] packet = this.getPacket();
        int var2 = packet[4] - 1;
        if (var2 != 4) {
            return 0L;
        } else {
            byte[] var3 = new byte[var2];
            System.arraycopy(packet, 5, var3, 0, var3.length);
            return ByteUtil.convertBytesTo32BitUnsignedInt(var3);
        }
    }

    public String toString() {
        return String.format("<%s%s%s>", this.getClass().getSimpleName(), String.format(" seq:0x%02x ", this.getSequenceNumber()), this.getCode());
    }

}

