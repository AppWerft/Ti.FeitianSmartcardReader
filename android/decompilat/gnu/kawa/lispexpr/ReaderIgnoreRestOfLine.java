// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.kawa.io.InPort;
import gnu.mapping.Values;
import gnu.lists.Sequence;
import gnu.kawa.io.BinaryInPort;
import gnu.text.Lexer;

public class ReaderIgnoreRestOfLine extends ReadTableEntry
{
    static ReaderIgnoreRestOfLine instance;
    public boolean checkEncodingSpec;
    
    public ReaderIgnoreRestOfLine() {
        this.checkEncodingSpec = true;
    }
    
    public static ReaderIgnoreRestOfLine getInstance() {
        return ReaderIgnoreRestOfLine.instance;
    }
    
    public Object read(final Lexer in, int ch, final int count) throws IOException, SyntaxException {
        final InPort port = in.getPort();
        StringBuilder buf = null;
        if (port instanceof BinaryInPort && this.checkEncodingSpec) {
            final int lineno = port.getLineNumber();
            if (lineno == 0 || lineno == 1) {
                buf = new StringBuilder();
            }
        }
        do {
            ch = in.read();
            if (ch < 0) {
                return Sequence.eofValue;
            }
            if (buf == null) {
                continue;
            }
            buf.append((char)ch);
        } while (ch != 10 && ch != 13);
        if (buf != null) {
            ((LispReader)in).checkEncodingSpec(buf.toString());
        }
        in.unread(ch);
        return Values.empty;
    }
    
    static {
        ReaderIgnoreRestOfLine.instance = new ReaderIgnoreRestOfLine();
    }
}
