/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassType;
import gnu.bytecode.Filter;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.List;

public class ArrayType
extends ObjectType
implements Externalizable {
    public Type elements;

    public ArrayType(Type elements) {
        this(elements, elements.getName() + "[]");
    }

    ArrayType(Type elements, String name) {
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
        Type eltype = this.elements.getImplementationType();
        return this.elements == eltype ? this : ArrayType.make(eltype);
    }

    @Override
    public Type getRawType() {
        Type eltype = this.elements.getRawType();
        return this.elements == eltype ? this : ArrayType.make(eltype);
    }

    static ArrayType make(String name) {
        Type elements = Type.getType(name.substring(0, name.length() - 2));
        ArrayType array_type = elements.array_type;
        if (array_type == null) {
            elements.array_type = array_type = new ArrayType(elements, name);
        }
        return array_type;
    }

    public static ArrayType make(Type elements) {
        ArrayType array_type = elements.array_type;
        if (array_type == null) {
            elements.array_type = array_type = new ArrayType(elements, elements.getName() + "[]");
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
        block3 : {
            try {
                if (this.reflectClass == null) {
                    String cname = this.getInternalName().replace('/', '.');
                    Class elClass = this.elements.getReflectClass();
                    this.reflectClass = Class.forName(cname, false, elClass.getClassLoader());
                }
                this.flags |= 16;
            }
            catch (ClassNotFoundException ex) {
                if ((this.flags & 16) == 0) break block3;
                RuntimeException rex = new RuntimeException("no such array class: " + this.getName());
                rex.initCause(ex);
                throw rex;
            }
        }
        return this.reflectClass;
    }

    @Override
    public int getMethods(Filter filter, int searchSupers, List<Method> result) {
        if (searchSupers > 0) {
            int count = Type.objectType.getMethods(filter, 0, result);
            if (searchSupers > 1 && filter.select(Type.clone_method)) {
                if (result != null) {
                    Method meth = Type.clone_method;
                    result.add(meth);
                }
                ++count;
            }
            return count;
        }
        return 0;
    }

    @Override
    public int isCompatibleWithValue(Type valueType) {
        if (valueType instanceof ArrayType) {
            return this.getComponentType().isCompatibleWithValue(((ArrayType)valueType).getComponentType());
        }
        if (valueType == nullType) {
            return 2;
        }
        if (valueType == objectType) {
            return 0;
        }
        return -1;
    }

    @Override
    public int compare(Type other) {
        if (other == nullType) {
            return 1;
        }
        if (other instanceof ArrayType) {
            return this.elements.compare(((ArrayType)other).elements);
        }
        if (other.getName().equals("java.lang.Object") || other == toStringType) {
            return -1;
        }
        return -3;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.elements);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.elements = (Type)in.readObject();
    }

    public Object readResolve() throws ObjectStreamException {
        ArrayType array_type = this.elements.array_type;
        if (array_type != null) {
            return array_type;
        }
        this.elements.array_type = this;
        return this;
    }
}

