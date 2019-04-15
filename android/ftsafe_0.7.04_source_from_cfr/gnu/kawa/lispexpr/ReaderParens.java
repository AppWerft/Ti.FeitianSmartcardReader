/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.lists.Pair;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public final class ReaderParens
extends ReadTableEntry {
    char open;
    char close;
    int kind;
    Object command;
    private static ReaderParens instance;

    @Override
    public int getKind() {
        return this.kind;
    }

    public static ReaderParens getInstance(char open, char close) {
        return ReaderParens.getInstance(open, close, 5);
    }

    public static ReaderParens getInstance(char open, char close, int kind) {
        if (open == '(' && close == ')' && kind == 5) {
            if (instance == null) {
                instance = new ReaderParens(open, close, kind, null);
            }
            return instance;
        }
        return new ReaderParens(open, close, kind, null);
    }

    public static ReaderParens getInstance(char open, char close, int kind, Object command) {
        if (command == null) {
            return ReaderParens.getInstance(open, close, kind);
        }
        return new ReaderParens(open, close, kind, command);
    }

    public ReaderParens(char open, char close, int kind, Object command) {
        this.open = open;
        this.close = close;
        this.kind = kind;
        this.command = command;
    }

    @Override
    public Object read(Lexer in, int ch, int count, int sharingIndex) throws IOException, SyntaxException {
        Pair p = null;
        if (this.command != null) {
            InPort port = in.getPort();
            int startLine = port.getLineNumber();
            int startColumn = port.getColumnNumber();
            p = ((LispReader)in).makePair(this.command, startLine, startColumn - 1);
            ((LispReader)in).bindSharedObject(sharingIndex, p);
            sharingIndex = -1;
        }
        return ReaderParens.readList((LispReader)in, p, ch, count, this.close, sharingIndex);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Object readList(LispReader lexer, Object last, int ch, int count, int close, int sharingIndex) throws IOException, SyntaxException {
        InPort port = lexer.getPort();
        char saveReadState = lexer.pushNesting(close == 93 ? (char)'[' : '(');
        int startLine = port.getLineNumber();
        int startColumn = port.getColumnNumber();
        try {
            Object list = last == null ? lexer.makeNil() : last;
            boolean sawDot = false;
            boolean sawDotCdr = false;
            ReadTable readTable = ReadTable.getCurrent();
            do {
                ReadTableEntry entry;
                Object value;
                int line = port.getLineNumber();
                int column = port.getColumnNumber();
                ch = port.read();
                if (ch == close) break;
                if (ch < 0) {
                    if (lexer.isTentative()) {
                        Pair value2 = Pair.incompleteListMarker;
                        if (last == null) {
                            list = value2;
                        } else {
                            lexer.setCdr(last, value2);
                        }
                        Object object2 = list;
                        return object2;
                    }
                    lexer.eofError("unexpected EOF in list starting here", startLine + 1, startColumn);
                }
                if (ch == 46) {
                    ch = port.peek();
                    entry = readTable.lookup(ch);
                    int kind = entry.getKind();
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
                    } else {
                        ch = 46;
                        entry = ReadTableEntry.getConstituentInstance();
                    }
                } else {
                    entry = readTable.lookup(ch);
                }
                Pair first = null;
                if (!sawDot && last == null) {
                    first = lexer.makePair(null, startLine, startColumn - 1);
                    lexer.bindSharedObject(sharingIndex, first);
                }
                if ((value = lexer.readValues(ch, entry, readTable, -1)) == Values.empty) continue;
                value = lexer.handlePostfix(value, readTable, line, column);
                if (sawDotCdr) {
                    lexer.error("multiple values after '.'");
                    last = null;
                    list = lexer.makeNil();
                    sawDotCdr = false;
                    continue;
                }
                if (sawDot) {
                    sawDotCdr = true;
                } else if (last == null) {
                    lexer.setCar(first, value);
                    value = first;
                    sharingIndex = -1;
                } else {
                    value = lexer.makePair(value, line, column);
                }
                if (last == null) {
                    list = value;
                } else {
                    lexer.setCdr(last, value);
                }
                last = value;
            } while (true);
            if (sawDot && !sawDotCdr) {
                lexer.error("missing value after '.'");
            }
            Object line = lexer.bindSharedObject(sharingIndex, list);
            return line;
        }
        finally {
            lexer.popNesting(saveReadState);
        }
    }
}

