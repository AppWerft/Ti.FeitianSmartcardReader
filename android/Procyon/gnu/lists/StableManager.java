// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class StableManager
{
    SimpleVector base;
    protected int[] positions;
    protected int free;
    protected static final int FREE_POSITION = -2;
    static final int START_POSITION = 0;
    static final int END_POSITION = 1;
    
    protected void chainFreelist() {
        this.free = -1;
        int i = this.positions.length;
        while (--i > 1) {
            final int pos = this.positions[i];
            if (pos == -2) {
                this.positions[i] = this.free;
                this.free = i;
            }
        }
    }
    
    protected void unchainFreelist() {
        int next;
        for (int i = this.free; i >= 0; i = next) {
            next = this.positions[i];
            this.positions[i] = -2;
        }
        this.free = -2;
    }
    
    public int startPos() {
        return 0;
    }
    
    public int endPos() {
        return 1;
    }
    
    public StableManager(final SimpleVector base) {
        (this.base = base).gapReserveGeneric(base.size(), 0);
        (this.positions = new int[16])[0] = 0;
        this.positions[1] = (base.getBufferLength() << 1 | 0x1);
        this.free = -1;
        int i = this.positions.length;
        while (--i > 1) {
            this.positions[i] = this.free;
            this.free = i;
        }
    }
    
    protected int allocPositionIndex() {
        if (this.free == -2) {
            this.chainFreelist();
        }
        if (this.free < 0) {
            final int oldLength = this.positions.length;
            final int[] tmp = new int[2 * oldLength];
            System.arraycopy(this.positions, 0, tmp, 0, oldLength);
            int i = 2 * oldLength;
            while (--i >= oldLength) {
                tmp[i] = this.free;
                this.free = i;
            }
            this.positions = tmp;
        }
        final int pos = this.free;
        this.free = this.positions[this.free];
        return pos;
    }
    
    public int createPos(int index, final boolean isAfter) {
        if (index == 0 && !isAfter) {
            return 0;
        }
        if (isAfter && index == this.base.size()) {
            return 1;
        }
        final int gapStart = this.base.getGapStart();
        final int gapEnd = this.base.getGapEnd();
        if (index > gapStart || (index == gapStart && isAfter)) {
            index += gapEnd - gapStart;
        }
        final int ipos = this.allocPositionIndex();
        this.positions[ipos] = (index << 1 | (isAfter ? 1 : 0));
        return ipos;
    }
    
    protected boolean isAfterPos(final int ipos) {
        return (this.positions[ipos] & 0x1) != 0x0;
    }
    
    public boolean hasNext(final int ipos) {
        final int ppos = this.positions[ipos];
        int index = ppos >>> 1;
        final int gapStart = this.base.getGapStart();
        if (index >= gapStart) {
            index += this.base.getGapEnd() - gapStart;
        }
        return index < this.base.getBufferLength();
    }
    
    public int nextPos(int ipos) {
        final int ppos = this.positions[ipos];
        int index = ppos >>> 1;
        final int gapStart = this.base.getGapStart();
        final int gapEnd = this.base.getGapEnd();
        if (index >= gapStart) {
            index += gapEnd - gapStart;
        }
        if (index >= this.base.getBufferLength()) {
            this.releasePos(ipos);
            return 0;
        }
        if (ipos == 0) {
            ipos = this.createPos(0, true);
        }
        this.positions[ipos] = (ppos | 0x1);
        return ipos;
    }
    
    public int nextIndex(final int ipos) {
        int index = this.positions[ipos] >>> 1;
        final int gapStart = this.base.getGapStart();
        final int gapEnd = this.base.getGapEnd();
        if (index > gapStart) {
            index -= gapEnd - gapStart;
        }
        return index;
    }
    
    public void releasePos(final int ipos) {
        if (ipos >= 2) {
            if (this.free == -2) {
                this.chainFreelist();
            }
            this.positions[ipos] = this.free;
            this.free = ipos;
        }
    }
    
    public int copyPos(int ipos) {
        if (ipos > 1) {
            final int i = this.allocPositionIndex();
            this.positions[i] = this.positions[ipos];
            ipos = i;
        }
        return ipos;
    }
    
    protected void gapReserve(final SimpleVector base, final int where, final int needed) {
        final int oldGapEnd = base.getGapEnd();
        final int oldGapStart = base.getGapStart();
        final int oldLength = base.getBufferLength();
        base.gapReserveGeneric(where, needed);
        if (needed > oldGapEnd - oldGapStart) {
            final int newLength = base.getBufferLength();
            if (where == oldGapStart) {
                this.adjustPositions(oldGapEnd << 1, newLength << 1 | 0x1, newLength - oldLength << 1);
            }
            else {
                this.adjustPositions(oldGapEnd << 1, oldLength << 1 | 0x1, oldGapStart - oldGapEnd << 1);
                final int gapStart = base.getGapStart();
                final int gapEnd = base.getGapEnd();
                this.adjustPositions(gapStart << 1, newLength << 1 | 0x1, gapEnd - gapStart << 1);
            }
        }
        else if (where != oldGapStart) {
            final int delta = where - oldGapStart;
            int low;
            int high;
            int adjust;
            if (delta > 0) {
                low = oldGapEnd;
                high = low + delta;
                adjust = oldGapStart - low << 1;
                low <<= 1;
                high <<= 1;
            }
            else {
                low = (where << 1) + 1;
                high = (oldGapStart << 1) + 1;
                adjust = oldGapEnd - oldGapStart << 1;
            }
            this.adjustPositions(low, high, adjust);
        }
    }
    
    protected void adjustPositions(int low, int high, final int delta) {
        if (this.free >= -1) {
            this.unchainFreelist();
        }
        low ^= Integer.MIN_VALUE;
        high ^= Integer.MIN_VALUE;
        int i = this.positions.length;
        while (--i > 0) {
            final int pos = this.positions[i];
            if (pos != -2) {
                final int index = pos ^ Integer.MIN_VALUE;
                if (index < low || index > high) {
                    continue;
                }
                this.positions[i] = pos + delta;
            }
        }
    }
    
    protected void removePosRange(final int ipos0, final int ipos1) {
        throw new Error();
    }
    
    public void consumePosRange(final int iposStart, final int iposEnd, final Consumer out) {
        throw new Error();
    }
}
