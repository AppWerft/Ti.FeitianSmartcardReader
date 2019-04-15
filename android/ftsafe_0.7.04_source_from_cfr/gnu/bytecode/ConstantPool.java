/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassType;
import gnu.bytecode.CpoolClass;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolInvokeDynamic;
import gnu.bytecode.CpoolMethodHandle;
import gnu.bytecode.CpoolMethodType;
import gnu.bytecode.CpoolNameAndType;
import gnu.bytecode.CpoolRef;
import gnu.bytecode.CpoolString;
import gnu.bytecode.CpoolUtf8;
import gnu.bytecode.CpoolValue1;
import gnu.bytecode.CpoolValue2;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ConstantPool {
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

    public final CpoolEntry getPoolEntry(int index) {
        return this.pool[index];
    }

    void rehash() {
        int i;
        CpoolEntry entry;
        if (this.hashTab == null && this.count > 0) {
            i = this.pool.length;
            while (--i >= 0) {
                entry = this.pool[i];
                if (entry == null) continue;
                entry.hashCode();
            }
        }
        this.hashTab = new CpoolEntry[this.count < 5 ? 101 : 2 * this.count];
        if (this.pool != null) {
            i = this.pool.length;
            while (--i >= 0) {
                entry = this.pool[i];
                if (entry == null) continue;
                entry.add_hashed(this);
            }
        }
    }

    public CpoolUtf8 addUtf8(String s) {
        s = s.intern();
        int h = s.hashCode();
        if (this.hashTab == null) {
            this.rehash();
        }
        int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        CpoolEntry entry = this.hashTab[index];
        while (entry != null) {
            if (h == entry.hash && entry instanceof CpoolUtf8) {
                CpoolUtf8 utf = (CpoolUtf8)entry;
                if (utf.string == s) {
                    return utf;
                }
            }
            entry = entry.next;
        }
        if (this.locked) {
            throw new Error("adding new Utf8 entry to locked contant pool: " + s);
        }
        return new CpoolUtf8(this, h, s);
    }

    public CpoolClass addClass(ObjectType otype) {
        CpoolClass entry = this.addClass(this.addUtf8(otype.getInternalName()));
        entry.clas = otype;
        return entry;
    }

    public CpoolMethodHandle addMethodHandle(Method method) {
        int kind = (method.access_flags & 8) != 0 ? 6 : (method.classfile.isInterface() ? 9 : ("<init>".equals(method.getName()) ? 8 : ((method.access_flags & 2) != 0 ? 7 : 5)));
        return this.addMethodHandle(kind, this.addMethodRef(method));
    }

    public CpoolMethodHandle addMethodHandle(int kind, CpoolRef reference) {
        int h = CpoolMethodHandle.hashCode(kind, reference);
        if (this.hashTab == null) {
            this.rehash();
        }
        int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        CpoolEntry entry = this.hashTab[index];
        while (entry != null) {
            if (h == entry.hash && entry instanceof CpoolMethodHandle && ((CpoolMethodHandle)entry).kind == kind && ((CpoolMethodHandle)entry).reference == reference) {
                return (CpoolMethodHandle)entry;
            }
            entry = entry.next;
        }
        return new CpoolMethodHandle(this, h, kind, reference);
    }

    public CpoolClass addClass(CpoolUtf8 name) {
        int h = CpoolClass.hashCode(name);
        if (this.hashTab == null) {
            this.rehash();
        }
        int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        CpoolEntry entry = this.hashTab[index];
        while (entry != null) {
            if (h == entry.hash && entry instanceof CpoolClass) {
                CpoolClass ent = (CpoolClass)entry;
                if (ent.name == name) {
                    return ent;
                }
            }
            entry = entry.next;
        }
        return new CpoolClass(this, h, name);
    }

    CpoolValue1 addValue1(int tag, int val) {
        int h = CpoolValue1.hashCode(val);
        if (this.hashTab == null) {
            this.rehash();
        }
        int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        CpoolEntry entry = this.hashTab[index];
        while (entry != null) {
            if (h == entry.hash && entry instanceof CpoolValue1) {
                CpoolValue1 ent = (CpoolValue1)entry;
                if (ent.tag == tag && ent.value == val) {
                    return ent;
                }
            }
            entry = entry.next;
        }
        return new CpoolValue1(this, tag, h, val);
    }

    CpoolValue2 addValue2(int tag, long val) {
        int h = CpoolValue2.hashCode(val);
        if (this.hashTab == null) {
            this.rehash();
        }
        int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        CpoolEntry entry = this.hashTab[index];
        while (entry != null) {
            if (h == entry.hash && entry instanceof CpoolValue2) {
                CpoolValue2 ent = (CpoolValue2)entry;
                if (ent.tag == tag && ent.value == val) {
                    return ent;
                }
            }
            entry = entry.next;
        }
        return new CpoolValue2(this, tag, h, val);
    }

    public CpoolValue1 addInt(int val) {
        return this.addValue1(3, val);
    }

    public CpoolValue2 addLong(long val) {
        return this.addValue2(5, val);
    }

    public CpoolValue1 addFloat(float val) {
        return this.addValue1(4, Float.floatToIntBits(val));
    }

    public CpoolValue2 addDouble(double val) {
        return this.addValue2(6, Double.doubleToLongBits(val));
    }

    public final CpoolString addString(String string) {
        return this.addString(this.addUtf8(string));
    }

    public CpoolString addString(CpoolUtf8 str) {
        int h = CpoolString.hashCode(str);
        if (this.hashTab == null) {
            this.rehash();
        }
        int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        CpoolEntry entry = this.hashTab[index];
        while (entry != null) {
            if (h == entry.hash && entry instanceof CpoolString) {
                CpoolString ent = (CpoolString)entry;
                if (ent.str == str) {
                    return ent;
                }
            }
            entry = entry.next;
        }
        return new CpoolString(this, h, str);
    }

    public CpoolNameAndType addNameAndType(Method method) {
        CpoolUtf8 name = this.addUtf8(method.getName());
        CpoolUtf8 type = this.addUtf8(method.getSignature());
        return this.addNameAndType(name, type);
    }

    public CpoolNameAndType addNameAndType(Field field) {
        CpoolUtf8 name = this.addUtf8(field.getName());
        CpoolUtf8 type = this.addUtf8(field.getSignature());
        return this.addNameAndType(name, type);
    }

    public CpoolNameAndType addNameAndType(CpoolUtf8 name, CpoolUtf8 type) {
        int h = CpoolNameAndType.hashCode(name, type);
        if (this.hashTab == null) {
            this.rehash();
        }
        int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        CpoolEntry entry = this.hashTab[index];
        while (entry != null) {
            if (h == entry.hash && entry instanceof CpoolNameAndType && ((CpoolNameAndType)entry).name == name && ((CpoolNameAndType)entry).type == type) {
                return (CpoolNameAndType)entry;
            }
            entry = entry.next;
        }
        return new CpoolNameAndType(this, h, name, type);
    }

    public CpoolRef addRef(int tag, CpoolClass clas, CpoolNameAndType nameAndType) {
        int h = CpoolRef.hashCode(clas, nameAndType);
        if (this.hashTab == null) {
            this.rehash();
        }
        int index = (h & Integer.MAX_VALUE) % this.hashTab.length;
        CpoolEntry entry = this.hashTab[index];
        while (entry != null) {
            if (h == entry.hash && entry instanceof CpoolRef) {
                CpoolRef ref = (CpoolRef)entry;
                if (ref.tag == tag && ref.clas == clas && ref.nameAndType == nameAndType) {
                    return ref;
                }
            }
            entry = entry.next;
        }
        return new CpoolRef(this, h, tag, clas, nameAndType);
    }

    public CpoolRef addMethodRef(Method method) {
        CpoolClass clas = this.addClass(method.classfile);
        int tag = (method.getDeclaringClass().getModifiers() & 512) == 0 ? 10 : 11;
        CpoolNameAndType nameType = this.addNameAndType(method);
        return this.addRef(tag, clas, nameType);
    }

    public CpoolRef addFieldRef(Field field) {
        CpoolClass clas = this.addClass(field.owner);
        int tag = 9;
        CpoolNameAndType nameType = this.addNameAndType(field);
        return this.addRef(tag, clas, nameType);
    }

    void write(DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.count + 1);
        for (int i = 1; i <= this.count; ++i) {
            CpoolEntry entry = this.pool[i];
            if (entry == null) continue;
            entry.write(dstr);
        }
        this.locked = true;
    }

    CpoolEntry getForced(int index, int tag) {
        CpoolEntry entry = this.pool[index &= 65535];
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
                }
            }
            this.pool[index] = entry;
            entry.index = index;
        } else if (entry.getTag() != tag) {
            if (entry.getTag() == -1) {
                ((CpoolRef)entry).tag = tag;
            } else if (tag != -1) {
                throw new ClassFormatError("conflicting constant pool tags at " + index);
            }
        }
        return entry;
    }

    CpoolClass getForcedClass(int index) {
        return (CpoolClass)this.getForced(index, 7);
    }

    public ConstantPool() {
    }

    public ConstantPool(DataInputStream dstr) throws IOException {
        this.count = dstr.readUnsignedShort() - 1;
        this.pool = new CpoolEntry[this.count + 1];
        block12 : for (int i = 1; i <= this.count; ++i) {
            byte tag = dstr.readByte();
            CpoolEntry entry = this.getForced(i, tag);
            switch (tag) {
                case 1: {
                    ((CpoolUtf8)entry).string = dstr.readUTF();
                    continue block12;
                }
                case 3: 
                case 4: {
                    ((CpoolValue1)entry).value = dstr.readInt();
                    continue block12;
                }
                case 5: 
                case 6: {
                    ((CpoolValue2)entry).value = dstr.readLong();
                    ++i;
                    continue block12;
                }
                case 7: {
                    ((CpoolClass)entry).name = (CpoolUtf8)this.getForced(dstr.readUnsignedShort(), 1);
                    continue block12;
                }
                case 8: {
                    ((CpoolString)entry).str = (CpoolUtf8)this.getForced(dstr.readUnsignedShort(), 1);
                    continue block12;
                }
                case 9: 
                case 10: 
                case 11: {
                    CpoolRef ref = (CpoolRef)entry;
                    ref.clas = this.getForcedClass(dstr.readUnsignedShort());
                    ref.nameAndType = (CpoolNameAndType)this.getForced(dstr.readUnsignedShort(), 12);
                    continue block12;
                }
                case 15: {
                    CpoolMethodHandle mh = (CpoolMethodHandle)entry;
                    mh.kind = dstr.readUnsignedByte();
                    mh.reference = (CpoolRef)this.getForced(dstr.readUnsignedShort(), -1);
                    continue block12;
                }
                case 16: {
                    CpoolMethodType mt = (CpoolMethodType)entry;
                    mt.descriptor = (CpoolUtf8)this.getForced(dstr.readUnsignedShort(), 1);
                    continue block12;
                }
                case 18: {
                    CpoolInvokeDynamic idyn = (CpoolInvokeDynamic)entry;
                    idyn.bootstrapMethodIndex = dstr.readUnsignedShort();
                    idyn.nameAndType = (CpoolNameAndType)this.getForced(dstr.readUnsignedShort(), 12);
                    continue block12;
                }
                case 12: {
                    CpoolNameAndType ntyp = (CpoolNameAndType)entry;
                    ntyp.name = (CpoolUtf8)this.getForced(dstr.readUnsignedShort(), 1);
                    ntyp.type = (CpoolUtf8)this.getForced(dstr.readUnsignedShort(), 1);
                }
            }
        }
    }
}

