// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.xml.XName;
import gnu.kawa.io.InPort;
import gnu.expr.Special;
import gnu.lists.Pair;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.text.Lexer;
import gnu.mapping.Symbol;

public class ReaderExtendedLiteral extends ReaderConstituent
{
    static final Symbol qstringSymbol;
    static final Symbol formatSymbol;
    static final Symbol sprintfSymbol;
    static final Symbol startEnclosedSymbol;
    static final Symbol endEnclosedSymbol;
    
    public ReaderExtendedLiteral() {
        super(2);
    }
    
    @Override
    public Object read(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
        final LispReader reader = (LispReader)in;
        final int startPos = reader.tokenBufferLength;
        final ReadTable rtable = ReadTable.getCurrent();
        final int startLine = reader.getLineNumber() + 1;
        final int startColumn = reader.getColumnNumber() - 2;
        in.tokenBufferAppend(ch);
        int next = reader.read();
        next = this.scanTag(reader, next);
        Object result;
        if (next == 123 || next == 91) {
            final int len = reader.tokenBufferLength - startPos - 1;
            final String tag = (len == 0) ? null : new String(reader.tokenBuffer, startPos + 1, len);
            reader.tokenBufferLength = startPos;
            result = this.readNamedLiteral(reader, rtable, tag, next, startLine, startColumn);
        }
        else {
            result = reader.readAndHandleToken(next, startPos, rtable);
        }
        return result;
    }
    
    protected int enclosedExprDelim(final int ch, final LispReader reader) {
        return (ch == 91) ? 93 : -1;
    }
    
    public Object readNamedLiteral(final LispReader reader, final ReadTable rtable, final String tag, int next, final int startLine, final int startColumn) throws IOException, SyntaxException {
        final Object operator = (tag == null) ? ReaderExtendedLiteral.qstringSymbol : LispLanguage.constructNamespace.getSymbol(tag);
        Pair rtail;
        final Pair result = rtail = PairWithPosition.make(operator, null, reader.getName(), startLine, startColumn);
        final int endDelimiter = this.enclosedExprDelim(next, reader);
        if (endDelimiter >= 0 && tag != null) {
            final int line = reader.getLineNumber() + 1;
            final int column = reader.getColumnNumber();
            rtail = this.readEnclosed(reader, rtable, rtail, next, endDelimiter);
            final Pair endMarker = reader.makePair(ReaderExtendedLiteral.endEnclosedSymbol, LList.Empty, reader.getLineNumber() + 1, reader.getColumnNumber());
            rtail.setCdrBackdoor(endMarker);
            rtail = endMarker;
            next = reader.read();
        }
        if (next == 123) {
            this.readContent(reader, '}', rtail);
        }
        else if (tag == null) {
            reader.error("unexpected character after &");
        }
        else {
            reader.unread(next);
        }
        return result;
    }
    
    protected Object checkDelim(final LispReader reader, final int next, final int delimiter) throws IOException, SyntaxException {
        return (next == delimiter || next < 0) ? Special.eof : null;
    }
    
    protected boolean isNestableStartDelim(final int next) {
        return next == 123;
    }
    
    protected boolean isNestableEndDelim(final int next) {
        return next == 125;
    }
    
