// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class FlattenedArray<E> extends TransformedArray<E> implements AVector<E>
{
    private final int size;
    private final int brank;
    
    public FlattenedArray(final Array<E> base) {
        super(base);
        this.size = base.getSize();
        this.brank = base.rank();
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public int getSize(final int dim) {
        if (dim != 0) {
            this.badRank(dim);
        }
        return this.size;
    }
    
    @Override
    public int effectiveIndex(final int i) {
        return Arrays.rowMajorToEffectiveIndex(this.base, i);
    }
    
    public static <E> AVector<E> flatten(final Array<E> array) {
        if (array instanceof AVector) {
            return (AVector<E>)(AVector)array;
        }
        if (array instanceof GeneralArray) {
            final GeneralArray<E> garr = (GeneralArray<E>)(GeneralArray)array;
            if (garr.simple && garr.base instanceof AVector) {
                return (AVector<E>)(AVector)garr.base;
            }
        }
        return new FlattenedArray<E>(array);
    }
}
