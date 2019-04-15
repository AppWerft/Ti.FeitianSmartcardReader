package gnu.q2.lang;

import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReaderDispatch;
import gnu.kawa.lispexpr.ReaderNestedComment;
import gnu.kawa.lispexpr.ReaderQuote;
import gnu.lists.FString;
import gnu.mapping.Environment;
import gnu.text.SourceMessages;
import kawa.standard.Scheme;

public class Q2 extends Scheme
{
  static Q2 instance;
  static final Object emptyForm = new FString();
  
  public Q2()
  {
    environ = q2Environment;
    ModuleBody.setMainPrintValues(true);
  }
  
  protected Q2(Environment env)
  {
    super(env);
  }
  
  protected static final gnu.mapping.SimpleEnvironment q2Environment = Environment.make("q2-environment", Scheme.kawaEnvironment);
  

  static
  {
    instance = new Q2();
    Environment saveEnv = Environment.setSaveCurrent(q2Environment);
    try
    {
      instance.initQ2();
    }
    finally
    {
      Environment.restoreCurrent(saveEnv);
    }
  }
  
  public static Q2 getQ2Instance()
  {
    if (instance == null)
      new Q2();
    return instance;
  }
  
  public void initQ2()
  {
    defSntxStFld(";", "gnu.q2.lang.Operator", "SEMI");
    defSntxStFld("+", "gnu.q2.lang.Operator", "PLUS");
    defSntxStFld("-", "gnu.q2.lang.Operator", "MINUS");
    defSntxStFld("*", "gnu.q2.lang.Operator", "STAR");
    defSntxStFld("/", "gnu.q2.lang.Operator", "SLASH");
    defSntxStFld("<", "gnu.q2.lang.Operator", "LT");
    defSntxStFld(">", "gnu.q2.lang.Operator", "GT");
    defSntxStFld("==", "gnu.q2.lang.Operator", "EQ");
    defSntxStFld("<=", "gnu.q2.lang.Operator", "LE");
    defSntxStFld(">=", "gnu.q2.lang.Operator", "GE");
    defSntxStFld(":=", "gnu.q2.lang.Operator", "ASSIGN");
    defSntxStFld("?>", "gnu.q2.lang.Operator", "IF_THEN");
  }
  
  public String getName()
  {
    return "Q2";
  }
  

  public gnu.kawa.lispexpr.LispReader getLexer(InPort inp, SourceMessages messages)
  {
    Q2Read lexer = new Q2Read(inp, messages);
    return lexer;
  }
  
  public String getCompilationClass() { return "gnu.q2.lang.Q2Translator"; }
  








  public static void registerEnvironment()
  {
    Language.setDefaults(new Q2());
  }
  
  public boolean appendBodyValues() { return true; }
  
  public String getPrimaryPrompt() {
    return "#|Q2:%N|# ";
  }
  
  public String getSecondaryPrompt() { return "#|%P.%N|# "; }
  
  public ReadTable createReadTable()
  {
    ReadTable rt = ReadTable.createInitial();
    rt.set(40, new Q2Read.ReadTableEntry());
    rt.set(59, new Q2Read.ReadTableEntry());
    ReaderDispatch rdispatch = ReaderDispatch.create(rt, false);
    rt.set(35, rdispatch);
    rdispatch.set(32, gnu.kawa.lispexpr.ReaderIgnoreRestOfLine.getInstance());
    rdispatch.set(91, new ReaderNestedComment('#', '[', ']', '#'));
    


    rt.setFinalColonIsKeyword(true);
    postfixLookupOperator = ':';
    rt.set(64, new ReaderQuote(LispLanguage.splice_sym, 6));
    
    return rt;
  }
  









  public static int compareIndentation(int indentation1, int indentation2)
  {
    int numTabs1 = indentation1 >>> 16;
    int numTabs2 = indentation1 >>> 16;
    int numSpaces1 = indentation1 & 0xFF;
    int numSpaces2 = indentation2 & 0xFF;
    if (numTabs1 == numTabs2)
      return numSpaces1 - numSpaces2;
    if (((numTabs1 < numTabs2) && (numSpaces1 <= numSpaces2)) || ((numTabs1 > numTabs2) && (numSpaces1 >= numSpaces2)))
    {
      return 8 * (numTabs1 - numTabs2);
    }
    return Integer.MIN_VALUE;
  }
}
