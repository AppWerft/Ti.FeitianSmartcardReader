/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.format.Printable;
import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.BinaryOutPort;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.CheckConsole;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.TtyInPort;
import gnu.lists.Consumer;
import gnu.mapping.Environment;
import gnu.mapping.ThreadLocation;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class InPort
extends Reader
implements Printable {
    public static final String systemInFilename = "/dev/stdin";
    private static InPort systemInPort;
    public static final String evalPathname = "<eval>";
    public static final String stringPathname = "<string>";
    public static final ThreadLocation<InPort> inLocation;
    protected Reader in;
    public static final int BUFFER_SIZE = 8192;
    public char[] buffer;
    public int pos;
    public int limit;
    int highestPos;
    public char readState = (char)10;
    private int flags;
    private static final int CONVERT_CR = 1;
    private static final int USER_BUFFER = 2;
    private static final int PREV_WAS_CR = 4;
    private static final int DONT_KEEP_FULL_LINES = 8;
    private static final int EOF_SEEN = 16;
    private static final int IS_CLOSED = 32;
    private static final int KEEP_ALL = 64;
    private int lineStartPos;
    Path path;
    protected int lineNumber;
    protected int readAheadLimit = -1;
    protected int markPos;

    public static InPort inDefault() {
        return inLocation.get();
    }

    public static void setInDefault(InPort in) {
        inLocation.set(in);
    }

    public static InPort openFile(Object fname) throws IOException {
        Path path = Path.valueOf(fname);
        return InPort.openFile(path.openInputStream(), path);
    }

    public static InPort openFile(Object fname, Object conv) throws IOException {
        Path path = Path.valueOf(fname);
        return InPort.openFile(path.openInputStream(), path, conv);
    }

    public static InPort openFile(InputStream strm, Path path) throws UnsupportedEncodingException {
        Object conv = Environment.user().get("port-char-encoding");
        return InPort.openFile(strm, path, conv);
    }

    public static InPort openFile(InputStream strm, Path path, Object conv) throws UnsupportedEncodingException {
        InputStreamReader rdr;
        if (conv == Boolean.FALSE) {
            return new BinaryInPort(strm, path);
        }
        if (!(strm instanceof BufferedInputStream)) {
            strm = new BufferedInputStream(strm);
        }
        if (conv instanceof Charset) {
            rdr = new InputStreamReader(strm, (Charset)conv);
        } else if (conv instanceof CharsetDecoder) {
            rdr = new InputStreamReader(strm, (CharsetDecoder)conv);
        } else if (conv != null && conv != Boolean.TRUE) {
            String enc = conv.toString();
            try {
                rdr = new InputStreamReader(strm, enc);
            }
            catch (UnsupportedEncodingException ex) {
                throw new RuntimeException("unknown character encoding: " + enc);
            }
        } else {
            rdr = new InputStreamReader(strm);
        }
        InPort port = new InPort(rdr, path);
        port.setConvertCR(true);
        return port;
    }

    @Override
    public void print(Consumer out) {
        out.write("#<input-port");
        String name = this.getName();
        if (name != null) {
            out.write(32);
            out.write(name);
        }
        out.write(62);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() throws IOException {
        Object object2 = this.lock;
        synchronized (object2) {
            this.flags |= 32;
            if (this.in != null) {
                try {
                    this.in.close();
                }
                finally {
                    this.in = null;
                    this.buffer = null;
                }
            }
        }
    }

    public boolean isOpen() {
        return (this.flags & 32) == 0;
    }

    public char getReadState() {
        return this.readState;
    }

    public void setKeepFullLines(boolean keep) {
        this.flags = keep ? (this.flags &= -9) : (this.flags |= 8);
    }

    public void setKeepAll(boolean keep) {
        if (keep) {
            this.flags |= 64;
        } else if ((this.flags & 64) != 0) {
            this.flags &= -65;
        }
    }

    public void resetAndKeep() {
        int lineno = this.getLineNumber();
        this.mark(-1);
        this.pos = 0;
        this.limit = 0;
        this.lineStartPos = 0;
        this.markPos = 0;
        this.highestPos = 0;
        this.lineNumber = lineno;
        this.flags |= 64;
    }

    public final boolean getConvertCR() {
        return (this.flags & 1) != 0;
    }

    public final void setConvertCR(boolean convertCR) {
        this.flags = convertCR ? (this.flags |= 1) : (this.flags &= -2);
    }

    public InPort(Reader in, Path path) {
        this(in);
        this.setPath(path);
    }

    public InPort(InputStream in) {
        this((Object)in, new InputStreamReader(in));
    }

    public InPort(Object lock, Reader in) {
        super(lock);
        this.in = in;
    }

    public InPort(InputStream in, Path path) {
        this(in);
        this.setPath(path);
    }

    public InPort(Reader in) {
        super(in);
        this.in = in;
    }

    public void lineStart(boolean revisited) throws IOException {
    }

    protected int fill(int len) throws IOException {
        return this.in.read(this.buffer, this.pos, len);
    }

    private void clearMark() {
        int i;
        int oldLimit = this.readAheadLimit;
        this.readAheadLimit = -1;
        if (oldLimit <= 0) {
            return;
        }
        int n = i = this.lineStartPos < 0 ? 0 : this.lineStartPos;
        while (++i < this.pos) {
            char ch = this.buffer[i - 1];
            if (ch != '\n' && (ch != '\r' || this.getConvertCR() && this.buffer[i] == '\n')) continue;
            ++this.lineNumber;
            this.lineStartPos = i;
        }
    }

    public void setBuffer(char[] buffer) throws IOException {
        if (buffer == null) {
            if (this.buffer != null) {
                buffer = new char[this.buffer.length];
                System.arraycopy(this.buffer, 0, buffer, 0, this.buffer.length);
                this.buffer = buffer;
            }
            this.flags &= -3;
        } else {
            if (this.limit - this.pos > buffer.length) {
                throw new IOException("setBuffer - too short");
            }
            this.flags |= 2;
            this.reserve(buffer, 0);
        }
    }

    private void reserve(char[] buffer, int reserve) {
        int saveStart;
        reserve += this.limit;
        if ((this.flags & 64) != 0) {
            if (reserve > buffer.length) {
                int nlen = 3 * buffer.length >> 1;
                if (nlen < reserve) {
                    nlen = reserve;
                }
                buffer = new char[nlen];
            }
            saveStart = 0;
        } else if (reserve <= buffer.length) {
            saveStart = 0;
        } else {
            saveStart = this.pos;
            if (this.readAheadLimit >= 0 && this.markPos < this.pos) {
                if (this.readAheadLimit > 0 && this.pos - this.markPos > this.readAheadLimit || (this.flags & 2) != 0 && reserve - this.markPos > buffer.length) {
                    this.clearMark();
                } else {
                    saveStart = this.markPos;
                }
            }
            if ((reserve -= buffer.length) > saveStart || saveStart > this.lineStartPos && (this.flags & 8) == 0) {
                if (reserve <= this.lineStartPos && saveStart > this.lineStartPos) {
                    saveStart = this.lineStartPos;
                } else if ((this.flags & 2) != 0) {
                    saveStart -= saveStart - reserve >> 2;
                } else {
                    if (this.lineStartPos >= 0) {
                        saveStart = this.lineStartPos;
                    }
                    buffer = new char[2 * buffer.length];
                }
            }
            this.lineStartPos -= saveStart;
            this.limit -= saveStart;
            this.markPos -= saveStart;
            this.pos -= saveStart;
            this.highestPos -= saveStart;
        }
        if (this.limit > 0) {
            System.arraycopy(this.buffer, saveStart, buffer, 0, this.limit);
        }
        this.buffer = buffer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int read() throws IOException {
        Object object2 = this.lock;
        synchronized (object2) {
            char ch;
            int prev = this.pos > 0 ? this.buffer[this.pos - 1] : ((this.flags & 4) != 0 ? 13 : (this.lineStartPos >= 0 ? 10 : 0));
            if (prev == 13 || prev == 10) {
                boolean revisited;
                if (this.lineStartPos < this.pos && (this.readAheadLimit <= 0 || this.pos <= this.markPos)) {
                    this.lineStartPos = this.pos;
                    ++this.lineNumber;
                }
                boolean bl = revisited = this.pos < this.highestPos;
                if (prev != 10 || (this.pos <= 1 ? (this.flags & 4) == 0 : this.buffer[this.pos - 2] != '\r')) {
                    this.lineStart(revisited);
                }
                if (!revisited) {
                    this.highestPos = this.pos + 1;
                }
            }
            if (this.pos >= this.limit) {
                int readCount;
                if (this.buffer == null) {
                    this.buffer = new char[8192];
                } else if (this.limit == this.buffer.length && !(this instanceof CharArrayInPort)) {
                    this.reserve(this.buffer, 1);
                }
                if (this.pos == 0) {
                    this.flags = prev == 13 ? (this.flags |= 4) : (this.flags &= -5);
                }
                if ((readCount = this.fill(this.buffer.length - this.pos)) <= 0) {
                    this.flags |= 16;
                    return -1;
                }
                this.limit += readCount;
            }
            if ((ch = this.buffer[this.pos++]) == '\n') {
                if (prev == 13) {
                    if (this.lineStartPos == this.pos - 1) {
                        --this.lineNumber;
                        --this.lineStartPos;
                    }
                    if (this.getConvertCR()) {
                        return this.read();
                    }
                }
            } else if (ch == '\r' && this.getConvertCR()) {
                return 10;
            }
            return ch;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        Object object2 = this.lock;
        synchronized (object2) {
            int ch = this.pos >= this.limit ? 0 : (this.pos > 0 ? this.buffer[this.pos - 1] : ((this.flags & 4) != 0 || this.lineStartPos >= 0 ? 10 : 0));
            int to_do = len;
            while (to_do > 0) {
                if (this.pos >= this.limit || ch == 10 || ch == 13) {
                    if (this.pos >= this.limit && to_do < len) {
                        return len - to_do;
                    }
                    ch = this.read();
                    if (ch < 0) {
                        return (len -= to_do) <= 0 ? -1 : len;
                    }
                    cbuf[off++] = (char)ch;
                    --to_do;
                    continue;
                }
                int lim = this.limit;
                int p = this.pos;
                if (to_do < lim - p) {
                    lim = p + to_do;
                }
                while (p < lim && (ch = this.buffer[p]) != 10 && ch != 13) {
                    cbuf[off++] = (char)ch;
                    ++p;
                }
                to_do -= p - this.pos;
                this.pos = p;
            }
            return len;
        }
    }

    public Path getPath() {
        return this.path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getName() {
        return this.path == null ? null : this.path.toString();
    }

    public void setName(Object name) {
        this.setPath(Path.valueOf(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getLineNumber() {
        Object object2 = this.lock;
        synchronized (object2) {
            int lineno = this.lineNumber;
            if (this.readAheadLimit <= 0) {
                char prev;
                if (this.pos > 0 && this.pos > this.lineStartPos && ((prev = this.buffer[this.pos - 1]) == '\n' || prev == '\r')) {
                    ++lineno;
                }
            } else {
                lineno += InPort.countLines(this.buffer, this.lineStartPos < 0 ? 0 : this.lineStartPos, this.pos);
            }
            return lineno;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setLineNumber(int lineNumber) {
        Object object2 = this.lock;
        synchronized (object2) {
            this.lineNumber += lineNumber - this.getLineNumber();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void incrLineNumber(int lineDelta, int lineStartPos) {
        Object object2 = this.lock;
        synchronized (object2) {
            this.lineNumber += lineDelta;
            this.lineStartPos = lineStartPos;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setSaveStart(int saveStart) {
        Object object2 = this.lock;
        synchronized (object2) {
            this.markPos = saveStart;
            this.readAheadLimit = saveStart < 0 ? -1 : 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getColumnNumber() {
        Object object2 = this.lock;
        synchronized (object2) {
            int start;
            char prev;
            if (this.pos > 0 && ((prev = this.buffer[this.pos - 1]) == '\n' || prev == '\r')) {
                return 0;
            }
            if (this.readAheadLimit <= 0) {
                return this.pos - this.lineStartPos;
            }
            int i = start = this.lineStartPos < 0 ? 0 : this.lineStartPos;
            while (i < this.pos) {
                char ch;
                if ((ch = this.buffer[i++]) != '\n' && ch != '\r') continue;
                start = i;
            }
            int col = this.pos - start;
            if (this.lineStartPos < 0) {
                col -= this.lineStartPos;
            }
            return col;
        }
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void mark(int readAheadLimit) {
        Object object2 = this.lock;
        synchronized (object2) {
            if (this.readAheadLimit >= 0) {
                this.clearMark();
            }
            this.readAheadLimit = readAheadLimit;
            this.markPos = this.pos;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void reset() throws IOException {
        if (this.readAheadLimit < 0) {
            throw new IOException("mark invalid");
        }
        Object object2 = this.lock;
        synchronized (object2) {
            if (this.pos > this.highestPos) {
                this.highestPos = this.pos;
            }
            this.pos = this.markPos;
            this.readAheadLimit = -1;
        }
    }

    public void readLine(StringBuffer sbuf, char mode) throws IOException {
        Object object2 = this.lock;
        synchronized (object2) {
            do {
                int ch;
                if ((ch = this.read()) < 0) {
                    return;
                }
                int start = --this.pos;
                while (this.pos < this.limit) {
                    if ((ch = this.buffer[this.pos++]) != 13 && ch != 10) continue;
                    sbuf.append(this.buffer, start, this.pos - 1 - start);
                    if (mode == 'P') {
                        --this.pos;
                        return;
                    }
                    if (this.getConvertCR() || ch == 10) {
                        if (mode != 'I') {
                            sbuf.append('\n');
                        }
                    } else {
                        if (mode != 'I') {
                            sbuf.append('\r');
                        }
                        if ((ch = this.read()) == 10) {
                            if (mode != 'I') {
                                sbuf.append('\n');
                            }
                        } else if (ch >= 0) {
                            this.unread_quick();
                        }
                    }
                    return;
                }
                sbuf.append(this.buffer, start, this.pos - start);
            } while (true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String readLine() throws IOException {
        Object object2 = this.lock;
        synchronized (object2) {
            int ch = this.read();
            if (ch < 0) {
                return null;
            }
            if (ch == 13 || ch == 10) {
                return "";
            }
            int start = this.pos - 1;
            while (this.pos < this.limit) {
                if ((ch = this.buffer[this.pos++]) != 13 && ch != 10) continue;
                int end = this.pos - 1;
                if (ch != 10 && !this.getConvertCR()) {
                    if (this.pos >= this.limit) {
                        --this.pos;
                        break;
                    }
                    if (this.buffer[this.pos] == '\n') {
                        ++this.pos;
                    }
                }
                return new String(this.buffer, start, end - start);
            }
            StringBuffer sbuf = new StringBuffer(100);
            sbuf.append(this.buffer, start, this.pos - start);
            this.readLine(sbuf, 'I');
            return sbuf.toString();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int skip(int n) throws IOException {
        Object object2 = this.lock;
        synchronized (object2) {
            if (n < 0) {
                int to_do;
                for (to_do = -n; to_do > 0 && this.pos > 0; --to_do) {
                    this.unread();
                }
                return n + to_do;
            }
            int to_do = n;
            int ch = this.pos >= this.limit ? 0 : (this.pos > 0 ? this.buffer[this.pos - 1] : ((this.flags & 4) != 0 || this.lineStartPos >= 0 ? 10 : 0));
            while (to_do > 0) {
                if (ch == 10 || ch == 13 || this.pos >= this.limit) {
                    ch = this.read();
                    if (ch < 0) {
                        return n - to_do;
                    }
                    --to_do;
                    continue;
                }
                int lim = this.limit;
                int p = this.pos;
                if (to_do < lim - p) {
                    lim = p + to_do;
                }
                while (p < lim && (ch = this.buffer[p]) != 10 && ch != 13) {
                    ++p;
                }
                to_do -= p - this.pos;
                this.pos = p;
            }
            return n;
        }
    }

    public boolean eofSeen() {
        return (this.flags & 16) != 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean ready() throws IOException {
        Object object2 = this.lock;
        synchronized (object2) {
            return this.pos < this.limit || (this.flags & 16) != 0 || this.sourceReady();
        }
    }

    protected boolean sourceReady() throws IOException {
        return this.in.ready();
    }

    public final void skip_quick() throws IOException {
        ++this.pos;
    }

    public void skip() throws IOException {
        this.read();
    }

    static int countLines(char[] buffer, int start, int limit) {
        int count = 0;
        int prev = 0;
        for (int i = start; i < limit; ++i) {
            int ch = buffer[i];
            if (ch == 10 && prev != 13 || ch == 13) {
                ++count;
            }
            prev = ch;
        }
        return count;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void skipRestOfLine() throws IOException {
        Object object2 = this.lock;
        synchronized (object2) {
            int c;
            do {
                if ((c = this.read()) < 0) {
                    return;
                }
                if (c != 13) continue;
                c = this.read();
                if (c >= 0 && c != 10) {
                    this.unread();
                }
                break;
            } while (c != 10);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unread() throws IOException {
        Object object2 = this.lock;
        synchronized (object2) {
            if (this.pos == 0) {
                throw new IOException("unread too much");
            }
            --this.pos;
            char ch = this.buffer[this.pos];
            if (ch == '\n' || ch == '\r') {
                if (this.pos > 0 && ch == '\n' && this.getConvertCR() && this.buffer[this.pos - 1] == '\r') {
                    --this.pos;
                }
                if (this.pos < this.lineStartPos) {
                    --this.lineNumber;
                    int i = this.pos;
                    while (i > 0) {
                        if ((ch = this.buffer[--i]) != '\r' && ch != '\n') continue;
                        ++i;
                        break;
                    }
                    this.lineStartPos = i;
                }
            }
        }
    }

    public void unread_quick() {
        --this.pos;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int peek() throws IOException {
        Object object2 = this.lock;
        synchronized (object2) {
            int ch;
            if (this.pos < this.limit && this.pos > 0 && (ch = this.buffer[this.pos - 1]) != 10 && ch != 13) {
                ch = this.buffer[this.pos];
                if (ch == 13 && this.getConvertCR()) {
                    ch = 10;
                }
                return ch;
            }
            int c = this.read();
            if (c >= 0) {
                this.unread_quick();
            }
            return c;
        }
    }

    public static int readCodePoint(Reader in) throws IOException {
        int c = in.read();
        if (c >= 55296 && c <= 56319) {
            int next = in.read();
            c = next >= 56320 && next <= 57343 ? (c - 55296 << 10) + (next - 56320) + 65536 : 65533;
        }
        return c;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int readCodePoint() throws IOException {
        Object object2 = this.lock;
        synchronized (object2) {
            return InPort.readCodePoint(this);
        }
    }

    public static int peekCodePoint(Reader in) throws IOException {
        if (in instanceof InPort) {
            return ((InPort)in).peekCodePoint();
        }
        in.mark(2);
        int ch = InPort.readCodePoint(in);
        in.reset();
        return ch;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int peekCodePoint() throws IOException {
        Object object2 = this.lock;
        synchronized (object2) {
            int ch = this.peek();
            if (ch < 55296 || ch > 56319) {
                return ch;
            }
            if (this.readAheadLimit > 0 && this.pos + 2 - this.markPos > this.readAheadLimit) {
                this.clearMark();
            }
            if (this.readAheadLimit == 0) {
                this.mark(2);
                ch = InPort.readCodePoint(this);
                this.reset();
            } else {
                int savePos = this.pos;
                ch = InPort.readCodePoint(this);
                if (this.pos > this.highestPos) {
                    this.highestPos = this.pos;
                }
                this.pos = savePos;
            }
            return ch;
        }
    }

    static {
        Path systemInPath = Path.valueOf(systemInFilename);
        if (CheckConsole.haveConsole()) {
            TtyInPort tin = TtyInPort.make(System.in, systemInPath, OutPort.outInitial);
            if (CheckConsole.getDomTermVersionInfo() != null) {
                tin.setInDomTerm(true);
            }
            systemInPort = tin;
        } else {
            systemInPort = new BinaryInPort(System.in, systemInPath);
        }
        inLocation = new ThreadLocation("in-default");
        inLocation.setGlobal(systemInPort);
    }
}

