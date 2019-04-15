/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.io.InPort;
import gnu.kawa.io.NBufferedInputStream;
import gnu.kawa.io.Path;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class BinaryInPort
extends InPort {
    private NBufferedInputStream bstrm;
    CharBuffer cbuf = null;
    Charset cset;
    CharsetDecoder decoder;
    Charset csetDefault;
    private boolean inEofSeen;

    public Charset getCharset() {
        return this.cset;
    }

    public void setCharset(Charset cset) {
        this.cset = cset;
        this.decoder = cset.newDecoder();
    }

    public void setCharset(String name) {
        Charset cset = Charset.forName(name);
        if (this.cset == null) {
            this.setCharset(cset);
        } else if (!cset.equals(this.cset)) {
            throw new RuntimeException("encoding " + name + " does not match previous " + this.cset);
        }
    }

    public void setDefaultCharset(Charset cset) {
        this.csetDefault = cset;
    }

    private BinaryInPort(NBufferedInputStream bstrm, Path path) {
        super(bstrm, path);
        this.bstrm = bstrm;
        this.setKeepFullLines(false);
    }

    public BinaryInPort(InputStream strm) {
        this(new NBufferedInputStream(strm), null);
    }

    public BinaryInPort(InputStream strm, Path path) {
        this(new NBufferedInputStream(strm), path);
    }

    public BinaryInPort(byte[] buffer, int length, Path path) {
        this(new NBufferedInputStream(buffer, length), path);
    }

    @Override
    public void setBuffer(char[] buffer) throws IOException {
        super.setBuffer(buffer);
        if (this.limit - this.pos + 2 < this.buffer.length) {
            throw new IOException("setBuffer - too short");
        }
    }

    public boolean setFromByteOrderMark() throws IOException {
        String enc = this.bstrm.checkByteOrderMark();
        if (enc == null) {
            return false;
        }
        this.setCharset(enc);
        return true;
    }

    public InputStream getInputStream() {
        return this.bstrm;
    }

    public void resetStart(int pos) throws IOException {
        this.bstrm.bbuf.position(pos);
    }

    @Override
    protected int fill(int len) throws IOException {
        int count;
        if (this.cset == null) {
            byte[] barr = this.bstrm.barr;
            ByteBuffer bbuf = this.bstrm.bbuf;
            int count2 = 0;
            int bpos = bbuf.position();
            int blim = bbuf.limit();
            do {
                byte b;
                if (count2 >= len) {
                    bbuf.position(bpos);
                    return count2;
                }
                if (bpos >= blim) {
                    bbuf.position(bpos);
                    if (count2 > 0) {
                        return count2;
                    }
                    int nb = this.bstrm.fillBytes();
                    if (nb < 0) {
                        return -1;
                    }
                    bpos = bbuf.position();
                    blim = bbuf.limit();
                }
                if ((b = barr[bpos]) < 0) break;
                this.buffer[this.pos + count2] = (char)b;
                ++bpos;
                ++count2;
            } while (true);
            if (count2 > 0) {
                bbuf.position(bpos);
                return count2;
            }
            if (this.csetDefault != null) {
                this.setCharset(this.csetDefault);
            } else {
                this.setCharset("UTF-8");
            }
        }
        if (this.cbuf == null) {
            this.cbuf = CharBuffer.wrap(this.buffer);
        }
        this.cbuf.limit(this.pos + len);
        this.cbuf.position(this.pos);
        do {
            CoderResult cres = this.decoder.decode(this.bstrm.bbuf, this.cbuf, this.inEofSeen);
            count = this.cbuf.position() - this.pos;
            if (count > 0 || this.inEofSeen || !cres.isUnderflow()) break;
            int rem = this.bstrm.bbuf.remaining();
            int n = this.bstrm.fillBytes();
            if (n >= 0) continue;
            this.inEofSeen = true;
        } while (true);
        return count == 0 && this.inEofSeen ? -1 : count;
    }

    public int readByte() throws IOException {
        return this.bstrm.read();
    }

    public int peekByte() throws IOException {
        return this.bstrm.peek();
    }

    public int readBytes(byte[] buf, int offset, int count) throws IOException {
        return this.bstrm.read(buf, offset, count);
    }

    @Override
    public void close() throws IOException {
        if (this.bstrm != null) {
            this.bstrm.close();
        }
        this.bstrm = null;
        super.close();
    }

    @Override
    protected boolean sourceReady() throws IOException {
        return this.bstrm.ready();
    }

    public static BinaryInPort openFile(Object fname) throws IOException {
        Path path = Path.valueOf(fname);
        BinaryInPort p = new BinaryInPort(path.openInputStream(), path);
        p.setCharset("ISO-8859-1");
        return p;
    }

    public static BinaryInPort openHeuristicFile(InputStream strm, Path path) throws IOException {
        NBufferedInputStream bstrm = strm instanceof NBufferedInputStream ? (NBufferedInputStream)strm : new NBufferedInputStream(strm);
        BinaryInPort inp = new BinaryInPort(bstrm, path);
        inp.setFromByteOrderMark();
        inp.setKeepFullLines(true);
        inp.setConvertCR(true);
        return inp;
    }
}

