package com.akos.sphero.commands.robot;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

public interface OrbBasicEventListener {

    void onEraseCompleted(boolean var1);

    void onLoadProgramComplete(boolean var1);

    void onPrintMessage(String var1);

    void onErrorMessage(String var1);

    void onErrorByteArray(byte[] var1);


}
