/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.format;

import gnu.kawa.format.ReportFormat;
import java.io.IOException;
import java.math.BigInteger;
import java.text.FieldPosition;

public class IntegerFormat
extends ReportFormat {
    public int base = 10;
    public int minWidth = 1;
    public int padChar = 32;
    public int commaChar = 44;
    public int commaInterval = 3;
    public int flags = 0;
    public static final int SHOW_GROUPS = 1;
    public static final int SHOW_PLUS = 2;
    public static final int SHOW_SPACE = 4;
    public static final int SHOW_BASE = 8;
    public static final int PAD_RIGHT = 16;
    public static final int UPPERCASE = 32;
    public static final int MIN_DIGITS = 64;

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        return this.format((Object)args, start, dst, fpos);
    }

    @Override
    public int format(Object arg, int start, Appendable dst, FieldPosition fpos) throws IOException {
        boolean padInternal;
        String sarg;
        Object[] args = arg instanceof Object[] ? (Object[])arg : null;
        int minWidth = IntegerFormat.getParam(this.minWidth, 1, args, start);
        if (this.minWidth == -1610612736) {
            ++start;
        }
        char padChar = IntegerFormat.getParam(this.padChar, ' ', args, start);
        if (this.padChar == -1610612736) {
            ++start;
        }
        char commaChar = IntegerFormat.getParam(this.commaChar, ',', args, start);
        if (this.commaChar == -1610612736) {
            ++start;
        }
        int commaInterval = IntegerFormat.getParam(this.commaInterval, 3, args, start);
        if (this.commaInterval == -1610612736) {
            ++start;
        }
        boolean printCommas = (this.flags & 1) != 0;
        boolean padRight = (this.flags & 16) != 0;
        boolean bl = padInternal = padChar == '0';
        if (args != null) {
            if (start >= args.length) {
                dst.append("#<missing format argument>");
                return start;
            }
            arg = args[start];
        }
        if ((sarg = this.convertToIntegerString(arg, this.base)) != null) {
            boolean uppercase;
            char sarg0 = sarg.charAt(0);
            boolean neg = sarg0 == '-';
            int slen = sarg.length();
            int ndigits = neg ? slen - 1 : slen;
            int numCommas = printCommas ? (ndigits - 1) / commaInterval : 0;
            int unpadded_len = ndigits + numCommas;
            if (neg || (this.flags & 6) != 0) {
                ++unpadded_len;
            }
            if ((this.flags & 8) != 0) {
                if (this.base == 16) {
                    unpadded_len += 2;
                } else if (this.base == 8 && sarg0 != '0') {
                    ++unpadded_len;
                }
            }
            if ((this.flags & 64) != 0) {
                unpadded_len = ndigits;
                if (slen == 1 && sarg0 == '0' && minWidth == 0) {
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
            } else if ((this.flags & 2) != 0) {
                dst.append('+');
            } else if ((this.flags & 4) != 0) {
                dst.append(' ');
            }
            boolean bl2 = uppercase = this.base > 10 && (this.flags & 32) != 0;
            if ((this.flags & 8) != 0) {
                if (this.base == 16) {
                    dst.append('0');
                    dst.append(uppercase ? (char)'X' : 'x');
                } else if (this.base == 8 && sarg0 != '0') {
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
                if (!printCommas || --slen <= 0 || slen % commaInterval != 0) continue;
                dst.append(commaChar);
            }
            if (padRight) {
                while (minWidth > unpadded_len) {
                    dst.append(padChar);
                    --minWidth;
                }
            }
        } else {
            dst.append(arg.toString());
        }
        return start + 1;
    }

    public String convertToIntegerString(Object x, int radix) {
        if (!(x instanceof Number)) {
            return null;
        }
        if (x instanceof BigInteger) {
            return ((BigInteger)x).toString(radix);
        }
        return Long.toString(((Number)x).longValue(), radix);
    }
}

