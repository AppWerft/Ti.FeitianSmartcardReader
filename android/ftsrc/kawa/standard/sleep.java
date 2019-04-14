package kawa.standard;

import gnu.math.Unit;

public class sleep
{
  public sleep() {}
  
  public static void sleep(gnu.math.Quantity q)
  {
    Unit u = q.unit();
    
    double seconds;
    if ((u == Unit.Empty) || (u.dimensions() == Unit.second.dimensions()))
    {
      seconds = q.doubleValue();
    } else
      throw new kawa.lang.GenericError("bad unit for sleep");
    double seconds; long millis = (seconds * 1000.0D);
    int nanos = (int)(seconds * 1.0E9D - millis * 1000000.0D);
    try
    {
      Thread.sleep(millis, nanos);
    }
    catch (InterruptedException ex)
    {
      throw new kawa.lang.GenericError("sleep was interrupted");
    }
  }
}
