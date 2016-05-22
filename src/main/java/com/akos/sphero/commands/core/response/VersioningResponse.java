package com.akos.sphero.commands.core.response;

import com.akos.sphero.common.internal.*;
import com.orbotix.common.internal.RobotVersion;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

public class VersioningResponse extends DeviceResponse {
    private static final long serialVersionUID = 990332812142308817L;
    private RobotVersion robotVersion;

    public VersioningResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }

    public VersioningResponse createDefaultVersioningResponse() {
        return new VersioningResponse(null, null);
    }

    @Override
    protected void parseData() {
        super.parseData();
        if (this.getPacket() == null) {
            this.robotVersion = new RobotVersion();
        } else {
            if (this.getResponseCode() == ResponseCode.OK) {
                byte[] var1 = this.getPacket();
                byte var2 = var1[5];
                String var3 = (var2 >> 4) + "." + (15 & var2);
                byte var4 = var1[6];
                byte var5 = var1[7];
                String var6 = (var5 >> 4) + "." + (15 & var5);
                String var7 = var1[8] + "." + var1[9];
                byte var8 = var1[10];
                String var9 = (var8 >> 4) + "." + (15 & var8);
                byte var10 = var1[11];
                String var11 = (var10 >> 4) + "." + (15 & var10);
                byte var12 = var1[12];
                String var13 = (var12 >> 4) + "." + (15 & var12);
                this.robotVersion = new RobotVersion(var4, var3, var6, var7, var9, var11, var13);
            } else {
                this.robotVersion = new RobotVersion();
            }

        }
    }

    public RobotVersion getRobotVersion() {
        return robotVersion;
    }
}