    public Pair readContent(final LispReader reader, final char delimiter, final Pair head) throws IOException, SyntaxException {
        Pair resultTail = head;
        reader.tokenBufferLength = 0;
        int braceNesting = 1;
        int lineStart = -1;
        int nonSpace = -1;
        while (true) {
            Object item = null;
            final int line = reader.getLineNumber() + 1;
            final int column = reader.getColumnNumber();
            int next = reader.readCodePoint();
            if (next == 13 || next == 10) {
                if (lineStart < 0 && nonSpace < 0) {
                    lineStart = 0;
                }
                else {
                    lineStart = reader.tokenBufferLength + 1;
                }
                nonSpace = -1;
            }
            else if (nonSpace < 0 && next != 32 && next != 9) {
                nonSpace = reader.tokenBufferLength;
            }
            if (next < 0) {
                reader.error("unexpected end-of-file");
                item = Special.eof;
            }
            else if (next == delimiter && (!this.isNestableEndDelim(next) || --braceNesting == 0)) {
                item = Special.eof;
            }
            else if (next == 38) {
                final int next2 = reader.peek();
                if (next2 == 124) {
                    final int skipped = 0;
                    final int blen = reader.tokenBufferLength;
                    if (lineStart < 0) {
                        reader.error('e', reader.getName(), line, column + 1, "invalid '&|'");
                    }
                    else if (nonSpace != reader.tokenBufferLength) {
                        reader.error('e', reader.getName(), line, nonSpace - lineStart + 1, "non-whitespace before '&|'");
                    }
                    else {
                        reader.tokenBufferLength = lineStart;
                    }
                    reader.skip();
                    continue;
                }
                if (next2 == 45) {
                    reader.skip();
                    boolean complained = false;
                    while (true) {
                        next = reader.read();
                        if (next == 13 || next == 10) {
                            break;
                        }
                        if (complained || next == 32 || next == 9) {
                            continue;
                        }
                        reader.error('e', reader.getName(), reader.getLineNumber() + 1, reader.getColumnNumber(), "non-whitespace after '&-'");
                        complained = true;
                    }
                    lineStart = reader.tokenBufferLength;
                    nonSpace = -1;
                    continue;
                }
                if (next2 == 35) {
                    reader.skip();
                    next = reader.read();
                    if (next == 124) {
                        ReaderNestedComment.getLispInstance().readNestedComment(reader);
                    }
                    else {
                        this.readCharRef(reader, next);
                    }
                }
            }
            else {
                if (this.isNestableStartDelim(next)) {
                    ++braceNesting;
                }
                reader.tokenBufferAppend(next);
                if (next == 93 && delimiter == '<' && reader.peek() == 93) {
                    reader.skip();
                    reader.tokenBufferAppend(93);
                    if (reader.peek() == 62) {
                        reader.error('w', reader.getName(), line, column + 1, "literal ']]>' is only valid following '<![CDATA['");
                    }
                }
                next = 32;
            }
            if (reader.tokenBufferLength > 0 && (next == delimiter || next == 38 || next < 0)) {
                final String text = reader.tokenBufferString();
                reader.tokenBufferLength = 0;
                final Object tnode = this.wrapText(text);
                final Pair pair = PairWithPosition.make(tnode, reader.makeNil(), null, -1, -1);
                resultTail.setCdrBackdoor(pair);
                resultTail = pair;
            }
            if (next == 38) {
                final ReadTable rtable = ReadTable.getCurrent();
                next = reader.read();
                int endDelimiter = this.enclosedExprDelim(next, reader);
                if (endDelimiter >= 0 || next == 40) {
                    final Pair qq = reader.makePair(ReaderExtendedLiteral.startEnclosedSymbol, LList.Empty, line, column);
                    resultTail.setCdrBackdoor(qq);
                    resultTail = qq;
                    resultTail = this.readEnclosed(reader, rtable, resultTail, next, endDelimiter);
                    item = ReaderExtendedLiteral.endEnclosedSymbol;
                }
                else if (next == 126 || next == 37) {
                    boolean sawQuote = false;
                    final boolean printfStyle = next == 37;
                    final int magic = next;
                    boolean needEnclosed;
                    while (true) {
                        reader.tokenBufferAppend(next);
                        next = reader.read();
                        if (next < 0 || next == 10) {
                            reader.error('e', "non-terminated format specifier");
                            needEnclosed = false;
                            break;
                        }
                        if (sawQuote) {
                            sawQuote = false;
                        }
                        else if (next == 39 && magic == 126) {
                            sawQuote = true;
                        }
                        else {
                            if ((next >= 48 && next <= 57) || next == 43 || next == 45 || next == 32) {
                                continue;
                            }
                            if (printfStyle) {
                                if (next == 46) {
                                    continue;
                                }
                                if (next == 42) {
                                    continue;
                                }
                            }
                            else {
                                if (next == 44 || next == 35 || next == 118 || next == 86 || next == 58) {
                                    continue;
                                }
                                if (next == 64) {
                                    continue;
                                }
                            }
                            reader.tokenBufferAppend(next);
                            next = reader.read();
                            if (next == 91 || next == 40) {
                                needEnclosed = true;
                                break;
                            }
                            if (next != magic) {
                                reader.unread(next);
                                needEnclosed = false;
                                break;
                            }
                            continue;
                        }
                    }
                    final String fmt = reader.tokenBufferString();
                    endDelimiter = this.enclosedExprDelim(next, reader);
                    reader.tokenBufferLength = 0;
                    final Pair ffmt = reader.makePair(fmt, LList.Empty, line, column);
                    final Object fun = printfStyle ? ReaderExtendedLiteral.sprintfSymbol : ReaderExtendedLiteral.formatSymbol;
                    final Pair fhead = reader.makePair(fun, ffmt, line, column);
                    if (needEnclosed) {
                        this.readEnclosed(reader, rtable, ffmt, next, endDelimiter);
                    }
                    item = fhead;
                }
                else {
                    final int startPos = reader.tokenBufferLength;
                    next = this.scanTag(reader, next);
                    final String str = new String(reader.tokenBuffer, startPos, reader.tokenBufferLength - startPos);
                    reader.tokenBufferLength = startPos;
                    reader.unread(next);
                    if (next == 91 || next == 123) {
                        item = this.readNamedLiteral(reader, rtable, str, reader.read(), line, column);
                    }
                    else if (next == 59) {
                        item = this.checkEntity(reader, str);
                    }
                    else {
                        reader.error('e', "expected '[', '{', or ';'");
                    }
                }
            }
            else {
                item = this.checkDelim(reader, next, delimiter);
            }
            if (item == Special.eof) {
                break;
            }
            if (item == null) {
                continue;
            }
            final Pair pair2 = PairWithPosition.make(item, reader.makeNil(), reader.getName(), line, column + 1);
            resultTail.setCdrBackdoor(pair2);
            resultTail = pair2;
        }
        return resultTail;
    }
    
