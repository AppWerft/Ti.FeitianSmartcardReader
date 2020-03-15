// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.format;

import java.math.BigInteger;
import java.io.IOException;
import java.text.FieldPosition;

public class IntegerFormat extends ReportFormat
{
    public int base;
    public int minWidth;
    public int padChar;
    public int commaChar;
    public int commaInterval;
    public int flags;
    public static final int SHOW_GROUPS = 1;
    public static final int SHOW_PLUS = 2;
    public static final int SHOW_SPACE = 4;
    public static final int SHOW_BASE = 8;
    public static final int PAD_RIGHT = 16;
    public static final int UPPERCASE = 32;
    public static final int MIN_DIGITS = 64;
    
    public IntegerFormat() {
        this.base = 10;
        this.minWidth = 1;
        this.padChar = 32;
        this.commaChar = 44;
        this.commaInterval = 3;
        this.flags = 0;
    }
    
    @Override
    public int format(final Object[] args, final int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        return this.format((Object)args, start, dst, fpos);
    }
    
    @Override
    public int format(Object arg, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        final Object[] args = (arg instanceof Object[]) ? ((Object[])arg) : null;
        int minWidth = ReportFormat.getParam(this.minWidth, 1, args, start);
        if (this.minWidth == -1610612736) {
            ++start;
        }
        final char padChar = ReportFormat.getParam(this.padChar, ' ', args, start);
        if (this.padChar == -1610612736) {
            ++start;
        }
        final char commaChar = ReportFormat.getParam(this.commaChar, ',', args, start);
        if (this.commaChar == -1610612736) {
            ++start;
        }
        final int commaInterval = ReportFormat.getParam(this.commaInterval, 3, args, start);
        if (this.commaInterval == -1610612736) {
            ++start;
        }
        final boolean printCommas = (this.flags & 0x1) != 0x0;
        final boolean padRight = (this.flags & 0x10) != 0x0;
        final boolean padInternal = padChar == '0';
        if (args != null) {
            if (start >= args.length) {
                dst.append("#<missing format argument>");
                return start;
            }
            arg = args[start];
        }
        final String sarg = this.convertToIntegerString(arg, this.base);
        if (sarg != null) {
            final char sarg2 = sarg.charAt(0);
            final boolean neg = sarg2 == '-';
            int slen = sarg.length();
            final int ndigits = neg ? (slen - 1) : slen;
            final int numCommas = printCommas ? ((ndigits - 1) / commaInterval) : 0;
            int unpadded_len = ndigits + numCommas;
            if (neg || (this.flags & 0x6) != 0x0) {
                ++unpadded_len;
            }
            if ((this.flags & 0x8) != 0x0) {
                if (this.base == 16) {
                    unpadded_len += 2;
                }
                else if (this.base == 8 && sarg2 != '0') {
                    ++unpadded_len;
                }
            }
            if ((this.flags & 0x40) != 0x0) {
                unpadded_len = ndigits;
                if (slen == 1 && sarg2 == '0' && minWidth == 0) {
                    slen = 0;
                }
            }
            if (!padRight && !padInternal) {
                while (minWidth > unpadded_len) {
                    dst.append(padChar);
                    --minWidth;
                }
            }
            int i = 0;
            if (neg) {
                dst.append('-');
                ++i;
                --slen;
            }
            else if ((this.flags & 0x2) != 0x0) {
                dst.append('+');
            }
            else if ((this.flags & 0x4) != 0x0) {
                dst.append(' ');
            }
            final boolean uppercase = this.base > 10 && (this.flags & 0x20) != 0x0;
            if ((this.flags & 0x8) != 0x0) {
                if (this.base == 16) {
                    dst.append('0');
                    dst.append(uppercase ? 'X' : 'x');
                }
                else if (this.base == 8 && sarg2 != '0') {
                    dst.append('0');
                }
            }
            if (padInternal) {
                while (minWidth > unpadded_len) {
                    dst.append(padChar);
                    --minWidth;
                }
            }
            while (slen != 0) {
                char ch = sarg.charAt(i++);
                if (uppercase) {
                    ch = Character.toUpperCase(ch);
                }
                dst.append(ch);
                --slen;
                if (printCommas && slen > 0 && slen % commaInterval == 0) {
                    dst.append(commaChar);
                }
            }
            if (padRight) {
                while (minWidth > unpadded_len) {
                    dst.append(padChar);
                    --minWidth;
                }
            }
        }
        else {
            dst.append(arg.toString());
        }
        return start + 1;
    }
    
    public String convertToIntegerString(final Object x, final int radix) {
        if (!(x instanceof Number)) {
            return null;
        }
        if (x instanceof BigInteger) {
            return ((BigInteger)x).toString(radix);
        }
        return Long.toString(((Number)x).longValue(), radix);
    }
}
