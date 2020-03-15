// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import java.io.Reader;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.mapping.Procedure;

public class ReaderMacro extends ReaderMisc
{
    Procedure procedure;
    
    public ReaderMacro(final Procedure procedure, final boolean nonTerminating) {
        super(nonTerminating ? 6 : 5);
        this.procedure = procedure;
    }
    
    public ReaderMacro(final Procedure procedure) {
        super(5);
        this.procedure = procedure;
    }
    
    public boolean isNonTerminating() {
        return this.kind == 6;
    }
    
    public Procedure getProcedure() {
        return this.procedure;
    }
    
    @Override
    public Object read(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
        final Reader reader = in.getPort();
        try {
            return this.procedure.apply2(reader, Char.make(ch));
        }
        catch (IOException ex) {
            throw ex;
        }
        catch (SyntaxException ex2) {
            throw ex2;
        }
        catch (Throwable ex3) {
            in.fatal("reader macro '" + this.procedure + "' threw: " + ex3);
            return null;
        }
    }
}
