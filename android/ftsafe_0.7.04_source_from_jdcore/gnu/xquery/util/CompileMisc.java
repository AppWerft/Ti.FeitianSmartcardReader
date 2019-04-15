package gnu.xquery.util;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.QuoteExp;
import gnu.kawa.reflect.OccurrenceType;
import gnu.mapping.Procedure;

public class CompileMisc
{
  public CompileMisc() {}
  
  public static Expression validateCompare(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc)
  {
    exp.visitArgs(visitor);
    Expression folded = exp.inlineIfConstant(proc, visitor);
    if (folded != exp)
      return folded;
    Compare cproc = (Compare)proc;
    if ((flags & 0x20) == 0)
    {



      exp = new ApplyExp(ClassType.make("gnu.xquery.util.Compare").getDeclaredMethod("apply", 4), new Expression[] { new QuoteExp(gnu.math.IntNum.make(flags)), exp.getArg(0), exp.getArg(1), QuoteExp.nullExp });
    }
    




    if (exp.getTypeRaw() == null)
      exp.setType(gnu.kawa.xml.XDataType.booleanType);
    return exp;
  }
  


  public static Expression validateBooleanValue(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc)
  {
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    if (args.length == 1)
    {
      Expression arg = args[0];
      Type type = arg.getType();
      if (type == gnu.kawa.xml.XDataType.booleanType)
        return arg;
      if (type == null)
        exp.setType(gnu.kawa.xml.XDataType.booleanType);
      if ((arg instanceof QuoteExp))
      {
        Object value = ((QuoteExp)arg).getValue();
        try
        {
          return BooleanValue.booleanValue(value) ? gnu.xquery.lang.XQuery.trueExp : gnu.xquery.lang.XQuery.falseExp;
        }
        catch (Exception ex)
        {
          String message = "cannot convert to a boolean";
          visitor.getMessages().error('e', message);
          return new gnu.expr.ErrorExp(message);
        }
      }
    }
    return exp;
  }
  


  public static Expression validateArithOp(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc)
  {
    exp.visitArgs(visitor);
    
    return exp;
  }
  


  public static Expression validateApplyValuesFilter(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc)
  {
    ValuesFilter vproc = (ValuesFilter)proc;
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    Expression exp2 = args[1];
    LambdaExp lexp2;
    if ((!(exp2 instanceof LambdaExp)) || (min_args != 3) || (max_args != 3))
    {

      return exp; }
    LambdaExp lexp2;
    Expression seq = args[0];
    Type seqType = seq.getType();
    if ((seqType instanceof OccurrenceType)) {
      OccurrenceType occType = (OccurrenceType)seqType;
      Type baseType = occType.getBase();
      if (OccurrenceType.itemCountIsOne(baseType)) {
        int min = occType.minOccurs();
        if (min > 0) {
          occType = new OccurrenceType(baseType, min, occType.maxOccurs());
        }
        exp.setType(occType);
      }
    }
    
    Compilation comp = visitor.getCompilation();
    
    Declaration dotArg = lexp2.firstDecl();
    Declaration posArg = dotArg.nextDecl();
    Declaration lastArg = posArg.nextDecl();
    dotArg.setCanRead(true);
    posArg.setCanRead(true);
    
    lexp2.setInlineOnly(exp, visitor.getCurrentLambda());
    

    lexp2.remove(posArg, lastArg);
    min_args = 2;
    max_args = 2;
    
    if ((!lastArg.getCanRead()) && (kind != 'R'))
    {

      return exp;
    }
    lastArg.setCanRead(true);
    
    comp.letStart();
    gnu.bytecode.Method sizeMethod;
    gnu.bytecode.Method sizeMethod; if (kind == 'P')
    {
      sizeMethod = Compilation.typeValues.getDeclaredMethod("countValues", 1);
    }
    else
    {
      seqType = gnu.kawa.xml.SortNodes.typeSortedNodes;
      seq = new ApplyExp(gnu.kawa.xml.SortNodes.sortNodes, new Expression[] { seq });
      sizeMethod = ClassType.make("gnu.lists.AbstractSequence").getDeclaredMethod("size", 0);
    }
    
    Declaration sequence = comp.letVariable("sequence", seqType, seq);
    comp.letEnter();
    
    Expression pred = body;
    Type predType = body.getType();
    if (predType != gnu.kawa.xml.XDataType.booleanType) {
      pred = new ApplyExp(ValuesFilter.matchesMethod, new Expression[] { pred, new gnu.expr.ReferenceExp(posArg) });
    }
    
    if (kind == 'R')
    {
      Declaration posIncoming = new Declaration(null, Type.intType);
      posIncoming.setCanRead(true);
      Expression init = new ApplyExp(gnu.kawa.functions.AddOp.$Mn, new Expression[] { new gnu.expr.ReferenceExp(lastArg), new gnu.expr.ReferenceExp(posIncoming) });
      



      init = new ApplyExp(gnu.kawa.functions.AddOp.$Pl, new Expression[] { init, new QuoteExp(gnu.math.IntNum.one()) });
      




      comp.letStart();
      lexp2.replaceFollowing(dotArg, posIncoming);
      comp.letVariable(posArg, init);
      comp.letEnter();
      pred = comp.letDone(pred);
    }
    
    pred = new gnu.expr.IfExp(pred, new gnu.expr.ReferenceExp(dotArg), QuoteExp.voidExp);
    

    body = pred;
    
    ApplyExp doMap = new ApplyExp(gnu.kawa.functions.ValuesMap.valuesMapWithPos, new Expression[] { lexp2, new gnu.expr.ReferenceExp(sequence) });
    


    doMap.setType(OccurrenceType.getInstance(dotArg.getType(), 0, -1));
    returnContinuation = doMap;
    
    Expression lastInit = new ApplyExp(sizeMethod, new Expression[] { new gnu.expr.ReferenceExp(sequence) });
    


    comp.letStart();
    comp.letVariable(lastArg, lastInit);
    gnu.expr.LetExp let2 = comp.letDone(gnu.kawa.functions.CompileMisc.validateApplyValuesMap(doMap, visitor, required, gnu.kawa.functions.ValuesMap.valuesMapWithPos));
    
    return comp.letDone(let2);
  }
  


