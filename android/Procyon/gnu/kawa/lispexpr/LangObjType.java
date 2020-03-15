// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.expr.ReferenceExp;
import gnu.expr.InlineCalls;
import gnu.kawa.reflect.CompileBuildObject;
import gnu.kawa.functions.MakeDynamic;
import gnu.kawa.functions.MakeList;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.bytecode.PrimType;
import gnu.lists.Sequences;
import gnu.kawa.io.URIPath;
import gnu.kawa.io.FilePath;
import gnu.kawa.io.Path;
import gnu.expr.Declaration;
import gnu.bytecode.CodeAttr;
import gnu.expr.PrimProcedure;
import gnu.bytecode.Method;
import gnu.lists.Blob;
import gnu.kawa.functions.LProcess;
import gnu.lists.U8Vector;
import gnu.kawa.reflect.Invoke;
import gnu.mapping.ProcedureN;
import gnu.mapping.Procedure;
import gnu.lists.FVector;
import gnu.expr.Language;
import gnu.expr.PairClassType;
import gnu.math.IntNum;
import gnu.math.RatNum;
import gnu.math.DFloNum;
import gnu.math.RealNum;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import gnu.math.Numeric;
import gnu.kawa.reflect.InstanceOf;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.bytecode.Variable;
import gnu.kawa.reflect.LazyType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ArrayType;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import gnu.expr.TypeValue;
import gnu.bytecode.SpecialObjectType;

public class LangObjType extends SpecialObjectType implements TypeValue
{
    final int typeCode;
    private static final int PATH_TYPE_CODE = 1;
    private static final int FILEPATH_TYPE_CODE = 2;
    private static final int URI_TYPE_CODE = 3;
    private static final int CLASS_TYPE_CODE = 4;
    private static final int TYPE_TYPE_CODE = 5;
    private static final int CLASSTYPE_TYPE_CODE = 6;
    private static final int INTEGER_TYPE_CODE = 7;
    private static final int RATIONAL_TYPE_CODE = 8;
    private static final int REAL_TYPE_CODE = 9;
    private static final int NUMERIC_TYPE_CODE = 10;
    private static final int LIST_TYPE_CODE = 11;
    private static final int VECTOR_TYPE_CODE = 12;
    private static final int CONST_VECTOR_TYPE_CODE = 13;
    private static final int STRING_TYPE_CODE = 14;
    private static final int REGEX_TYPE_CODE = 15;
    private static final int DFLONUM_TYPE_CODE = 16;
    private static final int S8VECTOR_TYPE_CODE = 17;
    private static final int U8VECTOR_TYPE_CODE = 18;
    private static final int S16VECTOR_TYPE_CODE = 19;
    private static final int U16VECTOR_TYPE_CODE = 20;
    private static final int S32VECTOR_TYPE_CODE = 21;
    private static final int U32VECTOR_TYPE_CODE = 22;
    private static final int S64VECTOR_TYPE_CODE = 23;
    private static final int U64VECTOR_TYPE_CODE = 24;
    private static final int F32VECTOR_TYPE_CODE = 25;
    private static final int F64VECTOR_TYPE_CODE = 26;
    private static final int PROCEDURE_TYPE_CODE = 27;
    private static final int PROMISE_TYPE_CODE = 28;
    private static final int SEQUENCE_TYPE_CODE = 29;
    private static final int DYNAMIC_TYPE_CODE = 30;
    public static final LangObjType pathType;
    public static final LangObjType filepathType;
    public static final LangObjType URIType;
    public static final LangObjType typeClass;
    public static final LangObjType typeType;
    public static final LangObjType typeClassType;
    public static final LangObjType numericType;
    public static final LangObjType realType;
    public static final LangObjType rationalType;
    public static final LangObjType integerType;
    public static final LangObjType dflonumType;
    public static final LangObjType vectorType;
    public static final LangObjType constVectorType;
    public static final LangObjType s8vectorType;
    public static final LangObjType u8vectorType;
    public static final LangObjType s16vectorType;
    public static final LangObjType u16vectorType;
    public static final LangObjType s32vectorType;
    public static final LangObjType u32vectorType;
    public static final LangObjType s64vectorType;
    public static final LangObjType u64vectorType;
    public static final LangObjType f32vectorType;
    public static final LangObjType f64vectorType;
    public static final LangObjType regexType;
    public static final LangObjType stringType;
    public static final LangObjType listType;
    static final ClassType typeArithmetic;
    public static final LangObjType procedureType;
    public static final LangObjType promiseType;
    public static final LangObjType sequenceType;
    public static final LangObjType dynamicType;
    static final String VARARGS_SUFFIX = "";
    public static final ClassType typeLangObjType;
    
