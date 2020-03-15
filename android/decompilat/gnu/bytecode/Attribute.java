// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public abstract class Attribute
{
    AttrContainer container;
    private Attribute next;
    String name;
    int name_index;
    
    public final AttrContainer getContainer() {
        return this.container;
    }
    
    public final void setContainer(final AttrContainer container) {
        this.container = container;
    }
    
    public final Attribute getNext() {
        return this.next;
    }
    
    public final void setNext(final Attribute next) {
        this.next = next;
    }
    
    public ConstantPool getConstants() {
        return this.getContainer().getConstants();
    }
    
    public void addToFrontOf(final AttrContainer container) {
        this.setContainer(container);
        this.setNext(container.getAttributes());
        container.setAttributes(this);
    }
    
    public final boolean isSkipped() {
        return this.name_index < 0;
    }
    
    public final void setSkipped(final boolean skip) {
        this.name_index = (skip ? -1 : 0);
    }
    
    public final void setSkipped() {
        this.name_index = -1;
    }
    
    public final String getName() {
        return this.name;
    }
    
    public final void setName(final String name) {
        this.name = name.intern();
    }
    
    public final int getNameIndex() {
        return this.name_index;
    }
    
    public final void setNameIndex(final int index) {
        this.name_index = index;
    }
    
    public Attribute(final String name) {
        this.name = name;
    }
    
    public static Attribute get(final AttrContainer container, final String name) {
        for (Attribute attr = container.getAttributes(); attr != null; attr = attr.next) {
            if (attr.getName() == name) {
                return attr;
            }
        }
        return null;
    }
    
    public void assignConstants(final ClassType cl) {
        if (this.name_index == 0) {
            this.name_index = cl.getConstants().addUtf8(this.name).getIndex();
        }
    }
    
    public static void assignConstants(final AttrContainer container, final ClassType cl) {
        for (Attribute attr = container.getAttributes(); attr != null; attr = attr.next) {
            if (!attr.isSkipped()) {
                attr.assignConstants(cl);
            }
        }
    }
    
    public abstract int getLength();
    
    public static int getLengthAll(final AttrContainer container) {
        int length = 0;
        for (Attribute attr = container.getAttributes(); attr != null; attr = attr.next) {
            if (!attr.isSkipped()) {
                length += 6 + attr.getLength();
            }
        }
        return length;
    }
    
    public abstract void write(final DataOutputStream p0) throws IOException;
    
    public static int count(final AttrContainer container) {
        int count = 0;
        for (Attribute attr = container.getAttributes(); attr != null; attr = attr.next) {
            if (!attr.isSkipped()) {
                ++count;
            }
        }
        return count;
    }
    
    public static void writeAll(final AttrContainer container, final DataOutputStream dstr) throws IOException {
        final int count = count(container);
        dstr.writeShort(count);
        for (Attribute attr = container.getAttributes(); attr != null; attr = attr.next) {
            if (!attr.isSkipped()) {
                if (attr.name_index == 0) {
                    throw new Error("Attribute.writeAll called without assignConstants");
                }
                dstr.writeShort(attr.name_index);
                dstr.writeInt(attr.getLength());
                attr.write(dstr);
            }
        }
    }
    
    public void print(final ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.println(this.getLength());
    }
}