  public static Expression validateApplyRelativeStep(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc)
  {
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    Expression exp1 = args[0];
    Expression exp2 = args[1];
    
    Compilation comp = visitor.getCompilation();
    LambdaExp lexp2; if ((!(exp2 instanceof LambdaExp)) || (!mustCompile) || (min_args != 3) || (max_args != 3))
    {




      return exp; }
    LambdaExp lexp2;
    lexp2.setInlineOnly(exp, visitor.getCurrentLambda());
    
    exp2 = body;
    
    Declaration dotArg = lexp2.firstDecl();
    Declaration posArg = dotArg.nextDecl();
    Declaration lastArg = posArg.nextDecl();
    

    posArg.setNext(lastArg.nextDecl());
    lastArg.setNext(null);
    min_args = 2;
    max_args = 2;
    
    Type type1 = exp1.getType();
    if ((type1 != null) && (gnu.kawa.xml.NodeType.anyNodeTest.compare(type1) == -3))
    {
      gnu.expr.Language language = visitor.getCompilation().getLanguage();
      String message = "step input is " + language.formatType(type1) + " - not a node sequence";
      visitor.getMessages().error('e', message);
      return new gnu.expr.ErrorExp(message);
    }
    
    Type rtype = exp.getTypeRaw();
    

    if ((rtype == null) || (rtype == Type.pointer_type))
    {
      Type type2 = exp2.getType();
      Type rtypePrime = OccurrenceType.itemPrimeType(type2);
      int nodeCompare = gnu.kawa.xml.NodeType.anyNodeTest.compare(rtypePrime);
      if (nodeCompare >= 0) {
        rtype = gnu.kawa.xml.NodeSetType.getInstance(rtypePrime);
      } else
        rtype = OccurrenceType.getInstance(rtypePrime, 0, -1);
      exp.setType(rtype);
    }
    if (lastArg.getCanRead())
    {
      ClassType typeNodes = gnu.kawa.xml.CoerceNodes.typeNodes;
      comp.letStart();
      Declaration sequence = comp.letVariable(null, typeNodes, new ApplyExp(gnu.kawa.xml.CoerceNodes.coerceNodes, new Expression[] { exp1 }));
      


      comp.letEnter();
      
      gnu.bytecode.Method sizeMethod = typeNodes.getDeclaredMethod("size", 0);
      Expression lastInit = new ApplyExp(sizeMethod, new Expression[] { new gnu.expr.ReferenceExp(sequence) });
      

      comp.letStart();
      comp.letVariable(lastArg, lastInit);
      comp.letEnter();
      gnu.expr.LetExp lastLet = comp.letDone(new ApplyExp(exp.getFunction(), new Expression[] { new gnu.expr.ReferenceExp(sequence), lexp2 }));
      


      return comp.letDone(lastLet);
    }
    
    ApplyExp result = exp;
    


    if ((exp2 instanceof ApplyExp))
    {
      ApplyExp aexp2 = (ApplyExp)exp2;
      Object proc2 = aexp2.getFunction().valueIfConstant();
      Expression vexp2;
      if (((proc2 instanceof ValuesFilter)) && (((vexp2 = aexp2.getArgs()[1]) instanceof LambdaExp)))
      {

        LambdaExp lvexp2 = (LambdaExp)vexp2;
        Declaration dot2 = lvexp2.firstDecl();
        Declaration pos2;
        if ((dot2 != null) && ((pos2 = dot2.nextDecl()) != null) && (pos2.nextDecl() == null) && (!pos2.getCanRead()) && (ClassType.make("java.lang.Number").compare(body.getType()) == -3))
        {






          exp2 = aexp2.getArg(0);
          body = exp2;
          aexp2.setArg(0, exp);
          result = aexp2;
        }
      }
    }
    

    if (((exp1 instanceof ApplyExp)) && ((exp2 instanceof ApplyExp)))
    {
      ApplyExp aexp1 = (ApplyExp)exp1;
      ApplyExp aexp2 = (ApplyExp)exp2;
      Object p1 = aexp1.getFunction().valueIfConstant();
      Object p2 = aexp2.getFunction().valueIfConstant();
      Expression exp12;
      if ((p1 == RelativeStep.relativeStep) && ((p2 instanceof gnu.kawa.xml.ChildAxis)) && (aexp1.getArgCount() == 2) && (((exp12 = aexp1.getArg(1)) instanceof LambdaExp)))
      {


        LambdaExp lexp12 = (LambdaExp)exp12;
        if (((body instanceof ApplyExp)) && (((ApplyExp)body).getFunction().valueIfConstant() == gnu.kawa.xml.DescendantOrSelfAxis.anyNode))
        {

          exp.setArg(0, aexp1.getArg(0));
          aexp2.setFunction(new QuoteExp(gnu.kawa.xml.DescendantAxis.make(((gnu.kawa.xml.ChildAxis)p2).getNodePredicate())));
        }
      }
    }
    return result;
  }
  

