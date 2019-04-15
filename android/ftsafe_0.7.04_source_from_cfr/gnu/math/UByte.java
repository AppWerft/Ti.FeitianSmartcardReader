/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.IntNum;
import gnu.math.UnsignedPrim;

public class UByte
extends UnsignedPrim
implements Comparable<UByte> {
    byte ival;

    @Override
    public int numBits() {
        return 8;
    }

    public UByte(byte ival) {
        this.ival = ival;
    }

    public static UByte valueOf(byte ival) {
        return new UByte(ival);
    }

    @Override
    public int intValue() {
        return this.ival & 255;
    }

    @Override
    public IntNum toIntNum() {
        return IntNum.valueOf(this.ival & 65535);
    }

    public boolean equals(Object obj) {
        return obj instanceof UByte && this.ival == ((UByte)obj).ival;
    }

    @Override
    public int compareTo(UByte other) {
        return this.intValue() - other.intValue();
    }

    public static String toString(byte ival) {
        return Integer.toString(ival & 255);
    }

    public String toString() {
        return UByte.toString(this.ival);
    }
}

