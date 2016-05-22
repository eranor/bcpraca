package com.akos.sphero.commands.core.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

public class SetDeviceNameCommand extends DeviceCommand {
    private static final long serialVersionUID = 6005704712691254537L;
    private final String name;

    public SetDeviceNameCommand(String name) {
        super(VirtualDeviceId.CORE, CoreCommandId.SET_BLUETOOTH_NAME);
        this.setKeepAlive(false);
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public byte[] getData() {
        byte[] var1 = new byte[48];
        Arrays.fill(var1, (byte) 0);
        Object var2 = null;
        byte[] var5;
        try {
            var5 = this.name.getBytes("UTF-8");
        } catch (UnsupportedEncodingException var4) {
            var4.printStackTrace();
            return null;
        }
        for (int var3 = 0; var3 < 48 && var3 < var5.length; ++var3) {
            var1[var3] = var5[var3];
        }
        return var1;
    }
}

