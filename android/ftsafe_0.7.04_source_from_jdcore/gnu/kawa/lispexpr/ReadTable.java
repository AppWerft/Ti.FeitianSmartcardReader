package gnu.kawa.lispexpr;

import gnu.bytecode.Type;
import gnu.expr.Language;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.util.RangeTable;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;



public class ReadTable
  extends RangeTable
{
  public static final int ILLEGAL = 0;
  public static final int WHITESPACE = 1;
  public static final int CONSTITUENT = 2;
  public static final int SINGLE_ESCAPE = 3;
  public static final int MULTIPLE_ESCAPE = 4;
  public static final int TERMINATING_MACRO = 5;
  public static final int NON_TERMINATING_MACRO = 6;
  public static int defaultBracketMode = -2;
  

  public char postfixLookupOperator = 65535;
  


  protected boolean initialColonIsKeyword;
  

  protected boolean finalColonIsKeyword;
  

  public int extraFlags;
  

  protected boolean hexEscapeAfterBackslash = true;
  

  public void setInitialColonIsKeyword(boolean whenInitial)
  {
    initialColonIsKeyword = whenInitial;
  }
  

  public void setFinalColonIsKeyword(boolean whenFinal)
  {
    finalColonIsKeyword = whenFinal;
  }
  
  static final ThreadLocation current = new ThreadLocation("read-table");
  


  public ReadTable() {}
  

  public void initialize(boolean sharpIsTerminating)
  {
    ReadTableEntry entry = ReadTableEntry.getWhitespaceInstance();
    set(32, entry);
    set(9, entry);
    set(10, entry);
    set(13, entry);
    set(12, entry);
    
    set(124, ReadTableEntry.getMultipleEscapeInstance());
    set(92, ReadTableEntry.getSingleEscapeInstance());
    set(48, 57, ReadTableEntry.getDigitInstance());
    entry = ReadTableEntry.getConstituentInstance();
    set(97, 122, entry);
    set(65, 90, entry);
    set(33, entry);
    set(36, entry);
    set(37, entry);
    set(38, ReadTableEntry.ampersand);
    set(42, entry);
    set(43, entry);
    set(45, entry);
    set(46, entry);
    set(47, entry);
    set(61, entry);
    set(62, entry);
    set(63, entry);
    set(64, entry);
    set(94, entry);
    set(95, entry);
    set(123, ReadTableEntry.brace);
    set(126, entry);
    set(127, entry);
    set(8, entry);
    set(58, new ReaderColon());
    set(34, new ReaderString());
    set(35, ReaderDispatch.create(this, !sharpIsTerminating));
    set(59, ReaderIgnoreRestOfLine.getInstance());
    set(40, ReaderParens.getInstance('(', ')'));
    
    set(39, new ReaderQuote(makeSymbol("quote")));
    set(96, new ReaderQuote(makeSymbol("quasiquote")));
    ReaderQuote unquoteEntry = new ReaderQuote(makeSymbol("unquote"), '@', makeSymbol("unquote-splicing"));
    

    set(44, unquoteEntry);
    
    setBracketMode();
  }
  

  public static ReadTable createInitial()
  {
    ReadTable tab = new ReadTable();
    tab.initialize(true);
    return tab;
  }
  









  public void setBracketMode(int mode)
  {
    if (mode == -2)
    {
      set(91, ReaderParens.getInstance('[', ']', 5, LispLanguage.bracket_list_sym));
      
      set(60, new ReaderTypespec());
    }
    else if (mode <= 0)
    {
      ReadTableEntry token = ReadTableEntry.getConstituentInstance();
      set(60, token);
      if (mode < 0)
      {
        set(91, token);
        set(93, token);
      }
    }
    else {
      set(60, new ReaderTypespec()); }
    if (mode >= 0)
    {
      set(91, ReaderParens.getInstance('[', ']'));
      remove(93);
    }
  }
  


  public void setBracketMode()
  {
    setBracketMode(defaultBracketMode);
  }
  

  Environment ctorTable = null;
  
  void initCtorTable()
  {
    if (ctorTable == null) {
      ctorTable = Environment.make();
    }
  }
  
  public synchronized void putReaderCtor(String key, Procedure proc)
  {
    initCtorTable();
    ctorTable.put(key, proc);
  }
  

  public synchronized void putReaderCtor(String key, Type type)
  {
    initCtorTable();
    ctorTable.put(key, type);
  }
  


  public synchronized void putReaderCtorFld(String key, String cname, String fname)
  {
    initCtorTable();
    Symbol symbol = ctorTable.getSymbol(key);
    StaticFieldLocation.define(ctorTable, symbol, null, cname, fname);
  }
  

  public synchronized Object getReaderCtor(String key)
  {
    initCtorTable();
    return ctorTable.get(key, null);
  }
  
  public static ReadTable getCurrent()
  {
    ReadTable table = (ReadTable)current.get(null);
    if (table == null)
    {
      Language language = Language.getDefaultLanguage();
      if ((language instanceof LispLanguage))
      {
        LispLanguage llanguage = (LispLanguage)language;
        synchronized (llanguage)
        {
          table = defaultReadTable;
          if (table == null)
          {
            table = llanguage.createReadTable();
            defaultReadTable = table;
          }
        }
      }
      else {
        table = createInitial(); }
      current.set(table);
    }
    return table;
  }
  
  public static void setCurrent(ReadTable rt)
  {
    current.set(rt);
  }
  
  public ReadTableEntry lookup(int ch)
  {
    ReadTableEntry entry = (ReadTableEntry)lookup(ch, null);
    if ((entry == null) && (ch >= 0) && (ch < 65536))
    {
      if (Character.isDigit((char)ch)) {
        entry = (ReadTableEntry)lookup(48, null);
      } else if (Character.isLowerCase((char)ch)) {
        entry = (ReadTableEntry)lookup(97, null);
      } else if ((Character.isLetter((char)ch)) || (ch == 61698))
      {
        entry = (ReadTableEntry)lookup(65, null);
      } else if (Character.isWhitespace((char)ch)) {
        entry = (ReadTableEntry)lookup(32, null);
      }
      if ((entry == null) && (ch >= 128))
        entry = ReadTableEntry.getConstituentInstance();
      if (entry == null)
        entry = ReadTableEntry.getIllegalInstance();
    }
    return entry;
  }
  
  protected Object makeSymbol(String name)
  {
    return Symbol.valueOf(name);
  }
}
