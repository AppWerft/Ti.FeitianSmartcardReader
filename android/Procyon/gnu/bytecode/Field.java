// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.lang.annotation.Annotation;
import java.io.IOException;
import java.io.DataOutputStream;

public class Field extends Location implements AttrContainer, Member
{
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
    public final void setAttributes(final Attribute attributes) {
        this.attributes = attributes;
    }
    
    public Field(final ClassType ctype) {
        if (ctype.last_field == null) {
            ctype.fields = this;
        }
        else {
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
    
    public final void setStaticFlag(final boolean is_static) {
        if (is_static) {
            this.flags |= 0x8;
        }
        else {
            this.flags ^= 0xFFFFFFF7;
        }
    }
    
    @Override
    public final boolean getStaticFlag() {
        return (this.flags & 0x8) != 0x0;
    }
    
    public final int getFlags() {
        return this.flags;
    }
    
    @Override
    public final int getModifiers() {
        return this.flags;
    }
    
    public final void setModifiers(final int modifiers) {
        this.flags = modifiers;
    }
    
    @Override
    public Type getType() {
        synchronized (this) {
            Type t = super.getType();
            if (t == null && this.rfield != null) {
                t = Type.make(this.rfield.getType(), this.rfield.getGenericType());
                super.setType(t);
            }
            return t;
        }
    }
    
    void write(final DataOutputStream dstr, final ClassType classfile) throws IOException {
        dstr.writeShort(this.flags);
        dstr.writeShort(this.name_index);
        dstr.writeShort(this.signature_index);
        Attribute.writeAll(this, dstr);
    }
    
    void assign_constants(final ClassType classfile) {
        final ConstantPool constants = classfile.constants;
        final Type t = this.getType();
        final String signature = t.getSignature();
        final String genericSignature = t.getGenericSignature();
        if (genericSignature != null && !genericSignature.equals(signature)) {
            final SignatureAttr attr = new SignatureAttr(genericSignature);
            attr.addToFrontOf(this);
        }
        if (this.name_index == 0 && this.name != null) {
            this.name_index = constants.addUtf8(this.name).index;
        }
        if (this.signature_index == 0 && t != null) {
            this.signature_index = constants.addUtf8(signature).index;
        }
        Attribute.assignConstants(this, classfile);
    }
    
    public synchronized java.lang.reflect.Field getReflectField() throws NoSuchFieldException {
        if (this.rfield == null) {
            this.rfield = this.owner.getReflectClass().getDeclaredField(this.getName());
        }
        return this.rfield;
    }
    
    public <T extends Annotation> T getAnnotation(final Class<T> clas) {
        final T ann = RuntimeAnnotationsAttr.getAnnotation(this, clas);
        if (ann != null) {
            return ann;
        }
        return (T)((this.rfield == null) ? null : this.rfield.getAnnotation(clas));
    }
    
    public void setSourceName(final String name) {
        this.sourceName = name;
    }
    
    public String getSourceName() {
        if (this.sourceName == null) {
            this.sourceName = this.getName().intern();
        }
        return this.sourceName;
    }
    
    public static Field searchField(Field fields, final String name) {
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
    
    public final void setConstantValue(final Object value, final ClassType ctype) {
        ConstantPool cpool = ctype.constants;
        if (cpool == null) {
            cpool = (ctype.constants = new ConstantPool());
        }
        final char sig1 = this.getType().getSignature().charAt(0);
        CpoolEntry entry = null;
        switch (sig1) {
            case 'Z': {
                entry = cpool.addInt(PrimType.booleanValue(value) ? 1 : 0);
                break;
            }
            case 'C': {
                if (value instanceof Character) {
                    entry = cpool.addInt((char)value);
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
                break;
            }
        }
        final ConstantValueAttr attr = new ConstantValueAttr(entry.getIndex());
        attr.addToFrontOf(this);
    }
    
    public boolean hasConstantValueAttr() {
        return Attribute.get(this, "ConstantValue") != null;
    }
    
    @Override
    public String toString() {
        final StringBuffer sbuf = new StringBuffer(100);
        sbuf.append("Field:");
        sbuf.append(this.getDeclaringClass().getName());
        sbuf.append('.');
        sbuf.append(this.name);
        return sbuf.toString();
    }
}
