/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.IntNum;
import gnu.math.UnsignedPrim;

public class UShort
extends UnsignedPrim
implements Comparable<UShort> {
    short ival;

    @Override
    public int numBits() {
        return 16;
    }

    public UShort(short ival) {
        this.ival = ival;
    }

    public static UShort valueOf(short ival) {
        return new UShort(ival);
    }

    @Override
    public short shortValue() {
        return this.ival;
    }

    @Override
    public int intValue() {
        return this.ival & 65535;
    }

    @Override
    public long longValue() {
        return this.ival & 65535;
    }

    @Override
    public IntNum toIntNum() {
        return IntNum.valueOf(this.ival & 65535);
    }

    public boolean equals(Object obj) {
        return obj instanceof UShort && this.ival == ((UShort)obj).ival;
    }

    @Override
    public int compareTo(UShort other) {
        return this.intValue() - other.intValue();
    }

    public static String toString(short ival) {
        return Integer.toString(ival & 65535);
    }

    public String toString() {
        return UShort.toString(this.ival);
    }
}

