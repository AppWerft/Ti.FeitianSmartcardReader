package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;

public class ClassType extends ObjectType implements AttrContainer, java.io.Externalizable, Member
{
  public static final int JDK_1_1_VERSION = 2949123;
  public static final int JDK_1_2_VERSION = 3014656;
  public static final int JDK_1_3_VERSION = 3080192;
  public static final int JDK_1_4_VERSION = 3145728;
  public static final int JDK_1_5_VERSION = 3211264;
  public static final int JDK_1_6_VERSION = 3276800;
  public static final int JDK_1_7_VERSION = 3342336;
  public static final int JDK_1_8_VERSION = 3407872;
  public static final int JAVA_9_VERSION = 3473408;
  int classfileFormatVersion = 3211264;
  int thisClassIndex;
  private ClassType superClass;
  
  public short getClassfileMajorVersion() { return (short)(classfileFormatVersion >> 16); }
  
  public short getClassfileMinorVersion()
  {
    return (short)(classfileFormatVersion & 0xFFFF);
  }
  
  public void setClassfileVersion(int major, int minor) {
    classfileFormatVersion = ((major & 0xFFFF) * 65536 + minor * 65535);
  }
  
  public void setClassfileVersion(int code) {
    classfileFormatVersion = code;
  }
  
  public int getClassfileVersion() {
    return classfileFormatVersion;
  }
  
  public void setClassfileVersionJava5() {
    setClassfileVersion(3211264);
  }
  





  public static ClassType make(String name)
  {
    return (ClassType)Type.getType(name);
  }
  
  @Deprecated
  public static ClassType make(String name, ClassType superClass)
  {
    ClassType type = make(name);
    if (superClass == null)
      type.setSuper(superClass);
    return type;
  }
  







  int superClassIndex = -1;
  
  ClassType[] interfaces;
  private ClassType[] allInterfaces;
  int[] interfaceIndexes;
  int access_flags;
  Attribute attributes;
  
  public final Attribute getAttributes() { return attributes; }
  
  public final void setAttributes(Attribute attributes) { this.attributes = attributes; }
  
  public static final ClassType[] noClasses = new ClassType[0];
  
  boolean emitDebugInfo = true;
  ConstantPool constants;
  ClassType firstInnerClass;
  
  public final ConstantPool getConstants() { return constants; }
  
  public final CpoolEntry getConstant(int i)
  {
    if ((constants == null) || (constants.pool == null) || (i > constants.count))
    {
      return null; }
    return constants.pool[i];
  }
  

  public final synchronized int getModifiers()
  {
    if ((access_flags == 0) && ((flags & 0x10) != 0) && (getReflectClass() != null))
    {
      access_flags = reflectClass.getModifiers(); }
    return access_flags;
  }
  
  public final boolean getStaticFlag() {
    return (getModifiers() & 0x8) != 0;
  }
  

  public final void setModifiers(int flags) { access_flags = flags; }
  public final void addModifiers(int flags) { access_flags |= flags; }
  

  public synchronized String getSimpleName()
  {
    if (((flags & 0x10) != 0) && (getReflectClass() != null))
    {
      try
      {
        return reflectClass.getSimpleName();
      }
      catch (Exception ex) {}
    }
    

    String name = getName();
    if ((enclosingMember instanceof ClassType))
    {
      String enclosingName = ((ClassType)enclosingMember).getName();
      int enclosingLength;
      if ((enclosingName != null) && (name.startsWith(enclosingName)) && (name.length() > (enclosingLength = enclosingName.length()) + 1) && (name.charAt(enclosingLength) == '$'))
      {

        return name.substring(enclosingLength + 1); }
    }
    int dot = name.lastIndexOf('.');
    if (dot > 0)
      name = name.substring(dot + 1);
    return name;
  }
  
  public void addMemberClass(ClassType member)
  {
    ClassType prev = null;
    ClassType entry = firstInnerClass;
    while (entry != null)
    {
      if (entry == member)
        return;
      prev = entry;
      entry = nextInnerClass;
    }
    if (prev == null) {
      firstInnerClass = member;
    } else {
      nextInnerClass = member;
    }
  }
  
  public ClassType getDeclaredClass(String simpleName) {
    addMemberClasses();
    for (ClassType member = firstInnerClass; member != null; 
        member = nextInnerClass)
    {
      if (simpleName.equals(member.getSimpleName()))
        return member;
    }
    return null;
  }
  




  public ClassType getDeclaringClass()
  {
    addEnclosingMember();
    if ((enclosingMember instanceof ClassType)) {
      return (ClassType)enclosingMember;
    }
    return null;
  }
  
