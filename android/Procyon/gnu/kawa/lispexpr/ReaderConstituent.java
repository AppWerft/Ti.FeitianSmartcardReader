// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.text.Lexer;

public class ReaderConstituent extends ReaderMisc
{
    public ReaderConstituent(final int kind) {
        super(kind);
    }
    
    @Override
    public Object read(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
        final LispReader reader = (LispReader)in;
        final int startPos = reader.tokenBufferLength;
        final ReadTable rtable = ReadTable.getCurrent();
        final Object result = reader.readAndHandleToken(ch, startPos, rtable);
        return result;
    }
}
