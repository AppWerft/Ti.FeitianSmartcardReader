// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class PositionManager
{
    static final PositionManager manager;
    SeqPosition[] positions;
    int[] ivals;
    int freeListHead;
    
    public static SeqPosition getPositionObject(final int ipos) {
        final PositionManager m = PositionManager.manager;
        synchronized (m) {
            return m.positions[ipos];
        }
    }
    
    private void addToFreeList(final int[] ivals, final int first, final int end) {
        int head = this.freeListHead;
        for (int i = first; i < end; ++i) {
            ivals[i] = head;
            head = i;
        }
        this.freeListHead = head;
    }
    
    private int getFreeSlot() {
        int head = this.freeListHead;
        if (head < 0) {
            final int old_size = this.positions.length;
            final SeqPosition[] npositions = new SeqPosition[2 * old_size];
            final int[] nvals = new int[2 * old_size];
            System.arraycopy(this.positions, 0, npositions, 0, old_size);
            System.arraycopy(this.ivals, 0, nvals, 0, old_size);
            this.positions = npositions;
            this.addToFreeList(this.ivals = nvals, old_size, 2 * old_size);
            head = this.freeListHead;
        }
        this.freeListHead = this.ivals[head];
        return head;
    }
    
    public PositionManager() {
        this.positions = new SeqPosition[50];
        this.ivals = new int[50];
        this.freeListHead = -1;
        this.addToFreeList(this.ivals, 1, this.ivals.length);
    }
    
    public synchronized int register(final SeqPosition pos) {
        final int i = this.getFreeSlot();
        this.positions[i] = pos;
        this.ivals[i] = -1;
        return i;
    }
    
    public synchronized void release(final int ipos) {
        final SeqPosition pos = this.positions[ipos];
        if (pos instanceof ExtPosition) {
            ((ExtPosition)pos).position = -1;
        }
        this.positions[ipos] = null;
        this.ivals[ipos] = this.freeListHead;
        this.freeListHead = ipos;
        pos.release();
    }
    
    static {
        manager = new PositionManager();
    }
}
