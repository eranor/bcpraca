package com.akos.models.modules;

import javafx.beans.property.*;
import javafx.scene.paint.Color;

import java.util.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class RGBLedModuleModel extends AModuleModel {


    private transient ObjectProperty<LEDType> ledType = new SimpleObjectProperty<>(this, "ledType", LEDType.MAIN_LED_RGB);
    private transient ObjectProperty<Color> color = new SimpleObjectProperty<>(this, "color", new Color(0, 0, 0, 1));
    private PredefColor predefColor = PredefColor.OFF;
    private int intensity;

    public RGBLedModuleModel() {
        super(ModuleType.BackLEDModule);
        setIntensity(0);
    }

    public LEDType getLedType() {
        return ledType.get();
    }

    public ObjectProperty<LEDType> ledTypeProperty() {
        return ledType;
    }

    public void setLedType(LEDType ledType) {
        this.ledType.set(ledType);
    }

    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public PredefColor getPredefColor() {
        return predefColor;
    }

    public void setPredefColor(PredefColor predefColor) {
        this.predefColor = predefColor;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    private String[] colorToRGB() {
        return new String[]{String.valueOf(getColor().getRed()),
                String.valueOf(getColor().getGreen()),
                String.valueOf(getColor().getBlue())};
    }

    @Override
    public String[] getCompiledValue() {
        String result = getLedType().getFunctionName() + " ";
        switch (getLedType()) {
            case MAIN_LED_RGB:
                result += String.format("%s,%s,%s", (int) getColor().getRed(), (int) getColor().getGreen(), (int) getColor().getBlue());
                break;
            case MAIN_LED_PRESET:
                result += String.valueOf(predefColor.getValue());
                break;
            case BACK_LED:
                result += String.valueOf(intensity);
                break;
        }
        return new String[]{result};
    }

    public enum PredefColor {
        OFF(0), RED(1), GREEN(2), BLUE(3), ORANGE(4), PURPLE(5), WHITE(6), YELLOW(7);

        private final int value;

        PredefColor(int i) {
            value = i;
        }

        public int getValue() {
            return value;
        }
    }

}

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
