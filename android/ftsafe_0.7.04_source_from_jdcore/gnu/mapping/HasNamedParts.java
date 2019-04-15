package gnu.mapping;

public abstract interface HasNamedParts
{
  public abstract Object get(String paramString);
  
  public abstract boolean isConstant(String paramString);
}
