package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleContext;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kawa.Version;
import kawa.lang.Translator;

public class IfFeature extends kawa.lang.Syntax
{
  public static final IfFeature condExpand = new IfFeature();
  private static List<String> coreFeatures;
  public static final String PROVIDE_PREFIX = "%provide%";
  
  public void scanForm(Pair st, ScopeExp defs, Translator tr) {
    Object forms = evaluate(st.getCdr(), tr);
    tr.scanBody(forms, defs, false);
  }
  
  public Expression rewriteForm(Pair form, Translator tr) {
    Object forms = evaluate(form.getCdr(), tr);
    return tr.rewrite_body(forms);
  }
  
  public boolean evaluateConditionCar(Pair pair, Translator tr) {
    Object save = tr.pushPositionOf(pair);
    boolean r = evaluateCondition(pair.getCar(), tr);
    tr.popPositionOf(save);
    return r;
  }
  
  public boolean evaluateCondition(Object form, Translator tr) {
    form = tr.namespaceResolve(Translator.stripSyntax(form));
    if (((form instanceof String)) || ((form instanceof SimpleSymbol)))
      return hasFeature(form.toString());
    if ((form instanceof Pair)) {
      Pair pair = (Pair)form;
      Object keyword = Translator.stripSyntax(pair.getCar());
      if ((keyword == orSymbol) || (keyword == andSymbol)) {
        Object rest = pair.getCdr();
        while ((rest instanceof Pair)) {
          pair = (Pair)rest;
          boolean val = evaluateConditionCar(pair, tr);
          if (val == (keyword == orSymbol))
            return val;
          rest = pair.getCdr();
        }
        tr.errorIfNonEmpty(rest);
        return keyword == andSymbol;
      }
      if (keyword == notSymbol) {
        Object rest = pair.getCdr();
        if ((rest instanceof Pair)) {
          Pair pair2 = (Pair)rest;
          if (pair2.getCdr() == LList.Empty)
            return !evaluateConditionCar(pair2, tr);
        }
        tr.errorWithPosition("'not' must be followed by a single condition", pair);
        return false;
      }
      if (keyword == librarySymbol) {
        Object rest = pair.getCdr();
        if ((rest instanceof Pair)) {
          Pair pair2 = (Pair)rest;
          if (pair2.getCdr() == LList.Empty) {
            return ImportFromLibrary.instance.libraryExists(pair2.getCar(), tr) != null;
          }
        }
        tr.errorWithPosition("'library' must be followed by <library name>", pair);
        return false;
      }
    }
    tr.error('e', "unrecognized cond-expand expression");
    return false;
  }
  
  public Object evaluate(Object clauses, Translator tr) {
    while ((clauses instanceof Pair)) {
      Pair pclauses = (Pair)clauses;
      Object clause = pclauses.getCar();
      clauses = pclauses.getCdr();
      if (!(clause instanceof Pair)) {
        tr.errorWithPosition("cond-expand clauses is not a list", pclauses);
      }
      Pair pclause = (Pair)clause;
      Object test = Translator.stripSyntax(pclause.getCar());
      if (((test == elseSymbol) && (clauses == LList.Empty)) || (evaluateConditionCar(pclause, tr)))
      {
        return pclause.getCdr(); }
    }
    tr.errorIfNonEmpty(clauses);
    return LList.Empty;
  }
  
  static
  {
    condExpand.setName("cond-expand");
    

















































































    coreFeatures = new ArrayList();
    
    coreFeatures.add("kawa");
    coreFeatures.add("kawa-" + Version.getVersion());
    
    coreFeatures.add("complex");
    coreFeatures.add("exact-complex");
    coreFeatures.add("exact-closed");
    coreFeatures.add("ieee-float");
    coreFeatures.add("ratios");
    coreFeatures.add("full-unicode");
    
    String javaVersion = System.getProperty("java.version");
    if ((javaVersion != null) && (javaVersion.length() >= 1)) {
      if ((javaVersion.length() >= 3) && (javaVersion.charAt(0) == '1') && (javaVersion.charAt(1) == '.'))
      {

        javaVersion = javaVersion.substring(2); }
      switch (javaVersion.charAt(0)) {
      case '9': 
        coreFeatures.add("java-9");
      
      case '8': 
        coreFeatures.add("java-8");
      
      case '7': 
        coreFeatures.add("java-7");
      
      case '6': 
        coreFeatures.add("java-6");
      }
      
    }
    
    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
      coreFeatures.add("big-endian");
    } else {
      coreFeatures.add("little-endian");
    }
    String osName = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    

