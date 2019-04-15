/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.lists.EmptyList;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongType;

public class vector_append
extends ProcedureN {
    public static final vector_append vectorAppend = new vector_append("vector-append");

    public vector_append(String name) {
        super(name);
    }

    @Override
    public Object applyN(Object[] args) {
        return vector_append.apply$V(args);
    }

    public static FVector apply$V(Object[] args) {
        return new FVector(vector_append.appendToArray(args));
    }

    public static Object[] appendToArray(Object[] args) {
        int args_length;
        int length = 0;
        int i = args_length = args.length;
        while (--i >= 0) {
            Object arg = args[i];
            if (arg instanceof FVector) {
                length += ((FVector)arg).size();
                continue;
            }
            int n = LList.listLength(arg, false);
            if (n < 0) {
                throw new WrongType((Procedure)vectorAppend, i, arg, "list or vector");
            }
            length += n;
        }
        Object[] result = new Object[length];
        int position = 0;
        for (int i2 = 0; i2 < args_length; ++i2) {
            Object arg = args[i2];
            if (arg instanceof FVector) {
                FVector vec = (FVector)arg;
                int vec_length = vec.size();
                for (int j = 0; j < vec_length; ++j) {
                    result[position++] = vec.get(j);
                }
                continue;
            }
            if (!(arg instanceof Pair)) continue;
            while (arg != LList.Empty) {
                Pair pair = (Pair)arg;
                result[position++] = pair.getCar();
                arg = pair.getCdr();
            }
        }
        return result;
    }
}

