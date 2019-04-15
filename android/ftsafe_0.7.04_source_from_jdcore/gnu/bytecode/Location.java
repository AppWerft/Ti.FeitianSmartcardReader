package gnu.bytecode;


public class Location
{
  protected String name;
  
  private Type type;
  int name_index;
  int signature_index;
  
  public Location() {}
  
  public final String getName()
  {
    return name;
  }
  
  public final void setName(String name)
  {
    this.name = name;
  }
  
  public final void setName(int name_index, ConstantPool constants)
  {
    if (name_index <= 0) {
      name = null;
    }
    else {
      CpoolUtf8 nameConstant = (CpoolUtf8)constants.getForced(name_index, 1);
      
      name = string;
    }
    this.name_index = name_index;
  }
  
  public Type getType() {
    return type;
  }
  
  public final void setType(Type type)
  {
    this.type = type;
  }
  
  public final String getSignature() { return getType().getRawType().getSignature(); }
  
  public void setSignature(int signature_index, ConstantPool constants)
  {
    CpoolUtf8 sigConstant = (CpoolUtf8)constants.getForced(signature_index, 1);
    
    this.signature_index = signature_index;
    type = Type.signatureToType(string);
  }
}
