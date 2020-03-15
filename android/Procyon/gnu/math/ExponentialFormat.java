// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.text.ParsePosition;
import java.text.FieldPosition;
import java.text.Format;

public class ExponentialFormat extends Format
{
    public int fracDigits;
    public int intDigits;
    public int expDigits;
    public char overflowChar;
    public char padChar;
    public char exponentChar;
    public boolean exponentShowSign;
    public boolean showPlus;
    public boolean general;
    public char style;
    public int width;
    static final double LOG10;
    
    public ExponentialFormat() {
        this.fracDigits = -1;
        this.exponentChar = 'E';
    }
    
    static boolean addOne(final StringBuffer sbuf, final int digStart, final int digEnd) {
        int j = digEnd;
        while (j != digStart) {
            final char ch = sbuf.charAt(--j);
            if (ch != '9') {
                sbuf.setCharAt(j, (char)(ch + '\u0001'));
                return false;
            }
            sbuf.setCharAt(j, '0');
        }
        sbuf.insert(j, '1');
        return true;
    }
    
    public StringBuffer format(final float value, final StringBuffer sbuf, final FieldPosition fpos) {
        return this.format(value, (this.fracDigits < 0) ? Float.toString(value) : null, sbuf, fpos);
    }
    
    public StringBuffer format(final double value, final StringBuffer sbuf, final FieldPosition fpos) {
        return this.format(value, (this.fracDigits < 0) ? Double.toString(value) : null, sbuf, fpos);
    }
    
