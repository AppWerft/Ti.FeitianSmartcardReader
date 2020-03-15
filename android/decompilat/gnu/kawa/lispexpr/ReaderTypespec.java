// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.kawa.io.InPort;
import gnu.text.Lexer;

public class ReaderTypespec extends ReaderConstituent
{
    public ReaderTypespec() {
        super(6);
    }
    
    @Override
    public Object read(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
        if (!(in instanceof LispReader)) {
            return super.read(in, ch, count);
        }
        final int endChar = (ch == 60) ? 62 : -2;
        final LispReader reader = (LispReader)in;
        final int startPos = in.tokenBufferLength;
        final InPort port = in.getPort();
        final ReadTable rtable = ReadTable.getCurrent();
        char saveReadState = '\0';
        in.tokenBufferAppend(ch);
        int c = ch;
        if (port instanceof InPort) {
            saveReadState = port.readState;
            port.readState = (char)ch;
        }
        try {
            boolean got_open_square = false;
            while (true) {
                final int prev = c;
                if (port.pos < port.limit && prev != 10) {
                    c = port.buffer[port.pos++];
                }
                else {
                    c = port.read();
                }
                if (c == 92) {
                    in.tokenBufferAppend(65535);
                    reader.seenEscapes = true;
                }
                else {
                    if (c == endChar && !got_open_square) {
                        reader.readToken(62, rtable);
                        break;
                    }
                    final int kind;
                    if ((got_open_square || c != 91 || !(got_open_square = true)) && (got_open_square || c != 93 || (got_open_square = false)) && (kind = rtable.lookup(c).getKind()) != 2 && kind != 6) {
                        in.unread(c);
                        break;
                    }
                    in.tokenBufferAppend(c);
                }
            }
            return reader.handleToken(startPos, rtable);
        }
        finally {
            in.tokenBufferLength = startPos;
            if (port instanceof InPort) {
                port.readState = saveReadState;
            }
        }
    }
}
