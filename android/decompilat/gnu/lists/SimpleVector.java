// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.util.RandomAccess;
import java.io.Externalizable;

public abstract class SimpleVector<E> extends AbstractSequence<E> implements AVector<E>, Externalizable, RandomAccess
{
    protected long info;
    public static final int MAX_GAP_SIZE = 33554431;
    protected static final long READ_ONLY_FLAG = 4294967296L;
    protected static final long SHARED_FLAG = 8589934592L;
    protected static final long COPY_ON_WRITE = 17179869184L;
    protected static final long SUBRANGE_FLAG = 68719476736L;
    protected static final long GAP_FLAG = 137438953472L;
    protected static final long VERY_SIMPLE_FLAG = Long.MIN_VALUE;
    
    public SimpleVector() {
        this.info = Long.MIN_VALUE;
    }
    
    protected final boolean isVerySimple() {
        return this.info < 0L;
    }
    
    protected final boolean isSubRange() {
        return (this.info & 0x1000000000L) != 0x0L;
    }
    
    protected final boolean isGapBuffer() {
        return (this.info & 0x2000000000L) != 0x0L;
    }
    
    protected final void setInfoField(final int size, final int offset, final long flags) {
        this.info = ((0xFFFFFFFFL & (long)size) | (long)offset << 38 | flags);
    }
    
    protected final int getGapStart() {
        return this.getSizeBits();
    }
    
    protected final int getGapEnd() {
        return this.getSizeBits() + this.getOffsetBits();
    }
    
    protected final void setGapBounds(final int gapStart, final int gapEnd, final long flags) {
        this.setInfoField(gapStart, gapEnd - gapStart, flags | 0x2000000000L);
    }
    
    protected final void setGapBounds(final int gapStart, final int gapEnd) {
        this.setInfoField(gapStart, gapEnd - gapStart, (this.info & 0x3F00000000L) | 0x2000000000L);
    }
    
    protected final int getSizeBits() {
        return (int)this.info;
    }
    
    protected final int getOffsetBits() {
        return (int)(this.info >> 38);
    }
    
    public boolean isReadOnly() {
        return (this.info & 0x100000000L) != 0x0L;
    }
    
    public void setReadOnly() {
        this.info |= 0x100000000L;
    }
    
    @Override
    public int size() {
        final int len = this.getBufferLength();
        if (this.isVerySimple()) {
            return len;
        }
        if ((this.info & 0x1000000000L) != 0x0L) {
            return this.getSizeBits();
        }
        return len - this.getOffsetBits();
    }
    
    @Override
    public int effectiveIndex(int index) {
        if (this.isVerySimple()) {
            return index;
        }
        if ((this.info & 0x1000000000L) == 0x0L) {
            if (index >= this.getSizeBits()) {
                index += this.getOffsetBits();
            }
            return index;
        }
        if (index >= this.getSizeBits()) {
            throw new IndexOutOfBoundsException();
        }
        return index + this.getOffsetBits();
    }
    
    protected void gapReserve(final int where, final int needed) {
        this.gapReserveGeneric(where, needed);
    }
    
