package gnu.xquery.util;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.Target;
import gnu.kawa.xml.SortedNodes;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class ValuesFilter extends gnu.mapping.MethodProc implements gnu.expr.Inlineable
{
  char kind;
  
  public ValuesFilter(char kind)
  {
    this.kind = kind;
    setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyValuesFilter");
  }
  

  public static ValuesFilter get(char kind)
  {
    if (kind == 'F') return forwardFilter;
    if (kind == 'R') return reverseFilter;
    return exprFilter;
  }
  



  int last_or_position_needed = 2;
  
  public int numArgs() { return 8194; }
  
  public static boolean matches(Object result, long count)
  {
    if ((result instanceof Values))
      result = ((Values)result).canonicalize();
    if ((result instanceof Number))
    {
      if ((result instanceof IntNum))
        return IntNum.compare((IntNum)result, count) == 0;
      if (((result instanceof Double)) || ((result instanceof Float)) || ((result instanceof gnu.math.DFloNum)))
      {
        return ((Number)result).doubleValue() == count; }
      if (((result instanceof Long)) || ((result instanceof Integer)) || ((result instanceof Short)) || ((result instanceof Byte)))
      {
        return count == ((Number)result).longValue();
      }
      return gnu.kawa.functions.NumberCompare.applyWithPromotion(8, IntNum.make(count), result);
    }
    

    return BooleanValue.booleanValue(result);
  }
  
  public void apply(CallContext ctx) throws Throwable
  {
    Object arg = ctx.getNextArg();
    Procedure proc = (Procedure)ctx.getNextArg();
    Consumer out = consumer;
    Values values;
    if (kind != 'P')
    {
      SortedNodes nodes = new SortedNodes();
      Values.writeValues(arg, nodes);
      values = nodes;
    } else { Values values;
      if ((arg instanceof Values)) {
        values = (Values)arg;
      }
      else {
        IntNum one = IntNum.one();
        if (matches(proc.apply3(arg, one, one), 1L))
          out.writeObject(arg);
        return; } }
    Values values;
    int count = values.size();
    int it = 0;
    IntNum countObj = IntNum.make(count);
    

    int pmax = proc.maxArgs();
    for (int i = 0; i < count; i++)
    {
      it = values.nextPos(it);
      Object dot = values.getPosPrevious(it);
      int pos = kind == 'R' ? count - i : i + 1;
      IntNum posObj = IntNum.make(pos);
      Object pred_res = pmax == 2 ? proc.apply2(dot, posObj) : proc.apply3(dot, posObj, countObj);
      
      if (matches(pred_res, pos)) {
        out.writeObject(dot);
      }
    }
  }
  
  public void compile(ApplyExp exp, gnu.expr.Compilation comp, Target target)
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
    if (!(exp2 instanceof LambdaExp))
    {
      ApplyExp.compile(exp, comp, target);
      return;
    }
    
    if (!(target instanceof ConsumerTarget))
    {
      ConsumerTarget.compileUsingConsumer(exp, comp, target);
      return;
    }
    
    LambdaExp lexp2 = (LambdaExp)exp2;
    gnu.kawa.functions.ValuesMap.compileInlined(lexp2, exp1, 1, matchesMethod, comp, target);
  }
  


  public Type getReturnType(Expression[] args)
  {
    return Type.pointer_type;
  }
  
  public static final ValuesFilter forwardFilter = new ValuesFilter('F');
  public static final ValuesFilter reverseFilter = new ValuesFilter('R');
  public static final ValuesFilter exprFilter = new ValuesFilter('P');
  public static final ClassType typeValuesFilter = ClassType.make("gnu.xquery.util.ValuesFilter");
  
  public static final gnu.bytecode.Method matchesMethod = typeValuesFilter.getDeclaredMethod("matches", 2);
}
