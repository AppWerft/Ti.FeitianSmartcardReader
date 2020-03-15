// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.math.IntNum;
import java.lang.reflect.Array;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import java.io.Externalizable;
import gnu.mapping.Procedure1;

public class ArrayLength extends Procedure1 implements Externalizable
{
    Type element_type;
    
    public ArrayLength(final Type element_type) {
        this.element_type = element_type;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileArrays:validateArrayLength");
        this.setProperty(Procedure.compilerXKey, "gnu.kawa.reflect.CompileArrays:compileLength");
    }
    
    @Override
    public Object apply1(final Object array) {
        return IntNum.make(Array.getLength(array));
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
