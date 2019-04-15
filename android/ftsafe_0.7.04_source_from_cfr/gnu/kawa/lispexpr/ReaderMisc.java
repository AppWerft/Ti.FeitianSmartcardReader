/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderMisc
extends ReadTableEntry {
    int kind;

    public ReaderMisc(int kind) {
        this.kind = kind;
    }

    @Override
    public int getKind() {
        return this.kind;
    }

    @Override
    public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        if (this.kind == 0) {
            String msg = "invalid character #\\" + (char)ch;
            if (in.isInteractive()) {
                in.fatal(msg);
            } else {
                in.error(msg);
            }
        }
        return Values.empty;
    }
}

