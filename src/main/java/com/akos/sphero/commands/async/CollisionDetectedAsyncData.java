package com.akos.sphero.commands.async;

import com.akos.sphero.common.internal.AsyncResponse;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class CollisionDetectedAsyncData extends AsyncResponse {


    public CollisionDetectedAsyncData(byte[] packet) {
        super(packet);
    }
}
