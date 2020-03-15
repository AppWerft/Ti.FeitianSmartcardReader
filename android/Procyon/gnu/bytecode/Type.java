// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import gnu.kawa.util.AbstractHashTable;
import gnu.kawa.util.AbstractWeakHashTable;
import java.io.PrintWriter;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.GenericArrayType;
import java.util.HashMap;

public abstract class Type implements java.lang.reflect.Type
{
    String signature;
    String genericSignature;
    String this_name;
    int size;
    ArrayType array_type;
    static ClassToTypeMap mapClassToType;
    static HashMap<String, Type> mapNameToType;
    public static final PrimType byteType;
    public static final PrimType shortType;
    public static final PrimType intType;
    public static final PrimType longType;
    public static final PrimType floatType;
    public static final PrimType doubleType;
    public static final PrimType booleanType;
    public static final PrimType charType;
    public static final PrimType voidType;
    public static final PrimType byte_type;
    public static final PrimType short_type;
    public static final PrimType int_type;
    public static final PrimType long_type;
    public static final PrimType float_type;
    public static final PrimType double_type;
    public static final PrimType boolean_type;
    public static final PrimType char_type;
    public static final PrimType void_type;
    public static final Type neverReturnsType;
    public static final ClassType javalangObjectType;
    public static final ClassType objectType;
    public static final ClassType javalangBooleanType;
    public static final ClassType javalangCharacterType;
    public static final ClassType javalangThrowableType;
    public static final ClassType javalangannotationAnnotationType;
    public static final Type[] typeArray0;
    public static final Method toString_method;
    public static final ClassType javalangNumberType;
    public static final Method clone_method;
    public static final Method intValue_method;
    public static final Method longValue_method;
    public static final Method floatValue_method;
    public static final Method doubleValue_method;
    public static final Method booleanValue_method;
    public static final ClassType javalangClassType;
    public static final ClassType javalanginvokeMethodHandleType;
    public static final ObjectType nullType;
    public static final ObjectType errorType;
    public static ClassType javalangStringType;
    public static final ObjectType toStringType;
    @Deprecated
    public static final ClassType pointer_type;
    @Deprecated
    public static final ClassType string_type;
    @Deprecated
    public static final ObjectType tostring_type;
    @Deprecated
    public static final ClassType java_lang_Class_type;
    @Deprecated
    public static final ClassType boolean_ctype;
    public static final ClassType throwable_type;
    @Deprecated
    public static final ClassType number_type;
    protected Class reflectClass;
    
    protected Type() {
    }
    
    public Type getImplementationType() {
        return this;
    }
    
    public Type getRawType() {
        Type t = this.getImplementationType();
        if (t != this) {
            t = t.getRawType();
        }
        return t;
    }
    
    public Type getRealType() {
        return this;
    }
    
    public boolean isInterface() {
        final Type raw = this.getRawType();
        return raw != this && raw.isInterface();
    }
    
    public boolean isExisting() {
        return true;
    }
    
    public static Type lookupType(final String name) {
        final HashMap<String, Type> map = Type.mapNameToType;
        synchronized (map) {
            return map.get(name);
        }
    }
    
    public static Type getType(final String name) {
        final HashMap<String, Type> map = Type.mapNameToType;
        synchronized (map) {
            Type type = map.get(name);
            if (type == null) {
                if (name.endsWith("[]")) {
                    type = ArrayType.make(name);
                }
                else {
                    final ClassType cl = new ClassType(name);
                    cl.setExisting(true);
                    type = cl;
                }
                map.put(name, type);
            }
            return type;
        }
    }
    
    public static synchronized void registerTypeForClass(final Class clas, final Type type) {
        ClassToTypeMap map = Type.mapClassToType;
        if (map == null) {
            map = (Type.mapClassToType = new ClassToTypeMap());
        }
        map.put(type.reflectClass = clas, type);
    }
    
    public static Type make(final Class reflectClass, final java.lang.reflect.Type type) {
        final Type t = make(type);
        return (t != null) ? t : make(reflectClass);
    }
    
