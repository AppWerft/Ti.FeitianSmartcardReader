// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.math.RealNum;
import gnu.kawa.format.EnglishIntegerFormat;
import gnu.kawa.format.RomanIntegerFormat;
import java.text.Format;

public class IntegerFormat extends gnu.kawa.format.IntegerFormat
{
    private static IntegerFormat plainDecimalFormat;
    
    public static IntegerFormat getInstance() {
        if (IntegerFormat.plainDecimalFormat == null) {
            IntegerFormat.plainDecimalFormat = new IntegerFormat();
        }
        return IntegerFormat.plainDecimalFormat;
    }
    
    public static Format getInstance(int base, int minWidth, int padChar, int commaChar, int commaInterval, final int flags) {
        if (base == -1073741824) {
            if (padChar == -1073741824 && padChar == -1073741824 && commaChar == -1073741824 && commaInterval == -1073741824) {
                final boolean seenColon = (flags & 0x1) != 0x0;
                if ((flags & 0x2) != 0x0) {
                    return RomanIntegerFormat.getInstance(seenColon);
                }
                return EnglishIntegerFormat.getInstance(seenColon);
            }
            else {
                base = 10;
            }
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
        if (base == 10 && minWidth == 1 && padChar == 32 && commaChar == 44 && commaInterval == 3 && flags == 0) {
            return getInstance();
        }
        final IntegerFormat fmt = new IntegerFormat();
        fmt.base = base;
        fmt.minWidth = minWidth;
        fmt.padChar = padChar;
        fmt.commaChar = commaChar;
        fmt.commaInterval = commaInterval;
        fmt.flags = flags;
        return fmt;
    }
    
    @Override
    public String convertToIntegerString(final Object arg, final int radix) {
        if (arg instanceof RealNum) {
            return ((RealNum)arg).toExactInt(4).toString(radix);
        }
        return super.convertToIntegerString(arg, radix);
    }
}
