/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.Complex;
import gnu.math.DComplex;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.Quaternion;
import gnu.math.RatNum;
import java.math.BigDecimal;

public abstract class RealNum
extends Complex
implements Comparable {
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
        }
        return this;
    }

    @Override
    public final Quaternion conjugate() {
        return this;
    }

    public static boolean isReal(Object value) {
        return value instanceof Number && (value instanceof RealNum || !(value instanceof Numeric));
    }

    public static RealNum asRealNumOrNull(Object value) {
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
        double d = this.doubleValue();
        return Double.isNaN(d) ? -1 : (Double.isInfinite(d) ? 0 : 1);
    }

    public abstract int sign();

    public RealNum max(RealNum x) {
        RealNum result;
        boolean exact = this.isExact() && x.isExact();
        RealNum realNum = result = this.grt(x) ? this : x;
        if (!exact && result.isExact()) {
            result = new DFloNum(result.doubleValue());
        }
        return result;
    }

    public RealNum min(RealNum x) {
        RealNum result;
        boolean exact = this.isExact() && x.isExact();
        RealNum realNum = result = this.grt(x) ? x : this;
        if (!exact && result.isExact()) {
            result = new DFloNum(result.doubleValue());
        }
        return result;
    }

    public static RealNum add(RealNum x, RealNum y, int k) {
        return (RealNum)x.add(y, k);
    }

    public static RealNum times(RealNum x, RealNum y) {
        return (RealNum)x.mul(y);
    }

    public static RealNum divide(RealNum x, RealNum y) {
        return (RealNum)x.div(y);
    }

    @Override
    public abstract Numeric add(Object var1, int var2);

    @Override
    public abstract Numeric mul(Object var1);

    @Override
    public abstract Numeric div(Object var1);

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

    public static double toInt(double d, int rounding_mode) {
        switch (rounding_mode) {
            case 1: {
                return Math.floor(d);
            }
            case 2: {
                return Math.ceil(d);
            }
            case 3: {
                return d < 0.0 ? Math.ceil(d) : Math.floor(d);
            }
            case 4: {
                return Math.rint(d);
            }
        }
        return d;
    }

    public RealNum toInt(int rounding_mode) {
        return new DFloNum(RealNum.toInt(this.doubleValue(), rounding_mode));
    }

    public IntNum toExactInt(int rounding_mode) {
        return RealNum.toExactInt(this.doubleValue(), rounding_mode);
    }

    public static IntNum toExactInt(double value, int rounding_mode) {
        return RealNum.toExactInt(RealNum.toInt(value, rounding_mode));
    }

    public static IntNum toExactInt(double value) {
        if (Double.isInfinite(value) || Double.isNaN(value)) {
            throw new ArithmeticException("cannot convert " + value + " to exact integer");
        }
        long bits = Double.doubleToLongBits(value);
        boolean neg = bits < 0L;
        int exp = (int)(bits >> 52) & 2047;
        bits &= 0xFFFFFFFFFFFFFL;
        bits = exp == 0 ? (bits <<= 1) : (bits |= 0x10000000000000L);
        if (exp <= 1075) {
            int rshift = 1075 - exp;
            if (rshift > 53) {
                return IntNum.zero();
            }
            return IntNum.make(neg ? -bits : (bits >>= rshift));
        }
        return IntNum.shift(IntNum.make(neg ? -bits : bits), exp - 1075);
    }

    @Override
    public Complex exp() {
        return new DFloNum(Math.exp(this.doubleValue()));
    }

    @Override
    public Complex log() {
        double x = this.doubleValue();
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
        double d = this.doubleValue();
        if (d >= 0.0) {
            return new DFloNum(Math.sqrt(d));
        }
        return Complex.make(IntNum.zero(), new DFloNum(Math.sqrt(-d)));
    }

    public static IntNum toScaledInt(double f, int k) {
        return RealNum.toScaledInt(DFloNum.toExact(f), k);
    }

    public static IntNum toScaledInt(RatNum r, int k) {
        if (k != 0) {
            IntNum power = IntNum.power(IntNum.ten(), k < 0 ? -k : k);
            IntNum num = r.numerator();
            IntNum den = r.denominator();
            if (k >= 0) {
                num = IntNum.times(num, power);
            } else {
                den = IntNum.times(den, power);
            }
            r = RatNum.make(num, den);
        }
        return r.toExactInt(4);
    }

    public IntNum toScaledInt(int k) {
        return RealNum.toScaledInt(this.toExact(), k);
    }

    public int compareTo(Object o) {
        return this.compare(o);
    }

    public BigDecimal asBigDecimal() {
        return new BigDecimal(this.doubleValue());
    }

    public static String toStringScientific(float d) {
        return RealNum.toStringScientific(Float.toString(d));
    }

    public static String toStringScientific(double d) {
        return RealNum.toStringScientific(Double.toString(d));
    }

    public static String toStringScientific(String dstr) {
        int indexE = dstr.indexOf(69);
        if (indexE >= 0) {
            return dstr;
        }
        int len = dstr.length();
        char ch = dstr.charAt(len - 1);
        if (ch == 'y' || ch == 'N') {
            return dstr;
        }
        StringBuffer sbuf = new StringBuffer(len + 10);
        int exp = RealNum.toStringScientific(dstr, sbuf);
        sbuf.append('E');
        sbuf.append(exp);
        return sbuf.toString();
    }

    public static int toStringScientific(String dstr, StringBuffer sbuf) {
        char ch;
        int exp;
        int pos;
        block11 : {
            boolean neg;
            boolean bl = neg = dstr.charAt(0) == '-';
            if (neg) {
                sbuf.append('-');
            }
            pos = neg ? 1 : 0;
            int len = dstr.length();
            if (dstr.charAt(pos) == '0') {
                int start = pos;
                do {
                    if (pos != len) continue;
                    sbuf.append("0");
                    exp = 0;
                    break block11;
                } while ((ch = dstr.charAt(pos++)) < '0' || ch > '9' || ch == '0' && pos != len);
                sbuf.append(ch);
                sbuf.append('.');
                int n = exp = ch == '0' ? 0 : start - pos + 2;
                if (pos == len) {
                    sbuf.append('0');
                } else {
                    while (pos < len) {
                        sbuf.append(dstr.charAt(pos++));
                    }
                }
            } else {
                int ndigits = len - (neg ? 2 : 1);
                int dot = dstr.indexOf(46);
                exp = ndigits - len + dot;
                sbuf.append(dstr.charAt(pos++));
                sbuf.append('.');
                while (pos < len) {
                    char ch2;
                    if ((ch2 = dstr.charAt(pos++)) == '.') continue;
                    sbuf.append(ch2);
                }
            }
        }
        pos = sbuf.length();
        int slen = -1;
        while ((ch = sbuf.charAt(--pos)) == '0') {
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

    public static String toStringDecimal(String dstr) {
        boolean neg;
        int indexE = dstr.indexOf(69);
        if (indexE < 0) {
            return dstr;
        }
        int len = dstr.length();
        char ch = dstr.charAt(len - 1);
        if (ch == 'y' || ch == 'N') {
            return dstr;
        }
        StringBuffer sbuf = new StringBuffer(len + 10);
        boolean bl = neg = dstr.charAt(0) == '-';
        if (dstr.charAt(indexE + 1) != '-') {
            throw new UnsupportedOperationException("not implemented: toStringDecimal given non-negative exponent: " + dstr);
        }
        int pos = indexE + 2;
        int exp = 0;
        while (pos < len) {
            exp = 10 * exp + (dstr.charAt(pos++) - 48);
        }
        if (neg) {
            sbuf.append('-');
        }
        sbuf.append("0.");
        while (--exp > 0) {
            sbuf.append('0');
        }
        pos = 0;
        while ((ch = dstr.charAt(pos++)) != 'E') {
            if (!(ch != '-' & ch != '.') || ch == '0' && pos >= indexE) continue;
            sbuf.append(ch);
        }
        return sbuf.toString();
    }
}

