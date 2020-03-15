// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class SignatureAttr extends Attribute
{
    String signature;
    int signature_index;
    
    public final String getSignature() {
        return this.signature;
    }
    
    protected void setSignature(final String sig) {
        this.signature = sig;
        this.signature_index = 0;
    }
    
    public SignatureAttr(final String signature) {
        super("Signature");
        this.signature = signature;
    }
    
    public SignatureAttr(final int index, final Member owner) {
        super("Signature");
        final ClassType ctype = (ClassType)((owner instanceof ClassType) ? owner : owner.getDeclaringClass());
        final CpoolUtf8 signatureConstant = (CpoolUtf8)ctype.constants.getForced(index, 1);
        this.signature = signatureConstant.string;
        this.signature_index = index;
    }
    
    @Override
    public void assignConstants(final ClassType cl) {
        super.assignConstants(cl);
        if (this.signature_index == 0) {
            this.signature_index = cl.getConstants().addUtf8(this.signature).getIndex();
        }
    }
    
    @Override
    public final int getLength() {
        return 2;
    }
    
    @Override
    public void write(final DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.signature_index);
    }
    
    @Override
    public void print(final ClassTypeWriter dst) {
        super.print(dst);
        dst.print("  ");
        dst.printOptionalIndex(this.signature_index);
        dst.print('\"');
        dst.print(this.getSignature());
        dst.println('\"');
    }
}
