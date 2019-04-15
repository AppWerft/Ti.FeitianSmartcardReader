/*
 * Decompiled with CFR 0.139.
 */
package com.ftsafe;

import java.util.Locale;

public class Utility {
    private static byte charToByte(char c) {
        return (byte)"0123456789ABCDEF".indexOf(c);
    }

    public static byte[] hexStrToBytes(String string) {
        if (string == null || string.equals("")) {
            return null;
        }
        return Utility.hexStrToBytes(string, string.length() / 2);
    }

    public static byte[] hexStrToBytes(String string, int n) {
        if (string == null || string.equals("")) {
            return null;
        }
        string = string.toUpperCase(Locale.getDefault());
        char[] arrc = string.toCharArray();
        byte[] arrby = new byte[n];
        for (int i = 0; i < n; ++i) {
            int n2 = i * 2;
            arrby[i] = (byte)(Utility.charToByte(arrc[n2]) << 4 | Utility.charToByte(arrc[n2 + 1]));
        }
        return arrby;
    }

    public static String bytes2HexStr(byte[] arrby) {
        if (arrby == null || arrby.length <= 0) {
            return null;
        }
        return Utility.bytes2HexStr(arrby, arrby.length);
    }

    public static String bytes2HexStr(byte[] arrby, int n) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (arrby == null || arrby.length <= 0) {
            return null;
        }
        for (int i = 0; i < n; ++i) {
            int n2 = arrby[i] & 255;
            String string = Integer.toHexString(n2);
            if (string.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(string + "");
        }
        return stringBuilder.toString();
    }
}

