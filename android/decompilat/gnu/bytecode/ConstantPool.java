// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.DataOutputStream;

public class ConstantPool
{
    public static final byte CLASS = 7;
    public static final byte FIELDREF = 9;
    public static final byte METHODREF = 10;
    public static final byte INTERFACE_METHODREF = 11;
    public static final byte ANY_REF = -1;
    public static final byte STRING = 8;
    public static final byte INTEGER = 3;
    public static final byte FLOAT = 4;
    public static final byte LONG = 5;
    public static final byte DOUBLE = 6;
    public static final byte METHOD_HANDLE = 15;
    public static final byte METHOD_TYPE = 16;
    public static final byte INVOKE_DYNAMIC = 18;
    public static final byte NAME_AND_TYPE = 12;
    public static final byte UTF8 = 1;
    CpoolEntry[] pool;
    int count;
    boolean locked;
    CpoolEntry[] hashTab;
    
    public final int getCount() {
        return this.count;
    }
    
    public final CpoolEntry getPoolEntry(final int index) {
        return this.pool[index];
    }
    
    void rehash() {
        if (this.hashTab == null && this.count > 0) {
            int i = this.pool.length;
            while (--i >= 0) {
                final CpoolEntry entry = this.pool[i];
                if (entry != null) {
                    entry.hashCode();
                }
            }
        }
        this.hashTab = new CpoolEntry[(this.count < 5) ? 101 : (2 * this.count)];
        if (this.pool != null) {
            int i = this.pool.length;
            while (--i >= 0) {
                final CpoolEntry entry = this.pool[i];
                if (entry != null) {
                    entry.add_hashed(this);
                }
            }
        }
    }
    
    public CpoolUtf8 addUtf8(String s) {
        s = s.intern();
        final int h = s.hashCode();
        if (this.hashTab == null) {
            this.rehash();
        }
        final int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        for (CpoolEntry entry = this.hashTab[index]; entry != null; entry = entry.next) {
            if (h == entry.hash && entry instanceof CpoolUtf8) {
                final CpoolUtf8 utf = (CpoolUtf8)entry;
                if (utf.string == s) {
                    return utf;
                }
            }
        }
        if (this.locked) {
            throw new Error("adding new Utf8 entry to locked contant pool: " + s);
        }
        return new CpoolUtf8(this, h, s);
    }
    
    public CpoolClass addClass(final ObjectType otype) {
        final CpoolClass entry = this.addClass(this.addUtf8(otype.getInternalName()));
        entry.clas = otype;
        return entry;
    }
    
    public CpoolMethodHandle addMethodHandle(final Method method) {
        int kind;
        if ((method.access_flags & 0x8) != 0x0) {
            kind = 6;
        }
        else if (method.classfile.isInterface()) {
            kind = 9;
        }
        else if ("<init>".equals(method.getName())) {
            kind = 8;
        }
        else if ((method.access_flags & 0x2) != 0x0) {
            kind = 7;
        }
        else {
            kind = 5;
        }
        return this.addMethodHandle(kind, this.addMethodRef(method));
    }
    
    public CpoolMethodHandle addMethodHandle(final int kind, final CpoolRef reference) {
        final int h = CpoolMethodHandle.hashCode(kind, reference);
        if (this.hashTab == null) {
            this.rehash();
        }
        final int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        for (CpoolEntry entry = this.hashTab[index]; entry != null; entry = entry.next) {
            if (h == entry.hash && entry instanceof CpoolMethodHandle && ((CpoolMethodHandle)entry).kind == kind && ((CpoolMethodHandle)entry).reference == reference) {
                return (CpoolMethodHandle)entry;
            }
        }
        return new CpoolMethodHandle(this, h, kind, reference);
    }
    
    public CpoolClass addClass(final CpoolUtf8 name) {
        final int h = CpoolClass.hashCode(name);
        if (this.hashTab == null) {
            this.rehash();
        }
        final int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        for (CpoolEntry entry = this.hashTab[index]; entry != null; entry = entry.next) {
            if (h == entry.hash && entry instanceof CpoolClass) {
                final CpoolClass ent = (CpoolClass)entry;
                if (ent.name == name) {
                    return ent;
                }
            }
        }
        return new CpoolClass(this, h, name);
    }
    
