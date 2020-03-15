// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class CharVector extends AbstractCharVector<Character>
{
    public CharVector(final char[] values) {
        this.data = values;
    }
    
    @Override
    public final Character getRaw(final int index) {
        return this.data[index];
    }
    
    @Override
    public final void setRaw(final int index, final Character value) {
        this.data[index] = value;
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof CharVector && AbstractCharVector.equals(this, (AbstractCharVector<?>)obj);
    }
    
    @Override
    protected CharVector newInstance(final int newLength) {
        return new CharVector((newLength < 0) ? this.data : new char[newLength]);
    }
    
    @Override
    public int getElementKind() {
        return 29;
    }
    
    @Override
    public String getTag() {
        return "c16";
    }
}
