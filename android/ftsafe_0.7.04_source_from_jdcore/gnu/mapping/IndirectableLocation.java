package gnu.mapping;




public abstract class IndirectableLocation<T>
  extends Location<T>
{
  protected static final Object DIRECT_ON_SET = new String("(direct-on-set)");
  







  protected static final Object INDIRECT_FLUIDS = new String("(indirect-fluids)");
  

  protected Location<T> base;
  

  protected Object value;
  


  public IndirectableLocation() {}
  


  public Symbol getKeySymbol()
  {
    return base != null ? base.getKeySymbol() : null;
  }
  
  public Object getKeyProperty()
  {
    return base != null ? base.getKeyProperty() : null;
  }
  
  public boolean isConstant()
  {
    return (base != null) && (base.isConstant());
  }
  
  public Location getBase()
  {
    return base == null ? this : base.getBase();
  }
  
  public Location getBaseForce()
  {
    if (base == null) {
      return new PlainLocation(getKeySymbol(), getKeyProperty(), value);
    }
    return base;
  }
  
  public void setBase(Location base)
  {
    this.base = base;
    value = null;
  }
  

  public void setAlias(Location base)
  {
    this.base = base;
    value = INDIRECT_FLUIDS;
  }
  
  public void undefine()
  {
    base = null;
    value = UNBOUND;
  }
  
  public Environment getEnvironment()
  {
    return (base instanceof NamedLocation) ? ((NamedLocation)base).getEnvironment() : null;
  }
}
