package com.akos.sphero.common.internal.ids;

/**
 * @author: Orbotix
 */
public enum BootloaderCommandId implements Id {
    BEGIN_REFLASH(2),
    HERE_IS_PAGE(3),
    LEAVE_BOOTLOADER(4),
    IS_PAGE_BLANK(5),
    ERASE_USER_CONFIG(6);

    private byte value;

    BootloaderCommandId(int value) {
        this.value = (byte) value;
    }

    public byte getValue() {
        return this.value;
    }
}
