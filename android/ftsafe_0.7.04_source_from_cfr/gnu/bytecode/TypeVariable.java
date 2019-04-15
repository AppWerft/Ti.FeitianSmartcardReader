/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import java.lang.reflect.ParameterizedType;

public class TypeVariable
extends ObjectType {
    ClassType rawType;
    java.lang.reflect.TypeVariable rtype;

    public TypeVariable(String name) {
        super(name);
    }

    public static TypeVariable make(java.lang.reflect.TypeVariable rtype) {
        TypeVariable tvar = new TypeVariable(rtype.getName());
        tvar.rawType = Type.objectType;
        java.lang.reflect.Type[] bounds = rtype.getBounds();
        Type bound = null;
        if (bounds.length == 1) {
            java.lang.reflect.Type bound0 = bounds[0];
            if (bound0 instanceof Class) {
                bound = Type.make(bound0);
            } else if (bound0 instanceof ParameterizedType) {
                bound = Type.make(((ParameterizedType)bound0).getRawType());
            }
        }
        if (bound != null) {
            bound = bound.getRawType();
        }
        if (bound instanceof ClassType) {
            tvar.rawType = (ClassType)bound;
        }
        tvar.rtype = rtype;
        return tvar;
    }

    @Override
    public int compare(Type other) {
        return this.rawType.compare(other);
    }

    @Override
    public ClassType getRawType() {
        return this.rawType;
    }

    @Override
    public void emitCoerceFromObject(CodeAttr code) {
        this.rawType.emitCoerceFromObject(code);
    }

    @Override
    public String getSignature() {
        return this.getRawType().getSignature();
    }

    public boolean equals(Object other) {
        if (!(other instanceof TypeVariable)) {
            return false;
        }
        TypeVariable tvother = (TypeVariable)other;
        return Type.isSame(this.rawType, tvother.rawType) && this.getName().equals(tvother.getName());
    }
}

