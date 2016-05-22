package com.akos.sphero.commands.core.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class GetPowerStateCommand extends DeviceCommand {
    public GetPowerStateCommand() {
        super(VirtualDeviceId.CORE, CoreCommandId.GET_POWER_STATE);
    }
}
