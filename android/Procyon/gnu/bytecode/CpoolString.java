// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class CpoolString extends CpoolEntry
{
    CpoolUtf8 str;
    
    CpoolString() {
    }
    
    CpoolString(final ConstantPool cpool, final int hash, final CpoolUtf8 str) {
        super(cpool, hash);
        this.str = str;
    }
    
    @Override
    public int getTag() {
        return 8;
    }
    
    public final CpoolUtf8 getString() {
        return this.str;
    }
    
    static final int hashCode(final CpoolUtf8 str) {
        return str.hashCode() ^ 0xF30F;
    }
    
    @Override
    public int hashCode() {
        if (this.hash == 0) {
            this.hash = hashCode(this.str);
        }
        return this.hash;
    }
    
    @Override
    void write(final DataOutputStream dstr) throws IOException {
        dstr.writeByte(8);
        dstr.writeShort(this.str.index);
    }
    
    @Override
    public void print(final ClassTypeWriter dst, final int verbosity) {
        if (verbosity > 0) {
            dst.print("String ");
            if (verbosity == 2) {
                dst.printOptionalIndex(this.str);
            }
        }
        dst.printConstantTersely(this.str.index, 1);
    }
}
