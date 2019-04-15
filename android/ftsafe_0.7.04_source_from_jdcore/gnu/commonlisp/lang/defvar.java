package gnu.commonlisp.lang;

import gnu.expr.Declaration;
import gnu.expr.SetExp;
import gnu.lists.Pair;
import kawa.lang.Translator;

public class defvar extends kawa.lang.Syntax
{
  boolean force;
  
  public defvar(boolean force)
  {
    this.force = force;
  }
  

  public boolean scanForDefinitions(Pair st, gnu.expr.ScopeExp defs, Translator tr)
  {
    if (!(st.getCdr() instanceof Pair))
      return super.scanForDefinitions(st, defs, tr);
    Pair p = (Pair)st.getCdr();
    Object name = p.getCar();
    if (((name instanceof String)) || ((name instanceof gnu.mapping.Symbol)))
    {
      Declaration decl = defs.lookup(name, tr.getLanguage(), 1);
      
      if (decl == null)
      {
        decl = new Declaration(name);
        decl.setFlag(268435456L);
        defs.addDeclaration(decl);
        tr.push(decl);
      }
      else {
        tr.error('w', "duplicate declaration for `" + name + "'"); }
      p = Translator.makePair(p, decl, p.getCdr());
      st = Translator.makePair(st, this, p);
      if ((defs instanceof gnu.expr.ModuleExp))
      {
        decl.setCanRead(true);
        decl.setCanWrite(true);
      }
    }
    tr.pushForm(st);
    return true;
  }
  
  public gnu.expr.Expression rewriteForm(Pair form, Translator tr)
  {
    Object obj = form.getCdr();
    Object name = null;
    gnu.expr.Expression value = null;
    Declaration decl = null;
    
    if ((obj instanceof Pair))
    {
      Pair p1 = (Pair)obj;
      if ((p1.getCar() instanceof Declaration))
      {
        decl = (Declaration)p1.getCar();
        name = decl.getSymbol();
        if ((p1.getCdr() instanceof Pair))
        {
          Pair p2 = (Pair)p1.getCdr();
          value = tr.rewrite(p2.getCar());
          if (p2.getCdr() == gnu.lists.LList.Empty) {}



        }
        else if (p1.getCdr() != gnu.lists.LList.Empty) {
          name = null;
        }
      } }
    if (name == null)
      return tr.syntaxError("invalid syntax for " + getName());
    if (value == null)
    {
      if (force) {
        value = CommonLisp.nilExpr;
      } else
        return new gnu.expr.QuoteExp(name);
    }
    SetExp sexp = new SetExp(name, value);
    if (!force)
      sexp.setSetIfUnbound(true);
    sexp.setDefining(true);
    if (decl != null)
    {
      sexp.setBinding(decl);
      if (((context instanceof gnu.expr.ModuleExp)) && (decl.getCanWrite()))
      {
        value = null; }
      decl.noteValue(value);
    }
    return sexp;
  }
}
