// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

public class PrimType extends Type
{
    private static final String numberHierarchy = "A:java.lang.Byte;A:gnu.math.UByte;B:java.lang.Short;B:gnu.math.UShort;C:java.lang.Integer;C:gnu.math.UInt;D:java.lang.Long;D:gnu.math.ULong;E:gnu.math.IntNum;E:java.gnu.math.BitInteger;G:gnu.math.RatNum;G:gnu.math.IntFraction;H:java.lang.Float;I:java.lang.Double;I:gnu.math.DFloNum;J:gnu.math.RealNum;K:gnu.math.Complex;L:gnu.math.Quantity;K:gnu.math.Numeric;N:java.lang.Number;";
    
    public PrimType(final String nam, final String sig, final int siz, final Class reflectClass) {
        super(nam, sig);
        this.size = siz;
        Type.registerTypeForClass(this.reflectClass = reflectClass, this);
    }
    
    protected PrimType(final PrimType type) {
        super(type.this_name, type.signature);
        this.size = type.size;
        this.reflectClass = type.reflectClass;
    }
    
    public boolean isUnsigned() {
        final char sig1 = this.signature.charAt(0);
        return sig1 == 'C' || sig1 == 'Z';
    }
    
    @Override
    public Object coerceFromObject(final Object obj) {
        if (obj.getClass() == this.reflectClass) {
            return obj;
        }
        final char sig1 = (this.signature == null || this.signature.length() != 1) ? ' ' : this.signature.charAt(0);
        switch (sig1) {
            case 'B': {
                return ((Number)obj).byteValue();
            }
            case 'S': {
                return ((Number)obj).shortValue();
            }
            case 'I': {
                return ((Number)obj).intValue();
            }
            case 'J': {
                return ((Number)obj).longValue();
            }
            case 'F': {
                return ((Number)obj).floatValue();
            }
            case 'D': {
                return ((Number)obj).doubleValue();
            }
            case 'Z': {
                return obj;
            }
            default: {
                throw new ClassCastException("don't know how to coerce " + obj.getClass().getName() + " to " + this.getName());
            }
        }
    }
    
    public Object convertToRaw(final Object obj) {
        return obj;
    }
    
    public char charValue(final Object value) {
        return (char)value;
    }
    
    public static boolean booleanValue(final Object value) {
        return !(value instanceof Boolean) || (boolean)value;
    }
    
    public ClassType boxedType() {
        final char sig1 = this.getSignature().charAt(0);
        String cname = null;
        switch (sig1) {
            case 'Z': {
                cname = "java.lang.Boolean";
                break;
            }
            case 'C': {
                cname = "java.lang.Character";
                break;
            }
            case 'B': {
                cname = "java.lang.Byte";
                break;
            }
            case 'S': {
                cname = "java.lang.Short";
                break;
            }
            case 'I': {
                cname = "java.lang.Integer";
                break;
            }
            case 'J': {
                cname = "java.lang.Long";
                break;
            }
            case 'F': {
                cname = "java.lang.Float";
                break;
            }
            case 'D': {
                cname = "java.lang.Double";
                break;
            }
            case 'V': {
                cname = "java.lang.Void";
                break;
            }
            default: {
                cname = null;
                break;
            }
        }
        return ClassType.make(cname);
    }
    
    public static PrimType unboxedType(final Type type) {
        if (type instanceof PrimType) {
            return (PrimType)type;
        }
        if (!(type instanceof ClassType)) {
            return null;
        }
        final String name = type.getName();
        if ("java.lang.Boolean".equals(name)) {
            return Type.booleanType;
        }
        if ("java.lang.Character".equals(name)) {
            return Type.charType;
        }
        if ("java.lang.Byte".equals(name)) {
            return Type.byteType;
        }
        if ("java.lang.Short".equals(name)) {
            return Type.shortType;
        }
        if ("java.lang.Integer".equals(name)) {
            return Type.intType;
        }
        if ("java.lang.Long".equals(name)) {
            return Type.longType;
        }
        if ("java.lang.Float".equals(name)) {
            return Type.floatType;
        }
        if ("java.lang.Double".equals(name)) {
            return Type.doubleType;
        }
        if ("java.lang.Void".equals(name)) {
            return Type.voidType;
        }
        return null;
    }
    
