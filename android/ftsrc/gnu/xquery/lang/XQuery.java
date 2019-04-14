package gnu.xquery.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.kawa.functions.ConstantFunction0;
import gnu.kawa.io.InPort;
import gnu.kawa.xml.XDataType;
import gnu.kawa.xml.XIntegerType;
import gnu.kawa.xml.XStringType;
import gnu.kawa.xml.XTimeType;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.text.Char;
import gnu.text.SourceMessages;
import java.io.Reader;
import java.util.Vector;

public class XQuery extends Language
{
  public static final String XQUERY_FUNCTION_NAMESPACE = "http://www.w3.org/2005/xpath-functions";
  public static final String KAWA_FUNCTION_NAMESPACE = "http://kawa.gnu.org/";
  public static final String QEXO_FUNCTION_NAMESPACE = "http://qexo.gnu.org/";
  public static final String LOCAL_NAMESPACE = "http://www.w3.org/2005/xquery-local-functions";
  public static final String SCHEMA_NAMESPACE = "http://www.w3.org/2001/XMLSchema";
  public static final String SCHEMA_INSTANCE_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";
  public static final String XHTML_NAMESPACE = "http://www.w3.org/1999/xhtml";
  public static final Namespace xqueryFunctionNamespace = Namespace.valueOf("http://www.w3.org/2005/xpath-functions");
  
  public static final Namespace kawaFunctionNamespace = Namespace.valueOf("http://kawa.gnu.org/");
  
  public static final Namespace qexoFunctionNamespace = Namespace.valueOf("http://qexo.gnu.org/");
  
  public static final Namespace[] defaultFunctionNamespacePath = { qexoFunctionNamespace, xqueryFunctionNamespace, Namespace.EmptyNamespace, kawaFunctionNamespace };
  



  static boolean charIsInt = false;
  

  public static final String DEFAULT_ELEMENT_PREFIX = null;
  public static final String DEFAULT_FUNCTION_PREFIX = "(functions)";
  Namespace defaultNamespace;
  public static final int PARSE_WITH_FOCUS = 65536;
  public static final int VARIADIC_FUNCTION_NAMESPACE = -2;
  
  public boolean hasSeparateFunctionNamespace()
  {
    return true;
  }
  
