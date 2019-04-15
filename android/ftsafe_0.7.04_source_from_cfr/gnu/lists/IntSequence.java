/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AVector;

public interface IntSequence
extends AVector<Integer> {
    @Override
    public int getInt(int var1);

    @Override
    public int size();
}

