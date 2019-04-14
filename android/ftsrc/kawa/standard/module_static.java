package kawa.standard;

import gnu.expr.ModuleExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Translator;

public class module_static extends kawa.lang.Syntax
{
  public static final module_static module_static = new module_static();
  static { module_static.setName("module-static"); }
  

  public boolean scanForDefinitions(Pair st, gnu.expr.ScopeExp defs, Translator tr)
  {
    Object list = st.getCdr();
    if (!(defs instanceof ModuleExp))
    {
      tr.error('e', "'" + getName() + "' not at module level");
      return true;
    }
    ModuleExp mexp = (ModuleExp)defs;
    if (((list instanceof Pair)) && ((st = (Pair)list).getCdr() == LList.Empty) && ((st.getCar() instanceof Boolean)))
    {


      if (st.getCar() == Boolean.FALSE) {
        mexp.setFlag(131072);
      } else {
        mexp.setFlag(65536);
      }
    } else if (((list instanceof Pair)) && ((st = (Pair)list).getCdr() == LList.Empty) && ((st.getCar() instanceof Pair)) && (tr.matches((st = (Pair)st.getCar()).getCar(), "quote")))
    {



      Object cdr = st.getCdr();
      if ((cdr != LList.Empty) && (((st = (Pair)cdr).getCar() instanceof gnu.mapping.SimpleSymbol)) && (st.getCar().toString() == "init-run"))
      {



        mexp.setFlag(65536);
        mexp.setFlag(524288);
        if (tr.generateMainMethod()) {
          tr.error('e', "init-run option incompatible with --main");
        }
      }
      else {
        tr.error('e', "invalid quoted symbol for '" + getName() + '\'');
        return false;
      }
    }
    else
    {
      mexp.setFlag(131072);
      

      while (list != LList.Empty)
      {
        if ((!(list instanceof Pair)) || (!((st = (Pair)list).getCar() instanceof gnu.mapping.Symbol)))
        {

          tr.error('e', "invalid syntax in '" + getName() + '\'');
          return false;
        }
        gnu.mapping.Symbol symbol = (gnu.mapping.Symbol)st.getCar();
        gnu.expr.Declaration decl = defs.getNoDefine(symbol);
        if (decl.getFlag(512L))
          Translator.setLine(decl, st);
        decl.setFlag(2048L);
        list = st.getCdr();
      }
    }
    if ((mexp.getFlag(131072)) && (mexp.getFlag(65536)))
    {
      tr.error('e', "inconsistent module-static specifiers"); }
    return true;
  }
  
  public gnu.expr.Expression rewriteForm(Pair form, Translator tr)
  {
    return null;
  }
  
  public module_static() {}
}
