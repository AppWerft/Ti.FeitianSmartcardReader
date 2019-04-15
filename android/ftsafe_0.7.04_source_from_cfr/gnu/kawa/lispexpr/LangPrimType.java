/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.InstanceOf;
import gnu.kawa.reflect.LazyType;
import gnu.lists.Sequence;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.IntNum;
import gnu.math.UByte;
import gnu.math.UInt;
import gnu.math.ULong;
import gnu.math.UShort;
import gnu.text.Char;

public class LangPrimType
extends PrimType
implements TypeValue {
    Language language;
    PrimType implementationType;
    boolean isUnsigned;
    public static final PrimType byteType = Type.byteType;
    public static final PrimType shortType = Type.shortType;
    public static final PrimType intType = Type.intType;
    public static final PrimType longType = Type.longType;
    public static final PrimType floatType = Type.floatType;
    public static final PrimType doubleType = Type.doubleType;
    public static final LangPrimType charType = new LangPrimType(Type.charType);
    public static final PrimType voidType = Type.voidType;
    static final ClassType scmCharType = ClassType.make("gnu.text.Char");
    static final ClassType boxedStringCursorType = ClassType.make("gnu.text.StringCursor");
    public static final LangPrimType characterType = new LangPrimType(Type.intType);
    public static final LangPrimType characterOrEofType;
    public static final LangPrimType unsignedLongType;
    static final ClassType boxedULongType;
    public static final LangPrimType unsignedIntType;
    static final ClassType boxedUIntType;
    public static final LangPrimType unsignedShortType;
    static final ClassType boxedUShortType;
    public static final LangPrimType unsignedByteType;
    static final ClassType boxedUByteType;
    public static final LangPrimType stringCursorType;

    public LangPrimType(PrimType type) {
        super(type);
        this.implementationType = type;
    }

    public LangPrimType(PrimType type, Language language) {
        super(type);
        this.language = language;
        this.implementationType = type;
    }

    public LangPrimType(String nam, String sig, int siz, Class reflectClass) {
        super(nam, sig, siz, reflectClass);
    }

    public LangPrimType(String nam, String sig, int siz, Class reflectClass, Language language) {
        this(nam, sig, siz, reflectClass);
        this.implementationType = Type.signatureToPrimitive(sig.charAt(0));
        this.language = language;
    }

    @Override
    public Type getImplementationType() {
        return this.implementationType;
    }

    @Override
    public boolean isUnsigned() {
        return this.isUnsigned;
    }

    @Override
    public ClassType boxedType() {
        if (this == characterType) {
            return scmCharType;
        }
        if (this == stringCursorType) {
            return boxedStringCursorType;
        }
        if (this == characterOrEofType) {
            return Type.objectType;
        }
        if (this == unsignedLongType) {
            return boxedULongType;
        }
        if (this == unsignedIntType) {
            return boxedUIntType;
        }
        if (this == unsignedShortType) {
            return boxedUShortType;
        }
        if (this == unsignedByteType) {
            return boxedUByteType;
        }
        return super.boxedType();
    }

    @Override
    public Object coerceFromObject(Object obj) {
        if (obj.getClass() == this.reflectClass) {
            return obj;
        }
        char sig1 = this.getSignature().charAt(0);
        switch (sig1) {
            case 'J': {
                if (!this.isUnsigned()) break;
                return ULong.valueOf(((Number)obj).longValue());
            }
            case 'I': {
                if (this == characterType || this == characterOrEofType) {
                    if (obj instanceof Integer) {
                        return obj;
                    }
                    int ival = obj instanceof Char ? ((Char)obj).intValue() : (obj == Sequence.eofValue && this == characterOrEofType ? -1 : (int)((Character)obj).charValue());
                    return ival;
                }
                if (!this.isUnsigned()) break;
                return UInt.valueOf(((Number)obj).intValue());
            }
            case 'S': {
                if (!this.isUnsigned()) break;
                return UShort.valueOf(((Number)obj).shortValue());
            }
            case 'B': {
                if (!this.isUnsigned()) break;
                return UByte.valueOf(((Number)obj).byteValue());
            }
            case 'Z': {
                return this.language.isTrue(obj) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 'C': {
                return new Character(((Char)obj).charValue());
            }
            case 'V': {
                return Values.empty;
            }
        }
        return super.coerceFromObject(obj);
    }

    @Override
    public char charValue(Object value) {
        if (value instanceof Character) {
            return ((Character)value).charValue();
        }
        return ((Char)value).charValue();
    }

    @Override
    public void emitIsInstance(CodeAttr code) {
        char sig1 = this.getSignature().charAt(0);
        switch (sig1) {
            case 'I': {
                String mname;
                String string = this == characterType ? "isChar" : (mname = this == characterOrEofType ? "isCharOrEof" : null);
                if (mname == null) break;
                code.emitInvokeStatic(scmCharType.getDeclaredMethod(mname, 1));
                return;
            }
            case 'C': {
                ClassType scmCharType = ClassType.make("gnu.text.Char");
                code.emitInvokeStatic(scmCharType.getDeclaredMethod("isChar", 1));
                return;
            }
        }
        super.emitIsInstance(code);
    }

    @Override
    public void emitCoerceFromObject(CodeAttr code) {
        char sig1 = this.getSignature().charAt(0);
        switch (sig1) {
            case 'I': {
                String mname;
                if (this == characterType || this == characterOrEofType) {
                    Type top = code.topType();
                    if (top == javalangCharacterType) {
                        code.emitInvokeVirtual(javalangCharacterType.getDeclaredMethod("charValue", 0));
                        return;
                    }
                    if (top == scmCharType) {
                        code.emitInvokeVirtual(scmCharType.getDeclaredMethod("intValue", 0));
                        return;
                    }
                }
                if (this == stringCursorType) {
                    boxedStringCursorType.emitCoerceFromObject(code);
                    code.emitInvoke(boxedStringCursorType.getDeclaredMethod("getValue", 0));
                    return;
                }
                String string = this == characterType ? "castToCharacter" : (mname = this == characterOrEofType ? "castToCharacterOrEof" : null);
                if (mname == null) break;
                code.emitInvokeStatic(scmCharType.getDeclaredMethod(mname, 1));
                return;
            }
            case 'Z': {
                Compilation.getCurrent().emitCoerceToBoolean();
                return;
            }
            case 'C': {
                if (code.topType() == javalangCharacterType) {
                    code.emitInvokeVirtual(javalangCharacterType.getDeclaredMethod("charValue", 0));
                    return;
                }
                Method charValueMethod = scmCharType.getDeclaredMethod("castToChar", 1);
                code.emitInvokeStatic(charValueMethod);
                return;
            }
        }
        super.emitCoerceFromObject(code);
    }

    @Override
    public Object coerceToObject(Object obj) {
        char sig1 = this.getSignature().charAt(0);
        switch (sig1) {
            case 'I': {
                if (this != characterType && this != characterOrEofType) break;
                if (obj instanceof Integer) {
                    int ival = (Integer)obj;
                    if (ival >= 0) {
                        return Char.make(ival);
                    }
                    if (ival == -1 && this == characterOrEofType) {
                        return Sequence.eofValue;
                    }
                }
                if (!(obj instanceof Char) || obj != Sequence.eofValue || this != characterOrEofType) break;
                return obj;
            }
            case 'Z': {
                return this.language.booleanObject((Boolean)obj);
            }
            case 'C': {
                if (obj instanceof Char) {
                    return obj;
                }
                return Char.make(((Character)obj).charValue());
            }
            case 'V': {
                return Values.empty;
            }
        }
        return super.coerceToObject(obj);
    }

    @Override
    public Object convertToRaw(Object obj) {
        if (this == characterType || this == characterOrEofType) {
            if (obj instanceof Char) {
                return ((Char)obj).intValue();
            }
            if (obj == Sequence.eofValue && this == characterOrEofType) {
                return -1;
            }
        }
        return obj;
    }

    @Override
    public void emitCoerceToObject(CodeAttr code) {
        char sig1 = this.getSignature().charAt(0);
        Object argType = null;
        String cname = null;
        switch (sig1) {
            case 'I': {
                String mname;
                String string = this == characterType ? "make" : (mname = this == characterOrEofType ? "makeOrEof" : null);
                if (mname != null) {
                    Method makeCharMethod = scmCharType.getDeclaredMethod(mname, 1);
                    code.emitInvokeStatic(makeCharMethod);
                    break;
                }
                super.emitCoerceToObject(code);
                break;
            }
            case 'Z': {
                Compilation comp = Compilation.getCurrent();
                code.emitIfIntNotZero();
                comp.emitPushBoolean(true);
                code.emitElse();
                comp.emitPushBoolean(false);
                code.emitFi();
                break;
            }
            case 'C': {
                ClassType scmCharType = ClassType.make("gnu.text.Char");
                Method makeCharMethod = scmCharType.getDeclaredMethod("make", 1);
                code.emitInvokeStatic(makeCharMethod);
                break;
            }
            default: {
                super.emitCoerceToObject(code);
            }
        }
        if (cname != null) {
            ClassType clas = ClassType.make(cname);
            Type[] args = new Type[]{argType};
            code.emitInvokeStatic(clas.getDeclaredMethod("make", args));
        }
    }

    @Override
    public int compare(Type other) {
        if (other instanceof LazyType) {
            other = ((LazyType)other).getValueType();
        }
        char sig1 = this.getSignature().charAt(0);
        char sig2 = other.getSignature().charAt(0);
        if (sig1 == 'Z') {
            return this.implementationType.compare(other);
        }
        if (this == other) {
            return 0;
        }
        if (this == stringCursorType) {
            return other == Type.objectType ? -1 : -3;
        }
        if (this == charType) {
            if (other == characterType || other == characterOrEofType || other == scmCharType) {
                return -1;
            }
            return this.getImplementationType().compare(other);
        }
        if (this == characterType) {
            if (other == characterOrEofType) {
                return -1;
            }
            if (other == charType || sig2 == 'C') {
                return 1;
            }
            return scmCharType.compare(other);
        }
        if (this == characterOrEofType) {
            if (other == characterType || other == ClassType.make("gnu.lists.EofClass") || other == charType || other == scmCharType || sig2 == 'C') {
                return 1;
            }
            return other == Type.objectType ? -1 : -3;
        }
        if (other instanceof PrimType) {
            return this.getImplementationType().compare(other);
        }
        if (sig1 == 'V') {
            return 1;
        }
        if (other instanceof LangObjType) {
            return LangPrimType.swappedCompareResult(other.compare(this));
        }
        return super.compare(other);
    }

    @Override
    public int isCompatibleWithValue(Type valueType) {
        if (this == charType && valueType == Type.charType) {
            return 2;
        }
        int r = super.isCompatibleWithValue(valueType);
        if (r < 0 && this.getSignature().charAt(0) == 'Z') {
            r = 0;
        }
        return r;
    }

    @Override
    public void emitTestIf(Variable incoming, Declaration decl, Compilation comp) {
        CodeAttr code = comp.getCode();
        char sig1 = this.getSignature().charAt(0);
        if (incoming != null) {
            code.emitLoad(incoming);
        }
        switch (sig1) {
            case 'Z': {
                Type.javalangBooleanType.emitIsInstance(code);
                code.emitIfIntNotZero();
                if (decl != null) {
                    code.emitLoad(incoming);
                    super.emitCoerceFromObject(code);
                    decl.compileStore(comp);
                }
                return;
            }
        }
        if (this == characterType || this == characterOrEofType || this == charType) {
            code.emitInvokeStatic(scmCharType.getDeclaredMethod("checkCharOrEof", 1));
        } else if (this == stringCursorType) {
            code.emitInvokeStatic(boxedStringCursorType.getDeclaredMethod("checkStringCursor", 1));
        }
        if (decl != null) {
            code.emitDup();
            decl.compileStore(comp);
        }
        if (this == characterType || this == stringCursorType) {
            code.emitIfIntGEqZero();
        } else if (this == charType) {
            code.emitPushInt(16);
            code.emitUshr();
            code.emitIfIntEqZero();
        } else if (this == characterOrEofType) {
            code.emitPushInt(-1);
            code.emitIfIntGEq();
        } else {
            this.emitIsInstance(code);
            code.emitIfIntNotZero();
        }
    }

    @Override
    public Expression convertValue(Expression value) {
        return null;
    }

    @Override
    public void emitIsInstance(Variable incoming, Compilation comp, Target target) {
        InstanceOf.emitIsInstance(this, incoming, comp, target);
    }

    @Override
    public Procedure getConstructor() {
        return null;
    }

    public static Object convertIntegerLiteral(IntNum ivalue, PrimType type, boolean nativeValue) {
        switch (type.getSignature().charAt(0)) {
            case 'B': {
                boolean unsigned;
                boolean bl = unsigned = type == unsignedByteType;
                if (!(unsigned ? ivalue.inRange(0L, 255L) : ivalue.inRange(-128L, 127L))) break;
                byte i = ivalue.byteValue();
                return unsigned && !nativeValue ? UByte.valueOf(i) : Byte.valueOf(i);
            }
            case 'S': {
                boolean unsigned;
                boolean bl = unsigned = type == unsignedShortType;
                if (!(unsigned ? ivalue.inRange(0L, 65535L) : ivalue.inRange(-32768L, 32767L))) break;
                short i = ivalue.shortValue();
                return unsigned && !nativeValue ? UShort.valueOf(i) : Short.valueOf(i);
            }
            case 'I': {
                boolean unsigned;
                boolean bl = unsigned = type == unsignedIntType;
                if (!(unsigned ? ivalue.inRange(0L, 0xFFFFFFFFL) : ivalue.inRange(Integer.MIN_VALUE, Integer.MAX_VALUE))) break;
                int i = ivalue.intValue();
                return unsigned && !nativeValue ? UInt.valueOf(i) : Integer.valueOf(i);
            }
            case 'J': {
                boolean unsigned;
                boolean bl = unsigned = type == unsignedLongType;
                if (!(unsigned ? IntNum.compare(ivalue, 0L) >= 0 && IntNum.compare(ivalue, IntNum.valueOfUnsigned(-1)) <= 0 : ivalue.inRange(Long.MIN_VALUE, Long.MAX_VALUE))) break;
                long i = ivalue.longValue();
                return unsigned && !nativeValue ? ULong.valueOf(i) : Long.valueOf(i);
            }
        }
        return null;
    }

    @Override
    public String encodeType(Language language) {
        if (this == characterType) {
            return "character";
        }
        if (this == characterOrEofType) {
            return "character-or-eof";
        }
        if (this == stringCursorType) {
            return "string-cursor";
        }
        if (this == unsignedLongType) {
            return "ulong";
        }
        if (this == unsignedIntType) {
            return "uint";
        }
        if (this == unsignedShortType) {
            return "ushort";
        }
        if (this == unsignedByteType) {
            return "ubyte";
        }
        return null;
    }

    static {
        characterType.setName("character");
        characterOrEofType = new LangPrimType(Type.intType);
        characterOrEofType.setName("character-or-eof");
        unsignedLongType = new LangPrimType(Type.longType);
        unsignedLongType.setName("ulong");
        LangPrimType.unsignedLongType.isUnsigned = true;
        boxedULongType = ClassType.make("gnu.math.ULong");
        unsignedIntType = new LangPrimType(Type.intType);
        unsignedIntType.setName("uint");
        LangPrimType.unsignedIntType.isUnsigned = true;
        boxedUIntType = ClassType.make("gnu.math.UInt");
        unsignedShortType = new LangPrimType(Type.shortType);
        unsignedShortType.setName("ushort");
        LangPrimType.unsignedShortType.isUnsigned = true;
        boxedUShortType = ClassType.make("gnu.math.UShort");
        unsignedByteType = new LangPrimType(Type.byteType);
        unsignedByteType.setName("ubyte");
        LangPrimType.unsignedByteType.isUnsigned = true;
        boxedUByteType = ClassType.make("gnu.math.UByte");
        stringCursorType = new LangPrimType(Type.intType);
        stringCursorType.setName("string-cursor");
    }
}

