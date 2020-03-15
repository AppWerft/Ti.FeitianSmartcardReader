// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.IOException;
import java.io.Writer;

public class CharBuffer extends FString
{
    StableManager manager;
    
    public CharBuffer(final FString str) {
        super((CharSequence)str);
        this.manager = new StableManager(this);
    }
    
    public CharBuffer(final int initialSize) {
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
    public void consume(final int start, final int count, final Consumer dest) {
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
    
    public boolean isAfterPos(final int ipos) {
        return this.manager.isAfterPos(ipos);
    }
    
    @Override
    public boolean hasNext(final int ipos) {
        return this.manager.hasNext(ipos);
    }
    
    @Override
    public int nextPos(final int ipos) {
        return this.manager.nextPos(ipos);
    }
    
    @Override
    public int copyPos(final int ipos) {
        return this.manager.copyPos(ipos);
    }
    
    public int nextIndex(final int ipos) {
        return this.manager.nextIndex(ipos);
    }
    
    public void releasePos(final int ipos) {
        this.manager.releasePos(ipos);
    }
    
    @Override
    public int createPos(final int index, final boolean isAfter) {
        return this.manager.createPos(index, isAfter);
    }
    
    @Override
    public void insert(final int where, final int ch, final boolean beforeMarkers) {
        super.insert(where, ch, beforeMarkers);
        if (beforeMarkers) {
            final int len = (ch >= 65536) ? 2 : 1;
            final int oldPos = this.getGapStart() - len << 1;
            this.manager.adjustPositions(oldPos, oldPos + 1, len << 1);
        }
    }
    
    @Override
    public void insert(final int where, final String str, final boolean beforeMarkers) {
        super.insert(where, str, beforeMarkers);
        if (beforeMarkers) {
            final int len = str.length();
            final int oldPos = this.getGapStart() - len << 1;
            this.manager.adjustPositions(oldPos, oldPos + 1, len << 1);
        }
    }
    
    @Override
    protected void gapReserve(final int where, final int needed) {
        this.manager.gapReserve(this, where, needed);
    }
    
    @Override
    public String toString() {
        final int len = this.size();
        final int start = this.getSegment(0, len);
        return new String(this.getArray(), start, len);
    }
    
    @Override
    public void writeTo(final int start, final int count, final Appendable dest) throws IOException {
        if (dest instanceof Writer) {
            this.writeTo(start, count, dest);
        }
        else {
            dest.append(this, start, start + count);
        }
    }
    
    @Override
    public void writeTo(final Appendable dest) throws IOException {
        this.writeTo(0, this.size(), dest);
    }
    
    public void dump() {
        System.err.println("Buffer Content dump.  size:" + this.size() + "  buffer:" + this.getArray().length);
        final int gapStart = this.getGapStart();
        final int gapEnd = this.getGapEnd();
        final int[] positions = this.manager.positions;
        final int free = this.manager.free;
        System.err.print("before gap: \"");
        System.err.print(new String(this.getArray(), 0, gapStart));
        System.err.println("\" (gapStart:" + gapStart + " gapEnd:" + gapEnd + ')');
        System.err.print("after gap: \"");
        System.err.print(new String(this.getArray(), gapEnd, this.getArray().length - gapEnd));
        System.err.println("\"");
        final int poslen = (positions == null) ? 0 : positions.length;
        System.err.println("Positions (size: " + poslen + " free:" + free + "):");
        boolean[] isFree = null;
        if (free != -2) {
            isFree = new boolean[positions.length];
            for (int i = free; i >= 0; i = positions[i]) {
                isFree[i] = true;
            }
        }
        for (int i = 0; i < poslen; ++i) {
            final int pos = positions[i];
            if (free == -2) {
                if (pos == -2) {
                    continue;
                }
            }
            else if (isFree[i]) {
                continue;
            }
            int p = pos >> 1;
            if (p > gapStart) {
                p -= gapEnd - gapStart;
            }
            System.err.println("position#" + i + ": [raw:" + pos + "]=" + p + " isAfter:" + (pos & 0x1));
        }
    }
}
