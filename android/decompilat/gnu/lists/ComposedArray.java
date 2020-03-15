// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.util.List;
import gnu.math.IntNum;
import gnu.mapping.Promise;
import gnu.mapping.Lazy;

public class ComposedArray<E> extends TransformedArray<E>
{
    Array<Integer>[] mappers;
    int rank;
    int[] dims;
    int[] lowBounds;
    
    public ComposedArray(final Array base, final int rank, final int[] dims, final int[] lowBounds, final Array<Integer>[] mappers) {
        super(base);
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
    public int getLowBound(final int dim) {
        return this.lowBounds[dim];
    }
    
    @Override
    public int getSize(final int dim) {
        return this.dims[dim];
    }
    
    @Override
    public final int effectiveIndex() {
        return this.resolve(0, 0, 0, ComposedArray.noInts);
    }
    
    @Override
    public final int effectiveIndex(final int i) {
        return this.resolve(i, 0, 0, ComposedArray.noInts);
    }
    
    @Override
    public final int effectiveIndex(final int i, final int j) {
        return this.resolve(i, j, 0, ComposedArray.noInts);
    }
    
    @Override
    public final int effectiveIndex(final int i, final int j, final int k, final int... rest) {
        return this.resolve(i, j, k, rest);
    }
    
    private int resolve(int x, int y, int z, final int... rest) {
        final int brank = this.base.rank();
        final int rlen = rest.length;
        int b0 = 0;
        int b2 = 0;
        int b3 = 0;
        final int[] brest = (brank > 3) ? new int[brank - 3] : ComposedArray.noInts;
        int bpos = 0;
        int mpos = 0;
        for (int i = 0; i < brank; ++i) {
            final Array<Integer> mapper = this.mappers[i];
            final int mrank = mapper.rank();
            int bval = 0;
            switch (mrank) {
                case 0: {
                    bval = mapper.getInt();
                    break;
                }
                case 1: {
                    bval = mapper.getInt(x);
                    x = y;
                    y = z;
                    if (mpos >= 3 && mpos - 3 < rlen) {
                        z = rest[mpos - 3];
                        break;
                    }
                    break;
                }
                case 2: {
                    bval = mapper.getInt(x, y);
                    x = z;
                    if (mpos < 3 || mpos - 3 >= rlen) {
                        break;
                    }
                    y = rest[mpos - 3];
                    if (mpos >= 2 && mpos - 2 < rlen) {
                        z = rest[mpos - 2];
                        break;
                    }
                    break;
                }
                default: {
                    int[] tmp;
                    if (mrank == 3) {
                        tmp = ComposedArray.noInts;
                    }
                    else {
                        tmp = new int[mrank - 3];
                        System.arraycopy(rest, mpos - 3, tmp, 0, mrank - 3);
                    }
                    bval = mapper.getInt(x, y, z, tmp);
                    if (mpos < 3 || mpos - 3 >= rlen) {
                        break;
                    }
                    x = rest[mpos - 3];
                    if (mpos >= 2 && mpos - 2 < rlen) {
                        y = rest[mpos - 2];
                    }
                    if (mpos >= 1 && mpos - 1 < rlen) {
                        z = rest[mpos - 1];
                        break;
                    }
                    break;
                }
            }
            mpos += mrank;
            switch (bpos) {
                case 0: {
                    b0 = bval;
                    break;
                }
                case 1: {
                    b2 = bval;
                    break;
                }
                case 2: {
                    b3 = bval;
                    break;
                }
                default: {
                    brest[bpos - 3] = bval;
                    break;
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
                return this.base.effectiveIndex(b0, b2);
            }
            default: {
                return this.base.effectiveIndex(b0, b2, b3, brest);
            }
        }
    }
    
    public static Object generalIndex(final Array arr, final boolean shared, final Object... indexes) {
        return generalIndex(arr, shared, 0, indexes.length, indexes);
    }
    
    public static Object generalIndex(Array arr, boolean shared, final int start, final int nindexes, final Object[] indexes) {
        boolean allInts = true;
        for (int i = 0; i < nindexes; ++i) {
            Object index = indexes[start + i];
            if (!(index instanceof Number)) {
                if (index instanceof Lazy) {
                    index = Promise.force(index);
                    indexes[start + i] = index;
                    if (!(index instanceof Number)) {
                        allInts = false;
                    }
                }
                else {
                    allInts = false;
                }
            }
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
                default: {
                    final int[] rest = (nindexes == 3) ? AbstractSequence.noInts : new int[nindexes];
                    for (int j = 3; j < nindexes; ++j) {
                        rest[j - 3] = ((Number)indexes[start + j]).intValue();
                    }
                    return arr.get(((Number)indexes[start]).intValue(), ((Number)indexes[start + 1]).intValue(), ((Number)indexes[start + 2]).intValue(), rest);
                }
            }
        }
        else {
            final Array<Integer>[] aindexes = (Array<Integer>[])new Array[nindexes];
            int rank = 0;
            for (int k = 0; k < nindexes; ++k) {
                Array<Integer> iarr = Arrays.asIntArrayOrNull(indexes[start + k]);
                if (iarr == null) {
                    throw new ClassCastException("index is not an integer or integer array " + indexes[start + k].getClass().getName());
                }
                aindexes[k] = iarr;
                final int irank = iarr.rank();
                if (irank != 0) {
                    if (!(iarr instanceof Range.IntRange)) {
                        linear = false;
                    }
                    else {
                        final Range.IntRange r = (Range.IntRange)iarr;
                        if (r.isUnbounded()) {
                            final int ilow = arr.getLowBound(k);
                            final int idim = arr.getSize(k);
                            final IntNum istart = IntNum.valueOf((r.size != -2) ? r.istart : ((r.istep >= 0) ? ilow : (ilow + idim - 1)));
                            final IntNum istep = IntNum.valueOf(r.istep);
                            if (r.istep >= 0) {
                                iarr = Range.upto(istart, istep, IntNum.valueOf(ilow + idim), false);
                            }
                            else {
                                iarr = Range.downto(istart, istep, IntNum.valueOf(ilow), true);
                            }
                            aindexes[k] = iarr;
                        }
                    }
                }
                rank += irank;
            }
            if (!shared && arr instanceof SimpleVector) {
                if (linear && rank == 1 && nindexes == 1) {
                    final SimpleVector svec = (SimpleVector)arr;
                    final Range.IntRange range = (Range.IntRange)aindexes[0];
                    return Sequences.copy(svec, range, false);
                }
                arr = ((SimpleVector)arr).asImmutable();
                shared = true;
            }
            final int[] dimensions = new int[rank];
            final int[] lowBounds = new int[rank];
            int l = 0;
            for (int m = 0; m < nindexes; ++m) {
                final Array<Integer> iarr2 = aindexes[m];
                final int irank2 = iarr2.rank();
                final int ilow2 = arr.getLowBound(m);
                final int idim2 = arr.getSize(m);
                if (irank2 == 0) {
                    int j2 = iarr2.getInt();
                    j2 -= ilow2;
                    if (j2 < 0 || (idim2 >= 0 && j2 >= idim2)) {
                        throwBoundException(m, nindexes, arr, "value " + (j2 + ilow2));
                    }
                }
                else if (iarr2 instanceof Range.IntRange) {
                    final Range.IntRange r2 = (Range.IntRange)iarr2;
                    final int ihigh = ilow2 + idim2 - 1;
                    final int rsize = r2.size();
                    final int rstep = r2.getStepInt();
                    final int istart2 = r2.getStartInt();
                    final int ilast = r2.getLastInt();
                    if (rsize != 0 && idim2 != 0 && (istart2 < ilow2 || (idim2 >= 0 && istart2 > ihigh) || ilast < ilow2 || (idim2 >= 0 && ilast > ihigh))) {
                        final String msg = "range [" + istart2 + " <=: " + ilast + "]";
                        throwBoundException(m, nindexes, arr, msg);
                    }
                }
                for (int j2 = 0; j2 < irank2; ++j2) {
                    dimensions[l] = iarr2.getSize(j2);
                    lowBounds[l] = iarr2.getLowBound(j2);
                    ++l;
                }
            }
            if (linear && shared && arr instanceof GeneralArray) {
                final GeneralArray garr = (GeneralArray)arr;
                int offset = garr.offset;
                final int[] strides = new int[rank];
                l = 0;
                for (int i2 = 0; i2 < nindexes; ++i2) {
                    final Array<Integer> iarr3 = aindexes[i2];
                    final int irank3 = iarr3.rank();
                    final int istride = garr.strides[i2];
                    final int ilow3 = garr.lowBounds[i2];
                    final int idim3 = garr.dimensions[i2];
                    if (iarr3.rank() == 0) {
                        final int j3 = iarr3.getInt();
                        offset += istride * (j3 - ilow3);
                    }
                    else {
                        final Range.IntRange r3 = (Range.IntRange)iarr3;
                        final int sz = r3.size();
                        final int j4 = r3.getStartInt();
                        strides[l] = r3.getStepInt() * istride;
                        offset += istride * (j4 - ilow3);
                        ++l;
                    }
                }
                return GeneralArray.make(garr.getBase(), dimensions, lowBounds, strides, offset);
            }
            if (shared && rank == 1 && lowBounds[0] == 0) {
                if (arr instanceof List && aindexes.length == 1 && aindexes[0] instanceof IntSequence) {
                    return new IndirectIndexedSeq((List<Object>)arr, (IntSequence)aindexes[0]);
                }
                return new AsSequence(arr, rank, dimensions, lowBounds, aindexes);
            }
            else {
                final ComposedArray carr = new ComposedArray(arr, rank, dimensions, lowBounds, aindexes);
                if (shared) {
                    return carr;
                }
                return Arrays.simpleCopy((Array<Object>)carr, false);
            }
        }
    }
    
    private static void throwBoundException(final int i, final int nindexes, final Array oldMapper, final String index) {
        final int ilow = oldMapper.getLowBound(i);
        final int idim = oldMapper.getSize(i);
        final StringBuilder sbuf = new StringBuilder();
        if (nindexes == 0) {
            sbuf.append("index ");
        }
        else {
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
    
    public static class AsSequence<E> extends ComposedArray<E> implements AVector<E>
    {
        public AsSequence(final Array base, final int rank, final int[] dims, final int[] lowBounds, final Array<Integer>[] mappers) {
            super(base, rank, dims, lowBounds, mappers);
        }
    }
}
