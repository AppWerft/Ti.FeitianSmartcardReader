// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.math.BigDecimal;
import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.math.BigInteger;
import java.io.Externalizable;

public class IntNum extends RatNum implements Externalizable
{
    public int ival;
    public int[] words;
    static final int minFixNum = -100;
    static final int maxFixNum = 1024;
    static final int numFixNum = 1125;
    static final IntNum[] smallFixNums;
    
    public IntNum() {
    }
    
    public IntNum(final int value) {
        this.ival = value;
    }
    
    public static final IntNum zero() {
        return IntNum.smallFixNums[100];
    }
    
    public static final IntNum one() {
        return IntNum.smallFixNums[101];
    }
    
    public static final IntNum ten() {
        return IntNum.smallFixNums[110];
    }
    
    public static IntNum minusOne() {
        return IntNum.smallFixNums[99];
    }
    
    public static IntNum asIntNumOrNull(final Object value) {
        if (value instanceof IntNum) {
            return (IntNum)value;
        }
        if (value instanceof UnsignedPrim) {
            return ((UnsignedPrim)value).toIntNum();
        }
        if (value instanceof BigInteger) {
            return valueOf(value.toString(), 10);
        }
        if (value instanceof Number && (value instanceof Integer || value instanceof Long || value instanceof Short || value instanceof Byte)) {
            return make(((Number)value).longValue());
        }
        return null;
    }
    
    public static IntNum alloc(final int nwords) {
        if (nwords <= 1) {
            return new IntNum();
        }
        final IntNum result = new IntNum();
        result.words = new int[nwords];
        return result;
    }
    
