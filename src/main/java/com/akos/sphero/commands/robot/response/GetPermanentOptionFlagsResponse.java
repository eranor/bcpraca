package com.akos.sphero.commands.robot.response;

import com.akos.sphero.common.internal.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class GetPermanentOptionFlagsResponse extends DeviceResponse {
    private static final int a = 4;
    public static final long OPTION_FLAGS_PREVENT_SLEEP_IN_CHARGER = 1L;
    public static final long OPTION_FLAGS_ENABLE_VECTORE_DRIVE = 2L;
    public static final long OPTION_FLAGS_DISABLE_SELF_LEVEL_IN_CHARGER = 4L;
    public static final long OPTION_FLAGS_TAIL_LIGHT_ALWAYS_ON = 8L;
    public static final long OPTION_FLAGS_ENABLE_MOTION_TIMOUT = 16L;
    private long flags;

    protected GetPermanentOptionFlagsResponse(byte[] packet, DeviceCommand command) {
        super(packet, command);
    }

    protected void parseData() {
        super.parseData();
        if (this.getResponseCode() == ResponseCode.OK) {
            this.flags = ((long) this.getPacket()[5] & 255L) << 24;
            this.flags += ((long) this.getPacket()[6] & 255L) << 16;
            this.flags += ((long) this.getPacket()[7] & 255L) << 8;
            this.flags += (long) this.getPacket()[8] & 255L;
        }

    }

    public long getOptionFlags() {
        return this.flags;
    }

    public boolean isOptionFlagSet(long optionFlag) {
        return (optionFlag & this.flags) > 0L;
    }
}
