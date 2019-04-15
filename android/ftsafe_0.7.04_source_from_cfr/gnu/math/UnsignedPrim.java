/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.IntNum;

public abstract class UnsignedPrim
extends Number {
    @Override
    public long longValue() {
        return this.intValue();
    }

    @Override
    public float floatValue() {
        return this.longValue();
    }

    @Override
    public double doubleValue() {
        return this.longValue();
    }

    public int hashCode() {
        return this.intValue();
    }

    public IntNum toIntNum() {
        return IntNum.valueOf(this.intValue());
    }

    public abstract int numBits();
}

