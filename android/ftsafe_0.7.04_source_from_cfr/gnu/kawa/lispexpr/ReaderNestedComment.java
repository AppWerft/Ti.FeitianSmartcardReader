/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderNestedComment
extends ReadTableEntry {
    char start1;
    char start2;
    char end1;
    char end2;
    static ReaderNestedComment lispInstance = new ReaderNestedComment('#', '|', '|', '#');

    public static ReaderNestedComment getLispInstance() {
        return lispInstance;
    }

    public ReaderNestedComment(char start1, char start2, char end1, char end2) {
        this.start1 = start1;
        this.start2 = start2;
        this.end1 = end1;
        this.end2 = end2;
    }

    @Override
    public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        this.readNestedComment((LispReader)in);
        return Values.empty;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void readNestedComment(LispReader reader) throws IOException, SyntaxException {
        InPort port = reader.getPort();
        char saveReadState = '\u0000';
        if (port instanceof InPort) {
            saveReadState = port.readState;
            port.readState = this.start1;
        }
        try {
            reader.readNestedComment(this.start1, this.start2, this.end1, this.end2);
        }
        finally {
            if (port instanceof InPort) {
                port.readState = saveReadState;
            }
        }
    }
}

