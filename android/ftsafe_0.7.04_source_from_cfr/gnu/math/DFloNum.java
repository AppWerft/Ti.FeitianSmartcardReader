/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RatNum;
import gnu.math.RealNum;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class DFloNum
extends RealNum
implements Externalizable {
    double value;
    private static final DFloNum zero = new DFloNum(0.0);
    private static final DFloNum one = new DFloNum(1.0);

    public DFloNum() {
    }

    public DFloNum(double value) {
        this.value = value;
    }

    public DFloNum(String s) throws NumberFormatException {
        Double d = Double.valueOf(s);
        this.value = d;
        if (this.value == 0.0 && s.charAt(0) == '-') {
            this.value = -0.0;
        }
    }

    @Deprecated
    public static DFloNum make(double value) {
        return new DFloNum(value);
    }

    public static DFloNum valueOf(double value) {
        return new DFloNum(value);
    }

    public static DFloNum zero() {
        return zero;
    }

    public static DFloNum asDFloNumOrNull(Object value) {
        if (value instanceof DFloNum) {
            return (DFloNum)value;
        }
        if (RealNum.isReal(value)) {
            return new DFloNum(((Number)value).doubleValue());
        }
        return null;
    }

    @Override
    public final double doubleValue() {
        return this.value;
    }

    @Override
    public long longValue() {
        return (long)this.value;
    }

    public int hashCode() {
        long v = Double.doubleToLongBits(this.value);
        return (int)(v ^ v >>> 32);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof DFloNum && Double.doubleToLongBits(((DFloNum)obj).value) == Double.doubleToLongBits(this.value);
    }

    @Override
    public Numeric add(Object y, int k) {
        if (y instanceof RealNum) {
            return new DFloNum(this.value + (double)k * ((RealNum)y).doubleValue());
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).addReversed(this, k);
    }

    @Override
    public Numeric addReversed(Numeric x, int k) {
        if (x instanceof RealNum) {
            return new DFloNum(((RealNum)x).doubleValue() + (double)k * this.value);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Numeric mul(Object y) {
        if (y instanceof RealNum) {
            return new DFloNum(this.value * ((RealNum)y).doubleValue());
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).mulReversed(this);
    }

    @Override
    public Numeric mulReversed(Numeric x) {
        if (x instanceof RealNum) {
            return new DFloNum(((RealNum)x).doubleValue() * this.value);
        }
        throw new IllegalArgumentException();
    }

    public static final DFloNum one() {
        return one;
    }

    @Override
    public Numeric div(Object y) {
        if (y instanceof RealNum) {
            return new DFloNum(this.value / ((RealNum)y).doubleValue());
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).divReversed(this);
    }

    @Override
    public Numeric divReversed(Numeric x) {
        if (x instanceof RealNum) {
            return new DFloNum(((RealNum)x).doubleValue() / this.value);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Numeric power(IntNum y) {
        return new DFloNum(Math.pow(this.doubleValue(), y.doubleValue()));
    }

    @Override
    public boolean isNegative() {
        return this.value < 0.0;
    }

    @Override
    public Numeric neg() {
        return new DFloNum(-this.value);
    }

    @Override
    public int sign() {
        return this.value > 0.0 ? 1 : (this.value < 0.0 ? -1 : (this.value == 0.0 ? 0 : -2));
    }

    public static int compare(double x, double y) {
        return x > y ? 1 : (x < y ? -1 : (x == y ? 0 : -2));
    }

    public static int compare(IntNum x_num, IntNum x_den, double y) {
        if (Double.isNaN(y)) {
            return -2;
        }
        if (Double.isInfinite(y)) {
            int result;
            int n = result = y >= 0.0 ? -1 : 1;
            if (!x_den.isZero()) {
                return result;
            }
            if (x_num.isZero()) {
                return -2;
            }
            return x_num.isNegative() ? result : ~(result >>= 1);
        }
        long bits = Double.doubleToLongBits(y);
        boolean neg = bits < 0L;
        int exp = (int)(bits >> 52) & 2047;
        bits &= 0xFFFFFFFFFFFFFL;
        bits = exp == 0 ? (bits <<= 1) : (bits |= 0x10000000000000L);
        IntNum y_num = IntNum.make(neg ? -bits : bits);
        if (exp >= 1075) {
            y_num = IntNum.shift(y_num, exp - 1075);
        } else {
            x_num = IntNum.shift(x_num, 1075 - exp);
        }
        return IntNum.compare(x_num, IntNum.times(y_num, x_den));
    }

    @Override
    public int compare(Object obj) {
        if (obj instanceof RatNum) {
            RatNum y_rat = (RatNum)obj;
            int i = DFloNum.compare(y_rat.numerator(), y_rat.denominator(), this.value);
            return i < -1 ? i : -i;
        }
        if (obj instanceof RealNum) {
            return DFloNum.compare(this.value, ((RealNum)obj).doubleValue());
        }
        return ((Numeric)obj).compareReversed(this);
    }

    @Override
    public int compareReversed(Numeric x) {
        if (x instanceof RatNum) {
            RatNum x_rat = (RatNum)x;
            return DFloNum.compare(x_rat.numerator(), x_rat.denominator(), this.value);
        }
        return DFloNum.compare(((RealNum)x).doubleValue(), this.value);
    }

    @Override
    public boolean isExact() {
        return false;
    }

    @Override
    public boolean isZero() {
        return this.value == 0.0;
    }

    public static RatNum toExact(double value) {
        if (Double.isInfinite(value)) {
            return RatNum.infinity(value >= 0.0 ? 1 : -1);
        }
        if (Double.isNaN(value)) {
            throw new ArithmeticException("cannot convert NaN to exact rational");
        }
        long bits = Double.doubleToLongBits(value);
        boolean neg = bits < 0L;
        int exp = (int)(bits >> 52) & 2047;
        bits &= 0xFFFFFFFFFFFFFL;
        bits = exp == 0 ? (bits <<= 1) : (bits |= 0x10000000000000L);
        IntNum mant = IntNum.make(neg ? -bits : bits);
        if (exp >= 1075) {
            return IntNum.shift(mant, exp - 1075);
        }
        return RatNum.make(mant, IntNum.shift(IntNum.one(), 1075 - exp));
    }

    @Override
    public String toString() {
        return DFloNum.toString(this.value);
    }

    public static String toString(double value) {
        return value == Double.POSITIVE_INFINITY ? "+inf.0" : (value == Double.NEGATIVE_INFINITY ? "-inf.0" : (Double.isNaN(value) ? "+nan.0" : Double.toString(value)));
    }

    @Override
    public String toString(int radix) {
        if (radix == 10) {
            return this.toString();
        }
        return "#d" + this.toString();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(this.value);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.value = in.readDouble();
    }
}

