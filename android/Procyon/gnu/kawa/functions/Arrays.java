// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.lists.Sequences;
import gnu.lists.TransformedArray;
import gnu.lists.AbstractSequence;
import gnu.math.IntNum;
import gnu.mapping.Values;
import gnu.mapping.Procedure;
import gnu.lists.SimpleVector;
import gnu.lists.F32Vector;
import gnu.lists.F64Vector;
import gnu.lists.U16Vector;
import gnu.lists.S16Vector;
import gnu.lists.U64Vector;
import gnu.lists.S64Vector;
import gnu.lists.U32Vector;
import gnu.lists.S32Vector;
import gnu.lists.U8Vector;
import gnu.lists.S8Vector;
import gnu.bytecode.PrimType;
import gnu.lists.Range;
import gnu.lists.IntSequence;
import gnu.lists.AVector;
import gnu.lists.GeneralArray;
import gnu.lists.FVector;
import gnu.lists.Array;

public class Arrays
{
    static final int[] shapeStrides;
    static final int[] zeros2;
    
    public static Array shape(final Object[] vals) {
        final int len = vals.length;
        if ((len & 0x1) != 0x0) {
            throw new RuntimeException("shape: not an even number of arguments");
        }
        final int d = len >> 1;
        final int[] dims = { d, 2 };
        return new GeneralArray(new FVector(vals), dims, null, Arrays.shapeStrides, 0);
    }
    
    public static GeneralArray allocateArray(final Array shape) {
        final int srank = shape.rank();
        final int rank = shape.getSize(0);
        if (srank != 1 && (srank != 2 || shape.getSize(1) != 2)) {
            throw new RuntimeException("array shape must be a sequence or a rank*2 array");
        }
        final int[] dimensions = new int[rank];
        int[] lowBounds = null;
        int i = rank;
        while (--i >= 0) {
            int lo;
            int hi;
            if (srank == 2) {
                lo = shape.getInt(i, 0);
                hi = shape.getInt(i, 1);
            }
            else if (shape instanceof IntSequence) {
                lo = 0;
                hi = ((IntSequence)shape).getInt(i);
            }
            else {
                final Object dim = shape.get(i);
                if (dim instanceof Range.IntRange) {
                    final Range.IntRange range = (Range.IntRange)dim;
                    if (range.getStepInt() != 1) {}
                    lo = range.getStartInt();
                    hi = range.size() + lo;
                }
                else {
                    lo = 0;
                    hi = ((Number)dim).intValue();
                }
            }
            if (lo > hi) {
                throw new RuntimeException("array dimension " + i + " has negative size");
            }
            dimensions[i] = hi - lo;
            if (lo == 0) {
                continue;
            }
            if (lowBounds == null) {
                lowBounds = new int[rank];
            }
            lowBounds[i] = lo;
        }
        return GeneralArray.make((AVector<Object>)null, dimensions, lowBounds, null, 0);
    }
    
    public static Array makeFromValues(final Array shape, final Object[] values) {
        final GeneralArray array = allocateArray(shape);
        final int total = array.getSize();
        final Object[] data = new Object[total];
        if (values != null && values.length > 0) {
            int j = 0;
            for (int i = 0; i < total; ++i) {
                data[i] = values[j];
                if (++j == values.length) {
                    j = 0;
                }
            }
        }
        array.setBase(data);
        return array;
    }
    
    public static Array makeFromSimple(final int[] dimensions, final int[] lowBounds, final Object buffer, final PrimType elementType) {
        char sig1;
        if (elementType == null) {
            sig1 = 'L';
        }
        else {
            sig1 = elementType.getSignature().charAt(0);
            if (elementType.isUnsigned()) {
                sig1 = Character.toLowerCase(sig1);
            }
        }
        final int rank = dimensions.length;
        SimpleVector base = null;
        switch (sig1) {
            case 'L': {
                base = new FVector((Object[])buffer);
                break;
            }
            case 'B': {
                base = new S8Vector((byte[])buffer);
                break;
            }
            case 'b': {
                base = new U8Vector((byte[])buffer);
                break;
            }
            case 'I': {
                base = new S32Vector((int[])buffer);
                break;
            }
            case 'i': {
                base = new U32Vector((int[])buffer);
                break;
            }
            case 'J': {
                base = new S64Vector((long[])buffer);
                break;
            }
            case 'j': {
                base = new U64Vector((long[])buffer);
                break;
            }
            case 'S': {
                base = new S16Vector((short[])buffer);
                break;
            }
            case 's': {
                base = new U16Vector((short[])buffer);
                break;
            }
            case 'D': {
                base = new F64Vector((double[])buffer);
                break;
            }
            case 'F': {
                base = new F32Vector((float[])buffer);
                break;
            }
            default: {
                throw new Error("bad type for makeFromSimple");
            }
        }
        if (rank == 1 && (lowBounds == null || lowBounds[0] == 0)) {
            return base;
        }
        return GeneralArray.makeSimple(lowBounds, dimensions, base);
    }
    
    public static Array makeSimple(final Array shape, final SimpleVector base) {
        final GeneralArray array = allocateArray(shape);
        array.setBase(base);
        return array;
    }
    
    private static int effectiveIndex(final Array array, final Procedure proc, final Object[] args, final int[] work) throws Throwable {
        final Object mapval = proc.applyN(args);
        if (mapval instanceof Values) {
            final Values mapvals = (Values)mapval;
            int i = 0;
            int j = 0;
            while ((i = mapvals.nextPos(i)) != 0) {
                work[j] = ((Number)mapvals.getPosPrevious(i)).intValue();
                ++j;
            }
        }
        else {
            work[0] = ((Number)mapval).intValue();
        }
        if (array instanceof GeneralArray) {
            return ((GeneralArray)array).resolve(work);
        }
        return work[0];
    }
    
