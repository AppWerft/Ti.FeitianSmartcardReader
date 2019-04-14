package gnu.xquery.util;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.xml.Nodes;
import gnu.kawa.xml.TreeScanner;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.math.IntNum;

public class RelativeStep extends gnu.mapping.MethodProc implements gnu.expr.Inlineable
{
  public static final RelativeStep relativeStep = new RelativeStep();
  
  RelativeStep()
  {
    setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyRelativeStep");
  }
  
  public int numArgs() {
    return 8194;
  }
  
  public void apply(CallContext ctx) throws Throwable {
    Object arg = ctx.getNextArg();
    Object next = ctx.getNextArg();
    Procedure proc = (Procedure)next;
    gnu.lists.Consumer out = consumer;
    Nodes values;
    Nodes values;
    if ((arg instanceof Nodes)) {
      values = (Nodes)arg;
    }
    else {
      values = new Nodes();
      gnu.mapping.Values.writeValues(arg, values);
    }
    int count = values.size();
    int it = 0;
    IntNum countObj = IntNum.make(count);
    RelativeStepFilter filter = new RelativeStepFilter(out);
    for (int pos = 1; pos <= count; pos++)
    {
      it = values.nextPos(it);
      Object dot = values.getPosPrevious(it);
      proc.check3(dot, IntNum.make(pos), countObj, ctx);
      gnu.mapping.Values.writeValues(ctx.runUntilValue(), filter);
    }
    filter.finish();
  }
  
  public void compile(ApplyExp exp, Compilation comp, Target target)
  {
    Expression[] args = exp.getArgs();
    Expression exp1 = args[0];
    Expression exp2 = args[1];
    if ((target instanceof gnu.expr.IgnoreTarget))
    {
      exp1.compile(comp, target);
      exp2.compile(comp, target);
      return;
    }
    
    Type rtype = exp.getTypeRaw();
    if (rtype == null)
      rtype = Type.pointer_type;
    Type rtypePrime = gnu.kawa.reflect.OccurrenceType.itemPrimeType(rtype);
    int nodeCompare = gnu.kawa.xml.NodeType.anyNodeTest.compare(rtypePrime);
    char expectedKind;
    char expectedKind;
    if (nodeCompare >= 0) {
      expectedKind = 'N'; } else { char expectedKind;
      if (nodeCompare == -3) {
        expectedKind = 'A';
      } else
        expectedKind = ' '; }
    TreeScanner step = extractStep(exp2);
    if (step != null)
    {
      Type type1 = exp1.getType();
      if (((step instanceof gnu.kawa.xml.ChildAxis)) || ((step instanceof gnu.kawa.xml.AttributeAxis)) || ((step instanceof gnu.kawa.xml.SelfAxis)))
      {


        if (((type1 instanceof gnu.kawa.xml.NodeSetType)) || ((expectedKind == 'N') && (gnu.kawa.reflect.OccurrenceType.itemCountIsZeroOrOne(exp1.getType()))))
        {

          expectedKind = 'S';
        }
      }
    }
    








    if (!(target instanceof ConsumerTarget))
    {
      ConsumerTarget.compileUsingConsumer(exp, comp, target);
      return;
    }
    
    CodeAttr code = comp.getCode();
    
    gnu.bytecode.Scope scope = code.pushScope();
    Variable tconsumer;
    ClassType mclass;
    Variable mconsumer;
    Target mtarget;
    Variable tconsumer; if ((expectedKind == 'A') || (expectedKind == 'S'))
    {
      Target mtarget = target;
      ClassType mclass = null;
      Variable mconsumer = null;
      tconsumer = null;
    }
    else
    {
      gnu.bytecode.Method initMethod;
      gnu.bytecode.Method initMethod;
      if (expectedKind == 'N')
      {
        ClassType mclass = ClassType.make("gnu.kawa.xml.SortedNodes");
        initMethod = mclass.getDeclaredMethod("<init>", 0);
      }
      else
      {
        mclass = ClassType.make("gnu.xquery.util.RelativeStepFilter");
        initMethod = mclass.getDeclaredMethod("<init>", 1);
      }
      mconsumer = scope.addVariable(code, mclass, null);
      mtarget = new ConsumerTarget(mconsumer);
      code.emitNew(mclass);
      code.emitDup(mclass);
      tconsumer = ((ConsumerTarget)target).getConsumerVariable();
      if (expectedKind != 'N')
        code.emitLoad(tconsumer);
      code.emitInvoke(initMethod);
      code.emitStore(mconsumer);
    }
    
    gnu.kawa.functions.ValuesMap.compileInlined((gnu.expr.LambdaExp)exp2, exp1, 1, null, comp, mtarget);
    

    if (expectedKind == 'N')
    {
      code.emitLoad(mconsumer);
      code.emitLoad(tconsumer);
      code.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("writeValues", 2));

    }
    else if (expectedKind == ' ')
    {
      code.emitLoad(mconsumer);
      code.emitInvoke(mclass.getDeclaredMethod("finish", 0));
    }
    
    code.popScope();
  }
  


  public Type getReturnType(Expression[] args)
  {
    return Type.pointer_type;
  }
  
  public static TreeScanner extractStep(Expression exp)
  {
    for (;;)
    {
      if (!(exp instanceof ApplyExp))
        return null;
      ApplyExp aexp = (ApplyExp)exp;
      Expression func = aexp.getFunction();
      if (!(func instanceof QuoteExp))
        break;
      Object value = ((QuoteExp)func).getValue();
      if ((value instanceof TreeScanner)) {
        return (TreeScanner)value;
      }
      if (!(value instanceof ValuesFilter))
        break;
      exp = aexp.getArgs()[0];
    }
    

    return null;
  }
}
