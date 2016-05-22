package com.akos.sphero.common.internal;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class AsyncResponse extends DeviceResponse {


    private static final long serialVersionUID = 3630259025952800696L;

    public AsyncResponse(byte[] packet) {
        this.setPacket(packet);
        this.setAsync(true);
        this.parseData();
    }

    protected void parseData() {
    }

    public String toString() {
        return String.format("<AsyncResponse: %s l=%d>", this.getType(), this.getPacket().length);
    }

    protected byte[] getData() {
        byte[] packet = this.getPacket();
        int dataLen = packet[3] << 8;
        dataLen += packet[4] - 1;
        byte[] data = new byte[dataLen];
        System.arraycopy(this.getPacket(), 5, data, 0, dataLen);
        return data;
    }

    public AsyncResponse.Type getType() {
        return AsyncResponse.Type.fromByte(this.getPacket()[2]);
    }

    public enum Type {
        Error(0),
        PowerAsyncMessage(1),
        L1DiagnosticAsyncMessage(2),
        SensorAsyncMessage(3),
        ConfigBlockContents(4),
        WillSleepAsyncMessage(5),
        MacroEmitMarker(6),
        CollisionDetected(7),
        OrbBasicPrint(8),
        OrbBasicErrorASCII(9),
        OrbBasicErrorBinary(10),
        SelfLevelComplete(11),
        GyroLimitsExceeded(12),
        OvalErrorBroadcast(18),
        OvalDeviceBroadcast(19),
        DidSleepAsyncMessage(20);

        private final byte a;

        Type(int value) {
            this.a = (byte) value;
        }

        public byte getValue() {
            return this.a;
        }

        public static AsyncResponse.Type fromByte(byte typeAsByte) {
            AsyncResponse.Type[] var1 = values();
            for (Type var4 : var1) {
                if (var4.getValue() == typeAsByte) {
                    return var4;
                }
            }
            return Error;
        }
    }
}
