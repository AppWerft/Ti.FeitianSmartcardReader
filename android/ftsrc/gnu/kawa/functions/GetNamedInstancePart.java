package gnu.kawa.functions;

import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;




public class GetNamedInstancePart
  extends ProcedureN
  implements Externalizable, HasSetter
{
  String pname;
  boolean isField;
  
  public GetNamedInstancePart()
  {
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateGetNamedInstancePart");
  }
  

  public GetNamedInstancePart(String name)
  {
    this();
    setPartName(name);
  }
  
  public void setPartName(String name)
  {
    setName("get-instance-part:" + name);
    if ((name.length() > 1) && (name.charAt(0) == '.'))
    {
      isField = true;
      pname = name.substring(1);
    }
    else
    {
      isField = false;
      pname = name;
    }
  }
  
  public int numArgs() { return isField ? 4097 : 61441; }
  
  public Object applyN(Object[] args) throws Throwable
  {
    checkArgCount(this, args.length);
    if (isField) {
      return SlotGet.field(args[0], pname);
    }
    
    Object[] xargs = new Object[args.length + 1];
    xargs[0] = args[0];
    xargs[1] = pname;
    System.arraycopy(args, 1, xargs, 2, args.length - 1);
    return Invoke.invoke.applyN(xargs);
  }
  

  public Procedure getSetter()
  {
    if (!isField)
      throw new RuntimeException("no setter for instance method call");
    return new SetNamedInstancePart(pname);
  }
  
  public void writeExternal(ObjectOutput out) throws IOException
  {
    out.writeObject(isField ? "." + pname : pname);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    setPartName((String)in.readObject());
  }
}
