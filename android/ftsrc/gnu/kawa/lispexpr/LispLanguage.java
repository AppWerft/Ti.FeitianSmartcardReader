package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.kawa.io.InPort;
import gnu.kawa.io.TtyInPort;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Sequence;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.text.Lexer;
import java.util.HashMap;
import kawa.lang.Translator;

public abstract class LispLanguage extends Language
{
  public static final String quote_str = "quote";
  public static final String unquote_str = "unquote";
  public static final String unquotesplicing_str = "unquote-splicing";
  public static final String quasiquote_str = "quasiquote";
  public static final Symbol quasiquote_sym = Namespace.EmptyNamespace.getSymbol("quasiquote");
  
  public static final gnu.mapping.SimpleSymbol dots3_sym = Symbol.valueOf("...");
  public static final String splice_str = "$splice$";
  public static final Symbol splice_sym = Namespace.EmptyNamespace.getSymbol("$splice$");
  
  public static final Symbol lookup_sym = Namespace.EmptyNamespace.getSymbol("$lookup$");
  

  public static final Symbol bracket_list_sym = Namespace.EmptyNamespace.getSymbol("$bracket-list$");
  


  public static final Symbol bracket_apply_sym = Namespace.EmptyNamespace.getSymbol("$bracket-apply$");
  
  public static StaticFieldLocation getNamedPartLocation = new StaticFieldLocation("gnu.kawa.functions.GetNamedPart", "getNamedPart");
  
  static { getNamedPartLocation.setProcedure(); }
  




  public static final Namespace unitNamespace = Namespace.valueOf("http://kawa.gnu.org/unit", "unit");
  

  public static final Namespace constructNamespace = Namespace.valueOf("http://kawa.gnu.org/construct", "$construct$");
  

  public static final Namespace entityNamespace = Namespace.valueOf("http://kawa.gnu.org/entity", "$entity$");
  
  protected ReadTable defaultReadTable;
  
  private HashMap<String, Type> types;
  
  private HashMap<Type, String> typeToStringMap;
  

  public LispReader getLexer(InPort inp, gnu.text.SourceMessages messages)
  {
    return new LispReader(inp, messages);
  }
  
  public String getCompilationClass() { return "kawa.lang.Translator"; }
  
  public boolean parse(Compilation comp, int options)
    throws java.io.IOException, gnu.text.SyntaxException
  {
    Translator tr = (Translator)comp;
    Lexer lexer = lexer;
    ModuleExp mexp = tr.getModule();
    LispReader reader = (LispReader)lexer;
    Compilation saveComp = Compilation.setSaveCurrent(tr);
    InPort in = reader == null ? null : reader.getPort();
    if ((in instanceof TtyInPort)) {
      ((TtyInPort)in).resetAndKeep();
    }
    try {
      if (pendingForm != null)
      {
        tr.scanForm(pendingForm, mexp);
        pendingForm = null;
      }
      

      while (reader != null)
      {
        Object sexp = reader.readCommand();
        boolean bool1;
        if ((Translator.listLength(sexp) == 2) && (Translator.safeCar(sexp) == kawa.standard.begin.begin) && (Translator.safeCar(Translator.safeCdr(sexp)) == Sequence.eofValue) && ((options & 0x84) != 0))
        {


          return false;
        }
        if (sexp == Sequence.eofValue)
        {
          if ((options & 0x4) == 0) break;
          return false;
        }
        int ch;
        do {
          ch = lexer.read();
        } while ((ch == 32) || (ch == 9) || (ch == 13));
        if (ch == 41)
          lexer.fatal("An unexpected close paren was read.");
        if (ch != 10)
          lexer.unread(ch);
        tr.scanForm(sexp, mexp);
        if ((options & 0x4) != 0)
        {





          if ((ch < 0) || (ch == 10)) break; if (!lexer.isInteractive()) {
            break;
          }
        } else if (((options & 0x8) != 0) && (tr.getState() >= 2))
        {

          return true;
        }
      }
      

      tr.finishModule(mexp);
      
      tr.setState(4);
    }
    finally
    {
      if ((in instanceof TtyInPort))
        ((TtyInPort)in).setKeepAll(false);
      Compilation.restoreCurrent(saveComp);
    }
    return true;
  }
  

  public void resolve(Compilation comp)
  {
    Translator tr = (Translator)comp;
    ModuleExp mexp = tr.getModule();
    tr.resolveModule(mexp);
    if (subModuleMap != null) {
      String mainName = mainClass.getName();
      ModuleInfo subinfo = (ModuleInfo)subModuleMap.get(mainName);
      if ((subinfo != null) && ((body != gnu.expr.QuoteExp.voidExp) || (mexp.firstDecl() != null)))
      {
        ModuleExp submodule = subinfo.getModuleExpRaw();
        tr.error('e', "module has both statements and a submodule with the same name: " + mainClass.getName(), submodule != null ? submodule : mexp);
      }
    }
  }
  

  public Declaration declFromField(ModuleExp mod, Object fvalue, Field fld)
  {
    Declaration fdecl = super.declFromField(mod, fvalue, fld);
    boolean isFinal = (fld.getModifiers() & 0x10) != 0;
    if ((isFinal) && ((fvalue instanceof kawa.lang.Syntax)))
      fdecl.setSyntax();
    return fdecl;
  }
  






  protected void defSntxStFld(String name, String cname, String fname)
  {
    Object property = hasSeparateFunctionNamespace() ? gnu.mapping.EnvironmentKey.FUNCTION : null;
    
    StaticFieldLocation loc = StaticFieldLocation.define(environ, environ.getSymbol(name), property, cname, fname);
    

    loc.setSyntax();
  }
  
