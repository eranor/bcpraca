package com.akos.sphero.commands.async;

import com.akos.sphero.common.internal.AsyncResponse;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class GyroLimitsExceededAsyncData extends AsyncResponse {


    public GyroLimitsExceededAsyncData(byte[] packet) {
        super(packet);
    }
}
