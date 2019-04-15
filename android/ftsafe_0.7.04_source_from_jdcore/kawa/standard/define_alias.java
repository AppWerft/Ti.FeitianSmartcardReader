package kawa.standard;

import gnu.expr.Declaration;
import gnu.lists.Pair;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class define_alias extends kawa.lang.Syntax
{
  public static final define_alias define_alias = new define_alias();
  public static final define_alias define_private_alias = new define_alias();
  
  static {
    define_alias.setName("define-alias");
    
    define_private_alias.setName("define-private-alias");
    define_private_aliasmakePrivate = true;
  }
  
  private boolean makePrivate = false;
  
  public void scanForm(Pair st, gnu.expr.ScopeExp defs, Translator tr) {
    Object formCdr = st.getCdr();
    SyntaxForm formSyntax = null;
    while ((formCdr instanceof SyntaxForm)) {
      formSyntax = (SyntaxForm)formCdr;
      formCdr = formSyntax.getDatum();
    }
    if ((formCdr instanceof Pair)) {
      Pair p1 = (Pair)formCdr;
      SyntaxForm nameSyntax = formSyntax;
      Object name = p1.getCar();
      while ((name instanceof SyntaxForm)) {
        nameSyntax = (SyntaxForm)name;
        name = nameSyntax.getDatum();
      }
      Object f2 = p1.getCdr();
      while ((f2 instanceof SyntaxForm)) {
        formSyntax = (SyntaxForm)f2;
        f2 = formSyntax.getDatum();
      }
      
      if ((((name instanceof String)) || ((name instanceof gnu.mapping.Symbol))) && ((f2 instanceof Pair)) && (((Pair)f2).getCdr() == gnu.lists.LList.Empty))
      {

        Declaration decl = tr.define(name, nameSyntax, defs);
        decl.setIndirectBinding(true);
        decl.setAlias(true);
        if (makePrivate) {
          decl.setFlag(16777216L);
          decl.setPrivate(true);
        }
        
        if (formSyntax != null)
          f2 = kawa.lang.SyntaxForms.makeForm(f2, formSyntax.getScope());
        tr.pushForm(Translator.makePair(st, this, Translator.makePair(p1, decl, f2)));
        
        return;
      }
    }
    tr.error('e', "invalid syntax for define-alias");
  }
  
  public gnu.expr.Expression rewriteForm(Pair form, Translator tr) {
    Object f1 = form.getCdr();
    if ((f1 instanceof Pair)) {
      Pair p1 = (Pair)f1;
      Object f2 = p1.getCar();
      if ((f2 instanceof Declaration)) {
        Declaration decl = (Declaration)f2;
        gnu.expr.Expression arg = tr.rewrite_car((Pair)p1.getCdr(), false);
        if ((arg instanceof gnu.expr.ReferenceExp)) {
          gnu.expr.ReferenceExp rarg = (gnu.expr.ReferenceExp)arg;
          Declaration d = Declaration.followAliases(rarg.getBinding());
          gnu.expr.Expression dval;
          if ((d != null) && ((((dval = d.getValue()) instanceof gnu.expr.ClassExp)) || ((dval instanceof gnu.expr.ModuleExp))))
          {

            decl.setIndirectBinding(false);
            decl.setFlag(16384L);
          }
          else {
            rarg.setDontDereference(true);
          }
        } else { if (!(arg instanceof gnu.expr.QuoteExp))
            arg = location.rewrite(arg, tr);
          if ((arg instanceof gnu.expr.QuoteExp)) {
            decl.setIndirectBinding(false);
            decl.setFlag(16384L);
          }
        }
        decl.setFlag(536870912L);
        tr.mustCompileHere();
        tr.push(decl);
        gnu.expr.SetExp sexp = new gnu.expr.SetExp(decl, arg);
        tr.setLineOf(sexp);
        decl.noteValueFromSet(sexp);
        sexp.setDefining(true);
        return sexp;
      }
    }
    return tr.syntaxError(getName() + " is only allowed in a <body>");
  }
  
  public define_alias() {}
}
