package com.akos.sphero.common;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public abstract class Processor implements Runnable {

    protected boolean running = false;

    public abstract void run();

    public boolean isRunning() {
        return this.running;
    }

}
