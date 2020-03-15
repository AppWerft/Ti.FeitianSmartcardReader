// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.kawa.util.RangeTable;

public class ReaderDispatch extends ReadTableEntry
{
    RangeTable table;
    int kind;
    
    @Override
    public int getKind() {
        return this.kind;
    }
    
    public void set(final int key, final Object value) {
        this.table.set(key, key, value);
    }
    
    public ReadTableEntry lookup(final int key) {
        return (ReadTableEntry)this.table.lookup(key, null);
    }
    
    public ReaderDispatch() {
        this.table = new RangeTable();
        this.kind = 5;
    }
    
    public ReaderDispatch(final boolean nonTerminating) {
        this.table = new RangeTable();
        this.kind = (nonTerminating ? 6 : 5);
    }
    
    public static ReaderDispatch create(final ReadTable rtable, final boolean nonTerminating) {
        final ReaderDispatch tab = new ReaderDispatch(nonTerminating);
        final ReaderDispatchMisc entry = ReaderDispatchMisc.getInstance();
        tab.set(58, entry);
        tab.set(65, entry);
        tab.set(66, entry);
        tab.set(68, entry);
        tab.set(69, entry);
        tab.set(70, entry);
        tab.set(73, entry);
        tab.set(79, entry);
        tab.set(82, entry);
        tab.set(83, entry);
        tab.set(84, entry);
        tab.set(85, entry);
        tab.set(88, entry);
        tab.set(59, entry);
        tab.set(33, entry);
        tab.set(92, entry);
        tab.set(61, entry);
        tab.set(35, entry);
        tab.set(42, entry);
        tab.set(47, entry);
        tab.set(124, ReaderNestedComment.getLispInstance());
        tab.set(39, new ReaderQuote(rtable.makeSymbol("function")));
        tab.set(40, new ReaderVector(')'));
        tab.set(60, new ReaderXmlElement());
        return tab;
    }
    
    @Override
    public Object read(final Lexer in, int ch, int count, final int sharingIndex) throws IOException, SyntaxException {
        count = in.readIntDigits();
        ch = in.read();
        if (ch < 0) {
            in.eofError("unexpected EOF after " + (char)ch);
        }
        if (ch < 65536) {
            ch = Character.toUpperCase((char)ch);
        }
        final ReadTableEntry entry = (ReadTableEntry)this.table.lookup(ch, null);
        if (entry == null) {
            in.error('e', in.getName(), in.getLineNumber() + 1, in.getColumnNumber(), "invalid dispatch character '" + (char)ch + '\'');
            return Char.make(63);
        }
        return entry.read(in, ch, count, sharingIndex);
    }
}
