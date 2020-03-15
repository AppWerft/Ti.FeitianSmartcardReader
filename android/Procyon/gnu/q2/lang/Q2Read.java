// 
// Decompiled by Procyon v0.5.36
// 

package gnu.q2.lang;

import gnu.text.Lexer;
import gnu.kawa.lispexpr.ReaderDispatchMisc;
import gnu.expr.Special;
import gnu.lists.Sequence;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.lists.PairWithPosition;
import gnu.mapping.Values;
import gnu.lists.Pair;
import kawa.standard.begin;
import gnu.expr.ReferenceExp;
import kawa.lang.Translator;
import gnu.expr.Compilation;
import gnu.mapping.Symbol;
import gnu.kawa.lispexpr.ReadTable;
import gnu.lists.LList;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.text.SourceMessages;
import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LispReader;

public class Q2Read extends LispReader
{
    int curIndentation;
    boolean resetNeeded;
    String expressionStartFile;
    int expressionStartLine;
    int expressionStartColumn;
    
    void init() {
        this.port.readState = ' ';
    }
    
    public Q2Read(final InPort port) {
        super(port);
        this.init();
    }
    
    public Q2Read(final InPort port, final SourceMessages messages) {
        super(port, messages);
        this.init();
    }
    
    int skipIndentation() throws IOException, SyntaxException {
        int numTabs = 0;
        int numSpaces = 0;
        int ch;
        for (ch = this.port.read(); ch == 9; ch = this.port.read()) {
            ++numTabs;
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
    
    Object readIndentCommand(final boolean singleLine) throws IOException, SyntaxException {
        final int startIndentation = this.curIndentation;
        LList rresult = LList.Empty;
        final Object obj = LList.Empty;
        final PairWithPosition pair = null;
        final PairWithPosition last = null;
        Object prev = null;
        final ReadTable rtable = ReadTable.getCurrent();
    Label_0395_Outer:
        while (true) {
            int ch = this.read();
            if (ch < 0) {
                break;
            }
            if (ch == 32) {
                continue;
            }
            if (ch == 9) {
                continue;
            }
            this.unread();
            if (ch == 41) {
                break;
            }
            if (ch == 13 || ch == 10) {
                Operator rhsNeeded = null;
                if (singleLine) {
                    if (!(prev instanceof Symbol) || Q2.instance.selfEvaluatingSymbol(prev)) {
                        break;
                    }
                    final Compilation comp = Compilation.getCurrent();
                    final Expression func = ((Translator)comp).rewrite(prev, true);
                    final Declaration decl;
                    final Object value;
                    if (!(func instanceof ReferenceExp) || (decl = ((ReferenceExp)func).getBinding()) == null || !((value = decl.getConstantValue()) instanceof Operator) || (((Operator)value).flags & 0x2) == 0x0) {
                        break;
                    }
                    rhsNeeded = (Operator)value;
                }
                ch = this.read();
                this.port.mark(Integer.MAX_VALUE);
                this.resetNeeded = true;
                final int subIndentation = this.skipIndentation();
                if (subIndentation == -1 && rhsNeeded != null) {
                    this.eofError("missing right operand after " + rhsNeeded.getName());
                }
                LList qresult = LList.Empty;
                this.curIndentation = subIndentation;
                while (true) {
                    while (this.curIndentation != -1) {
                        if (subIndentation == this.curIndentation) {
                            final int comparedIndent = Q2.compareIndentation(subIndentation, startIndentation);
                            if (comparedIndent == Integer.MIN_VALUE) {
                                this.error('e', "cannot compare indentation - mix of tabs and spaces");
                            }
                            else {
                                if (comparedIndent == -1 || comparedIndent == 1) {
                                    this.error('e', "indentation must differ by 2 or more");
                                }
                                else if (comparedIndent <= 0) {
                                    break;
                                }
                                final int line = this.port.getLineNumber();
                                final int column = this.port.getColumnNumber();
                                final Object val = this.readIndentCommand(false);
                                if (val != LList.Empty) {
                                    qresult = this.makePair(val, qresult, line, column);
                                    continue Label_0395_Outer;
                                }
                            }
                        }
                        if (qresult != LList.Empty) {
                            qresult = new Pair(begin.begin, LList.reverseInPlace(qresult));
                            rresult = new Pair(qresult, rresult);
                        }
                        prev = qresult;
                        break Label_0395_Outer;
                    }
                    continue;
                }
            }
            final int line2 = this.port.getLineNumber();
            final int column2 = this.port.getColumnNumber();
            ch = this.port.read();
            if (ch < 0) {
                break;
            }
            Object val2 = this.readValues(ch, rtable, -1);
            if ((prev = val2) == Values.empty) {
                continue;
            }
            val2 = this.handlePostfix(val2, rtable, line2, column2);
            rresult = this.makePair(val2, rresult, line2, column2);
        }
        return this.makeCommand(LList.reverseInPlace(rresult));
    }
    
    Object makeCommand(final Object command) {
        return command;
    }
    
    boolean singleLine() {
        return this.isInteractive() && this.nesting <= 1;
    }
    
    @Override
    public Object readCommand() throws IOException, SyntaxException {
        final int indent = this.skipIndentation();
        if (indent < 0) {
            return Sequence.eofValue;
        }
        this.curIndentation = indent;
        final char saveReadState = this.pushNesting('-');
        try {
            final Object result = this.readIndentCommand(this.singleLine());
            if (this.resetNeeded) {
                this.resetNeeded = false;
                final int line = this.port.getLineNumber();
                final int column = this.port.getColumnNumber();
                this.port.reset();
            }
            if (result instanceof Pair) {
                final Pair presult = (Pair)result;
                if (presult.getCdr() == LList.Empty && presult.getCar() == Special.eof) {
                    return Special.eof;
                }
            }
            return result;
        }
        finally {
            this.popNesting(saveReadState);
        }
    }
    
    public static Object readObject(final InPort port) throws IOException, SyntaxException {
        return new Q2Read(port).readObject();
    }
    
    void saveExpressionStartPosition() {
        this.expressionStartFile = this.port.getName();
        this.expressionStartLine = this.port.getLineNumber();
        this.expressionStartColumn = this.port.getColumnNumber();
    }
    
    static class ReadTableEntry extends ReaderDispatchMisc
    {
        @Override
        public Object read(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
            switch (ch) {
                case 40: {
                    return this.readParens(in);
                }
                case 59: {
                    return Symbol.valueOf(";");
                }
                default: {
                    throw new Error();
                }
            }
        }
        
        public Object readParens(final Lexer in) throws IOException, SyntaxException {
            final Q2Read reader = (Q2Read)in;
            final char saveReadState = reader.pushNesting('(');
            final int startLine = reader.getLineNumber();
            final int startColumn = reader.getColumnNumber();
            try {
                final Object result = reader.readIndentCommand(false);
                final InPort port = reader.getPort();
                final int ch = port.peek();
                if (ch == 41) {
                    port.skip();
                }
                else {
                    final String msg = "missing ')' after '(' starting here";
                    if (ch < 0) {
                        reader.eofError(msg, startLine + 1, startColumn);
                    }
                    else {
                        reader.error('e', port.getName(), startLine + 1, startColumn, msg);
                    }
                }
                if (reader.resetNeeded) {
                    reader.resetNeeded = false;
                    port.mark(0);
                }
                return reader.makeCommand(result);
            }
            finally {
                reader.popNesting(saveReadState);
            }
        }
    }
}
