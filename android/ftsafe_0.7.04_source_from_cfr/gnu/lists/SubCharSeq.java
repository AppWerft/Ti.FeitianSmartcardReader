/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AbstractSequence;
import gnu.lists.CharSeq;
import gnu.lists.Strings;
import gnu.text.Char;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;
import java.util.RandomAccess;

public class SubCharSeq
extends AbstractSequence<Char>
implements CharSeq,
RandomAccess,
Externalizable {
    CharSequence base;
    int start;
    int end;

    public SubCharSeq(CharSequence base2, int start, int end) {
        this.base = base2;
        this.start = start;
        this.end = end;
    }

    @Override
    public int length() {
        return this.end - this.start;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index >= this.end - this.start) {
            throw new IndexOutOfBoundsException();
        }
        return this.base.charAt(this.start + index);
    }

    @Override
    public Char get(int index) {
        return Char.valueOf(Strings.characterAt(this.base, this.start, this.end, index + this.start));
    }

    @Override
    public int size() {
        return this.length();
    }

    @Override
    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        for (int i = srcBegin; i < srcEnd; ++i) {
            dst[dstBegin++] = this.charAt(i);
        }
    }

    @Override
    public void setCharAt(int index, char ch) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        ((CharSeq)this.base).setCharAt(this.start + index, ch);
    }

    @Override
    public void setCharacterAt(int index, int ch) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        ((CharSeq)this.base).setCharacterAt(this.start + index, ch);
    }

    @Override
    public void fill(char value) {
        ((CharSeq)this.base).fill(this.start, this.end, value);
    }

    @Override
    public void fill(int fromIndex, int toIndex, char value) {
        if (fromIndex < 0 || toIndex < fromIndex || this.start + toIndex > this.end) {
            throw new IndexOutOfBoundsException();
        }
        ((CharSeq)this.base).fill(this.start + fromIndex, this.start + toIndex, value);
    }

    @Override
    public void writeTo(int start, int count, Appendable dest) throws IOException {
        if (start < 0 || count < 0 || start + count > this.length()) {
            throw new IndexOutOfBoundsException();
        }
        dest.append(this.base, this.start + start, count);
    }

    @Override
    public void writeTo(Appendable dest) throws IOException {
        dest.append(this.base, this.start, this.end);
    }

    @Override
    public String toString() {
        int sz = this.size();
        StringBuffer sbuf = new StringBuffer(sz);
        for (int i = 0; i < sz; ++i) {
            sbuf.append(this.charAt(i));
        }
        return sbuf.toString();
    }

    private SubCharSeq subCharSeq(int start, int end) {
        int sz = this.size();
        if (start < 0 || end < start || end > sz) {
            throw new IndexOutOfBoundsException();
        }
        return new SubCharSeq(this.base, this.start + start, this.start + end);
    }

    @Override
    public List subList(int fromIx, int toIx) {
        return this.subCharSeq(fromIx, toIx);
    }

    @Override
    public CharSeq subSequence(int start, int end) {
        return this.subCharSeq(start, end);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.base);
        out.writeInt(this.start);
        out.writeInt(this.end);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.base = (CharSequence)in.readObject();
        this.start = in.readInt();
        this.end = in.readInt();
    }
}

