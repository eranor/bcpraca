package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SetStabilizationCommand extends DeviceCommand {
    private final boolean stabilization;

    public SetStabilizationCommand(boolean on) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.STABILIZATION);
        this.stabilization = on;
    }

    public boolean on() {
        return this.stabilization;
    }

    public byte[] getData() {
        return new byte[]{(byte) (this.stabilization ? 1 : 0)};
    }
}