    LangObjType(final String name, final String implClass, final int typeCode) {
        super(name, ClassType.make(implClass));
        this.typeCode = typeCode;
    }
    
    public static LangObjType getInstanceFromClass(final String name) {
        if ("gnu.math.IntNum".equals(name)) {
            return LangObjType.integerType;
        }
        if ("gnu.math.DFloNum".equals(name)) {
            return LangObjType.dflonumType;
        }
        if ("gnu.math.RatNum".equals(name)) {
            return LangObjType.rationalType;
        }
        if ("gnu.math.RealNum".equals(name)) {
            return LangObjType.realType;
        }
        if ("gnu.math.Numeric".equals(name)) {
            return LangObjType.numericType;
        }
        if ("gnu.lists.FVector".equals(name)) {
            return LangObjType.vectorType;
        }
        if ("gnu.lists.LList".equals(name)) {
            return LangObjType.listType;
        }
        if ("gnu.kawa.io.Path".equals(name)) {
            return LangObjType.pathType;
        }
        if ("gnu.kawa.io.URIPath".equals(name)) {
            return LangObjType.URIType;
        }
        if ("gnu.kawa.io.FilePath".equals(name)) {
            return LangObjType.filepathType;
        }
        if ("java.lang.Class".equals(name)) {
            return LangObjType.typeClass;
        }
        if ("gnu.bytecode.Type".equals(name)) {
            return LangObjType.typeType;
        }
        if ("gnu.bytecode.ClassType".equals(name)) {
            return LangObjType.typeClassType;
        }
        if ("gnu.lists.F64Vector".equals(name)) {
            return LangObjType.f64vectorType;
        }
        if ("gnu.lists.F32Vector".equals(name)) {
            return LangObjType.f32vectorType;
        }
        if ("gnu.lists.S64Vector".equals(name)) {
            return LangObjType.s64vectorType;
        }
        if ("gnu.lists.S32Vector".equals(name)) {
            return LangObjType.s32vectorType;
        }
        if ("gnu.lists.S16Vector".equals(name)) {
            return LangObjType.s16vectorType;
        }
        if ("gnu.lists.S8Vector".equals(name)) {
            return LangObjType.s8vectorType;
        }
        if ("gnu.lists.U64Vector".equals(name)) {
            return LangObjType.u64vectorType;
        }
        if ("gnu.lists.U32Vector".equals(name)) {
            return LangObjType.u32vectorType;
        }
        if ("gnu.lists.U16Vector".equals(name)) {
            return LangObjType.u16vectorType;
        }
        if ("gnu.lists.U8Vector".equals(name)) {
            return LangObjType.u8vectorType;
        }
        return null;
    }
    
    @Override
    public int isCompatibleWithValue(final Type valueType) {
        if (Type.isSame(this, valueType)) {
            return 2;
        }
        switch (this.typeCode) {
            case 29: {
                if (valueType instanceof ArrayType) {
                    return 1;
                }
                if (LangObjType.stringType.isCompatibleWithValue(valueType) > 0) {
                    return 1;
                }
                break;
            }
            case 30: {
                return (valueType instanceof ObjectType) ? 2 : 1;
            }
        }
        return this.getImplementationType().isCompatibleWithValue(valueType);
    }
    
