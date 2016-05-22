package com.akos.sphero.commands.async;

import com.akos.sphero.common.internal.AsyncResponse;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SleepWillOccurMessage extends AsyncResponse {


    public SleepWillOccurMessage(byte[] packet) {
        super(packet);
    }
}
