/*
 * Decompiled with CFR 0.139.
 */
package gnu.q2.lang;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ReferenceExp;
import gnu.expr.Special;
import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReaderDispatchMisc;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.q2.lang.Operator;
import gnu.q2.lang.Q2;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import kawa.lang.Syntax;
import kawa.lang.Translator;
import kawa.standard.begin;

public class Q2Read
extends LispReader {
    int curIndentation;
    boolean resetNeeded;
    String expressionStartFile;
    int expressionStartLine;
    int expressionStartColumn;

    void init() {
        this.port.readState = (char)32;
    }

    public Q2Read(InPort port) {
        super(port);
        this.init();
    }

    public Q2Read(InPort port, SourceMessages messages) {
        super(port, messages);
        this.init();
    }

    int skipIndentation() throws IOException, SyntaxException {
        int numTabs = 0;
        int numSpaces = 0;
        int ch = this.port.read();
        while (ch == 9) {
            ++numTabs;
            ch = this.port.read();
        }
        while (ch == 32) {
            ++numSpaces;
            ch = this.port.read();
        }
        if (ch < 0) {
            return -1;
        }
        this.port.unread();
        return (numTabs << 16) + numSpaces;
    }

    Object readIndentCommand(boolean singleLine) throws IOException, SyntaxException {
        int ch;
        int startIndentation = this.curIndentation;
        LList rresult = LList.Empty;
        EmptyList obj = LList.Empty;
        Object pair = null;
        Object last = null;
        Object prev = null;
        ReadTable rtable = ReadTable.getCurrent();
        while ((ch = this.read()) >= 0) {
            Object val;
            if (ch == 32 || ch == 9) continue;
            this.unread();
            if (ch == 41) break;
            if (ch == 13 || ch == 10) {
                Syntax rhsNeeded = null;
                if (singleLine) {
                    Declaration decl;
                    Compilation comp;
                    Object value;
                    Expression func;
                    if (!(prev instanceof Symbol) || Q2.instance.selfEvaluatingSymbol(prev) || !((func = ((Translator)(comp = Compilation.getCurrent())).rewrite(prev, true)) instanceof ReferenceExp) || (decl = ((ReferenceExp)func).getBinding()) == null || !((value = decl.getConstantValue()) instanceof Operator) || (((Operator)value).flags & 2) == 0) break;
                    rhsNeeded = (Operator)value;
                }
                ch = this.read();
                this.port.mark(Integer.MAX_VALUE);
                this.resetNeeded = true;
                int subIndentation = this.skipIndentation();
                if (subIndentation == -1 && rhsNeeded != null) {
                    this.eofError("missing right operand after " + rhsNeeded.getName());
                }
                LList qresult = LList.Empty;
                this.curIndentation = subIndentation;
                while (this.curIndentation != -1 && subIndentation == this.curIndentation) {
                    int comparedIndent = Q2.compareIndentation(subIndentation, startIndentation);
                    if (comparedIndent == Integer.MIN_VALUE) {
                        this.error('e', "cannot compare indentation - mix of tabs and spaces");
                        break;
                    }
                    if (comparedIndent == -1 || comparedIndent == 1) {
                        this.error('e', "indentation must differ by 2 or more");
                    } else if (comparedIndent <= 0) break;
                    int line = this.port.getLineNumber();
                    int column = this.port.getColumnNumber();
                    Object val2 = this.readIndentCommand(false);
                    if (val2 == LList.Empty) break;
                    qresult = this.makePair(val2, qresult, line, column);
                }
                if (qresult != LList.Empty) {
                    qresult = new Pair(begin.begin, LList.reverseInPlace(qresult));
                    rresult = new Pair(qresult, rresult);
                }
                prev = qresult;
                break;
            }
            int line = this.port.getLineNumber();
            int column = this.port.getColumnNumber();
            ch = this.port.read();
            if (ch < 0) break;
            prev = val = this.readValues(ch, rtable, -1);
            if (val == Values.empty) continue;
            val = this.handlePostfix(val, rtable, line, column);
            rresult = this.makePair(val, rresult, line, column);
        }
        return this.makeCommand(LList.reverseInPlace(rresult));
    }

    Object makeCommand(Object command) {
        return command;
    }

    boolean singleLine() {
        return this.isInteractive() && this.nesting <= 1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object readCommand() throws IOException, SyntaxException {
        int indent = this.skipIndentation();
        if (indent < 0) {
            return Sequence.eofValue;
        }
        this.curIndentation = indent;
        char saveReadState = this.pushNesting('-');
        try {
            Pair presult22;
            Object result = this.readIndentCommand(this.singleLine());
            if (this.resetNeeded) {
                this.resetNeeded = false;
                int line = this.port.getLineNumber();
                int column = this.port.getColumnNumber();
                this.port.reset();
            }
            if (result instanceof Pair && (presult22 = (Pair)result).getCdr() == LList.Empty && presult22.getCar() == Special.eof) {
                Object column = Special.eof;
                return column;
            }
            Object presult22 = result;
            return presult22;
        }
        finally {
            this.popNesting(saveReadState);
        }
    }

    public static Object readObject(InPort port) throws IOException, SyntaxException {
        return new Q2Read(port).readObject();
    }

    void saveExpressionStartPosition() {
        this.expressionStartFile = this.port.getName();
        this.expressionStartLine = this.port.getLineNumber();
        this.expressionStartColumn = this.port.getColumnNumber();
    }

    static class ReadTableEntry
    extends ReaderDispatchMisc {
        ReadTableEntry() {
        }

        @Override
        public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
            switch (ch) {
                case 40: {
                    return this.readParens(in);
                }
                case 59: {
                    return Symbol.valueOf(";");
                }
            }
            throw new Error();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object readParens(Lexer in) throws IOException, SyntaxException {
            Q2Read reader = (Q2Read)in;
            char saveReadState = reader.pushNesting('(');
            int startLine = reader.getLineNumber();
            int startColumn = reader.getColumnNumber();
            try {
                Object msg;
                Object result = reader.readIndentCommand(false);
                InPort port = reader.getPort();
                int ch = port.peek();
                if (ch == 41) {
                    port.skip();
                } else {
                    msg = "missing ')' after '(' starting here";
                    if (ch < 0) {
                        reader.eofError((String)msg, startLine + 1, startColumn);
                    } else {
                        reader.error('e', port.getName(), startLine + 1, startColumn, (String)msg);
                    }
                }
                if (reader.resetNeeded) {
                    reader.resetNeeded = false;
                    port.mark(0);
                }
                msg = reader.makeCommand(result);
                return msg;
            }
            finally {
                reader.popNesting(saveReadState);
            }
        }
    }

}

