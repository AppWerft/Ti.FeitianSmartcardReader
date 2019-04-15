/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.ReaderMisc;
import gnu.mapping.Procedure;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderMacro
extends ReaderMisc {
    Procedure procedure;

    public ReaderMacro(Procedure procedure, boolean nonTerminating) {
        super(nonTerminating ? 6 : 5);
        this.procedure = procedure;
    }

    public ReaderMacro(Procedure procedure) {
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
    public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        InPort reader = in.getPort();
        try {
            return this.procedure.apply2(reader, Char.make(ch));
        }
        catch (IOException ex) {
            throw ex;
        }
        catch (SyntaxException ex) {
            throw ex;
        }
        catch (Throwable ex) {
            in.fatal("reader macro '" + this.procedure + "' threw: " + ex);
            return null;
        }
    }
}

