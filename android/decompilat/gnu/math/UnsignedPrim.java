// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

public abstract class UnsignedPrim extends Number
{
    @Override
    public long longValue() {
        return this.intValue();
    }
    
    @Override
    public float floatValue() {
        return (float)this.longValue();
    }
    
    @Override
    public double doubleValue() {
        return (double)this.longValue();
    }
    
    @Override
    public int hashCode() {
        return this.intValue();
    }
    
    public IntNum toIntNum() {
        return IntNum.valueOf(this.intValue());
    }
    
    public abstract int numBits();
}
