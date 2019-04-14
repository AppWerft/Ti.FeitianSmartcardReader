package gnu.expr;

import gnu.bytecode.Variable;
import gnu.mapping.Procedure;

public abstract interface TypeValue
  extends java.lang.reflect.Type
{
  public abstract gnu.bytecode.Type getImplementationType();
  
  public abstract void emitTestIf(Variable paramVariable, Declaration paramDeclaration, Compilation paramCompilation);
  
  public abstract void emitIsInstance(Variable paramVariable, Compilation paramCompilation, Target paramTarget);
  
  public abstract Procedure getConstructor();
  
  public abstract Expression convertValue(Expression paramExpression);
  
  public abstract String encodeType(Language paramLanguage);
}