    @Override
    public void emitCoerceToObject(final CodeAttr code) {
        final char sig1 = this.getSignature().charAt(0);
        final ClassType clas = this.boxedType();
        if (sig1 == 'Z') {
            code.emitIfIntNotZero();
            code.emitGetStatic(clas.getDeclaredField("TRUE"));
            code.emitElse();
            code.emitGetStatic(clas.getDeclaredField("FALSE"));
            code.emitFi();
            return;
        }
        final Type[] args = { this };
        Method method;
        if (code.getMethod().getDeclaringClass().classfileFormatVersion >= 3211264) {
            method = clas.getDeclaredMethod("valueOf", args);
        }
        else {
            method = clas.getDeclaredMethod("<init>", args);
            code.emitNew(clas);
            code.emitDupX();
            code.emitSwap();
        }
        code.emitInvoke(method);
    }
    
    @Override
    public void emitIsInstance(final CodeAttr code) {
        final char sig1 = (this.signature == null || this.signature.length() != 1) ? ' ' : this.signature.charAt(0);
        if (sig1 == 'Z') {
            PrimType.javalangBooleanType.emitIsInstance(code);
        }
        else if (sig1 == 'V') {
            code.emitPop(1);
            code.emitPushInt(1);
        }
        else {
            PrimType.javalangNumberType.emitIsInstance(code);
        }
    }
    
    @Override
    public void emitCoerceFromObject(final CodeAttr code) {
        final char sig1 = (this.signature == null || this.signature.length() != 1) ? ' ' : this.signature.charAt(0);
        if (sig1 == 'Z') {
            code.emitCheckcast(PrimType.javalangBooleanType);
            code.emitInvokeVirtual(PrimType.booleanValue_method);
        }
        else if (sig1 == 'V') {
            code.emitPop(1);
        }
        else {
            code.emitCheckcast(PrimType.javalangNumberType);
            if (sig1 == 'I' || sig1 == 'S' || sig1 == 'B') {
                code.emitInvokeVirtual(PrimType.intValue_method);
            }
            else if (sig1 == 'J') {
                code.emitInvokeVirtual(PrimType.longValue_method);
            }
            else if (sig1 == 'D') {
                code.emitInvokeVirtual(PrimType.doubleValue_method);
            }
            else if (sig1 == 'F') {
                code.emitInvokeVirtual(PrimType.floatValue_method);
            }
            else {
                super.emitCoerceFromObject(code);
            }
        }
    }
    
    public static int compare(final PrimType type1, final PrimType type2) {
        final char sig1 = type1.signature.charAt(0);
        final char sig2 = type2.signature.charAt(0);
        if (sig1 == sig2) {
            return (type1.isUnsigned() == type2.isUnsigned()) ? 0 : -2;
        }
        if (sig1 == 'V') {
            return 1;
        }
        if (sig2 == 'V') {
            return -1;
        }
        if (sig1 == 'Z' || sig2 == 'Z') {
            return -3;
        }
        if (sig1 == 'C') {
            return (type2.size > 2) ? -1 : -3;
        }
        if (sig2 == 'C') {
            return (type1.size > 2) ? 1 : -3;
        }
        if (sig1 == 'D') {
            return 1;
        }
        if (sig2 == 'D') {
            return -1;
        }
        if (sig1 == 'F') {
            return 1;
        }
        if (sig2 == 'F') {
            return -1;
        }
        int r = (sig1 == 'J') ? 1 : ((sig2 == 'J') ? -1 : ((sig1 == 'I') ? 1 : ((sig2 == 'I') ? -1 : ((sig1 == 'S') ? 1 : ((sig2 == 'S') ? -1 : ((sig1 == 'B') ? 1 : ((sig2 == 'B') ? -1 : -3)))))));
        if ((r == 1 && type1.isUnsigned() && !type2.isUnsigned()) || (r == -1 && type2.isUnsigned() && !type1.isUnsigned())) {
            r = -2;
        }
        return r;
    }
    
