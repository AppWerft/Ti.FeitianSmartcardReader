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

public class IntFraction
extends RatNum
implements Externalizable {
    IntNum num;
    IntNum den;

    IntFraction() {
    }

    public IntFraction(IntNum num, IntNum den) {
        this.num = num;
        this.den = den;
    }

    @Override
    public final IntNum numerator() {
        return this.num;
    }

    @Override
    public final IntNum denominator() {
        return this.den;
    }

    @Override
    public final boolean isNegative() {
        return this.num.isNegative();
    }

    @Override
    public final int sign() {
        return this.num.sign();
    }

    @Override
    public final int compare(Object obj) {
        if (obj instanceof RatNum) {
            return RatNum.compare(this, (RatNum)obj);
        }
        return ((RealNum)obj).compareReversed(this);
    }

    @Override
    public int compareReversed(Numeric x) {
        return RatNum.compare((RatNum)x, this);
    }

    @Override
    public Numeric add(Object y, int k) {
        if (y instanceof RatNum) {
            return RatNum.add(this, (RatNum)y, k);
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).addReversed(this, k);
    }

    @Override
    public Numeric addReversed(Numeric x, int k) {
        if (!(x instanceof RatNum)) {
            throw new IllegalArgumentException();
        }
        return RatNum.add((RatNum)x, this, k);
    }

    @Override
    public Numeric mul(Object y) {
        if (y instanceof RatNum) {
            return RatNum.times(this, (RatNum)y);
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).mulReversed(this);
    }

    @Override
    public Numeric mulReversed(Numeric x) {
        if (!(x instanceof RatNum)) {
            throw new IllegalArgumentException();
        }
        return RatNum.times((RatNum)x, this);
    }

    @Override
    public Numeric div(Object y) {
        if (y instanceof RatNum) {
            return RatNum.divide(this, (RatNum)y);
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).divReversed(this);
    }

    @Override
    public Numeric divReversed(Numeric x) {
        if (!(x instanceof RatNum)) {
            throw new IllegalArgumentException();
        }
        return RatNum.divide((RatNum)x, this);
    }

    public static IntFraction neg(IntFraction x) {
        return new IntFraction(IntNum.neg(x.numerator()), x.denominator());
    }

    @Override
    public Numeric neg() {
        return IntFraction.neg(this);
    }

    @Override
    public long longValue() {
        return this.toExactInt(4).longValue();
    }

    @Override
    public double doubleValue() {
        boolean neg = this.num.isNegative();
        if (this.den.isZero()) {
            return neg ? Double.NEGATIVE_INFINITY : (this.num.isZero() ? Double.NaN : Double.POSITIVE_INFINITY);
        }
        IntNum n = this.num;
        if (neg) {
            n = IntNum.neg(n);
        }
        int num_len = n.intLength();
        int den_len = this.den.intLength();
        int exp = 0;
        if (num_len < den_len + 54) {
            exp = den_len + 54 - num_len;
            n = IntNum.shift(n, exp);
            exp = -exp;
        }
        IntNum quot = new IntNum();
        IntNum remainder = new IntNum();
        IntNum.divide(n, this.den, quot, remainder, 3);
        quot = quot.canonicalize();
        remainder = remainder.canonicalize();
        return quot.roundToDouble(exp, neg, !remainder.isZero());
    }

    @Override
    public String toString(int radix) {
        return this.num.toString(radix) + '/' + this.den.toString(radix);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.num);
        out.writeObject(this.den);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.num = (IntNum)in.readObject();
        this.den = (IntNum)in.readObject();
    }
}

