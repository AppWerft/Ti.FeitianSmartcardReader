/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.IntNum;
import gnu.math.MPN;

public class BitOps {
    static final byte[] bit4_count = new byte[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};

    private BitOps() {
    }

    public static boolean bitValue(IntNum x, int bitno) {
        int i = x.ival;
        if (x.words == null) {
            return bitno >= 32 ? i < 0 : (i >> bitno & 1) != 0;
        }
        int wordno = bitno >> 5;
        return wordno >= i ? x.words[i - 1] < 0 : (x.words[wordno] >> bitno & 1) != 0;
    }

    static int[] dataBufferFor(IntNum x, int bitno) {
        int[] data;
        block6 : {
            int i;
            int nwords;
            block5 : {
                i = x.ival;
                nwords = bitno + 1 >> 5;
                if (x.words != null) break block5;
                if (nwords == 0) {
                    nwords = 1;
                }
                data = new int[nwords];
                data[0] = i;
                if (i >= 0) break block6;
                for (int j = 1; j < nwords; ++j) {
                    data[j] = -1;
                }
                break block6;
            }
            nwords = bitno + 1 >> 5;
            data = new int[nwords > i ? nwords : i];
            int j = i;
            while (--j >= 0) {
                data[j] = x.words[j];
            }
            if (data[i - 1] < 0) {
                for (j = i; j < nwords; ++j) {
                    data[j] = -1;
                }
            }
        }
        return data;
    }

    public static IntNum setBitValue(IntNum x, int bitno, int newValue) {
        int[] data;
        newValue &= 1;
        int i = x.ival;
        if (x.words == null) {
            int oldValue = i >> (bitno < 31 ? bitno : 31) & 1;
            if (oldValue == newValue) {
                return x;
            }
            if (bitno < 63) {
                return IntNum.make((long)i ^ (long)(1 << bitno));
            }
        } else {
            int wordno = bitno >> 5;
            int oldValue = wordno >= i ? (x.words[i - 1] < 0 ? 1 : 0) : x.words[wordno] >> bitno & 1;
            if (oldValue == newValue) {
                return x;
            }
        }
        int[] arrn = data = BitOps.dataBufferFor(x, bitno);
        int n = bitno >> 5;
        arrn[n] = arrn[n] ^ 1 << (bitno & 31);
        return IntNum.make(data, data.length);
    }

    public static boolean test(IntNum x, int y) {
        if (x.words == null) {
            return (x.ival & y) != 0;
        }
        return y < 0 || (x.words[0] & y) != 0;
    }

    public static boolean test(IntNum x, IntNum y) {
        if (y.words == null) {
            return BitOps.test(x, y.ival);
        }
        if (x.words == null) {
            return BitOps.test(y, x.ival);
        }
        if (x.ival < y.ival) {
            IntNum temp = x;
            x = y;
            y = temp;
        }
        for (int i = 0; i < y.ival; ++i) {
            if ((x.words[i] & y.words[i]) == 0) continue;
            return true;
        }
        return y.isNegative();
    }

    public static IntNum and(IntNum x, int y) {
        if (x.words == null) {
            return IntNum.make(x.ival & y);
        }
        if (y >= 0) {
            return IntNum.make(x.words[0] & y);
        }
        int len = x.ival;
        int[] words = new int[len];
        words[0] = x.words[0] & y;
        while (--len > 0) {
            words[len] = x.words[len];
        }
        return IntNum.make(words, x.ival);
    }

    public static IntNum and(IntNum x, IntNum y) {
        int i;
        if (y.words == null) {
            return BitOps.and(x, y.ival);
        }
        if (x.words == null) {
            return BitOps.and(y, x.ival);
        }
        if (x.ival < y.ival) {
            IntNum temp = x;
            x = y;
            y = temp;
        }
        int len = y.isNegative() ? x.ival : y.ival;
        int[] words = new int[len];
        for (i = 0; i < y.ival; ++i) {
            words[i] = x.words[i] & y.words[i];
        }
        while (i < len) {
            words[i] = x.words[i];
            ++i;
        }
        return IntNum.make(words, len);
    }

    public static IntNum ior(IntNum x, IntNum y) {
        return BitOps.bitOp(7, x, y);
    }

    public static IntNum xor(IntNum x, IntNum y) {
        return BitOps.bitOp(6, x, y);
    }

    public static IntNum not(IntNum x) {
        return BitOps.bitOp(12, x, IntNum.zero());
    }

    public static int swappedOp(int op) {
        return "\u0000\u0001\u0004\u0005\u0002\u0003\u0006\u0007\b\t\f\r\n\u000b\u000e\u000f".charAt(op);
    }

    public static IntNum bitOp(int op, IntNum x, IntNum y) {
        switch (op) {
            case 0: {
                return IntNum.zero();
            }
            case 1: {
                return BitOps.and(x, y);
            }
            case 3: {
                return x;
            }
            case 5: {
                return y;
            }
            case 15: {
                return IntNum.minusOne();
            }
        }
        IntNum result = new IntNum();
        BitOps.setBitOp(result, op, x, y);
        return result.canonicalize();
    }

