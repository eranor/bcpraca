package com.akos.sphero.commands.robot.response;

import com.akos.sphero.common.internal.*;
import com.akos.sphero.utils.ByteUtil;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ReadLocatorResponse extends DeviceResponse {

    private int xPos;
    private int yPos;
    private int xVel; //velocity over the x axis
    private int yVel; //velocity over the y axis
    private int sog;  //Speed over ground

    public ReadLocatorResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }

    @Override
    protected void parseData() {
        super.parseData();
        byte[] packet = this.getPacket();
        if (this.getResponseCode() == ResponseCode.OK) {
            int[] list = new int[5];
            for (int i = 0; i < 5; i++) {
                byte[] var = new byte[packet[4] - 1];
                System.arraycopy(packet, 5, var, i * var.length, var.length);
                list[i] = ByteUtil.convertBytesTo16BitInt(var);
            }
            this.xPos = list[0];
            this.yPos = list[1];
            this.xVel = list[2];
            this.yVel = list[3];
            this.sog = list[4];
        }
    }

    @Override
    public String toString() {
        return String.format("ReadLocatorResponse{xPos=%d, yPos=%d, xVel=%d, yVel=%d, sog=%d}", xPos, yPos, xVel, yVel, sog);
    }
}