  public Member getEnclosingMember()
  {
    addEnclosingMember();
    return enclosingMember;
  }
  
  public void setEnclosingMember(Member member)
  {
    enclosingMember = member;
  }
  
  synchronized void addEnclosingMember()
  {
    if ((flags & 0x18) != 16)
      return;
    Class clas = getReflectClass();
    flags |= 0x8;
    


    Class dclas = clas.getEnclosingClass();
    if (dclas == null)
      return;
    if (!clas.isMemberClass())
    {
      java.lang.reflect.Method rmeth = clas.getEnclosingMethod();
      if (rmeth != null)
      {
        enclosingMember = addMethod(rmeth);
        return;
      }
      Constructor rcons = clas.getEnclosingConstructor();
      if (rcons != null)
      {
        enclosingMember = addMethod(rcons);
        return;
      }
    }
    enclosingMember = ((ClassType)Type.make(dclas));
  }
  





  public synchronized void addMemberClasses()
  {
    if ((flags & 0x14) != 16)
      return;
    Class clas = getReflectClass();
    flags |= 0x4;
    Class[] memberClasses = clas.getClasses();
    int numMembers = memberClasses.length;
    if (numMembers > 0)
    {
      for (int i = 0; i < numMembers; i++)
      {
        ClassType member = (ClassType)Type.make(memberClasses[i]);
        addMemberClass(member);
      }
    }
  }
  
  public final boolean hasOuterLink()
  {
    getFields();
    return (flags & 0x20) != 0;
  }
  
  public ClassType getOuterLinkType()
  {
    return !hasOuterLink() ? null : (ClassType)getDeclaredField("this$0").getType();
  }
  


  ClassType nextInnerClass;
  

  Member enclosingMember;
  
  public final Field setOuterLink(ClassType outer)
  {
    if ((flags & 0x10) != 0)
      throw new Error("setOuterLink called for existing class " + getName());
    Field field = getDeclaredField("this$0");
    if (field == null)
    {
      field = addField("this$0", outer);
      flags |= 0x20;
      for (Method meth = methods; meth != null; meth = meth.getNext())
      {
        if ("<init>".equals(meth.getName()))
        {
          if (code != null)
            throw new Error("setOuterLink called when " + meth + " has code");
          Type[] arg_types = arg_types;
          Type[] new_types = new Type[arg_types.length + 1];
          System.arraycopy(arg_types, 0, new_types, 1, arg_types.length);
          new_types[0] = outer;
          arg_types = new_types;
          signature = null;
        }
      }
    }
    else if (!outer.equals(field.getType())) {
      throw new Error("inconsistent setOuterLink call for " + getName()); }
    return field;
  }
  





  public boolean isAccessible(Member member, ObjectType receiver)
  {
    if (member.getStaticFlag())
      receiver = null;
    return isAccessible(member.getDeclaringClass(), receiver, member.getModifiers());
  }
  

  SourceDebugExtAttr sourceDbgExt;
  
  TypeVariable[] typeParameters;
  
  Field fields;
  
  int fields_count;
  
  public boolean isAccessible(ClassType declaring, ObjectType receiver, int modifiers)
  {
    int cmods = declaring.getModifiers();
    
    if (((modifiers & 0x1) != 0) && ((cmods & 0x1) != 0))
      return true;
    String callerName = getName();
    String className = declaring.getName();
    if (callerName.equals(className))
      return true;
    if ((modifiers & 0x2) != 0)
      return false;
    int dot = callerName.lastIndexOf('.');
    String callerPackage = dot >= 0 ? callerName.substring(0, dot) : "";
    dot = className.lastIndexOf('.');
    String classPackage = dot >= 0 ? className.substring(0, dot) : "";
    if (callerPackage.equals(classPackage))
      return true;
    if ((cmods & 0x1) == 0)
      return false;
    if (((modifiers & 0x4) != 0) && (isSubclass(declaring)) && ((!(receiver instanceof ClassType)) || (((ClassType)receiver).isSubclass(this))))
    {


      return true; }
    return false;
  }
  



  public void setName(String name)
  {
    this_name = name;
    setSignature(nameToSignature(name));
  }
  
  public static String nameToSignature(String name) {
    return "L" + name.replace('.', '/') + ";";
  }
  





  public void setStratum(String stratum)
  {
    if (sourceDbgExt == null)
      sourceDbgExt = new SourceDebugExtAttr(this);
    sourceDbgExt.addStratum(stratum);
  }
  

