package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class MakeAttribute extends NodeConstructor
{
  public static final MakeAttribute makeAttribute = new MakeAttribute();
  public static final MakeAttribute makeAttributeS = new MakeAttribute();
  static { makeAttributeS.setStringIsText(true); }
  public static final gnu.expr.QuoteExp makeAttributeExp = new gnu.expr.QuoteExp(makeAttribute);
  
  public int numArgs() { return 61441; }
  
  public static void startAttribute(Consumer out, gnu.mapping.Symbol type)
  {
    out.startAttribute(type);
  }
  
  public void apply(CallContext ctx)
  {
    Consumer saved = consumer;
    Consumer out = pushNodeContext(ctx);
    try
    {
      Object type = ctx.getNextArg();
      startAttribute(out, (gnu.mapping.Symbol)type);
      Object endMarker = gnu.expr.Special.dfault;
      for (;;)
      {
        Object arg = ctx.getNextArg(endMarker);
        if (arg == endMarker)
          break;
        if (stringIsText) {
          writeContentS(arg, out);
        } else
          writeContent(arg, out);
      }
      out.endAttribute();
    }
    finally
    {
      popNodeContext(saved, ctx);
    }
  }
  

  public void compileToNode(gnu.expr.ApplyExp exp, Compilation comp, gnu.expr.ConsumerTarget target)
  {
    gnu.bytecode.Variable consumer = target.getConsumerVariable();
    Expression[] args = exp.getArgs();
    int nargs = args.length;
    CodeAttr code = comp.getCode();
    code.emitLoad(consumer);
    code.emitDup();
    args[0].compile(comp, gnu.expr.CheckedTarget.getInstance(Compilation.typeSymbol));
    
    code.emitInvokeStatic(startAttributeMethod);
    for (int i = 1; i < nargs; i++)
      compileChild(args[i], stringIsText, comp, target);
    code.emitInvokeInterface(endAttributeMethod);
  }
  
  static final ClassType typeMakeAttribute = ClassType.make("gnu.kawa.xml.MakeAttribute");
  
  static final gnu.bytecode.Method startAttributeMethod = typeMakeAttribute.getDeclaredMethod("startAttribute", 2);
  
  static final gnu.bytecode.Method endAttributeMethod = Compilation.typeConsumer.getDeclaredMethod("endAttribute", 0);
  

  public gnu.bytecode.Type getReturnType(Expression[] args)
  {
    return Compilation.typeObject;
  }
  
  public MakeAttribute() {}
}
