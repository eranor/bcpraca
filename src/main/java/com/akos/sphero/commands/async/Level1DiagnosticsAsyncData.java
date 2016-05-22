package com.akos.sphero.commands.async;

import com.akos.sphero.common.internal.AsyncResponse;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class Level1DiagnosticsAsyncData extends AsyncResponse {


    public Level1DiagnosticsAsyncData(byte[] packet) {
        super(packet);
    }
}
