package com.akos.sphero.common.internal.ids;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */
public enum RobotCommandId implements Id {
    CALIBRATE(1),
    SET_HEADING(1),
    STABILIZATION(2),
    ROTATION_RATE(3),
    GET_CHASSIS_ID(7),
    SELF_LEVEL(9),
    SET_DATA_STREAMING(17),
    CONFIGURE_COLLISION_DETECTION(18),
    CONFIGURE_LOCATOR(19),
    READ_LOCATOR(21),
    RGB_LED_OUTPUT(32),
    BACK_LED_OUTPUT(33),
    GET_LED_COLOR(34),
    ROLL(48),
    BOOST(49),
    RAW_MOTOR(51),
    SET_MOTION_TIMEOUT(52),
    SET_OPTION_FLAGS(53),
    GET_OPTION_FLAGS(54),
    SET_TEMPORARY_OPTION_FLAGS(55),
    GET_TEMPORARY_OPTION_FLAGS(56),
    GET_SKU(58),
    GET_CONFIGURATION_BLOCK(64),
    COMMIT_RAM_TO_FLASH(65),
    SET_DEVICE_MODE(66),
    GET_DEVICE_MODE(68),
    RUN_MACRO(80),
    SAVE_TEMPORARY_MACRO(81),
    SAVE_MACRO(82),
    INIT_MACRO_EXECUTIVE(84),
    ABORT_MACRO(85),
    SAVE_TEMPORARY_MACRO_CHUNK(88),
    ORB_BASIC_ERASE_STORAGE(96),
    ORB_BASIC_APPEND_FRAGMENT(97),
    ORB_BASIC_EXECUTE_PROGRAM(98),
    ORB_BASIC_ABORT_PROGRAM(99),
    SUBMIT_VALUE_TO_INPUT_STATEMENT(100),
    APPEND_OVAL_COMPLETE(128),
    RESET_OVM(129),
    APPEND_OVAL_FRAGMENT(131),
    GET_ODOMETER(117);

    private byte value;

    RobotCommandId(int value) {
        this.value = (byte) value;
    }

    public byte getValue() {
        return this.value;
    }

    public static RobotCommandId getRobotCommandId(int value) {
        for (RobotCommandId id : values()) {
            if (id.value == value) return id;
        }
        throw new RuntimeException("Illegal Argument - no such id");
    }
}