    if (osName.indexOf("linux") >= 0) {
      coreFeatures.add("posix");
      coreFeatures.add("unix");
      coreFeatures.add("linux");
      coreFeatures.add("gnu-linux");
    }
    else if (osName.indexOf("win") >= 0) {
      coreFeatures.add("windows");
    } else if ((osName.indexOf("sunos") >= 0) || (osName.indexOf("solaris") >= 0))
    {
      coreFeatures.add("posix");
      coreFeatures.add("unix");
      coreFeatures.add("solaris");
    } else if ((osName.indexOf("mac") >= 0) || (osName.indexOf("darwin") >= 0))
    {
      coreFeatures.add("posix");
      coreFeatures.add("unix");
      coreFeatures.add("darwin");
      coreFeatures.add("macosx");
    } else if (osName.indexOf("bsd") >= 0) {
      coreFeatures.add("bsd");
      coreFeatures.add("posix");
      coreFeatures.add("unix");
    } else if ((osName.indexOf("nix") >= 0) || (osName.indexOf("nux") >= 0) || (osName.indexOf("aix") > 0))
    {

      coreFeatures.add("posix");
      coreFeatures.add("unix");
    }
    
    String archName = System.getProperty("os.arch").toLowerCase(Locale.ENGLISH);
    
    if ((archName.indexOf("amd64") >= 0) || (archName.indexOf("x86_64") >= 0))
    {
      coreFeatures.add("x86-64");
    } else if ((archName.indexOf("x86") >= 0) || (archName.indexOf("i386") >= 0))
    {
      coreFeatures.add("i386");
    } else if ((archName.indexOf("ppc") >= 0) || (archName.indexOf("powerpc") >= 0))
    {
      coreFeatures.add("ppc");
    } else if (archName.indexOf("sparc") >= 0) {
      coreFeatures.add("sparc");
    }
    coreFeatures.add("jvm");
    
    coreFeatures.add("r7rs");
    
    coreFeatures.add("srfi-0");
    

    coreFeatures.add("srfi-4");
    coreFeatures.add("srfi-6");
    coreFeatures.add("srfi-8");
    coreFeatures.add("srfi-9");
    coreFeatures.add("srfi-11");
    coreFeatures.add("srfi-16");
    coreFeatures.add("srfi-17");
    coreFeatures.add("srfi-23");
    coreFeatures.add("srfi-25");
    coreFeatures.add("srfi-26");
    coreFeatures.add("srfi-28");
    coreFeatures.add("srfi-30");
    coreFeatures.add("srfi-39");
    













    coreFeatures.add("threads");
  }
  


  public static boolean hasFeature(String name)
  {
    int i = coreFeatures.size(); do { i--; if (i < 0) break;
    } while (name != coreFeatures.get(i));
    return true;
    
    if ((name == "in-http-server") || (name == "in-servlet")) {
      int mflags = ModuleContext.getContext().getFlags();
      if (name == "in-http-server")
        return (mflags & ModuleContext.IN_HTTP_SERVER) != 0;
      if (name == "in-servlet") {
        return ((mflags & ModuleContext.IN_SERVLET) != 0) || (Compilation.getCurrent().generatingServlet());
      }
    }
    
    String classExistsPrefix = "class-exists:";
    if (name.startsWith(classExistsPrefix)) {
      name = name.substring(classExistsPrefix.length());
      try {
        Class.forName(name, false, IfFeature.class.getClassLoader());
        return true;
      } catch (ClassNotFoundException ex) {
        return false;
      }
    }
    
    Symbol provide_symbol = Symbol.valueOf("%provide%" + name);
    Declaration decl = Compilation.getCurrent().lookup(provide_symbol, -1);
    if ((decl != null) && (!decl.getFlag(65536L)))
      return true;
    return false;
  }
  



  public static LList featureList()
  {
    LList result = LList.Empty;
    int i = coreFeatures.size(); for (;;) { i--; if (i < 0) break;
      String item = (String)coreFeatures.get(i);
      result = new gnu.lists.ImmutablePair(Symbol.valueOf(item), result);
    }
    return result;
  }
  


  public static boolean isProvide(Declaration decl)
  {
    return decl.getName().startsWith("%provide%");
  }
  
  public static final SimpleSymbol andSymbol = Symbol.valueOf("and");
  public static final SimpleSymbol elseSymbol = Symbol.valueOf("else");
  public static final SimpleSymbol librarySymbol = Symbol.valueOf("library");
  public static final SimpleSymbol notSymbol = Symbol.valueOf("not");
  public static final SimpleSymbol orSymbol = Symbol.valueOf("or");
  
  public IfFeature() {}
}
