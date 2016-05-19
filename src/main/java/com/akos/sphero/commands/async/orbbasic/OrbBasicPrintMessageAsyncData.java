package com.akos.sphero.commands.async.orbbasic;/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

import com.akos.sphero.common.internal.AsyncResponse;
import org.apache.logging.log4j.*;

public class OrbBasicPrintMessageAsyncData extends AsyncResponse {

    private static final Logger logger = LogManager.getLogger(OrbBasicPrintMessageAsyncData.class);
    private String message;


    public OrbBasicPrintMessageAsyncData(byte[] packet) {
        super(packet);
    }
    protected void parseData() {
        super.parseData();
        this.message = new String(this.getData());
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return String.format("%s :: %s", super.toString(), getMessage());
    }
}
