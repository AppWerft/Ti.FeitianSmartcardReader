// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

public class UShort extends UnsignedPrim implements Comparable<UShort>
{
    short ival;
    
    @Override
    public int numBits() {
        return 16;
    }
    
    public UShort(final short ival) {
        this.ival = ival;
    }
    
    public static UShort valueOf(final short ival) {
        return new UShort(ival);
    }
    
    @Override
    public short shortValue() {
        return this.ival;
    }
    
    @Override
    public int intValue() {
        return this.ival & 0xFFFF;
    }
    
    @Override
    public long longValue() {
        return this.ival & 0xFFFF;
    }
    
    @Override
    public IntNum toIntNum() {
        return IntNum.valueOf(this.ival & 0xFFFF);
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof UShort && this.ival == ((UShort)obj).ival;
    }
    
    @Override
    public int compareTo(final UShort other) {
        return this.intValue() - other.intValue();
    }
    
    public static String toString(final short ival) {
        return Integer.toString(ival & 0xFFFF);
    }
    
    @Override
    public String toString() {
        return toString(this.ival);
    }
}
