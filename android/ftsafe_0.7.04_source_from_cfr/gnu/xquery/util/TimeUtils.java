/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XTimeType;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.DateTime;
import gnu.math.Duration;
import gnu.math.IntNum;
import gnu.xml.TextUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TimeZone;

public class TimeUtils {
    static final ThreadLocal<DateTime> currentDateTimeLocal = new ThreadLocal();

    static DateTime coerceToDateTime(String fun, Object value) {
        if (XTimeType.dateTimeType.isInstance(value)) {
            return (DateTime)value;
        }
        if (value instanceof KNode || value instanceof UntypedAtomic) {
            return XTimeType.parseDateTime(TextUtils.stringValue(value), 126);
        }
        throw new WrongType(fun, 1, value, "xs:dateTime");
    }

    static DateTime coerceToDate(String fun, Object value) {
        if (XTimeType.dateType.isInstance(value)) {
            return (DateTime)value;
        }
        if (value instanceof KNode || value instanceof UntypedAtomic) {
            return XTimeType.parseDateTime(TextUtils.stringValue(value), 14);
        }
        throw new WrongType(fun, 1, value, "xs:date");
    }

    static DateTime coerceToTime(String fun, Object value) {
        if (XTimeType.timeType.isInstance(value)) {
            return (DateTime)value;
        }
        if (value instanceof KNode || value instanceof UntypedAtomic) {
            return XTimeType.parseDateTime(TextUtils.stringValue(value), 112);
        }
        throw new WrongType(fun, 1, value, "xs:time");
    }

    static Duration coerceToDuration(String fun, Object value) {
        if (value instanceof Duration) {
            return (Duration)value;
        }
        throw new WrongType(fun, 1, value, "xs:duration");
    }

    static Object timeZoneFromXTime(DateTime time2) {
        if (time2.isZoneUnspecified()) {
            return Values.empty;
        }
        return Duration.makeMinutes(time2.getZoneMinutes());
    }

    static IntNum asInteger(int value) {
        return IntNum.make(value);
    }

