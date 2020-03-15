// 
// Decompiled by Procyon v0.5.36
// 

package gnu.text;

import java.io.PrintWriter;
import java.io.IOException;
import gnu.kawa.io.InPort;
import java.io.Reader;

public class Lexer extends Reader
{
    protected InPort port;
    private boolean interactive;
    protected boolean tentative;
    protected int nesting;
    SourceMessages messages;
    public char[] tokenBuffer;
    public int tokenBufferLength;
    private int saveTokenBufferLength;
    
    public Lexer(final InPort port) {
        this.messages = null;
        this.tokenBuffer = new char[100];
        this.tokenBufferLength = 0;
        this.saveTokenBufferLength = -1;
        this.port = port;
    }
    
    public Lexer(final InPort port, final SourceMessages messages) {
        this.messages = null;
        this.tokenBuffer = new char[100];
        this.tokenBufferLength = 0;
        this.saveTokenBufferLength = -1;
        this.port = port;
        this.messages = messages;
    }
    
    public char pushNesting(final char promptChar) {
        ++this.nesting;
        final InPort port = this.getPort();
        final char save = port.readState;
        port.readState = promptChar;
        return save;
    }
    
    public void popNesting(final char save) {
        final InPort port = this.getPort();
        port.readState = save;
        --this.nesting;
    }
    
    public final InPort getPort() {
        return this.port;
    }
    
    @Override
    public void close() throws IOException {
        this.port.close();
    }
    
    @Override
    public int read() throws IOException {
        return this.port.read();
    }
    
    @Deprecated
    public int readUnicodeChar() throws IOException {
        return this.port.readCodePoint();
    }
    
    public int readCodePoint() throws IOException {
        return this.port.readCodePoint();
    }
    
    @Override
    public int read(final char[] buf, final int offset, final int length) throws IOException {
        return this.port.read(buf, offset, length);
    }
    
    public void unread(final int ch) throws IOException {
        if (ch >= 0) {
            this.port.unread();
        }
    }
    
    public int peek() throws IOException {
        return this.port.peek();
    }
    
    public void skip() throws IOException {
        this.port.skip();
    }
    
    protected void unread() throws IOException {
        this.port.unread();
    }
    
    protected void unread_quick() throws IOException {
        this.port.unread_quick();
    }
    
    public boolean checkNext(final char ch) throws IOException {
        final int r = this.port.read();
        if (r == ch) {
            return true;
        }
        if (r >= 0) {
            this.port.unread_quick();
        }
        return false;
    }
    
    protected void skip_quick() throws IOException {
        this.port.skip_quick();
    }
    
    public SourceMessages getMessages() {
        return this.messages;
    }
    
    public void setMessages(final SourceMessages messages) {
        this.messages = messages;
    }
    
    public boolean checkErrors(final PrintWriter out, final int max) {
        return this.messages != null && this.messages.checkErrors(out, max);
    }
    
    public SourceError getErrors() {
        return (this.messages == null) ? null : this.messages.getErrors();
    }
    
    public boolean seenErrors() {
        return this.messages != null && this.messages.seenErrors();
    }
    
    public void clearErrors() {
        if (this.messages != null) {
            this.messages.clearErrors();
        }
    }
    
    public void error(final char severity, final String filename, final int line, final int column, final String message) {
        if (this.messages == null) {
            this.messages = new SourceMessages();
        }
        this.messages.error(severity, filename, line, column, message);
    }
    
    public void error(final char severity, final String message) {
        final int line = this.port.getLineNumber();
        final int column = this.port.getColumnNumber();
        this.error(severity, this.port.getName(), line + 1, (column >= 0) ? (column + 1) : 0, message);
    }
    
    public void error(final String message) {
        this.error('e', message);
    }
    
    public void fatal(final String message) throws SyntaxException {
        this.error('f', message);
        throw new SyntaxException(this.messages);
    }
    
    public void eofError(final String msg) throws SyntaxException {
        this.fatal(msg);
    }
    
    public void eofError(final String message, final int startLine, final int startColumn) throws SyntaxException {
        this.error('f', this.port.getName(), startLine, startColumn, message);
        throw new SyntaxException(this.messages);
    }
    
