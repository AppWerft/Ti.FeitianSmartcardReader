// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.math.RealNum;
import gnu.kawa.functions.Arithmetic;
import java.math.BigDecimal;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import gnu.math.IntNum;

public class XIntegerType extends XDataType
{
    public final IntNum minValue;
    public final IntNum maxValue;
    static ClassType typeIntNum;
    boolean isUnsignedType;
    public static final XIntegerType integerType;
    public static final XIntegerType longType;
    public static final XIntegerType intType;
    public static final XIntegerType shortType;
    public static final XIntegerType byteType;
    public static final XIntegerType nonPositiveIntegerType;
    public static final XIntegerType negativeIntegerType;
    public static final XIntegerType nonNegativeIntegerType;
    public static final XIntegerType unsignedLongType;
    public static final XIntegerType unsignedIntType;
    public static final XIntegerType unsignedShortType;
    public static final XIntegerType unsignedByteType;
    public static final XIntegerType positiveIntegerType;
    
    public boolean isUnsignedType() {
        return this.isUnsignedType;
    }
    
    public XIntegerType(final String name, final XDataType base, final int typeCode, final IntNum min, final IntNum max) {
        this((Object)name, base, typeCode, min, max);
        this.isUnsignedType = name.startsWith("unsigned");
    }
    
    public XIntegerType(final Object name, final XDataType base, final int typeCode, final IntNum min, final IntNum max) {
        super(name, XIntegerType.typeIntNum, typeCode);
        this.minValue = min;
        this.maxValue = max;
        this.baseType = base;
    }
    
    @Override
    public boolean isInstance(final Object obj) {
        if (!(obj instanceof IntNum)) {
            return false;
        }
        if (this == XIntegerType.integerType) {
            return true;
        }
        for (XDataType objType = (obj instanceof XInteger) ? ((XInteger)obj).getIntegerType() : XIntegerType.integerType; objType != null; objType = objType.baseType) {
            if (objType == this) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Object coerceFromObject(final Object obj) {
        final IntNum ival = IntNum.asIntNumOrNull(obj);
        if (ival == null) {
            throw new ClassCastException("cannot cast " + obj + " to " + this.name);
        }
        return this.valueOf(ival);
    }
    
    public IntNum valueOf(final IntNum value) {
        if (this == XIntegerType.integerType) {
            return value;
        }
        if ((this.minValue != null && IntNum.compare(value, this.minValue) < 0) || (this.maxValue != null && IntNum.compare(value, this.maxValue) > 0)) {
            throw new ClassCastException("cannot cast " + value + " to " + this.name);
        }
        return new XInteger(value, this);
    }
    
    @Override
    public Object cast(final Object value) {
        if (value instanceof Boolean) {
            return this.valueOf(((boolean)value) ? IntNum.one() : IntNum.zero());
        }
        if (value instanceof IntNum) {
            return this.valueOf((IntNum)value);
        }
        if (value instanceof BigDecimal) {
            return this.valueOf(Arithmetic.asIntNum((BigDecimal)value));
        }
        if (value instanceof RealNum) {
            return this.valueOf(((RealNum)value).toExactInt(3));
        }
        if (RealNum.isReal(value)) {
            return this.valueOf(RealNum.toExactInt(((Number)value).doubleValue(), 3));
        }
        return super.cast(value);
    }
    
    @Override
    public Object valueOf(final String value) {
        return this.valueOf(IntNum.valueOf(value.trim(), 10));
    }
    
    public IntNum valueOf(final String value, final int radix) {
        return this.valueOf(IntNum.valueOf(value.trim(), radix));
    }
    
    static {
        XIntegerType.typeIntNum = ClassType.make("gnu.math.IntNum");
        integerType = new XIntegerType("integer", XIntegerType.decimalType, 5, null, null);
        longType = new XIntegerType("long", XIntegerType.integerType, 8, IntNum.make(Long.MIN_VALUE), IntNum.make(Long.MAX_VALUE));
        intType = new XIntegerType("int", XIntegerType.longType, 9, IntNum.make(Integer.MIN_VALUE), IntNum.make(Integer.MAX_VALUE));
        shortType = new XIntegerType("short", XIntegerType.intType, 10, IntNum.make(-32768), IntNum.make(32767));
        byteType = new XIntegerType("byte", XIntegerType.shortType, 11, IntNum.make(-128), IntNum.make(127));
        nonPositiveIntegerType = new XIntegerType("nonPositiveInteger", XIntegerType.integerType, 6, null, IntNum.zero());
        negativeIntegerType = new XIntegerType("negativeInteger", XIntegerType.nonPositiveIntegerType, 7, null, IntNum.minusOne());
        nonNegativeIntegerType = new XIntegerType("nonNegativeInteger", XIntegerType.integerType, 12, IntNum.zero(), null);
        unsignedLongType = new XIntegerType("unsignedLong", XIntegerType.nonNegativeIntegerType, 13, IntNum.zero(), IntNum.valueOf("18446744073709551615"));
        unsignedIntType = new XIntegerType("unsignedInt", XIntegerType.unsignedLongType, 14, IntNum.zero(), IntNum.make(4294967295L));
        unsignedShortType = new XIntegerType("unsignedShort", XIntegerType.unsignedIntType, 15, IntNum.zero(), IntNum.make(65535));
        unsignedByteType = new XIntegerType("unsignedByte", XIntegerType.unsignedShortType, 16, IntNum.zero(), IntNum.make(255));
        positiveIntegerType = new XIntegerType("positiveInteger", XIntegerType.nonNegativeIntegerType, 17, IntNum.one(), null);
    }
}
