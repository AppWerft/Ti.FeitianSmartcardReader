// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import gnu.text.Char;

public class FString extends AbstractCharVector<Char> implements Appendable, CharSeq, Consumable
{
    public FString() {
        this.data = FString.empty;
    }
    
    public FString(final int num) {
        this.data = new char[num];
    }
    
    public FString(final int num, final int value) {
        this.data = new char[(value < 65536) ? num : (2 * num)];
        this.insertRepeatedRaw(0, value, num);
    }
    
    public FString(final char[] values) {
        this.data = values;
    }
    
    public FString(final String str) {
        this.data = str.toCharArray();
    }
    
    public FString(final StringBuilder buffer) {
        this(buffer, 0, buffer.length());
    }
    
    public FString(final StringBuilder buffer, final int offset, final int length) {
        this.data = new char[length];
        if (length > 0) {
            buffer.getChars(offset, offset + length, this.data, 0);
        }
    }
    
    public FString(final StringBuffer buffer) {
        this(buffer, 0, buffer.length());
    }
    
    public FString(final StringBuffer buffer, final int offset, final int length) {
        this.data = new char[length];
        if (length > 0) {
            buffer.getChars(offset, offset + length, this.data, 0);
        }
    }
    
    public FString(final char[] buffer, final int offset, final int length) {
        System.arraycopy(buffer, offset, this.data = new char[length], 0, length);
    }
    
    public FString(final Sequence seq) {
        this.data = new char[seq.size()];
        this.addAll(seq);
    }
    
    public FString(final CharSequence seq) {
        this(seq, 0, seq.length());
    }
    
    public FString(final CharSequence seq, final int offset, final int length) {
        final char[] data = new char[length];
        if (seq instanceof CharSeq) {
            ((CharSeq)seq).getChars(offset, offset + length, data, 0);
        }
        else if (seq instanceof String) {
            ((String)seq).getChars(offset, offset + length, data, 0);
        }
        else {
            int i = length;
            while (--i >= 0) {
                data[i] = seq.charAt(offset + i);
            }
        }
        this.data = data;
    }
    
    public static FString alloc(int sz) {
        if (sz > 33554431) {
            sz = 33554431;
        }
        final FString str = new FString(sz);
        str.setGapBounds(0, sz);
        return str;
    }
    
    @Override
    public final Char getRaw(final int index) {
        throw this.unsupported("getRaw " + index);
    }
    
    @Override
    public final Char get(final int index) {
        return Char.valueOf(this.characterAt(index));
    }
    
    public int indexOf(final int ch, final int fromChar) {
        char c1;
        char c2;
        if (ch >= 65536) {
            c1 = (char)((ch - 65536 >> 10) + 55296);
            c2 = (char)((ch & 0x3FF) + 56320);
        }
        else {
            c1 = '\0';
            c2 = (char)ch;
        }
        final int sz = this.size();
        char prev = '\0';
        for (int i = fromChar; i < sz; ++i) {
            final char cur = this.charAt(i);
            if (cur == c2) {
                if (c1 == '\0') {
                    return i;
                }
                if (prev == c1) {
                    return i - 1;
                }
            }
            prev = cur;
        }
        return -1;
    }
    
    public int lastIndexOf(final int ch, final int fromChar) {
        char c1;
        char c2;
        if (ch >= 65536) {
            c1 = (char)((ch - 65536 >> 10) + 55296);
            c2 = (char)((ch & 0x3FF) + 56320);
        }
        else {
            c1 = '\0';
            c2 = (char)ch;
        }
        int i = fromChar;
        while (--i >= 0) {
            if (this.charAt(i) == c2) {
                if (c1 == '\0') {
                    return i;
                }
                if (i > 0 && this.charAt(i - 1) == c1) {
                    return i - 1;
                }
                continue;
            }
        }
        return -1;
    }
    
    @Override
    public Char set(final int index, final Char value) {
        this.checkCanWrite();
        final Char old = Char.valueOf(this.characterAt(index));
        this.setCharacterAt(index, value.intValue());
        return old;
    }
    
    @Override
    public final void setRaw(final int index, final Char value) {
        this.setCharacterAt(index, value.intValue());
    }
    
    public final int characterAt(final int index) {
        return Strings.characterAt(this, 0, this.size(), index);
    }
    
    public char[] toCharArray() {
        if (this.isVerySimple()) {
            return this.data;
        }
        final int seq_length = this.size();
        final char[] arr = new char[seq_length];
        for (int i = 0; i < seq_length; ++i) {
            arr[i] = this.charAt(i);
        }
        return arr;
    }
    
    @Override
    public void shift(final int srcStart, final int dstStart, final int count) {
        System.arraycopy(this.data, srcStart, this.data, dstStart, count);
    }
    
    public FString copy(final int start, final int end) {
        final char[] copy = new char[end - start];
        final char[] src = this.data;
        for (int i = start; i < end; ++i) {
            copy[i - start] = src[i];
        }
        return new FString(copy);
    }
    
