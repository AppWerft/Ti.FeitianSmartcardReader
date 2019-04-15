/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.ExtPosition;
import gnu.lists.SeqPosition;

public class PositionManager {
    static final PositionManager manager = new PositionManager();
    SeqPosition[] positions = new SeqPosition[50];
    int[] ivals = new int[50];
    int freeListHead = -1;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static SeqPosition getPositionObject(int ipos) {
        PositionManager m;
        PositionManager positionManager = m = manager;
        synchronized (positionManager) {
            return m.positions[ipos];
        }
    }

    private void addToFreeList(int[] ivals, int first, int end) {
        int head = this.freeListHead;
        int i = first;
        while (i < end) {
            ivals[i] = head;
            head = i++;
        }
        this.freeListHead = head;
    }

    private int getFreeSlot() {
        int head = this.freeListHead;
        if (head < 0) {
            int old_size = this.positions.length;
            SeqPosition[] npositions = new SeqPosition[2 * old_size];
            int[] nvals = new int[2 * old_size];
            System.arraycopy(this.positions, 0, npositions, 0, old_size);
            System.arraycopy(this.ivals, 0, nvals, 0, old_size);
            this.positions = npositions;
            this.ivals = nvals;
            this.addToFreeList(nvals, old_size, 2 * old_size);
            head = this.freeListHead;
        }
        this.freeListHead = this.ivals[head];
        return head;
    }

    public PositionManager() {
        this.addToFreeList(this.ivals, 1, this.ivals.length);
    }

    public synchronized int register(SeqPosition pos) {
        int i = this.getFreeSlot();
        this.positions[i] = pos;
        this.ivals[i] = -1;
        return i;
    }

    public synchronized void release(int ipos) {
        SeqPosition pos = this.positions[ipos];
        if (pos instanceof ExtPosition) {
            ((ExtPosition)pos).position = -1;
        }
        this.positions[ipos] = null;
        this.ivals[ipos] = this.freeListHead;
        this.freeListHead = ipos;
        pos.release();
    }
}

