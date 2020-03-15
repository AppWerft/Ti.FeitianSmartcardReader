// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import java.util.TimeZone;
import java.math.BigDecimal;
import java.math.BigInteger;
import gnu.math.IntNum;
import gnu.mapping.Values;
import gnu.math.Duration;
import gnu.mapping.WrongType;
import gnu.xml.TextUtils;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.XTimeType;
import gnu.math.DateTime;

public class TimeUtils
{
    static final ThreadLocal<DateTime> currentDateTimeLocal;
    
    static DateTime coerceToDateTime(final String fun, final Object value) {
        if (XTimeType.dateTimeType.isInstance(value)) {
            return (DateTime)value;
        }
        if (value instanceof KNode || value instanceof UntypedAtomic) {
            return XTimeType.parseDateTime(TextUtils.stringValue(value), 126);
        }
        throw new WrongType(fun, 1, value, "xs:dateTime");
    }
    
    static DateTime coerceToDate(final String fun, final Object value) {
        if (XTimeType.dateType.isInstance(value)) {
            return (DateTime)value;
        }
        if (value instanceof KNode || value instanceof UntypedAtomic) {
            return XTimeType.parseDateTime(TextUtils.stringValue(value), 14);
        }
        throw new WrongType(fun, 1, value, "xs:date");
    }
    
    static DateTime coerceToTime(final String fun, final Object value) {
        if (XTimeType.timeType.isInstance(value)) {
            return (DateTime)value;
        }
        if (value instanceof KNode || value instanceof UntypedAtomic) {
            return XTimeType.parseDateTime(TextUtils.stringValue(value), 112);
        }
        throw new WrongType(fun, 1, value, "xs:time");
    }
    
    static Duration coerceToDuration(final String fun, final Object value) {
        if (value instanceof Duration) {
            return (Duration)value;
        }
        throw new WrongType(fun, 1, value, "xs:duration");
    }
    
    static Object timeZoneFromXTime(final DateTime time) {
        if (time.isZoneUnspecified()) {
            return Values.empty;
        }
        return Duration.makeMinutes(time.getZoneMinutes());
    }
    
    static IntNum asInteger(final int value) {
        return IntNum.make(value);
    }
    
