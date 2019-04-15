/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.bytecode.Type;
import gnu.expr.Language;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.kawa.lispexpr.ReaderColon;
import gnu.kawa.lispexpr.ReaderDispatch;
import gnu.kawa.lispexpr.ReaderIgnoreRestOfLine;
import gnu.kawa.lispexpr.ReaderParens;
import gnu.kawa.lispexpr.ReaderQuote;
import gnu.kawa.lispexpr.ReaderString;
import gnu.kawa.lispexpr.ReaderTypespec;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.util.RangeTable;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;

public class ReadTable
extends RangeTable {
    public static final int ILLEGAL = 0;
    public static final int WHITESPACE = 1;
    public static final int CONSTITUENT = 2;
    public static final int SINGLE_ESCAPE = 3;
    public static final int MULTIPLE_ESCAPE = 4;
    public static final int TERMINATING_MACRO = 5;
    public static final int NON_TERMINATING_MACRO = 6;
    public static int defaultBracketMode = -2;
    public char postfixLookupOperator = (char)65535;
    protected boolean initialColonIsKeyword;
    protected boolean finalColonIsKeyword;
    public int extraFlags;
    protected boolean hexEscapeAfterBackslash = true;
    static final ThreadLocation current = new ThreadLocation("read-table");
    Environment ctorTable = null;

    public void setInitialColonIsKeyword(boolean whenInitial) {
        this.initialColonIsKeyword = whenInitial;
    }

    public void setFinalColonIsKeyword(boolean whenFinal) {
        this.finalColonIsKeyword = whenFinal;
    }

    public void initialize(boolean sharpIsTerminating) {
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
        ReaderQuote unquoteEntry = new ReaderQuote(this.makeSymbol("unquote"), '@', this.makeSymbol("unquote-splicing"));
        this.set(44, unquoteEntry);
        this.setBracketMode();
    }

    public static ReadTable createInitial() {
        ReadTable tab = new ReadTable();
        tab.initialize(true);
        return tab;
    }

    public void setBracketMode(int mode) {
        if (mode == -2) {
            this.set(91, ReaderParens.getInstance('[', ']', 5, LispLanguage.bracket_list_sym));
            this.set(60, new ReaderTypespec());
        } else if (mode <= 0) {
            ReadTableEntry token = ReadTableEntry.getConstituentInstance();
            this.set(60, token);
            if (mode < 0) {
                this.set(91, token);
                this.set(93, token);
            }
        } else {
            this.set(60, new ReaderTypespec());
        }
        if (mode >= 0) {
            this.set(91, ReaderParens.getInstance('[', ']'));
            this.remove(93);
        }
    }

    public void setBracketMode() {
        this.setBracketMode(defaultBracketMode);
    }

    void initCtorTable() {
        if (this.ctorTable == null) {
            this.ctorTable = Environment.make();
        }
    }

    public synchronized void putReaderCtor(String key, Procedure proc) {
        this.initCtorTable();
        this.ctorTable.put(key, (Object)proc);
    }

    public synchronized void putReaderCtor(String key, Type type) {
        this.initCtorTable();
        this.ctorTable.put(key, (Object)type);
    }

    public synchronized void putReaderCtorFld(String key, String cname, String fname) {
        this.initCtorTable();
        Symbol symbol = this.ctorTable.getSymbol(key);
        StaticFieldLocation.define(this.ctorTable, symbol, null, cname, fname);
    }

    public synchronized Object getReaderCtor(String key) {
        this.initCtorTable();
        return this.ctorTable.get(key, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ReadTable getCurrent() {
        ReadTable table = current.get(null);
        if (table == null) {
            Language language = Language.getDefaultLanguage();
            if (language instanceof LispLanguage) {
                LispLanguage llanguage;
                LispLanguage lispLanguage = llanguage = (LispLanguage)language;
                synchronized (lispLanguage) {
                    table = llanguage.defaultReadTable;
                    if (table == null) {
                        llanguage.defaultReadTable = table = llanguage.createReadTable();
                    }
                }
            } else {
                table = ReadTable.createInitial();
            }
            current.set(table);
        }
        return table;
    }

    public static void setCurrent(ReadTable rt) {
        current.set(rt);
    }

    public ReadTableEntry lookup(int ch) {
        ReadTableEntry entry = (ReadTableEntry)this.lookup(ch, null);
        if (entry == null && ch >= 0 && ch < 65536) {
            if (Character.isDigit((char)ch)) {
                entry = (ReadTableEntry)this.lookup(48, null);
            } else if (Character.isLowerCase((char)ch)) {
                entry = (ReadTableEntry)this.lookup(97, null);
            } else if (Character.isLetter((char)ch) || ch == 61698) {
                entry = (ReadTableEntry)this.lookup(65, null);
            } else if (Character.isWhitespace((char)ch)) {
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

    protected Object makeSymbol(String name) {
        return Symbol.valueOf(name);
    }
}