    @Override
    public int compare(Type other) {
        if (other instanceof LazyType) {
            other = ((LazyType)other).getValueType();
        }
        if (Type.isSame(this, other)) {
            return 0;
        }
        if (other == LangObjType.nullType) {
            return 1;
        }
        switch (this.typeCode) {
            case 4: {
                if (other == LangObjType.typeType || other == LangObjType.typeClassType || other == LangObjType.typeType.implementationType || other == LangObjType.typeClassType.implementationType) {
                    return -1;
                }
                break;
            }
            case 5: {
                if (other == LangObjType.typeClass || other == LangObjType.typeClassType || other == LangObjType.typeClass.implementationType || other == LangObjType.typeClassType.implementationType) {
                    return 1;
                }
            }
            case 6: {
                if (other == LangObjType.typeClass || other == LangObjType.typeClass.implementationType) {
                    return 1;
                }
                if (other == LangObjType.typeType || other == LangObjType.typeClass.implementationType || other == LangObjType.procedureType) {
                    return -1;
                }
                break;
            }
            case 27: {
                if (other == LangObjType.typeClassType) {
                    return 1;
                }
                break;
            }
            case 29: {
                if (other instanceof ArrayType || Type.isCompatibleWithValue(LangObjType.stringType, other) > 0) {
                    return 1;
                }
                break;
            }
        }
        return this.getImplementationType().compare(other);
    }
    
    @Override
    public void emitIsInstance(final Variable incoming, final Compilation comp, final Target target) {
        switch (this.typeCode) {
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26: {
                this.implementationType.emitIsInstance(comp.getCode());
                target.compileFromStack(comp, comp.getLanguage().getTypeFor(Boolean.TYPE));
                break;
            }
            default: {
                InstanceOf.emitIsInstance(this, incoming, comp, target);
                break;
            }
        }
    }
    
    public static Numeric coerceNumeric(Object value) {
        value = Promise.force(value);
        final Numeric rval = Numeric.asNumericOrNull(value);
        if (rval == null && value != null) {
            throw new WrongType(-4, value, LangObjType.numericType);
        }
        return rval;
    }
    
    public static RealNum coerceRealNum(Object value) {
        value = Promise.force(value);
        final RealNum rval = RealNum.asRealNumOrNull(value);
        if (rval == null && value != null) {
            throw new WrongType(-4, value, LangObjType.realType);
        }
        return rval;
    }
    
    public static DFloNum coerceDFloNum(Object value) {
        value = Promise.force(value);
        final DFloNum rval = DFloNum.asDFloNumOrNull(value);
        if (rval == null && value != null) {
            throw new WrongType(-4, value, LangObjType.dflonumType);
        }
        return rval;
    }
    
    public static RatNum coerceRatNum(Object value) {
        value = Promise.force(value);
        final RatNum rval = RatNum.asRatNumOrNull(value);
        if (rval == null && value != null) {
            throw new WrongType(-4, value, LangObjType.rationalType);
        }
        return rval;
    }
    
    public static IntNum coerceIntNum(Object value) {
        value = Promise.force(value);
        final IntNum ival = IntNum.asIntNumOrNull(value);
        if (ival == null && value != null) {
            throw new WrongType(-4, value, LangObjType.integerType);
        }
        return ival;
    }
    
    public static Class coerceToClassOrNull(Object type) {
        type = Promise.force(type);
        if (type instanceof Class) {
            return (Class)type;
        }
        if (type instanceof Type && type instanceof ClassType && !(type instanceof PairClassType)) {
            return ((ClassType)type).getReflectClass();
        }
        return null;
    }
    
    public static Class coerceToClass(final Object obj) {
        final Class coerced = coerceToClassOrNull(obj);
        if (coerced == null && obj != null) {
            throw new ClassCastException("cannot cast " + obj + " to type");
        }
        return coerced;
    }
    
    public static ClassType coerceToClassTypeOrNull(final Object type) {
        if (type instanceof ClassType) {
            return (ClassType)type;
        }
        if (type instanceof Class) {
            final Language language = Language.getDefaultLanguage();
            final Type t = language.getTypeFor((Class)type);
            if (t instanceof ClassType) {
                return (ClassType)t;
            }
        }
        return null;
    }
    
    public static ClassType coerceToClassType(Object obj) {
        obj = Promise.force(obj);
        final ClassType coerced = coerceToClassTypeOrNull(obj);
        if (coerced == null && obj != null) {
            throw new ClassCastException("cannot cast " + obj + " to class-type");
        }
        return coerced;
    }
    
    public static Type coerceToTypeOrNull(Object type) {
        type = Promise.force(type);
        if (type instanceof Type) {
            return (Type)type;
        }
        if (type instanceof Class) {
            final Language language = Language.getDefaultLanguage();
            return language.getTypeFor((Class)type);
        }
        return null;
    }
    
