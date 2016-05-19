package com.akos.sphero.commands.core.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

public class GetBluetoothInfoCommand extends DeviceCommand {

    public GetBluetoothInfoCommand() {
        super(VirtualDeviceId.CORE, CoreCommandId.GET_BLUETOOTH_INFO);
    }

}




