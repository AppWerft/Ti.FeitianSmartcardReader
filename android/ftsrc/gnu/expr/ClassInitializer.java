package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Type;

public class ClassInitializer
  extends Initializer
{
  ClassExp cexp;
  
  public ClassInitializer(ClassExp cexp, Field field, Compilation comp)
  {
    this.field = field;
    this.cexp = cexp;
    if (field.getStaticFlag()) {
      next = clinitChain;
      clinitChain = this;
    } else {
      LambdaExp heapLambda = cexp.getOwningLambda();
      next = initChain;
      initChain = this;
    }
  }
  

  public void emit(Compilation comp)
  {
    CodeAttr code = comp.getCode();
    if (!field.getStaticFlag())
      code.emitPushThis();
    if ((immediate) && (field.getStaticFlag()) && (cexp.type != Type.javalangClassType))
    {
      comp.compileConstant(cexp.compiledType);
    } else
      cexp.compilePushClass(comp, Target.pushValue(field.getType()));
    if (field.getStaticFlag()) {
      code.emitPutStatic(field);
    } else
      code.emitPutField(field);
    if ((cexp.compiledType == mainClass) && (cexp.clinitMethod != null)) {
      cexp.clinitMethod.body.compileWithPosition(comp, Target.Ignore);
    }
  }
}
