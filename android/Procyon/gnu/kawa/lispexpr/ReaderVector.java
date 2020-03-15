// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.lists.Pair;
import gnu.lists.LList;
import gnu.lists.FVector;
import gnu.kawa.io.InPort;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.text.Lexer;

public class ReaderVector extends ReadTableEntry
{
    char close;
    
    public ReaderVector(final char close) {
        this.close = close;
    }
    
    @Override
    public Object read(final Lexer in, final int ch, final int count, final int sharingIndex) throws IOException, SyntaxException {
        return readVector((LispReader)in, in.getPort(), count, this.close, sharingIndex);
    }
    
    public static FVector readVector(final LispReader lexer, final InPort port, final int count, final char close, final int sharingIndex) throws IOException, SyntaxException {
        char saveReadState = ' ';
        if (port instanceof InPort) {
            saveReadState = port.readState;
            port.readState = ((close == ']') ? '[' : '(');
        }
        final int startLine = port.getLineNumber();
        final int startColumn = port.getColumnNumber() - 1;
        try {
            final FVector result = new FVector();
            lexer.bindSharedObject(sharingIndex, result);
            final ReadTable rtable = ReadTable.getCurrent();
            Pair last;
            final Pair head = last = new Pair(null, LList.Empty);
            while (true) {
                final int ch = lexer.read();
                if (ch < 0) {
                    lexer.eofError("unexpected EOF in vector starting here", startLine + 1, startColumn);
                }
                if (ch == close) {
                    break;
                }
                last = lexer.readValuesAndAppend(ch, rtable, last);
            }
            result.replaceAll(((LList)head.getCdr()).toArray());
            result.setReadOnly();
            return result;
        }
        finally {
            if (port instanceof InPort) {
                port.readState = saveReadState;
            }
        }
    }
}
