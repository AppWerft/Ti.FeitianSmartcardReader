// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import java.lang.reflect.Array;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import gnu.mapping.ProcedureN;

public class ArrayMake extends ProcedureN
{
    Type elementType;
    public static final ArrayMake makeObjectArray;
    
    public ArrayMake(final Type elementType) {
        this.elementType = elementType;
        this.setProperty(Procedure.compilerXKey, "gnu.kawa.reflect.CompileArrays:compileMake");
    }
    
    public static ArrayMake getInstance(final Type elementType) {
        return (elementType == Type.objectType) ? ArrayMake.makeObjectArray : new ArrayMake(elementType);
    }
    
    @Override
    public Object applyN(final Object[] args) {
        final int nlen = args.length;
        if (this.elementType == Type.objectType) {
            final Object[] arr = new Object[nlen];
            System.arraycopy(args, 0, arr, 0, nlen);
            return arr;
        }
        final Class clas = this.elementType.getImplementationType().getReflectClass();
        final Object arr2 = Array.newInstance(clas, nlen);
        for (int i = 0; i < nlen; ++i) {
            final Object val = this.elementType.coerceFromObject(args[i]);
            Array.set(arr2, i, val);
        }
        return arr2;
    }
    
    @Override
    public String toString() {
        return "#<procedure ArrayMake[" + this.elementType + "]>";
    }
    
    static {
        makeObjectArray = new ArrayMake(Type.objectType);
    }
}
