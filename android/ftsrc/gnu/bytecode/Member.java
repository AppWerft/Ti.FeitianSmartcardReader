package gnu.bytecode;

public abstract interface Member
{
  public abstract ClassType getDeclaringClass();
  
  public abstract String getName();
  
  public abstract void setName(String paramString);
  
  public abstract int getModifiers();
  
  public abstract boolean getStaticFlag();
}
