package com.akos.sphero.commands.core.response;

import com.akos.sphero.common.internal.*;

import java.io.UnsupportedEncodingException;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class GetBluetoothInfoResponse extends DeviceResponse {
    private String deviceName;
    private String bluetoothAddress;

    public GetBluetoothInfoResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }


    protected void parseData() {
        super.parseData();
        if (this.getResponseCode() == ResponseCode.OK) {
            int dataLength = this.getPacket().length - 5 - 1;
            int deviceNameMaxLen = dataLength == 64 ? 48 : 16;
            int deviceNameLength = deviceNameMaxLen;

            for (int i = 0; i < deviceNameMaxLen; ++i) {
                if (this.getPacket()[5 + i] == 0) {
                    deviceNameLength = i;
                    break;
                }
            }

            int deviceAddressLength = 16;

            for (int i = 0; i < 16; ++i) {
                if (this.getPacket()[5 + i + deviceNameMaxLen] == 0) {
                    deviceAddressLength = i;
                    break;
                }
            }

            try {
                this.deviceName = new String(this.getPacket(), 5, deviceNameLength, "UTF-8");
                this.bluetoothAddress = new String(this.getPacket(), 5 + deviceNameMaxLen, deviceAddressLength, "US-ASCII");
                this.bluetoothAddress = this.bluetoothAddress.toUpperCase();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                this.deviceName = null;
                this.bluetoothAddress = null;
            }
        }

    }

    public String getName() {
        return this.deviceName;
    }

    public String getAddress() {
        return this.bluetoothAddress;
    }

    @Override
    public String toString() {
        return String.format("GetBluetoothInfoResponse{deviceName='%s', bluetoothAddress='%s'}", deviceName, bluetoothAddress);
    }
}
