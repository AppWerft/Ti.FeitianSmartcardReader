package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;




public class Duration
  extends Quantity
  implements Externalizable
{
  public Unit unit;
  int months;
  long seconds;
  int nanos;
  
  public Duration() {}
  
  public static Duration make(int months, long seconds, int nanos, Unit unit)
  {
    Duration d = new Duration();
    months = months;
    seconds = seconds;
    nanos = nanos;
    unit = unit;
    return d;
  }
  
  public static Duration makeMonths(int months)
  {
    Duration d = new Duration();
    unit = Unit.month;
    months = months;
    return d;
  }
  
  public static Duration makeMinutes(int minutes)
  {
    Duration d = new Duration();
    unit = Unit.second;
    seconds = (60 * minutes);
    return d;
  }
  
  public static Duration parse(String str, Unit unit)
  {
    Duration d = valueOf(str, unit);
    if (d == null)
      throw new IllegalArgumentException("not a valid " + unit.getName() + " duration: '" + str + "'");
    return d;
  }
  
  public static Duration parseDuration(String str)
  {
    return parse(str, Unit.duration);
  }
  
  public static Duration parseYearMonthDuration(String str)
  {
    return parse(str, Unit.month);
  }
  

  public static Duration parseDayTimeDuration(String str)
  {
    return parse(str, Unit.second);
  }
  



  public static Duration valueOf(String str, Unit unit)
  {
    str = str.trim();
    int pos = 0;
    int len = str.length();
    boolean negative;
    if ((pos < len) && (str.charAt(pos) == '-'))
    {
      boolean negative = true;
      pos++;
    }
    else {
      negative = false; }
    if ((pos + 1 >= len) || (str.charAt(pos) != 'P'))
      return null;
    pos++;
    int months = 0;int nanos = 0;
    long seconds = 0L;
    long part = scanPart(str, pos);
    pos = (int)part >> 16;
    char ch = (char)(int)part;
    if ((unit == Unit.second) && ((ch == 'Y') || (ch == 'M')))
      return null;
    if (ch == 'Y')
    {
      months = 12 * (int)(part >> 32);
      pos = (int)part >> 16;
      part = scanPart(str, pos);
      ch = (char)(int)part;
    }
    if (ch == 'M')
    {
      months = (int)(months + (part >> 32));
      pos = (int)part >> 16;
      part = scanPart(str, pos);
      ch = (char)(int)part;
    }
    if ((unit == Unit.month) && (pos != len))
      return null;
    if (ch == 'D')
    {
      if (unit == Unit.month)
        return null;
      seconds = 86400L * (int)(part >> 32);
      pos = (int)part >> 16;
      part = scanPart(str, pos);
    }
    if (part != pos << 16)
      return null;
    if (pos != len)
    {


      if (str.charAt(pos) == 'T') { pos++; if (pos != len) {}
      } else { return null;
      }
      
      if (unit == Unit.month)
        return null;
      part = scanPart(str, pos);
      ch = (char)(int)part;
      if (ch == 'H')
      {
        seconds += 3600 * (int)(part >> 32);
        pos = (int)part >> 16;
        part = scanPart(str, pos);
        ch = (char)(int)part;
      }
      if (ch == 'M')
      {
        seconds += 60 * (int)(part >> 32);
        pos = (int)part >> 16;
        part = scanPart(str, pos);
        ch = (char)(int)part;
      }
      if ((ch == 'S') || (ch == '.'))
      {
        seconds += (int)(part >> 32);
        pos = (int)part >> 16;
      }
      if ((ch == '.') && (pos + 1 < len) && (Character.digit(str.charAt(pos), 10) >= 0))
      {

        for (int nfrac = 0; 
            pos < len; nfrac++)
        {
          ch = str.charAt(pos++);
          int dig = Character.digit(ch, 10);
          if (dig < 0)
            break;
          if (nfrac < 9) {
            nanos = 10 * nanos + dig;
          } else if ((nfrac == 9) && (dig >= 5))
            nanos++;
        }
        while (nfrac++ < 9)
          nanos = 10 * nanos;
        if (ch != 'S')
          return null;
      }
    }
    if (pos != len)
      return null;
    Duration d = new Duration();
    if (negative)
    {
      months = -months;
      seconds = -seconds;
      nanos = -nanos;
    }
    months = months;
    seconds = seconds;
    nanos = nanos;
    unit = unit;
    return d;
  }
  
  public Numeric add(Object y, int k)
  {
    if ((y instanceof Duration))
      return add(this, (Duration)y, k);
    if (((y instanceof DateTime)) && (k == 1))
      return DateTime.add((DateTime)y, this, 1);
    throw new IllegalArgumentException();
  }
  
  public Numeric mul(Object y)
  {
    if ((y instanceof RealNum))
      return times(this, ((RealNum)y).doubleValue());
    return ((Numeric)y).mulReversed(this);
  }
  
  public Numeric mulReversed(Numeric x)
  {
    if (!(x instanceof RealNum))
      throw new IllegalArgumentException();
    return times(this, ((RealNum)x).doubleValue());
  }
  
  public static double div(Duration dur1, Duration dur2)
  {
    int months1 = months;
    int months2 = months;
    double sec1 = seconds + nanos * 1.0E-9D;
    double sec2 = seconds + nanos * 1.0E-9D;
    if ((months2 == 0) && (sec2 == 0.0D))
      throw new ArithmeticException("divide duration by zero");
    if (months2 == 0)
    {
      if (months1 == 0) {
        return sec1 / sec2;
      }
    } else if (sec2 == 0.0D)
    {
      if (sec1 == 0.0D)
        return months1 / months2;
    }
    throw new ArithmeticException("divide of incompatible durations");
  }
  
  public Numeric div(Object y)
  {
    if ((y instanceof RealNum))
    {
      double dy = ((RealNum)y).doubleValue();
      if ((dy == 0.0D) || (Double.isNaN(dy)))
        throw new ArithmeticException("divide of duration by 0 or NaN");
      return times(this, 1.0D / dy);
    }
    if ((y instanceof Duration))
      return new DFloNum(div(this, (Duration)y));
    return ((Numeric)y).divReversed(this);
  }
  
  public static Duration add(Duration x, Duration y, int k)
  {
    long months = x.months + k * months;
    

    long nanos = seconds * 1000000000L + x.nanos + k * (seconds * 1000000000L + nanos);
    


    Duration d = new Duration();
    months = ((int)months);
    seconds = ((int)(nanos / 1000000000L));
    nanos = ((int)(nanos % 1000000000L));
    if ((unit != unit) || (unit == Unit.duration))
      throw new ArithmeticException("cannot add these duration types");
    unit = unit;
    return d;
  }
  
  public static Duration times(Duration x, double y)
  {
    if (unit == Unit.duration)
      throw new IllegalArgumentException("cannot multiply general duration");
    double months = x.months * y;
    if ((Double.isInfinite(months)) || (Double.isNaN(months)))
      throw new ArithmeticException("overflow/NaN when multiplying a duration");
    double nanos = (seconds * 1000000000L + x.nanos) * y;
    Duration d = new Duration();
    months = ((int)Math.floor(months + 0.5D));
    seconds = ((int)(nanos / 1.0E9D));
    nanos = ((int)(nanos % 1.0E9D));
    unit = unit;
    return d;
  }
  
  public static int compare(Duration x, Duration y)
  {
    long months = x.months - months;
    long nanos = seconds * 1000000000L + x.nanos - (seconds * 1000000000L + nanos);
    
    if ((months < 0L) && (nanos <= 0L))
      return -1;
    if ((months > 0L) && (nanos >= 0L))
      return 1;
    if (months == 0L)
      return nanos > 0L ? 1 : nanos < 0L ? -1 : 0;
    return -2;
  }
  
  public int compare(Object obj)
  {
    if ((obj instanceof Duration)) {
      return compare(this, (Duration)obj);
    }
    throw new IllegalArgumentException();
  }
  
  public String toString()
  {
    StringBuffer sbuf = new StringBuffer();
    int m = months;
    long s = seconds;
    int n = nanos;
    boolean neg = (m < 0) || (s < 0L) || (n < 0);
    if (neg)
    {
      m = -m;
      s = -s;
      n = -n;
      sbuf.append('-');
    }
    sbuf.append('P');
    int y = m / 12;
    if (y != 0)
    {
      sbuf.append(y);
      sbuf.append('Y');
      m -= y * 12;
    }
    if (m != 0)
    {
      sbuf.append(m);
      sbuf.append('M');
    }
    long d = s / 86400L;
    if (d != 0L)
    {
      sbuf.append(d);
      sbuf.append('D');
      s -= 86400L * d;
    }
    if ((s != 0L) || (n != 0))
    {
      sbuf.append('T');
      long hr = s / 3600L;
      if (hr != 0L)
      {
        sbuf.append(hr);
        sbuf.append('H');
        s -= 3600L * hr;
      }
      long mn = s / 60L;
      if (mn != 0L)
      {
        sbuf.append(mn);
        sbuf.append('M');
        s -= 60L * mn;
      }
      if ((s != 0L) || (n != 0))
      {
        sbuf.append(s);
        appendNanoSeconds(n, sbuf);
        sbuf.append('S');
      }
    }
    else if (sbuf.length() == 1) {
      sbuf.append(unit == Unit.month ? "0M" : "T0S"); }
    return sbuf.toString();
  }
  
  static void appendNanoSeconds(int nanoSeconds, StringBuffer sbuf)
  {
    if (nanoSeconds == 0)
      return;
    sbuf.append('.');
    int pos = sbuf.length();
    sbuf.append(nanoSeconds);
    int len = sbuf.length();
    int pad = pos + 9 - len;
    for (;;) { pad--; if (pad < 0) break;
      sbuf.insert(pos, '0'); }
    len = pos + 9;
    do { len--; } while (sbuf.charAt(len) == '0');
    sbuf.setLength(len + 1);
  }
  





  private static long scanPart(String str, int start)
  {
    int i = start;
    long val = -1L;
    int len = str.length();
    while (i < len)
    {
      char ch = str.charAt(i);
      i++;
      int dig = Character.digit(ch, 10);
      if (dig < 0)
      {
        if (val < 0L) return start << 16;
        return val << 32 | i << 16 | ch;
      }
      val = val < 0L ? dig : 10L * val + dig;
      if (val > 2147483647L)
        return -1L;
    }
    return val < 0L ? start << 16 : -1L;
  }
  

  public int getYears()
  {
    return months / 12;
  }
  
  public int getMonths()
  {
    return months % 12;
  }
  
  public int getDays()
  {
    return (int)(seconds / 86400L);
  }
  
  public int getHours()
  {
    return (int)(seconds / 3600L % 24L);
  }
  
  public int getMinutes()
  {
    return (int)(seconds / 60L % 60L);
  }
  
  public int getSecondsOnly()
  {
    return (int)(seconds % 60L);
  }
  
  public int getNanoSecondsOnly()
  {
    return nanos;
  }
  
  public int getTotalMonths()
  {
    return months;
  }
  
  public long getTotalSeconds()
  {
    return seconds;
  }
  
  public long getTotalMinutes()
  {
    return seconds / 60L;
  }
  
  public long getNanoSeconds()
  {
    return seconds * 1000000000L + nanos;
  }
  
  public boolean isZero()
  {
    return (months == 0) && (seconds == 0L) && (nanos == 0);
  }
  
  public boolean isExact()
  {
    return false;
  }
  
  public void writeExternal(ObjectOutput out) throws IOException
  {
    out.writeInt(months);
    out.writeLong(seconds);
    out.writeInt(nanos);
    out.writeObject(unit);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    months = in.readInt();
    seconds = in.readLong();
    nanos = in.readInt();
    unit = ((Unit)in.readObject());
  }
  
  public Unit unit() { return unit; }
  
  public Complex number() {
    throw new UnsupportedOperationException("number needs to be implemented!");
  }
  
  public int hashCode()
  {
    return months ^ (int)seconds ^ nanos;
  }
  



  public static boolean equals(Duration x, Duration y)
  {
    return (months == months) && (seconds == seconds) && (nanos == nanos);
  }
  





  public boolean equals(Object obj)
  {
    if ((obj == null) || (!(obj instanceof Duration)))
      return false;
    return equals(this, (Duration)obj);
  }
}
