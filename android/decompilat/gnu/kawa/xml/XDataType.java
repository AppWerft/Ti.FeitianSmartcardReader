// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.mapping.Procedure;
import gnu.expr.Language;
import gnu.math.DateTime;
import gnu.math.RealNum;
import gnu.kawa.io.URIPath;
import gnu.xml.TextUtils;
import gnu.kawa.format.Printable;
import gnu.lists.Consumer;
import gnu.kawa.reflect.InstanceOf;
import gnu.math.Unit;
import gnu.math.Duration;
import gnu.math.IntNum;
import gnu.kawa.io.Path;
import gnu.mapping.Values;
import gnu.lists.SeqPosition;
import gnu.expr.Expression;
import gnu.expr.Declaration;
import gnu.bytecode.Variable;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.bytecode.CodeAttr;
import java.math.BigDecimal;
import gnu.expr.TypeValue;
import gnu.bytecode.Type;

public class XDataType extends Type implements TypeValue
{
    Type implementationType;
    Object name;
    XDataType baseType;
    int typeCode;
    public static final int ANY_SIMPLE_TYPE_CODE = 2;
    public static final int ANY_ATOMIC_TYPE_CODE = 3;
    public static final int DECIMAL_TYPE_CODE = 4;
    public static final int INTEGER_TYPE_CODE = 5;
    public static final int NON_POSITIVE_INTEGER_TYPE_CODE = 6;
    public static final int NEGATIVE_INTEGER_TYPE_CODE = 7;
    public static final int LONG_TYPE_CODE = 8;
    public static final int INT_TYPE_CODE = 9;
    public static final int SHORT_TYPE_CODE = 10;
    public static final int BYTE_TYPE_CODE = 11;
    public static final int NONNEGATIVE_INTEGER_TYPE_CODE = 12;
    public static final int UNSIGNED_LONG_TYPE_CODE = 13;
    public static final int UNSIGNED_INT_TYPE_CODE = 14;
    public static final int UNSIGNED_SHORT_TYPE_CODE = 15;
    public static final int UNSIGNED_BYTE_TYPE_CODE = 16;
    public static final int POSITIVE_INTEGER_TYPE_CODE = 17;
    public static final int FLOAT_TYPE_CODE = 18;
    public static final int DOUBLE_TYPE_CODE = 19;
    public static final int DATE_TIME_TYPE_CODE = 20;
    public static final int DATE_TYPE_CODE = 21;
    public static final int TIME_TYPE_CODE = 22;
    public static final int G_YEAR_MONTH_TYPE_CODE = 23;
    public static final int G_YEAR_TYPE_CODE = 24;
    public static final int G_MONTH_DAY_TYPE_CODE = 25;
    public static final int G_DAY_TYPE_CODE = 26;
    public static final int G_MONTH_TYPE_CODE = 27;
    public static final int DURATION_TYPE_CODE = 28;
    public static final int YEAR_MONTH_DURATION_TYPE_CODE = 29;
    public static final int DAY_TIME_DURATION_TYPE_CODE = 30;
    public static final int BOOLEAN_TYPE_CODE = 31;
    public static final int QNAME_TYPE_CODE = 32;
    public static final int ANY_URI_TYPE_CODE = 33;
    public static final int BASE64_BINARY_TYPE_CODE = 34;
    public static final int HEX_BINARY_TYPE_CODE = 35;
    public static final int NOTATION_TYPE_CODE = 36;
    public static final int UNTYPED_ATOMIC_TYPE_CODE = 37;
    public static final int STRING_TYPE_CODE = 38;
    public static final int NORMALIZED_STRING_TYPE_CODE = 39;
    public static final int TOKEN_TYPE_CODE = 40;
    public static final int LANGUAGE_TYPE_CODE = 41;
    public static final int NMTOKEN_TYPE_CODE = 42;
    public static final int NAME_TYPE_CODE = 43;
    public static final int NCNAME_TYPE_CODE = 44;
    public static final int ID_TYPE_CODE = 45;
    public static final int IDREF_TYPE_CODE = 46;
    public static final int ENTITY_TYPE_CODE = 47;
    public static final int UNTYPED_TYPE_CODE = 48;
    public static final XDataType anySimpleType;
    public static final XDataType anyAtomicType;
    public static final XDataType stringType;
    public static final XDataType stringStringType;
    public static final XDataType untypedAtomicType;
    public static final XDataType base64BinaryType;
    public static final XDataType hexBinaryType;
    public static final XDataType booleanType;
    public static final XDataType anyURIType;
    public static final XDataType NotationType;
    public static final XDataType decimalType;
    public static final XDataType floatType;
    public static final XDataType doubleType;
    public static final XDataType durationType;
    public static final XDataType yearMonthDurationType;
    public static final XDataType dayTimeDurationType;
    public static final XDataType untypedType;
    public static final Double DOUBLE_ZERO;
    public static final Double DOUBLE_ONE;
    public static final Float FLOAT_ZERO;
    public static final Float FLOAT_ONE;
    public static final BigDecimal DECIMAL_ONE;
    
