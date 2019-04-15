/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.PrimType;
import gnu.lists.AVector;
import gnu.lists.AbstractSequence;
import gnu.lists.Array;
import gnu.lists.F32Vector;
import gnu.lists.F64Vector;
import gnu.lists.FVector;
import gnu.lists.GeneralArray;
import gnu.lists.IntSequence;
import gnu.lists.Range;
import gnu.lists.S16Vector;
import gnu.lists.S32Vector;
import gnu.lists.S64Vector;
import gnu.lists.S8Vector;
import gnu.lists.Sequences;
import gnu.lists.SimpleVector;
import gnu.lists.TransformedArray;
import gnu.lists.U16Vector;
import gnu.lists.U32Vector;
import gnu.lists.U64Vector;
import gnu.lists.U8Vector;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class Arrays {
    static final int[] shapeStrides = new int[]{2, 1};
    static final int[] zeros2 = new int[2];

    public static Array shape(Object[] vals) {
        int len = vals.length;
        if ((len & 1) != 0) {
            throw new RuntimeException("shape: not an even number of arguments");
        }
        int d = len >> 1;
        int[] dims = new int[]{d, 2};
        return new GeneralArray(new FVector(vals), dims, null, shapeStrides, 0);
    }

    public static GeneralArray allocateArray(Array shape) {
        int srank = shape.rank();
        int rank = shape.getSize(0);
        if (srank != 1 && (srank != 2 || shape.getSize(1) != 2)) {
            throw new RuntimeException("array shape must be a sequence or a rank*2 array");
        }
        int[] dimensions = new int[rank];
        int[] lowBounds = null;
        int i = rank;
        while (--i >= 0) {
            int lo;
            int hi;
            if (srank == 2) {
                lo = shape.getInt(i, 0);
                hi = shape.getInt(i, 1);
            } else if (shape instanceof IntSequence) {
                lo = 0;
                hi = ((IntSequence)shape).getInt(i);
            } else {
                Object dim = shape.get(i);
                if (dim instanceof Range.IntRange) {
                    Range.IntRange range = (Range.IntRange)dim;
                    if (range.getStepInt() != 1) {
                        // empty if block
                    }
                    lo = range.getStartInt();
                    hi = range.size() + lo;
                } else {
                    lo = 0;
                    hi = ((Number)dim).intValue();
                }
            }
            if (lo > hi) {
                throw new RuntimeException("array dimension " + i + " has negative size");
            }
            dimensions[i] = hi - lo;
            if (lo == 0) continue;
            if (lowBounds == null) {
                lowBounds = new int[rank];
            }
            lowBounds[i] = lo;
        }
        return GeneralArray.make(null, dimensions, lowBounds, null, 0);
    }

    public static Array makeFromValues(Array shape, Object[] values) {
        GeneralArray array = Arrays.allocateArray(shape);
        int total = array.getSize();
        Object[] data = new Object[total];
        if (values != null && values.length > 0) {
            int j = 0;
            for (int i = 0; i < total; ++i) {
                data[i] = values[j];
                if (++j != values.length) continue;
                j = 0;
            }
        }
        array.setBase(data);
        return array;
    }

    public static Array makeFromSimple(int[] dimensions, int[] lowBounds, Object buffer, PrimType elementType) {
        SimpleVector base2;
        char sig1;
        if (elementType == null) {
            sig1 = 'L';
        } else {
            sig1 = elementType.getSignature().charAt(0);
            if (elementType.isUnsigned()) {
                sig1 = Character.toLowerCase(sig1);
            }
        }
        int rank = dimensions.length;
        switch (sig1) {
            case 'L': {
                base2 = new FVector((Object[])buffer);
                break;
            }
            case 'B': {
                base2 = new S8Vector((byte[])buffer);
                break;
            }
            case 'b': {
                base2 = new U8Vector((byte[])buffer);
                break;
            }
            case 'I': {
                base2 = new S32Vector((int[])buffer);
                break;
            }
            case 'i': {
                base2 = new U32Vector((int[])buffer);
                break;
            }
            case 'J': {
                base2 = new S64Vector((long[])buffer);
                break;
            }
            case 'j': {
                base2 = new U64Vector((long[])buffer);
                break;
            }
            case 'S': {
                base2 = new S16Vector((short[])buffer);
                break;
            }
            case 's': {
                base2 = new U16Vector((short[])buffer);
                break;
            }
            case 'D': {
                base2 = new F64Vector((double[])buffer);
                break;
            }
            case 'F': {
                base2 = new F32Vector((float[])buffer);
                break;
            }
            default: {
                throw new Error("bad type for makeFromSimple");
            }
        }
        if (rank == 1 && (lowBounds == null || lowBounds[0] == 0)) {
            return base2;
        }
        return GeneralArray.makeSimple(lowBounds, dimensions, base2);
    }

    public static Array makeSimple(Array shape, SimpleVector base2) {
        GeneralArray array = Arrays.allocateArray(shape);
        array.setBase(base2);
        return array;
    }

    private static int effectiveIndex(Array array, Procedure proc, Object[] args, int[] work) throws Throwable {
        Object mapval = proc.applyN(args);
        if (mapval instanceof Values) {
            Values mapvals = (Values)mapval;
            int i = 0;
            int j = 0;
            while ((i = mapvals.nextPos(i)) != 0) {
                work[j] = ((Number)mapvals.getPosPrevious(i)).intValue();
                ++j;
            }
        } else {
            work[0] = ((Number)mapval).intValue();
        }
        if (array instanceof GeneralArray) {
            return ((GeneralArray)array).resolve(work);
        }
        return work[0];
    }

    public static Array shareArray(Array array, Array shape, Procedure proc) throws Throwable {
        int offset0;
        GeneralArray result = Arrays.allocateArray(shape);
        int rank = result.rank();
        Object[] args = new Object[rank];
        int[] dimensions = result.getDimensions();
        int[] lowBounds = result.getLowBounds();
        boolean empty = result.getSize() == 0;
        int i = rank;
        while (--i >= 0) {
            args[i] = result.getLowBound(i);
        }
        int arank = array.rank();
        int[] offsets = new int[rank];
        if (empty) {
            offset0 = 0;
        } else {
            int[] work = new int[arank];
            offset0 = Arrays.effectiveIndex(array, proc, args, work);
            int i2 = rank;
            while (--i2 >= 0) {
                int lo;
                int size = dimensions[i2];
                int n = lo = lowBounds == null ? 0 : lowBounds[i2];
                if (size <= 1) {
                    offsets[i2] = 0;
                    continue;
                }
                Object low = args[i2];
                args[i2] = IntNum.make(lo + 1);
                offsets[i2] = Arrays.effectiveIndex(array, proc, args, work) - offset0;
                args[i2] = low;
            }
        }
        AVector base2 = array instanceof GeneralArray ? ((GeneralArray)array).getBase() : (AVector)array;
        result.setBase(base2);
        result.setStrides(offsets, offset0);
        return result;
    }

    public static <E> Array<E> getBuiltArray(Array shape, Procedure procedure) {
        GeneralArray ashape = Arrays.allocateArray(shape);
        return new BuiltArray(procedure, ashape.getDimensions(), ashape.getLowBounds());
    }

    public static <E> Array<E> getTransformed(Array<E> base2, Procedure transformer, Array shape) {
        GeneralArray ashape = Arrays.allocateArray(shape);
        return new ProcTransformedArray<E>(base2, transformer, ashape.getDimensions(), ashape.getLowBounds());
    }

    public static class ProcTransformedArray<E>
    extends TransformedArray<E> {
        Procedure proc;
        int[] dims;
        int[] lowBounds;

        public ProcTransformedArray(Array<E> base2, Procedure transformer, int[] dimensions, int[] lowBounds) {
            super(base2);
            this.proc = transformer;
            this.dims = dimensions;
            this.lowBounds = lowBounds;
        }

        @Override
        public int rank() {
            return this.dims.length;
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
        public final int effectiveIndex(int i, int j) {
            return this.effectiveIndex(new int[]{i, j});
        }

        @Override
        public int effectiveIndex(int[] indexes) {
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
            IntSequence ind = Sequences.asIntSequenceOrNull(obj);
            if (ind == null) {
                throw new ClassCastException("not an integer sequence");
            }
            if (ind instanceof S32Vector) {
                return this.base.effectiveIndex(((S32Vector)ind).getBuffer());
            }
            int rank = ind.size();
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
            }
            int[] rest = rank == 3 ? AbstractSequence.noInts : new int[rank - 3];
            for (int i = 3; i < rank; ++i) {
                rest[i - 3] = ind.getInt(i);
            }
            return this.base.effectiveIndex(ind.getInt(0), ind.getInt(1), ind.getInt(2), rest);
        }
    }

    public static class BuiltArray<E>
    extends AbstractSequence<E>
    implements Array<E> {
        Procedure proc;
        int[] dims;
        int[] lowBounds;

        public BuiltArray(Procedure proc, int[] dimensions, int[] lowBounds) {
            this.proc = proc;
            this.dims = dimensions;
            this.lowBounds = lowBounds;
        }

        @Override
        public int rank() {
            return this.dims.length;
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
        public E get() {
            return this.get(AbstractSequence.noInts);
        }

        @Override
        public E get(int i) {
            return this.get(new int[]{i});
        }

        @Override
        public E get(int i, int j) {
            return this.get(new int[]{i, j});
        }

        @Override
        public /* varargs */ E get(int i, int j, int k, int ... rest) {
            if (rest.length == 0) {
                return this.get(new int[]{i, j, k});
            }
            int[] indexes = new int[rest.length + 3];
            indexes[0] = i;
            indexes[1] = j;
            indexes[2] = k;
            System.arraycopy(rest, 0, indexes, 0, rest.length - 3);
            return this.get(indexes);
        }

        @Override
        public E get(int[] indexes) {
            try {
                return (E)this.proc.apply1(new S32Vector(indexes));
            }
            catch (Throwable ex) {
                throw new RuntimeException("caught " + ex + " evaluating array procedure", ex);
            }
        }

        @Override
        public E getRaw(int effi) {
            int[] indexes = new int[this.rank()];
            int i = this.rank();
            while (--i >= 0) {
                int d = this.dims[i];
                indexes[i] = effi % d + this.lowBounds[i];
                effi /= d;
            }
            return this.get(indexes);
        }
    }

}

