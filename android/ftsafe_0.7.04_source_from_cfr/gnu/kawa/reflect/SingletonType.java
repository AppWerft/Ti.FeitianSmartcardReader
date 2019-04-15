/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.kawa.reflect.OccurrenceType;
import gnu.mapping.Values;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class SingletonType
extends ObjectType
implements Externalizable {
    static final SingletonType instance = new SingletonType("singleton");

    public SingletonType(String name) {
        super(name);
    }

    public static final SingletonType getInstance() {
        return instance;
    }

    public static final SingletonType valueOf() {
        return instance;
    }

    @Override
    public Class getReflectClass() {
        return this.getImplementationType().getReflectClass();
    }

    @Override
    public Type getImplementationType() {
        return Type.pointer_type;
    }

    @Override
    public int compare(Type other) {
        int otherRange = OccurrenceType.itemCountRange(other);
        int otherMin = otherRange & 4095;
        int otherMax = otherRange >> 12;
        if (otherMax == 0 || otherMin > 1) {
            return -3;
        }
        if (otherMin == 1 && otherMax == 1) {
            return Type.pointer_type.compare(other);
        }
        int cmp = Type.pointer_type.compare(other);
        if (cmp == 0 || cmp == -1) {
            return -1;
        }
        return -2;
    }

    public static Object coerceToSingleton(Object obj) {
        if (obj instanceof Values) {
            obj = ((Values)obj).canonicalize();
        }
        if (obj == null || obj instanceof Values) {
            throw new ClassCastException("value is not a singleton");
        }
        return obj;
    }

    @Override
    public Object coerceFromObject(Object obj) {
        return SingletonType.coerceToSingleton(obj);
    }

    @Override
    public void emitCoerceFromObject(CodeAttr code) {
        code.emitInvokeStatic(ClassType.make("gnu.kawa.reflect.SingletonType").getDeclaredMethod("coerceToSingleton", 1));
    }

    @Override
    public boolean isInstance(Object obj) {
        return obj != null && !(obj instanceof Values);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    }

    public Object readResolve() throws ObjectStreamException {
        return instance;
    }
}

