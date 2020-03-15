// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class ByteVector<E> extends PrimIntegerVector<E>
{
    byte[] data;
    protected static byte[] empty;
    
    @Override
    public int getBufferLength() {
        return this.data.length;
    }
    
    @Override
    public void copyBuffer(int length) {
        final int oldLength = this.data.length;
        if (length == -1) {
            length = oldLength;
        }
        if (oldLength != length) {
            final byte[] tmp = new byte[length];
            System.arraycopy(this.data, 0, tmp, 0, (oldLength < length) ? oldLength : length);
            this.data = tmp;
        }
    }
    
    public byte[] getBuffer() {
        return this.data;
    }
    
    @Override
    protected void setBuffer(final Object buffer) {
        this.data = (byte[])buffer;
    }
    
    public final byte getByte(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final byte getByteRaw(final int index) {
        return this.data[index];
    }
    
    public final void setByte(final int index, final byte value) {
        this.checkCanWrite();
        this.data[this.effectiveIndex(index)] = value;
    }
    
    public final void setByteRaw(final int index, final byte value) {
        this.data[index] = value;
    }
    
    public void add(final byte v) {
        final int sz = this.size();
        this.addSpace(sz, 1);
        this.setByte(sz, v);
    }
    
    @Override
    protected void clearBuffer(int start, int count) {
        final byte[] d = this.data;
        while (--count >= 0) {
            d[start++] = 0;
        }
    }
    
    public int readFrom(final int start, int count, final InputStream in) throws IOException {
        int pos = start;
        while (count > 0) {
            final long result = this.getSegment(pos);
            final int where = (int)result;
            int size = (int)(result >> 32);
            if (size > count) {
                size = count;
            }
            final int n = in.read(this.data, where, size);
            if (n < 0) {
                if (pos == start) {
                    return -1;
                }
                break;
            }
            else {
                pos += n;
                count -= n;
            }
        }
        return pos - start;
    }
    
    public void writeTo(final OutputStream out) throws IOException {
        this.writeTo(0, this.size(), out);
    }
    
    public void writeTo(int start, int count, final OutputStream out) throws IOException {
        while (count > 0) {
            final long result = this.getSegment(start);
            final int where = (int)result;
            int size = (int)(result >> 32);
            if (size > count) {
                size = count;
            }
            out.write(this.data, where, size);
            start += size;
            count -= size;
        }
    }
    
    public void copyFrom(final int index, final ByteVector src, final int start, final int end) {
        final int count = end - start;
        final int sz = this.size();
        final int src_sz = src.size();
        if (count < 0 || index + count > sz || end > src_sz) {
            throw new ArrayIndexOutOfBoundsException();
        }
        final int sseg;
        final int dseg;
        if ((sseg = src.getSegmentReadOnly(start, count)) >= 0 && (dseg = this.getSegment(index, count)) >= 0) {
            System.arraycopy(src.data, sseg, this.data, dseg, count);
        }
        else {
            for (int i = 0; i < count; ++i) {
                this.setByte(index + i, src.getByte(start + i));
            }
        }
    }
    
    public InputStream getInputStream() {
        final int sz = this.size();
        final int seg = this.getSegmentReadOnly(0, sz);
        if (seg >= 0) {
            return new ByteArrayInputStream(this.data, seg, sz);
        }
        return new ByteVectorInputStream(this);
    }
    
    public String toUtf8(int start, final int length) {
        if (start + length > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        final int seg = this.getSegmentReadOnly(start, length);
        byte[] buf;
        if (seg >= 0) {
            buf = this.data;
            start = seg;
        }
        else {
            buf = new byte[length];
            for (int i = 0; i < length; ++i) {
                buf[i] = this.getByte(start + i);
            }
        }
        return Strings.toUtf8(buf, start, length);
    }
    
    static {
        ByteVector.empty = new byte[0];
    }
    
    static class ByteVectorInputStream extends InputStream
    {
        ByteVector bvec;
        int pos;
        int mark;
        int size;
        
        public ByteVectorInputStream(final ByteVector bvec) {
            this.bvec = bvec;
            this.size = bvec.size();
        }
        
        @Override
        public int read() {
            return (this.pos >= this.size) ? -1 : (0xFF & this.bvec.getByte(this.pos++));
        }
        
        @Override
        public boolean markSupported() {
            return true;
        }
        
        @Override
        public void mark(final int readLimit) {
            this.mark = this.pos;
        }
        
        @Override
        public void reset() {
            this.pos = this.mark;
        }
        
        @Override
        public void close() {
        }
        
        @Override
        public int available() {
            return this.size - this.pos;
        }
        
        @Override
        public long skip(long n) {
            if (n < 0L) {
                n = 0L;
            }
            if (n < this.size - this.pos) {
                this.pos = this.size;
                return this.size - this.pos;
            }
            this.pos += (int)n;
            return n;
        }
    }
}
