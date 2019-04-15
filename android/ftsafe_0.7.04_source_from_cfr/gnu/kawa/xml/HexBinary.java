/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.BinaryObject;

public class HexBinary
extends BinaryObject {
    public HexBinary(byte[] data) {
        this.data = data;
    }

    static HexBinary valueOf(String str) {
        return new HexBinary(HexBinary.parseHexBinary(str));
    }

    static byte[] parseHexBinary(String str) {
        int len = (str = str.trim()).length();
        if ((len & 1) != 0) {
            throw new IllegalArgumentException("hexBinary string length not a multiple of 2");
        }
        byte[] result = new byte[len >>= 1];
        for (int i = 0; i < len; ++i) {
            int d1 = Character.digit(str.charAt(2 * i), 16);
            int d2 = Character.digit(str.charAt(2 * i + 1), 16);
            int bad = -1;
            if (d1 < 0) {
                bad = 2 * i;
            } else if (d2 < 0) {
                bad = 2 * i + 1;
            }
            if (bad >= 0) {
                throw new IllegalArgumentException("invalid hexBinary character at position " + bad);
            }
            result[i] = (byte)(16 * d1 + d2);
        }
        return result;
    }

    static char forHexDigit(int val) {
        return val < 10 ? (char)(val + 48) : (char)(val - 10 + 65);
    }

    public StringBuffer toString(StringBuffer sbuf) {
        for (byte b : this.data) {
            sbuf.append(HexBinary.forHexDigit(b >> 4 & 15));
            sbuf.append(HexBinary.forHexDigit(b & 15));
        }
        return sbuf;
    }

    public String toString() {
        return this.toString(new StringBuffer()).toString();
    }
}

