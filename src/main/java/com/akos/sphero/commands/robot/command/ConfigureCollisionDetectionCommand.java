package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class ConfigureCollisionDetectionCommand extends DeviceCommand {
    public static final int DISABLE_DETECTION_METHOD = 0;
    public static final int DEFAULT_DETECTION_METHOD = 1;
    private final int detectionMethod;
    private final int xThreshold;
    private final int xSpeedThreshold;
    private final int yThreshold;
    private final int ySpeedThreshold;
    private final int deadTime;

    public ConfigureCollisionDetectionCommand(int xThreshold, int xSpeedThreshold, int yThreshold, int ySpeedThreshold, int deadTime) {
        this(DEFAULT_DETECTION_METHOD, xThreshold, xSpeedThreshold, yThreshold, ySpeedThreshold, deadTime);
    }

    public ConfigureCollisionDetectionCommand(int detectionMethod, int xThreshold, int xSpeedThreshold, int yThreshold, int ySpeedThreshold, int deadTime) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.CONFIGURE_COLLISION_DETECTION);
        this.detectionMethod = detectionMethod;
        this.xThreshold = xThreshold;
        this.xSpeedThreshold = xSpeedThreshold;
        this.yThreshold = yThreshold;
        this.ySpeedThreshold = ySpeedThreshold;
        this.deadTime = deadTime;
    }

    public static ConfigureCollisionDetectionCommand stopCommand() {
        return new ConfigureCollisionDetectionCommand(0, 0, 0, 0, 0);
    }

    public int getDetectionMethod() {
        return this.detectionMethod;
    }

    public int getXThreshold() {
        return this.xThreshold;
    }

    public int getXSpeedThreshold() {
        return this.xSpeedThreshold;
    }

    public int getYThreshold() {
        return this.yThreshold;
    }

    public int getYSpeedThreshold() {
        return this.ySpeedThreshold;
    }

    public int getDeadTime() {
        return this.deadTime;
    }

    public byte[] getData() {
        return new byte[]{(byte) this.detectionMethod, (byte) this.xThreshold, (byte) this.xSpeedThreshold, (byte) this.yThreshold, (byte) this.ySpeedThreshold, (byte) this.deadTime};
    }
}