    public static Array shareArray(final Array array, final Array shape, final Procedure proc) throws Throwable {
        final GeneralArray result = allocateArray(shape);
        final int rank = result.rank();
        final Object[] args = new Object[rank];
        final int[] dimensions = result.getDimensions();
        final int[] lowBounds = result.getLowBounds();
        final boolean empty = result.getSize() == 0;
        int i = rank;
        while (--i >= 0) {
            args[i] = result.getLowBound(i);
        }
        final int arank = array.rank();
        final int[] offsets = new int[rank];
        int offset0;
        if (empty) {
            offset0 = 0;
        }
        else {
            final int[] work = new int[arank];
            offset0 = effectiveIndex(array, proc, args, work);
            int j = rank;
            while (--j >= 0) {
                final int size = dimensions[j];
                final int lo = (lowBounds == null) ? 0 : lowBounds[j];
                if (size <= 1) {
                    offsets[j] = 0;
                }
                else {
                    final Object low = args[j];
                    args[j] = IntNum.make(lo + 1);
                    offsets[j] = effectiveIndex(array, proc, args, work) - offset0;
                    args[j] = low;
                }
            }
        }
        final AVector base = (array instanceof GeneralArray) ? ((GeneralArray)array).getBase() : array;
        result.setBase(base);
        result.setStrides(offsets, offset0);
        return result;
    }
    
    public static <E> Array<E> getBuiltArray(final Array shape, final Procedure procedure) {
        final GeneralArray ashape = allocateArray(shape);
        return new BuiltArray<E>(procedure, ashape.getDimensions(), ashape.getLowBounds());
    }
    
    public static <E> Array<E> getTransformed(final Array<E> base, final Procedure transformer, final Array shape) {
        final GeneralArray ashape = allocateArray(shape);
        return new ProcTransformedArray<E>(base, transformer, ashape.getDimensions(), ashape.getLowBounds());
    }
    
    static {
        shapeStrides = new int[] { 2, 1 };
        zeros2 = new int[2];
    }
    
    public static class BuiltArray<E> extends AbstractSequence<E> implements Array<E>
    {
        Procedure proc;
        int[] dims;
        int[] lowBounds;
        
        public BuiltArray(final Procedure proc, final int[] dimensions, final int[] lowBounds) {
            this.proc = proc;
            this.dims = dimensions;
            this.lowBounds = lowBounds;
        }
        
        @Override
        public int rank() {
            return this.dims.length;
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
        public E get() {
            return this.get(AbstractSequence.noInts);
        }
        
        @Override
        public E get(final int i) {
            return this.get(new int[] { i });
        }
        
        @Override
        public E get(final int i, final int j) {
            return this.get(new int[] { i, j });
        }
        
        @Override
        public E get(final int i, final int j, final int k, final int... rest) {
            if (rest.length == 0) {
                return this.get(new int[] { i, j, k });
            }
            final int[] indexes = new int[rest.length + 3];
            indexes[0] = i;
            indexes[1] = j;
            indexes[2] = k;
            System.arraycopy(rest, 0, indexes, 0, rest.length - 3);
            return this.get(indexes);
        }
        
        @Override
        public E get(final int[] indexes) {
            try {
                return (E)this.proc.apply1(new S32Vector(indexes));
            }
            catch (Throwable ex) {
                throw new RuntimeException("caught " + ex + " evaluating array procedure", ex);
            }
        }
        
        @Override
        public E getRaw(int effi) {
            final int[] indexes = new int[this.rank()];
            int i = this.rank();
            while (--i >= 0) {
                final int d = this.dims[i];
                indexes[i] = effi % d + this.lowBounds[i];
                effi /= d;
            }
            return this.get(indexes);
        }
    }
    
    public static class ProcTransformedArray<E> extends TransformedArray<E>
    {
        Procedure proc;
        int[] dims;
        int[] lowBounds;
        
        public ProcTransformedArray(final Array<E> base, final Procedure transformer, final int[] dimensions, final int[] lowBounds) {
            super(base);
            this.proc = transformer;
            this.dims = dimensions;
            this.lowBounds = lowBounds;
        }
        
        @Override
        public int rank() {
            return this.dims.length;
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
        public final int effectiveIndex(final int i, final int j) {
            return this.effectiveIndex(new int[] { i, j });
        }
        
        @Override
        public int effectiveIndex(final int[] indexes) {
            Object obj;
            try {
                obj = this.proc.apply1(indexes);
            }
            catch (Throwable ex) {
                throw new RuntimeException("index transformer throw " + ex, ex);
            }
            if (obj instanceof int[]) {
                return this.base.effectiveIndex((int[])obj);
            }
            final IntSequence ind = Sequences.asIntSequenceOrNull(obj);
            if (ind == null) {
                throw new ClassCastException("not an integer sequence");
            }
            if (ind instanceof S32Vector) {
                return this.base.effectiveIndex(((S32Vector)ind).getBuffer());
            }
            final int rank = ind.size();
            switch (rank) {
                case 0: {
                    return this.base.effectiveIndex();
                }
                case 1: {
                    return this.base.effectiveIndex(ind.getInt(0));
                }
                case 2: {
                    return this.base.effectiveIndex(ind.getInt(0), ind.getInt(1));
                }
                default: {
                    final int[] rest = (rank == 3) ? AbstractSequence.noInts : new int[rank - 3];
                    for (int i = 3; i < rank; ++i) {
                        rest[i - 3] = ind.getInt(i);
                    }
                    return this.base.effectiveIndex(ind.getInt(0), ind.getInt(1), ind.getInt(2), rest);
                }
            }
        }
    }
}
