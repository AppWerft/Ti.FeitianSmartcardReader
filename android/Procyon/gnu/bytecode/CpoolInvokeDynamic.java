// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class CpoolInvokeDynamic extends CpoolEntry
{
    int bootstrapMethodIndex;
    CpoolNameAndType nameAndType;
    
    @Override
    public int getTag() {
        return 18;
    }
    
    @Override
    void write(final DataOutputStream dstr) throws IOException {
        dstr.writeByte(18);
        dstr.writeShort(this.bootstrapMethodIndex);
        dstr.writeShort(this.nameAndType.index);
    }
    
    @Override
    public void print(final ClassTypeWriter dst, final int verbosity) {
        if (verbosity > 0) {
            dst.print("InvokeDynamic ");
        }
        dst.print("bootstrap_method: #");
        dst.print(this.bootstrapMethodIndex);
        dst.print(' ');
        this.nameAndType.print(dst, 0);
    }
}
