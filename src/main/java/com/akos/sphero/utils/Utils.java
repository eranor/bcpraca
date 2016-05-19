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
}
