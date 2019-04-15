/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.SpecialObjectType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Language;
import gnu.expr.PairClassType;
import gnu.expr.PrimProcedure;
import gnu.expr.ReferenceExp;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.kawa.functions.LProcess;
import gnu.kawa.functions.MakeDynamic;
import gnu.kawa.functions.MakeList;
import gnu.kawa.io.FilePath;
import gnu.kawa.io.Path;
import gnu.kawa.io.URIPath;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.CompileBuildObject;
import gnu.kawa.reflect.InstanceOf;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.LazyType;
import gnu.lists.Blob;
import gnu.lists.FVector;
import gnu.lists.Sequences;
import gnu.lists.U8Vector;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Promise;
import gnu.mapping.WrongType;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RatNum;
import gnu.math.RealNum;

public class LangObjType
extends SpecialObjectType
implements TypeValue {
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
    public static final LangObjType pathType = new LangObjType("path", "gnu.kawa.io.Path", 1);
    public static final LangObjType filepathType = new LangObjType("filepath", "gnu.kawa.io.FilePath", 2);
    public static final LangObjType URIType = new LangObjType("URI", "gnu.kawa.io.URIPath", 3);
    public static final LangObjType typeClass = new LangObjType("class", "java.lang.Class", 4);
    public static final LangObjType typeType = new LangObjType("type", "gnu.bytecode.Type", 5);
    public static final LangObjType typeClassType = new LangObjType("class-type", "gnu.bytecode.ClassType", 6);
    public static final LangObjType numericType = new LangObjType("number", "gnu.math.Numeric", 10);
    public static final LangObjType realType = new LangObjType("real", "gnu.math.RealNum", 9);
    public static final LangObjType rationalType = new LangObjType("rational", "gnu.math.RatNum", 8);
    public static final LangObjType integerType = new LangObjType("integer", "gnu.math.IntNum", 7);
    public static final LangObjType dflonumType = new LangObjType("DFloNum", "gnu.math.DFloNum", 16);
    public static final LangObjType vectorType = new LangObjType("vector", "gnu.lists.FVector", 12);
    public static final LangObjType constVectorType = new LangObjType("constant-vector", "gnu.lists.FVector", 13);
    public static final LangObjType s8vectorType = new LangObjType("s8vector", "gnu.lists.S8Vector", 17);
    public static final LangObjType u8vectorType = new LangObjType("u8vector", "gnu.lists.U8Vector", 18);
    public static final LangObjType s16vectorType = new LangObjType("s16vector", "gnu.lists.S16Vector", 19);
    public static final LangObjType u16vectorType = new LangObjType("u16vector", "gnu.lists.U16Vector", 20);
    public static final LangObjType s32vectorType = new LangObjType("s32vector", "gnu.lists.S32Vector", 21);
    public static final LangObjType u32vectorType = new LangObjType("u32vector", "gnu.lists.U32Vector", 22);
    public static final LangObjType s64vectorType = new LangObjType("s64vector", "gnu.lists.S64Vector", 23);
    public static final LangObjType u64vectorType = new LangObjType("u64vector", "gnu.lists.U64Vector", 24);
    public static final LangObjType f32vectorType = new LangObjType("f32vector", "gnu.lists.F32Vector", 25);
    public static final LangObjType f64vectorType = new LangObjType("f64vector", "gnu.lists.F64Vector", 26);
    public static final LangObjType regexType = new LangObjType("regex", "java.util.regex.Pattern", 15);
    public static final LangObjType stringType = new LangObjType("string", "java.lang.CharSequence", 14);
    public static final LangObjType listType = new LangObjType("list", "gnu.lists.LList", 11);
    static final ClassType typeArithmetic = ClassType.make("gnu.kawa.functions.Arithmetic");
    public static final LangObjType procedureType = new LangObjType("procedure", "gnu.mapping.Procedure", 27);
    public static final LangObjType promiseType = new LangObjType("promise", "gnu.mapping.Lazy", 28);
    public static final LangObjType sequenceType = new LangObjType("sequence", "java.util.List", 29);
    public static final LangObjType dynamicType = new LangObjType("dynamic", "java.lang.Object", 30);
    static final String VARARGS_SUFFIX = "";
    public static final ClassType typeLangObjType = ClassType.make("gnu.kawa.lispexpr.LangObjType");

    LangObjType(String name, String implClass, int typeCode) {
        super(name, ClassType.make(implClass));
        this.typeCode = typeCode;
    }

    public static LangObjType getInstanceFromClass(String name) {
        if ("gnu.math.IntNum".equals(name)) {
            return integerType;
        }
        if ("gnu.math.DFloNum".equals(name)) {
            return dflonumType;
        }
        if ("gnu.math.RatNum".equals(name)) {
            return rationalType;
        }
        if ("gnu.math.RealNum".equals(name)) {
            return realType;
        }
        if ("gnu.math.Numeric".equals(name)) {
            return numericType;
        }
        if ("gnu.lists.FVector".equals(name)) {
            return vectorType;
        }
        if ("gnu.lists.LList".equals(name)) {
            return listType;
        }
        if ("gnu.kawa.io.Path".equals(name)) {
            return pathType;
        }
        if ("gnu.kawa.io.URIPath".equals(name)) {
            return URIType;
        }
        if ("gnu.kawa.io.FilePath".equals(name)) {
            return filepathType;
        }
        if ("java.lang.Class".equals(name)) {
            return typeClass;
        }
        if ("gnu.bytecode.Type".equals(name)) {
            return typeType;
        }
        if ("gnu.bytecode.ClassType".equals(name)) {
            return typeClassType;
        }
        if ("gnu.lists.F64Vector".equals(name)) {
            return f64vectorType;
        }
        if ("gnu.lists.F32Vector".equals(name)) {
            return f32vectorType;
        }
        if ("gnu.lists.S64Vector".equals(name)) {
            return s64vectorType;
        }
        if ("gnu.lists.S32Vector".equals(name)) {
            return s32vectorType;
        }
        if ("gnu.lists.S16Vector".equals(name)) {
            return s16vectorType;
        }
        if ("gnu.lists.S8Vector".equals(name)) {
            return s8vectorType;
        }
        if ("gnu.lists.U64Vector".equals(name)) {
            return u64vectorType;
        }
        if ("gnu.lists.U32Vector".equals(name)) {
            return u32vectorType;
        }
        if ("gnu.lists.U16Vector".equals(name)) {
            return u16vectorType;
        }
        if ("gnu.lists.U8Vector".equals(name)) {
            return u8vectorType;
        }
        return null;
    }

    @Override
    public int isCompatibleWithValue(Type valueType) {
        if (Type.isSame(this, valueType)) {
            return 2;
        }
        switch (this.typeCode) {
            case 29: {
                if (valueType instanceof ArrayType) {
                    return 1;
                }
                if (stringType.isCompatibleWithValue(valueType) <= 0) break;
                return 1;
            }
            case 30: {
                return valueType instanceof ObjectType ? 2 : 1;
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
        if (other == nullType) {
            return 1;
        }
        switch (this.typeCode) {
            case 4: {
                if (other != typeType && other != typeClassType && other != LangObjType.typeType.implementationType && other != LangObjType.typeClassType.implementationType) break;
                return -1;
            }
            case 5: {
                if (other == typeClass || other == typeClassType || other == LangObjType.typeClass.implementationType || other == LangObjType.typeClassType.implementationType) {
                    return 1;
                }
            }
            case 6: {
                if (other == typeClass || other == LangObjType.typeClass.implementationType) {
                    return 1;
                }
                if (other != typeType && other != LangObjType.typeClass.implementationType && other != procedureType) break;
                return -1;
            }
            case 27: {
                if (other != typeClassType) break;
                return 1;
            }
            case 29: {
                if (!(other instanceof ArrayType) && LangObjType.isCompatibleWithValue(stringType, other) <= 0) break;
                return 1;
            }
        }
        return this.getImplementationType().compare(other);
    }

    @Override
    public void emitIsInstance(Variable incoming, Compilation comp, Target target) {
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
            }
        }
    }

    public static Numeric coerceNumeric(Object value) {
        Numeric rval = Numeric.asNumericOrNull(value = Promise.force(value));
        if (rval == null && value != null) {
            throw new WrongType(-4, value, numericType);
        }
        return rval;
    }

    public static RealNum coerceRealNum(Object value) {
        RealNum rval = RealNum.asRealNumOrNull(value = Promise.force(value));
        if (rval == null && value != null) {
            throw new WrongType(-4, value, realType);
        }
        return rval;
    }

    public static DFloNum coerceDFloNum(Object value) {
        DFloNum rval = DFloNum.asDFloNumOrNull(value = Promise.force(value));
        if (rval == null && value != null) {
            throw new WrongType(-4, value, dflonumType);
        }
        return rval;
    }

    public static RatNum coerceRatNum(Object value) {
        RatNum rval = RatNum.asRatNumOrNull(value = Promise.force(value));
        if (rval == null && value != null) {
            throw new WrongType(-4, value, rationalType);
        }
        return rval;
    }

    public static IntNum coerceIntNum(Object value) {
        IntNum ival = IntNum.asIntNumOrNull(value = Promise.force(value));
        if (ival == null && value != null) {
            throw new WrongType(-4, value, integerType);
        }
        return ival;
    }

    public static Class coerceToClassOrNull(Object type) {
        if ((type = Promise.force(type)) instanceof Class) {
            return (Class)type;
        }
        if (type instanceof Type && type instanceof ClassType && !(type instanceof PairClassType)) {
            return ((ClassType)type).getReflectClass();
        }
        return null;
    }

    public static Class coerceToClass(Object obj) {
        Class coerced = LangObjType.coerceToClassOrNull(obj);
        if (coerced == null && obj != null) {
            throw new ClassCastException("cannot cast " + obj + " to type");
        }
        return coerced;
    }

    public static ClassType coerceToClassTypeOrNull(Object type) {
        Language language;
        Type t;
        if (type instanceof ClassType) {
            return (ClassType)type;
        }
        if (type instanceof Class && (t = (language = Language.getDefaultLanguage()).getTypeFor((Class)type)) instanceof ClassType) {
            return (ClassType)t;
        }
        return null;
    }

    public static ClassType coerceToClassType(Object obj) {
        ClassType coerced = LangObjType.coerceToClassTypeOrNull(obj = Promise.force(obj));
        if (coerced == null && obj != null) {
            throw new ClassCastException("cannot cast " + obj + " to class-type");
        }
        return coerced;
    }

    public static Type coerceToTypeOrNull(Object type) {
        if ((type = Promise.force(type)) instanceof Type) {
            return (Type)type;
        }
        if (type instanceof Class) {
            Language language = Language.getDefaultLanguage();
            return language.getTypeFor((Class)type);
        }
        return null;
    }

    public static Type coerceToType(Object obj) {
        Type coerced = LangObjType.coerceToTypeOrNull(obj);
        if (coerced == null && obj != null) {
            throw new ClassCastException("cannot cast " + obj + " to type");
        }
        return coerced;
    }

    public static FVector coerceToConstVector(Object obj) {
        if ((obj = Promise.force(obj)) instanceof FVector) {
            FVector vec = (FVector)obj;
            if (vec.isReadOnly()) {
                return vec;
            }
            throw new ClassCastException("vector is not constant-vector");
        }
        throw new ClassCastException("cannot cast " + obj + " to constant-vector");
    }

    public static Procedure coerceToProcedureOrNull(Object value) {
        final Object obj = Promise.force(value);
        if (obj instanceof Procedure) {
            return (Procedure)obj;
        }
        if (obj instanceof LangObjType) {
            Procedure cons = ((LangObjType)obj).getConstructor();
            if (cons != null) {
                return cons;
            }
            return new ProcedureN(){

                @Override
                public Object applyN(Object[] args) throws Throwable {
                    int nargs = args.length;
                    Object[] xargs = new Object[nargs + 1];
                    System.arraycopy(args, 0, xargs, 1, nargs);
                    xargs[0] = obj;
                    return Invoke.make.applyN(xargs);
                }
            };
        }
        return null;
    }

    public static Procedure coerceToProcedure(Object obj) {
        Procedure coerced = LangObjType.coerceToProcedureOrNull(obj = Promise.force(obj));
        if (coerced == null && obj != null) {
            throw new ClassCastException("cannot cast " + obj + " to procedure");
        }
        return coerced;
    }

    public static U8Vector coerceToU8Vector(Object obj) {
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
                return typeLangObjType.getDeclaredMethod("coerceToClass", 1);
            }
            case 6: {
                return typeLangObjType.getDeclaredMethod("coerceToClassType", 1);
            }
            case 5: {
                return typeLangObjType.getDeclaredMethod("coerceToType", 1);
            }
            case 27: {
                return typeLangObjType.getDeclaredMethod("coerceToProcedure", 1);
            }
            case 10: {
                return typeLangObjType.getDeclaredMethod("coerceNumeric", 1);
            }
            case 9: {
                return typeLangObjType.getDeclaredMethod("coerceRealNum", 1);
            }
            case 8: {
                return typeLangObjType.getDeclaredMethod("coerceRatNum", 1);
            }
            case 7: {
                return typeLangObjType.getDeclaredMethod("coerceIntNum", 1);
            }
            case 16: {
                return typeLangObjType.getDeclaredMethod("coerceDFloNum", 1);
            }
            case 18: {
                return typeLangObjType.getDeclaredMethod("coerceToU8Vector", 1);
            }
            case 13: {
                return typeLangObjType.getDeclaredMethod("coerceToConstVector", 1);
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
        }
        Procedure cons = this.getConstructor();
        if (cons == null) {
            return null;
        }
        return ((PrimProcedure)cons).getMethod();
    }

    protected Method coercionOrNullMethod() {
        String mname;
        ClassType methodDeclaringClass = this.implementationType;
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
                methodDeclaringClass = typeLangObjType;
                mname = "coerceToClassOrNull";
                break;
            }
            case 6: {
                methodDeclaringClass = typeLangObjType;
                mname = "coerceToClassTypeOrNull";
                break;
            }
            case 5: {
                methodDeclaringClass = typeLangObjType;
                mname = "coerceToTypeOrNull";
                break;
            }
            case 27: {
                methodDeclaringClass = typeLangObjType;
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

    public boolean emitCoercionOrNull(CodeAttr code) {
        Method method = this.coercionOrNullMethod();
        if (method == null) {
            return false;
        }
        code.emitInvokeStatic(method);
        return true;
    }

    @Override
    public void emitTestIf(Variable incoming, Declaration decl, Compilation comp) {
        CodeAttr code = comp.getCode();
        if (incoming != null) {
            code.emitLoad(incoming);
        }
        if (this.emitCoercionOrNull(code)) {
            if (decl != null) {
                code.emitDup();
                decl.compileStore(comp);
            }
            code.emitIfNotNull();
        } else {
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
    public Object coerceFromObject(Object obj) {
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
                return LangObjType.coerceToClass(obj);
            }
            case 6: {
                return LangObjType.coerceToClassType(obj);
            }
            case 5: {
                return LangObjType.coerceToType(obj);
            }
            case 27: {
                return LangObjType.coerceToProcedure(obj);
            }
            case 10: {
                return LangObjType.coerceNumeric(obj);
            }
            case 9: {
                return LangObjType.coerceRealNum(obj);
            }
            case 8: {
                return LangObjType.coerceRatNum(obj);
            }
            case 7: {
                return LangObjType.coerceIntNum(obj);
            }
            case 16: {
                return LangObjType.coerceDFloNum(obj);
            }
            case 29: {
                return Sequences.coerceToSequence(obj);
            }
            case 13: {
                return LangObjType.coerceToConstVector(obj);
            }
        }
        return super.coerceFromObject(obj);
    }

    @Override
    public void emitConvertFromPrimitive(Type stackType, CodeAttr code) {
        Type argType = null;
        String cname = null;
        String mname = "make";
        switch (this.typeCode) {
            case 16: {
                if (!(stackType instanceof PrimType)) break;
                char sig1 = stackType.getSignature().charAt(0);
                if (sig1 == 'I' || sig1 == 'B' || sig1 == 'S' || sig1 == 'J' || sig1 == 'F') {
                    code.emitConvert((PrimType)stackType, Type.doubleType);
                    stackType = Type.doubleType;
                }
                if (stackType != Type.doubleType) break;
                cname = "gnu.math.DFloNum";
                argType = stackType;
                break;
            }
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                if (!(stackType instanceof PrimType)) break;
                if (stackType == Type.intType || stackType == Type.byteType || stackType == Type.shortType || stackType == LangPrimType.unsignedByteType || stackType == LangPrimType.unsignedShortType) {
                    cname = "gnu.math.IntNum";
                    argType = Type.int_type;
                    break;
                }
                if (stackType == Type.longType || stackType == LangPrimType.unsignedIntType || stackType == LangPrimType.unsignedLongType) {
                    cname = "gnu.math.IntNum";
                    mname = stackType == Type.longType ? "valueOf" : "valueOfUnsigned";
                    argType = stackType.getImplementationType();
                    break;
                }
                if (this.typeCode != 9 && this.typeCode != 10) break;
                if (stackType == Type.floatType) {
                    code.emitConvert(Type.float_type, Type.double_type);
                    stackType = Type.doubleType;
                }
                if (stackType != Type.doubleType) break;
                cname = "gnu.math.DFloNum";
                argType = Type.doubleType;
            }
        }
        if (cname != null) {
            ClassType clas = ClassType.make(cname);
            Type[] args = new Type[]{argType};
            code.emitInvokeStatic(clas.getDeclaredMethod(mname, args));
        } else {
            super.emitConvertFromPrimitive(stackType, code);
        }
    }

    @Override
    public Expression convertValue(Expression value) {
        if (this.typeCode == 7 || this.typeCode == 10 || this.typeCode == 9 || this.typeCode == 8 || this.typeCode == 16) {
            return null;
        }
        Method method = this.coercionMethod();
        if (method == null) {
            return null;
        }
        ApplyExp aexp = new ApplyExp(method, value);
        aexp.setType(this);
        return aexp;
    }

    @Override
    public void emitCoerceFromObject(CodeAttr code) {
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
            }
        }
    }

    public ObjectType getConstructorType() {
        switch (this.typeCode) {
            case 28: {
                return LazyType.promiseType;
            }
        }
        return this;
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
        }
        return null;
    }

    @Override
    public String encodeType(Language language) {
        if (this == sequenceType) {
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
        }
        return null;
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
        }
        return null;
    }

    public String elementSetterMethodName() {
        String gname = this.elementGetterMethodName();
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
        }
        return new CompileBuildObject();
    }

    public static class SimpleVectorBuilder
    extends CompileBuildObject {
        Type elementType;
        PrimProcedure addProc;

        public SimpleVectorBuilder(LangObjType vectorType) {
            this.elementType = vectorType.getElementType();
            Method addMethod = ((ClassType)vectorType.getImplementationType()).getMethod("add", new Type[]{this.elementType.getImplementationType()});
            this.addProc = new PrimProcedure(addMethod, (Type)Type.voidType, new Type[]{this.elementType});
        }

        @Override
        public boolean useBuilder(int numCode, InlineCalls visitor) {
            return this.numKeywordArgs() == 0 && this.hasDefaultConstructor() || super.useBuilder(numCode, visitor);
        }

        @Override
        public Expression buildAddChild(Declaration target, Expression child) {
            return new ApplyExp(this.addProc, new ReferenceExp(target), child);
        }
    }

}

