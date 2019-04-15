/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.functions.ArraySet;
import gnu.lists.Array;
import gnu.lists.Sequence;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;

public class ArrayRef
extends ProcedureN {
    public static final ArrayRef arrayRef = new ArrayRef();

    public static Object arrayRef(Array array, Sequence index) {
        int dims = index.size();
        int[] indexes = new int[dims];
        for (int i = 0; i < dims; ++i) {
            indexes[i] = index.getInt(i);
        }
        return array.get(indexes);
    }

    @Override
    public Object apply2(Object arg0, Object arg1) throws Throwable {
        if (arg1 instanceof Sequence) {
            return ArrayRef.arrayRef((Array)arg0, (Sequence)arg1);
        }
        return super.apply2(arg0, arg1);
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        Object arg1;
        Array array = (Array)args[0];
        if (args.length == 2 && (arg1 = args[1]) instanceof Sequence) {
            return ArrayRef.arrayRef(array, (Sequence)arg1);
        }
        int[] indexes = new int[args.length - 1];
        int i = args.length - 1;
        while (--i >= 0) {
            indexes[i] = ((Number)args[i + 1]).intValue();
        }
        return array.get(indexes);
    }

    static {
        arrayRef.setSetter(ArraySet.arraySet);
    }
}

