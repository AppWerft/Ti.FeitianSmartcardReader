// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.mapping.Values;
import java.lang.reflect.Array;
import gnu.bytecode.PrimType;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import java.io.Externalizable;
import gnu.mapping.Procedure3;

public class ArraySet extends Procedure3 implements Externalizable
{
    Type element_type;
    
    public ArraySet(final Type element_type) {
        this.element_type = element_type;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileArrays:validateArraySet");
        this.setProperty(Procedure.compilerXKey, "gnu.kawa.reflect.CompileArrays:compileSet");
    }
    
    @Override
    public Object apply3(final Object array, final Object index, Object value) {
        value = this.element_type.coerceFromObject(value);
        if (this.element_type instanceof PrimType) {
            value = ((PrimType)this.element_type).convertToRaw(value);
        }
        Array.set(array, ((Number)index).intValue(), value);
        return Values.empty;
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