    public static Object yearFromDateTime(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToDateTime("year-from-dateTime", arg).getYear());
    }

    public static Object monthFromDateTime(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToDateTime("month-from-dateTime", arg).getMonth());
    }

    public static Object dayFromDateTime(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToDateTime("day-from-dateTime", arg).getDay());
    }

    public static Object hoursFromDateTime(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToDateTime("hours-from-dateTime", arg).getHours());
    }

    public static Object minutesFromDateTime(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToDateTime("minutes-from-dateTime", arg).getMinutes());
    }

    static Number getSeconds(DateTime date) {
        int seconds = date.getSecondsOnly();
        long nanos = date.getNanoSecondsOnly();
        if (nanos == 0L) {
            return IntNum.make(seconds);
        }
        return new BigDecimal(BigInteger.valueOf(nanos += (long)seconds * 1000000000L), 9);
    }

    public static Object secondsFromDateTime(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.getSeconds(TimeUtils.coerceToDateTime("seconds-from-dateTime", arg));
    }

    public static Object timezoneFromDateTime(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.timeZoneFromXTime(TimeUtils.coerceToDateTime("timezone-from-datetime", arg));
    }

    public static Object yearFromDate(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToDate("year-from-date", arg).getYear());
    }

    public static Object monthFromDate(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToDate("month-from-date", arg).getMonth());
    }

    public static Object dayFromDate(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToDate("day-from-date", arg).getDay());
    }

    public static Object timezoneFromDate(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.timeZoneFromXTime(TimeUtils.coerceToDate("timezone-from-date", arg));
    }

    public static Object hoursFromTime(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToTime("hours-from-time", arg).getHours());
    }

    public static Object minutesFromTime(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToTime("minutes-from-time", arg).getMinutes());
    }

    public static Object secondsFromTime(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.getSeconds(TimeUtils.coerceToTime("seconds-from-time", arg));
    }

    public static Object timezoneFromTime(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.timeZoneFromXTime(TimeUtils.coerceToTime("timezone-from-time", arg));
    }

    public static Object yearsFromDuration(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToDuration("years-from-duration", arg).getYears());
    }

    public static Object monthsFromDuration(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToDuration("months-from-duration", arg).getMonths());
    }

    public static Object daysFromDuration(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToDuration("days-from-duration", arg).getDays());
    }

    public static Object hoursFromDuration(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToDuration("hours-from-duration", arg).getHours());
    }

    public static Object minutesFromDuration(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        return TimeUtils.asInteger(TimeUtils.coerceToDuration("minutes-from-duration", arg).getMinutes());
    }

    public static BigDecimal secondsBigDecimalFromDuration(long s, int n) {
        long ns;
        if (n == 0) {
            return BigDecimal.valueOf(s);
        }
        int scale = 9;
        boolean huge = (long)((int)s) != s;
        long l = ns = huge ? (long)n : s * 1000000000L + (long)n;
        while (ns % 10L == 0L) {
            ns /= 10L;
            --scale;
        }
        BigDecimal dec = new BigDecimal(BigInteger.valueOf(ns), scale);
        if (huge) {
            dec = BigDecimal.valueOf(s).add(dec);
        }
        return dec;
    }

    public static Object secondsFromDuration(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        Duration d = TimeUtils.coerceToDuration("seconds-from-duration", arg);
        int s = d.getSecondsOnly();
        int n = d.getNanoSecondsOnly();
        if (n == 0) {
            return TimeUtils.asInteger(s);
        }
        return TimeUtils.secondsBigDecimalFromDuration(s, n);
    }

    public static Duration getImplicitTimezone() {
        return Duration.makeMinutes(TimeZone.getDefault().getRawOffset() / 60000);
    }

    public static Object adjustDateTimeToTimezone(Object time2) {
        return TimeUtils.adjustDateTimeToTimezone(time2, TimeUtils.getImplicitTimezone());
    }

    public static Object adjustDateTimeToTimezone(Object time2, Object zone) {
        if (time2 == Values.empty || time2 == null) {
            return time2;
        }
        DateTime dtime = TimeUtils.coerceToDateTime("adjust-dateTime-to-timezone", time2);
        return TimeUtils.adjustDateTimeToTimezoneRaw(dtime, zone);
    }

    public static Object adjustDateToTimezone(Object time2) {
        return TimeUtils.adjustDateToTimezone(time2, TimeUtils.getImplicitTimezone());
    }

    public static Object adjustDateToTimezone(Object time2, Object zone) {
        if (time2 == Values.empty || time2 == null) {
            return time2;
        }
        DateTime dtime = TimeUtils.coerceToDate("adjust-date-to-timezone", time2);
        return TimeUtils.adjustDateTimeToTimezoneRaw(dtime, zone);
    }

    public static Object adjustTimeToTimezone(Object time2) {
        return TimeUtils.adjustTimeToTimezone(time2, TimeUtils.getImplicitTimezone());
    }

    public static Object adjustTimeToTimezone(Object time2, Object zone) {
        if (time2 == Values.empty || time2 == null) {
            return time2;
        }
        DateTime dtime = TimeUtils.coerceToTime("adjust-time-to-timezone", time2);
        return TimeUtils.adjustDateTimeToTimezoneRaw(dtime, zone);
    }

    static Object adjustDateTimeToTimezoneRaw(DateTime dtime, Object zone) {
        if (zone == Values.empty || zone == null) {
            return dtime.withZoneUnspecified();
        }
        Duration d = (Duration)zone;
        if (d.getNanoSecondsOnly() != 0 || d.getSecondsOnly() != 0) {
            throw new IllegalArgumentException("timezone offset with fractional minute");
        }
        int delta = (int)d.getTotalMinutes();
        if (delta < -840 || delta > 840) {
            throw new IllegalArgumentException("timezone offset out of range");
        }
        return dtime.adjustTimezone(delta);
    }

    public static DateTime now() {
        return XTimeType.dateTimeType.now();
    }

    public static Object dateTime(Object arg1, Object arg2) {
        boolean hasZone2;
        if (arg1 == null || arg1 == Values.empty) {
            return arg1;
        }
        if (arg2 == null || arg2 == Values.empty) {
            return arg2;
        }
        DateTime date = TimeUtils.coerceToDate("dateTime", arg1);
        DateTime time2 = TimeUtils.coerceToTime("dateTime", arg2);
        StringBuffer sbuf = new StringBuffer();
        date.toStringDate(sbuf);
        sbuf.append('T');
        time2.toStringTime(sbuf);
        boolean hasZone1 = !date.isZoneUnspecified();
        boolean bl = hasZone2 = !time2.isZoneUnspecified();
        if (hasZone1 || hasZone2) {
            int zone1 = date.getZoneMinutes();
            int zone2 = time2.getZoneMinutes();
            if (hasZone1 && hasZone2 && zone1 != zone2) {
                throw new Error("dateTime: incompatible timezone in arguments");
            }
            DateTime.toStringZone(hasZone1 ? zone1 : zone2, sbuf);
        }
        return (DateTime)XTimeType.dateTimeType.valueOf(sbuf.toString());
    }

    public static DateTime currentDateTime() {
        DateTime current = currentDateTimeLocal.get();
        if (current == null) {
            current = TimeUtils.now();
            currentDateTimeLocal.set(current);
        }
        return current;
    }

    public static DateTime currentDate() {
        return TimeUtils.currentDateTime().cast(14);
    }

    public static DateTime currentTime() {
        return TimeUtils.currentDateTime().cast(112);
    }

    public static Object implicitTimezone() {
        return TimeUtils.timeZoneFromXTime(TimeUtils.currentDateTime());
    }
}

