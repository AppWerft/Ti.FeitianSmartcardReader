package gnu.xquery.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.ExpExpVisitor;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.NameLookup;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ResolveNames;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.functions.CompileNamedPart;
import gnu.kawa.functions.GetModuleClass;
import gnu.kawa.reflect.SingletonType;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.xml.MakeAttribute;
import gnu.kawa.xml.MakeElement;
import gnu.kawa.xml.NodeType;
import gnu.kawa.xml.XDataType;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.mapping.WrongArguments;
import gnu.text.SourceMessages;
import gnu.xml.NamespaceBinding;
import gnu.xml.XMLFilter;
import gnu.xquery.util.NamedCollator;
import gnu.xquery.util.QNameUtils;
import java.util.HashMap;
import java.util.Map;





































public class XQResolveNames
  extends ResolveNames
{
  public XQParser parser;
  public static final int LAST_BUILTIN = -1;
  public static final int POSITION_BUILTIN = -2;
  public static final int HANDLE_EXTENSION_BUILTIN = -3;
  public static final int COMPARE_BUILTIN = -4;
  public static final int DISTINCT_VALUES_BUILTIN = -5;
  public static final int LOCAL_NAME_BUILTIN = -6;
  public static final int NAMESPACE_URI_BUILTIN = -7;
  public static final int COLLECTION_BUILTIN = -8;
  public static final int DOC_BUILTIN = -9;
  public static final int DOC_AVAILABLE_BUILTIN = -10;
  public static final int BASE_URI_BUILTIN = -11;
  public static final int RESOLVE_URI_BUILTIN = -12;
  public static final int RESOLVE_PREFIX_BUILTIN = -13;
  public static final int STATIC_BASE_URI_BUILTIN = -14;
  public static final int INDEX_OF_BUILTIN = -15;
  public static final int STRING_BUILTIN = -16;
  public static final int NORMALIZE_SPACE_BUILTIN = -17;
  public static final int UNORDERED_BUILTIN = -18;
  public static final int LANG_BUILTIN = -23;
  public static final int NAME_BUILTIN = -24;
  public static final int DEEP_EQUAL_BUILTIN = -25;
  public static final int MIN_BUILTIN = -26;
  public static final int MAX_BUILTIN = -27;
  public static final int NUMBER_BUILTIN = -28;
  public static final int DEFAULT_COLLATION_BUILTIN = -29;
  public static final int ID_BUILTIN = -30;
  public static final int IDREF_BUILTIN = -31;
  public static final int ROOT_BUILTIN = -32;
  public static final int CAST_AS_BUILTIN = -33;
  public static final int CASTABLE_AS_BUILTIN = -34;
  public static final int XS_QNAME_BUILTIN = -35;
  public static final int XS_QNAME_IGNORE_DEFAULT_BUILTIN = -36;
  public static final Declaration handleExtensionDecl = makeBuiltin("(extension)", -3);
  

  public static final Declaration castAsDecl = makeBuiltin("(cast as)", -33);
  

  public static final Declaration castableAsDecl = makeBuiltin("(castable as)", -34);
  


  public static final Declaration lastDecl = makeBuiltin("last", -1);
  

  public static final Declaration xsQNameDecl = makeBuiltin(Symbol.make("http://www.w3.org/2001/XMLSchema", "QName"), -35);
  

  public static final Declaration xsQNameIgnoreDefaultDecl = makeBuiltin(Symbol.make("http://www.w3.org/2001/XMLSchema", "(QName-ignore-default)"), -36);
  

  public static final Declaration staticBaseUriDecl = makeBuiltin("static-base-uri", -14);
  

  public static final Declaration resolvePrefixDecl = makeBuiltin(Symbol.make("http://www.w3.org/2001/XMLSchema", "(resolve-prefix)"), -13);
  



  public static Declaration makeBuiltin(String name, int code)
  {
    return makeBuiltin(Symbol.make("http://www.w3.org/2005/xpath-functions", name, "fn"), code);
  }
  


  public static Declaration makeBuiltin(Symbol name, int code)
  {
    Declaration decl = new Declaration(name);
    decl.setProcedureDecl(true);
    decl.setCode(code);
    return decl;
  }
  
  public XQResolveNames()
  {
    this(null);
  }
  
  void pushBuiltin(String name, int code)
  {
    lookup.push(makeBuiltin(name, code));
  }
  
  public XQResolveNames(Compilation comp)
  {
    super(comp);
    lookup.push(lastDecl);
    lookup.push(xsQNameDecl);
    lookup.push(staticBaseUriDecl);
    pushBuiltin("position", -2);
    pushBuiltin("compare", -4);
    pushBuiltin("distinct-values", -5);
    pushBuiltin("local-name", -6);
    pushBuiltin("name", -24);
    pushBuiltin("namespace-uri", -7);
    pushBuiltin("root", -32);
    pushBuiltin("base-uri", -11);
    pushBuiltin("lang", -23);
    pushBuiltin("resolve-uri", -12);
    pushBuiltin("collection", -8);
    pushBuiltin("doc", -9);
    pushBuiltin("document", -9);
    pushBuiltin("doc-available", -10);
    pushBuiltin("index-of", -15);
    pushBuiltin("string", -16);
    pushBuiltin("normalize-space", -17);
    pushBuiltin("unordered", -18);
    pushBuiltin("deep-equal", -25);
    pushBuiltin("min", -26);
    pushBuiltin("max", -27);
    pushBuiltin("number", -28);
    pushBuiltin("default-collation", -29);
    pushBuiltin("id", -30);
    pushBuiltin("idref", -31);
  }
  
  public Namespace[] functionNamespacePath = XQuery.defaultFunctionNamespacePath;
  private Declaration moduleDecl;
  
  protected void push(ScopeExp exp)
  {
    for (Declaration decl = exp.firstDecl(); 
        decl != null; decl = decl.nextDecl())
    {
      push(decl);
    }
  }
  
  void push(Declaration decl)
  {
    Compilation comp = getCompilation();
    Object name = decl.getSymbol();
    boolean function = decl.isProcedureDecl();
    if ((name instanceof String))
    {
      int line = decl.getLineNumber();
      if ((line > 0) && (comp != null))
      {
        String saveFilename = comp.getFileName();
        int saveLine = comp.getLineNumber();
        int saveColumn = comp.getColumnNumber();
        comp.setLocation(decl);
        name = parser.namespaceResolve((String)name, function);
        comp.setLine(saveFilename, saveLine, saveColumn);
      }
      else {
        name = parser.namespaceResolve((String)name, function); }
      if (name == null)
        return;
      decl.setName(name);
    }
    
    Declaration old = lookup.lookup(name, XQuery.instance.getNamespaceOf(decl));
    if (old != null)
    {
      if (context == context) {
        ScopeExp.duplicateDeclarationError(old, decl, comp);
      } else if ((XQParser.warnHidePreviousDeclaration) && ((!(name instanceof Symbol)) || (((Symbol)name).getNamespace() != null)))
      {

        comp.error('w', decl, "declaration ", " hides previous declaration");
      }
    }
    lookup.push(decl);
  }
  
  Declaration flookup(Symbol sym)
  {
    Environment env = XQuery.xqEnvironment;
    Location loc = env.lookup(sym, EnvironmentKey.FUNCTION);
    if (loc == null)
      return null;
    loc = loc.getBase();
    if ((loc instanceof StaticFieldLocation))
    {
      Declaration decl = ((StaticFieldLocation)loc).getDeclaration();
      if (decl != null)
        return decl;
    }
    Object val = loc.get(null);
    if (val != null)
      return procToDecl(sym, val);
    return null;
  }
  
  protected Expression visitReferenceExp(ReferenceExp exp, Void ignored)
  {
    return visitReferenceExp(exp, (ApplyExp)null);
  }
  
  protected Expression visitReferenceExp(ReferenceExp exp, ApplyExp call)
  {
    if (exp.getBinding() == null)
    {
      Object symbol = exp.getSymbol();
      boolean needFunction = exp.isProcedureName();
      boolean needType = exp.getFlag(16);
      int namespace = call == null ? 1 : XQuery.namespaceForFunctions(call.getArgCount());
      
      Declaration decl = lookup.lookup(symbol, namespace);
      
      if (decl == null) {
        Symbol sym;
        if (((symbol instanceof Symbol)) && ("".equals((sym = (Symbol)symbol).getNamespaceURI())))
        {


          String name = sym.getLocalName();
          String mname;
          String mname; if ("request".equals(name)) {
            mname = "getCurrentRequest"; } else { String mname;
            if ("response".equals(name)) {
              mname = "getCurrentResponse";
            } else
              mname = null; }
          if (mname != null)
          {
            Method meth = ClassType.make("gnu.kawa.servlet.KawaServlet").getDeclaredMethod(mname, 0);
            

            return new ApplyExp(meth, Expression.noExpressions);
          }
        }
        else if ((symbol instanceof Symbol))
        {

          decl = flookup((Symbol)symbol);
        }
        else
        {
          String name = (String)symbol;
          if (name.indexOf(':') < 0)
          {
            name = name.intern();
            if (needFunction)
            {
              for (int i = 0; i < functionNamespacePath.length; i++)
              {
                Symbol sym = functionNamespacePath[i].getSymbol(name);
                decl = lookup.lookup(sym, namespace);
                if (decl != null)
                  break;
                decl = flookup(sym);
                if (decl != null)
                  break;
              }
            }
          }
          if (decl == null)
          {
            Symbol sym = parser.namespaceResolve(name, needFunction);
            if (sym != null)
            {
              decl = lookup.lookup(sym, namespace);
              if ((decl == null) && ((needFunction) || (needType)))
              {

                String uri = sym.getNamespaceURI();
                Type type = null;
                if ("http://www.w3.org/2001/XMLSchema".equals(uri))
                {
                  type = parser.interpreter.getStandardType(sym.getName());
                }
                else if ((needType) && (uri == "") && (!getCompilation().isPedantic()))
                {

                  type = parser.interpreter.getTypeFor(name);
                }
                if (type != null)
                  return new QuoteExp(type).setLine(exp);
                if ((uri != null) && (uri.length() > 6) && (uri.startsWith("class:")))
                {

                  ClassType ctype = ClassType.make(uri.substring(6));
                  return CompileNamedPart.makeExp(ctype, sym.getName());
                }
                decl = flookup(sym);
              }
            }
          }
        } }
      if (decl != null) {
        exp.setBinding(decl);
      } else if (needFunction) {
        error('e', "unknown function " + symbol);
      } else if (needType) {
        messages.error('e', exp, "unknown type " + symbol, "XPST0051");
      } else
        messages.error('e', exp, "unknown variable $" + symbol, "XPST0008");
    }
    return exp;
  }
  
  protected Expression visitSetExp(SetExp exp, Void ignored)
  {
    Expression result = super.visitSetExp(exp, ignored);
    Declaration decl = exp.getBinding();
    Object name;
    Expression new_value;
    if ((decl != null) && (!getCompilationimmediate) && (((name = decl.getSymbol()) instanceof Symbol)) && ("http://www.w3.org/2005/xquery-local-functions".equals(((Symbol)name).getNamespaceURI())) && ((!((new_value = exp.getNewValue()) instanceof ApplyExp)) || (((ApplyExp)new_value).getFunction() != XQParser.getExternalFunction)))
    {




      decl.setFlag(16777216L);
      decl.setPrivate(true);
    }
    return result;
  }
  




  private Expression visitStatements(Expression exp)
  {
    if ((exp instanceof BeginExp))
    {
      BeginExp bbody = (BeginExp)exp;
      Expression[] exps = bbody.getExpressions();
      int nexps = bbody.getExpressionCount();
      for (int i = 0; i < nexps; i++)
      {
        exps[i] = visitStatements(exps[i]);
      }
    }
    else if ((exp instanceof SetExp))
    {
      Declaration decl = moduleDecl;
      SetExp sexp = (SetExp)exp;
      exp = visitSetExp(sexp, null);
      if ((sexp.isDefining()) && (sexp.getBinding() == decl))
      {
        if (!decl.isProcedureDecl())
          push(decl);
        decl = decl.nextDecl();
      }
      moduleDecl = decl;
    }
    else {
      exp = (Expression)visit(exp, null); }
    return exp;
  }
  
  static class CycleDetector extends ExpExpVisitor<Void> {
    Map<Declaration, Integer> depsScanState = new HashMap();
    static final Integer SCANNING = Integer.valueOf(0);
    static final Integer SCANNED_CYCLE = Integer.valueOf(1);
    static final Integer SCANNED_NO_CYCLE = Integer.valueOf(-1);
    Declaration target;
    boolean cycleSeen;
    
    CycleDetector() {}
    
    protected Expression visitReferenceExp(ReferenceExp exp, Void ignored) { Declaration decl = exp.getBinding();
      if ((decl != null) && ((context instanceof ModuleExp)))
        scanDependencies(decl);
      return exp;
    }
    
    public void scanDependencies(Declaration decl) {
      if (target == null) {
        target = decl;
      } else if (target == decl) {
        cycleSeen = true;
        return;
      }
      Integer state = (Integer)depsScanState.get(decl);
      if (state != null) {
        if (state == SCANNING)
          depsScanState.put(decl, SCANNED_CYCLE);
        return;
      }
      depsScanState.put(decl, SCANNING);
      Expression dval = decl.getValue();
      if (dval != null)
        visit(dval, null);
      state = (Integer)depsScanState.get(decl);
      if (state == SCANNING) {
        depsScanState.put(decl, SCANNED_NO_CYCLE);
      }
    }
    
    public static boolean scanVariable(Declaration decl) {
      CycleDetector cycleDetector = new CycleDetector();
      cycleDetector.scanDependencies(decl);
      return cycleSeen;
    }
  }
  
  public void resolveModule(ModuleExp exp)
  {
    currentLambda = exp;
    for (Declaration decl = exp.firstDecl(); 
        decl != null; decl = decl.nextDecl())
    {
      if (decl.isProcedureDecl())
        push(decl);
    }
    moduleDecl = exp.firstDecl();
    body = visitStatements(body);
    
    for (Declaration decl = exp.firstDecl(); 
        decl != null; decl = decl.nextDecl())
    {
      if ((!decl.isProcedureDecl()) && (CycleDetector.scanVariable(decl))) {
        getCompilation().error('e', "cycle detected initializing $" + decl.getName(), "XQST0054", decl);
      }
      


      if (decl.getSymbol() != null) {
        lookup.removeSubsumed(decl);
      }
    }
  }
  




  Expression getCollator(Expression[] args, int argno)
  {
    if ((args != null) && (args.length > argno)) {
      return new ApplyExp(ClassType.make("gnu.xquery.util.NamedCollator").getDeclaredMethod("find", 1), new Expression[] { args[argno] });
    }
    
    NamedCollator coll = parser.defaultCollator;
    return coll == null ? QuoteExp.nullExp : new QuoteExp(coll);
  }
  

  Expression withCollator(Method method, Expression[] args, String name, int minArgs)
  {
    return withCollator(new QuoteExp(new PrimProcedure(method)), args, name, minArgs);
  }
  



  Expression withCollator(Expression function, Expression[] args, String name, int minArgs)
  {
    String err = WrongArguments.checkArgCount(name, minArgs, minArgs + 1, args.length);
    if (err != null)
      return getCompilation().syntaxError(err);
    Expression[] xargs = new Expression[minArgs + 1];
    System.arraycopy(args, 0, xargs, 0, minArgs);
    xargs[minArgs] = getCollator(args, minArgs);
    return new ApplyExp(function, xargs);
  }
  


  Expression withContext(Method method, Expression[] args, String name, int minArgs)
  {
    String err = WrongArguments.checkArgCount(name, minArgs, minArgs + 1, args.length);
    
    if (err != null)
      return getCompilation().syntaxError(err);
    if (args.length == minArgs)
    {
      Expression[] xargs = new Expression[minArgs + 1];
      System.arraycopy(args, 0, xargs, 0, minArgs);
      Declaration dot = lookup.lookup(XQParser.DOT_VARNAME, false);
      if (dot == null)
      {
        String message = "undefined context for " + name;
        messages.error('e', message, "XPDY0002");
        return new ErrorExp(message);
      }
      xargs[minArgs] = new ReferenceExp(dot);
      args = xargs;
    }
    return new ApplyExp(method, args);
  }
  

  private Expression checkArgCount(Expression[] args, Declaration decl, int min, int max)
  {
    String err = WrongArguments.checkArgCount("fn:" + decl.getName(), min, max, args.length);
    
    if (err == null) {
      return null;
    }
    return getCompilation().syntaxError(err);
  }
  
  protected Expression visitApplyExp(ApplyExp exp, Void ignored)
  {
    Expression func = exp.getFunction();
    NamespaceBinding namespaceSave = parser.constructorNamespaces;
    Object proc = exp.getFunctionValue();
    if ((proc instanceof MakeElement))
    {
      MakeElement mk = (MakeElement)proc;
      NamespaceBinding nschain = NamespaceBinding.nconc(mk.getNamespaceNodes(), namespaceSave);
      
      mk.setNamespaceNodes(nschain);
      parser.constructorNamespaces = nschain;
    }
    if ((func instanceof ReferenceExp)) {
      func = visitReferenceExp((ReferenceExp)func, exp);
    } else
      func = (Expression)visit(func, ignored);
    exp.setFunction(func);
    visitExps(exp.getArgs(), ignored);
    parser.constructorNamespaces = namespaceSave;
    func = exp.getFunction();
    if ((func instanceof ReferenceExp))
    {
      Declaration decl = ((ReferenceExp)func).getBinding();
      
      int code;
      if ((decl != null) && ((code = decl.getCode()) < 0)) {
        Expression err;
        switch (code)
        {
        case -2: 
        case -1: 
          Symbol sym = code == -1 ? XQParser.LAST_VARNAME : XQParser.POSITION_VARNAME;
          
          decl = lookup.lookup(sym, false);
          if (decl == null) {
            error('e', "undefined context for " + sym.getName());
          }
          else
          {
            decl.setCanRead(true); }
          return new ReferenceExp(sym, decl);
        
        case -34: 
        case -33: 
          Expression[] args = exp.getArgs();
          Expression texp = args[1];
          Expression qexp = texp;
          if ((texp instanceof ApplyExp))
          {
            ApplyExp taexp = (ApplyExp)texp;
            if (taexp.getFunction().valueIfConstant() == XQParser.proc_OccurrenceType_getInstance)
            {
              qexp = taexp.getArg(0); }
          }
          Object value = qexp.valueIfConstant();
          String msg = null;
          if (value == SingletonType.getInstance()) {
            msg = "type to 'cast as' or 'castable as' must be atomic";
          } else if (value == XDataType.anyAtomicType) {
            msg = "type to 'cast as' or 'castable as' cannot be anyAtomicType";
          } else if (value == XDataType.anySimpleType) {
            msg = "type to 'cast as' or 'castable as' cannot be anySimpleType";
          } else if (value == XDataType.untypedType) {
            msg = "type to 'cast as' or 'castable as' cannot be untyped";
          } else if (value == XDataType.NotationType)
            msg = "type to 'cast as' or 'castable as' cannot be NOTATION";
          if (msg != null)
            messages.error('e', texp, msg, "XPST0080");
          boolean toQName = (value == Compilation.typeSymbol) && (!(texp instanceof ApplyExp));
          
          if (code == -33)
          {
            if (toQName)
              return visitApplyExp(XQParser.castQName(args[1], true), ignored);
            func = XQParser.makeFunctionExp("gnu.xquery.util.CastAs", "castAs");

          }
          else
          {
            if ((toQName) && ((args[0] instanceof QuoteExp)))
            {
              value = ((QuoteExp)args[0]).getValue();
              try
              {
                QNameUtils.resolveQName(value, parser.constructorNamespaces, parser.prologNamespaces);
                

                return XQuery.trueExp;
              }
              catch (RuntimeException ex)
              {
                return XQuery.falseExp;
              }
            }
            func = XQParser.makeFunctionExp("gnu.xquery.lang.XQParser", "castableAs");
          }
          return new ApplyExp(func, args).setLine(exp);
        

        case -36: 
        case -35: 
          Expression[] args = exp.getArgs();
          if ((err = checkArgCount(args, decl, 1, 1)) != null)
            return err;
          NamespaceBinding constructorNamespaces = parser.constructorNamespaces;
          
          if (code == -36) {
            constructorNamespaces = new NamespaceBinding(null, "", constructorNamespaces);
          }
          if ((args[0] instanceof QuoteExp))
          {
            try
            {
              Object val = ((QuoteExp)args[0]).getValue();
              val = QNameUtils.resolveQName(val, constructorNamespaces, parser.prologNamespaces);
              

              return new QuoteExp(val);
            }
            catch (RuntimeException ex)
            {
              return getCompilation().syntaxError(ex.getMessage());
            }
          }
          Expression[] xargs = { args[0], new QuoteExp(constructorNamespaces), new QuoteExp(parser.prologNamespaces) };
          


          Method meth = ClassType.make("gnu.xquery.util.QNameUtils").getDeclaredMethod("resolveQName", 3);
          

          ApplyExp app = new ApplyExp(meth, xargs);
          app.setFlag(4);
          return app;
        

        case -13: 
          Expression[] args = exp.getArgs();
          if ((err = checkArgCount(args, decl, 1, 1)) != null)
            return err;
          if ((args[0] instanceof QuoteExp))
          {
            Object val = ((QuoteExp)args[0]).getValue();
            String prefix = val == null ? null : val.toString();
            val = QNameUtils.lookupPrefix(prefix, parser.constructorNamespaces, parser.prologNamespaces);
            

            if (val == null) {
              return getCompilation().syntaxError("unknown namespace prefix '" + prefix + "'");
            }
            
            return new QuoteExp(val);
          }
          Expression[] xargs = { args[0], new QuoteExp(parser.constructorNamespaces), new QuoteExp(parser.prologNamespaces) };
          


          PrimProcedure pproc = new PrimProcedure(ClassType.make("gnu.xquery.util.QNameUtils").getDeclaredMethod("resolvePrefix", 3));
          

          ApplyExp app = new ApplyExp(pproc, xargs);
          app.setFlag(4);
          return app;
        

        case -6: 
          Method meth = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("localName", 1);
          
          return withContext(meth, exp.getArgs(), "fn:local-name", 0);
        

        case -24: 
          Method meth = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("name", 1);
          
          return withContext(meth, exp.getArgs(), "fn:name", 0);
        

        case -28: 
          Method meth = ClassType.make("gnu.xquery.util.NumberValue").getDeclaredMethod("numberValue", 1);
          
          return withContext(meth, exp.getArgs(), "fn:number", 0);
        

        case -32: 
          Method meth = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("root", 1);
          
          return withContext(meth, exp.getArgs(), "fn:root", 0);
        

        case -11: 
          Method meth = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("baseUri", 1);
          
          return withContext(meth, exp.getArgs(), "fn:base-uri", 0);
        

        case -23: 
          Method meth = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("lang", 2);
          
          return withContext(meth, exp.getArgs(), "fn:lang", 1);
        

        case -30: 
          Method meth = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("id$X", 3);
          
          return withContext(meth, exp.getArgs(), "fn:id", 1);
        

        case -31: 
          Method meth = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("idref", 2);
          
          return withContext(meth, exp.getArgs(), "fn:idref", 1);
        


        case -14: 
          Expression[] args = exp.getArgs();
          if ((err = checkArgCount(args, decl, 0, 0)) != null)
            return err;
          return getBaseUriExpr();
        

        case -7: 
          Method meth = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("namespaceURI", 1);
          
          return withContext(meth, exp.getArgs(), "fn:namespace-uri", 0);
        



        case -17: 
          Method meth = ClassType.make("gnu.xquery.util.StringUtils").getDeclaredMethod("normalizeSpace", 1);
          
          return withContext(meth, exp.getArgs(), "fn:normalize-space", 0);
        



        case -18: 
          Expression[] args = exp.getArgs();
          if ((err = checkArgCount(args, decl, 1, 1)) != null)
            return err;
          return args[0];
        


        case -4: 
          Method meth = ClassType.make("gnu.xquery.util.StringUtils").getDeclaredMethod("compare", 3);
          
          return withCollator(meth, exp.getArgs(), "fn:compare", 2);
        

        case -16: 
          return withContext(ClassType.make("gnu.xml.TextUtils").getDeclaredMethod("asString", 1), exp.getArgs(), "fn:string", 0);
        



        case -15: 
          Method meth = ClassType.make("gnu.xquery.util.SequenceUtils").getDeclaredMethod("indexOf$X", 4);
          
          return withCollator(meth, exp.getArgs(), "fn:index-of", 2);
        

        case -8: 
          Expression[] args = exp.getArgs();
          ClassType cl = ClassType.make("gnu.xquery.util.NodeUtils");
          Method meth = cl.getDeclaredMethod("collection", 2);
          if ((err = checkArgCount(args, decl, 0, 1)) != null)
            return err;
          Expression base = getBaseUriExpr();
          Expression uri = args.length > 0 ? args[0] : QuoteExp.voidExp;
          
          return new ApplyExp(meth, new Expression[] { uri, base });
        

        case -10: 
        case -9: 
          Expression[] args = exp.getArgs();
          ClassType cl = ClassType.make("gnu.xquery.util.NodeUtils");
          String mname;
          if (code == -9)
          {
            String mname = "docCached";
            if ((XQParser.warnOldVersion) && ("document".equals(decl.getName())))
            {
              getCompilation().error('w', "replace 'document' by 'doc'");
            }
          }
          else {
            mname = "availableCached"; }
          Method meth = cl.getDeclaredMethod(mname, 2);
          if ((err = checkArgCount(args, decl, 1, 1)) != null)
            return err;
          PrimProcedure pproc = new PrimProcedure(meth);
          if (code == -9)
            pproc.setSideEffectFree();
          Expression base = getBaseUriExpr();
          ApplyExp aexp = new ApplyExp(pproc, new Expression[] { args[0], base });
          
          if (code == -9) {
            aexp.setType(NodeType.documentNodeTest);
          } else
            aexp.setType(XDataType.booleanType);
          return aexp;
        

        case -12: 
          Expression[] args = exp.getArgs();
          if ((err = checkArgCount(args, decl, 1, 2)) != null)
            return err;
          Expression[] margs = new Expression[2];
          margs[0] = args[0];
          if (args.length == 1) {
            margs[1] = getBaseUriExpr();
          } else
            margs[1] = args[1];
          Method meth = ClassType.make("gnu.xquery.util.QNameUtils").getDeclaredMethod("resolveURI", 2);
          
          return new ApplyExp(meth, margs);
        

        case -5: 
          Method meth = ClassType.make("gnu.xquery.util.DistinctValues").getDeclaredMethod("distinctValues$X", 3);
          
          return withCollator(meth, exp.getArgs(), "fn:distinct-values", 1);
        



        case -25: 
          Method meth = ClassType.make("gnu.xquery.util.SequenceUtils").getDeclaredMethod("deepEqual", 3);
          
          return withCollator(meth, exp.getArgs(), "fn:deep-equal", 2);
        


        case -26: 
          Method meth = ClassType.make("gnu.xquery.util.MinMax").getDeclaredMethod("min", 2);
          
          return withCollator(meth, exp.getArgs(), "fn:min", 1);
        


        case -27: 
          Method meth = ClassType.make("gnu.xquery.util.MinMax").getDeclaredMethod("max", 2);
          
          return withCollator(meth, exp.getArgs(), "fn:max", 1);
        

        case -29: 
          if ((err = checkArgCount(exp.getArgs(), decl, 0, 0)) != null)
            return err;
          NamedCollator coll = parser.defaultCollator;
          return QuoteExp.getInstance(coll != null ? coll.getName() : "http://www.w3.org/2005/xpath-functions/collation/codepoint");
        

        case -3: 
          Compilation comp = getCompilation();
          Expression[] args = exp.getArgs();
          for (int i = 0; 
              i < args.length - 1; i += 2)
          {
            Expression pname = args[i];
            String qname = (String)((QuoteExp)pname).getValue();
            Symbol psymbol = parser.namespaceResolve(qname, false);
            if (psymbol != null)
            {
              if (psymbol.getNamespaceURI().length() == 0) {
                comp.error('e', "pragma name cannot be in the empty namespace");
              }
              else {
                Expression replacement = checkPragma(psymbol, args[(i + 1)]);
                
                if (replacement != null)
                  return replacement;
              } }
          }
          if (i < args.length)
            return args[(args.length - 1)];
          String msg = "no recognized pragma or default in extension expression";
          getMessages().error('e', msg, "XQST0079");
          return new ErrorExp(msg);
        }
        
      }
    }
    proc = exp.getFunctionValue();
    if ((proc instanceof Type))
    {
      Expression[] args = exp.getArgs();
      if (args.length != 1)
      {
        messages.error('e', "type constructor requires a single argument");
        return exp;
      }
      return new ApplyExp(XQParser.makeFunctionExp("gnu.xquery.util.CastAs", "castAs"), new Expression[] { exp.getFunction(), args[0] });
    }
    
    if ((proc instanceof MakeElement))
    {
      MakeElement make = (MakeElement)proc;
      

      NamespaceBinding nsBindings = make.getNamespaceNodes();
      Symbol tag = tag;
      if (tag == null)
        tag = MakeElement.getTagName(exp);
      nsBindings = maybeAddNamespace(tag, false, nsBindings);
      Expression[] args = exp.getArgs();
      Symbol[] attrSyms = new Symbol[args.length];
      int nattrSyms = 0;
      for (int i = 0; i < args.length; i++)
      {
        Expression arg = args[i];
        if ((arg instanceof ApplyExp))
        {
          ApplyExp app = (ApplyExp)arg;
          if (app.getFunction() == MakeAttribute.makeAttributeExp)
          {
            Symbol sym = MakeElement.getTagName(app);
            if (sym != null)
            {
              for (int j = 0;; j++)
              {
                if (j == nattrSyms)
                {
                  attrSyms[(nattrSyms++)] = sym;
                  break;
                }
                if (sym.equals(attrSyms[j]))
                {
                  getCompilation().setLine(app);
                  Symbol elementSym = MakeElement.getTagName(exp);
                  String elementName = elementSym == null ? null : elementSym.toString();
                  
                  messages.error('e', XMLFilter.duplicateAttributeMessage(sym, elementName), "XQST0040");
                }
              }
              nsBindings = maybeAddNamespace(sym, true, nsBindings);
            }
          }
        }
      }
      if (nsBindings != null)
        make.setNamespaceNodes(nsBindings);
    }
    return exp;
  }
  

  public Expression checkPragma(Symbol name, Expression contents)
  {
    return null;
  }
  
  Expression getBaseUriExpr()
  {
    Compilation comp = getCompilation();
    String staticBaseUri = parser.getStaticBaseUri();
    if (staticBaseUri != null) {
      return QuoteExp.getInstance(staticBaseUri);
    }
    return GetModuleClass.getModuleClassURI(comp);
  }
  

  static NamespaceBinding maybeAddNamespace(Symbol qname, boolean isAttribute, NamespaceBinding bindings)
  {
    if (qname == null)
      return bindings;
    String prefix = qname.getPrefix();
    String uri = qname.getNamespaceURI();
    if (prefix == "")
      prefix = null;
    if (uri == "")
      uri = null;
    if ((isAttribute) && (prefix == null) && (uri == null))
      return bindings;
    return NamespaceBinding.maybeAdd(prefix, uri, bindings);
  }
  

  static Declaration procToDecl(Object symbol, Object val)
  {
    Declaration decl = new Declaration(symbol);
    decl.setProcedureDecl(true);
    decl.noteValue(new QuoteExp(val));
    decl.setFlag(16384L);
    return decl;
  }
}
