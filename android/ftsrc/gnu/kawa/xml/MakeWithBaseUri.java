package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.lists.Consumer;
import gnu.lists.XConsumer;
import gnu.mapping.CallContext;

public class MakeWithBaseUri extends NodeConstructor
{
  public MakeWithBaseUri() {}
  
  public static final MakeWithBaseUri makeWithBaseUri = new MakeWithBaseUri();
  
  public int numArgs() { return 8194; }
  
  public void apply(CallContext ctx)
  {
    Consumer saved = consumer;
    Consumer out = NodeConstructor.pushNodeContext(ctx);
    Object baseUri = ctx.getNextArg();
    Object node = ctx.getNextArg();
    if ((out instanceof XConsumer)) {
      ((XConsumer)out).beginEntity(baseUri);
    }
    try {
      gnu.mapping.Values.writeValues(node, out);
    }
    finally
    {
      if ((out instanceof XConsumer))
        ((XConsumer)out).endEntity();
      NodeConstructor.popNodeContext(saved, ctx);
    }
  }
  


  public void compileToNode(ApplyExp exp, Compilation comp, ConsumerTarget target)
  {
    gnu.bytecode.Variable consumer = target.getConsumerVariable();
    Expression[] args = exp.getArgs();
    int nargs = args.length;
    CodeAttr code = comp.getCode();
    code.emitLoad(consumer);
    args[0].compile(comp, gnu.expr.Target.pushObject);
    code.emitInvokeInterface(beginEntityMethod);
    compileChild(args[1], stringIsText, comp, target);
    code.emitLoad(consumer);
    code.emitInvokeInterface(endEntityMethod);
  }
  
  static final ClassType typeXConsumer = ClassType.make("gnu.lists.XConsumer");
  static final Method beginEntityMethod = typeXConsumer.getDeclaredMethod("beginEntity", 1);
  
  static final Method endEntityMethod = typeXConsumer.getDeclaredMethod("endEntity", 0);
}
