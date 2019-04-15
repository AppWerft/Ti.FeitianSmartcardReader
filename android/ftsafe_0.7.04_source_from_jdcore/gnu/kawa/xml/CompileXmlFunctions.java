package gnu.kawa.xml;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;

public class CompileXmlFunctions
{
  public CompileXmlFunctions() {}
  
  public static gnu.expr.Expression validateApplyMakeUnescapedData(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    gnu.expr.Expression[] args = exp.getArgs();
    if ((args.length == 1) && ((args[0] instanceof gnu.expr.QuoteExp)))
      return new gnu.expr.QuoteExp(((MakeUnescapedData)proc).apply1(((gnu.expr.QuoteExp)args[0]).getValue()));
    return exp;
  }
  

  public static gnu.expr.Expression validateApplyTreeScanner(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    gnu.lists.NodePredicate type = type;
    if ((exp.getTypeRaw() == null) && ((type instanceof Type)))
      exp.setType(NodeSetType.getInstance((Type)type));
    return exp;
  }
}
