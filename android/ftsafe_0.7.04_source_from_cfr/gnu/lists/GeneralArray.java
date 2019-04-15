/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AVector;
import gnu.lists.Array;
import gnu.lists.FVector;
import gnu.lists.GeneralArray1;
import gnu.lists.SimpleVector;
import gnu.lists.TransformedArray;

public class GeneralArray<E>
extends TransformedArray<E> {
    int[] dimensions;
    int[] strides;
    int[] lowBounds;
    static final int[] zeros = new int[8];
    int offset;
    boolean simple;

    @Override
    protected int nextIndex(int ipos) {
        return ipos >>> 1;
    }

    public static Array makeSimple(int[] lowBounds, int[] dimensions, SimpleVector base2) {
        int d = dimensions.length;
        if (d == 1 && (lowBounds == null || lowBounds[0] == 0)) {
            return base2;
        }
        return new GeneralArray<E>(base2, dimensions, lowBounds);
    }

    public GeneralArray() {
    }

    public GeneralArray(int[] dimensions) {
        this.init(new FVector(GeneralArray.getSize(dimensions)), dimensions, null, null, 0);
    }

    public GeneralArray(AVector<E> base2, int[] dimensions, int[] lowBounds, int[] strides, int offset) {
        this.init(base2, dimensions, lowBounds, strides, offset);
    }

    public GeneralArray(AVector<E> base2, int[] dimensions, int[] lowBounds) {
        this.init(base2, dimensions, lowBounds, null, 0);
    }

    protected void init(AVector<E> base2, int[] dimensions, int[] lowBounds, int[] strides, int offset) {
        this.base = base2;
        this.simple = strides == null && offset == 0;
        int d = dimensions.length;
        if (lowBounds == null && d > (lowBounds = zeros).length) {
            lowBounds = new int[d];
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

    private static int getSize(int[] dimensions) {
        int sz = 1;
        int i = dimensions.length;
        while (--i >= 0) {
            sz *= dimensions[i];
        }
        return sz;
    }

    public static <E> GeneralArray<E> make0(AVector<E> base2) {
        return GeneralArray.make(base2, noInts, noInts, noInts, 0);
    }

    public static <E> GeneralArray<E> make(AVector<E> base2, int[] dimensions, int[] lowBounds, int[] strides, int offset) {
        GeneralArray1<E> array = dimensions.length == 1 && (lowBounds == null || lowBounds[0] == 0) ? new GeneralArray1<E>() : new GeneralArray1<E>();
        array.init(base2, dimensions, lowBounds, strides, offset);
        return array;
    }

    public AVector<E> getBase() {
        return (AVector)this.base;
    }

    public void setBase(AVector<E> base2) {
        if (this.base != null) {
            throw new IllegalStateException();
        }
        this.base = base2;
    }

    public void setBase(E[] data) {
        this.setBase(new FVector(data));
    }

    public void setStrides(int[] strides, int offset) {
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
        int low = this.lowBounds[0];
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
        return this.base.effectiveIndex(result += this.strides[1] * j);
    }

    @Override
    public /* varargs */ int effectiveIndex(int i, int j, int k, int ... rest) {
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

    public int resolve(int[] indexes) {
        int result = this.offset;
        int i = this.dimensions.length;
        while (--i >= 0) {
            int index = indexes[i];
            int low = this.lowBounds[i];
            if (index < low || (index -= low) >= this.dimensions[i]) {
                throw new IndexOutOfBoundsException();
            }
            result += this.strides[i] * index;
        }
        return result;
    }

    @Override
    public E get(int[] indexes) {
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
    public int getLowBound(int dim) {
        return this.lowBounds[dim];
    }

    @Override
    public int getSize(int dim) {
        return this.dimensions[dim];
    }

    public static void toString(Array array, StringBuffer sbuf) {
        sbuf.append("#<array");
        int r = array.rank();
        for (int i = 0; i < r; ++i) {
            sbuf.append(' ');
            int lo = array.getLowBound(i);
            int sz = array.getSize(i);
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
        StringBuffer sbuf = new StringBuffer();
        GeneralArray.toString(this, sbuf);
        return sbuf.toString();
    }
}

