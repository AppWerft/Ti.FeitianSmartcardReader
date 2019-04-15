/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.AttrContainer;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolUtf8;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Attribute {
    AttrContainer container;
    private Attribute next;
    String name;
    int name_index;

    public final AttrContainer getContainer() {
        return this.container;
    }

    public final void setContainer(AttrContainer container) {
        this.container = container;
    }

    public final Attribute getNext() {
        return this.next;
    }

    public final void setNext(Attribute next) {
        this.next = next;
    }

    public ConstantPool getConstants() {
        return this.getContainer().getConstants();
    }

    public void addToFrontOf(AttrContainer container) {
        this.setContainer(container);
        this.setNext(container.getAttributes());
        container.setAttributes(this);
    }

    public final boolean isSkipped() {
        return this.name_index < 0;
    }

    public final void setSkipped(boolean skip) {
        this.name_index = skip ? -1 : 0;
    }

    public final void setSkipped() {
        this.name_index = -1;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String name) {
        this.name = name.intern();
    }

    public final int getNameIndex() {
        return this.name_index;
    }

    public final void setNameIndex(int index) {
        this.name_index = index;
    }

    public Attribute(String name) {
        this.name = name;
    }

    public static Attribute get(AttrContainer container, String name) {
        Attribute attr = container.getAttributes();
        while (attr != null) {
            if (attr.getName() == name) {
                return attr;
            }
            attr = attr.next;
        }
        return null;
    }

    public void assignConstants(ClassType cl) {
        if (this.name_index == 0) {
            this.name_index = cl.getConstants().addUtf8(this.name).getIndex();
        }
    }

    public static void assignConstants(AttrContainer container, ClassType cl) {
        Attribute attr = container.getAttributes();
        while (attr != null) {
            if (!attr.isSkipped()) {
                attr.assignConstants(cl);
            }
            attr = attr.next;
        }
    }

    public abstract int getLength();

    public static int getLengthAll(AttrContainer container) {
        int length = 0;
        Attribute attr = container.getAttributes();
        while (attr != null) {
            if (!attr.isSkipped()) {
                length += 6 + attr.getLength();
            }
            attr = attr.next;
        }
        return length;
    }

    public abstract void write(DataOutputStream var1) throws IOException;

    public static int count(AttrContainer container) {
        int count = 0;
        Attribute attr = container.getAttributes();
        while (attr != null) {
            if (!attr.isSkipped()) {
                ++count;
            }
            attr = attr.next;
        }
        return count;
    }

    public static void writeAll(AttrContainer container, DataOutputStream dstr) throws IOException {
        int count = Attribute.count(container);
        dstr.writeShort(count);
        Attribute attr = container.getAttributes();
        while (attr != null) {
            if (!attr.isSkipped()) {
                if (attr.name_index == 0) {
                    throw new Error("Attribute.writeAll called without assignConstants");
                }
                dstr.writeShort(attr.name_index);
                dstr.writeInt(attr.getLength());
                attr.write(dstr);
            }
            attr = attr.next;
        }
    }

    public void print(ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.println(this.getLength());
    }
}