    public void realloc(final int nwords) {
        if (nwords == 0) {
            if (this.words != null) {
                if (this.ival > 0) {
                    this.ival = this.words[0];
                }
                this.words = null;
            }
        }
        else if (this.words == null || this.words.length < nwords || this.words.length > nwords + 2) {
            final int[] new_words = new int[nwords];
            if (this.words == null) {
                new_words[0] = this.ival;
                this.ival = 1;
            }
            else {
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
        return one();
    }
    
    @Override
    public final boolean isNegative() {
        return ((this.words == null) ? this.ival : this.words[this.ival - 1]) < 0;
    }
    
    @Override
    public int sign() {
        int n = this.ival;
        final int[] w = this.words;
        if (w == null) {
            return (n > 0) ? 1 : ((n < 0) ? -1 : 0);
        }
        final int i = w[--n];
        if (i > 0) {
            return 1;
        }
        if (i < 0) {
            return -1;
        }
        while (n != 0) {
            if (w[--n] != 0) {
                return 1;
            }
        }
        return 0;
    }
    
    public static int compare(final IntNum x, final IntNum y) {
        if (x.words == null && y.words == null) {
            return (x.ival < y.ival) ? -1 : ((x.ival > y.ival) ? 1 : 0);
        }
        final boolean x_negative = x.isNegative();
        final boolean y_negative = y.isNegative();
        if (x_negative != y_negative) {
            return x_negative ? -1 : 1;
        }
        final int x_len = (x.words == null) ? 1 : x.ival;
        final int y_len = (y.words == null) ? 1 : y.ival;
        if (x_len != y_len) {
            return (x_len > y_len != x_negative) ? 1 : -1;
        }
        return MPN.cmp(x.words, y.words, x_len);
    }
    
    public static int compare(final IntNum x, final long y) {
        long x_word;
        if (x.words == null) {
            x_word = x.ival;
        }
        else {
            final boolean x_negative = x.isNegative();
            final boolean y_negative = y < 0L;
            if (x_negative != y_negative) {
                return x_negative ? -1 : 1;
            }
            final int x_len = (x.words == null) ? 1 : x.ival;
            if (x_len == 1) {
                x_word = x.words[0];
            }
            else {
                if (x_len != 2) {
                    return x_negative ? -1 : 1;
                }
                x_word = x.longValue();
            }
        }
        return (x_word < y) ? -1 : ((x_word > y) ? 1 : 0);
    }
    
    @Override
    public int compare(final Object obj) {
        if (obj instanceof IntNum) {
            return compare(this, (IntNum)obj);
        }
        return ((Numeric)obj).compareReversed(this);
    }
    
    public final boolean isOdd() {
        final int low = (this.words == null) ? this.ival : this.words[0];
        return (low & 0x1) != 0x0;
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
    
    public static int wordsNeeded(final int[] words, final int len) {
        int i = len;
        if (i > 0) {
            int word = words[--i];
            if (word == -1) {
                while (i > 0 && (word = words[i - 1]) < 0) {
                    --i;
                    if (word != -1) {
                        break;
                    }
                }
            }
            else {
                while (word == 0 && i > 0 && (word = words[i - 1]) >= 0) {
                    --i;
                }
            }
        }
        return i + 1;
    }
    
    public IntNum canonicalize() {
        if (this.words != null && (this.ival = wordsNeeded(this.words, this.ival)) <= 1) {
            if (this.ival == 1) {
                this.ival = this.words[0];
            }
            this.words = null;
        }
        if (this.words == null && this.ival >= -100 && this.ival <= 1024) {
            return IntNum.smallFixNums[this.ival + 100];
        }
        return this;
    }
    
    public static final IntNum add(final int x, final int y) {
        return make(x + (long)y);
    }
    
    public static IntNum add(final IntNum x, final int y) {
        if (x.words == null) {
            return add(x.ival, y);
        }
        final IntNum result = new IntNum(0);
        result.setAdd(x, y);
        return result.canonicalize();
    }
    
    public void setAdd(final IntNum x, final int y) {
        if (x.words == null) {
            this.set(x.ival + (long)y);
            return;
        }
        final int len = x.ival;
        this.realloc(len + 1);
        long carry = y;
        for (int i = 0; i < len; ++i) {
            carry += ((long)x.words[i] & 0xFFFFFFFFL);
            this.words[i] = (int)carry;
            carry >>= 32;
        }
        if (x.words[len - 1] < 0) {
            --carry;
        }
        this.words[len] = (int)carry;
        this.ival = wordsNeeded(this.words, len + 1);
    }
    
    public final void setAdd(final int y) {
        this.setAdd(this, y);
    }
    
    public final void set(final int y) {
        this.words = null;
        this.ival = y;
    }
    
    public final void set(final long y) {
        final int i = (int)y;
        if (i == y) {
            this.ival = i;
            this.words = null;
        }
        else {
            this.realloc(2);
            this.words[0] = i;
            this.words[1] = (int)(y >> 32);
            this.ival = 2;
        }
    }
    
    public final void set(final int[] words, final int length) {
        this.ival = length;
        this.words = words;
    }
    
    public final void set(final IntNum y) {
        if (y.words == null) {
            this.set(y.ival);
        }
        else if (this != y) {
            this.realloc(y.ival);
            System.arraycopy(y.words, 0, this.words, 0, y.ival);
            this.ival = y.ival;
        }
    }
    
    public static IntNum add(final IntNum x, final IntNum y) {
        return add(x, y, 1);
    }
    
    public static IntNum sub(final IntNum x, final IntNum y) {
        return add(x, y, -1);
    }
    
    public static IntNum add(IntNum x, IntNum y, final int k) {
        if (y.words == null) {
            final int yval = y.ival;
            if (yval == 0) {
                return x;
            }
            if (x.words == null) {
                return make(k * (long)yval + x.ival);
            }
        }
        if (k != 1) {
            if (k == -1) {
                y = neg(y);
            }
            else {
                y = times(y, make(k));
            }
        }
        if (x.words == null) {
            return add(y, x.ival);
        }
        if (y.words == null) {
            return add(x, y.ival);
        }
        if (y.ival > x.ival) {
            final IntNum tmp = x;
            x = y;
            y = tmp;
        }
        final IntNum result = alloc(x.ival + 1);
        int i = y.ival;
        long carry = MPN.add_n(result.words, x.words, y.words, i);
        long y_ext = (y.words[i - 1] < 0) ? 4294967295L : 0L;
        while (i < x.ival) {
            carry += ((long)x.words[i] & 0xFFFFFFFFL) + y_ext;
            result.words[i] = (int)carry;
            carry >>>= 32;
            ++i;
        }
        if (x.words[i - 1] < 0) {
            --y_ext;
        }
        result.words[i] = (int)(carry + y_ext);
        result.ival = i + 1;
        return result.canonicalize();
    }
    
    public static final IntNum times(final int x, final int y) {
        return make(x * (long)y);
    }
    
    public static final IntNum times(final IntNum x, int y) {
        if (y == 0) {
            return zero();
        }
        if (y == 1) {
            return x;
        }
        int[] xwords = x.words;
        final int xlen = x.ival;
        if (xwords == null) {
            return make(xlen * (long)y);
        }
        final IntNum result = alloc(xlen + 1);
        boolean negative;
        if (xwords[xlen - 1] < 0) {
            negative = true;
            negate(result.words, xwords, xlen);
            xwords = result.words;
        }
        else {
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
    
    public static final IntNum times(final IntNum x, final IntNum y) {
        if (y.words == null) {
            return times(x, y.ival);
        }
        if (x.words == null) {
            return times(y, x.ival);
        }
        boolean negative = false;
        int xlen = x.ival;
        int ylen = y.ival;
        int[] xwords;
        if (x.isNegative()) {
            negative = true;
            xwords = new int[xlen];
            negate(xwords, x.words, xlen);
        }
        else {
            negative = false;
            xwords = x.words;
        }
        int[] ywords;
        if (y.isNegative()) {
            negative = !negative;
            ywords = new int[ylen];
            negate(ywords, y.words, ylen);
        }
        else {
            ywords = y.words;
        }
        if (xlen < ylen) {
            final int[] twords = xwords;
            xwords = ywords;
            ywords = twords;
            final int tlen = xlen;
            xlen = ylen;
            ylen = tlen;
        }
        final IntNum result = alloc(xlen + ylen);
        MPN.mul(result.words, xwords, xlen, ywords, ylen);
        result.ival = xlen + ylen;
        if (negative) {
            result.setNegative();
        }
        return result.canonicalize();
    }
    
    public static void divide(long x, long y, final IntNum quotient, final IntNum remainder, int rounding_mode) {
        if (rounding_mode == 5) {
            rounding_mode = ((y < 0L) ? 2 : 1);
        }
        boolean xNegative;
        if (x < 0L) {
            xNegative = true;
            if (x == Long.MIN_VALUE) {
                divide(make(x), make(y), quotient, remainder, rounding_mode);
                return;
            }
            x = -x;
        }
        else {
            xNegative = false;
        }
        boolean yNegative;
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
                }
                else {
                    divide(make(x), make(y), quotient, remainder, rounding_mode);
                }
                return;
            }
            y = -y;
        }
        else {
            yNegative = false;
        }
        long q = x / y;
        long r = x % y;
        final boolean qNegative = xNegative ^ yNegative;
        boolean add_one = false;
        if (r != 0L) {
            switch (rounding_mode) {
                case 1:
                case 2: {
                    if (qNegative == (rounding_mode == 1)) {
                        add_one = true;
                        break;
                    }
                    break;
                }
                case 4: {
                    add_one = (r > y - (q & 0x1L) >> 1);
                    break;
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
                xNegative = !xNegative;
            }
            if (xNegative) {
                r = -r;
            }
            remainder.set(r);
        }
    }
    
    public static void divide(final IntNum x, final IntNum y, final IntNum quotient, final IntNum remainder, int rounding_mode) {
        if ((x.words == null || x.ival <= 2) && (y.words == null || y.ival <= 2)) {
            final long x_l = x.longValue();
            final long y_l = y.longValue();
            if (x_l != Long.MIN_VALUE && y_l != Long.MIN_VALUE) {
                divide(x_l, y_l, quotient, remainder, rounding_mode);
                return;
            }
        }
        final boolean xNegative = x.isNegative();
        final boolean yNegative = y.isNegative();
        final boolean qNegative = xNegative ^ yNegative;
        int ylen = (y.words == null) ? 1 : y.ival;
        int[] ywords = new int[ylen];
        y.getAbsolute(ywords);
        while (ylen > 1 && ywords[ylen - 1] == 0) {
            --ylen;
        }
        int xlen = (x.words == null) ? 1 : x.ival;
        int[] xwords = new int[xlen + 2];
        x.getAbsolute(xwords);
        while (xlen > 1 && xwords[xlen - 1] == 0) {
            --xlen;
        }
        final int cmpval = MPN.cmp(xwords, xlen, ywords, ylen);
        int rlen;
        int qlen;
        if (cmpval < 0) {
            final int[] rwords = xwords;
            xwords = ywords;
            ywords = rwords;
            rlen = xlen;
            qlen = 1;
            xwords[0] = 0;
        }
        else if (cmpval == 0) {
            xwords[0] = 1;
            qlen = 1;
            ywords[0] = 0;
            rlen = 1;
        }
        else if (ylen == 1) {
            qlen = xlen;
            rlen = 1;
            ywords[0] = MPN.divmod_1(xwords, xwords, xlen, ywords[0]);
        }
        else {
            final int nshift = MPN.count_leading_zeros(ywords[ylen - 1]);
            if (nshift != 0) {
                MPN.lshift(ywords, 0, ywords, ylen, nshift);
                final int x_high = MPN.lshift(xwords, 0, xwords, xlen, nshift);
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
                rounding_mode = (yNegative ? 2 : 1);
            }
            switch (rounding_mode) {
                case 1:
                case 2: {
                    if (qNegative == (rounding_mode == 1)) {
                        add_one = true;
                        break;
                    }
                    break;
                }
                case 4: {
                    IntNum tmp = (remainder == null) ? new IntNum() : remainder;
                    tmp.set(ywords, rlen);
                    tmp = shift(tmp, 1);
                    if (yNegative) {
                        tmp.setNegative();
                    }
                    int cmp = compare(tmp, y);
                    if (yNegative) {
                        cmp = -cmp;
                    }
                    add_one = (cmp == 1 || (cmp == 0 && (xwords[0] & 0x1) != 0x0));
                    break;
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
                }
                else {
                    quotient.setNegative();
                }
            }
            else if (add_one) {
                quotient.setAdd(1);
            }
        }
        if (remainder != null) {
            remainder.set(ywords, rlen);
            if (add_one) {
                IntNum tmp;
                if (y.words == null) {
                    tmp = remainder;
                    tmp.set(yNegative ? (ywords[0] + y.ival) : (ywords[0] - y.ival));
                }
                else {
                    tmp = add(remainder, y, yNegative ? 1 : -1);
                }
                if (xNegative) {
                    remainder.setNegative(tmp);
                }
                else {
                    remainder.set(tmp);
                }
            }
            else if (xNegative) {
                remainder.setNegative();
            }
        }
    }
    
    public static IntNum quotient(final IntNum x, final IntNum y, final int rounding_mode) {
        final IntNum quotient = new IntNum();
        divide(x, y, quotient, null, rounding_mode);
        return quotient.canonicalize();
    }
    
    public static IntNum quotient(final IntNum x, final IntNum y) {
        return quotient(x, y, 3);
    }
    
    @Override
    public IntNum toExactInt(final int rounding_mode) {
        return this;
    }
    
    @Override
    public RealNum toInt(final int rounding_mode) {
        return this;
    }
    
    public static IntNum remainder(final IntNum x, final IntNum y, final int rounding_mode) {
        if (y.isZero()) {
            return x;
        }
        final IntNum rem = new IntNum();
        divide(x, y, null, rem, rounding_mode);
        return rem.canonicalize();
    }
    
    public static IntNum remainder(final IntNum x, final IntNum y) {
        return remainder(x, y, 3);
    }
    
    public static IntNum modulo(final IntNum x, final IntNum y) {
        return remainder(x, y, 1);
    }
    
    @Override
    public Numeric power(final IntNum y) {
        if (this.isOne()) {
            return this;
        }
        if (this.isMinusOne()) {
            return y.isOdd() ? this : one();
        }
        if (y.words == null && y.ival >= 0) {
            return power(this, y.ival);
        }
        if (this.isZero()) {
            return y.isNegative() ? RatNum.infinity(-1) : this;
        }
        return super.power(y);
    }
    
    public static IntNum power(final IntNum x, int y) {
        if (y <= 0) {
            if (y == 0) {
                return one();
            }
            throw new IllegalArgumentException("negative exponent");
        }
        else {
            if (x.isZero()) {
                return x;
            }
            int plen = (x.words == null) ? 1 : x.ival;
            final int blen = (x.intLength() * y >> 5) + 2 * plen;
            final boolean negative = x.isNegative() && (y & 0x1) != 0x0;
            int[] pow2 = new int[blen];
            int[] rwords = new int[blen];
            int[] work = new int[blen];
            x.getAbsolute(pow2);
            int rlen = 1;
            rwords[0] = 1;
            while (true) {
                if ((y & 0x1) != 0x0) {
                    MPN.mul(work, pow2, plen, rwords, rlen);
                    final int[] temp = work;
                    work = rwords;
                    for (rwords = temp, rlen += plen; rwords[rlen - 1] == 0; --rlen) {}
                }
                y >>= 1;
                if (y == 0) {
                    break;
                }
                MPN.mul(work, pow2, plen, pow2, plen);
                final int[] temp = work;
                work = pow2;
                for (pow2 = temp, plen *= 2; pow2[plen - 1] == 0; --plen) {}
            }
            if (rwords[rlen - 1] < 0) {
                ++rlen;
            }
            if (negative) {
                negate(rwords, rwords, rlen);
            }
            return make(rwords, rlen);
        }
    }
    
    public static final int gcd(int a, int b) {
        if (b > a) {
            final int tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            if (b == 1) {
                return b;
            }
            final int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    
    public static IntNum gcd(final IntNum x, final IntNum y) {
        int xval = x.ival;
        int yval = y.ival;
        if (x.words == null) {
            if (xval == 0) {
                return abs(y);
            }
            if (y.words == null && xval != Integer.MIN_VALUE && yval != Integer.MIN_VALUE) {
                if (xval < 0) {
                    xval = -xval;
                }
                if (yval < 0) {
                    yval = -yval;
                }
                return make(gcd(xval, yval));
            }
            xval = 1;
        }
        if (y.words == null) {
            if (yval == 0) {
                return abs(x);
            }
            yval = 1;
        }
        int len = (xval > yval) ? xval : yval;
        final int[] xwords = new int[len];
        final int[] ywords = new int[len];
        x.getAbsolute(xwords);
        y.getAbsolute(ywords);
        len = MPN.gcd(xwords, ywords, len);
        final IntNum result = new IntNum(0);
        if (xwords[len - 1] < 0) {
            xwords[len++] = 0;
        }
        result.ival = len;
        result.words = xwords;
        return result.canonicalize();
    }
    
    public static IntNum lcm(IntNum x, IntNum y) {
        if (x.isZero() || y.isZero()) {
            return zero();
        }
        x = abs(x);
        y = abs(y);
        final IntNum quotient = new IntNum();
        divide(times(x, y), gcd(x, y), quotient, null, 3);
        return quotient.canonicalize();
    }
    
    void setInvert() {
        if (this.words == null) {
            this.ival ^= -1;
        }
        else {
            int i = this.ival;
            while (--i >= 0) {
                this.words[i] ^= -1;
            }
        }
    }
    
    void setShiftLeft(final IntNum x, int count) {
        int[] xwords;
        int xlen;
        if (x.words == null) {
            if (count < 32) {
                this.set((long)x.ival << count);
                return;
            }
            xwords = new int[] { x.ival };
            xlen = 1;
        }
        else {
            xwords = x.words;
            xlen = x.ival;
        }
        final int word_count = count >> 5;
        count &= 0x1F;
        int new_len = xlen + word_count;
        if (count == 0) {
            this.realloc(new_len);
            int i = xlen;
            while (--i >= 0) {
                this.words[i + word_count] = xwords[i];
            }
        }
        else {
            ++new_len;
            this.realloc(new_len);
            final int shift_out = MPN.lshift(this.words, word_count, xwords, xlen, count);
            count = 32 - count;
            this.words[new_len - 1] = shift_out << count >> count;
        }
        this.ival = new_len;
        int i = word_count;
        while (--i >= 0) {
            this.words[i] = 0;
        }
    }
    
    void setShiftRight(final IntNum x, int count) {
        if (x.words == null) {
            this.set((count < 32) ? (x.ival >> count) : ((x.ival < 0) ? -1 : 0));
        }
        else if (count == 0) {
            this.set(x);
        }
        else {
            final boolean neg = x.isNegative();
            final int word_count = count >> 5;
            count &= 0x1F;
            final int d_len = x.ival - word_count;
            if (d_len <= 0) {
                this.set(neg ? -1 : 0);
            }
            else {
                if (this.words == null || this.words.length < d_len) {
                    this.realloc(d_len);
                }
                MPN.rshift0(this.words, x.words, word_count, d_len, count);
                this.ival = d_len;
                if (neg) {
                    final int[] words = this.words;
                    final int n = d_len - 1;
                    words[n] |= -2 << 31 - count;
                }
            }
        }
    }
    
    void setShift(final IntNum x, final int count) {
        if (count > 0) {
            this.setShiftLeft(x, count);
        }
        else {
            this.setShiftRight(x, -count);
        }
    }
    
    public static IntNum shift(final IntNum x, final int count) {
        if (x.words == null) {
            if (count <= 0) {
                return make((count > -32) ? (x.ival >> -count) : ((x.ival < 0) ? -1 : 0));
            }
            if (count < 32) {
                return make((long)x.ival << count);
            }
        }
        if (count == 0) {
            return x;
        }
        final IntNum result = new IntNum(0);
        result.setShift(x, count);
        return result.canonicalize();
    }
    
    public void format(final int radix, final StringBuffer buffer) {
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
    
    public void format(final int radix, final StringBuilder buffer) {
        if (this.words == null) {
            if (radix == 10) {
                buffer.append(this.ival);
            }
            else {
                buffer.append(Integer.toString(this.ival, radix));
            }
        }
        else if (this.ival <= 2) {
            final long lval = this.longValue();
            if (radix == 10) {
                buffer.append(lval);
            }
            else {
                buffer.append(Long.toString(lval, radix));
            }
        }
        else {
            final boolean neg = this.isNegative();
            int[] work;
            if (neg || radix != 16) {
                work = new int[this.ival];
                this.getAbsolute(work);
            }
            else {
                work = this.words;
            }
            int len = this.ival;
            if (radix == 16) {
                if (neg) {
                    buffer.append('-');
                }
                final int buf_start = buffer.length();
                int i = len;
                while (--i >= 0) {
                    final int word = work[i];
                    int j = 8;
                    while (--j >= 0) {
                        final int hex_digit = word >> 4 * j & 0xF;
                        if (hex_digit > 0 || buffer.length() > buf_start) {
                            buffer.append(Character.forDigit(hex_digit, 16));
                        }
                    }
                }
            }
            else {
                final int chars_per_word = MPN.chars_per_word(radix);
                int wradix = radix;
                int k = chars_per_word;
                while (--k > 0) {
                    wradix *= radix;
                }
                int l = buffer.length();
                do {
                    int wdigit = MPN.divmod_1(work, work, len, wradix);
                    while (len > 0 && work[len - 1] == 0) {
                        --len;
                    }
                    int m = chars_per_word;
                    while (--m >= 0 && (len != 0 || wdigit != 0)) {
                        int digit;
                        if (wdigit < 0) {
                            final long ldigit = (long)wdigit & -1L;
                            digit = (int)(ldigit % radix);
                            wdigit /= radix;
                        }
                        else {
                            digit = wdigit % radix;
                            wdigit /= radix;
                        }
                        buffer.append(Character.forDigit(digit, radix));
                    }
                } while (len != 0);
                if (neg) {
                    buffer.append('-');
                }
                for (int j = buffer.length() - 1; l < j; ++l, --j) {
                    final char tmp = buffer.charAt(l);
                    buffer.setCharAt(l, buffer.charAt(j));
                    buffer.setCharAt(j, tmp);
                }
            }
        }
    }
    
    @Override
    public String toString(final int radix) {
        if (this.words == null) {
            return Integer.toString(this.ival, radix);
        }
        if (this.ival <= 2) {
            return Long.toString(this.longValue(), radix);
        }
        final int buf_size = this.ival * (MPN.chars_per_word(radix) + 1);
        final StringBuilder buffer = new StringBuilder(buf_size);
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
    
    public static int intValue(final Object obj) {
        final IntNum inum = (IntNum)obj;
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
    
    @Override
    public int hashCode() {
        return (this.words == null) ? this.ival : (this.words[0] + this.words[this.ival - 1]);
    }
    
    public static boolean equals(final IntNum x, final IntNum y) {
        if (x.words == null && y.words == null) {
            return x.ival == y.ival;
        }
        if (x.words == null || y.words == null || x.ival != y.ival) {
            return false;
        }
        int i = x.ival;
        while (--i >= 0) {
            if (x.words[i] != y.words[i]) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj != null && obj instanceof IntNum && equals(this, (IntNum)obj);
    }
    
    public static IntNum make(final int value) {
        return valueOf(value);
    }
    
    public static IntNum valueOfUnsigned(final long value) {
        if (value >= 0L) {
            return valueOf(value);
        }
        final IntNum result = alloc(3);
        result.ival = 3;
        result.words[0] = (int)value;
        result.words[1] = (int)(value >> 32);
        result.words[2] = 0;
        return result;
    }
    
    public static IntNum valueOfUnsigned(final int value) {
        if (value >= 0) {
            return valueOf(value);
        }
        final IntNum result = alloc(2);
        result.ival = 2;
        result.words[0] = value;
        result.words[1] = 0;
        return result;
    }
    
    public static IntNum make(final int[] words, int len) {
        if (words == null) {
            return make(len);
        }
        len = wordsNeeded(words, len);
        if (len <= 1) {
            return (len == 0) ? zero() : make(words[0]);
        }
        final IntNum num = new IntNum();
        num.words = words;
        num.ival = len;
        return num;
    }
    
    public static IntNum make(final int[] words) {
        return make(words, words.length);
    }
    
    public static IntNum make(final long value) {
        return valueOf(value);
    }
    
    public static IntNum valueOf(final int value) {
        if (value >= -100 && value <= 1024) {
            return IntNum.smallFixNums[value + 100];
        }
        return new IntNum(value);
    }
    
    public static IntNum valueOf(final long value) {
        if (value >= -100L && value <= 1024L) {
            return IntNum.smallFixNums[(int)value + 100];
        }
        final int i = (int)value;
        if (i == value) {
            return new IntNum(i);
        }
        final IntNum result = alloc(2);
        result.ival = 2;
        result.words[0] = i;
        result.words[1] = (int)(value >> 32);
        return result;
    }
    
    public static IntNum valueOf(final char[] buf, final int offset, final int length, final int radix, boolean negative) {
        int byte_len = 0;
        final byte[] bytes = new byte[length];
        for (int i = 0; i < length; ++i) {
            final char ch = buf[offset + i];
            if (ch == '-') {
                negative = true;
            }
            else if (ch != '_') {
                if (byte_len == 0) {
                    if (ch == ' ') {
                        continue;
                    }
                    if (ch == '\t') {
                        continue;
                    }
                }
                final int digit = Character.digit(ch, radix);
                if (digit < 0) {
                    break;
                }
                bytes[byte_len++] = (byte)digit;
            }
        }
        return valueOf(bytes, byte_len, negative, radix);
    }
    
    public static IntNum valueOf(String s, final int radix) throws NumberFormatException {
        final int len = s.length();
        if (len + radix <= 28) {
            if (len > 1 && s.charAt(0) == '+' && Character.digit(s.charAt(1), radix) >= 0) {
                s = s.substring(1);
            }
            return make(Long.parseLong(s, radix));
        }
        int byte_len = 0;
        final byte[] bytes = new byte[len];
        boolean negative = false;
        for (int i = 0; i < len; ++i) {
            final char ch = s.charAt(i);
            if (ch == '-' && i == 0) {
                negative = true;
            }
            else if (ch != '+' || i != 0) {
                if (ch != '_') {
                    if (byte_len == 0) {
                        if (ch == ' ') {
                            continue;
                        }
                        if (ch == '\t') {
                            continue;
                        }
                    }
                    final int digit = Character.digit(ch, radix);
                    if (digit < 0) {
                        throw new NumberFormatException("For input string: \"" + s + '\"');
                    }
                    bytes[byte_len++] = (byte)digit;
                }
            }
        }
        return valueOf(bytes, byte_len, negative, radix);
    }
    
    public static IntNum valueOf(final byte[] digits, final int byte_len, final boolean negative, final int radix) {
        final int chars_per_word = MPN.chars_per_word(radix);
        final int[] words = new int[byte_len / chars_per_word + 1];
        int size = MPN.set_str(words, digits, byte_len, radix);
        if (size == 0) {
            return zero();
        }
        if (words[size - 1] < 0) {
            words[size++] = 0;
        }
        if (negative) {
            negate(words, words, size);
        }
        return make(words, size);
    }
    
    public static IntNum valueOf(final String s) throws NumberFormatException {
        return valueOf(s, 10);
    }
    
    @Override
    public double doubleValue() {
        if (this.words == null) {
            return this.ival;
        }
        if (this.ival <= 2) {
            return (double)this.longValue();
        }
        if (this.isNegative()) {
            return neg(this).roundToDouble(0, true, false);
        }
        return this.roundToDouble(0, false, false);
    }
    
    boolean checkBits(final int n) {
        if (n <= 0) {
            return false;
        }
        if (this.words == null) {
            return n > 31 || (this.ival & (1 << n) - 1) != 0x0;
        }
        int i;
        for (i = 0; i < n >> 5; ++i) {
            if (this.words[i] != 0) {
                return true;
            }
        }
        return (n & 0x1F) != 0x0 && (this.words[i] & (1 << (n & 0x1F)) - 1) != 0x0;
    }
    
    public double roundToDouble(int exp, final boolean neg, final boolean remainder) {
        final int il = this.intLength();
        exp += il - 1;
        if (exp < -1075) {
            return neg ? -0.0 : 0.0;
        }
        if (exp > 1023) {
            return neg ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        final int ml = (exp >= -1022) ? 53 : (53 + exp + 1022);
        final int excess_bits = il - (ml + 1);
        long m;
        if (excess_bits > 0) {
            m = ((this.words == null) ? (this.ival >> excess_bits) : MPN.rshift_long(this.words, this.ival, excess_bits));
        }
        else {
            m = this.longValue() << -excess_bits;
        }
        if (exp != 1023 || m >> 1 != 9007199254740991L) {
            if ((m & 0x1L) == 0x1L && ((m & 0x2L) == 0x2L || remainder || this.checkBits(excess_bits))) {
                m += 2L;
                if ((m & 0x40000000000000L) != 0x0L) {
                    ++exp;
                    m >>= 1;
                }
                else if (ml == 52 && (m & 0x20000000000000L) != 0x0L) {
                    ++exp;
                }
            }
            m >>= 1;
            final long bits_sign = neg ? Long.MIN_VALUE : 0L;
            exp += 1023;
            final long bits_exp = (exp <= 0) ? 0L : ((long)exp << 52);
            final long bits_mant = m & 0xFFEFFFFFFFFFFFFFL;
            return Double.longBitsToDouble(bits_sign | bits_exp | bits_mant);
        }
        if (remainder || this.checkBits(il - ml)) {
            return neg ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        return neg ? -1.7976931348623157E308 : Double.MAX_VALUE;
    }
    
    @Override
    public Numeric add(final Object y, final int k) {
        if (y instanceof IntNum) {
            return add(this, (IntNum)y, k);
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).addReversed(this, k);
    }
    
    @Override
    public Numeric mul(final Object y) {
        if (y instanceof IntNum) {
            return times(this, (IntNum)y);
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).mulReversed(this);
    }
    
    @Override
    public Numeric div(final Object y) {
        if (y instanceof RatNum) {
            final RatNum r = (RatNum)y;
            return RatNum.make(times(this, r.denominator()), r.numerator());
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).divReversed(this);
    }
    
    public void getAbsolute(final int[] words) {
        int len;
        if (this.words == null) {
            len = 1;
            words[0] = this.ival;
        }
        else {
            int i;
            len = (i = this.ival);
            while (--i >= 0) {
                words[i] = this.words[i];
            }
        }
        if (words[len - 1] < 0) {
            negate(words, words, len);
        }
        int i = words.length;
        while (--i > len) {
            words[i] = 0;
        }
    }
    
    public static boolean negate(final int[] dest, final int[] src, final int len) {
        long carry = 1L;
        final boolean negative = src[len - 1] < 0;
        for (int i = 0; i < len; ++i) {
            carry += ((long)~src[i] & 0xFFFFFFFFL);
            dest[i] = (int)carry;
            carry >>= 32;
        }
        return negative && dest[len - 1] < 0;
    }
    
    public void setNegative(final IntNum x) {
        int len = x.ival;
        if (x.words == null) {
            if (len == Integer.MIN_VALUE) {
                this.set(-len);
            }
            else {
                this.set(-len);
            }
            return;
        }
        this.realloc(len + 1);
        if (negate(this.words, x.words, len)) {
            this.words[len++] = 0;
        }
        this.ival = len;
    }
    
    public final void setNegative() {
        this.setNegative(this);
    }
    
    public static IntNum abs(final IntNum x) {
        return x.isNegative() ? neg(x) : x;
    }
    
    public static IntNum neg(final IntNum x) {
        if (x.words == null && x.ival != Integer.MIN_VALUE) {
            return make(-x.ival);
        }
        final IntNum result = new IntNum(0);
        result.setNegative(x);
        return result.canonicalize();
    }
    
    @Override
    public Numeric neg() {
        return neg(this);
    }
    
    public int intLength() {
        if (this.words == null) {
            return MPN.intLength(this.ival);
        }
        return MPN.intLength(this.words, this.ival);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        int nwords = (this.words == null) ? 1 : wordsNeeded(this.words, this.ival);
        if (nwords <= 1) {
            final int i = (this.words == null) ? this.ival : ((this.words.length == 0) ? 0 : this.words[0]);
            if (i >= -1073741824) {
                out.writeInt(i);
            }
            else {
                out.writeInt(-2147483647);
                out.writeInt(i);
            }
        }
        else {
            out.writeInt(Integer.MIN_VALUE | nwords);
            while (--nwords >= 0) {
                out.writeInt(this.words[nwords]);
            }
        }
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        int i = in.readInt();
        if (i <= -1073741824) {
            i &= Integer.MAX_VALUE;
            if (i == 1) {
                i = in.readInt();
            }
            else {
                final int[] w = new int[i];
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
    
    public boolean inRange(final long lo, final long hi) {
        return compare(this, lo) >= 0 && compare(this, hi) <= 0;
    }
    
    public boolean inIntRange() {
        return this.inRange(-2147483648L, 2147483647L);
    }
    
    public boolean inLongRange() {
        return this.inRange(Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    static {
        smallFixNums = new IntNum[1125];
        int i = 1125;
        while (--i >= 0) {
            IntNum.smallFixNums[i] = new IntNum(i - 100);
        }
    }
}
