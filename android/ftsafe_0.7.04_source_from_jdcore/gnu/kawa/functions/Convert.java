package gnu.kawa.functions;

import gnu.bytecode.Type;

public class Convert extends gnu.mapping.Procedure2
{
  boolean lenient;
  public static final Convert as = new Convert("as", true);
  
  static { as.setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyConvert");
    
    as.setProperty(gnu.mapping.Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileConvert");
    

    cast = new Convert("cast", false);
    
    cast.setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyConvert");
    
    cast.setProperty(gnu.mapping.Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileConvert");
  }
  
  public Convert(String name, boolean lenient)
  {
    super(name);
    this.lenient = lenient;
  }
  
  public static final Convert cast;
  public static Convert getInstance() { return as; }
  
  public Object apply2(Object arg1, Object arg2) {
    Type type;
    Type type;
    if ((arg1 instanceof Class)) {
      type = Type.make((Class)arg1);
    } else
      type = (Type)arg1;
    return type.coerceFromObject(arg2);
  }
}
