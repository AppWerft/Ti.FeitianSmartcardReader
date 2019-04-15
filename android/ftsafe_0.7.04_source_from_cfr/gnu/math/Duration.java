/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.BaseUnit;
import gnu.math.Complex;
import gnu.math.DFloNum;
import gnu.math.DateTime;
import gnu.math.NamedUnit;
import gnu.math.Numeric;
import gnu.math.Quantity;
import gnu.math.Quaternion;
import gnu.math.RealNum;
import gnu.math.Unit;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Duration
extends Quantity
implements Externalizable {
    public Unit unit;
    int months;
    long seconds;
    int nanos;

    public static Duration make(int months, long seconds, int nanos, Unit unit) {
        Duration d = new Duration();
        d.months = months;
        d.seconds = seconds;
        d.nanos = nanos;
        d.unit = unit;
        return d;
    }

    public static Duration makeMonths(int months) {
        Duration d = new Duration();
        d.unit = Unit.month;
        d.months = months;
        return d;
    }

    public static Duration makeMinutes(int minutes) {
        Duration d = new Duration();
        d.unit = Unit.second;
        d.seconds = 60 * minutes;
        return d;
    }

    public static Duration parse(String str, Unit unit) {
        Duration d = Duration.valueOf(str, unit);
        if (d == null) {
            throw new IllegalArgumentException("not a valid " + unit.getName() + " duration: '" + str + "'");
        }
        return d;
    }

    public static Duration parseDuration(String str) {
        return Duration.parse(str, Unit.duration);
    }

    public static Duration parseYearMonthDuration(String str) {
        return Duration.parse(str, Unit.month);
    }

    public static Duration parseDayTimeDuration(String str) {
        return Duration.parse(str, Unit.second);
    }

    public static Duration valueOf(String str, Unit unit) {
        boolean negative;
        int pos = 0;
        int len = (str = str.trim()).length();
        if (pos < len && str.charAt(pos) == '-') {
            negative = true;
            ++pos;
        } else {
            negative = false;
        }
        if (pos + 1 >= len || str.charAt(pos) != 'P') {
            return null;
        }
        int months = 0;
        int nanos = 0;
        long seconds = 0L;
        long part = Duration.scanPart(str, ++pos);
        pos = (int)part >> 16;
        char ch = (char)part;
        if (unit == Unit.second && (ch == 'Y' || ch == 'M')) {
            return null;
        }
        if (ch == 'Y') {
            months = 12 * (int)(part >> 32);
            pos = (int)part >> 16;
            part = Duration.scanPart(str, pos);
            ch = (char)part;
        }
        if (ch == 'M') {
            months = (int)((long)months + (part >> 32));
            pos = (int)part >> 16;
            part = Duration.scanPart(str, pos);
            ch = (char)part;
        }
        if (unit == Unit.month && pos != len) {
            return null;
        }
        if (ch == 'D') {
            if (unit == Unit.month) {
                return null;
            }
            seconds = 86400L * (long)((int)(part >> 32));
            pos = (int)part >> 16;
            part = Duration.scanPart(str, pos);
        }
        if (part != (long)(pos << 16)) {
            return null;
        }
        if (pos != len) {
            if (str.charAt(pos) != 'T' || ++pos == len) {
                return null;
            }
            if (unit == Unit.month) {
                return null;
            }
            part = Duration.scanPart(str, pos);
            ch = (char)part;
            if (ch == 'H') {
                seconds += (long)(3600 * (int)(part >> 32));
                pos = (int)part >> 16;
                part = Duration.scanPart(str, pos);
                ch = (char)part;
            }
            if (ch == 'M') {
                seconds += (long)(60 * (int)(part >> 32));
                pos = (int)part >> 16;
                part = Duration.scanPart(str, pos);
                ch = (char)part;
            }
            if (ch == 'S' || ch == '.') {
                seconds += (long)((int)(part >> 32));
                pos = (int)part >> 16;
            }
            if (ch == '.' && pos + 1 < len && Character.digit(str.charAt(pos), 10) >= 0) {
                int dig;
                int nfrac = 0;
                while (pos < len && (dig = Character.digit(ch = str.charAt(pos++), 10)) >= 0) {
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
                if (ch != 'S') {
                    return null;
                }
            }
        }
        if (pos != len) {
            return null;
        }
        Duration d = new Duration();
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
    public Numeric add(Object y, int k) {
        if (y instanceof Duration) {
            return Duration.add(this, (Duration)y, k);
        }
        if (y instanceof DateTime && k == 1) {
            return DateTime.add((DateTime)y, this, 1);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Numeric mul(Object y) {
        if (y instanceof RealNum) {
            return Duration.times(this, ((RealNum)y).doubleValue());
        }
        return ((Numeric)y).mulReversed(this);
    }

    @Override
    public Numeric mulReversed(Numeric x) {
        if (!(x instanceof RealNum)) {
            throw new IllegalArgumentException();
        }
        return Duration.times(this, ((RealNum)x).doubleValue());
    }

    public static double div(Duration dur1, Duration dur2) {
        int months1 = dur1.months;
        int months2 = dur2.months;
        double sec1 = (double)dur1.seconds + (double)dur1.nanos * 1.0E-9;
        double sec2 = (double)dur2.seconds + (double)dur1.nanos * 1.0E-9;
        if (months2 == 0 && sec2 == 0.0) {
            throw new ArithmeticException("divide duration by zero");
        }
        if (months2 == 0) {
            if (months1 == 0) {
                return sec1 / sec2;
            }
        } else if (sec2 == 0.0 && sec1 == 0.0) {
            return (double)months1 / (double)months2;
        }
        throw new ArithmeticException("divide of incompatible durations");
    }

    @Override
    public Numeric div(Object y) {
        if (y instanceof RealNum) {
            double dy = ((RealNum)y).doubleValue();
            if (dy == 0.0 || Double.isNaN(dy)) {
                throw new ArithmeticException("divide of duration by 0 or NaN");
            }
            return Duration.times(this, 1.0 / dy);
        }
        if (y instanceof Duration) {
            return new DFloNum(Duration.div(this, (Duration)y));
        }
        return ((Numeric)y).divReversed(this);
    }

    public static Duration add(Duration x, Duration y, int k) {
        long months = (long)x.months + (long)k * (long)y.months;
        long nanos = x.seconds * 1000000000L + (long)x.nanos + (long)k * (y.seconds * 1000000000L + (long)y.nanos);
        Duration d = new Duration();
        d.months = (int)months;
        d.seconds = (int)(nanos / 1000000000L);
        d.nanos = (int)(nanos % 1000000000L);
        if (x.unit != y.unit || x.unit == Unit.duration) {
            throw new ArithmeticException("cannot add these duration types");
        }
        d.unit = x.unit;
        return d;
    }

    public static Duration times(Duration x, double y) {
        if (x.unit == Unit.duration) {
            throw new IllegalArgumentException("cannot multiply general duration");
        }
        double months = (double)x.months * y;
        if (Double.isInfinite(months) || Double.isNaN(months)) {
            throw new ArithmeticException("overflow/NaN when multiplying a duration");
        }
        double nanos = (double)(x.seconds * 1000000000L + (long)x.nanos) * y;
        Duration d = new Duration();
        d.months = (int)Math.floor(months + 0.5);
        d.seconds = (int)(nanos / 1.0E9);
        d.nanos = (int)(nanos % 1.0E9);
        d.unit = x.unit;
        return d;
    }

    public static int compare(Duration x, Duration y) {
        long months = (long)x.months - (long)y.months;
        long nanos = x.seconds * 1000000000L + (long)x.nanos - (y.seconds * 1000000000L + (long)y.nanos);
        if (months < 0L && nanos <= 0L) {
            return -1;
        }
        if (months > 0L && nanos >= 0L) {
            return 1;
        }
        if (months == 0L) {
            return nanos < 0L ? -1 : (nanos > 0L ? 1 : 0);
        }
        return -2;
    }

    @Override
    public int compare(Object obj) {
        if (obj instanceof Duration) {
            return Duration.compare(this, (Duration)obj);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        long d;
        boolean neg;
        StringBuffer sbuf = new StringBuffer();
        int m = this.months;
        long s = this.seconds;
        int n = this.nanos;
        boolean bl = neg = m < 0 || s < 0L || n < 0;
        if (neg) {
            m = -m;
            s = -s;
            n = -n;
            sbuf.append('-');
        }
        sbuf.append('P');
        int y = m / 12;
        if (y != 0) {
            sbuf.append(y);
            sbuf.append('Y');
            m -= y * 12;
        }
        if (m != 0) {
            sbuf.append(m);
            sbuf.append('M');
        }
        if ((d = s / 86400L) != 0L) {
            sbuf.append(d);
            sbuf.append('D');
            s -= 86400L * d;
        }
        if (s != 0L || n != 0) {
            long mn;
            sbuf.append('T');
            long hr = s / 3600L;
            if (hr != 0L) {
                sbuf.append(hr);
                sbuf.append('H');
                s -= 3600L * hr;
            }
            if ((mn = s / 60L) != 0L) {
                sbuf.append(mn);
                sbuf.append('M');
                s -= 60L * mn;
            }
            if (s != 0L || n != 0) {
                sbuf.append(s);
                Duration.appendNanoSeconds(n, sbuf);
                sbuf.append('S');
            }
        } else if (sbuf.length() == 1) {
            sbuf.append(this.unit == Unit.month ? "0M" : "T0S");
        }
        return sbuf.toString();
    }

    static void appendNanoSeconds(int nanoSeconds, StringBuffer sbuf) {
        if (nanoSeconds == 0) {
            return;
        }
        sbuf.append('.');
        int pos = sbuf.length();
        sbuf.append(nanoSeconds);
        int len = sbuf.length();
        int pad = pos + 9 - len;
        while (--pad >= 0) {
            sbuf.insert(pos, '0');
        }
        len = pos + 9;
        while (sbuf.charAt(--len) == '0') {
        }
        sbuf.setLength(len + 1);
    }

    private static long scanPart(String str, int start) {
        long val = -1L;
        int len = str.length();
        for (int i = start; i < len; ++i) {
            char ch = str.charAt(i);
            int dig = Character.digit(ch, 10);
            if (dig >= 0) continue;
            if (val < 0L) {
                return start << 16;
            }
            return val << 32 | (long)(i << 16) | (long)ch;
        }
        return val < 0L ? (long)(start << 16) : -1L;
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
        return this.seconds * 1000000000L + (long)this.nanos;
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
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.months);
        out.writeLong(this.seconds);
        out.writeInt(this.nanos);
        out.writeObject(this.unit);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
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

    public int hashCode() {
        return this.months ^ (int)this.seconds ^ this.nanos;
    }

    public static boolean equals(Duration x, Duration y) {
        return x.months == y.months && x.seconds == y.seconds && x.nanos == y.nanos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Duration)) {
            return false;
        }
        return Duration.equals(this, (Duration)obj);
    }
}

