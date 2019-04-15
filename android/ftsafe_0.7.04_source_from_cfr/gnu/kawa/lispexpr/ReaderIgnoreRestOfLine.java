/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.lists.Sequence;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderIgnoreRestOfLine
extends ReadTableEntry {
    static ReaderIgnoreRestOfLine instance = new ReaderIgnoreRestOfLine();
    public boolean checkEncodingSpec = true;

    public static ReaderIgnoreRestOfLine getInstance() {
        return instance;
    }

    @Override
    public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        int lineno;
        InPort port = in.getPort();
        StringBuilder buf = null;
        if (port instanceof BinaryInPort && this.checkEncodingSpec && ((lineno = port.getLineNumber()) == 0 || lineno == 1)) {
            buf = new StringBuilder();
        }
        do {
            if ((ch = in.read()) < 0) {
                return Sequence.eofValue;
            }
            if (buf == null) continue;
            buf.append((char)ch);
        } while (ch != 10 && ch != 13);
        if (buf != null) {
            ((LispReader)in).checkEncodingSpec(buf.toString());
        }
        in.unread(ch);
        return Values.empty;
    }
}