    protected final void gapReserveGeneric(final int where, final int needed) {
        if ((this.info & 0x300000000L) != 0x0L) {
            final String msg = ((this.info & 0x100000000L) != 0x0L) ? "can't adjust size of constant vector" : "can't adjust size of indirect vector";
            throw new UnsupportedOperationException(msg + " info:" + Long.toHexString(this.info));
        }
        final int sz = this.size();
        final int blen = this.getBufferLength();
        if ((this.info & 0x400000000L) != 0x0L) {
            this.doCopyOnWrite(this.size());
        }
        if (this.isVerySimple()) {
            this.setGapBounds(sz, sz);
        }
        else if ((this.info & 0x1000000000L) != 0x0L) {}
        final int gapStart = this.getSizeBits();
        final int gapSize = this.getOffsetBits();
        final int gapEnd = gapStart + gapSize;
        if (needed > gapEnd - gapStart) {
            final int oldLength = this.getBufferLength();
            int newLength = (oldLength < 16) ? 16 : (2 * oldLength);
            final int size = oldLength - (gapEnd - gapStart);
            final int minLength = size + needed;
            if (newLength < minLength) {
                newLength = minLength;
            }
            final int newGapEnd = newLength - size + where;
            this.resizeShift(gapStart, gapEnd, where, newGapEnd);
            this.setGapBounds(where, newGapEnd);
        }
        else if (where != gapStart) {
            final int delta = where - gapStart;
            if (delta > 0) {
                this.shift(gapEnd, gapStart, delta);
            }
            else {
                if (delta >= 0) {
                    return;
                }
                this.shift(where, gapEnd + delta, -delta);
            }
            this.setGapBounds(where, gapEnd + delta);
        }
    }
    
    void resizeShift(final int oldGapStart, final int oldGapEnd, final int newGapStart, final int newGapEnd) {
        final int oldGapSize = oldGapEnd - oldGapStart;
        final int newGapSize = newGapEnd - newGapStart;
        final int oldLength = this.getBufferLength();
        final int newLength = oldLength - oldGapSize + newGapSize;
        if (newLength > oldLength) {
            this.copyBuffer(newLength);
        }
        final int gapDelta = oldGapStart - newGapStart;
        if (gapDelta >= 0) {
            final int endLength = oldLength - oldGapEnd;
            this.shift(oldGapEnd, newLength - endLength, endLength);
            if (gapDelta > 0) {
                this.shift(newGapStart, newGapEnd, gapDelta);
            }
        }
        else {
            final int endLength = newLength - newGapEnd;
            this.shift(oldLength - endLength, newGapEnd, endLength);
            this.shift(oldGapEnd, oldGapStart, newGapStart - oldGapStart);
        }
        this.clearBuffer(newGapStart, newGapSize);
    }
    
    @Override
    protected abstract void setBuffer(final Object p0);
    
    public abstract int getBufferLength();
    
    public abstract void copyBuffer(final int p0);
    
    protected abstract SimpleVector newInstance(final int p0);
    
    @Override
    public SimpleVector<E> asImmutable() {
        if ((this.info & 0x100000000L) != 0x0L) {
            return this;
        }
        if (this.isVerySimple()) {
            final SimpleVector<E> tmp = this.newInstance(-1);
            this.info |= 0x400000000L;
            final SimpleVector<E> simpleVector = tmp;
            simpleVector.info |= 0x100000000L;
            return tmp;
        }
        return Arrays.flattenCopy((Array<E>)this, false);
    }
    
    @Override
    protected void checkCanWrite() {
        final long fl = this.info;
        if ((fl & 0x400000000L) != 0x0L) {
            this.doCopyOnWrite(this.size());
        }
        if ((fl & 0x100000000L) != 0x0L) {
            throw new UnsupportedOperationException("write not allowed to read-only " + ((this.rank() == 1) ? "sequence" : "array"));
        }
    }
    
    protected void doCopyOnWrite(final int sz) {
        long fl = this.info;
        final Object old = this.getBuffer();
        this.copyBuffer(sz);
        if ((fl & 0x1000000000L) != 0x0L) {
            System.arraycopy(old, this.getOffsetBits(), this.getBuffer(), 0, sz);
            this.info = -1L;
        }
        fl &= 0xFFFFFFFBFFFFFFFFL;
        this.info = fl;
    }
    
    public long getSegment(final int index) {
        final int sz = this.size();
        int where;
        int size;
        if (this.isVerySimple()) {
            where = index;
            size = sz - index;
        }
        else if ((this.info & 0x1000000000L) != 0x0L) {
            final int istart = this.getOffsetBits();
            where = istart + index;
            size = sz - index;
        }
        else {
            final int gapStart = this.getGapStart();
            final int gEnd = this.getGapEnd();
            if (index < gapStart) {
                where = index;
                size = gapStart - index;
            }
            else {
                where = index + this.getGapEnd() - gapStart;
                size = this.getBufferLength() - where;
            }
        }
        return (long)size << 32 | (long)where;
    }
    