    static Type make(final java.lang.reflect.Type type) {
        if (type instanceof Class) {
            return make((Class)type);
        }
        if (type instanceof GenericArrayType) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            final ParameterizedType ptype = (ParameterizedType)type;
            final java.lang.reflect.Type[] typeArguments = ptype.getActualTypeArguments();
            final Type rt = make(ptype.getRawType());
            if (rt instanceof ClassType) {
                final ClassType rawType = (ClassType)rt;
                final int nargs = typeArguments.length;
                final Type[] typeArgumentTypes = new Type[nargs];
                final char[] bounds = new char[nargs];
                for (int i = 0; i < nargs; ++i) {
                    java.lang.reflect.Type ti = typeArguments[i];
                    if (ti instanceof WildcardType) {
                        final WildcardType wi = (WildcardType)ti;
                        final java.lang.reflect.Type[] lower = wi.getLowerBounds();
                        final java.lang.reflect.Type[] upper = wi.getUpperBounds();
                        if (lower.length + upper.length != 1) {
                            return null;
                        }
                        if (lower.length == 1) {
                            bounds[i] = '-';
                            ti = lower[0];
                        }
                        else {
                            bounds[i] = '+';
                            ti = upper[0];
                        }
                    }
                    typeArgumentTypes[i] = make(ti);
                }
                final gnu.bytecode.ParameterizedType ret = new gnu.bytecode.ParameterizedType(rawType, typeArgumentTypes);
                ret.setTypeArgumentBounds(bounds);
                return ret;
            }
        }
        if (type instanceof TypeVariable) {
            return gnu.bytecode.TypeVariable.make((TypeVariable)type);
        }
        return null;
    }
    
    public static synchronized Type make(final Class reflectClass) {
        if (Type.mapClassToType != null) {
            final Type t = ((AbstractHashTable<Entry, K, Type>)Type.mapClassToType).get(reflectClass);
            if (t != null) {
                return t;
            }
        }
        Type type;
        if (reflectClass.isArray()) {
            type = ArrayType.make(make(reflectClass.getComponentType()));
        }
        else {
            if (reflectClass.isPrimitive()) {
                throw new Error("internal error - primitive type not found");
            }
            final String name = reflectClass.getName();
            final HashMap<String, Type> map = Type.mapNameToType;
            synchronized (map) {
                type = map.get(name);
                if (type == null || (type.reflectClass != reflectClass && type.reflectClass != null)) {
                    final ClassType cl = new ClassType(name);
                    cl.setExisting(true);
                    type = cl;
                    Type.mapNameToType.put(name, type);
                }
            }
        }
        registerTypeForClass(reflectClass, type);
        return type;
    }
    
    public String getSignature() {
        return this.signature;
    }
    
    protected void setSignature(final String sig) {
        this.signature = sig;
    }
    
    public String getGenericSignature() {
        return this.genericSignature;
    }
    
    protected void setGenericSignature(final String sig) {
        this.genericSignature = sig;
    }
    
    public String getMaybeGenericSignature() {
        final String s = this.getGenericSignature();
        return (s != null) ? s : this.getSignature();
    }
    
    Type(final String nam, final String sig) {
        this.this_name = nam;
        this.signature = sig;
    }
    
    public Type(final Type type) {
        this.this_name = type.this_name;
        this.signature = type.signature;
        this.size = type.size;
        this.reflectClass = type.reflectClass;
    }
    
    public Type promote() {
        return (this.size < 4) ? Type.intType : this;
    }
    
    public Type promoteIfUnsigned() {
        if (this instanceof PrimType) {
            final char sig1 = this.signature.charAt(0);
            if ((sig1 == 'B' || sig1 == 'S') && ((PrimType)this).isUnsigned()) {
                return Type.intType;
            }
        }
        return this;
    }
    
    public final int getSize() {
        return this.size;
    }
    
    public int getSizeInWords() {
        return (this.size > 4) ? 2 : 1;
    }
    
    public final boolean isVoid() {
        return this.size == 0;
    }
    
    public static PrimType signatureToPrimitive(final char sig) {
        switch (sig) {
            case 'B': {
                return Type.byteType;
            }
            case 'C': {
                return Type.charType;
            }
            case 'D': {
                return Type.doubleType;
            }
            case 'F': {
                return Type.floatType;
            }
            case 'S': {
                return Type.shortType;
            }
            case 'I': {
                return Type.intType;
            }
            case 'J': {
                return Type.longType;
            }
            case 'Z': {
                return Type.booleanType;
            }
            case 'V': {
                return Type.voidType;
            }
            default: {
                return null;
            }
        }
    }
    
    public static Type signatureToType(final String sig, final int off, final int len) {
        if (len == 0) {
            return null;
        }
        final char c = sig.charAt(off);
        if (len == 1) {
            final Type type = signatureToPrimitive(c);
            if (type != null) {
                return type;
            }
        }
        if (c == '[') {
            final Type type = signatureToType(sig, off + 1, len - 1);
            return (type == null) ? null : ArrayType.make(type);
        }
        if (c == 'L' && len > 2 && sig.indexOf(59, off) == len - 1 + off) {
            return ClassType.make(sig.substring(off + 1, len - 1 + off).replace('/', '.'));
        }
        return null;
    }
    
    public static Type signatureToType(final String sig) {
        return signatureToType(sig, 0, sig.length());
    }
    
    public static void printSignature(final String sig, final int off, final int len, final PrintWriter out) {
        if (len == 0) {
            return;
        }
        final char c = sig.charAt(off);
        if (len == 1) {
            final Type type = signatureToPrimitive(c);
            if (type != null) {
                out.print(type.getName());
            }
        }
        else if (c == '[') {
            printSignature(sig, off + 1, len - 1, out);
            out.print("[]");
        }
        else if (c == 'L' && len > 2 && sig.indexOf(59, off) == len - 1 + off) {
            out.print(sig.substring(off + 1, len - 1 + off).replace('/', '.'));
        }
        else {
            out.append(sig, off, len - off);
        }
    }
    
    public static int signatureLength(final String sig, int pos) {
        final int len = sig.length();
        if (len <= pos) {
            return -1;
        }
        char c = sig.charAt(pos);
        int arrays = 0;
        while (c == '[') {
            ++arrays;
            ++pos;
            c = sig.charAt(pos);
        }
        if (signatureToPrimitive(c) != null) {
            return arrays + 1;
        }
        if (c == 'L') {
            final int end = sig.indexOf(59, pos);
            if (end > 0) {
                return arrays + end + 1 - pos;
            }
        }
        return -1;
    }
    
    public static int signatureLength(final String sig) {
        return signatureLength(sig, 0);
    }
    
    public static String signatureToName(String sig) {
        final int len = sig.length();
        if (len == 0) {
            return null;
        }
        final char c = sig.charAt(0);
        if (len == 1) {
            final Type type = signatureToPrimitive(c);
            if (type != null) {
                return type.getName();
            }
        }
        if (c == '[') {
            int arrays = 1;
            if (arrays < len && sig.charAt(arrays) == '[') {
                ++arrays;
            }
            sig = signatureToName(sig.substring(arrays));
            if (sig == null) {
                return null;
            }
            final StringBuffer buf = new StringBuffer(50);
            buf.append(sig);
            while (--arrays >= 0) {
                buf.append("[]");
            }
            return buf.toString();
        }
        else {
            if (c == 'L' && len > 2 && sig.indexOf(59) == len - 1) {
                return sig.substring(1, len - 1).replace('/', '.');
            }
            return null;
        }
    }
    
    public String getName() {
        return this.this_name;
    }
    
    protected void setName(final String name) {
        this.this_name = name;
    }
    
    public static boolean isValidJavaTypeName(final String name) {
        boolean in_name = false;
        int len;
        for (len = name.length(); len > 2 && name.charAt(len - 1) == ']' && name.charAt(len - 2) == '['; len -= 2) {}
        int i;
        for (i = 0; i < len; ++i) {
            final char ch = name.charAt(i);
            if (ch != '.') {
                if (in_name) {
                    if (!Character.isJavaIdentifierPart(ch)) {
                        return false;
                    }
                }
                else if (!Character.isJavaIdentifierStart(ch)) {
                    return false;
                }
                in_name = true;
                continue;
            }
            if (!in_name) {
                return false;
            }
            in_name = false;
        }
        return i == len;
    }
    
    public boolean isInstance(final Object obj) {
        return this.getReflectClass().isInstance(obj);
    }
    
    public final boolean isSubtype(final Type other) {
        final int comp = this.compare(other);
        return comp == -1 || comp == 0;
    }
    
    public int isCompatibleWithValue(final Type valueType) {
        if (isSame(this, valueType)) {
            return 2;
        }
        if (this == Type.toStringType) {
            return (valueType == Type.javalangStringType) ? 2 : 0;
        }
        if (this == Type.charType && valueType.getImplementationType() == this) {
            return 2;
        }
        return isCompatibleWithValue(this, valueType);
    }
    
    public static int isCompatibleWithValue(final Type targetType, final Type valueType) {
        final int comp = targetType.compare(valueType);
        return (comp >= 0) ? 1 : ((comp == -3) ? -1 : 0);
    }
    
    public static Type lowestCommonSuperType(Type t1, Type t2) {
        if (t1 == Type.neverReturnsType) {
            return t2;
        }
        if (t2 == Type.neverReturnsType) {
            return t1;
        }
        if (t1 == null || t2 == null) {
            return null;
        }
        if (t1 == t2) {
            return t1;
        }
        if (t1 instanceof PrimType && t2 instanceof PrimType) {
            t1 = ((PrimType)t1).promotedType();
            t2 = ((PrimType)t2).promotedType();
            return (t1 == t2) ? t1 : null;
        }
        if (t1.isSubtype(t2)) {
            return t2;
        }
        if (t2.isSubtype(t1)) {
            return t1;
        }
        if (!(t1 instanceof ClassType) || !(t2 instanceof ClassType)) {
            return Type.objectType;
        }
        final ClassType c1 = (ClassType)t1;
        final ClassType c2 = (ClassType)t2;
        if (!c1.isInterface() && !c2.isInterface()) {
            final ClassType s1 = c1.getSuperclass();
            final ClassType s2 = c2.getSuperclass();
            if (s1 != null && s2 != null) {
                return lowestCommonSuperType(s1, s2);
            }
        }
        return Type.objectType;
    }
    
    public abstract int compare(final Type p0);
    
    protected static int swappedCompareResult(final int code) {
        return (code == 1) ? -1 : ((code == -1) ? 1 : code);
    }
    
    public static boolean isMoreSpecific(final Type[] t1, final Type[] t2) {
        if (t1.length != t2.length) {
            return false;
        }
        int i = t1.length;
        while (--i >= 0) {
            if (!t1[i].isSubtype(t2[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isSame(final Type t1, final Type t2) {
        return t1 == t2 || (t1 != null && t2 != null && t1.equals(t2));
    }
    
    public void emitIsInstance(final CodeAttr code) {
        code.emitInstanceof(this);
    }
    
    public abstract Object coerceFromObject(final Object p0);
    
    public Object coerceToObject(final Object obj) {
        return obj;
    }
    
    public void emitConvertFromPrimitive(final Type stackType, final CodeAttr code) {
        stackType.emitCoerceToObject(code);
    }
    
    public void emitCoerceToObject(final CodeAttr code) {
    }
    
    public void emitCoerceFromObject(final CodeAttr code) {
        throw new Error("unimplemented emitCoerceFromObject for " + this);
    }
    
    public Class getReflectClass() {
        return this.reflectClass;
    }
    
    public void setReflectClass(final Class rclass) {
        this.reflectClass = rclass;
    }
    
    @Override
    public String toString() {
        return "Type " + this.getName();
    }
    
    @Override
    public int hashCode() {
        final String name = this.toString();
        return (name == null) ? 0 : name.hashCode();
    }
    
    static {
        byteType = new PrimType("byte", "B", 1, Byte.TYPE);
        shortType = new PrimType("short", "S", 2, Short.TYPE);
        intType = new PrimType("int", "I", 4, Integer.TYPE);
        longType = new PrimType("long", "J", 8, Long.TYPE);
        floatType = new PrimType("float", "F", 4, Float.TYPE);
        doubleType = new PrimType("double", "D", 8, Double.TYPE);
        booleanType = new PrimType("boolean", "Z", 1, Boolean.TYPE);
        charType = new PrimType("char", "C", 2, Character.TYPE);
        voidType = new PrimType("void", "V", 0, Void.TYPE);
        byte_type = Type.byteType;
        short_type = Type.shortType;
        int_type = Type.intType;
        long_type = Type.longType;
        float_type = Type.floatType;
        double_type = Type.doubleType;
        boolean_type = Type.booleanType;
        char_type = Type.charType;
        void_type = Type.voidType;
        (Type.mapNameToType = new HashMap<String, Type>()).put("byte", Type.byteType);
        Type.mapNameToType.put("short", Type.shortType);
        Type.mapNameToType.put("int", Type.intType);
        Type.mapNameToType.put("long", Type.longType);
        Type.mapNameToType.put("float", Type.floatType);
        Type.mapNameToType.put("double", Type.doubleType);
        Type.mapNameToType.put("boolean", Type.booleanType);
        Type.mapNameToType.put("char", Type.charType);
        Type.mapNameToType.put("void", Type.voidType);
        neverReturnsType = ClassType.make("gnu.bytecode.Type$NeverReturns");
        javalangObjectType = ClassType.make("java.lang.Object");
        objectType = Type.javalangObjectType;
        javalangBooleanType = ClassType.make("java.lang.Boolean");
        javalangCharacterType = ClassType.make("java.lang.Character");
        javalangThrowableType = ClassType.make("java.lang.Throwable");
        javalangannotationAnnotationType = ClassType.make("java.lang.annotation.Annotation");
        typeArray0 = new Type[0];
        toString_method = Type.objectType.getDeclaredMethod("toString", 0);
        javalangNumberType = ClassType.make("java.lang.Number");
        clone_method = Method.makeCloneMethod(Type.objectType);
        intValue_method = Type.javalangNumberType.addMethod("intValue", Type.typeArray0, Type.intType, 1);
        longValue_method = Type.javalangNumberType.addMethod("longValue", Type.typeArray0, Type.longType, 1);
        floatValue_method = Type.javalangNumberType.addMethod("floatValue", Type.typeArray0, Type.floatType, 1);
        doubleValue_method = Type.javalangNumberType.addMethod("doubleValue", Type.typeArray0, Type.doubleType, 1);
        booleanValue_method = Type.javalangBooleanType.addMethod("booleanValue", Type.typeArray0, Type.booleanType, 1);
        javalangClassType = ClassType.make("java.lang.Class");
        javalanginvokeMethodHandleType = ClassType.make("java.lang.invoke.MethodHandle");
        nullType = new SpecialObjectType("(type of null)", Type.objectType);
        errorType = new SpecialObjectType("<error-type>", Type.javalangObjectType);
        Type.javalangStringType = ClassType.make("java.lang.String");
        toStringType = new SpecialObjectType("String", Type.javalangStringType);
        pointer_type = Type.javalangObjectType;
        string_type = Type.javalangStringType;
        tostring_type = Type.toStringType;
        java_lang_Class_type = Type.javalangClassType;
        boolean_ctype = Type.javalangBooleanType;
        throwable_type = Type.javalangThrowableType;
        number_type = Type.javalangNumberType;
    }
    
    public static class NeverReturns
    {
        private NeverReturns() {
        }
    }
    
    static class ClassToTypeMap extends AbstractWeakHashTable<Class, Type>
    {
        @Override
        protected Class getKeyFromValue(final Type type) {
            return type.reflectClass;
        }
        
        protected boolean matches(final Class oldValue, final Class newValue) {
            return oldValue == newValue;
        }
    }
}