    public static Type coerceToType(final Object obj) {
        final Type coerced = coerceToTypeOrNull(obj);
        if (coerced == null && obj != null) {
            throw new ClassCastException("cannot cast " + obj + " to type");
        }
        return coerced;
    }
    
    public static FVector coerceToConstVector(Object obj) {
        obj = Promise.force(obj);
        if (!(obj instanceof FVector)) {
            throw new ClassCastException("cannot cast " + obj + " to constant-vector");
        }
        final FVector vec = (FVector)obj;
        if (vec.isReadOnly()) {
            return vec;
        }
        throw new ClassCastException("vector is not constant-vector");
    }
    
    public static Procedure coerceToProcedureOrNull(final Object value) {
        final Object obj = Promise.force(value);
        if (obj instanceof Procedure) {
            return (Procedure)obj;
        }
        if (!(obj instanceof LangObjType)) {
            return null;
        }
        final Procedure cons = ((LangObjType)obj).getConstructor();
        if (cons != null) {
            return cons;
        }
        return new ProcedureN() {
            @Override
            public Object applyN(final Object[] args) throws Throwable {
                final int nargs = args.length;
                final Object[] xargs = new Object[nargs + 1];
                System.arraycopy(args, 0, xargs, 1, nargs);
                xargs[0] = obj;
                return Invoke.make.applyN(xargs);
            }
        };
    }
    
    public static Procedure coerceToProcedure(Object obj) {
        obj = Promise.force(obj);
        final Procedure coerced = coerceToProcedureOrNull(obj);
        if (coerced == null && obj != null) {
            throw new ClassCastException("cannot cast " + obj + " to procedure");
        }
        return coerced;
    }
    
    public static U8Vector coerceToU8Vector(final Object obj) {
        if (obj instanceof LProcess) {
            return ((LProcess)obj).getValue().asPlainBytevector();
        }
        if (obj instanceof Blob) {
            return ((Blob)obj).asPlainBytevector();
        }
        return (U8Vector)obj;
    }
    
    Method coercionMethod() {
        switch (this.typeCode) {
            case 4: {
                return LangObjType.typeLangObjType.getDeclaredMethod("coerceToClass", 1);
            }
            case 6: {
                return LangObjType.typeLangObjType.getDeclaredMethod("coerceToClassType", 1);
            }
            case 5: {
                return LangObjType.typeLangObjType.getDeclaredMethod("coerceToType", 1);
            }
            case 27: {
                return LangObjType.typeLangObjType.getDeclaredMethod("coerceToProcedure", 1);
            }
            case 10: {
                return LangObjType.typeLangObjType.getDeclaredMethod("coerceNumeric", 1);
            }
            case 9: {
                return LangObjType.typeLangObjType.getDeclaredMethod("coerceRealNum", 1);
            }
            case 8: {
                return LangObjType.typeLangObjType.getDeclaredMethod("coerceRatNum", 1);
            }
            case 7: {
                return LangObjType.typeLangObjType.getDeclaredMethod("coerceIntNum", 1);
            }
            case 16: {
                return LangObjType.typeLangObjType.getDeclaredMethod("coerceDFloNum", 1);
            }
            case 18: {
                return LangObjType.typeLangObjType.getDeclaredMethod("coerceToU8Vector", 1);
            }
            case 13: {
                return LangObjType.typeLangObjType.getDeclaredMethod("coerceToConstVector", 1);
            }
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26: {
                return null;
            }
            case 29: {
                return ClassType.make("gnu.lists.Sequences").getDeclaredMethod("coerceToSequence", 1);
            }
            default: {
                final Procedure cons = this.getConstructor();
                if (cons == null) {
                    return null;
                }
                return ((PrimProcedure)cons).getMethod();
            }
        }
    }
    
