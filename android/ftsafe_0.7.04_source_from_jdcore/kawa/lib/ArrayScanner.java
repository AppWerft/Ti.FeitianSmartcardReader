package kawa.lib;

import gnu.bytecode.ArrayType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Convert;
import gnu.kawa.reflect.SlotGet;
import gnu.mapping.Promise;
import gnu.mapping.WrongType;
import kawa.lib.kawa.expressions;
import kawa.standard.Scheme;



































































































































































































































public class ArrayScanner
  extends ScanHelper
{
  public Type elementType;
  public Declaration seqDecl;
  public Declaration idxDecl;
  public Declaration lenDecl;
  
  public void init(Expression arg)
  {
    ArrayType arrayType = ArrayType.make(elementType);
    Expression seqArg = expressions.visitExp(expressions.applyExp$V(Convert.cast, new Object[] { arrayType, arg }));
    seqDecl = comp.letVariable(null, arrayType, seqArg);
    seqDecl.setLocation(arg);
    idxDecl = comp.letVariable(null, Type.int_type, expressions.$To$Exp(compile_map.Lit4));
    
    lenDecl = comp.letVariable(null, Type.int_type, expressions.applyExp$V(SlotGet.field, new Object[] { seqDecl, compile_map.Lit10 }));
  }
  
  public Declaration eval() { try { return comp.letVariable(null, null, (Expression)(localObject = Promise.force(expressions.applyToArgsExp$V(seqDecl, new Object[] { idxDecl }), Expression.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new WrongType(localClassCastException, "gnu.expr.Compilation.letVariable(java.lang.Object,type,gnu.expr.Expression)", 4, localObject);
    } }
  
  public Expression incr(Declaration value) { return expressions.setExp(idxDecl, expressions.applyExp$V(AddOp.$Pl, new Object[] { idxDecl, compile_map.Lit7 })); }
  
  public Expression test() { return expressions.applyExp$V(Scheme.numLss, new Object[] { idxDecl, lenDecl }); }
  
  public ArrayScanner() {}
}
