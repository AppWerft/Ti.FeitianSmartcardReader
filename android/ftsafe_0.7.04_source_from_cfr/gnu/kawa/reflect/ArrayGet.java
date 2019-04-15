/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.Type;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;

public class ArrayGet
extends Procedure2
implements Externalizable {
    Type element_type;

    public ArrayGet(Type element_type) {
        this.element_type = element_type;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileArrays:validateArrayGet");
        this.setProperty(Procedure.compilerXKey, "gnu.kawa.reflect.CompileArrays:compileGet");
    }

    @Override
    public Object apply2(Object array, Object index) {
        Object value = Array.get(array, ((Number)index).intValue());
        return this.element_type.coerceToObject(value);
    }

    @Override
    public boolean isSideEffectFree() {
        return true;
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

