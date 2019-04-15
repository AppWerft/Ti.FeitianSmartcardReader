/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AbstractSequence;
import gnu.lists.Array;
import gnu.lists.IntSequence;
import gnu.lists.Sequence;
import java.util.List;

public class IndirectIndexedSeq<E>
extends AbstractSequence<E>
implements Sequence<E>,
Array<E> {
    List<E> base;
    IntSequence indexes;

    public IndirectIndexedSeq(List<E> base2, IntSequence indexes) {
        this.base = base2;
        this.indexes = indexes;
    }

    @Override
    public int size() {
        return this.indexes.size();
    }

    @Override
    public int getElementKind() {
        return this.base instanceof AbstractSequence ? Integer.valueOf(((AbstractSequence)((Object)this.base)).getElementKind()) : null;
    }

    public int getBufferLength() {
        return this.base.size();
    }

    @Override
    public int effectiveIndex(int i) {
        return this.indexes.getInt(i);
    }

    @Override
    public E get(int index) {
        return this.base.get(this.indexes.getInt(index));
    }

    @Override
    public E set(int index, E value) {
        return this.base.set(this.indexes.getInt(index), value);
    }

    @Override
    public E getRaw(int i) {
        return this.base.get(i);
    }

    @Override
    public void setRaw(int index, E value) {
        this.base.set(index, value);
    }

    public void copyBuffer(int length) {
        throw this.unsupported("copyBuffer");
    }
}

