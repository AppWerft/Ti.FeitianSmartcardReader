package gnu.mapping;



public class ProcLocation
  extends Location<Object>
{
  Procedure proc;
  
  Object[] args;
  

  public ProcLocation(Procedure proc, Object[] args)
  {
    this.proc = proc;
    this.args = args;
  }
  
  public Object get(Object defaultValue)
  {
    return get();
  }
  
  public Object get()
  {
    try {
      return proc.applyN(args);
    }
    catch (Throwable ex)
    {
      throw WrappedException.rethrow(ex);
    }
  }
  
  public void set(Object value)
  {
    int len = args.length;
    Object[] xargs = new Object[len + 1];
    xargs[len] = value;
    System.arraycopy(args, 0, xargs, 0, len);
    try
    {
      proc.setN(xargs);
    }
    catch (Throwable ex)
    {
      throw WrappedException.rethrow(ex);
    }
  }
  
  public boolean isBound()
  {
    return true;
  }
}
