package kawa.lang;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Member;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.kawa.functions.CompileNamedPart;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.lispexpr.GenArrayType;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.reflect.FieldLocation;
import gnu.kawa.reflect.MakeAnnotation;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.LocationEnumeration;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kawa.standard.begin;
import kawa.standard.require.DeclSetMapper;

public class Translator extends Compilation
{
  private Environment env;
  public Macro currentMacroDefinition;
  public PatternScope patternScope;
  public Declaration templateScopeDecl;
  Object currentMacroMark = null;
  

  public Declaration matchArray;
  

  private Stack<Declaration> renamedAliasStack;
  

  public Object pendingForm;
  

  public LambdaExp curMethodLambda;
  
  public gnu.xml.NamespaceBinding xmlElementNamespaces = gnu.xml.NamespaceBinding.predefinedXML;
  
  public static final Declaration getNamedPartDecl;
  

  static
  {
    String cname = "gnu.kawa.functions.GetNamedPart";
    String fname = "getNamedPart";
    getNamedPartDecl = Declaration.getDeclarationFromStatic(cname, fname);
    LispLanguage.getNamedPartLocation.setDeclaration(getNamedPartDecl);
  }
  
  private static Expression errorExp = new ErrorExp("unknown syntax error");
  Syntax currentSyntax;
  Declaration macroContext;
  
  public Translator(Language language, SourceMessages messages, NameLookup lexical, Environment env) { super(language, messages, lexical);
    this.env = env;
  }
  
  public Translator(Language language, SourceMessages messages, NameLookup lexical)
  {
    super(language, messages, lexical);
    env = Environment.getCurrent();
  }
  
  public final Environment getGlobalEnvironment() {
    return env;
  }
  
  public Expression parse(Object input) {
    return rewrite(input);
  }
  
  public final Expression rewrite_car(Pair pair, SyntaxForm syntax)
  {
    if ((syntax == null) || (syntax.getScope() == current_scope) || ((pair.getCar() instanceof SyntaxForm)))
    {
      return rewrite_car(pair, false); }
    ScopeExp save_scope = setPushCurrentScope(syntax.getScope());
    try
    {
      return rewrite_car(pair, false);
    }
    finally
    {
      setPopCurrentScope(save_scope);
    }
  }
  
  public final Expression rewrite_car(Pair pair, boolean function)
  {
    Object car = pair.getCar();
    if ((pair instanceof PairWithPosition)) {
      return rewrite_with_position(car, function, (PairWithPosition)pair);
    }
    return rewrite(car, function);
  }
  



  public final Expression rewrite_car_for_lookup(Pair pair)
  {
    Object car = pair.getCar();
    if ((car instanceof Pair)) {
      Pair pcar = (Pair)car;
      if (pcar.getCar() == LispLanguage.quasiquote_sym) {
        Object pos = pushPositionOf(pair);
        Expression ret = Quote.quasiQuote.rewrite(pcar.getCdr(), this);
        popPositionOf(pos);
        return ret;
      }
    }
    return rewrite_car(pair, false);
  }
  
  public Syntax getCurrentSyntax() {
    return currentSyntax;
  }
  











  Expression apply_rewrite(Syntax syntax, Pair form)
  {
    Expression exp = errorExp;
    Syntax saveSyntax = currentSyntax;
    currentSyntax = syntax;
    try
    {
      exp = syntax.rewriteForm(form, this);
    }
    finally
    {
      currentSyntax = saveSyntax;
    }
    return exp;
  }
  



  static ReferenceExp getOriginalRef(Declaration decl)
  {
    if ((decl != null) && (decl.isAlias()) && (!decl.isIndirectBinding()))
    {
      Expression value = decl.getValue();
      if ((value instanceof ReferenceExp))
        return (ReferenceExp)value;
    }
    return null;
  }
  
  public final boolean keywordsAreSelfEvaluating() {
    return ((LispLanguage)getLanguage()).keywordsAreSelfEvaluating();
  }
  
  public final boolean selfEvaluatingSymbol(Object obj)
  {
    return ((LispLanguage)getLanguage()).selfEvaluatingSymbol(obj);
  }
  

  public final boolean matches(Object form, String literal)
  {
    return matches(form, null, literal);
  }
  
  public boolean matches(Object form, SyntaxForm syntax, String literal)
  {
    if ((syntax == null) || 
    


      ((form instanceof SyntaxForm)))
    {

      form = ((SyntaxForm)form).getDatum();
    }
    if (((form instanceof SimpleSymbol)) && (!selfEvaluatingSymbol(form)))
    {
      ReferenceExp rexp = getOriginalRef(lexical.lookup(form, -1));
      if (rexp != null)
        form = rexp.getSymbol();
    }
    return ((form instanceof SimpleSymbol)) && (((Symbol)form).getLocalPart() == literal);
  }
  

  public boolean matches(Object form, SyntaxForm syntax, Symbol literal)
  {
    if ((syntax == null) || 
    


      ((form instanceof SyntaxForm)))
    {

      form = ((SyntaxForm)form).getDatum();
    }
    if (((form instanceof SimpleSymbol)) && (!selfEvaluatingSymbol(form)))
    {
      ReferenceExp rexp = getOriginalRef(lexical.lookup(form, -1));
      if (rexp != null)
        form = rexp.getSymbol();
    }
    return form == literal;
  }
  
  public Object matchQuoted(Pair pair)
  {
    if ((matches(pair.getCar(), "quote")) && ((pair.getCdr() instanceof Pair)) && ((pair = (Pair)pair.getCdr()).getCdr() == LList.Empty))
    {

      return pair.getCar(); }
    return null;
  }
  
  public Declaration lookup(Object name, int namespace)
  {
    Declaration decl = lexical.lookup(name, namespace);
    if ((decl != null) && (getLanguage().hasNamespace(decl, namespace)))
      return decl;
    return currentModule().lookup(name, getLanguage(), namespace);
  }
  

  public Declaration lookupGlobal(Object name)
  {
    return lookupGlobal(name, -1);
  }
  

  public Declaration lookupGlobal(Object name, int namespace)
  {
    ModuleExp module = currentModule();
    Declaration decl = module.lookup(name, getLanguage(), namespace);
    if (decl == null)
    {
      decl = module.getNoDefine(name);
      decl.setIndirectBinding(true);
    }
    return decl;
  }
  





