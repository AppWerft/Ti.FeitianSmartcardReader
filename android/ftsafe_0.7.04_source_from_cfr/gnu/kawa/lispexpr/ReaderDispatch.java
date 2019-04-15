/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.kawa.lispexpr.ReaderDispatchMisc;
import gnu.kawa.lispexpr.ReaderNestedComment;
import gnu.kawa.lispexpr.ReaderQuote;
import gnu.kawa.lispexpr.ReaderVector;
import gnu.kawa.lispexpr.ReaderXmlElement;
import gnu.kawa.util.RangeTable;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderDispatch
extends ReadTableEntry {
    RangeTable table = new RangeTable();
    int kind;

    @Override
    public int getKind() {
        return this.kind;
    }

    public void set(int key, Object value) {
        this.table.set(key, key, value);
    }

    public ReadTableEntry lookup(int key) {
        return (ReadTableEntry)this.table.lookup(key, null);
    }

    public ReaderDispatch() {
        this.kind = 5;
    }

    public ReaderDispatch(boolean nonTerminating) {
        this.kind = nonTerminating ? 6 : 5;
    }

    public static ReaderDispatch create(ReadTable rtable, boolean nonTerminating) {
        ReaderDispatch tab = new ReaderDispatch(nonTerminating);
        ReaderDispatchMisc entry = ReaderDispatchMisc.getInstance();
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
    public Object read(Lexer in, int ch, int count, int sharingIndex) throws IOException, SyntaxException {
        ReadTableEntry entry;
        count = in.readIntDigits();
        ch = in.read();
        if (ch < 0) {
            in.eofError("unexpected EOF after " + (char)ch);
        }
        if (ch < 65536) {
            ch = Character.toUpperCase((char)ch);
        }
        if ((entry = (ReadTableEntry)this.table.lookup(ch, null)) == null) {
            in.error('e', in.getName(), in.getLineNumber() + 1, in.getColumnNumber(), "invalid dispatch character '" + (char)ch + '\'');
            return Char.make(63);
        }
        return entry.read(in, ch, count, sharingIndex);
    }
}

