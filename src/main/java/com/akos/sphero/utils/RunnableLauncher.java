package com.akos.sphero.utils;/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

import org.apache.logging.log4j.*;

import java.util.concurrent.*;

public class RunnableLauncher {

    private static final Logger logger = LogManager.getLogger(RunnableLauncher.class);

    private final ExecutorService runnableService = Executors.newSingleThreadExecutor();

    public void launch(Runnable aRunnable) {
        runnableService.submit(aRunnable);
        runnableService.shutdown();
        try {
            while (!runnableService.awaitTermination(60, TimeUnit.SECONDS)) ;
        } catch (InterruptedException e) {
            System.err.println("Interrupted while waiting for Runnable to finish.");
        }
    }
}