/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

class MPN {
    MPN() {
    }

    public static int add_1(int[] dest, int[] x, int size, int y) {
        long carry = (long)y & 0xFFFFFFFFL;
        for (int i = 0; i < size; ++i) {
            dest[i] = (int)(carry += (long)x[i] & 0xFFFFFFFFL);
            carry >>= 32;
        }
        return (int)carry;
    }

    public static int add_n(int[] dest, int[] x, int[] y, int len) {
        long carry = 0L;
        for (int i = 0; i < len; ++i) {
            dest[i] = (int)(carry += ((long)x[i] & 0xFFFFFFFFL) + ((long)y[i] & 0xFFFFFFFFL));
            carry >>>= 32;
        }
        return (int)carry;
    }

    public static int sub_n(int[] dest, int[] X, int[] Y, int size) {
        int cy = 0;
        for (int i = 0; i < size; ++i) {
            int y = Y[i];
            int x = X[i];
            cy = ((y += cy) ^ Integer.MIN_VALUE) < (cy ^ Integer.MIN_VALUE) ? 1 : 0;
            y = x - y;
            cy += (y ^ Integer.MIN_VALUE) > (x ^ Integer.MIN_VALUE) ? 1 : 0;
            dest[i] = y;
        }
        return cy;
    }

    public static int mul_1(int[] dest, int[] x, int len, int y) {
        long yword = (long)y & 0xFFFFFFFFL;
        long carry = 0L;
        for (int j = 0; j < len; ++j) {
            dest[j] = (int)(carry += ((long)x[j] & 0xFFFFFFFFL) * yword);
            carry >>>= 32;
        }
        return (int)carry;
    }

    public static void mul(int[] dest, int[] x, int xlen, int[] y, int ylen) {
        dest[xlen] = MPN.mul_1(dest, x, xlen, y[0]);
        for (int i = 1; i < ylen; ++i) {
            long yword = (long)y[i] & 0xFFFFFFFFL;
            long carry = 0L;
            for (int j = 0; j < xlen; ++j) {
                dest[i + j] = (int)(carry += ((long)x[j] & 0xFFFFFFFFL) * yword + ((long)dest[i + j] & 0xFFFFFFFFL));
                carry >>>= 32;
            }
            dest[i + xlen] = (int)carry;
        }
    }

    public static long udiv_qrnnd(long N, int D) {
        long r;
        long q;
        long a1 = N >>> 32;
        long a0 = N & 0xFFFFFFFFL;
        if (D >= 0) {
            if (a1 < ((long)D - a1 - (a0 >>> 31) & 0xFFFFFFFFL)) {
                q = N / (long)D;
                r = N % (long)D;
            } else {
                long c = N - ((long)D << 31);
                q = c / (long)D;
                r = c % (long)D;
                q += Integer.MIN_VALUE;
            }
        } else {
            long b1 = D >>> 1;
            long c = N >>> 1;
            if (a1 < b1 || a1 >> 1 < b1) {
                if (a1 < b1) {
                    q = c / b1;
                    r = c % b1;
                } else {
                    c = c - (b1 << 32) ^ -1L;
                    q = c / b1;
                    r = c % b1;
                    q = (q ^ -1L) & 0xFFFFFFFFL;
                    r = b1 - 1L - r;
                }
                r = 2L * r + (a0 & 1L);
                if ((D & 1) != 0) {
                    if (r >= q) {
                        r -= q;
                    } else if (q - r <= ((long)D & 0xFFFFFFFFL)) {
                        r = r - q + (long)D;
                        --q;
                    } else {
                        r = r - q + (long)D + (long)D;
                        q -= 2L;
                    }
                }
            } else if (a0 >= ((long)(-D) & 0xFFFFFFFFL)) {
                q = -1L;
                r = a0 + (long)D;
            } else {
                q = -2L;
                r = a0 + (long)D + (long)D;
            }
        }
        return r << 32 | q & 0xFFFFFFFFL;
    }

    public static int divmod_1(int[] quotient, int[] dividend, int len, int divisor) {
        int i = len - 1;
        long r = dividend[i];
        if ((r & 0xFFFFFFFFL) >= ((long)divisor & 0xFFFFFFFFL)) {
            r = 0L;
        } else {
            quotient[i--] = 0;
            r <<= 32;
        }
        while (i >= 0) {
            int n0 = dividend[i];
            r = r & -4294967296L | (long)n0 & 0xFFFFFFFFL;
            r = MPN.udiv_qrnnd(r, divisor);
            quotient[i] = (int)r;
            --i;
        }
        return (int)(r >> 32);
    }

