/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolNameAndType;
import java.io.DataOutputStream;
import java.io.IOException;

public class CpoolInvokeDynamic
extends CpoolEntry {
    int bootstrapMethodIndex;
    CpoolNameAndType nameAndType;

    @Override
    public int getTag() {
        return 18;
    }

    @Override
    void write(DataOutputStream dstr) throws IOException {
        dstr.writeByte(18);
        dstr.writeShort(this.bootstrapMethodIndex);
        dstr.writeShort(this.nameAndType.index);
    }

    @Override
    public void print(ClassTypeWriter dst, int verbosity) {
        if (verbosity > 0) {
            dst.print("InvokeDynamic ");
        }
        dst.print("bootstrap_method: #");
        dst.print(this.bootstrapMethodIndex);
        dst.print(' ');
        this.nameAndType.print(dst, 0);
    }
}

