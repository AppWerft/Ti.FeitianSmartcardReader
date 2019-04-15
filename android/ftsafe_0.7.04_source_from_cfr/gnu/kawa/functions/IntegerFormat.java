/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.EnglishIntegerFormat;
import gnu.kawa.format.RomanIntegerFormat;
import gnu.math.IntNum;
import gnu.math.RealNum;
import java.text.Format;

public class IntegerFormat
extends gnu.kawa.format.IntegerFormat {
    private static IntegerFormat plainDecimalFormat;

    public static IntegerFormat getInstance() {
        if (plainDecimalFormat == null) {
            plainDecimalFormat = new IntegerFormat();
        }
        return plainDecimalFormat;
    }

    public static Format getInstance(int base2, int minWidth, int padChar, int commaChar, int commaInterval, int flags) {
        if (base2 == -1073741824) {
            if (padChar == -1073741824 && padChar == -1073741824 && commaChar == -1073741824 && commaInterval == -1073741824) {
                boolean seenColon;
                boolean bl = seenColon = (flags & 1) != 0;
                if ((flags & 2) != 0) {
                    return RomanIntegerFormat.getInstance(seenColon);
                }
                return EnglishIntegerFormat.getInstance(seenColon);
            }
            base2 = 10;
        }
        if (minWidth == -1073741824) {
            minWidth = 1;
        }
        if (padChar == -1073741824) {
            padChar = 32;
        }
        if (commaChar == -1073741824) {
            commaChar = 44;
        }
        if (commaInterval == -1073741824) {
            commaInterval = 3;
        }
        if (base2 == 10 && minWidth == 1 && padChar == 32 && commaChar == 44 && commaInterval == 3 && flags == 0) {
            return IntegerFormat.getInstance();
        }
        IntegerFormat fmt = new IntegerFormat();
        fmt.base = base2;
        fmt.minWidth = minWidth;
        fmt.padChar = padChar;
        fmt.commaChar = commaChar;
        fmt.commaInterval = commaInterval;
        fmt.flags = flags;
        return fmt;
    }

    @Override
    public String convertToIntegerString(Object arg, int radix) {
        if (arg instanceof RealNum) {
            return ((RealNum)arg).toExactInt(4).toString(radix);
        }
        return super.convertToIntegerString(arg, radix);
    }
}

