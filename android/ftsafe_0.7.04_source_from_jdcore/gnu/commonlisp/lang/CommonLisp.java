package gnu.commonlisp.lang;

import gnu.bytecode.Type;
import gnu.expr.Keyword;
import gnu.kawa.format.AbstractFormat;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.mapping.Environment;
import gnu.mapping.LocationEnumeration;
import gnu.mapping.Symbol;
import gnu.math.Numeric;
import gnu.text.Char;

public class CommonLisp extends Lisp2
{
  static boolean charIsInt = false;
  public static final CommonLisp instance;
  
  public static Object getCharacter(int c)
  {
    if (charIsInt) {
      return gnu.math.IntNum.make(c);
    }
    return Char.make((char)c);
  }
  
  public static Numeric asNumber(Object arg)
  {
    if ((arg instanceof Char))
      return gnu.math.IntNum.make(((Char)arg).intValue());
    return (Numeric)arg;
  }
  
  public static char asChar(Object x)
  {
    if ((x instanceof Char))
      return ((Char)x).charValue();
    int i;
    int i; if ((x instanceof Numeric)) {
      i = ((Numeric)x).intValue();
    } else
      i = -1;
    if ((i < 0) || (i > 65535))
      throw new ClassCastException("not a character value");
    return (char)i;
  }
  
  public String getName()
  {
    return "CommonLisp";
  }
  




  public static final Environment clispEnvironment = Environment.make("clisp-environment");
  
  public static final NumberCompare numEqu;
  
  public static final NumberCompare numGrt;
  
  public static final NumberCompare numGEq;
  
  public static final NumberCompare numLss;
  
  public static final NumberCompare numLEq;
  public static final gnu.kawa.functions.Not not;
  public static final IsEq isEq;
  public static final IsEqv isEqv;
  public static final Symbol internalKeyword = Keyword.make("INTERNAL");
  public static final Symbol inheritedKeyword = Keyword.make("INHERITED");
  public static final Symbol externalKeyword = Keyword.make("EXTERNAL");
  
  static
  {
    instance = new CommonLisp();
    
    instance.define("t", TRUE);
    instance.define("nil", FALSE);
    not = new gnu.kawa.functions.Not(instance, "not");
    numEqu = NumberCompare.make(instance, "=", 8);
    
    numGrt = NumberCompare.make(instance, ">", 16);
    
    numGEq = NumberCompare.make(instance, ">=", 24);
    
    numLss = NumberCompare.make(instance, "<", 4);
    
    numLEq = NumberCompare.make(instance, "<=", 12);
    
    isEq = new IsEq(instance, "eq?");
    isEqv = new IsEqv(instance, "eqv?", isEq);
    
    Environment saveEnv = Environment.setSaveCurrent(clispEnvironment);
    try
    {
      instance.initLisp();
    }
    finally
    {
      Environment.restoreCurrent(saveEnv);
    }
  }
  
  public CommonLisp()
  {
    environ = clispEnvironment;
  }
  
