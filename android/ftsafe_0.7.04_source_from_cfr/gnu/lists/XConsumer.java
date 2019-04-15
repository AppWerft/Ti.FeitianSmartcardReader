/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Consumer;

public interface XConsumer
extends Consumer {
    public void writeComment(char[] var1, int var2, int var3);

    public void writeProcessingInstruction(String var1, char[] var2, int var3, int var4);

    public void writeCDATA(char[] var1, int var2, int var3);

    public void beginEntity(Object var1);

    public void endEntity();
}

