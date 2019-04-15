package gnu.kawa.xml;

import gnu.bytecode.CodeAttr;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class DocumentConstructor extends NodeConstructor
{
  public static final DocumentConstructor documentConstructor = new DocumentConstructor();
  
  public DocumentConstructor() {}
  
  public void apply(CallContext ctx) {
    Consumer saved = consumer;
    Consumer out = pushNodeContext(ctx);
    try
    {
      Object endMarker = gnu.mapping.Location.UNBOUND;
      out.startDocument();
      for (;;)
      {
        Object arg = ctx.getNextArg(endMarker);
        if (arg == endMarker)
          break;
        if ((arg instanceof Consumable)) {
          ((Consumable)arg).consume(out);
        } else
          out.writeObject(arg);
      }
      out.endDocument();
    }
    finally
    {
      popNodeContext(saved, ctx);
    }
  }
  

  public void compileToNode(ApplyExp exp, Compilation comp, ConsumerTarget target)
  {
    gnu.bytecode.Variable consumer = target.getConsumerVariable();
    gnu.expr.Expression[] args = exp.getArgs();
    int nargs = args.length;
    CodeAttr code = comp.getCode();
    code.emitLoad(consumer);
    code.emitInvokeInterface(startDocumentMethod);
    for (int i = 0; i < nargs; i++)
      compileChild(args[i], stringIsText, comp, target);
    code.emitLoad(consumer);
    code.emitInvokeInterface(endDocumentMethod);
  }
  
  static final gnu.bytecode.Method startDocumentMethod = Compilation.typeConsumer.getDeclaredMethod("startDocument", 0);
  
  static final gnu.bytecode.Method endDocumentMethod = Compilation.typeConsumer.getDeclaredMethod("endDocument", 0);
}
