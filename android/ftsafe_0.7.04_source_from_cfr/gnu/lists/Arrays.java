/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AVector;
import gnu.lists.AbstractSequence;
import gnu.lists.Array;
import gnu.lists.BitVector;
import gnu.lists.CharVector;
import gnu.lists.F32Vector;
import gnu.lists.F64Vector;
import gnu.lists.FVector;
import gnu.lists.GeneralArray;
import gnu.lists.IntSequence;
import gnu.lists.S16Vector;
import gnu.lists.S32Vector;
import gnu.lists.S64Vector;
import gnu.lists.S8Vector;
import gnu.lists.Sequences;
import gnu.lists.SimpleVector;
import gnu.lists.U16Vector;
import gnu.lists.U32Vector;
import gnu.lists.U64Vector;
import gnu.lists.U8Vector;

public class Arrays {
    public static int rowMajorToEffectiveIndex(Array arr, int index) {
        int sz;
        if (arr instanceof GeneralArray) {
            GeneralArray garr = (GeneralArray)arr;
            if (garr.simple) {
                return garr.base.effectiveIndex(index);
            }
        }
        int r = arr.rank();
        switch (r) {
            case 0: {
                return arr.effectiveIndex();
            }
            case 1: {
                return arr.effectiveIndex(index + arr.getLowBound(0));
            }
            case 2: {
                int sz1 = arr.getSize(1);
                return arr.effectiveIndex(index / sz1 + arr.getLowBound(0), index % sz1 + arr.getLowBound(1));
            }
        }
        int[] rest = r == 3 ? AbstractSequence.noInts : new int[r - 3];
        boolean p = true;
        int i = r;
        while (--i >= 3) {
            sz = arr.getSize(i);
            rest[i] = index % sz + arr.getLowBound(i);
            index /= sz;
        }
        sz = arr.getSize(2);
        int i2 = index % sz + arr.getLowBound(2);
        sz = arr.getSize(1);
        int i1 = (index /= sz) % sz + arr.getLowBound(1);
        sz = arr.getSize(0);
        int i0 = (index /= sz) % sz + arr.getLowBound(0);
        return arr.effectiveIndex(i0, i1, i2, rest);
    }

    public static <E> E getRowMajor(Array<E> arr, int index) {
        return arr.getRaw(Arrays.rowMajorToEffectiveIndex(arr, index));
    }

    public static int hashCode(Array arr) {
        int rank = arr.rank();
        int[] indexes = new int[rank];
        int size = 1;
        for (int r = 0; r < rank; ++r) {
            indexes[r] = arr.getLowBound(r);
            size *= arr.getSize(r);
        }
        int hash = 1;
        for (int i = 0; i < size; ++i) {
            Object element = arr.get(indexes);
            hash = 31 * hash + (element == null ? 0 : element.hashCode());
            Arrays.incrementIndexes(indexes, arr);
        }
        return hash;
    }

    public static Array<Integer> asIntArrayOrNull(Object obj) {
        int kind;
        Array arr;
        if (obj instanceof Array && (kind = (arr = (Array)obj).getElementKind()) >= 17 && kind <= 24) {
            return arr;
        }
        if (obj instanceof Array) {
            arr = (Array)obj;
            int sz = arr.getSize();
            int rank = arr.rank();
            int[] data = new int[sz];
            int[] dims = new int[rank];
            int[] lows = null;
            int[] work = new int[rank];
            for (int i = 0; i < rank; ++i) {
                dims[i] = arr.getSize(i);
                int low = arr.getLowBound(i);
                if (low != 0) {
                    if (lows == null) {
                        lows = new int[rank];
                    }
                    lows[i] = low;
                }
                work[i] = low;
            }
            int j = 0;
            block1 : while (j < sz) {
                Object datum = arr.get(work);
                data[j] = ((Number)datum).intValue();
                if (++j == sz) break;
                int[] arrn = work;
                int n = rank - 1;
                arrn[n] = arrn[n] + 1;
                int i = rank;
                while (--i >= 0) {
                    int low;
                    int n2 = low = lows == null ? 0 : lows[i];
                    if (work[i] < low + dims[i]) continue block1;
                    work[i] = low;
                    int[] arrn2 = work;
                    int n3 = i - 1;
                    arrn2[n3] = arrn2[n3] + 1;
                }
            }
            S32Vector vec = new S32Vector(data);
            if (rank == 1 && lows == null) {
                return vec;
            }
            return new GeneralArray<Integer>(vec, dims, lows);
        }
        IntSequence is = Sequences.asIntSequenceOrNull(obj);
        if (is != null) {
            return is;
        }
        if (obj instanceof Number) {
            int[] iis = new int[]{((Number)obj).intValue()};
            S32Vector vec = new S32Vector(iis);
            return new GeneralArray<Integer>(vec, AbstractSequence.noInts, AbstractSequence.noInts);
        }
        return null;
    }

    public static void incrementIndexes(int[] indexes, Array<?> arr) {
        int r = arr.rank();
        while (--r >= 0) {
            int dim;
            int ind = indexes[r];
            int low = arr.getLowBound(r);
            if (++ind - low < (dim = arr.getSize(r))) {
                indexes[r] = ind;
                break;
            }
            indexes[r] = low;
        }
    }

    public static int[] getDimensions(Array<?> arr) {
        if (arr instanceof GeneralArray) {
            return ((GeneralArray)arr).dimensions;
        }
        int rank = arr.rank();
        int[] dims = new int[rank];
        int i = rank;
        while (--i >= 0) {
            dims[i] = arr.getSize(i);
        }
        return dims;
    }