  Syntax check_if_Syntax(Declaration decl)
  {
    Declaration d = Declaration.followAliases(decl);
    Object obj = null;
    Expression dval = d.getValue();
    if ((dval != null) && (d.getFlag(32768L)))
    {
      try
      {
        if ((decl.getValue() instanceof ReferenceExp))
        {
          Declaration context = ((ReferenceExp)decl.getValue()).contextDecl();
          
          if (context != null) {
            macroContext = context;
          } else if ((current_scope instanceof TemplateScope)) {
            macroContext = current_scope).macroContext;
          }
        } else if ((current_scope instanceof TemplateScope)) {
          macroContext = current_scope).macroContext; }
        obj = dval.eval(env);
      }
      catch (Error ex)
      {
        throw ex;
      }
      catch (Throwable ex)
      {
        ex.printStackTrace();
        error('e', "unable to evaluate macro for " + decl.getSymbol());
      }
    }
    else if ((decl.getFlag(32768L)) && (!decl.needsContext()))
    {
      StaticFieldLocation loc = StaticFieldLocation.make(decl);
      obj = loc.get(null);
    }
    return (obj instanceof Syntax) ? (Syntax)obj : null;
  }
  
  public Expression rewrite_pair(Pair p, boolean function)
  {
    Object p_car = p.getCar();
    
    boolean useHelper = true;
    Expression func; if (((p_car instanceof Pair)) && (((Pair)p_car).getCar() == LispLanguage.splice_sym))
    {
      Expression func = MakeAnnotation.makeAnnotationMaker(rewrite_car((Pair)((Pair)p_car).getCdr(), false));
      
      useHelper = false;
    }
    else {
      func = rewrite_car(p, true); }
    Object proc = null;
    if ((func instanceof QuoteExp))
    {
      proc = func.valueIfConstant();
      if ((proc instanceof Syntax))
        return apply_rewrite((Syntax)proc, p);
    }
    ReferenceExp ref = null;
    if ((func instanceof ReferenceExp))
    {
      ref = (ReferenceExp)func;
      Declaration decl = ref.getBinding();
      if (decl == null)
      {
        Object sym = ref.getSymbol();
        String name;
        Symbol symbol;
        if (((sym instanceof Symbol)) && (!selfEvaluatingSymbol(sym)))
        {
          Symbol symbol = (Symbol)sym;
          name = symbol.getName();
        }
        else
        {
          String name = sym.toString();
          symbol = env.getSymbol(name);
        }
        proc = env.get(symbol, getLanguage().hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null, null);
        



        if ((proc instanceof Syntax))
          return apply_rewrite((Syntax)proc, p);
        if ((proc instanceof AutoloadProcedure))
        {
          try
          {
            proc = ((AutoloadProcedure)proc).getLoaded();
          }
          catch (RuntimeException ex)
          {
            proc = null;
          }
        }
      }
      else
      {
        Declaration saveContext = macroContext;
        Syntax syntax = check_if_Syntax(decl);
        if (syntax != null)
        {
          Expression e = apply_rewrite(syntax, p);
          macroContext = saveContext;
          return e;
        }
      }
      
      ref.setProcedureName(true);
      if (getLanguage().hasSeparateFunctionNamespace()) {
        func.setFlag(2);
      }
    }
    boolean isNamedPartDecl = ((func instanceof ReferenceExp)) && (((ReferenceExp)func).getBinding() == getNamedPartDecl);
    
    if (isNamedPartDecl) {
      useHelper = false;
    }
    Object cdr = p.getCdr();
    int cdr_length = listLength(cdr);
    
    if (cdr_length < 0) {
      return syntaxError("improper list (circular or dotted) is not allowed here");
    }
    Expression applyFunction = useHelper ? applyFunction(func) : null;
    
    Stack vec = new Stack();
    if (applyFunction != null) {
      vec.add(func);
      func = applyFunction;
    }
    
    ScopeExp save_scope = current_scope;
    int first_keyword = -1;
    int last_keyword = -1;
    int firstSpliceArg = -1;
    int i = 0;
    while (cdr != LList.Empty)
    {
      if ((cdr instanceof SyntaxForm))
      {
        SyntaxForm sf = (SyntaxForm)cdr;
        cdr = sf.getDatum();
        
        if (current_scope == save_scope)
          lexical.pushSaveTopLevelRedefs();
        setCurrentScope(sf.getScope());
      }
      Object save_pos = pushPositionOf(cdr);
      Pair cdr_pair = (Pair)cdr;
      Object cdr_car = cdr_pair.getCar();
      Object cdr_cdr = cdr_pair.getCdr();
      Expression arg;
      if ((cdr_car instanceof gnu.expr.Keyword)) {
        if (first_keyword < 0) {
          first_keyword = i;
          last_keyword = i - 2;
        }
        if (!keywordsAreSelfEvaluating())
        {
          if ((i == last_keyword + 1) || (i + 1 == cdr_length)) {
            error('w', "missing value after unquoted keyword");
          } else if (i != last_keyword + 2)
            error('w', "keyword separated from other keyword arguments"); }
        last_keyword = i;
        Expression arg = QuoteExp.getInstance(cdr_car, this);
        arg.setFlag(8);
      } else if (((cdr_cdr instanceof Pair)) && (((Pair)cdr_cdr).getCar() == LispLanguage.dots3_sym))
      {

        LambdaExp dotsLambda = new LambdaExp();
        pushScanContext(dotsLambda);
        body = rewrite_car(cdr_pair, false);
        List<Expression> seqs = currentScanContext.sequences;
        int nseqs = seqs.size();
        Expression[] subargs = new Expression[nseqs + 1];
        subargs[0] = dotsLambda;
        for (int j = 0; j < nseqs; j++)
          subargs[(j + 1)] = ((Expression)seqs.get(j));
        Expression arg = new ApplyExp(kawa.standard.Scheme.map, subargs);
        arg = new ApplyExp(MakeSplice.quoteInstance, new Expression[] { arg });
        popScanContext();
        cdr_cdr = ((Pair)cdr_cdr).getCdr();
        if (firstSpliceArg < 0) {
          firstSpliceArg = i + (applyFunction != null ? 1 : 0);
        }
      } else if (((cdr_car instanceof Pair)) && (((Pair)cdr_car).getCar() == LispLanguage.splice_sym))
      {
        Expression arg = rewrite_car((Pair)((Pair)cdr_car).getCdr(), false);
        arg = new ApplyExp(MakeSplice.quoteInstance, new Expression[] { arg });
        if (firstSpliceArg < 0) {
          firstSpliceArg = i + (applyFunction != null ? 1 : 0);
        }
      } else {
        arg = rewrite_car(cdr_pair, false);
      }
      i++;
      
      vec.addElement(arg);
      cdr = cdr_cdr;
      popPositionOf(save_pos);
    }
    

    Expression[] args = new Expression[vec.size()];
    vec.copyInto(args);
    
    if (save_scope != current_scope) {
      setPopCurrentScope(save_scope);
    }
    if (isNamedPartDecl) {
      return rewrite_lookup(args[0], args[1], function);
    }
    ApplyExp app = new ApplyExp(func, args);
    firstSpliceArg = firstSpliceArg;
    if (first_keyword >= 0)
    {
      numKeywordArgs = ((last_keyword - first_keyword) / 2 + 1);
      firstKeywordArgIndex = (first_keyword + (applyFunction != null ? 2 : 1));
    }
    return app;
  }
  
  public Expression rewrite_lookup(Expression part1, Expression part2, boolean function) {
    Symbol sym = namespaceResolve(part1, part2);
    if (sym != null) {
      return rewrite(sym, function);
    }
    return CompileNamedPart.makeExp(part1, part2);
  }
  
  public Namespace namespaceResolvePrefix(Expression context)
  {
    if ((context instanceof ReferenceExp))
    {
      ReferenceExp rexp = (ReferenceExp)context;
      Declaration decl = rexp.getBinding();
      Object val;
      Object val; if ((decl == null) || (decl.getFlag(65536L)))
      {
        Object rsym = rexp.getSymbol();
        Symbol sym = (rsym instanceof Symbol) ? (Symbol)rsym : env.getSymbol(rsym.toString());
        
        val = env.get(sym, null);
      } else { Object val;
        if (decl.isNamespaceDecl())
        {
          val = decl.getConstantValue();
        }
        else
          val = null; }
      if ((val instanceof Namespace))
      {
        Namespace ns = (Namespace)val;
        String uri = ns.getName();
        if ((uri != null) && (uri.startsWith("class:")))
          return null;
        return ns;
      }
    }
    return null;
  }
  
  public Symbol namespaceResolve(Namespace ns, Expression member)
  {
    if ((ns != null) && ((member instanceof QuoteExp)))
    {
      String mem = ((QuoteExp)member).getValue().toString().intern();
      return ns.getSymbol(mem);
    }
    return null;
  }
  
  public Symbol namespaceResolve(Expression context, Expression member)
  {
    return namespaceResolve(namespaceResolvePrefix(context), member);
  }
  
  public static Object stripSyntax(Object obj)
  {
    while ((obj instanceof SyntaxForm))
      obj = ((SyntaxForm)obj).getDatum();
    return obj;
  }
  
  public static Object safeCar(Object obj)
  {
    while ((obj instanceof SyntaxForm))
      obj = ((SyntaxForm)obj).getDatum();
    if (!(obj instanceof Pair))
      return null;
    return stripSyntax(((Pair)obj).getCar());
  }
  
  public static Object safeCdr(Object obj)
  {
    while ((obj instanceof SyntaxForm))
      obj = ((SyntaxForm)obj).getDatum();
    if (!(obj instanceof Pair))
      return null;
    return stripSyntax(((Pair)obj).getCdr());
  }
  







  public static int listLength(Object obj)
  {
    int n = 0;
    Object slow = obj;
    Object fast = obj;
    
    for (;;)
    {
      if ((fast instanceof SyntaxForm)) {
        fast = ((SyntaxForm)fast).getDatum();
      } else { while ((slow instanceof SyntaxForm))
          slow = ((SyntaxForm)slow).getDatum();
        if (fast == LList.Empty)
          return n;
        if (!(fast instanceof Pair))
          return -1 - n;
        n++;
        Object next = ((Pair)fast).getCdr();
        while ((next instanceof SyntaxForm))
          next = ((SyntaxForm)next).getDatum();
        if (next == LList.Empty)
          return n;
        if (!(next instanceof Pair))
          return -1 - n;
        slow = ((Pair)slow).getCdr();
        fast = ((Pair)next).getCdr();
        n++;
        if (fast == slow)
          return Integer.MIN_VALUE;
      }
    }
  }
  
  public void rewriteInBody(Object exp) {
    if ((exp instanceof SyntaxForm))
    {
      SyntaxForm sf = (SyntaxForm)exp;
      ScopeExp save_scope = setPushCurrentScope(sf.getScope());
      try
      {
        rewriteInBody(sf.getDatum());
      }
      finally
      {
        setPopCurrentScope(save_scope);
      }
    }
    else if ((exp instanceof ValuesFromLList))
    {


      Object vs = values;
      while (vs != LList.Empty)
      {
        Pair p = (Pair)vs;
        pushForm(rewrite_car(p, false));
        vs = p.getCdr();
      }
    }
    else if ((exp instanceof Values))
    {
      Object[] vals = ((Values)exp).getValues();
      for (int i = 0; i < vals.length; i++) {
        rewriteInBody(vals[i]);
      }
    } else {
      pushForm(rewrite(exp, false));
    }
  }
  

  public int getCompletions(Environment env, String nameStart, Object property, String namespaceUri, List<? super String> matches)
  {
    LocationEnumeration e = env.enumerateAllLocations();
    int count = 0;
    while (e.hasMoreElements()) {
      Location loc = e.nextLocation();
      Symbol sym = loc.getKeySymbol();
      String local = sym == null ? null : sym.getLocalPart();
      if ((local != null) && (local.startsWith(nameStart)) && (property == loc.getKeyProperty()) && (namespaceUri == sym.getNamespaceURI()))
      {

        count++;
        matches.add(local);
      }
    }
    return count;
  }
  
  public Object namespaceResolve(Object name) {
    Object prefix = null;
    Expression part2 = null;
    Pair p;
    if (((name instanceof Pair)) && (safeCar(p = (Pair)name) == LispLanguage.lookup_sym) && ((p.getCdr() instanceof Pair)) && (((p = (Pair)p.getCdr()).getCdr() instanceof Pair)))
    {


      prefix = namespaceResolve(p.getCar());
      if (!(stripSyntax(prefix) instanceof Symbol))
        return name;
      part2 = rewrite_car_for_lookup((Pair)p.getCdr());
    }
    else if ((name instanceof Symbol)) {
      Symbol s = (Symbol)name;
      if (s.hasUnknownNamespace()) {
        String loc = s.getLocalPart();
        prefix = Symbol.valueOf(s.getPrefix());
        part2 = QuoteExp.getInstance(Symbol.valueOf(s.getLocalPart()));
      }
    }
    if (part2 != null) {
      Expression part1 = rewrite(prefix);
      Symbol sym = namespaceResolve(part1, part2);
      if (sym != null)
        return sym;
      String combinedName = CompileNamedPart.combineName(part1, part2);
      if (combinedName != null)
        return Namespace.EmptyNamespace.getSymbol(combinedName);
    }
    return name;
  }
  


  public Expression rewrite(Object exp)
  {
    return rewrite(exp, 'N');
  }
  


  public Expression rewrite(Object exp, boolean function)
  {
    return rewrite(exp, function ? 'F' : 'N');
  }
  



  public Expression rewrite(Object exp, char mode)
  {
    if ((exp instanceof SyntaxForm)) {
      SyntaxForm sf = (SyntaxForm)exp;
      ScopeExp save_scope = setPushCurrentScope(sf.getScope());
      try {
        Expression s = rewrite(sf.getDatum(), mode);
        return s;
      } finally {
        setPopCurrentScope(save_scope);
      }
    }
    boolean function = mode != 'N';
    if ((exp instanceof PairWithPosition))
      return rewrite_with_position(exp, function, (PairWithPosition)exp);
    if ((exp instanceof Pair))
      return rewrite_pair((Pair)exp, function);
    if (((exp instanceof Symbol)) && (!selfEvaluatingSymbol(exp))) {
      Symbol s = (Symbol)exp;
      

      int complete = s.getLocalName().indexOf(61698);
      
      boolean separate = getLanguage().hasSeparateFunctionNamespace();
      if (complete >= 0) {
        Object candidates = new ArrayList();
        String prefix = s.toString().substring(0, complete);
        Object property = (function) && (separate) ? EnvironmentKey.FUNCTION : null;
        
        int symspace = function ? 2 : 1;
        
        getCompletions(env, prefix, property, s.getNamespaceURI(), (List)candidates);
        
        lexical.getCompletingSymbols(prefix, symspace, (List)candidates);
        
        throw new gnu.expr.CommandCompleter(complete, (List)candidates, prefix, prefix.length(), this);
      }
      

      if (s.hasUnknownNamespace()) {
        String loc = s.getLocalPart();
        return rewrite_lookup(rewrite(Symbol.valueOf(s.getPrefix()), false), QuoteExp.getInstance(Symbol.valueOf(s.getLocalPart())), function);
      }
      

      Declaration decl = lexical.lookup(exp, function);
      Declaration cdecl = null;
      



      ScopeExp scope = current_scope;
      int decl_nesting = decl == null ? -1 : ScopeExp.nesting(context);
      String dname;
      String dname; if ((exp instanceof SimpleSymbol)) {
        dname = exp.toString();
      } else
        dname = null;
      for (scope = null; 
          
          scope != null; scope = scope.getOuter()) {
        if (((scope instanceof LambdaExp)) && ((scope.getOuter() instanceof ClassExp)) && (((LambdaExp)scope).isClassMethod()) && (mode != 'M'))
        {


          if (decl_nesting >= ScopeExp.nesting(scope.getOuter()))
            break;
          LambdaExp caller = (LambdaExp)scope;
          ClassExp cexp = (ClassExp)scope.getOuter();
          ClassType ctype = cexp.getClassType();
          




          Member part = gnu.kawa.reflect.SlotGet.lookupMember(ctype, dname, ctype);
          boolean contextStatic = (caller == clinitMethod) || ((caller != initMethod) && (nameDecl.isStatic()));
          


          if (part == null) {
            gnu.expr.PrimProcedure[] methods = gnu.kawa.reflect.ClassMethods.getMethods(ctype, dname, contextStatic ? 'S' : 'V', ctype, language);
            


            if (methods.length == 0)
              continue;
          } else { if ((decl != null) && (!dname.equals(part.getName())))
              continue;
          }
          Expression part1;
          Expression part1;
          if (contextStatic) {
            part1 = new ReferenceExp(getOuternameDecl);
          } else
            part1 = new gnu.expr.ThisExp(caller.firstDecl());
          return CompileNamedPart.makeExp(part1, QuoteExp.getInstance(dname));
        }
      }
      
      Object nameToLookup;
      
      if (decl != null) {
        Object nameToLookup = decl.getSymbol();
        exp = null;
        ReferenceExp rexp = getOriginalRef(decl);
        if (rexp != null) {
          decl = rexp.getBinding();
          if (decl == null) {
            exp = rexp.getSymbol();
            nameToLookup = exp;
          }
        }
      } else {
        nameToLookup = exp;
      }
      Symbol symbol = (Symbol)exp;
      if (decl != null) {
        if (((current_scope instanceof TemplateScope)) && (decl.needsContext())) {
          cdecl = current_scope).macroContext;
        } else if ((decl.getFlag(1048576L)) && (!decl.isStatic()))
        {
          scope = currentScope();
          for (;;) {
            if (scope == null)
              throw new Error("internal error: missing " + decl);
            if (scope.getOuter() == context)
              break;
            scope = scope.getOuter();
          }
          cdecl = scope.firstDecl();
        }
      } else {
        Location loc = env.lookup(symbol, (function) && (separate) ? EnvironmentKey.FUNCTION : null);
        


        if (loc != null)
          loc = loc.getBase();
        if ((loc instanceof FieldLocation)) {
          FieldLocation floc = (FieldLocation)loc;
          try {
            decl = floc.getDeclaration();
            if ((!inlineOk(null)) && (decl != getNamedPartDecl) && (!isObjectSyntax(floc.getDeclaringClass(), floc.getMemberName())))
            {






              decl = null;
            } else if (immediate) {
              if (!decl.isStatic()) {
                cdecl = new Declaration("(module-instance)");
                cdecl.setValue(new QuoteExp(floc.getInstance()));
              }
            } else if (decl.isStatic())
            {


              Class fclass = floc.getRClass();
              ClassLoader floader;
              if ((fclass == null) || (((floader = fclass.getClassLoader()) instanceof gnu.bytecode.ZipLoader)) || ((floader instanceof ArrayClassLoader)))
              {


                decl = null; }
            } else {
              decl = null;
            }
          } catch (Exception ex) { error('e', "exception loading '" + exp + "' - " + ex.getMessage());
            

            decl = null;
          }
        }
        else if ((mode != 'M') && ((loc == null) || (!loc.isBound())))
        {
          Expression e = checkDefaultBinding(symbol, this);
          if (e != null) {
            return e;
          }
        }
      }
      






      if (decl != null)
      {


        Field dfield = field;
        if ((!function) && (dfield != null) && (isObjectSyntax(dfield.getDeclaringClass(), dfield.getName())))
        {

          return QuoteExp.getInstance(Object.class);
        }
        if ((decl.getContext() instanceof PatternScope)) {
          return syntaxError("reference to pattern variable " + decl.getName() + " outside syntax template");
        }
      }
      if ((decl == null) && (function) && (nameToLookup == LispLanguage.lookup_sym))
      {
        decl = getNamedPartDecl; }
      int scanNesting = decl == null ? 0 : decl.getScanNesting();
      ReferenceExp rexp = new ReferenceExp(nameToLookup, decl);
      rexp.setContextDecl(cdecl);
      rexp.setLine(this);
      if (scanNesting > 0) {
        if (getScanContext() == null) {
          error('e', "using scan variable " + decl.getName() + " while not in scan context");
        } else {
          Declaration paramDecl = currentScanContext.getLambda().addParameter(null);
          
          currentScanContext.addSeqExpression(rexp);
          return new ReferenceExp(paramDecl);
        }
      }
      if ((function) && (separate))
        rexp.setFlag(2);
      return rexp; }
    if ((exp instanceof LangExp))
      return rewrite(((LangExp)exp).getLangValue(), function);
    if ((exp instanceof Expression))
      return (Expression)exp;
    if (exp == gnu.expr.Special.abstractSpecial)
      return QuoteExp.abstractExp;
    if (exp == Boolean.TRUE)
      return QuoteExp.trueExp;
    if (exp == Boolean.FALSE)
      return QuoteExp.falseExp;
    if (exp == gnu.expr.Special.nativeSpecial) {
      return QuoteExp.nativeExp;
    }
    if (((exp instanceof gnu.expr.Keyword)) && (!keywordsAreSelfEvaluating())) {
      error('w', "keyword should be quoted if not in argument position");
    }
    return QuoteExp.getInstance(Quote.quote(exp, this), this);
  }
  





  static Map<String, String> standardEntities;
  



  PairWithPosition positionPair;
  



  ArrayList notedAccess;
  



  public Expression checkDefaultBinding(Symbol symbol, Translator tr)
  {
    Namespace namespace = symbol.getNamespace();
    String local = symbol.getLocalPart();
    String name = symbol.toString();
    int len = name.length();
    
    if ((namespace instanceof XmlNamespace))
      return makeQuoteExp(((XmlNamespace)namespace).get(local));
    String namespaceName = namespace.getName();
    if (namespaceName == LispLanguage.unitNamespace.getName()) {
      Object val = gnu.math.Unit.lookup(local);
      if (val != null)
        return makeQuoteExp(val);
    }
    if (namespaceName == LispLanguage.entityNamespace.getName()) {
      Object val = lookupStandardEntity(local);
      if (val != null)
        return makeQuoteExp(val);
      tr.error('e', "unknown entity name " + local);
    }
    
    char ch0 = name.charAt(0);
    
    if (ch0 == '@') {
      String rest = name.substring(1);
      Expression classRef = tr.rewrite(Symbol.valueOf(rest));
      return MakeAnnotation.makeAnnotationMaker(classRef);
    }
    

    if ((ch0 == '-') || (ch0 == '+') || (Character.digit(ch0, 10) >= 0))
    {




      int state = 0;
      for (int i = 0; 
          
          i < len; i++) {
        char ch = name.charAt(i);
        if (Character.digit(ch, 10) >= 0) {
          state = state < 5 ? 4 : state < 3 ? 2 : 5;
        } else if (((ch == '+') || (ch == '-')) && (state == 0)) {
          state = 1;
        } else if ((ch == '.') && (state < 3)) {
          state = 3;
        } else { if (((ch != 'e') && (ch != 'E')) || ((state != 2) && (state != 4)) || (i + 1 >= len))
            break;
          int j = i + 1;
          char next = name.charAt(j);
          if ((next == '-') || (next == '+')) { j++; if (j < len)
              next = name.charAt(j); }
          if (Character.digit(next, 10) < 0)
            break;
          state = 5;
          i = j + 1;
        }
      }
      


      if ((i < len) && (state > 1)) {
        DFloNum num = new DFloNum(name.substring(0, i));
        boolean div = false;
        ArrayList vec = new ArrayList();
        while (i < len) {
          char ch = name.charAt(i++);
          if (ch == '*') {
            if (i == len)
              break label1040;
            ch = name.charAt(i++);
          } else if (ch == '/') {
            if ((i == len) || (div))
              break label1040;
            div = true;
            ch = name.charAt(i++);
          }
          int unitStart = i - 1;
          for (;;)
          {
            if (!Character.isLetter(ch)) {
              int unitEnd = i - 1;
              if (unitEnd != unitStart)
                break;
              break label1040;
            }
            if (i == len) {
              int unitEnd = i;
              ch = '1';
              break;
            }
            ch = name.charAt(i++); }
          int unitEnd;
          vec.add(name.substring(unitStart, unitEnd));
          boolean expRequired = false;
          if (ch == '^') {
            expRequired = true;
            if (i == len)
              break label1040;
            ch = name.charAt(i++);
          }
          boolean neg = div;
          if (ch == '+') {
            expRequired = true;
            if (i == len)
              break label1040;
            ch = name.charAt(i++);
          } else if (ch == '-') {
            expRequired = true;
            if (i == len)
              break label1040;
            ch = name.charAt(i++);
            neg = !neg;
          }
          int nexp = 0;
          int exp = 0;
          for (;;) {
            int dig = Character.digit(ch, 10);
            if (dig <= 0) {
              i--;
              break;
            }
            exp = 10 * exp + dig;
            nexp++;
            if (i == len)
              break;
            ch = name.charAt(i++);
          }
          if (nexp == 0) {
            exp = 1;
            if (expRequired)
              break label1040;
          }
          if (neg)
            exp = -exp;
          vec.add(IntNum.make(exp));
        }
        if (i == len) {
          int nunits = vec.size() >> 1;
          Expression[] units = new Expression[nunits];
          for (i = 0; i < nunits; i++) {
            String uname = (String)vec.get(2 * i);
            Symbol usym = LispLanguage.unitNamespace.getSymbol(uname.intern());
            Expression uref = tr.rewrite(usym);
            IntNum uexp = (IntNum)vec.get(2 * i + 1);
            if (uexp.longValue() != 1L) {
              uref = new ApplyExp(kawa.standard.expt.expt, new Expression[] { uref, makeQuoteExp(uexp) });
            }
            

            units[i] = uref; }
          Expression unit;
          Expression unit;
          if (nunits == 1) {
            unit = units[0];
          } else
            unit = new ApplyExp(MultiplyOp.$St, units);
          return new ApplyExp(MultiplyOp.$St, new Expression[] { makeQuoteExp(num), unit });
        }
      }
    }
    
    label1040:
    
    boolean sawAngle;
    
    boolean sawAngle;
    if ((len > 2) && (ch0 == '<') && (name.charAt(len - 1) == '>')) {
      name = name.substring(1, len - 1);
      len -= 2;
      sawAngle = true;
    } else {
      sawAngle = false; }
    int rank = 0;
    
    while ((len > 2) && (name.charAt(len - 2) == '[') && (name.charAt(len - 1) == ']')) {
      len -= 2;
      rank++;
    }
    
    String cname = name;
    if (rank != 0)
      cname = name.substring(0, len);
    try {
      Type type = getLanguage().getNamedType(cname);
      if ((rank > 0) && ((!sawAngle) || (type == null))) {
        Symbol tsymbol = namespace.getSymbol(cname.intern());
        Expression texp = tr.rewrite(tsymbol, false);
        texp = gnu.expr.InlineCalls.inlineCalls(texp, tr);
        if (!(texp instanceof ErrorExp))
          type = tr.getLanguage().getTypeFor(texp);
      }
      if (type != null)
      {
        for (;;) {
          rank--; if (rank < 0) break;
          type = gnu.bytecode.ArrayType.make(type);
        }
        return makeQuoteExp(type);
      }
      
      type = Type.lookupType(cname);
      Class clas; Class clas; if ((type instanceof gnu.bytecode.PrimType)) {
        clas = type.getReflectClass();
      } else {
        if (cname.indexOf('.') < 0) {
          cname = classPrefix + gnu.expr.Mangling.mangleNameIfNeeded(cname);
        }
        if (rank == 0) {
          ModuleManager mmanager = ModuleManager.getInstance();
          ModuleInfo typeInfo = mmanager.searchWithClassName(cname);
          if (typeInfo != null) {
            Compilation tcomp = typeInfo.getCompilation();
            if ((tcomp != null) && (mainClass != null)) {
              QuoteExp qexp = new QuoteExp(mainClass, Type.javalangClassType);
              
              qexp.setLocation(this);
              return qexp;
            }
          }
        }
        
        clas = ClassType.getContextClass(cname);
      }
      if (clas != null) {
        if (rank > 0) {
          type = Type.make(clas);
          for (;;) { rank--; if (rank < 0) break;
            type = gnu.bytecode.ArrayType.make(type);
          }
          clas = type.getReflectClass();
        }
        return makeQuoteExp(clas);
      }
    } catch (ClassNotFoundException ex) {
      Package pack = ArrayClassLoader.getContextPackage(name);
      if (pack != null)
        return makeQuoteExp(pack);
    } catch (NoClassDefFoundError ex) {
      tr.error('w', "error loading class " + cname + " - " + ex.getMessage() + " not found");
    }
    catch (Exception ex) {}
    if (name.startsWith("array")) {
      int nlen = name.length();
      if (nlen == 5)
        return makeQuoteExp(GenArrayType.generalInstance);
      try {
        rank = Integer.parseInt(name.substring(5));
        if (rank >= 0) {
          return makeQuoteExp(new GenArrayType(rank, Type.objectType));
        }
      }
      catch (Throwable ex) {}
    }
    return null;
  }
  
  public static synchronized String lookupStandardEntity(String key)
  {
    if (standardEntities == null) {
      standardEntities = new java.util.HashMap();
      gnu.text.Char.addNamedChars(standardEntities);
    }
    String val = (String)standardEntities.get(key);
    if (val != null)
      return val;
    return val = (String)gnu.text.StandardNamedChars.instance.get(key);
  }
  
  public static void setLine(Expression exp, Object location)
  {
    if ((location instanceof SourceLocator)) {
      exp.setLocation((SourceLocator)location);
    }
  }
  
  public static void setLine(Declaration decl, Object location) {
    if ((location instanceof SourceLocator)) {
      decl.setLocation((SourceLocator)location);
    }
  }
  




  public Object pushPositionOf(Object pos)
  {
    if ((pos instanceof SyntaxForm))
      pos = ((SyntaxForm)pos).getDatum();
    PairWithPosition pair;
    if ((pos instanceof PairWithPosition)) {
      pair = (PairWithPosition)pos; } else { PairWithPosition pair;
      if ((pos instanceof SourceLocator)) {
        pair = new PairWithPosition((SourceLocator)pos, null, null);
      } else
        return null; }
    PairWithPosition pair;
    Object saved; Object saved; if ((positionPair == null) || (positionPair.getFileName() != getFileName()) || (positionPair.getLineNumber() != getLineNumber()) || (positionPair.getColumnNumber() != getColumnNumber()))
    {



      saved = new PairWithPosition(this, this, positionPair);
    }
    else
      saved = positionPair;
    setLine(pos);
    positionPair = pair;
    return saved;
  }
  



  public void popPositionOf(Object saved)
  {
    if (saved == null)
      return;
    setLine(saved);
    positionPair = ((PairWithPosition)saved);
    if (positionPair.getCar() == this)
      positionPair = ((PairWithPosition)positionPair.getCdr());
  }
  
  public void errorWithPosition(String message, Object form) {
    Object save = pushPositionOf(form);
    error('e', message);
    popPositionOf(save);
  }
  
  public void errorIfNonEmpty(Object form) {
    if (form != LList.Empty) {
      error('e', "invalid improper (dotted) list");
    }
  }
  



  public void setLineOf(Expression exp)
  {
    if ((exp instanceof QuoteExp))
      return;
    if (exp.getLineNumber() <= 0) {
      exp.setLocation(this);
    }
  }
  
  public Type exp2Type(Pair typeSpecPair)
  {
    return exp2Type(typeSpecPair, null, null);
  }
  
  public Type exp2Type(Pair typeSpecPair, Declaration decl, SyntaxForm syntax)
  {
    Object saved = pushPositionOf(typeSpecPair);
    try
    {
      Expression texp = rewrite_car(typeSpecPair, syntax);
      if ((texp instanceof ErrorExp))
        return null;
      Object type = getLanguage().getTypeFor(texp);
      if (type == null)
      {
        try
        {
          Object t = texp.eval(env);
          if ((t instanceof Class)) {
            type = Type.make((Class)t);
          } else if ((t instanceof Type)) {
            type = (Type)t;
          }
        }
        catch (Error ex) {
          throw ex;
        }
        catch (Throwable ex) {}
      }
      

      if (type == null)
      {
        if ((texp instanceof ReferenceExp)) {
          error('e', "unknown type name '" + ((ReferenceExp)texp).getName() + '\'');
        }
        else {
          error('e', "invalid type spec (must be \"type\" or 'type or <type>)");
        }
        type = Type.errorType;
      }
      if (decl != null)
        decl.setType(texp, (Type)type);
      return (Throwable)type;
    }
    finally
    {
      popPositionOf(saved);
    }
  }
  

  public Expression rewrite_with_position(Object exp, boolean function, PairWithPosition pair)
  {
    Object saved = pushPositionOf(pair);
    Expression result;
    try {
      Expression result;
      if (exp == pair) {
        result = rewrite_pair(pair, function);
      } else
        result = rewrite(exp, function);
      setLineOf(result);
    }
    finally
    {
      popPositionOf(saved);
    }
    return result;
  }
  
  public static Object wrapSyntax(Object form, SyntaxForm syntax)
  {
    if ((syntax == null) || ((form instanceof Expression))) {
      return form;
    }
    return SyntaxForms.fromDatumIfNeeded(form, syntax);
  }
  


  public Values popForms(Pair beforeFirst)
  {
    Object tail = formStack.popTail(beforeFirst);
    if (tail == LList.Empty)
      return Values.empty;
    return new ValuesFromLList((LList)tail);
  }
  
  public void scanForm(Object st, ScopeExp defs)
  {
    if ((st instanceof SyntaxForm))
    {
      SyntaxForm sf = (SyntaxForm)st;
      ScopeExp save_scope = setPushCurrentScope(sf.getScope());
      try
      {
        Pair beforeFirst = formStack.last;
        scanForm(sf.getDatum(), defs);
        pushForm(wrapSyntax(popForms(beforeFirst), sf)); return;

      }
      finally
      {
        setPopCurrentScope(save_scope);
      }
    }
    if ((st instanceof Values))
    {
      if (st == Values.empty) {
        st = QuoteExp.voidExp;
      } else if ((st instanceof ValuesFromLList))
      {
        Object vs = values;
        while (vs != LList.Empty)
        {
          Pair p = (Pair)vs;
          Object save = pushPositionOf(p);
          scanForm(p.getCar(), defs);
          popPositionOf(save);
          vs = p.getCdr();
        }
      }
      else
      {
        Object[] vals = ((Values)st).getValues();
        for (int i = 0; i < vals.length; i++)
          scanForm(vals[i], defs);
        return;
      }
    }
    if ((st instanceof Pair))
    {
      Pair st_pair = (Pair)st;
      Declaration saveContext = macroContext;
      Syntax syntax = null;
      ScopeExp savedScope = current_scope;
      Object savedPosition = pushPositionOf(st);
      if (((st instanceof SourceLocator)) && (defs.getLineNumber() < 0)) {
        defs.setLocation((SourceLocator)st);
      }
      try {
        Object obj = st_pair.getCar();
        if ((obj instanceof SyntaxForm))
        {
          SyntaxForm sf = (SyntaxForm)st_pair.getCar();
          savedScope = setPushCurrentScope(sf.getScope());
          obj = sf.getDatum();
        }
        Pair p;
        if (((obj instanceof Pair)) && ((p = (Pair)obj).getCar() == LispLanguage.lookup_sym) && ((p.getCdr() instanceof Pair)) && (((p = (Pair)p.getCdr()).getCdr() instanceof Pair)))
        {



          Expression part1 = rewrite(p.getCar());
          Expression part2 = rewrite_car_for_lookup((Pair)p.getCdr());
          Object value1 = part1.valueIfConstant();
          Object value2 = part2.valueIfConstant();
          if (((value1 instanceof Class)) && ((value2 instanceof Symbol)))
          {
            try
            {
              obj = gnu.kawa.functions.GetNamedPart.getNamedPart(value1, (Symbol)value2);
              if ((obj instanceof Syntax)) {
                syntax = (Syntax)obj;
              }
            }
            catch (Exception ex) {
              obj = null;
            }
            
          } else
            obj = namespaceResolve(part1, part2);
        }
        if (((obj instanceof Symbol)) && (!selfEvaluatingSymbol(obj)))
        {
          Expression func = rewrite(obj, 'M');
          if ((func instanceof ReferenceExp))
          {
            Declaration decl = ((ReferenceExp)func).getBinding();
            if (decl != null) {
              syntax = check_if_Syntax(decl);
            }
            else {
              obj = resolve(obj, true);
              if ((obj instanceof Syntax)) {
                syntax = (Syntax)obj;
              }
              
            }
            
          }
        }
        else if ((obj == begin.begin) || (obj == kawa.standard.define_library.define_library_scan))
        {
          syntax = (Syntax)obj;
        }
      }
      finally {
        if (savedScope != current_scope)
          setPopCurrentScope(savedScope);
        popPositionOf(savedPosition);
      }
      if (syntax != null)
      {
        String save_filename = getFileName();
        int save_line = getLineNumber();
        int save_column = getColumnNumber();
        try
        {
          setLine(st_pair);
          syntax.scanForm(st_pair, defs, this); return;

        }
        finally
        {
          macroContext = saveContext;
          setLine(save_filename, save_line, save_column);
        }
      }
    }
    pushForm(st);
  }
  









  public LList scanBody(Object body, ScopeExp defs, boolean makeList)
  {
    LList list = makeList ? LList.Empty : null;
    Pair lastPair = null;
    while (body != LList.Empty)
    {
      if ((body instanceof SyntaxForm))
      {
        SyntaxForm sf = (SyntaxForm)body;
        ScopeExp save_scope = setPushCurrentScope(sf.getScope());
        try
        {
          Pair first = formStack.last;
          
          LList f = scanBody(sf.getDatum(), defs, makeList);
          LList localLList1; if (makeList)
          {
            f = (LList)SyntaxForms.fromDatumIfNeeded(f, sf);
            if (lastPair == null)
              return f;
            lastPair.setCdrBackdoor(f);
            return list;
          }
          pushForm(wrapSyntax(popForms(first), sf));
          return null;
        }
        finally
        {
          setPopCurrentScope(save_scope);
        }
      }
      if ((body instanceof Pair))
      {
        Pair pair = (Pair)body;
        Pair first = formStack.last;
        Object savePos = pushPositionOf(pair);
        scanForm(pair.getCar(), defs);
        popPositionOf(savePos);
        if ((getState() == 2) && (pendingForm != null))
        {



          if (pair.getCar() != pendingForm)
            pair = makePair(pair, pendingForm, pair.getCdr());
          pendingForm = new Pair(begin.begin, pair);
          if (makeList)
            formStack.pushAll(list);
          return LList.Empty;
        }
        if (makeList)
        {
          Pair last = formStack.lastPair();
          LList nlist = (LList)formStack.popTail(first);
          if (lastPair == null) {
            list = nlist;
          } else
            lastPair.setCdrBackdoor(nlist);
          if (last != first)
            lastPair = last;
        }
        body = pair.getCdr();
      }
      else
      {
        pushForm(syntaxError("body is not a proper list"));
      }
    }
    
    return list;
  }
  
  public static Pair makePair(Pair pair, Object car, Object cdr)
  {
    if ((pair instanceof PairWithPosition))
      return new PairWithPosition((PairWithPosition)pair, car, cdr);
    return new Pair(car, cdr);
  }
  






  public Expression rewrite_body(Object exp)
  {
    Object saved = pushPositionOf(exp);
    LetExp defs = new LetExp();
    defs.setFlag(2);
    int renamedAliasOldSize = renamedAliasCount();
    Pair first = formStack.last;
    defs.setOuter(current_scope);
    current_scope = defs;
    try
    {
      LList list = scanBody(exp, defs, true);
      if (list.isEmpty())
        pushForm(syntaxError("body with no expressions"));
      int ndecls = 0;
      for (Declaration decl = defs.firstDecl(); decl != null; decl = decl.nextDecl())
      {
        if (!decl.getFlag(268435456L))
        {
          ndecls++;
          decl.setInitValue(QuoteExp.undefined_exp);
        }
      }
      rewriteBody(list);
      int renamedAliasNewSize = renamedAliasCount();
      popRenamedAlias(renamedAliasNewSize - renamedAliasOldSize);
      Expression body = makeBody(first, null);
      setLineOf(body);
      Object localObject1; if (ndecls == 0)
        return body;
      defs.setBody(body);
      setLineOf(defs);
      return defs;
    }
    finally
    {
      pop(defs);
      popPositionOf(saved);
    }
  }
  
  protected void rewriteBody(LList forms)
  {
    while (forms != LList.Empty)
    {
      Pair pair = (Pair)forms;
      Object saved = pushPositionOf(pair);
      try
      {
        rewriteInBody(pair.getCar());
      }
      finally
      {
        popPositionOf(saved);
      }
      forms = (LList)pair.getCdr();
    }
  }
  

  protected Expression makeBody(Pair head, ScopeExp scope)
  {
    Object tail = formStack.popTail(head);
    int nforms = LList.length(tail);
    if (nforms == 0)
      return QuoteExp.voidExp;
    Pair first = (Pair)tail;
    if (nforms == 1)
    {
      return (Expression)first.getCar();
    }
    

    Expression[] exps = new Expression[nforms];
    first.toArray(exps);
    if ((scope instanceof ModuleExp)) {
      return new ApplyExp(gnu.kawa.functions.AppendValues.appendValues, exps);
    }
    
    return makeBody(exps);
  }
  
  public boolean appendBodyValues() {
    return false;
  }
  
  public Expression makeBody(Expression[] exps)
  {
    if (appendBodyValues()) {
      return new ApplyExp(gnu.kawa.functions.AppendValues.appendValues, exps);
    }
    return new gnu.expr.BeginExp(exps);
  }
  






  public void noteAccess(Object name, ScopeExp scope)
  {
    if (notedAccess == null)
      notedAccess = new ArrayList();
    notedAccess.add(name);
    notedAccess.add(scope);
  }
  




  public void processAccesses()
  {
    if (notedAccess == null)
      return;
    int sz = notedAccess.size();
    ScopeExp saveScope = current_scope;
    for (int i = 0; i < sz; i += 2)
    {
      Object name = notedAccess.get(i);
      ScopeExp scope = (ScopeExp)notedAccess.get(i + 1);
      if (current_scope != scope)
      {

        if (current_scope == saveScope)
          lexical.pushSaveTopLevelRedefs();
        setCurrentScope(scope);
      }
      Declaration decl = lexical.lookup(name, -1);
      if ((decl != null) && (!decl.getFlag(65536L)))
      {
        decl.getContext().currentLambda().capture(decl);
        decl.setCanRead(true);
        decl.setSimple(false);
        decl.setFlag(524288L);
      }
    }
    if (current_scope != saveScope) {
      setPopCurrentScope(saveScope);
    }
  }
  
  public void finishModule(ModuleExp mexp) {
    boolean moduleStatic = mexp.isStatic();
    for (Declaration decl = mexp.firstDecl(); 
        decl != null; decl = decl.nextDecl())
    {
      if (decl.getFlag(512L))
      {
        String msg1 = "'";
        String msg2 = decl.getFlag(2048L) ? "' declared static but never defined" : decl.getFlag(1024L) ? "' exported but never defined" : "' declared but never defined";
        




        error('e', decl, msg1, msg2);
      }
      if ((mexp.getFlag(32768)) || ((generateMainMethod()) && (!immediate)))
      {

        if (decl.getFlag(1024L))
        {
          if (decl.isPrivate())
          {
            if (decl.getFlag(16777216L)) {
              error('e', decl, "'", "' is declared both private and exported");
            }
            decl.setPrivate(false);
          }
        }
        else if (!kawa.standard.IfFeature.isProvide(decl))
          decl.setPrivate(true);
      }
      if (moduleStatic) {
        decl.setFlag(2048L);
      } else if (((mexp.getFlag(131072)) && (!decl.getFlag(2048L))) || (Compilation.moduleStatic < 0) || (mexp.getFlag(262144)))
      {


        decl.setFlag(4096L); }
    }
    if (mexp.getFlag(262144)) {
      mexp.setFlag(false, 8388608);
    }
  }
  
  public void resolveModule(ModuleExp mexp) {
    Expression savePos = new ReferenceExp((Object)null);
    int numPending = pendingImports == null ? 0 : pendingImports.size();
    for (int i = 0; i < numPending;)
    {
      ModuleInfo info = (ModuleInfo)pendingImports.elementAt(i++);
      ScopeExp defs = (ScopeExp)pendingImports.elementAt(i++);
      Expression posExp = (Expression)pendingImports.elementAt(i++);
      Pair beforeGoal = (Pair)pendingImports.elementAt(i++);
      require.DeclSetMapper mapper = (require.DeclSetMapper)pendingImports.elementAt(i++);
      if (mexp == defs)
      {

        savePos.setLine(this);
        setLine(posExp);
        Pair beforeImports = formStack.last;
        kawa.standard.require.importDefinitions(null, info, mapper, formStack, defs, this);
        
        if ((beforeGoal != beforeImports) && (beforeImports != formStack.last))
        {



          Object firstGoal = beforeGoal.getCdr();
          Object firstImports = beforeImports.getCdr();
          beforeGoal.setCdrBackdoor(firstImports);
          formStack.last.setCdrBackdoor(firstGoal);
          beforeImports.setCdrBackdoor(LList.Empty);
          formStack.last = beforeImports;
        }
        setLine(savePos);
      }
    }
    pendingImports = null;
    setModule(mexp);
    
    savePos.setLine(this);
    setLine(null, -1, -1);
    Compilation save_comp = Compilation.setSaveCurrent(this);
    try
    {
      Pair firstForm = formStack.getHead();
      rewriteBody((LList)formStack.popTail(firstForm));
      body = makeBody(firstForm, mexp);
      
      processAccesses();
      

      if (!immediate) {
        lexical.pop(mexp);
      }
      
      for (Declaration decl = mexp.firstDecl(); decl != null; 
          decl = decl.nextDecl()) {
        if ((decl.getSymbol() == null) && (decl.getFlag(1024L)))
        {
          decl.patchSymbolFromSet();
        }
      }
    }
    finally
    {
      Compilation.restoreCurrent(save_comp);
      setLine(savePos);
    }
  }
  










  public Declaration makeRenamedAlias(Declaration decl, ScopeExp templateScope)
  {
    if (templateScope == null)
      return decl;
    return makeRenamedAlias(decl.getSymbol(), decl, templateScope);
  }
  


  public Declaration makeRenamedAlias(Object name, Declaration decl, ScopeExp templateScope)
  {
    Declaration alias = new Declaration(name);
    alias.setAlias(true);
    alias.setPrivate(true);
    context = templateScope;
    ReferenceExp ref = new ReferenceExp(decl);
    ref.setDontDereference(true);
    alias.noteValue(ref);
    return alias;
  }
  













  public void pushRenamedAlias(Declaration alias)
  {
    Declaration decl = getOriginalRef(alias).getBinding();
    ScopeExp templateScope = context;
    decl.setSymbol(null);
    Declaration old = templateScope.lookup(alias.getSymbol());
    if (old != null)
      templateScope.remove(old);
    templateScope.addDeclaration(alias);
    if (renamedAliasStack == null)
      renamedAliasStack = new Stack();
    renamedAliasStack.push(old);
    renamedAliasStack.push(alias);
  }
  
  public int renamedAliasCount() {
    return renamedAliasStack == null ? 0 : renamedAliasStack.size() >> 1;
  }
  
  public void popRenamedAlias(int count) {
    for (;;) {
      
      if (count < 0)
        break;
      Declaration alias = (Declaration)renamedAliasStack.pop();
      ScopeExp templateScope = alias.getContext();
      Declaration decl = getOriginalRef(alias).getBinding();
      decl.setSymbol(alias.getSymbol());
      templateScope.remove(alias);
      Declaration old = (Declaration)renamedAliasStack.pop();
      if (old != null)
        templateScope.addDeclaration(old);
    }
  }
  
  public Declaration define(Object name, ScopeExp defs) {
    return define(name, (TemplateScope)null, defs);
  }
  
  public Declaration define(Object name, SyntaxForm nameSyntax, ScopeExp defs)
  {
    return define(name, nameSyntax == null ? null : nameSyntax.getScope(), defs);
  }
  

  public Declaration define(Object name, TemplateScope templateScope, ScopeExp defs)
  {
    ScopeExp scope = templateScope != null ? templateScope : currentScope();
    
    boolean aliasNeeded = scope != defs;
    Object declName = aliasNeeded ? Symbol.makeUninterned(name.toString()) : name;
    

    Declaration decl = defs.getDefine(declName, this);
    if (aliasNeeded) {
      Declaration alias = makeRenamedAlias(name, decl, scope);
      if ((defs instanceof LetExp)) {
        pushRenamedAlias(alias);
      } else
        scope.addDeclaration(alias);
    }
    push(decl);
    return decl;
  }
  
  static boolean isObjectSyntax(ClassType declaringClass, String fieldName)
  {
    return ("objectSyntax".equals(fieldName)) && ("kawa.standard.object".equals(declaringClass.getName()));
  }
  

  public FormStack formStack = new FormStack(this);
  public void pushForm(Object value) { formStack.push(value); }
  

  public static class FormStack
    extends Pair
  {
    private Pair last = this;
    SourceLocator sloc;
    
    public FormStack(SourceLocator sloc) {
      this.sloc = sloc;
      cdr = LList.Empty;
    }
    



    public Pair getHead() { return this; }
    public Object getFirst() { return cdr; }
    

    public Pair lastPair()
    {
      return last;
    }
    











    public Object popTail(Pair oldTail)
    {
      Object r = oldTail.getCdr();
      oldTail.setCdrBackdoor(LList.Empty);
      last = oldTail;
      return r;
    }
    
    public void push(Object value) {
      Pair pair = new PairWithPosition(sloc, value, LList.Empty);
      last.setCdrBackdoor(pair);
      last = pair;
    }
    
    public void pushAll(LList values) {
      if (values == LList.Empty)
        return;
      last.setCdrBackdoor(values);
      last = ((Pair)values).lastPair();
    }
    
    public void pushAll(LList values, Pair valuesLast) {
      if (values == LList.Empty)
        return;
      last.setCdrBackdoor(values);
      last = valuesLast;
    }
    
    public void pushAfter(Object value, Pair position) {
      Pair pair = new PairWithPosition(sloc, value, position.getCdr());
      position.setCdrBackdoor(pair);
      if (last == position) {
        last = pair;
      }
    }
  }
  
  public static class ValuesFromLList extends gnu.mapping.Values.FromList<Object>
  {
    public LList values;
    
    public ValuesFromLList(LList values) {
      super();
      this.values = values;
    }
  }
  

  private ScanContext currentScanContext;
  public ScanContext getScanContext() { return currentScanContext; }
  public void setScanContext(ScanContext ctx) { currentScanContext = ctx; }
  
  public void pushScanContext(LambdaExp lambda) {
    ScanContext newContext = new ScanContext();
    outer = currentScanContext;
    currentScanContext = newContext;
    lambda = lambda;
  }
  
  public void popScanContext() { currentScanContext = currentScanContext.outer; }
  
  public static class ScanContext { ScanContext outer;
    public ScanContext() {}
    ArrayList<Expression> sequences = new ArrayList();
    

    public LambdaExp getLambda() { return lambda; }
    
    LambdaExp lambda;
    public void addSeqExpression(Expression exp) { sequences.add(exp); }
  }
}
