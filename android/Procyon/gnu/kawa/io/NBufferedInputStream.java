// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.io.InputStream;

public class NBufferedInputStream extends InputStream
{
    InputStream base;
    byte[] barr;
    ByteBuffer bbuf;
    
    public NBufferedInputStream(final InputStream base) {
        this.base = base;
        this.barr = new byte[8192];
        this.bbuf = ByteBuffer.wrap(this.barr, 0, 0);
    }
    
    public NBufferedInputStream(final byte[] buffer, final int length) {
        this.barr = buffer;
        this.bbuf = ByteBuffer.wrap(buffer, 0, length);
    }
    
    public synchronized int peek() throws IOException {
        final int r = this.read();
        if (r >= 0) {
            this.bbuf.position(this.bbuf.position() - 1);
        }
        return r;
    }
    
    @Override
    public synchronized int read() throws IOException {
        if (!this.bbuf.hasRemaining()) {
            final int n = this.fillBytes();
            if (n <= 0) {
                return -1;
            }
        }
        return this.bbuf.get() & 0xFF;
    }
    
    @Override
    public synchronized int read(final byte[] buf, final int offset, int count) throws IOException {
        int remaining = this.bbuf.remaining();
        if (remaining == 0) {
            final int n = this.fillBytes();
            if (n <= 0) {
                return -1;
            }
            remaining = this.bbuf.remaining();
        }
        if (count > remaining) {
            count = remaining;
        }
        this.bbuf.get(buf, offset, count);
        return count;
    }
    
    synchronized int fillBytes() throws IOException {
        if (this.base == null) {
            return -1;
        }
        int wpos = this.bbuf.limit();
        int avail = this.bbuf.capacity() - wpos;
        if (avail == 0) {
            this.bbuf.compact();
            this.bbuf.flip();
            wpos = this.bbuf.limit();
            avail = this.bbuf.capacity() - wpos;
        }
        final int n = this.base.read(this.barr, wpos, avail);
        this.bbuf.limit(wpos + ((n < 0) ? 0 : n));
        return n;
    }
    
    public synchronized boolean ready() throws IOException {
        return this.bbuf.hasRemaining() || (this.base != null && this.base.available() > 0);
    }
    
    @Override
    public synchronized int available() throws IOException {
        return this.bbuf.remaining() + ((this.base == null) ? 0 : this.base.available());
    }
    
    @Override
    public boolean markSupported() {
        return true;
    }
    
    @Override
    public synchronized void mark(final int readLimit) {
        if (readLimit > this.bbuf.capacity() - this.bbuf.position()) {
            this.bbuf.compact();
            this.bbuf.flip();
            if (readLimit > this.barr.length) {
                final byte[] tmp = new byte[readLimit];
                System.arraycopy(this.barr, 0, tmp, 0, this.barr.length);
                this.barr = tmp;
                this.bbuf = ByteBuffer.wrap(tmp, 0, this.bbuf.limit());
            }
        }
        this.bbuf.mark();
    }
    
    @Override
    public synchronized void reset() throws IOException {
        this.bbuf.reset();
    }
    
    public String checkByteOrderMark() throws IOException {
        final int b1 = this.read();
        final int b2 = (b1 < 0) ? -1 : this.read();
        final int b3 = (b2 < 0) ? -1 : this.read();
        final int b4 = (b3 < 0) ? -1 : this.read();
        if (b1 == 239 && b2 == 187 && b3 == 191) {
            this.bbuf.position(3);
            return "UTF-8";
        }
        if (b1 == 255 && b2 == 254 && b3 != 0) {
            this.bbuf.position(2);
            return "UTF-16LE";
        }
        if (b1 == 254 && b2 == 255 && b3 != 0) {
            this.bbuf.position(2);
            return "UTF-16BE";
        }
        this.bbuf.position(0);
        return null;
    }
}
