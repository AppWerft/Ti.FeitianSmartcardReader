package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;


public class IsEq
  extends Procedure2
{
  Language language;
  
  public IsEq(Language language, String name)
  {
    this.language = language;
    setName(name);
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplySimpleBoolean");
    
    setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileEq");
  }
  

  public boolean apply(Object arg1, Object arg2)
  {
    return arg1 == arg2;
  }
  
  public Object apply2(Object arg1, Object arg2)
  {
    return language.booleanObject(arg1 == arg2);
  }
}
