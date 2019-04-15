package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.PrimProcedure;
import gnu.expr.SetExp;
import gnu.lists.Pair;
import kawa.lang.Macro;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class define_syntax extends kawa.lang.Syntax
{
  int flags;
  public static final define_syntax define_macro = new define_syntax("%define-macro", false);
  

  public static final define_syntax define_syntax = new define_syntax("%define-syntax", true);
  

  public static final define_syntax define_rewrite_syntax = new define_syntax("define-rewrite-syntax", 3);
  
  public define_syntax()
  {
    flags = 1;
  }
  
  public define_syntax(Object name, int flags) {
    super(name);
    this.flags = flags;
  }
  
  public define_syntax(Object name, boolean hygienic) {
    this(name, hygienic ? 1 : 0);
  }
  
  static gnu.bytecode.ClassType typeMacro = gnu.bytecode.ClassType.make("kawa.lang.Macro");
  static PrimProcedure makeHygienic = new PrimProcedure(typeMacro.getDeclaredMethod("make", 3));
  
  static PrimProcedure makeNonHygienic = new PrimProcedure(typeMacro.getDeclaredMethod("makeNonHygienic", 3));
  
  static PrimProcedure makeSkipScanForm = new PrimProcedure(typeMacro.getDeclaredMethod("makeSkipScanForm", 3));
  
  static PrimProcedure setCapturedScope = new PrimProcedure(typeMacro.getDeclaredMethod("setCapturedScope", 1));
  
  static {
    makeHygienic.setSideEffectFree();
    makeNonHygienic.setSideEffectFree();
    makeSkipScanForm.setSideEffectFree();
  }
  
  public void scanForm(Pair st, gnu.expr.ScopeExp defs, Translator tr) {
    SyntaxForm syntax = null;
    Object st_cdr = st.getCdr();
    while ((st_cdr instanceof SyntaxForm)) {
      syntax = (SyntaxForm)st_cdr;
      st_cdr = syntax.getDatum();
    }
    Object p = st_cdr;
    
    if ((p instanceof Pair)) {
      Pair pp = (Pair)p;
      Object name = pp.getCar();
      p = pp.getCdr();
    }
    else {
      name = null; }
    SyntaxForm nameSyntax = syntax;
    while ((name instanceof SyntaxForm)) {
      nameSyntax = (SyntaxForm)name;
      name = nameSyntax.getDatum();
    }
    Object name = tr.namespaceResolve(name);
    if (!(name instanceof gnu.mapping.Symbol)) {
      tr.pushForm(tr.syntaxError("missing macro name for " + Translator.safeCar(st)));
      return;
    }
    if ((p == null) || (Translator.safeCdr(p) != gnu.lists.LList.Empty)) {
      tr.pushForm(tr.syntaxError("invalid syntax for " + getName()));
      return;
    }
    
    Declaration decl = tr.define(name, nameSyntax, defs);
    decl.setType(typeMacro);
    tr.push(decl);
    
    Macro savedMacro = currentMacroDefinition;
    Macro macro = Macro.make(decl);
    macro.setFlags(flags);
    
    gnu.expr.ScopeExp scope = syntax != null ? syntax.getScope() : tr.currentScope();
    Expression rule = new gnu.expr.LangExp(new Object[] { p, tr, scope });
    expander = rule;
    



    rule = new gnu.expr.QuoteExp(macro);
    decl.noteValue(rule);
    decl.setProcedureDecl(true);
    
    if ((context instanceof gnu.expr.ModuleExp)) {
      SetExp result = new SetExp(decl, rule);
      result.setDefining(true);
      if (tr.getLanguage().hasSeparateFunctionNamespace())
        result.setFuncDef(true);
      Object ret = Translator.makePair(st, this, Translator.makePair(st, result, gnu.lists.LList.Empty));
      
      tr.pushForm(ret);
      
      if (immediate) {
        Expression[] args = { new gnu.expr.ReferenceExp(decl), new gnu.expr.QuoteExp(defs) };
        
        tr.pushForm(new gnu.expr.ApplyExp(setCapturedScope, args));
      }
    } else {
      macro.rewriteIfNeeded();
    }
  }
  
  public Expression rewriteForm(Pair form, Translator tr) {
    if ((form instanceof Pair)) {
      Pair p1 = (Pair)form.getCdr();
      Object x1 = p1.getCar();
      if ((x1 instanceof SetExp)) {
        SetExp sexp = (SetExp)x1;
        Object val = sexp.getNewValue().valueIfConstant();
        Declaration decl = sexp.getBinding();
        Object name = decl.getSymbol();
        gnu.expr.ScopeExp defs = decl.getContext();
        if ((val instanceof Macro)) {
          Macro macro = (Macro)val;
          macro.rewriteIfNeeded();
          Expression rule = (Expression)expander;
          gnu.mapping.Procedure makeMacroProc = (flags & 0x1) != 0 ? makeHygienic : (flags & 0x2) != 0 ? makeSkipScanForm : makeNonHygienic;
          


          if ((defs instanceof gnu.expr.ModuleExp)) {
            rule = new gnu.expr.ApplyExp(makeMacroProc, new Expression[] { new gnu.expr.QuoteExp(name), rule, gnu.expr.ThisExp.makeGivingContext(defs) });
          }
          

          sexp.setNewValue(rule);
          decl.setValue(rule);
        }
        return (SetExp)x1;
      }
    }
    return tr.syntaxError("define-syntax not in a body");
  }
}
