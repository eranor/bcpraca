package com.akos.sphero.common.internal.ids;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public enum SOP {
    DEFAULT (0xFF),
    ASYNC (0xFE),
    NORESET (0xFD),
    NORESET_ASYNC (0xFC);

    private byte byteCode = 0x00;

    SOP(int aByteCode) {
        this.byteCode = (byte) aByteCode;
    }

    public byte getValue() {
        return byteCode;
    }

}
