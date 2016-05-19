package com.akos.sphero.commands.robot;


import com.akos.sphero.common.internal.*;

import java.util.EventListener;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */



public interface ResponseListener extends EventListener {

    void handleResponse(DeviceResponse response);

    void handleStringResponse(String response);

    void handleAsyncMessage(AsyncResponse response);


}
