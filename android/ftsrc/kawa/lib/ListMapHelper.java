package kawa.lib;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.Invoke;
import gnu.lists.LList;
import kawa.lib.kawa.expressions;
import kawa.standard.Scheme;























































































































































































public class ListMapHelper
  extends MapHelper
{
  public boolean collecting;
  public Declaration resultDecl;
  public Declaration lastDecl;
  
  public ScanHelper makeScanner(Expression exp, Type etype) { return compile_map.scannerFor(exp, etype, comp); }
  
  public void initialize(ApplyExp exp, Compilation comp) { if (collecting)
    {
      resultDecl = comp.letVariable(null, LangObjType.listType, QuoteExp.getInstance(LList.Empty));
      lastDecl = comp.letVariable(null, compile_map.Lit20, QuoteExp.nullExp);
    }
  }
  
  public Expression doCollect(Expression value)
  {
    comp.letStart();
    
    Declaration pairDecl = comp.letVariable(null, compile_map.Lit20, expressions.applyExp$V(Invoke.make, new Object[] { compile_map.Lit17, value, LList.Empty }));
    
    pairDecl.setFlag(Declaration.ALLOCATE_ON_STACK);
    ReferenceExp pairLastRef = new ReferenceExp(pairDecl);
    pairLastRef.setFlag(ReferenceExp.ALLOCATE_ON_STACK_LAST);
    comp.letEnter();
    






    return collecting ? comp.letDone(expressions.beginExp$V(new Object[] {expressions.ifExp(expressions.applyExp$V(Scheme.isEq, new Object[] { lastDecl, null }), expressions.setExp(resultDecl, pairDecl), expressions.applyExp$V(Invoke.invoke, new Object[] { lastDecl, compile_map.Lit21, pairDecl })), expressions.setExp(lastDecl, pairLastRef) })) : value; }
  
  public Expression collectResult(Expression result) { return collecting ? 
      expressions.beginExp$V(new Object[] { result, resultDecl }) : result; }
  
  public ListMapHelper() {}
}
