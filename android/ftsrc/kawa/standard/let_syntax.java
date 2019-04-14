package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.LetExp;
import gnu.lists.Pair;
import java.util.Stack;
import kawa.lang.Macro;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class let_syntax extends kawa.lang.Syntax
{
  public static final let_syntax let_syntax = new let_syntax(false, "let-syntax");
  
  public static final let_syntax letrec_syntax = new let_syntax(true, "letrec-syntax");
  
  boolean recursive;
  

  public let_syntax(boolean recursive, String name)
  {
    super(name);
    this.recursive = recursive;
  }
  
  public gnu.expr.Expression rewrite(Object obj, Translator tr)
  {
    if (!(obj instanceof Pair))
      return tr.syntaxError("missing let-syntax arguments");
    Pair pair = (Pair)obj;
    Object bindings = pair.getCar();
    Object body = pair.getCdr();
    int decl_count = Translator.listLength(bindings);
    if (decl_count < 0)
      return tr.syntaxError("bindings not a proper list");
    Stack renamedAliases = null;
    int renamedAliasesCount = 0;
    Declaration[] decls = new Declaration[decl_count];
    Macro[] macros = new Macro[decl_count];
    Pair[] transformers = new Pair[decl_count];
    SyntaxForm[] trSyntax = new SyntaxForm[decl_count];
    LetExp let = new LetExp();
    SyntaxForm listSyntax = null;
    for (int i = 0; i < decl_count; i++)
    {
      while ((bindings instanceof SyntaxForm))
      {
        listSyntax = (SyntaxForm)bindings;
        bindings = listSyntax.getDatum();
      }
      SyntaxForm bindingSyntax = listSyntax;
      Pair bind_pair = (Pair)bindings;
      Object bind_pair_car = bind_pair.getCar();
      if ((bind_pair_car instanceof SyntaxForm))
      {
        bindingSyntax = (SyntaxForm)bind_pair_car;
        bind_pair_car = bindingSyntax.getDatum();
      }
      if (!(bind_pair_car instanceof Pair))
        return tr.syntaxError(getName() + " binding is not a pair");
      Pair binding = (Pair)bind_pair_car;
      Object name = binding.getCar();
      SyntaxForm nameSyntax = bindingSyntax;
      while ((name instanceof SyntaxForm))
      {
        nameSyntax = (SyntaxForm)name;
        name = nameSyntax.getDatum();
      }
      if ((!(name instanceof String)) && (!(name instanceof gnu.mapping.Symbol)))
        return tr.syntaxError("variable in " + getName() + " binding is not a symbol");
      Object binding_cdr = binding.getCdr();
      while ((binding_cdr instanceof SyntaxForm))
      {
        bindingSyntax = (SyntaxForm)binding_cdr;
        binding_cdr = bindingSyntax.getDatum();
      }
      if (!(binding_cdr instanceof Pair))
        return tr.syntaxError(getName() + " has no value for '" + name + "'");
      binding = (Pair)binding_cdr;
      if (binding.getCdr() != gnu.lists.LList.Empty)
        return tr.syntaxError("let binding for '" + name + "' is improper list");
      Declaration decl = new Declaration(name);
      Macro macro = Macro.make(decl);
      macros[i] = macro;
      transformers[i] = binding;
      trSyntax[i] = bindingSyntax;
      let.addDeclaration(decl);
      gnu.expr.ScopeExp templateScope = nameSyntax == null ? null : nameSyntax.getScope();
      if (templateScope != null)
      {
        Declaration alias = tr.makeRenamedAlias(decl, templateScope);
        if (renamedAliases == null)
          renamedAliases = new Stack();
        renamedAliases.push(alias);
        renamedAliasesCount++;
      }
      macro.setCapturedScope(recursive ? let : bindingSyntax != null ? bindingSyntax.getScope() : tr.currentScope());
      
      decls[i] = decl;
      decl.setInitValue(gnu.expr.QuoteExp.nullExp);
      bindings = bind_pair.getCdr();
    }
    if (recursive)
      push(let, tr, renamedAliases);
    Macro savedMacro = currentMacroDefinition;
    for (int i = 0; i < decl_count; i++)
    {
      Macro macro = macros[i];
      currentMacroDefinition = macro;
      gnu.expr.Expression value = tr.rewrite_car(transformers[i], trSyntax[i]);
      Declaration decl = decls[i];
      decl.setInitValue(value);
      expander = value;
      decl.noteValue(new gnu.expr.QuoteExp(macro));
      if ((value instanceof gnu.expr.LambdaExp))
      {
        gnu.expr.LambdaExp lvalue = (gnu.expr.LambdaExp)value;
        nameDecl = decl;
        lvalue.setSymbol(decl.getSymbol());
      }
    }
    currentMacroDefinition = savedMacro;
    if (!recursive)
      push(let, tr, renamedAliases);
    gnu.expr.Expression result = tr.rewrite_body(body);
    tr.pop(let);
    tr.popRenamedAlias(renamedAliasesCount);
    return result;
  }
  
  private void push(LetExp let, Translator tr, Stack renamedAliases)
  {
    tr.push(let);
    if (renamedAliases != null) {
      int i = renamedAliases.size(); for (;;) { i--; if (i < 0) break;
        tr.pushRenamedAlias((Declaration)renamedAliases.pop());
      }
    }
  }
}
