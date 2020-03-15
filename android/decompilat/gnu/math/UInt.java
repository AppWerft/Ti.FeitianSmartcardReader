// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

public class UInt extends UnsignedPrim implements Comparable<UInt>
{
    int ival;
    
    @Override
    public int numBits() {
        return 32;
    }
    
    public UInt(final int ival) {
        this.ival = ival;
    }
    
    public static UInt valueOf(final int ival) {
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
    
    public static String toString(final int ival) {
        if (ival >= 0) {
            return Integer.toString(ival);
        }
        return Long.toString(0xFFFFFFFFL & (long)ival);
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof UInt && this.ival == ((UInt)obj).ival;
    }
    
    @Override
    public int compareTo(final UInt other) {
        final int x = this.ival + Integer.MIN_VALUE;
        final int y = other.ival + Integer.MIN_VALUE;
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
    
    @Override
    public String toString() {
        return toString(this.ival);
    }
}
