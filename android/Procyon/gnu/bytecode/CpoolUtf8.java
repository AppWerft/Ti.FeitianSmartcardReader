// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class CpoolUtf8 extends CpoolEntry
{
    String string;
    
    CpoolUtf8() {
    }
    
    CpoolUtf8(final ConstantPool cpool, final int h, final String s) {
        super(cpool, h);
        this.string = s;
    }
    
    @Override
    public int hashCode() {
        if (this.hash == 0) {
            this.hash = this.string.hashCode();
        }
        return this.hash;
    }
    
    public final void intern() {
        this.string = this.string.intern();
    }
    
    @Override
    public int getTag() {
        return 1;
    }
    
    public final String getString() {
        return this.string;
    }
    
    @Override
    void write(final DataOutputStream dstr) throws IOException {
        dstr.writeByte(1);
        dstr.writeUTF(this.string);
    }
    
    @Override
    public void print(final ClassTypeWriter dst, final int verbosity) {
        if (verbosity > 0) {
            dst.print("Utf8: ");
        }
        dst.printQuotedString(this.string);
    }
}
