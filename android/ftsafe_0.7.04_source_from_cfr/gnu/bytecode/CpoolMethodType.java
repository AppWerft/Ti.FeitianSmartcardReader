/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolUtf8;
import java.io.DataOutputStream;
import java.io.IOException;

public class CpoolMethodType
extends CpoolEntry {
    CpoolUtf8 descriptor;

    @Override
    public int getTag() {
        return 16;
    }

    @Override
    void write(DataOutputStream dstr) throws IOException {
        throw new Error();
    }

    @Override
    public void print(ClassTypeWriter dst, int verbosity) {
        if (verbosity > 0) {
            dst.print("MethodType");
            if (verbosity == 2) {
                dst.print(" descriptor: ");
                dst.printOptionalIndex(this.descriptor);
            } else {
                dst.print(' ');
            }
        }
        this.descriptor.print(dst, 0);
    }
}