    public boolean addAll(final CharSequence s) {
        final int ssize = s.length();
        final int sz = this.size();
        this.addSpace(sz, ssize);
        if (s instanceof String) {
            ((String)s).getChars(0, ssize, this.data, sz);
        }
        else if (s instanceof CharSeq) {
            ((CharSeq)s).getChars(0, ssize, this.data, sz);
        }
        else {
            int i = ssize;
            while (--i >= 0) {
                this.data[sz + i] = s.charAt(i);
            }
        }
        return ssize > 0;
    }
    
    public void insert(final int where, final int ch, final boolean beforeMarkers) {
        char c1;
        char c2;
        int len;
        if (ch >= 65536) {
            c1 = (char)((ch - 65536 >> 10) + 55296);
            c2 = (char)((ch & 0x3FF) + 56320);
            len = 2;
        }
        else {
            c1 = (char)ch;
            c2 = '\0';
            len = 1;
        }
        this.addSpace(where, len);
        this.data[where] = c1;
        if (c2 > '\0') {
            this.data[where + 1] = c2;
        }
    }
    
    public void insert(final int where, final String str, final boolean beforeMarkers) {
        final int len = str.length();
        this.addSpace(where, len);
        str.getChars(0, len, this.data, where);
    }
    
    public void addAllStrings(final Object[] args, final int startIndex) {
        final int sz = this.size();
        int count = 0;
        for (int i = startIndex; i < args.length; ++i) {
            final Object arg = args[i];
            count += ((CharSequence)arg).length();
        }
        this.gapReserve(sz, count);
        for (int i = startIndex; i < args.length; ++i) {
            this.addAll((CharSequence)args[i]);
        }
    }
    
    @Override
    public String toString() {
        return this.substring(0, this.size());
    }
    
    public String substring(final int start, final int end) {
        if (this.isVerySimple()) {
            return new String(this.data, start, end - start);
        }
        return new StringBuilder().append(this, start, end).toString();
    }
    
    @Override
    public CharSeq subSequence(final int start, final int end) {
        return new FString(this, start, end - start);
    }
    
    @Override
    public void setCharAt(final int index, final char ch) {
        this.checkCanWrite();
        this.data[this.effectiveIndex(index)] = ch;
    }
    
    @Override
    public void setCharacterAt(final int index, final int ch) {
        final int sz = this.size();
        if (index < 0 || index >= sz) {
            throw new StringIndexOutOfBoundsException(index);
        }
        final char old1 = this.charAt(index);
        final char old2;
        final boolean oldIsSupp = old1 >= '\ud800' && old1 <= '\udbff' && index + 1 < sz && (old2 = this.charAt(index + 1)) >= '\udc00' && old2 <= '\udfff';
        if (ch <= 65535) {
            if (oldIsSupp) {
                this.delete(index + 1, index + 2);
            }
            this.setCharAt(index, (char)ch);
        }
        else {
            final char c1 = (char)((ch - 65536 >> 10) + 55296);
            final char c2 = (char)((ch & 0x3FF) + 56320);
            this.setCharAt(index, c1);
            if (oldIsSupp) {
                this.setCharAt(index + 1, c2);
            }
            else {
                this.insert(index + 1, c2, true);
            }
        }
    }
    
    public void replace(CharSequence src, int srcStart, int srcEnd, final int dstStart, final int dstEnd) {
        if (dstStart < 0 || dstStart > dstEnd || dstEnd > this.length() || srcStart < 0 || srcStart > srcEnd || srcEnd > src.length()) {
            throw new StringIndexOutOfBoundsException();
        }
        final int srcLength = srcEnd - srcStart;
        final int dstLength = dstEnd - dstStart;
        final int grow = srcLength - dstLength;
        if (grow > 0) {
            this.gapReserve(dstEnd, grow);
        }
        if (src instanceof FString) {
            final FString fsrc = (FString)src;
            final int sstart = fsrc.getSegmentReadOnly(srcStart, srcLength);
            if (sstart >= 0) {
                System.arraycopy(fsrc.data, sstart, this.data, dstStart, srcLength);
                if (grow < 0) {
                    this.delete(dstEnd + grow, dstEnd);
                }
                else if (grow > 0) {
                    this.setGapBounds(this.getGapStart() + grow, this.getGapEnd());
                }
                return;
            }
        }
        if (!Sequences.copyInPlaceIsSafe(this, src)) {
            src = src.subSequence(srcStart, srcEnd).toString();
            srcEnd = srcLength;
            srcStart = 0;
        }
        if (grow < 0) {
            this.delete(dstEnd + grow, dstEnd);
        }
        else if (grow > 0) {
            this.setGapBounds(this.getGapStart() + grow, this.getGapEnd());
        }
        int i = dstStart;
        for (int j = srcStart; j < srcEnd; ++j) {
            this.data[i] = src.charAt(j);
            ++i;
        }
    }
    
