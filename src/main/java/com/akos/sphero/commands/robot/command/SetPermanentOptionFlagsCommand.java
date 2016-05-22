package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;
import com.orbotix.command.sphero.PersistentOptionFlags;
import com.orbotix.common.utilities.binary.BitMask;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SetPermanentOptionFlagsCommand extends DeviceCommand {
    private final long flags;

    /**
     * @deprecated
     */
    @Deprecated
    public SetPermanentOptionFlagsCommand(long optionFlags) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.SET_OPTION_FLAGS);
        this.flags = optionFlags;
    }

    public SetPermanentOptionFlagsCommand(BitMask<PersistentOptionFlags> mask) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.SET_OPTION_FLAGS);
        this.flags = mask.longValue();
    }

    public long getOptionFlags() {
        return this.flags;
    }

    public byte[] getData() {
        return new byte[]{(byte) ((int) (this.flags >> 24)), (byte) ((int) (this.flags >> 16)), (byte) ((int) (this.flags >> 8)), (byte) ((int) this.flags)};
    }

    public String toString() {
        return String.format("OptionFlagsCommand{optionFlags=%s}", String.format("%08x", this.flags));
    }
}