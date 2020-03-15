// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.text.Lexer;

public class ReaderString extends ReadTableEntry
{
    public Object read(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
        return readString(in, ch, count);
    }
    
    public static String readString(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
        final int startPos = in.tokenBufferLength;
        final InPort port = in.getPort();
        char saveReadState = '\0';
        int c = ch;
        Label_0039: {
            if (!(port instanceof InPort)) {
                break Label_0039;
            }
            saveReadState = port.readState;
            port.readState = (char)ch;
            try {
                while (true) {
                    final int prev = c;
                    if (prev == 13) {
                        c = port.read();
                        if (c == 10) {
                            continue;
                        }
                    }
                    else if (port.pos < port.limit && prev != 10) {
                        c = port.buffer[port.pos++];
                    }
                    else {
                        c = port.read();
                    }
                    if (c == ch) {
                        break;
                    }
                    switch (c) {
                        case 13: {
                            int t;
                            if (port.getConvertCR()) {
                                t = 10;
                            }
                            else {
                                t = 13;
                                c = 32;
                            }
                            in.tokenBufferAppend(t);
                            continue;
                        }
                        case 92: {
                            if (in instanceof LispReader) {
                                c = ((LispReader)in).readEscape();
                            }
                            else {
                                c = port.read();
                            }
                            if (c == -2) {
                                c = 10;
                                continue;
                            }
                            break;
                        }
                    }
                    if (c < 0) {
                        in.eofError("unexpected EOF in string literal");
                    }
                    in.tokenBufferAppend(c);
                }
                return new String(in.tokenBuffer, startPos, in.tokenBufferLength - startPos).intern();
            }
            finally {
                in.tokenBufferLength = startPos;
                if (port instanceof InPort) {
                    port.readState = saveReadState;
                }
            }
        }
    }
}
