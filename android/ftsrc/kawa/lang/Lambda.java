package kawa.lang;

import gnu.bytecode.Type;
import gnu.expr.BeginExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.util.ArrayList;
import kawa.standard.object;

public class Lambda extends Syntax
{
  public boolean handlePatterns;
  public Object optionalKeyword;
  public Object restKeyword;
  public Object keyKeyword;
  public static final Keyword nameKeyword = Keyword.make("name");
  

  public Expression defaultDefault = QuoteExp.falseExp;
  
  public Lambda() {}
  
  public void setKeywords(Object optional, Object rest, Object key) { optionalKeyword = optional;
    restKeyword = rest;
    keyKeyword = key;
  }
  

  public Expression rewriteForm(Pair form, Translator tr)
  {
    Expression exp = rewrite(form.getCdr(), tr);
    Translator.setLine(exp, form);
    return exp;
  }
  

  public Expression rewrite(Object obj, Translator tr)
  {
    if (!(obj instanceof Pair))
      return tr.syntaxError("missing formals in lambda");
    int old_errors = tr.getMessages().getErrorCount();
    LambdaExp lexp = new LambdaExp();
    Pair pair = (Pair)obj;
    Translator.setLine(lexp, pair);
    rewrite(lexp, pair.getCar(), pair.getCdr(), tr, null);
    if (tr.getMessages().getErrorCount() > old_errors)
      return new gnu.expr.ErrorExp("bad lambda expression");
    return lexp;
  }
  







  public void rewrite(LambdaExp lexp, Object formals, Object body, Translator tr, TemplateScope templateScopeRest)
  {
    lexp.setCallConvention(tr);
    rewriteFormals(lexp, formals, tr, templateScopeRest);
    if ((body instanceof gnu.lists.PairWithPosition))
      lexp.setFile(((gnu.lists.PairWithPosition)body).getFileName());
    body = rewriteAttrs(lexp, body, tr);
    rewriteBody(lexp, body, tr);
  }
  

