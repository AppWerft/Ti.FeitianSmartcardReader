// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.util.List;
import gnu.kawa.util.HashUtils;
import java.util.ListIterator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Collection;

public abstract class AbstractSequence<E>
{
    public static final int[] noInts;
    
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
    
    protected void checkRank(final int i) {
        if (i != this.rank()) {
            throw this.badRank(i);
        }
    }
    
    protected RuntimeException badRank(final int i) {
        return new RuntimeException("wrong number of indexes " + i + " to " + this.rank() + "-rank array");
    }
    
    public Array<E> asImmutable() {
        throw this.unsupported("asImmutable");
    }
    
    public E get() {
        return this.getRaw(this.effectiveIndex());
    }
    
    public E get(final int i) {
        return this.getRaw(this.effectiveIndex(i));
    }
    
    public E get(final int i, final int j) {
        return this.getRaw(this.effectiveIndex(i, j));
    }
    
    public E get(final int i, final int j, final int k, final int... rest) {
        return this.getRaw(this.effectiveIndex(i, j, k, rest));
    }
    
    public E get(final int[] indexes) {
        return this.getRaw(this.effectiveIndex(indexes));
    }
    
    protected void checkCanWrite() {
    }
    
    public E getRowMajor(final int index) {
        if (this.rank() == 1) {
            return this.get(index);
        }
        if (this instanceof Array) {
            return Arrays.getRowMajor((Array<E>)this, index);
        }
        throw unsupportedException("getRowMajor");
    }
    
    public int effectiveIndex() {
        this.checkRank(0);
        return 0;
    }
    
    public int effectiveIndex(final int index) {
        this.checkRank(1);
        return index - this.getLowBound(0);
    }
    
    public int effectiveIndex(final int i, final int j) {
        this.checkRank(2);
        return (i - this.getLowBound(0)) * this.getSize(1) + (j - this.getLowBound(1));
    }
    
    public int effectiveIndex(final int i, final int j, final int k, final int... rest) {
        int r = rest.length;
        this.checkRank(3 + r);
        int eff = 0;
        int stride = 1;
        while (--r >= 0) {
            eff += (rest[r] - this.getLowBound(3 + r)) * stride;
            stride *= this.getSize(3 + r);
        }
        eff += (k - this.getLowBound(2)) * stride;
        stride *= this.getSize(2);
        eff += (j - this.getLowBound(1)) * stride;
        stride *= this.getSize(1);
        eff += (i - this.getLowBound(0)) * stride;
        return eff;
    }
    
