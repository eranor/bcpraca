package com.akos.sphero.common;/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

import org.apache.logging.log4j.*;

import java.util.EventObject;

public class ResponseEvent extends EventObject {

    private static final Logger logger = LogManager.getLogger(ResponseEvent.class);
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ResponseEvent(Object source) {
        super(source);
    }
}
