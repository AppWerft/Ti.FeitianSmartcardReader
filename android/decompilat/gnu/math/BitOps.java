// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

public class BitOps
{
    static final byte[] bit4_count;
    
    private BitOps() {
    }
    
    public static boolean bitValue(final IntNum x, final int bitno) {
        final int i = x.ival;
        if (x.words == null) {
            return (bitno >= 32) ? (i < 0) : ((i >> bitno & 0x1) != 0x0);
        }
        final int wordno = bitno >> 5;
        return (wordno >= i) ? (x.words[i - 1] < 0) : ((x.words[wordno] >> bitno & 0x1) != 0x0);
    }
    
    static int[] dataBufferFor(final IntNum x, final int bitno) {
        final int i = x.ival;
        int nwords = bitno + 1 >> 5;
        int[] data;
        if (x.words == null) {
            if (nwords == 0) {
                nwords = 1;
            }
            data = new int[nwords];
            if ((data[0] = i) < 0) {
                for (int j = 1; j < nwords; ++j) {
                    data[j] = -1;
                }
            }
        }
        else {
            nwords = bitno + 1 >> 5;
            data = new int[(nwords > i) ? nwords : i];
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
    
    public static IntNum setBitValue(final IntNum x, final int bitno, int newValue) {
        newValue &= 0x1;
        final int i = x.ival;
        if (x.words == null) {
            final int oldValue = i >> ((bitno < 31) ? bitno : 31) & 0x1;
            if (oldValue == newValue) {
                return x;
            }
            if (bitno < 63) {
                return IntNum.make((long)i ^ (long)(1 << bitno));
            }
        }
        else {
            final int wordno = bitno >> 5;
            int oldValue2;
            if (wordno >= i) {
                oldValue2 = ((x.words[i - 1] < 0) ? 1 : 0);
            }
            else {
                oldValue2 = (x.words[wordno] >> bitno & 0x1);
            }
            if (oldValue2 == newValue) {
                return x;
            }
        }
        final int[] dataBuffer;
        final int[] data = dataBuffer = dataBufferFor(x, bitno);
        final int n = bitno >> 5;
        dataBuffer[n] ^= 1 << (bitno & 0x1F);
        return IntNum.make(data, data.length);
    }
    
    public static boolean test(final IntNum x, final int y) {
        if (x.words == null) {
            return (x.ival & y) != 0x0;
        }
        return y < 0 || (x.words[0] & y) != 0x0;
    }
    
    public static boolean test(IntNum x, IntNum y) {
        if (y.words == null) {
            return test(x, y.ival);
        }
        if (x.words == null) {
            return test(y, x.ival);
        }
        if (x.ival < y.ival) {
            final IntNum temp = x;
            x = y;
            y = temp;
        }
        for (int i = 0; i < y.ival; ++i) {
            if ((x.words[i] & y.words[i]) != 0x0) {
                return true;
            }
        }
        return y.isNegative();
    }
    
    public static IntNum and(final IntNum x, final int y) {
        if (x.words == null) {
            return IntNum.make(x.ival & y);
        }
        if (y >= 0) {
            return IntNum.make(x.words[0] & y);
        }
        int len = x.ival;
        final int[] words = new int[len];
        words[0] = (x.words[0] & y);
        while (--len > 0) {
            words[len] = x.words[len];
        }
        return IntNum.make(words, x.ival);
    }
    
    public static IntNum and(IntNum x, IntNum y) {
        if (y.words == null) {
            return and(x, y.ival);
        }
        if (x.words == null) {
            return and(y, x.ival);
        }
        if (x.ival < y.ival) {
            final IntNum temp = x;
            x = y;
            y = temp;
        }
        final int len = y.isNegative() ? x.ival : y.ival;
        final int[] words = new int[len];
        int i;
        for (i = 0; i < y.ival; ++i) {
            words[i] = (x.words[i] & y.words[i]);
        }
        while (i < len) {
            words[i] = x.words[i];
            ++i;
        }
        return IntNum.make(words, len);
    }
    
    public static IntNum ior(final IntNum x, final IntNum y) {
        return bitOp(7, x, y);
    }
    
    public static IntNum xor(final IntNum x, final IntNum y) {
        return bitOp(6, x, y);
    }
    
    public static IntNum not(final IntNum x) {
        return bitOp(12, x, IntNum.zero());
    }
    
    public static int swappedOp(final int op) {
        return "\u0000\u0001\u0004\u0005\u0002\u0003\u0006\u0007\b\t\f\r\n\u000b\u000e\u000f".charAt(op);
    }
    
    public static IntNum bitOp(final int op, final IntNum x, final IntNum y) {
        switch (op) {
            case 0: {
                return IntNum.zero();
            }
            case 1: {
                return and(x, y);
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
            default: {
                final IntNum result = new IntNum();
                setBitOp(result, op, x, y);
                return result.canonicalize();
            }
        }
    }
    
    public static void setBitOp(final IntNum result, int op, IntNum x, IntNum y) {
        if (y.words != null) {
            if (x.words == null || x.ival < y.ival) {
                final IntNum temp = x;
                x = y;
                y = temp;
                op = swappedOp(op);
            }
        }
        int yi;
        int ylen;
        if (y.words == null) {
            yi = y.ival;
            ylen = 1;
        }
        else {
            yi = y.words[0];
            ylen = y.ival;
        }
        int xi;
        int xlen;
        if (x.words == null) {
            xi = x.ival;
            xlen = 1;
        }
        else {
            xi = x.words[0];
            xlen = x.ival;
        }
        if (xlen > 1) {
            result.realloc(xlen);
        }
        final int[] w = result.words;
        int i = 0;
        int finish = 0;
        int ni = 0;
        switch (op) {
            case 0: {
                ni = 0;
                break;
            }
            case 1: {
                while (true) {
                    ni = (xi & yi);
                    if (i + 1 >= ylen) {
                        break;
                    }
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                }
                if (yi < 0) {
                    finish = 1;
                    break;
                }
                break;
            }
            case 2: {
                while (true) {
                    ni = (xi & ~yi);
                    if (i + 1 >= ylen) {
                        break;
                    }
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                }
                if (yi >= 0) {
                    finish = 1;
                    break;
                }
                break;
            }
            case 3: {
                ni = xi;
                finish = 1;
                break;
            }
            case 4: {
                while (true) {
                    ni = (~xi & yi);
                    if (i + 1 >= ylen) {
                        break;
                    }
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                }
                if (yi < 0) {
                    finish = 2;
                    break;
                }
                break;
            }
            case 5: {
                while (true) {
                    ni = yi;
                    if (i + 1 >= ylen) {
                        break;
                    }
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                }
                break;
            }
            case 6: {
                while (true) {
                    ni = (xi ^ yi);
                    if (i + 1 >= ylen) {
                        break;
                    }
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                }
                finish = ((yi < 0) ? 2 : 1);
                break;
            }
            case 7: {
                while (true) {
                    ni = (xi | yi);
                    if (i + 1 >= ylen) {
                        break;
                    }
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                }
                if (yi >= 0) {
                    finish = 1;
                    break;
                }
                break;
            }
            case 8: {
                while (true) {
                    ni = ~(xi | yi);
                    if (i + 1 >= ylen) {
                        break;
                    }
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                }
                if (yi >= 0) {
                    finish = 2;
                    break;
                }
                break;
            }
            case 9: {
                while (true) {
                    ni = ~(xi ^ yi);
                    if (i + 1 >= ylen) {
                        break;
                    }
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                }
                finish = ((yi >= 0) ? 2 : 1);
                break;
            }
            case 10: {
                while (true) {
                    ni = ~yi;
                    if (i + 1 >= ylen) {
                        break;
                    }
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                }
                break;
            }
            case 11: {
                while (true) {
                    ni = (xi | ~yi);
                    if (i + 1 >= ylen) {
                        break;
                    }
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                }
                if (yi < 0) {
                    finish = 1;
                    break;
                }
                break;
            }
            case 12: {
                ni = ~xi;
                finish = 2;
                break;
            }
            case 13: {
                while (true) {
                    ni = (~xi | yi);
                    if (i + 1 >= ylen) {
                        break;
                    }
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                }
                if (yi >= 0) {
                    finish = 2;
                    break;
                }
                break;
            }
            case 14: {
                while (true) {
                    ni = ~(xi & yi);
                    if (i + 1 >= ylen) {
                        break;
                    }
                    w[i++] = ni;
                    xi = x.words[i];
                    yi = y.words[i];
                }
                if (yi < 0) {
                    finish = 2;
                    break;
                }
                break;
            }
            default: {
                ni = -1;
                break;
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
    
    public static IntNum makeMask(final int startBit, final int endBit) {
        final int width = endBit - startBit;
        if (width <= 0) {
            return IntNum.zero();
        }
        if (endBit < 64) {
            return IntNum.make(~(-1L << width) << startBit);
        }
        final int len = (endBit >> 5) + 1;
        final int[] buf = new int[len];
        final int startWord = startBit >> 5;
        int i = width >> 5;
        buf[i] = ~(-1 << (width & 0x1F));
        while (--i >= 0) {
            buf[i] = -1;
        }
        MPN.lshift(buf, startWord, buf, len - startWord, startBit & 0x1F);
        i = startWord;
        while (--i >= 0) {
            buf[i] = 0;
        }
        return IntNum.make(buf, len);
    }
    
    public static IntNum extract(final IntNum x, int startBit, int endBit) {
        if (endBit < 32) {
            final int word0 = (x.words == null) ? x.ival : x.words[0];
            return IntNum.make((word0 & ~(-1 << endBit)) >> startBit);
        }
        int x_len;
        if (x.words == null) {
            if (x.ival >= 0) {
                return IntNum.make((startBit >= 31) ? 0 : (x.ival >> startBit));
            }
            x_len = 1;
        }
        else {
            x_len = x.ival;
        }
        final boolean neg = x.isNegative();
        if (endBit > 32 * x_len) {
            endBit = 32 * x_len;
            if (!neg && startBit == 0) {
                return x;
            }
        }
        else {
            x_len = endBit + 31 >> 5;
        }
        final int length = endBit - startBit;
        if (length < 64) {
            long l;
            if (x.words == null) {
                l = x.ival >> ((startBit >= 32) ? 31 : startBit);
            }
            else {
                l = MPN.rshift_long(x.words, x_len, startBit);
            }
            return IntNum.make(l & ~(-1L << length));
        }
        final int startWord = startBit >> 5;
        final int buf_len = (endBit >> 5) + 1 - startWord;
        final int[] buf = new int[buf_len];
        if (x.words == null) {
            buf[0] = ((startBit >= 32) ? -1 : (x.ival >> startBit));
        }
        else {
            x_len -= startWord;
            startBit &= 0x1F;
            MPN.rshift0(buf, x.words, startWord, x_len, startBit);
        }
        x_len = length >> 5;
        final int[] array = buf;
        final int n = x_len;
        array[n] &= ~(-1 << length);
        return IntNum.make(buf, x_len + 1);
    }
    
    public static int lowestBitSet(int i) {
        if (i == 0) {
            return -1;
        }
        int index;
        for (index = 0; (i & 0xFF) == 0x0; i >>>= 8, index += 8) {}
        while ((i & 0x3) == 0x0) {
            i >>>= 2;
            index += 2;
        }
        if ((i & 0x1) == 0x0) {
            ++index;
        }
        return index;
    }
    
    public static int lowestBitSet(final IntNum x) {
        final int[] x_words = x.words;
        if (x_words == null) {
            return lowestBitSet(x.ival);
        }
        final int x_len = x.ival;
        final int i = 0;
        while (i < x_len) {
            final int b = lowestBitSet(x_words[i]);
            if (b >= 0) {
                return 32 * i + b;
            }
        }
        return -1;
    }
    
    public static int bitCount(int i) {
        int count = 0;
        while (i != 0) {
            count += BitOps.bit4_count[i & 0xF];
            i >>>= 4;
        }
        return count;
    }
    
    public static int bitCount(final int[] x, int len) {
        int count = 0;
        while (--len >= 0) {
            count += bitCount(x[len]);
        }
        return count;
    }
    
    public static int bitCount(final IntNum x) {
        final int[] x_words = x.words;
        int x_len;
        int i;
        if (x_words == null) {
            x_len = 1;
            i = bitCount(x.ival);
        }
        else {
            x_len = x.ival;
            i = bitCount(x_words, x_len);
        }
        return x.isNegative() ? (x_len * 32 - i) : i;
    }
    
    public static IntNum reverseBits(final IntNum x, final int start, final int end) {
        final int ival = x.ival;
        final int[] xwords = x.words;
        if (xwords == null && end < 63) {
            long w = ival;
            for (int i = start, j = end - 1; i < j; ++i, --j) {
                final long biti = w >> i & 0x1L;
                final long bitj = w >> j & 0x1L;
                w &= ~(1L << i | 1L << j);
                w = (w | biti << j | bitj << i);
            }
            return IntNum.make(w);
        }
        final int[] data = dataBufferFor(x, end - 1);
        for (int k = start, l = end - 1; k < l; ++k, --l) {
            final int ii = k >> 5;
            final int jj = l >> 5;
            int wi = data[ii];
            final int biti2 = wi >> k & 0x1;
            if (ii == jj) {
                final int bitj2 = wi >> l & 0x1;
                wi = (int)((long)wi & ~(1L << k | 1L << l));
                wi = (wi | biti2 << l | bitj2 << k);
            }
            else {
                int wj = data[jj];
                final int bitj3 = wj >> (l & 0x1F) & 0x1;
                wi &= ~(1 << (k & 0x1F));
                wj &= ~(1 << (l & 0x1F));
                wi |= bitj3 << (k & 0x1F);
                wj |= biti2 << (l & 0x1F);
                data[jj] = wj;
            }
            data[ii] = wi;
        }
        return IntNum.make(data, data.length);
    }
    
    public static int shift(final int x, int count) {
        if (count >= 32) {
            return 0;
        }
        if (count >= 0) {
            return x << count;
        }
        count = -count;
        if (count >= 32) {
            return (x < 0) ? -1 : 0;
        }
        return x >> count;
    }
    
    public static int shiftUnsigned(final int x, int count) {
        if (count >= 32) {
            return 0;
        }
        if (count >= 0) {
            return x << count;
        }
        count = -count;
        return (count >= 32) ? 0 : (x >>> count);
    }
    
    public static long shift(final long x, int count) {
        if (count >= 64) {
            return 0L;
        }
        if (count >= 0) {
            return x << count;
        }
        count = -count;
        if (count >= 64) {
            return (x < 0L) ? -1L : 0L;
        }
        return x >> count;
    }
    
    public static long shiftUnsigned(final long x, int count) {
        if (count >= 64) {
            return 0L;
        }
        if (count >= 0) {
            return x << count;
        }
        count = -count;
        return (count >= 64) ? 0L : (x >>> count);
    }
    
    static {
        bit4_count = new byte[] { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
    }
}
