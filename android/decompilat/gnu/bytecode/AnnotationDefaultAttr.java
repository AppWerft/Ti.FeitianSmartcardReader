// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class AnnotationDefaultAttr extends Attribute
{
    int dataLength;
    AnnotationEntry.Value value;
    
    public AnnotationDefaultAttr(final String name, final AnnotationEntry.Value value, final AttrContainer container) {
        super(name);
        this.value = value;
        this.addToFrontOf(container);
    }
    
    @Override
    public int getLength() {
        return this.dataLength;
    }
    
    @Override
    public void print(final ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.println(this.getLength());
        dst.print("  Default: ");
        this.value.print(2, dst);
    }
    
    @Override
    public void assignConstants(final ClassType cl) {
        super.assignConstants(cl);
        this.dataLength += RuntimeAnnotationsAttr.assignConstants(this.value, cl.getConstants());
    }
    
    @Override
    public void write(final DataOutputStream dstr) throws IOException {
        RuntimeAnnotationsAttr.write(this.value, this.getConstants(), dstr);
    }
}
