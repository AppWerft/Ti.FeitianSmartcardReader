/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Consumer;
import gnu.lists.SimpleVector;

public class StableManager {
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
            int pos = this.positions[i];
            if (pos != -2) continue;
            this.positions[i] = this.free;
            this.free = i;
        }
    }

    protected void unchainFreelist() {
        int i = this.free;
        while (i >= 0) {
            int next = this.positions[i];
            this.positions[i] = -2;
            i = next;
        }
        this.free = -2;
    }

    public int startPos() {
        return 0;
    }

    public int endPos() {
        return 1;
    }

    public StableManager(SimpleVector base2) {
        this.base = base2;
        base2.gapReserveGeneric(base2.size(), 0);
        this.positions = new int[16];
        this.positions[0] = 0;
        this.positions[1] = base2.getBufferLength() << 1 | 1;
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
            int oldLength = this.positions.length;
            int[] tmp = new int[2 * oldLength];
            System.arraycopy(this.positions, 0, tmp, 0, oldLength);
            int i = 2 * oldLength;
            while (--i >= oldLength) {
                tmp[i] = this.free;
                this.free = i;
            }
            this.positions = tmp;
        }
        int pos = this.free;
        this.free = this.positions[this.free];
        return pos;
    }

    public int createPos(int index, boolean isAfter) {
        if (index == 0 && !isAfter) {
            return 0;
        }
        if (isAfter && index == this.base.size()) {
            return 1;
        }
        int gapStart = this.base.getGapStart();
        int gapEnd = this.base.getGapEnd();
        if (index > gapStart || index == gapStart && isAfter) {
            index += gapEnd - gapStart;
        }
        int ipos = this.allocPositionIndex();
        this.positions[ipos] = index << 1 | (isAfter ? 1 : 0);
        return ipos;
    }

    protected boolean isAfterPos(int ipos) {
        return (this.positions[ipos] & 1) != 0;
    }

    public boolean hasNext(int ipos) {
        int ppos = this.positions[ipos];
        int index = ppos >>> 1;
        int gapStart = this.base.getGapStart();
        if (index >= gapStart) {
            index += this.base.getGapEnd() - gapStart;
        }
        return index < this.base.getBufferLength();
    }

    public int nextPos(int ipos) {
        int ppos = this.positions[ipos];
        int index = ppos >>> 1;
        int gapStart = this.base.getGapStart();
        int gapEnd = this.base.getGapEnd();
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
        this.positions[ipos] = ppos | 1;
        return ipos;
    }

    public int nextIndex(int ipos) {
        int index = this.positions[ipos] >>> 1;
        int gapStart = this.base.getGapStart();
        int gapEnd = this.base.getGapEnd();
        if (index > gapStart) {
            index -= gapEnd - gapStart;
        }
        return index;
    }

    public void releasePos(int ipos) {
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
            int i = this.allocPositionIndex();
            this.positions[i] = this.positions[ipos];
            ipos = i;
        }
        return ipos;
    }

    protected void gapReserve(SimpleVector base2, int where, int needed) {
        int oldGapEnd = base2.getGapEnd();
        int oldGapStart = base2.getGapStart();
        int oldLength = base2.getBufferLength();
        base2.gapReserveGeneric(where, needed);
        if (needed > oldGapEnd - oldGapStart) {
            int newLength = base2.getBufferLength();
            if (where == oldGapStart) {
                this.adjustPositions(oldGapEnd << 1, newLength << 1 | 1, newLength - oldLength << 1);
            } else {
                this.adjustPositions(oldGapEnd << 1, oldLength << 1 | 1, oldGapStart - oldGapEnd << 1);
                int gapStart = base2.getGapStart();
                int gapEnd = base2.getGapEnd();
                this.adjustPositions(gapStart << 1, newLength << 1 | 1, gapEnd - gapStart << 1);
            }
        } else if (where != oldGapStart) {
            int adjust;
            int low;
            int high;
            int delta = where - oldGapStart;
            if (delta > 0) {
                low = oldGapEnd;
                high = low + delta;
                adjust = oldGapStart - low << 1;
                low <<= 1;
                high <<= 1;
            } else {
                low = (where << 1) + 1;
                high = (oldGapStart << 1) + 1;
                adjust = oldGapEnd - oldGapStart << 1;
            }
            this.adjustPositions(low, high, adjust);
        }
    }

    protected void adjustPositions(int low, int high, int delta) {
        if (this.free >= -1) {
            this.unchainFreelist();
        }
        low ^= Integer.MIN_VALUE;
        high ^= Integer.MIN_VALUE;
        int i = this.positions.length;
        while (--i > 0) {
            int index;
            int pos = this.positions[i];
            if (pos == -2 || (index = pos ^ Integer.MIN_VALUE) < low || index > high) continue;
            this.positions[i] = pos + delta;
        }
    }

    protected void removePosRange(int ipos0, int ipos1) {
        throw new Error();
    }

    public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
        throw new Error();
    }
}

