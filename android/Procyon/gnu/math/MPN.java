// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

class MPN
{
    public static int add_1(final int[] dest, final int[] x, final int size, final int y) {
        long carry = (long)y & 0xFFFFFFFFL;
        for (int i = 0; i < size; ++i) {
            carry += ((long)x[i] & 0xFFFFFFFFL);
            dest[i] = (int)carry;
            carry >>= 32;
        }
        return (int)carry;
    }
    
    public static int add_n(final int[] dest, final int[] x, final int[] y, final int len) {
        long carry = 0L;
        for (int i = 0; i < len; ++i) {
            carry += ((long)x[i] & 0xFFFFFFFFL) + ((long)y[i] & 0xFFFFFFFFL);
            dest[i] = (int)carry;
            carry >>>= 32;
        }
        return (int)carry;
    }
    
    public static int sub_n(final int[] dest, final int[] X, final int[] Y, final int size) {
        int cy = 0;
        for (int i = 0; i < size; ++i) {
            int y = Y[i];
            final int x = X[i];
            y += cy;
            cy = (((y ^ Integer.MIN_VALUE) < (cy ^ Integer.MIN_VALUE)) ? 1 : 0);
            y = x - y;
            cy += (((y ^ Integer.MIN_VALUE) > (x ^ Integer.MIN_VALUE)) ? 1 : 0);
            dest[i] = y;
        }
        return cy;
    }
    
    public static int mul_1(final int[] dest, final int[] x, final int len, final int y) {
        final long yword = (long)y & 0xFFFFFFFFL;
        long carry = 0L;
        for (int j = 0; j < len; ++j) {
            carry += ((long)x[j] & 0xFFFFFFFFL) * yword;
            dest[j] = (int)carry;
            carry >>>= 32;
        }
        return (int)carry;
    }
    
    public static void mul(final int[] dest, final int[] x, final int xlen, final int[] y, final int ylen) {
        dest[xlen] = mul_1(dest, x, xlen, y[0]);
        for (int i = 1; i < ylen; ++i) {
            final long yword = (long)y[i] & 0xFFFFFFFFL;
            long carry = 0L;
            for (int j = 0; j < xlen; ++j) {
                carry += ((long)x[j] & 0xFFFFFFFFL) * yword + ((long)dest[i + j] & 0xFFFFFFFFL);
                dest[i + j] = (int)carry;
                carry >>>= 32;
            }
            dest[i + xlen] = (int)carry;
        }
    }
    
    public static long udiv_qrnnd(final long N, final int D) {
        final long a1 = N >>> 32;
        final long a2 = N & 0xFFFFFFFFL;
        long q;
        long r;
        if (D >= 0) {
            if (a1 < (D - a1 - (a2 >>> 31) & 0xFFFFFFFFL)) {
                q = N / D;
                r = N % D;
            }
            else {
                final long c = N - ((long)D << 31);
                q = c / D;
                r = c % D;
                q -= 2147483648L;
            }
        }
        else {
            final long b1 = D >>> 1;
            long c2 = N >>> 1;
            if (a1 < b1 || a1 >> 1 < b1) {
                if (a1 < b1) {
                    q = c2 / b1;
                    r = c2 % b1;
                }
                else {
                    c2 = ~(c2 - (b1 << 32));
                    q = c2 / b1;
                    r = c2 % b1;
                    q = (~q & 0xFFFFFFFFL);
                    r = b1 - 1L - r;
                }
                r = 2L * r + (a2 & 0x1L);
                if ((D & 0x1) != 0x0) {
                    if (r >= q) {
                        r -= q;
                    }
                    else if (q - r <= ((long)D & 0xFFFFFFFFL)) {
                        r = r - q + D;
                        --q;
                    }
                    else {
                        r = r - q + D + D;
                        q -= 2L;
                    }
                }
            }
            else if (a2 >= ((long)(-D) & 0xFFFFFFFFL)) {
                q = -1L;
                r = a2 + D;
            }
            else {
                q = -2L;
                r = a2 + D + D;
            }
        }
        return r << 32 | (q & 0xFFFFFFFFL);
    }
    
    public static int divmod_1(final int[] quotient, final int[] dividend, final int len, final int divisor) {
        int i = len - 1;
        long r = dividend[i];
        if ((r & 0xFFFFFFFFL) >= ((long)divisor & 0xFFFFFFFFL)) {
            r = 0L;
        }
        else {
            quotient[i--] = 0;
            r <<= 32;
        }
        while (i >= 0) {
            final int n0 = dividend[i];
            r = ((r & 0xFFFFFFFF00000000L) | ((long)n0 & 0xFFFFFFFFL));
            r = udiv_qrnnd(r, divisor);
            quotient[i] = (int)r;
            --i;
        }
        return (int)(r >> 32);
    }
    