  public static Expression validateApplyOrderedMap(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc)
  {
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    if (args.length > 2)
    {
      Expression[] rargs = new Expression[args.length - 1];
      System.arraycopy(args, 1, rargs, 0, rargs.length);
      Expression[] xargs = new Expression[2];
      gnu.bytecode.Method makeTupleMethod = typeTuples.getDeclaredMethod("make$V", 2);
      xargs[0] = args[0];
      xargs[1] = new ApplyExp(makeTupleMethod, rargs);
      return new ApplyExp(proc, xargs);
    }
    return exp;
  }
  
  static final ClassType typeTuples = ClassType.make("gnu.xquery.util.OrderedTuples");
  

  public static void compileOrderedMap(ApplyExp exp, Compilation comp, gnu.expr.Target target, Procedure proc)
  {
    Expression[] args = exp.getArgs();
    if (args.length != 2)
    {
      ApplyExp.compile(exp, comp, target);
      return;
    }
    gnu.bytecode.CodeAttr code = comp.getCode();
    gnu.bytecode.Scope scope = code.pushScope();
    gnu.bytecode.Variable consumer = scope.addVariable(code, typeTuples, null);
    args[1].compile(comp, gnu.expr.Target.pushValue(typeTuples));
    code.emitStore(consumer);
    gnu.expr.ConsumerTarget ctarget = new gnu.expr.ConsumerTarget(consumer);
    args[0].compile(comp, ctarget);
    gnu.bytecode.Method mm = typeTuples.getDeclaredMethod("run$X", 1);
    code.emitLoad(consumer);
    gnu.expr.PrimProcedure.compileInvoke(comp, mm, target, exp.isTailCall(), 182, Type.pointer_type, false);
    
    code.popScope();
  }
  
  static final ClassType typeXDataType = ClassType.make("gnu.kawa.xml.XDataType");
  
  static final gnu.bytecode.Method castMethod = typeXDataType.getDeclaredMethod("cast", 1);
  

  public static Expression validateApplyCastAs(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc)
  {
    exp.visitArgs(visitor);
    exp = gnu.kawa.reflect.CompileReflect.inlineClassName(exp, 0, visitor);
    Expression[] args = exp.getArgs();
    if ((args.length != 2) || (!(args[0] instanceof QuoteExp)))
      return exp;
    Object type = ((QuoteExp)args[0]).getValue();
    if ((type instanceof gnu.kawa.xml.XDataType))
      return new ApplyExp(castMethod, args);
    return exp;
  }
  
  static final gnu.bytecode.Method castableMethod = typeXDataType.getDeclaredMethod("castable", 1);
  


  public static Expression validateApplyCastableAs(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc)
  {
    exp.visitArgs(visitor);
    exp = gnu.kawa.reflect.CompileReflect.inlineClassName(exp, 1, visitor);
    Expression[] args = exp.getArgs();
    if ((args.length != 2) || (!(args[1] instanceof QuoteExp)))
      return exp;
    Object type = ((QuoteExp)args[1]).getValue();
    if ((type instanceof gnu.kawa.xml.XDataType)) {
      return new ApplyExp(castableMethod, new Expression[] { args[1], args[0] });
    }
    return exp;
  }
}
