package kawa.lang;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.lists.Consumer;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import java.io.ObjectOutput;

public class Macro extends Syntax implements gnu.kawa.format.Printable, java.io.Externalizable
{
  public Object expander;
  Object instance;
  public static final int HYGIENIC = 1;
  public static final int SKIP_SCAN_FORM = 2;
  private int flags = 1;
  
  public final void setFlags(int flags) { this.flags = flags; }
  public final boolean isHygienic() { return (flags & 0x1) != 0; }
  
  public final void setHygienic(boolean hygienic) { if (hygienic) {
      flags |= 0x1;
    } else {
      flags &= 0xFFFFFFFE;
    }
  }
  
  public ScopeExp getCapturedScope()
  {
    if (capturedScope == null) {
      if ((instance instanceof gnu.expr.ModuleExp)) {
        capturedScope = ((gnu.expr.ModuleExp)instance);
      } else if ((instance instanceof String)) {
        capturedScope = gnu.expr.ModuleInfo.findWithClassName((String)instance).getModuleExp();
      } else if (instance != null)
        capturedScope = gnu.expr.ModuleInfo.findFromInstance(instance).getModuleExp();
    }
    return capturedScope;
  }
  
  public void setCapturedScope(ScopeExp scope) {
    capturedScope = scope;
  }
  
  public static Macro make(Declaration decl) {
    Macro mac = new Macro(decl.getSymbol());
    decl.setSyntax();
    capturedScope = context;
    return mac;
  }
  
  public static Macro makeNonHygienic(Object name, Procedure expander) {
    Macro mac = new Macro(name, expander);
    mac.setHygienic(false);
    return mac;
  }
  
  public static Macro makeNonHygienic(Object name, Procedure expander, Object instance)
  {
    Macro mac = new Macro(name, expander);
    mac.setHygienic(false);
    instance = instance;
    return mac;
  }
  
  public static Macro makeSkipScanForm(Object name, Procedure expander, Object instance)
  {
    Macro mac = new Macro(name, expander);
    flags = 3;
    instance = instance;
    return mac;
  }
  
  public static Macro make(Object name, Procedure expander) {
    return new Macro(name, expander);
  }
  
  public static Macro make(Object name, Procedure expander, Object instance)
  {
    Macro mac = new Macro(name, expander);
    instance = instance;
    return mac;
  }
  

  public Macro() {}
  
  public Macro(Macro old)
  {
    name = name;
    expander = expander;
    flags = flags;
  }
  
  public Macro(Object name, Procedure expander) {
    super(name);
    this.expander = ((expander instanceof Expression) ? expander : new gnu.expr.QuoteExp(expander));
  }
  
  public Macro(Object name)
  {
    super(name);
  }
  
  public Expression rewriteForm(Pair form, Translator tr) {
    return tr.rewrite(expand(form, tr), 'N');
  }
  
  public String toString() {
    return "#<macro " + getName() + '>';
  }
  
  public void print(Consumer out) {
    out.write("#<macro ");
    out.write(getName());
    out.write(62);
  }
  
  public Object rewriteIfNeeded() {
    Object exp = expander;
    if ((exp instanceof gnu.expr.LangExp)) {
      Object[] lval = (Object[])((gnu.expr.LangExp)exp).getLangValue();
      Object p = lval[0];
      Translator xtr = (Translator)lval[1];
      ScopeExp scope = (ScopeExp)lval[2];
      Macro savedMacro = currentMacroDefinition;
      gnu.expr.Compilation savedComp = gnu.expr.Compilation.getCurrent();
      currentMacroDefinition = this;
      gnu.expr.Compilation.setCurrent(xtr);
      
      ScopeExp savedScope = xtr.setPushCurrentScope(scope);
      Expression rule;
      try { rule = xtr.rewrite_car((Pair)p, false);
      } finally {
        xtr.setPopCurrentScope(savedScope);
        currentMacroDefinition = savedMacro;
        gnu.expr.Compilation.setCurrent(savedComp);
      }
      if ((rule instanceof gnu.expr.LambdaExp))
        ((gnu.expr.LambdaExp)rule).setFlag(256);
      expander = (exp = rule);
    }
    return exp;
  }
  
  public Object expand(Object form, Translator tr) {
    Object savedMacroMark = currentMacroMark;
    currentMacroMark = new Object();
    try
    {
      Object exp = expander;
      Procedure pr; Procedure pr; if (((exp instanceof Procedure)) && (!(exp instanceof Expression))) {
        pr = (Procedure)exp;
      } else {
        exp = rewriteIfNeeded();
        if (!(exp instanceof Expression)) {
          Macro savedMacro = currentMacroDefinition;
          currentMacroDefinition = this;
          try {
            exp = tr.rewrite(exp);
          }
          finally {}
        }
        












        pr = (Procedure)((Expression)exp).eval(tr.getGlobalEnvironment());
      }
      
      Object result;
      if (!isHygienic()) {
        form = Quote.quote(form, tr);
        int nargs = Translator.listLength(form);
        if (nargs <= 0)
          return tr.syntaxError("invalid macro argument list to " + this);
        Object[] args = new Object[nargs - 1];
        for (int i = 0; i < nargs; i++) {
          Pair pair = (Pair)form;
          if (i > 0)
            args[(i - 1)] = pair.getCar();
          form = pair.getCdr();
        }
        result = pr.applyN(args);
      }
      else {
        result = pr.apply1(form); }
      Object p; if (((form instanceof gnu.lists.PairWithPosition)) && ((result instanceof Pair)) && (!(result instanceof gnu.lists.PairWithPosition)))
      {
        p = (Pair)result;
        result = new gnu.lists.PairWithPosition((gnu.lists.PairWithPosition)form, ((Pair)p).getCar(), ((Pair)p).getCdr());
      }
      
      return result;
    } catch (Throwable ex) { Object result;
      String msg = "evaluating syntax transformer '" + getName() + "' threw " + ex;
      
      tr.getMessages().error('e', msg, ex);
      return new gnu.expr.ErrorExp(msg);
    } finally {
      currentMacroMark = savedMacroMark;
    }
  }
  
  public void scanForm(Pair st, ScopeExp defs, Translator tr) {
    if ((flags & 0x2) != 0) {
      super.scanForm(st, defs, tr);
      return;
    }
    String save_filename = tr.getFileName();
    int save_line = tr.getLineNumber();
    int save_column = tr.getColumnNumber();
    Syntax saveSyntax = currentSyntax;
    try {
      tr.setLine(st);
      currentSyntax = this;
      Object x = expand(st, tr);
      tr.scanForm(x, defs);
    } finally {
      tr.setLine(save_filename, save_line, save_column);
      currentSyntax = saveSyntax;
    }
  }
  

  ScopeExp capturedScope;
  public void writeExternal(ObjectOutput out)
    throws java.io.IOException
  {
    out.writeObject(getName());
    out.writeObject(((gnu.expr.QuoteExp)expander).getValue());
  }
  
  public void readExternal(java.io.ObjectInput in) throws java.io.IOException, ClassNotFoundException
  {
    setName((String)in.readObject());
    expander = new gnu.expr.QuoteExp(in.readObject());
  }
}
