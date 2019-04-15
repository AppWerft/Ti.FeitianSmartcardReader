/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.PrimIntegerVector;
import gnu.lists.Strings;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class ByteVector<E>
extends PrimIntegerVector<E> {
    byte[] data;
    protected static byte[] empty = new byte[0];

    @Override
    public int getBufferLength() {
        return this.data.length;
    }

    @Override
    public void copyBuffer(int length) {
        int oldLength = this.data.length;
        if (length == -1) {
            length = oldLength;
        }
        if (oldLength != length) {
            byte[] tmp = new byte[length];
            System.arraycopy(this.data, 0, tmp, 0, oldLength < length ? oldLength : length);
            this.data = tmp;
        }
    }

    public byte[] getBuffer() {
        return this.data;
    }

    @Override
    protected void setBuffer(Object buffer) {
        this.data = (byte[])buffer;
    }

    public final byte getByte(int index) {
        return this.data[this.effectiveIndex(index)];
    }

    @Override
    public final byte getByteRaw(int index) {
        return this.data[index];
    }

    public final void setByte(int index, byte value) {
        this.checkCanWrite();
        this.data[this.effectiveIndex((int)index)] = value;
    }

    public final void setByteRaw(int index, byte value) {
        this.data[index] = value;
    }

    public void add(byte v) {
        int sz = this.size();
        this.addSpace(sz, 1);
        this.setByte(sz, v);
    }

    @Override
    protected void clearBuffer(int start, int count) {
        byte[] d = this.data;
        while (--count >= 0) {
            d[start++] = 0;
        }
    }

    public int readFrom(int start, int count, InputStream in) throws IOException {
        int pos = start;
        while (count > 0) {
            int n;
            long result = this.getSegment(pos);
            int where = (int)result;
            int size = (int)(result >> 32);
            if (size > count) {
                size = count;
            }
            if ((n = in.read(this.data, where, size)) < 0) {
                if (pos != start) break;
                return -1;
            }
            pos += n;
            count -= n;
        }
        return pos - start;
    }

    public void writeTo(OutputStream out) throws IOException {
        this.writeTo(0, this.size(), out);
    }

    public void writeTo(int start, int count, OutputStream out) throws IOException {
        while (count > 0) {
            long result = this.getSegment(start);
            int where = (int)result;
            int size = (int)(result >> 32);
            if (size > count) {
                size = count;
            }
            out.write(this.data, where, size);
            start += size;
            count -= size;
        }
    }

    public void copyFrom(int index, ByteVector src, int start, int end) {
        int dseg;
        int count = end - start;
        int sz = this.size();
        int src_sz = src.size();
        if (count < 0 || index + count > sz || end > src_sz) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int sseg = src.getSegmentReadOnly(start, count);
        if (sseg >= 0 && (dseg = this.getSegment(index, count)) >= 0) {
            System.arraycopy(src.data, sseg, this.data, dseg, count);
        } else {
            for (int i = 0; i < count; ++i) {
                this.setByte(index + i, src.getByte(start + i));
            }
        }
    }

    public InputStream getInputStream() {
        int sz = this.size();
        int seg = this.getSegmentReadOnly(0, sz);
        if (seg >= 0) {
            return new ByteArrayInputStream(this.data, seg, sz);
        }
        return new ByteVectorInputStream(this);
    }

    public String toUtf8(int start, int length) {
        byte[] buf;
        if (start + length > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        int seg = this.getSegmentReadOnly(start, length);
        if (seg >= 0) {
            buf = this.data;
            start = seg;
        } else {
            buf = new byte[length];
            for (int i = 0; i < length; ++i) {
                buf[i] = this.getByte(start + i);
            }
        }
        return Strings.toUtf8(buf, start, length);
    }

    static class ByteVectorInputStream
    extends InputStream {
        ByteVector bvec;
        int pos;
        int mark;
        int size;

        public ByteVectorInputStream(ByteVector bvec) {
            this.bvec = bvec;
            this.size = bvec.size();
        }

        @Override
        public int read() {
            return this.pos >= this.size ? -1 : 255 & this.bvec.getByte(this.pos++);
        }

        @Override
        public boolean markSupported() {
            return true;
        }

        @Override
        public void mark(int readLimit) {
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
            if (n < (long)(this.size - this.pos)) {
                this.pos = this.size;
                return this.size - this.pos;
            }
            this.pos = (int)((long)this.pos + n);
            return n;
        }
    }

}

