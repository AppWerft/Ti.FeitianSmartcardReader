package kawa.lang;

import gnu.lists.Consumer;
import gnu.lists.Pair;
import java.io.ObjectOutput;

public class PairPat extends Pattern implements gnu.kawa.format.Printable, java.io.Externalizable
{
  Pattern car;
  Pattern cdr;
  private int car_count;
  private int cdr_count;
  
  public PairPat() {}
  
  public PairPat(Pattern car, Pattern cdr)
  {
    this.car = car;
    this.cdr = cdr;
    car_count = car.varCount();
    cdr_count = cdr.varCount();
  }
  
  public static PairPat make(Pattern car, Pattern cdr)
  {
    return new PairPat(car, cdr);
  }
  
  public boolean match(Object obj, Object[] vars, int start_vars)
  {
    if (!(obj instanceof Pair))
      return false;
    Pair pair = (Pair)obj;
    return (car.match(pair.getCar(), vars, start_vars)) && (cdr.match(pair.getCdr(), vars, start_vars + car_count));
  }
  

  public void print(Consumer out)
  {
    out.write("#<pair-pattern car: ");
    car.print(out);
    out.write(" cdr: ");
    cdr.print(out);
    out.write(62);
  }
  
  public int varCount() { return car_count + cdr_count; }
  


  public void writeExternal(ObjectOutput out)
    throws java.io.IOException
  {
    out.writeObject(car);
    out.writeObject(cdr);
  }
  
  public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException, ClassNotFoundException
  {
    car = ((Pattern)in.readObject());
    cdr = ((Pattern)in.readObject());
  }
}
