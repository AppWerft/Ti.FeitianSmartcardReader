/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AbstractSequence;
import gnu.lists.PositionManager;
import gnu.lists.SeqPosition;

public class ExtPosition<E, ESEQ extends AbstractSequence<E>>
extends SeqPosition<E, ESEQ> {
    int position = -1;

    @Override
    public int getPos() {
        if (this.position < 0) {
            this.position = PositionManager.manager.register(this);
        }
        return this.position;
    }

    @Override
    public void setPos(AbstractSequence seq, int ipos) {
        throw seq.unsupported("setPos");
    }

    @Override
    public final boolean isAfter() {
        return (this.ipos & 1) != 0;
    }

    @Override
    public void release() {
        if (this.position >= 0) {
            PositionManager.manager.release(this.position);
        }
        this.sequence = null;
    }
}

