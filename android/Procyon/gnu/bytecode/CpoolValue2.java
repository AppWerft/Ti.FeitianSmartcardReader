// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class CpoolValue2 extends CpoolEntry
{
    int tag;
    long value;
    
    CpoolValue2(final int tag) {
        this.tag = tag;
    }
    
    CpoolValue2(final ConstantPool cpool, final int tag, final int hash, final long value) {
        super(cpool, hash);
        this.tag = tag;
        this.value = value;
        ++cpool.count;
    }
    
    @Override
    public int getTag() {
        return this.tag;
    }
    
    public final long getValue() {
        return this.value;
    }
    
    static int hashCode(final long val) {
        return (int)val;
    }
    
    @Override
    public int hashCode() {
        if (this.hash == 0) {
            this.hash = hashCode(this.value);
        }
        return this.hash;
    }
    
    @Override
    void write(final DataOutputStream dstr) throws IOException {
        dstr.writeByte(this.tag);
        dstr.writeLong(this.value);
    }
    
    @Override
    public void print(final ClassTypeWriter dst, final int verbosity) {
        if (this.tag == 5) {
            if (verbosity > 0) {
                dst.print("Long ");
            }
            dst.print(this.value);
            if (verbosity > 1 && this.value != 0L) {
                dst.print("=0x");
                dst.print(Long.toHexString(this.value));
            }
        }
        else {
            if (verbosity > 0) {
                dst.print("Double ");
            }
            dst.print(Double.longBitsToDouble(this.value));
            if (verbosity > 1) {
                dst.print("=0x");
                dst.print(Long.toHexString(this.value));
            }
        }
    }
}
