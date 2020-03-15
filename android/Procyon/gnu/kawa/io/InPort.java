// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import gnu.lists.Consumer;
import java.nio.charset.CharsetDecoder;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.io.BufferedInputStream;
import java.io.UnsupportedEncodingException;
import gnu.mapping.Environment;
import java.io.InputStream;
import java.io.IOException;
import gnu.mapping.ThreadLocation;
import gnu.kawa.format.Printable;
import java.io.Reader;

public class InPort extends Reader implements Printable
{
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
    public char readState;
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
    protected int readAheadLimit;
    protected int markPos;
    
    public static InPort inDefault() {
        return InPort.inLocation.get();
    }
    
    public static void setInDefault(final InPort in) {
        InPort.inLocation.set(in);
    }
    
    public static InPort openFile(final Object fname) throws IOException {
        final Path path = Path.valueOf(fname);
        return openFile(path.openInputStream(), path);
    }
    
    public static InPort openFile(final Object fname, final Object conv) throws IOException {
        final Path path = Path.valueOf(fname);
        return openFile(path.openInputStream(), path, conv);
    }
    
    public static InPort openFile(final InputStream strm, final Path path) throws UnsupportedEncodingException {
        final Object conv = Environment.user().get("port-char-encoding");
        return openFile(strm, path, conv);
    }
    
    public static InPort openFile(InputStream strm, final Path path, final Object conv) throws UnsupportedEncodingException {
        if (conv == Boolean.FALSE) {
            return new BinaryInPort(strm, path);
        }
        if (!(strm instanceof BufferedInputStream)) {
            strm = new BufferedInputStream(strm);
        }
        Reader rdr;
        if (conv instanceof Charset) {
            rdr = new InputStreamReader(strm, (Charset)conv);
        }
        else if (conv instanceof CharsetDecoder) {
            rdr = new InputStreamReader(strm, (CharsetDecoder)conv);
        }
        else if (conv != null && conv != Boolean.TRUE) {
            final String enc = conv.toString();
            try {
                rdr = new InputStreamReader(strm, enc);
            }
            catch (UnsupportedEncodingException ex) {
                throw new RuntimeException("unknown character encoding: " + enc);
            }
        }
        else {
            rdr = new InputStreamReader(strm);
        }
        final InPort port = new InPort(rdr, path);
        port.setConvertCR(true);
        return port;
    }
    
    @Override
    public void print(final Consumer out) {
        out.write("#<input-port");
        final String name = this.getName();
        if (name != null) {
            out.write(32);
            out.write(name);
        }
        out.write(62);
    }
    
