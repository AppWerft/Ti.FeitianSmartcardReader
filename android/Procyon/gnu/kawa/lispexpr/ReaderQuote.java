// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.lists.PairWithPosition;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.text.Lexer;

public class ReaderQuote extends ReadTableEntry
{
    Object magicSymbol;
    char next;
    Object magicSymbol2;
    int kind;
    
    @Override
    public int getKind() {
        return this.kind;
    }
    
    public ReaderQuote(final Object magicSymbol) {
        this.magicSymbol = magicSymbol;
        this.kind = 5;
    }
    
    public ReaderQuote(final Object magicSymbol, final int kind) {
        this.magicSymbol = magicSymbol;
        this.kind = kind;
    }
    
    public ReaderQuote(final Object magicSymbol, final char next, final Object magicSymbol2) {
        this.next = next;
        this.magicSymbol = magicSymbol;
        this.magicSymbol2 = magicSymbol2;
        this.kind = 5;
    }
    
    public Object read(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
        return read((LispReader)in, this.magicSymbol, this.next, this.magicSymbol2);
    }
    
    public static Object read(final LispReader reader, final Object magicSymbol, final char next, final Object magicSymbol2) throws IOException, SyntaxException {
        final String file = reader.getName();
        final int line1 = reader.getLineNumber() + 1;
        final int column1 = reader.getColumnNumber() + 1;
        Object magic = magicSymbol;
        if (next != '\0') {
            final int ch = reader.read();
            if (ch == next) {
                magic = magicSymbol2;
            }
            else if (ch >= 0) {
                reader.unread(ch);
            }
        }
        final int line2 = reader.getLineNumber() + 1;
        final int column2 = reader.getColumnNumber() + 1;
        Object form = reader.readObject();
        form = PairWithPosition.make(form, reader.makeNil(), file, line2, column2);
        form = PairWithPosition.make(magic, form, file, line1, column1);
        return form;
    }
}
