// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.DataOutputStream;

public class CpoolClass extends CpoolEntry
{
    CpoolUtf8 name;
    ObjectType clas;
    
    CpoolClass() {
    }
    
    CpoolClass(final ConstantPool cpool, final int hash, final CpoolUtf8 n) {
        super(cpool, hash);
        this.name = n;
    }
    
    @Override
    public int getTag() {
        return 7;
    }
    
    public final CpoolUtf8 getName() {
        return this.name;
    }
    
    public final String getStringName() {
        return this.name.string;
    }
    
    public final String getClassName() {
        return this.name.string.replace('/', '.');
    }
    
    public final ObjectType getClassType() {
        ObjectType otype = this.clas;
        if (otype != null) {
            return otype;
        }
        final String name = this.name.string;
        if (name.charAt(0) == '[') {
            otype = (ObjectType)Type.signatureToType(name);
        }
        else {
            otype = ClassType.make(name.replace('/', '.'));
        }
        return this.clas = otype;
    }
    
    static final int hashCode(final CpoolUtf8 name) {
        return name.hashCode() ^ 0xF0F;
    }
    
    @Override
    public int hashCode() {
        if (this.hash == 0) {
            this.hash = hashCode(this.name);
        }
        return this.hash;
    }
    
    @Override
    void write(final DataOutputStream dstr) throws IOException {
        dstr.writeByte(7);
        dstr.writeShort(this.name.index);
    }
    
    @Override
    public void print(final ClassTypeWriter dst, final int verbosity) {
        if (verbosity == 1) {
            dst.print("Class ");
        }
        else if (verbosity > 1) {
            dst.print("Class name: ");
            dst.printOptionalIndex(this.name);
        }
        final String str = this.name.string;
        final int nlen = str.length();
        if (nlen > 1 && str.charAt(0) == '[') {
            Type.printSignature(str, 0, nlen, dst);
        }
        else {
            dst.print(str.replace('/', '.'));
        }
    }
}
