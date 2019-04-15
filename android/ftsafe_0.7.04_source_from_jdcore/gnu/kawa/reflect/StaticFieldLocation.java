package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.expr.Declaration;

public class StaticFieldLocation extends FieldLocation
{
  public StaticFieldLocation(String cname, String fname)
  {
    super(null, cname, fname);
  }
  
  public StaticFieldLocation(ClassType type, String mname)
  {
    super(null, type, mname);
  }
  
  public StaticFieldLocation(java.lang.reflect.Field field)
  {
    super(null, field);
  }
  
  public Object get(Object defaultValue)
  {
    Object val = super.get(defaultValue);
    if ((val instanceof kawa.lang.Macro))
      getDeclaration();
    return val;
  }
  


  public static StaticFieldLocation define(gnu.mapping.Environment environ, gnu.mapping.Symbol sym, Object property, String cname, String fname)
  {
    StaticFieldLocation loc = new StaticFieldLocation(cname, fname);
    environ.addLocation(sym, property, loc);
    return loc;
  }
  
  public static StaticFieldLocation make(Declaration decl)
  {
    gnu.bytecode.Field fld = field;
    ClassType ctype = fld.getDeclaringClass();
    StaticFieldLocation loc = new StaticFieldLocation(ctype, fld.getName());
    loc.setDeclaration(decl);
    
    return loc;
  }
  
  public static StaticFieldLocation make(String cname, String fldName)
  {
    return new StaticFieldLocation(cname, fldName);
  }
}