  public void setSourceFile(String name)
  {
    if (sourceDbgExt != null)
    {
      sourceDbgExt.addFile(name);
      if (sourceDbgExt.fileCount > 1) {
        return;
      }
    }
    name = SourceFileAttr.fixSourceFile(name);
    int slash = name.lastIndexOf('/');
    if (slash >= 0)
      name = name.substring(slash + 1);
    SourceFileAttr.setSourceFile(this, name);
  }
  

  public TypeVariable[] getTypeParameters()
  {
    TypeVariable[] params = typeParameters;
    if ((params == null) && ((flags & 0x10) != 0) && (getReflectClass() != null))
    {
      java.lang.reflect.TypeVariable[] rparams = reflectClass.getTypeParameters();
      
      int nparams = rparams.length;
      params = new TypeVariable[nparams];
      for (int i = 0; i < nparams; i++) {
        params[i] = TypeVariable.make(rparams[i]);
      }
      typeParameters = params;
    }
    return params;
  }
  




  public void setSuper(String name)
  {
    setSuper(name == null ? Type.pointer_type : make(name));
  }
  
  public void setSuper(ClassType superClass)
  {
    this.superClass = superClass;
  }
  
  public synchronized ClassType getSuperclass()
  {
    if ((superClass == null) && (!isInterface()) && (!"java.lang.Object".equals(getName())) && ((flags & 0x10) != 0) && (getReflectClass() != null))
    {



      superClass = ((ClassType)make(reflectClass.getSuperclass()));
    }
    return superClass;
  }
  
  public String getPackageName()
  {
    String name = getName();
    int index = name.lastIndexOf('.');
    return index < 0 ? "" : name.substring(0, index);
  }
  




  public synchronized ClassType[] getInterfaces()
  {
    if ((interfaces == null) && ((flags & 0x10) != 0) && (getReflectClass() != null))
    {

      Class[] reflectInterfaces = reflectClass.getInterfaces();
      int numInterfaces = reflectInterfaces.length;
      interfaces = (numInterfaces == 0 ? noClasses : new ClassType[numInterfaces]);
      

      for (int i = 0; i < numInterfaces; i++)
        interfaces[i] = ((ClassType)Type.make(reflectInterfaces[i]));
    }
    return interfaces;
  }
  


  public synchronized ClassType[] getAllInterfaces()
  {
    if (allInterfaces == null) {
      LinkedHashMap<String, ClassType> map = new LinkedHashMap();
      
      for (ClassType t = this; t != null; t = t.getSuperclass()) {
        if (!t.addInterfaces(map))
          return null;
      }
      ClassType[] allInts = new ClassType[map.size()];
      int i = 0;
      for (ClassType intf : map.values()) {
        allInts[(i++)] = intf;
      }
      allInterfaces = allInts;
    }
    return allInterfaces;
  }
  
  private boolean addInterfaces(LinkedHashMap<String, ClassType> map) {
    ClassType[] intfs = getInterfaces();
    if (intfs == null)
      return false;
    for (ClassType intf : intfs) {
      if ((map.put(intf.getName(), intf) == null) && (!intf.addInterfaces(map)))
      {
        return false; }
    }
    return true;
  }
  
  public void setInterfaces(ClassType[] interfaces) {
    this.interfaces = interfaces;
  }
  
  public void addInterface(ClassType newInterface)
  {
    int oldCount;
    if ((interfaces == null) || (interfaces.length == 0))
    {
      int oldCount = 0;
      interfaces = new ClassType[1];
    }
    else
    {
      oldCount = interfaces.length;
      int i = oldCount; do { i--; if (i < 0) break;
      } while (interfaces[i] != newInterface);
      return;
      ClassType[] newInterfaces = new ClassType[oldCount + 1];
      System.arraycopy(interfaces, 0, newInterfaces, 0, oldCount);
      interfaces = newInterfaces;
    }
    interfaces[oldCount] = newInterface;
  }
  
  public final boolean isInterface() {
    return (getModifiers() & 0x200) != 0;
  }
  
  public final void setInterface(boolean val) {
    if (val) access_flags |= 0x600; else
      access_flags &= 0xFDFF;
  }
  
  public final boolean isFinal() {
    return (getModifiers() & 0x10) != 0;
  }
  
  public final boolean isAnnotation() { return (getModifiers() & 0x2000) != 0; }
  

  public ClassType() {}
  
  public ClassType(String class_name)
  {
    setName(class_name);
  }
  

  Field last_field;
  
  int ConstantValue_name_index;
  
  int Code_name_index;
  