    protected Method coercionOrNullMethod() {
        ClassType methodDeclaringClass = this.implementationType;
        String mname = null;
        switch (this.typeCode) {
            case 1: {
                mname = "coerceToPathOrNull";
                break;
            }
            case 2: {
                mname = "coerceToFilePathOrNull";
                break;
            }
            case 3: {
                mname = "coerceToURIPathOrNull";
                break;
            }
            case 4: {
                methodDeclaringClass = LangObjType.typeLangObjType;
                mname = "coerceToClassOrNull";
                break;
            }
            case 6: {
                methodDeclaringClass = LangObjType.typeLangObjType;
                mname = "coerceToClassTypeOrNull";
                break;
            }
            case 5: {
                methodDeclaringClass = LangObjType.typeLangObjType;
                mname = "coerceToTypeOrNull";
                break;
            }
            case 27: {
                methodDeclaringClass = LangObjType.typeLangObjType;
                mname = "coerceToProcedureOrNull";
                break;
            }
            case 10: {
                methodDeclaringClass = this.implementationType;
                mname = "asNumericOrNull";
                break;
            }
            case 16: {
                methodDeclaringClass = this.implementationType;
                mname = "asDFloNumOrNull";
                break;
            }
            case 9: {
                methodDeclaringClass = this.implementationType;
                mname = "asRealNumOrNull";
                break;
            }
            case 8: {
                methodDeclaringClass = this.implementationType;
                mname = "asRatNumOrNull";
                break;
            }
            case 7: {
                methodDeclaringClass = this.implementationType;
                mname = "asIntNumOrNull";
                break;
            }
            case 29: {
                methodDeclaringClass = ClassType.make("gnu.lists.Sequences");
                mname = "asSequenceOrNull";
                break;
            }
            default: {
                return null;
            }
        }
        return methodDeclaringClass.getDeclaredMethod(mname, 1);
    }
    
    public boolean emitCoercionOrNull(final CodeAttr code) {
        final Method method = this.coercionOrNullMethod();
        if (method == null) {
            return false;
        }
        code.emitInvokeStatic(method);
        return true;
    }
    
    @Override
    public void emitTestIf(final Variable incoming, final Declaration decl, final Compilation comp) {
        final CodeAttr code = comp.getCode();
        if (incoming != null) {
            code.emitLoad(incoming);
        }
        if (this.emitCoercionOrNull(code)) {
            if (decl != null) {
                code.emitDup();
                decl.compileStore(comp);
            }
            code.emitIfNotNull();
        }
        else {
            this.implementationType.emitIsInstance(code);
            code.emitIfIntNotZero();
            if (decl != null) {
                code.emitLoad(incoming);
                this.emitCoerceFromObject(code);
                decl.compileStore(comp);
            }
        }
    }
    
    @Override
    public Object coerceFromObject(final Object obj) {
        switch (this.typeCode) {
            case 1: {
                return Path.valueOf(obj);
            }
            case 2: {
                return FilePath.makeFilePath(obj);
            }
            case 3: {
                return URIPath.makeURI(obj);
            }
            case 4: {
                return coerceToClass(obj);
            }
            case 6: {
                return coerceToClassType(obj);
            }
            case 5: {
                return coerceToType(obj);
            }
            case 27: {
                return coerceToProcedure(obj);
            }
            case 10: {
                return coerceNumeric(obj);
            }
            case 9: {
                return coerceRealNum(obj);
            }
            case 8: {
                return coerceRatNum(obj);
            }
            case 7: {
                return coerceIntNum(obj);
            }
            case 16: {
                return coerceDFloNum(obj);
            }
            case 29: {
                return Sequences.coerceToSequence(obj);
            }
            case 13: {
                return coerceToConstVector(obj);
            }
            default: {
                return super.coerceFromObject(obj);
            }
        }
    }
    
