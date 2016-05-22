package com.akos.sphero.commands.async;

import com.akos.sphero.common.internal.AsyncResponse;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class SleepDidOccurMessage extends AsyncResponse {


    public SleepDidOccurMessage(byte[] packet) {
        super(packet);
    }
}
