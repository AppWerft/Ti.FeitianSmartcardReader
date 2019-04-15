/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.lists.PairWithPosition;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderQuote
extends ReadTableEntry {
    Object magicSymbol;
    char next;
    Object magicSymbol2;
    int kind;

    @Override
    public int getKind() {
        return this.kind;
    }

    public ReaderQuote(Object magicSymbol) {
        this.magicSymbol = magicSymbol;
        this.kind = 5;
    }

    public ReaderQuote(Object magicSymbol, int kind) {
        this.magicSymbol = magicSymbol;
        this.kind = kind;
    }

    public ReaderQuote(Object magicSymbol, char next, Object magicSymbol2) {
        this.next = next;
        this.magicSymbol = magicSymbol;
        this.magicSymbol2 = magicSymbol2;
        this.kind = 5;
    }

    @Override
    public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        return ReaderQuote.read((LispReader)in, this.magicSymbol, this.next, this.magicSymbol2);
    }

    public static Object read(LispReader reader, Object magicSymbol, char next, Object magicSymbol2) throws IOException, SyntaxException {
        String file2 = reader.getName();
        int line1 = reader.getLineNumber() + 1;
        int column1 = reader.getColumnNumber() + 1;
        Object magic = magicSymbol;
        if (next != '\u0000') {
            int ch = reader.read();
            if (ch == next) {
                magic = magicSymbol2;
            } else if (ch >= 0) {
                reader.unread(ch);
            }
        }
        int line2 = reader.getLineNumber() + 1;
        int column2 = reader.getColumnNumber() + 1;
        Object form = reader.readObject();
        form = PairWithPosition.make(form, reader.makeNil(), file2, line2, column2);
        form = PairWithPosition.make(magic, form, file2, line1, column1);
        return form;
    }
}

