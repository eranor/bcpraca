package com.akos.sphero.commands.async.orbbasic;/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

import com.akos.sphero.common.internal.AsyncResponse;
import org.apache.logging.log4j.*;

public class OrbBasicErrorASCIIAsyncData extends AsyncResponse {

    private static final Logger logger = LogManager.getLogger(OrbBasicErrorASCIIAsyncData.class);
    private String errorASCII;


    public OrbBasicErrorASCIIAsyncData(byte[] packet) {
        super(packet);
    }

    protected void parseData() {
        super.parseData();
        this.errorASCII = new String(this.getData());
    }

    public String getErrorASCII() {
        return this.errorASCII;
    }

    @Override
    public String toString() {
        return String.format("OrbBasicErrorASCIIAsyncData{errorASCII='%s'}", errorASCII);
    }
}
