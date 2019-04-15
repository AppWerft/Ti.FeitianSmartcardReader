/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.format;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class RomanIntegerFormat
extends NumberFormat {
    private static RomanIntegerFormat newRoman;
    private static RomanIntegerFormat oldRoman;
    public boolean oldStyle;
    static final String codes = "IVXLCDM";

    public RomanIntegerFormat(boolean oldStyle) {
        this.oldStyle = oldStyle;
    }

    public RomanIntegerFormat() {
    }

    public static RomanIntegerFormat getInstance(boolean oldStyle) {
        if (oldStyle) {
            if (oldRoman == null) {
                oldRoman = new RomanIntegerFormat(true);
            }
            return oldRoman;
        }
        if (newRoman == null) {
            newRoman = new RomanIntegerFormat(false);
        }
        return newRoman;
    }

    public static String format(int num, boolean oldStyle) {
        if (num <= 0 || num >= 4999) {
            return Integer.toString(num);
        }
        StringBuffer sbuf = new StringBuffer(20);
        int unit = 1000;
        for (int power = 3; power >= 0; --power) {
            int digit = num / unit;
            num -= digit * unit;
            if (digit != 0) {
                if (!(oldStyle || digit != 4 && digit != 9)) {
                    sbuf.append(codes.charAt(2 * power));
                    sbuf.append(codes.charAt(2 * power + (digit + 1) / 5));
                } else {
                    int rest = digit;
                    if (rest >= 5) {
                        sbuf.append(codes.charAt(2 * power + 1));
                        rest -= 5;
                    }
                    while (--rest >= 0) {
                        sbuf.append(codes.charAt(2 * power));
                    }
                }
            }
            unit /= 10;
        }
        return sbuf.toString();
    }

    public static String format(int num) {
        return RomanIntegerFormat.format(num, false);
    }

    @Override
    public StringBuffer format(long num, StringBuffer sbuf, FieldPosition fpos) {
        String str = num > 0L && num < (long)(this.oldStyle ? 4999 : 3999) ? RomanIntegerFormat.format((int)num, this.oldStyle) : Long.toString(num);
        if (fpos != null) {
            int len;
            long tval = 1L;
            int i = len = str.length();
            while (--i > 0) {
                tval = 10L * tval + 9L;
            }
            StringBuffer tbuf = new StringBuffer(len);
            new DecimalFormat("0").format(tval, tbuf, fpos);
        }
        sbuf.append(str);
        return sbuf;
    }

    @Override
    public StringBuffer format(double num, StringBuffer sbuf, FieldPosition fpos) {
        long inum = (long)num;
        if ((double)inum == num) {
            return this.format(inum, sbuf, fpos);
        }
        sbuf.append(Double.toString(num));
        return sbuf;
    }

    @Override
    public Number parse(String text, ParsePosition status) {
        throw new Error("RomanIntegerFormat.parseObject - not implemented");
    }
}

