// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.io.IOException;
import java.io.Reader;
import gnu.lists.CharSeq;
import gnu.lists.FString;
import gnu.lists.AbstractCharVector;

public class CharArrayInPort extends InPort
{
    static final Path stringPath;
    private AbstractCharVector string;
    int limitIndex;
    int start;
    int end;
    
    public static CharArrayInPort make(final CharSequence seq) {
        if (seq instanceof FString) {
            return ((FString)seq).openReader(0, seq.length());
        }
        return make(seq, "");
    }
    
    public static CharArrayInPort make(final CharSequence seq, final CharSequence suffix) {
        final int len1 = seq.length();
        final int len2 = suffix.length();
        final char[] buf = new char[len1 + len2];
        if (seq instanceof String) {
            ((String)seq).getChars(0, len1, buf, 0);
        }
        else if (!(seq instanceof CharSeq)) {
            int i = len1;
            while (--i >= 0) {
                buf[i] = seq.charAt(i);
            }
        }
        else {
            ((CharSeq)seq).getChars(0, len1, buf, 0);
        }
        int i = len2;
        while (--i >= 0) {
            buf[i + len1] = suffix.charAt(i);
        }
        return new CharArrayInPort(buf, len1 + len2);
    }
    
    public CharArrayInPort(final char[] buffer, final int len) {
        super(NullReader.nullReader, CharArrayInPort.stringPath);
        try {
            this.setBuffer(buffer);
        }
        catch (IOException ex) {
            throw new Error(ex.toString());
        }
        this.limit = len;
    }
    
    public CharArrayInPort(final char[] buffer) {
        this(buffer, buffer.length);
    }
    
    public CharArrayInPort(final String string) {
        this(string.toCharArray());
    }
    
    public CharArrayInPort(final AbstractCharVector string, final char[] buffer, final int start, final int end) {
        this(buffer, 0);
        this.string = string;
        this.start = start;
        this.end = end;
        this.limitIndex = start;
    }
    
    @Override
    protected int fill(final int len) throws IOException {
        if (this.string == null) {
            return -1;
        }
        final long result = this.string.getSegment(this.limitIndex);
        final int where = (int)result;
        int size = (int)(result >> 32);
        if (size <= 0) {
            return -1;
        }
        this.limitIndex += size;
        if (this.limitIndex > this.end) {
            size -= this.limitIndex - this.end;
            this.limitIndex = this.end;
        }
        this.pos = where;
        this.limit = this.pos;
        return size;
    }
    
    @Override
    public void mark(final int readAheadLimit) {
        synchronized (this.lock) {
            super.mark(readAheadLimit);
        }
    }
    
    @Override
    public void reset() throws IOException {
        super.reset();
    }
    
    static {
        stringPath = Path.valueOf("<string>");
    }
}