    public void setCharAtBuffer(final int index, final char ch) {
        this.data[index] = ch;
    }
    
    @Override
    public final void fill(final char ch) {
        this.fill(0, this.size(), ch);
    }
    
    @Override
    public void fill(final int fromIndex, final int toIndex, final char value) {
        if (fromIndex < 0 || toIndex > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        if (this.isVerySimple()) {
            final char[] d = this.data;
            for (int i = fromIndex; i < toIndex; ++i) {
                d[i] = value;
            }
        }
        else {
            for (int j = fromIndex; j < toIndex; ++j) {
                this.setCharAt(j, value);
            }
        }
    }
    
    public void insertRepeated(final int where, final int value, final int count) {
        this.addSpace(where, (value < 65536) ? count : (2 * count));
        this.insertRepeatedRaw(where, value, count);
    }
    
    private void insertRepeatedRaw(final int where, final int value, final int count) {
        char c1;
        char c2;
        int len;
        if (value >= 65536) {
            c1 = (char)((value - 65536 >> 10) + 55296);
            c2 = (char)((value & 0x3FF) + 56320);
            len = 2 * count;
        }
        else {
            c1 = (char)value;
            c2 = '\0';
            len = count;
        }
        final char[] array = this.data;
        for (int end = where + len, i = where; i < end; array[where + i++] = c2) {
            array[i++] = c1;
            if (c2 != '\0') {}
        }
    }
    
    public void replace(final int where, final char[] chars, final int start, final int count) {
        System.arraycopy(chars, start, this.data, where, count);
    }
    
    public void replace(final int where, final String string) {
        string.getChars(0, string.length(), this.data, where);
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof FString && AbstractCharVector.equals(this, (AbstractCharVector<?>)obj);
    }
    
    @Override
    protected FString newInstance(final int newLength) {
        return new FString((newLength < 0) ? this.data : new char[newLength]);
    }
    
    @Override
    public int getElementKind() {
        return 29;
    }
    
    @Override
    public String getTag() {
        return "c32";
    }
    
    @Override
    public void consume(final Consumer out) {
        out.write(this.data, 0, this.data.length);
    }
    
    @Override
    public void consumePosRange(final int iposStart, final int iposEnd, final Consumer out) {
        if (out.ignoring()) {
            return;
        }
        int size;
        for (int i = this.nextIndex(iposStart), end = this.nextIndex(iposEnd); i < end; i += size) {
            final long result = this.getSegment(i);
            final int where = (int)result;
            size = (int)(result >> 32);
            out.write(this.data, where, size);
        }
    }
    
    @Override
    public FString append(final char c) {
        final int sz = this.size();
        this.addSpace(sz, 1);
        final char[] d = this.data;
        d[sz] = c;
        return this;
    }
    
    public FString appendCharacter(int c) {
        int delta;
        if (c < 65536) {
            delta = 1;
        }
        else {
            if (c == 2097151) {
                return this;
            }
            delta = 2;
        }
        int sz = this.size();
        this.addSpace(sz, delta);
        final char[] d = this.data;
        if (delta > 1) {
            d[sz++] = (char)((c - 65536 >> 10) + 55296);
            c = (c & 0x3FF) + 56320;
        }
        d[sz++] = (char)c;
        return this;
    }
    
    @Override
    public FString append(CharSequence csq) {
        if (csq == null) {
            csq = "null";
        }
        return this.append(csq, 0, csq.length());
    }
    
    @Override
    public FString append(CharSequence csq, final int start, final int end) {
        if (csq == null) {
            csq = "null";
        }
        final int len = end - start;
        final int sz = this.size();
        this.addSpace(sz, len);
        final char[] d = this.data;
        if (csq instanceof String) {
            ((String)csq).getChars(start, end, d, sz);
        }
        else if (csq instanceof CharSeq) {
            ((CharSeq)csq).getChars(start, end, d, sz);
        }
        else {
            int j = sz;
            for (int i = start; i < end; ++i) {
                d[j++] = csq.charAt(i);
            }
        }
        return this;
    }
    
    public FString append(final Object obj) {
        if (obj instanceof Char) {
            this.appendCharacter(((Char)obj).intValue());
        }
        else if (obj instanceof Character) {
            this.appendCharacter((char)obj);
        }
        else {
            this.append(obj.toString());
        }
        return this;
    }
    
    @Override
    public void writeTo(int start, int count, final Appendable dest) throws IOException {
        if (dest instanceof Writer) {
            final Writer wr = (Writer)dest;
            while (count > 0) {
                final long result = this.getSegment(start);
                final int where = (int)result;
                int size = (int)(result >> 32);
                if (size > count) {
                    size = count;
                }
                wr.write(this.data, where, size);
                start += size;
                count -= size;
            }
        }
        else {
            dest.append(this, start, start + count);
        }
    }
    
    @Override
    public void writeTo(final Appendable dest) throws IOException {
        this.writeTo(0, this.size(), dest);
    }
}
