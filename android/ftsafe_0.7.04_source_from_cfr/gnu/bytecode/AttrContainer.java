/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.Attribute;
import gnu.bytecode.ConstantPool;

public interface AttrContainer {
    public Attribute getAttributes();

    public void setAttributes(Attribute var1);

    public ConstantPool getConstants();
}

