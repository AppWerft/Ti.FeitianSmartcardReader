// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.mapping.Values;
import gnu.bytecode.Type;
import java.io.Externalizable;
import gnu.bytecode.ObjectType;

public class SingletonType extends ObjectType implements Externalizable
{
    static final SingletonType instance;
    
    public SingletonType(final String name) {
        super(name);
    }
    
    public static final SingletonType getInstance() {
        return SingletonType.instance;
    }
    
    public static final SingletonType valueOf() {
        return SingletonType.instance;
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
    public int compare(final Type other) {
        final int otherRange = OccurrenceType.itemCountRange(other);
        final int otherMin = otherRange & 0xFFF;
        final int otherMax = otherRange >> 12;
        if (otherMax == 0 || otherMin > 1) {
            return -3;
        }
        if (otherMin == 1 && otherMax == 1) {
            return Type.pointer_type.compare(other);
        }
        final int cmp = Type.pointer_type.compare(other);
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
    public Object coerceFromObject(final Object obj) {
        return coerceToSingleton(obj);
    }
    
    @Override
    public void emitCoerceFromObject(final CodeAttr code) {
        code.emitInvokeStatic(ClassType.make("gnu.kawa.reflect.SingletonType").getDeclaredMethod("coerceToSingleton", 1));
    }
    
    @Override
    public boolean isInstance(final Object obj) {
        return obj != null && !(obj instanceof Values);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
    }
    
    public Object readResolve() throws ObjectStreamException {
        return SingletonType.instance;
    }
    
    static {
        instance = new SingletonType("singleton");
    }
}
