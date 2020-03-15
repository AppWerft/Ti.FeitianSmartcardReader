// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;
import java.io.IOException;
import java.io.Externalizable;
import java.util.RandomAccess;
import gnu.text.Char;

public class SubCharSeq extends AbstractSequence<Char> implements CharSeq, RandomAccess, Externalizable
{
    CharSequence base;
    int start;
    int end;
    
    public SubCharSeq(final CharSequence base, final int start, final int end) {
        this.base = base;
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int length() {
        return this.end - this.start;
    }
    
    @Override
    public char charAt(final int index) {
        if (index < 0 || index >= this.end - this.start) {
            throw new IndexOutOfBoundsException();
        }
        return this.base.charAt(this.start + index);
    }
    
    @Override
    public Char get(final int index) {
        return Char.valueOf(Strings.characterAt(this.base, this.start, this.end, index + this.start));
    }
    
    @Override
    public int size() {
        return this.length();
    }
    
    @Override
    public void getChars(final int srcBegin, final int srcEnd, final char[] dst, int dstBegin) {
        for (int i = srcBegin; i < srcEnd; ++i) {
            dst[dstBegin++] = this.charAt(i);
        }
    }
    
    @Override
    public void setCharAt(final int index, final char ch) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        ((CharSeq)this.base).setCharAt(this.start + index, ch);
    }
    
    @Override
    public void setCharacterAt(final int index, final int ch) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        ((CharSeq)this.base).setCharacterAt(this.start + index, ch);
    }
    
    @Override
    public void fill(final char value) {
        ((CharSeq)this.base).fill(this.start, this.end, value);
    }
    
    @Override
    public void fill(final int fromIndex, final int toIndex, final char value) {
        if (fromIndex < 0 || toIndex < fromIndex || this.start + toIndex > this.end) {
            throw new IndexOutOfBoundsException();
        }
        ((CharSeq)this.base).fill(this.start + fromIndex, this.start + toIndex, value);
    }
    
    @Override
    public void writeTo(final int start, final int count, final Appendable dest) throws IOException {
        if (start < 0 || count < 0 || start + count > this.length()) {
            throw new IndexOutOfBoundsException();
        }
        dest.append(this.base, this.start + start, count);
    }
    
    @Override
    public void writeTo(final Appendable dest) throws IOException {
        dest.append(this.base, this.start, this.end);
    }
    
    @Override
    public String toString() {
        final int sz = this.size();
        final StringBuffer sbuf = new StringBuffer(sz);
        for (int i = 0; i < sz; ++i) {
            sbuf.append(this.charAt(i));
        }
        return sbuf.toString();
    }
    
    private SubCharSeq subCharSeq(final int start, final int end) {
        final int sz = this.size();
        if (start < 0 || end < start || end > sz) {
            throw new IndexOutOfBoundsException();
        }
        return new SubCharSeq(this.base, this.start + start, this.start + end);
    }
    
    @Override
    public List subList(final int fromIx, final int toIx) {
        return this.subCharSeq(fromIx, toIx);
    }
    
    @Override
    public CharSeq subSequence(final int start, final int end) {
        return this.subCharSeq(start, end);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.base);
        out.writeInt(this.start);
        out.writeInt(this.end);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.base = (CharSequence)in.readObject();
        this.start = in.readInt();
        this.end = in.readInt();
    }
}
