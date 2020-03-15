// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Values;
import gnu.lists.Sequence;
import gnu.lists.Array;
import gnu.mapping.ProcedureN;

public class ArraySet extends ProcedureN
{
    public static final ArraySet arraySet;
    
    public static void arraySet(final Array array, final Sequence index, final Object value) {
        final int dims = index.size();
        final int[] indexes = new int[dims];
        for (int i = 0; i < dims; ++i) {
            indexes[i] = index.get(i).intValue();
        }
        array.set(indexes, value);
    }
    
    @Override
    public Object apply3(final Object arg0, final Object arg1, final Object arg2) throws Throwable {
        if (arg1 instanceof Sequence) {
            arraySet((Array)arg0, (Sequence)arg1, arg2);
            return Values.empty;
        }
        return super.apply3(arg0, arg1, arg2);
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        final Array array = (Array)args[0];
        if (args.length == 3) {
            final Object arg1 = args[1];
            if (arg1 instanceof Sequence) {
                arraySet(array, (Sequence)arg1, args[2]);
                return Values.empty;
            }
        }
        final int dim = args.length - 2;
        final int[] indexes = new int[dim];
        int i = dim;
        while (--i >= 0) {
            indexes[i] = ((Number)args[i + 1]).intValue();
        }
        array.set(indexes, args[dim + 1]);
        return Values.empty;
    }
    
    static {
        arraySet = new ArraySet();
    }
}
