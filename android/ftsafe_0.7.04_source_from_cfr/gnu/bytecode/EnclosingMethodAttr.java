/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.AttrContainer;
import gnu.bytecode.Attribute;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolClass;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolNameAndType;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import java.io.DataOutputStream;
import java.io.IOException;

public class EnclosingMethodAttr
extends Attribute {
    int class_index;
    int method_index;
    Method method;

    public EnclosingMethodAttr(ClassType cl) {
        super("EnclosingMethod");
        this.addToFrontOf(cl);
    }

    public EnclosingMethodAttr(int class_index, int method_index, ClassType ctype) {
        this(ctype);
        this.class_index = class_index;
        this.method_index = method_index;
    }

    public static EnclosingMethodAttr getFirstEnclosingMethod(Attribute attr) {
        while (attr != null && !(attr instanceof EnclosingMethodAttr)) {
            attr = attr.getNext();
        }
        return (EnclosingMethodAttr)attr;
    }

    @Override
    public int getLength() {
        return 4;
    }

    @Override
    public void assignConstants(ClassType cl) {
        super.assignConstants(cl);
        if (this.method != null) {
            ConstantPool constants = cl.getConstants();
            this.class_index = constants.addClass(this.method.getDeclaringClass()).getIndex();
            this.method_index = constants.addNameAndType(this.method).getIndex();
        }
    }

    @Override
    public void write(DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.class_index);
        dstr.writeShort(this.method_index);
    }

    @Override
    public void print(ClassTypeWriter dst) {
        ClassType ctype = (ClassType)this.container;
        ConstantPool constants = ctype.getConstants();
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.println(this.getLength());
        dst.print("  class: ");
        dst.printOptionalIndex(this.class_index);
        CpoolEntry centry = constants.getForced(this.class_index, 7);
        dst.print(((CpoolClass)centry).getClassName());
        if (this.method_index != 0) {
            dst.print(", method: ");
            dst.printOptionalIndex(this.method_index);
            centry = constants.getForced(this.method_index, 12);
            centry.print(dst, 0);
        }
        dst.println();
    }
}

