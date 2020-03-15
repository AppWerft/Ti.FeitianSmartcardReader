// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import gnu.lists.LList;
import gnu.lists.FVector;
import gnu.mapping.ProcedureN;

public class vector_append extends ProcedureN
{
    public static final vector_append vectorAppend;
    
    public vector_append(final String name) {
        super(name);
    }
    
    @Override
    public Object applyN(final Object[] args) {
        return apply$V(args);
    }
    
    public static FVector apply$V(final Object[] args) {
        return new FVector(appendToArray(args));
    }
    
    public static Object[] appendToArray(final Object[] args) {
        int length = 0;
        int i;
        final int args_length = i = args.length;
        while (--i >= 0) {
            final Object arg = args[i];
            if (arg instanceof FVector) {
                length += ((FVector)arg).size();
            }
            else {
                final int n = LList.listLength(arg, false);
                if (n < 0) {
                    throw new WrongType(vector_append.vectorAppend, i, arg, "list or vector");
                }
                length += n;
            }
        }
        final Object[] result = new Object[length];
        int position = 0;
        for (Object arg2 : args) {
            if (arg2 instanceof FVector) {
                final FVector vec = (FVector)arg2;
                for (int vec_length = vec.size(), k = 0; k < vec_length; ++k) {
                    result[position++] = vec.get(k);
                }
            }
            else if (arg2 instanceof Pair) {
                while (arg2 != LList.Empty) {
                    final Pair pair = (Pair)arg2;
                    result[position++] = pair.getCar();
                    arg2 = pair.getCdr();
                }
            }
        }
        return result;
    }
    
    static {
        vectorAppend = new vector_append("vector-append");
    }
}