    protected Object wrapText(final String text) {
        return text;
    }
    
    protected Object readEnclosedSingleExpression(final LispReader reader, final ReadTable readTable, final int ch) throws IOException, SyntaxException {
        if (ch == 40) {
            reader.unread(ch);
            return reader.readObject();
        }
        final int endDelimiter = this.enclosedExprDelim(ch, reader);
        final Pair head = new Pair(null, LList.Empty);
        final int line = reader.getLineNumber() + 1;
        final int column = reader.getColumnNumber() + 1;
        final Pair tail = this.readEnclosedExpressions(reader, readTable, head, endDelimiter);
        if (head == tail) {
            reader.error('e', reader.getName(), line, column, "missing expression");
            return "<missing>";
        }
        final Pair first = (Pair)head.getCdr();
        if (first.getCdr() != LList.Empty) {
            reader.error('e', reader.getName(), line, column, "too many expressions");
        }
        return first.getCar();
    }
    
    protected Pair readEnclosed(final LispReader reader, final ReadTable readTable, final Pair last, final int startDelimiter, final int endDelimiter) throws IOException, SyntaxException {
        if (startDelimiter == 40) {
            return reader.readValuesAndAppend(40, readTable, last);
        }
        return this.readEnclosedExpressions(reader, readTable, last, endDelimiter);
    }
    
    protected Pair readEnclosedExpressions(final LispReader reader, final ReadTable readTable, Pair last, final int endDelimiter) throws IOException, SyntaxException {
        final InPort port = reader.getPort();
        final char saveReadState = reader.pushNesting('[');
        final int startLine = port.getLineNumber();
        final int startColumn = port.getColumnNumber();
        try {
            while (true) {
                final int line = port.getLineNumber();
                final int column = port.getColumnNumber();
                final int ch = port.read();
                if (ch == endDelimiter) {
                    break;
                }
                if (ch < 0) {
                    reader.eofError("unexpected EOF in list starting here", startLine + 1, startColumn);
                }
                last = reader.readValuesAndAppend(ch, readTable, last);
            }
            return last;
        }
        finally {
            reader.popNesting(saveReadState);
        }
    }
    
    private int scanTag(final LispReader reader, int next) throws IOException, SyntaxException {
        if (XName.isNameStart(next)) {
            do {
                reader.tokenBufferAppend(next);
                next = reader.read();
            } while (XName.isNamePart(next));
        }
        else if (next == 96 || next == 60 || next == 62) {
            int nextnext = reader.peek();
            if (next == 62 && nextnext == 62) {
                reader.tokenBufferAppend(next);
                reader.skip();
                nextnext = reader.peek();
            }
            if (nextnext == 123 || nextnext == 91) {
                reader.tokenBufferAppend(next);
                next = reader.read();
            }
        }
        return next;
    }
    
    Object checkEntity(final LispReader reader, final String str) throws IOException, SyntaxException {
        final int next = reader.read();
        if (next != 59) {
            reader.unread(next);
            reader.error("invalid entity reference");
        }
        return LispLanguage.entityNamespace.getSymbol(str);
    }
    
    void readCharRef(final LispReader reader, int next) throws IOException, SyntaxException {
        int base;
        if (next == 120) {
            base = 16;
            next = reader.read();
        }
        else {
            base = 10;
        }
        int value = 0;
        while (next >= 0) {
            final char ch = (char)next;
            final int digit = Character.digit(ch, base);
            if (digit < 0) {
                break;
            }
            if (value >= 134217728) {
                break;
            }
            value *= base;
            value += digit;
            next = reader.read();
        }
        if (next != 59) {
            reader.unread(next);
            reader.error("invalid character reference");
        }
        else if ((value > 0 && value <= 55295) || (value >= 57344 && value <= 65533) || (value >= 65536 && value <= 1114111)) {
            reader.tokenBufferAppend(value);
        }
        else {
            reader.error("invalid character value " + value);
        }
    }
    
    static {
        qstringSymbol = Symbol.valueOf("$string$");
        formatSymbol = Symbol.valueOf("$format$");
        sprintfSymbol = Symbol.valueOf("$sprintf$");
        startEnclosedSymbol = Symbol.valueOf("$<<$");
        endEnclosedSymbol = Symbol.valueOf("$>>$");
    }
}