  int LocalVariableTable_name_index;
  
  int LineNumberTable_name_index;
  
  Method methods;
  
  int methods_count;
  Method last_method;
  public Method constructor;
  public final synchronized Field getFields()
  {
    if ((flags & 0x11) == 16)
      addFields();
    return fields;
  }
  
  public final int getFieldCount()
  {
    return fields_count;
  }
  



  public Field getDeclaredField(String name)
  {
    for (Field field = getFields(); field != null; field = next)
    {
      if (name.equals(name))
        return field;
    }
    return null;
  }
  






  public synchronized Field getField(String name, int mask)
  {
    ClassType cl = this;
    for (;;)
    {
      Field field = cl.getDeclaredField(name);
      if ((field != null) && ((mask == -1) || ((field.getModifiers() & mask) != 0)))
      {
        return field; }
      ClassType[] interfaces = cl.getInterfaces();
      if (interfaces != null)
      {
        for (int i = 0; i < interfaces.length; i++)
        {
          field = interfaces[i].getField(name, mask);
          if (field != null)
            return field;
        }
      }
      cl = cl.getSuperclass();
      if (cl == null) {
        return null;
      }
    }
  }
  


  public Field getField(String name)
  {
    return getField(name, 1);
  }
  

  public Field addField()
  {
    return new Field(this);
  }
  


  public Field addField(String name)
  {
    Field field = new Field(this);
    field.setName(name);
    return field;
  }
  
  public final Field addField(String name, Type type) {
    Field field = new Field(this);
    field.setName(name);
    field.setType(type);
    return field;
  }
  
  public final Field addField(String name, Type type, int flags)
  {
    Field field = addField(name, type);
    flags = flags;
    return field;
  }
  




  public synchronized void addFields()
  {
    Class clas = getReflectClass();
    java.lang.reflect.Field[] fields;
    try
    {
      fields = clas.getDeclaredFields();
    }
    catch (SecurityException ex)
    {
      fields = clas.getFields();
    }
    int count = fields.length;
    for (int i = 0; i < count; i++)
    {
      java.lang.reflect.Field field = fields[i];
      if ("this$0".equals(field.getName()))
        flags |= 0x20;
      int mods = field.getModifiers();
      if ((mods & 0x2) == 0) {
        Field fld = addField(field.getName(), null, mods);
        

        rfield = field;
      }
    }
    flags |= 0x1;
  }
  
  public void removeField(Field field, Field prev) {
    if (field != (prev == null ? fields : next))
      new Error();
    if (prev == null) {
      fields = next;
    } else
      next = next;
    if (last_field == field)
      last_field = null;
    fields_count -= 1;
  }
  






  public final Method getMethods()
  {
    return methods;
  }
  
  public final int getMethodCount() {
    return methods_count;
  }
  
  Method addMethod() {
    return new Method(this, 0);
  }
  
  public Method addMethod(String name) {
    return addMethod(name, 0);
  }
  
  public Method addMethod(String name, int flags) {
    Method method = new Method(this, flags);
    method.setName(name);
    return method;
  }
  


  public Method addMethod(String name, Type[] arg_types, Type return_type, int flags)
  {
    return addMethod(name, flags, arg_types, return_type);
  }
  





  public synchronized Method addMethod(String name, int flags, Type[] arg_types, Type return_type)
  {
    Method method = getDeclaredMethod(name, arg_types);
    if ((method != null) && (return_type.equals(method.getReturnType())) && ((flags & access_flags) == flags))
    {

      return method; }
    method = addMethod(name, flags);
    arg_types = arg_types;
    return_type = return_type;
    return method;
  }
  
  public Method addMethod(java.lang.reflect.Method method)
  {
    int modifiers = method.getModifiers();
    Class[] paramTypes = method.getParameterTypes();
    java.lang.reflect.Type[] gparamTypes = method.getGenericParameterTypes();
    int j = paramTypes.length;
    Type[] args = new Type[j];
    for (;;) { j--; if (j < 0) break;
      args[j] = Type.make(paramTypes[j], gparamTypes[j]); }
    Type rtype = Type.make(method.getReturnType(), method.getGenericReturnType());
    Method meth = addMethod(method.getName(), modifiers, args, rtype);
    rmethod = method;
    return meth;
  }
  
  public Method addMethod(Constructor method)
  {
    Class[] paramTypes = method.getParameterTypes();
    int modifiers = method.getModifiers();
    int j = paramTypes.length;
    Type[] args = new Type[j];
    for (;;) { j--; if (j < 0) break;
      args[j] = Type.make(paramTypes[j]); }
    Method meth = addMethod("<init>", modifiers, args, Type.voidType);
    rmethod = method;
    return meth;
  }
  
