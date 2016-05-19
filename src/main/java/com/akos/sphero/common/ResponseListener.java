package com.akos.sphero.common;/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */



import com.akos.sphero.Robot;
import com.akos.sphero.common.internal.*;

public interface ResponseListener {

    void handleResponse(DeviceResponse var1, Robot var2);

    void handleStringResponse(String var1, Robot var2);

    void handleAsyncResponse(AsyncResponse var1, Robot var2);

}