    public static int submul_1(int[] dest, int offset, int[] x, int len, int y) {
        long yl = (long)y & 0xFFFFFFFFL;
        int carry = 0;
        int j = 0;
        do {
            long prod = ((long)x[j] & 0xFFFFFFFFL) * yl;
            int prod_low = (int)prod;
            int prod_high = (int)(prod >> 32);
            carry = (((prod_low += carry) ^ Integer.MIN_VALUE) < (carry ^ Integer.MIN_VALUE) ? 1 : 0) + prod_high;
            int x_j = dest[offset + j];
            if (((prod_low = x_j - prod_low) ^ Integer.MIN_VALUE) > (x_j ^ Integer.MIN_VALUE)) {
                ++carry;
            }
            dest[offset + j] = prod_low;
        } while (++j < len);
        return carry;
    }

    public static void divide(int[] zds, int nx, int[] y, int ny) {
        int j = nx;
        do {
            int qhat;
            if (zds[j] == y[ny - 1]) {
                qhat = -1;
            } else {
                long w = ((long)zds[j] << 32) + ((long)zds[j - 1] & 0xFFFFFFFFL);
                qhat = (int)MPN.udiv_qrnnd(w, y[ny - 1]);
            }
            if (qhat != 0) {
                int borrow = MPN.submul_1(zds, j - ny, y, ny, qhat);
                int save = zds[j];
                long num = ((long)save & 0xFFFFFFFFL) - ((long)borrow & 0xFFFFFFFFL);
                while (num != 0L) {
                    --qhat;
                    long carry = 0L;
                    for (int i = 0; i < ny; ++i) {
                        zds[j - ny + i] = (int)(carry += ((long)zds[j - ny + i] & 0xFFFFFFFFL) + ((long)y[i] & 0xFFFFFFFFL));
                        carry >>>= 32;
                    }
                    int[] arrn = zds;
                    int n = j;
                    arrn[n] = (int)((long)arrn[n] + carry);
                    num = carry - 1L;
                }
            }
            zds[j] = qhat;
        } while (--j >= ny);
    }

