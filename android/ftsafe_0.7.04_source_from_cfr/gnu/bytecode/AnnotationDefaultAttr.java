/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.AnnotationEntry;
import gnu.bytecode.AttrContainer;
import gnu.bytecode.Attribute;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.RuntimeAnnotationsAttr;
import java.io.DataOutputStream;
import java.io.IOException;

public class AnnotationDefaultAttr
extends Attribute {
    int dataLength;
    AnnotationEntry.Value value;

    public AnnotationDefaultAttr(String name, AnnotationEntry.Value value, AttrContainer container) {
        super(name);
        this.value = value;
        this.addToFrontOf(container);
    }

    @Override
    public int getLength() {
        return this.dataLength;
    }

    @Override
    public void print(ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.println(this.getLength());
        dst.print("  Default: ");
        this.value.print(2, dst);
    }

    @Override
    public void assignConstants(ClassType cl) {
        super.assignConstants(cl);
        this.dataLength += RuntimeAnnotationsAttr.assignConstants(this.value, cl.getConstants());
    }

    @Override
    public void write(DataOutputStream dstr) throws IOException {
        RuntimeAnnotationsAttr.write(this.value, this.getConstants(), dstr);
    }
}

