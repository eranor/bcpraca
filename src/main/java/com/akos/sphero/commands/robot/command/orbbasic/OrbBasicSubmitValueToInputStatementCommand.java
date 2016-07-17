package com.akos.sphero.commands.robot.command.orbbasic;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

import java.nio.*;

/**
 * author: Orbotix
 */

public class OrbBasicSubmitValueToInputStatementCommand extends DeviceCommand {
    private int inputValue;

    public OrbBasicSubmitValueToInputStatementCommand(int value) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.SUBMIT_VALUE_TO_INPUT_STATEMENT);
    }

    public byte[] getData() {
        ByteBuffer var1 = ByteBuffer.allocate(4);
        var1.order(ByteOrder.BIG_ENDIAN);
        var1.putInt(this.inputValue);
        var1.flip();
        return var1.array();
    }
}