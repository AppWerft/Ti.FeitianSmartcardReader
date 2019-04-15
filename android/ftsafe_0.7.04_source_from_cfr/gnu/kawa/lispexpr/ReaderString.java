/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderString
extends ReadTableEntry {
    @Override
    public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        return ReaderString.readString(in, ch, count);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String readString(Lexer in, int ch, int count) throws IOException, SyntaxException {
        int startPos = in.tokenBufferLength;
        InPort port = in.getPort();
        char saveReadState = '\u0000';
        int c = ch;
        if (port instanceof InPort) {
            saveReadState = port.readState;
            port.readState = (char)ch;
        }
        try {
            block7 : do {
                int prev;
                if ((prev = c) == 13) {
                    c = port.read();
                    if (c == 10) {
                        continue;
                    }
                } else {
                    c = port.pos < port.limit && prev != 10 ? port.buffer[port.pos++] : port.read();
                }
                if (c == ch) break;
                switch (c) {
                    case 13: {
                        int t;
                        if (port.getConvertCR()) {
                            t = 10;
                        } else {
                            t = 13;
                            c = 32;
                        }
                        in.tokenBufferAppend(t);
                        continue block7;
                    }
                    case 92: {
                        c = in instanceof LispReader ? ((LispReader)in).readEscape() : port.read();
                        if (c != -2) break;
                        c = 10;
                        continue block7;
                    }
                }
                if (c < 0) {
                    in.eofError("unexpected EOF in string literal");
                }
                in.tokenBufferAppend(c);
            } while (true);
            String t = new String(in.tokenBuffer, startPos, in.tokenBufferLength - startPos).intern();
            return t;
        }
        finally {
            in.tokenBufferLength = startPos;
            if (port instanceof InPort) {
                port.readState = saveReadState;
            }
        }
    }
}

