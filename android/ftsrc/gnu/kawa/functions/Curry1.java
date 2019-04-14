package gnu.kawa.functions;

import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;




public class Curry1
  extends Procedure1
{
  public static final Curry1 makeConverter = new Curry1("make-converter", Convert.cast);
  Procedure proc2;
  
  public Curry1(String name, Procedure proc2) {
    super(name);
    this.proc2 = proc2;
  }
  
  public Object apply1(Object arg) {
    return new Curried1(proc2, arg);
  }
  
  static class Curried1 extends Procedure1 {
    Object arg1;
    Procedure proc2;
    
    public Curried1(Procedure proc2, Object arg1) {
      this.proc2 = proc2;
      this.arg1 = arg1;
    }
    
    public Object apply1(Object arg2) throws Throwable {
      return proc2.apply2(arg1, arg2);
    }
  }
}
