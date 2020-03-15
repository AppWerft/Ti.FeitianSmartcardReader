// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class MiscAttr extends Attribute
{
    byte[] data;
    int offset;
    int dataLength;
    
    public MiscAttr(final String name, final byte[] data, final int offset, final int length) {
        super(name);
        this.data = data;
        this.offset = offset;
        this.dataLength = length;
    }
    
    public MiscAttr(final String name, final byte[] data) {
        this(name, data, 0, data.length);
    }
    
    @Override
    public int getLength() {
        return this.dataLength;
    }
    
    protected int u1(final int offset) {
        return this.data[offset] & 0xFF;
    }
    
    protected int u2(final int offset) {
        return ((this.data[offset] & 0xFF) << 8) + (this.data[offset + 1] & 0xFF);
    }
    
    protected int u1() {
        return this.u1(this.offset++);
    }
    
    protected int u2() {
        final int v = this.u2(this.offset);
        this.offset += 2;
        return v;
    }
    
    protected void put1(final int val) {
        if (this.data == null) {
            this.data = new byte[20];
        }
        else if (this.dataLength >= this.data.length) {
            final byte[] tmp = new byte[2 * this.data.length];
            System.arraycopy(this.data, 0, tmp, 0, this.dataLength);
            this.data = tmp;
        }
        this.data[this.dataLength++] = (byte)val;
    }
    
    protected void put2(final int val) {
        this.put1((byte)(val >> 8));
        this.put1((byte)val);
    }
    
    protected void put2(final int offset, final int val) {
        this.data[offset] = (byte)(val >> 8);
        this.data[offset + 1] = (byte)val;
    }
    
    @Override
    public void write(final DataOutputStream dstr) throws IOException {
        dstr.write(this.data, this.offset, this.dataLength);
    }
    
    @Override
    public void print(final ClassTypeWriter dst) {
        super.print(dst);
        final int len = this.getLength();
        int i = 0;
        while (i < len) {
            final int b = this.data[i];
            if (i % 20 == 0) {
                dst.print(' ');
            }
            dst.print(' ');
            dst.print(Character.forDigit(b >> 4 & 0xF, 16));
            dst.print(Character.forDigit(b & 0xF, 16));
            if (++i % 20 == 0 || i == len) {
                dst.println();
            }
        }
    }
}
