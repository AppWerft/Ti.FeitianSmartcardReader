// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

public class ULong extends UnsignedPrim implements Comparable<ULong>
{
    long ival;
    
    @Override
    public int numBits() {
        return 64;
    }
    
    public ULong(final long ival) {
        this.ival = ival;
    }
    
    public static ULong valueOf(final long ival) {
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
    
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof ULong && this.ival == ((ULong)obj).ival;
    }
    
    @Override
    public int compareTo(final ULong other) {
        final long x = this.ival + Long.MIN_VALUE;
        final long y = other.ival + Long.MIN_VALUE;
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
    
    public static String toString(final long ival) {
        if (ival >= 0L) {
            return Long.toString(ival);
        }
        return IntNum.valueOfUnsigned(ival).toString();
    }
    
    @Override
    public String toString() {
        return toString(this.ival);
    }
}
