// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import java.util.Calendar;
import java.util.GregorianCalendar;
import gnu.math.DateTime;
import gnu.bytecode.Type;
import java.util.TimeZone;
import gnu.bytecode.ClassType;

public class XTimeType extends XDataType
{
    static ClassType typeDateTime;
    public static final XTimeType dateTimeType;
    public static final XTimeType dateType;
    public static final XTimeType timeType;
    public static final XTimeType gYearMonthType;
    public static final XTimeType gYearType;
    public static final XTimeType gMonthType;
    public static final XTimeType gMonthDayType;
    public static final XTimeType gDayType;
    private static TimeZone fixedTimeZone;
    
    XTimeType(final String name, final int code) {
        super(name, XTimeType.typeDateTime, code);
    }
    
    static int components(final int typeCode) {
        switch (typeCode) {
            case 20: {
                return 126;
            }
            case 21: {
                return 14;
            }
            case 22: {
                return 112;
            }
            case 23: {
                return 6;
            }
            case 24: {
                return 2;
            }
            case 25: {
                return 12;
            }
            case 26: {
                return 8;
            }
            case 27: {
                return 4;
            }
            case 28: {
                return 126;
            }
            case 29: {
                return 6;
            }
            case 30: {
                return 120;
            }
            default: {
                return 0;
            }
        }
    }
    
    public DateTime now() {
        return new DateTime(components(this.typeCode) | 0x80, (GregorianCalendar)Calendar.getInstance(fixedTimeZone()));
    }
    
    private static synchronized TimeZone fixedTimeZone() {
        if (XTimeType.fixedTimeZone == null) {
            final int offset = TimeZone.getDefault().getRawOffset() / 60000;
            XTimeType.fixedTimeZone = DateTime.minutesToTimeZone(offset);
        }
        return XTimeType.fixedTimeZone;
    }
    
    public static DateTime parseDateTime(final String value, final int mask) {
        final DateTime time = DateTime.parse(value, mask);
        if (time.isZoneUnspecified()) {
            time.setTimeZone(fixedTimeZone());
        }
        return time;
    }
    
    @Override
    public Object valueOf(final String value) {
        return parseDateTime(value, components(this.typeCode));
    }
    
    @Override
    public boolean isInstance(final Object obj) {
        if (!(obj instanceof DateTime)) {
            return false;
        }
        final int thisMask = components(this.typeCode);
        final int objMask = ((DateTime)obj).components();
        return thisMask == objMask;
    }
    
    static {
        XTimeType.typeDateTime = ClassType.make("gnu.math.DateTime");
        dateTimeType = new XTimeType("dateTime", 20);
        dateType = new XTimeType("date", 21);
        timeType = new XTimeType("time", 22);
        gYearMonthType = new XTimeType("gYearMonth", 23);
        gYearType = new XTimeType("gYear", 24);
        gMonthType = new XTimeType("gMonth", 27);
        gMonthDayType = new XTimeType("gMonthDay", 25);
        gDayType = new XTimeType("gDay", 26);
    }
}
