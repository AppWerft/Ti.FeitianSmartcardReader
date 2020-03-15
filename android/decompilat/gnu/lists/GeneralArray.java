// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class GeneralArray<E> extends TransformedArray<E>
{
    int[] dimensions;
    int[] strides;
    int[] lowBounds;
    static final int[] zeros;
    int offset;
    boolean simple;
    
    @Override
    protected int nextIndex(final int ipos) {
        return ipos >>> 1;
    }
    
    public static Array makeSimple(final int[] lowBounds, final int[] dimensions, final SimpleVector base) {
        final int d = dimensions.length;
        if (d == 1 && (lowBounds == null || lowBounds[0] == 0)) {
            return base;
        }
        return new GeneralArray(base, dimensions, lowBounds);
    }
    
    public GeneralArray() {
    }
    
    public GeneralArray(final int[] dimensions) {
        this.init(new FVector<E>(getSize(dimensions)), dimensions, null, null, 0);
    }
    
    public GeneralArray(final AVector<E> base, final int[] dimensions, final int[] lowBounds, final int[] strides, final int offset) {
        this.init(base, dimensions, lowBounds, strides, offset);
    }
    
    public GeneralArray(final AVector<E> base, final int[] dimensions, final int[] lowBounds) {
        this.init(base, dimensions, lowBounds, null, 0);
    }
    
    protected void init(final AVector<E> base, final int[] dimensions, int[] lowBounds, int[] strides, final int offset) {
        this.base = base;
        this.simple = (strides == null && offset == 0);
        final int d = dimensions.length;
        if (lowBounds == null) {
            lowBounds = GeneralArray.zeros;
            if (d > lowBounds.length) {
                lowBounds = new int[d];
            }
        }
        if (strides == null) {
            strides = new int[d];
            int n = 1;
            int i = d;
            while (--i >= 0) {
                strides[i] = n;
                n *= dimensions[i];
            }
        }
        this.strides = strides;
        this.dimensions = dimensions;
        this.lowBounds = lowBounds;
        this.offset = offset;
    }
    
    private static int getSize(final int[] dimensions) {
        int sz = 1;
        int i = dimensions.length;
        while (--i >= 0) {
            sz *= dimensions[i];
        }
        return sz;
    }
    
    public static <E> GeneralArray<E> make0(final AVector<E> base) {
        return make(base, GeneralArray.noInts, GeneralArray.noInts, GeneralArray.noInts, 0);
    }
    
    public static <E> GeneralArray<E> make(final AVector<E> base, final int[] dimensions, final int[] lowBounds, final int[] strides, final int offset) {
        final GeneralArray array = (dimensions.length == 1 && (lowBounds == null || lowBounds[0] == 0)) ? new GeneralArray1() : new GeneralArray();
        array.init(base, dimensions, lowBounds, strides, offset);
        return (GeneralArray<E>)array;
    }
    
    public AVector<E> getBase() {
        return (AVector<E>)(AVector)this.base;
    }
    
    public void setBase(final AVector<E> base) {
        if (this.base != null) {
            throw new IllegalStateException();
        }
        this.base = base;
    }
    
    public void setBase(final E[] data) {
        this.setBase(new FVector<E>(data));
    }
    
    public void setStrides(final int[] strides, final int offset) {
        this.strides = strides;
        this.offset = offset;
    }
    
    public int[] getDimensions() {
        return this.dimensions;
    }
    
    public int[] getLowBounds() {
        return this.lowBounds;
    }
    
    @Override
    public int rank() {
        return this.dimensions.length;
    }
    
    @Override
    public int effectiveIndex() {
        this.checkRank(0);
        return this.base.effectiveIndex(this.offset);
    }
    
    @Override
    public int effectiveIndex(int i) {
        this.checkRank(1);
        final int low = this.lowBounds[0];
        if (i < low || (i -= low) >= this.dimensions[0]) {
            throw new IndexOutOfBoundsException();
        }
        return this.base.effectiveIndex(this.offset + this.strides[0] * i);
    }
    
    @Override
    public int effectiveIndex(int i, int j) {
        this.checkRank(2);
        int result = this.offset;
        int low = this.lowBounds[0];
        if (i < low || (i -= low) >= this.dimensions[0]) {
            throw new IndexOutOfBoundsException();
        }
        result += this.strides[0] * i;
        low = this.lowBounds[1];
        if (j < low || (j -= low) >= this.dimensions[1]) {
            throw new IndexOutOfBoundsException();
        }
        result += this.strides[1] * j;
        return this.base.effectiveIndex(result);
    }
    
    @Override
    public int effectiveIndex(int i, int j, int k, final int... rest) {
        this.checkRank(rest.length + 3);
        int result = this.offset;
        int low = this.lowBounds[0];
        if (i < low || (i -= low) >= this.dimensions[0]) {
            throw new IndexOutOfBoundsException();
        }
        result += this.strides[0] * i;
        low = this.lowBounds[1];
        if (j < low || (j -= low) >= this.dimensions[1]) {
            throw new IndexOutOfBoundsException();
        }
        result += this.strides[1] * j;
        low = this.lowBounds[2];
        if (k < low || (k -= low) >= this.dimensions[2]) {
            throw new IndexOutOfBoundsException();
        }
        result += this.strides[2] * k;
        int d = rest.length;
        while (--d >= 0) {
            int index = rest[d];
            low = this.lowBounds[d + 3];
            if (index < low || (index -= low) >= this.dimensions[d + 3]) {
                throw new IndexOutOfBoundsException();
            }
            result += this.strides[d + 3] * index;
        }
        return result;
    }
    
    public int resolve(final int[] indexes) {
        int result = this.offset;
        int i = this.dimensions.length;
        while (--i >= 0) {
            int index = indexes[i];
            final int low = this.lowBounds[i];
            if (index < low || (index -= low) >= this.dimensions[i]) {
                throw new IndexOutOfBoundsException();
            }
            result += this.strides[i] * index;
        }
        return result;
    }
    
    @Override
    public E get(final int[] indexes) {
        return this.base.getRaw(this.effectiveIndex(indexes));
    }
    
    @Override
    public int size() {
        int total = 1;
        int i = this.dimensions.length;
        while (--i >= 0) {
            total *= this.dimensions[i];
        }
        return total;
    }
    
    @Override
    public int getLowBound(final int dim) {
        return this.lowBounds[dim];
    }
    
    @Override
    public int getSize(final int dim) {
        return this.dimensions[dim];
    }
    
    public static void toString(final Array array, final StringBuffer sbuf) {
        sbuf.append("#<array");
        for (int r = array.rank(), i = 0; i < r; ++i) {
            sbuf.append(' ');
            final int lo = array.getLowBound(i);
            final int sz = array.getSize(i);
            if (lo != 0) {
                sbuf.append(lo);
                sbuf.append(':');
            }
            sbuf.append(lo + sz);
        }
        sbuf.append('>');
    }
    
    public String getTag() {
        if (this.base instanceof SimpleVector) {
            return ((SimpleVector)this.base).getTag();
        }
        return null;
    }
    
    @Override
    public String toString() {
        final StringBuffer sbuf = new StringBuffer();
        toString(this, sbuf);
        return sbuf.toString();
    }
    
    static {
        zeros = new int[8];
    }
}
