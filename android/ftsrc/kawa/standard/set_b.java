package kawa.standard;

import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ReferenceExp;
import gnu.expr.SetExp;
import gnu.lists.Pair;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class set_b extends kawa.lang.Syntax
{
  public static final set_b set = new set_b();
  static { set.setName("set!"); }
  
  public Expression rewriteForm(Pair form, Translator tr)
  {
    Object o1 = form.getCdr();
    SyntaxForm syntax = null;
    while ((o1 instanceof SyntaxForm))
    {
      syntax = (SyntaxForm)o1;
      o1 = syntax.getDatum();
    }
    if (!(o1 instanceof Pair))
      return tr.syntaxError("missing name");
    Pair p1 = (Pair)o1;
    Expression name = tr.rewrite_car(p1, syntax);
    Object o2 = p1.getCdr();
    while ((o2 instanceof SyntaxForm))
    {
      syntax = (SyntaxForm)o2;
      o2 = syntax.getDatum();
    }
    Pair p2;
    if ((!(o2 instanceof Pair)) || ((p2 = (Pair)o2).getCdr() != gnu.lists.LList.Empty))
    {
      return tr.syntaxError("missing or extra arguments to set!"); }
    Pair p2; Expression value = tr.rewrite_car(p2, syntax);
    
    if ((name instanceof ApplyExp))
    {


      ApplyExp aexp = (ApplyExp)name;
      Expression[] args = aexp.getArgs();
      int nargs = args.length;
      int skip = 0;
      Expression func = aexp.getFunction();
      if ((args.length > 0) && ((func instanceof ReferenceExp)) && (((ReferenceExp)func).getBinding() == SchemeCompilation.applyFieldDecl))
      {

        skip = 1;
        nargs--;
        func = args[0];
      }
      Expression[] setterArgs = { func };
      Expression[] xargs = new Expression[nargs + 1];
      System.arraycopy(args, skip, xargs, 0, nargs);
      xargs[nargs] = value;
      Declaration setter = gnu.kawa.functions.CompilationHelpers.setterDecl;
      return new ApplyExp(new ApplyExp(new ReferenceExp(setter), setterArgs), xargs);
    }
    
    if (!(name instanceof ReferenceExp)) {
      return tr.syntaxError("first set! argument is not a variable name");
    }
    ReferenceExp ref = (ReferenceExp)name;
    Declaration decl = ref.getBinding();
    SetExp sexp = new SetExp(ref.getSymbol(), value);
    sexp.setContextDecl(ref.contextDecl());
    if (decl != null)
    {
      decl.setCanWrite(true);
      sexp.setBinding(decl);
      decl = Declaration.followAliases(decl);
      if (decl != null)
        decl.noteValueFromSet(sexp);
      if (decl.getFlag(16384L))
        return tr.syntaxError("constant variable " + decl.getName() + " is set!");
      if ((context != mainLambda) && ((context instanceof gnu.expr.ModuleExp)) && (!decl.getFlag(268435456L)) && (!context.getFlag(2097152)))
      {



        tr.error('w', decl, "imported variable ", " is set!"); }
    }
    return sexp;
  }
  
  public set_b() {}
}