    public static int submul_1(final int[] dest, final int offset, final int[] x, final int len, final int y) {
        final long yl = (long)y & 0xFFFFFFFFL;
        int carry = 0;
        int j = 0;
        do {
            final long prod = ((long)x[j] & 0xFFFFFFFFL) * yl;
            int prod_low = (int)prod;
            final int prod_high = (int)(prod >> 32);
            prod_low += carry;
            carry = (((prod_low ^ Integer.MIN_VALUE) < (carry ^ Integer.MIN_VALUE)) ? 1 : 0) + prod_high;
            final int x_j = dest[offset + j];
            prod_low = x_j - prod_low;
            if ((prod_low ^ Integer.MIN_VALUE) > (x_j ^ Integer.MIN_VALUE)) {
                ++carry;
            }
            dest[offset + j] = prod_low;
        } while (++j < len);
        return carry;
    }
    
    public static void divide(final int[] zds, final int nx, final int[] y, final int ny) {
        int j = nx;
        do {
            int qhat;
            if (zds[j] == y[ny - 1]) {
                qhat = -1;
            }
            else {
                final long w = ((long)zds[j] << 32) + ((long)zds[j - 1] & 0xFFFFFFFFL);
                qhat = (int)udiv_qrnnd(w, y[ny - 1]);
            }
            if (qhat != 0) {
                final int borrow = submul_1(zds, j - ny, y, ny, qhat);
                final int save = zds[j];
                long carry;
                for (long num = ((long)save & 0xFFFFFFFFL) - ((long)borrow & 0xFFFFFFFFL); num != 0L; num = carry - 1L) {
                    --qhat;
                    carry = 0L;
                    for (int i = 0; i < ny; ++i) {
                        carry += ((long)zds[j - ny + i] & 0xFFFFFFFFL) + ((long)y[i] & 0xFFFFFFFFL);
                        zds[j - ny + i] = (int)carry;
                        carry >>>= 32;
                    }
                    final int n = j;
                    zds[n] += (int)carry;
                }
            }
            zds[j] = qhat;
        } while (--j >= ny);
    }
    
    public static int chars_per_word(final int radix) {
        if (radix < 10) {
            if (radix >= 8) {
                return 10;
            }
            if (radix <= 2) {
                return 32;
            }
            if (radix == 3) {
                return 20;
            }
            if (radix == 4) {
                return 16;
            }
            return 18 - radix;
        }
        else {
            if (radix < 12) {
                return 9;
            }
            if (radix <= 16) {
                return 8;
            }
            if (radix <= 23) {
                return 7;
            }
            if (radix <= 40) {
                return 6;
            }
            if (radix <= 256) {
                return 4;
            }
            return 1;
        }
    }
    
    public static int count_leading_zeros(int i) {
        if (i == 0) {
            return 32;
        }
        int count = 0;
        for (int k = 16; k > 0; k >>= 1) {
            final int j = i >>> k;
            if (j == 0) {
                count += k;
            }
            else {
                i = j;
            }
        }
        return count;
    }
    
    public static int set_str(final int[] dest, final byte[] str, final int str_len, final int base) {
        int size = 0;
        if ((base & base - 1) == 0x0) {
            int next_bitpos = 0;
            int bits_per_indigit = 0;
            int i = base;
            while ((i >>= 1) != 0) {
                ++bits_per_indigit;
            }
            int res_digit = 0;
            int j = str_len;
            while (--j >= 0) {
                final int inp_digit = str[j];
                res_digit |= inp_digit << next_bitpos;
                next_bitpos += bits_per_indigit;
                if (next_bitpos >= 32) {
                    dest[size++] = res_digit;
                    next_bitpos -= 32;
                    res_digit = inp_digit >> bits_per_indigit - next_bitpos;
                }
            }
            if (res_digit != 0) {
                dest[size++] = res_digit;
            }
        }
        else {
            final int indigits_per_limb = chars_per_word(base);
            int str_pos = 0;
            while (str_pos < str_len) {
                int chunk = str_len - str_pos;
                if (chunk > indigits_per_limb) {
                    chunk = indigits_per_limb;
                }
                int res_digit2 = str[str_pos++];
                int big_base = base;
                while (--chunk > 0) {
                    res_digit2 = res_digit2 * base + str[str_pos++];
                    big_base *= base;
                }
                int cy_limb;
                if (size == 0) {
                    cy_limb = res_digit2;
                }
                else {
                    cy_limb = mul_1(dest, dest, size, big_base);
                    cy_limb += add_1(dest, dest, size, res_digit2);
                }
                if (cy_limb != 0) {
                    dest[size++] = cy_limb;
                }
            }
        }
        return size;
    }
    
    public static int cmp(final int[] x, final int[] y, int size) {
        while (--size >= 0) {
            final int x_word = x[size];
            final int y_word = y[size];
            if (x_word != y_word) {
                return ((x_word ^ Integer.MIN_VALUE) > (y_word ^ Integer.MIN_VALUE)) ? 1 : -1;
            }
        }
        return 0;
    }
    
    public static int cmp(final int[] x, final int xlen, final int[] y, final int ylen) {
        return (xlen > ylen) ? 1 : ((xlen < ylen) ? -1 : cmp(x, y, xlen));
    }
    