  public Method addMethod(String name, String signature, int flags)
  {
    Method meth = addMethod(name, flags);
    meth.setSignature(signature);
    return meth;
  }
  



  public Method getMethod(java.lang.reflect.Method method)
  {
    String name = method.getName();
    Class[] parameterClasses = method.getParameterTypes();
    Type[] parameterTypes = new Type[parameterClasses.length];
    int i = parameterClasses.length; for (;;) { i--; if (i < 0) break;
      parameterTypes[i] = Type.make(parameterClasses[i]); }
    return addMethod(name, method.getModifiers(), parameterTypes, Type.make(method.getReturnType()));
  }
  

  public final synchronized Method getDeclaredMethods()
  {
    if ((flags & 0x12) == 16)
      addMethods(getReflectClass());
    return methods;
  }
  







  public final int countMethods(Filter filter, int searchSupers)
  {
    Vector vec = new Vector();
    getMethods(filter, searchSupers, vec);
    return vec.size();
  }
  
  public Method[] getMethods(Filter filter, boolean searchSupers)
  {
    return getMethods(filter, searchSupers ? 1 : 0);
  }
  







  public Method[] getMethods(Filter filter, int searchSupers)
  {
    Vector<Method> vec = new Vector();
    getMethods(filter, searchSupers, vec);
    int count = vec.size();
    Method[] result = new Method[count];
    for (int i = 0; i < count; i++)
      result[i] = ((Method)vec.elementAt(i));
    return result;
  }
  










  @Deprecated
  public int getMethods(Filter filter, int searchSupers, Method[] result, int offset)
  {
    Vector<Method> vec = new Vector();
    getMethods(filter, searchSupers, vec);
    int count = vec.size();
    for (int i = 0; i < count; i++)
      result[(offset + i)] = ((Method)vec.elementAt(i));
    return count;
  }
  














  public int getMethods(Filter filter, int searchSupers, List<Method> result)
  {
    int count = 0;
    String inheritingPackage = null;
    for (ClassType ctype = this; ctype != null; 
        ctype = ctype.isInterface() ? Type.objectType : ctype.getSuperclass())
    {
      String curPackage = ctype.getPackageName();
      for (Method meth = ctype.getDeclaredMethods(); 
          meth != null; meth = meth.getNext())
      {
        if (ctype != this)
        {
          int mmods = meth.getModifiers();
          if ((mmods & 0x2) == 0)
          {
            if (((mmods & 0x5) == 0) && (!curPackage.equals(inheritingPackage))) {}
          }
          
        }
        else if (filter.select(meth))
        {
          if (result != null)
          {
            result.add(meth);
          }
          count++;
        }
      }
      
      inheritingPackage = curPackage;
      
      if (searchSupers == 0) {
        break;
      }
    }
    if (searchSupers > 1) {
      ClassType[] interfaces = getAllInterfaces();
      if (interfaces != null) {
        for (int i = 0; i < interfaces.length; i++)
          count += interfaces[i].getMethods(filter, 0, result);
      }
    }
    return count;
  }
  
  static class AbstractMethodFilter implements Filter
  {
    public static final AbstractMethodFilter instance = new AbstractMethodFilter();
    
    AbstractMethodFilter() {}
    
    public boolean select(Object value) {
      Method method = (Method)value;
      return method.isAbstract();
    }
  }
  
  public Method[] getAbstractMethods()
  {
    return getMethods(AbstractMethodFilter.instance, 2);
  }
  







  public Method getDeclaredMethod(String name, Type[] arg_types)
  {
    int needOuterLinkArg = ("<init>".equals(name)) && (hasOuterLink()) ? 1 : 0;
    Method found = null;
    for (Method method = getDeclaredMethods(); 
        method != null; method = next)
    {
      if (name.equals(method.getName()))
      {
        Type[] method_args = method.getParameterTypes();
        boolean synthetic = (method.getModifiers() & 0x1040) != 0;
        
        if ((arg_types == null) || ((arg_types == method_args) && (needOuterLinkArg == 0)))
        {

          if (!synthetic)
            return method;
          found = method;
        }
        int i = arg_types.length;
        if (i == method_args.length - needOuterLinkArg) {
          for (;;) {
            i--; if (i < 0)
              break;
            Type meth_type = method_args[(i + needOuterLinkArg)];
            Type need_type = arg_types[i];
            if ((meth_type != need_type) && (need_type != null))
            {
              String meth_sig = meth_type.getSignature();
              String need_sig = need_type.getSignature();
              if (!meth_sig.equals(need_sig)) break;
            }
          }
          if (i < 0)
          {
            if (!synthetic)
              return method;
            found = method;
          }
        } } }
    return found;
  }
  
