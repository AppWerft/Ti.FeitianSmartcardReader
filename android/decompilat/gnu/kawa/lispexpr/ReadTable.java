// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.expr.Language;
import gnu.mapping.Symbol;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.bytecode.Type;
import gnu.mapping.Procedure;
import gnu.mapping.Environment;
import gnu.mapping.ThreadLocation;
import gnu.kawa.util.RangeTable;

public class ReadTable extends RangeTable
{
    public static final int ILLEGAL = 0;
    public static final int WHITESPACE = 1;
    public static final int CONSTITUENT = 2;
    public static final int SINGLE_ESCAPE = 3;
    public static final int MULTIPLE_ESCAPE = 4;
    public static final int TERMINATING_MACRO = 5;
    public static final int NON_TERMINATING_MACRO = 6;
    public static int defaultBracketMode;
    public char postfixLookupOperator;
    protected boolean initialColonIsKeyword;
    protected boolean finalColonIsKeyword;
    public int extraFlags;
    protected boolean hexEscapeAfterBackslash;
    static final ThreadLocation current;
    Environment ctorTable;
    
    public void setInitialColonIsKeyword(final boolean whenInitial) {
        this.initialColonIsKeyword = whenInitial;
    }
    
    public void setFinalColonIsKeyword(final boolean whenFinal) {
        this.finalColonIsKeyword = whenFinal;
    }
    
    public ReadTable() {
        this.postfixLookupOperator = '\uffff';
        this.hexEscapeAfterBackslash = true;
        this.ctorTable = null;
    }
    
    public void initialize(final boolean sharpIsTerminating) {
        ReadTableEntry entry = ReadTableEntry.getWhitespaceInstance();
        this.set(32, entry);
        this.set(9, entry);
        this.set(10, entry);
        this.set(13, entry);
        this.set(12, entry);
        this.set(124, ReadTableEntry.getMultipleEscapeInstance());
        this.set(92, ReadTableEntry.getSingleEscapeInstance());
        this.set(48, 57, ReadTableEntry.getDigitInstance());
        entry = ReadTableEntry.getConstituentInstance();
        this.set(97, 122, entry);
        this.set(65, 90, entry);
        this.set(33, entry);
        this.set(36, entry);
        this.set(37, entry);
        this.set(38, ReadTableEntry.ampersand);
        this.set(42, entry);
        this.set(43, entry);
        this.set(45, entry);
        this.set(46, entry);
        this.set(47, entry);
        this.set(61, entry);
        this.set(62, entry);
        this.set(63, entry);
        this.set(64, entry);
        this.set(94, entry);
        this.set(95, entry);
        this.set(123, ReadTableEntry.brace);
        this.set(126, entry);
        this.set(127, entry);
        this.set(8, entry);
        this.set(58, new ReaderColon());
        this.set(34, new ReaderString());
        this.set(35, ReaderDispatch.create(this, !sharpIsTerminating));
        this.set(59, ReaderIgnoreRestOfLine.getInstance());
        this.set(40, ReaderParens.getInstance('(', ')'));
        this.set(39, new ReaderQuote(this.makeSymbol("quote")));
        this.set(96, new ReaderQuote(this.makeSymbol("quasiquote")));
        final ReaderQuote unquoteEntry = new ReaderQuote(this.makeSymbol("unquote"), '@', this.makeSymbol("unquote-splicing"));
        this.set(44, unquoteEntry);
        this.setBracketMode();
    }
    
    public static ReadTable createInitial() {
        final ReadTable tab = new ReadTable();
        tab.initialize(true);
        return tab;
    }
    
    public void setBracketMode(final int mode) {
        if (mode == -2) {
            this.set(91, ReaderParens.getInstance('[', ']', 5, LispLanguage.bracket_list_sym));
            this.set(60, new ReaderTypespec());
        }
        else if (mode <= 0) {
            final ReadTableEntry token = ReadTableEntry.getConstituentInstance();
            this.set(60, token);
            if (mode < 0) {
                this.set(91, token);
                this.set(93, token);
            }
        }
        else {
            this.set(60, new ReaderTypespec());
        }
        if (mode >= 0) {
            this.set(91, ReaderParens.getInstance('[', ']'));
            this.remove(93);
        }
    }
    
    public void setBracketMode() {
        this.setBracketMode(ReadTable.defaultBracketMode);
    }
    
    void initCtorTable() {
        if (this.ctorTable == null) {
            this.ctorTable = Environment.make();
        }
    }
    
    public synchronized void putReaderCtor(final String key, final Procedure proc) {
        this.initCtorTable();
        this.ctorTable.put(key, proc);
    }
    
    public synchronized void putReaderCtor(final String key, final Type type) {
        this.initCtorTable();
        this.ctorTable.put(key, type);
    }
    
    public synchronized void putReaderCtorFld(final String key, final String cname, final String fname) {
        this.initCtorTable();
        final Symbol symbol = this.ctorTable.getSymbol(key);
        StaticFieldLocation.define(this.ctorTable, symbol, null, cname, fname);
    }
    
    public synchronized Object getReaderCtor(final String key) {
        this.initCtorTable();
        return this.ctorTable.get(key, null);
    }
    
    public static ReadTable getCurrent() {
        ReadTable table = ReadTable.current.get(null);
        if (table == null) {
            final Language language = Language.getDefaultLanguage();
            if (language instanceof LispLanguage) {
                final LispLanguage llanguage = (LispLanguage)language;
                synchronized (llanguage) {
                    table = llanguage.defaultReadTable;
                    if (table == null) {
                        table = llanguage.createReadTable();
                        llanguage.defaultReadTable = table;
                    }
                }
            }
            else {
                table = createInitial();
            }
            ReadTable.current.set(table);
        }
        return table;
    }
    
    public static void setCurrent(final ReadTable rt) {
        ReadTable.current.set(rt);
    }
    
    public ReadTableEntry lookup(final int ch) {
        ReadTableEntry entry = (ReadTableEntry)this.lookup(ch, null);
        if (entry == null && ch >= 0 && ch < 65536) {
            if (Character.isDigit((char)ch)) {
                entry = (ReadTableEntry)this.lookup(48, null);
            }
            else if (Character.isLowerCase((char)ch)) {
                entry = (ReadTableEntry)this.lookup(97, null);
            }
            else if (Character.isLetter((char)ch) || ch == 61698) {
                entry = (ReadTableEntry)this.lookup(65, null);
            }
            else if (Character.isWhitespace((char)ch)) {
                entry = (ReadTableEntry)this.lookup(32, null);
            }
            if (entry == null && ch >= 128) {
                entry = ReadTableEntry.getConstituentInstance();
            }
            if (entry == null) {
                entry = ReadTableEntry.getIllegalInstance();
            }
        }
        return entry;
    }
    
    protected Object makeSymbol(final String name) {
        return Symbol.valueOf(name);
    }
    
    static {
        ReadTable.defaultBracketMode = -2;
        current = new ThreadLocation("read-table");
    }
}
