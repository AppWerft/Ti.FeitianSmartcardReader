/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Filter;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import java.util.List;

public class SpecialObjectType
extends ObjectType {
    protected ClassType implementationType;

    public SpecialObjectType(String name, ClassType implementationType) {
        super(name);
        this.implementationType = implementationType;
        this.setSignature(implementationType.getSignature());
    }

    @Override
    public Field getField(String name, int mask) {
        return this.implementationType.getField(name, mask);
    }

    @Override
    public Method getMethod(String name, Type[] arg_types) {
        return this.implementationType.getMethod(name, arg_types);
    }

    public Method getDeclaredMethod(String name, int argCount) {
        return this.implementationType.getDeclaredMethod(name, argCount);
    }

    @Override
    public int getMethods(Filter filter, int searchSupers, List<Method> result) {
        return this.implementationType.getMethods(filter, searchSupers, result);
    }

    @Override
    public Class getReflectClass() {
        return this.implementationType.getReflectClass();
    }

    @Override
    public Type getRealType() {
        return this.implementationType;
    }

    @Override
    public Type getImplementationType() {
        return this.implementationType;
    }

    @Override
    public int compare(Type other) {
        if (this == toStringType) {
            return other == this || other == Type.javalangStringType ? 0 : (other == Type.javalangObjectType ? -1 : 1);
        }
        return super.compare(other);
    }
}

