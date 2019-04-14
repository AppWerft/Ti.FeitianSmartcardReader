package kawa.standard;

import gnu.expr.SetExp;
import gnu.lists.Pair;

public class MatchDef extends kawa.lang.Syntax
{
  public MatchDef() {}
  
  public static final MatchDef matchDef = new MatchDef();
  
  public void scanForm(Pair st, gnu.expr.ScopeExp defs, kawa.lang.Translator tr) {
    Object arg = st.getCdr();
    if (!(arg instanceof Pair)) {
      tr.error('e', "missing pattern following '!'");
      return;
    }
    Pair p1 = (Pair)arg;
    SetExp sexp = new SetExp(null, null);
    st = kawa.lang.Translator.makePair(st, this, sexp);
    
    tr.pushForm(st);
    Object[] r = kawa.lang.BindDecls.instance.parsePatternCar(p1, 0, defs, tr);
    Object rest = r[0];
    gnu.expr.Declaration decl = (gnu.expr.Declaration)r[1];
    sexp.setBinding(decl);
    gnu.expr.Expression init;
    gnu.expr.Expression init; if ((rest instanceof Pair)) {
      Pair prest = (Pair)rest;
      if (prest.getCdr() != gnu.lists.LList.Empty) {
        tr.error('e', "junk after initializer");
      }
      init = new gnu.expr.LangExp(rest);
    }
    else {
      tr.error('e', "missing initializer");
      init = gnu.expr.QuoteExp.nullExp;
    }
    sexp.setNewValue(init);
  }
  
  public gnu.expr.Expression rewriteForm(Pair form, kawa.lang.Translator tr) {
    Object arg = form.getCdr();
    if (!(arg instanceof SetExp))
      return tr.syntaxError("! definition is only allowed in a <body>");
    SetExp sexp = (SetExp)arg;
    
    gnu.expr.Declaration decl = sexp.getBinding();
    gnu.expr.Expression init = sexp.getNewValue();
    if ((init instanceof gnu.expr.LangExp)) {
      init = tr.rewrite_car((Pair)((gnu.expr.LangExp)init).getLangValue(), false);
      sexp.setNewValue(init);
    }
    decl.noteValueFromSet(sexp);
    
    sexp.setDefining(true);
    return sexp;
  }
}