    @Override
    public void close() throws IOException {
        synchronized (this.lock) {
            this.flags |= 0x20;
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
        return (this.flags & 0x20) == 0x0;
    }
    
    public char getReadState() {
        return this.readState;
    }
    
    public void setKeepFullLines(final boolean keep) {
        if (keep) {
            this.flags &= 0xFFFFFFF7;
        }
        else {
            this.flags |= 0x8;
        }
    }
    
    public void setKeepAll(final boolean keep) {
        if (keep) {
            this.flags |= 0x40;
        }
        else if ((this.flags & 0x40) != 0x0) {
            this.flags &= 0xFFFFFFBF;
        }
    }
    
    public void resetAndKeep() {
        final int lineno = this.getLineNumber();
        this.mark(-1);
        this.pos = 0;
        this.limit = 0;
        this.lineStartPos = 0;
        this.markPos = 0;
        this.highestPos = 0;
        this.lineNumber = lineno;
        this.flags |= 0x40;
    }
    
    public final boolean getConvertCR() {
        return (this.flags & 0x1) != 0x0;
    }
    
    public final void setConvertCR(final boolean convertCR) {
        if (convertCR) {
            this.flags |= 0x1;
        }
        else {
            this.flags &= 0xFFFFFFFE;
        }
    }
    
    public InPort(final Reader in, final Path path) {
        this(in);
        this.setPath(path);
    }
    
    public InPort(final InputStream in) {
        this(in, new InputStreamReader(in));
    }
    
    public InPort(final Object lock, final Reader in) {
        super(lock);
        this.readState = '\n';
        this.readAheadLimit = -1;
        this.in = in;
    }
    
    public InPort(final InputStream in, final Path path) {
        this(in);
        this.setPath(path);
    }
    
    public InPort(final Reader in) {
        super(in);
        this.readState = '\n';
        this.readAheadLimit = -1;
        this.in = in;
    }
    
    public void lineStart(final boolean revisited) throws IOException {
    }
    
    protected int fill(final int len) throws IOException {
        return this.in.read(this.buffer, this.pos, len);
    }
    
    private void clearMark() {
        final int oldLimit = this.readAheadLimit;
        this.readAheadLimit = -1;
        if (oldLimit <= 0) {
            return;
        }
        int i = (this.lineStartPos < 0) ? 0 : this.lineStartPos;
        while (++i < this.pos) {
            final char ch = this.buffer[i - 1];
            if (ch == '\n' || (ch == '\r' && (!this.getConvertCR() || this.buffer[i] != '\n'))) {
                ++this.lineNumber;
                this.lineStartPos = i;
            }
        }
    }
    
    public void setBuffer(char[] buffer) throws IOException {
        if (buffer == null) {
            if (this.buffer != null) {
                buffer = new char[this.buffer.length];
                System.arraycopy(this.buffer, 0, buffer, 0, this.buffer.length);
                this.buffer = buffer;
            }
            this.flags &= 0xFFFFFFFD;
        }
        else {
            if (this.limit - this.pos > buffer.length) {
                throw new IOException("setBuffer - too short");
            }
            this.flags |= 0x2;
            this.reserve(buffer, 0);
        }
    }
    
    private void reserve(char[] buffer, int reserve) {
        reserve += this.limit;
        int saveStart;
        if ((this.flags & 0x40) != 0x0) {
            if (reserve > buffer.length) {
                int nlen = 3 * buffer.length >> 1;
                if (nlen < reserve) {
                    nlen = reserve;
                }
                buffer = new char[nlen];
            }
            saveStart = 0;
        }
        else if (reserve <= buffer.length) {
            saveStart = 0;
        }
        else {
            saveStart = this.pos;
            if (this.readAheadLimit >= 0 && this.markPos < this.pos) {
                if ((this.readAheadLimit > 0 && this.pos - this.markPos > this.readAheadLimit) || ((this.flags & 0x2) != 0x0 && reserve - this.markPos > buffer.length)) {
                    this.clearMark();
                }
                else {
                    saveStart = this.markPos;
                }
            }
            reserve -= buffer.length;
            Label_0233: {
                if (reserve <= saveStart) {
                    if (saveStart <= this.lineStartPos) {
                        break Label_0233;
                    }
                    if ((this.flags & 0x8) != 0x0) {
                        break Label_0233;
                    }
                }
                if (reserve <= this.lineStartPos && saveStart > this.lineStartPos) {
                    saveStart = this.lineStartPos;
                }
                else if ((this.flags & 0x2) != 0x0) {
                    saveStart -= saveStart - reserve >> 2;
                }
                else {
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
    
    @Override
    public int read() throws IOException {
        synchronized (this.lock) {
            char prev;
            if (this.pos > 0) {
                prev = this.buffer[this.pos - 1];
            }
            else if ((this.flags & 0x4) != 0x0) {
                prev = '\r';
            }
            else if (this.lineStartPos >= 0) {
                prev = '\n';
            }
            else {
                prev = '\0';
            }
            if (prev == '\r' || prev == '\n') {
                if (this.lineStartPos < this.pos && (this.readAheadLimit <= 0 || this.pos <= this.markPos)) {
                    this.lineStartPos = this.pos;
                    ++this.lineNumber;
                }
                final boolean revisited = this.pos < this.highestPos;
                Label_0182: {
                    if (prev == '\n') {
                        if (this.pos <= 1) {
                            if ((this.flags & 0x4) != 0x0) {
                                break Label_0182;
                            }
                        }
                        else if (this.buffer[this.pos - 2] == '\r') {
                            break Label_0182;
                        }
                    }
                    this.lineStart(revisited);
                }
                if (!revisited) {
                    this.highestPos = this.pos + 1;
                }
            }
            if (this.pos >= this.limit) {
                if (this.buffer == null) {
                    this.buffer = new char[8192];
                }
                else if (this.limit == this.buffer.length && !(this instanceof CharArrayInPort)) {
                    this.reserve(this.buffer, 1);
                }
                if (this.pos == 0) {
                    if (prev == '\r') {
                        this.flags |= 0x4;
                    }
                    else {
                        this.flags &= 0xFFFFFFFB;
                    }
                }
                final int readCount = this.fill(this.buffer.length - this.pos);
                if (readCount <= 0) {
                    this.flags |= 0x10;
                    return -1;
                }
                this.limit += readCount;
            }
            final int ch = this.buffer[this.pos++];
            if (ch == 10) {
                if (prev == '\r') {
                    if (this.lineStartPos == this.pos - 1) {
                        --this.lineNumber;
                        --this.lineStartPos;
                    }
                    if (this.getConvertCR()) {
                        return this.read();
                    }
                }
            }
            else if (ch == 13 && this.getConvertCR()) {
                return 10;
            }
            return ch;
        }
    }
    
    @Override
    public int read(final char[] cbuf, int off, int len) throws IOException {
        synchronized (this.lock) {
            int ch;
            if (this.pos >= this.limit) {
                ch = 0;
            }
            else if (this.pos > 0) {
                ch = this.buffer[this.pos - 1];
            }
            else if ((this.flags & 0x4) != 0x0 || this.lineStartPos >= 0) {
                ch = 10;
            }
            else {
                ch = 0;
            }
            int to_do = len;
            while (to_do > 0) {
                if (this.pos >= this.limit || ch == 10 || ch == 13) {
                    if (this.pos >= this.limit && to_do < len) {
                        return len - to_do;
                    }
                    ch = this.read();
                    if (ch < 0) {
                        len -= to_do;
                        return (len <= 0) ? -1 : len;
                    }
                    cbuf[off++] = (char)ch;
                    --to_do;
                }
                else {
                    int p = this.pos;
                    int lim = this.limit;
                    if (to_do < lim - p) {
                        lim = p + to_do;
                    }
                    while (p < lim) {
                        ch = this.buffer[p];
                        if (ch == 10) {
                            break;
                        }
                        if (ch == 13) {
                            break;
                        }
                        cbuf[off++] = (char)ch;
                        ++p;
                    }
                    to_do -= p - this.pos;
                    this.pos = p;
                }
            }
            return len;
        }
    }
    
    public Path getPath() {
        return this.path;
    }
    
    public void setPath(final Path path) {
        this.path = path;
    }
    
    public String getName() {
        return (this.path == null) ? null : this.path.toString();
    }
    
    public void setName(final Object name) {
        this.setPath(Path.valueOf(name));
    }
    
    public int getLineNumber() {
        synchronized (this.lock) {
            int lineno = this.lineNumber;
            if (this.readAheadLimit <= 0) {
                if (this.pos > 0 && this.pos > this.lineStartPos) {
                    final char prev = this.buffer[this.pos - 1];
                    if (prev == '\n' || prev == '\r') {
                        ++lineno;
                    }
                }
            }
            else {
                lineno += countLines(this.buffer, (this.lineStartPos < 0) ? 0 : this.lineStartPos, this.pos);
            }
            return lineno;
        }
    }
    
    public void setLineNumber(final int lineNumber) {
        synchronized (this.lock) {
            this.lineNumber += lineNumber - this.getLineNumber();
        }
    }
    
    public void incrLineNumber(final int lineDelta, final int lineStartPos) {
        synchronized (this.lock) {
            this.lineNumber += lineDelta;
            this.lineStartPos = lineStartPos;
        }
    }
    
    public void setSaveStart(final int saveStart) {
        synchronized (this.lock) {
            this.markPos = saveStart;
            this.readAheadLimit = ((saveStart < 0) ? -1 : 0);
        }
    }
    
    public int getColumnNumber() {
        synchronized (this.lock) {
            if (this.pos > 0) {
                final char prev = this.buffer[this.pos - 1];
                if (prev == '\n' || prev == '\r') {
                    return 0;
                }
            }
            if (this.readAheadLimit <= 0) {
                return this.pos - this.lineStartPos;
            }
            int i;
            int start = i = ((this.lineStartPos < 0) ? 0 : this.lineStartPos);
            while (i < this.pos) {
                final char ch = this.buffer[i++];
                if (ch == '\n' || ch == '\r') {
                    start = i;
                }
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
    
    @Override
    public void mark(final int readAheadLimit) {
        synchronized (this.lock) {
            if (this.readAheadLimit >= 0) {
                this.clearMark();
            }
            this.readAheadLimit = readAheadLimit;
            this.markPos = this.pos;
        }
    }
    
    @Override
    public void reset() throws IOException {
        if (this.readAheadLimit < 0) {
            throw new IOException("mark invalid");
        }
        synchronized (this.lock) {
            if (this.pos > this.highestPos) {
                this.highestPos = this.pos;
            }
            this.pos = this.markPos;
            this.readAheadLimit = -1;
        }
    }
    
    public void readLine(final StringBuffer sbuf, final char mode) throws IOException {
        synchronized (this.lock) {
            while (true) {
                int ch = this.read();
                if (ch < 0) {
                    return;
                }
                final int pos = this.pos - 1;
                this.pos = pos;
                final int start = pos;
                while (this.pos < this.limit) {
                    ch = this.buffer[this.pos++];
                    if (ch == 13 || ch == 10) {
                        sbuf.append(this.buffer, start, this.pos - 1 - start);
                        if (mode == 'P') {
                            --this.pos;
                            return;
                        }
                        if (this.getConvertCR() || ch == 10) {
                            if (mode != 'I') {
                                sbuf.append('\n');
                            }
                        }
                        else {
                            if (mode != 'I') {
                                sbuf.append('\r');
                            }
                            ch = this.read();
                            if (ch == 10) {
                                if (mode != 'I') {
                                    sbuf.append('\n');
                                }
                            }
                            else if (ch >= 0) {
                                this.unread_quick();
                            }
                        }
                        return;
                    }
                }
                sbuf.append(this.buffer, start, this.pos - start);
            }
        }
    }
    
    public String readLine() throws IOException {
        synchronized (this.lock) {
            int ch = this.read();
            if (ch < 0) {
                return null;
            }
            if (ch == 13 || ch == 10) {
                return "";
            }
            final int start = this.pos - 1;
            while (this.pos < this.limit) {
                ch = this.buffer[this.pos++];
                if (ch == 13 || ch == 10) {
                    final int end = this.pos - 1;
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
            }
            final StringBuffer sbuf = new StringBuffer(100);
            sbuf.append(this.buffer, start, this.pos - start);
            this.readLine(sbuf, 'I');
            return sbuf.toString();
        }
    }
    
    public int skip(final int n) throws IOException {
        synchronized (this.lock) {
            if (n < 0) {
                int to_do;
                for (to_do = -n; to_do > 0 && this.pos > 0; --to_do) {
                    this.unread();
                }
                return n + to_do;
            }
            int to_do = n;
            int ch;
            if (this.pos >= this.limit) {
                ch = 0;
            }
            else if (this.pos > 0) {
                ch = this.buffer[this.pos - 1];
            }
            else if ((this.flags & 0x4) != 0x0 || this.lineStartPos >= 0) {
                ch = 10;
            }
            else {
                ch = 0;
            }
            while (to_do > 0) {
                if (ch == 10 || ch == 13 || this.pos >= this.limit) {
                    ch = this.read();
                    if (ch < 0) {
                        return n - to_do;
                    }
                    --to_do;
                }
                else {
                    int p = this.pos;
                    int lim = this.limit;
                    if (to_do < lim - p) {
                        lim = p + to_do;
                    }
                    while (p < lim) {
                        ch = this.buffer[p];
                        if (ch == 10) {
                            break;
                        }
                        if (ch == 13) {
                            break;
                        }
                        ++p;
                    }
                    to_do -= p - this.pos;
                    this.pos = p;
                }
            }
            return n;
        }
    }
    
    public boolean eofSeen() {
        return (this.flags & 0x10) != 0x0;
    }
    
    @Override
    public boolean ready() throws IOException {
        synchronized (this.lock) {
            return this.pos < this.limit || (this.flags & 0x10) != 0x0 || this.sourceReady();
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
    
    static int countLines(final char[] buffer, final int start, final int limit) {
        int count = 0;
        char prev = '\0';
        for (int i = start; i < limit; ++i) {
            final char ch = buffer[i];
            if ((ch == '\n' && prev != '\r') || ch == '\r') {
                ++count;
            }
            prev = ch;
        }
        return count;
    }
    
    public void skipRestOfLine() throws IOException {
        synchronized (this.lock) {
            while (true) {
                int c = this.read();
                if (c < 0) {
                    return;
                }
                if (c == 13) {
                    c = this.read();
                    if (c >= 0 && c != 10) {
                        this.unread();
                        break;
                    }
                    break;
                }
                else {
                    if (c == 10) {
                        break;
                    }
                    continue;
                }
            }
        }
    }
    
    public void unread() throws IOException {
        synchronized (this.lock) {
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
                        ch = this.buffer[--i];
                        if (ch == '\r' || ch == '\n') {
                            ++i;
                            break;
                        }
                    }
                    this.lineStartPos = i;
                }
            }
        }
    }
    
    public void unread_quick() {
        --this.pos;
    }
    
    public int peek() throws IOException {
        synchronized (this.lock) {
            if (this.pos < this.limit && this.pos > 0) {
                char ch = this.buffer[this.pos - 1];
                if (ch != '\n' && ch != '\r') {
                    ch = this.buffer[this.pos];
                    if (ch == '\r' && this.getConvertCR()) {
                        ch = '\n';
                    }
                    return ch;
                }
            }
            final int c = this.read();
            if (c >= 0) {
                this.unread_quick();
            }
            return c;
        }
    }
    
    public static int readCodePoint(final Reader in) throws IOException {
        int c = in.read();
        if (c >= 55296 && c <= 56319) {
            final int next = in.read();
            if (next >= 56320 && next <= 57343) {
                c = (c - 55296 << 10) + (next - 56320) + 65536;
            }
            else {
                c = 65533;
            }
        }
        return c;
    }
    
    public int readCodePoint() throws IOException {
        synchronized (this.lock) {
            return readCodePoint(this);
        }
    }
    
    public static int peekCodePoint(final Reader in) throws IOException {
        if (in instanceof InPort) {
            return ((InPort)in).peekCodePoint();
        }
        in.mark(2);
        final int ch = readCodePoint(in);
        in.reset();
        return ch;
    }
    
    public int peekCodePoint() throws IOException {
        synchronized (this.lock) {
            int ch = this.peek();
            if (ch < 55296 || ch > 56319) {
                return ch;
            }
            if (this.readAheadLimit > 0 && this.pos + 2 - this.markPos > this.readAheadLimit) {
                this.clearMark();
            }
            if (this.readAheadLimit == 0) {
                this.mark(2);
                ch = readCodePoint(this);
                this.reset();
            }
            else {
                final int savePos = this.pos;
                ch = readCodePoint(this);
                if (this.pos > this.highestPos) {
                    this.highestPos = this.pos;
                }
                this.pos = savePos;
            }
            return ch;
        }
    }
    
    static {
        final Path systemInPath = Path.valueOf("/dev/stdin");
        if (CheckConsole.haveConsole()) {
            final TtyInPort tin = TtyInPort.make(System.in, systemInPath, OutPort.outInitial);
            if (CheckConsole.getDomTermVersionInfo() != null) {
                tin.setInDomTerm(true);
            }
            InPort.systemInPort = tin;
        }
        else {
            InPort.systemInPort = new BinaryInPort(System.in, systemInPath);
        }
        (inLocation = new ThreadLocation<InPort>("in-default")).setGlobal(InPort.systemInPort);
    }
}
