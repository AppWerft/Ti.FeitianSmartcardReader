// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

public class Base64Binary extends BinaryObject
{
    public static final String ENCODING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
    
    public Base64Binary(final byte[] data) {
        this.data = data;
    }
    
    public static Base64Binary valueOf(final String str) {
        return new Base64Binary(str);
    }
    
    public Base64Binary(final String str) {
        final int len = str.length();
        int blen = 0;
        for (int i = 0; i < len; ++i) {
            final char ch = str.charAt(i);
            if (!Character.isWhitespace(ch) && ch != '=') {
                ++blen;
            }
        }
        blen = 3 * blen / 4;
        final byte[] bytes = new byte[blen];
        int value = 0;
        int buffered = 0;
        int padding = 0;
        blen = 0;
        for (int j = 0; j < len; ++j) {
            final char ch2 = str.charAt(j);
            int v;
            if (ch2 >= 'A' && ch2 <= 'Z') {
                v = ch2 - 'A';
            }
            else if (ch2 >= 'a' && ch2 <= 'z') {
                v = ch2 - 'a' + 26;
            }
            else if (ch2 >= '0' && ch2 <= '9') {
                v = ch2 - '0' + 52;
            }
            else if (ch2 == '+') {
                v = 62;
            }
            else if (ch2 == '/') {
                v = 63;
            }
            else {
                if (Character.isWhitespace(ch2)) {
                    continue;
                }
                if (ch2 == '=') {
                    ++padding;
                    continue;
                }
                v = -1;
            }
            if (v < 0 || padding > 0) {
                throw new IllegalArgumentException("illegal character in base64Binary string at position " + j);
            }
            value = (value << 6) + v;
            if (++buffered == 4) {
                bytes[blen++] = (byte)(value >> 16);
                bytes[blen++] = (byte)(value >> 8);
                bytes[blen++] = (byte)value;
                buffered = 0;
            }
        }
        Label_0385: {
            if (buffered + padding > 0) {
                if (buffered + padding == 4 && (value & (1 << padding) - 1) == 0x0) {
                    if (blen + 3 - padding == bytes.length) {
                        break Label_0385;
                    }
                }
            }
            else if (blen == bytes.length) {
                break Label_0385;
            }
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
                break;
            }
        }
        this.data = bytes;
    }
    
    public StringBuffer toString(final StringBuffer sbuf) {
        final byte[] bb = this.data;
        final int len = bb.length;
        int value = 0;
        int i = 0;
        while (i < len) {
            final byte b = bb[i];
            value = (value << 8 | (b & 0xFF));
            if (++i % 3 == 0) {
                sbuf.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(value >> 18 & 0x3F));
                sbuf.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(value >> 12 & 0x3F));
                sbuf.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(value >> 6 & 0x3F));
                sbuf.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(value & 0x3F));
            }
        }
        switch (len % 3) {
            case 1: {
                sbuf.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(value >> 2 & 0x3F));
                sbuf.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(value << 4 & 0x3F));
                sbuf.append("==");
                break;
            }
            case 2: {
                sbuf.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(value >> 10 & 0x3F));
                sbuf.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(value >> 4 & 0x3F));
                sbuf.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(value << 2 & 0x3F));
                sbuf.append('=');
                break;
            }
        }
        return sbuf;
    }
    
    @Override
    public String toString() {
        return this.toString(new StringBuffer()).toString();
    }
}
