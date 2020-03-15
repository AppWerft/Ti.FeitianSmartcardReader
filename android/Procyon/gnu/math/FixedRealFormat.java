// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.text.ParsePosition;
import java.text.FieldPosition;
import java.text.Format;

public class FixedRealFormat extends Format
{
    private int i;
    private int d;
    public int width;
    public int scale;
    public char padChar;
    public boolean showPlus;
    public boolean internalPad;
    public char overflowChar;
    
    public int getMaximumFractionDigits() {
        return this.d;
    }
    
    public int getMinimumIntegerDigits() {
        return this.i;
    }
    
    public void setMaximumFractionDigits(final int d) {
        this.d = d;
    }
    
    public void setMinimumIntegerDigits(final int i) {
        this.i = i;
    }
    
    public void format(final RealNum number, final StringBuffer sbuf, final FieldPosition fpos) {
        final int decimals;
        if (number instanceof RatNum && (decimals = this.getMaximumFractionDigits()) >= 0) {
            RatNum ratnum = (RatNum)number;
            final boolean negative = ratnum.isNegative();
            if (negative) {
                ratnum = ratnum.rneg();
            }
            final int oldSize = sbuf.length();
            int signLen = 1;
            if (negative) {
                sbuf.append('-');
            }
            else if (this.showPlus) {
                sbuf.append('+');
            }
            else {
                signLen = 0;
            }
            final String string = RealNum.toScaledInt(ratnum, decimals + this.scale).toString();
            sbuf.append(string);
            final int length = string.length();
            final int digits = length - decimals;
            this.format(sbuf, fpos, length, digits, decimals, signLen, oldSize);
        }
        else {
            this.format(number.doubleValue(), sbuf, fpos);
        }
    }
    
    public StringBuffer format(final long num, final StringBuffer sbuf, final FieldPosition fpos) {
        this.format(IntNum.make(num), sbuf, fpos);
        return sbuf;
    }
    
    public StringBuffer format(double num, final StringBuffer sbuf, final FieldPosition fpos) {
        if (Double.isNaN(num) || Double.isInfinite(num)) {
            return sbuf.append(num);
        }
        if (this.getMaximumFractionDigits() >= 0) {
            this.format(DFloNum.toExact(num), sbuf, fpos);
        }
        else {
            boolean negative;
            if (num < 0.0) {
                negative = true;
                num = -num;
            }
            else {
                negative = false;
            }
            final int oldSize = sbuf.length();
            int signLen = 1;
            if (negative) {
                sbuf.append('-');
            }
            else if (this.showPlus) {
                sbuf.append('+');
            }
            else {
                signLen = 0;
            }
            String string = Double.toString(num);
            int cur_scale = this.scale;
            final int seenE = string.indexOf(69);
            if (seenE >= 0) {
                int expStart = seenE + 1;
                if (string.charAt(expStart) == '+') {
                    ++expStart;
                }
                cur_scale += Integer.parseInt(string.substring(expStart));
                string = string.substring(0, seenE);
            }
            final int seenDot = string.indexOf(46);
            int length = string.length();
            if (seenDot >= 0) {
                cur_scale -= length - seenDot - 1;
                --length;
                string = string.substring(0, seenDot) + string.substring(seenDot + 1);
            }
            int i;
            int initial_zeros;
            for (i = string.length(), initial_zeros = 0; initial_zeros < i - 1 && string.charAt(initial_zeros) == '0'; ++initial_zeros) {}
            if (initial_zeros > 0) {
                string = string.substring(initial_zeros);
                i -= initial_zeros;
            }
            int digits = i + cur_scale;
            int decimals;
            if (this.width > 0) {
                while (digits < 0) {
                    sbuf.append('0');
                    ++digits;
                    ++i;
                }
                decimals = this.width - signLen - 1 - digits;
            }
            else {
                decimals = ((i > 16) ? 16 : i) - digits;
            }
            if (decimals < 0) {
                decimals = 0;
            }
            sbuf.append(string);
            while (cur_scale > 0) {
                sbuf.append('0');
                --cur_scale;
                ++i;
            }
            final int digStart = oldSize + signLen;
            int digEnd = digStart + digits + decimals;
            i = sbuf.length();
            char nextDigit;
            if (digEnd >= i) {
                digEnd = i;
                nextDigit = '0';
            }
            else {
                nextDigit = sbuf.charAt(digEnd);
            }
            final boolean addOne = nextDigit >= '5';
            for (char skip = addOne ? '9' : '0'; digEnd > digStart + digits && sbuf.charAt(digEnd - 1) == skip; --digEnd) {}
            length = digEnd - digStart;
            decimals = length - digits;
            if (addOne && ExponentialFormat.addOne(sbuf, digStart, digEnd)) {
                ++digits;
                decimals = 0;
                length = digits;
            }
            if (decimals == 0 && (this.width <= 0 || signLen + digits + 1 < this.width)) {
                decimals = 1;
                ++length;
                sbuf.insert(digStart + digits, '0');
            }
            sbuf.setLength(digStart + length);
            this.format(sbuf, fpos, length, digits, decimals, negative ? 1 : 0, oldSize);
        }
        return sbuf;
    }
    
    @Override
    public StringBuffer format(final Object num, final StringBuffer sbuf, final FieldPosition fpos) {
        RealNum rnum = RealNum.asRealNumOrNull(num);
        if (rnum == null) {
            if (num instanceof Complex) {
                final String str = num.toString();
                int padding = this.width - str.length();
                while (--padding >= 0) {
                    sbuf.append(' ');
                }
                sbuf.append(str);
                return sbuf;
            }
            rnum = (RealNum)num;
        }
        return this.format(rnum.doubleValue(), sbuf, fpos);
    }
    
    private void format(final StringBuffer sbuf, final FieldPosition fpos, final int length, final int digits, final int decimals, final int signLen, final int oldSize) {
        final int total_digits = digits + decimals;
        int zero_digits = this.getMinimumIntegerDigits();
        if (digits >= 0 && digits > zero_digits) {
            zero_digits = 0;
        }
        else {
            zero_digits -= digits;
        }
        if (digits + zero_digits <= 0 && (this.width <= 0 || this.width > decimals + 1 + signLen)) {
            ++zero_digits;
        }
        final int needed = signLen + length + zero_digits + 1;
        int padding = this.width - needed;
        int i = zero_digits;
        while (--i >= 0) {
            sbuf.insert(oldSize + signLen, '0');
        }
        if (padding >= 0) {
            i = oldSize;
            if (this.internalPad && signLen > 0) {
                ++i;
            }
            while (--padding >= 0) {
                sbuf.insert(i, this.padChar);
            }
        }
        else if (this.overflowChar != '\0') {
            sbuf.setLength(oldSize);
            this.i = this.width;
            while (true) {
                final int j = this.i - 1;
                this.i = j;
                if (j < 0) {
                    break;
                }
                sbuf.append(this.overflowChar);
            }
            return;
        }
        final int newSize = sbuf.length();
        sbuf.insert(newSize - decimals, '.');
    }
    
    public Number parse(final String text, final ParsePosition status) {
        throw new UnsupportedOperationException("RealFixedFormat.parse - not implemented");
    }
    
    @Override
    public Object parseObject(final String text, final ParsePosition status) {
        throw new UnsupportedOperationException("RealFixedFormat.parseObject - not implemented");
    }
}
