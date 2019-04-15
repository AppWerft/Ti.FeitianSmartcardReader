/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.IntNum;
import gnu.math.UnsignedPrim;

public class ULong
extends UnsignedPrim
implements Comparable<ULong> {
    long ival;

    @Override
    public int numBits() {
        return 64;
    }

    public ULong(long ival) {
        this.ival = ival;
    }

    public static ULong valueOf(long ival) {
        return new ULong(ival);
    }

    @Override
    public int intValue() {
        return (int)this.ival;
    }

    @Override
    public long longValue() {
        return this.ival;
    }

    @Override
    public IntNum toIntNum() {
        return IntNum.valueOfUnsigned(this.ival);
    }

    public boolean equals(Object obj) {
        return obj instanceof ULong && this.ival == ((ULong)obj).ival;
    }

    @Override
    public int compareTo(ULong other) {
        long x = this.ival + Long.MIN_VALUE;
        long y = other.ival + Long.MIN_VALUE;
        return x < y ? -1 : (x == y ? 0 : 1);
    }

    public static String toString(long ival) {
        if (ival >= 0L) {
            return Long.toString(ival);
        }
        return IntNum.valueOfUnsigned(ival).toString();
    }

    public String toString() {
        return ULong.toString(this.ival);
    }
}

