/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.Type;

public class LazyType
extends ObjectType {
    ClassType rawType;
    Type valueType;
    ParameterizedType implementationType;
    public static final ClassType lazyType = ClassType.make("gnu.mapping.Lazy");
    public static final ClassType promiseType = ClassType.make("gnu.mapping.Promise");

    public Type getValueType() {
        return this.valueType;
    }

    @Override
    public Type getRawType() {
        return this.rawType;
    }

    public LazyType(ClassType rawType, Type valueType) {
        this.rawType = rawType;
        this.valueType = valueType;
    }

    @Override
    public Type getImplementationType() {
        if (this.implementationType == null) {
            this.implementationType = new ParameterizedType(this.rawType, this.valueType);
            this.implementationType.setTypeArgumentBound(0, '+');
        }
        return this.implementationType;
    }

    public static LazyType getInstance(ClassType rawType, Type valueType) {
        return new LazyType(rawType, valueType);
    }

    @Override
    public int compare(Type other) {
        return this.valueType.compare(other);
    }

    public static LazyType getLazyType(Type valueType) {
        return LazyType.getInstance(lazyType, valueType);
    }

    public static LazyType getPromiseType(Type valueType) {
        return LazyType.getInstance(promiseType, valueType);
    }

    @Override
    public String toString() {
        return this.rawType.toString() + '[' + this.valueType.toString() + ']';
    }

    public static boolean maybeLazy(Type type) {
        if ((type = type.getRawType()) instanceof ClassType && ((ClassType)type).implementsInterface(lazyType)) {
            return true;
        }
        return type == Type.objectType;
    }
}

