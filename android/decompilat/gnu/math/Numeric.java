// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class Numeric extends Number
{
    public static final int FLOOR = 1;
    public static final int CEILING = 2;
    public static final int TRUNCATE = 3;
    public static final int ROUND = 4;
    public static final int NONNEG_MOD = 5;
    
    @Override
    public float floatValue() {
        return (float)this.doubleValue();
    }
    
    @Override
    public int intValue() {
        return (int)this.longValue();
    }
    
    @Override
    public long longValue() {
        return (long)this.doubleValue();
    }
    
    public abstract Numeric add(final Object p0, final int p1);
    
    public final Numeric add(final Object obj) {
        return this.add(obj, 1);
    }
    
    public final Numeric sub(final Object obj) {
        return this.add(obj, -1);
    }
    
    public abstract Numeric mul(final Object p0);
    
    public abstract Numeric div(final Object p0);
    
    public abstract Numeric abs();
    
    public abstract Numeric neg();
    
    public abstract String toString(final int p0);
    
    @Override
    public String toString() {
        return this.toString(10);
    }
    
    public static Numeric asNumericOrNull(final Object value) {
        if (value instanceof Numeric) {
            return (Numeric)value;
        }
        if (value instanceof BigInteger || value instanceof Long || value instanceof Short || value instanceof Byte || value instanceof Integer || value instanceof UnsignedPrim) {
            return IntNum.asIntNumOrNull(value);
        }
        if (value instanceof BigDecimal) {
            return RatNum.asRatNumOrNull(value);
        }
        if (value instanceof Float || value instanceof Double) {
            return new DFloNum(((Number)value).doubleValue());
        }
        return null;
    }
    
    public abstract boolean isExact();
    
    public Numeric toExact() {
        return this;
    }
    
    public Numeric toInexact() {
        return this;
    }
    
    public abstract boolean isZero();
    
    public int compare(final Object obj) {
        return -3;
    }
    
    public int compareReversed(final Numeric x) {
        throw new IllegalArgumentException();
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj != null && obj instanceof Numeric && this.compare(obj) == 0;
    }
    
    public boolean grt(final Object x) {
        return this.compare(x) > 0;
    }
    
    public boolean geq(final Object x) {
        return this.compare(x) >= 0;
    }
    
    public Numeric addReversed(final Numeric x, final int k) {
        throw new IllegalArgumentException();
    }
    
    public Numeric mulReversed(final Numeric x) {
        throw new IllegalArgumentException();
    }
    
    public Numeric divReversed(final Numeric x) {
        throw new IllegalArgumentException();
    }
    
    public Numeric div_inv() {
        return IntNum.one().div(this);
    }
    
    public Numeric mul_ident() {
        return IntNum.one();
    }
    
    public Numeric power(IntNum y) {
        if (y.isNegative()) {
            return this.power(IntNum.neg(y)).div_inv();
        }
        Numeric pow2 = this;
        Numeric r = null;
        while (true) {
            if (y.isOdd()) {
                r = ((r == null) ? pow2 : r.mul(pow2));
            }
            y = IntNum.shift(y, -1);
            if (y.isZero()) {
                break;
            }
            pow2 = pow2.mul(pow2);
        }
        return (r == null) ? this.mul_ident() : r;
    }
}
