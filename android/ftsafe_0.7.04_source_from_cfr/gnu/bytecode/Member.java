/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassType;

public interface Member {
    public ClassType getDeclaringClass();

    public String getName();

    public void setName(String var1);

    public int getModifiers();

    public boolean getStaticFlag();
}

