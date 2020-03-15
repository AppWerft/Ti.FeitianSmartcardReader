// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.util.List;
import java.util.Vector;

public class ObjectType extends Type
{
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
    
    public ObjectType(final String name) {
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
            return (this.flags & 0x10) != 0x0;
        }
        return t.isExisting();
    }
    
    public final void setExisting(final boolean existing) {
        if (existing) {
            this.flags |= 0x10;
        }
        else {
            this.flags &= 0xFFFFFFEF;
        }
    }
    
    public String getInternalName() {
        return this.getName().replace('.', '/');
    }
    
    public static Class getContextClass(final String cname) throws ClassNotFoundException {
        return Class.forName(cname, false, getContextClassLoader());
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
        try {
            if (this.reflectClass == null) {
                this.reflectClass = getContextClass(this.getInternalName().replace('/', '.'));
            }
            this.setExisting(true);
        }
        catch (ClassNotFoundException ex) {
            if ((this.flags & 0x10) != 0x0) {
                throw new RuntimeException("no such class: " + this.getName(), ex);
            }
        }
        return this.reflectClass;
    }
    
    @Override
    public boolean isInstance(final Object obj) {
        if (this == ObjectType.nullType) {
            return obj == null;
        }
        return super.isInstance(obj);
    }
    
    public Field getField(final String name, final int mask) {
        return null;
    }
    
    public Method getMethod(final String name, final Type[] arg_types) {
        return Type.objectType.getMethod(name, arg_types);
    }
    
    @Deprecated
    public final int getMethods(final Filter filter, final int searchSupers, final Vector result, final String context) {
        return this.getMethods(filter, searchSupers, result);
    }
    
    public int getMethods(final Filter filter, final int searchSupers, final List<Method> result) {
        return Type.objectType.getMethods(filter, searchSupers, result);
    }
    
    @Override
    public int compare(final Type other) {
        if (this == other) {
            return 0;
        }
        if (this == ObjectType.nullType) {
            return -1;
        }
        return -3;
    }
    
    @Override
    public Object coerceFromObject(final Object obj) {
        if (obj != null) {
            if (this == Type.toStringType) {
                return obj.toString();
            }
            final Class clas = this.getReflectClass();
            final Class objClass = obj.getClass();
            if (!clas.isAssignableFrom(objClass)) {
                throw new ClassCastException("don't know how to coerce " + objClass.getName() + " to " + this.getName());
            }
        }
        return obj;
    }
    
    @Override
    public void emitCoerceFromObject(final CodeAttr code) {
        if (this == Type.toStringType) {
            code.emitDup();
            code.emitIfNull();
            code.emitPop(1);
            code.emitPushNull();
            code.emitElse();
            code.emitInvokeVirtual(Type.toString_method);
            code.emitFi();
        }
        else if (this != Type.objectType) {
            code.emitCheckcast(this);
        }
    }
}
