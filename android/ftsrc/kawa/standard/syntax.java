package kawa.standard;

import gnu.expr.Expression;
import gnu.lists.Pair;
import kawa.lang.Translator;

public class syntax extends kawa.lang.Quote
{
  public static final syntax syntax = new syntax("syntax", false);
  public static final syntax quasiSyntax = new syntax("quasisyntax", true);
  
  public syntax(String name, boolean isQuasi)
  {
    super(name, isQuasi);
  }
  
  protected boolean matchesUnquote(Pair pair, kawa.lang.SyntaxForm syntax, Translator tr)
  {
    Object form = pair.getCar();
    if (tr.matches(form, syntax, "unsyntax"))
      return true;
    if (tr.matches(form, syntax, "unquote")) {
      tr.error('w', "unquote inside quasisyntax is deprecated - use unsyntax or #,", (pair instanceof gnu.lists.PairWithPosition) ? (gnu.lists.PairWithPosition)pair : tr);
      

      return true;
    }
    return false;
  }
  
  protected boolean matchesUnquoteSplicing(Pair pair, kawa.lang.SyntaxForm syntax, Translator tr)
  {
    Object form = pair.getCar();
    if (tr.matches(form, syntax, "unsyntax-splicing"))
      return true;
    if (tr.matches(form, syntax, "unquote-splicing")) {
      tr.error('w', "unquote-splicing inside quasisyntax is deprecated - use unsyntax-splicing or #@,", (pair instanceof gnu.lists.PairWithPosition) ? (gnu.lists.PairWithPosition)pair : tr);
      

      return true;
    }
    return false;
  }
  
  protected boolean matchesQuasiQuote(Object form, kawa.lang.SyntaxForm syntax, Translator tr)
  {
    return tr.matches(form, syntax, "quasisyntax");
  }
  
  protected boolean expandColonForms()
  {
    return false;
  }
  
  static final gnu.bytecode.ClassType typeTemplateScope = gnu.bytecode.ClassType.make("kawa.lang.TemplateScope");
  
  static final gnu.bytecode.Method makeTemplateScopeMethod = typeTemplateScope.getDeclaredMethod("make", 0);
  

  public Expression rewriteForm(Pair form, Translator tr)
  {
    if ((!(form.getCdr() instanceof Pair)) || ((form = (Pair)form.getCdr()).getCdr() != gnu.lists.LList.Empty))
    {
      return tr.syntaxError("syntax forms requires a single form"); }
    gnu.expr.Declaration saveTemplateScopeDecl = templateScopeDecl;
    gnu.expr.Declaration templateScopeDecl; if (saveTemplateScopeDecl == null)
    {
      tr.letStart();
      Expression init = new gnu.expr.ApplyExp(makeTemplateScopeMethod, Expression.noExpressions);
      

      templateScopeDecl = tr.letVariable(null, typeTemplateScope, init);
      templateScopeDecl.setCanRead();
      templateScopeDecl = templateScopeDecl;
      tr.letEnter();
    }
    
    try
    {
      Expression body = coerceExpression(expand(form.getCar(), isQuasi ? 1 : -1, tr), tr);
      

      return saveTemplateScopeDecl == null ? tr.letDone(body) : body;
    }
    finally
    {
      templateScopeDecl = saveTemplateScopeDecl;
    }
  }
  
  protected Expression leaf(Object val, Translator tr)
  {
    return makeSyntax(val, tr);
  }
  
  static Expression makeSyntax(Object form, Translator tr)
  {
    kawa.lang.SyntaxTemplate template = new kawa.lang.SyntaxTemplate(form, null, kawa.lang.SyntaxRule.dots3Symbol, tr);
    
    Expression matchArray = gnu.expr.QuoteExp.nullExp;
    kawa.lang.PatternScope patternScope = patternScope;
    if ((patternScope != null) && (matchArray != null))
      matchArray = new gnu.expr.ReferenceExp(matchArray);
    Expression[] args = { new gnu.expr.QuoteExp(template), matchArray, new gnu.expr.ReferenceExp(templateScopeDecl) };
    return new gnu.expr.ApplyExp(gnu.bytecode.ClassType.make("kawa.lang.SyntaxTemplate").getDeclaredMethod("execute", new gnu.bytecode.Type[] { null, typeTemplateScope }), args);
  }
}
