/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.BaseUnit;
import gnu.math.Complex;
import gnu.math.Duration;
import gnu.math.NamedUnit;
import gnu.math.Numeric;
import gnu.math.Quantity;
import gnu.math.Quaternion;
import gnu.math.Unit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTime
extends Quantity
implements Cloneable {
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
    private static final Date minDate = new Date(Long.MIN_VALUE);
    public static TimeZone GMT = TimeZone.getTimeZone("GMT");

    public int components() {
        return this.mask & -129;
    }

    public DateTime cast(int newComponents) {
        int oldComponents = this.mask & -129;
        if (newComponents == oldComponents) {
            return this;
        }
        DateTime copy = new DateTime(newComponents, (GregorianCalendar)this.calendar.clone());
        if ((newComponents & ~oldComponents) != 0 && (oldComponents != 14 || newComponents != 126)) {
            throw new ClassCastException("cannot cast DateTime - missing conponents");
        }
        copy.mask = this.isZoneUnspecified() ? (copy.mask &= -129) : (copy.mask |= 128);
        int extraComponents = oldComponents & ~newComponents;
        if ((extraComponents & 112) != 0) {
            copy.calendar.clear(11);
            copy.calendar.clear(12);
            copy.calendar.clear(13);
        } else {
            copy.nanoSeconds = this.nanoSeconds;
        }
        if ((extraComponents & 2) != 0) {
            copy.calendar.clear(1);
            copy.calendar.clear(0);
        }
        if ((extraComponents & 4) != 0) {
            copy.calendar.clear(2);
        }
        if ((extraComponents & 8) != 0) {
            copy.calendar.clear(5);
        }
        return copy;
    }

    public DateTime(int mask) {
        this.calendar = new GregorianCalendar();
        this.calendar.setGregorianChange(minDate);
        this.calendar.clear();
        this.mask = mask;
    }

    public DateTime(int mask, GregorianCalendar calendar) {
        this.calendar = calendar;
        this.mask = mask;
    }

    public static DateTime parse(String value, int mask) {
        boolean wantTime;
        DateTime result = new DateTime(mask);
        value = value.trim();
        int len = value.length();
        int pos = 0;
        boolean wantDate = (mask & 14) != 0;
        boolean bl = wantTime = (mask & 112) != 0;
        if (wantDate) {
            pos = result.parseDate(value, pos, mask);
            if (wantTime) {
                pos = pos < 0 || pos >= len || value.charAt(pos) != 'T' ? -1 : ++pos;
            }
        }
        if (wantTime) {
            pos = result.parseTime(value, pos);
        }
        if ((pos = result.parseZone(value, pos)) != len) {
            throw new NumberFormatException("Unrecognized date/time '" + value + '\'');
        }
        return result;
    }

    int parseDate(String str, int start, int mask) {
        int part;
        int maxDay;
        int year;
        int month;
        if (start < 0) {
            return start;
        }
        int len = str.length();
        boolean negYear = false;
        if (start < len && str.charAt(start) == '-') {
            ++start;
            negYear = true;
        }
        int pos = start;
        if ((mask & 2) == 0) {
            if (!negYear) {
                return -1;
            }
            year = -1;
        } else {
            part = DateTime.parseDigits(str, pos);
            year = part >> 16;
            pos = part & 65535;
            if (pos != start + 4 && (pos <= start + 4 || str.charAt(start) == '0')) {
                return -1;
            }
            if (negYear || year == 0) {
                this.calendar.set(0, 0);
                this.calendar.set(1, year + 1);
            } else {
                this.calendar.set(1, year);
            }
        }
        if ((mask & 12) == 0) {
            return pos;
        }
        if (pos >= len || str.charAt(pos) != '-') {
            return -1;
        }
        start = ++pos;
        if ((mask & 4) != 0) {
            part = DateTime.parseDigits(str, start);
            month = part >> 16;
            pos = part & 65535;
            if (month <= 0 || month > 12 || pos != start + 2) {
                return -1;
            }
            this.calendar.set(2, month - 1);
            if ((mask & 8) == 0) {
                return pos;
            }
        } else {
            month = -1;
        }
        if (pos >= len || str.charAt(pos) != '-') {
            return -1;
        }
        start = pos + 1;
        part = DateTime.parseDigits(str, start);
        int day = part >> 16;
        pos = part & 65535;
        if (day > 0 && pos == start + 2 && day <= (maxDay = (mask & 4) == 0 ? 31 : DateTime.daysInMonth(month - 1, (mask & 2) != 0 ? year : 2000))) {
            this.calendar.set(5, day);
            return pos;
        }
        return -1;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static int daysInMonth(int month, int year) {
        switch (month) {
            case 3: 
            case 5: 
            case 8: 
            case 10: {
                return 30;
            }
            case 1: {
                return DateTime.isLeapYear(year) ? 29 : 28;
            }
        }
        return 31;
    }

    int parseZone(String str, int start) {
        if (start < 0) {
            return start;
        }
        int part = this.parseZoneMinutes(str, start);
        if (part == 0) {
            return -1;
        }
        if (part == start) {
            return start;
        }
        int minutes = part >> 16;
        int pos = part & 65535;
        TimeZone zone = minutes == 0 ? GMT : TimeZone.getTimeZone("GMT" + str.substring(start, pos));
        this.calendar.setTimeZone(zone);
        this.mask |= 128;
        return pos;
    }

    int parseZoneMinutes(String str, int start) {
        int part;
        int hour;
        int len = str.length();
        if (start == len || start < 0) {
            return start;
        }
        char ch = str.charAt(start);
        if (ch == 'Z') {
            return start + 1;
        }
        if (ch != '+' && ch != '-') {
            return start;
        }
        if ((hour = (part = DateTime.parseDigits(str, ++start)) >> 16) > 14) {
            return 0;
        }
        int minute = 60 * hour;
        int pos = part & 65535;
        if (pos != start + 2) {
            return 0;
        }
        if (pos < len) {
            if (str.charAt(pos) == ':') {
                start = pos + 1;
                part = DateTime.parseDigits(str, start);
                pos = part & 65535;
                if ((part >>= 16) > 0 && (part >= 60 || hour == 14)) {
                    return 0;
                }
                minute += part;
                if (pos != start + 2) {
                    return 0;
                }
            }
        } else {
            return 0;
        }
        if (minute > 840) {
            return 0;
        }
        if (ch == '-') {
            minute = -minute;
        }
        return minute << 16 | pos;
    }

    int parseTime(String str, int start) {
        if (start < 0) {
            return start;
        }
        int len = str.length();
        int pos = start;
        int part = DateTime.parseDigits(str, start);
        int hour = part >> 16;
        pos = part & 65535;
        if (hour <= 24 && pos == start + 2 && pos != len && str.charAt(pos) == ':') {
            start = pos + 1;
            part = DateTime.parseDigits(str, start);
            int minute = part >> 16;
            pos = part & 65535;
            if (minute < 60 && pos == start + 2 && pos != len && str.charAt(pos) == ':') {
                start = pos + 1;
                part = DateTime.parseDigits(str, start);
                int second = part >> 16;
                pos = part & 65535;
                if (second < 60 && pos == start + 2) {
                    if (pos + 1 < len && str.charAt(pos) == '.' && Character.digit(str.charAt(pos + 1), 10) >= 0) {
                        int dig;
                        int nanos = 0;
                        int nfrac = 0;
                        for (pos = start = pos + 1; pos < len && (dig = Character.digit(str.charAt(pos), 10)) >= 0; ++pos) {
                            if (nfrac < 9) {
                                nanos = 10 * nanos + dig;
                            } else if (nfrac == 9 && dig >= 5) {
                                ++nanos;
                            }
                            ++nfrac;
                        }
                        while (nfrac++ < 9) {
                            nanos = 10 * nanos;
                        }
                        this.nanoSeconds = nanos;
                    }
                    if (hour == 24 && (minute != 0 || second != 0 || this.nanoSeconds != 0)) {
                        return -1;
                    }
                    this.calendar.set(11, hour);
                    this.calendar.set(12, minute);
                    this.calendar.set(13, second);
                    return pos;
                }
            }
        }
        return -1;
    }

    private static int parseDigits(String str, int start) {
        char ch;
        int i;
        int dig;
        int val = -1;
        int len = str.length();
        for (i = start; i < len && (dig = Character.digit(ch = str.charAt(i), 10)) >= 0; ++i) {
            if (val > 20000) {
                return 0;
            }
            val = val < 0 ? dig : 10 * val + dig;
        }
        return val < 0 ? i : val << 16 | i;
    }

    public int getYear() {
        int year = this.calendar.get(1);
        if (this.calendar.get(0) == 0) {
            year = 1 - year;
        }
        return year;
    }

    public int getMonth() {
        return this.calendar.get(2) + 1;
    }

    public int getDay() {
        return this.calendar.get(5);
    }

    public int getHours() {
        return this.calendar.get(11);
    }

    public int getMinutes() {
        return this.calendar.get(12);
    }

    public int getSecondsOnly() {
        return this.calendar.get(13);
    }

    public int getWholeSeconds() {
        return this.calendar.get(13);
    }

    public int getNanoSecondsOnly() {
        return this.nanoSeconds;
    }

    public static int compare(DateTime date1, DateTime date2) {
        long millis1 = date1.calendar.getTimeInMillis();
        long millis2 = date2.calendar.getTimeInMillis();
        if (((date1.mask | date2.mask) & 14) == 0) {
            if (millis1 < 0L) {
                millis1 += 86400000L;
            }
            if (millis2 < 0L) {
                millis2 += 86400000L;
            }
        }
        int nanos1 = date1.nanoSeconds;
        int nanos2 = date2.nanoSeconds;
        return (millis1 += (long)((nanos1 %= 1000000) / 1000000)) < (millis2 += (long)((nanos2 %= 1000000) / 1000000)) ? -1 : (millis1 > millis2 ? 1 : (nanos1 < nanos2 ? -1 : (nanos1 > nanos2 ? 1 : 0)));
    }

    @Override
    public int compare(Object obj) {
        if (obj instanceof DateTime) {
            return DateTime.compare(this, (DateTime)obj);
        }
        return ((Numeric)obj).compareReversed(this);
    }

    public static Duration sub(DateTime date1, DateTime date2) {
        long millis1 = date1.calendar.getTimeInMillis();
        long millis2 = date2.calendar.getTimeInMillis();
        int nanos1 = date1.nanoSeconds;
        int nanos2 = date2.nanoSeconds;
        long millis = (millis1 += (long)((nanos1 %= 1000000) / 1000000)) - (millis2 += (long)(nanos2 / 1000000));
        long seconds = millis / 1000L;
        int nanos = (int)(millis % 1000L * 1000000L + (long)(nanos2 %= 1000000) - (long)nanos2);
        return Duration.make(0, seconds += (long)(nanos / 1000000000), nanos %= 1000000000, Unit.second);
    }

    public DateTime withZoneUnspecified() {
        if (this.isZoneUnspecified()) {
            return this;
        }
        DateTime r = new DateTime(this.mask, (GregorianCalendar)this.calendar.clone());
        r.calendar.setTimeZone(TimeZone.getDefault());
        r.mask &= -129;
        return r;
    }

    public DateTime adjustTimezone(int newOffset) {
        TimeZone zone;
        DateTime r = new DateTime(this.mask, (GregorianCalendar)this.calendar.clone());
        if (newOffset == 0) {
            zone = GMT;
        } else {
            StringBuffer sbuf = new StringBuffer("GMT");
            DateTime.toStringZone(newOffset, sbuf);
            zone = TimeZone.getTimeZone(sbuf.toString());
        }
        r.calendar.setTimeZone(zone);
        if ((r.mask & 128) != 0) {
            long millis = this.calendar.getTimeInMillis();
            r.calendar.setTimeInMillis(millis);
            if ((this.mask & 112) == 0) {
                r.calendar.set(11, 0);
                r.calendar.set(12, 0);
                r.calendar.set(13, 0);
                r.nanoSeconds = 0;
            }
        } else {
            r.mask |= 128;
        }
        return r;
    }

    public static DateTime add(DateTime x, Duration y, int k) {
        long nanos;
        if (y.unit == Unit.duration || y.unit == Unit.month && (x.mask & 14) != 14) {
            throw new IllegalArgumentException("invalid date/time +/- duration combinatuion");
        }
        DateTime r = new DateTime(x.mask, (GregorianCalendar)x.calendar.clone());
        if (y.months != 0) {
            int year;
            int daysInMonth;
            int month = 12 * r.getYear() + r.calendar.get(2);
            int day = r.calendar.get(5);
            if ((month += k * y.months) >= 12) {
                year = month / 12;
                r.calendar.set(0, 1);
                daysInMonth = DateTime.daysInMonth(month %= 12, year);
            } else {
                month = 11 - month;
                r.calendar.set(0, 0);
                year = month / 12 + 1;
                month = 11 - month % 12;
                daysInMonth = DateTime.daysInMonth(month, 1);
            }
            if (day > daysInMonth) {
                day = daysInMonth;
            }
            r.calendar.set(year, month, day);
        }
        if ((nanos = (long)x.nanoSeconds + (long)k * (y.seconds * 1000000000L + (long)y.nanos)) != 0L) {
            if ((x.mask & 112) == 0) {
                long nanosPerDay = 86400000000000L;
                long mod = nanos % nanosPerDay;
                if (mod < 0L) {
                    mod += nanosPerDay;
                }
                nanos -= mod;
            }
            long millis = r.calendar.getTimeInMillis();
            r.calendar.setTimeInMillis(millis += nanos / 1000000000L * 1000L);
            r.nanoSeconds = (int)(nanos % 1000000000L);
        }
        return r;
    }

    public static DateTime addMinutes(DateTime x, int y) {
        return DateTime.addSeconds(x, 60 * y);
    }

    public static DateTime addSeconds(DateTime x, int y) {
        DateTime r = new DateTime(x.mask, (GregorianCalendar)x.calendar.clone());
        long nanos = (long)y * 1000000000L;
        if (nanos != 0L) {
            nanos = (long)x.nanoSeconds + nanos;
            long millis = x.calendar.getTimeInMillis();
            r.calendar.setTimeInMillis(millis += nanos / 1000000L);
            r.nanoSeconds = (int)(nanos % 1000000L);
        }
        return r;
    }

    @Override
    public Numeric add(Object y, int k) {
        if (y instanceof Duration) {
            return DateTime.add(this, (Duration)y, k);
        }
        if (y instanceof DateTime && k == -1) {
            return DateTime.sub(this, (DateTime)y);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Numeric addReversed(Numeric x, int k) {
        if (x instanceof Duration && k == 1) {
            return DateTime.add(this, (Duration)x, k);
        }
        throw new IllegalArgumentException();
    }

    private static void append(int value, StringBuffer sbuf, int minWidth) {
        int start = sbuf.length();
        sbuf.append(value);
        int padding = start + minWidth - sbuf.length();
        while (--padding >= 0) {
            sbuf.insert(start, '0');
        }
    }

    public void toStringDate(StringBuffer sbuf) {
        int mask = this.components();
        if ((mask & 2) != 0) {
            int year = this.calendar.get(1);
            if (this.calendar.get(0) == 0 && --year != 0) {
                sbuf.append('-');
            }
            DateTime.append(year, sbuf, 4);
        } else {
            sbuf.append('-');
        }
        if ((mask & 12) != 0) {
            sbuf.append('-');
            if ((mask & 4) != 0) {
                DateTime.append(this.getMonth(), sbuf, 2);
            }
            if ((mask & 8) != 0) {
                sbuf.append('-');
                DateTime.append(this.getDay(), sbuf, 2);
            }
        }
    }

    public void toStringTime(StringBuffer sbuf) {
        DateTime.append(this.getHours(), sbuf, 2);
        sbuf.append(':');
        DateTime.append(this.getMinutes(), sbuf, 2);
        sbuf.append(':');
        DateTime.append(this.getWholeSeconds(), sbuf, 2);
        Duration.appendNanoSeconds(this.nanoSeconds, sbuf);
    }

    public boolean isZoneUnspecified() {
        return (this.mask & 128) == 0;
    }

    public int getZoneMinutes() {
        return this.calendar.getTimeZone().getRawOffset() / 60000;
    }

    public static TimeZone minutesToTimeZone(int minutes) {
        if (minutes == 0) {
            return GMT;
        }
        StringBuffer sbuf = new StringBuffer("GMT");
        DateTime.toStringZone(minutes, sbuf);
        return TimeZone.getTimeZone(sbuf.toString());
    }

    public void setTimeZone(TimeZone timeZone) {
        this.calendar.setTimeZone(timeZone);
    }

    public void toStringZone(StringBuffer sbuf) {
        if (this.isZoneUnspecified()) {
            return;
        }
        DateTime.toStringZone(this.getZoneMinutes(), sbuf);
    }

    public static void toStringZone(int minutes, StringBuffer sbuf) {
        if (minutes == 0) {
            sbuf.append('Z');
        } else {
            if (minutes < 0) {
                sbuf.append('-');
                minutes = -minutes;
            } else {
                sbuf.append('+');
            }
            DateTime.append(minutes / 60, sbuf, 2);
            sbuf.append(':');
            DateTime.append(minutes % 60, sbuf, 2);
        }
    }

    public void toString(StringBuffer sbuf) {
        boolean hasTime;
        int mask = this.components();
        boolean hasDate = (mask & 14) != 0;
        boolean bl = hasTime = (mask & 112) != 0;
        if (hasDate) {
            this.toStringDate(sbuf);
            if (hasTime) {
                sbuf.append('T');
            }
        }
        if (hasTime) {
            this.toStringTime(sbuf);
        }
        this.toStringZone(sbuf);
    }

    @Override
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        this.toString(sbuf);
        return sbuf.toString();
    }

    @Override
    public boolean isExact() {
        return (this.mask & 112) == 0;
    }

    @Override
    public boolean isZero() {
        throw new UnsupportedOperationException("DateTime.isZero not meaningful!");
    }

    @Override
    public Unit unit() {
        return this.unit;
    }

    @Override
    public Complex number() {
        throw new UnsupportedOperationException("number needs to be implemented!");
    }
}

