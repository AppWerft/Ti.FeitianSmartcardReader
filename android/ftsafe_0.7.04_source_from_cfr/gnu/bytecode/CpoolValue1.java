/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolEntry;
import java.io.DataOutputStream;
import java.io.IOException;

public class CpoolValue1
extends CpoolEntry {
    int tag;
    int value;

    CpoolValue1(int tag) {
        this.tag = tag;
    }

    CpoolValue1(ConstantPool cpool, int tag, int hash, int value) {
        super(cpool, hash);
        this.tag = tag;
        this.value = value;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    public final int getValue() {
        return this.value;
    }

    static int hashCode(int val) {
        return val;
    }

    @Override
    public int hashCode() {
        if (this.hash == 0) {
            this.hash = this.value;
        }
        return this.hash;
    }

    @Override
    void write(DataOutputStream dstr) throws IOException {
        dstr.writeByte(this.tag);
        dstr.writeInt(this.value);
    }

    @Override
    public void print(ClassTypeWriter dst, int verbosity) {
        if (this.tag == 3) {
            if (verbosity > 0) {
                dst.print("Integer ");
            }
            dst.print(this.value);
            if (verbosity > 1 && this.value != 0) {
                dst.print("=0x");
                dst.print(Integer.toHexString(this.value));
            }
        } else {
            if (verbosity > 0) {
                dst.print("Float ");
            }
            dst.print(Float.intBitsToFloat(this.value));
            if (verbosity > 1) {
                dst.print("=0x");
                dst.print(Integer.toHexString(this.value));
            }
        }
    }
}

