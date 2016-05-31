package com.akos.sphero.utils;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class Utils {
    public static <T extends Comparable<T>> T limit(T val, T min, T max) {
        if (val.compareTo(min) < 0) return min;
        else if (val.compareTo(max) > 0) return max;
        else return val;
    }

    public static <T extends Number> float scaleToRange(T val, T oldMin, T oldMax, T newMin, T newMax) {
        final float oldRange = (oldMax.floatValue() - oldMin.floatValue());
        final float v = val.floatValue() - oldMin.floatValue();
        final float v1 = newMax.floatValue() - newMin.floatValue();
        float r = (((v * v1) / oldRange) + newMin.floatValue());
        return (oldRange == 0 ? newMin.floatValue() : r >= newMax.floatValue() ? newMax.floatValue() : r);
    }
}
