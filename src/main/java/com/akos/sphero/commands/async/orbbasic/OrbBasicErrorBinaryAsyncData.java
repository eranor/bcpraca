package com.akos.sphero.commands.async.orbbasic;/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

import com.akos.sphero.common.internal.AsyncResponse;
import org.apache.logging.log4j.*;

public class OrbBasicErrorBinaryAsyncData extends AsyncResponse {

    private byte[] errorBinary;

    private static final Logger logger = LogManager.getLogger(OrbBasicErrorBinaryAsyncData.class);


    public OrbBasicErrorBinaryAsyncData(byte[] packet) {
        super(packet);
    }

    protected void parseData() {
        super.parseData();
        this.errorBinary = this.getData();
    }

    public byte[] getErrorBinary() {
        return this.errorBinary;
    }
}
