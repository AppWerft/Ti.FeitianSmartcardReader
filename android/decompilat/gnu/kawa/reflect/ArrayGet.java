// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import java.io.Externalizable;
import gnu.mapping.Procedure2;

public class ArrayGet extends Procedure2 implements Externalizable
{
    Type element_type;
    
    public ArrayGet(final Type element_type) {
        this.element_type = element_type;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileArrays:validateArrayGet");
        this.setProperty(Procedure.compilerXKey, "gnu.kawa.reflect.CompileArrays:compileGet");
    }
    
    @Override
    public Object apply2(final Object array, final Object index) {
        final Object value = Array.get(array, ((Number)index).intValue());
        return this.element_type.coerceToObject(value);
    }
    
    @Override
    public boolean isSideEffectFree() {
        return true;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.element_type);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.element_type = (Type)in.readObject();
    }
}