    public static Object yearFromDateTime(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToDateTime("year-from-dateTime", arg).getYear());
    }
    
    public static Object monthFromDateTime(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToDateTime("month-from-dateTime", arg).getMonth());
    }
    
    public static Object dayFromDateTime(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToDateTime("day-from-dateTime", arg).getDay());
    }
    
    public static Object hoursFromDateTime(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToDateTime("hours-from-dateTime", arg).getHours());
    }
    
    public static Object minutesFromDateTime(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToDateTime("minutes-from-dateTime", arg).getMinutes());
    }
    
    static Number getSeconds(final DateTime date) {
        final int seconds = date.getSecondsOnly();
        long nanos = date.getNanoSecondsOnly();
        if (nanos == 0L) {
            return IntNum.make(seconds);
        }
        nanos += seconds * 1000000000L;
        return new BigDecimal(BigInteger.valueOf(nanos), 9);
    }
    
    public static Object secondsFromDateTime(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return getSeconds(coerceToDateTime("seconds-from-dateTime", arg));
    }
    
    public static Object timezoneFromDateTime(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return timeZoneFromXTime(coerceToDateTime("timezone-from-datetime", arg));
    }
    
    public static Object yearFromDate(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToDate("year-from-date", arg).getYear());
    }
    
    public static Object monthFromDate(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToDate("month-from-date", arg).getMonth());
    }
    
    public static Object dayFromDate(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToDate("day-from-date", arg).getDay());
    }
    
    public static Object timezoneFromDate(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return timeZoneFromXTime(coerceToDate("timezone-from-date", arg));
    }
    
    public static Object hoursFromTime(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToTime("hours-from-time", arg).getHours());
    }
    
    public static Object minutesFromTime(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToTime("minutes-from-time", arg).getMinutes());
    }
    
    public static Object secondsFromTime(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return getSeconds(coerceToTime("seconds-from-time", arg));
    }
    
    public static Object timezoneFromTime(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return timeZoneFromXTime(coerceToTime("timezone-from-time", arg));
    }
    
    public static Object yearsFromDuration(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToDuration("years-from-duration", arg).getYears());
    }
    
    public static Object monthsFromDuration(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToDuration("months-from-duration", arg).getMonths());
    }
    
    public static Object daysFromDuration(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToDuration("days-from-duration", arg).getDays());
    }
    
    public static Object hoursFromDuration(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToDuration("hours-from-duration", arg).getHours());
    }
    
    public static Object minutesFromDuration(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return asInteger(coerceToDuration("minutes-from-duration", arg).getMinutes());
    }
    
    public static BigDecimal secondsBigDecimalFromDuration(final long s, final int n) {
        if (n == 0) {
            return BigDecimal.valueOf(s);
        }
        int scale = 9;
        final boolean huge = (int)s != s;
        long ns;
        for (ns = (huge ? n : (s * 1000000000L + n)); ns % 10L == 0L; ns /= 10L, --scale) {}
        BigDecimal dec = new BigDecimal(BigInteger.valueOf(ns), scale);
        if (huge) {
            dec = BigDecimal.valueOf(s).add(dec);
        }
        return dec;
    }
    
    public static Object secondsFromDuration(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        final Duration d = coerceToDuration("seconds-from-duration", arg);
        final int s = d.getSecondsOnly();
        final int n = d.getNanoSecondsOnly();
        if (n == 0) {
            return asInteger(s);
        }
        return secondsBigDecimalFromDuration(s, n);
    }
    
    public static Duration getImplicitTimezone() {
        return Duration.makeMinutes(TimeZone.getDefault().getRawOffset() / 60000);
    }
    
    public static Object adjustDateTimeToTimezone(final Object time) {
        return adjustDateTimeToTimezone(time, getImplicitTimezone());
    }
    
    public static Object adjustDateTimeToTimezone(final Object time, final Object zone) {
        if (time == Values.empty || time == null) {
            return time;
        }
        final DateTime dtime = coerceToDateTime("adjust-dateTime-to-timezone", time);
        return adjustDateTimeToTimezoneRaw(dtime, zone);
    }
    
    public static Object adjustDateToTimezone(final Object time) {
        return adjustDateToTimezone(time, getImplicitTimezone());
    }
    
    public static Object adjustDateToTimezone(final Object time, final Object zone) {
        if (time == Values.empty || time == null) {
            return time;
        }
        final DateTime dtime = coerceToDate("adjust-date-to-timezone", time);
        return adjustDateTimeToTimezoneRaw(dtime, zone);
    }
    
    public static Object adjustTimeToTimezone(final Object time) {
        return adjustTimeToTimezone(time, getImplicitTimezone());
    }
    
    public static Object adjustTimeToTimezone(final Object time, final Object zone) {
        if (time == Values.empty || time == null) {
            return time;
        }
        final DateTime dtime = coerceToTime("adjust-time-to-timezone", time);
        return adjustDateTimeToTimezoneRaw(dtime, zone);
    }
    
    static Object adjustDateTimeToTimezoneRaw(final DateTime dtime, final Object zone) {
        if (zone == Values.empty || zone == null) {
            return dtime.withZoneUnspecified();
        }
        final Duration d = (Duration)zone;
        if (d.getNanoSecondsOnly() != 0 || d.getSecondsOnly() != 0) {
            throw new IllegalArgumentException("timezone offset with fractional minute");
        }
        final int delta = (int)d.getTotalMinutes();
        if (delta < -840 || delta > 840) {
            throw new IllegalArgumentException("timezone offset out of range");
        }
        return dtime.adjustTimezone(delta);
    }
    
    public static DateTime now() {
        return XTimeType.dateTimeType.now();
    }
    
    public static Object dateTime(final Object arg1, final Object arg2) {
        if (arg1 == null || arg1 == Values.empty) {
            return arg1;
        }
        if (arg2 == null || arg2 == Values.empty) {
            return arg2;
        }
        final DateTime date = coerceToDate("dateTime", arg1);
        final DateTime time = coerceToTime("dateTime", arg2);
        final StringBuffer sbuf = new StringBuffer();
        date.toStringDate(sbuf);
        sbuf.append('T');
        time.toStringTime(sbuf);
        final boolean hasZone1 = !date.isZoneUnspecified();
        final boolean hasZone2 = !time.isZoneUnspecified();
        if (hasZone1 || hasZone2) {
            final int zone1 = date.getZoneMinutes();
            final int zone2 = time.getZoneMinutes();
            if (hasZone1 && hasZone2 && zone1 != zone2) {
                throw new Error("dateTime: incompatible timezone in arguments");
            }
            DateTime.toStringZone(hasZone1 ? zone1 : zone2, sbuf);
        }
        return XTimeType.dateTimeType.valueOf(sbuf.toString());
    }
    
    public static DateTime currentDateTime() {
        DateTime current = TimeUtils.currentDateTimeLocal.get();
        if (current == null) {
            current = now();
            TimeUtils.currentDateTimeLocal.set(current);
        }
        return current;
    }
    
    public static DateTime currentDate() {
        return currentDateTime().cast(14);
    }
    
    public static DateTime currentTime() {
        return currentDateTime().cast(112);
    }
    
    public static Object implicitTimezone() {
        return timeZoneFromXTime(currentDateTime());
    }
    
    static {
        currentDateTimeLocal = new ThreadLocal<DateTime>();
    }
}
