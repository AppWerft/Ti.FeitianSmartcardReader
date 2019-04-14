package gnu.mapping;





public abstract class Procedure4
  extends Procedure
{
  public Procedure4() {}
  



  public Procedure4(String n)
  {
    super(n);
  }
  
  public int numArgs() { return 16388; }
  
  public Object apply0()
  {
    throw new WrongArguments(this, 0);
  }
  
  public Object apply1(Object arg1)
  {
    throw new WrongArguments(this, 1);
  }
  
  public Object apply2(Object arg1, Object arg2)
  {
    throw new WrongArguments(this, 2);
  }
  
  public Object apply3(Object arg1, Object arg2, Object arg3)
  {
    throw new WrongArguments(this, 3);
  }
  
  public abstract Object apply4(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    throws Throwable;
  
  public Object applyN(Object[] args) throws Throwable
  {
    if (args.length != 4)
      throw new WrongArguments(this, args.length);
    return apply4(args[0], args[1], args[2], args[3]);
  }
}
