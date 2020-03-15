// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class ExceptionsAttr extends Attribute
{
    ClassType[] exceptions;
    short[] exception_table;
    
    public ExceptionsAttr(final Method meth) {
        super("Exceptions");
        this.addToFrontOf(meth);
    }
    
    public void setExceptions(final short[] indices, final ClassType cl) {
        this.exception_table = indices;
        this.exceptions = new ClassType[indices.length];
        final ConstantPool cp = cl.getConstants();
        for (int i = indices.length - 1; i >= 0; --i) {
            this.exceptions[i] = (ClassType)((CpoolClass)cp.getPoolEntry(indices[i])).getClassType();
        }
    }
    
    public void setExceptions(final ClassType[] excep_types) {
        this.exceptions = excep_types;
    }
    
    @Override
    public void assignConstants(final ClassType cl) {
        super.assignConstants(cl);
        final ConstantPool cp = cl.getConstants();
        final int count = this.exceptions.length;
        this.exception_table = new short[count];
        for (int i = count - 1; i >= 0; --i) {
            this.exception_table[i] = (short)cp.addClass(this.exceptions[i]).index;
        }
    }
    
    @Override
    public final int getLength() {
        return 2 + 2 * ((this.exceptions == null) ? 0 : this.exceptions.length);
    }
    
    public final ClassType[] getExceptions() {
        return this.exceptions;
    }
    
    @Override
    public void write(final DataOutputStream dstr) throws IOException {
        final int count = this.exceptions.length;
        dstr.writeShort(count);
        for (int i = 0; i < count; ++i) {
            dstr.writeShort(this.exception_table[i]);
        }
    }
    
    @Override
    public void print(final ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", count: ");
        final int count = this.exceptions.length;
        dst.println(count);
        for (int i = 0; i < count; ++i) {
            final int catch_type_index = this.exception_table[i] & 0xFFFF;
            dst.print("  ");
            dst.printOptionalIndex(catch_type_index);
            dst.printConstantTersely(catch_type_index, 7);
            dst.println();
        }
    }
}
