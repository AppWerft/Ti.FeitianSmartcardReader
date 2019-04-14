package gnu.kawa.xml;

import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Values;

public class MakeText extends NodeConstructor
{
  public MakeText() {}
  
  public static final MakeText makeText = new MakeText();
  
  public int numArgs() { return 4097; }
  
  public Object apply1(Object arg)
  {
    if ((arg == null) || (((arg instanceof Values)) && (((Values)arg).isEmpty())))
      return arg;
    gnu.xml.NodeTree node = new gnu.xml.NodeTree();
    gnu.xml.TextUtils.textValue(arg, new gnu.xml.XMLFilter(node));
    return KText.make(node);
  }
  
  public static void text$X(Object arg, CallContext ctx)
  {
    if ((arg == null) || (((arg instanceof Values)) && (((Values)arg).isEmpty())))
      return;
    Consumer saved = consumer;
    Consumer out = NodeConstructor.pushNodeContext(ctx);
    try
    {
      gnu.xml.TextUtils.textValue(arg, out);
    }
    finally
    {
      NodeConstructor.popNodeContext(saved, ctx);
    }
  }
  
  public void apply(CallContext ctx)
  {
    text$X(ctx.getNextArg(null), ctx);
  }
  


  public void compile(ApplyExp exp, Compilation comp, gnu.expr.Target target)
  {
    ApplyExp.compile(exp, comp, target);
  }
  
  public void compileToNode(ApplyExp exp, Compilation comp, gnu.expr.ConsumerTarget target)
  {
    throw new Error("MakeText.compileToNode called!");
  }
}
