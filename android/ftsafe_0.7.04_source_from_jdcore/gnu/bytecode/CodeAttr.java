package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;



public class CodeAttr
  extends Attribute
  implements AttrContainer
{
  Attribute attributes;
  LineNumbersAttr lines;
  public LocalVarsAttr locals;
  public StackMapTableAttr stackMap;
  SourceDebugExtAttr sourceDbgExt;
  public static final int GENERATE_STACK_MAP_TABLE = 1;
  public static final int DONT_USE_JSR = 2;
  int flags;
  public Type[] stack_types;
  
  public final Attribute getAttributes() { return attributes; }
  
  public final void setAttributes(Attribute attributes) { this.attributes = attributes; }
  










  Type[] local_types = new Type[20];
  
  Label previousLabel;
  boolean[] varsSetInCurrentBlock;
  int SP;
  private int max_stack;
  private int max_locals;
  int PC;
  byte[] code;
  short[] exception_table;
  int exception_table_length;
  static final int FIXUP_DEFINE = 0;
  static final int FIXUP_DEFINE_UNREACHABLE = 1;
  static final int FIXUP_SWITCH = 2;
  static final int FIXUP_CASE = 3;
  static final int FIXUP_GOTO = 4;
  
  boolean useJsr()
  {
    return (flags & 0x2) == 0;
  }
  




  static final int FIXUP_JSR = 5;
  



  static final int FIXUP_TRANSFER = 6;
  



  static final int FIXUP_TRANSFER2 = 7;
  



  static final int FIXUP_DELETE3 = 8;
  



  static final int FIXUP_MOVE = 9;
  



  static final int FIXUP_MOVE_TO_END = 10;
  



  static final int FIXUP_TRY = 11;
  



  static final int FIXUP_TRY_END = 12;
  



  static final int FIXUP_TRY_HANDLER = 13;
  


  static final int FIXUP_LINE_PC = 14;
  


  static final int FIXUP_LINE_NUMBER = 15;
  


  int[] fixup_offsets;
  


  Label[] fixup_labels;
  


  int fixup_count;
  


  public final void fixupChain(Label here, Label target)
  {
    fixupAdd(9, -1, target);
    here.defineRaw(this);
    setPreviousLabelHere(here);
  }
  



  public final void fixupAdd(int kind, Label label)
  {
    fixupAdd(kind, PC, label);
  }
  
  final void fixupAdd(int kind, int offset, Label label)
  {
    if ((label != null) && (kind != 0) && (kind != 1) && (kind != 2) && (kind != 11))
    {
      needsStackMapEntry = true; }
    int count = fixup_count;
    if (count == 0)
    {
      fixup_offsets = new int[30];
      fixup_labels = new Label[30];
    }
    else if (fixup_count == fixup_offsets.length)
    {
      int new_length = 2 * count;
      Label[] new_labels = new Label[new_length];
      System.arraycopy(fixup_labels, 0, new_labels, 0, count);
      fixup_labels = new_labels;
      int[] new_offsets = new int[new_length];
      System.arraycopy(fixup_offsets, 0, new_offsets, 0, count);
      fixup_offsets = new_offsets;
    }
    fixupSet(count, kind, offset);
    fixup_labels[count] = label;
    fixup_count = (count + 1);
  }
  
  private final int fixupOffset(int index)
  {
    return fixup_offsets[index] >> 4;
  }
  
  private final int fixupKind(int index)
  {
    return fixup_offsets[index] & 0xF;
  }
  
  private void fixupSet(int index, int kind, int offset) {
    fixup_offsets[index] = fixupEncode(kind, offset);
  }
  
  private int fixupEncode(int kind, int offset) { return offset << 4 | kind; }
  




  public static boolean instructionLineMode = false;
  
  IfState if_stack;
  TryState try_stack;
  private boolean unreachable_here;
  ExitableBlock currentExitableBlock;
  int exitableBlockLevel;
  
  public final Method getMethod() { return (Method)getContainer(); }
  
  public final int getPC() { return PC; }
  
  public final int getSP() { return SP; }
  
  public final ConstantPool getConstants()
  {
    return getMethodclassfile.constants;
  }
  




  public final boolean reachableHere() { return !unreachable_here; }
  public final void setReachable(boolean val) { unreachable_here = (!val); }
  public final void setUnreachable() { unreachable_here = true; }
  

  public int getMaxStack() { return max_stack; }
  
  public int getMaxLocals() { return max_locals; }
  

  public void setMaxStack(int n) { max_stack = n; }
  
  public void setMaxLocals(int n) { max_locals = n; }
  
  public byte[] getCode()
  {
    return code;
  }
  
  public void setCode(byte[] code)
  {
    this.code = code;PC = code.length;
  }
  

  public void setCodeLength(int len) { PC = len; }
  
  public int getCodeLength() { return PC; }
  
  public CodeAttr(Method meth)
  {
    super("Code");
    addToFrontOf(meth);
    code = this;
    if (meth.getDeclaringClass().getClassfileMajorVersion() >= 50) {
      flags |= 0x3;
    }
  }
  
  public final void reserve(int bytes) {
    if (code == null) {
      code = new byte[100 + bytes];
    } else if (PC + bytes > code.length)
    {
      byte[] new_code = new byte[2 * code.length + bytes];
      System.arraycopy(code, 0, new_code, 0, PC);
      code = new_code;
    }
  }
  

  byte invert_opcode(byte opcode)
  {
    int iopcode = opcode & 0xFF;
    if (((iopcode >= 153) && (iopcode <= 166)) || ((iopcode >= 198) && (iopcode <= 199)))
    {
      return (byte)(iopcode ^ 0x1); }
    throw new Error("unknown opcode to invert_opcode");
  }
  




  public final void put1(int i)
  {
    code[(PC++)] = ((byte)i);
    unreachable_here = false;
  }
  




  public final void put2(int i)
  {
    code[(PC++)] = ((byte)(i >> 8));
    code[(PC++)] = ((byte)i);
    unreachable_here = false;
  }
  




  public final void put4(int i)
  {
    code[(PC++)] = ((byte)(i >> 24));
    code[(PC++)] = ((byte)(i >> 16));
    code[(PC++)] = ((byte)(i >> 8));
    
    code[(PC++)] = ((byte)i);
    unreachable_here = false;
  }
  
  public final void putIndex2(CpoolEntry cnst)
  {
    put2(index);
  }
  
  public final void putLineNumber(String filename, int linenumber)
  {
    if (filename != null)
      getMethodclassfile.setSourceFile(filename);
    putLineNumber(linenumber);
  }
  
  public final void putLineNumber(int linenumber)
  {
    if (sourceDbgExt != null)
      linenumber = sourceDbgExt.fixLine(linenumber);
    fixupAdd(14, null);
    fixupAdd(15, linenumber, null);
  }
  

  void noteParamTypes()
  {
    Method method = getMethod();
    int offset = 0;
    if ((access_flags & 0x8) == 0)
    {
      Type type = classfile;
      if (("<init>".equals(method.getName())) && (!"java.lang.Object".equals(type.getName())))
      {
        type = UninitializedType.uninitializedThis((ClassType)type); }
      noteVarType(offset++, type);
    }
    int arg_count = arg_types.length;
    for (int i = 0; i < arg_count; i++)
    {
      Type type = arg_types[i];
      noteVarType(offset++, type);
      int size = type.getSizeInWords(); for (;;) { size--; if (size <= 0) break;
        offset++;
      } }
    if ((flags & 0x1) != 0)
    {
      stackMap = new StackMapTableAttr();
      
      int[] encodedLocals = new int[20 + offset];
      int count = 0;
      for (int i = 0; i < offset; i++)
      {
        int encoded = stackMap.encodeVerificationType(local_types[i], this);
        encodedLocals[(count++)] = encoded;
        int tag = encoded & 0xFF;
        if ((tag == 3) || (tag == 4))
          i++;
      }
      stackMap.encodedLocals = encodedLocals;
      stackMap.countLocals = count;
      stackMap.encodedStack = new int[10];
      stackMap.countStack = 0;
    }
  }
  
  void setPreviousLabelHere(Label here) {
    previousLabel = here;
    boolean[] varsSet = varsSetInCurrentBlock;
    if (varsSet != null)
      for (int i = varsSet.length;; varsSet[i] = false) { i--; if (i < 0)
          break;
      }
  }
  
  public void noteVarType(int offset, Type type) { int size = type.getSizeInWords();
    
    if (local_types == null) {
      local_types = new Type[offset + size + 20];
    } else if (offset + size > local_types.length) {
      Type[] new_array = new Type[2 * (offset + size)];
      System.arraycopy(local_types, 0, new_array, 0, local_types.length);
      local_types = new_array;
    }
    local_types[offset] = type;
    if (varsSetInCurrentBlock == null) {
      varsSetInCurrentBlock = new boolean[local_types.length];
    } else if (varsSetInCurrentBlock.length <= offset)
    {
      boolean[] tmp = new boolean[local_types.length];
      System.arraycopy(varsSetInCurrentBlock, 0, tmp, 0, varsSetInCurrentBlock.length);
      varsSetInCurrentBlock = tmp;
    }
    varsSetInCurrentBlock[offset] = true;
    if (offset > 0)
    {
      Type prev = local_types[(offset - 1)];
      if ((prev != null) && (prev.getSizeInWords() == 2))
        local_types[(offset - 1)] = null;
    }
    for (;;) { size--; if (size <= 0) break;
      local_types[(++offset)] = null;
    }
  }
  
  public final void setTypes(Label label)
  {
    setTypes(localTypes, stackTypes);
  }
  

  public final void setTypes(Type[] labelLocals, Type[] labelStack)
  {
    int usedStack = labelStack.length;
    int usedLocals = labelLocals.length;
    if (local_types != null)
    {
      if (usedLocals > 0)
        System.arraycopy(labelLocals, 0, local_types, 0, usedLocals);
      for (int i = usedLocals; i < local_types.length; i++)
        local_types[i] = null;
    }
    if ((stack_types == null) || (usedStack > stack_types.length)) {
      stack_types = new Type[usedStack];
    }
    else {
      for (int i = usedStack; i < stack_types.length; i++)
        stack_types[i] = null;
    }
    System.arraycopy(labelStack, 0, stack_types, 0, usedStack);
    SP = usedStack;
  }
  
  public final void pushType(Type type)
  {
    if (size == 0)
      throw new Error("pushing void type onto stack");
    if ((stack_types == null) || (stack_types.length == 0)) {
      stack_types = new Type[20];
    } else if (SP + 1 >= stack_types.length) {
      Type[] new_array = new Type[2 * stack_types.length];
      System.arraycopy(stack_types, 0, new_array, 0, SP);
      stack_types = new_array;
    }
    if (size == 8)
      stack_types[(SP++)] = Type.voidType;
    stack_types[(SP++)] = type;
    if (SP > max_stack) {
      max_stack = SP;
    }
  }
  
  public final Type popType() {
    if (SP <= 0)
      throw new Error("popType called with empty stack " + getMethod());
    Type type = stack_types[(--SP)];
    if ((size == 8) && 
      (!popType().isVoid()))
      throw new Error("missing void type on stack");
    return type;
  }
  
  public final Type topType()
  {
    return stack_types[(SP - 1)];
  }
  
  public void emitPop(int nvalues)
  {
    for (; 
        

        nvalues > 0; nvalues--)
    {
      reserve(1);
      Type type = popType();
      if (size > 4) {
        put1(88);
      } else if (nvalues > 1)
      {
        Type type2 = popType();
        if (size > 4)
        {
          put1(87);
          reserve(1);
        }
        put1(88);
        nvalues--;
      }
      else {
        put1(87);
      }
    }
  }
  


  public Label getLabel()
  {
    Label label = new Label();
    label.defineRaw(this);
    return label;
  }
  
  public void emitSwap()
  {
    reserve(1);
    Type type1 = popType();
    Type type2 = popType();
    
    if ((size > 4) || (size > 4))
    {


      pushType(type2);
      pushType(type1);
      emitDupX();
      emitPop(1);
    }
    else
    {
      pushType(type1);
      put1(95);
      pushType(type2);
    }
  }
  

  public void emitDup()
  {
    reserve(1);
    
    Type type = topType();
    put1(size <= 4 ? 89 : 92);
    pushType(type);
  }
  


  public void emitDupX()
  {
    reserve(1);
    
    Type type = popType();
    Type skipedType = popType();
    
    if (size <= 4) {
      put1(size <= 4 ? 90 : 93);
    } else {
      put1(size <= 4 ? 91 : 94);
    }
    pushType(type);
    pushType(skipedType);
    pushType(type);
  }
  





  public void emitDup(int size, int offset)
  {
    if (size == 0)
      return;
    reserve(1);
    
    Type copied1 = popType();
    Type copied2 = null;
    if (size == 1)
    {
      if (size > 4)
        throw new Error("using dup for 2-word type");
    } else {
      if (size != 2)
        throw new Error("invalid size to emitDup");
      if (size <= 4)
      {
        copied2 = popType();
        if (size > 4) {
          throw new Error("dup will cause invalid types on stack");
        }
      }
    }
    
    Type skipped1 = null;
    Type skipped2 = null;
    int kind; if (offset == 0)
    {
      kind = size == 1 ? 89 : 92;
    }
    else if (offset == 1)
    {
      int kind = size == 1 ? 90 : 93;
      skipped1 = popType();
      if (size > 4) {
        throw new Error("dup will cause invalid types on stack");
      }
    } else if (offset == 2)
    {
      int kind = size == 1 ? 91 : 94;
      skipped1 = popType();
      if (size <= 4)
      {
        skipped2 = popType();
        if (size > 4) {
          throw new Error("dup will cause invalid types on stack");
        }
      }
    } else {
      throw new Error("emitDup:  invalid offset"); }
    int kind;
    put1(kind);
    if (copied2 != null)
      pushType(copied2);
    pushType(copied1);
    if (skipped2 != null)
      pushType(skipped2);
    if (skipped1 != null)
      pushType(skipped1);
    if (copied2 != null)
      pushType(copied2);
    pushType(copied1);
  }
  




  public void emitDup(int size)
  {
    emitDup(size, 0);
  }
  
  public void emitDup(Type type)
  {
    emitDup(size > 4 ? 2 : 1, 0);
  }
  
  public void enterScope(Scope scope)
  {
    scope.setStartPC(this);
    locals.enterScope(scope);
  }
  
  public Scope pushScope()
  {
    Scope scope = new Scope();
    if (locals == null)
      locals = new LocalVarsAttr(getMethod());
    enterScope(scope);
    if (locals.parameter_scope == null)
      locals.parameter_scope = scope;
    return scope;
  }
  




  public Scope pushAutoPoppableScope()
  {
    Scope scope = pushScope();
    autoPop = true;
    return scope;
  }
  
  public Scope getCurrentScope()
  {
    return locals.current_scope;
  }
  
  public Scope popScope() {
    Label end = getLabel();
    for (;;) {
      Scope scope = locals.current_scope;
      locals.current_scope = parent;
      scope.freeLocals(this);
      end = end;
      if (!autoPop) {
        return scope;
      }
    }
  }
  
  public Variable getArg(int index)
  {
    return locals.parameter_scope.getVariable(index);
  }
  





  public Variable lookup(String name)
  {
    for (Scope scope = locals.current_scope; 
        scope != null; scope = parent)
    {
      Variable var = scope.lookup(name);
      if (var != null)
        return var;
    }
    return null;
  }
  



  public Variable addLocal(Type type)
  {
    return locals.current_scope.addVariable(this, type, null);
  }
  




  public Variable addLocal(Type type, String name)
  {
    return locals.current_scope.addVariable(this, type, name);
  }
  

  public void addParamLocals()
  {
    Method method = getMethod();
    if ((access_flags & 0x8) == 0)
      addLocal(classfile).setParameter(true);
    int arg_count = arg_types.length;
    for (int i = 0; i < arg_count; i++) {
      addLocal(arg_types[i]).setParameter(true);
    }
  }
  
  public final void emitPushConstant(int val, Type type) {
    switch (type.getSignature().charAt(0)) {
    case 'B': case 'C': case 'I': 
    case 'S': case 'Z': 
      emitPushInt(val); break;
    case 'J': 
      emitPushLong(val); break;
    case 'F': 
      emitPushFloat(val); break;
    case 'D': 
      emitPushDouble(val); break;
    case 'E': case 'G': case 'H': case 'K': case 'L': case 'M': case 'N': case 'O': case 'P': case 'Q': case 'R': case 'T': case 'U': case 'V': case 'W': case 'X': case 'Y': default: 
      throw new Error("bad type to emitPushConstant");
    }
    
  }
  

  public final void emitPushConstant(CpoolEntry cnst)
  {
    reserve(3);
    int index = index;
    if ((cnst instanceof CpoolValue2))
    {
      put1(20);
      put2(index);
    }
    else if (index < 256)
    {
      put1(18);
      put1(index);
    }
    else
    {
      put1(19);
      put2(index);
    }
  }
  
  public final void emitPushInt(int i)
  {
    reserve(3);
    if ((i >= -1) && (i <= 5)) {
      put1(i + 3);
    } else if ((i >= -128) && (i < 128))
    {
      put1(16);
      put1(i);
    }
    else if ((i >= 32768) && (i < 32768))
    {
      put1(17);
      put2(i);
    }
    else
    {
      emitPushConstant(getConstants().addInt(i));
    }
    pushType(Type.intType);
  }
  
  public void emitPushLong(long i)
  {
    if ((i == 0L) || (i == 1L))
    {
      reserve(1);
      put1(9 + (int)i);
    }
    else if ((int)i == i)
    {
      emitPushInt((int)i);
      reserve(1);
      popType();
      put1(133);
    }
    else
    {
      emitPushConstant(getConstants().addLong(i));
    }
    pushType(Type.longType);
  }
  
  public void emitPushFloat(float x)
  {
    int xi = (int)x;
    if ((xi == x) && (xi >= -128) && (xi < 128))
    {
      if ((xi >= 0) && (xi <= 2))
      {
        reserve(1);
        put1(11 + xi);
        if ((xi == 0) && (Float.floatToIntBits(x) != 0))
        {
          reserve(1);
          put1(118);
        }
        

      }
      else
      {
        emitPushInt(xi);
        reserve(1);
        popType();
        put1(134);
      }
      
    }
    else {
      emitPushConstant(getConstants().addFloat(x));
    }
    pushType(Type.floatType);
  }
  
  public void emitPushDouble(double x)
  {
    int xi = (int)x;
    if ((xi == x) && (xi >= -128) && (xi < 128))
    {
      if ((xi == 0) || (xi == 1))
      {
        reserve(1);
        put1(14 + xi);
        if ((xi == 0) && (Double.doubleToLongBits(x) != 0L))
        {
          reserve(1);
          put1(119);
        }
        

      }
      else
      {
        emitPushInt(xi);
        reserve(1);
        popType();
        put1(135);
      }
      
    }
    else {
      emitPushConstant(getConstants().addDouble(x));
    }
    pushType(Type.doubleType);
  }
  





  public static final String calculateSplit(String str)
  {
    int strLength = str.length();
    StringBuffer sbuf = new StringBuffer(20);
    
    int segmentStart = 0;
    int byteLength = 0;
    for (int i = 0; i < strLength; i++)
    {
      char ch = str.charAt(i);
      int bytes = (ch >= '') || (ch == 0) ? 2 : ch >= 'ࠀ' ? 3 : 1;
      if (byteLength + bytes > 65535)
      {
        sbuf.append((char)(i - segmentStart));
        segmentStart = i;
        byteLength = 0;
      }
      byteLength += bytes;
    }
    sbuf.append((char)(strLength - segmentStart));
    return sbuf.toString();
  }
  





  public final void emitPushString(String str)
  {
    if (str == null) {
      emitPushNull();
    }
    else {
      int length = str.length();
      String segments = calculateSplit(str);
      int numSegments = segments.length();
      if (numSegments <= 1) {
        emitPushConstant(getConstants().addString(str));
      }
      else {
        if (numSegments == 2)
        {
          int firstSegment = segments.charAt(0);
          emitPushString(str.substring(0, firstSegment));
          emitPushString(str.substring(firstSegment));
          Method concatMethod = Type.javalangStringType.getDeclaredMethod("concat", 1);
          
          emitInvokeVirtual(concatMethod);
        }
        else
        {
          ClassType sbufType = ClassType.make("java.lang.StringBuffer");
          emitNew(sbufType);
          emitDup(sbufType);
          emitPushInt(length);
          Type[] args1 = { Type.intType };
          emitInvokeSpecial(sbufType.getDeclaredMethod("<init>", args1));
          Type[] args2 = { Type.javalangStringType };
          Method appendMethod = sbufType.getDeclaredMethod("append", args2);
          
          int segStart = 0;
          for (int seg = 0; seg < numSegments; seg++)
          {
            emitDup(sbufType);
            int segEnd = segStart + segments.charAt(seg);
            emitPushString(str.substring(segStart, segEnd));
            emitInvokeVirtual(appendMethod);
            segStart = segEnd;
          }
          emitInvokeVirtual(Type.toString_method);
        }
        if (str == str.intern())
          emitInvokeVirtual(Type.javalangStringType.getDeclaredMethod("intern", 0));
        return;
      }
      pushType(Type.javalangStringType);
    }
  }
  


  public final void emitPushClass(ObjectType ctype)
  {
    emitPushConstant(getConstants().addClass(ctype));
    pushType(Type.javalangClassType);
  }
  


  public final void emitPushMethodHandle(Method method)
  {
    emitPushConstant(getConstants().addMethodHandle(method));
    pushType(Type.javalanginvokeMethodHandleType);
  }
  
  public void emitPushNull() { emitPushNull(Type.nullType); }
  
  public void emitPushNull(ObjectType type) {
    reserve(1);
    put1(1);
    pushType(type);
  }
  

  public void emitPushDefaultValue(Type type)
  {
    type = type.getImplementationType();
    if ((type instanceof PrimType)) {
      emitPushConstant(0, type);
    } else {
      emitPushNull();
    }
  }
  
  public void emitStoreDefaultValue(Variable var)
  {
    emitPushDefaultValue(var.getType());
    emitStore(var);
  }
  
  public final void emitPushThis()
  {
    emitLoad(locals.used[0]);
  }
  




  public final void emitPushPrimArray(Object value, ArrayType arrayType)
  {
    Type elementType = arrayType.getComponentType();
    int len = Array.getLength(value);
    emitPushInt(len);
    emitNewArray(elementType);
    char sig = elementType.getSignature().charAt(0);
    for (int i = 0; i < len; i++)
    {
      long ival = 0L;float fval = 0.0F;double dval = 0.0D;
      switch (sig)
      {
      case 'J': 
        ival = ((long[])(long[])value)[i];
        if (ival != 0L) break;
        break;
      
      case 'I': 
        ival = ((int[])(int[])value)[i];
        if (ival != 0L) break;
        break;
      
      case 'S': 
        ival = ((short[])(short[])value)[i];
        if (ival != 0L) break;
        break;
      
      case 'C': 
        ival = ((char[])(char[])value)[i];
        if (ival != 0L) break;
        break;
      
      case 'B': 
        ival = ((byte[])(byte[])value)[i];
        if (ival != 0L) break;
        break;
      
      case 'Z': 
        ival = ((boolean[])(boolean[])value)[i] != 0 ? 1L : 0L;
        if (ival != 0L) break;
        break;
      
      case 'F': 
        fval = ((float[])(float[])value)[i];
        if (fval != 0.0D) break;
        break;
      
      case 'D': 
        dval = ((double[])(double[])value)[i];
        if (dval == 0.0D) {
          continue;
        }
      }
      emitDup(arrayType);
      emitPushInt(i);
      switch (sig)
      {
      case 'B': 
      case 'C': 
      case 'I': 
      case 'S': 
      case 'Z': 
        emitPushInt((int)ival);
        break;
      case 'J': 
        emitPushLong(ival);
        break;
      case 'F': 
        emitPushFloat(fval);
        break;
      case 'D': 
        emitPushDouble(dval);
      }
      
      emitArrayStore(elementType);
    }
  }
  


  void emitNewArray(int type_code)
  {
    reserve(2);
    put1(188);
    put1(type_code);
  }
  
  public final void emitArrayLength()
  {
    if (!(popType() instanceof ArrayType)) {
      throw new Error("non-array type in emitArrayLength");
    }
    reserve(1);
    put1(190);
    pushType(Type.intType);
  }
  




  private int adjustTypedOp(char sig)
  {
    switch (sig) {
    case 'I': 
      return 0;
    case 'J':  return 1;
    case 'F':  return 2;
    case 'D':  return 3;
    case 'E': case 'G': case 'H': case 'K': case 'L': case 'M': case 'N': case 'O': case 'P': case 'Q': case 'R': case 'T': case 'U': case 'V': case 'W': case 'X': case 'Y': default:  return 4;
    case 'B': case 'Z': 
      return 5;
    case 'C':  return 6; }
    return 7;
  }
  

  private int adjustTypedOp(Type type)
  {
    return adjustTypedOp(type.getSignature().charAt(0));
  }
  
  private void emitTypedOp(int op, Type type)
  {
    reserve(1);
    put1(op + adjustTypedOp(type));
  }
  
  private void emitTypedOp(int op, char sig)
  {
    reserve(1);
    put1(op + adjustTypedOp(sig));
  }
  





  public void emitArrayStore(Type element_type)
  {
    popType();
    popType();
    popType();
    emitTypedOp(79, element_type);
  }
  





  public void emitArrayStore()
  {
    popType();
    popType();
    Type arrayType = popType().getImplementationType();
    Type elementType = ((ArrayType)arrayType).getComponentType();
    emitTypedOp(79, elementType);
  }
  




  public void emitArrayLoad(Type element_type)
  {
    popType();
    popType();
    emitTypedOp(46, element_type);
    pushType(element_type);
  }
  





  public void emitArrayLoad()
  {
    popType();
    Type arrayType = popType().getImplementationType();
    Type elementType = ((ArrayType)arrayType).getComponentType();
    emitTypedOp(46, elementType);
    pushType(elementType);
  }
  





  public void emitNew(ClassType type)
  {
    reserve(3);
    Label label = new Label(this);
    label.defineRaw(this);
    put1(187);
    putIndex2(getConstants().addClass(type));
    pushType(new UninitializedType(type, label));
  }
  





  public void emitNewArray(Type element_type, int dims)
  {
    if (popType().promote() != Type.intType) {
      throw new Error("non-int dim. spec. in emitNewArray");
    }
    if ((element_type instanceof PrimType))
    {
      int code;
      switch (element_type.getSignature().charAt(0)) {
      case 'B': 
        code = 8; break;
      case 'S':  code = 9; break;
      case 'I':  code = 10; break;
      case 'J':  code = 11; break;
      case 'F':  code = 6; break;
      case 'D':  code = 7; break;
      case 'Z':  code = 4; break;
      case 'C':  code = 5; break;
      case 'E': case 'G': case 'H': case 'K': case 'L': case 'M': case 'N': case 'O': case 'P': case 'Q': case 'R': case 'T': case 'U': case 'V': case 'W': case 'X': case 'Y': default:  throw new Error("bad PrimType in emitNewArray");
      }
      emitNewArray(code);
    } else {
      if (((element_type instanceof ArrayType)) && (dims > 1))
      {
        reserve(4);
        put1(197);
        putIndex2(getConstants().addClass(new ArrayType(element_type)));
        if ((dims < 1) || (dims > 255))
          throw new Error("dims out of range in emitNewArray");
        put1(dims);
        do { dims--; if (dims <= 0) break;
        } while (popType().promote() == Type.intType);
        throw new Error("non-int dim. spec. in emitNewArray");
      }
      if ((element_type instanceof ObjectType))
      {
        reserve(3);
        put1(189);
        putIndex2(getConstants().addClass((ObjectType)element_type));
      }
      else {
        throw new Error("unimplemented type in emitNewArray");
      } }
    pushType(new ArrayType(element_type));
  }
  
  public void emitNewArray(Type element_type)
  {
    emitNewArray(element_type, 1);
  }
  

  private void emitBinop(int base_code)
  {
    Type type2 = popType().promote();
    Type type1_raw = popType();
    Type type1 = type1_raw.promote();
    if ((type1 != type2) || (!(type1 instanceof PrimType)))
      throw new Error("non-matching or bad types in binary operation");
    emitTypedOp(base_code, type1);
    pushType(type1_raw);
  }
  
  private void emitBinop(int base_code, char sig)
  {
    popType();
    popType();
    emitTypedOp(base_code, sig);
    pushType(Type.signatureToPrimitive(sig));
  }
  
  public void emitBinop(int base_code, Type type)
  {
    popType();
    popType();
    emitTypedOp(base_code, type);
    pushType(type);
  }
  





  public final void emitAdd(char sig) { emitBinop(96, sig); }
  public final void emitAdd(PrimType type) { emitBinop(96, type); } @Deprecated
  public final void emitAdd() { emitBinop(96); }
  
  public final void emitSub(char sig) { emitBinop(100, sig); }
  public final void emitSub(PrimType type) { emitBinop(100, type); } @Deprecated
  public final void emitSub() { emitBinop(100); }
  
  public final void emitMul() { emitBinop(104); }
  public final void emitDiv() { emitBinop(108); }
  public final void emitRem() { emitBinop(112); }
  public final void emitAnd() { emitBinop(126); }
  public final void emitIOr() { emitBinop(128); }
  public final void emitXOr() { emitBinop(130); }
  
  public final void emitShl() { emitShift(120); }
  public final void emitShr() { emitShift(122); }
  public final void emitUshr() { emitShift(124); }
  
  private void emitShift(int base_code)
  {
    Type type2 = popType().promote();
    Type type1_raw = popType();
    Type type1 = type1_raw.promote();
    
    if ((type1 != Type.intType) && (type1 != Type.longType)) {
      throw new Error("the value shifted must be an int or a long");
    }
    if (type2 != Type.intType) {
      throw new Error("the amount of shift must be an int");
    }
    emitTypedOp(base_code, type1);
    pushType(type1_raw);
  }
  

  public final void emitNot(Type type)
  {
    emitPushConstant(1, type);
    emitAdd();
    emitPushConstant(1, type);
    emitAnd();
  }
  
  public void emitPrimop(int opcode, int arg_count, Type retType)
  {
    reserve(1);
    for (;;) { arg_count--; if (arg_count < 0) break;
      popType(); }
    put1(opcode);
    pushType(retType);
  }
  
  void emitMaybeWide(int opcode, int index)
  {
    if (index >= 256)
    {
      put1(196);
      put1(opcode);
      put2(index);
    }
    else
    {
      put1(opcode);
      put1(index);
    }
  }
  




  public final void emitLoad(Variable var)
  {
    if (var.dead())
      throw new Error("attempting to push dead variable");
    int offset = offset;
    if ((offset < 0) || (!var.isSimple())) {
      throw new Error("attempting to load from unassigned variable " + var + " simple:" + var.isSimple() + ", offset: " + offset);
    }
    Type type = var.getType().promote();
    reserve(4);
    int kind = adjustTypedOp(type);
    if (offset <= 3) {
      put1(26 + 4 * kind + offset);
    } else
      emitMaybeWide(21 + kind, offset);
    pushType(var.getType());
  }
  
  public void emitStore(Variable var)
  {
    if (!reachableHere())
      return;
    int offset = offset;
    if ((offset < 0) || (!var.isSimple())) {
      throw new Error("attempting to store in unassigned " + var + " simple:" + var.isSimple() + ", offset: " + offset);
    }
    Type type = var.getType().promote();
    noteVarType(offset, type);
    reserve(4);
    popType();
    int kind = adjustTypedOp(type);
    if (offset <= 3) {
      put1(59 + 4 * kind + offset);
    } else {
      emitMaybeWide(54 + kind, offset);
    }
  }
  




  public void emitInc(Variable var, short inc)
  {
    if (var.dead())
      throw new Error("attempting to increment dead variable");
    int offset = offset;
    if ((offset < 0) || (!var.isSimple())) {
      throw new Error("attempting to increment unassigned variable" + var.getName() + " simple:" + var.isSimple() + ", offset: " + offset);
    }
    
    if (inc == 0) {
      return;
    }
    reserve(6);
    if (var.getType().getImplementationType().promote() != Type.intType) {
      throw new Error("attempting to increment non-int variable");
    }
    boolean wide = (offset > 255) || (inc > 255) || (inc < 65280);
    if (wide)
    {
      put1(196);
      put1(132);
      put2(offset);
      put2(inc);
    }
    else
    {
      put1(132);
      put1(offset);
      put1(inc);
    }
  }
  

  private final void emitFieldop(Field field, int opcode)
  {
    reserve(3);
    put1(opcode);
    putIndex2(getConstants().addFieldRef(field));
  }
  



  public final void emitGetStatic(Field field)
  {
    pushType(field.getType());
    emitFieldop(field, 178);
  }
  



  public final void emitGetField(Field field)
  {
    popType();
    pushType(field.getType());
    emitFieldop(field, 180);
  }
  



  public final void emitPutStatic(Field field)
  {
    popType();
    emitFieldop(field, 179);
  }
  



  public final void emitPutField(Field field)
  {
    popType();
    popType();
    emitFieldop(field, 181);
  }
  

  private int words(Type[] types)
  {
    int res = 0;
    int i = types.length; for (;;) { i--; if (i < 0) break;
      if (size > 4) {
        res += 2;
      } else
        res++; }
    return res;
  }
  
  public void emitInvokeMethod(Method method, int opcode)
  {
    if (!reachableHere())
      return;
    reserve(opcode == 185 ? 5 : 3);
    int arg_count = arg_types.length;
    boolean is_invokestatic = opcode == 184;
    boolean is_init = (opcode == 183) && ("<init>".equals(method.getName()));
    
    if (is_invokestatic != ((access_flags & 0x8) != 0)) {
      throw new Error("emitInvokeXxx static flag mis-match method.flags=" + access_flags);
    }
    if ((!is_invokestatic) && (!is_init))
      arg_count++;
    put1(opcode);
    putIndex2(getConstants().addMethodRef(method));
    if (opcode == 185)
    {
      put1(words(arg_types) + 1);
      put1(0);
    }
    for (;;) { arg_count--; if (arg_count < 0)
        break;
      Type t = popType();
      if ((t instanceof UninitializedType))
        throw new Error("passing " + t + " as parameter");
    }
    if (is_init)
    {
      Type t = popType();
      
      if (!(t instanceof UninitializedType))
        throw new Error("calling <init> on already-initialized object");
      ClassType ctype = ctype;
      for (int i = 0; i < SP; i++)
        if (stack_types[i] == t)
          stack_types[i] = ctype;
      Variable[] used = locals.used;
      int i = used == null ? 0 : used.length; for (;;) { i--; if (i < 0)
          break;
        Variable var = used[i];
        if ((var != null) && (var.getType() == t))
          var.setType(ctype);
      }
      int i = local_types == null ? 0 : local_types.length; for (;;) { i--; if (i < 0)
          break;
        if (local_types[i] == t)
          local_types[i] = ctype;
      }
    }
    if (return_type.size != 0)
      pushType(return_type);
  }
  
  public void emitInvoke(Method method) {
    int opcode;
    int opcode;
    if ((access_flags & 0x8) != 0) {
      opcode = 184; } else { int opcode;
      if (classfile.isInterface()) {
        opcode = 185; } else { int opcode;
        if (("<init>".equals(method.getName())) || ((access_flags & 0x2) != 0))
        {
          opcode = 183;
        } else
          opcode = 182; } }
    emitInvokeMethod(method, opcode);
  }
  




  public void emitInvokeVirtual(Method method)
  {
    emitInvokeMethod(method, 182);
  }
  
  public void emitInvokeSpecial(Method method)
  {
    emitInvokeMethod(method, 183);
  }
  




  public void emitInvokeStatic(Method method)
  {
    emitInvokeMethod(method, 184);
  }
  
  public void emitInvokeInterface(Method method)
  {
    emitInvokeMethod(method, 185);
  }
  
  final void emitTransfer(Label label, int opcode)
  {
    label.setTypes(this);
    fixupAdd(6, label);
    put1(opcode);
    PC += 2;
  }
  



  public final void emitGoto(Label label)
  {
    label.setTypes(this);
    fixupAdd(4, label);
    reserve(3);
    put1(167);
    PC += 2;
    setUnreachable();
  }
  
  public final void emitJsr(Label label)
  {
    fixupAdd(5, label);
    reserve(3);
    put1(168);
    PC += 2;
  }
  







  public ExitableBlock startExitableBlock(Type resultType, boolean runFinallyBlocks)
  {
    ExitableBlock bl = new ExitableBlock(resultType, this, runFinallyBlocks);
    outer = currentExitableBlock;
    currentExitableBlock = bl;
    return bl;
  }
  


  public void endExitableBlock()
  {
    ExitableBlock bl = currentExitableBlock;
    bl.finish();
    currentExitableBlock = outer;
  }
  
  public final void emitGotoIfCompare1(Label label, int opcode)
  {
    popType();
    reserve(3);
    emitTransfer(label, opcode);
  }
  

  public final void emitGotoIfIntEqZero(Label label) { emitGotoIfCompare1(label, 153); }
  
  public final void emitGotoIfIntNeZero(Label label) { emitGotoIfCompare1(label, 154); }
  
  public final void emitGotoIfIntLtZero(Label label) { emitGotoIfCompare1(label, 155); }
  
  public final void emitGotoIfIntGeZero(Label label) { emitGotoIfCompare1(label, 156); }
  
  public final void emitGotoIfIntGtZero(Label label) { emitGotoIfCompare1(label, 157); }
  
  public final void emitGotoIfIntLeZero(Label label) { emitGotoIfCompare1(label, 158); }
  
  public final void emitGotoIfNull(Label label) { emitGotoIfCompare1(label, 198); }
  
  public final void emitGotoIfNonNull(Label label) { emitGotoIfCompare1(label, 199); }
  
  public final void emitGotoIfCompare2(Label label, int logop)
  {
    if ((logop < 153) || (logop > 158)) {
      throw new Error("emitGotoIfCompare2: logop must be one of ifeq...ifle");
    }
    Type type2 = popType().promote();
    Type type1 = popType().promote();
    reserve(4);
    char sig1 = type1.getSignature().charAt(0);
    char sig2 = type2.getSignature().charAt(0);
    
    boolean cmpg = (logop == 155) || (logop == 158);
    
    if ((sig1 == 'I') && (sig2 == 'I')) {
      logop += 6;
    } else if ((sig1 == 'J') && (sig2 == 'J')) {
      put1(148);
    } else if ((sig1 == 'F') && (sig2 == 'F')) {
      put1(cmpg ? 149 : 150);
    } else if ((sig1 == 'D') && (sig2 == 'D')) {
      put1(cmpg ? 151 : 152);
    } else if (((sig1 == 'L') || (sig1 == '[')) && ((sig2 == 'L') || (sig2 == '[')) && (logop <= 154))
    {

      logop += 12;
    } else {
      throw new Error("invalid types to emitGotoIfCompare2");
    }
    emitTransfer(label, logop);
  }
  

  @Deprecated
  public final void emitGotoIfEq(Label label, boolean invert)
  {
    emitGotoIfCompare2(label, invert ? 154 : 153);
  }
  

  public final void emitGotoIfEq(Label label)
  {
    emitGotoIfCompare2(label, 153);
  }
  

  public final void emitGotoIfNE(Label label)
  {
    emitGotoIfCompare2(label, 154);
  }
  

  public final void emitGotoIfLt(Label label) { emitGotoIfCompare2(label, 155); }
  
  public final void emitGotoIfGe(Label label) { emitGotoIfCompare2(label, 156); }
  
  public final void emitGotoIfGt(Label label) { emitGotoIfCompare2(label, 157); }
  
  public final void emitGotoIfLe(Label label) { emitGotoIfCompare2(label, 158); }
  




  public final void emitIfCompare1(int opcode)
  {
    IfState new_if = pushIfState();
    if (popType().promote() != Type.intType)
      throw new Error("non-int type to emitIfCompare1");
    reserve(3);
    emitTransfer(end_label, opcode);
  }
  


  public final void emitIfIntNotZero()
  {
    emitIfCompare1(153);
  }
  


  public final void emitIfIntEqZero()
  {
    emitIfCompare1(154);
  }
  

  public final void emitIfIntLEqZero()
  {
    emitIfCompare1(157);
  }
  

  public final void emitIfIntGEqZero()
  {
    emitIfCompare1(155);
  }
  



  public final void emitIfRefCompare1(int opcode)
  {
    IfState new_if = pushIfState();
    if (!(popType() instanceof ObjectType))
      throw new Error("non-ref type to emitIfRefCompare1");
    reserve(3);
    emitTransfer(end_label, opcode);
  }
  

  public final void emitIfNotNull()
  {
    emitIfRefCompare1(198);
  }
  

  public final void emitIfNull()
  {
    emitIfRefCompare1(199);
  }
  


  public final void emitIfIntCompare(int opcode)
  {
    IfState new_if = pushIfState();
    popType();
    popType();
    reserve(3);
    emitTransfer(end_label, opcode);
  }
  

  public final void emitIfIntLt()
  {
    emitIfIntCompare(162);
  }
  

  public final void emitIfIntGEq()
  {
    emitIfIntCompare(161);
  }
  


  public final void emitIfNEq()
  {
    IfState new_if = pushIfState();
    emitGotoIfEq(end_label);
  }
  


  public final void emitIfEq()
  {
    IfState new_if = pushIfState();
    emitGotoIfNE(end_label);
  }
  


  public final void emitIfLt()
  {
    IfState new_if = pushIfState();
    emitGotoIfGe(end_label);
  }
  


  public final void emitIfGe()
  {
    IfState new_if = pushIfState();
    emitGotoIfLt(end_label);
  }
  


  public final void emitIfGt()
  {
    IfState new_if = pushIfState();
    emitGotoIfLe(end_label);
  }
  


  public final void emitIfLe()
  {
    IfState new_if = pushIfState();
    emitGotoIfGt(end_label);
  }
  


  public void emitRet(Variable var)
  {
    int offset = offset;
    if (offset < 256)
    {
      reserve(2);
      put1(169);
      put1(offset);
    }
    else
    {
      reserve(4);
      put1(196);
      put1(169);
      put2(offset);
    }
  }
  

  public final void emitThen() {}
  

  public final void emitIfThen()
  {
    new IfState(this, null);
  }
  

  public final void emitElse()
  {
    Label else_label = if_stack.end_label;
    if (reachableHere())
    {
      Label end_label = new Label(this);
      if_stack.end_label = end_label;
      emitGoto(end_label);
    }
    else {
      if_stack.end_label = null; }
    if (else_label != null)
      else_label.define(this);
    if_stack.doing_else = true;
  }
  

  public final void emitFi()
  {
    if (if_stack.end_label != null) {
      if_stack.end_label.define(this);
    }
    if_stack = if_stack.previous;
  }
  











  public void emitAndThen()
  {
    if ((if_stack == null) || (if_stack.andThenSet)) throw new InternalError();
    if_stack.andThenSet = true;
  }
  
  private IfState pushIfState() {
    if ((if_stack != null) && (if_stack.andThenSet)) {
      if_stack.andThenSet = false;
      return if_stack;
    }
    return new IfState(this);
  }
  
  public final void fixUnsigned(Type stackType) {
    if (((stackType instanceof PrimType)) && (((PrimType)stackType).isUnsigned()))
    {
      char sig1 = stackType.getSignature().charAt(0);
      if (sig1 == 'S') {
        reserve(1);
        put1(146);
      } else if (sig1 == 'B') {
        emitPushInt(255);
        emitAnd();
      }
    }
  }
  
  public final void emitConvert(PrimType from, PrimType to) {
    String to_sig = to.getSignature();
    String from_sig = from.getSignature();
    int op = -1;
    char to_sig0 = to_sig.charAt(0);
    char from_sig0 = from_sig.charAt(0);
    if (from_sig0 == to_sig0)
      return;
    if (size < 4)
      from_sig0 = 'I';
    if (size < 4) {
      emitConvert(from, Type.intType);
      from_sig0 = 'I';
      if (to.isUnsigned()) {
        if (to_sig0 == 'S') {
          to_sig0 = 'C';
        } else if (to_sig0 == 'B') {
          emitPushInt(255);
          emitAnd();
          return;
        }
      }
    }
    if ((from_sig0 == 'J') && (from.isUnsigned()) && ((to_sig0 == 'F') || (to_sig0 == 'D')))
    {
      emitPushInt(1);
      emitUshr();
      emitConvert(Type.longType, to);
      emitPushConstant(2, to);
      emitMul();
      return;
    }
    if ((from_sig0 == 'I') && (from.isUnsigned()) && ((to_sig0 == 'J') || (to_sig0 == 'F') || (to_sig0 == 'D')))
    {
      emitConvert(Type.intType, Type.longType);
      reserve(4);
      emitPushLong(4294967295L);
      emitAnd();
      from_sig0 = 'J';
    }
    if (from_sig0 == to_sig0)
      return;
    switch (from_sig0)
    {
    case 'I': 
      switch (to_sig0) {
      case 'B': 
        op = 145; break;
      case 'C':  op = 146; break;
      case 'S':  op = 147; break;
      case 'J':  op = 133; break;
      case 'F':  op = 134; break;
      case 'D':  op = 135;
      }
      break;
    case 'J': 
      switch (to_sig0) {
      case 'I': 
        op = 136; break;
      case 'F':  op = 137; break;
      case 'D':  op = 138;
      }
      break;
    case 'F': 
      switch (to_sig0) {
      case 'I': 
        op = 139; break;
      case 'J':  op = 140; break;
      case 'D':  op = 141;
      }
      break;
    case 'D': 
      switch (to_sig0) {
      case 'I': 
        op = 142; break;
      case 'J':  op = 143; break;
      case 'F':  op = 144;
      }
      break;
    }
    if (op < 0)
      throw new Error("unsupported CodeAttr.emitConvert");
    reserve(1);
    popType();
    put1(op);
    pushType(to);
  }
  
  private void emitCheckcast(Type type, int opcode)
  {
    reserve(3);
    popType();
    put1(opcode);
    if ((type instanceof ObjectType))
    {
      putIndex2(getConstants().addClass((ObjectType)type));
    }
    else {
      throw new Error("unimplemented type " + type + " in emitCheckcast/emitInstanceof");
    }
  }
  
  public static boolean castNeeded(Type top, Type required)
  {
    top = top.getRawType();
    for (;;)
    {
      if (top == required)
        return false;
      if (((required instanceof ClassType)) && ((top instanceof ClassType)) && (((ClassType)top).isSubclass((ClassType)required)))
      {

        return false; }
      if ((!(required instanceof ArrayType)) || (!(top instanceof ArrayType))) {
        break;
      }
      required = ((ArrayType)required).getComponentType();
      top = ((ArrayType)top).getComponentType();
    }
    
    return true;
  }
  

  public void emitCheckcast(Type type)
  {
    if (castNeeded(topType(), type))
    {
      emitCheckcast(type, 192);
      pushType(type);
    }
  }
  
  public void emitInstanceof(Type type)
  {
    emitCheckcast(type, 193);
    pushType(Type.booleanType);
  }
  
  public final void emitThrow()
  {
    popType();
    reserve(1);
    put1(191);
    setUnreachable();
  }
  
  public final void emitMonitorEnter()
  {
    popType();
    reserve(1);
    put1(194);
  }
  
  public final void emitMonitorExit()
  {
    popType();
    reserve(1);
    put1(195);
  }
  






  public final void emitReturn()
  {
    if (try_stack != null)
      new Error();
    emitRawReturn();
  }
  
  final void emitRawReturn()
  {
    if (!reachableHere())
      return;
    if (getMethodgetReturnTypesize == 0)
    {
      reserve(1);
      put1(177);
    }
    else {
      emitTypedOp(172, popType().promote()); }
    setUnreachable();
  }
  




  public void addHandler(int start_pc, int end_pc, int handler_pc, int catch_type)
  {
    int index = 4 * exception_table_length;
    if (exception_table == null)
    {
      exception_table = new short[20];
    }
    else if (exception_table.length <= index)
    {
      short[] new_table = new short[2 * exception_table.length];
      System.arraycopy(exception_table, 0, new_table, 0, index);
      exception_table = new_table;
    }
    exception_table[(index++)] = ((short)start_pc);
    exception_table[(index++)] = ((short)end_pc);
    exception_table[(index++)] = ((short)handler_pc);
    exception_table[(index++)] = ((short)catch_type);
    exception_table_length += 1;
  }
  



  public void addHandler(Label start_try, Label end_try, ClassType catch_type)
  {
    ConstantPool constants = getConstants();
    int catch_type_index;
    int catch_type_index; if (catch_type == null) {
      catch_type_index = 0;
    } else
      catch_type_index = addClassindex;
    fixupAdd(11, start_try);
    fixupAdd(12, catch_type_index, end_try);
    Label handler = new Label();
    localTypes = localTypes;
    stackTypes = new Type[1];
    Type handler_class = catch_type == null ? Type.javalangThrowableType : catch_type;
    stackTypes[0] = handler_class;
    setTypes(handler);
    fixupAdd(13, 0, handler);
    setReachable(true);
  }
  







  public void emitWithCleanupStart()
  {
    int savedSP = SP;
    SP = 0;
    emitTryStart(false, null);
    SP = savedSP;
  }
  



  public void emitWithCleanupCatch(Variable catchVar)
  {
    emitTryEnd(false);
    try_stack.saved_result = catchVar;
    emitCatchStart(catchVar);
  }
  


  public void emitWithCleanupDone()
  {
    Variable catchVar = try_stack.saved_result;
    try_stack.saved_result = null;
    if (catchVar != null)
      emitLoad(catchVar);
    emitThrow();
    emitCatchEnd();
    emitTryCatchEnd();
  }
  

  public void emitTryStart(boolean has_finally, Type result_type)
  {
    if ((result_type != null) && (result_type.isVoid()))
      result_type = null;
    Variable[] savedStack = null;
    if ((result_type != null) || (SP > 0))
      pushScope();
    if (SP > 0)
    {
      savedStack = new Variable[SP];
      int i = 0;
      while (SP > 0)
      {
        Variable var = addLocal(topType());
        emitStore(var);
        savedStack[(i++)] = var;
      }
    }
    TryState try_state = new TryState(this);
    savedStack = savedStack;
    
    for (int usedLocals = local_types == null ? 0 : local_types.length; 
        usedLocals > 0; usedLocals--)
    {
      Type last = local_types[(usedLocals - 1)];
      if (last != null)
        break;
    }
    Type[] startLocals;
    Type[] startLocals;
    if (usedLocals == 0) {
      startLocals = Type.typeArray0;
    }
    else {
      startLocals = new Type[usedLocals];
      System.arraycopy(local_types, 0, startLocals, 0, usedLocals);
    }
    start_try.localTypes = startLocals;
    
    if (result_type != null)
      saved_result = addLocal(result_type);
    if (has_finally) {
      finally_subr = new Label();
    }
  }
  
  @Deprecated
  public void emitTryEnd() {}
  
  private void emitTryEnd(boolean fromFinally)
  {
    if (try_stack.tryClauseDone)
      return;
    try_stack.tryClauseDone = true;
    if (try_stack.finally_subr != null)
      try_stack.exception = addLocal(Type.javalangThrowableType);
    gotoFinallyOrEnd(fromFinally);
    try_stack.end_try = getLabel();
  }
  
  public void emitCatchStart(Variable var) {
    if (var == null) {
      emitCatchStart((ClassType)null);
    } else {
      emitCatchStart((ClassType)var.getType());
      emitStore(var);
    }
  }
  
  public void emitCatchStart(ClassType type)
  {
    emitTryEnd(false);
    setTypes(try_stack.start_try.localTypes, Type.typeArray0);
    if (try_stack.try_type != null)
      emitCatchEnd();
    try_stack.try_type = type;
    addHandler(try_stack.start_try, try_stack.end_try, type);
    setReachable(true);
  }
  
  public void emitCatchEnd()
  {
    gotoFinallyOrEnd(false);
    try_stack.try_type = null;
  }
  
  private void gotoFinallyOrEnd(boolean fromFinally)
  {
    if (reachableHere())
    {
      if (try_stack.saved_result != null)
        emitStore(try_stack.saved_result);
      if (try_stack.end_label == null)
        try_stack.end_label = new Label();
      if ((try_stack.finally_subr == null) || (useJsr()))
      {
        if (try_stack.finally_subr != null)
          emitJsr(try_stack.finally_subr);
        emitGoto(try_stack.end_label);
      }
      else
      {
        if (try_stack.exitCases != null)
          emitPushInt(0);
        emitPushNull();
        if (!fromFinally) {
          emitGoto(try_stack.finally_subr);
        }
      }
    }
  }
  
  public void emitFinallyStart() {
    emitTryEnd(true);
    if (try_stack.try_type != null)
      emitCatchEnd();
    try_stack.end_try = getLabel();
    
    pushScope();
    if (useJsr())
    {
      SP = 0;
      emitCatchStart((ClassType)null);
      emitStore(try_stack.exception);
      emitJsr(try_stack.finally_subr);
      emitLoad(try_stack.exception);
      emitThrow();
    }
    else
    {
      if (reachableHere())
        emitGoto(try_stack.finally_subr);
      addHandler(try_stack.start_try, try_stack.end_try, Type.javalangThrowableType);
      if (try_stack.saved_result != null)
        emitStoreDefaultValue(try_stack.saved_result);
      if (try_stack.exitCases != null)
      {
        emitPushInt(-1);
        emitSwap();
      }
    }
    try_stack.finally_subr.define(this);
    
    if (useJsr())
    {
      Type ret_addr_type = Type.objectType;
      try_stack.finally_ret_addr = addLocal(ret_addr_type);
      pushType(ret_addr_type);
      emitStore(try_stack.finally_ret_addr);
    }
  }
  






  public void emitFinallyEnd()
  {
    if (!reachableHere()) {
      try_stack.end_label = null;
    } else if (useJsr()) {
      emitRet(try_stack.finally_ret_addr);
    } else if ((try_stack.end_label == null) && (try_stack.exitCases == null))
    {
      emitThrow();
    }
    else
    {
      emitStore(try_stack.exception);
      emitLoad(try_stack.exception);
      emitIfNotNull();
      emitLoad(try_stack.exception);
      emitThrow();
      emitElse();
      
      ExitableBlock exit = try_stack.exitCases;
      
      if (exit != null)
      {
        SwitchState sw = startSwitch();
        
        while (exit != null)
        {
          ExitableBlock next = nextCase;
          nextCase = null;
          currentTryState = null;
          TryState nextTry = TryState.outerHandler(try_stack.previous, initialTryState);
          
          if (nextTry == initialTryState)
          {
            sw.addCaseGoto(switchCase, this, endLabel);
          }
          else
          {
            sw.addCase(switchCase, this);
            exit.exit(nextTry);
          }
          exit = next;
        }
        try_stack.exitCases = null;
        
        sw.addDefault(this);
        sw.finish(this);
      }
      emitFi();
      
      setUnreachable();
    }
    popScope();
    try_stack.finally_subr = null;
  }
  
  public void emitTryCatchEnd()
  {
    if (try_stack.finally_subr != null)
      emitFinallyEnd();
    Variable[] vars = try_stack.savedStack;
    if (try_stack.end_label == null) {
      setUnreachable();
    }
    else {
      setTypes(try_stack.start_try.localTypes, Type.typeArray0);
      try_stack.end_label.define(this);
      if (vars != null)
      {
        int i = vars.length; for (;;) { i--; if (i < 0)
            break;
          Variable v = vars[i];
          if (v != null) {
            emitLoad(v);
          }
        }
      }
      if (try_stack.saved_result != null)
        emitLoad(try_stack.saved_result);
    }
    if ((try_stack.saved_result != null) || (vars != null))
      popScope();
    try_stack = try_stack.previous;
  }
  
  public final TryState getCurrentTry()
  {
    return try_stack;
  }
  


  public final boolean isInTry()
  {
    return try_stack != null;
  }
  



  public SwitchState startSwitch()
  {
    SwitchState sw = new SwitchState(this);
    sw.switchValuePushed(this);
    return sw;
  }
  



  public void emitTailCall(boolean pop_args, Label start)
  {
    if (pop_args)
    {
      Method meth = getMethod();
      int arg_slots = (access_flags & 0x8) != 0 ? 0 : 1;
      int i = arg_types.length; for (;;) { i--; if (i < 0) break;
        arg_slots += (arg_types[i].size > 4 ? 2 : 1); }
      int i = arg_types.length; for (;;) { i--; if (i < 0)
          break;
        arg_slots -= (arg_types[i].size > 4 ? 2 : 1);
        emitStore(locals.used[arg_slots]);
      }
    }
    emitGoto(start);
  }
  



  public void emitTailCall(boolean pop_args, Scope scope)
  {
    emitTailCall(pop_args, start);
  }
  
  public void processFixups() {
    if (fixup_count <= 0) {
      return;
    }
    




    int delta = 0;
    int instruction_tail = fixup_count;
    fixupAdd(9, -1, null);
    












    int i = 0;
    for (;;) {
      int offset = fixup_offsets[i];
      int kind = offset & 0xF;
      offset >>= 4;
      Label label = fixup_labels[i];
      



      if ((kind >= 3) && (kind <= 7)) {
        int max = fixup_count;
        
        while (label != null) { max--; if (max < 0) break;
          int labpc = fixupOffset(first_fixup);
          for (int def = first_fixup + 1;; def++) {
            if ((def >= fixup_count) || (labpc != fixupOffset(def)))
              break label179;
            if ((fixupKind(def) == 4) || (fixupKind(def) == 8))
            {
              label = fixup_labels[def];
              fixup_labels[i] = label;
              break;
            }
          }
        }
      }
      switch (kind)
      {
      case 11: 
        i += 2;
        break;
      case 14: 
        i++;
      

      case 3: 
      case 8: 
        break;
      


      case 1: 
        while ((i + 1 < fixup_count) && (fixupKind(i + 1) == 0) && (fixupOffset(i + 1) == offset)) {
          i++;
          position += delta;
          label = fixup_labels[i];
        }
        if ((i + 1 < fixup_count) && (fixupKind(i + 1) == 4) && (fixupOffset(i + 1) == offset))
        {
          for (int j = i;; j--) {
            fixup_labels[j].needsStackMapEntry = false;
            if (fixupKind(j) == 1)
              break;
          }
          i++;
          fixupSet(i, 8, offset);
          delta -= 3; }
        break;
      

      case 0: 
        position += delta;
        break;
      case 2: 
        delta += 3;
        break;
      case 4: 
        if (fixupOffset(first_fixup) == offset + 3)
        {

          fixupSet(i, 8, offset);
          delta -= 3; }
        break;
      

      case 5: 
        if (PC >= 32768)
          delta += 2;
        break;
      case 6: 
        if (PC >= 32768)
          delta += 5;
        break;
      case 10: 
        fixup_labels[instruction_tail] = fixup_labels[(i + 1)];
        instruction_tail = offset;
      
      case 9: 
        int cur_pc = i + 1 >= fixup_count ? PC : fixupOffset(fixup_labels[(i + 1)].first_fixup);
        
        fixupSet(i, 9, cur_pc);
        if (label == null) {
          break label599;
        }
        
        i = first_fixup;
        int next_pc = fixupOffset(i);
        delta = cur_pc + delta - next_pc;
        break;
      case 7: case 12: case 13: default: 
        label179:
        throw new Error("unexpected fixup");
        
        i++;
      }
      
    }
    
    label599:
    int new_size = PC;
    
    delta = 0;
    
    for (int i = 0; i < fixup_count;)
    {
      int offset = fixup_offsets[i];
      int kind = offset & 0xF;
      Label label = fixup_labels[i];
      if ((label != null) && (position < 0))
        throw new Error("undefined label " + label);
      offset >>= 4;
      switch (kind)
      {
      case 11: 
        i += 2;
        fixup_labels[i].position = (offset + delta);
        break;
      case 14: 
        i++;
      case 3: 
        break;
      case 8: 
        delta -= 3;
        new_size -= 3;
        break;
      case 0: 
      case 1: 
        position = (offset + delta);
        break;
      case 2: 
        int padding = 3 - (offset + delta) & 0x3;
        delta += padding;
        new_size += padding;
        break;
      case 4: 
      case 5: 
      case 6: 
        int rel = position - (offset + delta);
        if ((short)rel == rel)
        {
          fixupSet(i, 7, offset);
        }
        else
        {
          delta += (kind == 6 ? 5 : 2);
          new_size += (kind == 6 ? 5 : 2);
        }
        break;
      case 9: 
        if (label == null) {
          break label955;
        }
        
        i = first_fixup;
        int next_pc = fixupOffset(i);
        delta = offset + delta - next_pc;
        break;
      case 7: case 10: case 12: 
      case 13: default: 
        throw new Error("unexpected fixup");
        
        i++;
      }
      
    }
    



    label955:
    



    byte[] new_code = new byte[new_size];
    int prev_linenumber = -1;
    int new_pc = 0;
    int next_fixup_index = 0;
    int next_fixup_offset = fixupOffset(0);
    int oldPC = -1;
    Label pendingStackMapLabel = null;
    
    int old_pc = 0;
    for (;;) {
      if (old_pc < next_fixup_offset) {
        new_code[(new_pc++)] = code[(old_pc++)];
      }
      else {
        int kind = fixup_offsets[next_fixup_index] & 0xF;
        Label label = fixup_labels[next_fixup_index];
        if ((pendingStackMapLabel != null) && (position < new_pc))
        {

          stackMap.emitStackMapEntry(pendingStackMapLabel, this);
          pendingStackMapLabel = null;
        }
        if ((pendingStackMapLabel != null) && (position > new_pc))
        {
          throw new Error("labels out of order"); }
        int switch_start; switch (kind)
        {
        case 0: 
        case 1: 
          if ((stackMap != null) && (label != null) && (label.isUsed()) && (needsStackMapEntry))
          {
            pendingStackMapLabel = mergeLabels(pendingStackMapLabel, label);
          }
          
          break;
        case 8: 
          old_pc += 3;
          break;
        case 7: 
          delta = position - new_pc;
          new_code[(new_pc++)] = code[old_pc];
          new_code[(new_pc++)] = ((byte)(delta >> 8));
          new_code[(new_pc++)] = ((byte)(delta & 0xFF));
          old_pc += 3;
          break;
        case 4: 
        case 5: 
        case 6: 
          delta = position - new_pc;
          byte opcode = code[old_pc];
          if (kind == 6)
          {

            opcode = invert_opcode(opcode);
            new_code[(new_pc++)] = opcode;
            new_code[(new_pc++)] = 0;
            new_code[(new_pc++)] = 8;
            opcode = -56;

          }
          else
          {
            opcode = (byte)(opcode + 33);
          }
          new_code[(new_pc++)] = opcode;
          new_code[(new_pc++)] = ((byte)(delta >> 24));
          new_code[(new_pc++)] = ((byte)(delta >> 16));
          new_code[(new_pc++)] = ((byte)(delta >> 8));
          new_code[(new_pc++)] = ((byte)(delta & 0xFF));
          old_pc += 3;
          break;
        case 2: 
          int padding = 3 - new_pc & 0x3;
          switch_start = new_pc;
          new_code[(new_pc++)] = code[(old_pc++)];
          for (;;) { padding--; if (padding < 0) break;
            new_code[(new_pc++)] = 0;
          }  case 11: case 14: case 9: case 3: case 10: case 12: case 13: default:  for (;;) {
            if ((next_fixup_index < fixup_count) && (fixupKind(next_fixup_index + 1) == 3))
            {
              next_fixup_index++;
              int offset = fixupOffset(next_fixup_index);
              while (old_pc < offset)
                new_code[(new_pc++)] = code[(old_pc++)];
              delta = fixup_labels[next_fixup_index].position - switch_start;
              
              new_code[(new_pc++)] = ((byte)(delta >> 24));
              new_code[(new_pc++)] = ((byte)(delta >> 16));
              new_code[(new_pc++)] = ((byte)(delta >> 8));
              new_code[(new_pc++)] = ((byte)(delta & 0xFF));
              old_pc += 4;
              continue;
              

              label = fixup_labels[(next_fixup_index + 2)];
              int handler_type_index = fixupOffset(next_fixup_index + 1);
              if (stackMap != null) {
                pendingStackMapLabel = mergeLabels(pendingStackMapLabel, label);
              }
              addHandler(fixup_labels[next_fixup_index].position, fixup_labels[(next_fixup_index + 1)].position, new_pc, handler_type_index);
              


              next_fixup_index += 2;
              
              break label1785;
              if (lines == null)
                lines = new LineNumbersAttr(this);
              next_fixup_index++;
              int linenumber = fixupOffset(next_fixup_index);
              if (linenumber != prev_linenumber)
                lines.put(linenumber, new_pc);
              prev_linenumber = linenumber;
              
              break label1785;
              if (label == null) {
                break label1799;
              }
              
              next_fixup_index = first_fixup;
              old_pc = fixupOffset(next_fixup_index);
              next_fixup_offset = old_pc;
              if (position == new_pc) break;
              throw new Error("bad pc");
              


              throw new Error("unexpected fixup"); } } }
        label1785:
        next_fixup_index++;
        next_fixup_offset = fixupOffset(next_fixup_index);
      } }
    label1799:
    if (new_size != new_pc)
      throw new Error("PC confusion new_pc:" + new_pc + " new_size:" + new_size);
    PC = new_size;
    code = new_code;
    fixup_count = 0;
    fixup_labels = null;
    fixup_offsets = null;
  }
  
  private Label mergeLabels(Label oldLabel, Label newLabel)
  {
    if (oldLabel != null)
      newLabel.setTypes(oldLabel);
    return newLabel;
  }
  
  public void assignConstants(ClassType cl)
  {
    if ((locals != null) && (locals.container == null) && (!locals.isEmpty()))
      locals.addToFrontOf(this);
    processFixups();
    if ((stackMap != null) && (stackMap.numEntries > 0))
      stackMap.addToFrontOf(this);
    if (instructionLineMode)
    {


      if (lines == null)
        lines = new LineNumbersAttr(this);
      lines.linenumber_count = 0;
      int codeLen = getCodeLength();
      for (int i = 0; i < codeLen; i++)
        lines.put(i, i);
    }
    super.assignConstants(cl);
    Attribute.assignConstants(this, cl);
  }
  
  public final int getLength()
  {
    return 12 + getCodeLength() + 8 * exception_table_length + Attribute.getLengthAll(this);
  }
  
  public void write(DataOutputStream dstr)
    throws IOException
  {
    dstr.writeShort(max_stack);
    dstr.writeShort(max_locals);
    dstr.writeInt(PC);
    dstr.write(code, 0, PC);
    
    dstr.writeShort(exception_table_length);
    int count = exception_table_length;
    for (int i = 0;; i += 4) { count--; if (count < 0)
        break;
      dstr.writeShort(exception_table[i]);
      dstr.writeShort(exception_table[(i + 1)]);
      dstr.writeShort(exception_table[(i + 2)]);
      dstr.writeShort(exception_table[(i + 3)]);
    }
    
    Attribute.writeAll(this, dstr);
  }
  
  public void print(ClassTypeWriter dst)
  {
    dst.print("Attribute \"");
    dst.print(getName());
    dst.print("\", length:");
    dst.print(getLength());
    dst.print(", max_stack:");
    dst.print(max_stack);
    dst.print(", max_locals:");
    dst.print(max_locals);
    dst.print(", code_length:");
    int length = getCodeLength();
    dst.println(length);
    disAssemble(dst, 0, length);
    if (exception_table_length > 0)
    {
      dst.print("Exceptions (count: ");
      dst.print(exception_table_length);
      dst.println("):");
      int count = exception_table_length;
      for (int i = 0;; i += 4) { count--; if (count < 0)
          break;
        dst.print("  start: ");
        dst.print(exception_table[i] & 0xFFFF);
        dst.print(", end: ");
        dst.print(exception_table[(i + 1)] & 0xFFFF);
        dst.print(", handler: ");
        dst.print(exception_table[(i + 2)] & 0xFFFF);
        dst.print(", type: ");
        int catch_type_index = exception_table[(i + 3)] & 0xFFFF;
        if (catch_type_index == 0) {
          dst.print("0 /* finally */");
        }
        else {
          dst.printOptionalIndex(catch_type_index);
          dst.printConstantTersely(catch_type_index, 7);
        }
        dst.println();
      }
    }
    dst.printAttributes(this);
  }
  























































































  public void disAssemble(ClassTypeWriter dst, int start, int limit)
  {
    boolean wide = false;
    for (int i = start; i < limit;)
    {
      int oldpc = i++;
      int op = code[oldpc] & 0xFF;
      String str = Integer.toString(oldpc);
      int printConstant = 0;
      int j = str.length();
      for (;;) { j++; if (j > 3) break; dst.print(' '); }
      dst.print(str);
      dst.print(": ");
      
      if (op < 120)
      {
        if (op < 87)
        {
          if (op < 3) { print("nop;aconst_null;iconst_m1;", op, dst);
          } else if (op < 9) { dst.print("iconst_");dst.print(op - 3);
          } else if (op < 16)
          {
            char typ;
            if (op < 11) { char typ = 'l';op -= 9;
            } else if (op < 14) { char typ = 'f';op -= 11;
            } else { typ = 'd';op -= 14; }
            dst.print(typ);dst.print("const_");dst.print(op);
          }
          else if (op < 21)
          {
            if (op < 18)
            {
              print("bipush ;sipush ;", op - 16, dst);
              int constant;
              int constant; if (op == 16) { constant = code[(i++)];
              } else { constant = (short)readUnsignedShort(i);i += 2; }
              dst.print(constant);
            }
            else
            {
              printConstant = op == 18 ? 1 : 2;
              print("ldc;ldc_w;ldc2_w;", op - 18, dst);
            }
          }
          else {
            String load_or_store;
            String load_or_store;
            if (op < 54) { load_or_store = "load";
            } else { load_or_store = "store";op -= 33; }
            int index;
            if (op < 26) { int index = -1;op -= 21;
            } else if (op < 46) { op -= 26;int index = op % 4;op >>= 2;
            } else { index = -2;op -= 46; }
            dst.print("ilfdabcs".charAt(op));
            if (index == -2) dst.write(97);
            dst.print(load_or_store);
            if (index >= 0) { dst.write(95);dst.print(index);
            } else if (index == -1)
            {
              if (wide) { index = readUnsignedShort(i);i += 2;
              } else { index = code[i] & 0xFF;i++; }
              wide = false;
              dst.print(' ');
              dst.print(index);
            }
            
          }
          
        }
        else if (op < 96) {
          print("pop;pop2;dup;dup_x1;dup_x2;dup2;dup2_x1;dup2_x2;swap;", op - 87, dst);
        }
        else
        {
          dst.print("ilfda".charAt((op - 96) % 4));
          print("add;sub;mul;div;rem;neg;", op - 96 >> 2, dst);

        }
        

      }
      else if (op < 170)
      {
        if (op < 132)
        {
          dst.print((op & 0x1) == 0 ? 'i' : 'l');
          print("shl;shr;ushr;and;or;xor;", op - 120 >> 1, dst);
        }
        else if (op == 132)
        {


          dst.print("iinc");
          int constant; int var_index; int constant; if (!wide)
          {
            int var_index = 0xFF & code[(i++)];
            constant = code[(i++)];
          }
          else
          {
            var_index = readUnsignedShort(i);
            i += 2;
            constant = (short)readUnsignedShort(i);
            i += 2;
            wide = false;
          }
          dst.print(' ');dst.print(var_index);
          dst.print(' ');dst.print(constant);
        }
        else if (op < 148)
        {
          dst.print("ilfdi".charAt((op - 133) / 3));
          dst.print('2');
          dst.print("lfdifdildilfbcs".charAt(op - 133));
        }
        else if (op < 153) {
          print("lcmp;fcmpl;fcmpg;dcmpl;dcmpg;", op - 148, dst);
        } else if (op < 169)
        {
          if (op < 159)
          {
            dst.print("if");
            print("eq;ne;lt;ge;gt;le;", op - 153, dst);
          }
          else if (op < 167)
          {
            if (op < 165) { dst.print("if_icmp");
            } else { dst.print("if_acmp");op -= 6; }
            print("eq;ne;lt;ge;gt;le;", op - 159, dst);
          }
          else {
            print("goto;jsr;", op - 167, dst); }
          int delta = (short)readUnsignedShort(i);
          i += 2;
          dst.print(' ');dst.print(oldpc + delta);

        }
        else
        {
          dst.print("ret ");
          int index; if (wide) { int index = readUnsignedShort(i);i += 2;
          } else { index = code[i] & 0xFF;i++; }
          wide = false;
          dst.print(index);
        }
        

      }
      else if (op < 172)
      {
        if (fixup_count <= 0)
          i = i + 3 & 0xFFFFFFFC;
        int code_offset = readInt(i);i += 4;
        if (op == 170)
        {
          dst.print("tableswitch");
          int low = readInt(i);i += 4;
          int high = readInt(i);i += 4;
          dst.print(" low: ");dst.print(low);
          dst.print(" high: ");dst.print(high);
          dst.print(" default: ");dst.print(oldpc + code_offset);
          for (; low <= high; low++)
          {
            code_offset = readInt(i);i += 4;
            dst.println();
            dst.print("  ");dst.print(low);
            dst.print(": ");dst.print(oldpc + code_offset);
          }
        }
        else
        {
          dst.print("lookupswitch");
          int npairs = readInt(i);i += 4;
          dst.print(" npairs: ");dst.print(npairs);
          dst.print(" default: ");dst.print(oldpc + code_offset);
          for (;;) { npairs--; if (npairs < 0)
              break;
            int match = readInt(i);i += 4;
            code_offset = readInt(i);i += 4;
            dst.println();
            dst.print("  ");dst.print(match);
            dst.print(": ");dst.print(oldpc + code_offset);
          }
        }
      }
      else if (op < 178)
      {
        if (op < 177) dst.print("ilfda".charAt(op - 172));
        dst.print("return");
      }
      else if (op < 182)
      {
        print("getstatic;putstatic;getfield;putfield;", op - 178, dst);
        printConstant = 2;
      }
      else if (op < 185)
      {
        dst.print("invoke");
        print("virtual;special;static;", op - 182, dst);
        printConstant = 2;
      }
      else if (op == 185)
      {
        dst.print("invokeinterface (");
        int index = readUnsignedShort(i);
        i += 2;
        int args = 0xFF & code[i];
        i += 2;
        dst.print(args + " args)");
        dst.printConstantOperand(index);
      }
      else if (op == 186)
      {
        dst.print("invokedynamic");
        int index = readUnsignedShort(i);
        i += 4;
        dst.printConstantOperand(index);
      }
      else if (op < 196)
      {
        print("186;new;newarray;anewarray;arraylength;athrow;checkcast;instanceof;monitorenter;monitorexit;", op - 186, dst);
        if ((op == 187) || (op == 189) || (op == 192) || (op == 193)) {
          printConstant = 2;
        } else if (op == 188)
        {
          int type = code[(i++)];
          dst.print(' ');
          if ((type >= 4) && (type <= 11)) {
            print("boolean;char;float;double;byte;short;int;long;", type - 4, dst);
          }
          else {
            dst.print(type);
          }
        }
      }
      else if (op == 196)
      {
        dst.print("wide");
        wide = true;
      }
      else if (op == 197)
      {
        dst.print("multianewarray");
        int index = readUnsignedShort(i);
        i += 2;
        dst.printConstantOperand(index);
        int dims = 0xFF & code[(i++)];
        dst.print(' ');
        dst.print(dims);
      }
      else if (op < 200)
      {
        print("ifnull;ifnonnull;", op - 198, dst);
        int delta = (short)readUnsignedShort(i);
        i += 2;
        dst.print(' ');dst.print(oldpc + delta);
      }
      else if (op < 202)
      {
        print("goto_w;jsr_w;", op - 200, dst);
        int delta = readInt(i);
        i += 4;
        dst.print(' ');dst.print(oldpc + delta);
      }
      else {
        dst.print(op);
      }
      
      if (printConstant > 0) {
        int index;
        int index;
        if (printConstant == 1) { index = 0xFF & code[(i++)];
        } else { index = readUnsignedShort(i);i += 2; }
        dst.printConstantOperand(index);
      }
      dst.println();
    }
  }
  
  private int readUnsignedShort(int offset)
  {
    return (0xFF & code[offset]) << 8 | 0xFF & code[(offset + 1)];
  }
  
  private int readInt(int offset)
  {
    return readUnsignedShort(offset) << 16 | readUnsignedShort(offset + 2);
  }
  














  private void print(String str, int i, PrintWriter dst)
  {
    int last = 0;
    int pos = -1;
    for (; i >= 0; i--)
    {
      pos++;last = pos;
      pos = str.indexOf(';', last);
    }
    dst.write(str, last, pos - last);
  }
  
  public int beginFragment(Label after)
  {
    return beginFragment(new Label(), after);
  }
  
  public int beginFragment(Label start, Label after)
  {
    int i = fixup_count;
    fixupAdd(10, after);
    start.define(this);
    return i;
  }
  



  public void endFragment(int cookie)
  {
    fixupSet(cookie, 10, fixup_count);
    Label after = fixup_labels[cookie];
    fixupAdd(9, -1, null);
    after.define(this);
    int fx = fixup_count - 1;
    fixupSet(fx, 0, fixupOffset(fx));
  }
}
