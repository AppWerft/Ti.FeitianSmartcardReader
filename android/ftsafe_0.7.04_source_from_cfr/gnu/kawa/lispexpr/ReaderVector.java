/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.lists.EmptyList;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderVector
extends ReadTableEntry {
    char close;

    public ReaderVector(char close) {
        this.close = close;
    }

    @Override
    public Object read(Lexer in, int ch, int count, int sharingIndex) throws IOException, SyntaxException {
        return ReaderVector.readVector((LispReader)in, in.getPort(), count, this.close, sharingIndex);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static FVector readVector(LispReader lexer, InPort port, int count, char close, int sharingIndex) throws IOException, SyntaxException {
        int saveReadState = 32;
        if (port instanceof InPort) {
            saveReadState = port.readState;
            port.readState = (char)(close == ']' ? 91 : 40);
        }
        int startLine = port.getLineNumber();
        int startColumn = port.getColumnNumber() - 1;
        try {
            Pair head;
            FVector<Object> result = new FVector<Object>();
            lexer.bindSharedObject(sharingIndex, result);
            ReadTable rtable = ReadTable.getCurrent();
            Pair last = head = new Pair(null, LList.Empty);
            do {
                int ch;
                if ((ch = lexer.read()) < 0) {
                    lexer.eofError("unexpected EOF in vector starting here", startLine + 1, startColumn);
                }
                if (ch == close) break;
                last = lexer.readValuesAndAppend(ch, rtable, last);
            } while (true);
            result.replaceAll(((LList)head.getCdr()).toArray());
            result.setReadOnly();
            FVector<Object> ch = result;
            return ch;
        }
        finally {
            if (port instanceof InPort) {
                port.readState = (char)saveReadState;
            }
        }
    }
}

