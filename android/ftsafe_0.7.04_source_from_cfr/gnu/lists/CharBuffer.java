/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.lists.SimpleVector;
import gnu.lists.StableManager;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;

public class CharBuffer
extends FString {
    StableManager manager;

    public CharBuffer(FString str) {
        super(str);
        this.manager = new StableManager(this);
    }

    public CharBuffer(int initialSize) {
        super(initialSize);
        this.setGapBounds(0, initialSize);
        this.manager = new StableManager(this);
    }

    protected CharBuffer() {
        this.manager = new StableManager(this);
    }

    @Override
    public int length() {
        return this.size();
    }

    public char[] getArray() {
        return this.getBuffer();
    }

    @Override
    public void consume(int start, int count, Consumer dest) {
        throw new Error();
    }

    @Override
    public int startPos() {
        return this.manager.startPos();
    }

    @Override
    public int endPos() {
        return this.manager.endPos();
    }

    @Override
    public boolean isAfterPos(int ipos) {
        return this.manager.isAfterPos(ipos);
    }

    @Override
    public boolean hasNext(int ipos) {
        return this.manager.hasNext(ipos);
    }

    @Override
    public int nextPos(int ipos) {
        return this.manager.nextPos(ipos);
    }

    @Override
    public int copyPos(int ipos) {
        return this.manager.copyPos(ipos);
    }

    @Override
    public int nextIndex(int ipos) {
        return this.manager.nextIndex(ipos);
    }

    @Override
    public void releasePos(int ipos) {
        this.manager.releasePos(ipos);
    }

    @Override
    public int createPos(int index, boolean isAfter) {
        return this.manager.createPos(index, isAfter);
    }

    @Override
    public void insert(int where, int ch, boolean beforeMarkers) {
        super.insert(where, ch, beforeMarkers);
        if (beforeMarkers) {
            int len = ch >= 65536 ? 2 : 1;
            int oldPos = this.getGapStart() - len << 1;
            this.manager.adjustPositions(oldPos, oldPos + 1, len << 1);
        }
    }

    @Override
    public void insert(int where, String str, boolean beforeMarkers) {
        super.insert(where, str, beforeMarkers);
        if (beforeMarkers) {
            int len = str.length();
            int oldPos = this.getGapStart() - len << 1;
            this.manager.adjustPositions(oldPos, oldPos + 1, len << 1);
        }
    }

    @Override
    protected void gapReserve(int where, int needed) {
        this.manager.gapReserve(this, where, needed);
    }

    @Override
    public String toString() {
        int len = this.size();
        int start = this.getSegment(0, len);
        return new String(this.getArray(), start, len);
    }

    @Override
    public void writeTo(int start, int count, Appendable dest) throws IOException {
        if (dest instanceof Writer) {
            this.writeTo(start, count, (Writer)dest);
        } else {
            dest.append(this, start, start + count);
        }
    }

    @Override
    public void writeTo(Appendable dest) throws IOException {
        this.writeTo(0, this.size(), dest);
    }

    public void dump() {
        int i;
        System.err.println("Buffer Content dump.  size:" + this.size() + "  buffer:" + this.getArray().length);
        int gapStart = this.getGapStart();
        int gapEnd = this.getGapEnd();
        int[] positions = this.manager.positions;
        int free = this.manager.free;
        System.err.print("before gap: \"");
        System.err.print(new String(this.getArray(), 0, gapStart));
        System.err.println("\" (gapStart:" + gapStart + " gapEnd:" + gapEnd + ')');
        System.err.print("after gap: \"");
        System.err.print(new String(this.getArray(), gapEnd, this.getArray().length - gapEnd));
        System.err.println("\"");
        int poslen = positions == null ? 0 : positions.length;
        System.err.println("Positions (size: " + poslen + " free:" + free + "):");
        boolean[] isFree = null;
        if (free != -2) {
            isFree = new boolean[positions.length];
            i = free;
            while (i >= 0) {
                isFree[i] = true;
                i = positions[i];
            }
        }
        for (i = 0; i < poslen; ++i) {
            int pos = positions[i];
            if (!(free == -2 ? pos != -2 : !isFree[i])) continue;
            int p = pos >> 1;
            if (p > gapStart) {
                p -= gapEnd - gapStart;
            }
            System.err.println("position#" + i + ": [raw:" + pos + "]=" + p + " isAfter:" + (pos & 1));
        }
    }
}

