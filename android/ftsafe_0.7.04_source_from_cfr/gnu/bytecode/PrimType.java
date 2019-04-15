/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;

public class PrimType
extends Type {
    private static final String numberHierarchy = "A:java.lang.Byte;A:gnu.math.UByte;B:java.lang.Short;B:gnu.math.UShort;C:java.lang.Integer;C:gnu.math.UInt;D:java.lang.Long;D:gnu.math.ULong;E:gnu.math.IntNum;E:java.gnu.math.BitInteger;G:gnu.math.RatNum;G:gnu.math.IntFraction;H:java.lang.Float;I:java.lang.Double;I:gnu.math.DFloNum;J:gnu.math.RealNum;K:gnu.math.Complex;L:gnu.math.Quantity;K:gnu.math.Numeric;N:java.lang.Number;";

    public PrimType(String nam, String sig, int siz, Class reflectClass) {
        super(nam, sig);
        this.size = siz;
        this.reflectClass = reflectClass;
        Type.registerTypeForClass(reflectClass, this);
    }

    protected PrimType(PrimType type) {
        super(type.this_name, type.signature);
        this.size = type.size;
        this.reflectClass = type.reflectClass;
    }

    public boolean isUnsigned() {
        char sig1 = this.signature.charAt(0);
        return sig1 == 'C' || sig1 == 'Z';
    }

    @Override
    public Object coerceFromObject(Object obj) {
        if (obj.getClass() == this.reflectClass) {
            return obj;
        }
        int sig1 = this.signature == null || this.signature.length() != 1 ? 32 : (int)this.signature.charAt(0);
        switch (sig1) {
            case 66: {
                return ((Number)obj).byteValue();
            }
            case 83: {
                return ((Number)obj).shortValue();
            }
            case 73: {
                return ((Number)obj).intValue();
            }
            case 74: {
                return ((Number)obj).longValue();
            }
            case 70: {
                return Float.valueOf(((Number)obj).floatValue());
            }
            case 68: {
                return ((Number)obj).doubleValue();
            }
            case 90: {
                return (boolean)((Boolean)obj);
            }
        }
        throw new ClassCastException("don't know how to coerce " + obj.getClass().getName() + " to " + this.getName());
    }

    public Object convertToRaw(Object obj) {
        return obj;
    }

    public char charValue(Object value) {
        return ((Character)value).charValue();
    }

    public static boolean booleanValue(Object value) {
        return !(value instanceof Boolean) || (Boolean)value != false;
    }

    public ClassType boxedType() {
        String cname;
        char sig1 = this.getSignature().charAt(0);
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
            }
        }
        return ClassType.make(cname);
    }

    public static PrimType unboxedType(Type type) {
        if (type instanceof PrimType) {
            return (PrimType)type;
        }
        if (!(type instanceof ClassType)) {
            return null;
        }
        String name = type.getName();
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
    public void emitCoerceToObject(CodeAttr code) {
        Method method;
        char sig1 = this.getSignature().charAt(0);
        ClassType clas = this.boxedType();
        if (sig1 == 'Z') {
            code.emitIfIntNotZero();
            code.emitGetStatic(clas.getDeclaredField("TRUE"));
            code.emitElse();
            code.emitGetStatic(clas.getDeclaredField("FALSE"));
            code.emitFi();
            return;
        }
        Type[] args = new Type[]{this};
        if (code.getMethod().getDeclaringClass().classfileFormatVersion >= 3211264) {
            method = clas.getDeclaredMethod("valueOf", args);
        } else {
            method = clas.getDeclaredMethod("<init>", args);
            code.emitNew(clas);
            code.emitDupX();
            code.emitSwap();
        }
        code.emitInvoke(method);
    }

    @Override
    public void emitIsInstance(CodeAttr code) {
        int sig1;
        int n = sig1 = this.signature == null || this.signature.length() != 1 ? 32 : (int)this.signature.charAt(0);
        if (sig1 == 90) {
            javalangBooleanType.emitIsInstance(code);
        } else if (sig1 == 86) {
            code.emitPop(1);
            code.emitPushInt(1);
        } else {
            javalangNumberType.emitIsInstance(code);
        }
    }

    @Override
    public void emitCoerceFromObject(CodeAttr code) {
        int sig1;
        int n = sig1 = this.signature == null || this.signature.length() != 1 ? 32 : (int)this.signature.charAt(0);
        if (sig1 == 90) {
            code.emitCheckcast(javalangBooleanType);
            code.emitInvokeVirtual(booleanValue_method);
        } else if (sig1 == 86) {
            code.emitPop(1);
        } else {
            code.emitCheckcast(javalangNumberType);
            if (sig1 == 73 || sig1 == 83 || sig1 == 66) {
                code.emitInvokeVirtual(intValue_method);
            } else if (sig1 == 74) {
                code.emitInvokeVirtual(longValue_method);
            } else if (sig1 == 68) {
                code.emitInvokeVirtual(doubleValue_method);
            } else if (sig1 == 70) {
                code.emitInvokeVirtual(floatValue_method);
            } else {
                super.emitCoerceFromObject(code);
            }
        }
    }

    public static int compare(PrimType type1, PrimType type2) {
        char sig2;
        int r;
        char sig1 = type1.signature.charAt(0);
        if (sig1 == (sig2 = type2.signature.charAt(0))) {
            return type1.isUnsigned() == type2.isUnsigned() ? 0 : -2;
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
            return type2.size > 2 ? -1 : -3;
        }
        if (sig2 == 'C') {
            return type1.size > 2 ? 1 : -3;
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
        int n = sig1 == 'J' ? 1 : (sig2 == 'J' ? -1 : (sig1 == 'I' ? 1 : (sig2 == 'I' ? -1 : (sig1 == 'S' ? 1 : (sig2 == 'S' ? -1 : (sig1 == 'B' ? 1 : (r = sig2 == 'B' ? -1 : -3)))))));
        if (r == 1 && type1.isUnsigned() && !type2.isUnsigned() || r == -1 && type2.isUnsigned() && !type1.isUnsigned()) {
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
        }
        return this.getImplementationType();
    }

    private static char findInHierarchy(String cname) {
        int pos = numberHierarchy.indexOf(cname) - 2;
        return pos < 0 ? (char)'\u0000' : numberHierarchy.charAt(pos);
    }

    @Override
    public int compare(Type other) {
        char otherPriority;
        if (other instanceof PrimType) {
            if (other.getImplementationType() != other) {
                return PrimType.swappedCompareResult(other.compare(this));
            }
            return PrimType.compare(this, (PrimType)other);
        }
        if (!(other instanceof ClassType)) {
            if (other instanceof ArrayType) {
                return -3;
            }
            return PrimType.swappedCompareResult(other.compare(this));
        }
        char sig1 = this.signature.charAt(0);
        String otherName = other.getName();
        if (otherName == null) {
            return -1;
        }
        char thisPriority = '\u0000';
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
                if (!otherName.equals("java.lang.Character")) break;
                return 0;
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
            }
        }
        if (thisPriority != '\u0000' && (otherPriority = PrimType.findInHierarchy(otherName)) != '\u0000') {
            return otherPriority == thisPriority ? 0 : (otherPriority < thisPriority ? 1 : -1);
        }
        if (otherName.equals("java.lang.Object") || other == toStringType) {
            return -1;
        }
        return -3;
    }
}

