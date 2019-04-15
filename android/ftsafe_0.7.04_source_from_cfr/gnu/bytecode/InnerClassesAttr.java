/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.Access;
import gnu.bytecode.AttrContainer;
import gnu.bytecode.Attribute;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolClass;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolUtf8;
import gnu.bytecode.ObjectType;
import java.io.DataOutputStream;
import java.io.IOException;

public class InnerClassesAttr
extends Attribute {
    int count;
    short[] data;

    public InnerClassesAttr(ClassType cl) {
        super("InnerClasses");
        this.addToFrontOf(cl);
    }

    public InnerClassesAttr(short[] data, ClassType cl) {
        this(cl);
        this.count = (short)(data.length >> 2);
        this.data = data;
    }

    public static InnerClassesAttr getFirstInnerClasses(Attribute attr) {
        while (attr != null && !(attr instanceof InnerClassesAttr)) {
            attr = attr.getNext();
        }
        return (InnerClassesAttr)attr;
    }

    void addClass(CpoolClass centry, ClassType owner) {
        int i = 4 * this.count++;
        if (this.data == null) {
            this.data = new short[16];
        } else if (i >= this.data.length) {
            short[] tmp = new short[2 * i];
            System.arraycopy(this.data, 0, tmp, 0, i);
            this.data = tmp;
        }
        ConstantPool constants = owner.constants;
        ClassType clas = (ClassType)centry.getClassType();
        String name = clas.getSimpleName();
        int name_index = name == null || name.length() == 0 ? 0 : constants.addUtf8((String)name).index;
        this.data[i] = (short)centry.index;
        ClassType outer = clas.getDeclaringClass();
        this.data[i + 1] = outer == null ? (short)0 : (short)constants.addClass((ObjectType)outer).index;
        this.data[i + 2] = (short)name_index;
        int flags = clas.getModifiers();
        this.data[i + 3] = (short)(flags &= -33);
    }

    @Override
    public void assignConstants(ClassType cl) {
        super.assignConstants(cl);
    }

    @Override
    public int getLength() {
        return 2 + 8 * this.count;
    }

    @Override
    public void write(DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.count);
        for (int i = 0; i < this.count; ++i) {
            dstr.writeShort(this.data[4 * i]);
            dstr.writeShort(this.data[4 * i + 1]);
            dstr.writeShort(this.data[4 * i + 2]);
            dstr.writeShort(this.data[4 * i + 3]);
        }
    }

    @Override
    public void print(ClassTypeWriter dst) {
        ClassType ctype = (ClassType)this.container;
        ConstantPool constants = this.data == null ? null : ctype.getConstants();
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", count: ");
        dst.println(this.count);
        for (int i = 0; i < this.count; ++i) {
            int index;
            String name;
            int inner_index = constants == null ? 0 : this.data[4 * i] & 65535;
            CpoolClass centry = constants == null || inner_index == 0 ? null : constants.getForcedClass(inner_index);
            ClassType clas = centry != null && centry.clas instanceof ClassType ? (ClassType)centry.clas : null;
            dst.print(' ');
            int access = inner_index == 0 && clas != null ? clas.getModifiers() : this.data[4 * i + 3] & 65535;
            dst.print(Access.toString(access, 'I'));
            dst.print(' ');
            if (inner_index == 0 && clas != null) {
                name = clas.getSimpleName();
            } else {
                index = this.data[4 * i + 2] & 65535;
                if (constants == null || index == 0) {
                    name = "(Anonymous)";
                } else {
                    dst.printOptionalIndex(index);
                    name = ((CpoolUtf8)constants.getForced((int)index, (int)1)).string;
                }
            }
            dst.print(name);
            dst.print(" = ");
            if (centry != null) {
                dst.printOptionalIndex(inner_index);
                name = centry.getClassName();
            } else {
                name = "(Unknown)";
            }
            dst.print(name);
            dst.print("; ");
            if (inner_index == 0 && clas != null) {
                int start;
                char ch;
                String iname = clas.getName();
                int dot = iname.lastIndexOf(46);
                if (dot > 0) {
                    iname = iname.substring(dot + 1);
                }
                if ((start = iname.lastIndexOf(36) + 1) < iname.length() && (ch = iname.charAt(start)) >= '0' && ch <= '9') {
                    dst.print("not a member");
                } else {
                    dst.print("member of ");
                    dst.print(ctype.getName());
                }
            } else {
                index = this.data[4 * i + 1] & 65535;
                if (index == 0) {
                    dst.print("not a member");
                } else {
                    dst.print("member of ");
                    CpoolEntry oentry = constants.getForced(index, 7);
                    dst.print(((CpoolClass)oentry).getStringName());
                }
            }
            dst.println();
        }
    }
}

