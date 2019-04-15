package gnu.bytecode;

import gnu.kawa.util.AbstractWeakHashTable;
import java.io.PrintWriter;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.WildcardType;
import java.util.HashMap;

















public abstract class Type
  implements java.lang.reflect.Type
{
  String signature;
  String genericSignature;
  String this_name;
  int size;
  ArrayType array_type;
  static ClassToTypeMap mapClassToType;
  static HashMap<String, Type> mapNameToType;
  
  public Type getImplementationType()
  {
    return this;
  }
  
  public Type getRawType()
  {
    Type t = getImplementationType();
    if (t != this)
      t = t.getRawType();
    return t;
  }
  


  public Type getRealType()
  {
    return this;
  }
  
  public boolean isInterface() {
    Type raw = getRawType();
    return (raw != this) && (raw.isInterface());
  }
  

  public boolean isExisting()
  {
    return true;
  }
  










  public static Type lookupType(String name)
  {
    HashMap<String, Type> map = mapNameToType;
    synchronized (map) { return (Type)map.get(name);
    }
  }
  








  public static Type getType(String name)
  {
    HashMap<String, Type> map = mapNameToType;
    


    synchronized (map)
    {
      Type type = (Type)map.get(name);
      if (type == null)
      {
        if (name.endsWith("[]")) {
          type = ArrayType.make(name);
        }
        else {
          ClassType cl = new ClassType(name);
          cl.setExisting(true);
          type = cl;
        }
        map.put(name, type);
      }
      return type;
    }
  }
  

  public static synchronized void registerTypeForClass(Class clas, Type type)
  {
    ClassToTypeMap map = mapClassToType;
    if (map == null)
      mapClassToType = map = new ClassToTypeMap();
    reflectClass = clas;
    map.put(clas, type);
  }
  


  public static Type make(Class reflectClass, java.lang.reflect.Type type)
  {
    Type t = make(type);
    return t != null ? t : make(reflectClass);
  }
  



  static Type make(java.lang.reflect.Type type)
  {
    if ((type instanceof Class))
      return make((Class)type);
    if ((type instanceof GenericArrayType))
      return null;
    if ((type instanceof java.lang.reflect.ParameterizedType)) {
      java.lang.reflect.ParameterizedType ptype = (java.lang.reflect.ParameterizedType)type;
      
      java.lang.reflect.Type[] typeArguments = ptype.getActualTypeArguments();
      
      Type rt = make(ptype.getRawType());
      if ((rt instanceof ClassType)) {
        ClassType rawType = (ClassType)rt;
        int nargs = typeArguments.length;
        Type[] typeArgumentTypes = new Type[nargs];
        char[] bounds = new char[nargs];
        for (int i = 0; i < nargs; i++) {
          java.lang.reflect.Type ti = typeArguments[i];
          if ((ti instanceof WildcardType)) {
            WildcardType wi = (WildcardType)ti;
            
            java.lang.reflect.Type[] lower = wi.getLowerBounds();
            java.lang.reflect.Type[] upper = wi.getUpperBounds();
            if (lower.length + upper.length != 1)
              return null;
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
        ParameterizedType ret = new ParameterizedType(rawType, typeArgumentTypes);
        ret.setTypeArgumentBounds(bounds);
        return ret;
      }
    }
    if ((type instanceof java.lang.reflect.TypeVariable)) {
      return TypeVariable.make((java.lang.reflect.TypeVariable)type);
    }
    return null;
  }
  


  public static synchronized Type make(Class reflectClass)
  {
    if (mapClassToType != null)
    {
      Type t = (Type)mapClassToType.get(reflectClass);
      if (t != null)
        return t; }
    Type type;
    Type type; if (reflectClass.isArray()) {
      type = ArrayType.make(make(reflectClass.getComponentType()));
    } else { if (reflectClass.isPrimitive()) {
        throw new Error("internal error - primitive type not found");
      }
      
      String name = reflectClass.getName();
      
      HashMap<String, Type> map = mapNameToType;
      


      synchronized (map)
      {
        type = (Type)map.get(name);
        if ((type == null) || ((reflectClass != reflectClass) && (reflectClass != null)))
        {


          ClassType cl = new ClassType(name);
          cl.setExisting(true);
          type = cl;
          mapNameToType.put(name, type);
        }
      }
    }
    registerTypeForClass(reflectClass, type);
    return type;
  }
  
  public String getSignature() { return signature; }
  protected void setSignature(String sig) { signature = sig; }
  public String getGenericSignature() { return genericSignature; }
  protected void setGenericSignature(String sig) { genericSignature = sig; }
  
  public String getMaybeGenericSignature() { String s = getGenericSignature();
    return s != null ? s : getSignature();
  }
  
  Type(String nam, String sig) {
    this_name = nam;
    signature = sig;
  }
  
  public Type(Type type)
  {
    this_name = this_name;
    signature = signature;
    size = size;
    reflectClass = reflectClass;
  }
  
  public Type promote() {
    return size < 4 ? intType : this;
  }
  
  public Type promoteIfUnsigned() {
    if ((this instanceof PrimType)) {
      char sig1 = signature.charAt(0);
      if (((sig1 == 'B') || (sig1 == 'S')) && (((PrimType)this).isUnsigned()))
        return intType;
    }
    return this;
  }
  
  public final int getSize() { return size; }
  public int getSizeInWords() { return size > 4 ? 2 : 1; }
  
  public final boolean isVoid() { return size == 0; }
  


  public static PrimType signatureToPrimitive(char sig)
  {
    switch (sig) {
    case 'B': 
      return byteType;
    case 'C':  return charType;
    case 'D':  return doubleType;
    case 'F':  return floatType;
    case 'S':  return shortType;
    case 'I':  return intType;
    case 'J':  return longType;
    case 'Z':  return booleanType;
    case 'V':  return voidType;
    }
    return null;
  }
  

  public static Type signatureToType(String sig, int off, int len)
  {
    if (len == 0)
      return null;
    char c = sig.charAt(off);
    
    if (len == 1)
    {
      Type type = signatureToPrimitive(c);
      if (type != null)
        return type;
    }
    if (c == '[')
    {
      Type type = signatureToType(sig, off + 1, len - 1);
      return type == null ? null : ArrayType.make(type);
    }
    if ((c == 'L') && (len > 2) && (sig.indexOf(';', off) == len - 1 + off))
      return ClassType.make(sig.substring(off + 1, len - 1 + off).replace('/', '.'));
    return null;
  }
  

  public static Type signatureToType(String sig)
  {
    return signatureToType(sig, 0, sig.length());
  }
  

  public static void printSignature(String sig, int off, int len, PrintWriter out)
  {
    if (len == 0)
      return;
    char c = sig.charAt(off);
    
    if (len == 1)
    {
      Type type = signatureToPrimitive(c);
      if (type != null) {
        out.print(type.getName());
      }
    } else if (c == '[')
    {
      printSignature(sig, off + 1, len - 1, out);
      out.print("[]");
    }
    else if ((c == 'L') && (len > 2) && (sig.indexOf(';', off) == len - 1 + off)) {
      out.print(sig.substring(off + 1, len - 1 + off).replace('/', '.'));
    } else {
      out.append(sig, off, len - off);
    }
  }
  

  public static int signatureLength(String sig, int pos)
  {
    int len = sig.length();
    if (len <= pos)
      return -1;
    char c = sig.charAt(pos);
    int arrays = 0;
    while (c == '[')
    {
      arrays++;
      pos++;
      c = sig.charAt(pos);
    }
    if (signatureToPrimitive(c) != null)
      return arrays + 1;
    if (c == 'L')
    {
      int end = sig.indexOf(';', pos);
      if (end > 0)
        return arrays + end + 1 - pos;
    }
    return -1;
  }
  
  public static int signatureLength(String sig)
  {
    return signatureLength(sig, 0);
  }
  


  public static String signatureToName(String sig)
  {
    int len = sig.length();
    if (len == 0)
      return null;
    char c = sig.charAt(0);
    
    if (len == 1)
    {
      Type type = signatureToPrimitive(c);
      if (type != null)
        return type.getName();
    }
    if (c == '[')
    {
      int arrays = 1;
      if ((arrays < len) && (sig.charAt(arrays) == '['))
        arrays++;
      sig = signatureToName(sig.substring(arrays));
      if (sig == null)
        return null;
      StringBuffer buf = new StringBuffer(50);
      buf.append(sig);
      for (;;) { arrays--; if (arrays < 0) break;
        buf.append("[]"); }
      return buf.toString();
    }
    if ((c == 'L') && (len > 2) && (sig.indexOf(';') == len - 1))
      return sig.substring(1, len - 1).replace('/', '.');
    return null;
  }
  
  public String getName()
  {
    return this_name;
  }
  
  protected void setName(String name)
  {
    this_name = name;
  }
  
  public static boolean isValidJavaTypeName(String name)
  {
    boolean in_name = false;
    
    int len = name.length();
    
    while ((len > 2) && (name.charAt(len - 1) == ']') && (name.charAt(len - 2) == '['))
      len -= 2;
    for (int i = 0; i < len; i++)
    {
      char ch = name.charAt(i);
      if (ch == '.')
      {
        if (in_name) {
          in_name = false;
        } else {
          return false;
        }
      } else if (in_name ? Character.isJavaIdentifierPart(ch) : Character.isJavaIdentifierStart(ch))
      {
        in_name = true;
      } else
        return false;
    }
    return i == len;
  }
  
  public boolean isInstance(Object obj)
  {
    return getReflectClass().isInstance(obj);
  }
  

  public final boolean isSubtype(Type other)
  {
    int comp = compare(other);
    return (comp == -1) || (comp == 0);
  }
  






  public int isCompatibleWithValue(Type valueType)
  {
    if (isSame(this, valueType))
      return 2;
    if (this == toStringType) {
      return valueType == javalangStringType ? 2 : 0;
    }
    if ((this == charType) && (valueType.getImplementationType() == this))
      return 2;
    return isCompatibleWithValue(this, valueType);
  }
  
  public static int isCompatibleWithValue(Type targetType, Type valueType) {
    int comp = targetType.compare(valueType);
    return comp == -3 ? -1 : comp >= 0 ? 1 : 0;
  }
  











  public static Type lowestCommonSuperType(Type t1, Type t2)
  {
    if (t1 == neverReturnsType)
      return t2;
    if (t2 == neverReturnsType)
      return t1;
    if ((t1 == null) || (t2 == null))
      return null;
    if (t1 == t2)
      return t1;
    if (((t1 instanceof PrimType)) && ((t2 instanceof PrimType)))
    {
      t1 = ((PrimType)t1).promotedType();
      t2 = ((PrimType)t2).promotedType();
      return t1 == t2 ? t1 : null;
    }
    if (t1.isSubtype(t2))
      return t2;
    if (t2.isSubtype(t1)) {
      return t1;
    }
    

    if ((!(t1 instanceof ClassType)) || (!(t2 instanceof ClassType)))
      return objectType;
    ClassType c1 = (ClassType)t1;
    ClassType c2 = (ClassType)t2;
    if ((!c1.isInterface()) && (!c2.isInterface()))
    {
      ClassType s1 = c1.getSuperclass();
      ClassType s2 = c2.getSuperclass();
      if ((s1 != null) && (s2 != null)) {
        return lowestCommonSuperType(s1, s2);
      }
    }
    return objectType;
  }
  
























  protected static int swappedCompareResult(int code)
  {
    return code == -1 ? 1 : code == 1 ? -1 : code;
  }
  

  public static boolean isMoreSpecific(Type[] t1, Type[] t2)
  {
    if (t1.length != t2.length)
      return false;
    int i = t1.length; do { i--; if (i < 0)
        break;
    } while (t1[i].isSubtype(t2[i]));
    return false;
    
    return true;
  }
  
  public static boolean isSame(Type t1, Type t2) {
    return (t1 == t2) || ((t1 != null) && (t2 != null) && (t1.equals(t2)));
  }
  

  public void emitIsInstance(CodeAttr code)
  {
    code.emitInstanceof(this);
  }
  












  public Object coerceToObject(Object obj)
  {
    return obj;
  }
  







  public void emitConvertFromPrimitive(Type stackType, CodeAttr code)
  {
    stackType.emitCoerceToObject(code);
  }
  






  public void emitCoerceFromObject(CodeAttr code)
  {
    throw new Error("unimplemented emitCoerceFromObject for " + this);
  }
  
  public static final PrimType byteType = new PrimType("byte", "B", 1, Byte.TYPE);
  
  public static final PrimType shortType = new PrimType("short", "S", 2, Short.TYPE);
  
  public static final PrimType intType = new PrimType("int", "I", 4, Integer.TYPE);
  
  public static final PrimType longType = new PrimType("long", "J", 8, Long.TYPE);
  
  public static final PrimType floatType = new PrimType("float", "F", 4, Float.TYPE);
  
  public static final PrimType doubleType = new PrimType("double", "D", 8, Double.TYPE);
  
  public static final PrimType booleanType = new PrimType("boolean", "Z", 1, Boolean.TYPE);
  
  public static final PrimType charType = new PrimType("char", "C", 2, Character.TYPE);
  
  public static final PrimType voidType = new PrimType("void", "V", 0, Void.TYPE);
  

  public static final PrimType byte_type = byteType;
  public static final PrimType short_type = shortType;
  public static final PrimType int_type = intType;
  public static final PrimType long_type = longType;
  public static final PrimType float_type = floatType;
  public static final PrimType double_type = doubleType;
  public static final PrimType boolean_type = booleanType;
  public static final PrimType char_type = charType;
  public static final PrimType void_type = voidType;
  

  static
  {
    mapNameToType = new HashMap();
    


    mapNameToType.put("byte", byteType);
    mapNameToType.put("short", shortType);
    mapNameToType.put("int", intType);
    mapNameToType.put("long", longType);
    mapNameToType.put("float", floatType);
    mapNameToType.put("double", doubleType);
    mapNameToType.put("boolean", booleanType);
    mapNameToType.put("char", charType);
    mapNameToType.put("void", voidType);
  }
  

  public static final Type neverReturnsType = ClassType.make("gnu.bytecode.Type$NeverReturns");
  

  public static final ClassType javalangObjectType = ClassType.make("java.lang.Object");
  
  public static final ClassType objectType = javalangObjectType;
  public static final ClassType javalangBooleanType = ClassType.make("java.lang.Boolean");
  
  public static final ClassType javalangCharacterType = ClassType.make("java.lang.Character");
  
  public static final ClassType javalangThrowableType = ClassType.make("java.lang.Throwable");
  
  public static final ClassType javalangannotationAnnotationType = ClassType.make("java.lang.annotation.Annotation");
  
  public static final Type[] typeArray0 = new Type[0];
  public static final Method toString_method = objectType.getDeclaredMethod("toString", 0);
  
  public static final ClassType javalangNumberType = ClassType.make("java.lang.Number");
  
  public static final Method clone_method = Method.makeCloneMethod(objectType);
  
  public static final Method intValue_method = javalangNumberType.addMethod("intValue", typeArray0, intType, 1);
  

  public static final Method longValue_method = javalangNumberType.addMethod("longValue", typeArray0, longType, 1);
  

  public static final Method floatValue_method = javalangNumberType.addMethod("floatValue", typeArray0, floatType, 1);
  

  public static final Method doubleValue_method = javalangNumberType.addMethod("doubleValue", typeArray0, doubleType, 1);
  

  public static final Method booleanValue_method = javalangBooleanType.addMethod("booleanValue", typeArray0, booleanType, 1);
  

  public static final ClassType javalangClassType = ClassType.make("java.lang.Class");
  

  public static final ClassType javalanginvokeMethodHandleType = ClassType.make("java.lang.invoke.MethodHandle");
  


  public static final ObjectType nullType = new SpecialObjectType("(type of null)", objectType);
  

  public static final ObjectType errorType = new SpecialObjectType("<error-type>", javalangObjectType);
  

  public static ClassType javalangStringType = ClassType.make("java.lang.String");
  
  public static final ObjectType toStringType = new SpecialObjectType("String", javalangStringType);
  

  @Deprecated
  public static final ClassType pointer_type = javalangObjectType;
  @Deprecated
  public static final ClassType string_type = javalangStringType;
  @Deprecated
  public static final ObjectType tostring_type = toStringType;
  @Deprecated
  public static final ClassType java_lang_Class_type = javalangClassType;
  @Deprecated
  public static final ClassType boolean_ctype = javalangBooleanType;
  public static final ClassType throwable_type = javalangThrowableType;
  @Deprecated
  public static final ClassType number_type = javalangNumberType;
  
  protected Class reflectClass;
  

  public Class getReflectClass()
  {
    return reflectClass;
  }
  
  public void setReflectClass(Class rclass)
  {
    reflectClass = rclass;
  }
  
  public String toString()
  {
    return "Type " + getName();
  }
  
  public int hashCode()
  {
    String name = toString();
    return name == null ? 0 : name.hashCode(); }
  
  protected Type() {}
  
  public abstract int compare(Type paramType);
  
  public abstract Object coerceFromObject(Object paramObject);
  
  public void emitCoerceToObject(CodeAttr code) {}
  
  static class ClassToTypeMap extends AbstractWeakHashTable<Class, Type> { ClassToTypeMap() {}
    
    protected Class getKeyFromValue(Type type) { return reflectClass; }
    


    protected boolean matches(Class oldValue, Class newValue)
    {
      return oldValue == newValue;
    }
  }
  
  public static class NeverReturns
  {
    private NeverReturns() {}
  }
}
