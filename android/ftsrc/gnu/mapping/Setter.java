package gnu.mapping;


public class Setter
  extends ProcedureN
{
  protected Procedure getter;
  
  public Setter(Procedure getter)
  {
    this.getter = getter;
    String name = getter.getName();
    if (name != null) {
      setName("(setter " + name + ")");
    }
  }
  
  public int numArgs() {
    int get_args = getter.numArgs();
    if (get_args < 0) return get_args + 1;
    return get_args + 4097;
  }
  
  public Object applyN(Object[] args) throws Throwable {
    getter.setN(args);return Values.empty;
  }
}
