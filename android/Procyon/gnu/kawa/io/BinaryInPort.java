// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.nio.charset.CoderResult;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.Charset;
import java.nio.CharBuffer;

public class BinaryInPort extends InPort
{
    private NBufferedInputStream bstrm;
    CharBuffer cbuf;
    Charset cset;
    CharsetDecoder decoder;
    Charset csetDefault;
    private boolean inEofSeen;
    
    public Charset getCharset() {
        return this.cset;
    }
    
    public void setCharset(final Charset cset) {
        this.cset = cset;
        this.decoder = cset.newDecoder();
    }
    
    public void setCharset(final String name) {
        final Charset cset = Charset.forName(name);
        if (this.cset == null) {
            this.setCharset(cset);
        }
        else if (!cset.equals(this.cset)) {
            throw new RuntimeException("encoding " + name + " does not match previous " + this.cset);
        }
    }
    
    public void setDefaultCharset(final Charset cset) {
        this.csetDefault = cset;
    }
    
    private BinaryInPort(final NBufferedInputStream bstrm, final Path path) {
        super(bstrm, path);
        this.cbuf = null;
        this.bstrm = bstrm;
        this.setKeepFullLines(false);
    }
    
    public BinaryInPort(final InputStream strm) {
        this(new NBufferedInputStream(strm), null);
    }
    
    public BinaryInPort(final InputStream strm, final Path path) {
        this(new NBufferedInputStream(strm), path);
    }
    
    public BinaryInPort(final byte[] buffer, final int length, final Path path) {
        this(new NBufferedInputStream(buffer, length), path);
    }
    
    @Override
    public void setBuffer(final char[] buffer) throws IOException {
        super.setBuffer(buffer);
        if (this.limit - this.pos + 2 < this.buffer.length) {
            throw new IOException("setBuffer - too short");
        }
    }
    
    public boolean setFromByteOrderMark() throws IOException {
        final String enc = this.bstrm.checkByteOrderMark();
        if (enc == null) {
            return false;
        }
        this.setCharset(enc);
        return true;
    }
    
    public InputStream getInputStream() {
        return this.bstrm;
    }
    
    public void resetStart(final int pos) throws IOException {
        this.bstrm.bbuf.position(pos);
    }
    
    @Override
    protected int fill(final int len) throws IOException {
        Label_0184: {
            if (this.cset == null) {
                final byte[] barr = this.bstrm.barr;
                final ByteBuffer bbuf = this.bstrm.bbuf;
                int count = 0;
                int bpos = bbuf.position();
                int blim = bbuf.limit();
                while (count < len) {
                    if (bpos >= blim) {
                        bbuf.position(bpos);
                        if (count > 0) {
                            return count;
                        }
                        final int nb = this.bstrm.fillBytes();
                        if (nb < 0) {
                            return -1;
                        }
                        bpos = bbuf.position();
                        blim = bbuf.limit();
                    }
                    final byte b = barr[bpos];
                    if (b >= 0) {
                        this.buffer[this.pos + count] = (char)b;
                        ++bpos;
                        ++count;
                    }
                    else {
                        if (count > 0) {
                            bbuf.position(bpos);
                            return count;
                        }
                        if (this.csetDefault != null) {
                            this.setCharset(this.csetDefault);
                            break Label_0184;
                        }
                        this.setCharset("UTF-8");
                        break Label_0184;
                    }
                }
                bbuf.position(bpos);
                return count;
            }
        }
        if (this.cbuf == null) {
            this.cbuf = CharBuffer.wrap(this.buffer);
        }
        this.cbuf.limit(this.pos + len);
        this.cbuf.position(this.pos);
        int count2;
        while (true) {
            final CoderResult cres = this.decoder.decode(this.bstrm.bbuf, this.cbuf, this.inEofSeen);
            count2 = this.cbuf.position() - this.pos;
            if (count2 > 0 || this.inEofSeen || !cres.isUnderflow()) {
                break;
            }
            final int rem = this.bstrm.bbuf.remaining();
            final int n = this.bstrm.fillBytes();
            if (n >= 0) {
                continue;
            }
            this.inEofSeen = true;
        }
        return (count2 == 0 && this.inEofSeen) ? -1 : count2;
    }
    
    public int readByte() throws IOException {
        return this.bstrm.read();
    }
    
    public int peekByte() throws IOException {
        return this.bstrm.peek();
    }
    
    public int readBytes(final byte[] buf, final int offset, final int count) throws IOException {
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
    
    public static BinaryInPort openFile(final Object fname) throws IOException {
        final Path path = Path.valueOf(fname);
        final BinaryInPort p = new BinaryInPort(path.openInputStream(), path);
        p.setCharset("ISO-8859-1");
        return p;
    }
    
    public static BinaryInPort openHeuristicFile(final InputStream strm, final Path path) throws IOException {
        final NBufferedInputStream bstrm = (NBufferedInputStream)((strm instanceof NBufferedInputStream) ? strm : new NBufferedInputStream(strm));
        final BinaryInPort inp = new BinaryInPort(bstrm, path);
        inp.setFromByteOrderMark();
        inp.setKeepFullLines(true);
        inp.setConvertCR(true);
        return inp;
    }
}
