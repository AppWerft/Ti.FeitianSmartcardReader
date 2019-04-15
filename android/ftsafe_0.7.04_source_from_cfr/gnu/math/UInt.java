/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.IntNum;
import gnu.math.UnsignedPrim;

public class UInt
extends UnsignedPrim
implements Comparable<UInt> {
    int ival;

    @Override
    public int numBits() {
        return 32;
    }

    public UInt(int ival) {
        this.ival = ival;
    }

    public static UInt valueOf(int ival) {
        return new UInt(ival);
    }

    @Override
    public int intValue() {
        return this.ival;
    }

    @Override
    public long longValue() {
        return (long)this.ival & 0xFFFFFFFFL;
    }

    @Override
    public IntNum toIntNum() {
        return IntNum.valueOf(this.longValue());
    }

    public static String toString(int ival) {
        if (ival >= 0) {
            return Integer.toString(ival);
        }
        return Long.toString(0xFFFFFFFFL & (long)ival);
    }

    public boolean equals(Object obj) {
        return obj instanceof UInt && this.ival == ((UInt)obj).ival;
    }

    @Override
    public int compareTo(UInt other) {
        int x = this.ival + Integer.MIN_VALUE;
        int y = other.ival + Integer.MIN_VALUE;
        return x < y ? -1 : (x == y ? 0 : 1);
    }

    public String toString() {
        return UInt.toString(this.ival);
    }
}

