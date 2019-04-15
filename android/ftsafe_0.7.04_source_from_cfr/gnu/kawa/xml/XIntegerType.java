/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.xml.XDataType;
import gnu.kawa.xml.XInteger;
import gnu.math.IntNum;
import gnu.math.RealNum;
import java.math.BigDecimal;

public class XIntegerType
extends XDataType {
    public final IntNum minValue;
    public final IntNum maxValue;
    static ClassType typeIntNum = ClassType.make("gnu.math.IntNum");
    boolean isUnsignedType;
    public static final XIntegerType integerType = new XIntegerType("integer", decimalType, 5, null, null);
    public static final XIntegerType longType = new XIntegerType("long", (XDataType)integerType, 8, IntNum.make(Long.MIN_VALUE), IntNum.make(Long.MAX_VALUE));
    public static final XIntegerType intType = new XIntegerType("int", (XDataType)longType, 9, IntNum.make(Integer.MIN_VALUE), IntNum.make(Integer.MAX_VALUE));
    public static final XIntegerType shortType = new XIntegerType("short", (XDataType)intType, 10, IntNum.make(-32768), IntNum.make(32767));
    public static final XIntegerType byteType = new XIntegerType("byte", (XDataType)shortType, 11, IntNum.make(-128), IntNum.make(127));
    public static final XIntegerType nonPositiveIntegerType = new XIntegerType("nonPositiveInteger", (XDataType)integerType, 6, null, IntNum.zero());
    public static final XIntegerType negativeIntegerType = new XIntegerType("negativeInteger", (XDataType)nonPositiveIntegerType, 7, null, IntNum.minusOne());
    public static final XIntegerType nonNegativeIntegerType = new XIntegerType("nonNegativeInteger", (XDataType)integerType, 12, IntNum.zero(), null);
    public static final XIntegerType unsignedLongType = new XIntegerType("unsignedLong", (XDataType)nonNegativeIntegerType, 13, IntNum.zero(), IntNum.valueOf("18446744073709551615"));
    public static final XIntegerType unsignedIntType = new XIntegerType("unsignedInt", (XDataType)unsignedLongType, 14, IntNum.zero(), IntNum.make(0xFFFFFFFFL));
    public static final XIntegerType unsignedShortType = new XIntegerType("unsignedShort", (XDataType)unsignedIntType, 15, IntNum.zero(), IntNum.make(65535));
    public static final XIntegerType unsignedByteType = new XIntegerType("unsignedByte", (XDataType)unsignedShortType, 16, IntNum.zero(), IntNum.make(255));
    public static final XIntegerType positiveIntegerType = new XIntegerType("positiveInteger", (XDataType)nonNegativeIntegerType, 17, IntNum.one(), null);

    public boolean isUnsignedType() {
        return this.isUnsignedType;
    }

    public XIntegerType(String name, XDataType base2, int typeCode, IntNum min, IntNum max) {
        this((Object)name, base2, typeCode, min, max);
        this.isUnsignedType = name.startsWith("unsigned");
    }

    public XIntegerType(Object name, XDataType base2, int typeCode, IntNum min, IntNum max) {
        super(name, typeIntNum, typeCode);
        this.minValue = min;
        this.maxValue = max;
        this.baseType = base2;
    }

    @Override
    public boolean isInstance(Object obj) {
        XDataType objType;
        if (!(obj instanceof IntNum)) {
            return false;
        }
        if (this == integerType) {
            return true;
        }
        XIntegerType xIntegerType = objType = obj instanceof XInteger ? ((XInteger)obj).getIntegerType() : integerType;
        while (objType != null) {
            if (objType == this) {
                return true;
            }
            objType = objType.baseType;
        }
        return false;
    }

    @Override
    public Object coerceFromObject(Object obj) {
        IntNum ival = IntNum.asIntNumOrNull(obj);
        if (ival == null) {
            throw new ClassCastException("cannot cast " + obj + " to " + this.name);
        }
        return this.valueOf(ival);
    }

    public IntNum valueOf(IntNum value) {
        if (this != integerType) {
            if (this.minValue != null && IntNum.compare(value, this.minValue) < 0 || this.maxValue != null && IntNum.compare(value, this.maxValue) > 0) {
                throw new ClassCastException("cannot cast " + value + " to " + this.name);
            }
            return new XInteger(value, this);
        }
        return value;
    }

    @Override
    public Object cast(Object value) {
        if (value instanceof Boolean) {
            return this.valueOf((Boolean)value != false ? IntNum.one() : IntNum.zero());
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
    public Object valueOf(String value) {
        return this.valueOf(IntNum.valueOf(value.trim(), 10));
    }

    public IntNum valueOf(String value, int radix) {
        return this.valueOf(IntNum.valueOf(value.trim(), radix));
    }
}