    StringBuffer format(double value, String dstr, final StringBuffer sbuf, final FieldPosition fpos) {
        int k = this.intDigits;
        int d = this.fracDigits;
        final boolean negative = value < 0.0;
        if (negative) {
            value = -value;
        }
        final int oldLen = sbuf.length();
        int signLen = 1;
        if (negative) {
            if (d >= 0) {
                sbuf.append('-');
            }
        }
        else if (this.showPlus) {
            sbuf.append('+');
        }
        else {
            signLen = 0;
        }
        int digStart = sbuf.length();
        final boolean nonFinite = Double.isNaN(value) || Double.isInfinite(value);
        int exponent;
        int digits;
        int scale;
        if (d < 0 || nonFinite) {
            if (dstr == null) {
                dstr = Double.toString(value);
            }
            int indexE = dstr.indexOf(69);
            if (indexE >= 0) {
                sbuf.append(dstr);
                indexE += digStart;
                final boolean negexp = dstr.charAt(indexE + 1) == '-';
                exponent = 0;
                for (int i = indexE + (negexp ? 2 : 1); i < sbuf.length(); ++i) {
                    exponent = 10 * exponent + (sbuf.charAt(i) - '0');
                }
                if (negexp) {
                    exponent = -exponent;
                }
                sbuf.setLength(indexE);
            }
            else {
                exponent = RealNum.toStringScientific(dstr, sbuf);
            }
            if (negative) {
                ++digStart;
            }
            final int dot = digStart + 1;
            sbuf.deleteCharAt(dot);
            digits = sbuf.length() - digStart;
            if (digits > 1 && sbuf.charAt(digStart + digits - 1) == '0') {
                sbuf.setLength(digStart + --digits);
            }
            scale = digits - exponent - 1;
        }
        else {
            digits = d + ((k > 0) ? 1 : k);
            int log = (int)(Math.log(value) / ExponentialFormat.LOG10 + 1000.0);
            if (log == Integer.MIN_VALUE) {
                log = 0;
            }
            else {
                log -= 1000;
            }
            scale = digits - log - 1;
            RealNum.toScaledInt(value, scale).format(10, sbuf);
            exponent = digits - 1 - scale;
        }
        exponent -= k - 1;
        final int exponentAbs = (exponent < 0) ? (-exponent) : exponent;
        int exponentLen = (exponentAbs >= 1000) ? 4 : ((exponentAbs >= 100) ? 3 : ((exponentAbs >= 10) ? 2 : 1));
        if (this.expDigits > exponentLen) {
            exponentLen = this.expDigits;
        }
        boolean showExponent = true;
        int ee = this.general ? ((this.expDigits > 0) ? (this.expDigits + 2) : 4) : 0;
        final boolean fracUnspecified = d < 0;
        if (this.general || fracUnspecified) {
            final int n = digits - scale;
            if (fracUnspecified) {
                d = ((n < 7) ? n : 7);
                if (digits > d) {
                    d = digits;
                }
            }
            final int dd = d - n;
            if (this.general && n >= 0 && dd >= 0) {
                digits = d;
                k = n;
                showExponent = false;
            }
            else if (fracUnspecified) {
                if (this.width <= 0) {
                    digits = d;
                }
                else {
                    final int avail = digits = this.width - signLen - exponentLen - 3;
                    if (k < 0) {
                        digits -= k;
                    }
                    if (digits > d) {
                        digits = d;
                    }
                }
                if (digits <= 0) {
                    digits = 1;
                }
            }
        }
        int digEnd = digStart + digits;
        while (sbuf.length() < digEnd) {
            sbuf.append('0');
        }
        final char nextDigit = (digEnd == sbuf.length()) ? '0' : sbuf.charAt(digEnd);
        final boolean addOne = nextDigit >= '5';
        if (addOne && addOne(sbuf, digStart, digEnd)) {
            ++scale;
        }
        scale -= sbuf.length() - digEnd;
        sbuf.setLength(digEnd);
        int dot2 = digStart;
        if (k < 0) {
            int j = k;
            while (++j <= 0) {
                sbuf.insert(digStart, '0');
            }
        }
        else {
            while (digStart + k > digEnd) {
                sbuf.append('0');
                ++digEnd;
            }
            dot2 += k;
        }
        if (nonFinite) {
            showExponent = false;
        }
        else {
            sbuf.insert(dot2, '.');
        }
        if (showExponent) {
            sbuf.append(this.exponentChar);
            if (this.exponentShowSign || exponent < 0) {
                sbuf.append((exponent >= 0) ? '+' : '-');
            }
            final int l = sbuf.length();
            sbuf.append(exponentAbs);
            int newLen = sbuf.length();
            int m = this.expDigits - (newLen - l);
            if (m > 0) {
                newLen += m;
                while (--m >= 0) {
                    sbuf.insert(l, '0');
                }
            }
        }
        else {
            exponentLen = 0;
        }
        int newLen = sbuf.length();
        final int used = newLen - oldLen;
        int l = this.width - used;
        if (fracUnspecified && (dot2 + 1 == sbuf.length() || sbuf.charAt(dot2 + 1) == this.exponentChar) && (this.width <= 0 || l > 0)) {
            --l;
            sbuf.insert(dot2 + 1, '0');
        }
        if ((l >= 0 || this.width <= 0) && (!showExponent || exponentLen <= this.expDigits || this.expDigits <= 0 || this.overflowChar == '\0')) {
            if (k <= 0 && (l > 0 || this.width <= 0)) {
                sbuf.insert(digStart, '0');
                --l;
            }
            if (!showExponent && this.style == 'L') {
                while (--ee >= 0) {
                    sbuf.append(' ');
                    --l;
                }
            }
            while (--l >= 0) {
                sbuf.insert(oldLen, this.padChar);
            }
        }
        else if (this.overflowChar != '\0') {
            sbuf.setLength(oldLen);
            l = this.width;
            while (--l >= 0) {
                sbuf.append(this.overflowChar);
            }
        }
        return sbuf;
    }
    
    public StringBuffer format(final long num, final StringBuffer sbuf, final FieldPosition fpos) {
        return this.format((double)num, sbuf, fpos);
    }
    
    @Override
    public StringBuffer format(final Object num, final StringBuffer sbuf, final FieldPosition fpos) {
        return this.format(((Number)num).doubleValue(), sbuf, fpos);
    }
    
    public Number parse(final String text, final ParsePosition status) {
        throw new UnsupportedOperationException("ExponentialFormat.parse - not implemented");
    }
    
    @Override
    public Object parseObject(final String text, final ParsePosition status) {
        throw new UnsupportedOperationException("ExponentialFormat.parseObject - not implemented");
    }
    
    static {
        LOG10 = Math.log(10.0);
    }
}
