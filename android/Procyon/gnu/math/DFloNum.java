// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class DFloNum extends RealNum implements Externalizable
{
    double value;
    private static final DFloNum zero;
    private static final DFloNum one;
    
    public DFloNum() {
    }
    
    public DFloNum(final double value) {
        this.value = value;
    }
    
    public DFloNum(final String s) throws NumberFormatException {
        final Double d = Double.valueOf(s);
        this.value = d;
        if (this.value == 0.0 && s.charAt(0) == '-') {
            this.value = -0.0;
        }
    }
    
    @Deprecated
    public static DFloNum make(final double value) {
        return new DFloNum(value);
    }
    
    public static DFloNum valueOf(final double value) {
        return new DFloNum(value);
    }
    
    public static DFloNum zero() {
        return DFloNum.zero;
    }
    
    public static DFloNum asDFloNumOrNull(final Object value) {
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
    
    @Override
    public int hashCode() {
        final long v = Double.doubleToLongBits(this.value);
        return (int)(v ^ v >>> 32);
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj != null && obj instanceof DFloNum && Double.doubleToLongBits(((DFloNum)obj).value) == Double.doubleToLongBits(this.value);
    }
    
    @Override
    public Numeric add(final Object y, final int k) {
        if (y instanceof RealNum) {
            return new DFloNum(this.value + k * ((RealNum)y).doubleValue());
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).addReversed(this, k);
    }
    
    @Override
    public Numeric addReversed(final Numeric x, final int k) {
        if (x instanceof RealNum) {
            return new DFloNum(((RealNum)x).doubleValue() + k * this.value);
        }
        throw new IllegalArgumentException();
    }
    
    @Override
    public Numeric mul(final Object y) {
        if (y instanceof RealNum) {
            return new DFloNum(this.value * ((RealNum)y).doubleValue());
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).mulReversed(this);
    }
    
    @Override
    public Numeric mulReversed(final Numeric x) {
        if (x instanceof RealNum) {
            return new DFloNum(((RealNum)x).doubleValue() * this.value);
        }
        throw new IllegalArgumentException();
    }
    
    public static final DFloNum one() {
        return DFloNum.one;
    }
    
    @Override
    public Numeric div(final Object y) {
        if (y instanceof RealNum) {
            return new DFloNum(this.value / ((RealNum)y).doubleValue());
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).divReversed(this);
    }
    
    @Override
    public Numeric divReversed(final Numeric x) {
        if (x instanceof RealNum) {
            return new DFloNum(((RealNum)x).doubleValue() / this.value);
        }
        throw new IllegalArgumentException();
    }
    
    @Override
    public Numeric power(final IntNum y) {
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
        return (this.value > 0.0) ? 1 : ((this.value < 0.0) ? -1 : ((this.value == 0.0) ? 0 : -2));
    }
    
    public static int compare(final double x, final double y) {
        return (x > y) ? 1 : ((x < y) ? -1 : ((x == y) ? 0 : -2));
    }
    
    public static int compare(IntNum x_num, final IntNum x_den, final double y) {
        if (Double.isNaN(y)) {
            return -2;
        }
        if (!Double.isInfinite(y)) {
            long bits = Double.doubleToLongBits(y);
            final boolean neg = bits < 0L;
            final int exp = (int)(bits >> 52) & 0x7FF;
            bits &= 0xFFFFFFFFFFFFFL;
            if (exp == 0) {
                bits <<= 1;
            }
            else {
                bits |= 0x10000000000000L;
            }
            IntNum y_num = IntNum.make(neg ? (-bits) : bits);
            if (exp >= 1075) {
                y_num = IntNum.shift(y_num, exp - 1075);
            }
            else {
                x_num = IntNum.shift(x_num, 1075 - exp);
            }
            return IntNum.compare(x_num, IntNum.times(y_num, x_den));
        }
        int result = (y >= 0.0) ? -1 : 1;
        if (!x_den.isZero()) {
            return result;
        }
        if (x_num.isZero()) {
            return -2;
        }
        result >>= 1;
        return x_num.isNegative() ? result : (~result);
    }
    
    @Override
    public int compare(final Object obj) {
        if (obj instanceof RatNum) {
            final RatNum y_rat = (RatNum)obj;
            final int i = compare(y_rat.numerator(), y_rat.denominator(), this.value);
            return (i < -1) ? i : (-i);
        }
        if (obj instanceof RealNum) {
            return compare(this.value, ((RealNum)obj).doubleValue());
        }
        return ((Numeric)obj).compareReversed(this);
    }
    
    @Override
    public int compareReversed(final Numeric x) {
        if (x instanceof RatNum) {
            final RatNum x_rat = (RatNum)x;
            return compare(x_rat.numerator(), x_rat.denominator(), this.value);
        }
        return compare(((RealNum)x).doubleValue(), this.value);
    }
    
    @Override
    public boolean isExact() {
        return false;
    }
    
    @Override
    public boolean isZero() {
        return this.value == 0.0;
    }
    
    public static RatNum toExact(final double value) {
        if (Double.isInfinite(value)) {
            return RatNum.infinity((value >= 0.0) ? 1 : -1);
        }
        if (Double.isNaN(value)) {
            throw new ArithmeticException("cannot convert NaN to exact rational");
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
        final IntNum mant = IntNum.make(neg ? (-bits) : bits);
        if (exp >= 1075) {
            return IntNum.shift(mant, exp - 1075);
        }
        return RatNum.make(mant, IntNum.shift(IntNum.one(), 1075 - exp));
    }
    
    @Override
    public String toString() {
        return toString(this.value);
    }
    
    public static String toString(final double value) {
        return (value == Double.POSITIVE_INFINITY) ? "+inf.0" : ((value == Double.NEGATIVE_INFINITY) ? "-inf.0" : (Double.isNaN(value) ? "+nan.0" : Double.toString(value)));
    }
    
    @Override
    public String toString(final int radix) {
        if (radix == 10) {
            return this.toString();
        }
        return "#d" + this.toString();
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeDouble(this.value);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.value = in.readDouble();
    }
    
    static {
        zero = new DFloNum(0.0);
        one = new DFloNum(1.0);
    }
}
