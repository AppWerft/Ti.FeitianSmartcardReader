/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.lists.CharSeq;
import java.io.IOException;
import java.io.Reader;

public class QueueReader
extends Reader
implements Appendable {
    char[] buffer;
    int readAheadLimit;
    int mark;
    int pos;
    int limit;
    boolean EOFseen;

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public synchronized void mark(int readAheadLimit) {
        this.readAheadLimit = readAheadLimit;
        this.mark = this.pos;
    }

    @Override
    public synchronized void reset() {
        if (this.readAheadLimit > 0) {
            this.pos = this.mark;
        }
    }

    void resize(int len) {
        int cur_size = this.limit - this.pos;
        if (this.readAheadLimit > 0 && this.pos - this.mark <= this.readAheadLimit) {
            cur_size = this.limit - this.mark;
        } else {
            this.mark = this.pos;
        }
        char[] new_buffer = this.buffer.length < cur_size + len ? new char[2 * cur_size + len] : this.buffer;
        System.arraycopy(this.buffer, this.mark, new_buffer, 0, cur_size);
        this.buffer = new_buffer;
        this.pos -= this.mark;
        this.mark = 0;
        this.limit = cur_size;
    }

    @Override
    public QueueReader append(CharSequence csq) {
        if (csq == null) {
            csq = "null";
        }
        return this.append(csq, 0, csq.length());
    }

    @Override
    public synchronized QueueReader append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        int len = end - start;
        this.reserveSpace(len);
        int sz = this.limit;
        char[] d = this.buffer;
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
        this.limit = sz + len;
        this.notifyAll();
        return this;
    }

    public void append(char[] chars) {
        this.append(chars, 0, chars.length);
    }

    public synchronized void append(char[] chars, int off, int len) {
        this.reserveSpace(len);
        System.arraycopy(chars, off, this.buffer, this.limit, len);
        this.limit += len;
        this.notifyAll();
    }

    @Override
    public synchronized QueueReader append(char ch) {
        this.reserveSpace(1);
        this.buffer[this.limit++] = ch;
        this.notifyAll();
        return this;
    }

    public synchronized void appendEOF() {
        this.EOFseen = true;
        this.notifyAll();
    }

    protected void reserveSpace(int len) {
        if (this.buffer == null) {
            this.buffer = new char[100 + len];
        } else if (this.buffer.length < this.limit + len) {
            this.resize(len);
        }
    }

    @Override
    public synchronized boolean ready() {
        return this.pos < this.limit || this.EOFseen;
    }

    public void checkAvailable() {
    }

    @Override
    public synchronized int read() {
        while (this.pos >= this.limit) {
            if (this.EOFseen) {
                return -1;
            }
            this.checkAvailable();
            try {
                this.wait();
            }
            catch (InterruptedException ex) {}
        }
        char ch = this.buffer[this.pos++];
        return ch;
    }

    @Override
    public synchronized int read(char[] cbuf, int off, int len) {
        if (len == 0) {
            return 0;
        }
        while (this.pos >= this.limit) {
            if (this.EOFseen) {
                return -1;
            }
            this.checkAvailable();
            try {
                this.wait();
            }
            catch (InterruptedException ex) {}
        }
        int avail = this.limit - this.pos;
        if (len > avail) {
            len = avail;
        }
        System.arraycopy(this.buffer, this.pos, cbuf, off, len);
        this.pos += len;
        return len;
    }

    @Override
    public synchronized void close() {
        this.pos = 0;
        this.limit = 0;
        this.mark = 0;
        this.EOFseen = true;
        this.buffer = null;
    }
}

