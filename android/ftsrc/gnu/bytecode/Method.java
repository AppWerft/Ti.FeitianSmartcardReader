package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.util.Stack;











public class Method
  implements AttrContainer, Member
{
  private String name;
  Type[] arg_types;
  Type return_type;
  int access_flags;
  int name_index;
  int signature_index;
  Method next;
  ClassType classfile;
  CodeAttr code;
  AccessibleObject rmethod;
  Attribute attributes;
  ExceptionsAttr exceptions;
  String signature;
  
  public final Attribute getAttributes() { return attributes; }
  
  public final void setAttributes(Attribute attributes) { this.attributes = attributes; }
  

  public final ExceptionsAttr getExceptionAttr() { return exceptions; }
  
  public void setExceptions(short[] exn_indices) {
    if (exceptions == null)
      exceptions = new ExceptionsAttr(this);
    exceptions.setExceptions(exn_indices, classfile);
  }
  
  public void setExceptions(ClassType[] exn_types) {
    if (exceptions == null)
      exceptions = new ExceptionsAttr(this);
    exceptions.setExceptions(exn_types);
  }
  
  public final CodeAttr getCode() { return code; }
  


  private Method() {}
  

  static Method makeCloneMethod(Type returnType)
  {
    Method method = new Method();
    name = "clone";
    access_flags = 1;
    arg_types = Type.typeArray0;
    return_type = returnType;
    classfile = Type.objectType;
    return method;
  }
  



  public Method(Method base, ClassType clas)
  {
    arg_types = arg_types;
    return_type = return_type;
    name = name;
    access_flags = access_flags;
    classfile = clas;
  }
  
  Method(ClassType clfile, int flags) {
    if (last_method == null) {
      methods = this;
    } else
      last_method.next = this;
    last_method = this;
    methods_count += 1;
    access_flags = flags;
    classfile = clfile;
  }
  
  public final void setStaticFlag(boolean is_static) {
    if (is_static) {
      access_flags |= 0x8;
    } else
      access_flags ^= 0xFFFFFFF7;
  }
  
  public final boolean getStaticFlag() {
    return (access_flags & 0x8) != 0;
  }
  
  public final boolean isAbstract() {
    return (access_flags & 0x400) != 0;
  }
  
  public final boolean isNative() {
    return (access_flags & 0x100) != 0;
  }
  
  public int getModifiers() {
    return access_flags;
  }
  
  public void setModifiers(int modifiers) {
    access_flags = modifiers;
  }
  
  public final ConstantPool getConstants() {
    return classfile.constants;
  }
  
  public Scope pushScope() {
    prepareCode(0);
    return code.pushScope();
  }
  

  public final boolean reachableHere() { return code.reachableHere(); }
  
  public Scope popScope() { return code.popScope(); }
  


  @Deprecated
  public void allocate_local(Variable local)
  {
    local.allocateLocal(code);
  }
  

  public void initCode()
  {
    if (classfile.constants == null)
      classfile.constants = new ConstantPool();
    prepareCode(0);
    code.sourceDbgExt = classfile.sourceDbgExt;
    code.noteParamTypes();
    code.pushScope();
  }
  
  /**
   * @deprecated
   */
  public void init_param_slots() {
    startCode();
  }
  
  public CodeAttr startCode()
  {
    initCode();
    code.addParamLocals();
    return code;
  }
  
  void kill_local(Variable var) { var.freeLocal(code); }
  


  void prepareCode(int max_size)
  {
    if (code == null)
      code = new CodeAttr(this);
    code.reserve(max_size);
  }
  



  void instruction_start_hook(int max_size)
  {
    prepareCode(max_size);
  }
  
  final Type pop_stack_type() { return code.popType(); }
  final void push_stack_type(Type type) { code.pushType(type); }
  
  public void compile_checkcast(Type type) {
    code.emitCheckcast(type);
  }
  
  public void maybe_compile_checkcast(Type type) {
    Type stack_type = code.topType();
    if (type != stack_type) {
      code.emitCheckcast(type);
    }
  }
  

  /**
   * @deprecated
   */
  public void push_var(Variable var) { code.emitLoad(var); }
  
  @Deprecated
  public void compile_push_value(Variable var) { code.emitLoad(var); }
  
  @Deprecated
  public void compile_store_value(Variable var) { code.emitStore(var); }
  
  public void compile_push_this()
  {
    code.emitPushThis();
  }
  
  void write(DataOutputStream dstr, ClassType classfile) throws IOException
  {
    dstr.writeShort(access_flags);
    dstr.writeShort(name_index);
    dstr.writeShort(signature_index);
    
    Attribute.writeAll(this, dstr);
  }
  
  public static String makeSignature(Type[] arg_types, Type return_type)
  {
    StringBuilder buf = new StringBuilder(100);
    


    int args_count = arg_types.length;
    buf.append('(');
    for (int i = 0; i < args_count; i++)
      buf.append(arg_types[i].getSignature());
    buf.append(')');
    buf.append(return_type.getSignature());
    return buf.toString();
  }
  
  public static String makeGenericSignature(Type[] arg_types, Type return_type)
  {
    StringBuilder buf = new StringBuilder(100);
    int args_count = arg_types.length;
    buf.append('(');
    for (int i = 0; i < args_count; i++)
      buf.append(arg_types[i].getMaybeGenericSignature());
    buf.append(')');
    buf.append(return_type.getMaybeGenericSignature());
    return buf.toString();
  }
  

  public String getSignature()
  {
    if (signature == null)
      signature = makeSignature(arg_types, return_type);
    return signature;
  }
  
  public void setSignature(String signature) {
    int len = signature.length();
    if ((len < 3) || (signature.charAt(0) != '('))
      throw new ClassFormatError("bad method signature");
    int pos = 1;
    Stack<Type> types = new Stack();
    for (;;) {
      int arg_sig_len = Type.signatureLength(signature, pos);
      if (arg_sig_len < 0) {
        if ((pos < len) && (signature.charAt(pos) == ')'))
          break;
        throw new ClassFormatError("bad method signature");
      }
      Type arg_type = Type.signatureToType(signature, pos, arg_sig_len);
      types.push(arg_type);
      pos += arg_sig_len;
    }
    arg_types = new Type[types.size()];
    int i = types.size(); for (;;) { i--; if (i < 0) break;
      arg_types[i] = ((Type)types.pop()); }
    return_type = Type.signatureToType(signature, pos + 1, len - pos - 1);
  }
  
  public void setSignature(int signature_index) {
    CpoolUtf8 sigConstant = (CpoolUtf8)getConstants().getForced(signature_index, 1);
    
    this.signature_index = signature_index;
    setSignature(string);
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> clas)
  {
    T ann = RuntimeAnnotationsAttr.getAnnotation(this, clas);
    if (ann != null)
      return ann;
    return rmethod == null ? null : rmethod.getAnnotation(clas);
  }
  
  void assignConstants() {
    ConstantPool constants = getConstants();
    if ((name_index == 0) && (name != null))
      name_index = addUtf8name).index;
    String signature = getSignature();
    String genericSignature = makeGenericSignature(arg_types, return_type);
    if (signature_index == 0)
      signature_index = addUtf8index;
    if ((genericSignature != null) && (!genericSignature.equals(signature))) {
      SignatureAttr attr = new SignatureAttr(genericSignature);
      attr.addToFrontOf(this);
    }
    Attribute.assignConstants(this, classfile);
  }
  
  public ClassType getDeclaringClass() { return classfile; }
  
  public final Type getReturnType() { return return_type; }
  public final void setReturnType(Type type) { return_type = type; }
  
  public final Type[] getParameterTypes() { return arg_types; }
  
  public final ClassType[] getExceptions()
  {
    if (exceptions == null) return null;
    return exceptions.getExceptions();
  }
  
  public final String getName() {
    return name;
  }
  
  public final void setName(String name) {
    this.name = name;
  }
  
  public final void setName(int name_index) {
    if (name_index <= 0) {
      name = null;
    } else {
      CpoolUtf8 nameConstant = (CpoolUtf8)getConstants().getForced(name_index, 1);
      
      name = string;
    }
    this.name_index = name_index;
  }
  
  public final Method getNext() {
    return next;
  }
  
  public void listParameters(StringBuffer sbuf) {
    int args_count = arg_types.length;
    sbuf.append('(');
    for (int i = 0; i < args_count; i++) {
      if (i > 0)
        sbuf.append(',');
      sbuf.append(arg_types[i].getName());
    }
    sbuf.append(')');
  }
  
  public String toString() {
    StringBuffer sbuf = new StringBuffer(100);
    ClassType declaring = getDeclaringClass();
    sbuf.append(declaring != null ? declaring.getName() : "???");
    sbuf.append('.');
    sbuf.append(name);
    if (arg_types != null) {
      listParameters(sbuf);
      sbuf.append(return_type.getName());
    }
    return sbuf.toString();
  }
  
  public void cleanupAfterCompilation() {
    attributes = null;
    exceptions = null;
    code = null;
  }
}