  synchronized Method getDeclaredMethod(String name, boolean mustBeStatic, int argCount)
  {
    Method result = null;
    int needOuterLinkArg = ("<init>".equals(name)) && (hasOuterLink()) ? 1 : 0;
    for (Method method = getDeclaredMethods(); 
        method != null; method = next)
    {
      if ((!mustBeStatic) || (method.getStaticFlag()))
      {
        if ((name.equals(method.getName())) && (argCount + needOuterLinkArg == method.getParameterTypes().length))
        {

          if (result != null) {
            throw new Error("ambiguous call to getDeclaredMethod(\"" + name + "\", " + argCount + ")\n - " + result + "\n - " + method);
          }
          
          result = method;
        } }
    }
    return result;
  }
  
  public Method getDeclaredMethod(String name, int argCount)
  {
    return getDeclaredMethod(name, false, argCount);
  }
  

  public Method getDeclaredStaticMethod(String name, int argCount)
  {
    return getDeclaredMethod(name, true, argCount);
  }
  



  public synchronized Method getMethod(String name, Type[] arg_types)
  {
    for (ClassType cl = this; cl != null; cl = cl.getSuperclass()) {
      Method m = cl.getDeclaredMethod(name, arg_types);
      if (m != null)
        return m;
    }
    ClassType[] interfaces = getAllInterfaces();
    if (interfaces != null) {
      for (int i = 0; i < interfaces.length; i++) {
        Method m = interfaces[i].getDeclaredMethod(name, arg_types);
        if (m != null)
          return m;
      }
    }
    return null;
  }
  
  public Method getDefaultConstructor()
  {
    return getDeclaredMethod("<init>", Type.typeArray0);
  }
  








  public synchronized void addMethods(Class clas)
  {
    flags |= 0x2;
    
    java.lang.reflect.Method[] methods;
    try
    {
      methods = clas.getDeclaredMethods();
    }
    catch (SecurityException ex)
    {
      methods = clas.getMethods();
    }
    int count = methods.length;
    for (int i = 0; i < count; i++)
    {
      java.lang.reflect.Method method = methods[i];
      if (method.getDeclaringClass().equals(clas))
      {
        addMethod(method);
      }
    }
    Constructor[] cmethods;
    try
    {
      cmethods = clas.getDeclaredConstructors();
    }
    catch (SecurityException ex)
    {
      cmethods = clas.getConstructors();
    }
    count = cmethods.length;
    for (int i = 0; i < count; i++)
    {
      Constructor method = cmethods[i];
      if (method.getDeclaringClass().equals(clas))
      {
        addMethod(method);
      }
    }
  }
  
  public Method[] getMatchingMethods(String name, Type[] paramTypes, int flags) {
    int nMatches = 0;
    Vector matches = new Vector(10);
    for (Method method = methods; method != null; method = method.getNext())
    {
      if (name.equals(method.getName()))
      {
        if ((flags & 0x8) == (access_flags & 0x8))
        {
          if ((flags & 0x1) <= (access_flags & 0x1))
          {
            Type[] mtypes = arg_types;
            if (mtypes.length == paramTypes.length)
            {
              nMatches++;
              matches.addElement(method);
            } } } } }
    Method[] result = new Method[nMatches];
    matches.copyInto(result);
    return result;
  }
  
  public <T extends java.lang.annotation.Annotation> T getAnnotation(Class<T> clas)
  {
    T ann = RuntimeAnnotationsAttr.getAnnotation(this, clas);
    if (ann != null)
      return ann;
    if (((flags & 0x10) != 0) && (getReflectClass() != null)) {
      Class<?> c = getReflectClass();
      return c.getAnnotation(clas);
    }
    return null;
  }
  



