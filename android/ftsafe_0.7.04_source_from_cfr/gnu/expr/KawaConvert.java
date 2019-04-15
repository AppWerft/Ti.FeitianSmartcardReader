/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.lists.Convert;
import gnu.mapping.Lazy;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.text.Char;

public class KawaConvert
extends Convert {
    public static Convert instance = new KawaConvert();

    public static Convert getInstance() {
        return instance;
    }

    public static void setInstance(Convert value) {
        instance = value;
    }

    @Override
    public Object charToObject(char ch) {
        return Char.make(ch);
    }

    @Override
    public char objectToChar(Object obj) {
        return ((Char)obj).charValue();
    }

    @Override
    public Object byteToObject(byte value) {
        return IntNum.valueOf(value);
    }

    @Override
    public Object shortToObject(short value) {
        return IntNum.valueOf(value);
    }

    @Override
    public Object intToObject(int value) {
        return IntNum.valueOf(value);
    }

    @Override
    public Object longToObject(long value) {
        return IntNum.valueOf(value);
    }

    @Override
    public Object byteToObjectUnsigned(byte value) {
        return IntNum.valueOf(value & 255);
    }

    @Override
    public Object shortToObjectUnsigned(short value) {
        return IntNum.valueOf(value & 65535);
    }

    @Override
    public Object intToObjectUnsigned(int value) {
        return IntNum.valueOf((long)value & 0xFFFFFFFFL);
    }

    @Override
    public Object longToObjectUnsigned(long value) {
        return IntNum.valueOfUnsigned(value);
    }

    @Override
    public Object floatToObject(float value) {
        return DFloNum.valueOf(value);
    }

    @Override
    public Object doubleToObject(double value) {
        return DFloNum.valueOf(value);
    }

    public static boolean isTrue(Object value) {
        do {
            if (value instanceof Boolean) {
                return (Boolean)value;
            }
            if (value == null) {
                return false;
            }
            if (!(value instanceof Lazy)) break;
            value = ((Lazy)value).getValue();
        } while (true);
        return true;
    }
}

