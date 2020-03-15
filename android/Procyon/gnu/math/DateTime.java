// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.util.TimeZone;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTime extends Quantity implements Cloneable
{
    Unit unit;
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
    private static final Date minDate;
    public static TimeZone GMT;
    
    public int components() {
        return this.mask & 0xFFFFFF7F;
    }
    
    public DateTime cast(final int newComponents) {
        final int oldComponents = this.mask & 0xFFFFFF7F;
        if (newComponents == oldComponents) {
            return this;
        }
        final DateTime copy = new DateTime(newComponents, (GregorianCalendar)this.calendar.clone());
        if ((newComponents & ~oldComponents) != 0x0 && (oldComponents != 14 || newComponents != 126)) {
            throw new ClassCastException("cannot cast DateTime - missing conponents");
        }
        if (this.isZoneUnspecified()) {
            final DateTime dateTime = copy;
            dateTime.mask &= 0xFFFFFF7F;
        }
        else {
            final DateTime dateTime2 = copy;
            dateTime2.mask |= 0x80;
        }
        final int extraComponents = oldComponents & ~newComponents;
        if ((extraComponents & 0x70) != 0x0) {
            copy.calendar.clear(11);
            copy.calendar.clear(12);
            copy.calendar.clear(13);
        }
        else {
            copy.nanoSeconds = this.nanoSeconds;
        }
        if ((extraComponents & 0x2) != 0x0) {
            copy.calendar.clear(1);
            copy.calendar.clear(0);
        }
        if ((extraComponents & 0x4) != 0x0) {
            copy.calendar.clear(2);
        }
        if ((extraComponents & 0x8) != 0x0) {
            copy.calendar.clear(5);
        }
        return copy;
    }
    
    public DateTime(final int mask) {
        this.unit = Unit.date;
        (this.calendar = new GregorianCalendar()).setGregorianChange(DateTime.minDate);
        this.calendar.clear();
        this.mask = mask;
    }
    
    public DateTime(final int mask, final GregorianCalendar calendar) {
        this.unit = Unit.date;
        this.calendar = calendar;
        this.mask = mask;
    }
    
    public static DateTime parse(String value, final int mask) {
        final DateTime result = new DateTime(mask);
        value = value.trim();
        final int len = value.length();
        int pos = 0;
        final boolean wantDate = (mask & 0xE) != 0x0;
        final boolean wantTime = (mask & 0x70) != 0x0;
        if (wantDate) {
            pos = result.parseDate(value, pos, mask);
            if (wantTime) {
                if (pos < 0 || pos >= len || value.charAt(pos) != 'T') {
                    pos = -1;
                }
                else {
                    ++pos;
                }
            }
        }
        if (wantTime) {
            pos = result.parseTime(value, pos);
        }
        pos = result.parseZone(value, pos);
        if (pos != len) {
            throw new NumberFormatException("Unrecognized date/time '" + value + '\'');
        }
        return result;
    }
    
    int parseDate(final String str, int start, final int mask) {
        if (start < 0) {
            return start;
        }
        final int len = str.length();
        boolean negYear = false;
        if (start < len && str.charAt(start) == '-') {
            ++start;
            negYear = true;
        }
        int pos = start;
        int year;
        if ((mask & 0x2) == 0x0) {
            if (!negYear) {
                return -1;
            }
            year = -1;
        }
        else {
            final int part = parseDigits(str, pos);
            year = part >> 16;
            pos = (part & 0xFFFF);
            if (pos != start + 4 && (pos <= start + 4 || str.charAt(start) == '0')) {
                return -1;
            }
            if (negYear || year == 0) {
                this.calendar.set(0, 0);
                this.calendar.set(1, year + 1);
            }
            else {
                this.calendar.set(1, year);
            }
        }
        if ((mask & 0xC) == 0x0) {
            return pos;
        }
        if (pos >= len || str.charAt(pos) != '-') {
            return -1;
        }
        start = ++pos;
        int month;
        if ((mask & 0x4) != 0x0) {
            final int part = parseDigits(str, start);
            month = part >> 16;
            pos = (part & 0xFFFF);
            if (month <= 0 || month > 12 || pos != start + 2) {
                return -1;
            }
            this.calendar.set(2, month - 1);
            if ((mask & 0x8) == 0x0) {
                return pos;
            }
        }
        else {
            month = -1;
        }
        if (pos >= len || str.charAt(pos) != '-') {
            return -1;
        }
        start = pos + 1;
        final int part = parseDigits(str, start);
        final int day = part >> 16;
        pos = (part & 0xFFFF);
        if (day > 0 && pos == start + 2) {
            int maxDay;
            if ((mask & 0x4) == 0x0) {
                maxDay = 31;
            }
            else {
                maxDay = daysInMonth(month - 1, ((mask & 0x2) != 0x0) ? year : 2000);
            }
            if (day <= maxDay) {
                this.calendar.set(5, day);
                return pos;
            }
        }
        return -1;
    }
    
    public static boolean isLeapYear(final int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
    
    public static int daysInMonth(final int month, final int year) {
        switch (month) {
            case 3:
            case 5:
            case 8:
            case 10: {
                return 30;
            }
            case 1: {
                return isLeapYear(year) ? 29 : 28;
            }
            default: {
                return 31;
            }
        }
    }
    
    int parseZone(final String str, final int start) {
        if (start < 0) {
            return start;
        }
        final int part = this.parseZoneMinutes(str, start);
        if (part == 0) {
            return -1;
        }
        if (part == start) {
            return start;
        }
        final int minutes = part >> 16;
        final int pos = part & 0xFFFF;
        TimeZone zone;
        if (minutes == 0) {
            zone = DateTime.GMT;
        }
        else {
            zone = TimeZone.getTimeZone("GMT" + str.substring(start, pos));
        }
        this.calendar.setTimeZone(zone);
        this.mask |= 0x80;
        return pos;
    }
    
    int parseZoneMinutes(final String str, int start) {
        final int len = str.length();
        if (start == len || start < 0) {
            return start;
        }
        final char ch = str.charAt(start);
        if (ch == 'Z') {
            return start + 1;
        }
        if (ch != '+' && ch != '-') {
            return start;
        }
        ++start;
        int part = parseDigits(str, start);
        final int hour = part >> 16;
        if (hour > 14) {
            return 0;
        }
        int minute = 60 * hour;
        int pos = part & 0xFFFF;
        if (pos != start + 2) {
            return 0;
        }
        if (pos >= len) {
            return 0;
        }
        if (str.charAt(pos) == ':') {
            start = pos + 1;
            part = parseDigits(str, start);
            pos = (part & 0xFFFF);
            part >>= 16;
            if (part > 0 && (part >= 60 || hour == 14)) {
                return 0;
            }
            minute += part;
            if (pos != start + 2) {
                return 0;
            }
        }
        if (minute > 840) {
            return 0;
        }
        if (ch == '-') {
            minute = -minute;
        }
        return minute << 16 | pos;
    }
    
    int parseTime(final String str, int start) {
        if (start < 0) {
            return start;
        }
        final int len = str.length();
        int pos = start;
        int part = parseDigits(str, start);
        final int hour = part >> 16;
        pos = (part & 0xFFFF);
        if (hour <= 24 && pos == start + 2 && pos != len && str.charAt(pos) == ':') {
            start = pos + 1;
            part = parseDigits(str, start);
            final int minute = part >> 16;
            pos = (part & 0xFFFF);
            if (minute < 60 && pos == start + 2 && pos != len && str.charAt(pos) == ':') {
                start = pos + 1;
                part = parseDigits(str, start);
                final int second = part >> 16;
                pos = (part & 0xFFFF);
                if (second < 60 && pos == start + 2) {
                    if (pos + 1 < len && str.charAt(pos) == '.' && Character.digit(str.charAt(pos + 1), 10) >= 0) {
                        start = ++pos;
                        int nanos = 0;
                        int nfrac = 0;
                        while (pos < len) {
                            final int dig = Character.digit(str.charAt(pos), 10);
                            if (dig < 0) {
                                break;
                            }
                            if (nfrac < 9) {
                                nanos = 10 * nanos + dig;
                            }
                            else if (nfrac == 9 && dig >= 5) {
                                ++nanos;
                            }
                            ++nfrac;
                            ++pos;
                        }
                        while (nfrac++ < 9) {
                            nanos *= 10;
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
    
    private static int parseDigits(final String str, final int start) {
        int i = start;
        int val = -1;
        for (int len = str.length(); i < len; ++i) {
            final char ch = str.charAt(i);
            final int dig = Character.digit(ch, 10);
            if (dig < 0) {
                break;
            }
            if (val > 20000) {
                return 0;
            }
            val = ((val < 0) ? dig : (10 * val + dig));
        }
        return (val < 0) ? i : (val << 16 | i);
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
    
    public static int compare(final DateTime date1, final DateTime date2) {
        long millis1 = date1.calendar.getTimeInMillis();
        long millis2 = date2.calendar.getTimeInMillis();
        if (((date1.mask | date2.mask) & 0xE) == 0x0) {
            if (millis1 < 0L) {
                millis1 += 86400000L;
            }
            if (millis2 < 0L) {
                millis2 += 86400000L;
            }
        }
        int nanos1 = date1.nanoSeconds;
        int nanos2 = date2.nanoSeconds;
        millis1 += nanos1 / 1000000;
        millis2 += nanos2 / 1000000;
        nanos1 %= 1000000;
        nanos2 %= 1000000;
        return (millis1 < millis2) ? -1 : ((millis1 > millis2) ? 1 : ((nanos1 < nanos2) ? -1 : ((nanos1 > nanos2) ? 1 : 0)));
    }
    
    @Override
    public int compare(final Object obj) {
        if (obj instanceof DateTime) {
            return compare(this, (DateTime)obj);
        }
        return ((Numeric)obj).compareReversed(this);
    }
    
    public static Duration sub(final DateTime date1, final DateTime date2) {
        long millis1 = date1.calendar.getTimeInMillis();
        long millis2 = date2.calendar.getTimeInMillis();
        int nanos1 = date1.nanoSeconds;
        int nanos2 = date2.nanoSeconds;
        millis1 += nanos1 / 1000000;
        millis2 += nanos2 / 1000000;
        nanos1 %= 1000000;
        nanos2 %= 1000000;
        final long millis3 = millis1 - millis2;
        long seconds = millis3 / 1000L;
        int nanos3 = (int)(millis3 % 1000L * 1000000L + nanos2 - nanos2);
        seconds += nanos3 / 1000000000;
        nanos3 %= 1000000000;
        return Duration.make(0, seconds, nanos3, Unit.second);
    }
    
    public DateTime withZoneUnspecified() {
        if (this.isZoneUnspecified()) {
            return this;
        }
        final DateTime r = new DateTime(this.mask, (GregorianCalendar)this.calendar.clone());
        r.calendar.setTimeZone(TimeZone.getDefault());
        final DateTime dateTime = r;
        dateTime.mask &= 0xFFFFFF7F;
        return r;
    }
    
    public DateTime adjustTimezone(final int newOffset) {
        final DateTime r = new DateTime(this.mask, (GregorianCalendar)this.calendar.clone());
        TimeZone zone;
        if (newOffset == 0) {
            zone = DateTime.GMT;
        }
        else {
            final StringBuffer sbuf = new StringBuffer("GMT");
            toStringZone(newOffset, sbuf);
            zone = TimeZone.getTimeZone(sbuf.toString());
        }
        r.calendar.setTimeZone(zone);
        if ((r.mask & 0x80) != 0x0) {
            final long millis = this.calendar.getTimeInMillis();
            r.calendar.setTimeInMillis(millis);
            if ((this.mask & 0x70) == 0x0) {
                r.calendar.set(11, 0);
                r.calendar.set(12, 0);
                r.calendar.set(13, 0);
                r.nanoSeconds = 0;
            }
        }
        else {
            final DateTime dateTime = r;
            dateTime.mask |= 0x80;
        }
        return r;
    }
    
    public static DateTime add(final DateTime x, final Duration y, final int k) {
        if (y.unit == Unit.duration || (y.unit == Unit.month && (x.mask & 0xE) != 0xE)) {
            throw new IllegalArgumentException("invalid date/time +/- duration combinatuion");
        }
        final DateTime r = new DateTime(x.mask, (GregorianCalendar)x.calendar.clone());
        if (y.months != 0) {
            int month = 12 * r.getYear() + r.calendar.get(2);
            month += k * y.months;
            int day = r.calendar.get(5);
            int year;
            int daysInMonth;
            if (month >= 12) {
                year = month / 12;
                month %= 12;
                r.calendar.set(0, 1);
                daysInMonth = daysInMonth(month, year);
            }
            else {
                month = 11 - month;
                r.calendar.set(0, 0);
                year = month / 12 + 1;
                month = 11 - month % 12;
                daysInMonth = daysInMonth(month, 1);
            }
            if (day > daysInMonth) {
                day = daysInMonth;
            }
            r.calendar.set(year, month, day);
        }
        long nanos = x.nanoSeconds + k * (y.seconds * 1000000000L + y.nanos);
        if (nanos != 0L) {
            if ((x.mask & 0x70) == 0x0) {
                final long nanosPerDay = 86400000000000L;
                long mod = nanos % nanosPerDay;
                if (mod < 0L) {
                    mod += nanosPerDay;
                }
                nanos -= mod;
            }
            long millis = r.calendar.getTimeInMillis();
            millis += nanos / 1000000000L * 1000L;
            r.calendar.setTimeInMillis(millis);
            r.nanoSeconds = (int)(nanos % 1000000000L);
        }
        return r;
    }
    
    public static DateTime addMinutes(final DateTime x, final int y) {
        return addSeconds(x, 60 * y);
    }
    
    public static DateTime addSeconds(final DateTime x, final int y) {
        final DateTime r = new DateTime(x.mask, (GregorianCalendar)x.calendar.clone());
        long nanos = y * 1000000000L;
        if (nanos != 0L) {
            nanos += x.nanoSeconds;
            long millis = x.calendar.getTimeInMillis();
            millis += nanos / 1000000L;
            r.calendar.setTimeInMillis(millis);
            r.nanoSeconds = (int)(nanos % 1000000L);
        }
        return r;
    }
    
    @Override
    public Numeric add(final Object y, final int k) {
        if (y instanceof Duration) {
            return add(this, (Duration)y, k);
        }
        if (y instanceof DateTime && k == -1) {
            return sub(this, (DateTime)y);
        }
        throw new IllegalArgumentException();
    }
    
    @Override
    public Numeric addReversed(final Numeric x, final int k) {
        if (x instanceof Duration && k == 1) {
            return add(this, (Duration)x, k);
        }
        throw new IllegalArgumentException();
    }
    
    private static void append(final int value, final StringBuffer sbuf, final int minWidth) {
        final int start = sbuf.length();
        sbuf.append(value);
        int padding = start + minWidth - sbuf.length();
        while (--padding >= 0) {
            sbuf.insert(start, '0');
        }
    }
    
    public void toStringDate(final StringBuffer sbuf) {
        final int mask = this.components();
        if ((mask & 0x2) != 0x0) {
            int year = this.calendar.get(1);
            if (this.calendar.get(0) == 0 && --year != 0) {
                sbuf.append('-');
            }
            append(year, sbuf, 4);
        }
        else {
            sbuf.append('-');
        }
        if ((mask & 0xC) != 0x0) {
            sbuf.append('-');
            if ((mask & 0x4) != 0x0) {
                append(this.getMonth(), sbuf, 2);
            }
            if ((mask & 0x8) != 0x0) {
                sbuf.append('-');
                append(this.getDay(), sbuf, 2);
            }
        }
    }
    
    public void toStringTime(final StringBuffer sbuf) {
        append(this.getHours(), sbuf, 2);
        sbuf.append(':');
        append(this.getMinutes(), sbuf, 2);
        sbuf.append(':');
        append(this.getWholeSeconds(), sbuf, 2);
        Duration.appendNanoSeconds(this.nanoSeconds, sbuf);
    }
    
    public boolean isZoneUnspecified() {
        return (this.mask & 0x80) == 0x0;
    }
    
    public int getZoneMinutes() {
        return this.calendar.getTimeZone().getRawOffset() / 60000;
    }
    
    public static TimeZone minutesToTimeZone(final int minutes) {
        if (minutes == 0) {
            return DateTime.GMT;
        }
        final StringBuffer sbuf = new StringBuffer("GMT");
        toStringZone(minutes, sbuf);
        return TimeZone.getTimeZone(sbuf.toString());
    }
    
    public void setTimeZone(final TimeZone timeZone) {
        this.calendar.setTimeZone(timeZone);
    }
    
    public void toStringZone(final StringBuffer sbuf) {
        if (this.isZoneUnspecified()) {
            return;
        }
        toStringZone(this.getZoneMinutes(), sbuf);
    }
    
    public static void toStringZone(int minutes, final StringBuffer sbuf) {
        if (minutes == 0) {
            sbuf.append('Z');
        }
        else {
            if (minutes < 0) {
                sbuf.append('-');
                minutes = -minutes;
            }
            else {
                sbuf.append('+');
            }
            append(minutes / 60, sbuf, 2);
            sbuf.append(':');
            append(minutes % 60, sbuf, 2);
        }
    }
    
    public void toString(final StringBuffer sbuf) {
        final int mask = this.components();
        final boolean hasDate = (mask & 0xE) != 0x0;
        final boolean hasTime = (mask & 0x70) != 0x0;
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
        final StringBuffer sbuf = new StringBuffer();
        this.toString(sbuf);
        return sbuf.toString();
    }
    
    @Override
    public boolean isExact() {
        return (this.mask & 0x70) == 0x0;
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
    
    static {
        minDate = new Date(Long.MIN_VALUE);
        DateTime.GMT = TimeZone.getTimeZone("GMT");
    }
}
