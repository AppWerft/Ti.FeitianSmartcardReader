// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class Convert
{
    public static Convert instance;
    
    public static Convert getInstance() {
        return Convert.instance;
    }
    
    public static void setInstance(final Convert value) {
        Convert.instance = value;
    }
    
    public Object booleanToObject(final boolean value) {
        return value ? Boolean.TRUE : Boolean.FALSE;
    }
    
    public boolean objectToBoolean(final Object obj) {
        return !(obj instanceof Boolean) || (boolean)obj;
    }
    
    public static Object toObject(final boolean value) {
        return Convert.instance.booleanToObject(value);
    }
    
    public static boolean toBoolean(final Object obj) {
        return Convert.instance.objectToBoolean(obj);
    }
    
    public Object charToObject(final char ch) {
        return new Character(ch);
    }
    
    public char objectToChar(final Object obj) {
        return (char)obj;
    }
    
    public static Object toObject(final char ch) {
        return Convert.instance.charToObject(ch);
    }
    
    public static char toChar(final Object obj) {
        return Convert.instance.objectToChar(obj);
    }
    
    public Object byteToObject(final byte value) {
        return new Byte(value);
    }
    
    public byte objectToByte(final Object obj) {
        return ((Number)obj).byteValue();
    }
    
    public static Object toObject(final byte value) {
        return Convert.instance.byteToObject(value);
    }
    
    public static byte toByte(final Object obj) {
        return Convert.instance.objectToByte(obj);
    }
    
    public Object byteToObjectUnsigned(final byte value) {
        return new Integer(value & 0xFF);
    }
    
    public byte objectToByteUnsigned(final Object obj) {
        return ((Number)obj).byteValue();
    }
    
    public static Object toObjectUnsigned(final byte value) {
        return Convert.instance.byteToObjectUnsigned(value);
    }
    
    public static byte toByteUnsigned(final Object obj) {
        return Convert.instance.objectToByteUnsigned(obj);
    }
    
    public Object shortToObject(final short value) {
        return new Short(value);
    }
    
    public short objectToShort(final Object obj) {
        return ((Number)obj).shortValue();
    }
    
    public static Object toObject(final short value) {
        return Convert.instance.shortToObject(value);
    }
    
    public static short toShort(final Object obj) {
        return Convert.instance.objectToShort(obj);
    }
    
    public Object shortToObjectUnsigned(final short value) {
        return new Integer(value & 0xFFFF);
    }
    
    public short objectToShortUnsigned(final Object obj) {
        return ((Number)obj).shortValue();
    }
    
    public static Object toObjectUnsigned(final short value) {
        return Convert.instance.shortToObjectUnsigned(value);
    }
    
    public static short toShortUnsigned(final Object obj) {
        return Convert.instance.objectToShortUnsigned(obj);
    }
    
    public Object intToObject(final int value) {
        return new Integer(value);
    }
    
    public int objectToInt(final Object obj) {
        return ((Number)obj).intValue();
    }
    
    public static Object toObject(final int value) {
        return Convert.instance.intToObject(value);
    }
    
    public static int toInt(final Object obj) {
        return Convert.instance.objectToInt(obj);
    }
    
    public Object intToObjectUnsigned(final int value) {
        if (value >= 0) {
            return new Integer(value);
        }
        return new Long((long)value & 0xFFFFFFFFL);
    }
    
    public int objectToIntUnsigned(final Object obj) {
        return ((Number)obj).intValue();
    }
    
    public static Object toObjectUnsigned(final int value) {
        return Convert.instance.intToObjectUnsigned(value);
    }
    
    public static int toIntUnsigned(final Object obj) {
        return Convert.instance.objectToIntUnsigned(obj);
    }
    
    public Object longToObject(final long value) {
        return new Long(value);
    }
    
    public long objectToLong(final Object obj) {
        return ((Number)obj).longValue();
    }
    
    public static Object toObject(final long value) {
        return Convert.instance.longToObject(value);
    }
    
    public static long toLong(final Object obj) {
        return Convert.instance.objectToLong(obj);
    }
    
    public Object longToObjectUnsigned(final long value) {
        return new Long(value);
    }
    
    public long objectToLongUnsigned(final Object obj) {
        return ((Number)obj).longValue();
    }
    
    public static Object toObjectUnsigned(final long value) {
        return Convert.instance.longToObjectUnsigned(value);
    }
    
    public static long toLongUnsigned(final Object obj) {
        return Convert.instance.objectToLongUnsigned(obj);
    }
    
    public Object floatToObject(final float value) {
        return new Float(value);
    }
    
    public float objectToFloat(final Object obj) {
        return ((Number)obj).floatValue();
    }
    
    public static Object toObject(final float value) {
        return Convert.instance.floatToObject(value);
    }
    
    public static float toFloat(final Object obj) {
        return Convert.instance.objectToFloat(obj);
    }
    
    public Object doubleToObject(final double value) {
        return new Double(value);
    }
    
    public double objectToDouble(final Object obj) {
        return ((Number)obj).doubleValue();
    }
    
    public static Object toObject(final double value) {
        return Convert.instance.doubleToObject(value);
    }
    
    public static double toDouble(final Object obj) {
        return Convert.instance.objectToDouble(obj);
    }
    
    public static double parseDouble(final String str) {
        return Double.parseDouble(str);
    }
    
    static {
        Convert.instance = new Convert();
    }
}
