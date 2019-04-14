package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LetExp;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleEnvironment;
import gnu.mapping.Symbol;
import java.util.ArrayList;
import java.util.Stack;
import kawa.lang.BindDecls;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class let extends kawa.lang.Syntax
{
  public static final let let = new let("let", false);
  

  protected boolean settingProcedures;
  


  public let(String name, boolean settingProcedures)
  {
    setName(name);
    this.settingProcedures = settingProcedures;
  }
  
  public Expression rewrite(Object obj, final Translator tr)
  {
    ArrayList<Declaration> decls = new ArrayList();
    final Stack<Declaration> renamedAliases = new Stack();
    
    final SimpleEnvironment dupenv = new SimpleEnvironment();
    final LetExp let = new LetExp();
    
    BindDecls bindDecls = new BindDecls()
    {

      public Declaration define(Symbol name, SyntaxForm nameSyntax, ScopeExp defs, Translator comp)
      {
        ScopeExp templateScope = nameSyntax == null ? null : nameSyntax.getScope();
        
        Declaration decl = new Declaration(name);
        Object old = dupenv.get(name, templateScope, null);
        if (old != null) {
          ScopeExp.duplicateDeclarationError((Declaration)old, decl, tr);
        }
        dupenv.put(name, templateScope, decl);
        let.add(decl);
        decl.setFlag(262144L);
        if (templateScope != null) {
          renamedAliases.push(tr.makeRenamedAlias(decl, templateScope));
        }
        
        return decl;
      }
    };
    allowShadowing = true;
    makeConstant = false;
    
    if (!(obj instanceof Pair))
      return tr.syntaxError("missing " + getName() + " arguments");
    Pair pair = (Pair)obj;
    Object bindings = pair.getCar();
    Object body = pair.getCdr();
    

    while (bindings != LList.Empty)
    {
      if (!(bindings instanceof Pair))
        return tr.syntaxError("bindings not a proper list");
      Pair bind_pair = (Pair)bindings;
      Object bind_pair_car = bind_pair.getCar();
      if (!(bind_pair_car instanceof Pair)) {
        return tr.syntaxError(getName() + " binding is not a pair:" + bind_pair_car);
      }
      Pair binding = (Pair)bind_pair_car;
      Object saveLoc1 = tr.pushPositionOf(binding);
      Object[] r = bindDecls.parsePatternCar(binding, 0, let, tr);
      Object binding_cdr = r[0];
      Declaration decl = (Declaration)r[1];
      maybeSetProcedure(decl);
      
      if ((binding_cdr instanceof Pair)) {
        Pair init = (Pair)binding_cdr;
        binding_cdr = init.getCdr();
        
        Expression initExp = tr.rewrite_car(init, null);
        decl.setInitValue(initExp);
        if (initExp != gnu.expr.QuoteExp.undefined_exp) {
          decl.noteValueFromLet(let);
        }
        if (init.getCdr() != LList.Empty) {
          Object saveLoc2 = tr.pushPositionOf(init.getCdr());
          tr.error('e', "junk after initializer");
          tr.popPositionOf(saveLoc2);
        }
      } else {
        tr.error('e', "let has no initializer");
      }
      tr.popPositionOf(saveLoc1);
      bindings = bind_pair.getCdr();
    }
    
    int renamedAliasesCount = renamedAliases.size();
    int i = renamedAliasesCount; for (;;) { i--; if (i < 0) break;
      tr.pushRenamedAlias((Declaration)renamedAliases.pop());
    }
    tr.push(let);
    try {
      let.setBody(tr.rewrite_body(body));
    } finally {
      tr.pop(let);
      tr.popRenamedAlias(renamedAliasesCount);
    }
    return let;
  }
  








  protected void maybeSetProcedure(Declaration decl)
  {
    if (settingProcedures) {
      decl.setProcedureDecl(true);
    }
  }
}
