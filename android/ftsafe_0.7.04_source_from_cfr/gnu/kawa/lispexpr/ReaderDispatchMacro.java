/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.ReaderMisc;
import gnu.mapping.Procedure;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderDispatchMacro
extends ReaderMisc {
    Procedure procedure;

    public ReaderDispatchMacro(Procedure procedure) {
        super(5);
        this.procedure = procedure;
    }

    public Procedure getProcedure() {
        return this.procedure;
    }

    @Override
    public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        InPort reader = in.getPort();
        try {
            return this.procedure.apply3(reader, Char.make(ch), IntNum.make(count));
        }
        catch (IOException ex) {
            throw ex;
        }
        catch (SyntaxException ex) {
            throw ex;
        }
        catch (Error ex) {
            throw ex;
        }
        catch (Throwable ex) {
            in.fatal("reader macro '" + this.procedure + "' threw: " + ex);
            return null;
        }
    }
}

