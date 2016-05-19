package com.akos.sphero.commands.core.response;

import com.akos.sphero.common.internal.*;
import com.akos.sphero.utils.ByteUtil;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class GetPowerStateResponse extends DeviceResponse {
    private int a;
    private GetPowerStateResponse.PowerState powerState;
    private float batteryVoltage;
    private int numRecharg;
    private int timeSinceCharge;

    public GetPowerStateResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }


    protected int getRecordVersion() {
        return this.a;
    }

    public GetPowerStateResponse.PowerState getPowerState() {
        return this.powerState;
    }

    public float getBatteryVoltage() {
        return this.batteryVoltage;
    }

    public int getNumberOfCharges() {
        return this.numRecharg;
    }

    public int getTimeSinceLastCharge() {
        return this.timeSinceCharge;
    }

    @Override
    protected void parseData() {
        super.parseData();
        if (this.getResponseCode() == ResponseCode.OK) {
            byte[] var1 = this.getPacket();
            this.a = ByteUtil.convertUnsignedToShort(var1[5]);
            this.powerState = GetPowerStateResponse.PowerState.stateForInt(ByteUtil.convertUnsignedToShort(var1[6]));
            this.batteryVoltage = (float) ByteUtil.convertUnsignedToInt(var1[7], var1[8]) / 100.0F;
            this.numRecharg = ByteUtil.convertUnsignedToInt(var1[9], var1[10]);
            this.timeSinceCharge = ByteUtil.convertUnsignedToInt(var1[11], var1[12]);
        }

    }

    @Override
    public String toString() {
        return String.format("GetPowerStateResponse{a=%d, powerState=%s, batteryVoltage=%s, numRecharg=%d, timeSinceCharge=%d}", a, powerState, batteryVoltage, numRecharg, timeSinceCharge);
    }

    public enum PowerState {
        CHARGING(1),
        OK(2),
        LOW(3),
        CRITICAL(4);

        private byte value;

        public static GetPowerStateResponse.PowerState stateForInt(int value) {
            GetPowerStateResponse.PowerState[] var1 = values();
            for (PowerState var4 : var1) {
                if (var4.getValue() == value) return var4;
            }
            return null;
        }

        PowerState(int value) {
            this.value = (byte) value;
        }

        public byte getValue() {
            return this.value;
        }
    }

}
