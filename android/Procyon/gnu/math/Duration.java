// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class Duration extends Quantity implements Externalizable
{
    public Unit unit;
    int months;
    long seconds;
    int nanos;
    
    public static Duration make(final int months, final long seconds, final int nanos, final Unit unit) {
        final Duration d = new Duration();
        d.months = months;
        d.seconds = seconds;
        d.nanos = nanos;
        d.unit = unit;
        return d;
    }
    
    public static Duration makeMonths(final int months) {
        final Duration d = new Duration();
        d.unit = Unit.month;
        d.months = months;
        return d;
    }
    
    public static Duration makeMinutes(final int minutes) {
        final Duration d = new Duration();
        d.unit = Unit.second;
        d.seconds = 60 * minutes;
        return d;
    }
    
    public static Duration parse(final String str, final Unit unit) {
        final Duration d = valueOf(str, unit);
        if (d == null) {
            throw new IllegalArgumentException("not a valid " + unit.getName() + " duration: '" + str + "'");
        }
        return d;
    }
    
    public static Duration parseDuration(final String str) {
        return parse(str, Unit.duration);
    }
    
    public static Duration parseYearMonthDuration(final String str) {
        return parse(str, Unit.month);
    }
    
    public static Duration parseDayTimeDuration(final String str) {
        return parse(str, Unit.second);
    }
    
    public static Duration valueOf(String str, final Unit unit) {
        str = str.trim();
        int pos = 0;
        final int len = str.length();
        boolean negative;
        if (pos < len && str.charAt(pos) == '-') {
            negative = true;
            ++pos;
        }
        else {
            negative = false;
        }
        if (pos + 1 >= len || str.charAt(pos) != 'P') {
            return null;
        }
        ++pos;
        int months = 0;
        int nanos = 0;
        long seconds = 0L;
        long part = scanPart(str, pos);
        pos = (int)part >> 16;
        char ch = (char)part;
        if (unit == Unit.second && (ch == 'Y' || ch == 'M')) {
            return null;
        }
        if (ch == 'Y') {
            months = 12 * (int)(part >> 32);
            pos = (int)part >> 16;
            part = scanPart(str, pos);
            ch = (char)part;
        }
        if (ch == 'M') {
            months += (int)(part >> 32);
            pos = (int)part >> 16;
            part = scanPart(str, pos);
            ch = (char)part;
        }
        if (unit == Unit.month && pos != len) {
            return null;
        }
        if (ch == 'D') {
            if (unit == Unit.month) {
                return null;
            }
            seconds = 86400L * (int)(part >> 32);
            pos = (int)part >> 16;
            part = scanPart(str, pos);
        }
        if (part != pos << 16) {
            return null;
        }
        if (pos != len) {
            if (str.charAt(pos) != 'T' || ++pos == len) {
                return null;
            }
            if (unit == Unit.month) {
                return null;
            }
            part = scanPart(str, pos);
            ch = (char)part;
            if (ch == 'H') {
                seconds += 3600 * (int)(part >> 32);
                pos = (int)part >> 16;
                part = scanPart(str, pos);
                ch = (char)part;
            }
            if (ch == 'M') {
                seconds += 60 * (int)(part >> 32);
                pos = (int)part >> 16;
                part = scanPart(str, pos);
                ch = (char)part;
            }
            if (ch == 'S' || ch == '.') {
                seconds += (int)(part >> 32);
                pos = (int)part >> 16;
            }
            if (ch == '.' && pos + 1 < len && Character.digit(str.charAt(pos), 10) >= 0) {
                int nfrac = 0;
                while (pos < len) {
                    ch = str.charAt(pos++);
                    final int dig = Character.digit(ch, 10);
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
                }
                while (nfrac++ < 9) {
                    nanos *= 10;
                }
                if (ch != 'S') {
                    return null;
                }
            }
        }
        if (pos != len) {
            return null;
        }
        final Duration d = new Duration();
        if (negative) {
            months = -months;
            seconds = -seconds;
            nanos = -nanos;
        }
        d.months = months;
        d.seconds = seconds;
        d.nanos = nanos;
        d.unit = unit;
        return d;
    }
    
    @Override
    public Numeric add(final Object y, final int k) {
        if (y instanceof Duration) {
            return add(this, (Duration)y, k);
        }
        if (y instanceof DateTime && k == 1) {
            return DateTime.add((DateTime)y, this, 1);
        }
        throw new IllegalArgumentException();
    }
    
    @Override
    public Numeric mul(final Object y) {
        if (y instanceof RealNum) {
            return times(this, ((RealNum)y).doubleValue());
        }
        return ((Numeric)y).mulReversed(this);
    }
    
    @Override
    public Numeric mulReversed(final Numeric x) {
        if (!(x instanceof RealNum)) {
            throw new IllegalArgumentException();
        }
        return times(this, ((RealNum)x).doubleValue());
    }
    
    public static double div(final Duration dur1, final Duration dur2) {
        final int months1 = dur1.months;
        final int months2 = dur2.months;
        final double sec1 = dur1.seconds + dur1.nanos * 1.0E-9;
        final double sec2 = dur2.seconds + dur1.nanos * 1.0E-9;
        if (months2 == 0 && sec2 == 0.0) {
            throw new ArithmeticException("divide duration by zero");
        }
        if (months2 == 0) {
            if (months1 == 0) {
                return sec1 / sec2;
            }
        }
        else if (sec2 == 0.0 && sec1 == 0.0) {
            return months1 / (double)months2;
        }
        throw new ArithmeticException("divide of incompatible durations");
    }
    
    @Override
    public Numeric div(final Object y) {
        if (y instanceof RealNum) {
            final double dy = ((RealNum)y).doubleValue();
            if (dy == 0.0 || Double.isNaN(dy)) {
                throw new ArithmeticException("divide of duration by 0 or NaN");
            }
            return times(this, 1.0 / dy);
        }
        else {
            if (y instanceof Duration) {
                return new DFloNum(div(this, (Duration)y));
            }
            return ((Numeric)y).divReversed(this);
        }
    }
    
    public static Duration add(final Duration x, final Duration y, final int k) {
        final long months = x.months + k * (long)y.months;
        final long nanos = x.seconds * 1000000000L + x.nanos + k * (y.seconds * 1000000000L + y.nanos);
        final Duration d = new Duration();
        d.months = (int)months;
        d.seconds = (int)(nanos / 1000000000L);
        d.nanos = (int)(nanos % 1000000000L);
        if (x.unit != y.unit || x.unit == Unit.duration) {
            throw new ArithmeticException("cannot add these duration types");
        }
        d.unit = x.unit;
        return d;
    }
    
    public static Duration times(final Duration x, final double y) {
        if (x.unit == Unit.duration) {
            throw new IllegalArgumentException("cannot multiply general duration");
        }
        final double months = x.months * y;
        if (Double.isInfinite(months) || Double.isNaN(months)) {
            throw new ArithmeticException("overflow/NaN when multiplying a duration");
        }
        final double nanos = (x.seconds * 1000000000L + x.nanos) * y;
        final Duration d = new Duration();
        d.months = (int)Math.floor(months + 0.5);
        d.seconds = (int)(nanos / 1.0E9);
        d.nanos = (int)(nanos % 1.0E9);
        d.unit = x.unit;
        return d;
    }
    
    public static int compare(final Duration x, final Duration y) {
        final long months = x.months - (long)y.months;
        final long nanos = x.seconds * 1000000000L + x.nanos - (y.seconds * 1000000000L + y.nanos);
        if (months < 0L && nanos <= 0L) {
            return -1;
        }
        if (months > 0L && nanos >= 0L) {
            return 1;
        }
        if (months == 0L) {
            return (nanos < 0L) ? -1 : ((nanos > 0L) ? 1 : 0);
        }
        return -2;
    }
    
    @Override
    public int compare(final Object obj) {
        if (obj instanceof Duration) {
            return compare(this, (Duration)obj);
        }
        throw new IllegalArgumentException();
    }
    
    @Override
    public String toString() {
        final StringBuffer sbuf = new StringBuffer();
        int m = this.months;
        long s = this.seconds;
        int n = this.nanos;
        final boolean neg = m < 0 || s < 0L || n < 0;
        if (neg) {
            m = -m;
            s = -s;
            n = -n;
            sbuf.append('-');
        }
        sbuf.append('P');
        final int y = m / 12;
        if (y != 0) {
            sbuf.append(y);
            sbuf.append('Y');
            m -= y * 12;
        }
        if (m != 0) {
            sbuf.append(m);
            sbuf.append('M');
        }
        final long d = s / 86400L;
        if (d != 0L) {
            sbuf.append(d);
            sbuf.append('D');
            s -= 86400L * d;
        }
        if (s != 0L || n != 0) {
            sbuf.append('T');
            final long hr = s / 3600L;
            if (hr != 0L) {
                sbuf.append(hr);
                sbuf.append('H');
                s -= 3600L * hr;
            }
            final long mn = s / 60L;
            if (mn != 0L) {
                sbuf.append(mn);
                sbuf.append('M');
                s -= 60L * mn;
            }
            if (s != 0L || n != 0) {
                sbuf.append(s);
                appendNanoSeconds(n, sbuf);
                sbuf.append('S');
            }
        }
        else if (sbuf.length() == 1) {
            sbuf.append((this.unit == Unit.month) ? "0M" : "T0S");
        }
        return sbuf.toString();
    }
    
    static void appendNanoSeconds(final int nanoSeconds, final StringBuffer sbuf) {
        if (nanoSeconds == 0) {
            return;
        }
        sbuf.append('.');
        final int pos = sbuf.length();
        sbuf.append(nanoSeconds);
        int len = sbuf.length();
        int pad = pos + 9 - len;
        while (--pad >= 0) {
            sbuf.insert(pos, '0');
        }
        len = pos + 9;
        do {
            --len;
        } while (sbuf.charAt(len) == '0');
        sbuf.setLength(len + 1);
    }
    
    private static long scanPart(final String str, final int start) {
        int i = start;
        long val = -1L;
        final int len = str.length();
        while (i < len) {
            final char ch = str.charAt(i);
            ++i;
            final int dig = Character.digit(ch, 10);
            if (dig < 0) {
                if (val < 0L) {
                    return start << 16;
                }
                return val << 32 | (long)(i << 16) | (long)ch;
            }
            else {
                val = ((val < 0L) ? dig : (10L * val + dig));
                if (val > 2147483647L) {
                    return -1L;
                }
                continue;
            }
        }
        return (val < 0L) ? (start << 16) : -1L;
    }
    
    public int getYears() {
        return this.months / 12;
    }
    
    public int getMonths() {
        return this.months % 12;
    }
    
    public int getDays() {
        return (int)(this.seconds / 86400L);
    }
    
    public int getHours() {
        return (int)(this.seconds / 3600L % 24L);
    }
    
    public int getMinutes() {
        return (int)(this.seconds / 60L % 60L);
    }
    
    public int getSecondsOnly() {
        return (int)(this.seconds % 60L);
    }
    
    public int getNanoSecondsOnly() {
        return this.nanos;
    }
    
    public int getTotalMonths() {
        return this.months;
    }
    
    public long getTotalSeconds() {
        return this.seconds;
    }
    
    public long getTotalMinutes() {
        return this.seconds / 60L;
    }
    
    public long getNanoSeconds() {
        return this.seconds * 1000000000L + this.nanos;
    }
    
    @Override
    public boolean isZero() {
        return this.months == 0 && this.seconds == 0L && this.nanos == 0;
    }
    
    @Override
    public boolean isExact() {
        return false;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeInt(this.months);
        out.writeLong(this.seconds);
        out.writeInt(this.nanos);
        out.writeObject(this.unit);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.months = in.readInt();
        this.seconds = in.readLong();
        this.nanos = in.readInt();
        this.unit = (Unit)in.readObject();
    }
    
    @Override
    public Unit unit() {
        return this.unit;
    }
    
    @Override
    public Complex number() {
        throw new UnsupportedOperationException("number needs to be implemented!");
    }
    
    @Override
    public int hashCode() {
        return this.months ^ (int)this.seconds ^ this.nanos;
    }
    
    public static boolean equals(final Duration x, final Duration y) {
        return x.months == y.months && x.seconds == y.seconds && x.nanos == y.nanos;
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj != null && obj instanceof Duration && equals(this, (Duration)obj);
    }
}
