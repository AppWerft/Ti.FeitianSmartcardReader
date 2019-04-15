package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.mapping.HasNamedParts;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.Values.FromTreeList;

public class GetNamedPart extends gnu.mapping.Procedure2 implements gnu.mapping.HasSetter
{
  public static final GetNamedPart getNamedPart = new GetNamedPart();
  
  static { getNamedPart.setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateGetNamedPart"); }
  



  public static final String CLASSTYPE_FOR = "<>";
  

  public static final String CAST_METHOD_NAME = "@";
  

  public static final String INSTANCEOF_METHOD_NAME = "instance?";
  

  public Object apply2(Object container, Object part)
    throws Throwable
  {
    if ((container instanceof Values))
    {
      Object[] values = ((Values)container).getValues();
      Values.FromTreeList result = new Values.FromTreeList();
      for (int i = 0; i < values.length; i++)
      {
        result.writeObject(apply2(values[i], part));
      }
      return result.canonicalize(); }
    Symbol sym;
    Symbol sym;
    if ((part instanceof Symbol)) {
      sym = (Symbol)part;
    } else
      sym = gnu.mapping.Namespace.EmptyNamespace.getSymbol(part.toString().intern());
    return getNamedPart(container, sym);
  }
  
  public static Object getTypePart(Type type, String name)
    throws Exception
  {
    if (name.equals("<>")) {
      return type;
    }
    if ((type instanceof gnu.bytecode.ObjectType))
    {
      if (name.equals("instance?"))
        return new NamedPart(type, name, 'I');
      if (name.equals("@"))
        return new NamedPart(type, name, 'C');
      if (name.equals("new"))
        return new NamedPart(type, name, 'N');
      if ((name.equals(".length")) || ((name.length() > 1) && (name.charAt(0) == '.') && ((type instanceof ClassType))))
      {

        return new NamedPart(type, name, 'D');
      }
    }
    if ((type instanceof ClassType))
    {
      try
      {
        return gnu.kawa.reflect.SlotGet.staticField(type, name);

      }
      catch (Exception ex)
      {

        return gnu.kawa.reflect.ClassMethods.apply(gnu.kawa.reflect.ClassMethods.classMethods, type, name);
      } }
    return getMemberPart(type, name);
  }
  
  public static Object getNamedPart(Object container, Symbol part)
    throws Exception
  {
    String name = part.getName();
    container = gnu.mapping.Promise.force(container);
    if ((container instanceof HasNamedParts))
      return ((HasNamedParts)container).get(name);
    if ((container instanceof Class))
      container = Type.make((Class)container);
    if ((container instanceof Package))
    {
      try
      {
        String pname = ((Package)container).getName();
        return ClassType.getContextClass(pname + '.' + name);
      }
      catch (Exception ex) {}
    }
    

    if ((container instanceof Type))
      return getTypePart((Type)container, name);
    return getMemberPart(container, part.toString());
  }
  
  public static Object getMemberPart(Object container, String name)
    throws Exception
  {
    try
    {
      return gnu.kawa.reflect.SlotGet.field(container, name);

    }
    catch (Exception ex)
    {

      gnu.mapping.MethodProc methods = gnu.kawa.reflect.ClassMethods.apply((gnu.bytecode.ObjectType)ClassType.make(container.getClass()), gnu.expr.Mangling.mangleName(name), '\000', gnu.expr.Language.getDefaultLanguage());
      

      if (methods != null)
        return new NamedPart(container, name, 'M', methods);
      throw new RuntimeException("no part '" + name + "' in " + container);
    }
  }
  
  public gnu.mapping.Procedure getSetter() {
    return SetNamedPart.setNamedPart;
  }
  
  public GetNamedPart() {}
}
