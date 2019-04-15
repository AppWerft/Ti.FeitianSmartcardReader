/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.AttrContainer;
import gnu.bytecode.Attribute;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.CodeAttr;
import java.io.DataOutputStream;
import java.io.IOException;

public class LineNumbersAttr
extends Attribute {
    short[] linenumber_table;
    int linenumber_count;

    public LineNumbersAttr(CodeAttr code) {
        super("LineNumberTable");
        this.addToFrontOf(code);
        code.lines = this;
    }

    public LineNumbersAttr(short[] numbers2, CodeAttr code) {
        this(code);
        this.linenumber_table = numbers2;
        this.linenumber_count = numbers2.length >> 1;
    }

    public void put(int linenumber, int PC) {
        if (this.linenumber_table == null) {
            this.linenumber_table = new short[32];
        } else if (2 * this.linenumber_count >= this.linenumber_table.length) {
            short[] new_linenumbers = new short[2 * this.linenumber_table.length];
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
    public void write(DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.linenumber_count);
        int count = 2 * this.linenumber_count;
        for (int i = 0; i < count; ++i) {
            dstr.writeShort(this.linenumber_table[i]);
        }
    }

    @Override
    public void print(ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", count: ");
        dst.println(this.linenumber_count);
        for (int i = 0; i < this.linenumber_count; ++i) {
            dst.print("  line: ");
            dst.print(this.linenumber_table[2 * i + 1] & 65535);
            dst.print(" at pc: ");
            dst.println(this.linenumber_table[2 * i] & 65535);
        }
    }
}