    CpoolValue1 addValue1(final int tag, final int val) {
        final int h = CpoolValue1.hashCode(val);
        if (this.hashTab == null) {
            this.rehash();
        }
        final int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        for (CpoolEntry entry = this.hashTab[index]; entry != null; entry = entry.next) {
            if (h == entry.hash && entry instanceof CpoolValue1) {
                final CpoolValue1 ent = (CpoolValue1)entry;
                if (ent.tag == tag && ent.value == val) {
                    return ent;
                }
            }
        }
        return new CpoolValue1(this, tag, h, val);
    }
    
    CpoolValue2 addValue2(final int tag, final long val) {
        final int h = CpoolValue2.hashCode(val);
        if (this.hashTab == null) {
            this.rehash();
        }
        final int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        for (CpoolEntry entry = this.hashTab[index]; entry != null; entry = entry.next) {
            if (h == entry.hash && entry instanceof CpoolValue2) {
                final CpoolValue2 ent = (CpoolValue2)entry;
                if (ent.tag == tag && ent.value == val) {
                    return ent;
                }
            }
        }
        return new CpoolValue2(this, tag, h, val);
    }
    
    public CpoolValue1 addInt(final int val) {
        return this.addValue1(3, val);
    }
    
    public CpoolValue2 addLong(final long val) {
        return this.addValue2(5, val);
    }
    
    public CpoolValue1 addFloat(final float val) {
        return this.addValue1(4, Float.floatToIntBits(val));
    }
    
    public CpoolValue2 addDouble(final double val) {
        return this.addValue2(6, Double.doubleToLongBits(val));
    }
    
    public final CpoolString addString(final String string) {
        return this.addString(this.addUtf8(string));
    }
    
    public CpoolString addString(final CpoolUtf8 str) {
        final int h = CpoolString.hashCode(str);
        if (this.hashTab == null) {
            this.rehash();
        }
        final int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        for (CpoolEntry entry = this.hashTab[index]; entry != null; entry = entry.next) {
            if (h == entry.hash && entry instanceof CpoolString) {
                final CpoolString ent = (CpoolString)entry;
                if (ent.str == str) {
                    return ent;
                }
            }
        }
        return new CpoolString(this, h, str);
    }
    
    public CpoolNameAndType addNameAndType(final Method method) {
        final CpoolUtf8 name = this.addUtf8(method.getName());
        final CpoolUtf8 type = this.addUtf8(method.getSignature());
        return this.addNameAndType(name, type);
    }
    
    public CpoolNameAndType addNameAndType(final Field field) {
        final CpoolUtf8 name = this.addUtf8(field.getName());
        final CpoolUtf8 type = this.addUtf8(field.getSignature());
        return this.addNameAndType(name, type);
    }
    
    public CpoolNameAndType addNameAndType(final CpoolUtf8 name, final CpoolUtf8 type) {
        final int h = CpoolNameAndType.hashCode(name, type);
        if (this.hashTab == null) {
            this.rehash();
        }
        final int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        for (CpoolEntry entry = this.hashTab[index]; entry != null; entry = entry.next) {
            if (h == entry.hash && entry instanceof CpoolNameAndType && ((CpoolNameAndType)entry).name == name && ((CpoolNameAndType)entry).type == type) {
                return (CpoolNameAndType)entry;
            }
        }
        return new CpoolNameAndType(this, h, name, type);
    }
    
    public CpoolRef addRef(final int tag, final CpoolClass clas, final CpoolNameAndType nameAndType) {
        final int h = CpoolRef.hashCode(clas, nameAndType);
        if (this.hashTab == null) {
            this.rehash();
        }
        final int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        for (CpoolEntry entry = this.hashTab[index]; entry != null; entry = entry.next) {
            if (h == entry.hash && entry instanceof CpoolRef) {
                final CpoolRef ref = (CpoolRef)entry;
                if (ref.tag == tag && ref.clas == clas && ref.nameAndType == nameAndType) {
                    return ref;
                }
            }
        }
        return new CpoolRef(this, h, tag, clas, nameAndType);
    }
    
    public CpoolRef addMethodRef(final Method method) {
        final CpoolClass clas = this.addClass(method.classfile);
        int tag;
        if ((method.getDeclaringClass().getModifiers() & 0x200) == 0x0) {
            tag = 10;
        }
        else {
            tag = 11;
        }
        final CpoolNameAndType nameType = this.addNameAndType(method);
        return this.addRef(tag, clas, nameType);
    }
    
    public CpoolRef addFieldRef(final Field field) {
        final CpoolClass clas = this.addClass(field.owner);
        final int tag = 9;
        final CpoolNameAndType nameType = this.addNameAndType(field);
        return this.addRef(tag, clas, nameType);
    }
    
