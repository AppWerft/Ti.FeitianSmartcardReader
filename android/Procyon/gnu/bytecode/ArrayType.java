// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.util.List;
import java.io.Externalizable;

public class ArrayType extends ObjectType implements Externalizable
{
    public Type elements;
    
    public ArrayType(final Type elements) {
        this(elements, elements.getName() + "[]");
    }
    
    ArrayType(final Type elements, final String name) {
        this.this_name = name;
        this.elements = elements;
    }
    
    @Override
    public String getSignature() {
        if (this.signature == null) {
            this.setSignature("[" + this.elements.getSignature());
        }
        return this.signature;
    }
    
    @Override
    public Type getImplementationType() {
        final Type eltype = this.elements.getImplementationType();
        return (this.elements == eltype) ? this : make(eltype);
    }
    
    @Override
    public Type getRawType() {
        final Type eltype = this.elements.getRawType();
        return (this.elements == eltype) ? this : make(eltype);
    }
    
    static ArrayType make(final String name) {
        final Type elements = Type.getType(name.substring(0, name.length() - 2));
        ArrayType array_type = elements.array_type;
        if (array_type == null) {
            array_type = new ArrayType(elements, name);
            elements.array_type = array_type;
        }
        return array_type;
    }
    
    public static ArrayType make(final Type elements) {
        ArrayType array_type = elements.array_type;
        if (array_type == null) {
            array_type = new ArrayType(elements, elements.getName() + "[]");
            elements.array_type = array_type;
        }
        return array_type;
    }
    
    public Type getComponentType() {
        return this.elements;
    }
    
    @Override
    public String getInternalName() {
        return this.getSignature();
    }
    
    @Override
    public Class getReflectClass() {
        try {
            if (this.reflectClass == null) {
                final String cname = this.getInternalName().replace('/', '.');
                final Class elClass = this.elements.getReflectClass();
                this.reflectClass = Class.forName(cname, false, elClass.getClassLoader());
            }
            this.flags |= 0x10;
        }
        catch (ClassNotFoundException ex) {
            if ((this.flags & 0x10) != 0x0) {
                final RuntimeException rex = new RuntimeException("no such array class: " + this.getName());
                rex.initCause(ex);
                throw rex;
            }
        }
        return this.reflectClass;
    }
    
    @Override
    public int getMethods(final Filter filter, final int searchSupers, final List<Method> result) {
        if (searchSupers > 0) {
            int count = Type.objectType.getMethods(filter, 0, result);
            if (searchSupers > 1 && filter.select(Type.clone_method)) {
                if (result != null) {
                    final Method meth = Type.clone_method;
                    result.add(meth);
                }
                ++count;
            }
            return count;
        }
        return 0;
    }
    
    @Override
    public int isCompatibleWithValue(final Type valueType) {
        if (valueType instanceof ArrayType) {
            return this.getComponentType().isCompatibleWithValue(((ArrayType)valueType).getComponentType());
        }
        if (valueType == ArrayType.nullType) {
            return 2;
        }
        if (valueType == ArrayType.objectType) {
            return 0;
        }
        return -1;
    }
    
    @Override
    public int compare(final Type other) {
        if (other == ArrayType.nullType) {
            return 1;
        }
        if (other instanceof ArrayType) {
            return this.elements.compare(((ArrayType)other).elements);
        }
        if (other.getName().equals("java.lang.Object") || other == ArrayType.toStringType) {
            return -1;
        }
        return -3;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.elements);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.elements = (Type)in.readObject();
    }
    
    public Object readResolve() throws ObjectStreamException {
        final ArrayType array_type = this.elements.array_type;
        if (array_type != null) {
            return array_type;
        }
        return this.elements.array_type = this;
    }
}
