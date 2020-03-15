// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Procedure;
import gnu.lists.Sequence;
import gnu.lists.Array;
import gnu.mapping.ProcedureN;

public class ArrayRef extends ProcedureN
{
    public static final ArrayRef arrayRef;
    
    public static Object arrayRef(final Array array, final Sequence index) {
        final int dims = index.size();
        final int[] indexes = new int[dims];
        for (int i = 0; i < dims; ++i) {
            indexes[i] = index.getInt(i);
        }
        return array.get(indexes);
    }
    
    @Override
    public Object apply2(final Object arg0, final Object arg1) throws Throwable {
        if (arg1 instanceof Sequence) {
            return arrayRef((Array)arg0, (Sequence)arg1);
        }
        return super.apply2(arg0, arg1);
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        final Array array = (Array)args[0];
        if (args.length == 2) {
            final Object arg1 = args[1];
            if (arg1 instanceof Sequence) {
                return arrayRef(array, (Sequence)arg1);
            }
        }
        final int[] indexes = new int[args.length - 1];
        int i = args.length - 1;
        while (--i >= 0) {
            indexes[i] = ((Number)args[i + 1]).intValue();
        }
        return array.get(indexes);
    }
    
    static {
        (arrayRef = new ArrayRef()).setSetter(ArraySet.arraySet);
    }
}
