package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;


public class CpoolClass
  extends CpoolEntry
{
  CpoolUtf8 name;
  ObjectType clas;
  
  CpoolClass() {}
  
  CpoolClass(ConstantPool cpool, int hash, CpoolUtf8 n)
  {
    super(cpool, hash);
    name = n;
  }
  
  public int getTag() { return 7; }
  
  public final CpoolUtf8 getName()
  {
    return name;
  }
  

  public final String getStringName()
  {
    return name.string;
  }
  
  public final String getClassName()
  {
    return name.string.replace('/', '.');
  }
  

  public final ObjectType getClassType()
  {
    ObjectType otype = clas;
    if (otype != null)
      return otype;
    String name = namestring;
    if (name.charAt(0) == '[') {
      otype = (ObjectType)Type.signatureToType(name);
    } else
      otype = ClassType.make(name.replace('/', '.'));
    clas = otype;
    return otype;
  }
  
  static final int hashCode(CpoolUtf8 name)
  {
    return name.hashCode() ^ 0xF0F;
  }
  
  public int hashCode()
  {
    if (hash == 0)
      hash = hashCode(name);
    return hash;
  }
  
  void write(DataOutputStream dstr) throws IOException
  {
    dstr.writeByte(7);
    dstr.writeShort(name.index);
  }
  
  public void print(ClassTypeWriter dst, int verbosity)
  {
    if (verbosity == 1) {
      dst.print("Class ");
    } else if (verbosity > 1)
    {
      dst.print("Class name: ");
      dst.printOptionalIndex(name);
    }
    String str = name.string;
    int nlen = str.length();
    if ((nlen > 1) && (str.charAt(0) == '[')) {
      Type.printSignature(str, 0, nlen, dst);
    } else {
      dst.print(str.replace('/', '.'));
    }
  }
}
