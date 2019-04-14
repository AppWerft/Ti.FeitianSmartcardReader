package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.Values;

public class SetNamedPart extends gnu.mapping.Procedure3 implements gnu.mapping.HasSetter
{
  public static final SetNamedPart setNamedPart = new SetNamedPart();
  
  static { setNamedPart.setName("setNamedPart");
    setNamedPart.setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateSetNamedPart");
  }
  





  public Object apply3(Object container, Object part, Object value)
  {
    if ((container instanceof Namespace))
    {
      Namespace ns = (Namespace)container;
      String uri = ns.getName();
      if (uri.startsWith("class:")) {
        container = ClassType.make(uri.substring(6));
      }
      else {
        gnu.mapping.Symbol sym = ns.getSymbol(part.toString());
        Environment env = Environment.getCurrent();
        Environment.getCurrent().put(sym, value);
        return Values.empty;
      }
    }
    if ((container instanceof Class))
      container = (ClassType)gnu.bytecode.Type.make((Class)container);
    if ((container instanceof ClassType))
    {
      try
      {
        gnu.kawa.reflect.SlotSet.setStaticField(container, part.toString(), value);
        return Values.empty;
      }
      catch (Exception ex) {}
    }
    



    gnu.kawa.reflect.SlotSet.setField(container, part.toString(), value);
    return Values.empty;
  }
  
  public SetNamedPart() {}
}
