// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.math.BigDecimal;

public abstract class RealNum extends Complex implements Comparable
{
    @Override
    public final RealNum re() {
        return this;
    }
    
    @Override
    public final RealNum im() {
        return IntNum.zero();
    }
    
    @Override
    public final RealNum angle() {
        return this.isNegative() ? DFloNum.valueOf(3.141592653589793) : DFloNum.zero();
    }
    
    @Override
    public final Quaternion vectorPart() {
        return IntNum.zero();
    }
    
    @Override
    public final Quaternion unitVector() {
        return IntNum.zero();
    }
    
    @Override
    public final Quaternion unitQuaternion() {
        switch (this.sign()) {
            case 1: {
                return IntNum.one();
            }
            case 0: {
                return IntNum.zero();
            }
            case -1: {
                return IntNum.minusOne();
            }
            default: {
                return this;
            }
        }
    }
    
    @Override
    public final Quaternion conjugate() {
        return this;
    }
    
    public static boolean isReal(final Object value) {
        return value instanceof Number && (value instanceof RealNum || !(value instanceof Numeric));
    }
    
    public static RealNum asRealNumOrNull(final Object value) {
        if (value instanceof RealNum) {
            return (RealNum)value;
        }
        if (value instanceof Float || value instanceof Double) {
            return new DFloNum(((Number)value).doubleValue());
        }
        return RatNum.asRatNumOrNull(value);
    }
    
    public abstract boolean isNegative();
    
    @Override
    public int classifyFinite() {
        final double d = this.doubleValue();
        return Double.isNaN(d) ? -1 : (Double.isInfinite(d) ? 0 : 1);
    }
    
    public abstract int sign();
    
    public RealNum max(final RealNum x) {
        final boolean exact = this.isExact() && x.isExact();
        RealNum result = this.grt(x) ? this : x;
        if (!exact && result.isExact()) {
            result = new DFloNum(result.doubleValue());
        }
        return result;
    }
    
    public RealNum min(final RealNum x) {
        final boolean exact = this.isExact() && x.isExact();
        RealNum result = this.grt(x) ? x : this;
        if (!exact && result.isExact()) {
            result = new DFloNum(result.doubleValue());
        }
        return result;
    }
    
    public static RealNum add(final RealNum x, final RealNum y, final int k) {
        return (RealNum)x.add(y, k);
    }
    
    public static RealNum times(final RealNum x, final RealNum y) {
        return (RealNum)x.mul(y);
    }
    
    public static RealNum divide(final RealNum x, final RealNum y) {
        return (RealNum)x.div(y);
    }
    
    @Override
    public abstract Numeric add(final Object p0, final int p1);
    
    @Override
    public abstract Numeric mul(final Object p0);
    
    @Override
    public abstract Numeric div(final Object p0);
    
    @Override
    public Numeric abs() {
        return this.isNegative() ? this.neg() : this;
    }
    
    public RealNum rneg() {
        return (RealNum)this.neg();
    }
    
    @Override
    public boolean isZero() {
        return this.sign() == 0;
    }
    
    @Override
    public RatNum toExact() {
        return DFloNum.toExact(this.doubleValue());
    }
    
    @Override
    public RealNum toInexact() {
        if (this.isExact()) {
            return new DFloNum(this.doubleValue());
        }
        return this;
    }
    
    public static double toInt(final double d, final int rounding_mode) {
        switch (rounding_mode) {
            case 1: {
                return Math.floor(d);
            }
            case 2: {
                return Math.ceil(d);
            }
            case 3: {
                return (d < 0.0) ? Math.ceil(d) : Math.floor(d);
            }
            case 4: {
                return Math.rint(d);
            }
            default: {
                return d;
            }
        }
    }
    
    public RealNum toInt(final int rounding_mode) {
        return new DFloNum(toInt(this.doubleValue(), rounding_mode));
    }
    
    public IntNum toExactInt(final int rounding_mode) {
        return toExactInt(this.doubleValue(), rounding_mode);
    }
    
    public static IntNum toExactInt(final double value, final int rounding_mode) {
        return toExactInt(toInt(value, rounding_mode));
    }
    
    public static IntNum toExactInt(final double value) {
        if (Double.isInfinite(value) || Double.isNaN(value)) {
            throw new ArithmeticException("cannot convert " + value + " to exact integer");
        }
        long bits = Double.doubleToLongBits(value);
        final boolean neg = bits < 0L;
        final int exp = (int)(bits >> 52) & 0x7FF;
        bits &= 0xFFFFFFFFFFFFFL;
        if (exp == 0) {
            bits <<= 1;
        }
        else {
            bits |= 0x10000000000000L;
        }
        if (exp > 1075) {
            return IntNum.shift(IntNum.make(neg ? (-bits) : bits), exp - 1075);
        }
        final int rshift = 1075 - exp;
        if (rshift > 53) {
            return IntNum.zero();
        }
        bits >>= rshift;
        return IntNum.make(neg ? (-bits) : bits);
    }
    
    @Override
    public Complex exp() {
        return new DFloNum(Math.exp(this.doubleValue()));
    }
    
    @Override
    public Complex log() {
        final double x = this.doubleValue();
        if (x <= 0.0) {
            return DComplex.log(x, 0.0);
        }
        return new DFloNum(Math.log(x));
    }
    
