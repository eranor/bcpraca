package com.akos.modules.specific;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
enum RollMode {
    STOP(0), NORMAL(1), FAST(2);

    private final int val;

    RollMode(int i) {
        this.val = i;
    }

    public int getVal() {
        return val;
    }
}
