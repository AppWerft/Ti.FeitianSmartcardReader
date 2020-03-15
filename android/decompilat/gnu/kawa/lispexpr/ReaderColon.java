// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.text.Lexer;

public class ReaderColon extends ReadTableEntry
{
    @Override
    public int getKind() {
        return 6;
    }
    
    public Object read(final Lexer in, int ch, final int count) throws IOException, SyntaxException {
        final LispReader reader = (LispReader)in;
        final ReadTable rtable = ReadTable.getCurrent();
        final int startPos = reader.tokenBufferLength;
        if (ch == rtable.postfixLookupOperator) {
            final int next = reader.read();
            if (next == 58) {
                return rtable.makeSymbol("::");
            }
            reader.tokenBufferAppend(ch);
            ch = next;
        }
        return reader.readAndHandleToken(ch, startPos, rtable);
    }
}
