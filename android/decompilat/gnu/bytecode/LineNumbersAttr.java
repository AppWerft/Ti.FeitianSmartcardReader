// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class LineNumbersAttr extends Attribute
{
    short[] linenumber_table;
    int linenumber_count;
    
    public LineNumbersAttr(final CodeAttr code) {
        super("LineNumberTable");
        this.addToFrontOf(code);
        code.lines = this;
    }
    
    public LineNumbersAttr(final short[] numbers, final CodeAttr code) {
        this(code);
        this.linenumber_table = numbers;
        this.linenumber_count = numbers.length >> 1;
    }
    
    public void put(final int linenumber, final int PC) {
        if (this.linenumber_table == null) {
            this.linenumber_table = new short[32];
        }
        else if (2 * this.linenumber_count >= this.linenumber_table.length) {
            final short[] new_linenumbers = new short[2 * this.linenumber_table.length];
            System.arraycopy(this.linenumber_table, 0, new_linenumbers, 0, 2 * this.linenumber_count);
            this.linenumber_table = new_linenumbers;
        }
        this.linenumber_table[2 * this.linenumber_count] = (short)PC;
        this.linenumber_table[2 * this.linenumber_count + 1] = (short)linenumber;
        ++this.linenumber_count;
    }
    
    @Override
    public final int getLength() {
        return 2 + 4 * this.linenumber_count;
    }
    
    public int getLineCount() {
        return this.linenumber_count;
    }
    
    public short[] getLineNumberTable() {
        return this.linenumber_table;
    }
    
    @Override
    public void write(final DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.linenumber_count);
        for (int count = 2 * this.linenumber_count, i = 0; i < count; ++i) {
            dstr.writeShort(this.linenumber_table[i]);
        }
    }
    
    @Override
    public void print(final ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", count: ");
        dst.println(this.linenumber_count);
        for (int i = 0; i < this.linenumber_count; ++i) {
            dst.print("  line: ");
            dst.print(this.linenumber_table[2 * i + 1] & 0xFFFF);
            dst.print(" at pc: ");
            dst.println(this.linenumber_table[2 * i] & 0xFFFF);
        }
    }
}