    public int readOptionalExponent() throws IOException {
        int sign = this.read();
        boolean overflow = false;
        int c;
        if (sign == 43 || sign == 45) {
            c = this.read();
        }
        else {
            c = sign;
            sign = 0;
        }
        int value;
        if (c < 0 || (value = Character.digit((char)c, 10)) < 0) {
            if (sign != 0) {
                this.error("exponent sign not followed by digit");
            }
            value = 1;
        }
        else {
            final int max = 214748363;
            while (true) {
                c = this.read();
                final int d = Character.digit((char)c, 10);
                if (d < 0) {
                    break;
                }
                if (value > max) {
                    overflow = true;
                }
                value = 10 * value + d;
            }
        }
        if (c >= 0) {
            this.unread(c);
        }
        if (sign == 45) {
            value = -value;
        }
        if (overflow) {
            return (sign == 45) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return value;
    }
    
    public boolean readDelimited(final String delimiter) throws IOException, SyntaxException {
        this.tokenBufferLength = 0;
        final int dlen = delimiter.length();
        final char last = delimiter.charAt(dlen - 1);
        while (true) {
            final int ch = this.read();
            if (ch < 0) {
                return false;
            }
            Label_0089: {
                int j;
                final int dstart;
                if (ch == last && (dstart = this.tokenBufferLength - (j = dlen - 1)) >= 0) {
                    while (j != 0) {
                        --j;
                        if (this.tokenBuffer[dstart + j] != delimiter.charAt(j)) {
                            break Label_0089;
                        }
                    }
                    this.tokenBufferLength = dstart;
                    return true;
                }
            }
            this.tokenBufferAppend((char)ch);
        }
    }
    
    public static long readDigitsInBuffer(final InPort port, long ival, final int radix) {
        int i = port.pos;
        if (i >= port.limit) {
            return ival;
        }
        do {
            final char c = port.buffer[i];
            final int dval = Character.digit(c, radix);
            if (dval < 0) {
                break;
            }
            if (ival == -2L) {
                ival = dval;
            }
            else if (ival != -1L) {
                if (ival > (Long.MAX_VALUE - dval) / radix) {
                    ival = -1L;
                }
                else {
                    ival = ival * radix + dval;
                }
            }
        } while (++i < port.limit);
        port.pos = i;
        return ival;
    }
    
    public static long readDigits(final InPort port, final int radix) throws IOException {
        long ival = -2L;
        do {
            ival = readDigitsInBuffer(port, ival, radix);
        } while (port.pos >= port.limit && port.peek() >= 0);
        return ival;
    }
    
    public int readIntDigits() throws IOException {
        final long lval = readDigits(this.port, 10);
        final int ival = (int)lval;
        if (ival == -1 || ival != lval) {
            return Integer.MAX_VALUE;
        }
        return (ival < 0) ? -1 : ival;
    }
    
    public String getName() {
        return this.port.getName();
    }
    
    public int getLineNumber() {
        return this.port.getLineNumber();
    }
    
    public int getColumnNumber() {
        return this.port.getColumnNumber();
    }
    
    public boolean isInteractive() {
        return this.interactive;
    }
    
    public void setInteractive(final boolean v) {
        this.interactive = v;
    }
    
    public boolean isTentative() {
        return this.tentative;
    }
    
    public void setTentative(final boolean v) {
        this.tentative = v;
    }
    
    public void tokenBufferAppend(int ch) {
        if (ch >= 65536) {
            this.tokenBufferAppend((ch - 65536 >> 10) + 55296);
            ch = (ch & 0x3FF) + 56320;
        }
        final int len = this.tokenBufferLength;
        char[] buffer = this.tokenBuffer;
        if (len == this.tokenBuffer.length) {
            System.arraycopy(buffer, 0, this.tokenBuffer = new char[2 * len], 0, len);
            buffer = this.tokenBuffer;
        }
        buffer[len] = (char)ch;
        this.tokenBufferLength = len + 1;
    }
    
    public String tokenBufferString() {
        return new String(this.tokenBuffer, 0, this.tokenBufferLength);
    }
    
    public void mark() throws IOException {
        if (this.saveTokenBufferLength >= 0) {
            throw new Error("internal error: recursive call to mark not allowed");
        }
        this.port.mark(Integer.MAX_VALUE);
        this.saveTokenBufferLength = this.tokenBufferLength;
    }
    
    @Override
    public void reset() throws IOException {
        if (this.saveTokenBufferLength < 0) {
            throw new Error("internal error: reset called without prior mark");
        }
        this.port.reset();
        this.saveTokenBufferLength = -1;
    }
}
