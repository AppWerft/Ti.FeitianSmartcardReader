package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;







public class CpoolRef
  extends CpoolEntry
{
  CpoolClass clas;
  CpoolNameAndType nameAndType;
  int tag;
  
  public int getTag()
  {
    return tag;
  }
  
  public final CpoolClass getCpoolClass() {
    return clas;
  }
  
  public final CpoolNameAndType getNameAndType()
  {
    return nameAndType;
  }
  
  CpoolRef(int tag) { this.tag = tag; }
  

  CpoolRef(ConstantPool cpool, int hash, int tag, CpoolClass clas, CpoolNameAndType nameAndType)
  {
    super(cpool, hash);
    this.tag = tag;
    this.clas = clas;
    this.nameAndType = nameAndType;
  }
  
  static final int hashCode(CpoolClass clas, CpoolNameAndType nameAndType)
  {
    return clas.hashCode() ^ nameAndType.hashCode();
  }
  
  public int hashCode()
  {
    if (hash == 0)
      hash = hashCode(clas, nameAndType);
    return hash;
  }
  
  void write(DataOutputStream dstr) throws IOException
  {
    dstr.writeByte(tag);
    dstr.writeShort(clas.index);
    dstr.writeShort(nameAndType.index);
  }
  
  public void print(ClassTypeWriter dst, int verbosity)
  {
    String str;
    switch (tag) {
    case 9: 
      str = "Field"; break;
    case 10:  str = "Method"; break;
    case 11:  str = "InterfaceMethod"; break;
    default:  str = "<Unknown>Ref";
    }
    if (verbosity > 0)
    {
      dst.print(str);
      if (verbosity == 2)
      {
        dst.print(" class: ");
        dst.printOptionalIndex(clas);
      }
      else {
        dst.print(' ');
      } }
    clas.print(dst, 0);
    if (verbosity < 2) {
      dst.print('.');
    }
    else {
      dst.print(" name_and_type: ");
      dst.printOptionalIndex(nameAndType);
      dst.print('<');
    }
    nameAndType.print(dst, 0);
    if (verbosity == 2) {
      dst.print('>');
    }
  }
}
