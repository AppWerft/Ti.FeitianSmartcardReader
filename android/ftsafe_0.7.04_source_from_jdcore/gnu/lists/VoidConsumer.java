package gnu.lists;





public class VoidConsumer
  extends FilterConsumer
{
  public static VoidConsumer instance = new VoidConsumer();
  
  public static VoidConsumer getInstance() { return instance; }
  
  public VoidConsumer()
  {
    super(null);
    skipping = true;
  }
  
  public VoidConsumer(Consumer out) { super(out);
    skipping = true;
  }
  
  public static VoidConsumer make(Consumer old) {
    return new VoidConsumer(old);
  }
  


  public boolean ignoring()
  {
    return true;
  }
}