    @Override
    public void emitConvertFromPrimitive(Type stackType, final CodeAttr code) {
        Type argType = null;
        String cname = null;
        String mname = "make";
        switch (this.typeCode) {
            case 16: {
                if (stackType instanceof PrimType) {
                    final char sig1 = stackType.getSignature().charAt(0);
                    if (sig1 == 'I' || sig1 == 'B' || sig1 == 'S' || sig1 == 'J' || sig1 == 'F') {
                        code.emitConvert((PrimType)stackType, Type.doubleType);
                        stackType = Type.doubleType;
                    }
                    if (stackType == Type.doubleType) {
                        cname = "gnu.math.DFloNum";
                        argType = stackType;
                    }
                    break;
                }
                break;
            }
            case 7:
            case 8:
            case 9:
            case 10: {
                if (!(stackType instanceof PrimType)) {
                    break;
                }
                if (stackType == Type.intType || stackType == Type.byteType || stackType == Type.shortType || stackType == LangPrimType.unsignedByteType || stackType == LangPrimType.unsignedShortType) {
                    cname = "gnu.math.IntNum";
                    argType = Type.int_type;
                    break;
                }
                if (stackType == Type.longType || stackType == LangPrimType.unsignedIntType || stackType == LangPrimType.unsignedLongType) {
                    cname = "gnu.math.IntNum";
                    mname = ((stackType == Type.longType) ? "valueOf" : "valueOfUnsigned");
                    argType = stackType.getImplementationType();
                    break;
                }
                if (this.typeCode != 9 && this.typeCode != 10) {
                    break;
                }
                if (stackType == Type.floatType) {
                    code.emitConvert(Type.float_type, Type.double_type);
                    stackType = Type.doubleType;
                }
                if (stackType == Type.doubleType) {
                    cname = "gnu.math.DFloNum";
                    argType = Type.doubleType;
                    break;
                }
                break;
            }
        }
        if (cname != null) {
            final ClassType clas = ClassType.make(cname);
            final Type[] args = { argType };
            code.emitInvokeStatic(clas.getDeclaredMethod(mname, args));
        }
        else {
            super.emitConvertFromPrimitive(stackType, code);
        }
    }
    
    @Override
    public Expression convertValue(final Expression value) {
        if (this.typeCode == 7 || this.typeCode == 10 || this.typeCode == 9 || this.typeCode == 8 || this.typeCode == 16) {
            return null;
        }
        final Method method = this.coercionMethod();
        if (method == null) {
            return null;
        }
        final ApplyExp aexp = new ApplyExp(method, new Expression[] { value });
        aexp.setType(this);
        return aexp;
    }
    
    @Override
    public void emitCoerceFromObject(final CodeAttr code) {
        switch (this.typeCode) {
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 28: {
                code.emitCheckcast(this.implementationType);
                break;
            }
            default: {
                code.emitInvoke(this.coercionMethod());
                break;
            }
        }
    }
    
    public ObjectType getConstructorType() {
        switch (this.typeCode) {
            case 28: {
                return LazyType.promiseType;
            }
            default: {
                return this;
            }
        }
    }
    
