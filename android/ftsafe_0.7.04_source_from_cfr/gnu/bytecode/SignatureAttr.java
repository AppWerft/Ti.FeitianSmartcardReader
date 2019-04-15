/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.Attribute;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolUtf8;
import gnu.bytecode.Member;
import java.io.DataOutputStream;
import java.io.IOException;

public class SignatureAttr
extends Attribute {
    String signature;
    int signature_index;

    public final String getSignature() {
        return this.signature;
    }

    protected void setSignature(String sig) {
        this.signature = sig;
        this.signature_index = 0;
    }

    public SignatureAttr(String signature) {
        super("Signature");
        this.signature = signature;
    }

    public SignatureAttr(int index, Member owner) {
        super("Signature");
        ClassType ctype = owner instanceof ClassType ? (ClassType)owner : owner.getDeclaringClass();
        CpoolUtf8 signatureConstant = (CpoolUtf8)ctype.constants.getForced(index, 1);
        this.signature = signatureConstant.string;
        this.signature_index = index;
    }

    @Override
    public void assignConstants(ClassType cl) {
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
    public void write(DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.signature_index);
    }

    @Override
    public void print(ClassTypeWriter dst) {
        super.print(dst);
        dst.print("  ");
        dst.printOptionalIndex(this.signature_index);
        dst.print('\"');
        dst.print(this.getSignature());
        dst.println('\"');
    }
}

