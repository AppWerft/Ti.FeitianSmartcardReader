package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ReferenceExp;
import gnu.expr.Special;
import gnu.mapping.Symbol;
import kawa.lang.Translator;

public class SchemeCompilation extends Translator
{
  public SchemeCompilation(gnu.expr.Language language, gnu.text.SourceMessages messages, gnu.expr.NameLookup lexical, gnu.mapping.Environment env)
  {
    super(language, messages, lexical, env);
  }
  
  public SchemeCompilation(gnu.expr.Language language, gnu.text.SourceMessages messages, gnu.expr.NameLookup lexical)
  {
    super(language, messages, lexical);
  }
  
  public static final Declaration applyFieldDecl = Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "applyToArgs");
  public static final kawa.repl repl;
  
  public Expression applyFunction(Expression func)
  {
    if ((func instanceof gnu.expr.LambdaExp)) {
      return null;
    }
    return new ReferenceExp(applyFieldDecl);
  }
  

  public boolean isApplyFunction(Expression exp)
  {
    return isSimpleApplyFunction(exp);
  }
  

  public boolean isSimpleApplyFunction(Expression exp)
  {
    return ((exp instanceof ReferenceExp)) && (((ReferenceExp)exp).getBinding() == applyFieldDecl);
  }
  





  public boolean appendBodyValues()
  {
    return ((Scheme)getLanguage()).appendBodyValues();
  }
  


  public static final kawa.lang.Lambda lambda = new kawa.lang.Lambda();
  public static final kawa.lang.Lambda mlambda = new kawa.lang.Lambda();
  static { mlambdahandlePatterns = true;
    mlambda.setKeywords(Special.optional, Special.rest, Special.key);
    



    repl = new kawa.repl(Scheme.instance);
    lambda.setKeywords(Special.optional, Special.rest, Special.key);
  }
  






  public Expression checkDefaultBinding(Symbol symbol, Translator tr)
  {
    gnu.mapping.Namespace namespace = symbol.getNamespace();
    String local = symbol.getLocalPart();
    
    String name = symbol.toString();
    int len = name.length();
    if (len == 0)
      return null;
    int llen = local.length();
    


    if ((len > 1) && (llen > 1) && (name.charAt(len - 1) == '?')) {
      String tlocal = local.substring(0, llen - 1).intern();
      Symbol tsymbol = namespace.getSymbol(tlocal);
      Expression texp = tr.rewrite(tsymbol, false);
      if ((texp instanceof ReferenceExp)) {
        Declaration decl = ((ReferenceExp)texp).getBinding();
        if ((decl == null) || (decl.getFlag(65536L))) {
          texp = null;
        }
      } else if (!(texp instanceof gnu.expr.QuoteExp)) {
        texp = null; }
      if (texp != null) {
        gnu.expr.LambdaExp lexp = new gnu.expr.LambdaExp(1);
        lexp.setSymbol(symbol);
        Declaration param = lexp.addDeclaration((Object)null);
        param.setFlag(8796093022208L);
        param.noteValueUnknown();
        body = new gnu.expr.ApplyExp(Scheme.instanceOf, new Expression[] { new ReferenceExp(param), texp });
        
        return lexp;
      }
    }
    


    if ((len > 2) && (llen > 2) && (name.charAt(0) == '-') && (name.charAt(1) == '>'))
    {
      String tlocal = local.substring(2).intern();
      Symbol tsymbol = namespace.getSymbol(tlocal);
      
      Expression texp = tr.rewrite(tsymbol, false);
      if ((texp instanceof ReferenceExp)) {
        Declaration decl = ((ReferenceExp)texp).getBinding();
        if ((decl == null) || (decl.getFlag(65536L))) {
          texp = null;
        }
      } else if (!(texp instanceof gnu.expr.QuoteExp)) {
        texp = null; }
      if (texp != null)
        return new gnu.kawa.functions.CurryExp(gnu.kawa.functions.Curry1.makeConverter, gnu.kawa.functions.Convert.cast, new Expression[] { texp });
    }
    return super.checkDefaultBinding(symbol, tr);
  }
}
