package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SetRawMotorValuesCommand extends DeviceCommand {
    private final SetRawMotorValuesCommand.MotorMode leftMotorMode;
    private final int leftMotorSpeed;
    private final SetRawMotorValuesCommand.MotorMode rightMotorMode;
    private final int rightMotorSpeed;

    public SetRawMotorValuesCommand(SetRawMotorValuesCommand.MotorMode leftMode, int leftSpeed, SetRawMotorValuesCommand.MotorMode rightMode, int rightSpeed) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.RAW_MOTOR);
        this.leftMotorMode = leftMode;
        this.leftMotorSpeed = leftSpeed;
        this.rightMotorMode = rightMode;
        this.rightMotorSpeed = rightSpeed;
    }

    public SetRawMotorValuesCommand.MotorMode getLeftMotorMode() {
        return this.leftMotorMode;
    }

    public int getLeftMotorSpeed() {
        return this.leftMotorSpeed;
    }

    public SetRawMotorValuesCommand.MotorMode getRightMotorMode() {
        return this.rightMotorMode;
    }

    public int getRightMotorSpeed() {
        return this.rightMotorSpeed;
    }


    public byte[] getData() {
        return new byte[]{(byte) this.leftMotorMode.getValue(), (byte) this.leftMotorSpeed, (byte) this.rightMotorMode.getValue(), (byte) this.rightMotorSpeed};
    }

    public enum MotorMode {
        MOTOR_MODE_OFF(0),
        MOTOR_MODE_FORWARD(1),
        MOTOR_MODE_REVERSE(2),
        MOTOR_MODE_BRAKE(3),
        MOTOR_MODE_IGNORE(4);

        private int value;

        MotorMode(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
}