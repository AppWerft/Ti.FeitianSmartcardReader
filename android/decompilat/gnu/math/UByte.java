// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

public class UByte extends UnsignedPrim implements Comparable<UByte>
{
    byte ival;
    
    @Override
    public int numBits() {
        return 8;
    }
    
    public UByte(final byte ival) {
        this.ival = ival;
    }
    
    public static UByte valueOf(final byte ival) {
        return new UByte(ival);
    }
    
    @Override
    public int intValue() {
        return this.ival & 0xFF;
    }
    
    @Override
    public IntNum toIntNum() {
        return IntNum.valueOf(this.ival & 0xFFFF);
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof UByte && this.ival == ((UByte)obj).ival;
    }
    
    @Override
    public int compareTo(final UByte other) {
        return this.intValue() - other.intValue();
    }
    
    public static String toString(final byte ival) {
        return Integer.toString(ival & 0xFF);
    }
    
    @Override
    public String toString() {
        return toString(this.ival);
    }
}
