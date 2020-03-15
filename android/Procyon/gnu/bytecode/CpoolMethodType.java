// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class CpoolMethodType extends CpoolEntry
{
    CpoolUtf8 descriptor;
    
    @Override
    public int getTag() {
        return 16;
    }
    
    @Override
    void write(final DataOutputStream dstr) throws IOException {
        throw new Error();
    }
    
    @Override
    public void print(final ClassTypeWriter dst, final int verbosity) {
        if (verbosity > 0) {
            dst.print("MethodType");
            if (verbosity == 2) {
                dst.print(" descriptor: ");
                dst.printOptionalIndex(this.descriptor);
            }
            else {
                dst.print(' ');
            }
        }
        this.descriptor.print(dst, 0);
    }
}
