/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.Attribute;
import gnu.bytecode.ClassTypeWriter;
import java.io.DataOutputStream;
import java.io.IOException;

public class MiscAttr
extends Attribute {
    byte[] data;
    int offset;
    int dataLength;

    public MiscAttr(String name, byte[] data, int offset, int length) {
        super(name);
        this.data = data;
        this.offset = offset;
        this.dataLength = length;
    }

    public MiscAttr(String name, byte[] data) {
        this(name, data, 0, data.length);
    }

    @Override
    public int getLength() {
        return this.dataLength;
    }

    protected int u1(int offset) {
        return this.data[offset] & 255;
    }

    protected int u2(int offset) {
        return ((this.data[offset] & 255) << 8) + (this.data[offset + 1] & 255);
    }

    protected int u1() {
        return this.u1(this.offset++);
    }

    protected int u2() {
        int v = this.u2(this.offset);
        this.offset += 2;
        return v;
    }

    protected void put1(int val) {
        if (this.data == null) {
            this.data = new byte[20];
        } else if (this.dataLength >= this.data.length) {
            byte[] tmp = new byte[2 * this.data.length];
            System.arraycopy(this.data, 0, tmp, 0, this.dataLength);
            this.data = tmp;
        }
        this.data[this.dataLength++] = (byte)val;
    }

    protected void put2(int val) {
        this.put1((byte)(val >> 8));
        this.put1((byte)val);
    }

    protected void put2(int offset, int val) {
        this.data[offset] = (byte)(val >> 8);
        this.data[offset + 1] = (byte)val;
    }

    @Override
    public void write(DataOutputStream dstr) throws IOException {
        dstr.write(this.data, this.offset, this.dataLength);
    }

    @Override
    public void print(ClassTypeWriter dst) {
        super.print(dst);
        int len = this.getLength();
        int i = 0;
        while (i < len) {
            byte b = this.data[i];
            if (i % 20 == 0) {
                dst.print(' ');
            }
            dst.print(' ');
            dst.print(Character.forDigit(b >> 4 & 15, 16));
            dst.print(Character.forDigit(b & 15, 16));
            if (++i % 20 != 0 && i != len) continue;
            dst.println();
        }
    }
}