    public XDataType(final Object name, final Type implementationType, final int typeCode) {
        super(implementationType);
        this.name = name;
        if (name != null) {
            this.setName(name.toString());
        }
        this.implementationType = implementationType;
        this.typeCode = typeCode;
    }
    
    @Override
    public Class getReflectClass() {
        return this.implementationType.getReflectClass();
    }
    
    @Override
    public Type getImplementationType() {
        return this.implementationType;
    }
    
    @Override
    public void emitCoerceFromObject(final CodeAttr code) {
        final Compilation comp = Compilation.getCurrent();
        comp.compileConstant(this, Target.pushObject);
        final Method meth = ClassType.make("gnu.kawa.xml.XDataType").getDeclaredMethod("coerceFromObject", 1);
        code.emitSwap();
        code.emitInvokeVirtual(meth);
        this.implementationType.emitCoerceFromObject(code);
    }
    
    @Override
    public void emitCoerceToObject(final CodeAttr code) {
        if (this.typeCode == 31) {
            this.implementationType.emitCoerceToObject(code);
        }
        else {
            super.emitCoerceToObject(code);
        }
    }
    
    @Override
    public void emitTestIf(final Variable incoming, final Declaration decl, final Compilation comp) {
        final CodeAttr code = comp.getCode();
        if (this.typeCode == 31) {
            if (incoming != null) {
                code.emitLoad(incoming);
            }
            Type.javalangBooleanType.emitIsInstance(code);
            code.emitIfIntNotZero();
            if (decl != null) {
                code.emitLoad(incoming);
                Type.booleanType.emitCoerceFromObject(code);
                decl.compileStore(comp);
            }
            return;
        }
        comp.compileConstant(this, Target.pushObject);
        if (incoming == null) {
            code.emitSwap();
        }
        else {
            code.emitLoad(incoming);
        }
        code.emitInvokeVirtual(Compilation.typeType.getDeclaredMethod("isInstance", 1));
        code.emitIfIntNotZero();
        if (decl != null) {
            code.emitLoad(incoming);
            this.emitCoerceFromObject(code);
            decl.compileStore(comp);
        }
    }
    
    @Override
    public Expression convertValue(final Expression value) {
        return null;
    }
    
    @Override
    public boolean isInstance(final Object obj) {
        switch (this.typeCode) {
            case 48: {
                return true;
            }
            case 2: {
                return !(obj instanceof SeqPosition) && !(obj instanceof Nodes);
            }
            case 3: {
                return !(obj instanceof Values) && !(obj instanceof SeqPosition);
            }
            case 38: {
                return obj instanceof CharSequence;
            }
            case 37: {
                return obj instanceof UntypedAtomic;
            }
            case 33: {
                return obj instanceof Path;
            }
            case 31: {
                return obj instanceof Boolean;
            }
            case 18: {
                return obj instanceof Float;
            }
            case 19: {
                return obj instanceof Double;
            }
            case 4: {
                return obj instanceof BigDecimal || obj instanceof IntNum;
            }
            case 28: {
                return obj instanceof Duration;
            }
            case 29: {
                return obj instanceof Duration && ((Duration)obj).unit() == Unit.month;
            }
            case 30: {
                return obj instanceof Duration && ((Duration)obj).unit() == Unit.second;
            }
            default: {
                return super.isInstance(obj);
            }
        }
    }
    
    @Override
    public void emitIsInstance(final Variable incoming, final Compilation comp, final Target target) {
        InstanceOf.emitIsInstance(this, incoming, comp, target);
    }
    
    public String toString(final Object value) {
        return value.toString();
    }
    
