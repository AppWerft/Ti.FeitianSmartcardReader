// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.bytecode.ParameterizedType;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;

public class LazyType extends ObjectType
{
    ClassType rawType;
    Type valueType;
    ParameterizedType implementationType;
    public static final ClassType lazyType;
    public static final ClassType promiseType;
    
    public Type getValueType() {
        return this.valueType;
    }
    
    @Override
    public Type getRawType() {
        return this.rawType;
    }
    
    public LazyType(final ClassType rawType, final Type valueType) {
        this.rawType = rawType;
        this.valueType = valueType;
    }
    
    @Override
    public Type getImplementationType() {
        if (this.implementationType == null) {
            (this.implementationType = new ParameterizedType(this.rawType, new Type[] { this.valueType })).setTypeArgumentBound(0, '+');
        }
        return this.implementationType;
    }
    
    public static LazyType getInstance(final ClassType rawType, final Type valueType) {
        return new LazyType(rawType, valueType);
    }
    
    @Override
    public int compare(final Type other) {
        return this.valueType.compare(other);
    }
    
    public static LazyType getLazyType(final Type valueType) {
        return getInstance(LazyType.lazyType, valueType);
    }
    
    public static LazyType getPromiseType(final Type valueType) {
        return getInstance(LazyType.promiseType, valueType);
    }
    
    @Override
    public String toString() {
        return this.rawType.toString() + '[' + this.valueType.toString() + ']';
    }
    
    public static boolean maybeLazy(Type type) {
        type = type.getRawType();
        return (type instanceof ClassType && ((ClassType)type).implementsInterface(LazyType.lazyType)) || type == Type.objectType;
    }
    
    static {
        lazyType = ClassType.make("gnu.mapping.Lazy");
        promiseType = ClassType.make("gnu.mapping.Promise");
    }
}
