/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.RatNum;
import gnu.math.UnsignedPrim;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class Numeric
extends Number {
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

    public abstract Numeric add(Object var1, int var2);

    public final Numeric add(Object obj) {
        return this.add(obj, 1);
    }

    public final Numeric sub(Object obj) {
        return this.add(obj, -1);
    }

    public abstract Numeric mul(Object var1);

    public abstract Numeric div(Object var1);

    public abstract Numeric abs();

    public abstract Numeric neg();

    public abstract String toString(int var1);

    public String toString() {
        return this.toString(10);
    }

    public static Numeric asNumericOrNull(Object value) {
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

    public int compare(Object obj) {
        return -3;
    }

    public int compareReversed(Numeric x) {
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Numeric)) {
            return false;
        }
        return this.compare(obj) == 0;
    }

    public boolean grt(Object x) {
        return this.compare(x) > 0;
    }

    public boolean geq(Object x) {
        return this.compare(x) >= 0;
    }

    public Numeric addReversed(Numeric x, int k) {
        throw new IllegalArgumentException();
    }

    public Numeric mulReversed(Numeric x) {
        throw new IllegalArgumentException();
    }

    public Numeric divReversed(Numeric x) {
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
        do {
            if (y.isOdd()) {
                Numeric numeric = r = r == null ? pow2 : r.mul(pow2);
            }
            if ((y = IntNum.shift(y, -1)).isZero()) break;
            pow2 = pow2.mul(pow2);
        } while (true);
        return r == null ? this.mul_ident() : r;
    }
}

