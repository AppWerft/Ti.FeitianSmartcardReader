package kawa.standard;

import gnu.lists.Pair;
import kawa.lang.Translator;

public class export extends kawa.lang.Syntax
{
  public static final export module_export = new export();
  static { module_export.setName("module-export");
    
    export = new export();
    export.setName("export");
  }
  
  public static final export export;
  public boolean scanForDefinitions(Pair st, gnu.expr.ScopeExp defs, Translator tr) { Object list = st.getCdr();
    Object savePos = tr.pushPositionOf(st);
    try {
      if (!(defs instanceof gnu.expr.ModuleExp)) {
        tr.error('e', "'" + getName() + "' not at module level");
        return false;
      }
      gnu.expr.ModuleExp mexp = (gnu.expr.ModuleExp)defs;
      if (mexp.getFlag(16777216)) {
        tr.error('e', "'export' used follow explicit modules");
        return false;
      }
      mexp.setFlag(32768);
      kawa.lang.SyntaxForm restSyntax = null;
      kawa.lang.SyntaxForm nameSyntax; while (list != gnu.lists.LList.Empty) {
        tr.pushPositionOf(list);
        while ((list instanceof kawa.lang.SyntaxForm)) {
          restSyntax = (kawa.lang.SyntaxForm)list;
          list = restSyntax.getDatum();
        }
        nameSyntax = restSyntax;
        Object symbol; if ((list instanceof Pair)) {
          st = (Pair)list;
          symbol = st.getCar();
          while ((symbol instanceof kawa.lang.SyntaxForm)) {
            nameSyntax = (kawa.lang.SyntaxForm)symbol;
            symbol = nameSyntax.getDatum();
          }
          if ((symbol instanceof String)) {
            String str = (String)symbol;
            if (str.startsWith("namespace:")) {
              tr.error('w', "'namespace:' prefix ignored");
              symbol = str.substring(10).intern();
            }
          }
          symbol = tr.namespaceResolve(symbol);
          if ((symbol instanceof Pair))
          {
            Pair psym = (Pair)symbol;
            Object symcdr;
            Pair psymcdr; Object symcddr; if ((tr.matches(psym.getCar(), "rename")) && (((symcdr = psym.getCdr()) instanceof Pair)) && (((symcddr = (psymcdr = (Pair)symcdr).getCdr()) instanceof Pair)))
            {


              Pair psymcddr = (Pair)symcddr;
              Object symcdddr = psymcddr.getCdr();
              Object name1 = tr.namespaceResolve(psymcdr.getCar());
              Object name2 = tr.namespaceResolve(psymcddr.getCar());
              if ((symcdddr == gnu.lists.LList.Empty) && ((name1 instanceof gnu.mapping.Symbol)) && ((name2 instanceof gnu.mapping.Symbol)))
              {

                gnu.expr.Declaration decl1 = defs.getNoDefine(name1);
                if (decl1.getFlag(512L))
                  Translator.setLine(decl1, st);
                decl1.setFlag(524288L);
                

                gnu.expr.Declaration decl2 = tr.define(null, nameSyntax, defs);
                decl2.setIndirectBinding(true);
                decl2.setAlias(true);
                decl2.setFlag(536871936L);
                
                gnu.expr.ReferenceExp ref1 = new gnu.expr.ReferenceExp(decl1);
                ref1.setDontDereference(true);
                gnu.expr.SetExp sexp = new gnu.expr.SetExp(name2, ref1);
                sexp.setBinding(decl2);
                tr.setLineOf(sexp);
                decl2.noteValueFromSet(sexp);
                sexp.setDefining(true);
                list = st.getCdr();
                tr.pushForm(sexp);
                continue;
              }
            }
          }
          if (((symbol instanceof String)) || ((symbol instanceof gnu.mapping.Symbol)))
          {
            if (nameSyntax != null) {}
            


            gnu.expr.Declaration decl = defs.getNoDefine(symbol);
            if (decl.getFlag(512L))
              Translator.setLine(decl, st);
            decl.setFlag(1024L);
            list = st.getCdr();
            continue;
          }
        }
        tr.error('e', "invalid syntax in '" + getName() + '\'');
        return 0;
      }
      return 1;
    } finally {
      tr.popPositionOf(savePos);
    }
  }
  
  public gnu.expr.Expression rewriteForm(Pair form, Translator tr) {
    return tr.syntaxError(getName() + " is only allowed in a <body>");
  }
  
  public export() {}
}
