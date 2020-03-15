// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class InnerClassesAttr extends Attribute
{
    int count;
    short[] data;
    
    public InnerClassesAttr(final ClassType cl) {
        super("InnerClasses");
        this.addToFrontOf(cl);
    }
    
    public InnerClassesAttr(final short[] data, final ClassType cl) {
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
    
    void addClass(final CpoolClass centry, final ClassType owner) {
        final int i = 4 * this.count++;
        if (this.data == null) {
            this.data = new short[16];
        }
        else if (i >= this.data.length) {
            final short[] tmp = new short[2 * i];
            System.arraycopy(this.data, 0, tmp, 0, i);
            this.data = tmp;
        }
        final ConstantPool constants = owner.constants;
        final ClassType clas = (ClassType)centry.getClassType();
        final String name = clas.getSimpleName();
        final int name_index = (name == null || name.length() == 0) ? 0 : constants.addUtf8(name).index;
        this.data[i] = (short)centry.index;
        final ClassType outer = clas.getDeclaringClass();
        this.data[i + 1] = (short)((outer == null) ? 0 : ((short)constants.addClass(outer).index));
        this.data[i + 2] = (short)name_index;
        int flags = clas.getModifiers();
        flags &= 0xFFFFFFDF;
        this.data[i + 3] = (short)flags;
    }
    
    @Override
    public void assignConstants(final ClassType cl) {
        super.assignConstants(cl);
    }
    
    @Override
    public int getLength() {
        return 2 + 8 * this.count;
    }
    
    @Override
    public void write(final DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.count);
        for (int i = 0; i < this.count; ++i) {
            dstr.writeShort(this.data[4 * i]);
            dstr.writeShort(this.data[4 * i + 1]);
            dstr.writeShort(this.data[4 * i + 2]);
            dstr.writeShort(this.data[4 * i + 3]);
        }
    }
    
    @Override
    public void print(final ClassTypeWriter dst) {
        final ClassType ctype = (ClassType)this.container;
        final ConstantPool constants = (this.data == null) ? null : ctype.getConstants();
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", count: ");
        dst.println(this.count);
        for (int i = 0; i < this.count; ++i) {
            final int inner_index = (constants == null) ? 0 : (this.data[4 * i] & 0xFFFF);
            final CpoolClass centry = (constants == null || inner_index == 0) ? null : constants.getForcedClass(inner_index);
            final ClassType clas = (centry != null && centry.clas instanceof ClassType) ? ((ClassType)centry.clas) : null;
            dst.print(' ');
            final int access = (inner_index == 0 && clas != null) ? clas.getModifiers() : (this.data[4 * i + 3] & 0xFFFF);
            dst.print(Access.toString(access, 'I'));
            dst.print(' ');
            String name;
            if (inner_index == 0 && clas != null) {
                name = clas.getSimpleName();
            }
            else {
                final int index = this.data[4 * i + 2] & 0xFFFF;
                if (constants == null || index == 0) {
                    name = "(Anonymous)";
                }
                else {
                    dst.printOptionalIndex(index);
                    name = ((CpoolUtf8)constants.getForced(index, 1)).string;
                }
            }
            dst.print(name);
            dst.print(" = ");
            if (centry != null) {
                dst.printOptionalIndex(inner_index);
                name = centry.getClassName();
            }
            else {
                name = "(Unknown)";
            }
            dst.print(name);
            dst.print("; ");
            if (inner_index == 0 && clas != null) {
                String iname = clas.getName();
                final int dot = iname.lastIndexOf(46);
                if (dot > 0) {
                    iname = iname.substring(dot + 1);
                }
                final int start = iname.lastIndexOf(36) + 1;
                final char ch;
                if (start < iname.length() && (ch = iname.charAt(start)) >= '0' && ch <= '9') {
                    dst.print("not a member");
                }
                else {
                    dst.print("member of ");
                    dst.print(ctype.getName());
                }
            }
            else {
                final int index = this.data[4 * i + 1] & 0xFFFF;
                if (index == 0) {
                    dst.print("not a member");
                }
                else {
                    dst.print("member of ");
                    final CpoolEntry oentry = constants.getForced(index, 7);
                    dst.print(((CpoolClass)oentry).getStringName());
                }
            }
            dst.println();
        }
    }
}
