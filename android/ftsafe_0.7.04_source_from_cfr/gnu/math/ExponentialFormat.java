/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.RealNum;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class ExponentialFormat
extends Format {
    public int fracDigits = -1;
    public int intDigits;
    public int expDigits;
    public char overflowChar;
    public char padChar;
    public char exponentChar = (char)69;
    public boolean exponentShowSign;
    public boolean showPlus;
    public boolean general;
    public char style;
    public int width;
    static final double LOG10 = Math.log(10.0);

    static boolean addOne(StringBuffer sbuf, int digStart, int digEnd) {
        int j = digEnd;
        do {
            char ch;
            if (j == digStart) {
                sbuf.insert(j, '1');
                return true;
            }
            if ((ch = sbuf.charAt(--j)) != '9') {
                sbuf.setCharAt(j, (char)(ch + '\u0001'));
                return false;
            }
            sbuf.setCharAt(j, '0');
        } while (true);
    }

    public StringBuffer format(float value, StringBuffer sbuf, FieldPosition fpos) {
        return this.format(value, this.fracDigits < 0 ? Float.toString(value) : null, sbuf, fpos);
    }

    public StringBuffer format(double value, StringBuffer sbuf, FieldPosition fpos) {
        return this.format(value, this.fracDigits < 0 ? Double.toString(value) : null, sbuf, fpos);
    }

    StringBuffer format(double value, String dstr, StringBuffer sbuf, FieldPosition fpos) {
        block47 : {
            int i;
            int oldLen;
            block46 : {
                boolean fracUnspecified;
                boolean negative;
                boolean addOne;
                int exponent;
                int scale;
                int exponentLen;
                int exponentAbs;
                boolean nonFinite;
                int digits;
                int newLen;
                int k = this.intDigits;
                int d = this.fracDigits;
                boolean bl = negative = value < 0.0;
                if (negative) {
                    value = -value;
                }
                oldLen = sbuf.length();
                int signLen = 1;
                if (negative) {
                    if (d >= 0) {
                        sbuf.append('-');
                    }
                } else if (this.showPlus) {
                    sbuf.append('+');
                } else {
                    signLen = 0;
                }
                int digStart = sbuf.length();
                boolean bl2 = nonFinite = Double.isNaN(value) || Double.isInfinite(value);
                if (d < 0 || nonFinite) {
                    int indexE;
                    if (dstr == null) {
                        dstr = Double.toString(value);
                    }
                    if ((indexE = dstr.indexOf(69)) >= 0) {
                        sbuf.append(dstr);
                        boolean negexp = dstr.charAt((indexE += digStart) + 1) == '-';
                        exponent = 0;
                        for (int i2 = indexE + (negexp != false ? 2 : 1); i2 < sbuf.length(); ++i2) {
                            exponent = 10 * exponent + (sbuf.charAt(i2) - 48);
                        }
                        if (negexp) {
                            exponent = -exponent;
                        }
                        sbuf.setLength(indexE);
                    } else {
                        exponent = RealNum.toStringScientific(dstr, sbuf);
                    }
                    if (negative) {
                        ++digStart;
                    }
                    int dot = digStart + 1;
                    sbuf.deleteCharAt(dot);
                    digits = sbuf.length() - digStart;
                    if (digits > 1 && sbuf.charAt(digStart + digits - 1) == '0') {
                        sbuf.setLength(digStart + --digits);
                    }
                    scale = digits - exponent - 1;
                } else {
                    digits = d + (k > 0 ? 1 : k);
                    int log = (int)(Math.log(value) / LOG10 + 1000.0);
                    log = log == Integer.MIN_VALUE ? 0 : (log -= 1000);
                    scale = digits - log - 1;
                    RealNum.toScaledInt(value, scale).format(10, sbuf);
                    exponent = digits - 1 - scale;
                }
                int n = exponentAbs = (exponent -= k - 1) < 0 ? -exponent : exponent;
                int n2 = exponentAbs >= 1000 ? 4 : (exponentAbs >= 100 ? 3 : (exponentLen = exponentAbs >= 10 ? 2 : 1));
                if (this.expDigits > exponentLen) {
                    exponentLen = this.expDigits;
                }
                boolean showExponent = true;
                int ee = !this.general ? 0 : (this.expDigits > 0 ? this.expDigits + 2 : 4);
                boolean bl3 = fracUnspecified = d < 0;
                if (this.general || fracUnspecified) {
                    int n3 = digits - scale;
                    if (fracUnspecified) {
                        int n4 = d = n3 < 7 ? n3 : 7;
                        if (digits > d) {
                            d = digits;
                        }
                    }
                    int dd = d - n3;
                    if (this.general && n3 >= 0 && dd >= 0) {
                        digits = d;
                        k = n3;
                        showExponent = false;
                    } else if (fracUnspecified) {
                        if (this.width <= 0) {
                            digits = d;
                        } else {
                            int avail;
                            digits = avail = this.width - signLen - exponentLen - 3;
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
                int nextDigit = digEnd == sbuf.length() ? 48 : (int)sbuf.charAt(digEnd);
                boolean bl4 = addOne = nextDigit >= 53;
                if (addOne && ExponentialFormat.addOne(sbuf, digStart, digEnd)) {
                    ++scale;
                }
                scale -= sbuf.length() - digEnd;
                sbuf.setLength(digEnd);
                int dot = digStart;
                if (k < 0) {
                    int j = k;
                    while (++j <= 0) {
                        sbuf.insert(digStart, '0');
                    }
                } else {
                    while (digStart + k > digEnd) {
                        sbuf.append('0');
                        ++digEnd;
                    }
                    dot += k;
                }
                if (nonFinite) {
                    showExponent = false;
                } else {
                    sbuf.insert(dot, '.');
                }
                if (showExponent) {
                    sbuf.append(this.exponentChar);
                    if (this.exponentShowSign || exponent < 0) {
                        sbuf.append(exponent >= 0 ? (char)'+' : '-');
                    }
                    i = sbuf.length();
                    sbuf.append(exponentAbs);
                    newLen = sbuf.length();
                    int j = this.expDigits - (newLen - i);
                    if (j > 0) {
                        newLen += j;
                        while (--j >= 0) {
                            sbuf.insert(i, '0');
                        }
                    }
                } else {
                    exponentLen = 0;
                }
                newLen = sbuf.length();
                int used = newLen - oldLen;
                i = this.width - used;
                if (!(!fracUnspecified || dot + 1 != sbuf.length() && sbuf.charAt(dot + 1) != this.exponentChar || this.width > 0 && i <= 0)) {
                    --i;
                    sbuf.insert(dot + 1, '0');
                }
                if (i < 0 && this.width > 0 || showExponent && exponentLen > this.expDigits && this.expDigits > 0 && this.overflowChar != '\u0000') break block46;
                if (k <= 0 && (i > 0 || this.width <= 0)) {
                    sbuf.insert(digStart, '0');
                    --i;
                }
                if (!showExponent && this.style == 'L') {
                    while (--ee >= 0) {
                        sbuf.append(' ');
                        --i;
                    }
                }
                while (--i >= 0) {
                    sbuf.insert(oldLen, this.padChar);
                }
                break block47;
            }
            if (this.overflowChar == '\u0000') break block47;
            sbuf.setLength(oldLen);
            i = this.width;
            while (--i >= 0) {
                sbuf.append(this.overflowChar);
            }
        }
        return sbuf;
    }

    public StringBuffer format(long num, StringBuffer sbuf, FieldPosition fpos) {
        return this.format((double)num, sbuf, fpos);
    }

    @Override
    public StringBuffer format(Object num, StringBuffer sbuf, FieldPosition fpos) {
        return this.format(((Number)num).doubleValue(), sbuf, fpos);
    }

    public Number parse(String text, ParsePosition status) {
        throw new UnsupportedOperationException("ExponentialFormat.parse - not implemented");
    }

    @Override
    public Object parseObject(String text, ParsePosition status) {
        throw new UnsupportedOperationException("ExponentialFormat.parseObject - not implemented");
    }
}

