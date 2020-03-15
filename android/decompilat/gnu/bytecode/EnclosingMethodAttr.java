// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class EnclosingMethodAttr extends Attribute
{
    int class_index;
    int method_index;
    Method method;
    
    public EnclosingMethodAttr(final ClassType cl) {
        super("EnclosingMethod");
        this.addToFrontOf(cl);
    }
    
    public EnclosingMethodAttr(final int class_index, final int method_index, final ClassType ctype) {
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
    public void assignConstants(final ClassType cl) {
        super.assignConstants(cl);
        if (this.method != null) {
            final ConstantPool constants = cl.getConstants();
            this.class_index = constants.addClass(this.method.getDeclaringClass()).getIndex();
            this.method_index = constants.addNameAndType(this.method).getIndex();
        }
    }
    
    @Override
    public void write(final DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.class_index);
        dstr.writeShort(this.method_index);
    }
    
    @Override
    public void print(final ClassTypeWriter dst) {
        final ClassType ctype = (ClassType)this.container;
        final ConstantPool constants = ctype.getConstants();
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
