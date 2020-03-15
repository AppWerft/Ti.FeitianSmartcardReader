// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.format;

import java.text.ParsePosition;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;

public class RomanIntegerFormat extends NumberFormat
{
    private static RomanIntegerFormat newRoman;
    private static RomanIntegerFormat oldRoman;
    public boolean oldStyle;
    static final String codes = "IVXLCDM";
    
    public RomanIntegerFormat(final boolean oldStyle) {
        this.oldStyle = oldStyle;
    }
    
    public RomanIntegerFormat() {
    }
    
    public static RomanIntegerFormat getInstance(final boolean oldStyle) {
        if (oldStyle) {
            if (RomanIntegerFormat.oldRoman == null) {
                RomanIntegerFormat.oldRoman = new RomanIntegerFormat(true);
            }
            return RomanIntegerFormat.oldRoman;
        }
        if (RomanIntegerFormat.newRoman == null) {
            RomanIntegerFormat.newRoman = new RomanIntegerFormat(false);
        }
        return RomanIntegerFormat.newRoman;
    }
    
    public static String format(int num, final boolean oldStyle) {
        if (num <= 0 || num >= 4999) {
            return Integer.toString(num);
        }
        final StringBuffer sbuf = new StringBuffer(20);
        int power = 3;
        int unit = 1000;
        while (power >= 0) {
            final int digit = num / unit;
            num -= digit * unit;
            if (digit != 0) {
                if (!oldStyle && (digit == 4 || digit == 9)) {
                    sbuf.append("IVXLCDM".charAt(2 * power));
                    sbuf.append("IVXLCDM".charAt(2 * power + (digit + 1) / 5));
                }
                else {
                    int rest = digit;
                    if (rest >= 5) {
                        sbuf.append("IVXLCDM".charAt(2 * power + 1));
                        rest -= 5;
                    }
                    while (--rest >= 0) {
                        sbuf.append("IVXLCDM".charAt(2 * power));
                    }
                }
            }
            unit /= 10;
            --power;
        }
        return sbuf.toString();
    }
    
    public static String format(final int num) {
        return format(num, false);
    }
    
    @Override
    public StringBuffer format(final long num, final StringBuffer sbuf, final FieldPosition fpos) {
        String str;
        if (num > 0L && num < (this.oldStyle ? 4999 : 3999)) {
            str = format((int)num, this.oldStyle);
        }
        else {
            str = Long.toString(num);
        }
        if (fpos != null) {
            long tval = 1L;
            int i;
            final int len = i = str.length();
            while (--i > 0) {
                tval = 10L * tval + 9L;
            }
            final StringBuffer tbuf = new StringBuffer(len);
            new DecimalFormat("0").format(tval, tbuf, fpos);
        }
        sbuf.append(str);
        return sbuf;
    }
    
    @Override
    public StringBuffer format(final double num, final StringBuffer sbuf, final FieldPosition fpos) {
        final long inum = (long)num;
        if (inum == num) {
            return this.format(inum, sbuf, fpos);
        }
        sbuf.append(Double.toString(num));
        return sbuf;
    }
    
    @Override
    public Number parse(final String text, final ParsePosition status) {
        throw new Error("RomanIntegerFormat.parseObject - not implemented");
    }
}
