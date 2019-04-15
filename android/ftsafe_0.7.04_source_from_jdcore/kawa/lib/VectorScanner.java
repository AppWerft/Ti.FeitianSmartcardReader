package kawa.lib;

import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Convert;
import gnu.kawa.reflect.Invoke;
import kawa.lib.kawa.expressions;
import kawa.standard.Scheme;




























































































































































































































































public class VectorScanner
  extends ScanHelper
{
  public Declaration seqDecl;
  public Declaration idxDecl;
  public Declaration endDecl;
  
  public void init(Expression arg)
  {
    Expression seqArg = expressions.visitExp(expressions.applyExp$V(Convert.cast, new Object[] { compile_map.Lit1, arg }));
    seqDecl = comp.letVariable(null, null, seqArg);
    seqDecl.setLocation(arg);
    idxDecl = comp.letVariable(null, Type.int_type, expressions.$To$Exp(compile_map.Lit4));
    
    endDecl = comp.letVariable(null, Type.int_type, expressions.applyExp$V(Invoke.invoke, new Object[] { seqDecl, compile_map.Lit22 }));
  }
  
  public Declaration eval() { return comp.letVariable(null, null, expressions.applyExp$V(Invoke.invoke, new Object[] { seqDecl, compile_map.Lit23, idxDecl })); }
  

  public Expression incr(Declaration value) { return expressions.setExp(idxDecl, expressions.applyExp$V(AddOp.$Pl, new Object[] { idxDecl, compile_map.Lit7 })); }
  
  public Expression test() { return expressions.applyExp$V(Scheme.numLss, new Object[] { idxDecl, endDecl }); }
  
  public VectorScanner() {}
}