    public int effectiveIndex(final int[] indexes) {
        final int ilength = indexes.length;
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
            default: {
                int[] rest;
                if (ilength == 3) {
                    rest = AbstractSequence.noInts;
                }
                else {
                    rest = new int[ilength - 3];
                    System.arraycopy(indexes, 3, rest, 0, ilength - 3);
                }
                return this.effectiveIndex(indexes[0], indexes[1], indexes[2], rest);
            }
        }
    }
    
    public E getRaw(final int index) {
        throw this.unsupported("getRaw");
    }
    
    protected void setBuffer(final Object obj) {
        throw this.unsupported("setBuffer");
    }
    
    public void setRaw(final int index, final E value) {
        throw this.unsupported("setRaw");
    }
    
    public boolean getBooleanRaw(final int index) {
        final Object value = this.getRaw(index);
        return value != null && (boolean)value;
    }
    
    public char getCharRaw(final int index) {
        return this.getRaw(index);
    }
    
    public byte getByteRaw(final int index) {
        return this.getRaw(index).byteValue();
    }
    
    public short getShortRaw(final int index) {
        return this.getRaw(index).shortValue();
    }
    
    public int getIntRaw(final int index) {
        return this.getRaw(index).intValue();
    }
    
    public long getLongRaw(final int index) {
        return this.getRaw(index).longValue();
    }
    
    public float getFloatRaw(final int index) {
        return this.getRaw(index).floatValue();
    }
    
    public double getDoubleRaw(final int index) {
        return this.getRaw(index).doubleValue();
    }
    
    public int getInt() {
        return this.getIntRaw(this.effectiveIndex());
    }
    
    public int getInt(final int i) {
        return this.getIntRaw(this.effectiveIndex(i));
    }
    
    public int getInt(final int i, final int j) {
        return this.getIntRaw(this.effectiveIndex(i, j));
    }
    
    public int getInt(final int i, final int j, final int k, final int... rest) {
        return this.getIntRaw(this.effectiveIndex(i, j, k, rest));
    }
    
    public int getInt(final int[] indexes) {
        return this.getIntRaw(this.effectiveIndex(indexes));
    }
    
    public void set(final int[] indexes, final E value) {
        this.checkCanWrite();
        this.setRaw(this.effectiveIndex(indexes), value);
    }
    
    public int getLowBound(final int dim) {
        return 0;
    }
    
    public int getSize(final int dim) {
        return (dim == 0) ? this.size() : 1;
    }
    
    public int getElementKind() {
        return 32;
    }
    
    protected RuntimeException unsupported(final String text) {
        return unsupportedException(this.getClass().getName() + " does not implement " + text);
    }
    
    public static RuntimeException unsupportedException(final String text) {
        return new UnsupportedOperationException(text);
    }
    
    public E set(final int index, final E value) {
        this.checkCanWrite();
        final int effi = this.effectiveIndex(index);
        final E old = this.getRaw(effi);
        this.setRaw(effi, value);
        return old;
    }
    
    public void setAt(final int index, final E value) {
        this.checkCanWrite();
        this.setRaw(this.effectiveIndex(index), value);
    }
    
    public void fill(final E value) {
        int i = this.startPos();
        while ((i = this.nextPos(i)) != 0) {
            this.setPosPrevious(i, value);
        }
    }
    
    public void fillPosRange(final int fromPos, final int toPos, final E value) {
        int i;
        for (i = this.copyPos(fromPos); this.compare(i, toPos) < 0; i = this.nextPos(i)) {
            this.setPosNext(i, value);
        }
        this.releasePos(i);
    }
    
    public void fill(final int fromIndex, final int toIndex, final E value) {
        int i;
        int limit;
        for (i = this.createPos(fromIndex, false), limit = this.createPos(toIndex, true); this.compare(i, limit) < 0; i = this.nextPos(i)) {
            this.setPosNext(i, value);
        }
        this.releasePos(i);
        this.releasePos(limit);
    }
    
    public int indexOf(final Object o) {
        int i = 0;
        int iter = this.startPos();
        while ((iter = this.nextPos(iter)) != 0) {
            final Object v = this.getPosPrevious(iter);
            Label_0045: {
                if (o == null) {
                    if (v == null) {
                        break Label_0045;
                    }
                }
                else if (o.equals(v)) {
                    break Label_0045;
                }
                ++i;
                continue;
            }
            this.releasePos(iter);
            return i;
        }
        return -1;
    }
    
    public int lastIndexOf(final Object o) {
        int n = this.size();
        while (--n >= 0) {
            final Object e = this.get(n);
            if (o == null) {
                if (e == null) {
                    return n;
                }
                continue;
            }
            else {
                if (o.equals(e)) {
                    return n;
                }
                continue;
            }
        }
        return -1;
    }
    
    public int nextMatching(final int startPos, final ItemPredicate type, final int endPos, final boolean descend) {
        if (descend) {
            throw this.unsupported("nextMatching with descend");
        }
        int ipos = startPos;
        while (this.compare(ipos, endPos) < 0) {
            ipos = this.nextPos(ipos);
            if (type.isInstancePos(this, ipos)) {
                return ipos;
            }
        }
        return 0;
    }
    
    public boolean contains(final Object o) {
        return this.indexOf(o) >= 0;
    }
    
    public boolean containsAll(final Collection<?> c) {
        for (final Object e : c) {
            if (!this.contains(e)) {
                return false;
            }
        }
        return true;
    }
    
    public final Enumeration<E> elements() {
        return this.getIterator(0);
    }
    
    public final SeqPosition<E, AbstractSequence<E>> getIterator() {
        return this.getIterator(0);
    }
    
    public SeqPosition<E, AbstractSequence<E>> getIterator(final int index) {
        return new SeqPosition<E, AbstractSequence<E>>(this, index, false);
    }
    
    public SeqPosition<E, AbstractSequence<E>> getIteratorAtPos(final int ipos) {
        return new SeqPosition<E, AbstractSequence<E>>(this, this.copyPos(ipos));
    }
    
    public final Iterator<E> iterator() {
        return this.getIterator(0);
    }
    
    public final ListIterator<E> listIterator() {
        return this.getIterator(0);
    }
    
    public final ListIterator<E> listIterator(final int index) {
        return this.getIterator(index);
    }
    
    protected int addPos(final int ipos, final E value) {
        throw this.unsupported("addPos");
    }
    
    public boolean add(final E o) {
        this.addPos(this.endPos(), o);
        return true;
    }
    
    public void add(final int index, final E o) {
        final int pos = this.createPos(index, false);
        this.addPos(pos, o);
        this.releasePos(pos);
    }
    
    public boolean addAll(final Collection<? extends E> c) {
        return this.addAll(this.size(), c);
    }
    
    public boolean addAll(final int index, final Collection<? extends E> c) {
        boolean changed = false;
        int pos = this.createPos(index, false);
        final Iterator<? extends E> it = c.iterator();
        while (it.hasNext()) {
            pos = this.addPos(pos, it.next());
            changed = true;
        }
        this.releasePos(pos);
        return changed;
    }
    
    public void removePos(final int ipos, final int count) {
        final int rpos = this.createRelativePos(ipos, count, false);
        if (count >= 0) {
            this.removePosRange(ipos, rpos);
        }
        else {
            this.removePosRange(rpos, ipos);
        }
        this.releasePos(rpos);
    }
    
    protected void removePosRange(final int ipos0, final int ipos1) {
        throw this.unsupported("removePosRange");
    }
    
    public E remove(final int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        final int ipos = this.createPos(index, false);
        final E result = (E)this.getPosNext(ipos);
        this.removePos(ipos, 1);
        this.releasePos(ipos);
        return result;
    }
    
    public boolean remove(final Object o) {
        final int index = this.indexOf(o);
        if (index < 0) {
            return false;
        }
        final int ipos = this.createPos(index, false);
        this.removePos(ipos, 1);
        this.releasePos(ipos);
        return true;
    }
    
    public boolean removeAll(final Collection<?> c) {
        boolean changed = false;
        int iter = this.startPos();
        while ((iter = this.nextPos(iter)) != 0) {
            final Object value = this.getPosPrevious(iter);
            if (c.contains(value)) {
                this.removePos(iter, -1);
                changed = true;
            }
        }
        return changed;
    }
    
    public boolean retainAll(final Collection<?> c) {
        boolean changed = false;
        int iter = this.startPos();
        while ((iter = this.nextPos(iter)) != 0) {
            final Object value = this.getPosPrevious(iter);
            if (!c.contains(value)) {
                this.removePos(iter, -1);
                changed = true;
            }
        }
        return changed;
    }
    
    public void clear() {
        this.removePos(this.startPos(), this.endPos());
    }
    
    protected boolean isAfterPos(final int ipos) {
        return (ipos & 0x1) != 0x0;
    }
    
    public int createPos(final int index, final boolean isAfter) {
        return index << 1 | (isAfter ? 1 : 0);
    }
    
    public int createRelativePos(final int pos, final int delta, final boolean isAfter) {
        return this.createPos(this.nextIndex(pos) + delta, isAfter);
    }
    
    public int startPos() {
        return 0;
    }
    
    public int endPos() {
        return -1;
    }
    
    protected void releasePos(final int ipos) {
    }
    
    public int copyPos(final int ipos) {
        return ipos;
    }
    
    protected int getIndexDifference(final int ipos1, final int ipos0) {
        return this.nextIndex(ipos1) - this.nextIndex(ipos0);
    }
    
    protected int nextIndex(final int ipos) {
        return (ipos == -1) ? this.size() : (ipos >>> 1);
    }
    
    public int xnextIndex(final int ipos) {
        return this.nextIndex(ipos);
    }
    
    protected int fromEndIndex(final int ipos) {
        return this.size() - this.nextIndex(ipos);
    }
    
    protected int getContainingSequenceSize(final int ipos) {
        return this.size();
    }
    
    public boolean hasNext(final int ipos) {
        return this.nextIndex(ipos) != this.size();
    }
    
    public int getNextKind(final int ipos) {
        return this.hasNext(ipos) ? 32 : 0;
    }
    
    public String getNextTypeName(final int ipos) {
        final Object type = this.getNextTypeObject(ipos);
        return (type == null) ? null : type.toString();
    }
    
    public E getNextTypeObject(final int ipos) {
        return null;
    }
    
    protected boolean hasPrevious(final int ipos) {
        return this.nextIndex(ipos) != 0;
    }
    
    public int nextPos(final int ipos) {
        if (!this.hasNext(ipos)) {
            return 0;
        }
        final int next = this.createRelativePos(ipos, 1, true);
        this.releasePos(ipos);
        return next;
    }
    
    public int previousPos(final int ipos) {
        if (!this.hasPrevious(ipos)) {
            return 0;
        }
        final int next = this.createRelativePos(ipos, -1, false);
        this.releasePos(ipos);
        return next;
    }
    
    public final boolean gotoChildrenStart(final TreePosition pos) {
        final int ipos = this.firstChildPos(pos.getPos());
        if (ipos == 0) {
            return false;
        }
        pos.push(this, ipos);
        return true;
    }
    
    public int firstChildPos(final int ipos) {
        return 0;
    }
    
    public int firstChildPos(final int ipos, final ItemPredicate predicate) {
        final int child = this.firstChildPos(ipos);
        if (child == 0) {
            return 0;
        }
        if (predicate.isInstancePos(this, child)) {
            return child;
        }
        return this.nextMatching(child, predicate, this.endPos(), false);
    }
    
    public int firstAttributePos(final int ipos) {
        return 0;
    }
    
    public int parentPos(final int ipos) {
        return this.endPos();
    }
    
    protected boolean gotoParent(final TreePosition pos) {
        if (pos.depth < 0) {
            return false;
        }
        pos.pop();
        return true;
    }
    
    public int getAttributeLength() {
        return 0;
    }
    
    public Object getAttribute(final int index) {
        return null;
    }
    
    protected boolean gotoAttributesStart(final TreePosition pos) {
        return false;
    }
    
    public Object getPosNext(final int ipos) {
        if (!this.hasNext(ipos)) {
            return Sequence.eofValue;
        }
        return this.get(this.nextIndex(ipos));
    }
    
    public Object getPosPrevious(final int ipos) {
        final int index = this.nextIndex(ipos);
        if (index <= 0) {
            return Sequence.eofValue;
        }
        return this.get(index - 1);
    }
    
    protected void setPosNext(final int ipos, final E value) {
        final int index = this.nextIndex(ipos);
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        this.set(index, value);
    }
    
    protected void setPosPrevious(final int ipos, final E value) {
        final int index = this.nextIndex(ipos);
        if (index == 0) {
            throw new IndexOutOfBoundsException();
        }
        this.set(index - 1, value);
    }
    
    public final int nextIndex(final SeqPosition pos) {
        return this.nextIndex(pos.ipos);
    }
    
    public boolean equals(final int ipos1, final int ipos2) {
        return this.compare(ipos1, ipos2) == 0;
    }
    
    public int compare(final int ipos1, final int ipos2) {
        final int i1 = this.nextIndex(ipos1);
        final int i2 = this.nextIndex(ipos2);
        return (i1 < i2) ? -1 : ((i1 > i2) ? 1 : 0);
    }
    
    public final int compare(final SeqPosition i1, final SeqPosition i2) {
        return this.compare(i1.ipos, i2.ipos);
    }
    
    public Object[] toArray() {
        final int len = this.size();
        final Object[] arr = new Object[len];
        int it = this.startPos();
        int i = 0;
        while ((it = this.nextPos(it)) != 0) {
            arr[i++] = this.getPosPrevious(it);
        }
        return arr;
    }
    
    public <T> T[] toArray(T[] arr) {
        int alen = arr.length;
        final int len = this.size();
        if (len > alen) {
            final Class componentType = arr.getClass().getComponentType();
            arr = (T[])java.lang.reflect.Array.newInstance(componentType, len);
            alen = len;
        }
        int it = this.startPos();
        int i = 0;
        while ((it = this.nextPos(it)) != 0) {
            arr[i] = (T)this.getPosPrevious(it);
            ++i;
        }
        if (len < alen) {
            arr[len] = null;
        }
        return arr;
    }
    
    public int stableCompare(final AbstractSequence other) {
        final int id1 = System.identityHashCode(this);
        final int id2 = System.identityHashCode(other);
        return (id1 < id2) ? -1 : ((id1 > id2) ? 1 : 0);
    }
    
    public static int compare(final AbstractSequence seq1, final int pos1, final AbstractSequence seq2, final int pos2) {
        if (seq1 == seq2) {
            return seq1.compare(pos1, pos2);
        }
        return seq1.stableCompare(seq2);
    }
    
    @Override
    public int hashCode() {
        if (this.rank() != 1 && this instanceof Array) {
            return Arrays.hashCode((Array)this);
        }
        int hash = 1;
        int i = this.startPos();
        while ((i = this.nextPos(i)) != 0) {
            final Object obj = this.getPosPrevious(i);
            hash = 31 * hash + ((obj == null) ? 0 : obj.hashCode());
        }
        return hash;
    }
    
    public int boundedHash(int seed, final int limit) {
        int count = 0;
        final int sublimit = limit >> 1;
        int i = this.startPos();
        while ((i = this.nextPos(i)) != 0 && ++count <= limit) {
            final int h = HashUtils.boundedHash(this.getPosPrevious(i), 0, sublimit);
            seed = HashUtils.murmur3step(seed, h);
        }
        return HashUtils.murmur3finish(seed, count);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(this instanceof List) || !(o instanceof List)) {
            return this == o;
        }
        final Iterator<E> it1 = this.iterator();
        final Iterator<E> it2 = ((List)o).iterator();
        while (true) {
            final boolean more1 = it1.hasNext();
            final boolean more2 = it2.hasNext();
            if (more1 != more2) {
                return false;
            }
            if (!more1) {
                return true;
            }
            final E e1 = it1.next();
            final E e2 = it2.next();
            if (e1 == null) {
                if (e2 != null) {
                    return false;
                }
                continue;
            }
            else {
                if (!e1.equals(e2)) {
                    return false;
                }
                continue;
            }
        }
    }
    
    public Sequence subSequence(final SeqPosition start, final SeqPosition end) {
        return this.subSequencePos(start.ipos, end.ipos);
    }
    
    protected Sequence<E> subSequencePos(final int ipos0, final int ipos1) {
        return new SubSequence<E>(this, ipos0, ipos1);
    }
    
    public List<E> subList(final int fromIx, final int toIx) {
        return this.subSequencePos(this.createPos(fromIx, false), this.createPos(toIx, true));
    }
    
    public boolean consumeNext(final int ipos, final Consumer out) {
        final int next = this.nextPos(ipos);
        if (next == 0) {
            return false;
        }
        this.consumePosRange(ipos, next, out);
        return true;
    }
    
    public void consumePosRange(final int iposStart, final int iposEnd, final Consumer out) {
        if (out.ignoring()) {
            return;
        }
        int it;
        for (it = this.copyPos(iposStart); !this.equals(it, iposEnd); it = this.nextPos(it)) {
            if (!this.hasNext(it)) {
                throw new RuntimeException();
            }
            out.writeObject(this.getPosNext(it));
        }
        this.releasePos(it);
    }
    
    public void consume(final int fromIndex, final int toIndex, final Consumer out) {
        final int ipos0 = this.createPos(fromIndex, false);
        final int ipos2 = this.createPos(toIndex, true);
        this.consumePosRange(ipos0, ipos2, out);
        this.releasePos(ipos0);
        this.releasePos(ipos2);
    }
    
    public void consume(final Consumer out) {
        final boolean isSequence = this instanceof Sequence;
        if (isSequence) {
            out.startElement("#sequence");
        }
        this.consumePosRange(this.startPos(), this.endPos(), out);
        if (isSequence) {
            out.endElement();
        }
    }
    
    public void toString(final String sep, final StringBuffer sbuf) {
        boolean seen = false;
        int i = this.startPos();
        while ((i = this.nextPos(i)) != 0) {
            if (seen) {
                sbuf.append(sep);
            }
            else {
                seen = true;
            }
            sbuf.append(this.getPosPrevious(i));
        }
    }
    
    @Override
    public String toString() {
        final StringBuffer sbuf = new StringBuffer(100);
        if (this instanceof Sequence) {
            sbuf.append('[');
        }
        this.toString(", ", sbuf);
        if (this instanceof Sequence) {
            sbuf.append(']');
        }
        return sbuf.toString();
    }
    
    static {
        noInts = new int[0];
    }
}
