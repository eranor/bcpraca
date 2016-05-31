package com.akos.modules.specific;

import java.util.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
enum LEDType implements EnumProperty {

    MAIN_LED_RGB("RGB", Arrays.asList("name", "type", "ledType", "color")),
    MAIN_LED_PRESET("LEDC", Arrays.asList("name", "type", "ledType", "predefColor")),
    BACK_LED("backLED", Arrays.asList("name", "type", "ledType", "intensity"));

    private final String functionName;
    private final List<String> argsList;

    LEDType(String functionName, List<String> argName) {
        this.functionName = functionName;
        this.argsList = argName;
    }

    public String getFunctionName() {
        return functionName;
    }

    @Override
    public List<String> getArgsList() {
        return argsList;
    }


}
