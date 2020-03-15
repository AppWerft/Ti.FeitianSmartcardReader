// 
// Decompiled by Procyon v0.5.36
// 

package com.ftsafe;

import java.util.Locale;

public class Utility
{
    private static byte charToByte(final char ch) {
        return (byte)"0123456789ABCDEF".indexOf(ch);
    }
    
    public static byte[] hexStrToBytes(final String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        return hexStrToBytes(s, s.length() / 2);
    }
    
    public static byte[] hexStrToBytes(String upperCase, final int n) {
        if (upperCase == null || upperCase.equals("")) {
            return null;
        }
        upperCase = upperCase.toUpperCase(Locale.getDefault());
        final char[] charArray = upperCase.toCharArray();
        final byte[] array = new byte[n];
        for (int i = 0; i < n; ++i) {
            final int n2 = i * 2;
            array[i] = (byte)(charToByte(charArray[n2]) << 4 | charToByte(charArray[n2 + 1]));
        }
        return array;
    }
    
    public static String bytes2HexStr(final byte[] array) {
        if (array == null || array.length <= 0) {
            return null;
        }
        return bytes2HexStr(array, array.length);
    }
    
    public static String bytes2HexStr(final byte[] array, final int n) {
        final StringBuilder sb = new StringBuilder("");
        if (array == null || array.length <= 0) {
            return null;
        }
        for (int i = 0; i < n; ++i) {
            final String hexString = Integer.toHexString(array[i] & 0xFF);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString + "");
        }
        return sb.toString();
    }
}