    public void print(final Object value, final Consumer out) {
        if (value instanceof Printable) {
            ((Printable)value).print(out);
        }
        else {
            out.write(this.toString(value));
        }
    }
    
    public boolean castable(final Object value) {
        try {
            this.cast(value);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    public Object cast(Object value) {
        value = KNode.atomicValue(value);
        if (value instanceof UntypedAtomic) {
            if (this.typeCode == 37) {
                return value;
            }
            return this.valueOf(value.toString());
        }
        else {
            if (value instanceof String) {
                return this.valueOf(value.toString());
            }
            switch (this.typeCode) {
                case 38: {
                    return TextUtils.asString(value);
                }
                case 37: {
                    return new UntypedAtomic(TextUtils.stringValue(value));
                }
                case 33: {
                    return URIPath.makeURI(value);
                }
                case 31: {
                    if (value instanceof Boolean) {
                        return value ? Boolean.TRUE : Boolean.FALSE;
                    }
                    if (RealNum.isReal(value)) {
                        final double d = ((Number)value).doubleValue();
                        return (d == 0.0 || Double.isNaN(d)) ? Boolean.FALSE : Boolean.TRUE;
                    }
                    break;
                }
                case 4: {
                    if (value instanceof BigDecimal) {
                        return value;
                    }
                    if (value instanceof RealNum) {
                        return ((RealNum)value).asBigDecimal();
                    }
                    if (RealNum.isReal(value)) {
                        return BigDecimal.valueOf(((Number)value).doubleValue());
                    }
                    if (value instanceof Boolean) {
                        return this.cast(value ? IntNum.one() : IntNum.zero());
                    }
                    break;
                }
                case 18: {
                    if (value instanceof Float) {
                        return value;
                    }
                    if (RealNum.isReal(value)) {
                        return makeFloat(((Number)value).floatValue());
                    }
                    if (value instanceof Boolean) {
                        return value ? XDataType.FLOAT_ONE : XDataType.FLOAT_ZERO;
                    }
                    break;
                }
                case 19: {
                    if (value instanceof Double) {
                        return value;
                    }
                    if (RealNum.isReal(value)) {
                        return makeDouble(((Number)value).doubleValue());
                    }
                    if (value instanceof Boolean) {
                        return value ? XDataType.DOUBLE_ONE : XDataType.DOUBLE_ZERO;
                    }
                    break;
                }
                case 23:
                case 24:
                case 25:
                case 26:
                case 27: {
                    if (!(value instanceof DateTime)) {
                        break;
                    }
                    final int dstMask = XTimeType.components(((XTimeType)this).typeCode);
                    final DateTime dt = (DateTime)value;
                    final int srcMask = dt.components();
                    if (dstMask == srcMask || (srcMask & 0xE) == 0xE) {
                        return dt.cast(dstMask);
                    }
                    throw new ClassCastException();
                }
                case 20:
                case 21:
                case 22: {
                    if (value instanceof DateTime) {
                        final int mask = XTimeType.components(((XTimeType)this).typeCode);
                        return ((DateTime)value).cast(mask);
                    }
                    break;
                }
                case 28: {
                    return this.castToDuration(value, Unit.duration);
                }
                case 29: {
                    return this.castToDuration(value, Unit.month);
                }
                case 30: {
                    return this.castToDuration(value, Unit.second);
                }
                case 34: {
                    if (value instanceof BinaryObject) {
                        return new Base64Binary(((BinaryObject)value).getBytes());
                    }
                }
                case 35: {
                    if (value instanceof BinaryObject) {
                        return new HexBinary(((BinaryObject)value).getBytes());
                    }
                    break;
                }
            }
            return this.coerceFromObject(value);
        }
    }
    
    Duration castToDuration(final Object value, final Unit unit) {
        if (!(value instanceof Duration)) {
            return (Duration)this.coerceFromObject(value);
        }
        final Duration dur = (Duration)value;
        if (dur.unit() == unit) {
            return dur;
        }
        int months = dur.getTotalMonths();
        long seconds = dur.getTotalSeconds();
        int nanos = dur.getNanoSecondsOnly();
        if (unit == Unit.second) {
            months = 0;
        }
        if (unit == Unit.month) {
            seconds = 0L;
            nanos = 0;
        }
        return Duration.make(months, seconds, nanos, unit);
    }
    
    @Override
    public Object coerceFromObject(final Object obj) {
        if (!this.isInstance(obj)) {
            throw new ClassCastException("cannot cast " + obj + " to " + this.name);
        }
        return obj;
    }
    
    @Override
    public int compare(final Type other) {
        if (this == other || (this == XDataType.stringStringType && other == XDataType.stringType) || (this == XDataType.stringType && other == XDataType.stringStringType)) {
            return 0;
        }
        return this.implementationType.compare(other);
    }
    
    public Object valueOf(String value) {
        switch (this.typeCode) {
            case 38: {
                return value;
            }
            case 37: {
                return new UntypedAtomic(value);
            }
            case 33: {
                return URIPath.makeURI(TextUtils.replaceWhitespace(value, true));
            }
            case 31: {
                value = value.trim();
                if (value.equals("true") || value.equals("1")) {
                    return Boolean.TRUE;
                }
                if (value.equals("false") || value.equals("0")) {
                    return Boolean.FALSE;
                }
                throw new IllegalArgumentException("not a valid boolean: '" + value + "'");
            }
            case 18:
            case 19: {
                value = value.trim();
                if ("INF".equals(value)) {
                    value = "Infinity";
                }
                else if ("-INF".equals(value)) {
                    value = "-Infinity";
                }
                return (this.typeCode == 18) ? Float.valueOf(value) : Double.valueOf(value);
            }
            case 4: {
                value = value.trim();
                int i = value.length();
                while (--i >= 0) {
                    final char ch = value.charAt(i);
                    if (ch == 'e' || ch == 'E') {
                        throw new IllegalArgumentException("not a valid decimal: '" + value + "'");
                    }
                }
                return new BigDecimal(value);
            }
            case 28: {
                return Duration.parseDuration(value);
            }
            case 29: {
                return Duration.parseYearMonthDuration(value);
            }
            case 30: {
                return Duration.parseDayTimeDuration(value);
            }
            case 34: {
                return Base64Binary.valueOf(value);
            }
            case 35: {
                return HexBinary.valueOf(value);
            }
            default: {
                throw new RuntimeException("valueOf not implemented for " + this.name);
            }
        }
    }
    
    public static Float makeFloat(final float value) {
        return value;
    }
    
    public static Double makeDouble(final double value) {
        return value;
    }
    
    @Override
    public String encodeType(final Language language) {
        return null;
    }
    
    @Override
    public Procedure getConstructor() {
        return null;
    }
    
    static {
        anySimpleType = new XDataType("anySimpleType", Type.objectType, 2);
        anyAtomicType = new XDataType("anyAtomicType", Type.objectType, 3);
        stringType = new XDataType("string", Compilation.typeCharSequence, 38);
        stringStringType = new XDataType("String", ClassType.make("java.lang.String"), 38);
        untypedAtomicType = new XDataType("string", ClassType.make("gnu.kawa.xml.UntypedAtomic"), 37);
        base64BinaryType = new XDataType("base64Binary", ClassType.make("gnu.kawa.xml.Base64Binary"), 34);
        hexBinaryType = new XDataType("hexBinary", ClassType.make("gnu.kawa.xml.HexBinary"), 35);
        booleanType = new XDataType("boolean", Type.booleanType, 31);
        anyURIType = new XDataType("anyURI", ClassType.make("gnu.kawa.io.Path"), 33);
        NotationType = new XDataType("NOTATION", ClassType.make("gnu.kawa.xml.Notation"), 36);
        decimalType = new XDataType("decimal", ClassType.make("java.lang.Number"), 4);
        floatType = new XDataType("float", ClassType.make("java.lang.Float"), 18);
        doubleType = new XDataType("double", ClassType.make("java.lang.Double"), 19);
        durationType = new XDataType("duration", ClassType.make("gnu.math.Duration"), 28);
        yearMonthDurationType = new XDataType("yearMonthDuration", ClassType.make("gnu.math.Duration"), 29);
        dayTimeDurationType = new XDataType("dayTimeDuration", ClassType.make("gnu.math.Duration"), 30);
        untypedType = new XDataType("untyped", Type.objectType, 48);
        DOUBLE_ZERO = makeDouble(0.0);
        DOUBLE_ONE = makeDouble(1.0);
        FLOAT_ZERO = makeFloat(0.0f);
        FLOAT_ONE = makeFloat(1.0f);
        DECIMAL_ONE = BigDecimal.valueOf(1L);
    }
}