    public static int[] getLowBounds(Array<?> arr) {
        if (arr instanceof GeneralArray) {
            return ((GeneralArray)arr).lowBounds;
        }
        int rank = arr.rank();
        int[] lows = new int[rank];
        int i = rank;
        while (--i >= 0) {
            lows[i] = arr.getLowBound(i);
        }
        return lows;
    }

    public static <E> void fill(Array<E> arr, E value) {
        int size;
        int rank = arr.rank();
        int[] indexes = new int[rank];
        int r = rank;
        while (--r >= 0) {
            indexes[r] = arr.getLowBound(r);
        }
        int i = size = arr.getSize();
        while (--i >= 0) {
            arr.set(indexes, value);
            Arrays.incrementIndexes(indexes, arr);
        }
    }

    public static <E> void copy(Array<E> dst, Array<E> src) {
        int size;
        int rank = dst.rank();
        if (rank != src.rank()) {
            throw new RuntimeException("incompatible arrays for copy (source rank :" + src.rank() + ", destination rank:" + rank + ")");
        }
        int[] idst = new int[rank];
        int[] isrc = new int[rank];
        int r = rank;
        while (--r >= 0) {
            int dsize;
            int ssize = src.getSize(r);
            if (ssize != (dsize = dst.getSize(r))) {
                throw new RuntimeException("incompatible arrays for copy, dimension " + r + " (source size: " + ssize + "; destination: " + dsize + ")");
            }
            isrc[r] = src.getLowBound(r);
            idst[r] = dst.getLowBound(r);
        }
        int i = size = dst.getSize();
        while (--i >= 0) {
            E value = src.get(isrc);
            dst.set(idst, value);
            Arrays.incrementIndexes(isrc, src);
            Arrays.incrementIndexes(idst, dst);
        }
    }

    public static <E> GeneralArray<E> simpleCopy(Array<E> arr, boolean writable) {
        SimpleVector<E> vec = Arrays.flattenCopy(arr, writable);
        return GeneralArray.make(vec, Arrays.getDimensions(arr), Arrays.getLowBounds(arr), null, 0);
    }

    public static <E> SimpleVector<E> flattenCopy(Array<E> arr, boolean writable) {
        SimpleVector vec;
        int rank = arr.rank();
        int[] indexes = new int[rank];
        int d = rank;
        while (--d >= 0) {
            indexes[d] = arr.getLowBound(d);
        }
        int size = arr.getSize();
        int kind = arr.getElementKind();
        switch (kind) {
            case 27: {
                boolean[] data = new boolean[size];
                for (int i = 0; i < size; ++i) {
                    int effi = arr.effectiveIndex(indexes);
                    Arrays.incrementIndexes(indexes, arr);
                    data[i] = arr.getBooleanRaw(effi);
                }
                vec = new BitVector(data);
                break;
            }
            case 29: {
                char[] data = new char[size];
                for (int i = 0; i < size; ++i) {
                    int effi = arr.effectiveIndex(indexes);
                    Arrays.incrementIndexes(indexes, arr);
                    data[i] = arr.getCharRaw(effi);
                }
                vec = new CharVector(data);
                break;
            }
            case 17: 
            case 18: {
                byte[] data = new byte[size];
                for (int i = 0; i < size; ++i) {
                    int effi = arr.effectiveIndex(indexes);
                    Arrays.incrementIndexes(indexes, arr);
                    data[i] = arr.getByteRaw(effi);
                }
                vec = kind == 18 ? new S8Vector(data) : new U8Vector(data);
                break;
            }
            case 19: 
            case 20: {
                short[] data = new short[size];
                for (int i = 0; i < size; ++i) {
                    int effi = arr.effectiveIndex(indexes);
                    Arrays.incrementIndexes(indexes, arr);
                    data[i] = arr.getShortRaw(effi);
                }
                vec = kind == 20 ? new S16Vector(data) : new U16Vector(data);
                break;
            }
            case 21: 
            case 22: {
                int[] data = new int[size];
                for (int i = 0; i < size; ++i) {
                    int effi = arr.effectiveIndex(indexes);
                    Arrays.incrementIndexes(indexes, arr);
                    data[i] = arr.getIntRaw(effi);
                }
                vec = kind == 22 ? new S32Vector(data) : new U32Vector(data);
                break;
            }
            case 23: 
            case 24: {
                long[] data = new long[size];
                for (int i = 0; i < size; ++i) {
                    int effi = arr.effectiveIndex(indexes);
                    Arrays.incrementIndexes(indexes, arr);
                    data[i] = arr.getLongRaw(effi);
                }
                vec = kind == 24 ? new S64Vector(data) : new U64Vector(data);
                break;
            }
            case 25: {
                float[] data = new float[size];
                for (int i = 0; i < size; ++i) {
                    int effi = arr.effectiveIndex(indexes);
                    Arrays.incrementIndexes(indexes, arr);
                    data[i] = arr.getFloatRaw(effi);
                }
                vec = new F32Vector(data);
                break;
            }
            case 26: {
                double[] data = new double[size];
                for (int i = 0; i < size; ++i) {
                    int effi = arr.effectiveIndex(indexes);
                    Arrays.incrementIndexes(indexes, arr);
                    data[i] = arr.getDoubleRaw(effi);
                }
                vec = new F64Vector(data);
                break;
            }
            default: {
                Object[] data = new Object[size];
                for (int i = 0; i < size; ++i) {
                    int effi = arr.effectiveIndex(indexes);
                    Arrays.incrementIndexes(indexes, arr);
                    data[i] = arr.getRaw(effi);
                }
                vec = new FVector(data);
            }
        }
        if (!writable) {
            vec.info |= 0x100000000L;
        }
        return vec;
    }
}

