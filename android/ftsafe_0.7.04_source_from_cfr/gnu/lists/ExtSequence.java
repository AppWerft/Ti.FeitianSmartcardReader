/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AbstractSequence;
import gnu.lists.PositionManager;
import gnu.lists.SeqPosition;

public abstract class ExtSequence<E>
extends AbstractSequence<E> {
    @Override
    public int copyPos(int ipos) {
        if (ipos <= 0) {
            return ipos;
        }
        return PositionManager.manager.register(PositionManager.getPositionObject(ipos).copy());
    }

    @Override
    protected void releasePos(int ipos) {
        if (ipos > 0) {
            PositionManager.manager.release(ipos);
        }
    }

    @Override
    protected boolean isAfterPos(int ipos) {
        if (ipos <= 0) {
            return ipos < 0;
        }
        return (PositionManager.getPositionObject((int)ipos).ipos & 1) != 0;
    }

    @Override
    protected int nextIndex(int ipos) {
        return ipos == -1 ? this.size() : (ipos == 0 ? 0 : PositionManager.getPositionObject(ipos).nextIndex());
    }
}