  public void doFixups()
  {
    if (constants == null)
      constants = new ConstantPool();
    if (thisClassIndex == 0)
      thisClassIndex = constants.addClass(this).index;
    if (superClass == this)
      setSuper((ClassType)null);
    if (superClassIndex < 0) {
      superClassIndex = (superClass == null ? 0 : constants.addClass(superClass).index);
    }
    if ((interfaces != null) && (interfaceIndexes == null))
    {
      int n = interfaces.length;
      interfaceIndexes = new int[n];
      for (int i = 0; i < n; i++)
        interfaceIndexes[i] = constants.addClass(interfaces[i]).index;
    }
    for (Field field = fields; field != null; field = next) {
      field.assign_constants(this);
    }
    for (Method method = methods; method != null; method = next)
      method.assignConstants();
    if ((enclosingMember instanceof Method))
    {
      EnclosingMethodAttr attr = EnclosingMethodAttr.getFirstEnclosingMethod(getAttributes());
      
      if (attr == null)
        attr = new EnclosingMethodAttr(this);
      method = ((Method)enclosingMember);
    }
    else if ((enclosingMember instanceof ClassType)) {
      constants.addClass((ClassType)enclosingMember); }
    for (ClassType member = firstInnerClass; member != null; 
        member = nextInnerClass)
    {
      constants.addClass(member);
    }
    
    InnerClassesAttr innerAttr = InnerClassesAttr.getFirstInnerClasses(getAttributes());
    
    if (innerAttr != null)
    {

      innerAttr.setSkipped(true);
    }
    
    Attribute.assignConstants(this, this);
    




    for (int i = 1; i <= constants.count; i++)
    {
      CpoolEntry entry = constants.pool[i];
      if ((entry instanceof CpoolClass))
      {
        CpoolClass centry = (CpoolClass)entry;
        if ((clas instanceof ClassType))
        {
          ClassType ctype = (ClassType)clas;
          if (ctype.getEnclosingMember() != null)
          {
            if (innerAttr == null)
              innerAttr = new InnerClassesAttr(this);
            innerAttr.addClass(centry, this);
          }
        } } }
    if (innerAttr != null)
    {
      innerAttr.setSkipped(false);
      innerAttr.assignConstants(this);
    }
  }
  
  public void writeToStream(OutputStream stream)
    throws IOException
  {
    DataOutputStream dstr = new DataOutputStream(stream);
    

    doFixups();
    
    dstr.writeInt(-889275714);
    dstr.writeShort(getClassfileMinorVersion());
    dstr.writeShort(getClassfileMajorVersion());
    

    if (constants == null) {
      dstr.writeShort(1);
    } else {
      constants.write(dstr);
    }
    dstr.writeShort(access_flags);
    dstr.writeShort(thisClassIndex);
    dstr.writeShort(superClassIndex);
    if (interfaceIndexes == null) {
      dstr.writeShort(0);
    }
    else {
      int interfaces_count = interfaceIndexes.length;
      dstr.writeShort(interfaces_count);
      for (int i = 0; i < interfaces_count; i++) {
        dstr.writeShort(interfaceIndexes[i]);
      }
    }
    dstr.writeShort(fields_count);
    for (Field field = fields; field != null; field = next) {
      field.write(dstr, this);
    }
    dstr.writeShort(methods_count);
    for (Method method = methods; method != null; method = next) {
      method.write(dstr, this);
    }
    Attribute.writeAll(this, dstr);
    
    flags |= 0xB;
  }
  
  public void writeToFile(String filename)
    throws IOException
  {
    OutputStream stream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(filename));
    
