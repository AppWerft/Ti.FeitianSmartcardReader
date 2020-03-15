// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.mapping.Values;
import gnu.lists.Pair;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.kawa.io.InPort;
import gnu.text.Lexer;

public final class ReaderParens extends ReadTableEntry
{
    char open;
    char close;
    int kind;
    Object command;
    private static ReaderParens instance;
    
    @Override
    public int getKind() {
        return this.kind;
    }
    
    public static ReaderParens getInstance(final char open, final char close) {
        return getInstance(open, close, 5);
    }
    
    public static ReaderParens getInstance(final char open, final char close, final int kind) {
        if (open == '(' && close == ')' && kind == 5) {
            if (ReaderParens.instance == null) {
                ReaderParens.instance = new ReaderParens(open, close, kind, null);
            }
            return ReaderParens.instance;
        }
        return new ReaderParens(open, close, kind, null);
    }
    
    public static ReaderParens getInstance(final char open, final char close, final int kind, final Object command) {
        if (command == null) {
            return getInstance(open, close, kind);
        }
        return new ReaderParens(open, close, kind, command);
    }
    
    public ReaderParens(final char open, final char close, final int kind, final Object command) {
        this.open = open;
        this.close = close;
        this.kind = kind;
        this.command = command;
    }
    
    @Override
    public Object read(final Lexer in, final int ch, final int count, int sharingIndex) throws IOException, SyntaxException {
        Object p = null;
        if (this.command != null) {
            final InPort port = in.getPort();
            final int startLine = port.getLineNumber();
            final int startColumn = port.getColumnNumber();
            p = ((LispReader)in).makePair(this.command, startLine, startColumn - 1);
            ((LispReader)in).bindSharedObject(sharingIndex, p);
            sharingIndex = -1;
        }
        return readList((LispReader)in, p, ch, count, this.close, sharingIndex);
    }
    
    public static Object readList(final LispReader lexer, Object last, int ch, final int count, final int close, int sharingIndex) throws IOException, SyntaxException {
        final InPort port = lexer.getPort();
        final char saveReadState = lexer.pushNesting((close == 93) ? '[' : '(');
        final int startLine = port.getLineNumber();
        final int startColumn = port.getColumnNumber();
        try {
            Object list = (last == null) ? lexer.makeNil() : last;
            boolean sawDot = false;
            boolean sawDotCdr = false;
            final ReadTable readTable = ReadTable.getCurrent();
            while (true) {
                final int line = port.getLineNumber();
                int column = port.getColumnNumber();
                ch = port.read();
                if (ch == close) {
                    break;
                }
                if (ch < 0) {
                    if (lexer.isTentative()) {
                        final Object value = Pair.incompleteListMarker;
                        if (last == null) {
                            list = value;
                        }
                        else {
                            lexer.setCdr(last, value);
                        }
                        return list;
                    }
                    lexer.eofError("unexpected EOF in list starting here", startLine + 1, startColumn);
                }
                ReadTableEntry entry;
                if (ch == 46) {
                    ch = port.peek();
                    entry = readTable.lookup(ch);
                    final int kind = entry.getKind();
                    if (kind == 1 || kind == 5 || kind == 0) {
                        port.skip();
                        ++column;
                        if (ch == close) {
                            lexer.error("unexpected '" + (char)close + "' after '.'");
                            break;
                        }
                        if (ch < 0) {
                            lexer.eofError("unexpected EOF in list starting here", startLine + 1, startColumn);
                        }
                        if (sawDot) {
                            lexer.error("multiple '.' in list");
                            sawDotCdr = false;
                            list = lexer.makeNil();
                            last = null;
                        }
                        sawDot = true;
                    }
                    else {
                        ch = 46;
                        entry = ReadTableEntry.getConstituentInstance();
                    }
                }
                else {
                    entry = readTable.lookup(ch);
                }
                Object first = null;
                if (!sawDot && last == null) {
                    first = lexer.makePair(null, startLine, startColumn - 1);
                    lexer.bindSharedObject(sharingIndex, first);
                }
                Object value2 = lexer.readValues(ch, entry, readTable, -1);
                if (value2 == Values.empty) {
                    continue;
                }
                value2 = lexer.handlePostfix(value2, readTable, line, column);
                if (sawDotCdr) {
                    lexer.error("multiple values after '.'");
                    last = null;
                    list = lexer.makeNil();
                    sawDotCdr = false;
                }
                else {
                    if (sawDot) {
                        sawDotCdr = true;
                    }
                    else if (last == null) {
                        lexer.setCar(first, value2);
                        value2 = first;
                        sharingIndex = -1;
                    }
                    else {
                        value2 = lexer.makePair(value2, line, column);
                    }
                    if (last == null) {
                        list = value2;
                    }
                    else {
                        lexer.setCdr(last, value2);
                    }
                    last = value2;
                }
            }
            if (sawDot && !sawDotCdr) {
                lexer.error("missing value after '.'");
            }
            return lexer.bindSharedObject(sharingIndex, list);
        }
        finally {
            lexer.popNesting(saveReadState);
        }
    }
}
