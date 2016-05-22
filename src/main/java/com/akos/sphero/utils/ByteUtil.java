package com.akos.sphero.utils;

import java.util.*;

/**
 * @author: Orbotix
 */
public class ByteUtil {
    public ByteUtil() {
    }

    public static int convertUnsignedToInt(byte b) {
        return b & 255;
    }

    public static int convertUnsignedToInt(byte msb, byte lsb) {
        int var2 = convertUnsignedToInt(msb);
        return var2 << 8 | convertUnsignedToInt(lsb);
    }

    public static short convertUnsignedToShort(byte b) {
        return (short) ((short) b & 255);
    }

    public static String byteArrayToHex(byte[] a) {
        StringBuilder var1 = new StringBuilder();
        int var2 = 0;
        byte[] var3 = a;
        int var4 = a.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            byte var6 = var3[var5];
            var1.append(String.format("%02x", new Object[]{Integer.valueOf(var6 & 255)}));
            ++var2;
            if (var2 == 2) {
                var2 = 0;
                var1.append(" ");
            }
        }

        return var1.toString();
    }

    public static String listOfBytesToHex(List<Byte> bytes) {
        StringBuilder var1 = new StringBuilder();
        int var2 = 0;
        Iterator var3 = bytes.iterator();

        while (var3.hasNext()) {
            byte var4 = ((Byte) var3.next()).byteValue();
            var1.append(String.format("%02x", new Object[]{Integer.valueOf(var4 & 255)}));
            ++var2;
            if (var2 == 2) {
                var2 = 0;
                var1.append(" ");
            }
        }

        return var1.toString();
    }

    public static byte[] hexStringToByteArray(String s) {
        int var1 = s.length();
        byte[] var2 = new byte[var1 / 2];

        for (int var3 = 0; var3 < var1; var3 += 2) {
            var2[var3 / 2] = (byte) ((Character.digit(s.charAt(var3), 16) << 4) + Character.digit(s.charAt(var3 + 1), 16));
        }

        return var2;
    }

    public static byte[] concatenateByteArrays(byte[] left, byte[] right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            byte[] var2 = new byte[left.length + right.length];
            System.arraycopy(left, 0, var2, 0, left.length);
            System.arraycopy(right, 0, var2, left.length, right.length);
            return var2;
        }
    }

    public static byte[] readBytesFromFront(byte[] in, int length) {
        byte[] var2 = new byte[length];
        System.arraycopy(in, 0, var2, 0, length);
        return var2;
    }

    public static byte[] removeBytesFromFront(byte[] in, int length) {
        byte[] var2 = new byte[in.length - length];
        if (var2.length > 0) {
            System.arraycopy(in, length, var2, 0, var2.length);
        }

        return var2;
    }

    public static byte[] reverse(byte[] source) {
        byte[] var1 = new byte[source.length];
        System.arraycopy(source, 0, var1, 0, var1.length);
        reverseNoCopy(var1);
        return var1;
    }

    public static void reverseNoCopy(byte[] source) {
        for (int var1 = 0; var1 < source.length / 2; ++var1) {
            byte var2 = source[var1];
            int var3 = source.length - 1 - var1;
            source[var1] = source[var3];
            source[var3] = var2;
        }

    }

    public static int convertBytesTo16BitInt(byte[] source) {
        if (source.length != 2) {
            throw new IllegalArgumentException("Length of source bytes must be exactly 2");
        } else {
            byte var1 = 0;
            int var2 = var1 + ((source[0] & 255) << 8);
            var2 += source[1] & 255;
            return var2;
        }
    }

    public static int convertBytesTo32BitInt(byte[] source) {
        if (source.length != 4) {
            throw new IllegalArgumentException("Length of source bytes must be exactly 4");
        } else {
            return (source[0] & 255) << 24 | (source[1] & 255) << 16 | (source[2] & 255) << 8 | source[3] & 255;
        }
    }

    public static long convertBytesTo32BitUnsignedInt(byte[] source) {
        int var1 = convertBytesTo32BitInt(source);
        return (long) var1 & 4294967295L;
    }

    public static float convertBytesTo32BitFloat(byte[] source) {
        return Float.intBitsToFloat(convertBytesTo32BitInt(source));
    }
}

