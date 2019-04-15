/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AVector;
import gnu.lists.AbstractSequence;
import gnu.lists.Array;
import gnu.lists.Arrays;
import gnu.lists.GeneralArray;
import gnu.lists.IndirectIndexedSeq;
import gnu.lists.IntSequence;
import gnu.lists.Range;
import gnu.lists.Sequences;
import gnu.lists.SimpleVector;
import gnu.lists.TransformedArray;
import gnu.mapping.Lazy;
import gnu.mapping.Promise;
import gnu.math.IntNum;
import java.util.List;

public class ComposedArray<E>
extends TransformedArray<E> {
    Array<Integer>[] mappers;
    int rank;
    int[] dims;
    int[] lowBounds;

    public ComposedArray(Array base2, int rank, int[] dims, int[] lowBounds, Array<Integer>[] mappers) {
        super(base2);
        this.rank = rank;
        this.dims = dims;
        this.lowBounds = lowBounds;
        this.mappers = mappers;
    }

    @Override
    public int rank() {
        return this.rank;
    }

    @Override
    public int getLowBound(int dim) {
        return this.lowBounds[dim];
    }

    @Override
    public int getSize(int dim) {
        return this.dims[dim];
    }

    @Override
    public final int effectiveIndex() {
        return this.resolve(0, 0, 0, noInts);
    }

    @Override
    public final int effectiveIndex(int i) {
        return this.resolve(i, 0, 0, noInts);
    }

    @Override
    public final int effectiveIndex(int i, int j) {
        return this.resolve(i, j, 0, noInts);
    }

    @Override
    public final /* varargs */ int effectiveIndex(int i, int j, int k, int ... rest) {
        return this.resolve(i, j, k, rest);
    }

    private /* varargs */ int resolve(int x, int y, int z, int ... rest) {
        int brank = this.base.rank();
        int rlen = rest.length;
        int b0 = 0;
        int b1 = 0;
        int b2 = 0;
        int[] brest = brank > 3 ? new int[brank - 3] : noInts;
        int bpos = 0;
        int mpos = 0;
        for (int i = 0; i < brank; ++i) {
            int bval;
            Array<Integer> mapper = this.mappers[i];
            int mrank = mapper.rank();
            switch (mrank) {
                case 0: {
                    bval = mapper.getInt();
                    break;
                }
                case 1: {
                    bval = mapper.getInt(x);
                    x = y;
                    y = z;
                    if (mpos < 3 || mpos - 3 >= rlen) break;
                    z = rest[mpos - 3];
                    break;
                }
                case 2: {
                    bval = mapper.getInt(x, y);
                    x = z;
                    if (mpos < 3 || mpos - 3 >= rlen) break;
                    y = rest[mpos - 3];
                    if (mpos < 2 || mpos - 2 >= rlen) break;
                    z = rest[mpos - 2];
                    break;
                }
                default: {
                    int[] tmp;
                    if (mrank == 3) {
                        tmp = noInts;
                    } else {
                        tmp = new int[mrank - 3];
                        System.arraycopy(rest, mpos - 3, tmp, 0, mrank - 3);
                    }
                    bval = mapper.getInt(x, y, z, tmp);
                    if (mpos < 3 || mpos - 3 >= rlen) break;
                    x = rest[mpos - 3];
                    if (mpos >= 2 && mpos - 2 < rlen) {
                        y = rest[mpos - 2];
                    }
                    if (mpos < 1 || mpos - 1 >= rlen) break;
                    z = rest[mpos - 1];
                }
            }
            mpos += mrank;
            switch (bpos) {
                case 0: {
                    b0 = bval;
                    break;
                }
                case 1: {
                    b1 = bval;
                    break;
                }
                case 2: {
                    b2 = bval;
                    break;
                }
                default: {
                    brest[bpos - 3] = bval;
                }
            }
            ++bpos;
        }
        switch (bpos) {
            case 0: {
                return this.base.effectiveIndex();
            }
            case 1: {
                return this.base.effectiveIndex(b0);
            }
            case 2: {
                return this.base.effectiveIndex(b0, b1);
            }
        }
        return this.base.effectiveIndex(b0, b1, b2, brest);
    }

    public static /* varargs */ Object generalIndex(Array arr, boolean shared, Object ... indexes) {
        return ComposedArray.generalIndex(arr, shared, 0, indexes.length, indexes);
    }

    public static Object generalIndex(Array arr, boolean shared, int start, int nindexes, Object[] indexes) {
        boolean allInts = true;
        for (int i = 0; i < nindexes; ++i) {
            Object index = indexes[start + i];
            if (index instanceof Number) continue;
            if (index instanceof Lazy) {
                indexes[start + i] = index = Promise.force(index);
                if (index instanceof Number) continue;
                allInts = false;
                continue;
            }
            allInts = false;
        }
        boolean linear = true;
        if (allInts && !shared) {
            switch (nindexes) {
                case 0: {
                    return arr.get();
                }
                case 1: {
                    return arr.get(((Number)indexes[start]).intValue());
                }
                case 2: {
                    return arr.get(((Number)indexes[start]).intValue(), ((Number)indexes[start + 1]).intValue());
                }
            }
            int[] rest = nindexes == 3 ? AbstractSequence.noInts : new int[nindexes];
            for (int i = 3; i < nindexes; ++i) {
                rest[i - 3] = ((Number)indexes[start + i]).intValue();
            }
            return arr.get(((Number)indexes[start]).intValue(), ((Number)indexes[start + 1]).intValue(), ((Number)indexes[start + 2]).intValue(), rest);
        }
        Array[] aindexes = new Array[nindexes];
        int rank = 0;
        for (int i = 0; i < nindexes; ++i) {
            Range.IntRange iarr = Arrays.asIntArrayOrNull(indexes[start + i]);
            if (iarr == null) {
                throw new ClassCastException("index is not an integer or integer array " + indexes[start + i].getClass().getName());
            }
            aindexes[i] = iarr;
            int irank = iarr.rank();
            if (irank != 0) {
                if (!(iarr instanceof Range.IntRange)) {
                    linear = false;
                } else {
                    Range.IntRange r = iarr;
                    if (r.isUnbounded()) {
                        int ilow = arr.getLowBound(i);
                        int idim = arr.getSize(i);
                        IntNum istart = IntNum.valueOf(r.size != -2 ? r.istart : (r.istep >= 0 ? ilow : ilow + idim - 1));
                        IntNum istep = IntNum.valueOf(r.istep);
                        iarr = r.istep >= 0 ? Range.upto(istart, istep, IntNum.valueOf(ilow + idim), false) : Range.downto(istart, istep, IntNum.valueOf(ilow), true);
                        aindexes[i] = iarr;
                    }
                }
            }
            rank += irank;
        }
        if (!shared && arr instanceof SimpleVector) {
            if (linear && rank == 1 && nindexes == 1) {
                SimpleVector svec = (SimpleVector)arr;
                Range.IntRange range = (Range.IntRange)aindexes[0];
                return Sequences.copy(svec, range, false);
            }
            arr = ((SimpleVector)arr).asImmutable();
            shared = true;
        }
        int[] dimensions = new int[rank];
        int[] lowBounds = new int[rank];
        int k = 0;
        for (int i = 0; i < nindexes; ++i) {
            int j;
            Array iarr = aindexes[i];
            int irank = iarr.rank();
            int ilow = arr.getLowBound(i);
            int idim = arr.getSize(i);
            if (irank == 0) {
                j = iarr.getInt();
                if ((j -= ilow) < 0 || idim >= 0 && j >= idim) {
                    ComposedArray.throwBoundException(i, nindexes, arr, "value " + (j + ilow));
                }
            } else if (iarr instanceof Range.IntRange) {
                Range.IntRange r = (Range.IntRange)iarr;
                int ihigh = ilow + idim - 1;
                int rsize = r.size();
                int rstep = r.getStepInt();
                int istart = r.getStartInt();
                int ilast = r.getLastInt();
                if (rsize != 0 && idim != 0 && (istart < ilow || idim >= 0 && istart > ihigh || ilast < ilow || idim >= 0 && ilast > ihigh)) {
                    String msg = "range [" + istart + " <=: " + ilast + "]";
                    ComposedArray.throwBoundException(i, nindexes, arr, msg);
                }
            }
            for (j = 0; j < irank; ++j) {
                dimensions[k] = iarr.getSize(j);
                lowBounds[k] = iarr.getLowBound(j);
                ++k;
            }
        }
        if (linear && shared && arr instanceof GeneralArray) {
            GeneralArray garr = (GeneralArray)arr;
            int offset = garr.offset;
            int[] strides = new int[rank];
            k = 0;
            for (int i = 0; i < nindexes; ++i) {
                Array iarr = aindexes[i];
                int irank = iarr.rank();
                int istride = garr.strides[i];
                int ilow = garr.lowBounds[i];
                int idim = garr.dimensions[i];
                if (iarr.rank() == 0) {
                    int j = iarr.getInt();
                    offset += istride * (j - ilow);
                    continue;
                }
                Range.IntRange r = (Range.IntRange)iarr;
                int sz = r.size();
                int j = r.getStartInt();
                strides[k] = r.getStepInt() * istride;
                offset += istride * (j - ilow);
                ++k;
            }
            return GeneralArray.make(garr.getBase(), dimensions, lowBounds, strides, offset);
        }
        if (shared && rank == 1 && lowBounds[0] == 0) {
            if (arr instanceof List && aindexes.length == 1 && aindexes[0] instanceof IntSequence) {
                return new IndirectIndexedSeq((List)((Object)arr), (IntSequence)aindexes[0]);
            }
            return new AsSequence(arr, rank, dimensions, lowBounds, aindexes);
        }
        ComposedArray<E> carr = new ComposedArray<E>(arr, rank, dimensions, lowBounds, aindexes);
        if (shared) {
            return carr;
        }
        return Arrays.simpleCopy(carr, false);
    }

    private static void throwBoundException(int i, int nindexes, Array oldMapper, String index) {
        int ilow = oldMapper.getLowBound(i);
        int idim = oldMapper.getSize(i);
        StringBuilder sbuf = new StringBuilder();
        if (nindexes == 0) {
            sbuf.append("index ");
        } else {
            sbuf.append("index (");
            sbuf.append(i);
            sbuf.append(" of ");
            sbuf.append(nindexes);
            sbuf.append(") ");
        }
        sbuf.append(index);
        sbuf.append(" out of bounds [");
        sbuf.append(ilow);
        sbuf.append(" <: ");
        sbuf.append(idim + ilow);
        sbuf.append("]");
        throw new IndexOutOfBoundsException(sbuf.toString());
    }

    public static class AsSequence<E>
    extends ComposedArray<E>
    implements AVector<E> {
        public AsSequence(Array base2, int rank, int[] dims, int[] lowBounds, Array<Integer>[] mappers) {
            super(base2, rank, dims, lowBounds, mappers);
        }
    }

}

