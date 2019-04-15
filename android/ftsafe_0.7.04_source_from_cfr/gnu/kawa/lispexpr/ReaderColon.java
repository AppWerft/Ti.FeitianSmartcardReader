/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderColon
extends ReadTableEntry {
    @Override
    public int getKind() {
        return 6;
    }

    @Override
    public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        LispReader reader = (LispReader)in;
        ReadTable rtable = ReadTable.getCurrent();
        int startPos = reader.tokenBufferLength;
        if (ch == rtable.postfixLookupOperator) {
            int next = reader.read();
            if (next == 58) {
                return rtable.makeSymbol("::");
            }
            reader.tokenBufferAppend(ch);
            ch = next;
        }
        return reader.readAndHandleToken(ch, startPos, rtable);
    }
}

