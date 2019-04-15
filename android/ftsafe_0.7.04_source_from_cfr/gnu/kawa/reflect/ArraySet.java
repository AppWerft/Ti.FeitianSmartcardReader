/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure3;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;

public class ArraySet
extends Procedure3
implements Externalizable {
    Type element_type;

    public ArraySet(Type element_type) {
        this.element_type = element_type;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileArrays:validateArraySet");
        this.setProperty(Procedure.compilerXKey, "gnu.kawa.reflect.CompileArrays:compileSet");
    }

    @Override
    public Object apply3(Object array, Object index, Object value) {
        value = this.element_type.coerceFromObject(value);
        if (this.element_type instanceof PrimType) {
            value = ((PrimType)this.element_type).convertToRaw(value);
        }
        Array.set(array, ((Number)index).intValue(), value);
        return Values.empty;
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

