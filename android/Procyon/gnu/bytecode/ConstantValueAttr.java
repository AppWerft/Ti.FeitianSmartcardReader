// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class ConstantValueAttr extends Attribute
{
    Object value;
    int value_index;
    
    public Object getValue(final ConstantPool cpool) {
        if (this.value != null) {
            return this.value;
        }
        final CpoolEntry entry = cpool.getPoolEntry(this.value_index);
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
                final float f = Float.intBitsToFloat(((CpoolValue1)entry).value);
                this.value = new Float(f);
                break;
            }
            case 6: {
                final double d = Double.longBitsToDouble(((CpoolValue2)entry).value);
                this.value = new Double(d);
                break;
            }
        }
        return this.value;
    }
    
    public ConstantValueAttr(final Object value) {
        super("ConstantValue");
        this.value = value;
    }
    
    public ConstantValueAttr(final int index) {
        super("ConstantValue");
        this.value_index = index;
    }
    
    @Override
    public void assignConstants(final ClassType cl) {
        super.assignConstants(cl);
        if (this.value_index == 0) {
            final ConstantPool cpool = cl.getConstants();
            CpoolEntry entry = null;
            if (this.value instanceof String) {
                entry = cpool.addString((String)this.value);
            }
            else if (this.value instanceof Integer) {
                entry = cpool.addInt((int)this.value);
            }
            else if (this.value instanceof Long) {
                entry = cpool.addLong((long)this.value);
            }
            else if (this.value instanceof Float) {
                entry = cpool.addFloat((float)this.value);
            }
            else if (this.value instanceof Long) {
                entry = cpool.addDouble((double)this.value);
            }
            this.value_index = entry.getIndex();
        }
    }
    
    @Override
    public final int getLength() {
        return 2;
    }
    
    @Override
    public void write(final DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.value_index);
    }
    
    @Override
    public void print(final ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", value: ");
        if (this.value_index == 0) {
            final Object value = this.getValue(dst.ctype.constants);
            if (value instanceof String) {
                dst.printQuotedString((String)value);
            }
            else {
                dst.print(value);
            }
        }
        else {
            dst.printOptionalIndex(this.value_index);
            final CpoolEntry entry = dst.ctype.constants.getPoolEntry(this.value_index);
            entry.print(dst, 1);
        }
        dst.println();
    }
}
