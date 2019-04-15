/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.Type;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;

public class ArrayNew
extends Procedure1
implements Externalizable {
    Type element_type;

    public ArrayNew(Type element_type) {
        this.element_type = element_type;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileArrays:validateArrayNew");
        this.setProperty(Procedure.compilerXKey, "gnu.kawa.reflect.CompileArrays:compileNew");
    }

    @Override
    public boolean isSideEffectFree() {
        return true;
    }

    @Override
    public Object apply1(Object count) {
        Class clas = this.element_type.getImplementationType().getReflectClass();
        return Array.newInstance(clas, ((Number)count).intValue());
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.element_type);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.element_type = (Type)in.readObject();
    }
}

