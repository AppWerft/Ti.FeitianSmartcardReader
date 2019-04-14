package gnu.kawa.reflect;

import gnu.bytecode.CodeAttr;
import gnu.expr.ApplyExp;

public class CompileArrays
{
  public CompileArrays() {}
  
  public static gnu.expr.Expression validateArrayNew(ApplyExp exp, gnu.expr.InlineCalls visitor, gnu.bytecode.Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    exp.setType(gnu.bytecode.ArrayType.make(element_type));
    return exp;
  }
  

  public static gnu.expr.Expression validateArrayLength(ApplyExp exp, gnu.expr.InlineCalls visitor, gnu.bytecode.Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    exp.setType(gnu.kawa.lispexpr.LangPrimType.intType);
    return exp;
  }
  

  public static gnu.expr.Expression validateArrayGet(ApplyExp exp, gnu.expr.InlineCalls visitor, gnu.bytecode.Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    exp.setType(element_type);
    return exp;
  }
  

  public static gnu.expr.Expression validateArraySet(ApplyExp exp, gnu.expr.InlineCalls visitor, gnu.bytecode.Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    exp.setType(gnu.bytecode.Type.void_type);
    return exp;
  }
  
  public static boolean compileGet(ApplyExp exp, gnu.expr.Compilation comp, gnu.expr.Target target, gnu.mapping.Procedure proc)
  {
    if (!exp.isSimple())
      return false;
    gnu.bytecode.Type element_type = element_type;
    gnu.expr.Expression[] args = exp.getArgs();
    args[0].compile(comp, gnu.bytecode.ArrayType.make(element_type));
    args[1].compile(comp, gnu.bytecode.Type.int_type);
    CodeAttr code = comp.getCode();
    code.emitArrayLoad(element_type);
    target.compileFromStack(comp, element_type);
    return true;
  }
  
  public static boolean compileSet(ApplyExp exp, gnu.expr.Compilation comp, gnu.expr.Target target, gnu.mapping.Procedure proc)
  {
    if (!exp.isSimple())
      return false;
    gnu.bytecode.Type element_type = element_type;
    gnu.expr.Expression[] args = exp.getArgs();
    args[0].compile(comp, gnu.bytecode.ArrayType.make(element_type));
    args[1].compile(comp, gnu.bytecode.Type.int_type);
    gnu.expr.Target valueTarget = gnu.expr.StackTarget.getTruncatingInstance(element_type);
    args[2].compile(comp, valueTarget);
    comp.getCode().emitArrayStore(element_type);
    comp.compileConstant(gnu.mapping.Values.empty, target);
    return true;
  }
  
  public static boolean compileNew(ApplyExp exp, gnu.expr.Compilation comp, gnu.expr.Target target, gnu.mapping.Procedure proc)
  {
    if (!exp.isSimple())
      return false;
    gnu.bytecode.Type element_type = element_type;
    CodeAttr code = comp.getCode();
    exp.getArgs()[0].compile(comp, gnu.bytecode.Type.intType);
    code.emitNewArray(element_type.getImplementationType());
    target.compileFromStack(comp, gnu.bytecode.ArrayType.make(element_type));
    return true;
  }
  
  public static boolean compileLength(ApplyExp exp, gnu.expr.Compilation comp, gnu.expr.Target target, gnu.mapping.Procedure proc)
  {
    if (!exp.isSimple())
      return false;
    gnu.bytecode.Type element_type = element_type;
    exp.getArgs()[0].compile(comp, gnu.bytecode.ArrayType.make(element_type));
    CodeAttr code = comp.getCode();
    code.emitArrayLength();
    target.compileFromStack(comp, gnu.kawa.lispexpr.LangPrimType.intType);
    return true;
  }
  
  public static boolean compileMake(ApplyExp exp, gnu.expr.Compilation comp, gnu.expr.Target target, gnu.mapping.Procedure proc)
  {
    gnu.bytecode.Type elementType = elementType;
    gnu.expr.Expression[] args = exp.getArgs();
    createArray(elementType, comp, args, 0, args.length);
    target.compileFromStack(comp, gnu.bytecode.ArrayType.make(elementType));
    return true;
  }
  

