package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.lists.Pair;
import kawa.lang.Translator;

public class syntax_case extends kawa.lang.Syntax
{
  public static final syntax_case syntax_case = new syntax_case();
  static { syntax_case.setName("syntax-case"); }
  

  gnu.expr.PrimProcedure call_error;
  
  Expression rewriteClauses(Object clauses, syntax_case_work work, Translator tr)
  {
    gnu.expr.Language language = tr.getLanguage();
    gnu.bytecode.Type[] argtypes; if (clauses == gnu.lists.LList.Empty)
    {






      Expression[] args = new Expression[2];
      args[0] = new gnu.expr.QuoteExp("syntax-case");
      args[1] = new gnu.expr.ReferenceExp(inputExpression);
      if (call_error == null)
      {
        gnu.bytecode.ClassType clas = gnu.bytecode.ClassType.make("kawa.standard.syntax_case");
        argtypes = new gnu.bytecode.Type[2];
        argtypes[0] = gnu.expr.Compilation.javaStringType;
        argtypes[1] = gnu.bytecode.Type.objectType;
        gnu.bytecode.Method method = clas.addMethod("error", argtypes, gnu.bytecode.Type.objectType, 9);
        

        call_error = new gnu.expr.PrimProcedure(method, language);
      }
      return new gnu.expr.ApplyExp(call_error, args);
    }
    Object savePos = tr.pushPositionOf(clauses);
    try
    {
      Object clause;
      if ((!(clauses instanceof Pair)) || (!((clause = ((Pair)clauses).getCar()) instanceof Pair)))
      {
        return tr.syntaxError("syntax-case:  bad clause list"); }
      Object clause; Pair pair = (Pair)clause;
      kawa.lang.PatternScope clauseScope = kawa.lang.PatternScope.push(tr);
      matchArray = matchArray;
      tr.push(clauseScope);
      
      kawa.lang.SyntaxForm syntax = null;
      Object tail = pair.getCdr();
      while ((tail instanceof kawa.lang.SyntaxForm))
      {
        syntax = (kawa.lang.SyntaxForm)tail;
        tail = syntax.getDatum();
      }
      
      if (!(tail instanceof Pair)) {
        return tr.syntaxError("missing syntax-case output expression");
      }
      int outerVarCount = pattern_names.size();
      kawa.lang.SyntaxPattern pattern = new kawa.lang.SyntaxPattern(pair.getCar(), literal_identifiers, tr);
      
      int varCount = pattern.varCount();
      if (varCount > maxVars) {
        maxVars = varCount;
      }
      gnu.expr.BlockExp block = new gnu.expr.BlockExp();
      Expression[] args = new Expression[4];
      args[0] = new gnu.expr.QuoteExp(pattern);
      args[1] = new gnu.expr.ReferenceExp(inputExpression);
      args[2] = new gnu.expr.ReferenceExp(matchArray);
      args[3] = new gnu.expr.QuoteExp(gnu.math.IntNum.zero());
      Expression tryMatch = new gnu.expr.ApplyExp(new gnu.expr.PrimProcedure(kawa.lang.Pattern.matchPatternMethod, language), args);
      


      pair = (Pair)tail;
      Expression output; Expression fender; Expression output; if (pair.getCdr() == gnu.lists.LList.Empty) {
        output = tr.rewrite_car(pair, syntax);
      }
      else {
        fender = tr.rewrite_car(pair, syntax);
        if ((!(pair.getCdr() instanceof Pair)) || ((pair = (Pair)pair.getCdr()).getCdr() != gnu.lists.LList.Empty))
        {
          return tr.syntaxError("syntax-case:  bad clause"); }
        output = new gnu.expr.IfExp(fender, tr.rewrite_car(pair, syntax), new gnu.expr.ExitExp(block));
      }
      
      clauseScope.setBody(output);
      
      tr.pop(clauseScope);
      kawa.lang.PatternScope.pop(tr);
      block.setBody(new gnu.expr.IfExp(tryMatch, clauseScope, new gnu.expr.ExitExp(block)), rewriteClauses(((Pair)clauses).getCdr(), work, tr));
      
      return block;
    }
    finally
    {
      tr.popPositionOf(savePos);
    }
  }
  
  private static final gnu.bytecode.Method allocVars = gnu.bytecode.ClassType.make("kawa.lang.SyntaxPattern").getDeclaredMethod("allocVars", 2);
  


  public Expression rewriteForm(Pair form, Translator tr)
  {
    syntax_case_work work = new syntax_case_work();
    
    Object obj = form.getCdr();
    if (((obj instanceof Pair)) && ((((Pair)obj).getCdr() instanceof Pair)))
    {
      tr.letStart();
      form = (Pair)obj;
      inputExpression = tr.letVariable(null, null, tr.rewrite(form.getCar()));
      inputExpression.setCanRead(true);
      
      tr.letEnter();
      gnu.expr.LetExp let2 = new gnu.expr.LetExp();
      Declaration matchArrayOuter = matchArray;
      Declaration matchArray = let2.addDeclaration((String)null);
      matchArray.setType(gnu.expr.Compilation.objArrayType);
      matchArray.setCanRead(true);
      matchArray = matchArray;
      
      obj = form.getCdr();
      
      form = (Pair)obj;
      literal_identifiers = kawa.lang.SyntaxPattern.getLiteralsList(form.getCar(), null, tr);
      
      obj = form.getCdr();
      try
      {
        tr.push(let2);
        let2.setBody(rewriteClauses(obj, work, tr));
        Expression[] args = { new gnu.expr.QuoteExp(gnu.math.IntNum.make(maxVars)), matchArrayOuter == null ? gnu.expr.QuoteExp.nullExp : new gnu.expr.ReferenceExp(matchArrayOuter) };
        


        matchArray.setInitValue(new gnu.expr.ApplyExp(allocVars, args));
        matchArray.noteValueUnknown();
        tr.pop(let2);
        return tr.letDone(let2);
      }
      finally
      {
        matchArray = matchArrayOuter;
      }
    }
    return tr.syntaxError("insufficiant arguments to syntax-case");
  }
  

  public static Object error(String kind, Object arg)
  {
    Translator tr = (Translator)gnu.expr.Compilation.getCurrent();
    if (tr == null)
      throw new RuntimeException("no match in syntax-case");
    kawa.lang.Syntax syntax = tr.getCurrentSyntax();
    String name = syntax == null ? "some syntax" : syntax.getName();
    String msg = "no matching case while expanding " + name;
    return tr.syntaxError(msg);
  }
  
  public syntax_case() {}
}
