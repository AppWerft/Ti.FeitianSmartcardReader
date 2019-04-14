package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class DQuantity
  extends Quantity
  implements Externalizable
{
  double factor;
  Unit unt;
  
  public final Unit unit() { return unt; }
  public final Complex number() { return new DFloNum(factor); }
  
  public final RealNum re() { return new DFloNum(factor); }
  public final double doubleValue() { return factor * unt.factor; }
  
  public DQuantity(double factor, Unit unit)
  {
    this.factor = factor;
    unt = unit;
  }
  
  public boolean isExact() { return false; }
  
  public boolean isZero() { return factor == 0.0D; }
  
  public static DQuantity add(DQuantity x, DQuantity y, double k)
  {
    if (x.dimensions() != y.dimensions())
      throw new ArithmeticException("units mis-match");
    double unit_ratio = unitfactor / unitfactor;
    return new DQuantity(factor + k * unit_ratio * factor, x.unit());
  }
  
  public static DQuantity times(DQuantity x, DQuantity y)
  {
    double factor = x.factor * factor;
    Unit unit = Unit.times(x.unit(), y.unit());
    return new DQuantity(factor, unit);
  }
  
  public static DQuantity divide(DQuantity x, DQuantity y)
  {
    double factor = x.factor / factor;
    Unit unit = Unit.divide(x.unit(), y.unit());
    return new DQuantity(factor, unit);
  }
  
  public Numeric add(Object y, int k)
  {
    if ((y instanceof DQuantity))
      return add(this, (DQuantity)y, k);
    if ((dimensions() == Dimensions.Empty) && ((y instanceof RealNum)))
      return new DQuantity(factor + k * ((RealNum)y).doubleValue(), unit());
    if (!(y instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)y).addReversed(this, k);
  }
  
  public Numeric addReversed(Numeric x, int k)
  {
    if ((dimensions() == Dimensions.Empty) && ((x instanceof RealNum)))
      return new DFloNum(((RealNum)x).doubleValue() + k * factor);
    throw new IllegalArgumentException();
  }
  
  public Numeric mul(Object y)
  {
    if ((y instanceof DQuantity))
      return times(this, (DQuantity)y);
    if ((y instanceof RealNum))
      return new DQuantity(factor * ((RealNum)y).doubleValue(), unit());
    if (!(y instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)y).mulReversed(this);
  }
  
  public Numeric mulReversed(Numeric x)
  {
    if ((x instanceof RealNum))
      return new DQuantity(((RealNum)x).doubleValue() * factor, unit());
    throw new IllegalArgumentException();
  }
  
  public Numeric div(Object y)
  {
    if ((y instanceof DQuantity))
    {
      DQuantity qy = (DQuantity)y;
      if (dimensions() == qy.dimensions()) {
        return new DFloNum(factor * unit().doubleValue() / (factor * unitfactor));
      }
      return divide(this, qy);
    }
    if ((y instanceof RealNum))
      return new DQuantity(factor / ((RealNum)y).doubleValue(), unit());
    if (!(y instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)y).divReversed(this);
  }
  
  public Numeric divReversed(Numeric x)
  {
    if ((x instanceof RealNum)) {
      return new DQuantity(((RealNum)x).doubleValue() / factor, Unit.divide(Unit.Empty, unit()));
    }
    throw new IllegalArgumentException();
  }
  




  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeDouble(factor);
    out.writeObject(unt);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    factor = in.readDouble();
    unt = ((Unit)in.readObject());
  }
}
