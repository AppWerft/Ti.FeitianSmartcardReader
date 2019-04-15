/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolUtf8;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import java.io.DataOutputStream;
import java.io.IOException;

public class CpoolClass
extends CpoolEntry {
    CpoolUtf8 name;
    ObjectType clas;

    CpoolClass() {
    }

    CpoolClass(ConstantPool cpool, int hash, CpoolUtf8 n) {
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
        String name = this.name.string;
        otype = name.charAt(0) == '[' ? (ObjectType)Type.signatureToType(name) : ClassType.make(name.replace('/', '.'));
        this.clas = otype;
        return otype;
    }

    static final int hashCode(CpoolUtf8 name) {
        return name.hashCode() ^ 3855;
    }

    @Override
    public int hashCode() {
        if (this.hash == 0) {
            this.hash = CpoolClass.hashCode(this.name);
        }
        return this.hash;
    }

    @Override
    void write(DataOutputStream dstr) throws IOException {
        dstr.writeByte(7);
        dstr.writeShort(this.name.index);
    }

    @Override
    public void print(ClassTypeWriter dst, int verbosity) {
        if (verbosity == 1) {
            dst.print("Class ");
        } else if (verbosity > 1) {
            dst.print("Class name: ");
            dst.printOptionalIndex(this.name);
        }
        String str = this.name.string;
        int nlen = str.length();
        if (nlen > 1 && str.charAt(0) == '[') {
            Type.printSignature(str, 0, nlen, dst);
        } else {
            dst.print(str.replace('/', '.'));
        }
    }
}

