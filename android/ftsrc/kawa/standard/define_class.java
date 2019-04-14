package kawa.standard;

import gnu.expr.Declaration;
import gnu.lists.Pair;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class define_class extends kawa.lang.Syntax
{
  public static final define_class define_class = new define_class("define-class", false);
  
  public static final define_class define_simple_class = new define_class("define-simple-class", true);
  
  boolean isSimple;
  
  object objectSyntax;
  
  define_class(object objectSyntax, boolean isSimple)
  {
    this.objectSyntax = objectSyntax;
    this.isSimple = isSimple;
  }
  
  define_class(String name, boolean isSimple)
  {
    super(name);
    objectSyntax = object.objectSyntax;
    this.isSimple = isSimple;
  }
  

  public boolean scanForDefinitions(Pair st, gnu.expr.ScopeExp defs, Translator tr)
  {
    Object st_cdr = st.getCdr();
    SyntaxForm nameSyntax = null;
    while ((st_cdr instanceof SyntaxForm))
    {
      nameSyntax = (SyntaxForm)st_cdr;
      st_cdr = nameSyntax.getDatum();
    }
    Object name;
    if ((st_cdr instanceof Pair))
    {
      Object name = ((Pair)st_cdr).getCar();
      while ((name instanceof SyntaxForm))
      {
        nameSyntax = (SyntaxForm)name;
        name = nameSyntax.getDatum();
      }
      name = tr.namespaceResolve(name);
    }
    else {
      name = null; }
    if ((!(name instanceof String)) && (!(name instanceof gnu.mapping.Symbol)))
    {
      tr.error('e', "missing class name");
      return false;
    }
    Pair p = (Pair)st_cdr;
    Declaration decl = tr.define(name, nameSyntax, defs);
    if ((p instanceof gnu.lists.PairWithPosition))
      decl.setLocation((gnu.lists.PairWithPosition)p);
    gnu.expr.ClassExp oexp = new gnu.expr.ClassExp(isSimple, null);
    decl.noteValue(oexp);
    decl.setFlag(536887296L);
    decl.setType(isSimple ? gnu.expr.Compilation.typeClass : gnu.expr.Compilation.typeClassType);
    tr.mustCompileHere();
    
    String cname = (name instanceof gnu.mapping.Symbol) ? ((gnu.mapping.Symbol)name).getName() : name.toString();
    
    int nlen = cname.length();
    if ((nlen > 2) && (cname.charAt(0) == '<') && (cname.charAt(nlen - 1) == '>'))
      cname = cname.substring(1, nlen - 1);
    oexp.setName(cname);
    
    Object members = p.getCdr();
    while ((members instanceof SyntaxForm))
    {
      nameSyntax = (SyntaxForm)members;
      members = nameSyntax.getDatum();
    }
    if (!(members instanceof Pair))
    {
      tr.error('e', "missing class members");
      return false;
    }
    p = (Pair)members;
    gnu.expr.ScopeExp save_scope = tr.currentScope();
    if (nameSyntax != null)
      tr.setCurrentScope(nameSyntax.getScope());
    Object[] saved = objectSyntax.scanClassDef(p, oexp, tr);
    if (nameSyntax != null)
      tr.setCurrentScope(save_scope);
    gnu.bytecode.ClassType mtype = tr.getModule().classFor(tr);
    String clname = oexp.getClassName(tr);
    String mname = mtype.getName();
    gnu.bytecode.ClassType ctype;
    if (clname.equals(mname))
    {
      gnu.bytecode.ClassType ctype = mtype;
      tr.getModule().setFlag(8388608);
    }
    else {
      ctype = new gnu.bytecode.ClassType(clname); }
    oexp.setClassType(ctype);
    oexp.createFields(tr);
    if (saved == null)
      return false;
    st = Translator.makePair(st, this, Translator.makePair(p, decl, saved));
    tr.pushForm(st);
    return true;
  }
  
  public gnu.expr.Expression rewriteForm(Pair form, Translator tr)
  {
    Object form_cdr = form.getCdr();
    if ((form_cdr instanceof Pair))
    {
      form = (Pair)form_cdr;
      Object form_car = form.getCar();
      if ((form_car instanceof Declaration))
      {
        Declaration decl = (Declaration)form_car;
        gnu.expr.ClassExp oexp = (gnu.expr.ClassExp)decl.getValue();
        objectSyntax.rewriteClassDef((Object[])form.getCdr(), tr);
        gnu.expr.SetExp sexp = new gnu.expr.SetExp(decl, oexp);
        sexp.setDefining(true);
        return sexp;
      }
    }
    return tr.syntaxError(getName() + " can only be used in <body>");
  }
}
