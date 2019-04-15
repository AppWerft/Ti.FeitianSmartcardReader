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
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import java.io.DataOutputStream;
import java.io.IOException;

public class ExceptionsAttr
extends Attribute {
    ClassType[] exceptions;
    short[] exception_table;

    public ExceptionsAttr(Method meth) {
        super("Exceptions");
        this.addToFrontOf(meth);
    }

    public void setExceptions(short[] indices, ClassType cl) {
        this.exception_table = indices;
        this.exceptions = new ClassType[indices.length];
        ConstantPool cp = cl.getConstants();
        for (int i = indices.length - 1; i >= 0; --i) {
            this.exceptions[i] = (ClassType)((CpoolClass)cp.getPoolEntry(indices[i])).getClassType();
        }
    }

    public void setExceptions(ClassType[] excep_types) {
        this.exceptions = excep_types;
    }

    @Override
    public void assignConstants(ClassType cl) {
        super.assignConstants(cl);
        ConstantPool cp = cl.getConstants();
        int count = this.exceptions.length;
        this.exception_table = new short[count];
        for (int i = count - 1; i >= 0; --i) {
            this.exception_table[i] = (short)cp.addClass((ObjectType)this.exceptions[i]).index;
        }
    }

    @Override
    public final int getLength() {
        return 2 + 2 * (this.exceptions == null ? 0 : this.exceptions.length);
    }

    public final ClassType[] getExceptions() {
        return this.exceptions;
    }

    @Override
    public void write(DataOutputStream dstr) throws IOException {
        int count = this.exceptions.length;
        dstr.writeShort(count);
        for (int i = 0; i < count; ++i) {
            dstr.writeShort(this.exception_table[i]);
        }
    }

    @Override
    public void print(ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", count: ");
        int count = this.exceptions.length;
        dst.println(count);
        for (int i = 0; i < count; ++i) {
            int catch_type_index = this.exception_table[i] & 65535;
            dst.print("  ");
            dst.printOptionalIndex(catch_type_index);
            dst.printConstantTersely(catch_type_index, 7);
            dst.println();
        }
    }
}

