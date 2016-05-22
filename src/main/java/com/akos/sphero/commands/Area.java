package com.akos.sphero.commands;

/**
 * Created by Ákos on 2016. 01. 04.
 * Email: akoshervay@gmail.com
 */
public enum Area {

    /*Sphero volatile memory*/
    RAM(0x00),
    /*Sphero persistent memory*/
    Flash(0x01);

    private byte code;

    Area(int code) {
        this.code = (byte) code;
    }

    public byte getCode() {
        return code;
    }
}
