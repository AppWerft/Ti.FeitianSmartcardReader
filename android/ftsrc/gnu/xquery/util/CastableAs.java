package gnu.xquery.util;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Target;
import gnu.kawa.reflect.InstanceOf;
import gnu.kawa.xml.XDataType;

public class CastableAs extends InstanceOf
{
  public static CastableAs castableAs = new CastableAs();
  
  CastableAs()
  {
    super(gnu.xquery.lang.XQuery.getInstance(), "castable as");
    setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyCastableAs");
  }
  

  public Object apply2(Object arg1, Object arg2)
  {
    Type type = language.asType(arg2);
    boolean result;
    boolean result; if ((type instanceof XDataType)) {
      result = ((XDataType)type).castable(arg1);
    } else
      result = type.isInstance(arg1);
    return language.booleanObject(result);
  }
  

  public void compile(ApplyExp exp, gnu.expr.Compilation comp, Target target)
  {
    ApplyExp.compile(exp, comp, target);
  }
}
