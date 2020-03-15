// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

public class HexBinary extends BinaryObject
{
    public HexBinary(final byte[] data) {
        this.data = data;
    }
    
    static HexBinary valueOf(final String str) {
        return new HexBinary(parseHexBinary(str));
    }
    
    static byte[] parseHexBinary(String str) {
        str = str.trim();
        int len = str.length();
        if ((len & 0x1) != 0x0) {
            throw new IllegalArgumentException("hexBinary string length not a multiple of 2");
        }
        len >>= 1;
        final byte[] result = new byte[len];
        for (int i = 0; i < len; ++i) {
            final int d1 = Character.digit(str.charAt(2 * i), 16);
            final int d2 = Character.digit(str.charAt(2 * i + 1), 16);
            int bad = -1;
            if (d1 < 0) {
                bad = 2 * i;
            }
            else if (d2 < 0) {
                bad = 2 * i + 1;
            }
            if (bad >= 0) {
                throw new IllegalArgumentException("invalid hexBinary character at position " + bad);
            }
            result[i] = (byte)(16 * d1 + d2);
        }
        return result;
    }
    
    static char forHexDigit(final int val) {
        return (val < 10) ? ((char)(val + 48)) : ((char)(val - 10 + 65));
    }
    
    public StringBuffer toString(final StringBuffer sbuf) {
        for (final byte b : this.data) {
            sbuf.append(forHexDigit(b >> 4 & 0xF));
            sbuf.append(forHexDigit(b & 0xF));
        }
        return sbuf;
    }
    
    @Override
    public String toString() {
        return this.toString(new StringBuffer()).toString();
    }
}