  protected void defSntxStFld(String name, String cname)
  {
    defSntxStFld(name, cname, mangleNameIfNeeded(name));
  }
  





  public boolean keywordsAreSelfEvaluating()
  {
    return true;
  }
  
  public boolean selfEvaluatingSymbol(Object obj)
  {
    return obj instanceof gnu.expr.Keyword;
  }
  

  public static Symbol langSymbolToSymbol(Object sym)
  {
    return ((LispLanguage)Language.getDefaultLanguage()).fromLangSymbol(sym);
  }
  
  protected Symbol fromLangSymbol(Object sym)
  {
    if ((sym instanceof String))
      return getSymbol((String)sym);
    return (Symbol)sym;
  }
  




  protected synchronized HashMap<String, Type> getTypeMap()
  {
    if (types == null) {
      types = new HashMap(64);
      types.put("void", LangPrimType.voidType);
      types.put("int", LangPrimType.intType);
      types.put("char", LangPrimType.charType);
      types.put("character", LangPrimType.characterType);
      types.put("character-or-eof", LangPrimType.characterOrEofType);
      
      types.put("byte", LangPrimType.byteType);
      types.put("short", LangPrimType.shortType);
      types.put("long", LangPrimType.longType);
      types.put("float", LangPrimType.floatType);
      types.put("double", LangPrimType.doubleType);
      types.put("ubyte", LangPrimType.unsignedByteType);
      types.put("ushort", LangPrimType.unsignedShortType);
      types.put("uint", LangPrimType.unsignedIntType);
      types.put("ulong", LangPrimType.unsignedLongType);
      types.put("never-returns", Type.neverReturnsType);
      
      types.put("dynamic", LangObjType.dynamicType);
      types.put("Object", Type.objectType);
      types.put("String", Type.toStringType);
      
      types.put("object", Type.objectType);
      types.put("number", LangObjType.numericType);
      types.put("quantity", ClassType.make("gnu.math.Quantity"));
      types.put("complex", ClassType.make("gnu.math.Complex"));
      types.put("real", LangObjType.realType);
      types.put("rational", LangObjType.rationalType);
      types.put("integer", LangObjType.integerType);
      types.put("symbol", ClassType.make("gnu.mapping.Symbol"));
      types.put("simple-symbol", ClassType.make("gnu.mapping.SimpleSymbol"));
      types.put("namespace", ClassType.make("gnu.mapping.Namespace"));
      types.put("keyword", ClassType.make("gnu.expr.Keyword"));
      types.put("pair", ClassType.make("gnu.lists.Pair"));
      types.put("pair-with-position", ClassType.make("gnu.lists.PairWithPosition"));
      
      types.put("constant-string", ClassType.make("java.lang.String"));
      types.put("abstract-string", ClassType.make("gnu.lists.CharSeq"));
      types.put("vector", LangObjType.vectorType);
      types.put("string", LangObjType.stringType);
      types.put("empty-list", ClassType.make("gnu.lists.EmptyList"));
      types.put("sequence", LangObjType.sequenceType);
      types.put("list", LangObjType.listType);
      types.put("function", ClassType.make("gnu.mapping.Procedure"));
      types.put("procedure", LangObjType.procedureType);
      types.put("input-port", ClassType.make("gnu.kawa.io.InPort"));
      types.put("output-port", ClassType.make("gnu.kawa.io.OutPort"));
      types.put("string-output-port", ClassType.make("gnu.kawa.io.CharArrayOutPort"));
      
      types.put("string-input-port", ClassType.make("gnu.kawa.io.CharArrayInPort"));
      
      types.put("record", ClassType.make("kawa.lang.Record"));
      types.put("type", LangObjType.typeType);
      types.put("class-type", LangObjType.typeClassType);
      types.put("class", LangObjType.typeClass);
      types.put("promise", LangObjType.promiseType);
      types.put("document", ClassType.make("gnu.kawa.xml.KDocument"));
      types.put("readtable", ClassType.make("gnu.kawa.lispexpr.ReadTable"));
      
      types.put("string-cursor", LangPrimType.stringCursorType);
    }
    return types;
  }
  








  public Type getPackageStyleType(String name)
  {
    int colon = name.indexOf(':');
    
    if (colon > 0) {
      String lang = name.substring(0, colon);
      Language interp = Language.getInstance(lang);
      if (interp == null) {
        throw new RuntimeException("unknown type '" + name + "' - unknown language '" + lang + '\'');
      }
      
      Type type = interp.getNamedType(name.substring(colon + 1));
      
      if (type != null)
        types.put(name, type);
      return type;
    }
    return null;
  }
  


  public Type getNamedType(String name)
  {
    Type type = (Type)getTypeMap().get(name);
    return type != null ? type : getPackageStyleType(name);
  }
  

  public Type getTypeFor(Class clas)
  {
    String name = clas.getName();
    if (clas.isPrimitive()) {
      return getNamedType(name);
    }
    

    if ("java.lang.String".equals(name))
      return Type.toStringType;
    Type t = LangObjType.getInstanceFromClass(name);
    if (t != null)
      return t;
    return super.getTypeFor(clas);
  }
  
  public String getPrimaryPrompt() {
    return "#|kawa:%N|# ";
  }
  
  public String getSecondaryPrompt() { return "#|%P.%N|# "; }
  
  public LispLanguage() {}
  
  public abstract ReadTable createReadTable();
}
