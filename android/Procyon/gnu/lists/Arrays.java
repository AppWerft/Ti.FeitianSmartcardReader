// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class Arrays
{
    public static int rowMajorToEffectiveIndex(final Array arr, int index) {
        if (arr instanceof GeneralArray) {
            final GeneralArray garr = (GeneralArray)arr;
            if (garr.simple) {
                return garr.base.effectiveIndex(index);
            }
        }
        final int r = arr.rank();
        switch (r) {
            case 0: {
                return arr.effectiveIndex();
            }
            case 1: {
                return arr.effectiveIndex(index + arr.getLowBound(0));
            }
            case 2: {
                final int sz1 = arr.getSize(1);
                return arr.effectiveIndex(index / sz1 + arr.getLowBound(0), index % sz1 + arr.getLowBound(1));
            }
            default: {
                final int[] rest = (r == 3) ? AbstractSequence.noInts : new int[r - 3];
                final int p = 1;
                int i = r;
                while (--i >= 3) {
                    final int sz2 = arr.getSize(i);
                    rest[i] = index % sz2 + arr.getLowBound(i);
                    index /= sz2;
                }
                int sz2 = arr.getSize(2);
                final int i2 = index % sz2 + arr.getLowBound(2);
                index /= sz2;
                sz2 = arr.getSize(1);
                final int i3 = index % sz2 + arr.getLowBound(1);
                index /= sz2;
                sz2 = arr.getSize(0);
                final int i4 = index % sz2 + arr.getLowBound(0);
                return arr.effectiveIndex(i4, i3, i2, rest);
            }
        }
    }
    
    public static <E> E getRowMajor(final Array<E> arr, final int index) {
        return arr.getRaw(rowMajorToEffectiveIndex(arr, index));
    }
    
    public static int hashCode(final Array arr) {
        final int rank = arr.rank();
        final int[] indexes = new int[rank];
        int size = 1;
        for (int r = 0; r < rank; ++r) {
            indexes[r] = arr.getLowBound(r);
            size *= arr.getSize(r);
        }
        int hash = 1;
        for (int i = 0; i < size; ++i) {
            final Object element = arr.get(indexes);
            hash = 31 * hash + ((element == null) ? 0 : element.hashCode());
            incrementIndexes(indexes, arr);
        }
        return hash;
    }
    
    public static Array<Integer> asIntArrayOrNull(final Object obj) {
        if (obj instanceof Array) {
            final Array arr = (Array)obj;
            final int kind = arr.getElementKind();
            if (kind >= 17 && kind <= 24) {
                return (Array<Integer>)arr;
            }
        }
        if (obj instanceof Array) {
            final Array arr = (Array)obj;
            final int sz = arr.getSize();
            final int rank = arr.rank();
            final int[] data = new int[sz];
            final int[] dims = new int[rank];
            int[] lows = null;
            final int[] work = new int[rank];
            for (int i = 0; i < rank; ++i) {
                dims[i] = arr.getSize(i);
                final int low = arr.getLowBound(i);
                if (low != 0) {
                    if (lows == null) {
                        lows = new int[rank];
                    }
                    lows[i] = low;
                }
                work[i] = low;
            }
            int j = 0;
            while (j < sz) {
                final Object datum = arr.get(work);
                data[j] = ((Number)datum).intValue();
                if (++j == sz) {
                    break;
                }
                final int[] array = work;
                final int n = rank - 1;
                ++array[n];
                int k = rank;
                while (--k >= 0) {
                    final int low2 = (lows == null) ? 0 : lows[k];
                    if (work[k] < low2 + dims[k]) {
                        break;
                    }
                    work[k] = low2;
                    final int[] array2 = work;
                    final int n2 = k - 1;
                    ++array2[n2];
                }
            }
            final S32Vector vec = new S32Vector(data);
            if (rank == 1 && lows == null) {
                return vec;
            }
            return new GeneralArray<Integer>(vec, dims, lows);
        }
        else {
            final IntSequence is = Sequences.asIntSequenceOrNull(obj);
            if (is != null) {
                return is;
            }
            if (obj instanceof Number) {
                final int[] iis = { ((Number)obj).intValue() };
                final S32Vector vec2 = new S32Vector(iis);
                return new GeneralArray<Integer>(vec2, AbstractSequence.noInts, AbstractSequence.noInts);
            }
            return null;
        }
    }
    
    public static void incrementIndexes(final int[] indexes, final Array<?> arr) {
        int r = arr.rank();
        while (--r >= 0) {
            int ind = indexes[r];
            ++ind;
            final int low = arr.getLowBound(r);
            final int dim = arr.getSize(r);
            if (ind - low < dim) {
                indexes[r] = ind;
                break;
            }
            indexes[r] = low;
        }
    }
    
    public static int[] getDimensions(final Array<?> arr) {
        if (arr instanceof GeneralArray) {
            return ((GeneralArray)arr).dimensions;
        }
        final int rank = arr.rank();
        final int[] dims = new int[rank];
        int i = rank;
        while (--i >= 0) {
            dims[i] = arr.getSize(i);
        }
        return dims;
    }
    
    public static int[] getLowBounds(final Array<?> arr) {
        if (arr instanceof GeneralArray) {
            return ((GeneralArray)arr).lowBounds;
        }
        final int rank = arr.rank();
        final int[] lows = new int[rank];
        int i = rank;
        while (--i >= 0) {
            lows[i] = arr.getLowBound(i);
        }
        return lows;
    }
    
    public static <E> void fill(final Array<E> arr, final E value) {
        final int rank = arr.rank();
        final int[] indexes = new int[rank];
        int r = rank;
        while (--r >= 0) {
            indexes[r] = arr.getLowBound(r);
        }
        int i;
        final int size = i = arr.getSize();
        while (--i >= 0) {
            arr.set(indexes, value);
            incrementIndexes(indexes, arr);
        }
    }
    
    public static <E> void copy(final Array<E> dst, final Array<E> src) {
        final int rank = dst.rank();
        if (rank != src.rank()) {
            throw new RuntimeException("incompatible arrays for copy (source rank :" + src.rank() + ", destination rank:" + rank + ")");
        }
        final int[] idst = new int[rank];
        final int[] isrc = new int[rank];
        int r = rank;
        while (--r >= 0) {
            final int ssize = src.getSize(r);
            final int dsize = dst.getSize(r);
            if (ssize != dsize) {
                throw new RuntimeException("incompatible arrays for copy, dimension " + r + " (source size: " + ssize + "; destination: " + dsize + ")");
            }
            isrc[r] = src.getLowBound(r);
            idst[r] = dst.getLowBound(r);
        }
        int i;
        final int size = i = dst.getSize();
        while (--i >= 0) {
            final E value = src.get(isrc);
            dst.set(idst, value);
            incrementIndexes(isrc, src);
            incrementIndexes(idst, dst);
        }
    }
    
    public static <E> GeneralArray<E> simpleCopy(final Array<E> arr, final boolean writable) {
        final SimpleVector<E> vec = flattenCopy(arr, writable);
        return GeneralArray.make(vec, getDimensions(arr), getLowBounds(arr), null, 0);
    }
    
    public static <E> SimpleVector<E> flattenCopy(final Array<E> arr, final boolean writable) {
        final int rank = arr.rank();
        final int[] indexes = new int[rank];
        int d = rank;
        while (--d >= 0) {
            indexes[d] = arr.getLowBound(d);
        }
        final int size = arr.getSize();
        final int kind = arr.getElementKind();
        SimpleVector vec = null;
        switch (kind) {
            case 27: {
                final boolean[] data = new boolean[size];
                for (int i = 0; i < size; ++i) {
                    final int effi = arr.effectiveIndex(indexes);
                    incrementIndexes(indexes, arr);
                    data[i] = arr.getBooleanRaw(effi);
                }
                vec = new BitVector(data);
                break;
            }
            case 29: {
                final char[] data2 = new char[size];
                for (int i = 0; i < size; ++i) {
                    final int effi = arr.effectiveIndex(indexes);
                    incrementIndexes(indexes, arr);
                    data2[i] = arr.getCharRaw(effi);
                }
                vec = new CharVector(data2);
                break;
            }
            case 17:
            case 18: {
                final byte[] data3 = new byte[size];
                for (int i = 0; i < size; ++i) {
                    final int effi = arr.effectiveIndex(indexes);
                    incrementIndexes(indexes, arr);
                    data3[i] = arr.getByteRaw(effi);
                }
                vec = (SimpleVector)((kind == 18) ? new S8Vector(data3) : new U8Vector(data3));
                break;
            }
            case 19:
            case 20: {
                final short[] data4 = new short[size];
                for (int i = 0; i < size; ++i) {
                    final int effi = arr.effectiveIndex(indexes);
                    incrementIndexes(indexes, arr);
                    data4[i] = arr.getShortRaw(effi);
                }
                vec = (SimpleVector)((kind == 20) ? new S16Vector(data4) : new U16Vector(data4));
                break;
            }
            case 21:
            case 22: {
                final int[] data5 = new int[size];
                for (int i = 0; i < size; ++i) {
                    final int effi = arr.effectiveIndex(indexes);
                    incrementIndexes(indexes, arr);
                    data5[i] = arr.getIntRaw(effi);
                }
                vec = (SimpleVector)((kind == 22) ? new S32Vector(data5) : new U32Vector(data5));
                break;
            }
            case 23:
            case 24: {
                final long[] data6 = new long[size];
                for (int i = 0; i < size; ++i) {
                    final int effi = arr.effectiveIndex(indexes);
                    incrementIndexes(indexes, arr);
                    data6[i] = arr.getLongRaw(effi);
                }
                vec = (SimpleVector)((kind == 24) ? new S64Vector(data6) : new U64Vector(data6));
                break;
            }
            case 25: {
                final float[] data7 = new float[size];
                for (int i = 0; i < size; ++i) {
                    final int effi = arr.effectiveIndex(indexes);
                    incrementIndexes(indexes, arr);
                    data7[i] = arr.getFloatRaw(effi);
                }
                vec = new F32Vector(data7);
                break;
            }
            case 26: {
                final double[] data8 = new double[size];
                for (int i = 0; i < size; ++i) {
                    final int effi = arr.effectiveIndex(indexes);
                    incrementIndexes(indexes, arr);
                    data8[i] = arr.getDoubleRaw(effi);
                }
                vec = new F64Vector(data8);
                break;
            }
            default: {
                final Object[] data9 = new Object[size];
                for (int i = 0; i < size; ++i) {
                    final int effi = arr.effectiveIndex(indexes);
                    incrementIndexes(indexes, arr);
                    data9[i] = arr.getRaw(effi);
                }
                vec = new FVector(data9);
                break;
            }
        }
        if (!writable) {
            final SimpleVector simpleVector = vec;
            simpleVector.info |= 0x100000000L;
        }
        return (SimpleVector<E>)vec;
    }
}
