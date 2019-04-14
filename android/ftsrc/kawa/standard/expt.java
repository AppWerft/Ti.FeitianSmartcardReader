package kawa.standard;

import gnu.math.Complex;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.Quaternion;

public class expt extends gnu.mapping.Procedure2
{
  public static final expt expt = new expt("expt");
  
  public expt(String name)
  {
    super(name);
  }
  
  public static IntNum expt(IntNum x, int y)
  {
    return IntNum.power(x, y);
  }
  
  public static Numeric expt(Object arg1, Object arg2) {
    Numeric narg1 = gnu.kawa.functions.Arithmetic.asNumeric(arg1);
    Numeric narg2 = gnu.kawa.functions.Arithmetic.asNumeric(arg2);
    if ((narg2 instanceof IntNum))
      return narg1.power((IntNum)narg2);
    if (((narg1 instanceof Complex)) && ((narg2 instanceof Complex)))
      return Complex.power((Complex)narg1, (Complex)narg2);
    return Quaternion.power((Quaternion)narg1, (Quaternion)narg2);
  }
  
  public Object apply2(Object arg1, Object arg2)
  {
    return expt(arg1, arg2);
  }
}
