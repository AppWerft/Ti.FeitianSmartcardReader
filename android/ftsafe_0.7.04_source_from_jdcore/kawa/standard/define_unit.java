package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import gnu.math.BaseUnit;
import gnu.math.Quantity;
import gnu.math.Unit;
import kawa.lang.Translator;

public class define_unit extends kawa.lang.Syntax
{
  public static final define_unit define_unit = new define_unit(false);
  static { define_unit.setName("define-unit");
    define_base_unit = new define_unit(true);
    define_base_unit.setName("define-base-unit");
  }
  
  public static final define_unit define_base_unit;
  boolean base;
  public define_unit(boolean base)
  {
    this.base = base;
  }
  

  public boolean scanForDefinitions(Pair st, gnu.expr.ScopeExp defs, Translator tr)
  {
    if ((st.getCdr() instanceof Pair))
    {
      Pair p = (Pair)st.getCdr();
      Object q = p.getCar();
      if ((q instanceof gnu.mapping.SimpleSymbol))
      {
        String name = q.toString();
        Symbol sym = gnu.kawa.lispexpr.LispLanguage.unitNamespace.getSymbol(name);
        Declaration decl = defs.getDefine(sym, tr);
        tr.push(decl);
        Translator.setLine(decl, p);
        decl.setFlag(16384L);
        if ((defs instanceof gnu.expr.ModuleExp))
          decl.setCanRead(true);
        Unit unit = null;
        if ((base) && (p.getCdr() == gnu.lists.LList.Empty)) {
          unit = BaseUnit.make(name, (String)null);
        } else if ((p.getCdr() instanceof Pair))
        {
          Object v = ((Pair)p.getCdr()).getCar();
          if ((base) && ((v instanceof CharSequence)))
          {





            unit = BaseUnit.make(name, v.toString());
          } else if ((!base) && ((v instanceof Quantity)))
            unit = Unit.make(name, (Quantity)v);
        }
        if (unit != null)
          decl.noteValue(new QuoteExp(unit));
        p = Translator.makePair(p, decl, p.getCdr());
        st = Translator.makePair(st, this, p);
        tr.pushForm(st);
        return true;
      }
    }
    tr.error('e', "missing name in define-unit");
    return false;
  }
  
  public Expression rewriteForm(Pair form, Translator tr)
  {
    Object obj = form.getCdr();
    Expression value = null;
    
    Pair p1;
    if ((!(obj instanceof Pair)) || (!((p1 = (Pair)obj).getCar() instanceof Declaration)))
    {
      return tr.syntaxError("invalid syntax for " + getName()); }
    Pair p1; Declaration decl = (Declaration)p1.getCar();
    Symbol symbol = (Symbol)decl.getSymbol();
    String unit = symbol.getLocalPart();
    gnu.bytecode.ClassType unitType = gnu.bytecode.ClassType.make("gnu.math.Unit");
    decl.setType(unitType);
    if ((!((value = decl.getValue()) instanceof QuoteExp)) || (!(((QuoteExp)value).getValue() instanceof Unit)))
    {

      if (base)
      {
        String dimension = null;
        if (p1.getCdr() != gnu.lists.LList.Empty)
        {
          dimension = ((Pair)p1.getCdr()).getCar().toString();
        }
        BaseUnit bunit = BaseUnit.make(unit, dimension);
        value = new QuoteExp(bunit);
      }
      else
      {
        if (!(p1.getCdr() instanceof Pair))
          return tr.syntaxError("missing value for define-unit");
        Pair p2 = (Pair)p1.getCdr();
        value = tr.rewrite(p2.getCar());
        Object quantity;
        if (((value instanceof QuoteExp)) && (((quantity = ((QuoteExp)value).getValue()) instanceof Quantity)))
        {

          value = new QuoteExp(Unit.make(unit, (Quantity)quantity));
        }
        else
        {
          Expression[] args = new Expression[2];
          args[0] = new QuoteExp(unit);
          args[1] = value;
          value = gnu.kawa.reflect.Invoke.makeInvokeStatic(unitType, "make", args);
        }
      }
    }
    gnu.expr.SetExp sexp = new gnu.expr.SetExp(decl, value);
    sexp.setDefining(true);
    decl.noteValue(value);
    return sexp;
  }
}
