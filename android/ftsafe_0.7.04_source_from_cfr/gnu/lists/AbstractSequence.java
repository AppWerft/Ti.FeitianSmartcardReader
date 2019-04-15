/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.kawa.util.HashUtils;
import gnu.lists.Array;
import gnu.lists.Arrays;
import gnu.lists.Consumer;
import gnu.lists.ItemPredicate;
import gnu.lists.SeqPosition;
import gnu.lists.Sequence;
import gnu.lists.SubSequence;
import gnu.lists.TreePosition;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class AbstractSequence<E> {
    public static final int[] noInts = new int[0];

    public int size() {
        if (this.rank() == 1) {
            return this.getSize(0);
        }
        throw this.unsupported("size");
    }

    public int getSize() {
        int sz = 1;
        int r = this.rank();
        while (--r >= 0) {
            sz *= this.getSize(r);
        }
        return sz;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int rank() {
        return 1;
    }

    protected void checkRank(int i) {
        if (i != this.rank()) {
            throw this.badRank(i);
        }
    }

    protected RuntimeException badRank(int i) {
        return new RuntimeException("wrong number of indexes " + i + " to " + this.rank() + "-rank array");
    }

    public Array<E> asImmutable() {
        throw this.unsupported("asImmutable");
    }

    public E get() {
        return this.getRaw(this.effectiveIndex());
    }

    public E get(int i) {
        return this.getRaw(this.effectiveIndex(i));
    }

    public E get(int i, int j) {
        return this.getRaw(this.effectiveIndex(i, j));
    }

    public /* varargs */ E get(int i, int j, int k, int ... rest) {
        return this.getRaw(this.effectiveIndex(i, j, k, rest));
    }

    public E get(int[] indexes) {
        return this.getRaw(this.effectiveIndex(indexes));
    }

    protected void checkCanWrite() {
    }

    public E getRowMajor(int index) {
        if (this.rank() == 1) {
            return this.get(index);
        }
        if (this instanceof Array) {
            return Arrays.getRowMajor((Array)((Object)this), index);
        }
        throw AbstractSequence.unsupportedException("getRowMajor");
    }

    public int effectiveIndex() {
        this.checkRank(0);
        return 0;
    }

    public int effectiveIndex(int index) {
        this.checkRank(1);
        return index - this.getLowBound(0);
    }

    public int effectiveIndex(int i, int j) {
        this.checkRank(2);
        return (i - this.getLowBound(0)) * this.getSize(1) + (j - this.getLowBound(1));
    }

    public /* varargs */ int effectiveIndex(int i, int j, int k, int ... rest) {
        int r = rest.length;
        this.checkRank(3 + r);
        int eff = 0;
        int stride = 1;
        while (--r >= 0) {
            eff += (rest[r] - this.getLowBound(3 + r)) * stride;
            stride *= this.getSize(3 + r);
        }
        eff += (k - this.getLowBound(2)) * stride;
        eff += (j - this.getLowBound(1)) * (stride *= this.getSize(2));
        return eff += (i - this.getLowBound(0)) * (stride *= this.getSize(1));
    }

    public int effectiveIndex(int[] indexes) {
        int[] rest;
        int ilength = indexes.length;
        switch (indexes.length) {
            case 0: {
                return this.effectiveIndex();
            }
            case 1: {
                return this.effectiveIndex(indexes[0]);
            }
            case 2: {
                return this.effectiveIndex(indexes[0], indexes[1]);
            }
        }
        if (ilength == 3) {
            rest = noInts;
        } else {
            rest = new int[ilength - 3];
            System.arraycopy(indexes, 3, rest, 0, ilength - 3);
        }
        return this.effectiveIndex(indexes[0], indexes[1], indexes[2], rest);
    }

    public E getRaw(int index) {
        throw this.unsupported("getRaw");
    }

    protected void setBuffer(Object obj) {
        throw this.unsupported("setBuffer");
    }

    public void setRaw(int index, E value) {
        throw this.unsupported("setRaw");
    }

    public boolean getBooleanRaw(int index) {
        E value = this.getRaw(index);
        return value != null && (Boolean)value != false;
    }

    public char getCharRaw(int index) {
        return ((Character)this.getRaw(index)).charValue();
    }

    public byte getByteRaw(int index) {
        return ((Number)this.getRaw(index)).byteValue();
    }

    public short getShortRaw(int index) {
        return ((Number)this.getRaw(index)).shortValue();
    }

    public int getIntRaw(int index) {
        return ((Number)this.getRaw(index)).intValue();
    }

    public long getLongRaw(int index) {
        return ((Number)this.getRaw(index)).longValue();
    }

    public float getFloatRaw(int index) {
        return ((Number)this.getRaw(index)).floatValue();
    }

    public double getDoubleRaw(int index) {
        return ((Number)this.getRaw(index)).doubleValue();
    }

    public int getInt() {
        return this.getIntRaw(this.effectiveIndex());
    }

    public int getInt(int i) {
        return this.getIntRaw(this.effectiveIndex(i));
    }

    public int getInt(int i, int j) {
        return this.getIntRaw(this.effectiveIndex(i, j));
    }

    public /* varargs */ int getInt(int i, int j, int k, int ... rest) {
        return this.getIntRaw(this.effectiveIndex(i, j, k, rest));
    }

    public int getInt(int[] indexes) {
        return this.getIntRaw(this.effectiveIndex(indexes));
    }

    public void set(int[] indexes, E value) {
        this.checkCanWrite();
        this.setRaw(this.effectiveIndex(indexes), value);
    }

    public int getLowBound(int dim) {
        return 0;
    }

    public int getSize(int dim) {
        return dim == 0 ? this.size() : 1;
    }

    public int getElementKind() {
        return 32;
    }

    protected RuntimeException unsupported(String text) {
        return AbstractSequence.unsupportedException(this.getClass().getName() + " does not implement " + text);
    }

    public static RuntimeException unsupportedException(String text) {
        return new UnsupportedOperationException(text);
    }

    public E set(int index, E value) {
        this.checkCanWrite();
        int effi = this.effectiveIndex(index);
        E old = this.getRaw(effi);
        this.setRaw(effi, value);
        return old;
    }

    public void setAt(int index, E value) {
        this.checkCanWrite();
        this.setRaw(this.effectiveIndex(index), value);
    }

    public void fill(E value) {
        int i = this.startPos();
        while ((i = this.nextPos(i)) != 0) {
            this.setPosPrevious(i, value);
        }
    }

    public void fillPosRange(int fromPos, int toPos, E value) {
        int i = this.copyPos(fromPos);
        while (this.compare(i, toPos) < 0) {
            this.setPosNext(i, value);
            i = this.nextPos(i);
        }
        this.releasePos(i);
    }

    public void fill(int fromIndex, int toIndex, E value) {
        int i = this.createPos(fromIndex, false);
        int limit = this.createPos(toIndex, true);
        while (this.compare(i, limit) < 0) {
            this.setPosNext(i, value);
            i = this.nextPos(i);
        }
        this.releasePos(i);
        this.releasePos(limit);
    }

    public int indexOf(Object o) {
        int i = 0;
        int iter = this.startPos();
        while ((iter = this.nextPos(iter)) != 0) {
            Object v = this.getPosPrevious(iter);
            if (o == null ? v == null : o.equals(v)) {
                this.releasePos(iter);
                return i;
            }
            ++i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int n = this.size();
        while (--n >= 0) {
            E e = this.get(n);
            if (!(o == null ? e == null : o.equals(e))) continue;
            return n;
        }
        return -1;
    }

    public int nextMatching(int startPos, ItemPredicate type, int endPos, boolean descend) {
        if (descend) {
            throw this.unsupported("nextMatching with descend");
        }
        int ipos = startPos;
        do {
            if (this.compare(ipos, endPos) < 0) continue;
            return 0;
        } while (!type.isInstancePos(this, ipos = this.nextPos(ipos)));
        return ipos;
    }

    public boolean contains(Object o) {
        return this.indexOf(o) >= 0;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (this.contains(e)) continue;
            return false;
        }
        return true;
    }

    public final Enumeration<E> elements() {
        return this.getIterator(0);
    }

    public final SeqPosition<E, AbstractSequence<E>> getIterator() {
        return this.getIterator(0);
    }

    public SeqPosition<E, AbstractSequence<E>> getIterator(int index) {
        return new SeqPosition(this, index, false);
    }

    public SeqPosition<E, AbstractSequence<E>> getIteratorAtPos(int ipos) {
        return new SeqPosition(this, this.copyPos(ipos));
    }

    public final Iterator<E> iterator() {
        return this.getIterator(0);
    }

    public final ListIterator<E> listIterator() {
        return this.getIterator(0);
    }

    public final ListIterator<E> listIterator(int index) {
        return this.getIterator(index);
    }

    protected int addPos(int ipos, E value) {
        throw this.unsupported("addPos");
    }

    public boolean add(E o) {
        this.addPos(this.endPos(), o);
        return true;
    }

    public void add(int index, E o) {
        int pos = this.createPos(index, false);
        this.addPos(pos, o);
        this.releasePos(pos);
    }

    public boolean addAll(Collection<? extends E> c) {
        return this.addAll(this.size(), c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        boolean changed = false;
        int pos = this.createPos(index, false);
        Iterator<E> it = c.iterator();
        while (it.hasNext()) {
            pos = this.addPos(pos, it.next());
            changed = true;
        }
        this.releasePos(pos);
        return changed;
    }

    public void removePos(int ipos, int count) {
        int rpos = this.createRelativePos(ipos, count, false);
        if (count >= 0) {
            this.removePosRange(ipos, rpos);
        } else {
            this.removePosRange(rpos, ipos);
        }
        this.releasePos(rpos);
    }

    protected void removePosRange(int ipos0, int ipos1) {
        throw this.unsupported("removePosRange");
    }

    public E remove(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        int ipos = this.createPos(index, false);
        Object result = this.getPosNext(ipos);
        this.removePos(ipos, 1);
        this.releasePos(ipos);
        return (E)result;
    }

    public boolean remove(Object o) {
        int index = this.indexOf(o);
        if (index < 0) {
            return false;
        }
        int ipos = this.createPos(index, false);
        this.removePos(ipos, 1);
        this.releasePos(ipos);
        return true;
    }

    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        int iter = this.startPos();
        while ((iter = this.nextPos(iter)) != 0) {
            Object value = this.getPosPrevious(iter);
            if (!c.contains(value)) continue;
            this.removePos(iter, -1);
            changed = true;
        }
        return changed;
    }

    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        int iter = this.startPos();
        while ((iter = this.nextPos(iter)) != 0) {
            Object value = this.getPosPrevious(iter);
            if (c.contains(value)) continue;
            this.removePos(iter, -1);
            changed = true;
        }
        return changed;
    }

    public void clear() {
        this.removePos(this.startPos(), this.endPos());
    }

    protected boolean isAfterPos(int ipos) {
        return (ipos & 1) != 0;
    }

    public int createPos(int index, boolean isAfter) {
        return index << 1 | (isAfter ? 1 : 0);
    }

    public int createRelativePos(int pos, int delta, boolean isAfter) {
        return this.createPos(this.nextIndex(pos) + delta, isAfter);
    }

    public int startPos() {
        return 0;
    }

    public int endPos() {
        return -1;
    }

    protected void releasePos(int ipos) {
    }

    public int copyPos(int ipos) {
        return ipos;
    }

    protected int getIndexDifference(int ipos1, int ipos0) {
        return this.nextIndex(ipos1) - this.nextIndex(ipos0);
    }

    protected int nextIndex(int ipos) {
        return ipos == -1 ? this.size() : ipos >>> 1;
    }

    public int xnextIndex(int ipos) {
        return this.nextIndex(ipos);
    }

    protected int fromEndIndex(int ipos) {
        return this.size() - this.nextIndex(ipos);
    }

    protected int getContainingSequenceSize(int ipos) {
        return this.size();
    }

    public boolean hasNext(int ipos) {
        return this.nextIndex(ipos) != this.size();
    }

    public int getNextKind(int ipos) {
        return this.hasNext(ipos) ? 32 : 0;
    }

    public String getNextTypeName(int ipos) {
        E type = this.getNextTypeObject(ipos);
        return type == null ? null : type.toString();
    }

    public E getNextTypeObject(int ipos) {
        return null;
    }

    protected boolean hasPrevious(int ipos) {
        return this.nextIndex(ipos) != 0;
    }

    public int nextPos(int ipos) {
        if (!this.hasNext(ipos)) {
            return 0;
        }
        int next = this.createRelativePos(ipos, 1, true);
        this.releasePos(ipos);
        return next;
    }

    public int previousPos(int ipos) {
        if (!this.hasPrevious(ipos)) {
            return 0;
        }
        int next = this.createRelativePos(ipos, -1, false);
        this.releasePos(ipos);
        return next;
    }

    public final boolean gotoChildrenStart(TreePosition pos) {
        int ipos = this.firstChildPos(pos.getPos());
        if (ipos == 0) {
            return false;
        }
        pos.push(this, ipos);
        return true;
    }

    public int firstChildPos(int ipos) {
        return 0;
    }

    public int firstChildPos(int ipos, ItemPredicate predicate) {
        int child = this.firstChildPos(ipos);
        if (child == 0) {
            return 0;
        }
        if (predicate.isInstancePos(this, child)) {
            return child;
        }
        return this.nextMatching(child, predicate, this.endPos(), false);
    }

    public int firstAttributePos(int ipos) {
        return 0;
    }

    public int parentPos(int ipos) {
        return this.endPos();
    }

    protected boolean gotoParent(TreePosition pos) {
        if (pos.depth < 0) {
            return false;
        }
        pos.pop();
        return true;
    }

    public int getAttributeLength() {
        return 0;
    }

    public Object getAttribute(int index) {
        return null;
    }

    protected boolean gotoAttributesStart(TreePosition pos) {
        return false;
    }

    public Object getPosNext(int ipos) {
        if (!this.hasNext(ipos)) {
            return Sequence.eofValue;
        }
        return this.get(this.nextIndex(ipos));
    }

    public Object getPosPrevious(int ipos) {
        int index = this.nextIndex(ipos);
        if (index <= 0) {
            return Sequence.eofValue;
        }
        return this.get(index - 1);
    }

    protected void setPosNext(int ipos, E value) {
        int index = this.nextIndex(ipos);
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        this.set(index, value);
    }

    protected void setPosPrevious(int ipos, E value) {
        int index = this.nextIndex(ipos);
        if (index == 0) {
            throw new IndexOutOfBoundsException();
        }
        this.set(index - 1, value);
    }

    public final int nextIndex(SeqPosition pos) {
        return this.nextIndex(pos.ipos);
    }

    public boolean equals(int ipos1, int ipos2) {
        return this.compare(ipos1, ipos2) == 0;
    }

    public int compare(int ipos1, int ipos2) {
        int i2;
        int i1 = this.nextIndex(ipos1);
        return i1 < (i2 = this.nextIndex(ipos2)) ? -1 : (i1 > i2 ? 1 : 0);
    }

    public final int compare(SeqPosition i1, SeqPosition i2) {
        return this.compare(i1.ipos, i2.ipos);
    }

    public Object[] toArray() {
        int len = this.size();
        Object[] arr = new Object[len];
        int it = this.startPos();
        int i = 0;
        while ((it = this.nextPos(it)) != 0) {
            arr[i++] = this.getPosPrevious(it);
        }
        return arr;
    }

    public <T> T[] toArray(T[] arr) {
        int alen = arr.length;
        int len = this.size();
        if (len > alen) {
            Class<?> componentType = arr.getClass().getComponentType();
            arr = (Object[])java.lang.reflect.Array.newInstance(componentType, len);
            alen = len;
        }
        int it = this.startPos();
        int i = 0;
        while ((it = this.nextPos(it)) != 0) {
            arr[i] = this.getPosPrevious(it);
            ++i;
        }
        if (len < alen) {
            arr[len] = null;
        }
        return arr;
    }

    public int stableCompare(AbstractSequence other) {
        int id2;
        int id1 = System.identityHashCode(this);
        return id1 < (id2 = System.identityHashCode(other)) ? -1 : (id1 > id2 ? 1 : 0);
    }

    public static int compare(AbstractSequence seq1, int pos1, AbstractSequence seq2, int pos2) {
        if (seq1 == seq2) {
            return seq1.compare(pos1, pos2);
        }
        return seq1.stableCompare(seq2);
    }

    public int hashCode() {
        if (this.rank() != 1 && this instanceof Array) {
            return Arrays.hashCode((Array)((Object)this));
        }
        int hash = 1;
        int i = this.startPos();
        while ((i = this.nextPos(i)) != 0) {
            Object obj = this.getPosPrevious(i);
            hash = 31 * hash + (obj == null ? 0 : obj.hashCode());
        }
        return hash;
    }

    public int boundedHash(int seed, int limit) {
        int count = 0;
        int sublimit = limit >> 1;
        int i = this.startPos();
        while ((i = this.nextPos(i)) != 0 && ++count <= limit) {
            int h = HashUtils.boundedHash(this.getPosPrevious(i), 0, sublimit);
            seed = HashUtils.murmur3step(seed, h);
        }
        return HashUtils.murmur3finish(seed, count);
    }

    public boolean equals(Object o) {
        Object e2;
        E e1;
        if (!(this instanceof List) || !(o instanceof List)) {
            return this == o;
        }
        Iterator<E> it1 = this.iterator();
        Iterator it2 = ((List)o).iterator();
        do {
            boolean more2;
            boolean more1;
            if ((more1 = it1.hasNext()) != (more2 = it2.hasNext())) {
                return false;
            }
            if (!more1) {
                return true;
            }
            e1 = it1.next();
            e2 = it2.next();
        } while (!(e1 == null ? e2 != null : !e1.equals(e2)));
        return false;
    }

    public Sequence subSequence(SeqPosition start, SeqPosition end) {
        return this.subSequencePos(start.ipos, end.ipos);
    }

    protected Sequence<E> subSequencePos(int ipos0, int ipos1) {
        return new SubSequence(this, ipos0, ipos1);
    }

    public List<E> subList(int fromIx, int toIx) {
        return this.subSequencePos(this.createPos(fromIx, false), this.createPos(toIx, true));
    }

    public boolean consumeNext(int ipos, Consumer out) {
        int next = this.nextPos(ipos);
        if (next == 0) {
            return false;
        }
        this.consumePosRange(ipos, next, out);
        return true;
    }

    public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
        if (out.ignoring()) {
            return;
        }
        int it = this.copyPos(iposStart);
        while (!this.equals(it, iposEnd)) {
            if (!this.hasNext(it)) {
                throw new RuntimeException();
            }
            out.writeObject(this.getPosNext(it));
            it = this.nextPos(it);
        }
        this.releasePos(it);
    }

    public void consume(int fromIndex, int toIndex, Consumer out) {
        int ipos0 = this.createPos(fromIndex, false);
        int ipos1 = this.createPos(toIndex, true);
        this.consumePosRange(ipos0, ipos1, out);
        this.releasePos(ipos0);
        this.releasePos(ipos1);
    }

    public void consume(Consumer out) {
        boolean isSequence = this instanceof Sequence;
        if (isSequence) {
            out.startElement("#sequence");
        }
        this.consumePosRange(this.startPos(), this.endPos(), out);
        if (isSequence) {
            out.endElement();
        }
    }

    public void toString(String sep, StringBuffer sbuf) {
        boolean seen = false;
        int i = this.startPos();
        while ((i = this.nextPos(i)) != 0) {
            if (seen) {
                sbuf.append(sep);
            } else {
                seen = true;
            }
            sbuf.append(this.getPosPrevious(i));
        }
    }

    public String toString() {
        StringBuffer sbuf = new StringBuffer(100);
        if (this instanceof Sequence) {
            sbuf.append('[');
        }
        this.toString(", ", sbuf);
        if (this instanceof Sequence) {
            sbuf.append(']');
        }
        return sbuf.toString();
    }
}

