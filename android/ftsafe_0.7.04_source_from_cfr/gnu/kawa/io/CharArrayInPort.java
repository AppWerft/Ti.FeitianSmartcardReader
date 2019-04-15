/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.io.InPort;
import gnu.kawa.io.NullReader;
import gnu.kawa.io.Path;
import gnu.lists.AbstractCharVector;
import gnu.lists.CharSeq;
import gnu.lists.FString;
import java.io.IOException;
import java.io.Reader;

public class CharArrayInPort
extends InPort {
    static final Path stringPath = Path.valueOf("<string>");
    private AbstractCharVector string;
    int limitIndex;
    int start;
    int end;

    public static CharArrayInPort make(CharSequence seq) {
        if (seq instanceof FString) {
            return ((FString)seq).openReader(0, seq.length());
        }
        return CharArrayInPort.make(seq, "");
    }

    public static CharArrayInPort make(CharSequence seq, CharSequence suffix) {
        int i;
        int len1 = seq.length();
        int len2 = suffix.length();
        char[] buf = new char[len1 + len2];
        if (seq instanceof String) {
            ((String)seq).getChars(0, len1, buf, 0);
        } else if (!(seq instanceof CharSeq)) {
            i = len1;
            while (--i >= 0) {
                buf[i] = seq.charAt(i);
            }
        } else {
            ((CharSeq)seq).getChars(0, len1, buf, 0);
        }
        i = len2;
        while (--i >= 0) {
            buf[i + len1] = suffix.charAt(i);
        }
        return new CharArrayInPort(buf, len1 + len2);
    }

    public CharArrayInPort(char[] buffer, int len) {
        super(NullReader.nullReader, stringPath);
        try {
            this.setBuffer(buffer);
        }
        catch (IOException ex) {
            throw new Error(ex.toString());
        }
        this.limit = len;
    }

    public CharArrayInPort(char[] buffer) {
        this(buffer, buffer.length);
    }

    public CharArrayInPort(String string) {
        this(string.toCharArray());
    }

    public CharArrayInPort(AbstractCharVector string, char[] buffer, int start, int end) {
        this(buffer, 0);
        this.string = string;
        this.start = start;
        this.end = end;
        this.limitIndex = start;
    }

    @Override
    protected int fill(int len) throws IOException {
        if (this.string != null) {
            long result = this.string.getSegment(this.limitIndex);
            int where = (int)result;
            int size = (int)(result >> 32);
            if (size <= 0) {
                return -1;
            }
            this.limitIndex += size;
            if (this.limitIndex > this.end) {
                size -= this.limitIndex - this.end;
                this.limitIndex = this.end;
            }
            this.limit = this.pos = where;
            return size;
        }
        return -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void mark(int readAheadLimit) {
        Object object2 = this.lock;
        synchronized (object2) {
            super.mark(readAheadLimit);
        }
    }

    @Override
    public void reset() throws IOException {
        super.reset();
    }
}

