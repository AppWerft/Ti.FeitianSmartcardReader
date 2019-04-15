/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.MPN;
import gnu.math.Numeric;
import gnu.math.RatNum;
import gnu.math.RealNum;
import gnu.math.UnsignedPrim;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class IntNum
extends RatNum
implements Externalizable {
    public int ival;
    public int[] words;
    static final int minFixNum = -100;
    static final int maxFixNum = 1024;
    static final int numFixNum = 1125;
    static final IntNum[] smallFixNums = new IntNum[1125];

    public IntNum() {
    }

    public IntNum(int value) {
        this.ival = value;
    }

    public static final IntNum zero() {
        return smallFixNums[100];
    }

    public static final IntNum one() {
        return smallFixNums[101];
    }

    public static final IntNum ten() {
        return smallFixNums[110];
    }

    public static IntNum minusOne() {
        return smallFixNums[99];
    }

    public static IntNum asIntNumOrNull(Object value) {
        if (value instanceof IntNum) {
            return (IntNum)value;
        }
        if (value instanceof UnsignedPrim) {
            return ((UnsignedPrim)value).toIntNum();
        }
        if (value instanceof BigInteger) {
            return IntNum.valueOf(value.toString(), 10);
        }
        if (value instanceof Number && (value instanceof Integer || value instanceof Long || value instanceof Short || value instanceof Byte)) {
            return IntNum.make(((Number)value).longValue());
        }
        return null;
    }

    public static IntNum alloc(int nwords) {
        if (nwords <= 1) {
            return new IntNum();
        }
        IntNum result = new IntNum();
        result.words = new int[nwords];
        return result;
    }

    public void realloc(int nwords) {
        if (nwords == 0) {
            if (this.words != null) {
                if (this.ival > 0) {
                    this.ival = this.words[0];
                }
                this.words = null;
            }
        } else if (this.words == null || this.words.length < nwords || this.words.length > nwords + 2) {
            int[] new_words = new int[nwords];
            if (this.words == null) {
                new_words[0] = this.ival;
                this.ival = 1;
            } else {
                if (nwords < this.ival) {
                    this.ival = nwords;
                }
                System.arraycopy(this.words, 0, new_words, 0, this.ival);
            }
            this.words = new_words;
        }
    }

    @Override
    public final IntNum numerator() {
        return this;
    }

    @Override
    public final IntNum denominator() {
        return IntNum.one();
    }

    @Override
    public final boolean isNegative() {
        return (this.words == null ? this.ival : this.words[this.ival - 1]) < 0;
    }

    @Override
    public int sign() {
        int i;
        int n = this.ival;
        int[] w = this.words;
        if (w == null) {
            return n > 0 ? 1 : (n < 0 ? -1 : 0);
        }
        if ((i = w[--n]) > 0) {
            return 1;
        }
        if (i < 0) {
            return -1;
        }
        do {
            if (n != 0) continue;
            return 0;
        } while (w[--n] == 0);
        return 1;
    }

    public static int compare(IntNum x, IntNum y) {
        int y_len;
        boolean y_negative;
        if (x.words == null && y.words == null) {
            return x.ival < y.ival ? -1 : (x.ival > y.ival ? 1 : 0);
        }
        boolean x_negative = x.isNegative();
        if (x_negative != (y_negative = y.isNegative())) {
            return x_negative ? -1 : 1;
        }
        int x_len = x.words == null ? 1 : x.ival;
        int n = y_len = y.words == null ? 1 : y.ival;
        if (x_len != y_len) {
            return x_len > y_len != x_negative ? 1 : -1;
        }
        return MPN.cmp(x.words, y.words, x_len);
    }

    public static int compare(IntNum x, long y) {
        long x_word;
        if (x.words == null) {
            x_word = x.ival;
        } else {
            boolean y_negative;
            int x_len;
            boolean x_negative = x.isNegative();
            boolean bl = y_negative = y < 0L;
            if (x_negative != y_negative) {
                return x_negative ? -1 : 1;
            }
            int n = x_len = x.words == null ? 1 : x.ival;
            if (x_len == 1) {
                x_word = x.words[0];
            } else if (x_len == 2) {
                x_word = x.longValue();
            } else {
                return x_negative ? -1 : 1;
            }
        }
        return x_word < y ? -1 : (x_word > y ? 1 : 0);
    }

    @Override
    public int compare(Object obj) {
        if (obj instanceof IntNum) {
            return IntNum.compare(this, (IntNum)obj);
        }
        return ((Numeric)obj).compareReversed(this);
    }

    public final boolean isOdd() {
        int low = this.words == null ? this.ival : this.words[0];
        return (low & 1) != 0;
    }

    @Override
    public final boolean isZero() {
        return this.words == null && this.ival == 0;
    }

    public final boolean isOne() {
        return this.words == null && this.ival == 1;
    }

    public final boolean isMinusOne() {
        return this.words == null && this.ival == -1;
    }

    public static int wordsNeeded(int[] words, int len) {
        int i;
        block4 : {
            int word;
            i = len;
            if (i <= 0) break block4;
            if ((word = words[--i]) == -1) {
                while (i > 0 && (word = words[i - 1]) < 0) {
                    --i;
                    if (word == -1) continue;
                    break;
                }
            } else {
                while (word == 0 && i > 0 && (word = words[i - 1]) >= 0) {
                    --i;
                }
            }
        }
        return i + 1;
    }

    public IntNum canonicalize() {
        if (this.words != null && (this.ival = IntNum.wordsNeeded(this.words, this.ival)) <= 1) {
            if (this.ival == 1) {
                this.ival = this.words[0];
            }
            this.words = null;
        }
        if (this.words == null && this.ival >= -100 && this.ival <= 1024) {
            return smallFixNums[this.ival - -100];
        }
        return this;
    }

    public static final IntNum add(int x, int y) {
        return IntNum.make((long)x + (long)y);
    }

    public static IntNum add(IntNum x, int y) {
        if (x.words == null) {
            return IntNum.add(x.ival, y);
        }
        IntNum result = new IntNum(0);
        result.setAdd(x, y);
        return result.canonicalize();
    }

    public void setAdd(IntNum x, int y) {
        if (x.words == null) {
            this.set((long)x.ival + (long)y);
            return;
        }
        int len = x.ival;
        this.realloc(len + 1);
        long carry = y;
        for (int i = 0; i < len; ++i) {
            this.words[i] = (int)(carry += (long)x.words[i] & 0xFFFFFFFFL);
            carry >>= 32;
        }
        if (x.words[len - 1] < 0) {
            --carry;
        }
        this.words[len] = (int)carry;
        this.ival = IntNum.wordsNeeded(this.words, len + 1);
    }

    public final void setAdd(int y) {
        this.setAdd(this, y);
    }

    public final void set(int y) {
        this.words = null;
        this.ival = y;
    }

    public final void set(long y) {
        int i = (int)y;
        if ((long)i == y) {
            this.ival = i;
            this.words = null;
        } else {
            this.realloc(2);
            this.words[0] = i;
            this.words[1] = (int)(y >> 32);
            this.ival = 2;
        }
    }

    public final void set(int[] words, int length) {
        this.ival = length;
        this.words = words;
    }

    public final void set(IntNum y) {
        if (y.words == null) {
            this.set(y.ival);
        } else if (this != y) {
            this.realloc(y.ival);
            System.arraycopy(y.words, 0, this.words, 0, y.ival);
            this.ival = y.ival;
        }
    }

    public static IntNum add(IntNum x, IntNum y) {
        return IntNum.add(x, y, 1);
    }

    public static IntNum sub(IntNum x, IntNum y) {
        return IntNum.add(x, y, -1);
    }

    public static IntNum add(IntNum x, IntNum y, int k) {
        long y_ext;
        int i;
        if (y.words == null) {
            int yval = y.ival;
            if (yval == 0) {
                return x;
            }
            if (x.words == null) {
                return IntNum.make((long)k * (long)yval + (long)x.ival);
            }
        }
        if (k != 1) {
            y = k == -1 ? IntNum.neg(y) : IntNum.times(y, IntNum.make(k));
        }
        if (x.words == null) {
            return IntNum.add(y, x.ival);
        }
        if (y.words == null) {
            return IntNum.add(x, y.ival);
        }
        if (y.ival > x.ival) {
            IntNum tmp = x;
            x = y;
            y = tmp;
        }
        IntNum result = IntNum.alloc(x.ival + 1);
        long carry = MPN.add_n(result.words, x.words, y.words, i);
        long l = y_ext = y.words[i - 1] < 0 ? 0xFFFFFFFFL : 0L;
        for (i = y.ival; i < x.ival; ++i) {
            result.words[i] = (int)(carry += ((long)x.words[i] & 0xFFFFFFFFL) + y_ext);
            carry >>>= 32;
        }
        if (x.words[i - 1] < 0) {
            --y_ext;
        }
        result.words[i] = (int)(carry + y_ext);
        result.ival = i + 1;
        return result.canonicalize();
    }

    public static final IntNum times(int x, int y) {
        return IntNum.make((long)x * (long)y);
    }

    public static final IntNum times(IntNum x, int y) {
        boolean negative;
        if (y == 0) {
            return IntNum.zero();
        }
        if (y == 1) {
            return x;
        }
        int[] xwords = x.words;
        int xlen = x.ival;
        if (xwords == null) {
            return IntNum.make((long)xlen * (long)y);
        }
        IntNum result = IntNum.alloc(xlen + 1);
        if (xwords[xlen - 1] < 0) {
            negative = true;
            IntNum.negate(result.words, xwords, xlen);
            xwords = result.words;
        } else {
            negative = false;
        }
        if (y < 0) {
            negative = !negative;
            y = -y;
        }
        result.words[xlen] = MPN.mul_1(result.words, xwords, xlen, y);
        result.ival = xlen + 1;
        if (negative) {
            result.setNegative();
        }
        return result.canonicalize();
    }

    public static final IntNum times(IntNum x, IntNum y) {
        int[] ywords;
        int[] xwords;
        if (y.words == null) {
            return IntNum.times(x, y.ival);
        }
        if (x.words == null) {
            return IntNum.times(y, x.ival);
        }
        boolean negative = false;
        int xlen = x.ival;
        int ylen = y.ival;
        if (x.isNegative()) {
            negative = true;
            xwords = new int[xlen];
            IntNum.negate(xwords, x.words, xlen);
        } else {
            negative = false;
            xwords = x.words;
        }
        if (y.isNegative()) {
            negative = !negative;
            ywords = new int[ylen];
            IntNum.negate(ywords, y.words, ylen);
        } else {
            ywords = y.words;
        }
        if (xlen < ylen) {
            int[] twords = xwords;
            xwords = ywords;
            ywords = twords;
            int tlen = xlen;
            xlen = ylen;
            ylen = tlen;
        }
        IntNum result = IntNum.alloc(xlen + ylen);
        MPN.mul(result.words, xwords, xlen, ywords, ylen);
        result.ival = xlen + ylen;
        if (negative) {
            result.setNegative();
        }
        return result.canonicalize();
    }

    public static void divide(long x, long y, IntNum quotient, IntNum remainder, int rounding_mode) {
        boolean xNegative;
        boolean yNegative;
        if (rounding_mode == 5) {
            int n = rounding_mode = y < 0L ? 2 : 1;
        }
        if (x < 0L) {
            xNegative = true;
            if (x == Long.MIN_VALUE) {
                IntNum.divide(IntNum.make(x), IntNum.make(y), quotient, remainder, rounding_mode);
                return;
            }
            x = -x;
        } else {
            xNegative = false;
        }
        if (y < 0L) {
            yNegative = true;
            if (y == Long.MIN_VALUE) {
                if (rounding_mode == 3) {
                    if (quotient != null) {
                        quotient.set(0);
                    }
                    if (remainder != null) {
                        remainder.set(x);
                    }
                } else {
                    IntNum.divide(IntNum.make(x), IntNum.make(y), quotient, remainder, rounding_mode);
                }
                return;
            }
            y = -y;
        } else {
            yNegative = false;
        }
        long q = x / y;
        long r = x % y;
        boolean qNegative = xNegative ^ yNegative;
        boolean add_one = false;
        if (r != 0L) {
            switch (rounding_mode) {
                case 3: {
                    break;
                }
                case 1: 
                case 2: {
                    if (qNegative != (rounding_mode == 1)) break;
                    add_one = true;
                    break;
                }
                case 4: {
                    add_one = r > y - (q & 1L) >> 1;
                }
            }
        }
        if (quotient != null) {
            if (add_one) {
                ++q;
            }
            if (qNegative) {
                q = -q;
            }
            quotient.set(q);
        }
        if (remainder != null) {
            if (add_one) {
                r = y - r;
                boolean bl = xNegative = !xNegative;
            }
            if (xNegative) {
                r = -r;
            }
            remainder.set(r);
        }
    }

    public static void divide(IntNum x, IntNum y, IntNum quotient, IntNum remainder, int rounding_mode) {
        int rlen;
        int ylen;
        int xlen;
        int qlen;
        if (!(x.words != null && x.ival > 2 || y.words != null && y.ival > 2)) {
            long x_l = x.longValue();
            long y_l = y.longValue();
            if (x_l != Long.MIN_VALUE && y_l != Long.MIN_VALUE) {
                IntNum.divide(x_l, y_l, quotient, remainder, rounding_mode);
                return;
            }
        }
        boolean xNegative = x.isNegative();
        boolean yNegative = y.isNegative();
        boolean qNegative = xNegative ^ yNegative;
        int[] ywords = new int[ylen];
        y.getAbsolute(ywords);
        for (ylen = y.words == null ? 1 : y.ival; ylen > 1 && ywords[ylen - 1] == 0; --ylen) {
        }
        int[] xwords = new int[xlen + 2];
        x.getAbsolute(xwords);
        for (xlen = x.words == null ? 1 : x.ival; xlen > 1 && xwords[xlen - 1] == 0; --xlen) {
        }
        int cmpval = MPN.cmp(xwords, xlen, ywords, ylen);
        if (cmpval < 0) {
            int[] rwords = xwords;
            xwords = ywords;
            ywords = rwords;
            rlen = xlen;
            qlen = 1;
            xwords[0] = 0;
        } else if (cmpval == 0) {
            xwords[0] = 1;
            qlen = 1;
            ywords[0] = 0;
            rlen = 1;
        } else if (ylen == 1) {
            qlen = xlen;
            rlen = 1;
            ywords[0] = MPN.divmod_1(xwords, xwords, xlen, ywords[0]);
        } else {
            int nshift = MPN.count_leading_zeros(ywords[ylen - 1]);
            if (nshift != 0) {
                MPN.lshift(ywords, 0, ywords, ylen, nshift);
                int x_high = MPN.lshift(xwords, 0, xwords, xlen, nshift);
                xwords[xlen++] = x_high;
            }
            if (xlen == ylen) {
                xwords[xlen++] = 0;
            }
            MPN.divide(xwords, xlen, ywords, ylen);
            rlen = ylen;
            MPN.rshift0(ywords, xwords, 0, rlen, nshift);
            qlen = xlen + 1 - ylen;
            if (quotient != null) {
                for (int i = 0; i < qlen; ++i) {
                    xwords[i] = xwords[i + ylen];
                }
            }
        }
        while (rlen > 1 && ywords[rlen - 1] == 0) {
            --rlen;
        }
        if (ywords[rlen - 1] < 0) {
            ywords[rlen] = 0;
            ++rlen;
        }
        boolean add_one = false;
        if (rlen > 1 || ywords[0] != 0) {
            if (rounding_mode == 5) {
                rounding_mode = yNegative ? 2 : 1;
            }
            switch (rounding_mode) {
                case 3: {
                    break;
                }
                case 1: 
                case 2: {
                    if (qNegative != (rounding_mode == 1)) break;
                    add_one = true;
                    break;
                }
                case 4: {
                    IntNum tmp = remainder == null ? new IntNum() : remainder;
                    tmp.set(ywords, rlen);
                    tmp = IntNum.shift(tmp, 1);
                    if (yNegative) {
                        tmp.setNegative();
                    }
                    int cmp = IntNum.compare(tmp, y);
                    if (yNegative) {
                        cmp = -cmp;
                    }
                    add_one = cmp == 1 || cmp == 0 && (xwords[0] & 1) != 0;
                }
            }
        }
        if (quotient != null) {
            if (xwords[qlen - 1] < 0) {
                xwords[qlen] = 0;
                ++qlen;
            }
            quotient.set(xwords, qlen);
            if (qNegative) {
                if (add_one) {
                    quotient.setInvert();
                } else {
                    quotient.setNegative();
                }
            } else if (add_one) {
                quotient.setAdd(1);
            }
        }
        if (remainder != null) {
            remainder.set(ywords, rlen);
            if (add_one) {
                IntNum tmp;
                if (y.words == null) {
                    tmp = remainder;
                    tmp.set(yNegative ? ywords[0] + y.ival : ywords[0] - y.ival);
                } else {
                    tmp = IntNum.add(remainder, y, yNegative ? 1 : -1);
                }
                if (xNegative) {
                    remainder.setNegative(tmp);
                } else {
                    remainder.set(tmp);
                }
            } else if (xNegative) {
                remainder.setNegative();
            }
        }
    }

    public static IntNum quotient(IntNum x, IntNum y, int rounding_mode) {
        IntNum quotient = new IntNum();
        IntNum.divide(x, y, quotient, null, rounding_mode);
        return quotient.canonicalize();
    }

    public static IntNum quotient(IntNum x, IntNum y) {
        return IntNum.quotient(x, y, 3);
    }

    @Override
    public IntNum toExactInt(int rounding_mode) {
        return this;
    }

    @Override
    public RealNum toInt(int rounding_mode) {
        return this;
    }

    public static IntNum remainder(IntNum x, IntNum y, int rounding_mode) {
        if (y.isZero()) {
            return x;
        }
        IntNum rem = new IntNum();
        IntNum.divide(x, y, null, rem, rounding_mode);
        return rem.canonicalize();
    }

    public static IntNum remainder(IntNum x, IntNum y) {
        return IntNum.remainder(x, y, 3);
    }

    public static IntNum modulo(IntNum x, IntNum y) {
        return IntNum.remainder(x, y, 1);
    }

    @Override
    public Numeric power(IntNum y) {
        if (this.isOne()) {
            return this;
        }
        if (this.isMinusOne()) {
            return y.isOdd() ? this : IntNum.one();
        }
        if (y.words == null && y.ival >= 0) {
            return IntNum.power(this, y.ival);
        }
        if (this.isZero()) {
            return y.isNegative() ? RatNum.infinity(-1) : this;
        }
        return super.power(y);
    }

    public static IntNum power(IntNum x, int y) {
        if (y <= 0) {
            if (y == 0) {
                return IntNum.one();
            }
            throw new IllegalArgumentException("negative exponent");
        }
        if (x.isZero()) {
            return x;
        }
        int plen = x.words == null ? 1 : x.ival;
        int blen = (x.intLength() * y >> 5) + 2 * plen;
        boolean negative = x.isNegative() && (y & 1) != 0;
        int[] pow2 = new int[blen];
        int[] rwords = new int[blen];
        int[] work = new int[blen];
        x.getAbsolute(pow2);
        int rlen = 1;
        rwords[0] = 1;
        block0 : do {
            int[] temp;
            if ((y & 1) != 0) {
                MPN.mul(work, pow2, plen, rwords, rlen);
                temp = work;
                work = rwords;
                rwords = temp;
                rlen += plen;
                while (rwords[rlen - 1] == 0) {
                    --rlen;
                }
            }
            if ((y >>= 1) == 0) break;
            MPN.mul(work, pow2, plen, pow2, plen);
            temp = work;
            work = pow2;
            pow2 = temp;
            plen *= 2;
            do {
                if (pow2[plen - 1] != 0) continue block0;
                --plen;
            } while (true);
            break;
        } while (true);
        if (rwords[rlen - 1] < 0) {
            ++rlen;
        }
        if (negative) {
            IntNum.negate(rwords, rwords, rlen);
        }
        return IntNum.make(rwords, rlen);
    }

    public static final int gcd(int a, int b) {
        int tmp;
        if (b > a) {
            tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            if (b == 1) {
                return b;
            }
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public static IntNum gcd(IntNum x, IntNum y) {
        int xval = x.ival;
        int yval = y.ival;
        if (x.words == null) {
            if (xval == 0) {
                return IntNum.abs(y);
            }
            if (y.words == null && xval != Integer.MIN_VALUE && yval != Integer.MIN_VALUE) {
                if (xval < 0) {
                    xval = -xval;
                }
                if (yval < 0) {
                    yval = -yval;
                }
                return IntNum.make(IntNum.gcd(xval, yval));
            }
            xval = 1;
        }
        if (y.words == null) {
            if (yval == 0) {
                return IntNum.abs(x);
            }
            yval = 1;
        }
        int len = xval > yval ? xval : yval;
        int[] xwords = new int[len];
        int[] ywords = new int[len];
        x.getAbsolute(xwords);
        y.getAbsolute(ywords);
        len = MPN.gcd(xwords, ywords, len);
        IntNum result = new IntNum(0);
        if (xwords[len - 1] < 0) {
            xwords[len++] = 0;
        }
        result.ival = len;
        result.words = xwords;
        return result.canonicalize();
    }

    public static IntNum lcm(IntNum x, IntNum y) {
        if (x.isZero() || y.isZero()) {
            return IntNum.zero();
        }
        x = IntNum.abs(x);
        y = IntNum.abs(y);
        IntNum quotient = new IntNum();
        IntNum.divide(IntNum.times(x, y), IntNum.gcd(x, y), quotient, null, 3);
        return quotient.canonicalize();
    }

    void setInvert() {
        if (this.words == null) {
            this.ival ^= -1;
        } else {
            int i = this.ival;
            while (--i >= 0) {
                this.words[i] = ~this.words[i];
            }
        }
    }

    void setShiftLeft(IntNum x, int count) {
        int[] xwords;
        int xlen;
        int i;
        if (x.words == null) {
            if (count < 32) {
                this.set((long)x.ival << count);
                return;
            }
            xwords = new int[]{x.ival};
            xlen = 1;
        } else {
            xwords = x.words;
            xlen = x.ival;
        }
        int word_count = count >> 5;
        int new_len = xlen + word_count;
        if ((count &= 31) == 0) {
            this.realloc(new_len);
            i = xlen;
            while (--i >= 0) {
                this.words[i + word_count] = xwords[i];
            }
        } else {
            this.realloc(++new_len);
            int shift_out = MPN.lshift(this.words, word_count, xwords, xlen, count);
            count = 32 - count;
            this.words[new_len - 1] = shift_out << count >> count;
        }
        this.ival = new_len;
        i = word_count;
        while (--i >= 0) {
            this.words[i] = 0;
        }
    }

    void setShiftRight(IntNum x, int count) {
        if (x.words == null) {
            this.set(count < 32 ? x.ival >> count : (x.ival < 0 ? -1 : 0));
        } else if (count == 0) {
            this.set(x);
        } else {
            boolean neg = x.isNegative();
            int word_count = count >> 5;
            count &= 31;
            int d_len = x.ival - word_count;
            if (d_len <= 0) {
                this.set(neg ? -1 : 0);
            } else {
                if (this.words == null || this.words.length < d_len) {
                    this.realloc(d_len);
                }
                MPN.rshift0(this.words, x.words, word_count, d_len, count);
                this.ival = d_len;
                if (neg) {
                    int[] arrn = this.words;
                    int n = d_len - 1;
                    arrn[n] = arrn[n] | -2 << 31 - count;
                }
            }
        }
    }

    void setShift(IntNum x, int count) {
        if (count > 0) {
            this.setShiftLeft(x, count);
        } else {
            this.setShiftRight(x, -count);
        }
    }

    public static IntNum shift(IntNum x, int count) {
        if (x.words == null) {
            if (count <= 0) {
                return IntNum.make(count > -32 ? x.ival >> -count : (x.ival < 0 ? -1 : 0));
            }
            if (count < 32) {
                return IntNum.make((long)x.ival << count);
            }
        }
        if (count == 0) {
            return x;
        }
        IntNum result = new IntNum(0);
        result.setShift(x, count);
        return result.canonicalize();
    }

    public void format(int radix, StringBuffer buffer) {
        if (radix == 10) {
            if (this.words == null) {
                buffer.append(this.ival);
                return;
            }
            if (this.ival <= 2) {
                buffer.append(this.longValue());
                return;
            }
        }
        buffer.append(this.toString(radix));
    }

    public void format(int radix, StringBuilder buffer) {
        if (this.words == null) {
            if (radix == 10) {
                buffer.append(this.ival);
            } else {
                buffer.append(Integer.toString(this.ival, radix));
            }
        } else if (this.ival <= 2) {
            long lval = this.longValue();
            if (radix == 10) {
                buffer.append(lval);
            } else {
                buffer.append(Long.toString(lval, radix));
            }
        } else {
            int[] work;
            boolean neg = this.isNegative();
            if (neg || radix != 16) {
                work = new int[this.ival];
                this.getAbsolute(work);
            } else {
                work = this.words;
            }
            int len = this.ival;
            if (radix == 16) {
                if (neg) {
                    buffer.append('-');
                }
                int buf_start = buffer.length();
                int i = len;
                while (--i >= 0) {
                    int word = work[i];
                    int j = 8;
                    while (--j >= 0) {
                        int hex_digit = word >> 4 * j & 15;
                        if (hex_digit <= 0 && buffer.length() <= buf_start) continue;
                        buffer.append(Character.forDigit(hex_digit, 16));
                    }
                }
            } else {
                int chars_per_word = MPN.chars_per_word(radix);
                int wradix = radix;
                int j = chars_per_word;
                while (--j > 0) {
                    wradix *= radix;
                }
                int i = buffer.length();
                do {
                    int wdigit = MPN.divmod_1(work, work, len, wradix);
                    while (len > 0 && work[len - 1] == 0) {
                        --len;
                    }
                    int j2 = chars_per_word;
                    while (--j2 >= 0 && (len != 0 || wdigit != 0)) {
                        int digit;
                        if (wdigit < 0) {
                            long ldigit = (long)wdigit & -1L;
                            digit = (int)(ldigit % (long)radix);
                            wdigit /= radix;
                        } else {
                            digit = wdigit % radix;
                            wdigit /= radix;
                        }
                        buffer.append(Character.forDigit(digit, radix));
                    }
                } while (len != 0);
                if (neg) {
                    buffer.append('-');
                }
                for (int j3 = buffer.length() - 1; i < j3; ++i, --j3) {
                    char tmp = buffer.charAt(i);
                    buffer.setCharAt(i, buffer.charAt(j3));
                    buffer.setCharAt(j3, tmp);
                }
            }
        }
    }

    @Override
    public String toString(int radix) {
        if (this.words == null) {
            return Integer.toString(this.ival, radix);
        }
        if (this.ival <= 2) {
            return Long.toString(this.longValue(), radix);
        }
        int buf_size = this.ival * (MPN.chars_per_word(radix) + 1);
        StringBuilder buffer = new StringBuilder(buf_size);
        this.format(radix, buffer);
        return buffer.toString();
    }

    @Override
    public int intValue() {
        if (this.words == null) {
            return this.ival;
        }
        return this.words[0];
    }

    public static int intValue(Object obj) {
        IntNum inum = (IntNum)obj;
        if (inum.words != null) {
            throw new ClassCastException("integer too large");
        }
        return inum.ival;
    }

    @Override
    public long longValue() {
        if (this.words == null) {
            return this.ival;
        }
        if (this.ival == 1) {
            return this.words[0];
        }
        return ((long)this.words[1] << 32) + ((long)this.words[0] & 0xFFFFFFFFL);
    }

    public int hashCode() {
        return this.words == null ? this.ival : this.words[0] + this.words[this.ival - 1];
    }

    public static boolean equals(IntNum x, IntNum y) {
        if (x.words == null && y.words == null) {
            return x.ival == y.ival;
        }
        if (x.words == null || y.words == null || x.ival != y.ival) {
            return false;
        }
        int i = x.ival;
        while (--i >= 0) {
            if (x.words[i] == y.words[i]) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IntNum)) {
            return false;
        }
        return IntNum.equals(this, (IntNum)obj);
    }

    public static IntNum make(int value) {
        return IntNum.valueOf(value);
    }

    public static IntNum valueOfUnsigned(long value) {
        if (value >= 0L) {
            return IntNum.valueOf(value);
        }
        IntNum result = IntNum.alloc(3);
        result.ival = 3;
        result.words[0] = (int)value;
        result.words[1] = (int)(value >> 32);
        result.words[2] = 0;
        return result;
    }

    public static IntNum valueOfUnsigned(int value) {
        if (value >= 0) {
            return IntNum.valueOf(value);
        }
        IntNum result = IntNum.alloc(2);
        result.ival = 2;
        result.words[0] = value;
        result.words[1] = 0;
        return result;
    }

    public static IntNum make(int[] words, int len) {
        if (words == null) {
            return IntNum.make(len);
        }
        if ((len = IntNum.wordsNeeded(words, len)) <= 1) {
            return len == 0 ? IntNum.zero() : IntNum.make(words[0]);
        }
        IntNum num = new IntNum();
        num.words = words;
        num.ival = len;
        return num;
    }

    public static IntNum make(int[] words) {
        return IntNum.make(words, words.length);
    }

    public static IntNum make(long value) {
        return IntNum.valueOf(value);
    }

    public static IntNum valueOf(int value) {
        if (value >= -100 && value <= 1024) {
            return smallFixNums[value - -100];
        }
        return new IntNum(value);
    }

    public static IntNum valueOf(long value) {
        if (value >= -100L && value <= 1024L) {
            return smallFixNums[(int)value - -100];
        }
        int i = (int)value;
        if ((long)i == value) {
            return new IntNum(i);
        }
        IntNum result = IntNum.alloc(2);
        result.ival = 2;
        result.words[0] = i;
        result.words[1] = (int)(value >> 32);
        return result;
    }

    public static IntNum valueOf(char[] buf, int offset, int length, int radix, boolean negative) {
        int byte_len = 0;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; ++i) {
            char ch = buf[offset + i];
            if (ch == '-') {
                negative = true;
                continue;
            }
            if (ch == '_' || byte_len == 0 && (ch == ' ' || ch == '\t')) continue;
            int digit = Character.digit(ch, radix);
            if (digit < 0) break;
            bytes[byte_len++] = (byte)digit;
        }
        return IntNum.valueOf(bytes, byte_len, negative, radix);
    }

    public static IntNum valueOf(String s, int radix) throws NumberFormatException {
        int len = s.length();
        if (len + radix <= 28) {
            if (len > 1 && s.charAt(0) == '+' && Character.digit(s.charAt(1), radix) >= 0) {
                s = s.substring(1);
            }
            return IntNum.make(Long.parseLong(s, radix));
        }
        int byte_len = 0;
        byte[] bytes = new byte[len];
        boolean negative = false;
        for (int i = 0; i < len; ++i) {
            char ch = s.charAt(i);
            if (ch == '-' && i == 0) {
                negative = true;
                continue;
            }
            if (ch == '+' && i == 0 || ch == '_' || byte_len == 0 && (ch == ' ' || ch == '\t')) continue;
            int digit = Character.digit(ch, radix);
            if (digit < 0) {
                throw new NumberFormatException("For input string: \"" + s + '\"');
            }
            bytes[byte_len++] = (byte)digit;
        }
        return IntNum.valueOf(bytes, byte_len, negative, radix);
    }

    public static IntNum valueOf(byte[] digits, int byte_len, boolean negative, int radix) {
        int chars_per_word = MPN.chars_per_word(radix);
        int[] words = new int[byte_len / chars_per_word + 1];
        int size = MPN.set_str(words, digits, byte_len, radix);
        if (size == 0) {
            return IntNum.zero();
        }
        if (words[size - 1] < 0) {
            words[size++] = 0;
        }
        if (negative) {
            IntNum.negate(words, words, size);
        }
        return IntNum.make(words, size);
    }

    public static IntNum valueOf(String s) throws NumberFormatException {
        return IntNum.valueOf(s, 10);
    }

    @Override
    public double doubleValue() {
        if (this.words == null) {
            return this.ival;
        }
        if (this.ival <= 2) {
            return this.longValue();
        }
        if (this.isNegative()) {
            return IntNum.neg(this).roundToDouble(0, true, false);
        }
        return this.roundToDouble(0, false, false);
    }

    boolean checkBits(int n) {
        int i;
        if (n <= 0) {
            return false;
        }
        if (this.words == null) {
            return n > 31 || (this.ival & (1 << n) - 1) != 0;
        }
        for (i = 0; i < n >> 5; ++i) {
            if (this.words[i] == 0) continue;
            return true;
        }
        return (n & 31) != 0 && (this.words[i] & (1 << (n & 31)) - 1) != 0;
    }

    public double roundToDouble(int exp, boolean neg, boolean remainder) {
        int il = this.intLength();
        if ((exp += il - 1) < -1075) {
            return neg ? -0.0 : 0.0;
        }
        if (exp > 1023) {
            return neg ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        int ml = exp >= -1022 ? 53 : 53 + exp + 1022;
        int excess_bits = il - (ml + 1);
        long m = excess_bits > 0 ? (this.words == null ? (long)(this.ival >> excess_bits) : MPN.rshift_long(this.words, this.ival, excess_bits)) : this.longValue() << -excess_bits;
        if (exp == 1023 && m >> 1 == 0x1FFFFFFFFFFFFFL) {
            if (remainder || this.checkBits(il - ml)) {
                return neg ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            }
            return neg ? -1.7976931348623157E308 : Double.MAX_VALUE;
        }
        if ((m & 1L) == 1L && ((m & 2L) == 2L || remainder || this.checkBits(excess_bits))) {
            if (((m += 2L) & 0x40000000000000L) != 0L) {
                ++exp;
                m >>= 1;
            } else if (ml == 52 && (m & 0x20000000000000L) != 0L) {
                ++exp;
            }
        }
        long bits_sign = neg ? Long.MIN_VALUE : 0L;
        long bits_exp = (exp += 1023) <= 0 ? 0L : (long)exp << 52;
        long bits_mant = (m >>= 1) & -4503599627370497L;
        return Double.longBitsToDouble(bits_sign | bits_exp | bits_mant);
    }

    @Override
    public Numeric add(Object y, int k) {
        if (y instanceof IntNum) {
            return IntNum.add(this, (IntNum)y, k);
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).addReversed(this, k);
    }

    @Override
    public Numeric mul(Object y) {
        if (y instanceof IntNum) {
            return IntNum.times(this, (IntNum)y);
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).mulReversed(this);
    }

    @Override
    public Numeric div(Object y) {
        if (y instanceof RatNum) {
            RatNum r = (RatNum)y;
            return RatNum.make(IntNum.times(this, r.denominator()), r.numerator());
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).divReversed(this);
    }

    public void getAbsolute(int[] words) {
        int i;
        int len;
        if (this.words == null) {
            len = 1;
            words[0] = this.ival;
        } else {
            i = len = this.ival;
            while (--i >= 0) {
                words[i] = this.words[i];
            }
        }
        if (words[len - 1] < 0) {
            IntNum.negate(words, words, len);
        }
        i = words.length;
        while (--i > len) {
            words[i] = 0;
        }
    }

    public static boolean negate(int[] dest, int[] src, int len) {
        long carry = 1L;
        boolean negative = src[len - 1] < 0;
        for (int i = 0; i < len; ++i) {
            dest[i] = (int)(carry += (long)(~src[i]) & 0xFFFFFFFFL);
            carry >>= 32;
        }
        return negative && dest[len - 1] < 0;
    }

    public void setNegative(IntNum x) {
        int len = x.ival;
        if (x.words == null) {
            if (len == Integer.MIN_VALUE) {
                this.set(-((long)len));
            } else {
                this.set(-len);
            }
            return;
        }
        this.realloc(len + 1);
        if (IntNum.negate(this.words, x.words, len)) {
            this.words[len++] = 0;
        }
        this.ival = len;
    }

    public final void setNegative() {
        this.setNegative(this);
    }

    public static IntNum abs(IntNum x) {
        return x.isNegative() ? IntNum.neg(x) : x;
    }

    public static IntNum neg(IntNum x) {
        if (x.words == null && x.ival != Integer.MIN_VALUE) {
            return IntNum.make(-x.ival);
        }
        IntNum result = new IntNum(0);
        result.setNegative(x);
        return result.canonicalize();
    }

    @Override
    public Numeric neg() {
        return IntNum.neg(this);
    }

    public int intLength() {
        if (this.words == null) {
            return MPN.intLength(this.ival);
        }
        return MPN.intLength(this.words, this.ival);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        int nwords;
        int n = nwords = this.words == null ? 1 : IntNum.wordsNeeded(this.words, this.ival);
        if (nwords <= 1) {
            int i;
            int n2 = this.words == null ? this.ival : (i = this.words.length == 0 ? 0 : this.words[0]);
            if (i >= -1073741824) {
                out.writeInt(i);
            } else {
                out.writeInt(-2147483647);
                out.writeInt(i);
            }
        } else {
            out.writeInt(Integer.MIN_VALUE | nwords);
            while (--nwords >= 0) {
                out.writeInt(this.words[nwords]);
            }
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int i = in.readInt();
        if (i <= -1073741824) {
            if ((i &= Integer.MAX_VALUE) == 1) {
                i = in.readInt();
            } else {
                int[] w = new int[i];
                int j = i;
                while (--j >= 0) {
                    w[j] = in.readInt();
                }
                this.words = w;
            }
        }
        this.ival = i;
    }

    public Object readResolve() throws ObjectStreamException {
        return this.canonicalize();
    }

    public BigInteger asBigInteger() {
        if (this.words == null || this.ival <= 2) {
            return BigInteger.valueOf(this.longValue());
        }
        return new BigInteger(this.toString());
    }

    @Override
    public BigDecimal asBigDecimal() {
        if (this.words == null) {
            return new BigDecimal(this.ival);
        }
        if (this.ival <= 2) {
            return BigDecimal.valueOf(this.longValue());
        }
        return new BigDecimal(this.toString());
    }

    public boolean inRange(long lo, long hi) {
        return IntNum.compare(this, lo) >= 0 && IntNum.compare(this, hi) <= 0;
    }

    public boolean inIntRange() {
        return this.inRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean inLongRange() {
        return this.inRange(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static {
        int i = 1125;
        while (--i >= 0) {
            IntNum.smallFixNums[i] = new IntNum(i + -100);
        }
    }
}

