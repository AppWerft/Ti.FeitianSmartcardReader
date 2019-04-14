package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;




public class CpoolNameAndType
  extends CpoolEntry
{
  CpoolUtf8 name;
  CpoolUtf8 type;
  
  CpoolNameAndType() {}
  
  CpoolNameAndType(ConstantPool cpool, int hash, CpoolUtf8 n, CpoolUtf8 t)
  {
    super(cpool, hash);
    name = n;
    type = t;
  }
  
  public int getTag() { return 12; }
  
  public final CpoolUtf8 getName()
  {
    return name;
  }
  
  public final CpoolUtf8 getType()
  {
    return type;
  }
  
  static final int hashCode(CpoolUtf8 name, CpoolUtf8 type)
  {
    return name.hashCode() ^ type.hashCode();
  }
  
  public int hashCode()
  {
    if (hash == 0)
      hash = hashCode(name, type);
    return hash;
  }
  
  void write(DataOutputStream dstr) throws IOException
  {
    dstr.writeByte(12);
    dstr.writeShort(name.index);
    dstr.writeShort(type.index);
  }
  
  public void print(ClassTypeWriter dst, int verbosity)
  {
    if (verbosity == 1) {
      dst.print("NameAndType ");
    } else if (verbosity > 1)
    {
      dst.print("NameAndType name: ");
      dst.printOptionalIndex(name);
    }
    dst.printName(name.string);
    if (verbosity <= 1) {
      dst.print(' ');
    }
    else {
      dst.print(", signature: ");
      dst.printOptionalIndex(type);
    }
    dst.printSignature(type.string);
  }
}
