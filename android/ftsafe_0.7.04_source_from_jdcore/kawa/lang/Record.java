package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.lists.LList;
import gnu.lists.Pair;

public class Record
{
  public Record() {}
  
  public String getTypeName()
  {
    return getClass().getName();
  }
  
  public static boolean isRecord(Object obj) { return obj instanceof Record; }
  
  public int hashCode()
  {
    java.lang.reflect.Field[] fields = getClass().getFields();
    int hash = 12345;
    for (int i = 0; i < fields.length; i++)
    {
      java.lang.reflect.Field field = fields[i];
      Object value;
      try
      {
        value = field.get(this);
      }
      catch (IllegalAccessException ex)
      {
        continue;
      }
      if (value != null)
        hash ^= value.hashCode();
    }
    return hash;
  }
  
  static java.lang.reflect.Field getField(Class clas, String fname)
    throws NoSuchFieldException
  {
    ClassType ctype = (ClassType)Type.make(clas);
    for (gnu.bytecode.Field fld = ctype.getFields(); 
        fld != null; fld = fld.getNext())
    {
      if ((fld.getModifiers() & 0x9) == 1)
      {

        if (fld.getSourceName().equals(fname))
        {
          return fld.getReflectField(); } }
    }
    throw new NoSuchFieldException();
  }
  
  public Object get(String fname, Object defaultValue)
  {
    Class clas = getClass();
    try
    {
      return getField(clas, fname).get(this);

    }
    catch (NoSuchFieldException ex)
    {
      throw new GenericError("no such field " + fname + " in " + clas.getName());
    }
    catch (IllegalAccessException ex)
    {
      throw new GenericError("illegal access for field " + fname);
    }
  }
  
  public Object put(String fname, Object value)
  {
    return set1(this, fname, value);
  }
  
  public static Object set1(Object record, String fname, Object value)
  {
    Class clas = record.getClass();
    try
    {
      java.lang.reflect.Field fld = getField(clas, fname);
      Object old = fld.get(record);
      fld.set(record, value);
      return old;

    }
    catch (NoSuchFieldException ex)
    {
      throw new GenericError("no such field " + fname + " in " + clas.getName());
    }
    catch (IllegalAccessException ex)
    {
      throw new GenericError("illegal access for field " + fname);
    }
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    Class thisClass = getClass();
    if ((obj == null) || (obj.getClass() != thisClass))
      return false;
    ClassType ctype = (ClassType)Type.make(thisClass);
    for (gnu.bytecode.Field fld = ctype.getFields(); 
        fld != null; fld = fld.getNext())
    {
      if ((fld.getModifiers() & 0x9) == 1)
      {
        Object value1;
        Object value2;
        try
        {
          java.lang.reflect.Field field = fld.getReflectField();
          value1 = field.get(this);
          value2 = field.get(obj);
        }
        catch (Exception ex)
        {
          throw new gnu.mapping.WrappedException(ex);
        }
        if (!value1.equals(value2))
          return false;
      } }
    return true;
  }
  
  public String toString()
  {
    StringBuffer buf = new StringBuffer(200);
    buf.append("#<");
    buf.append(getTypeName());
    ClassType ctype = (ClassType)Type.make(getClass());
    for (gnu.bytecode.Field fld = ctype.getFields(); 
        fld != null; fld = fld.getNext())
    {
      if ((fld.getModifiers() & 0x9) == 1)
      {
        Object value;
        
        try
        {
          java.lang.reflect.Field field = fld.getReflectField();
          value = field.get(this);
        }
        catch (Exception ex)
        {
          value = "#<illegal-access>";
        }
        buf.append(' ');
        buf.append(fld.getSourceName());
        buf.append(": ");
        buf.append(value);
      } }
    buf.append(">");
    return buf.toString();
  }
  
  public void print(java.io.PrintWriter ps)
  {
    ps.print(toString());
  }
  
  public static ClassType makeRecordType(String name, LList fnames)
  {
    ClassType superClass = ClassType.make("kawa.lang.Record");
    String mangledName = gnu.expr.Mangling.mangleClassName(name);
    ClassType clas = new ClassType(mangledName);
    clas.setClassfileVersion(gnu.expr.Compilation.defaultClassFileVersion);
    clas.setSuper(superClass);
    clas.setModifiers(33);
    

    gnu.bytecode.Method constructor = clas.addMethod("<init>", Type.typeArray0, Type.voidType, 1);
    
    gnu.bytecode.Method superConstructor = superClass.addMethod("<init>", Type.typeArray0, Type.voidType, 1);
    

    CodeAttr code = constructor.startCode();
    code.emitPushThis();
    code.emitInvokeSpecial(superConstructor);
    code.emitReturn();
    if (!name.equals(mangledName))
    {
      gnu.bytecode.Method meth = clas.addMethod("getTypeName", Type.typeArray0, gnu.expr.Compilation.typeString, 1);
      
      code = meth.startCode();
      code.emitPushString(name);
      code.emitReturn();
    }
    


    while (fnames != LList.Empty)
    {
      Pair pair = (Pair)fnames;
      String fname = pair.getCar().toString();
      
      gnu.bytecode.Field fld = clas.addField(gnu.expr.Mangling.mangleNameIfNeeded(fname), Type.pointer_type, 1);
      
      fld.setSourceName(fname.intern());
      fnames = (LList)pair.getCdr();
    }
    






    byte[][] arrays = new byte[1][];
    String[] names = new String[1];
    names[0] = mangledName;
    arrays[0] = clas.writeToArray();
    gnu.bytecode.ArrayClassLoader loader = new gnu.bytecode.ArrayClassLoader(names, arrays);
    try
    {
      Class reflectClass = loader.loadClass(mangledName);
      Type.registerTypeForClass(reflectClass, clas);
      return clas;
    }
    catch (ClassNotFoundException ex)
    {
      throw new InternalError(ex.toString());
    }
  }
  
  public static LList typeFieldNames(Class clas)
  {
    LList list = LList.Empty;
    





















    ClassType ctype = (ClassType)Type.make(clas);
    gnu.bytecode.Field field = ctype.getFields();
    java.util.Vector vec = new java.util.Vector(100);
    for (; field != null; field = field.getNext())
    {
      if ((field.getModifiers() & 0x9) == 1)
      {
        vec.addElement(gnu.mapping.SimpleSymbol.valueOf(field.getSourceName())); }
    }
    int i = vec.size(); for (;;) { i--; if (i < 0)
        break;
      list = new Pair(vec.elementAt(i), list);
    }
    return list;
  }
  
  public static LList typeFieldNames(ClassType ctype)
  {
    return typeFieldNames(ctype.getReflectClass());
  }
}
