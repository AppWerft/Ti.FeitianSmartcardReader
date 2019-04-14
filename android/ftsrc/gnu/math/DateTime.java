package gnu.math;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;










public class DateTime
  extends Quantity
  implements Cloneable
{
  Unit unit = Unit.date;
  
  int nanoSeconds;
  
  GregorianCalendar calendar;
  
  int mask;
  
  static final int YEAR_COMPONENT = 1;
  
  static final int MONTH_COMPONENT = 2;
  
  static final int DAY_COMPONENT = 3;
  
  static final int HOURS_COMPONENT = 4;
  
  static final int MINUTES_COMPONENT = 5;
  static final int SECONDS_COMPONENT = 6;
  static final int TIMEZONE_COMPONENT = 7;
  public static final int YEAR_MASK = 2;
  public static final int MONTH_MASK = 4;
  public static final int DAY_MASK = 8;
  public static final int HOURS_MASK = 16;
  public static final int MINUTES_MASK = 32;
  public static final int SECONDS_MASK = 64;
  public static final int TIMEZONE_MASK = 128;
  public static final int DATE_MASK = 14;
  public static final int TIME_MASK = 112;
  
  public int components()
  {
    return mask & 0xFF7F;
  }
  
  public DateTime cast(int newComponents) {
    int oldComponents = mask & 0xFF7F;
    if (newComponents == oldComponents)
      return this;
    DateTime copy = new DateTime(newComponents, (GregorianCalendar)calendar.clone());
    
    if (((newComponents & (oldComponents ^ 0xFFFFFFFF)) != 0) && ((oldComponents != 14) || (newComponents != 126)))
    {


      throw new ClassCastException("cannot cast DateTime - missing conponents"); }
    if (isZoneUnspecified()) {
      mask &= 0xFF7F;
    } else
      mask |= 0x80;
    int extraComponents = oldComponents & (newComponents ^ 0xFFFFFFFF);
    if ((extraComponents & 0x70) != 0)
    {
      calendar.clear(11);
      calendar.clear(12);
      calendar.clear(13);
    }
    else {
      nanoSeconds = nanoSeconds; }
    if ((extraComponents & 0x2) != 0)
    {
      calendar.clear(1);
      calendar.clear(0);
    }
    if ((extraComponents & 0x4) != 0)
      calendar.clear(2);
    if ((extraComponents & 0x8) != 0)
      calendar.clear(5);
    return copy;
  }
  
  private static final Date minDate = new Date(Long.MIN_VALUE);
  
  public DateTime(int mask)
  {
    calendar = new GregorianCalendar();
    
    calendar.setGregorianChange(minDate);
    calendar.clear();
    this.mask = mask;
  }
  
  public DateTime(int mask, GregorianCalendar calendar)
  {
    this.calendar = calendar;
    this.mask = mask;
  }
  
  public static DateTime parse(String value, int mask)
  {
    DateTime result = new DateTime(mask);
    value = value.trim();
    int len = value.length();
    int pos = 0;
    boolean wantDate = (mask & 0xE) != 0;
    boolean wantTime = (mask & 0x70) != 0;
    if (wantDate)
    {
      pos = result.parseDate(value, pos, mask);
      if (wantTime)
      {
        if ((pos < 0) || (pos >= len) || (value.charAt(pos) != 'T')) {
          pos = -1;
        } else
          pos++;
      }
    }
    if (wantTime)
      pos = result.parseTime(value, pos);
    pos = result.parseZone(value, pos);
    if (pos != len)
      throw new NumberFormatException("Unrecognized date/time '" + value + '\'');
    return result;
  }
  
  int parseDate(String str, int start, int mask)
  {
    if (start < 0)
      return start;
    int len = str.length();
    boolean negYear = false;
    if ((start < len) && (str.charAt(start) == '-'))
    {
      start++;
      negYear = true;
    }
    int pos = start;
    int year;
    int year; if ((mask & 0x2) == 0)
    {
      if (!negYear)
        return -1;
      year = -1;
    }
    else
    {
      int part = parseDigits(str, pos);
      year = part >> 16;
      pos = part & 0xFFFF;
      if ((pos != start + 4) && ((pos <= start + 4) || (str.charAt(start) == '0')))
        return -1;
      if ((negYear) || (year == 0))
      {
        calendar.set(0, 0);
        calendar.set(1, year + 1);
      }
      else {
        calendar.set(1, year);
      } }
    if ((mask & 0xC) == 0)
      return pos;
    if ((pos >= len) || (str.charAt(pos) != '-'))
      return -1;
    pos++;start = pos;
    int month; if ((mask & 0x4) != 0)
    {
      int part = parseDigits(str, start);
      int month = part >> 16;
      pos = part & 0xFFFF;
      if ((month <= 0) || (month > 12) || (pos != start + 2))
        return -1;
      calendar.set(2, month - 1);
      if ((mask & 0x8) == 0) {
        return pos;
      }
    } else {
      month = -1; }
    if ((pos >= len) || (str.charAt(pos) != '-'))
      return -1;
    start = pos + 1;
    int part = parseDigits(str, start);
    int day = part >> 16;
    pos = part & 0xFFFF;
    if ((day > 0) && (pos == start + 2)) {
      int maxDay;
      int maxDay;
      if ((mask & 0x4) == 0) {
        maxDay = 31;
      } else
        maxDay = daysInMonth(month - 1, (mask & 0x2) != 0 ? year : 2000);
      if (day <= maxDay)
      {
        calendar.set(5, day);
        return pos;
      }
    }
    return -1;
  }
  
  public static boolean isLeapYear(int year)
  {
    return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
  }
  
  public static int daysInMonth(int month, int year)
  {
    switch (month)
    {
    case 3: 
    case 5: 
    case 8: 
    case 10: 
      return 30;
    case 1: 
      return isLeapYear(year) ? 29 : 28;
    }
    return 31;
  }
  

  public static TimeZone GMT = TimeZone.getTimeZone("GMT");
  
  int parseZone(String str, int start)
  {
    if (start < 0)
      return start;
    int part = parseZoneMinutes(str, start);
    if (part == 0)
      return -1;
    if (part == start)
      return start;
    int minutes = part >> 16;
    
    int pos = part & 0xFFFF;
    TimeZone zone; TimeZone zone; if (minutes == 0) {
      zone = GMT;
    } else
      zone = TimeZone.getTimeZone("GMT" + str.substring(start, pos));
    calendar.setTimeZone(zone);
    mask |= 0x80;
    return pos;
  }
  


  int parseZoneMinutes(String str, int start)
  {
    int len = str.length();
    if ((start == len) || (start < 0))
      return start;
    char ch = str.charAt(start);
    if (ch == 'Z')
      return start + 1;
    if ((ch != '+') && (ch != '-'))
      return start;
    start++;
    int part = parseDigits(str, start);
    int hour = part >> 16;
    if (hour > 14)
      return 0;
    int minute = 60 * hour;
    int pos = part & 0xFFFF;
    if (pos != start + 2)
      return 0;
    if (pos < len)
    {
      if (str.charAt(pos) == ':')
      {
        start = pos + 1;
        part = parseDigits(str, start);
        pos = part & 0xFFFF;
        part >>= 16;
        if ((part > 0) && ((part >= 60) || (hour == 14)))
          return 0;
        minute += part;
        if (pos != start + 2) {
          return 0;
        }
      }
    } else
      return 0;
    if (minute > 840)
      return 0;
    if (ch == '-')
      minute = -minute;
    return minute << 16 | pos;
  }
  
  int parseTime(String str, int start)
  {
    if (start < 0)
      return start;
    int len = str.length();
    int pos = start;
    int part = parseDigits(str, start);
    int hour = part >> 16;
    pos = part & 0xFFFF;
    if ((hour <= 24) && (pos == start + 2) && (pos != len) && (str.charAt(pos) == ':'))
    {
      start = pos + 1;
      part = parseDigits(str, start);
      int minute = part >> 16;
      pos = part & 0xFFFF;
      if ((minute < 60) && (pos == start + 2) && (pos != len) && (str.charAt(pos) == ':'))
      {

        start = pos + 1;
        part = parseDigits(str, start);
        int second = part >> 16;
        pos = part & 0xFFFF;
        
        if ((second < 60) && (pos == start + 2))
        {
          if ((pos + 1 < len) && (str.charAt(pos) == '.') && (Character.digit(str.charAt(pos + 1), 10) >= 0))
          {

            start = pos + 1;
            pos = start;
            int nanos = 0;
            int nfrac = 0;
            for (; pos < len; pos++)
            {
              int dig = Character.digit(str.charAt(pos), 10);
              if (dig < 0)
                break;
              if (nfrac < 9) {
                nanos = 10 * nanos + dig;
              } else if ((nfrac == 9) && (dig >= 5)) {
                nanos++;
              }
              nfrac++;
            }
            







            while (nfrac++ < 9)
              nanos = 10 * nanos;
            nanoSeconds = nanos;
          }
          if ((hour == 24) && ((minute != 0) || (second != 0) || (nanoSeconds != 0)))
          {
            return -1; }
          calendar.set(11, hour);
          calendar.set(12, minute);
          calendar.set(13, second);
          return pos;
        }
      }
    }
    return -1;
  }
  

  private static int parseDigits(String str, int start)
  {
    int i = start;
    int val = -1;
    int len = str.length();
    while (i < len)
    {
      char ch = str.charAt(i);
      int dig = Character.digit(ch, 10);
      if (dig < 0)
        break;
      if (val > 20000)
        return 0;
      val = val < 0 ? dig : 10 * val + dig;
      i++;
    }
    return val < 0 ? i : val << 16 | i;
  }
  
  public int getYear()
  {
    int year = calendar.get(1);
    if (calendar.get(0) == 0)
      year = 1 - year;
    return year;
  }
  
  public int getMonth()
  {
    return calendar.get(2) + 1;
  }
  
  public int getDay()
  {
    return calendar.get(5);
  }
  
  public int getHours()
  {
    return calendar.get(11);
  }
  
  public int getMinutes()
  {
    return calendar.get(12);
  }
  
  public int getSecondsOnly()
  {
    return calendar.get(13);
  }
  
  public int getWholeSeconds()
  {
    return calendar.get(13);
  }
  
  public int getNanoSecondsOnly()
  {
    return nanoSeconds;
  }
  








  public static int compare(DateTime date1, DateTime date2)
  {
    long millis1 = calendar.getTimeInMillis();
    long millis2 = calendar.getTimeInMillis();
    if (((mask | mask) & 0xE) == 0)
    {
      if (millis1 < 0L) millis1 += 86400000L;
      if (millis2 < 0L) millis2 += 86400000L;
    }
    int nanos1 = nanoSeconds;
    int nanos2 = nanoSeconds;
    millis1 += nanos1 / 1000000;
    millis2 += nanos2 / 1000000;
    nanos1 %= 1000000;
    nanos2 %= 1000000;
    return nanos1 > nanos2 ? 1 : nanos1 < nanos2 ? -1 : millis1 > millis2 ? 1 : millis1 < millis2 ? -1 : 0;
  }
  

  public int compare(Object obj)
  {
    if ((obj instanceof DateTime))
      return compare(this, (DateTime)obj);
    return ((Numeric)obj).compareReversed(this);
  }
  
  public static Duration sub(DateTime date1, DateTime date2)
  {
    long millis1 = calendar.getTimeInMillis();
    long millis2 = calendar.getTimeInMillis();
    int nanos1 = nanoSeconds;
    int nanos2 = nanoSeconds;
    millis1 += nanos1 / 1000000;
    millis2 += nanos2 / 1000000;
    nanos1 %= 1000000;
    nanos2 %= 1000000;
    long millis = millis1 - millis2;
    long seconds = millis / 1000L;
    int nanos = (int)(millis % 1000L * 1000000L + nanos2 - nanos2);
    seconds += nanos / 1000000000;
    nanos %= 1000000000;
    return Duration.make(0, seconds, nanos, Unit.second);
  }
  
  public DateTime withZoneUnspecified()
  {
    if (isZoneUnspecified())
      return this;
    DateTime r = new DateTime(mask, (GregorianCalendar)calendar.clone());
    calendar.setTimeZone(TimeZone.getDefault());
    mask &= 0xFF7F;
    return r;
  }
  
  public DateTime adjustTimezone(int newOffset)
  {
    DateTime r = new DateTime(mask, (GregorianCalendar)calendar.clone());
    TimeZone zone;
    TimeZone zone; if (newOffset == 0) {
      zone = GMT;
    }
    else {
      StringBuffer sbuf = new StringBuffer("GMT");
      toStringZone(newOffset, sbuf);
      zone = TimeZone.getTimeZone(sbuf.toString());
    }
    calendar.setTimeZone(zone);
    if ((mask & 0x80) != 0)
    {
      long millis = calendar.getTimeInMillis();
      calendar.setTimeInMillis(millis);
      if ((mask & 0x70) == 0)
      {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        nanoSeconds = 0;
      }
    }
    else {
      mask |= 0x80; }
    return r;
  }
  
  public static DateTime add(DateTime x, Duration y, int k)
  {
    if ((unit == Unit.duration) || ((unit == Unit.month) && ((mask & 0xE) != 14)))
    {
      throw new IllegalArgumentException("invalid date/time +/- duration combinatuion"); }
    DateTime r = new DateTime(mask, (GregorianCalendar)calendar.clone());
    if (months != 0)
    {
      int month = 12 * r.getYear() + calendar.get(2);
      month += k * months;
      int day = calendar.get(5);
      int daysInMonth;
      int year; int daysInMonth; if (month >= 12)
      {
        int year = month / 12;
        month %= 12;
        calendar.set(0, 1);
        daysInMonth = daysInMonth(month, year);
      }
      else
      {
        month = 11 - month;
        calendar.set(0, 0);
        year = month / 12 + 1;
        month = 11 - month % 12;
        daysInMonth = daysInMonth(month, 1);
      }
      
      if (day > daysInMonth)
        day = daysInMonth;
      calendar.set(year, month, day);
    }
    long nanos = nanoSeconds + k * (seconds * 1000000000L + nanos);
    if (nanos != 0L)
    {
      if ((mask & 0x70) == 0)
      {
        long nanosPerDay = 86400000000000L;
        long mod = nanos % nanosPerDay;
        if (mod < 0L)
          mod += nanosPerDay;
        nanos -= mod;
      }
      long millis = calendar.getTimeInMillis();
      millis += nanos / 1000000000L * 1000L;
      calendar.setTimeInMillis(millis);
      nanoSeconds = ((int)(nanos % 1000000000L));
    }
    return r;
  }
  
  public static DateTime addMinutes(DateTime x, int y)
  {
    return addSeconds(x, 60 * y);
  }
  
  public static DateTime addSeconds(DateTime x, int y)
  {
    DateTime r = new DateTime(mask, (GregorianCalendar)calendar.clone());
    long nanos = y * 1000000000L;
    if (nanos != 0L)
    {
      nanos = nanoSeconds + nanos;
      long millis = calendar.getTimeInMillis();
      millis += nanos / 1000000L;
      calendar.setTimeInMillis(millis);
      nanoSeconds = ((int)(nanos % 1000000L));
    }
    return r;
  }
  
  public Numeric add(Object y, int k)
  {
    if ((y instanceof Duration))
      return add(this, (Duration)y, k);
    if (((y instanceof DateTime)) && (k == -1))
      return sub(this, (DateTime)y);
    throw new IllegalArgumentException();
  }
  
  public Numeric addReversed(Numeric x, int k)
  {
    if (((x instanceof Duration)) && (k == 1))
      return add(this, (Duration)x, k);
    throw new IllegalArgumentException();
  }
  
  private static void append(int value, StringBuffer sbuf, int minWidth)
  {
    int start = sbuf.length();
    sbuf.append(value);
    int padding = start + minWidth - sbuf.length();
    for (;;) { padding--; if (padding < 0) break;
      sbuf.insert(start, '0');
    }
  }
  
  public void toStringDate(StringBuffer sbuf) {
    int mask = components();
    if ((mask & 0x2) != 0)
    {
      int year = calendar.get(1);
      if (calendar.get(0) == 0)
      {
        year--;
        if (year != 0)
          sbuf.append('-');
      }
      append(year, sbuf, 4);
    }
    else {
      sbuf.append('-'); }
    if ((mask & 0xC) != 0)
    {
      sbuf.append('-');
      if ((mask & 0x4) != 0)
        append(getMonth(), sbuf, 2);
      if ((mask & 0x8) != 0)
      {
        sbuf.append('-');
        append(getDay(), sbuf, 2);
      }
    }
  }
  
  public void toStringTime(StringBuffer sbuf)
  {
    append(getHours(), sbuf, 2);
    sbuf.append(':');
    append(getMinutes(), sbuf, 2);
    sbuf.append(':');
    append(getWholeSeconds(), sbuf, 2);
    Duration.appendNanoSeconds(nanoSeconds, sbuf);
  }
  


  public boolean isZoneUnspecified()
  {
    return (mask & 0x80) == 0;
  }
  
  public int getZoneMinutes()
  {
    return calendar.getTimeZone().getRawOffset() / 60000;
  }
  



  public static TimeZone minutesToTimeZone(int minutes)
  {
    if (minutes == 0)
      return GMT;
    StringBuffer sbuf = new StringBuffer("GMT");
    toStringZone(minutes, sbuf);
    return TimeZone.getTimeZone(sbuf.toString());
  }
  
  public void setTimeZone(TimeZone timeZone)
  {
    calendar.setTimeZone(timeZone);
  }
  
  public void toStringZone(StringBuffer sbuf)
  {
    if (isZoneUnspecified())
      return;
    toStringZone(getZoneMinutes(), sbuf);
  }
  
  public static void toStringZone(int minutes, StringBuffer sbuf) {
    if (minutes == 0) {
      sbuf.append('Z');
    }
    else {
      if (minutes < 0)
      {
        sbuf.append('-');
        minutes = -minutes;
      }
      else {
        sbuf.append('+'); }
      append(minutes / 60, sbuf, 2);
      sbuf.append(':');
      append(minutes % 60, sbuf, 2);
    }
  }
  
  public void toString(StringBuffer sbuf)
  {
    int mask = components();
    boolean hasDate = (mask & 0xE) != 0;
    boolean hasTime = (mask & 0x70) != 0;
    if (hasDate)
    {
      toStringDate(sbuf);
      if (hasTime)
        sbuf.append('T');
    }
    if (hasTime)
      toStringTime(sbuf);
    toStringZone(sbuf);
  }
  
  public String toString()
  {
    StringBuffer sbuf = new StringBuffer();
    toString(sbuf);
    return sbuf.toString();
  }
  
  public boolean isExact()
  {
    return (mask & 0x70) == 0;
  }
  
  public boolean isZero()
  {
    throw new UnsupportedOperationException("DateTime.isZero not meaningful!");
  }
  
  public Unit unit() { return unit; }
  
  public Complex number() {
    throw new UnsupportedOperationException("number needs to be implemented!");
  }
}