    public Type promotedType() {
        switch (this.signature.charAt(0)) {
            case 'B':
            case 'C':
            case 'I':
            case 'S':
            case 'Z': {
                return Type.intType;
            }
            default: {
                return this.getImplementationType();
            }
        }
    }
    
    private static char findInHierarchy(final String cname) {
        final int pos = "A:java.lang.Byte;A:gnu.math.UByte;B:java.lang.Short;B:gnu.math.UShort;C:java.lang.Integer;C:gnu.math.UInt;D:java.lang.Long;D:gnu.math.ULong;E:gnu.math.IntNum;E:java.gnu.math.BitInteger;G:gnu.math.RatNum;G:gnu.math.IntFraction;H:java.lang.Float;I:java.lang.Double;I:gnu.math.DFloNum;J:gnu.math.RealNum;K:gnu.math.Complex;L:gnu.math.Quantity;K:gnu.math.Numeric;N:java.lang.Number;".indexOf(cname) - 2;
        return (pos < 0) ? '\0' : "A:java.lang.Byte;A:gnu.math.UByte;B:java.lang.Short;B:gnu.math.UShort;C:java.lang.Integer;C:gnu.math.UInt;D:java.lang.Long;D:gnu.math.ULong;E:gnu.math.IntNum;E:java.gnu.math.BitInteger;G:gnu.math.RatNum;G:gnu.math.IntFraction;H:java.lang.Float;I:java.lang.Double;I:gnu.math.DFloNum;J:gnu.math.RealNum;K:gnu.math.Complex;L:gnu.math.Quantity;K:gnu.math.Numeric;N:java.lang.Number;".charAt(pos);
    }
    
    @Override
    public int compare(final Type other) {
        if (other instanceof PrimType) {
            if (other.getImplementationType() != other) {
                return Type.swappedCompareResult(other.compare(this));
            }
            return compare(this, (PrimType)other);
        }
        else if (!(other instanceof ClassType)) {
            if (other instanceof ArrayType) {
                return -3;
            }
            return Type.swappedCompareResult(other.compare(this));
        }
        else {
            final char sig1 = this.signature.charAt(0);
            final String otherName = other.getName();
            if (otherName == null) {
                return -1;
            }
            char thisPriority = '\0';
            switch (sig1) {
                case 'V': {
                    return 1;
                }
                case 'Z': {
                    if (otherName.equals("java.lang.Boolean")) {
                        return 0;
                    }
                }
                case 'C': {
                    if (otherName.equals("java.lang.Character")) {
                        return 0;
                    }
                    break;
                }
                case 'B': {
                    thisPriority = 'A';
                    break;
                }
                case 'S': {
                    thisPriority = 'B';
                    break;
                }
                case 'I': {
                    thisPriority = 'C';
                    break;
                }
                case 'J': {
                    thisPriority = 'D';
                    break;
                }
                case 'F': {
                    thisPriority = 'H';
                    break;
                }
                case 'D': {
                    thisPriority = 'I';
                    break;
                }
            }
            if (thisPriority != '\0') {
                final char otherPriority = findInHierarchy(otherName);
                if (otherPriority != '\0') {
                    return (otherPriority == thisPriority) ? 0 : ((otherPriority < thisPriority) ? 1 : -1);
                }
            }
            if (otherName.equals("java.lang.Object") || other == PrimType.toStringType) {
                return -1;
            }
            return -3;
        }
    }
}
