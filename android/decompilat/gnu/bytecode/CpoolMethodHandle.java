// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class CpoolMethodHandle extends CpoolEntry
{
    int kind;
    CpoolRef reference;
    
    public CpoolMethodHandle() {
    }
    
    CpoolMethodHandle(final ConstantPool cpool, final int hash, final int kind, final CpoolRef reference) {
        super(cpool, hash);
        this.kind = kind;
        this.reference = reference;
    }
    
    @Override
    public int getTag() {
        return 15;
    }
    
    static final int hashCode(final int kind, final CpoolRef reference) {
        return kind ^ reference.hashCode();
    }
    
    @Override
    public int hashCode() {
        if (this.hash == 0) {
            this.hash = hashCode(this.kind, this.reference);
        }
        return this.hash;
    }
    
    @Override
    void write(final DataOutputStream dstr) throws IOException {
        dstr.writeByte(15);
        dstr.writeByte(this.kind);
        dstr.writeShort(this.reference.index);
    }
    
    @Override
    public void print(final ClassTypeWriter dst, final int verbosity) {
        if (verbosity > 0) {
            dst.print("MethodHandle ");
            if (verbosity == 2) {
                dst.print(this.kind);
                dst.print('=');
            }
        }
        String kindStr = null;
        switch (this.kind) {
            case 1: {
                kindStr = "getField";
                break;
            }
            case 2: {
                kindStr = "getStatic";
                break;
            }
            case 3: {
                kindStr = "putField";
                break;
            }
            case 4: {
                kindStr = "putStatic";
                break;
            }
            case 5: {
                kindStr = "invokeVirtual";
                break;
            }
            case 6: {
                kindStr = "invokeStatic";
                break;
            }
            case 7: {
                kindStr = "invokeSpecial";
                break;
            }
            case 8: {
                kindStr = "invokeNewSpecial";
                break;
            }
            case 9: {
                kindStr = "invokeInterface";
                break;
            }
            default: {
                kindStr = "<unknown kind>";
                break;
            }
        }
        dst.print(kindStr);
        if (verbosity == 2) {
            dst.print(" reference:");
        }
        dst.print(' ');
        if (this.reference == null) {
            dst.print("(null)");
        }
        else {
            if (verbosity == 2) {
                dst.printOptionalIndex(this.reference);
            }
            this.reference.print(dst, 0);
        }
    }
}