    public static int rshift(final int[] dest, final int[] x, final int x_start, final int len, final int count) {
        final int count_2 = 32 - count;
        int low_word = x[x_start];
        final int retval = low_word << count_2;
        int i;
        for (i = 1; i < len; ++i) {
            final int high_word = x[x_start + i];
            dest[i - 1] = (low_word >>> count | high_word << count_2);
            low_word = high_word;
        }
        dest[i - 1] = low_word >>> count;
        return retval;
    }
    
    public static void rshift0(final int[] dest, final int[] x, final int x_start, final int len, final int count) {
        if (count > 0) {
            rshift(dest, x, x_start, len, count);
        }
        else {
            for (int i = 0; i < len; ++i) {
                dest[i] = x[i + x_start];
            }
        }
    }
    
    public static long rshift_long(final int[] x, final int len, int count) {
        int wordno = count >> 5;
        count &= 0x1F;
        final int sign = (x[len - 1] < 0) ? -1 : 0;
        int w0 = (wordno >= len) ? sign : x[wordno];
        int w2 = (++wordno >= len) ? sign : x[wordno];
        if (count != 0) {
            final int w3 = (++wordno >= len) ? sign : x[wordno];
            w0 = (w0 >>> count | w2 << 32 - count);
            w2 = (w2 >>> count | w3 << 32 - count);
        }
        return (long)w2 << 32 | ((long)w0 & 0xFFFFFFFFL);
    }
    
    public static int lshift(final int[] dest, int d_offset, final int[] x, final int len, final int count) {
        final int count_2 = 32 - count;
        int i = len - 1;
        int high_word = x[i];
        final int retval = high_word >>> count_2;
        ++d_offset;
        while (--i >= 0) {
            final int low_word = x[i];
            dest[d_offset + i] = (high_word << count | low_word >>> count_2);
            high_word = low_word;
        }
        dest[d_offset + i] = high_word << count;
        return retval;
    }
    
    static int findLowestBit(int word) {
        int i;
        for (i = 0; (word & 0xF) == 0x0; word >>= 4, i += 4) {}
        if ((word & 0x3) == 0x0) {
            word >>= 2;
            i += 2;
        }
        if ((word & 0x1) == 0x0) {
            ++i;
        }
        return i;
    }
    
    static int findLowestBit(final int[] words) {
        int i;
        for (i = 0; words[i] == 0; ++i) {}
        return 32 * i + findLowestBit(words[i]);
    }
    
    public static int gcd(final int[] x, final int[] y, int len) {
        int i = 0;
        int word;
        while (true) {
            word = (x[i] | y[i]);
            if (word != 0) {
                break;
            }
            ++i;
        }
        final int initShiftWords = i;
        final int initShiftBits = findLowestBit(word);
        len -= initShiftWords;
        rshift0(x, x, initShiftWords, len, initShiftBits);
        rshift0(y, y, initShiftWords, len, initShiftBits);
        int[] odd_arg;
        int[] other_arg;
        if ((x[0] & 0x1) != 0x0) {
            odd_arg = x;
            other_arg = y;
        }
        else {
            odd_arg = y;
            other_arg = x;
        }
        while (true) {
            for (i = 0; other_arg[i] == 0; ++i) {}
            if (i > 0) {
                int j;
                for (j = 0; j < len - i; ++j) {
                    other_arg[j] = other_arg[j + i];
                }
                while (j < len) {
                    other_arg[j] = 0;
                    ++j;
                }
            }
            i = findLowestBit(other_arg[0]);
            if (i > 0) {
                rshift(other_arg, other_arg, 0, len, i);
            }
            i = cmp(odd_arg, other_arg, len);
            if (i == 0) {
                break;
            }
            if (i > 0) {
                sub_n(odd_arg, odd_arg, other_arg, len);
                final int[] tmp = odd_arg;
                odd_arg = other_arg;
                other_arg = tmp;
            }
            else {
                sub_n(other_arg, other_arg, odd_arg, len);
            }
            while (odd_arg[len - 1] == 0 && other_arg[len - 1] == 0) {
                --len;
            }
        }
        if (initShiftWords + initShiftBits > 0) {
            if (initShiftBits > 0) {
                final int sh_out = lshift(x, initShiftWords, x, len, initShiftBits);
                if (sh_out != 0) {
                    x[len++ + initShiftWords] = sh_out;
                }
            }
            else {
                i = len;
                while (--i >= 0) {
                    x[i + initShiftWords] = x[i];
                }
            }
            i = initShiftWords;
            while (--i >= 0) {
                x[i] = 0;
            }
            len += initShiftWords;
        }
        return len;
    }
    
    public static int intLength(final int i) {
        return 32 - count_leading_zeros((i < 0) ? (~i) : i);
    }
    
    public static int intLength(final int[] words, int len) {
        --len;
        return intLength(words[len]) + 32 * len;
    }
}
