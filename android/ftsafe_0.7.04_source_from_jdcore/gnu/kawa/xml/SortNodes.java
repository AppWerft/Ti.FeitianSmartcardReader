package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.Target;

public class SortNodes extends gnu.mapping.Procedure1 implements gnu.expr.Inlineable
{
  public static final SortNodes sortNodes = new SortNodes();
  
  public SortNodes() {}
  
  public Object apply1(Object values) { SortedNodes nodes = new SortedNodes();
    gnu.mapping.Values.writeValues(values, nodes);
    return nodes.canonicalize();
  }
  
  public void compile(ApplyExp exp, Compilation comp, Target target)
  {
    Expression[] args = exp.getArgs();
    if ((args.length != 1) || (!mustCompile)) {
      ApplyExp.compile(exp, comp, target);
    } else {
      Method resultMethod;
      Method resultMethod;
      if (((target instanceof ConsumerTarget)) || (((target instanceof gnu.expr.StackTarget)) && (target.getType().isSubtype(Compilation.typeValues))))
      {

        resultMethod = null;
      } else
        resultMethod = canonicalizeMethod;
      ConsumerTarget.compileUsingConsumer(args[0], comp, target, makeSortedNodesMethod, resultMethod);
    }
  }
  


  public Type getReturnType(Expression[] args)
  {
    return Compilation.typeObject;
  }
  
  public static final ClassType typeSortedNodes = ClassType.make("gnu.kawa.xml.SortedNodes");
  
  public static final Method makeSortedNodesMethod = typeSortedNodes.getDeclaredMethod("<init>", 0);
  
  public static final Method canonicalizeMethod = Compilation.typeValues.getDeclaredMethod("canonicalize", 0);
}