  public static Numeric asNumber(Object arg)
  {
    if ((arg instanceof Char))
      return IntNum.valueOf(((Char)arg).intValue());
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
  
  public boolean isTrue(Object value)
  {
    return gnu.xquery.util.BooleanValue.booleanValue(value);
  }
  
  public gnu.text.Lexer getLexer(InPort inp, SourceMessages messages)
  {
    return new XQParser(inp, messages, this);
  }
  
  public Compilation getCompilation(gnu.text.Lexer lexer, SourceMessages messages, gnu.expr.NameLookup lexical)
  {
    return new Compilation(this, messages, lexical);
  }
  



  public boolean parse(Compilation tr, int options)
    throws java.io.IOException, gnu.text.SyntaxException
  {
    gnu.expr.ModuleExp mexp = mainLambda;
    Compilation.defaultCallConvention = 2;
    tr.mustCompileHere();
    XQParser parser = (XQParser)lexer;
    if (parser.isInteractive())
    {
      Expression sexp = parser.parse(tr);
      if (sexp == null)
        return false;
      body = sexp;
    }
    else if ((options & 0x10000) != 0)
    {
      LambdaExp lexp = new LambdaExp(3);
      Declaration dotDecl = lexp.addDeclaration(XQParser.DOT_VARNAME);
      dotDecl.setFlag(262144L);
      dotDecl.noteValueUnknown();
      lexp.addDeclaration(XQParser.POSITION_VARNAME, Type.intType);
      lexp.addDeclaration(XQParser.LAST_VARNAME, Type.intType);
      tr.push(lexp);
      body = parser.parse(tr);
      tr.pop(lexp);
      body = lexp;
    }
    else
    {
      Vector exps = new Vector(10);
      Expression sexp = body;
      if ((sexp instanceof BeginExp))
      {
        BeginExp bexp = (BeginExp)sexp;
        int blen = bexp.getExpressionCount();
        Expression[] bexps = bexp.getExpressions();
        for (int i = 0; i < blen; i++) {
          exps.addElement(bexps[i]);
        }
      } else if ((sexp != null) && (sexp != QuoteExp.voidExp))
      {
        exps.addElement(sexp);
      }
      for (;;)
      {
        sexp = parser.parse(tr);
        if (sexp == null)
        {
          if ((parseCount != 0) || (parser.isInteractive()))
            break;
          parser.error('e', "empty module", "XPST0003");
          return false;
        }
        

        exps.addElement(sexp);
      }
      int nexps = exps.size();
      if (nexps == 0) {
        body = QuoteExp.voidExp;
      } else if (nexps == 1) {
        body = ((Expression)exps.elementAt(0));
      }
      else {
        Expression[] arr = new Expression[nexps];
        exps.copyInto(arr);
        body = new BeginExp(arr);
      }
    }
    


    tr.pop(mexp);
    









    XQResolveNames resolver = new XQResolveNames(tr);
    functionNamespacePath = functionNamespacePath;
    parser = parser;
    resolver.resolveModule(mexp);
    tr.setState(4);
    return true;
  }
  




  public static int namespaceForFunctions(int argCount)
  {
    return argCount << 2 | 0x2;
  }
  



  public int getNamespaceOf(Declaration decl)
  {
    if (decl.isProcedureDecl())
    {
      if (decl.getCode() < 0)
        return -2;
      Expression value = decl.getValue();
      if ((value instanceof LambdaExp))
      {
        LambdaExp lexp = (LambdaExp)value;
        if (min_args == max_args) {
          return namespaceForFunctions(min_args);
        }
      } else if ((value instanceof QuoteExp))
      {
        Object val = ((QuoteExp)value).getValue();
        if ((val instanceof Procedure))
        {
          Procedure proc = (Procedure)val;
          int min = proc.minArgs();
          int max = proc.maxArgs();
          if (min == max) {
            return namespaceForFunctions(min);
          }
        }
      } else if ((value instanceof gnu.expr.ReferenceExp)) {
        return getNamespaceOf(((gnu.expr.ReferenceExp)value).getBinding());
      }
      return -2;
    }
    return 1;
  }
  
  public boolean hasNamespace(Declaration decl, int namespace)
  {
    int dnspace = getNamespaceOf(decl);
    return (dnspace == namespace) || ((dnspace == -2) && ((namespace & 0x2) != 0)) || ((namespace == -2) && ((dnspace & 0x2) != 0));
  }
  




  public Symbol getSymbol(String name)
  {
    return Symbol.make(defaultNamespace, name);
  }
  
  public void define(String name, Object value)
  {
    Symbol sym = Symbol.make(defaultNamespace, name);
    Object prop = (value instanceof Procedure) ? gnu.mapping.EnvironmentKey.FUNCTION : null;
    environ.define(sym, prop, value);
  }
  
  protected void define_method(String name, String cname, String mname)
  {
    Symbol sym = Symbol.make(defaultNamespace, name);
    

    ClassType ctype = ClassType.make(cname);
    Procedure proc = gnu.kawa.reflect.ClassMethods.apply(ctype, mname, '\000', this);
    proc.setSymbol(sym);
    environ.define(sym, gnu.mapping.EnvironmentKey.FUNCTION, proc);
  }
  
  public String getName()
  {
    return "XQuery";
  }
  
  static int envCounter = 0;
  

  public static Environment extensionsEnvEnv = Environment.getInstance("http://kawa.gnu.org/");
  











  public void applyWithFocus(Procedure proc, Object item, int position, int size, Consumer out)
    throws Throwable
  {
    CallContext ctx = CallContext.getInstance();
    proc.check3(item, IntNum.valueOf(position), IntNum.valueOf(size), ctx);
    Consumer save = consumer;
    try
    {
      consumer = out;
      ctx.runUntilDone();
    }
    finally
    {
      consumer = save;
    }
  }
  









  public Object applyWithFocus(Procedure proc, Object item, int position, int size)
    throws Throwable
  {
    CallContext ctx = CallContext.getInstance();
    int oldIndex = ctx.startFromContext();
    try
    {
      proc.check3(item, IntNum.valueOf(position), IntNum.valueOf(size), ctx);
      return ctx.getFromContext(oldIndex);
    }
    catch (Throwable ex)
    {
      ctx.cleanupFromContext(oldIndex);
      throw ex;
    }
  }
  








  public void applyWithFocus(Procedure proc, Object values, Consumer out)
    throws Throwable
  {
    CallContext ctx = CallContext.getInstance();
    Consumer save = consumer;
    try
    {
      consumer = out;
      applyWithFocus$X(proc, values, ctx);
    }
    finally
    {
      consumer = save;
    }
  }
  








  public Object applyWithFocus(Procedure proc, Object values)
    throws Throwable
  {
    CallContext ctx = CallContext.getInstance();
    int oldIndex = ctx.startFromContext();
    try
    {
      applyWithFocus$X(proc, values, ctx);
      return ctx.getFromContext(oldIndex);
    }
    catch (Throwable ex)
    {
      ctx.cleanupFromContext(oldIndex);
      throw ex;
    }
  }
  










  public void applyWithFocus$X(Procedure proc, Object values, CallContext ctx)
    throws Throwable
  {
    if ((values instanceof Values))
    {
      Values v = (Values)values;
      int count = v.size();
      if (count == 0)
        return;
      int ipos = 0;
      IntNum size = IntNum.valueOf(count);
      for (int i = 1;; i++)
      {
        proc.check3(v.getPosNext(ipos), IntNum.valueOf(i), size, ctx);
        ctx.runUntilDone();
        if (i == count)
          break;
        ipos = v.nextPos(ipos);
      }
    }
    else
    {
      IntNum one = IntNum.one();
      proc.check3(values, one, one, ctx);
      ctx.runUntilDone();
    }
  }
  






  public Procedure evalToFocusProc(String expr)
    throws Throwable
  {
    SourceMessages messages = new SourceMessages();
    Procedure proc = evalToFocusProc(new gnu.kawa.io.CharArrayInPort(expr), messages);
    if (messages.seenErrors()) {
      throw new RuntimeException("invalid syntax in eval form:\n" + messages.toString(20));
    }
    return proc;
  }
  







  public Procedure evalToFocusProc(Reader in, SourceMessages messages)
    throws Throwable
  {
    InPort port = (in instanceof InPort) ? (InPort)in : new InPort(in);
    Compilation comp = parse(port, messages, 65537);
    CallContext ctx = CallContext.getInstance();
    int oldIndex = ctx.startFromContext();
    try
    {
      gnu.expr.ModuleExp.evalModule(Environment.getCurrent(), ctx, comp, null, null);
      return (Procedure)ctx.getFromContext(oldIndex);
    }
    catch (Throwable ex)
    {
      ctx.cleanupFromContext(oldIndex);
      throw ex;
    }
  }
  








  public void evalWithFocus(Reader in, SourceMessages messages, Object values, Consumer out)
    throws Throwable
  {
    applyWithFocus(evalToFocusProc(in, messages), values, out);
  }
  






  public Object evalWithFocus(String expr, Object values)
    throws Throwable
  {
    return applyWithFocus(evalToFocusProc(expr), values);
  }
  








  public Object evalWithFocus(String expr, Object item, int position, int size)
    throws Throwable
  {
    return applyWithFocus(evalToFocusProc(expr), item, position, size);
  }
  










  public void evalWithFocus(Reader in, SourceMessages messages, Object item, int position, int size, Consumer out)
    throws Throwable
  {
    applyWithFocus(evalToFocusProc(in, messages), item, position, size, out);
  }
  








  public void eval_with_focus$X(String expr, Object values, CallContext ctx)
    throws Throwable
  {
    applyWithFocus$X(evalToFocusProc(expr), values, ctx);
  }
  








  public void eval_with_focus$X(String expr, Object item, int position, int size, CallContext ctx)
    throws Throwable
  {
    Procedure proc = evalToFocusProc(expr);
    proc.check3(item, IntNum.valueOf(position), IntNum.valueOf(size), ctx);
  }
  
  public static final Environment xqEnvironment = Environment.make("http://www.w3.org/2005/xpath-functions");
  



  public static final XQuery instance = new XQuery();
  static { instance.initXQuery(); }
  
  public XQuery()
  {
    environ = xqEnvironment;
    defaultNamespace = xqueryFunctionNamespace;
  }
  
  private void initXQuery()
  {
    gnu.expr.ModuleBody.setMainPrintValues(true);
    
    defProcStFld("unescaped-data", "gnu.kawa.xml.MakeUnescapedData", "unescapedData");
    defProcStFld("item-at", "gnu.xquery.util.ItemAt", "itemAt");
    defProcStFld("count", "kawa.lib.xquery.Xutils", "count$Mnvalues");
    define_method("sum", "gnu.xquery.util.Reduce", "sum");
    defProcStFld("avg", "gnu.xquery.util.Average", "avg");
    defProcStFld("sublist", "kawa.lib.xquery.Xutils", "sublist");
    defProcStFld("subsequence", "kawa.lib.xquery.Xutils", "sublist");
    define_method("empty", "gnu.xquery.util.SequenceUtils", "isEmptySequence");
    
    define_method("exists", "gnu.xquery.util.SequenceUtils", "exists");
    
    define_method("insert-before", "gnu.xquery.util.SequenceUtils", "insertBefore$X");
    
    define_method("remove", "gnu.xquery.util.SequenceUtils", "remove$X");
    
    define_method("reverse", "gnu.xquery.util.SequenceUtils", "reverse$X");
    
    defProcStFld("false", "gnu.xquery.lang.XQuery", "falseFunction");
    defProcStFld("true", "gnu.xquery.lang.XQuery", "trueFunction");
    defProcStFld("boolean", "gnu.xquery.util.BooleanValue", "booleanValue");
    
    define_method("trace", "gnu.xquery.util.Debug", "trace");
    define_method("error", "gnu.xquery.util.XQException", "error");
    
    defProcStFld("write-to", "gnu.kawa.xml.WriteTo", "writeTo");
    defProcStFld("write-to-if-changed", "gnu.kawa.xml.WriteTo", "writeToIfChanged");
    
    defProcStFld("iterator-items", "gnu.kawa.xml.IteratorItems", "iteratorItems");
    
    defProcStFld("list-items", "gnu.kawa.xml.ListItems", "listItems");
    define_method("node-name", "gnu.xquery.util.NodeUtils", "nodeName");
    define_method("nilled", "gnu.xquery.util.NodeUtils", "nilled");
    define_method("data", "gnu.xquery.util.NodeUtils", "data$X");
    define_method("lower-case", "gnu.xquery.util.StringUtils", "lowerCase");
    define_method("upper-case", "gnu.xquery.util.StringUtils", "upperCase");
    define_method("substring", "gnu.xquery.util.StringUtils", "substring");
    define_method("string-length", "gnu.xquery.util.StringUtils", "stringLength");
    
    define_method("substring-before", "gnu.xquery.util.StringUtils", "substringBefore");
    
    define_method("substring-after", "gnu.xquery.util.StringUtils", "substringAfter");
    
    define_method("translate", "gnu.xquery.util.StringUtils", "translate");
    define_method("encode-for-uri", "gnu.xquery.util.StringUtils", "encodeForUri");
    
    define_method("iri-to-uri", "gnu.xquery.util.StringUtils", "iriToUri");
    define_method("escape-html-uri", "gnu.xquery.util.StringUtils", "escapeHtmlUri");
    


    define_method("contains", "gnu.xquery.util.StringUtils", "contains");
    define_method("starts-with", "gnu.xquery.util.StringUtils", "startsWith");
    define_method("ends-with", "gnu.xquery.util.StringUtils", "endsWith");
    define_method("codepoint-equal", "gnu.xquery.util.StringUtils", "codepointEqual");
    
    define_method("normalize-unicode", "gnu.xquery.util.StringUtils", "normalizeUnicode");
    
    define_method("string-join", "gnu.xquery.util.StringUtils", "stringJoin");
    define_method("concat", "gnu.xquery.util.StringUtils", "concat$V");
    define_method("matches", "gnu.xquery.util.StringUtils", "matches");
    define_method("replace", "gnu.xquery.util.StringUtils", "replace");
    define_method("tokenize", "gnu.xquery.util.StringUtils", "tokenize$X");
    define_method("string-to-codepoints", "gnu.xquery.util.StringUtils", "stringToCodepoints$X");
    
    define_method("codepoints-to-string", "gnu.xquery.util.StringUtils", "codepointsToString");
    

    define_method("abs", "gnu.xquery.util.NumberValue", "abs");
    define_method("floor", "gnu.xquery.util.NumberValue", "floor");
    define_method("ceiling", "gnu.xquery.util.NumberValue", "ceiling");
    define_method("round", "gnu.xquery.util.NumberValue", "round");
    define_method("round-half-to-even", "gnu.xquery.util.NumberValue", "roundHalfToEven");
    

    define_method("QName", "gnu.xquery.util.QNameUtils", "makeQName");
    define_method("resolve-QName", "gnu.xquery.util.QNameUtils", "resolveQNameUsingElement");
    
    define_method("prefix-from-QName", "gnu.xquery.util.QNameUtils", "prefixFromQName");
    
    define_method("local-name-from-QName", "gnu.xquery.util.QNameUtils", "localNameFromQName");
    
    define_method("namespace-uri-from-QName", "gnu.xquery.util.QNameUtils", "namespaceURIFromQName");
    
    define_method("namespace-uri-for-prefix", "gnu.xquery.util.QNameUtils", "namespaceURIForPrefix");
    
    define_method("in-scope-prefixes", "gnu.xquery.util.NodeUtils", "inScopePrefixes$X");
    
    define_method("document-uri", "gnu.xquery.util.NodeUtils", "documentUri");
    
    define_method("years-from-duration", "gnu.xquery.util.TimeUtils", "yearsFromDuration");
    
    define_method("months-from-duration", "gnu.xquery.util.TimeUtils", "monthsFromDuration");
    
    define_method("days-from-duration", "gnu.xquery.util.TimeUtils", "daysFromDuration");
    
    define_method("hours-from-duration", "gnu.xquery.util.TimeUtils", "hoursFromDuration");
    
    define_method("minutes-from-duration", "gnu.xquery.util.TimeUtils", "minutesFromDuration");
    
    define_method("seconds-from-duration", "gnu.xquery.util.TimeUtils", "secondsFromDuration");
    
    define_method("year-from-dateTime", "gnu.xquery.util.TimeUtils", "yearFromDateTime");
    
    define_method("month-from-dateTime", "gnu.xquery.util.TimeUtils", "monthFromDateTime");
    
    define_method("day-from-dateTime", "gnu.xquery.util.TimeUtils", "dayFromDateTime");
    
    define_method("hours-from-dateTime", "gnu.xquery.util.TimeUtils", "hoursFromDateTime");
    
    define_method("minutes-from-dateTime", "gnu.xquery.util.TimeUtils", "minutesFromDateTime");
    
    define_method("seconds-from-dateTime", "gnu.xquery.util.TimeUtils", "secondsFromDateTime");
    
    define_method("timezone-from-dateTime", "gnu.xquery.util.TimeUtils", "timezoneFromDateTime");
    
    define_method("year-from-date", "gnu.xquery.util.TimeUtils", "yearFromDate");
    
    define_method("month-from-date", "gnu.xquery.util.TimeUtils", "monthFromDate");
    
    define_method("day-from-date", "gnu.xquery.util.TimeUtils", "dayFromDate");
    
    define_method("timezone-from-date", "gnu.xquery.util.TimeUtils", "timezoneFromDate");
    
    define_method("hours-from-time", "gnu.xquery.util.TimeUtils", "hoursFromTime");
    
    define_method("minutes-from-time", "gnu.xquery.util.TimeUtils", "minutesFromTime");
    
    define_method("seconds-from-time", "gnu.xquery.util.TimeUtils", "secondsFromTime");
    
    define_method("timezone-from-time", "gnu.xquery.util.TimeUtils", "timezoneFromTime");
    
    define_method("adjust-dateTime-to-timezone", "gnu.xquery.util.TimeUtils", "adjustDateTimeToTimezone");
    
    define_method("adjust-date-to-timezone", "gnu.xquery.util.TimeUtils", "adjustDateToTimezone");
    
    define_method("adjust-time-to-timezone", "gnu.xquery.util.TimeUtils", "adjustTimeToTimezone");
    
    define_method("dateTime", "gnu.xquery.util.TimeUtils", "dateTime");
    define_method("current-dateTime", "gnu.xquery.util.TimeUtils", "currentDateTime");
    
    define_method("current-date", "gnu.xquery.util.TimeUtils", "currentDate");
    
    define_method("current-time", "gnu.xquery.util.TimeUtils", "currentTime");
    
    define_method("implicit-timezone", "gnu.xquery.util.TimeUtils", "implicitTimezone");
    

    define_method("zero-or-one", "gnu.xquery.util.SequenceUtils", "zeroOrOne");
    define_method("one-or-more", "gnu.xquery.util.SequenceUtils", "oneOrMore");
    define_method("exactly-one", "gnu.xquery.util.SequenceUtils", "exactlyOne");
    
    defProcStFld("distinct-nodes", "gnu.kawa.xml.SortNodes", "sortNodes");
    

    defProcStFld("children", "gnu.kawa.xml.Children", "children");
    define_method("not", "gnu.xquery.util.BooleanValue", "not");
    
    defaultNamespace = qexoFunctionNamespace;
    defProcStFld("response-header", "gnu.kawa.servlet.HTTP");
    defProcStFld("response-content-type", "gnu.kawa.servlet.HTTP");
    defProcStFld("response-status", "gnu.kawa.servlet.HTTP");
    defProcStFld("error-response", "gnu.kawa.servlet.HTTP");
    defProcStFld("current-servlet", "gnu.kawa.servlet.HTTP");
    defProcStFld("current-servlet-context", "gnu.kawa.servlet.HTTP");
    defProcStFld("current-servlet-config", "gnu.kawa.servlet.HTTP");
    defProcStFld("servlet-context-realpath", "gnu.kawa.servlet.HTTP");
    defProcStFld("get-response", "gnu.kawa.servlet.HTTP");
    defProcStFld("get-request", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-method", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-uri", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-url", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-path-info", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-path-translated", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-servlet-path", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-query-string", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-parameter", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-parameters", "gnu.kawa.servlet.HTTP");
    defaultNamespace = xqueryFunctionNamespace;
  }
  
  public static XQuery getInstance()
  {
    return instance;
  }
  

  public static void registerEnvironment()
  {
    gnu.expr.ApplicationMainSupport.processCommandLinePropertyAssignments = true;
    Language.setDefaults(instance);
  }
  
  public static QuoteExp falseExp = new QuoteExp(Boolean.FALSE, XDataType.booleanType);
  
  public static QuoteExp trueExp = new QuoteExp(Boolean.TRUE, XDataType.booleanType);
  

  public static final ConstantFunction0 falseFunction = new ConstantFunction0("false", falseExp);
  
  public static final ConstantFunction0 trueFunction = new ConstantFunction0("true", trueExp);
  

  public Consumer getOutputConsumer(java.io.Writer out)
  {
    return new gnu.xml.XMLPrinter(out);
  }
  
  static Object[] typeMap = { "string", XDataType.stringType, "untypedAtomic", XDataType.untypedAtomicType, "boolean", XDataType.booleanType, "integer", XIntegerType.integerType, "long", XIntegerType.longType, "int", XIntegerType.intType, "short", XIntegerType.shortType, "byte", XIntegerType.byteType, "unsignedLong", XIntegerType.unsignedLongType, "unsignedInt", XIntegerType.unsignedIntType, "unsignedShort", XIntegerType.unsignedShortType, "unsignedByte", XIntegerType.unsignedByteType, "positiveInteger", XIntegerType.positiveIntegerType, "nonPositiveInteger", XIntegerType.nonPositiveIntegerType, "negativeInteger", XIntegerType.negativeIntegerType, "nonNegativeInteger", XIntegerType.nonNegativeIntegerType, "date", XTimeType.dateType, "dateTime", XTimeType.dateTimeType, "time", XTimeType.timeType, "duration", XTimeType.durationType, "yearMonthDuration", XTimeType.yearMonthDurationType, "dayTimeDuration", XTimeType.dayTimeDurationType, "gYearMonth", XTimeType.gYearMonthType, "gYear", XTimeType.gYearType, "gMonthDay", XTimeType.gMonthDayType, "gDay", XTimeType.gDayType, "gMonth", XTimeType.gMonthType, "decimal", XDataType.decimalType, "float", XDataType.floatType, "double", XDataType.doubleType, "anyURI", XDataType.anyURIType, "hexBinary", XDataType.hexBinaryType, "base64Binary", XDataType.base64BinaryType, "NOTATION", XDataType.NotationType, "QName", "gnu.mapping.Symbol", "normalizedString", XStringType.normalizedStringType, "token", XStringType.tokenType, "language", XStringType.languageType, "NMTOKEN", XStringType.NMTOKENType, "Name", XStringType.NameType, "NCName", XStringType.NCNameType, "ID", XStringType.IDType, "IDREF", XStringType.IDREFType, "ENTITY", XStringType.ENTITYType, "anyAtomicType", XDataType.anyAtomicType, "anySimpleType", XDataType.anySimpleType, "untyped", XDataType.untypedType, "anyType", Type.objectType };
  

















































  public Type getStandardType(String name)
  {
    int i = typeMap.length; do { i -= 2; if (i < 0)
        break;
    } while (!typeMap[i].equals(name));
    
    Object t = typeMap[(i + 1)];
    if ((t instanceof String)) {
      return super.getTypeFor((String)t);
    }
    return (Type)t;
    

    return null;
  }
  

  public Type getTypeFor(String name)
  {
    String core = name.startsWith("xdt:") ? name.substring(4) : name.startsWith("xs:") ? name.substring(3) : name;
    

    Type t = getStandardType(core);
    return t != null ? t : super.getTypeFor(name);
  }
  

  public String formatType(Type type)
  {
    String tname = type.getName();
    if ("gnu.math.IntNum".equals(tname))
      return "xs:integer";
    if (("java.lang.String".equals(tname)) || ("java.lang.CharSequence".equals(tname)))
    {
      return "xs:string"; }
    return type.toString();
  }
  

  public Type getTypeFor(Class clas)
  {
    if (clas.isPrimitive())
    {
      String name = clas.getName();
      if (name.equals("boolean"))
        return XDataType.booleanType;
      return super.getTypeFor(name);
    }
    if (!clas.isArray())
    {
      String name = clas.getName();
      if (name.equals("java.lang.String"))
        return XDataType.stringStringType;
      if (name.equals("gnu.kawa.xml.UntypedAtomic"))
        return XDataType.untypedAtomicType;
      if (name.equals("java.lang.Boolean"))
        return XDataType.booleanType;
      if (name.equals("java.lang.Float"))
        return XDataType.floatType;
      if (name.equals("java.lang.Double"))
        return XDataType.doubleType;
      if (name.equals("java.math.BigDecimal"))
        return XDataType.decimalType;
      if (name.equals("gnu.math.Duration"))
        return XDataType.durationType;
      if (name.equals("gnu.kawa.io.Path"))
        return XDataType.anyURIType;
    }
    return Type.make(clas);
  }
  

  public String getPrimaryPrompt() { return "<!--%N-->"; }
  
  public String getSecondaryPrompt() { return "{%P.%N} "; }
  
























  static void mangle(String name, int start, int length, StringBuffer sbuf, char mode)
  {
    char prev = 'P';
    int outStart = sbuf.length();
    for (int i = 0; i < length;)
    {

      char ch = name.charAt(start + i);
      i++;
      if (Character.isUpperCase(ch))
      {
        boolean wordStart = (prev != 'U') || ((i < length) && (Character.isLowerCase(name.charAt(start + i))));
        

        prev = 'U';
      }
      else if (Character.isLowerCase(ch))
      {
        boolean wordStart = (prev != 'L') || (prev != 'U');
        prev = 'L';
      }
      else if (Character.isLetter(ch))
      {
        boolean wordStart = prev != 'O';
        prev = 'O';
      }
      else if (Character.isDigit(ch))
      {
        boolean wordStart = prev != 'D';
        prev = 'D';
      }
      else if (Character.isJavaIdentifierPart(ch))
      {
        boolean wordStart = (prev != 'D') && (prev != 'M');
        prev = 'M';
      }
      else
      {
        prev = 'P';
        continue; }
      boolean wordStart;
      if ((wordStart) || (mode == '_'))
      {
        if ((wordStart) && (mode == '_') && (sbuf.length() > outStart))
          sbuf.append('_');
        ch = Character.toUpperCase(ch);
      }
      sbuf.append(ch);
    }
  }
  
  public static String mangle(String name) {
    StringBuffer sbuf = new StringBuffer();
    mangle(name, 0, name.length(), sbuf, 'U');
    return sbuf.toString();
  }
  
  public static String makeClassName(String source)
  {
    source = source.replace(java.io.File.separatorChar, '/');
    int sl = source.lastIndexOf('/');
    if (sl >= 0)
      source = source.substring(sl + 1);
    int dot = source.lastIndexOf('.');
    if (dot >= 0)
      source = source.substring(0, dot);
    return gnu.expr.Mangling.mangleNameIfNeeded(source);
  }
  
  public static Object getExternal(Symbol name, Object type)
  {
    Environment env = Environment.getCurrent();
    Object value = env.get(name, null, null);
    if (value == null) {
      value = env.get(Symbol.makeWithUnknownNamespace(name.getLocalName(), name.getPrefix()), null, null);
    }
    
    if (value == null)
      throw new RuntimeException("unbound external " + name);
    if (type == null)
      return value;
    if ((type instanceof XDataType))
      return ((XDataType)type).cast(value);
    if ((type instanceof ClassType))
    {
      String cname = ((ClassType)type).getName();
      
      if ("gnu.math.IntNum".equals(cname))
        return IntNum.valueOf(value.toString());
      if ("gnu.math.RealNum".equals(cname)) {
        return gnu.math.DFloNum.valueOf(Double.parseDouble(value.toString()));
      }
    }
    try {
      value = ((Type)type).coerceFromObject(value);
    }
    catch (ClassCastException ex)
    {
      throw new gnu.mapping.WrongType(name.toString(), -2, value, type.toString());
    }
    


    return value;
  }
  
  public void resolve(Compilation comp) {}
}
