package com.akos.modules.RollModule;

import java.io.Serializable;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class SliderValue implements Serializable {

    private int min, max, value;

    public SliderValue(int min, int max, int value) {
        this.min = min;
        this.max = max;
        this.value = value;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