  public void rewriteFormals(LambdaExp lexp, Object formals, Translator tr, TemplateScope templateScopeRest)
  {
    if (handlePatterns)
      tr.pushScope(lexp);
    if (lexp.getSymbol() == null)
    {
      String filename = lexp.getFileName();
      int line = lexp.getLineNumber();
      if ((filename != null) && (line > 0))
        lexp.setSourceLocation(filename, line);
    }
    Object bindings = formals;
    int opt_args = -1;
    int rest_args = -1;
    int key_args = -1;
    
    bindings = formals;
    opt_args = -1;
    key_args = -1;
    ArrayList<Expression> defaultArgs = null;
    ArrayList<Keyword> keywords = null;
    Object mode = null;
    Object next = null;
    for (;; bindings = next)
    {
      if ((bindings instanceof SyntaxForm))
      {
        SyntaxForm sf = (SyntaxForm)bindings;
        bindings = sf.getDatum();
        

        templateScopeRest = sf.getScope();
      }
      if (!(bindings instanceof Pair))
        break;
      TemplateScope templateScope = templateScopeRest;
      Pair pair = (Pair)bindings;
      Object pair_car = pair.getCar();
      next = pair.getCdr();
      if ((pair_car instanceof SyntaxForm))
      {
        SyntaxForm sf = (SyntaxForm)pair_car;
        pair_car = sf.getDatum();
        templateScope = sf.getScope();
      }
      if (pair_car == optionalKeyword)
      {
        if (opt_args >= 0) {
          tr.syntaxError("multiple " + optionalKeyword + " keywords in parameter list");
        } else if ((rest_args >= 0) || (key_args >= 0))
          tr.syntaxError(optionalKeyword.toString() + " after " + restKeyword + " or " + keyKeyword);
        opt_args = 0;
      }
      else if (pair_car == restKeyword)
      {
        if (rest_args >= 0) {
          tr.syntaxError("multiple " + restKeyword + " keywords in parameter list");
        }
        else if (key_args >= 0) {
          tr.syntaxError(restKeyword.toString() + " after " + keyKeyword);
        }
        rest_args = 0;
      }
      else if (pair_car == keyKeyword)
      {
        if (key_args >= 0) {
          tr.syntaxError("multiple " + keyKeyword + " keywords in parameter list");
        }
        key_args = 0;
      }
      else if (key_args >= 0) {
        key_args++;
      } else if (rest_args >= 0) {
        rest_args++;
      } else if (opt_args >= 0) {
        opt_args++;
      } else {
        min_args += 1; }
      if ((pair_car == optionalKeyword) || (pair_car == restKeyword) || (pair_car == keyKeyword))
      {

        mode = pair_car;
      }
      else {
        Object savePos = tr.pushPositionOf(pair);
        Object name = null;
        Object defaultValue = defaultDefault;
        Pair typeSpecPair = null;
        
        if (tr.matches(pair_car, "::"))
        {
          tr.syntaxError("'::' must follow parameter name");
          break;
        }
        pair_car = tr.namespaceResolve(pair_car);
        if (((pair_car instanceof Symbol)) && ((!handlePatterns) || (mode != null)))
        {

          name = pair_car;
          Pair p; if (((pair.getCdr() instanceof Pair)) && (tr.matches((p = (Pair)pair.getCdr()).getCar(), "::")))
          {

            if (!(p.getCdr() instanceof Pair))
            {
              tr.syntaxError("'::' not followed by a type specifier (for parameter '" + name + "')");
              
              bindings = LList.Empty;
              break;
            }
            p = (Pair)p.getCdr();
            typeSpecPair = p;
            pair = p;
            next = pair.getCdr();
          }
        }
        else if (((pair_car instanceof Pair)) && ((!handlePatterns) || (mode != null)))
        {

          Pair p = (Pair)pair_car;
          pair_car = p.getCar();
          if ((pair_car instanceof SyntaxForm))
          {
            SyntaxForm sf = (SyntaxForm)pair_car;
            pair_car = sf.getDatum();
            templateScope = sf.getScope();
          }
          pair_car = tr.namespaceResolve(pair_car);
          if (((pair_car instanceof Symbol)) && ((p.getCdr() instanceof Pair)))
          {

            name = pair_car;
            p = (Pair)p.getCdr();
            if (tr.matches(p.getCar(), "::"))
            {
              if (!(p.getCdr() instanceof Pair))
              {
                tr.syntaxError("'::' not followed by a type specifier (for parameter '" + name + "')");
                
                break;
              }
              p = (Pair)p.getCdr();
              typeSpecPair = p;
              if ((p.getCdr() instanceof Pair)) {
                p = (Pair)p.getCdr();
              } else if (p.getCdr() == LList.Empty) {
                p = null;
              }
              else {
                tr.syntaxError("improper list in specifier for parameter '" + name + "')");
                
                break;
              }
            }
            if ((p != null) && (mode != null))
            {
              defaultValue = p.getCar();
              if ((p.getCdr() instanceof Pair)) {
                p = (Pair)p.getCdr();
              } else if (p.getCdr() == LList.Empty) {
                p = null;
              }
              else {
                tr.syntaxError("improper list in specifier for parameter '" + name + "')");
                
                break;
              }
            }
            if (p != null)
            {
              if (typeSpecPair != null)
              {
                tr.syntaxError("duplicate type specifier for parameter '" + name + '\'');
                
                break;
              }
              typeSpecPair = p;
              if (p.getCdr() != LList.Empty)
              {
                tr.syntaxError("junk at end of specifier for parameter '" + name + '\'' + " after type " + p.getCar());
                
                break;
              }
              tr.error('w', "deprecated type specifier syntax - use (VAR :: TYPE) rather than (VAR TYPE)");
            }
          }
        }
        Declaration decl;
        if ((handlePatterns) && (mode == null)) {
          Pair p = pair;
          pair_car = p.getCar();
          boolean extraParens = false;
          if ((pair_car instanceof Pair)) {
            Object pair_car_cdr = ((Pair)pair_car).getCdr();
            if (((pair_car_cdr instanceof Pair)) && (tr.matches(((Pair)pair_car_cdr).getCar(), "::")))
            {
              extraParens = true; }
          }
          Object[] r = BindDecls.instance.parsePatternCar(extraParens ? (Pair)pair_car : p, 0, lexp, tr);
          if (!extraParens) {
            next = r[0];
          } else if (r[0] != LList.Empty) {
            Object savePos1 = tr.pushPositionOf(r[0]);
            tr.syntaxError("junk at end of specifier for parameter");
            tr.popPositionOf(savePos1);
          }
          Declaration decl = (Declaration)r[1];
          if (decl == null)
            decl = new Declaration("<error>");
          name = decl == null ? null : decl.getSymbol();
        } else {
          if (name == null) {
            tr.syntaxError("parameter is neither name nor (name :: type) nor (name default): " + pair);
            break;
          }
          decl = new Declaration(name);
        }
        decl.setFlag(8796093022208L);
        if ((mode == optionalKeyword) || (mode == keyKeyword))
        {
          decl.setInitValue(new LangExp(defaultValue));
          if (mode == keyKeyword)
          {
            if (keywords == null)
              keywords = new ArrayList();
            keywords.add(Keyword.make((name instanceof Symbol) ? ((Symbol)name).getName() : name.toString()));
          }
        }
        Translator.setLine(decl, bindings);
        if (typeSpecPair != null)
        {
          decl.setType(new LangExp(typeSpecPair), null);
          decl.setFlag(8192L);
        }
        if (mode == restKeyword)
        {
          decl.setFlag(4398046511104L);
          if (!decl.getFlag(8192L))
            decl.setType(gnu.kawa.lispexpr.LangObjType.listType);
        }
        decl.setFlag(262144L);
        if ((!handlePatterns) || (mode != null))
          addParam(decl, templateScope, lexp, tr);
        tr.popPositionOf(savePos);
      } }
    if ((bindings instanceof SyntaxForm))
    {
      SyntaxForm sf = (SyntaxForm)bindings;
      bindings = sf.getDatum();
      templateScopeRest = sf.getScope();
    }
    if ((bindings instanceof Symbol))
    {
      if ((opt_args >= 0) || (key_args >= 0) || (rest_args >= 0))
      {
        tr.syntaxError("dotted rest-arg after " + optionalKeyword + ", " + restKeyword + ", or " + keyKeyword);

      }
      else
      {
        rest_args = 1;
        Declaration decl = new Declaration(bindings);
        decl.setType(gnu.kawa.lispexpr.LangObjType.listType);
        decl.setFlag(13194139795456L);
        

        decl.noteValueUnknown();
        addParam(decl, templateScopeRest, lexp, tr);
      }
    }
    else if (bindings != LList.Empty)
    {
      tr.syntaxError("misformed formals in lambda");
    }
    if (rest_args > 1)
    {
      tr.syntaxError("multiple " + restKeyword + " parameters");
      rest_args = 1;
    }
    if (opt_args < 0)
      opt_args = 0;
    if (rest_args < 0)
      rest_args = 0;
    if (key_args < 0)
      key_args = 0;
    if (rest_args > 0) {
      max_args = -1;
    } else
      max_args = (min_args + opt_args + 2 * key_args);
    opt_args = opt_args;
    if (keywords != null) {
      keywords = ((Keyword[])keywords.toArray(new Keyword[keywords.size()]));
    }
  }
  
