/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.Attribute;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolString;
import gnu.bytecode.CpoolUtf8;
import gnu.bytecode.CpoolValue1;
import gnu.bytecode.CpoolValue2;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantValueAttr
extends Attribute {
    Object value;
    int value_index;

    public Object getValue(ConstantPool cpool) {
        if (this.value != null) {
            return this.value;
        }
        CpoolEntry entry = cpool.getPoolEntry(this.value_index);
        switch (entry.getTag()) {
            case 8: {
                this.value = ((CpoolString)entry).getString().getString();
                break;
            }
            case 3: {
                this.value = new Integer(((CpoolValue1)entry).value);
                break;
            }
            case 5: {
                this.value = new Long(((CpoolValue2)entry).value);
                break;
            }
            case 4: {
                float f = Float.intBitsToFloat(((CpoolValue1)entry).value);
                this.value = new Float(f);
                break;
            }
            case 6: {
                double d = Double.longBitsToDouble(((CpoolValue2)entry).value);
                this.value = new Double(d);
            }
        }
        return this.value;
    }

    public ConstantValueAttr(Object value) {
        super("ConstantValue");
        this.value = value;
    }

    public ConstantValueAttr(int index) {
        super("ConstantValue");
        this.value_index = index;
    }

    @Override
    public void assignConstants(ClassType cl) {
        super.assignConstants(cl);
        if (this.value_index == 0) {
            ConstantPool cpool = cl.getConstants();
            CpoolEntry entry = null;
            if (this.value instanceof String) {
                entry = cpool.addString((String)this.value);
            } else if (this.value instanceof Integer) {
                entry = cpool.addInt((Integer)this.value);
            } else if (this.value instanceof Long) {
                entry = cpool.addLong((Long)this.value);
            } else if (this.value instanceof Float) {
                entry = cpool.addFloat(((Float)this.value).floatValue());
            } else if (this.value instanceof Long) {
                entry = cpool.addDouble((Double)this.value);
            }
            this.value_index = entry.getIndex();
        }
    }

    @Override
    public final int getLength() {
        return 2;
    }

    @Override
    public void write(DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.value_index);
    }

    @Override
    public void print(ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", value: ");
        if (this.value_index == 0) {
            Object value = this.getValue(dst.ctype.constants);
            if (value instanceof String) {
                dst.printQuotedString((String)value);
            } else {
                dst.print(value);
            }
        } else {
            dst.printOptionalIndex(this.value_index);
            CpoolEntry entry = dst.ctype.constants.getPoolEntry(this.value_index);
            entry.print(dst, 1);
        }
        dst.println();
    }
}