    public int getSegment(int index, int len) {
        if (!this.isGapBuffer()) {
            return this.getSegmentReadOnly(index, len);
        }
        final int sz = this.size();
        if (index < 0 || index > sz) {
            return -1;
        }
        if (index < 0) {
            index = 0;
        }
        else if (index + len > sz) {
            len = sz - index;
        }
        final int gapStart = this.getGapStart();
        if (index + len <= gapStart) {
            return index;
        }
        if (index >= gapStart) {
            return index + (this.getGapEnd() - gapStart);
        }
        if ((this.info & 0x100000000L) != 0x0L) {
            return -1;
        }
        if (gapStart - index > len >> 1) {
            this.gapReserve(index + len, 0);
            return index;
        }
        this.gapReserve(index, 0);
        return index + (this.getGapEnd() - gapStart);
    }
    
    public int getSegmentReadOnly(final int start, final int len) {
        final int sz = this.size();
        if (start < 0 || len < 0 || start + len > sz) {
            return -1;
        }
        final long result = this.getSegment(start);
        final int where = (int)result;
        final int size = (int)(result >> 32);
        return (size >= len) ? where : -1;
    }
    
    @Override
    protected boolean isAfterPos(final int ipos) {
        return (ipos & 0x1) != 0x0;
    }
    
    protected abstract Object getBuffer();
    
    @Override
    public E getRowMajor(final int i) {
        return this.get(i);
    }
    
    @Override
    public void fill(final E value) {
        this.checkCanWrite();
        int i = this.size();
        while (--i >= 0) {
            this.setRaw(this.effectiveIndex(i), value);
        }
    }
    
    public void shift(final int srcStart, final int dstStart, final int count) {
        this.checkCanWrite();
        final Object data = this.getBuffer();
        System.arraycopy(data, srcStart, data, dstStart, count);
    }
    
    @Override
    public boolean add(final E o) {
        this.add(this.size(), o);
        return true;
    }
    
    @Override
    public void add(final int index, final E o) {
        this.addSpace(index, 1);
        this.setRaw(index, o);
    }
    
    @Override
    protected int addPos(final int ipos, final E value) {
        final int index = this.nextIndex(ipos);
        this.add(index, value);
        final int ret = this.createPos(index + 1, true);
        this.releasePos(ipos);
        return ret;
    }
    
    protected void addSpace(final int index, final int count) {
        this.gapReserve(index, count);
        this.setGapBounds(this.getGapStart() + count, this.getGapEnd());
    }
    
    public void delete(final int start, final int end) {
        this.gapReserve(start, 0);
        final int gapStart = this.getSizeBits();
        final int gapSize = this.getOffsetBits();
        final int gapEnd = gapStart + gapSize;
        final int count = end - start;
        this.setGapBounds(start, gapEnd + count);
        this.clearBuffer(start, count);
    }
    
    protected abstract void clearBuffer(final int p0, final int p1);
    
    public Object toDataArray() {
        final Object buffer = this.getBuffer();
        final Class componentType = buffer.getClass().getComponentType();
        int count = this.size();
        int index = 0;
        final Object copy = java.lang.reflect.Array.newInstance(componentType, count);
        while (count > 0) {
            final long result = this.getSegment(index);
            final int where = (int)result;
            int size = (int)(result >> 32);
            if (size > count) {
                size = count;
            }
            System.arraycopy(buffer, where, copy, index, size);
            index += size;
            count -= size;
        }
        return copy;
    }
    
    public String getTag() {
        return null;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.getBuffer());
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.setBuffer(in.readObject());
    }
}