    @Override
    public Procedure getConstructor() {
        switch (this.typeCode) {
            case 1: {
                return new PrimProcedure("gnu.kawa.io.Path", "valueOf", 1);
            }
            case 2: {
                return new PrimProcedure("gnu.kawa.io.FilePath", "makeFilePath", 1);
            }
            case 3: {
                return new PrimProcedure("gnu.kawa.io.URIPath", "makeURI", 1);
            }
            case 12: {
                return new PrimProcedure("gnu.lists.FVector", "make", 1);
            }
            case 13: {
                return new PrimProcedure("gnu.lists.FVector", "makeConstant", 1);
            }
            case 11: {
                return MakeList.list;
            }
            case 14: {
                return new PrimProcedure("kawa.lib.strings", "$make$string$", 1);
            }
            case 15: {
                return new PrimProcedure("java.util.regex.Pattern", "compile", 1);
            }
            case 30: {
                return MakeDynamic.instance;
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public String encodeType(final Language language) {
        if (this == LangObjType.sequenceType) {
            return "sequence";
        }
        return null;
    }
    
    public Type getElementType() {
        switch (this.typeCode) {
            case 17: {
                return LangPrimType.byteType;
            }
            case 19: {
                return LangPrimType.shortType;
            }
            case 21: {
                return LangPrimType.intType;
            }
            case 23: {
                return LangPrimType.longType;
            }
            case 18: {
                return LangPrimType.unsignedByteType;
            }
            case 20: {
                return LangPrimType.unsignedShortType;
            }
            case 22: {
                return LangPrimType.unsignedIntType;
            }
            case 24: {
                return LangPrimType.unsignedLongType;
            }
            case 25: {
                return LangPrimType.floatType;
            }
            case 26: {
                return LangPrimType.doubleType;
            }
            default: {
                return null;
            }
        }
    }
    
    public String elementGetterMethodName() {
        switch (this.typeCode) {
            case 17:
            case 18: {
                return "getByte";
            }
            case 19:
            case 20: {
                return "getShort";
            }
            case 21:
            case 22: {
                return "getInt";
            }
            case 23:
            case 24: {
                return "getLong";
            }
            case 25: {
                return "getFloat";
            }
            case 26: {
                return "getDouble";
            }
            default: {
                return null;
            }
        }
    }
    
    public String elementSetterMethodName() {
        final String gname = this.elementGetterMethodName();
        if (gname == null) {
            return null;
        }
        return "set" + gname.substring(3);
    }
    
    public CompileBuildObject getBuildObject() {
        switch (this.typeCode) {
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26: {
                return new SimpleVectorBuilder(this);
            }
            default: {
                return new CompileBuildObject();
            }
        }
    }
    
    static {
        pathType = new LangObjType("path", "gnu.kawa.io.Path", 1);
        filepathType = new LangObjType("filepath", "gnu.kawa.io.FilePath", 2);
        URIType = new LangObjType("URI", "gnu.kawa.io.URIPath", 3);
        typeClass = new LangObjType("class", "java.lang.Class", 4);
        typeType = new LangObjType("type", "gnu.bytecode.Type", 5);
        typeClassType = new LangObjType("class-type", "gnu.bytecode.ClassType", 6);
        numericType = new LangObjType("number", "gnu.math.Numeric", 10);
        realType = new LangObjType("real", "gnu.math.RealNum", 9);
        rationalType = new LangObjType("rational", "gnu.math.RatNum", 8);
        integerType = new LangObjType("integer", "gnu.math.IntNum", 7);
        dflonumType = new LangObjType("DFloNum", "gnu.math.DFloNum", 16);
        vectorType = new LangObjType("vector", "gnu.lists.FVector", 12);
        constVectorType = new LangObjType("constant-vector", "gnu.lists.FVector", 13);
        s8vectorType = new LangObjType("s8vector", "gnu.lists.S8Vector", 17);
        u8vectorType = new LangObjType("u8vector", "gnu.lists.U8Vector", 18);
        s16vectorType = new LangObjType("s16vector", "gnu.lists.S16Vector", 19);
        u16vectorType = new LangObjType("u16vector", "gnu.lists.U16Vector", 20);
        s32vectorType = new LangObjType("s32vector", "gnu.lists.S32Vector", 21);
        u32vectorType = new LangObjType("u32vector", "gnu.lists.U32Vector", 22);
        s64vectorType = new LangObjType("s64vector", "gnu.lists.S64Vector", 23);
        u64vectorType = new LangObjType("u64vector", "gnu.lists.U64Vector", 24);
        f32vectorType = new LangObjType("f32vector", "gnu.lists.F32Vector", 25);
        f64vectorType = new LangObjType("f64vector", "gnu.lists.F64Vector", 26);
        regexType = new LangObjType("regex", "java.util.regex.Pattern", 15);
        stringType = new LangObjType("string", "java.lang.CharSequence", 14);
        listType = new LangObjType("list", "gnu.lists.LList", 11);
        typeArithmetic = ClassType.make("gnu.kawa.functions.Arithmetic");
        procedureType = new LangObjType("procedure", "gnu.mapping.Procedure", 27);
        promiseType = new LangObjType("promise", "gnu.mapping.Lazy", 28);
        sequenceType = new LangObjType("sequence", "java.util.List", 29);
        dynamicType = new LangObjType("dynamic", "java.lang.Object", 30);
        typeLangObjType = ClassType.make("gnu.kawa.lispexpr.LangObjType");
    }
    
    public static class SimpleVectorBuilder extends CompileBuildObject
    {
        Type elementType;
        PrimProcedure addProc;
        
        public SimpleVectorBuilder(final LangObjType vectorType) {
            this.elementType = vectorType.getElementType();
            final Method addMethod = ((ClassType)vectorType.getImplementationType()).getMethod("add", new Type[] { this.elementType.getImplementationType() });
            this.addProc = new PrimProcedure(addMethod, Type.voidType, new Type[] { this.elementType });
        }
        
        @Override
        public boolean useBuilder(final int numCode, final InlineCalls visitor) {
            return (this.numKeywordArgs() == 0 && this.hasDefaultConstructor()) || super.useBuilder(numCode, visitor);
        }
        
        @Override
        public Expression buildAddChild(final Declaration target, final Expression child) {
            return new ApplyExp(this.addProc, new Expression[] { new ReferenceExp(target), child });
        }
    }
}
