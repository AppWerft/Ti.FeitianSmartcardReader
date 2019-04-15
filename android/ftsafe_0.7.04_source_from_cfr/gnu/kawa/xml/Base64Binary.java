/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.BinaryObject;

public class Base64Binary
extends BinaryObject {
    public static final String ENCODING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

    public Base64Binary(byte[] data) {
        this.data = data;
    }

    public static Base64Binary valueOf(String str) {
        return new Base64Binary(str);
    }

    public Base64Binary(String str) {
        int len = str.length();
        int blen = 0;
        for (int i = 0; i < len; ++i) {
            char ch = str.charAt(i);
            if (Character.isWhitespace(ch) || ch == '=') continue;
            ++blen;
        }
        blen = 3 * blen / 4;
        byte[] bytes = new byte[blen];
        int value = 0;
        int buffered = 0;
        int padding = 0;
        blen = 0;
        for (int i = 0; i < len; ++i) {
            int v;
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                v = ch - 65;
            } else if (ch >= 'a' && ch <= 'z') {
                v = ch - 97 + 26;
            } else if (ch >= '0' && ch <= '9') {
                v = ch - 48 + 52;
            } else if (ch == '+') {
                v = 62;
            } else if (ch == '/') {
                v = 63;
            } else {
                if (Character.isWhitespace(ch)) continue;
                if (ch == '=') {
                    ++padding;
                    continue;
                }
                v = -1;
            }
            if (v < 0 || padding > 0) {
                throw new IllegalArgumentException("illegal character in base64Binary string at position " + i);
            }
            value = (value << 6) + v;
            if (++buffered != 4) continue;
            bytes[blen++] = (byte)(value >> 16);
            bytes[blen++] = (byte)(value >> 8);
            bytes[blen++] = (byte)value;
            buffered = 0;
        }
        if (buffered + padding > 0 ? buffered + padding != 4 || (value & (1 << padding) - 1) != 0 || blen + 3 - padding != bytes.length : blen != bytes.length) {
            throw new IllegalArgumentException();
        }
        switch (padding) {
            case 1: {
                bytes[blen++] = (byte)(value << 10);
                bytes[blen++] = (byte)(value >> 2);
                break;
            }
            case 2: {
                bytes[blen++] = (byte)(value >> 4);
            }
        }
        this.data = bytes;
    }

    public StringBuffer toString(StringBuffer sbuf) {
        byte[] bb = this.data;
        int len = bb.length;
        int value = 0;
        int i = 0;
        while (i < len) {
            byte b = bb[i];
            value = value << 8 | b & 255;
            if (++i % 3 != 0) continue;
            sbuf.append(ENCODING.charAt(value >> 18 & 63));
            sbuf.append(ENCODING.charAt(value >> 12 & 63));
            sbuf.append(ENCODING.charAt(value >> 6 & 63));
            sbuf.append(ENCODING.charAt(value & 63));
        }
        switch (len % 3) {
            case 1: {
                sbuf.append(ENCODING.charAt(value >> 2 & 63));
                sbuf.append(ENCODING.charAt(value << 4 & 63));
                sbuf.append("==");
                break;
            }
            case 2: {
                sbuf.append(ENCODING.charAt(value >> 10 & 63));
                sbuf.append(ENCODING.charAt(value >> 4 & 63));
                sbuf.append(ENCODING.charAt(value << 2 & 63));
                sbuf.append('=');
            }
        }
        return sbuf;
    }

    public String toString() {
        return this.toString(new StringBuffer()).toString();
    }
}