    @Override
    public final RealNum sin() {
        return new DFloNum(Math.sin(this.doubleValue()));
    }
    
    @Override
    public final RealNum cos() {
        return new DFloNum(Math.cos(this.doubleValue()));
    }
    
    @Override
    public final RealNum tan() {
        return new DFloNum(Math.tan(this.doubleValue()));
    }
    
    @Override
    public final Complex sqrt() {
        final double d = this.doubleValue();
        if (d >= 0.0) {
            return new DFloNum(Math.sqrt(d));
        }
        return Complex.make(IntNum.zero(), new DFloNum(Math.sqrt(-d)));
    }
    
    public static IntNum toScaledInt(final double f, final int k) {
        return toScaledInt(DFloNum.toExact(f), k);
    }
    
    public static IntNum toScaledInt(RatNum r, final int k) {
        if (k != 0) {
            final IntNum power = IntNum.power(IntNum.ten(), (k < 0) ? (-k) : k);
            IntNum num = r.numerator();
            IntNum den = r.denominator();
            if (k >= 0) {
                num = IntNum.times(num, power);
            }
            else {
                den = IntNum.times(den, power);
            }
            r = RatNum.make(num, den);
        }
        return r.toExactInt(4);
    }
    
    public IntNum toScaledInt(final int k) {
        return toScaledInt(this.toExact(), k);
    }
    
    @Override
    public int compareTo(final Object o) {
        return this.compare(o);
    }
    
    public BigDecimal asBigDecimal() {
        return new BigDecimal(this.doubleValue());
    }
    
    public static String toStringScientific(final float d) {
        return toStringScientific(Float.toString(d));
    }
    
    public static String toStringScientific(final double d) {
        return toStringScientific(Double.toString(d));
    }
    
    public static String toStringScientific(final String dstr) {
        final int indexE = dstr.indexOf(69);
        if (indexE >= 0) {
            return dstr;
        }
        final int len = dstr.length();
        final char ch = dstr.charAt(len - 1);
        if (ch == 'y' || ch == 'N') {
            return dstr;
        }
        final StringBuffer sbuf = new StringBuffer(len + 10);
        final int exp = toStringScientific(dstr, sbuf);
        sbuf.append('E');
        sbuf.append(exp);
        return sbuf.toString();
    }
    
    public static int toStringScientific(final String dstr, final StringBuffer sbuf) {
        final boolean neg = dstr.charAt(0) == '-';
        if (neg) {
            sbuf.append('-');
        }
        int pos = neg ? 1 : 0;
        final int len = dstr.length();
        int exp = 0;
        Label_0274: {
            if (dstr.charAt(pos) == '0') {
                final int start = pos;
                while (pos != len) {
                    final char ch = dstr.charAt(pos++);
                    if (ch >= '0' && ch <= '9' && (ch != '0' || pos == len)) {
                        sbuf.append(ch);
                        sbuf.append('.');
                        exp = ((ch == '0') ? 0 : (start - pos + 2));
                        if (pos == len) {
                            sbuf.append('0');
                        }
                        else {
                            while (pos < len) {
                                sbuf.append(dstr.charAt(pos++));
                            }
                        }
                        break Label_0274;
                    }
                }
                sbuf.append("0");
                exp = 0;
            }
            else {
                final int ndigits = len - (neg ? 2 : 1);
                final int dot = dstr.indexOf(46);
                exp = ndigits - len + dot;
                sbuf.append(dstr.charAt(pos++));
                sbuf.append('.');
                while (pos < len) {
                    final char ch2 = dstr.charAt(pos++);
                    if (ch2 != '.') {
                        sbuf.append(ch2);
                    }
                }
            }
        }
        pos = sbuf.length();
        int slen = -1;
        char ch;
        while (true) {
            ch = sbuf.charAt(--pos);
            if (ch != '0') {
                break;
            }
            slen = pos;
        }
        if (ch == '.') {
            slen = pos + 2;
        }
        if (slen >= 0) {
            sbuf.setLength(slen);
        }
        return exp;
    }
    
    public static String toStringDecimal(final String dstr) {
        final int indexE = dstr.indexOf(69);
        if (indexE < 0) {
            return dstr;
        }
        final int len = dstr.length();
        char ch = dstr.charAt(len - 1);
        if (ch == 'y' || ch == 'N') {
            return dstr;
        }
        final StringBuffer sbuf = new StringBuffer(len + 10);
        final boolean neg = dstr.charAt(0) == '-';
        if (dstr.charAt(indexE + 1) != '-') {
            throw new UnsupportedOperationException("not implemented: toStringDecimal given non-negative exponent: " + dstr);
        }
        int pos;
        int exp;
        for (pos = indexE + 2, exp = 0; pos < len; exp = 10 * exp + (dstr.charAt(pos++) - '0')) {}
        if (neg) {
            sbuf.append('-');
        }
        sbuf.append("0.");
        while (--exp > 0) {
            sbuf.append('0');
        }
        pos = 0;
        while ((ch = dstr.charAt(pos++)) != 'E') {
            if ((ch != '-' & ch != '.') && (ch != '0' || pos < indexE)) {
                sbuf.append(ch);
            }
        }
        return sbuf.toString();
    }
}
