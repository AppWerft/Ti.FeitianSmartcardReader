/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.lists.Array;
import gnu.lists.Sequence;
import gnu.mapping.ProcedureN;
import gnu.mapping.Values;

public class ArraySet
extends ProcedureN {
    public static final ArraySet arraySet = new ArraySet();

    public static void arraySet(Array array, Sequence index, Object value) {
        int dims = index.size();
        int[] indexes = new int[dims];
        for (int i = 0; i < dims; ++i) {
            indexes[i] = ((Number)index.get(i)).intValue();
        }
        array.set(indexes, value);
    }

    @Override
    public Object apply3(Object arg0, Object arg1, Object arg2) throws Throwable {
        if (arg1 instanceof Sequence) {
            ArraySet.arraySet((Array)arg0, (Sequence)arg1, arg2);
            return Values.empty;
        }
        return super.apply3(arg0, arg1, arg2);
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        Object arg1;
        Array array = (Array)args[0];
        if (args.length == 3 && (arg1 = args[1]) instanceof Sequence) {
            ArraySet.arraySet(array, (Sequence)arg1, args[2]);
            return Values.empty;
        }
        int dim = args.length - 2;
        int[] indexes = new int[dim];
        int i = dim;
        while (--i >= 0) {
            indexes[i] = ((Number)args[i + 1]).intValue();
        }
        array.set(indexes, args[dim + 1]);
        return Values.empty;
    }
}

