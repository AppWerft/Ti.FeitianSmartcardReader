package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.math.DateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class XTimeType
  extends XDataType
{
  static ClassType typeDateTime = ClassType.make("gnu.math.DateTime");
  
  public static final XTimeType dateTimeType = new XTimeType("dateTime", 20);
  

  public static final XTimeType dateType = new XTimeType("date", 21);
  
  public static final XTimeType timeType = new XTimeType("time", 22);
  
  public static final XTimeType gYearMonthType = new XTimeType("gYearMonth", 23);
  
  public static final XTimeType gYearType = new XTimeType("gYear", 24);
  
  public static final XTimeType gMonthType = new XTimeType("gMonth", 27);
  
  public static final XTimeType gMonthDayType = new XTimeType("gMonthDay", 25);
  
  public static final XTimeType gDayType = new XTimeType("gDay", 26);
  private static TimeZone fixedTimeZone;
  
  XTimeType(String name, int code)
  {
    super(name, typeDateTime, code);
  }
  
  static int components(int typeCode)
  {
    switch (typeCode)
    {
    case 20: 
      return 126;
    case 21: 
      return 14;
    case 22: 
      return 112;
    case 23: 
      return 6;
    case 24: 
      return 2;
    case 25: 
      return 12;
    case 26: 
      return 8;
    case 27: 
      return 4;
    case 28: 
      return 126;
    case 29: 
      return 6;
    case 30: 
      return 120;
    }
    return 0;
  }
  









  public DateTime now()
  {
    return new DateTime(components(typeCode) | 0x80, (GregorianCalendar)Calendar.getInstance(fixedTimeZone()));
  }
  



  private static synchronized TimeZone fixedTimeZone()
  {
    if (fixedTimeZone == null)
    {
      int offset = TimeZone.getDefault().getRawOffset() / 60000;
      fixedTimeZone = DateTime.minutesToTimeZone(offset);
    }
    return fixedTimeZone;
  }
  

  public static DateTime parseDateTime(String value, int mask)
  {
    DateTime time = DateTime.parse(value, mask);
    




    if (time.isZoneUnspecified())
      time.setTimeZone(fixedTimeZone());
    return time;
  }
  
  public Object valueOf(String value)
  {
    return parseDateTime(value, components(typeCode));
  }
  
  public boolean isInstance(Object obj)
  {
    if (!(obj instanceof DateTime))
      return false;
    int thisMask = components(typeCode);
    int objMask = ((DateTime)obj).components();
    
    return thisMask == objMask;
  }
}
