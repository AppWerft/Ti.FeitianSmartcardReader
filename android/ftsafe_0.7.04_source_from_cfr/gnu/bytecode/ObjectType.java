/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Filter;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import java.util.List;
import java.util.Vector;

public class ObjectType
extends Type {
    static final int ADD_FIELDS_DONE = 1;
    static final int ADD_METHODS_DONE = 2;
    static final int ADD_MEMBERCLASSES_DONE = 4;
    static final int ADD_ENCLOSING_DONE = 8;
    static final int EXISTING_CLASS = 16;
    static final int HAS_OUTER_LINK = 32;
    public int flags;

    protected ObjectType() {
        this.size = 4;
    }

    public ObjectType(String name) {
        this.this_name = name;
        this.size = 4;
    }

    @Override
    public final boolean isExisting() {
        Type t = this.getImplementationType();
        if (t instanceof ArrayType) {
            t = ((ArrayType)t).getComponentType();
        }
        if (t == this) {
            return (this.flags & 16) != 0;
        }
        return t.isExisting();
    }

    public final void setExisting(boolean existing) {
        this.flags = existing ? (this.flags |= 16) : (this.flags &= -17);
    }

    public String getInternalName() {
        return this.getName().replace('.', '/');
    }

    public static Class getContextClass(String cname) throws ClassNotFoundException {
        return Class.forName(cname, false, ObjectType.getContextClassLoader());
    }

    public static ClassLoader getContextClassLoader() {
        try {
            return Thread.currentThread().getContextClassLoader();
        }
        catch (SecurityException ex) {
            return ObjectType.class.getClassLoader();
        }
    }

    @Override
    public Class getReflectClass() {
        block3 : {
            try {
                if (this.reflectClass == null) {
                    this.reflectClass = ObjectType.getContextClass(this.getInternalName().replace('/', '.'));
                }
                this.setExisting(true);
            }
            catch (ClassNotFoundException ex) {
                if ((this.flags & 16) == 0) break block3;
                throw new RuntimeException("no such class: " + this.getName(), ex);
            }
        }
        return this.reflectClass;
    }

    @Override
    public boolean isInstance(Object obj) {
        if (this == nullType) {
            return obj == null;
        }
        return super.isInstance(obj);
    }

    public Field getField(String name, int mask) {
        return null;
    }

    public Method getMethod(String name, Type[] arg_types) {
        return Type.objectType.getMethod(name, arg_types);
    }

    @Deprecated
    public final int getMethods(Filter filter, int searchSupers, Vector result, String context) {
        return this.getMethods(filter, searchSupers, result);
    }

    public int getMethods(Filter filter, int searchSupers, List<Method> result) {
        return Type.objectType.getMethods(filter, searchSupers, result);
    }

    @Override
    public int compare(Type other) {
        if (this == other) {
            return 0;
        }
        if (this == nullType) {
            return -1;
        }
        return -3;
    }

    @Override
    public Object coerceFromObject(Object obj) {
        if (obj != null) {
            Class<?> objClass;
            if (this == Type.toStringType) {
                return obj.toString();
            }
            Class clas = this.getReflectClass();
            if (!clas.isAssignableFrom(objClass = obj.getClass())) {
                throw new ClassCastException("don't know how to coerce " + objClass.getName() + " to " + this.getName());
            }
        }
        return obj;
    }

    @Override
    public void emitCoerceFromObject(CodeAttr code) {
        if (this == Type.toStringType) {
            code.emitDup();
            code.emitIfNull();
            code.emitPop(1);
            code.emitPushNull();
            code.emitElse();
            code.emitInvokeVirtual(Type.toString_method);
            code.emitFi();
        } else if (this != Type.objectType) {
            code.emitCheckcast(this);
        }
    }
}