    public static int chars_per_word(int radix) {
        if (radix < 10) {
            if (radix < 8) {
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
            return 10;
        }
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

    public static int count_leading_zeros(int i) {
        if (i == 0) {
            return 32;
        }
        int count = 0;
        for (int k = 16; k > 0; k >>= 1) {
            int j = i >>> k;
            if (j == 0) {
                count += k;
                continue;
            }
            i = j;
        }
        return count;
    }

    public static int set_str(int[] dest, byte[] str, int str_len, int base2) {
        int size = 0;
        if ((base2 & base2 - 1) == 0) {
            int next_bitpos = 0;
            int bits_per_indigit = 0;
            int i = base2;
            while ((i >>= 1) != 0) {
                ++bits_per_indigit;
            }
            int res_digit = 0;
            int i2 = str_len;
            while (--i2 >= 0) {
                byte inp_digit = str[i2];
                res_digit |= inp_digit << next_bitpos;
                if ((next_bitpos += bits_per_indigit) < 32) continue;
                dest[size++] = res_digit;
                res_digit = inp_digit >> bits_per_indigit - (next_bitpos -= 32);
            }
            if (res_digit != 0) {
                dest[size++] = res_digit;
            }
        } else {
            int indigits_per_limb = MPN.chars_per_word(base2);
            int str_pos = 0;
            while (str_pos < str_len) {
                int cy_limb;
                int chunk = str_len - str_pos;
                if (chunk > indigits_per_limb) {
                    chunk = indigits_per_limb;
                }
                int res_digit = str[str_pos++];
                int big_base = base2;
                while (--chunk > 0) {
                    res_digit = res_digit * base2 + str[str_pos++];
                    big_base *= base2;
                }
                if (size == 0) {
                    cy_limb = res_digit;
                } else {
                    cy_limb = MPN.mul_1(dest, dest, size, big_base);
                    cy_limb += MPN.add_1(dest, dest, size, res_digit);
                }
                if (cy_limb == 0) continue;
                dest[size++] = cy_limb;
            }
        }
        return size;
    }

    public static int cmp(int[] x, int[] y, int size) {
        while (--size >= 0) {
            int x_word = x[size];
            int y_word = y[size];
            if (x_word == y_word) continue;
            return (x_word ^ Integer.MIN_VALUE) > (y_word ^ Integer.MIN_VALUE) ? 1 : -1;
        }
        return 0;
    }

    public static int cmp(int[] x, int xlen, int[] y, int ylen) {
        return xlen > ylen ? 1 : (xlen < ylen ? -1 : MPN.cmp(x, y, xlen));
    }

    public static int rshift(int[] dest, int[] x, int x_start, int len, int count) {
        int count_2 = 32 - count;
        int low_word = x[x_start];
        int retval = low_word << count_2;
        for (int i = 1; i < len; ++i) {
            int high_word = x[x_start + i];
            dest[i - 1] = low_word >>> count | high_word << count_2;
            low_word = high_word;
        }
        dest[i - 1] = low_word >>> count;
        return retval;
    }

    public static void rshift0(int[] dest, int[] x, int x_start, int len, int count) {
        if (count > 0) {
            MPN.rshift(dest, x, x_start, len, count);
        } else {
            for (int i = 0; i < len; ++i) {
                dest[i] = x[i + x_start];
            }
        }
    }

    public static long rshift_long(int[] x, int len, int count) {
        int w1;
        int wordno = count >> 5;
        int sign = x[len - 1] < 0 ? -1 : 0;
        int w0 = wordno >= len ? sign : x[wordno];
        int n = w1 = ++wordno >= len ? sign : x[wordno];
        if ((count &= 31) != 0) {
            int w2 = ++wordno >= len ? sign : x[wordno];
            w0 = w0 >>> count | w1 << 32 - count;
            w1 = w1 >>> count | w2 << 32 - count;
        }
        return (long)w1 << 32 | (long)w0 & 0xFFFFFFFFL;
    }

    public static int lshift(int[] dest, int d_offset, int[] x, int len, int count) {
        int count_2 = 32 - count;
        int i = len - 1;
        int high_word = x[i];
        int retval = high_word >>> count_2;
        ++d_offset;
        while (--i >= 0) {
            int low_word = x[i];
            dest[d_offset + i] = high_word << count | low_word >>> count_2;
            high_word = low_word;
        }
        dest[d_offset + i] = high_word << count;
        return retval;
    }

    static int findLowestBit(int word) {
        int i = 0;
        while ((word & 15) == 0) {
            word >>= 4;
            i += 4;
        }
        if ((word & 3) == 0) {
            word >>= 2;
            i += 2;
        }
        if ((word & 1) == 0) {
            ++i;
        }
        return i;
    }

    static int findLowestBit(int[] words) {
        int i = 0;
        while (words[i] == 0) {
            ++i;
        }
        return 32 * i + MPN.findLowestBit(words[i]);
    }

    public static int gcd(int[] x, int[] y, int len) {
        int[] odd_arg;
        int[] other_arg;
        int word;
        int i = 0;
        while ((word = x[i] | y[i]) == 0) {
            ++i;
        }
        int initShiftWords = i;
        int initShiftBits = MPN.findLowestBit(word);
        MPN.rshift0(x, x, initShiftWords, len -= initShiftWords, initShiftBits);
        MPN.rshift0(y, y, initShiftWords, len, initShiftBits);
        if ((x[0] & 1) != 0) {
            odd_arg = x;
            other_arg = y;
        } else {
            odd_arg = y;
            other_arg = x;
        }
        block1 : do {
            i = 0;
            while (other_arg[i] == 0) {
                ++i;
            }
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
            if ((i = MPN.findLowestBit(other_arg[0])) > 0) {
                MPN.rshift(other_arg, other_arg, 0, len, i);
            }
            if ((i = MPN.cmp(odd_arg, other_arg, len)) == 0) break;
            if (i > 0) {
                MPN.sub_n(odd_arg, odd_arg, other_arg, len);
                int[] tmp = odd_arg;
                odd_arg = other_arg;
                other_arg = tmp;
            } else {
                MPN.sub_n(other_arg, other_arg, odd_arg, len);
            }
            do {
                if (odd_arg[len - 1] != 0 || other_arg[len - 1] != 0) continue block1;
                --len;
            } while (true);
            break;
        } while (true);
        if (initShiftWords + initShiftBits > 0) {
            if (initShiftBits > 0) {
                int sh_out = MPN.lshift(x, initShiftWords, x, len, initShiftBits);
                if (sh_out != 0) {
                    x[len++ + initShiftWords] = sh_out;
                }
            } else {
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

    public static int intLength(int i) {
        return 32 - MPN.count_leading_zeros(i < 0 ? ~i : i);
    }

    public static int intLength(int[] words, int len) {
        return MPN.intLength(words[--len]) + 32 * len;
    }
}