    writeToStream(stream);
    stream.close();
  }
  
  public void writeToFile()
    throws IOException
  {
    writeToFile(this_name.replace('.', java.io.File.separatorChar) + ".class");
  }
  
  public byte[] writeToArray()
  {
    java.io.ByteArrayOutputStream stream = new java.io.ByteArrayOutputStream(500);
    try
    {
      writeToStream(stream);
    }
    catch (IOException ex)
    {
      throw new InternalError(ex.toString());
    }
    return stream.toByteArray();
  }
  





  public static byte[] to_utf8(String str)
  {
    if (str == null)
      return null;
    int str_len = str.length();
    int utf_len = 0;
    for (int i = 0; i < str_len; i++) {
      int c = str.charAt(i);
      if ((c > 0) && (c <= 127)) {
        utf_len++;
      } else if (c <= 2047) {
        utf_len += 2;
      } else
        utf_len += 3;
    }
    byte[] buffer = new byte[utf_len];
    int j = 0;
    for (int i = 0; i < str_len; i++) {
      int c = str.charAt(i);
      if ((c > 0) && (c <= 127)) {
        buffer[(j++)] = ((byte)c);
      } else if (c <= 2047) {
        buffer[(j++)] = ((byte)(0xC0 | c >> 6 & 0x1F));
        buffer[(j++)] = ((byte)(0x80 | c >> 0 & 0x3F));
      } else {
        buffer[(j++)] = ((byte)(0xE0 | c >> 12 & 0xF));
        buffer[(j++)] = ((byte)(0x80 | c >> 6 & 0x3F));
        buffer[(j++)] = ((byte)(0x80 | c >> 0 & 0x3F));
      }
    }
    return buffer;
  }
  

  public final boolean implementsInterface(ClassType iface)
  {
    if (this == iface)
      return true;
    ClassType baseClass = getSuperclass();
    if ((baseClass != null) && (baseClass.implementsInterface(iface)))
      return true;
    ClassType[] interfaces = getInterfaces();
    if (interfaces != null)
    {
      int i = interfaces.length; do { i--; if (i < 0)
          break;
      } while (!interfaces[i].implementsInterface(iface));
      return true;
    }
    
    return false;
  }
  




  public final boolean isSubclass(String cname)
  {
    ClassType ctype = this;
    do
    {
      if (cname.equals(ctype.getName()))
        return true;
      ctype = ctype.getSuperclass();
    } while (ctype != null);
    return false;
  }
  

  public final boolean isSubclass(ClassType other)
  {
    if (other.isInterface())
      return implementsInterface(other);
    if ((this == javalangStringType) && (other == toStringType))
      return true;
    if (other == Type.javalangObjectType)
      return true;
    ClassType baseClass = this;
    while (baseClass != null)
    {
      if (baseClass == other)
        return true;
      baseClass = baseClass.getSuperclass();
    }
    return false;
  }
  
  public int isCompatibleWithValue(Type valueType)
  {
    if ((this == objectType) && ((valueType instanceof ObjectType)))
      return 2;
    if ((valueType == Type.nullType) || (Type.isSame(this, valueType)))
      return 2;
    if (isInterface()) {
      Type rawType = valueType.getRawType();
      if (!(rawType instanceof ClassType))
        return -1;
      if (rawType == objectType)
        return 0;
      if (((ClassType)rawType).implementsInterface(this))
        return 2;
      if ((rawType.isInterface()) && (implementsInterface((ClassType)rawType)))
      {
        return 0;
      }
      

      return -1;
    }
    int comp = compare(valueType);
    if (comp >= 0) {
      return (valueType instanceof ObjectType) ? 2 : 1;
    }
    return comp == -3 ? -1 : 0;
  }
  

  public int compare(Type other)
  {
    if (other == nullType)
      return 1;
    if (!(other instanceof ClassType))
      return swappedCompareResult(other.compare(this));
    String name = getName();
    if ((name != null) && (name.equals(other.getName())))
      return 0;
    ClassType cother = (ClassType)other;
    if (isSubclass(cother))
      return -1;
    if (cother.isSubclass(this))
      return 1;
    if (isInterface()) {
      return cother == Type.javalangObjectType ? -1 : (cother.isAnnotation()) || (cother.isFinal()) ? -3 : -2;
    }
    if (cother.isInterface()) {
      return this == Type.javalangObjectType ? 1 : (isAnnotation()) || (isFinal()) ? -3 : -2;
    }
    return -3;
  }
  
  public String toString()
  {
    return "ClassType " + getName();
  }
  


  public void writeExternal(java.io.ObjectOutput out)
    throws IOException
  {
    out.writeUTF(getName());
  }
  
  public void readExternal(java.io.ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    setName(in.readUTF());
    flags |= 0x10;
  }
  
  public Object readResolve() throws java.io.ObjectStreamException
  {
    String name = getName();
    
    java.util.HashMap<String, Type> map = mapNameToType;
    


    synchronized (map)
    {
      Type found = (Type)map.get(name);
      if (found != null)
        return found;
      map.put(name, this);
    }
    return this;
  }
  

  public void cleanupAfterCompilation()
  {
    for (Method meth = methods; meth != null; meth = meth.getNext()) {
      meth.cleanupAfterCompilation();
    }
    constants = null;
    attributes = null;
    sourceDbgExt = null;
  }
  







  public Method checkSingleAbstractMethod()
  {
    Method[] methods = getAbstractMethods();
    int nmethods = methods.length;
    Method result = null;
    for (int i = 0; i < nmethods; i++)
    {
      Method meth = methods[i];
      final String mname = meth.getName();
      final String sig = meth.getSignature();
      Filter<Method> filter = new Filter() {
        public boolean select(Method m) {
          return (!m.isAbstract()) && (mname.equals(m.getName())) && (sig.equals(m.getSignature()));
        }
      };
      

      if (countMethods(filter, 2) <= 0)
      {
        if (result != null)
          return null;
        result = meth;
      } }
    return result;
  }
}