    public static void setBitOp(IntNum result, int op, IntNum x, IntNum y) {
        int xi;
        int ylen;
        int ni;
        int xlen;
        int yi;
        if (y.words != null && (x.words == null || x.ival < y.ival)) {
            IntNum temp = x;
            x = y;
            y = temp;
            op = BitOps.swappedOp(op);
        }
        if (y.words == null) {
            yi = y.ival;
            ylen = 1;
        } else {
            yi = y.words[0];
            ylen = y.ival;
        }
        if (x.words == null) {
            xi = x.ival;
            xlen = 1;
        } else {
            xi = x.words[0];
            xlen = x.ival;
        }
        if (xlen > 1) {
            result.realloc(xlen);
        }
        int[] w = result.words;
        int i = 0;
        int finish = 0;
        block0 : switch (op) {
            case 0: {
                ni = 0;
                break;
            }
            case 1: {
                do {
                    ni = xi & yi;
                    if (i + 1 >= ylen) break;
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                } while (true);
                if (yi >= 0) break;
                finish = 1;
                break;
            }
            case 2: {
                do {
                    ni = xi & ~yi;
                    if (i + 1 >= ylen) break;
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                } while (true);
                if (yi < 0) break;
                finish = 1;
                break;
            }
            case 3: {
                ni = xi;
                finish = 1;
                break;
            }
            case 4: {
                do {
                    ni = ~xi & yi;
                    if (i + 1 >= ylen) break;
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                } while (true);
                if (yi >= 0) break;
                finish = 2;
                break;
            }
            case 5: {
                do {
                    ni = yi;
                    if (i + 1 >= ylen) break block0;
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                } while (true);
            }
            case 6: {
                do {
                    ni = xi ^ yi;
                    if (i + 1 >= ylen) break;
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                } while (true);
                finish = yi < 0 ? 2 : 1;
                break;
            }
            case 7: {
                do {
                    ni = xi | yi;
                    if (i + 1 >= ylen) break;
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                } while (true);
                if (yi < 0) break;
                finish = 1;
                break;
            }
            case 8: {
                do {
                    ni = ~(xi | yi);
                    if (i + 1 >= ylen) break;
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                } while (true);
                if (yi < 0) break;
                finish = 2;
                break;
            }
            case 9: {
                do {
                    ni = ~(xi ^ yi);
                    if (i + 1 >= ylen) break;
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                } while (true);
                finish = yi >= 0 ? 2 : 1;
                break;
            }
            case 10: {
                do {
                    ni = ~yi;
                    if (i + 1 >= ylen) break block0;
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                } while (true);
            }
            case 11: {
                do {
                    ni = xi | ~yi;
                    if (i + 1 >= ylen) break;
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                } while (true);
                if (yi >= 0) break;
                finish = 1;
                break;
            }
            case 12: {
                ni = ~xi;
                finish = 2;
                break;
            }
            case 13: {
                do {
                    ni = ~xi | yi;
                    if (i + 1 >= ylen) break;
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                } while (true);
                if (yi < 0) break;
                finish = 2;
                break;
            }
            case 14: {
                do {
                    ni = ~(xi & yi);
                    if (i + 1 >= ylen) break;
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                } while (true);
                if (yi >= 0) break;
                finish = 2;
                break;
            }
            default: {
                ni = -1;
            }
        }
        if (i + 1 == xlen) {
            finish = 0;
        }
        switch (finish) {
            case 0: {
                if (i == 0 && w == null) {
                    result.ival = ni;
                    return;
                }
                w[i++] = ni;
                break;
            }
            case 1: {
                w[i] = ni;
                while (++i < xlen) {
                    w[i] = x.words[i];
                }
                break;
            }
            case 2: {
                w[i] = ni;
                while (++i < xlen) {
                    w[i] = ~x.words[i];
                }
                break;
            }
        }
        result.ival = i;
    }

    public static IntNum makeMask(int startBit, int endBit) {
        int width = endBit - startBit;
        if (width <= 0) {
            return IntNum.zero();
        }
        if (endBit < 64) {
            return IntNum.make((-1L << width ^ -1L) << startBit);
        }
        int len = (endBit >> 5) + 1;
        int[] buf = new int[len];
        int startWord = startBit >> 5;
        int i = width >> 5;
        buf[i] = ~(-1 << (width & 31));
        while (--i >= 0) {
            buf[i] = -1;
        }
        MPN.lshift(buf, startWord, buf, len - startWord, startBit & 31);
        i = startWord;
        while (--i >= 0) {
            buf[i] = 0;
        }
        return IntNum.make(buf, len);
    }

