package com.akos.sphero.commands.robot.command;

import com.akos.sphero.Robot;
import com.akos.sphero.commands.async.DeviceSensorAsyncMessage;
import com.akos.sphero.common.ResponseListener;
import com.akos.sphero.common.internal.*;
import com.akos.sphero.common.internal.ids.*;
import com.orbotix.common.sensor.SensorFlag;

import java.util.HashMap;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SetDataStreamingCommand extends DeviceCommand implements ResponseListener {
    private final int divisor;
    private final int packetFrames;
    private final long mask;
    private final byte packetCount;
    private static HashMap e = new HashMap();

    public SetDataStreamingCommand(int divisor, int packetFrames, long sensorMask, int packetCount) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.SET_DATA_STREAMING);
        this.divisor = divisor;
        this.packetFrames = packetFrames;
        com.orbotix.async.DeviceSensorAsyncMessage.sPacketFrames = packetFrames;
        this.mask = sensorMask;
        com.orbotix.async.DeviceSensorAsyncMessage.sMask = sensorMask;
        this.packetCount = (byte) packetCount;
    }

    public SetDataStreamingCommand(int divisor, int packetFrames, SensorFlag sensorMask, int packetCount) {
        this(divisor, packetFrames, sensorMask.longValue(), packetCount);
    }

    public byte[] getData() {
        return new byte[]{(byte) (this.divisor >> 8), (byte) this.divisor, (byte) (this.packetFrames >> 8), (byte) this.packetFrames, (byte) ((int) (this.mask >> 24)), (byte) ((int) (this.mask >> 16)), (byte) ((int) (this.mask >> 8)), (byte) ((int) this.mask), this.packetCount, (byte) ((int) (this.mask >> 56)), (byte) ((int) (this.mask >> 48)), (byte) ((int) (this.mask >> 40)), (byte) ((int) (this.mask >> 32))};
    }

    public long getMask() {
        return this.mask;
    }

    public void handleResponse(DeviceResponse response, Robot robot) {
    }

    public void handleStringResponse(String stringResponse, Robot robot) {
    }

    @Override
    public void handleAsyncResponse(AsyncResponse asyncResponse, Robot robot) {
        if (asyncResponse instanceof DeviceSensorAsyncMessage) {
            String identifier = robot.getIdentifier();
            if (e.containsKey(identifier)) {
                StreamingPacket var4 = (StreamingPacket) e.get(identifier);
                if (var4.i() && var4.b()) {
                    robot.send(new SetDataStreamingCommand(var4.divisor(), var4.packetFrames(), var4.mask(), var4.packetCount()));
                    var4.a();
                }
            }
        }

    }

    public String toString() {
        return String.format("SetDataStreamingCommand{Divisor=%d, PacketFrames=%d, SensorMask=%s, PacketCount=%s}",
                this.divisor, this.packetFrames, String.format("%16X", this.mask), this.packetCount);
    }

    private static class StreamingPacket {
        private static final int a = 200;
        private static final int b = 50;
        private int c;
        private int divisor;
        private int packetFrames;
        private long mask;
        private int packetCount;

        public StreamingPacket(int divisor, int packetFrames, long mask, int packetCount) {
            this.divisor = divisor;
            this.packetFrames = packetFrames;
            this.mask = mask;
            this.packetCount = packetCount;
        }

        private boolean i() {
            return ++this.c > 150;
        }

        public void a() {
            this.c = 0;
        }

        public boolean b() {
            return this.packetCount == 0;
        }

        public int c() {
            return this.c;
        }

        public int divisor() {
            return this.divisor;
        }

        public int packetFrames() {
            return this.packetFrames;
        }

        public long mask() {
            return this.mask;
        }

        public int packetCount() {
            return this.packetCount;
        }

        public int h() {
            return this.packetCount == 0 ? 200 : this.packetCount;
        }
    }
}
