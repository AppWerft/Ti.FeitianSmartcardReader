package gnu.kawa.functions;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.QuoteExp;
import gnu.kawa.reflect.ArraySet;
import gnu.kawa.reflect.Invoke;













































































































































































































































































































































class SetArrayExp
  extends ApplyExp
{
  public static final ClassType typeSetArray = ClassType.make("gnu.kawa.functions.SetArray");
  
  Type elementType;
  
  public SetArrayExp(Expression array, ArrayType arrayType)
  {
    super(Invoke.make, new Expression[] { new QuoteExp(typeSetArray), array });
    elementType = arrayType.getComponentType();
  }
  
  public Expression validateApply(ApplyExp exp, InlineCalls visitor, Type required, Declaration decl)
  {
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    if (args.length == 2) {
      Expression array = getArgs()[1];
      Expression[] xargs = new Expression[3];
      xargs[0] = array;
      xargs[1] = args[0];
      xargs[2] = args[1];
      ArraySet arrSetter = new ArraySet(elementType);
      return visitor.visitApplyOnly(new ApplyExp(arrSetter, xargs), required);
    }
    return exp;
  }
}