  protected void addParam(Declaration decl, ScopeExp templateScope, LambdaExp lexp, Translator tr)
  {
    if (templateScope != null)
      decl = tr.makeRenamedAlias(decl, templateScope);
    lexp.addDeclaration(decl);
    if (templateScope != null)
      context = templateScope;
    if (handlePatterns) {
      tr.push(decl);
    }
  }
  
  public Object rewriteAttrs(LambdaExp lexp, Object body, Translator tr) {
    String allocationFlagName = null;
    long accessFlag = 0L;
    int allocationFlag = 0;
    SyntaxForm syntax0 = null;
    for (;;)
    {
      if ((body instanceof SyntaxForm))
      {
        syntax0 = (SyntaxForm)body;
        body = syntax0.getDatum();
      } else {
        if (!(body instanceof Pair))
          break;
        Pair pair1 = (Pair)body;
        Object attrName = Translator.stripSyntax(pair1.getCar());
        if (tr.matches(attrName, "::")) {
          attrName = null;
        } else { if (((attrName instanceof Pair)) && (isAnnotationSymbol(((Pair)attrName).getCar())))
          {

            if (nameDecl == null) {
              tr.error('e', "annotation for anonymous function");
            } else
              nameDecl.addAnnotation(new LangExp(pair1));
            body = pair1.getCdr();
            continue;
          }
          if (!(attrName instanceof Keyword))
            break;
        }
        SyntaxForm syntax1 = syntax0;
        Object pair1_cdr = pair1.getCdr();
        while ((pair1_cdr instanceof SyntaxForm))
        {
          syntax1 = (SyntaxForm)pair1_cdr;
          pair1_cdr = syntax1.getDatum();
        }
        if (!(pair1_cdr instanceof Pair))
          break;
        Pair pair2 = (Pair)pair1_cdr;
        

        if (attrName == null)
        {
          if ((lexp.isClassMethod()) && ("*init*".equals(lexp.getName()))) {
            tr.error('e', "explicit return type for '*init*' method");
          }
          else {
            body = new LangExp(new Object[] { pair2, syntax1 });
          }
        } else if (attrName == object.accessKeyword)
        {
          accessFlag = object.addAccessFlags(pair2.getCar(), accessFlag, 223589957632L, "method", tr);



        }
        else if (attrName == object.allocationKeyword)
        {
          Expression attrExpr = tr.rewrite_car(pair2, syntax1);
          Object attrValue; if ((!(attrExpr instanceof QuoteExp)) || ((!((attrValue = ((QuoteExp)attrExpr).getValue()) instanceof SimpleSymbol)) && (!(attrValue instanceof CharSequence))))
          {







            tr.error('e', "allocation: value not a constant symbol or string"); } else { Object attrValue;
            if (nameDecl == null) {
              tr.error('e', "allocation: not allowed for anonymous function");
            }
            else {
              String value = attrValue.toString();
              if (("class".equals(value)) || ("static".equals(value))) {
                allocationFlag = 2048;
              } else if ("instance".equals(value)) {
                allocationFlag = 4096;
              } else
                tr.error('e', "unknown allocation specifier");
              if ((allocationFlagName != null) && (value != null))
              {
                tr.error('e', "duplicate allocation specifiers - " + allocationFlagName + " and " + value);
              }
              

              allocationFlagName = value;
            }
          }
        } else if (attrName == object.throwsKeyword)
        {
          Object attrValue = pair2.getCar();
          int count = Translator.listLength(attrValue);
          if (count < 0) {
            tr.error('e', "throws: not followed by a list");
          }
          else {
            Expression[] exps = new Expression[count];
            SyntaxForm syntax2 = syntax1;
            for (int i = 0; i < count; i++)
            {
              while ((attrValue instanceof SyntaxForm))
              {
                syntax2 = (SyntaxForm)attrValue;
                attrValue = syntax2.getDatum();
              }
              Pair pair3 = (Pair)attrValue;
              exps[i] = tr.rewrite_car(pair3, syntax2);
              
              Translator.setLine(exps[i], pair3);
              attrValue = pair3.getCdr();
            }
            lexp.setExceptions(exps);
          }
        }
        else if (attrName == nameKeyword)
        {
          Expression attrExpr = tr.rewrite_car(pair2, syntax1);
          if ((attrExpr instanceof QuoteExp)) {
            lexp.setName(((QuoteExp)attrExpr).getValue().toString());
          }
        }
        else {
          Expression attrExpr = tr.rewrite_car(pair2, syntax1);
          attrName = ((Keyword)attrName).asSymbol();
          lexp.setProperty(attrName, attrExpr);
        }
        body = pair2.getCdr();
      } }
    accessFlag |= allocationFlag;
    if (accessFlag != 0L)
      nameDecl.setFlag(accessFlag);
    if (syntax0 != null)
      body = SyntaxForms.fromDatumIfNeeded(body, syntax0);
    return body;
  }
  
