// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.servlet;

import java.io.IOException;
import java.io.OutputStream;

class HttpOutputStream extends OutputStream
{
    HttpRequestContext context;
    byte[] buffer;
    OutputStream out;
    int count;
    
    public HttpOutputStream(final HttpRequestContext context, final int bufSize) {
        this.context = context;
        this.buffer = new byte[bufSize];
    }
    
    @Override
    public void write(final int b) throws IOException {
        if (this.count >= this.buffer.length) {
            this.flush();
        }
        this.buffer[this.count++] = (byte)b;
    }
    
    @Override
    public void write(final byte[] data, int offset, int length) throws IOException {
        for (int avail = this.buffer.length - this.count; length > avail; length -= avail, avail = this.buffer.length) {
            System.arraycopy(data, offset, this.buffer, this.count, avail);
            this.count += avail;
            this.flush();
            offset += avail;
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
    
    void maybeSendResponseHeaders(final int count) throws IOException {
        final int statusCode = this.context.statusCode;
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
