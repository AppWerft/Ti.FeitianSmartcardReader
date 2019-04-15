package gnu.mapping;

public class ReadOnlyLocation
  extends ConstrainedLocation
{
  public ReadOnlyLocation() {}
  
  public static ReadOnlyLocation make(Location base)
  {
    ReadOnlyLocation rloc = new ReadOnlyLocation();
    base = base;
    return rloc;
  }
  
  public boolean isConstant()
  {
    return true;
  }
  
  protected Object coerce(Object newValue)
  {
    StringBuffer sbuf = new StringBuffer("attempt to modify read-only location");
    
    Symbol name = getKeySymbol();
    if (name != null)
    {
      sbuf.append(": ");
      sbuf.append(name);
    }
    throw new IllegalStateException(sbuf.toString());
  }
}