  public Object skipAttrs(LambdaExp lexp, Object body, Translator tr)
  {
    while ((body instanceof Pair))
    {
      Pair pair = (Pair)body;
      if (!(pair.getCdr() instanceof Pair))
        break;
      Object attrName = pair.getCar();
      if (tr.matches(attrName, "::"))
        attrName = null; else
        if (!(attrName instanceof Keyword))
          break;
      body = ((Pair)pair.getCdr()).getCdr();
    }
    return body;
  }
  
  public void rewriteBody(LambdaExp lexp, Object body, Translator tr)
  {
    int numRenamedAlias = 0;
    

    if ((curMethodLambda == null) && (nameDecl != null) && (tr.getModule().getFlag(262144)))
    {

      curMethodLambda = lexp; }
    ScopeExp curs = tr.currentScope();
    if (!handlePatterns)
      tr.pushScope(lexp);
    if (nameDecl != null)
      rewriteAnnotations(nameDecl, tr);
    Declaration prev = null;
    int key_args = keywords == null ? 0 : keywords.length;
    int opt_args = opt_args;
    int arg_i = 0;
    for (Declaration cur = lexp.firstDecl(); cur != null; cur = cur.nextDecl())
    {
      if (cur.isAlias())
      {
        Declaration param = Translator.getOriginalRef(cur).getBinding();
        lexp.replaceFollowing(prev, param);
        context = lexp;
        tr.pushRenamedAlias(cur);
        numRenamedAlias++;
        cur = param;
      }
      Expression texp = cur.getTypeExpRaw();
      if ((texp instanceof LangExp))
      {
        Pair typeSpecPair = (Pair)((LangExp)texp).getLangValue();
        Type t = tr.exp2Type(typeSpecPair, cur, null);
        if (t != null)
          cur.setType(t);
      }
      prev = cur;
      
      if (cur.getFlag(8796093022208L))
      {
        if ((arg_i >= min_args) && ((arg_i < min_args + opt_args) || (max_args >= 0) || (arg_i != min_args + opt_args)))
        {



          cur.setInitValue(tr.rewrite(cur.getInitValue()));
        }
        arg_i++;
      }
      
      if (!handlePatterns) {
        lexical.push(cur);
      }
    }
    if ((lexp.isClassMethod()) && (!nameDecl.getFlag(2048L)))
    {


      lexp.add(null, new Declaration(gnu.expr.ThisExp.THIS_NAME));
    }
    
    LambdaExp saveLambda = curLambda;
    curLambda = lexp;
    Type rtype = returnType;
    Object[] tform = (body instanceof LangExp) ? (Object[])((LangExp)body).getLangValue() : null;
    

    body = auxillaryRewrite(body, tr);
    curLambda = saveLambda;
    

    try
    {
      if (tform != null)
      {
        Expression texp = tr.rewrite_car((Pair)tform[0], (SyntaxForm)tform[1]);
        
        lexp.setCoercedReturnValue(texp, tr.getLanguage()); } else { Expression[] exps;
        int len;
        Object val; if (((body instanceof BeginExp)) && ((body instanceof Pair)) && ((((Pair)body).getCar() instanceof Symbol)) && ((len = (exps = ((BeginExp)body).getExpressions()).length) > 1) && (((exps[0] instanceof gnu.expr.ReferenceExp)) || (((val = exps[0].valueIfConstant()) instanceof Type)) || ((val instanceof Class))))
        {







          tr.error('w', "deprecated return-type specifier - use '::TYPE'");
          Expression rexp = exps[0];
          len--;
          if (len == 1) {
            body = exps[1];
          }
          else {
            Expression[] new_body = new Expression[len];
            System.arraycopy(exps, 1, new_body, 0, len);
            body = BeginExp.canonicalize(new_body);
          }
          lexp.setCoercedReturnValue(rexp, tr.getLanguage());
        }
        else {
          lexp.setCoercedReturnType(rtype);
        }
      } } finally { tr.pop(lexp);
      lexp.countDecls();
      tr.popRenamedAlias(numRenamedAlias);
      lexp.countDecls();
    }
    if (curMethodLambda == lexp) {
      curMethodLambda = null;
    }
  }
  
  public Expression auxillaryRewrite(Object body, Translator tr) {
    return tr.rewrite_body(body);
  }
  

  public void print(gnu.lists.Consumer out)
  {
    out.write("#<builtin lambda>");
  }
  
  public static boolean isAnnotationSymbol(Object key)
  {
    if ((key instanceof Pair))
    {
      Pair keyp = (Pair)key;
      if (keyp.getCar() == gnu.kawa.lispexpr.LispLanguage.splice_sym)
        return true;
    }
    if ((key instanceof SimpleSymbol))
    {
      String name = ((SimpleSymbol)key).getName();
      if ((name.length() > 1) && (name.charAt(0) == '@'))
        return true;
    }
    return false;
  }
  
  public static void rewriteAnnotations(Declaration decl, Translator tr)
  {
    int n = decl.numAnnotations();
    for (int i = 0; i < n; i++)
    {
      Expression ann = decl.getAnnotation(i);
      if ((ann instanceof LangExp))
      {
        ann = tr.rewrite_car((Pair)((LangExp)ann).getLangValue(), false);
        decl.setAnnotation(i, ann);
      }
    }
  }
}
