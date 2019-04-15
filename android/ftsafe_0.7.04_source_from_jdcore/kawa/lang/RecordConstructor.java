package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.lists.Pair;

public class RecordConstructor extends gnu.mapping.ProcedureN
{
  ClassType type;
  gnu.bytecode.Field[] fields;
  
  public RecordConstructor(ClassType type, gnu.bytecode.Field[] fields)
  {
    this.type = type;
    this.fields = fields;
  }
  
  public RecordConstructor(Class clas, gnu.bytecode.Field[] fields)
  {
    this((ClassType)gnu.bytecode.Type.make(clas), fields);
  }
  
  public RecordConstructor(Class clas)
  {
    init((ClassType)gnu.bytecode.Type.make(clas));
  }
  
  public RecordConstructor(ClassType type)
  {
    init(type);
  }
  
  private void init(ClassType type)
  {
    this.type = type;
    gnu.bytecode.Field list = type.getFields();
    int count = 0;
    for (gnu.bytecode.Field fld = list; fld != null; fld = fld.getNext())
    {
      if ((fld.getModifiers() & 0x9) == 1)
      {
        count++; }
    }
    fields = new gnu.bytecode.Field[count];
    int i = 0;
    for (gnu.bytecode.Field fld = list; fld != null; fld = fld.getNext())
    {
      if ((fld.getModifiers() & 0x9) == 1)
      {
        fields[(i++)] = fld;
      }
    }
  }
  
  public RecordConstructor(Class clas, Object fieldsList) {
    this((ClassType)gnu.bytecode.Type.make(clas), fieldsList);
  }
  
  public RecordConstructor(ClassType type, Object fieldsList)
  {
    this.type = type;
    if (fieldsList == null) {
      init(type);
    }
    else {
      int nfields = gnu.lists.LList.listLength(fieldsList, false);
      fields = new gnu.bytecode.Field[nfields];
      gnu.bytecode.Field list = type.getFields();
      for (int i = 0; i < nfields; i++)
      {
        Pair pair = (Pair)fieldsList;
        String fname = pair.getCar().toString();
        for (gnu.bytecode.Field fld = list;; fld = fld.getNext())
        {
          if (fld == null)
            throw new RuntimeException("no such field " + fname + " in " + type.getName());
          if (fld.getSourceName() == fname)
          {
            fields[i] = fld;
            break;
          }
        }
        fieldsList = pair.getCdr();
      }
    }
  }
  
  public int numArgs()
  {
    int nargs = fields.length;
    return nargs << 12 | nargs;
  }
  
  public String getName()
  {
    return type.getName() + " constructor";
  }
  
  public Object applyN(Object[] args)
  {
    Object obj;
    try
    {
      obj = type.getReflectClass().newInstance();
    }
    catch (InstantiationException ex)
    {
      throw new GenericError(ex.toString());
    }
    catch (IllegalAccessException ex)
    {
      throw new GenericError(ex.toString());
    }
    if (args.length != fields.length)
      throw new gnu.mapping.WrongArguments(this, args.length);
    for (int i = 0; i < args.length; i++)
    {
      gnu.bytecode.Field fld = fields[i];
      try
      {
        fld.getReflectField().set(obj, args[i]);
      }
      catch (Exception ex)
      {
        throw new gnu.mapping.WrappedException("illegal access for field " + fld.getName(), ex);
      }
    }
    return obj;
  }
}
