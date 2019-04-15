/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AVector;
import gnu.lists.AbstractSequence;
import gnu.lists.Array;
import gnu.lists.Arrays;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.RandomAccess;

public abstract class SimpleVector<E>
extends AbstractSequence<E>
implements AVector<E>,
Externalizable,
RandomAccess {
    protected long info = Long.MIN_VALUE;
    public static final int MAX_GAP_SIZE = 33554431;
    protected static final long READ_ONLY_FLAG = 0x100000000L;
    protected static final long SHARED_FLAG = 0x200000000L;
    protected static final long COPY_ON_WRITE = 0x400000000L;
    protected static final long SUBRANGE_FLAG = 0x1000000000L;
    protected static final long GAP_FLAG = 0x2000000000L;
    protected static final long VERY_SIMPLE_FLAG = Long.MIN_VALUE;

    protected final boolean isVerySimple() {
        return this.info < 0L;
    }

    protected final boolean isSubRange() {
        return (this.info & 0x1000000000L) != 0L;
    }

    protected final boolean isGapBuffer() {
        return (this.info & 0x2000000000L) != 0L;
    }

    protected final void setInfoField(int size, int offset, long flags) {
        this.info = 0xFFFFFFFFL & (long)size | (long)offset << 38 | flags;
    }

    protected final int getGapStart() {
        return this.getSizeBits();
    }

    protected final int getGapEnd() {
        return this.getSizeBits() + this.getOffsetBits();
    }

    protected final void setGapBounds(int gapStart, int gapEnd, long flags) {
        this.setInfoField(gapStart, gapEnd - gapStart, flags | 0x2000000000L);
    }

    protected final void setGapBounds(int gapStart, int gapEnd) {
        this.setInfoField(gapStart, gapEnd - gapStart, this.info & 270582939648L | 0x2000000000L);
    }

    protected final int getSizeBits() {
        return (int)this.info;
    }

    protected final int getOffsetBits() {
        return (int)(this.info >> 38);
    }

    public boolean isReadOnly() {
        return (this.info & 0x100000000L) != 0L;
    }

    public void setReadOnly() {
        this.info |= 0x100000000L;
    }

    @Override
    public int size() {
        int len = this.getBufferLength();
        if (this.isVerySimple()) {
            return len;
        }
        if ((this.info & 0x1000000000L) != 0L) {
            return this.getSizeBits();
        }
        return len - this.getOffsetBits();
    }

    @Override
    public int effectiveIndex(int index) {
        if (this.isVerySimple()) {
            return index;
        }
        if ((this.info & 0x1000000000L) != 0L) {
            if (index >= this.getSizeBits()) {
                throw new IndexOutOfBoundsException();
            }
            return index + this.getOffsetBits();
        }
        if (index >= this.getSizeBits()) {
            index += this.getOffsetBits();
        }
        return index;
    }

    protected void gapReserve(int where, int needed) {
        this.gapReserveGeneric(where, needed);
    }

    protected final void gapReserveGeneric(int where, int needed) {
        if ((this.info & 0x300000000L) != 0L) {
            String msg = (this.info & 0x100000000L) != 0L ? "can't adjust size of constant vector" : "can't adjust size of indirect vector";
            throw new UnsupportedOperationException(msg + " info:" + Long.toHexString(this.info));
        }
        int sz = this.size();
        int blen = this.getBufferLength();
        if ((this.info & 0x400000000L) != 0L) {
            this.doCopyOnWrite(this.size());
        }
        if (this.isVerySimple()) {
            this.setGapBounds(sz, sz);
        } else if ((this.info & 0x1000000000L) != 0L) {
            // empty if block
        }
        int gapStart = this.getSizeBits();
        int gapSize = this.getOffsetBits();
        int gapEnd = gapStart + gapSize;
        if (needed > gapEnd - gapStart) {
            int minLength;
            int size;
            int oldLength = this.getBufferLength();
            int newLength = oldLength < 16 ? 16 : 2 * oldLength;
            if (newLength < (minLength = (size = oldLength - (gapEnd - gapStart)) + needed)) {
                newLength = minLength;
            }
            int newGapEnd = newLength - size + where;
            this.resizeShift(gapStart, gapEnd, where, newGapEnd);
            this.setGapBounds(where, newGapEnd);
        } else if (where != gapStart) {
            int delta = where - gapStart;
            if (delta > 0) {
                this.shift(gapEnd, gapStart, delta);
            } else if (delta < 0) {
                this.shift(where, gapEnd + delta, -delta);
            } else {
                return;
            }
            this.setGapBounds(where, gapEnd + delta);
        }
    }

    void resizeShift(int oldGapStart, int oldGapEnd, int newGapStart, int newGapEnd) {
        int gapDelta;
        int oldGapSize = oldGapEnd - oldGapStart;
        int newGapSize = newGapEnd - newGapStart;
        int oldLength = this.getBufferLength();
        int newLength = oldLength - oldGapSize + newGapSize;
        if (newLength > oldLength) {
            this.copyBuffer(newLength);
        }
        if ((gapDelta = oldGapStart - newGapStart) >= 0) {
            int endLength = oldLength - oldGapEnd;
            this.shift(oldGapEnd, newLength - endLength, endLength);
            if (gapDelta > 0) {
                this.shift(newGapStart, newGapEnd, gapDelta);
            }
        } else {
            int endLength = newLength - newGapEnd;
            this.shift(oldLength - endLength, newGapEnd, endLength);
            this.shift(oldGapEnd, oldGapStart, newGapStart - oldGapStart);
        }
        this.clearBuffer(newGapStart, newGapSize);
    }

    @Override
    protected abstract void setBuffer(Object var1);

    public abstract int getBufferLength();

    public abstract void copyBuffer(int var1);

    protected abstract SimpleVector newInstance(int var1);

    @Override
    public SimpleVector<E> asImmutable() {
        if ((this.info & 0x100000000L) != 0L) {
            return this;
        }
        if (this.isVerySimple()) {
            SimpleVector tmp = this.newInstance(-1);
            this.info |= 0x400000000L;
            tmp.info |= 0x100000000L;
            return tmp;
        }
        return Arrays.flattenCopy(this, false);
    }

    @Override
    protected void checkCanWrite() {
        long fl = this.info;
        if ((fl & 0x400000000L) != 0L) {
            this.doCopyOnWrite(this.size());
        }
        if ((fl & 0x100000000L) != 0L) {
            throw new UnsupportedOperationException("write not allowed to read-only " + (this.rank() == 1 ? "sequence" : "array"));
        }
    }

    protected void doCopyOnWrite(int sz) {
        long fl = this.info;
        Object old = this.getBuffer();
        this.copyBuffer(sz);
        if ((fl & 0x1000000000L) != 0L) {
            System.arraycopy(old, this.getOffsetBits(), this.getBuffer(), 0, sz);
            this.info = -1L;
        }
        this.info = fl &= -17179869185L;
    }

    public long getSegment(int index) {
        int size;
        int where;
        int sz = this.size();
        if (this.isVerySimple()) {
            where = index;
            size = sz - index;
        } else if ((this.info & 0x1000000000L) != 0L) {
            int istart = this.getOffsetBits();
            where = istart + index;
            size = sz - index;
        } else {
            int gapStart = this.getGapStart();
            int gEnd = this.getGapEnd();
            if (index < gapStart) {
                where = index;
                size = gapStart - index;
            } else {
                where = index + this.getGapEnd() - gapStart;
                size = this.getBufferLength() - where;
            }
        }
        return (long)size << 32 | (long)where;
    }

    public int getSegment(int index, int len) {
        if (this.isGapBuffer()) {
            int sz = this.size();
            if (index < 0 || index > sz) {
                return -1;
            }
            if (index < 0) {
                index = 0;
            } else if (index + len > sz) {
                len = sz - index;
            }
            int gapStart = this.getGapStart();
            if (index + len <= gapStart) {
                return index;
            }
            if (index >= gapStart) {
                return index + (this.getGapEnd() - gapStart);
            }
            if ((this.info & 0x100000000L) != 0L) {
                return -1;
            }
            if (gapStart - index > len >> 1) {
                this.gapReserve(index + len, 0);
                return index;
            }
            this.gapReserve(index, 0);
            return index + (this.getGapEnd() - gapStart);
        }
        return this.getSegmentReadOnly(index, len);
    }

    public int getSegmentReadOnly(int start, int len) {
        int sz = this.size();
        if (start < 0 || len < 0 || start + len > sz) {
            return -1;
        }
        long result = this.getSegment(start);
        int where = (int)result;
        int size = (int)(result >> 32);
        return size >= len ? where : -1;
    }

    @Override
    protected boolean isAfterPos(int ipos) {
        return (ipos & 1) != 0;
    }

    protected abstract Object getBuffer();

    @Override
    public E getRowMajor(int i) {
        return this.get(i);
    }

    @Override
    public void fill(E value) {
        this.checkCanWrite();
        int i = this.size();
        while (--i >= 0) {
            this.setRaw(this.effectiveIndex(i), value);
        }
    }

    public void shift(int srcStart, int dstStart, int count) {
        this.checkCanWrite();
        Object data = this.getBuffer();
        System.arraycopy(data, srcStart, data, dstStart, count);
    }

    @Override
    public boolean add(E o) {
        this.add(this.size(), o);
        return true;
    }

    @Override
    public void add(int index, E o) {
        this.addSpace(index, 1);
        this.setRaw(index, o);
    }

    @Override
    protected int addPos(int ipos, E value) {
        int index = this.nextIndex(ipos);
        this.add(index, value);
        int ret = this.createPos(index + 1, true);
        this.releasePos(ipos);
        return ret;
    }

    protected void addSpace(int index, int count) {
        this.gapReserve(index, count);
        this.setGapBounds(this.getGapStart() + count, this.getGapEnd());
    }

    public void delete(int start, int end) {
        this.gapReserve(start, 0);
        int gapStart = this.getSizeBits();
        int gapSize = this.getOffsetBits();
        int gapEnd = gapStart + gapSize;
        int count = end - start;
        this.setGapBounds(start, gapEnd + count);
        this.clearBuffer(start, count);
    }

    protected abstract void clearBuffer(int var1, int var2);

    public Object toDataArray() {
        int count;
        int size;
        Object buffer = this.getBuffer();
        Class<?> componentType = buffer.getClass().getComponentType();
        int index = 0;
        Object copy = java.lang.reflect.Array.newInstance(componentType, count);
        for (count = this.size(); count > 0; count -= size) {
            long result = this.getSegment(index);
            int where = (int)result;
            size = (int)(result >> 32);
            if (size > count) {
                size = count;
            }
            System.arraycopy(buffer, where, copy, index, size);
            index += size;
        }
        return copy;
    }

    public String getTag() {
        return null;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getBuffer());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setBuffer(in.readObject());
    }
}

