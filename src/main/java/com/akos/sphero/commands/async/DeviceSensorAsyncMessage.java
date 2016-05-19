package com.akos.sphero.commands.async;

import com.akos.sphero.common.internal.AsyncResponse;
import com.orbotix.common.sensor.*;
import com.orbotix.common.utilities.binary.BitMask;

import java.util.ArrayList;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */

public class DeviceSensorAsyncMessage extends AsyncResponse {
    private static final String mask = "mask";
    private static final String frameCount = "frameCount";
    private static final String dataFrames = "dataFrames";
    public static long sMask = 0L;
    public static int sPacketFrames = 0;
    private byte[] packet;
    private ArrayList<DeviceSensorsData> asyncData;

    public DeviceSensorAsyncMessage(byte[] packet) {
        super(packet);
    }

    protected void parseData() {
        super.parseData();
        this.packet = this.getData();
        if (sMask != 0L) {
            int var1 = this.a(sMask) * 2;
            if (this.packet.length / sPacketFrames < var1) {
                sMask &= 4294967295L;
                var1 = this.a(sMask) * 2;
            }

            int var2 = this.packet.length / var1;
            this.asyncData = new ArrayList<>(var2);

            for (int var3 = 0; var3 < var2; ++var3) {
                byte[] var4 = new byte[var1];
                System.arraycopy(this.packet, var3 * var1, var4, 0, var1);
                BitMask<SensorFlag> bitMask = new BitMask<>(sMask);
                this.asyncData.add(new DeviceSensorsData(bitMask, var4));
            }

        }
    }

    public byte[] getRawData() {
        return this.packet;
    }

    public ArrayList<DeviceSensorsData> getAsyncData() {
        return this.asyncData;
    }

    private int a(long var1) {
        int var3 = 0;
        for (int var4 = 0; var4 < 64; ++var4) {
            if ((1L & var1 >> var4) == 1L) {
                ++var3;
            }
        }
        return var3;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (byte i : this.packet) {
            buffer.append(String.format("%02X ", i));
        }
        return String.format("DeviceSensorsAsyncData{mRawData=%s, mAsyncData=%s}", buffer.toString(), this.asyncData);
    }
}
