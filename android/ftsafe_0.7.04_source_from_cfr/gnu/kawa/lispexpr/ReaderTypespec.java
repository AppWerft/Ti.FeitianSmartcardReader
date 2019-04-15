/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.kawa.lispexpr.ReaderConstituent;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderTypespec
extends ReaderConstituent {
    public ReaderTypespec() {
        super(6);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        if (!(in instanceof LispReader)) {
            return super.read(in, ch, count);
        }
        int endChar = ch == 60 ? 62 : -2;
        LispReader reader = (LispReader)in;
        int startPos = in.tokenBufferLength;
        InPort port = in.getPort();
        ReadTable rtable = ReadTable.getCurrent();
        char saveReadState = '\u0000';
        in.tokenBufferAppend(ch);
        int c = ch;
        if (port instanceof InPort) {
            saveReadState = port.readState;
            port.readState = (char)ch;
        }
        try {
            block13 : {
                boolean got_open_square = false;
                do {
                    block15 : {
                        int kind;
                        block16 : {
                            block14 : {
                                int prev = c;
                                c = port.pos < port.limit && prev != 10 ? port.buffer[port.pos++] : port.read();
                                if (c == 92) {
                                    in.tokenBufferAppend(65535);
                                    reader.seenEscapes = true;
                                    continue;
                                }
                                if (c == endChar && !got_open_square) {
                                    reader.readToken(62, rtable);
                                    break block13;
                                }
                                if (got_open_square || c != 91) break block14;
                                got_open_square = true;
                                if (true) break block15;
                            }
                            if (!got_open_square || c != 93) break block16;
                            got_open_square = false;
                            if (!false) break block15;
                        }
                        if ((kind = rtable.lookup(c).getKind()) != 2 && kind != 6) break;
                    }
                    in.tokenBufferAppend(c);
                } while (true);
                in.unread(c);
            }
            Object object2 = reader.handleToken(startPos, rtable);
            return object2;
        }
        finally {
            in.tokenBufferLength = startPos;
            if (port instanceof InPort) {
                port.readState = saveReadState;
            }
        }
    }
}

