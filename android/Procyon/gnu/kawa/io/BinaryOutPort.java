// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.io.Writer;
import java.io.OutputStream;

public class BinaryOutPort extends OutPort
{
    OutputStream strm;
    
    public OutputStream getOutputStream() {
        this.flushBuffer();
        return this.strm;
    }
    
    public BinaryOutPort(final OutputStream strm, final Path path) {
        this(strm, new OutputStreamWriterSimple(strm, false), path);
    }
    
    public BinaryOutPort(final OutputStream strm, final Writer out, final Path path, final boolean printPretty, final boolean autoflush) {
        super(out, printPretty, autoflush, path);
        this.strm = strm;
    }
    
    private BinaryOutPort(final OutputStream strm, final Writer out, final Path path) {
        super(out, path);
        this.strm = strm;
    }
    
    private static Writer makeConvertWriter(final MyBufferedOutputStream strm, final Charset conv) {
        final String cname = conv.name();
        final boolean isUtf8 = "UTF-8".equals(cname);
        if (isUtf8 || "ISO_8859_1".equals(cname)) {
            return new OutputStreamWriterSimple(strm, isUtf8);
        }
        return new OutputStreamWriter(strm, conv);
    }
    
    public static BinaryOutPort makeStandardPort(final OutputStream strm, final String path) {
        final MyBufferedOutputStream bufstrm = new MyBufferedOutputStream(strm);
        final Writer wr = makeConvertWriter(bufstrm, Charset.defaultCharset());
        return new BinaryOutPort(bufstrm, new LogWriter(wr), Path.valueOf(path), true, true);
    }
    
    public static BinaryOutPort openFile(final OutputStream strm, final Path path, final Charset conv) {
        final MyBufferedOutputStream bufstrm = new MyBufferedOutputStream(strm);
        final Writer wr = makeConvertWriter(bufstrm, conv);
        return new BinaryOutPort(bufstrm, wr, path);
    }
    
    public static BinaryOutPort openFile(final Object fname) throws IOException {
        return (BinaryOutPort)OutPort.openFile(fname, Boolean.FALSE);
    }
    
    @Override
    void flushBuffer() {
        if (this.strm instanceof MyBufferedOutputStream) {
            final MyBufferedOutputStream mstr = (MyBufferedOutputStream)this.strm;
            mstr.disableFlush(true);
            try {
                this.flush();
            }
            finally {
                mstr.disableFlush(false);
            }
        }
        else {
            super.flushBuffer();
        }
    }
    
    public void writeBytes(final byte[] buf, final int off, final int len) throws IOException {
        this.flushBuffer();
        this.strm.write(buf, off, len);
    }
    
    public void writeByte(final int b) throws IOException {
        this.flushBuffer();
        this.strm.write(b);
    }
    
    public static OutputStream asOutputStream(final Object obj) {
        if (obj instanceof BinaryOutPort) {
            return ((BinaryOutPort)obj).getOutputStream();
        }
        return (OutputStream)obj;
    }
    
    static class MyBufferedOutputStream extends BufferedOutputStream
    {
        boolean flushDisabled;
        
        public MyBufferedOutputStream(final OutputStream out) {
            super(out);
        }
        
        public void disableFlush(final boolean flushDisabled) {
            this.flushDisabled = flushDisabled;
        }
        
        @Override
        public void flush() throws IOException {
            if (!this.flushDisabled) {
                super.flush();
            }
        }
    }
    
    public static class OutputStreamWriterSimple extends Writer
    {
        OutputStream strm;
        boolean utf8;
        int pendingHighSurrogate;
        
        public OutputStreamWriterSimple(final OutputStream strm, final boolean utf8) {
            super(strm);
            this.strm = strm;
            this.utf8 = utf8;
        }
        
        private void write1(int ch) throws IOException {
            if (ch <= (this.utf8 ? 127 : 255)) {
                this.strm.write(ch);
            }
            else if (!this.utf8) {
                this.strm.write(63);
            }
            else {
                int cont = 0;
                if (ch < 2047) {
                    this.strm.write(0xC0 | (ch >> 6 & 0x1F));
                    cont = 1;
                }
                else {
                    if (ch >= 55296 && ch <= 56319) {
                        this.pendingHighSurrogate = ch;
                        return;
                    }
                    if (ch >= 56320 && ch <= 57343 && this.pendingHighSurrogate > 0) {
                        ch = (this.pendingHighSurrogate - 55296) * 1024 + (ch - 56320) + 65536;
                        this.strm.write(0xF0 | (ch >> 18 & 0x7));
                        cont = 3;
                        this.pendingHighSurrogate = 0;
                    }
                    else {
                        this.strm.write(0xE0 | (ch >> 12 & 0xF));
                        cont = 2;
                    }
                }
                while (--cont >= 0) {
                    this.strm.write(0x80 | (ch >> 6 * cont & 0x3F));
                }
            }
        }
        
        @Override
        public void write(final int ch) throws IOException {
            synchronized (this.lock) {
                this.write1(ch);
            }
        }
        
        @Override
        public void write(final char[] cbuf, final int off, final int len) throws IOException {
            synchronized (this.lock) {
                for (int i = 0; i < len; ++i) {
                    final char ch = cbuf[off + i];
                    this.write1(ch);
                }
            }
        }
        
        @Override
        public void write(final String str, final int off, final int len) throws IOException {
            synchronized (this.lock) {
                for (int i = 0; i < len; ++i) {
                    final char ch = str.charAt(off + i);
                    this.write1(ch);
                }
            }
        }
        
        @Override
        public void flush() throws IOException {
            synchronized (this.lock) {
                this.strm.flush();
            }
        }
        
        @Override
        public void close() throws IOException {
            synchronized (this.lock) {
                this.strm.close();
            }
        }
    }
}