    void write(final DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.count + 1);
        for (int i = 1; i <= this.count; ++i) {
            final CpoolEntry entry = this.pool[i];
            if (entry != null) {
                entry.write(dstr);
            }
        }
        this.locked = true;
    }
    
    CpoolEntry getForced(int index, final int tag) {
        index &= 0xFFFF;
        CpoolEntry entry = this.pool[index];
        if (entry == null) {
            if (this.locked) {
                throw new Error("adding new entry to locked contant pool");
            }
            switch (tag) {
                case 1: {
                    entry = new CpoolUtf8();
                    break;
                }
                case 3:
                case 4: {
                    entry = new CpoolValue1(tag);
                    break;
                }
                case 5:
                case 6: {
                    entry = new CpoolValue2(tag);
                    break;
                }
                case 7: {
                    entry = new CpoolClass();
                    break;
                }
                case 8: {
                    entry = new CpoolString();
                    break;
                }
                case -1:
                case 9:
                case 10:
                case 11: {
                    entry = new CpoolRef(tag);
                    break;
                }
                case 12: {
                    entry = new CpoolNameAndType();
                    break;
                }
                case 18: {
                    entry = new CpoolInvokeDynamic();
                    break;
                }
                case 15: {
                    entry = new CpoolMethodHandle();
                    break;
                }
                case 16: {
                    entry = new CpoolMethodType();
                    break;
                }
                default: {
                    System.err.println("tag: " + tag);
                    break;
                }
            }
            this.pool[index] = entry;
            entry.index = index;
        }
        else if (entry.getTag() != tag) {
            if (entry.getTag() == -1) {
                ((CpoolRef)entry).tag = tag;
            }
            else if (tag != -1) {
                throw new ClassFormatError("conflicting constant pool tags at " + index);
            }
        }
        return entry;
    }
    
    CpoolClass getForcedClass(final int index) {
        return (CpoolClass)this.getForced(index, 7);
    }
    
    public ConstantPool() {
    }
    
    public ConstantPool(final DataInputStream dstr) throws IOException {
        this.count = dstr.readUnsignedShort() - 1;
        this.pool = new CpoolEntry[this.count + 1];
        for (int i = 1; i <= this.count; ++i) {
            final byte tag = dstr.readByte();
            final CpoolEntry entry = this.getForced(i, tag);
            switch (tag) {
                case 1: {
                    ((CpoolUtf8)entry).string = dstr.readUTF();
                    break;
                }
                case 3:
                case 4: {
                    ((CpoolValue1)entry).value = dstr.readInt();
                    break;
                }
                case 5:
                case 6: {
                    ((CpoolValue2)entry).value = dstr.readLong();
                    ++i;
                    break;
                }
                case 7: {
                    ((CpoolClass)entry).name = (CpoolUtf8)this.getForced(dstr.readUnsignedShort(), 1);
                    break;
                }
                case 8: {
                    ((CpoolString)entry).str = (CpoolUtf8)this.getForced(dstr.readUnsignedShort(), 1);
                    break;
                }
                case 9:
                case 10:
                case 11: {
                    final CpoolRef ref = (CpoolRef)entry;
                    ref.clas = this.getForcedClass(dstr.readUnsignedShort());
                    ref.nameAndType = (CpoolNameAndType)this.getForced(dstr.readUnsignedShort(), 12);
                    break;
                }
                case 15: {
                    final CpoolMethodHandle mh = (CpoolMethodHandle)entry;
                    mh.kind = dstr.readUnsignedByte();
                    mh.reference = (CpoolRef)this.getForced(dstr.readUnsignedShort(), -1);
                    break;
                }
                case 16: {
                    final CpoolMethodType mt = (CpoolMethodType)entry;
                    mt.descriptor = (CpoolUtf8)this.getForced(dstr.readUnsignedShort(), 1);
                    break;
                }
                case 18: {
                    final CpoolInvokeDynamic idyn = (CpoolInvokeDynamic)entry;
                    idyn.bootstrapMethodIndex = dstr.readUnsignedShort();
                    idyn.nameAndType = (CpoolNameAndType)this.getForced(dstr.readUnsignedShort(), 12);
                    break;
                }
                case 12: {
                    final CpoolNameAndType ntyp = (CpoolNameAndType)entry;
                    ntyp.name = (CpoolUtf8)this.getForced(dstr.readUnsignedShort(), 1);
                    ntyp.type = (CpoolUtf8)this.getForced(dstr.readUnsignedShort(), 1);
                    break;
                }
            }
        }
    }
}
