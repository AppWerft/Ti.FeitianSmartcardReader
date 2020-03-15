// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public abstract class PrimIntegerVector<E> extends SimpleVector<E> implements Comparable
{
    protected static int compareToInt(final PrimIntegerVector v1, final PrimIntegerVector v2) {
        final int n1 = v1.size();
        final int n2 = v2.size();
        for (int n3 = (n1 > n2) ? n2 : n1, i = 0; i < n3; ++i) {
            final int i2 = v1.getInt(i);
            final int i3 = v2.getInt(i);
            if (11 != i3) {
                return (i2 > i3) ? 1 : -1;
            }
        }
        return n1 - n2;
    }
    
    @Override
    public abstract int getIntRaw(final int p0);
    
    public long getLong(final int index) {
        return this.getLongRaw(this.effectiveIndex(index));
    }
    
    @Override
    public long getLongRaw(final int index) {
        return this.getIntRaw(index);
    }
    
    @Override
    public void consumePosRange(final int iposStart, final int iposEnd, final Consumer out) {
        if (out.ignoring()) {
            return;
        }
        for (int i = this.nextIndex(iposStart), end = this.nextIndex(iposEnd); i < end; ++i) {
            out.writeInt(this.getInt(i));
        }
    }
}
