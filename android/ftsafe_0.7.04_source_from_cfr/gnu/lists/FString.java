/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AbstractCharVector;
import gnu.lists.CharSeq;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.Sequence;
import gnu.lists.Sequences;
import gnu.lists.SimpleVector;
import gnu.lists.Strings;
import gnu.text.Char;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

public class FString
extends AbstractCharVector<Char>
implements Appendable,
CharSeq,
Consumable {
    public FString() {
        this.data = empty;
    }

    public FString(int num) {
        this.data = new char[num];
    }

    public FString(int num, int value) {
        this.data = new char[value < 65536 ? num : 2 * num];
        this.insertRepeatedRaw(0, value, num);
    }

    public FString(char[] values) {
        this.data = values;
    }

    public FString(String str) {
        this.data = str.toCharArray();
    }

    public FString(StringBuilder buffer) {
        this(buffer, 0, buffer.length());
    }

    public FString(StringBuilder buffer, int offset, int length) {
        this.data = new char[length];
        if (length > 0) {
            buffer.getChars(offset, offset + length, this.data, 0);
        }
    }

    public FString(StringBuffer buffer) {
        this(buffer, 0, buffer.length());
    }

    public FString(StringBuffer buffer, int offset, int length) {
        this.data = new char[length];
        if (length > 0) {
            buffer.getChars(offset, offset + length, this.data, 0);
        }
    }

    public FString(char[] buffer, int offset, int length) {
        this.data = new char[length];
        System.arraycopy(buffer, offset, this.data, 0, length);
    }

    public FString(Sequence seq) {
        this.data = new char[seq.size()];
        this.addAll(seq);
    }

    public FString(CharSequence seq) {
        this(seq, 0, seq.length());
    }

    public FString(CharSequence seq, int offset, int length) {
        char[] data = new char[length];
        if (seq instanceof CharSeq) {
            ((CharSeq)seq).getChars(offset, offset + length, data, 0);
        } else if (seq instanceof String) {
            ((String)seq).getChars(offset, offset + length, data, 0);
        } else {
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
        FString str = new FString(sz);
        str.setGapBounds(0, sz);
        return str;
    }

    @Override
    public final Char getRaw(int index) {
        throw this.unsupported("getRaw " + index);
    }

    @Override
    public final Char get(int index) {
        return Char.valueOf(this.characterAt(index));
    }

    public int indexOf(int ch, int fromChar) {
        char c2;
        char c1;
        if (ch >= 65536) {
            c1 = (char)((ch - 65536 >> 10) + 55296);
            c2 = (char)((ch & 1023) + 56320);
        } else {
            c1 = '\u0000';
            c2 = (char)ch;
        }
        int sz = this.size();
        char prev = '\u0000';
        for (int i = fromChar; i < sz; ++i) {
            char cur = this.charAt(i);
            if (cur == c2) {
                if (c1 == '\u0000') {
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

    public int lastIndexOf(int ch, int fromChar) {
        char c2;
        char c1;
        if (ch >= 65536) {
            c1 = (char)((ch - 65536 >> 10) + 55296);
            c2 = (char)((ch & 1023) + 56320);
        } else {
            c1 = '\u0000';
            c2 = (char)ch;
        }
        int i = fromChar;
        while (--i >= 0) {
            if (this.charAt(i) != c2) continue;
            if (c1 == '\u0000') {
                return i;
            }
            if (i <= 0 || this.charAt(i - 1) != c1) continue;
            return i - 1;
        }
        return -1;
    }

    @Override
    public Char set(int index, Char value) {
        this.checkCanWrite();
        Char old = Char.valueOf(this.characterAt(index));
        this.setCharacterAt(index, value.intValue());
        return old;
    }

    @Override
    public final void setRaw(int index, Char value) {
        this.setCharacterAt(index, value.intValue());
    }

    public final int characterAt(int index) {
        return Strings.characterAt(this, 0, this.size(), index);
    }

    public char[] toCharArray() {
        if (this.isVerySimple()) {
            return this.data;
        }
        int seq_length = this.size();
        char[] arr = new char[seq_length];
        for (int i = 0; i < seq_length; ++i) {
            arr[i] = this.charAt(i);
        }
        return arr;
    }

    @Override
    public void shift(int srcStart, int dstStart, int count) {
        System.arraycopy(this.data, srcStart, this.data, dstStart, count);
    }

    public FString copy(int start, int end) {
        char[] copy = new char[end - start];
        char[] src = this.data;
        for (int i = start; i < end; ++i) {
            copy[i - start] = src[i];
        }
        return new FString(copy);
    }

    public boolean addAll(CharSequence s) {
        int ssize = s.length();
        int sz = this.size();
        this.addSpace(sz, ssize);
        if (s instanceof String) {
            ((String)s).getChars(0, ssize, this.data, sz);
        } else if (s instanceof CharSeq) {
            ((CharSeq)s).getChars(0, ssize, this.data, sz);
        } else {
            int i = ssize;
            while (--i >= 0) {
                this.data[sz + i] = s.charAt(i);
            }
        }
        return ssize > 0;
    }

    public void insert(int where, int ch, boolean beforeMarkers) {
        char c2;
        char c1;
        int len;
        if (ch >= 65536) {
            c1 = (char)((ch - 65536 >> 10) + 55296);
            c2 = (char)((ch & 1023) + 56320);
            len = 2;
        } else {
            c1 = (char)ch;
            c2 = '\u0000';
            len = 1;
        }
        this.addSpace(where, len);
        this.data[where] = c1;
        if (c2 > '\u0000') {
            this.data[where + 1] = c2;
        }
    }

    public void insert(int where, String str, boolean beforeMarkers) {
        int len = str.length();
        this.addSpace(where, len);
        str.getChars(0, len, this.data, where);
    }

    public void addAllStrings(Object[] args, int startIndex) {
        int i;
        int sz = this.size();
        int count = 0;
        for (i = startIndex; i < args.length; ++i) {
            Object arg = args[i];
            count += ((CharSequence)arg).length();
        }
        this.gapReserve(sz, count);
        for (i = startIndex; i < args.length; ++i) {
            this.addAll((CharSequence)args[i]);
        }
    }

    @Override
    public String toString() {
        return this.substring(0, this.size());
    }

    public String substring(int start, int end) {
        if (this.isVerySimple()) {
            return new String(this.data, start, end - start);
        }
        return new StringBuilder().append(this, start, end).toString();
    }

    @Override
    public CharSeq subSequence(int start, int end) {
        return new FString(this, start, end - start);
    }

    @Override
    public void setCharAt(int index, char ch) {
        this.checkCanWrite();
        this.data[this.effectiveIndex((int)index)] = ch;
    }

    @Override
    public void setCharacterAt(int index, int ch) {
        boolean oldIsSupp;
        char old2;
        int sz = this.size();
        if (index < 0 || index >= sz) {
            throw new StringIndexOutOfBoundsException(index);
        }
        char old1 = this.charAt(index);
        boolean bl = oldIsSupp = old1 >= '\ud800' && old1 <= '\udbff' && index + 1 < sz && (old2 = this.charAt(index + 1)) >= '\udc00' && old2 <= '\udfff';
        if (ch <= 65535) {
            if (oldIsSupp) {
                this.delete(index + 1, index + 2);
            }
            this.setCharAt(index, (char)ch);
        } else {
            char c1 = (char)((ch - 65536 >> 10) + 55296);
            char c2 = (char)((ch & 1023) + 56320);
            this.setCharAt(index, c1);
            if (oldIsSupp) {
                this.setCharAt(index + 1, c2);
            } else {
                this.insert(index + 1, c2, true);
            }
        }
    }

    public void replace(CharSequence src, int srcStart, int srcEnd, int dstStart, int dstEnd) {
        int sstart;
        FString fsrc;
        if (dstStart < 0 || dstStart > dstEnd || dstEnd > this.length() || srcStart < 0 || srcStart > srcEnd || srcEnd > src.length()) {
            throw new StringIndexOutOfBoundsException();
        }
        int srcLength = srcEnd - srcStart;
        int dstLength = dstEnd - dstStart;
        int grow = srcLength - dstLength;
        if (grow > 0) {
            this.gapReserve(dstEnd, grow);
        }
        if (src instanceof FString && (sstart = (fsrc = (FString)src).getSegmentReadOnly(srcStart, srcLength)) >= 0) {
            System.arraycopy(fsrc.data, sstart, this.data, dstStart, srcLength);
            if (grow < 0) {
                this.delete(dstEnd + grow, dstEnd);
            } else if (grow > 0) {
                this.setGapBounds(this.getGapStart() + grow, this.getGapEnd());
            }
            return;
        }
        if (!Sequences.copyInPlaceIsSafe(this, src)) {
            src = ((Object)src.subSequence(srcStart, srcEnd)).toString();
            srcEnd = srcLength;
            srcStart = 0;
        }
        if (grow < 0) {
            this.delete(dstEnd + grow, dstEnd);
        } else if (grow > 0) {
            this.setGapBounds(this.getGapStart() + grow, this.getGapEnd());
        }
        int i = dstStart;
        for (int j = srcStart; j < srcEnd; ++j) {
            this.data[i] = src.charAt(j);
            ++i;
        }
    }

    public void setCharAtBuffer(int index, char ch) {
        this.data[index] = ch;
    }

    @Override
    public final void fill(char ch) {
        this.fill(0, this.size(), ch);
    }

    @Override
    public void fill(int fromIndex, int toIndex, char value) {
        if (fromIndex < 0 || toIndex > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        if (this.isVerySimple()) {
            char[] d = this.data;
            for (int i = fromIndex; i < toIndex; ++i) {
                d[i] = value;
            }
        } else {
            for (int i = fromIndex; i < toIndex; ++i) {
                this.setCharAt(i, value);
            }
        }
    }

    public void insertRepeated(int where, int value, int count) {
        this.addSpace(where, value < 65536 ? count : 2 * count);
        this.insertRepeatedRaw(where, value, count);
    }

    private void insertRepeatedRaw(int where, int value, int count) {
        char c2;
        char c1;
        int len;
        if (value >= 65536) {
            c1 = (char)((value - 65536 >> 10) + 55296);
            c2 = (char)((value & 1023) + 56320);
            len = 2 * count;
        } else {
            c1 = (char)value;
            c2 = '\u0000';
            len = count;
        }
        char[] array = this.data;
        int end = where + len;
        int i = where;
        while (i < end) {
            array[i++] = c1;
            if (c2 == '\u0000') continue;
            array[where + i++] = c2;
        }
    }

    public void replace(int where, char[] chars, int start, int count) {
        System.arraycopy(chars, start, this.data, where, count);
    }

    public void replace(int where, String string) {
        string.getChars(0, string.length(), this.data, where);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FString && FString.equals(this, (FString)obj);
    }

    @Override
    protected FString newInstance(int newLength) {
        return new FString(newLength < 0 ? this.data : new char[newLength]);
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
    public void consume(Consumer out) {
        out.write(this.data, 0, this.data.length);
    }

    @Override
    public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
        int size;
        if (out.ignoring()) {
            return;
        }
        int end = this.nextIndex(iposEnd);
        for (int i = this.nextIndex((int)iposStart); i < end; i += size) {
            long result = this.getSegment(i);
            int where = (int)result;
            size = (int)(result >> 32);
            out.write(this.data, where, size);
        }
    }

    @Override
    public FString append(char c) {
        int sz = this.size();
        this.addSpace(sz, 1);
        char[] d = this.data;
        d[sz] = c;
        return this;
    }

    public FString appendCharacter(int c) {
        int delta;
        if (c < 65536) {
            delta = 1;
        } else {
            if (c == 2097151) {
                return this;
            }
            delta = 2;
        }
        int sz = this.size();
        this.addSpace(sz, delta);
        char[] d = this.data;
        if (delta > 1) {
            d[sz++] = (char)((c - 65536 >> 10) + 55296);
            c = (c & 1023) + 56320;
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
    public FString append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        int len = end - start;
        int sz = this.size();
        this.addSpace(sz, len);
        char[] d = this.data;
        if (csq instanceof String) {
            ((String)csq).getChars(start, end, d, sz);
        } else if (csq instanceof CharSeq) {
            ((CharSeq)csq).getChars(start, end, d, sz);
        } else {
            int j = sz;
            for (int i = start; i < end; ++i) {
                d[j++] = csq.charAt(i);
            }
        }
        return this;
    }

    public FString append(Object obj) {
        if (obj instanceof Char) {
            this.appendCharacter(((Char)obj).intValue());
        } else if (obj instanceof Character) {
            this.appendCharacter(((Character)obj).charValue());
        } else {
            this.append(obj.toString());
        }
        return this;
    }

    @Override
    public void writeTo(int start, int count, Appendable dest) throws IOException {
        if (dest instanceof Writer) {
            Writer wr = (Writer)dest;
            while (count > 0) {
                long result = this.getSegment(start);
                int where = (int)result;
                int size = (int)(result >> 32);
                if (size > count) {
                    size = count;
                }
                wr.write(this.data, where, size);
                start += size;
                count -= size;
            }
        } else {
            dest.append(this, start, start + count);
        }
    }

    @Override
    public void writeTo(Appendable dest) throws IOException {
        this.writeTo(0, this.size(), dest);
    }
}

