// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class CpoolRef extends CpoolEntry
{
    CpoolClass clas;
    CpoolNameAndType nameAndType;
    int tag;
    
    @Override
    public int getTag() {
        return this.tag;
    }
    
    public final CpoolClass getCpoolClass() {
        return this.clas;
    }
    
    public final CpoolNameAndType getNameAndType() {
        return this.nameAndType;
    }
    
    CpoolRef(final int tag) {
        this.tag = tag;
    }
    
    CpoolRef(final ConstantPool cpool, final int hash, final int tag, final CpoolClass clas, final CpoolNameAndType nameAndType) {
        super(cpool, hash);
        this.tag = tag;
        this.clas = clas;
        this.nameAndType = nameAndType;
    }
    
    static final int hashCode(final CpoolClass clas, final CpoolNameAndType nameAndType) {
        return clas.hashCode() ^ nameAndType.hashCode();
    }
    
    @Override
    public int hashCode() {
        if (this.hash == 0) {
            this.hash = hashCode(this.clas, this.nameAndType);
        }
        return this.hash;
    }
    
    @Override
    void write(final DataOutputStream dstr) throws IOException {
        dstr.writeByte(this.tag);
        dstr.writeShort(this.clas.index);
        dstr.writeShort(this.nameAndType.index);
    }
    
    @Override
    public void print(final ClassTypeWriter dst, final int verbosity) {
        String str = null;
        switch (this.tag) {
            case 9: {
                str = "Field";
                break;
            }
            case 10: {
                str = "Method";
                break;
            }
            case 11: {
                str = "InterfaceMethod";
                break;
            }
            default: {
                str = "<Unknown>Ref";
                break;
            }
        }
        if (verbosity > 0) {
            dst.print(str);
            if (verbosity == 2) {
                dst.print(" class: ");
                dst.printOptionalIndex(this.clas);
            }
            else {
                dst.print(' ');
            }
        }
        this.clas.print(dst, 0);
        if (verbosity < 2) {
            dst.print('.');
        }
        else {
            dst.print(" name_and_type: ");
            dst.printOptionalIndex(this.nameAndType);
            dst.print('<');
        }
        this.nameAndType.print(dst, 0);
        if (verbosity == 2) {
            dst.print('>');
        }
    }
}
