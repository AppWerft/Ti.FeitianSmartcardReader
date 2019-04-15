/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.servlet;

import gnu.kawa.servlet.HttpRequestContext;
import java.io.IOException;
import java.io.OutputStream;

class HttpOutputStream
extends OutputStream {
    HttpRequestContext context;
    byte[] buffer;
    OutputStream out;
    int count;

    public HttpOutputStream(HttpRequestContext context, int bufSize) {
        this.context = context;
        this.buffer = new byte[bufSize];
    }

    @Override
    public void write(int b) throws IOException {
        if (this.count >= this.buffer.length) {
            this.flush();
        }
        this.buffer[this.count++] = (byte)b;
    }

    @Override
    public void write(byte[] data, int offset, int length) throws IOException {
        int avail = this.buffer.length - this.count;
        while (length > avail) {
            System.arraycopy(data, offset, this.buffer, this.count, avail);
            this.count += avail;
            this.flush();
            offset += avail;
            length -= avail;
            avail = this.buffer.length;
        }
        if (length > 0) {
            System.arraycopy(data, offset, this.buffer, this.count, length);
            this.count += length;
        }
    }

    public boolean reset() {
        this.count = 0;
        return this.out == null;
    }

    @Override
    public void flush() throws IOException {
        if (this.out == null) {
            this.maybeSendResponseHeaders(-1);
            this.out = this.context.getResponseStream();
        }
        if (this.count > 0) {
            this.out.write(this.buffer, 0, this.count);
            this.count = 0;
        }
    }

    void maybeSendResponseHeaders(int count) throws IOException {
        int statusCode = this.context.statusCode;
        if (statusCode != -999) {
            this.context.sendResponseHeaders(statusCode, this.context.statusReasonPhrase, count);
            this.context.statusCode = -999;
        }
    }

    @Override
    public void close() throws IOException {
        if (this.out == null) {
            this.maybeSendResponseHeaders(this.count);
            this.out = this.context.getResponseStream();
        }
        this.flush();
        this.out.close();
    }
}

