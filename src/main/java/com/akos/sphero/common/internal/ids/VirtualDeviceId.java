package com.akos.sphero.common.internal.ids;

/**
 * Sphero is an actual device (obviously) but in his core software,
 * many virtual devices are implemented.  This makes the separation
 * of tasks more clear.
 *
 * @author Orbotix
 * @author Ákos Hervay(akoshervay@gmail.com)
 */
public enum VirtualDeviceId implements Id {
    /* The control system accepts direction and speed commands.*/
    CORE(0x00),
    /* The Bootloader device handles firmware downloads.*/
    BOOTLOADER(0x01),
    /* The orbBasic device manages downloaded user programs.*/
    ROBOT(0x02);

    private final byte value;

    VirtualDeviceId(int i) {
        this.value = (byte) i;
    }

    public byte getValue() {
        return this.value;
    }
}
