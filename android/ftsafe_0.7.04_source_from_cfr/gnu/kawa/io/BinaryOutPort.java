/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.io.LogWriter;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class BinaryOutPort
extends OutPort {
    OutputStream strm;

    public OutputStream getOutputStream() {
        this.flushBuffer();
        return this.strm;
    }

    public BinaryOutPort(OutputStream strm, Path path) {
        this(strm, new OutputStreamWriterSimple(strm, false), path);
    }

    public BinaryOutPort(OutputStream strm, Writer out, Path path, boolean printPretty, boolean autoflush) {
        super(out, printPretty, autoflush, path);
        this.strm = strm;
    }

    private BinaryOutPort(OutputStream strm, Writer out, Path path) {
        super(out, path);
        this.strm = strm;
    }

    private static Writer makeConvertWriter(MyBufferedOutputStream strm, Charset conv) {
        String cname = conv.name();
        boolean isUtf8 = "UTF-8".equals(cname);
        if (isUtf8 || "ISO_8859_1".equals(cname)) {
            return new OutputStreamWriterSimple(strm, isUtf8);
        }
        return new OutputStreamWriter((OutputStream)strm, conv);
    }

    public static BinaryOutPort makeStandardPort(OutputStream strm, String path) {
        MyBufferedOutputStream bufstrm = new MyBufferedOutputStream(strm);
        Writer wr = BinaryOutPort.makeConvertWriter(bufstrm, Charset.defaultCharset());
        return new BinaryOutPort(bufstrm, new LogWriter(wr), Path.valueOf(path), true, true);
    }

    public static BinaryOutPort openFile(OutputStream strm, Path path, Charset conv) {
        MyBufferedOutputStream bufstrm = new MyBufferedOutputStream(strm);
        Writer wr = BinaryOutPort.makeConvertWriter(bufstrm, conv);
        return new BinaryOutPort(bufstrm, wr, path);
    }

    public static BinaryOutPort openFile(Object fname) throws IOException {
        return (BinaryOutPort)OutPort.openFile(fname, Boolean.FALSE);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    void flushBuffer() {
        if (this.strm instanceof MyBufferedOutputStream) {
            MyBufferedOutputStream mstr = (MyBufferedOutputStream)this.strm;
            mstr.disableFlush(true);
            try {
                this.flush();
            }
            finally {
                mstr.disableFlush(false);
            }
        } else {
            super.flushBuffer();
        }
    }

    public void writeBytes(byte[] buf, int off, int len) throws IOException {
        this.flushBuffer();
        this.strm.write(buf, off, len);
    }

    public void writeByte(int b) throws IOException {
        this.flushBuffer();
        this.strm.write(b);
    }

    public static OutputStream asOutputStream(Object obj) {
        if (obj instanceof BinaryOutPort) {
            return ((BinaryOutPort)obj).getOutputStream();
        }
        return (OutputStream)obj;
    }

    public static class OutputStreamWriterSimple
    extends Writer {
        OutputStream strm;
        boolean utf8;
        int pendingHighSurrogate;

        public OutputStreamWriterSimple(OutputStream strm, boolean utf8) {
            super(strm);
            this.strm = strm;
            this.utf8 = utf8;
        }

        private void write1(int ch) throws IOException {
            if (ch <= (this.utf8 ? 127 : 255)) {
                this.strm.write(ch);
            } else if (!this.utf8) {
                this.strm.write(63);
            } else {
                int cont = 0;
                if (ch < 2047) {
                    this.strm.write(192 | ch >> 6 & 31);
                    cont = 1;
                } else {
                    if (ch >= 55296 && ch <= 56319) {
                        this.pendingHighSurrogate = ch;
                        return;
                    }
                    if (ch >= 56320 && ch <= 57343 && this.pendingHighSurrogate > 0) {
                        ch = (this.pendingHighSurrogate - 55296) * 1024 + (ch - 56320) + 65536;
                        this.strm.write(240 | ch >> 18 & 7);
                        cont = 3;
                        this.pendingHighSurrogate = 0;
                    } else {
                        this.strm.write(224 | ch >> 12 & 15);
                        cont = 2;
                    }
                }
                while (--cont >= 0) {
                    this.strm.write(128 | ch >> 6 * cont & 63);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void write(int ch) throws IOException {
            Object object2 = this.lock;
            synchronized (object2) {
                this.write1(ch);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
            Object object2 = this.lock;
            synchronized (object2) {
                for (int i = 0; i < len; ++i) {
                    char ch = cbuf[off + i];
                    this.write1(ch);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void write(String str, int off, int len) throws IOException {
            Object object2 = this.lock;
            synchronized (object2) {
                for (int i = 0; i < len; ++i) {
                    char ch = str.charAt(off + i);
                    this.write1(ch);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void flush() throws IOException {
            Object object2 = this.lock;
            synchronized (object2) {
                this.strm.flush();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void close() throws IOException {
            Object object2 = this.lock;
            synchronized (object2) {
                this.strm.close();
            }
        }
    }

    static class MyBufferedOutputStream
    extends BufferedOutputStream {
        boolean flushDisabled;

        public MyBufferedOutputStream(OutputStream out) {
            super(out);
        }

        public void disableFlush(boolean flushDisabled) {
            this.flushDisabled = flushDisabled;
        }

        @Override
        public void flush() throws IOException {
            if (!this.flushDisabled) {
                super.flush();
            }
        }
    }

}

