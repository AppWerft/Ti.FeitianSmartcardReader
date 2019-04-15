package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.lists.Consumer;
import gnu.xml.XMLFilter;

public abstract class NodeConstructor extends gnu.mapping.MethodProc implements gnu.expr.Inlineable
{
  protected boolean stringIsText;
  
  public NodeConstructor() {}
  
  public abstract void compileToNode(ApplyExp paramApplyExp, Compilation paramCompilation, ConsumerTarget paramConsumerTarget);
  
  public void setStringIsText(boolean stringIsText)
  {
    this.stringIsText = stringIsText;
  }
  


  public static XMLFilter pushNodeConsumer(Consumer out)
  {
    if ((out instanceof XMLFilter)) {
      return (XMLFilter)out;
    }
    return new XMLFilter(new gnu.xml.NodeTree());
  }
  
  public static void popNodeConsumer(Consumer saved, Consumer current)
  {
    if (saved != current) {
      saved.writeObject((current instanceof XMLFilter) ? KNode.make((gnu.xml.NodeTree)out) : current);
    }
  }
  

  public static XMLFilter pushNodeContext(gnu.mapping.CallContext ctx)
  {
    Consumer out = consumer;
    if ((out instanceof XMLFilter)) {
      return (XMLFilter)out;
    }
    




    XMLFilter filter = new XMLFilter(new gnu.xml.NodeTree());
    consumer = filter;
    return filter;
  }
  

  public static void popNodeContext(Consumer saved, gnu.mapping.CallContext ctx)
  {
    Object current = consumer;
    if (saved != current)
    {
      if ((current instanceof XMLFilter))
        current = KNode.make((gnu.xml.NodeTree)out);
      saved.writeObject(current);
      consumer = saved;
    }
  }
  
  public static void compileChild(Expression arg, boolean stringIsText, Compilation comp, ConsumerTarget target)
  {
    if ((arg instanceof ApplyExp)) {
      ApplyExp app = (ApplyExp)arg;
      Expression func = app.getFunction();
      Object proc = func.valueIfConstant();
      


      if (((proc instanceof NodeConstructor)) && (!(proc instanceof MakeText)))
      {
        ((NodeConstructor)proc).compileToNode(app, comp, target);
        return;
      }
    }
    CodeAttr code = comp.getCode();
    if ((arg instanceof gnu.expr.QuoteExp)) {
      Object value = ((gnu.expr.QuoteExp)arg).getValue();
      if ((value instanceof gnu.lists.FString)) {
        code.emitLoad(target.getConsumerVariable());
        code.emitPushString(value.toString());
        code.emitInvoke(Compilation.typeConsumer.getDeclaredMethod("write", new gnu.bytecode.Type[] { gnu.bytecode.Type.javalangStringType }));
        

        return;
      }
    }
    arg.compileWithPosition(comp, gnu.expr.Target.pushObject);
    code.emitLoad(target.getConsumerVariable());
    code.emitInvokeStatic(ClassType.make("gnu.kawa.xml.NodeConstructor").getDeclaredMethod(stringIsText ? "writeContentS" : "writeContent", 2));
  }
  






  public static void compileUsingNodeTree(Expression exp, Compilation comp, gnu.expr.Target target)
  {
    gnu.bytecode.Method makeMethod = typeNodeConstructor.getDeclaredMethod("makeNode", 0);
    gnu.bytecode.Method makeKNodeMethod = typeNodeConstructor.getDeclaredMethod("finishNode", 1);
    ConsumerTarget.compileUsingConsumer(exp, comp, target, makeMethod, makeKNodeMethod);
  }
  

  public static XMLFilter makeNode()
  {
    return new XMLFilter(new gnu.xml.NodeTree());
  }
  
  public static KNode finishNode(XMLFilter filter)
  {
    return KNode.make((gnu.xml.NodeTree)out);
  }
  
  public void compile(ApplyExp exp, Compilation comp, gnu.expr.Target target)
  {
    if ((target instanceof gnu.expr.IgnoreTarget)) {
      ApplyExp.compile(exp, comp, target);
    } else if (!(target instanceof ConsumerTarget)) {
      compileUsingNodeTree(exp, comp, target);
    }
    else {
      ConsumerTarget ctarget = (ConsumerTarget)target;
      gnu.bytecode.Variable cvar = ctarget.getConsumerVariable();
      gnu.bytecode.Type ctype = cvar.getType();
      if (ctype.isSubtype(typeXMLFilter)) {
        compileToNode(exp, comp, ctarget);
      }
      else {
        Expression[] args = exp.getArgs();
        int nargs = args.length;
        CodeAttr code = comp.getCode();
        gnu.bytecode.Scope scope = code.pushScope();
        gnu.bytecode.Variable xvar = scope.addVariable(code, typeXMLFilter, null);
        
        if (ctarget.isContextTarget())
        {
          comp.loadCallContext();
          code.emitInvokeStatic(pushNodeContextMethod);
        }
        else
        {
          code.emitLoad(cvar);
          code.emitInvokeStatic(pushNodeConsumerMethod);
        }
        code.emitStore(xvar);
        code.emitTryStart(true, gnu.bytecode.Type.void_type);
        ConsumerTarget xtarget = new ConsumerTarget(xvar);
        compileToNode(exp, comp, xtarget);
        code.emitFinallyStart();
        code.emitLoad(cvar);
        if (ctarget.isContextTarget())
        {
          comp.loadCallContext();
          code.emitInvokeStatic(popNodeContextMethod);
        }
        else
        {
          code.emitLoad(xvar);
          code.emitInvokeStatic(popNodeConsumerMethod);
        }
        code.emitFinallyEnd();
        code.emitTryCatchEnd();
        code.popScope();
      }
    }
  }
  
  public gnu.bytecode.Type getReturnType(Expression[] args)
  {
    return Compilation.typeObject;
  }
  
  public static void writeContentS(Object arg, Consumer out) {
    if (((arg instanceof CharSequence)) && (!(arg instanceof gnu.lists.UnescapedData))) {
      CharSequence carg = (CharSequence)arg;
      out.write(carg, 0, carg.length());
    }
    else {
      writeContent(arg, out);
    } }
  
  public static void writeContent(Object arg, Consumer out) { if (((arg instanceof java.util.List)) && (!(arg instanceof CharSequence))) {
      for (Object e : (java.util.List)arg) {
        writeContent1(e, out);
      }
      
    } else
      writeContent1(arg, out);
  }
  
  protected static void writeContent1(Object arg, Consumer out) {
    if ((arg instanceof gnu.lists.Consumable)) {
      ((gnu.lists.Consumable)arg).consume(out);
    } else
      gnu.mapping.Values.writeValues(arg, out);
  }
  
  static final ClassType typeXMLFilter = ClassType.make("gnu.xml.XMLFilter");
  
  static final ClassType typeKNode = ClassType.make("gnu.kawa.xml.KNode");
  
  static final ClassType typeNodeConstructor = ClassType.make("gnu.kawa.xml.NodeConstructor");
  
  static final gnu.bytecode.Method pushNodeContextMethod = typeNodeConstructor.getDeclaredMethod("pushNodeContext", 1);
  
  static final gnu.bytecode.Method popNodeContextMethod = typeNodeConstructor.getDeclaredMethod("popNodeContext", 2);
  
  static final gnu.bytecode.Method pushNodeConsumerMethod = typeNodeConstructor.getDeclaredMethod("pushNodeConsumer", 1);
  
  static final gnu.bytecode.Method popNodeConsumerMethod = typeNodeConstructor.getDeclaredMethod("popNodeConsumer", 2);
}
