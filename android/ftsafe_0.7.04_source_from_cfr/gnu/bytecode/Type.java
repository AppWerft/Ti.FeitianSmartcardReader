/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.PrimType;
import gnu.bytecode.SpecialObjectType;
import gnu.bytecode.TypeVariable;
import gnu.kawa.util.AbstractWeakHashTable;
import java.io.PrintWriter;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.WildcardType;
import java.util.HashMap;

public abstract class Type
implements java.lang.reflect.Type {
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
        Type raw = this.getRawType();
        return raw != this && raw.isInterface();
    }

    public boolean isExisting() {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Type lookupType(String name) {
        HashMap<String, Type> map;
        HashMap<String, Type> hashMap = map = mapNameToType;
        synchronized (hashMap) {
            return map.get(name);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Type getType(String name) {
        HashMap<String, Type> map;
        HashMap<String, Type> hashMap = map = mapNameToType;
        synchronized (hashMap) {
            Type type = map.get(name);
            if (type == null) {
                if (name.endsWith("[]")) {
                    type = ArrayType.make(name);
                } else {
                    ClassType cl = new ClassType(name);
                    cl.setExisting(true);
                    type = cl;
                }
                map.put(name, type);
            }
            return type;
        }
    }

    public static synchronized void registerTypeForClass(Class clas, Type type) {
        ClassToTypeMap map = mapClassToType;
        if (map == null) {
            mapClassToType = map = new ClassToTypeMap();
        }
        type.reflectClass = clas;
        map.put(clas, type);
    }

    public static Type make(Class reflectClass, java.lang.reflect.Type type) {
        Type t = Type.make(type);
        return t != null ? t : Type.make(reflectClass);
    }

    static Type make(java.lang.reflect.Type type) {
        if (type instanceof Class) {
            return Type.make((Class)type);
        }
        if (type instanceof GenericArrayType) {
            return null;
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.ParameterizedType ptype = (java.lang.reflect.ParameterizedType)type;
            java.lang.reflect.Type[] typeArguments = ptype.getActualTypeArguments();
            Type rt = Type.make(ptype.getRawType());
            if (rt instanceof ClassType) {
                ClassType rawType = (ClassType)rt;
                int nargs = typeArguments.length;
                Type[] typeArgumentTypes = new Type[nargs];
                char[] bounds = new char[nargs];
                for (int i = 0; i < nargs; ++i) {
                    java.lang.reflect.Type ti = typeArguments[i];
                    if (ti instanceof WildcardType) {
                        java.lang.reflect.Type[] upper;
                        WildcardType wi = (WildcardType)ti;
                        java.lang.reflect.Type[] lower = wi.getLowerBounds();
                        if (lower.length + (upper = wi.getUpperBounds()).length != 1) {
                            return null;
                        }
                        if (lower.length == 1) {
                            bounds[i] = 45;
                            ti = lower[0];
                        } else {
                            bounds[i] = 43;
                            ti = upper[0];
                        }
                    }
                    typeArgumentTypes[i] = Type.make(ti);
                }
                ParameterizedType ret = new ParameterizedType(rawType, typeArgumentTypes);
                ret.setTypeArgumentBounds(bounds);
                return ret;
            }
        }
        if (type instanceof java.lang.reflect.TypeVariable) {
            return TypeVariable.make((java.lang.reflect.TypeVariable)type);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static synchronized Type make(Class reflectClass) {
        Type type;
        Type t;
        if (mapClassToType != null && (t = (Type)mapClassToType.get(reflectClass)) != null) {
            return t;
        }
        if (reflectClass.isArray()) {
            type = ArrayType.make(Type.make(reflectClass.getComponentType()));
        } else {
            HashMap<String, Type> map;
            if (reflectClass.isPrimitive()) {
                throw new Error("internal error - primitive type not found");
            }
            String name = reflectClass.getName();
            HashMap<String, Type> hashMap = map = mapNameToType;
            synchronized (hashMap) {
                type = map.get(name);
                if (type == null || type.reflectClass != reflectClass && type.reflectClass != null) {
                    ClassType cl = new ClassType(name);
                    cl.setExisting(true);
                    type = cl;
                    mapNameToType.put(name, type);
                }
            }
        }
        Type.registerTypeForClass(reflectClass, type);
        return type;
    }

    public String getSignature() {
        return this.signature;
    }

    protected void setSignature(String sig) {
        this.signature = sig;
    }

    public String getGenericSignature() {
        return this.genericSignature;
    }

    protected void setGenericSignature(String sig) {
        this.genericSignature = sig;
    }

    public String getMaybeGenericSignature() {
        String s = this.getGenericSignature();
        return s != null ? s : this.getSignature();
    }

    Type(String nam, String sig) {
        this.this_name = nam;
        this.signature = sig;
    }

    public Type(Type type) {
        this.this_name = type.this_name;
        this.signature = type.signature;
        this.size = type.size;
        this.reflectClass = type.reflectClass;
    }

    public Type promote() {
        return this.size < 4 ? intType : this;
    }

    public Type promoteIfUnsigned() {
        char sig1;
        if (this instanceof PrimType && ((sig1 = this.signature.charAt(0)) == 'B' || sig1 == 'S') && ((PrimType)this).isUnsigned()) {
            return intType;
        }
        return this;
    }

    public final int getSize() {
        return this.size;
    }

    public int getSizeInWords() {
        return this.size > 4 ? 2 : 1;
    }

    public final boolean isVoid() {
        return this.size == 0;
    }

    public static PrimType signatureToPrimitive(char sig) {
        switch (sig) {
            case 'B': {
                return byteType;
            }
            case 'C': {
                return charType;
            }
            case 'D': {
                return doubleType;
            }
            case 'F': {
                return floatType;
            }
            case 'S': {
                return shortType;
            }
            case 'I': {
                return intType;
            }
            case 'J': {
                return longType;
            }
            case 'Z': {
                return booleanType;
            }
            case 'V': {
                return voidType;
            }
        }
        return null;
    }

    public static Type signatureToType(String sig, int off, int len) {
        Type type;
        if (len == 0) {
            return null;
        }
        char c = sig.charAt(off);
        if (len == 1 && (type = Type.signatureToPrimitive(c)) != null) {
            return type;
        }
        if (c == '[') {
            type = Type.signatureToType(sig, off + 1, len - 1);
            return type == null ? null : ArrayType.make(type);
        }
        if (c == 'L' && len > 2 && sig.indexOf(59, off) == len - 1 + off) {
            return ClassType.make(sig.substring(off + 1, len - 1 + off).replace('/', '.'));
        }
        return null;
    }

    public static Type signatureToType(String sig) {
        return Type.signatureToType(sig, 0, sig.length());
    }

    public static void printSignature(String sig, int off, int len, PrintWriter out) {
        if (len == 0) {
            return;
        }
        char c = sig.charAt(off);
        if (len == 1) {
            PrimType type = Type.signatureToPrimitive(c);
            if (type != null) {
                out.print(type.getName());
            }
        } else if (c == '[') {
            Type.printSignature(sig, off + 1, len - 1, out);
            out.print("[]");
        } else if (c == 'L' && len > 2 && sig.indexOf(59, off) == len - 1 + off) {
            out.print(sig.substring(off + 1, len - 1 + off).replace('/', '.'));
        } else {
            out.append(sig, off, len - off);
        }
    }

    public static int signatureLength(String sig, int pos) {
        int end;
        int len = sig.length();
        if (len <= pos) {
            return -1;
        }
        char c = sig.charAt(pos);
        int arrays2 = 0;
        while (c == '[') {
            ++arrays2;
            c = sig.charAt(++pos);
        }
        if (Type.signatureToPrimitive(c) != null) {
            return arrays2 + 1;
        }
        if (c == 'L' && (end = sig.indexOf(59, pos)) > 0) {
            return arrays2 + end + 1 - pos;
        }
        return -1;
    }

    public static int signatureLength(String sig) {
        return Type.signatureLength(sig, 0);
    }

    public static String signatureToName(String sig) {
        PrimType type;
        int len = sig.length();
        if (len == 0) {
            return null;
        }
        char c = sig.charAt(0);
        if (len == 1 && (type = Type.signatureToPrimitive(c)) != null) {
            return type.getName();
        }
        if (c == '[') {
            int arrays2 = 1;
            if (arrays2 < len && sig.charAt(arrays2) == '[') {
                ++arrays2;
            }
            if ((sig = Type.signatureToName(sig.substring(arrays2))) == null) {
                return null;
            }
            StringBuffer buf = new StringBuffer(50);
            buf.append(sig);
            while (--arrays2 >= 0) {
                buf.append("[]");
            }
            return buf.toString();
        }
        if (c == 'L' && len > 2 && sig.indexOf(59) == len - 1) {
            return sig.substring(1, len - 1).replace('/', '.');
        }
        return null;
    }

    public String getName() {
        return this.this_name;
    }

    protected void setName(String name) {
        this.this_name = name;
    }

    public static boolean isValidJavaTypeName(String name) {
        int i;
        int len;
        boolean in_name = false;
        for (len = name.length(); len > 2 && name.charAt(len - 1) == ']' && name.charAt(len - 2) == '['; len -= 2) {
        }
        for (i = 0; i < len; ++i) {
            char ch = name.charAt(i);
            if (ch == '.') {
                if (in_name) {
                    in_name = false;
                    continue;
                }
                return false;
            }
            if (in_name ? Character.isJavaIdentifierPart(ch) : Character.isJavaIdentifierStart(ch)) {
                in_name = true;
                continue;
            }
            return false;
        }
        return i == len;
    }

    public boolean isInstance(Object obj) {
        return this.getReflectClass().isInstance(obj);
    }

    public final boolean isSubtype(Type other) {
        int comp = this.compare(other);
        return comp == -1 || comp == 0;
    }

    public int isCompatibleWithValue(Type valueType) {
        if (Type.isSame(this, valueType)) {
            return 2;
        }
        if (this == toStringType) {
            return valueType == javalangStringType ? 2 : 0;
        }
        if (this == charType && valueType.getImplementationType() == this) {
            return 2;
        }
        return Type.isCompatibleWithValue(this, valueType);
    }

    public static int isCompatibleWithValue(Type targetType, Type valueType) {
        int comp = targetType.compare(valueType);
        return comp >= 0 ? 1 : (comp == -3 ? -1 : 0);
    }

    public static Type lowestCommonSuperType(Type t1, Type t2) {
        if (t1 == neverReturnsType) {
            return t2;
        }
        if (t2 == neverReturnsType) {
            return t1;
        }
        if (t1 == null || t2 == null) {
            return null;
        }
        if (t1 == t2) {
            return t1;
        }
        if (t1 instanceof PrimType && t2 instanceof PrimType) {
            return (t1 = ((PrimType)t1).promotedType()) == (t2 = ((PrimType)t2).promotedType()) ? t1 : null;
        }
        if (t1.isSubtype(t2)) {
            return t2;
        }
        if (t2.isSubtype(t1)) {
            return t1;
        }
        if (!(t1 instanceof ClassType) || !(t2 instanceof ClassType)) {
            return objectType;
        }
        ClassType c1 = (ClassType)t1;
        ClassType c2 = (ClassType)t2;
        if (!c1.isInterface() && !c2.isInterface()) {
            ClassType s1 = c1.getSuperclass();
            ClassType s2 = c2.getSuperclass();
            if (s1 != null && s2 != null) {
                return Type.lowestCommonSuperType(s1, s2);
            }
        }
        return objectType;
    }

    public abstract int compare(Type var1);

    protected static int swappedCompareResult(int code) {
        return code == 1 ? -1 : (code == -1 ? 1 : code);
    }

    public static boolean isMoreSpecific(Type[] t1, Type[] t2) {
        if (t1.length != t2.length) {
            return false;
        }
        int i = t1.length;
        while (--i >= 0) {
            if (t1[i].isSubtype(t2[i])) continue;
            return false;
        }
        return true;
    }

    public static boolean isSame(Type t1, Type t2) {
        return t1 == t2 || t1 != null && t2 != null && t1.equals(t2);
    }

    public void emitIsInstance(CodeAttr code) {
        code.emitInstanceof(this);
    }

    public abstract Object coerceFromObject(Object var1);

    public Object coerceToObject(Object obj) {
        return obj;
    }

    public void emitConvertFromPrimitive(Type stackType, CodeAttr code) {
        stackType.emitCoerceToObject(code);
    }

    public void emitCoerceToObject(CodeAttr code) {
    }

    public void emitCoerceFromObject(CodeAttr code) {
        throw new Error("unimplemented emitCoerceFromObject for " + this);
    }

    public Class getReflectClass() {
        return this.reflectClass;
    }

    public void setReflectClass(Class rclass) {
        this.reflectClass = rclass;
    }

    public String toString() {
        return "Type " + this.getName();
    }

    public int hashCode() {
        String name = this.toString();
        return name == null ? 0 : name.hashCode();
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
        byte_type = byteType;
        short_type = shortType;
        int_type = intType;
        long_type = longType;
        float_type = floatType;
        double_type = doubleType;
        boolean_type = booleanType;
        char_type = charType;
        void_type = voidType;
        mapNameToType = new HashMap<K, V>();
        mapNameToType.put("byte", byteType);
        mapNameToType.put("short", shortType);
        mapNameToType.put("int", intType);
        mapNameToType.put("long", longType);
        mapNameToType.put("float", floatType);
        mapNameToType.put("double", doubleType);
        mapNameToType.put("boolean", booleanType);
        mapNameToType.put("char", charType);
        mapNameToType.put("void", voidType);
        neverReturnsType = ClassType.make("gnu.bytecode.Type$NeverReturns");
        objectType = javalangObjectType = ClassType.make("java.lang.Object");
        javalangBooleanType = ClassType.make("java.lang.Boolean");
        javalangCharacterType = ClassType.make("java.lang.Character");
        javalangThrowableType = ClassType.make("java.lang.Throwable");
        javalangannotationAnnotationType = ClassType.make("java.lang.annotation.Annotation");
        typeArray0 = new Type[0];
        toString_method = objectType.getDeclaredMethod("toString", 0);
        javalangNumberType = ClassType.make("java.lang.Number");
        clone_method = Method.makeCloneMethod(objectType);
        intValue_method = javalangNumberType.addMethod("intValue", typeArray0, intType, 1);
        longValue_method = javalangNumberType.addMethod("longValue", typeArray0, longType, 1);
        floatValue_method = javalangNumberType.addMethod("floatValue", typeArray0, floatType, 1);
        doubleValue_method = javalangNumberType.addMethod("doubleValue", typeArray0, doubleType, 1);
        booleanValue_method = javalangBooleanType.addMethod("booleanValue", typeArray0, booleanType, 1);
        javalangClassType = ClassType.make("java.lang.Class");
        javalanginvokeMethodHandleType = ClassType.make("java.lang.invoke.MethodHandle");
        nullType = new SpecialObjectType("(type of null)", objectType);
        errorType = new SpecialObjectType("<error-type>", javalangObjectType);
        javalangStringType = ClassType.make("java.lang.String");
        toStringType = new SpecialObjectType("String", javalangStringType);
        pointer_type = javalangObjectType;
        string_type = javalangStringType;
        tostring_type = toStringType;
        java_lang_Class_type = javalangClassType;
        boolean_ctype = javalangBooleanType;
        throwable_type = javalangThrowableType;
        number_type = javalangNumberType;
    }

    static class ClassToTypeMap
    extends AbstractWeakHashTable<Class, Type> {
        ClassToTypeMap() {
        }

        @Override
        protected Class getKeyFromValue(Type type) {
            return type.reflectClass;
        }

        protected boolean matches(Class oldValue, Class newValue) {
            return oldValue == newValue;
        }
    }

    public static class NeverReturns {
        private NeverReturns() {
        }
    }

}

