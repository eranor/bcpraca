package com.akos.sphero.commands.robot.command.orbbasic;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class AppendOrbBasicFragmentCommand extends DeviceCommand {
    private final boolean storageType;
    private final byte[] fragment;

    public AppendOrbBasicFragmentCommand(boolean storageType, byte[] fragment) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.ORB_BASIC_APPEND_FRAGMENT);
        this.storageType = storageType;
        this.fragment = fragment;
    }

    public boolean getStorageType() {
        return this.storageType;
    }

    public byte[] getFragment() {
        return this.fragment;
    }

    public byte[] getData() {
        byte[] data = new byte[1 + this.fragment.length];
        data[0] = (byte) (this.storageType ? 1 : 0);
        System.arraycopy(this.fragment, 0, data, 1, this.fragment.length);
        return data;
    }
}

