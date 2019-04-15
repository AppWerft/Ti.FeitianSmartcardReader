/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import java.lang.reflect.Array;

public class ArrayMake
extends ProcedureN {
    Type elementType;
    public static final ArrayMake makeObjectArray = new ArrayMake(Type.objectType);

    public ArrayMake(Type elementType) {
        this.elementType = elementType;
        this.setProperty(Procedure.compilerXKey, "gnu.kawa.reflect.CompileArrays:compileMake");
    }

    public static ArrayMake getInstance(Type elementType) {
        return elementType == Type.objectType ? makeObjectArray : new ArrayMake(elementType);
    }

    @Override
    public Object applyN(Object[] args) {
        int nlen = args.length;
        if (this.elementType == Type.objectType) {
            Object[] arr = new Object[nlen];
            System.arraycopy(args, 0, arr, 0, nlen);
            return arr;
        }
        Class clas = this.elementType.getImplementationType().getReflectClass();
        Object arr = Array.newInstance(clas, nlen);
        for (int i = 0; i < nlen; ++i) {
            Object val = this.elementType.coerceFromObject(args[i]);
            Array.set(arr, i, val);
        }
        return arr;
    }

    @Override
    public String toString() {
        return "#<procedure ArrayMake[" + this.elementType + "]>";
    }
}

