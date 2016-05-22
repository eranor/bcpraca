package com.akos.sphero.commands.core.command;


import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

public class PingCommand extends DeviceCommand {
    private static final long serialVersionUID = 6005704712691254537L;

    public PingCommand() {
        super(VirtualDeviceId.CORE, CoreCommandId.PING);
        this.setKeepAlive(false);
    }

    @Override
    public byte[] getData() {
        return new byte[0];
    }
}
