/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.AttrContainer;
import gnu.bytecode.Attribute;
import gnu.bytecode.ClassType;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.ConstantValueAttr;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolString;
import gnu.bytecode.CpoolUtf8;
import gnu.bytecode.CpoolValue1;
import gnu.bytecode.CpoolValue2;
import gnu.bytecode.Location;
import gnu.bytecode.Member;
import gnu.bytecode.PrimType;
import gnu.bytecode.RuntimeAnnotationsAttr;
import gnu.bytecode.SignatureAttr;
import gnu.bytecode.Type;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;

public class Field
extends Location
implements AttrContainer,
Member {
    int flags;
    Field next;
    Attribute attributes;
    ClassType owner;
    String sourceName;
    java.lang.reflect.Field rfield;

    @Override
    public final Attribute getAttributes() {
        return this.attributes;
    }

    @Override
    public final void setAttributes(Attribute attributes) {
        this.attributes = attributes;
    }

    public Field(ClassType ctype) {
        if (ctype.last_field == null) {
            ctype.fields = this;
        } else {
            ctype.last_field.next = this;
        }
        ctype.last_field = this;
        ++ctype.fields_count;
        this.owner = ctype;
    }

    @Override
    public final ClassType getDeclaringClass() {
        return this.owner;
    }

    @Override
    public final ConstantPool getConstants() {
        return this.owner.constants;
    }

    public final void setStaticFlag(boolean is_static) {
        this.flags = is_static ? (this.flags |= 8) : (this.flags ^= -9);
    }

    @Override
    public final boolean getStaticFlag() {
        return (this.flags & 8) != 0;
    }

    public final int getFlags() {
        return this.flags;
    }

    @Override
    public final int getModifiers() {
        return this.flags;
    }

    public final void setModifiers(int modifiers) {
        this.flags = modifiers;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Type getType() {
        Field field = this;
        synchronized (field) {
            Type t = super.getType();
            if (t == null && this.rfield != null) {
                t = Type.make(this.rfield.getType(), this.rfield.getGenericType());
                super.setType(t);
            }
            return t;
        }
    }

    void write(DataOutputStream dstr, ClassType classfile) throws IOException {
        dstr.writeShort(this.flags);
        dstr.writeShort(this.name_index);
        dstr.writeShort(this.signature_index);
        Attribute.writeAll(this, dstr);
    }

    void assign_constants(ClassType classfile) {
        ConstantPool constants = classfile.constants;
        Type t = this.getType();
        String signature = t.getSignature();
        String genericSignature = t.getGenericSignature();
        if (genericSignature != null && !genericSignature.equals(signature)) {
            SignatureAttr attr = new SignatureAttr(genericSignature);
            attr.addToFrontOf(this);
        }
        if (this.name_index == 0 && this.name != null) {
            this.name_index = constants.addUtf8((String)this.name).index;
        }
        if (this.signature_index == 0 && t != null) {
            this.signature_index = constants.addUtf8((String)signature).index;
        }
        Attribute.assignConstants(this, classfile);
    }

    public synchronized java.lang.reflect.Field getReflectField() throws NoSuchFieldException {
        if (this.rfield == null) {
            this.rfield = this.owner.getReflectClass().getDeclaredField(this.getName());
        }
        return this.rfield;
    }

    public <T extends Annotation> T getAnnotation(Class<T> clas) {
        T ann = RuntimeAnnotationsAttr.getAnnotation(this, clas);
        if (ann != null) {
            return ann;
        }
        return this.rfield == null ? null : (T)this.rfield.getAnnotation(clas);
    }

    public void setSourceName(String name) {
        this.sourceName = name;
    }

    public String getSourceName() {
        if (this.sourceName == null) {
            this.sourceName = this.getName().intern();
        }
        return this.sourceName;
    }

    public static Field searchField(Field fields, String name) {
        while (fields != null) {
            if (fields.getSourceName() == name) {
                return fields;
            }
            fields = fields.next;
        }
        return null;
    }

    public final Field getNext() {
        return this.next;
    }

    public final void setConstantValue(Object value, ClassType ctype) {
        CpoolEntry entry;
        ConstantPool cpool = ctype.constants;
        if (cpool == null) {
            ctype.constants = cpool = new ConstantPool();
        }
        char sig1 = this.getType().getSignature().charAt(0);
        switch (sig1) {
            case 'Z': {
                entry = cpool.addInt(PrimType.booleanValue(value) ? 1 : 0);
                break;
            }
            case 'C': {
                if (value instanceof Character) {
                    entry = cpool.addInt(((Character)value).charValue());
                    break;
                }
            }
            case 'B': 
            case 'I': 
            case 'S': {
                entry = cpool.addInt(((Number)value).intValue());
                break;
            }
            case 'J': {
                entry = cpool.addLong(((Number)value).longValue());
                break;
            }
            case 'F': {
                entry = cpool.addFloat(((Number)value).floatValue());
                break;
            }
            case 'D': {
                entry = cpool.addDouble(((Number)value).doubleValue());
                break;
            }
            default: {
                entry = cpool.addString(value.toString());
            }
        }
        ConstantValueAttr attr = new ConstantValueAttr(entry.getIndex());
        attr.addToFrontOf(this);
    }

    public boolean hasConstantValueAttr() {
        return Attribute.get(this, "ConstantValue") != null;
    }

    public String toString() {
        StringBuffer sbuf = new StringBuffer(100);
        sbuf.append("Field:");
        sbuf.append(this.getDeclaringClass().getName());
        sbuf.append('.');
        sbuf.append(this.name);
        return sbuf.toString();
    }
}

