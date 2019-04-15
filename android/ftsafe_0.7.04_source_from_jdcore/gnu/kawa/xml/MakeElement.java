package gnu.kawa.xml;

import gnu.bytecode.CodeAttr;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.lists.Consumer;
import gnu.mapping.Symbol;

public class MakeElement extends NodeConstructor
{
  public static final MakeElement makeElementS = new MakeElement();
  static { makeElementS.setStringIsText(true); }
  
  public int numArgs() { return tag == null ? 61441 : 61440; }
  

  public Symbol tag;
  public String toString()
  {
    return "makeElement[" + tag + "]"; }
  
  public int copyNamespacesMode = 1;
  
  private boolean handlingKeywordParameters;
  
  gnu.xml.NamespaceBinding namespaceNodes;
  
  public boolean isHandlingKeywordParameters()
  {
    return handlingKeywordParameters;
  }
  
  public void setHandlingKeywordParameters(boolean value)
  {
    handlingKeywordParameters = value;
  }
  


  public gnu.xml.NamespaceBinding getNamespaceNodes()
  {
    return namespaceNodes;
  }
  
  public void setNamespaceNodes(gnu.xml.NamespaceBinding bindings)
  {
    namespaceNodes = bindings;
  }
  
  public static Symbol getTagName(ApplyExp exp)
  {
    Expression[] args = exp.getArgs();
    if (args.length > 0)
    {
      Expression arg0 = args[0];
      if ((arg0 instanceof gnu.expr.QuoteExp))
      {
        Object val = ((gnu.expr.QuoteExp)arg0).getValue();
        if ((val instanceof Symbol))
          return (Symbol)val;
      }
    }
    return null;
  }
  


  public static void startElement(Consumer out, Symbol qname, int copyNamespacesMode, gnu.xml.NamespaceBinding namespaceNodes)
  {
    gnu.xml.XName type = new gnu.xml.XName(qname, namespaceNodes);
    if ((out instanceof gnu.xml.XMLFilter))
      copyNamespacesMode = copyNamespacesMode;
    out.startElement(type);
  }
  

  public static void startElement(Consumer out, Symbol qname, int copyNamespacesMode)
  {
    if ((out instanceof gnu.xml.XMLFilter))
      copyNamespacesMode = copyNamespacesMode;
    out.startElement(qname);
  }
  
  public static void endElement(Consumer out, Object type)
  {
    out.endElement();
  }
  
  public void apply(gnu.mapping.CallContext ctx)
  {
    Consumer saved = consumer;
    Consumer out = pushNodeContext(ctx);
    try
    {
      Symbol type = tag != null ? tag : (Symbol)ctx.getNextArg();
      if (namespaceNodes != null) {
        startElement(out, type, copyNamespacesMode, namespaceNodes);
      } else
        startElement(out, type, copyNamespacesMode);
      Object endMarker = gnu.expr.Special.dfault;
      for (;;)
      {
        Object arg = ctx.getNextArg(endMarker);
        if (arg == endMarker)
          break;
        if (stringIsText) {
          writeContentS(arg, out);
        } else {
          writeContent(arg, out);
        }
        if (isHandlingKeywordParameters())
          out.endAttribute();
      }
      endElement(out, type);
    }
    finally
    {
      popNodeContext(saved, ctx);
    }
  }
  

  public void compileToNode(ApplyExp exp, Compilation comp, gnu.expr.ConsumerTarget target)
  {
    gnu.bytecode.Variable consumer = target.getConsumerVariable();
    Expression[] args = exp.getArgs();
    int nargs = args.length;
    CodeAttr code = comp.getCode();
    code.emitLoad(consumer);
    code.emitDup();
    
    gnu.expr.Target tagTarget = gnu.expr.CheckedTarget.getInstance(Compilation.typeSymbol);
    int i; int i; if (tag == null)
    {
      args[0].compile(comp, tagTarget);
      i = 1;
    }
    else
    {
      comp.compileConstant(tag, tagTarget);
      i = 0;
    }
    code.emitDup(1, 1);
    
    code.emitPushInt(copyNamespacesMode);
    if (namespaceNodes != null)
    {
      comp.compileConstant(namespaceNodes, gnu.expr.Target.pushObject);
      code.emitInvokeStatic(startElementMethod4);
    }
    else {
      code.emitInvokeStatic(startElementMethod3); }
    for (; i < nargs; i++)
    {
      compileChild(args[i], stringIsText, comp, target);
      if (isHandlingKeywordParameters())
      {
        code.emitLoad(consumer);
        code.emitInvokeInterface(MakeAttribute.endAttributeMethod);
      }
    }
    code.emitInvokeStatic(endElementMethod);
  }
  
  public gnu.bytecode.Type getReturnType(Expression[] args)
  {
    return Compilation.typeObject;
  }
  
  static final gnu.bytecode.ClassType typeMakeElement = gnu.bytecode.ClassType.make("gnu.kawa.xml.MakeElement");
  
  static final gnu.bytecode.Method startElementMethod3 = typeMakeElement.getDeclaredMethod("startElement", 3);
  
  static final gnu.bytecode.Method startElementMethod4 = typeMakeElement.getDeclaredMethod("startElement", 4);
  
  static final gnu.bytecode.Method endElementMethod = typeMakeElement.getDeclaredMethod("endElement", 2);
  
  public MakeElement() {}
}
