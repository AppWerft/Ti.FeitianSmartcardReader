// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import java.io.Reader;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.mapping.Procedure;

public class ReaderDispatchMacro extends ReaderMisc
{
    Procedure procedure;
    
    public ReaderDispatchMacro(final Procedure procedure) {
        super(5);
        this.procedure = procedure;
    }
    
    public Procedure getProcedure() {
        return this.procedure;
    }
    
    @Override
    public Object read(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
        final Reader reader = in.getPort();
        try {
            return this.procedure.apply3(reader, Char.make(ch), IntNum.make(count));
        }
        catch (IOException ex) {
            throw ex;
        }
        catch (SyntaxException ex2) {
            throw ex2;
        }
        catch (Error ex3) {
            throw ex3;
        }
        catch (Throwable ex4) {
            in.fatal("reader macro '" + this.procedure + "' threw: " + ex4);
            return null;
        }
    }
}
