/*
 * Decompiled with CFR 0.139.
 */
package gnu.text;

import gnu.kawa.io.InPort;
import gnu.text.SourceError;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

public class Lexer
extends Reader {
    protected InPort port;
    private boolean interactive;
    protected boolean tentative;
    protected int nesting;
    SourceMessages messages = null;
    public char[] tokenBuffer = new char[100];
    public int tokenBufferLength = 0;
    private int saveTokenBufferLength = -1;

    public Lexer(InPort port) {
        this.port = port;
    }

    public Lexer(InPort port, SourceMessages messages) {
        this.port = port;
        this.messages = messages;
    }

    public char pushNesting(char promptChar) {
        ++this.nesting;
        InPort port = this.getPort();
        char save = port.readState;
        port.readState = promptChar;
        return save;
    }

    public void popNesting(char save) {
        InPort port = this.getPort();
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
    public int read(char[] buf, int offset, int length) throws IOException {
        return this.port.read(buf, offset, length);
    }

    public void unread(int ch) throws IOException {
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

    public boolean checkNext(char ch) throws IOException {
        int r = this.port.read();
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

    public void setMessages(SourceMessages messages) {
        this.messages = messages;
    }

    public boolean checkErrors(PrintWriter out, int max) {
        return this.messages != null && this.messages.checkErrors(out, max);
    }

    public SourceError getErrors() {
        return this.messages == null ? null : this.messages.getErrors();
    }

    public boolean seenErrors() {
        return this.messages != null && this.messages.seenErrors();
    }

    public void clearErrors() {
        if (this.messages != null) {
            this.messages.clearErrors();
        }
    }

    public void error(char severity, String filename, int line, int column, String message) {
        if (this.messages == null) {
            this.messages = new SourceMessages();
        }
        this.messages.error(severity, filename, line, column, message);
    }

    public void error(char severity, String message) {
        int column;
        int line = this.port.getLineNumber();
        this.error(severity, this.port.getName(), line + 1, (column = this.port.getColumnNumber()) >= 0 ? column + 1 : 0, message);
    }

    public void error(String message) {
        this.error('e', message);
    }

    public void fatal(String message) throws SyntaxException {
        this.error('f', message);
        throw new SyntaxException(this.messages);
    }

    public void eofError(String msg) throws SyntaxException {
        this.fatal(msg);
    }

    public void eofError(String message, int startLine, int startColumn) throws SyntaxException {
        this.error('f', this.port.getName(), startLine, startColumn, message);
        throw new SyntaxException(this.messages);
    }

    public int readOptionalExponent() throws IOException {
        int value;
        int c;
        int sign = this.read();
        boolean overflow = false;
        if (sign == 43 || sign == 45) {
            c = this.read();
        } else {
            c = sign;
            sign = 0;
        }
        if (c < 0 || (value = Character.digit((char)c, 10)) < 0) {
            if (sign != 0) {
                this.error("exponent sign not followed by digit");
            }
            value = 1;
        } else {
            int d;
            int max = 214748363;
            while ((d = Character.digit((char)(c = this.read()), 10)) >= 0) {
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
            return sign == 45 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return value;
    }

    public boolean readDelimited(String delimiter) throws IOException, SyntaxException {
        this.tokenBufferLength = 0;
        int dlen = delimiter.length();
        char last = delimiter.charAt(dlen - 1);
        int ch;
        while ((ch = this.read()) >= 0) {
            int j;
            int dstart;
            if (ch == last && (dstart = this.tokenBufferLength - (j = dlen - 1)) >= 0) {
                do {
                    if (j != 0) continue;
                    this.tokenBufferLength = dstart;
                    return true;
                } while (this.tokenBuffer[dstart + --j] == delimiter.charAt(j));
            }
            this.tokenBufferAppend((char)ch);
        }
        return false;
    }

    public static long readDigitsInBuffer(InPort port, long ival, int radix) {
        int dval;
        char c;
        int i = port.pos;
        if (i >= port.limit) {
            return ival;
        }
        while ((dval = Character.digit(c = port.buffer[i], radix)) >= 0) {
            if (ival == -2L) {
                ival = dval;
            } else if (ival != -1L) {
                ival = ival > (Long.MAX_VALUE - (long)dval) / (long)radix ? -1L : ival * (long)radix + (long)dval;
            }
            if (++i < port.limit) continue;
            break;
        }
        port.pos = i;
        return ival;
    }

    public static long readDigits(InPort port, int radix) throws IOException {
        long ival;
        ival = -2L;
        do {
            ival = Lexer.readDigitsInBuffer(port, ival, radix);
        } while (port.pos >= port.limit && port.peek() >= 0);
        return ival;
    }

    public int readIntDigits() throws IOException {
        long lval = Lexer.readDigits(this.port, 10);
        int ival = (int)lval;
        if (ival == -1 || (long)ival != lval) {
            return Integer.MAX_VALUE;
        }
        return ival < 0 ? -1 : ival;
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

    public void setInteractive(boolean v) {
        this.interactive = v;
    }

    public boolean isTentative() {
        return this.tentative;
    }

    public void setTentative(boolean v) {
        this.tentative = v;
    }

    public void tokenBufferAppend(int ch) {
        if (ch >= 65536) {
            this.tokenBufferAppend((ch - 65536 >> 10) + 55296);
            ch = (ch & 1023) + 56320;
        }
        int len = this.tokenBufferLength;
        char[] buffer = this.tokenBuffer;
        if (len == this.tokenBuffer.length) {
            this.tokenBuffer = new char[2 * len];
            System.arraycopy(buffer, 0, this.tokenBuffer, 0, len);
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

