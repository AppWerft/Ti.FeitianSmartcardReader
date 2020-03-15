// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.math.IntNum;
import gnu.mapping.Procedure;
import gnu.kawa.reflect.InstanceOf;
import gnu.expr.Target;
import gnu.expr.Expression;
import gnu.expr.Declaration;
import gnu.bytecode.Variable;
import gnu.kawa.reflect.LazyType;
import gnu.bytecode.Method;
import gnu.expr.Compilation;
import gnu.bytecode.CodeAttr;
import gnu.mapping.Values;
import gnu.math.UByte;
import gnu.math.UShort;
import gnu.math.UInt;
import gnu.lists.Sequence;
import gnu.text.Char;
import gnu.math.ULong;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import gnu.expr.Language;
import gnu.expr.TypeValue;
import gnu.bytecode.PrimType;

public class LangPrimType extends PrimType implements TypeValue
{
    Language language;
    PrimType implementationType;
    boolean isUnsigned;
    public static final PrimType byteType;
    public static final PrimType shortType;
    public static final PrimType intType;
    public static final PrimType longType;
    public static final PrimType floatType;
    public static final PrimType doubleType;
    public static final LangPrimType charType;
    public static final PrimType voidType;
    static final ClassType scmCharType;
    static final ClassType boxedStringCursorType;
    public static final LangPrimType characterType;
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
    
    public LangPrimType(final PrimType type) {
        super(type);
        this.implementationType = type;
    }
    
    public LangPrimType(final PrimType type, final Language language) {
        super(type);
        this.language = language;
        this.implementationType = type;
    }
    
    public LangPrimType(final String nam, final String sig, final int siz, final Class reflectClass) {
        super(nam, sig, siz, reflectClass);
    }
    
    public LangPrimType(final String nam, final String sig, final int siz, final Class reflectClass, final Language language) {
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
        if (this == LangPrimType.characterType) {
            return LangPrimType.scmCharType;
        }
        if (this == LangPrimType.stringCursorType) {
            return LangPrimType.boxedStringCursorType;
        }
        if (this == LangPrimType.characterOrEofType) {
            return Type.objectType;
        }
        if (this == LangPrimType.unsignedLongType) {
            return LangPrimType.boxedULongType;
        }
        if (this == LangPrimType.unsignedIntType) {
            return LangPrimType.boxedUIntType;
        }
        if (this == LangPrimType.unsignedShortType) {
            return LangPrimType.boxedUShortType;
        }
        if (this == LangPrimType.unsignedByteType) {
            return LangPrimType.boxedUByteType;
        }
        return super.boxedType();
    }
    