  public static void createArray(gnu.bytecode.Type elementType, gnu.expr.Compilation comp, gnu.expr.Expression[] args, int start, int end)
  {
    CodeAttr code = comp.getCode();
    
    int countNonSplice = 0;
    int lastSplice = -1;
    for (int i = start; i < end; i++) {
      if (gnu.kawa.functions.MakeSplice.argIfSplice(args[i]) == null) {
        countNonSplice++;
      } else
        lastSplice = i;
    }
    code.pushScope();
    code.emitPushInt(countNonSplice);
    gnu.bytecode.Variable arrSizeVar;
    gnu.bytecode.Variable arrSizeVar;
    if (lastSplice < 0) {
      arrSizeVar = null;
    } else {
      arrSizeVar = code.addLocal(gnu.bytecode.Type.intType);
      code.emitStore(arrSizeVar);
    }
    
    gnu.bytecode.ClassType utilType = gnu.bytecode.ClassType.make("gnu.kawa.functions.MakeSplice");
    gnu.bytecode.Method countMethod = utilType.getDeclaredMethod("count", 1);
    gnu.bytecode.Method copyToMethod4 = utilType.getDeclaredMethod("copyTo", 4);
    gnu.bytecode.Method copyToMethod5 = utilType.getDeclaredMethod("copyTo", 5);
    
    gnu.bytecode.Variable[] tmpVars = new gnu.bytecode.Variable[end - start];
    gnu.bytecode.Variable[] sizeVars = new gnu.bytecode.Variable[end - start];
    
    if (lastSplice >= 0)
    {
      for (int i = start; i < end; i++) {
        gnu.expr.Expression arg = args[i];
        gnu.expr.Expression argIfSplice = gnu.kawa.functions.MakeSplice.argIfSplice(arg);
        if ((argIfSplice != null) || ((arg.side_effects()) && (i < lastSplice)))
        {
          if (argIfSplice != null) {
            argIfSplice.compile(comp, gnu.expr.Target.pushObject);
          } else
            arg.compile(comp, elementType);
          gnu.bytecode.Variable tmpVar = code.addLocal(argIfSplice != null ? gnu.bytecode.Type.objectType : elementType);
          

          code.emitStore(tmpVar);
          tmpVars[(i - start)] = tmpVar;
          if (argIfSplice != null) {
            gnu.bytecode.Variable sizeVar = code.addLocal(gnu.bytecode.Type.intType);
            sizeVars[(i - start)] = sizeVar;
            
            code.emitLoad(tmpVar);
            code.emitInvoke(countMethod);
            code.emitDup();
            code.emitStore(sizeVar);
            
            code.emitLoad(arrSizeVar);
            code.emitAdd();
            code.emitStore(arrSizeVar);
          }
        }
      }
    }
    
    if (lastSplice >= 0)
      code.emitLoad(arrSizeVar);
    code.emitNewArray(elementType.getImplementationType());
    
    gnu.bytecode.Variable offsetVar = null;
    
    for (int i = start; i < end; i++)
    {
      code.emitDup();
      gnu.expr.Expression arg = args[i];
      gnu.expr.Expression argIfSplice = gnu.kawa.functions.MakeSplice.argIfSplice(arg);
      if (argIfSplice != null)
      {
        if (offsetVar == null) {
          offsetVar = code.addLocal(gnu.bytecode.Type.intType);
          code.emitPushInt(i - start);
          code.emitStore(offsetVar);
        }
        code.emitLoad(offsetVar);
        code.emitLoad(sizeVars[(i - start)]);
        code.emitLoad(tmpVars[(i - start)]);
        if (elementType == gnu.bytecode.Type.objectType) {
          code.emitInvoke(copyToMethod4);
        } else {
          comp.compileConstant(elementType, gnu.expr.Target.pushObject);
          code.emitInvoke(copyToMethod5);
        }
        
        code.emitLoad(offsetVar);
        code.emitLoad(sizeVars[(i - start)]);
        code.emitAdd();
        code.emitStore(offsetVar);
      }
      else {
        if (offsetVar == null) {
          code.emitPushInt(i - start);
        } else
          code.emitLoad(offsetVar);
        gnu.bytecode.Variable savedValue = tmpVars[(i - start)];
        if (savedValue != null) {
          code.emitLoad(savedValue);
        } else
          arg.compile(comp, elementType);
        code.emitArrayStore(elementType);
        if (offsetVar != null)
          code.emitInc(offsetVar, (short)1);
      }
    }
    code.popScope();
  }
}
