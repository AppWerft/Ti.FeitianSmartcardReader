/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolEntry;
import java.io.DataOutputStream;
import java.io.IOException;

public class CpoolValue2
extends CpoolEntry {
    int tag;
    long value;

    CpoolValue2(int tag) {
        this.tag = tag;
    }

    CpoolValue2(ConstantPool cpool, int tag, int hash, long value) {
        super(cpool, hash);
        this.tag = tag;
        this.value = value;
        ++cpool.count;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    public final long getValue() {
        return this.value;
    }

    static int hashCode(long val) {
        return (int)val;
    }

    @Override
    public int hashCode() {
        if (this.hash == 0) {
            this.hash = CpoolValue2.hashCode(this.value);
        }
        return this.hash;
    }

    @Override
    void write(DataOutputStream dstr) throws IOException {
        dstr.writeByte(this.tag);
        dstr.writeLong(this.value);
    }

    @Override
    public void print(ClassTypeWriter dst, int verbosity) {
        if (this.tag == 5) {
            if (verbosity > 0) {
                dst.print("Long ");
            }
            dst.print(this.value);
            if (verbosity > 1 && this.value != 0L) {
                dst.print("=0x");
                dst.print(Long.toHexString(this.value));
            }
        } else {
            if (verbosity > 0) {
                dst.print("Double ");
            }
            dst.print(Double.longBitsToDouble(this.value));
            if (verbosity > 1) {
                dst.print("=0x");
                dst.print(Long.toHexString(this.value));
            }
        }
    }
}

