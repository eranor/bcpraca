package com.akos.sphero.common.internal.ids;

/**
 * @author: Orbotix
 */
public enum CoreCommandId implements Id {
    PING(1),
    VERSIONING(2),
    SET_BLUETOOTH_NAME(16),
    GET_BLUETOOTH_INFO(17),
    GET_POWER_STATE(32),
    SET_POWER_NOTIFICATION(33),
    SLEEP(34),
    SET_INACTIVITY_TIMEOUT(37),
    GET_CHARGER_STATE(38),
    GET_FACTORY_CONFIG_BLOCK_CRC(39),
    JUMP_TO_BOOTLOADER(48),
    LEVEL_1_DIAGNOSTICS(64),
    POLL_PACKET_TIMES(81);

    private byte value;

    CoreCommandId(int value) {
        this.value = (byte) value;
    }

    public byte getValue() {
        return this.value;
    }
}
