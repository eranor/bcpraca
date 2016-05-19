package com.akos.sphero.commands.core.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

public class VersioningCommand extends DeviceCommand {
    private static final long serialVersionUID = 6005704712691254537L;

    public VersioningCommand() {
        super(VirtualDeviceId.CORE, CoreCommandId.VERSIONING);
        this.setKeepAlive(false);
    }
}

