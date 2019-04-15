package gnu.bytecode;

public abstract interface AttrContainer
{
  public abstract Attribute getAttributes();
  
  public abstract void setAttributes(Attribute paramAttribute);
  
  public abstract ConstantPool getConstants();
}
