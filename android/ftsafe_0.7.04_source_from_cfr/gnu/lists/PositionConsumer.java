/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AbstractSequence;
import gnu.lists.SeqPosition;

public interface PositionConsumer {
    public void writePosition(SeqPosition var1);

    public void writePosition(AbstractSequence var1, int var2);
}