    @Override
    public Object coerceFromObject(final Object obj) {
        if (obj.getClass() == this.reflectClass) {
            return obj;
        }
        final char sig1 = this.getSignature().charAt(0);
        switch (sig1) {
            case 'J': {
                if (this.isUnsigned()) {
                    return ULong.valueOf(((Number)obj).longValue());
                }
                break;
            }
            case 'I': {
                if (this == LangPrimType.characterType || this == LangPrimType.characterOrEofType) {
                    if (obj instanceof Integer) {
                        return obj;
                    }
                    int ival;
                    if (obj instanceof Char) {
                        ival = ((Char)obj).intValue();
                    }
                    else if (obj == Sequence.eofValue && this == LangPrimType.characterOrEofType) {
                        ival = -1;
                    }
                    else {
                        ival = (char)obj;
                    }
                    return ival;
                }
                else {
                    if (this.isUnsigned()) {
                        return UInt.valueOf(((Number)obj).intValue());
                    }
                    break;
                }
                break;
            }
            case 'S': {
                if (this.isUnsigned()) {
                    return UShort.valueOf(((Number)obj).shortValue());
                }
                break;
            }
            case 'B': {
                if (this.isUnsigned()) {
                    return UByte.valueOf(((Number)obj).byteValue());
                }
                break;
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
    public char charValue(final Object value) {
        if (value instanceof Character) {
            return (char)value;
        }
        return ((Char)value).charValue();
    }
    
    @Override
    public void emitIsInstance(final CodeAttr code) {
        final char sig1 = this.getSignature().charAt(0);
        switch (sig1) {
            case 'I': {
                final String mname = (this == LangPrimType.characterType) ? "isChar" : ((this == LangPrimType.characterOrEofType) ? "isCharOrEof" : null);
                if (mname != null) {
                    code.emitInvokeStatic(LangPrimType.scmCharType.getDeclaredMethod(mname, 1));
                    return;
                }
                break;
            }
            case 'C': {
                final ClassType scmCharType = ClassType.make("gnu.text.Char");
                code.emitInvokeStatic(scmCharType.getDeclaredMethod("isChar", 1));
                return;
            }
        }
        super.emitIsInstance(code);
    }
    
    @Override
    public void emitCoerceFromObject(final CodeAttr code) {
        final char sig1 = this.getSignature().charAt(0);
        switch (sig1) {
            case 'I': {
                if (this == LangPrimType.characterType || this == LangPrimType.characterOrEofType) {
                    final Type top = code.topType();
                    if (top == LangPrimType.javalangCharacterType) {
                        code.emitInvokeVirtual(LangPrimType.javalangCharacterType.getDeclaredMethod("charValue", 0));
                        return;
                    }
                    if (top == LangPrimType.scmCharType) {
                        code.emitInvokeVirtual(LangPrimType.scmCharType.getDeclaredMethod("intValue", 0));
                        return;
                    }
                }
                if (this == LangPrimType.stringCursorType) {
                    LangPrimType.boxedStringCursorType.emitCoerceFromObject(code);
                    code.emitInvoke(LangPrimType.boxedStringCursorType.getDeclaredMethod("getValue", 0));
                    return;
                }
                final String mname = (this == LangPrimType.characterType) ? "castToCharacter" : ((this == LangPrimType.characterOrEofType) ? "castToCharacterOrEof" : null);
                if (mname != null) {
                    code.emitInvokeStatic(LangPrimType.scmCharType.getDeclaredMethod(mname, 1));
                    return;
                }
                break;
            }
            case 'Z': {
                Compilation.getCurrent().emitCoerceToBoolean();
                return;
            }
            case 'C': {
                if (code.topType() == LangPrimType.javalangCharacterType) {
                    code.emitInvokeVirtual(LangPrimType.javalangCharacterType.getDeclaredMethod("charValue", 0));
                    return;
                }
                final Method charValueMethod = LangPrimType.scmCharType.getDeclaredMethod("castToChar", 1);
                code.emitInvokeStatic(charValueMethod);
                return;
            }
        }
        super.emitCoerceFromObject(code);
    }
    
    @Override
    public Object coerceToObject(final Object obj) {
        final char sig1 = this.getSignature().charAt(0);
        switch (sig1) {
            case 'I': {
                if (this != LangPrimType.characterType && this != LangPrimType.characterOrEofType) {
                    break;
                }
                if (obj instanceof Integer) {
                    final int ival = (int)obj;
                    if (ival >= 0) {
                        return Char.make(ival);
                    }
                    if (ival == -1 && this == LangPrimType.characterOrEofType) {
                        return Sequence.eofValue;
                    }
                }
                if (obj instanceof Char && obj == Sequence.eofValue && this == LangPrimType.characterOrEofType) {
                    return obj;
                }
                break;
            }
            case 'Z': {
                return this.language.booleanObject((boolean)obj);
            }
            case 'C': {
                if (obj instanceof Char) {
                    return obj;
                }
                return Char.make((char)obj);
            }
            case 'V': {
                return Values.empty;
            }
        }
        return super.coerceToObject(obj);
    }
    
    @Override
    public Object convertToRaw(final Object obj) {
        if (this == LangPrimType.characterType || this == LangPrimType.characterOrEofType) {
            if (obj instanceof Char) {
                return ((Char)obj).intValue();
            }
            if (obj == Sequence.eofValue && this == LangPrimType.characterOrEofType) {
                return -1;
            }
        }
        return obj;
    }
    
    @Override
    public void emitCoerceToObject(final CodeAttr code) {
        final char sig1 = this.getSignature().charAt(0);
        final Type argType = null;
        final String cname = null;
        switch (sig1) {
            case 'I': {
                final String mname = (this == LangPrimType.characterType) ? "make" : ((this == LangPrimType.characterOrEofType) ? "makeOrEof" : null);
                if (mname != null) {
                    final Method makeCharMethod = LangPrimType.scmCharType.getDeclaredMethod(mname, 1);
                    code.emitInvokeStatic(makeCharMethod);
                    break;
                }
                super.emitCoerceToObject(code);
                break;
            }
            case 'Z': {
                final Compilation comp = Compilation.getCurrent();
                code.emitIfIntNotZero();
                comp.emitPushBoolean(true);
                code.emitElse();
                comp.emitPushBoolean(false);
                code.emitFi();
                break;
            }
            case 'C': {
                final ClassType scmCharType = ClassType.make("gnu.text.Char");
                final Method makeCharMethod2 = scmCharType.getDeclaredMethod("make", 1);
                code.emitInvokeStatic(makeCharMethod2);
                break;
            }
            default: {
                super.emitCoerceToObject(code);
                break;
            }
        }
        if (cname != null) {
            final ClassType clas = ClassType.make(cname);
            final Type[] args = { argType };
            code.emitInvokeStatic(clas.getDeclaredMethod("make", args));
        }
    }
    
    @Override
    public int compare(Type other) {
        if (other instanceof LazyType) {
            other = ((LazyType)other).getValueType();
        }
        final char sig1 = this.getSignature().charAt(0);
        final char sig2 = other.getSignature().charAt(0);
        if (sig1 == 'Z') {
            return this.implementationType.compare(other);
        }
        if (this == other) {
            return 0;
        }
        if (this == LangPrimType.stringCursorType) {
            return (other == Type.objectType) ? -1 : -3;
        }
        if (this == LangPrimType.charType) {
            if (other == LangPrimType.characterType || other == LangPrimType.characterOrEofType || other == LangPrimType.scmCharType) {
                return -1;
            }
            return this.getImplementationType().compare(other);
        }
        else if (this == LangPrimType.characterType) {
            if (other == LangPrimType.characterOrEofType) {
                return -1;
            }
            if (other == LangPrimType.charType || sig2 == 'C') {
                return 1;
            }
            return LangPrimType.scmCharType.compare(other);
        }
        else if (this == LangPrimType.characterOrEofType) {
            if (other == LangPrimType.characterType || other == ClassType.make("gnu.lists.EofClass") || other == LangPrimType.charType || other == LangPrimType.scmCharType || sig2 == 'C') {
                return 1;
            }
            return (other == Type.objectType) ? -1 : -3;
        }
        else {
            if (other instanceof PrimType) {
                return this.getImplementationType().compare(other);
            }
            if (sig1 == 'V') {
                return 1;
            }
            if (other instanceof LangObjType) {
                return Type.swappedCompareResult(other.compare(this));
            }
            return super.compare(other);
        }
    }
    
    @Override
    public int isCompatibleWithValue(final Type valueType) {
        if (this == LangPrimType.charType && valueType == Type.charType) {
            return 2;
        }
        int r = super.isCompatibleWithValue(valueType);
        if (r < 0 && this.getSignature().charAt(0) == 'Z') {
            r = 0;
        }
        return r;
    }
    
    @Override
    public void emitTestIf(final Variable incoming, final Declaration decl, final Compilation comp) {
        final CodeAttr code = comp.getCode();
        final char sig1 = this.getSignature().charAt(0);
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
            }
            default: {
                if (this == LangPrimType.characterType || this == LangPrimType.characterOrEofType || this == LangPrimType.charType) {
                    code.emitInvokeStatic(LangPrimType.scmCharType.getDeclaredMethod("checkCharOrEof", 1));
                }
                else if (this == LangPrimType.stringCursorType) {
                    code.emitInvokeStatic(LangPrimType.boxedStringCursorType.getDeclaredMethod("checkStringCursor", 1));
                }
                if (decl != null) {
                    code.emitDup();
                    decl.compileStore(comp);
                }
                if (this == LangPrimType.characterType || this == LangPrimType.stringCursorType) {
                    code.emitIfIntGEqZero();
                }
                else if (this == LangPrimType.charType) {
                    code.emitPushInt(16);
                    code.emitUshr();
                    code.emitIfIntEqZero();
                }
                else if (this == LangPrimType.characterOrEofType) {
                    code.emitPushInt(-1);
                    code.emitIfIntGEq();
                }
                else {
                    this.emitIsInstance(code);
                    code.emitIfIntNotZero();
                }
            }
        }
    }
    
    @Override
    public Expression convertValue(final Expression value) {
        return null;
    }
    
    @Override
    public void emitIsInstance(final Variable incoming, final Compilation comp, final Target target) {
        InstanceOf.emitIsInstance(this, incoming, comp, target);
    }
    
    @Override
    public Procedure getConstructor() {
        return null;
    }
    
    public static Object convertIntegerLiteral(final IntNum ivalue, final PrimType type, final boolean nativeValue) {
        switch (type.getSignature().charAt(0)) {
            case 'B': {
                final boolean unsigned = type == LangPrimType.unsignedByteType;
                if (unsigned) {
                    if (!ivalue.inRange(0L, 255L)) {
                        break;
                    }
                }
                else if (!ivalue.inRange(-128L, 127L)) {
                    break;
                }
                final byte i = ivalue.byteValue();
                return (unsigned && !nativeValue) ? UByte.valueOf(i) : Byte.valueOf(i);
            }
            case 'S': {
                final boolean unsigned = type == LangPrimType.unsignedShortType;
                if (unsigned) {
                    if (!ivalue.inRange(0L, 65535L)) {
                        break;
                    }
                }
                else if (!ivalue.inRange(-32768L, 32767L)) {
                    break;
                }
                final short j = ivalue.shortValue();
                return (unsigned && !nativeValue) ? UShort.valueOf(j) : Short.valueOf(j);
            }
            case 'I': {
                final boolean unsigned = type == LangPrimType.unsignedIntType;
                if (unsigned) {
                    if (!ivalue.inRange(0L, 4294967295L)) {
                        break;
                    }
                }
                else if (!ivalue.inRange(-2147483648L, 2147483647L)) {
                    break;
                }
                final int k = ivalue.intValue();
                return (unsigned && !nativeValue) ? UInt.valueOf(k) : Integer.valueOf(k);
            }
            case 'J': {
                final boolean unsigned = type == LangPrimType.unsignedLongType;
                if (unsigned) {
                    if (IntNum.compare(ivalue, 0L) < 0 || IntNum.compare(ivalue, IntNum.valueOfUnsigned(-1)) > 0) {
                        break;
                    }
                }
                else if (!ivalue.inRange(Long.MIN_VALUE, Long.MAX_VALUE)) {
                    break;
                }
                final long l = ivalue.longValue();
                return (unsigned && !nativeValue) ? ULong.valueOf(l) : Long.valueOf(l);
            }
        }
        return null;
    }
    
    @Override
    public String encodeType(final Language language) {
        if (this == LangPrimType.characterType) {
            return "character";
        }
        if (this == LangPrimType.characterOrEofType) {
            return "character-or-eof";
        }
        if (this == LangPrimType.stringCursorType) {
            return "string-cursor";
        }
        if (this == LangPrimType.unsignedLongType) {
            return "ulong";
        }
        if (this == LangPrimType.unsignedIntType) {
            return "uint";
        }
        if (this == LangPrimType.unsignedShortType) {
            return "ushort";
        }
        if (this == LangPrimType.unsignedByteType) {
            return "ubyte";
        }
        return null;
    }
    
    static {
        byteType = Type.byteType;
        shortType = Type.shortType;
        intType = Type.intType;
        longType = Type.longType;
        floatType = Type.floatType;
        doubleType = Type.doubleType;
        charType = new LangPrimType(Type.charType);
        voidType = Type.voidType;
        scmCharType = ClassType.make("gnu.text.Char");
        boxedStringCursorType = ClassType.make("gnu.text.StringCursor");
        (characterType = new LangPrimType(Type.intType)).setName("character");
        (characterOrEofType = new LangPrimType(Type.intType)).setName("character-or-eof");
        (unsignedLongType = new LangPrimType(Type.longType)).setName("ulong");
        LangPrimType.unsignedLongType.isUnsigned = true;
        boxedULongType = ClassType.make("gnu.math.ULong");
        (unsignedIntType = new LangPrimType(Type.intType)).setName("uint");
        LangPrimType.unsignedIntType.isUnsigned = true;
        boxedUIntType = ClassType.make("gnu.math.UInt");
        (unsignedShortType = new LangPrimType(Type.shortType)).setName("ushort");
        LangPrimType.unsignedShortType.isUnsigned = true;
        boxedUShortType = ClassType.make("gnu.math.UShort");
        (unsignedByteType = new LangPrimType(Type.byteType)).setName("ubyte");
        LangPrimType.unsignedByteType.isUnsigned = true;
        boxedUByteType = ClassType.make("gnu.math.UByte");
        (stringCursorType = new LangPrimType(Type.intType)).setName("string-cursor");
    }
}
