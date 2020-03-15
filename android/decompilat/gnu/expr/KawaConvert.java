// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.mapping.Lazy;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.lists.Convert;

public class KawaConvert extends Convert
{
    public static Convert instance;
    
    public static Convert getInstance() {
        return KawaConvert.instance;
    }
    
    public static void setInstance(final Convert value) {
        KawaConvert.instance = value;
    }
    
    @Override
    public Object charToObject(final char ch) {
        return Char.make(ch);
    }
    
    @Override
    public char objectToChar(final Object obj) {
        return ((Char)obj).charValue();
    }
    
    @Override
    public Object byteToObject(final byte value) {
        return IntNum.valueOf(value);
    }
    
    @Override
    public Object shortToObject(final short value) {
        return IntNum.valueOf(value);
    }
    
    @Override
    public Object intToObject(final int value) {
        return IntNum.valueOf(value);
    }
    
    @Override
    public Object longToObject(final long value) {
        return IntNum.valueOf(value);
    }
    
    @Override
    public Object byteToObjectUnsigned(final byte value) {
        return IntNum.valueOf(value & 0xFF);
    }
    
    @Override
    public Object shortToObjectUnsigned(final short value) {
        return IntNum.valueOf(value & 0xFFFF);
    }
    
    @Override
    public Object intToObjectUnsigned(final int value) {
        return IntNum.valueOf((long)value & 0xFFFFFFFFL);
    }
    
    @Override
    public Object longToObjectUnsigned(final long value) {
        return IntNum.valueOfUnsigned(value);
    }
    
    @Override
    public Object floatToObject(final float value) {
        return DFloNum.valueOf(value);
    }
    
    @Override
    public Object doubleToObject(final double value) {
        return DFloNum.valueOf(value);
    }
    
    public static boolean isTrue(Object value) {
        while (!(value instanceof Boolean)) {
            if (value == null) {
                return false;
            }
            if (!(value instanceof Lazy)) {
                return true;
            }
            value = ((Lazy)value).getValue();
        }
        return (boolean)value;
    }
    
    static {
        KawaConvert.instance = new KawaConvert();
    }
}
