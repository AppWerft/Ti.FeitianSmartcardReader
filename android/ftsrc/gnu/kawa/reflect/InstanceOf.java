package gnu.kawa.reflect;

import gnu.expr.Language;

public class InstanceOf extends gnu.mapping.Procedure2 implements gnu.expr.Inlineable
{
  protected Language language;
  static gnu.bytecode.ClassType typeType;
  static gnu.bytecode.Method instanceMethod;
  
  public InstanceOf(Language language) {
    this.language = language;
    setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplyInstanceOf");
  }
  

  public InstanceOf(Language language, String name)
  {
    this(language);
    setName(name);
  }
  
  public Object apply2(Object arg1, Object arg2)
  {
    gnu.bytecode.Type type = language.asType(arg2);
    if ((type instanceof gnu.bytecode.PrimType))
      type = ((gnu.bytecode.PrimType)type).boxedType();
    return language.booleanObject(type.isInstance(arg1));
  }
  



  public void compile(gnu.expr.ApplyExp exp, gnu.expr.Compilation comp, gnu.expr.Target target)
  {
    gnu.expr.Expression[] args = exp.getArgs();
    gnu.bytecode.CodeAttr code = comp.getCode();
    gnu.bytecode.Type type = null;
    gnu.expr.Expression typeArg = args[1];
    if ((typeArg instanceof gnu.expr.QuoteExp))
    {
      try
      {
        type = language.asType(((gnu.expr.QuoteExp)typeArg).getValue());
      }
      catch (Exception ex)
      {
        comp.error('w', "unknown type spec: " + type, typeArg);
      }
      
    } else
      type = language.getTypeFor(typeArg);
    if (type != null)
    {
      if ((type instanceof gnu.bytecode.PrimType))
        type = ((gnu.bytecode.PrimType)type).boxedType();
      args[0].compile(comp, gnu.expr.Target.pushObject);
      if ((type instanceof gnu.expr.TypeValue))
      {
        ((gnu.expr.TypeValue)type).emitIsInstance(null, comp, target);
        return;
      }
      
      type.getImplementationType().emitIsInstance(code);
      comp.usedClass(type);
    }
    else
    {
      if (typeType == null)
      {
        typeType = gnu.bytecode.ClassType.make("gnu.bytecode.Type");
        instanceMethod = typeType.addMethod("isInstance", gnu.expr.Compilation.apply1args, gnu.bytecode.Type.boolean_type, 1);
      }
      


      args[1].compile(comp, typeType);
      args[0].compile(comp, gnu.expr.Target.pushObject);
      code.emitInvokeVirtual(instanceMethod);
    }
    target.compileFromStack(comp, language.getTypeFor(Boolean.TYPE));
  }
  
  public gnu.bytecode.Type getReturnType(gnu.expr.Expression[] args)
  {
    return language.getTypeFor(Boolean.TYPE);
  }
  

  public static void emitIsInstance(gnu.expr.TypeValue type, gnu.bytecode.Variable incoming, gnu.expr.Compilation comp, gnu.expr.Target target)
  {
    gnu.bytecode.CodeAttr code = comp.getCode();
    type.emitTestIf(null, null, comp);
    gnu.expr.ConditionalTarget cond = null;
    if ((target instanceof gnu.expr.ConditionalTarget))
    {
      cond = (gnu.expr.ConditionalTarget)target;
      code.emitGoto(ifTrue);
    }
    else {
      code.emitPushInt(1); }
    code.emitElse();
    if (cond != null) {
      code.emitGoto(ifFalse);
    } else
      code.emitPushInt(0);
    code.emitFi();
    if (cond == null) {
      target.compileFromStack(comp, comp.getLanguage().getTypeFor(Boolean.TYPE));
    }
  }
}
