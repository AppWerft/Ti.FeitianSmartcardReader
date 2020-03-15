// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.mapping.Values;
import gnu.text.Lexer;

public class ReaderMisc extends ReadTableEntry
{
    int kind;
    
    public ReaderMisc(final int kind) {
        this.kind = kind;
    }
    
    @Override
    public int getKind() {
        return this.kind;
    }
    
    public Object read(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
        if (this.kind == 0) {
            final String msg = "invalid character #\\" + (char)ch;
            if (in.isInteractive()) {
                in.fatal(msg);
            }
            else {
                in.error(msg);
            }
        }
        return Values.empty;
    }
}
