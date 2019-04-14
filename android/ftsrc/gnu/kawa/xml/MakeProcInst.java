package gnu.kawa.xml;

import gnu.expr.ApplyExp;
import gnu.expr.ConsumerTarget;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Values;

public class MakeProcInst extends NodeConstructor
{
  public MakeProcInst() {}
  
  public static final MakeProcInst makeProcInst = new MakeProcInst();
  
  public int numArgs() {
    return 8194;
  }
  
  public static void procInst$C(Object target, Object content, Consumer out) {
    target = KNode.atomicValue(target);
    if ((!(target instanceof String)) && (!(target instanceof UntypedAtomic))) {
      throw new ClassCastException("invalid type of processing-instruction target [XPTY0004]");
    }
    if (!(out instanceof gnu.lists.XConsumer))
      return;
    StringBuffer sbuf = new StringBuffer();
    if ((content instanceof Values))
    {
      Object[] vals = ((Values)content).getValues();
      for (int i = 0; i < vals.length; i++)
      {
        if (i > 0)
          sbuf.append(' ');
        gnu.xml.TextUtils.stringValue(vals[i], sbuf);
      }
    }
    else {
      gnu.xml.TextUtils.stringValue(content, sbuf); }
    int length = sbuf.length();
    int start = 0;
    while ((start < length) && (Character.isWhitespace(sbuf.charAt(start))))
      start++;
    char[] chars = new char[length - start];
    sbuf.getChars(start, length, chars, 0);
    ((gnu.lists.XConsumer)out).writeProcessingInstruction(target.toString(), chars, 0, chars.length);
  }
  


  public static void procInst$X(Object target, Object content, CallContext ctx)
  {
    Consumer saved = consumer;
    Consumer out = NodeConstructor.pushNodeContext(ctx);
    try
    {
      procInst$C(target, content, out);
    }
    finally
    {
      NodeConstructor.popNodeContext(saved, ctx);
    }
  }
  
  public void apply(CallContext ctx)
  {
    procInst$X(ctx.getNextArg(null), ctx.getNextArg(null), ctx);
  }
  

  public void compileToNode(ApplyExp exp, gnu.expr.Compilation comp, ConsumerTarget target)
  {
    gnu.bytecode.CodeAttr code = comp.getCode();
    gnu.expr.Expression[] args = exp.getArgs();
    args[0].compile(comp, gnu.expr.Target.pushObject);
    args[1].compile(comp, gnu.expr.Target.pushObject);
    code.emitLoad(target.getConsumerVariable());
    code.emitInvokeStatic(gnu.bytecode.ClassType.make("gnu.kawa.xml.MakeProcInst").getDeclaredMethod("procInst$C", 3));
  }
}
