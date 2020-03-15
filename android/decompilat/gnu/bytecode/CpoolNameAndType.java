// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class CpoolNameAndType extends CpoolEntry
{
    CpoolUtf8 name;
    CpoolUtf8 type;
    
    CpoolNameAndType() {
    }
    
    CpoolNameAndType(final ConstantPool cpool, final int hash, final CpoolUtf8 n, final CpoolUtf8 t) {
        super(cpool, hash);
        this.name = n;
        this.type = t;
    }
    
    @Override
    public int getTag() {
        return 12;
    }
    
    public final CpoolUtf8 getName() {
        return this.name;
    }
    
    public final CpoolUtf8 getType() {
        return this.type;
    }
    
    static final int hashCode(final CpoolUtf8 name, final CpoolUtf8 type) {
        return name.hashCode() ^ type.hashCode();
    }
    
    @Override
    public int hashCode() {
        if (this.hash == 0) {
            this.hash = hashCode(this.name, this.type);
        }
        return this.hash;
    }
    
    @Override
    void write(final DataOutputStream dstr) throws IOException {
        dstr.writeByte(12);
        dstr.writeShort(this.name.index);
        dstr.writeShort(this.type.index);
    }
    
    @Override
    public void print(final ClassTypeWriter dst, final int verbosity) {
        if (verbosity == 1) {
            dst.print("NameAndType ");
        }
        else if (verbosity > 1) {
            dst.print("NameAndType name: ");
            dst.printOptionalIndex(this.name);
        }
        dst.printName(this.name.string);
        if (verbosity <= 1) {
            dst.print(' ');
        }
        else {
            dst.print(", signature: ");
            dst.printOptionalIndex(this.type);
        }
        dst.printSignature(this.type.string);
    }
}