    public static IntNum extract(IntNum x, int startBit, int endBit) {
        int length;
        int x_len;
        if (endBit < 32) {
            int word0 = x.words == null ? x.ival : x.words[0];
            return IntNum.make((word0 & ~(-1 << endBit)) >> startBit);
        }
        if (x.words == null) {
            if (x.ival >= 0) {
                return IntNum.make(startBit >= 31 ? 0 : x.ival >> startBit);
            }
            x_len = 1;
        } else {
            x_len = x.ival;
        }
        boolean neg = x.isNegative();
        if (endBit > 32 * x_len) {
            endBit = 32 * x_len;
            if (!neg && startBit == 0) {
                return x;
            }
        } else {
            x_len = endBit + 31 >> 5;
        }
        if ((length = endBit - startBit) < 64) {
            long l = x.words == null ? (long)(x.ival >> (startBit >= 32 ? 31 : startBit)) : MPN.rshift_long(x.words, x_len, startBit);
            return IntNum.make(l & (-1L << length ^ -1L));
        }
        int startWord = startBit >> 5;
        int buf_len = (endBit >> 5) + 1 - startWord;
        int[] buf = new int[buf_len];
        if (x.words == null) {
            buf[0] = startBit >= 32 ? -1 : x.ival >> startBit;
        } else {
            MPN.rshift0(buf, x.words, startWord, x_len -= startWord, startBit &= 31);
        }
        x_len = length >> 5;
        int[] arrn = buf;
        int n = x_len;
        arrn[n] = arrn[n] & ~(-1 << length);
        return IntNum.make(buf, x_len + 1);
    }

    public static int lowestBitSet(int i) {
        if (i == 0) {
            return -1;
        }
        int index = 0;
        while ((i & 255) == 0) {
            i >>>= 8;
            index += 8;
        }
        while ((i & 3) == 0) {
            i >>>= 2;
            index += 2;
        }
        if ((i & 1) == 0) {
            ++index;
        }
        return index;
    }

    public static int lowestBitSet(IntNum x) {
        int[] x_words = x.words;
        if (x_words == null) {
            return BitOps.lowestBitSet(x.ival);
        }
        int x_len = x.ival;
        int i = 0;
        while (i < x_len) {
            int b = BitOps.lowestBitSet(x_words[i]);
            if (b < 0) continue;
            return 32 * i + b;
        }
        return -1;
    }

    public static int bitCount(int i) {
        int count = 0;
        while (i != 0) {
            count += bit4_count[i & 15];
            i >>>= 4;
        }
        return count;
    }

    public static int bitCount(int[] x, int len) {
        int count = 0;
        while (--len >= 0) {
            count += BitOps.bitCount(x[len]);
        }
        return count;
    }

    public static int bitCount(IntNum x) {
        int x_len;
        int i;
        int[] x_words = x.words;
        if (x_words == null) {
            x_len = 1;
            i = BitOps.bitCount(x.ival);
        } else {
            x_len = x.ival;
            i = BitOps.bitCount(x_words, x_len);
        }
        return x.isNegative() ? x_len * 32 - i : i;
    }

    public static IntNum reverseBits(IntNum x, int start, int end) {
        int ival = x.ival;
        int[] xwords = x.words;
        if (xwords == null && end < 63) {
            long w = ival;
            int i = start;
            for (int j = end - 1; i < j; ++i, --j) {
                long biti = w >> i & 1L;
                long bitj = w >> j & 1L;
                w &= (1L << i | 1L << j) ^ -1L;
                w = w | biti << j | bitj << i;
            }
            return IntNum.make(w);
        }
        int[] data = BitOps.dataBufferFor(x, end - 1);
        int i = start;
        for (int j = end - 1; i < j; ++i, --j) {
            int ii = i >> 5;
            int jj = j >> 5;
            int wi = data[ii];
            int biti = wi >> i & 1;
            if (ii == jj) {
                int bitj = wi >> j & 1;
                wi = (int)((long)wi & ((1L << i | 1L << j) ^ -1L));
                wi = wi | biti << j | bitj << i;
            } else {
                int wj = data[jj];
                int bitj = wj >> (j & 31) & 1;
                wi &= ~(1 << (i & 31));
                wj &= ~(1 << (j & 31));
                wi |= bitj << (i & 31);
                data[jj] = wj |= biti << (j & 31);
            }
            data[ii] = wi;
        }
        return IntNum.make(data, data.length);
    }

    public static int shift(int x, int count) {
        if (count >= 32) {
            return 0;
        }
        if (count >= 0) {
            return x << count;
        }
        if ((count = -count) >= 32) {
            return x < 0 ? -1 : 0;
        }
        return x >> count;
    }

    public static int shiftUnsigned(int x, int count) {
        if (count >= 32) {
            return 0;
        }
        if (count >= 0) {
            return x << count;
        }
        return (count = -count) >= 32 ? 0 : x >>> count;
    }

    public static long shift(long x, int count) {
        if (count >= 64) {
            return 0L;
        }
        if (count >= 0) {
            return x << count;
        }
        if ((count = -count) >= 64) {
            return x < 0L ? -1L : 0L;
        }
        return x >> count;
    }

    public static long shiftUnsigned(long x, int count) {
        if (count >= 64) {
            return 0L;
        }
        if (count >= 0) {
            return x << count;
        }
        return (count = -count) >= 64 ? 0L : x >>> count;
    }
}