  void initLisp()
  {
    LocationEnumeration e = kawa.standard.Scheme.builtin().enumerateAllLocations();
    while (e.hasMoreElements())
    {
      importLocation(e.nextLocation());
    }
    

    try
    {
      loadClass("kawa.lib.prim_syntax");
      loadClass("kawa.lib.std_syntax");
      loadClass("kawa.lib.lists");
      loadClass("kawa.lib.strings");
      loadClass("gnu.commonlisp.lisp.PrimOps");
    }
    catch (ClassNotFoundException ex) {}
    



    OrdinaryLambda lambda = new OrdinaryLambda();
    lambda.setKeywords(asSymbol("&optional"), asSymbol("&rest"), asSymbol("&key"), asSymbol("&allow-other-keys"), asSymbol("&aux"), asSymbol("&body"));
    




    defaultDefault = nilExpr;
    defun("lambda", lambda);
    defun("defun", new defun(lambda));
    
    defun("defvar", new defvar(false));
    defun("defconst", new defvar(true));
    defun("defsubst", new defun(lambda));
    defun("function", new function(lambda));
    defun("setq", new setq());
    defun("prog1", new prog1("prog1", 1));
    defun("prog2", prog1.prog2);
    defun("progn", new kawa.standard.begin());
    defun("unwind-protect", new UnwindProtect());
    defun("null", not);
    defun("eq", new IsEq(this, "eq"));
    defun("equal", new gnu.kawa.functions.IsEqual(this, "equal"));
    defun("typep", new gnu.kawa.reflect.InstanceOf(this));
    defProcStFld("the", "gnu.kawa.functions.Convert", "as");
    defun("%flet", new kawa.standard.let("flet", true));
    defProcStFld("princ", "gnu.commonlisp.lisp.PrimOps");
    defProcStFld("prin1", "gnu.commonlisp.lisp.PrimOps");
    
    defAliasStFld("*package*", "gnu.kawa.lispexpr.LispPackage", "currentPackage");
    defProcStFld("=", "gnu.commonlisp.lang.CommonLisp", "numEqu");
    defProcStFld("<", "gnu.commonlisp.lang.CommonLisp", "numLss");
    defProcStFld(">", "gnu.commonlisp.lang.CommonLisp", "numGrt");
    defProcStFld("<=", "gnu.commonlisp.lang.CommonLisp", "numLEq");
    defProcStFld(">=", "gnu.commonlisp.lang.CommonLisp", "numGEq");
    defProcStFld("not", "gnu.commonlisp.lang.CommonLisp");
    defProcStFld("eq?", "gnu.commonlisp.lang.CommonLisp", "isEq");
    defProcStFld("eqv?", "gnu.commonlisp.lang.CommonLisp", "isEqv");
    defProcStFld("functionp", "gnu.commonlisp.lisp.PrimOps");
    defProcStFld("car", "gnu.commonlisp.lisp.primitives");
    defProcStFld("first", "gnu.commonlisp.lisp.primitives");
    defProcStFld("cdr", "gnu.commonlisp.lisp.primitives");
    defProcStFld("caar", "kawa.lib.lists");
    defProcStFld("cadr", "kawa.lib.lists");
    defProcStFld("cdar", "kawa.lib.lists");
    defProcStFld("cddr", "kawa.lib.lists");
    defProcStFld("caaar", "kawa.lib.lists");
    defProcStFld("caadr", "kawa.lib.lists");
    defProcStFld("cadar", "kawa.lib.lists");
    defProcStFld("caddr", "kawa.lib.lists");
    defProcStFld("cdaar", "kawa.lib.lists");
    defProcStFld("cdadr", "kawa.lib.lists");
    defProcStFld("cddar", "kawa.lib.lists");
    defProcStFld("cdddr", "kawa.lib.lists");
    defProcStFld("caaaar", "kawa.lib.lists");
    defProcStFld("caaadr", "kawa.lib.lists");
    defProcStFld("caadar", "kawa.lib.lists");
    defProcStFld("caaddr", "kawa.lib.lists");
    defProcStFld("cadaar", "kawa.lib.lists");
    defProcStFld("cadadr", "kawa.lib.lists");
    defProcStFld("caddar", "kawa.lib.lists");
    defProcStFld("cadddr", "kawa.lib.lists");
    defProcStFld("cdaaar", "kawa.lib.lists");
    defProcStFld("cdaadr", "kawa.lib.lists");
    defProcStFld("cdadar", "kawa.lib.lists");
    defProcStFld("cdaddr", "kawa.lib.lists");
    defProcStFld("cddaar", "kawa.lib.lists");
    defProcStFld("cddadr", "kawa.lib.lists");
    defProcStFld("cdddar", "kawa.lib.lists");
    defProcStFld("cddddr", "kawa.lib.lists");
    defProcStFld("rest", "gnu.commonlisp.lisp.primitives");
    defProcStFld("second", "gnu.commonlisp.lisp.primitives");
    defProcStFld("third", "gnu.commonlisp.lisp.primitives");
    defProcStFld("nthcdr", "gnu.commonlisp.lisp.primitives");
    defProcStFld("nth", "gnu.commonlisp.lisp.primitives");
    defProcStFld("1-", "gnu.commonlisp.lisp.primitives");
    defProcStFld("1+", "gnu.commonlisp.lisp.primitives");
    defProcStFld("acons", "gnu.commonlisp.lisp.primitives");
    defProcStFld("listp", "gnu.commonlisp.lisp.primitives");
    defProcStFld("numberp", "gnu.commonlisp.lisp.primitives");
    defProcStFldAs("zerop", "kawa.lib.numbers", "zero?");
    defProcStFldAs("consp", "kawa.lib.lists", "pair?");
    defProcStFld("atom", "gnu.commonlisp.lisp.primitives");
    defProcStFld("eql", "gnu.commonlisp.lisp.primitives");
    defProcStFld("member", "gnu.commonlisp.lisp.primitives");
    defProcStFld("complement", "gnu.commonlisp.lisp.primitives");
    defProcStFld("apply", "gnu.commonlisp.lisp.primitives");
    defProcStFld("funcall", "gnu.commonlisp.lisp.primitives");
    defProcStFld("minusp", "gnu.commonlisp.lisp.primitives");
    defProcStFld("plusp", "gnu.commonlisp.lisp.primitives");
    defProcStFld("flet", "gnu.commonlisp.lisp.primitives");
    defProcStFld("labels", "gnu.commonlisp.lisp.primitives");
    defProcStFld("multiple-value-bind", "gnu.commonlisp.lisp.primitives");
    defProcStFld("floor", "gnu.commonlisp.lisp.primitives");
  }
  
  public static CommonLisp getInstance()
  {
    return instance;
  }
  

  public static void registerEnvironment()
  {
    gnu.expr.Language.setDefaults(instance);
  }
  
  public static final AbstractFormat writeFormat = new DisplayFormat(true, 'C');
  
  public static final AbstractFormat displayFormat = new DisplayFormat(false, 'C');
  LangPrimType booleanType;
  
  public AbstractFormat getFormat(boolean readable)
  {
    return readable ? writeFormat : displayFormat;
  }
  


  public Type getTypeFor(String name)
  {
    if (name == "t")
      name = "java.lang.Object";
    return super.getTypeFor(name);
  }
  
  public Type getTypeFor(Class clas)
  {
    if (clas.isPrimitive())
      return getNamedType(clas.getName());
    return Type.make(clas);
  }
  
  public Type getNamedType(String name) {
    if (name.equals("boolean")) {
      if (booleanType == null)
        booleanType = new LangPrimType(Type.booleanType, this);
      return booleanType;
    }
    return super.getNamedType(name);
  }
}
