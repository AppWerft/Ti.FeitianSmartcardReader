package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassFileInput;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.TypeVariable;
import gnu.bytecode.Variable;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.Consumer;
import gnu.lists.ConsumerWriter;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongArguments;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.net.URL;
import kawa.SourceMethodType;


public class PrimProcedure
  extends MethodProc
{
  private Type retType;
  private Type[] argTypes;
  private gnu.bytecode.Method method;
  private gnu.bytecode.Method methodForInvoke;
  private int op_code;
  private char mode;
  private boolean sideEffectFree;
  private boolean doFixUnsigned;
  private LambdaExp source;
  private Member member;
  
  public final int opcode() { return op_code; }
  
  public Type getReturnType() { return retType; }
  
  public void setReturnType(Type retType) { doFixUnsigned = true;
    this.retType = retType;
  }
  
  public boolean isSpecial() { return mode == 'P'; }
  
  public Type getReturnType(Expression[] args) { return retType; }
  
  public ClassType getDeclaringClass() {
    return methodForInvoke == null ? null : methodForInvoke.getDeclaringClass();
  }
  

  public gnu.bytecode.Method getMethod() { return method; }
  
  public void setMethodForInvoke(gnu.bytecode.Method m) {
    methodForInvoke = m;
    setOpcode(m);
  }
  
  public boolean isSideEffectFree()
  {
    return sideEffectFree;
  }
  
  public void setSideEffectFree()
  {
    sideEffectFree = true;
  }
  
  public boolean takesVarArgs()
  {
    return takesVarArgs(method);
  }
  
  public static boolean takesVarArgs(gnu.bytecode.Method method) {
    if (method != null) {
      if ((method.getModifiers() & 0x80) != 0)
        return true;
      String name = method.getName();
      return (name.endsWith("$V")) || (name.endsWith("$V$X"));
    }
    return false;
  }
  
  public boolean takesContext()
  {
    return (method != null) && (takesContext(method));
  }
  
  public static boolean takesContext(gnu.bytecode.Method method)
  {
    return method.getName().endsWith("$X");
  }
  












  public static boolean explicitArrayAsVarArgsAllowed = true;
  
  public int isApplicable(Type[] argTypes, Type restType) {
    int app = super.isApplicable(argTypes, restType);
    int nargs = argTypes.length;
    if ((explicitArrayAsVarArgsAllowed) && (app == -1) && (method != null) && (restType == null) && ((method.getModifiers() & 0x80) != 0) && (nargs > 0) && ((argTypes[(nargs - 1)] instanceof ArrayType)))
    {





      Type[] tmp = new Type[nargs];
      System.arraycopy(argTypes, 0, tmp, 0, nargs - 1);
      tmp[(nargs - 1)] = ((ArrayType)argTypes[(nargs - 1)]).getComponentType();
      return super.isApplicable(tmp, null);
    }
    return app;
  }
  
  public boolean isAbstract() {
    return (method != null) && ((method.getModifiers() & 0x400) != 0);
  }
  


  public final boolean isConstructor()
  {
    return (opcode() == 183) && (mode != 'P');
  }
  








  public boolean takesTarget()
  {
    return mode != 0;
  }
  





  public int numArgs()
  {
    int num = argTypes.length;
    if (takesTarget())
      num++;
    if (takesContext())
      num--;
    return takesVarArgs() ? num - 1 + 61440 : num + (num << 12);
  }
  
  public int match0(CallContext ctx)
  {
    return matchN(ProcedureN.noArgs, ctx);
  }
  
  public int match1(Object arg1, CallContext ctx)
  {
    Object[] args = { arg1 };
    return matchN(args, ctx);
  }
  
  public int match2(Object arg1, Object arg2, CallContext ctx)
  {
    Object[] args = { arg1, arg2 };
    return matchN(args, ctx);
  }
  
  public int match3(Object arg1, Object arg2, Object arg3, CallContext ctx)
  {
    Object[] args = { arg1, arg2, arg3 };
    return matchN(args, ctx);
  }
  

  public int match4(Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx)
  {
    Object[] args = { arg1, arg2, arg3, arg4 };
    return matchN(args, ctx);
  }
  
  public int matchN(Object[] args, CallContext ctx) {
    int nargs = args.length;
    boolean takesVarArgs = takesVarArgs();
    int fixArgs = minArgs();
    if (nargs < fixArgs)
      return 0xFFF10000 | fixArgs;
    if ((!takesVarArgs) && (nargs > fixArgs))
      return 0xFFF20000 | fixArgs;
    int paramCount = argTypes.length;
    Type elementType = null;
    Object restArray = null;
    int extraCount = (takesTarget()) || (isConstructor()) ? 1 : 0;
    boolean takesContext = takesContext();
    Object[] rargs = new Object[paramCount];
    if (takesContext) {
      rargs[(--paramCount)] = ctx;
    }
    if (takesVarArgs) {
      Type restType = argTypes[(paramCount - 1)];
      if ((restType == Compilation.scmListType) || (restType == LangObjType.listType))
      {
        rargs[(paramCount - 1)] = LList.makeList(args, fixArgs);
        nargs = fixArgs;
        elementType = Type.objectType;
      } else {
        ArrayType restArrayType = (ArrayType)restType;
        elementType = restArrayType.getComponentType();
        Class elementClass = elementType.getReflectClass();
        restArray = Array.newInstance(elementClass, nargs - fixArgs);
        rargs[(paramCount - 1)] = restArray; } }
    Object extraArg;
    Object extraArg;
    if (isConstructor()) {
      extraArg = args[0];
    } else if (extraCount != 0) {
      try {
        extraArg = getDeclaringClass().coerceFromObject(args[0]);
      } catch (ClassCastException ex) {
        return -786431;
      }
    } else
      extraArg = null;
    for (int i = extraCount; i < args.length; i++) {
      Object arg = args[i];
      Type type = elementType == null ? null : i < fixArgs ? argTypes[(i - extraCount)] : elementType;
      
      if (type != Type.objectType) {
        try {
          arg = type.coerceFromObject(arg);
        } catch (ClassCastException ex) {
          return 0xFFF40000 | i + 1;
        }
      }
      if (i < fixArgs) {
        rargs[(i - extraCount)] = arg;
      } else if (restArray != null) {
        if ((type instanceof PrimType))
          arg = ((PrimType)type).convertToRaw(arg);
        Array.set(restArray, i - fixArgs, arg);
      }
    }
    value1 = extraArg;
    values = rargs;
    proc = this;
    return 0;
  }
  
  public void apply(CallContext ctx) throws Throwable
  {
    int arg_count = argTypes.length;
    boolean is_constructor = isConstructor();
    boolean slink = (is_constructor) && (getDeclaringClass().hasOuterLink());
    
    try
    {
      if (member == null)
      {
        Class clas = getDeclaringClass().getReflectClass();
        Class[] paramTypes = new Class[arg_count + (slink ? 1 : 0)];
        int i = arg_count; for (;;) { i--; if (i < 0) break;
          paramTypes[(i + (slink ? 1 : 0))] = argTypes[i].getReflectClass(); }
        if (slink)
          paramTypes[0] = getDeclaringClass().getOuterLinkType().getReflectClass();
        if (is_constructor) {
          member = clas.getConstructor(paramTypes);
        } else if (method != Type.clone_method)
          member = clas.getMethod(method.getName(), paramTypes); }
      Object result;
      Object result;
      if (is_constructor)
      {
        Object[] args = values;
        if (slink)
        {
          int nargs = args.length + 1;
          Object[] xargs = new Object[nargs];
          System.arraycopy(args, 0, xargs, 1, nargs - 1);
          xargs[0] = value1).staticLink;
          args = xargs;
        }
        
        result = ((Constructor)member).newInstance(args);

      }
      else if (method == Type.clone_method)
      {

        Object arr = value1;
        Class elClass = arr.getClass().getComponentType();
        int n = Array.getLength(arr);
        Object result = Array.newInstance(elClass, n);
        System.arraycopy(arr, 0, result, 0, n);
      }
      else {
        result = retType.coerceToObject(((java.lang.reflect.Method)member).invoke(value1, values));
      }
      if (!takesContext()) {
        consumer.writeObject(result);
      }
    }
    catch (InvocationTargetException ex) {
      throw ex.getTargetException();
    }
  }
  
  public PrimProcedure(String className, String methodName, int numArgs)
  {
    this(ClassType.make(className).getDeclaredMethod(methodName, numArgs));
  }
  
  public PrimProcedure(java.lang.reflect.Method method, Language language)
  {
    this(((ClassType)language.getTypeFor(method.getDeclaringClass())).getMethod(method), language);
  }
  

  public PrimProcedure(gnu.bytecode.Method method)
  {
    init(method);
    retType = (method.getName().endsWith("$X") ? Type.objectType : method.getReturnType());
  }
  
  public PrimProcedure(gnu.bytecode.Method method, Type retType, Type[] argTypes)
  {
    init(method);
    this.retType = retType;
    if (argTypes != null) {
      this.argTypes = argTypes;
    }
  }
  
  public PrimProcedure(gnu.bytecode.Method method, Language language) {
    this(method, '\000', language, null);
  }
  
  public PrimProcedure(gnu.bytecode.Method method, char mode, Language language, ParameterizedType parameterizedType)
  {
    this.mode = mode;
    
    init(method);
    

    Type[] pTypes = argTypes;
    int nTypes = pTypes.length;
    argTypes = null;
    String[] annotTypes;
    try {
      SourceMethodType sourceType = (SourceMethodType)method.getAnnotation(SourceMethodType.class);
      annotTypes = sourceType == null ? null : sourceType.value();
    } catch (Throwable ex) {
      annotTypes = null;
    }
    int i = nTypes; for (;;) { i--; if (i < 0) break;
      Type javaType = pTypes[i];
      Type langType = decodeType(javaType, annotTypes, i + 1, parameterizedType, language);
      
      if (javaType != langType) {
        if (argTypes == null) {
          argTypes = new Type[nTypes];
          System.arraycopy(pTypes, 0, argTypes, 0, nTypes);
        }
        argTypes[i] = langType;
      }
    }
    if (argTypes == null)
      argTypes = pTypes;
    if (isConstructor()) {
      retType = getDeclaringClass();
    } else if (method.getName().endsWith("$X")) {
      retType = Type.objectType;
    } else {
      retType = decodeType(method.getReturnType(), annotTypes, 0, parameterizedType, language);
      



      if (retType == Type.toStringType) {
        retType = Type.javalangStringType;
      }
    }
  }
  

  public static Type decodeType(Type javaType, String[] annotTypes, int annotIndex, ParameterizedType parameterizedType, Language lang)
  {
    String annotType = (annotTypes != null) && (annotTypes.length > annotIndex) ? annotTypes[annotIndex] : null;
    
    return lang.decodeType(javaType, annotType, parameterizedType);
  }
  
  private void setOpcode(gnu.bytecode.Method m) {
    int flags = m.getModifiers();
    if ((flags & 0x8) != 0) {
      op_code = 184;
    } else {
      ClassType mclass = m.getDeclaringClass();
      if (mode == 'P') {
        op_code = 183;
      } else {
        mode = 'V';
        if ("<init>".equals(m.getName())) {
          op_code = 183;
        } else if ((mclass.getModifiers() & 0x200) != 0) {
          op_code = 185;
        } else {
          op_code = 182;
        }
      }
    }
  }
  
  private void init(gnu.bytecode.Method method) {
    this.method = method;
    methodForInvoke = method;
    setOpcode(method);
    Type[] mtypes = method.getParameterTypes();
    if ((isConstructor()) && (method.getDeclaringClass().hasOuterLink()))
    {
      int len = mtypes.length - 1;
      Type[] types = new Type[len];
      System.arraycopy(mtypes, 1, types, 0, len);
      mtypes = types;
    }
    argTypes = mtypes;
  }
  
  public PrimProcedure(gnu.bytecode.Method method, LambdaExp source)
  {
    this(method);
    retType = source.getReturnType();
    this.source = source;
  }
  
  public PrimProcedure(int opcode, Type retType, Type[] argTypes)
  {
    op_code = opcode;
    this.retType = retType;
    this.argTypes = argTypes;
  }
  

  public static PrimProcedure makeBuiltinUnary(int opcode, Type type)
  {
    Type[] args = new Type[1];
    args[0] = type;
    return new PrimProcedure(opcode, type, args);
  }
  

  public static PrimProcedure makeBuiltinBinary(int opcode, Type type)
  {
    Type[] args = new Type[2];
    args[0] = type;
    args[1] = type;
    return new PrimProcedure(opcode, type, args);
  }
  

  public PrimProcedure(int op_code, ClassType classtype, String name, Type retType, Type[] argTypes)
  {
    this.op_code = op_code;
    method = classtype.addMethod(name, op_code == 184 ? 8 : 0, argTypes, retType);
    
    methodForInvoke = method;
    this.retType = retType;
    this.argTypes = argTypes;
    mode = (op_code == 184 ? '\000' : 'V');
  }
  

  public final boolean getStaticFlag()
  {
    return (method == null) || (method.getStaticFlag()) || (isConstructor());
  }
  
  public final Type[] getParameterTypes()
  {
    return argTypes;
  }
  









  private void compileArgs(ApplyExp exp, Expression[] args, int startArg, Type thisType, Compilation comp)
  {
    boolean variable = takesVarArgs();
    String name = getName();
    Type arg_type = null;
    CodeAttr code = comp.getCode();
    int skipArg = thisType == Type.voidType ? 1 : 0;
    int arg_count = argTypes.length - skipArg;
    if (takesContext())
      arg_count--;
    int nargs = args.length - startArg;
    boolean is_static = (thisType == null) || (skipArg != 0);
    



    boolean createVarargsArrayIfNeeded = false;
    if ((explicitArrayAsVarArgsAllowed) && (variable) && ((method.getModifiers() & 0x80) != 0) && (firstSpliceArg < 0) && (nargs > 0) && (argTypes.length > 0)) if (nargs == arg_count + (is_static ? 0 : 1))
      {




        Type lastType = args[(args.length - 1)].getType();
        Type lastParam = argTypes[(argTypes.length - 1)];
        if (lastParam.isCompatibleWithValue(lastType) >= 0)
        {
          if (((lastParam instanceof ArrayType)) && (((ArrayType)lastParam).getComponentType().isCompatibleWithValue(lastType) >= 0))
          {
            createVarargsArrayIfNeeded = true; }
          variable = false;
        }
      }
    int fix_arg_count = variable ? arg_count - (is_static ? 1 : 0) : args.length - startArg;
    Declaration argDecl = source == null ? null : source.firstDecl();
    if ((argDecl != null) && (argDecl.isThisParameter()))
      argDecl = argDecl.nextDecl();
    for (int i = 0;; i++)
    {
      if ((variable) && (i == fix_arg_count))
      {
        arg_type = argTypes[(arg_count - 1 + skipArg)];
        if ((arg_type == Compilation.scmListType) || (arg_type == LangObjType.listType))
        {
          gnu.kawa.functions.MakeList.compile(args, startArg + i, comp);
          break;
        }
        if ((startArg + i + 1 == args.length) && (firstSpliceArg == startArg + i))
        {

          Expression spliceArg = MakeSplice.argIfSplice(args[(startArg + i)]);
          Type spliceType = spliceArg.getType();
          if ((spliceType instanceof ArrayType)) {
            Type spliceElType = ((ArrayType)spliceType).getComponentType();
            Type argElType = ((ArrayType)arg_type).getComponentType();
            if ((spliceElType == argElType) || ((argElType == Type.objectType) && ((spliceElType instanceof ObjectType))) || (((argElType instanceof ClassType)) && ((spliceElType instanceof ClassType)) && (spliceElType.isSubtype(argElType))))
            {




              spliceArg.compileWithPosition(comp, Target.pushObject);
              i = nargs;
              break;
            }
          }
        }
        
        arg_type = ((ArrayType)arg_type).getComponentType();
        gnu.kawa.reflect.CompileArrays.createArray(arg_type, comp, args, startArg + i, args.length);
        
        i = nargs;
        break;
      }
      if (i >= nargs)
        break;
      boolean createVarargsNow = (createVarargsArrayIfNeeded) && (i + 1 == nargs);
      if (i >= fix_arg_count)
      {
        code.emitDup(1);
        code.emitPushInt(i - fix_arg_count);
      }
      else {
        arg_type = i == 0 ? thisType : is_static ? argTypes[(i + skipArg)] : (argDecl != null) && ((is_static) || (i > 0)) ? argDecl.getType() : argTypes[(i - 1)];
      }
      

      comp.usedClass(arg_type);
      Type argTypeForTarget = createVarargsNow ? Type.objectType : arg_type;
      Target target = source == null ? CheckedTarget.getInstance(argTypeForTarget, name, i + 1) : CheckedTarget.getInstance(argTypeForTarget, source, i);
      

      args[(startArg + i)].compileWithPosition(comp, target);
      if (createVarargsNow)
      {


        Type eltype = ((ArrayType)arg_type).getComponentType();
        code.emitDup();
        code.emitInstanceof(arg_type);
        code.emitIfIntNotZero();
        code.emitCheckcast(arg_type);
        code.emitElse();
        code.emitPushInt(1);
        code.emitNewArray(eltype);
        code.emitDupX();
        code.emitSwap();
        code.emitPushInt(0);
        code.emitSwap();
        eltype.emitCoerceFromObject(code);
        code.emitArrayStore(eltype);
        code.emitFi();
      }
      if (i >= fix_arg_count)
        code.emitArrayStore(arg_type);
      if ((argDecl != null) && ((is_static) || (i > 0)))
        argDecl = argDecl.nextDecl();
    }
  }
  
  public boolean canCompile(ApplyExp exp) {
    if (firstKeywordArgIndex != 0) {
      return false;
    }
    
    if ((firstSpliceArg >= 0) && ((!takesVarArgs()) || (minArgs() > firstSpliceArg)))
    {
      return false; }
    return true;
  }
  
  public boolean compile(ApplyExp exp, Compilation comp, Target target) {
    if (!canCompile(exp)) {
      return false;
    }
    CodeAttr code = comp.getCode();
    ClassType mclass = getDeclaringClass();
    Expression[] args = exp.getArgs();
    if (isConstructor())
    {
      if ((exp.getFlag(8)) && (Compilation.defaultClassFileVersion <= 3407872))
      {














        int nargs = args.length;
        comp.letStart();
        Expression[] xargs = new Expression[nargs];
        xargs[0] = args[0];
        for (int i = 1; i < nargs; i++)
        {
          Expression argi = args[i];
          



          if ((!(argi instanceof QuoteExp)) && (!(argi instanceof LambdaExp)) && (!(argi instanceof ReferenceExp)))
          {


            Declaration d = comp.letVariable(null, argi.getType(), argi);
            d.setCanRead(true);
            argi = new ReferenceExp(d);
          }
          xargs[i] = argi;
        }
        comp.letEnter();
        LetExp let = comp.letDone(new ApplyExp(func, xargs));
        let.compile(comp, target);
        return true;
      }
      code.emitNew(mclass);
      code.emitDup(mclass);
    }
    int spliceCount = exp.spliceCount();
    String arg_error = WrongArguments.checkArgCount(this, args.length - spliceCount, spliceCount > 0);
    

    if (arg_error != null) {
      comp.error('e', arg_error);
    }
    compile(getStaticFlag() ? null : mclass, exp, comp, target);
    return true;
  }
  
  void compile(Type thisType, ApplyExp exp, Compilation comp, Target target)
  {
    Expression[] args = exp.getArgs();
    CodeAttr code = comp.getCode();
    int startArg = 0;
    if (isConstructor())
    {
      ClassType mclass = getDeclaringClass();
      if (mclass.hasOuterLink())
      {
        ClassExp.loadSuperStaticLink(args[0], mclass, comp);
      }
      thisType = null;
      startArg = 1;


    }
    else if ((opcode() == 183) && (mode == 'P') && ("<init>".equals(method.getName())))
    {

      ClassType mclass = getDeclaringClass();
      if (mclass.hasOuterLink())
      {
        code.emitPushThis();
        
        code.emitLoad(code.getCurrentScope().getVariable(1));
        thisType = null;
        startArg = 1;
      }
    }
    else if ((takesTarget()) && (method.getStaticFlag())) {
      startArg = 1; }
    compileArgs(exp, args, startArg, thisType, comp);
    
    if (method == null)
    {
      code.emitPrimop(opcode(), args.length, retType);
      target.compileFromStack(comp, retType);
    }
    else
    {
      compileInvoke(comp, methodForInvoke, target, exp.isTailCall(), op_code, retType, doFixUnsigned);
    }
  }
  








  public static void compileInvoke(Compilation comp, gnu.bytecode.Method method, Target target, boolean isTailCall, int op_code, Type returnType, boolean doFixUnsigned)
  {
    CodeAttr code = comp.getCode();
    comp.usedClass(method.getDeclaringClass());
    comp.usedClass(method.getReturnType());
    if (!takesContext(method))
    {
      code.emitInvokeMethod(method, op_code);
    } else {
      if (((target instanceof IgnoreTarget)) || (((target instanceof ConsumerTarget)) && (((ConsumerTarget)target).isContextTarget())))
      {


        Field consumerFld = null;
        Variable saveCallContext = null;
        comp.loadCallContext();
        if ((target instanceof IgnoreTarget))
        {
          ClassType typeCallContext = Compilation.typeCallContext;
          consumerFld = typeCallContext.getDeclaredField("consumer");
          


          code.pushScope();
          saveCallContext = code.addLocal(typeCallContext);
          code.emitDup();
          code.emitGetField(consumerFld);
          code.emitStore(saveCallContext);
          code.emitDup();
          code.emitGetStatic(ClassType.make("gnu.lists.VoidConsumer").getDeclaredField("instance"));
          
          code.emitPutField(consumerFld);
        }
        code.emitInvokeMethod(method, op_code);
        ApplyExp.finishTrampoline(isTailCall, target, comp);
        if ((target instanceof IgnoreTarget))
        {

          comp.loadCallContext();
          code.emitLoad(saveCallContext);
          code.emitPutField(consumerFld);
          code.popScope();
        }
        return;
      }
      

      comp.loadCallContext();
      returnType = Type.objectType;
      code.pushScope();
      Variable saveIndex = code.addLocal(Type.intType);
      



      comp.loadCallContext();
      code.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("startFromContext", 0));
      
      code.emitStore(saveIndex);
      code.emitWithCleanupStart();
      code.emitInvokeMethod(method, op_code);
      code.emitWithCleanupCatch(null);
      comp.loadCallContext();
      code.emitLoad(saveIndex);
      code.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("cleanupFromContext", 1));
      
      code.emitWithCleanupDone();
      comp.loadCallContext();
      code.emitLoad(saveIndex);
      code.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("getFromContext", 1));
      
      code.popScope();
    }
    if (method.getReturnType() == Type.neverReturnsType)
    {



      compileReachedUnexpected(code);
    }
    else {
      if ((method.getReturnType() instanceof TypeVariable)) {
        if ((returnType instanceof ClassType))
        {






          code.emitCheckcast(returnType);
        } else
          returnType = method.getReturnType().getRawType();
      }
      if (doFixUnsigned)
        code.fixUnsigned(returnType);
      target.compileFromStack(comp, returnType);
    }
  }
  
  public static void compileReachedUnexpected(CodeAttr code) {
    if (code.reachableHere()) {
      code.emitGetStatic(ClassType.make("gnu.expr.Special").getDeclaredField("reachedUnexpected"));
      
      code.emitThrow();
    }
  }
  
  public Type getParameterType(int index)
  {
    if (takesTarget())
    {
      if (index == 0) {
        return isConstructor() ? Type.objectType : getDeclaringClass();
      }
      index--;
    }
    int lenTypes = argTypes.length;
    if (index < lenTypes - 1)
      return argTypes[index];
    boolean varArgs = takesVarArgs();
    if ((index < lenTypes) && (!varArgs))
      return argTypes[index];
    Type restType = argTypes[(lenTypes - 1)];
    if ((restType instanceof ArrayType)) {
      return ((ArrayType)restType).getComponentType();
    }
    return Type.objectType;
  }
  

  private static ClassLoader systemClassLoader = PrimProcedure.class.getClassLoader();
  



  public static int mostSpecific(PrimProcedure[] procs, int length)
  {
    if (length <= 1) {
      return length - 1;
    }
    int best = 0;
    


    int[] bests = null;
    
    int bestn = 0;
    label165:
    for (int i = 1; i < length; i++) {
      PrimProcedure method = procs[i];
      if (best >= 0) {
        PrimProcedure winner = (PrimProcedure)mostSpecific(procs[best], method);
        
        if (winner == null) {
          if (bests == null)
            bests = new int[length];
          bests[0] = best;
          bests[1] = i;
          bestn = 2;
          best = -1;
        } else if (winner == method) {
          best = i;
          bestn = i;
        }
      } else {
        for (int j = 0; j < bestn; j++) {
          PrimProcedure old = procs[bests[j]];
          PrimProcedure winner = (PrimProcedure)mostSpecific(old, method);
          
          if (winner == old)
            break label165;
          if (winner == null) {
            bests[(bestn++)] = i;
            
            break label165;
          }
        }
        best = i;
        bestn = i;
      }
    }
    if ((best < 0) && (bestn > 1)) {
      PrimProcedure first = procs[bests[0]];
      for (int j = 0; j < bestn; j++) {
        int m = bests[j];
        PrimProcedure method = procs[m];
        if ((j > 0) && (!overrideEquivalent(first, method)))
          return -1;
        if (!method.isAbstract()) {
          if (best >= 0)
            return -1;
          best = m;
        }
      }
      return best >= 0 ? best : bests[0];
    }
    return best;
  }
  
  public static PrimProcedure getMethodFor(Procedure pproc, Expression[] args)
  {
    return getMethodFor(pproc, null, args, Language.getDefaultLanguage());
  }
  




  public static PrimProcedure getMethodFor(Procedure pproc, Declaration decl, Expression[] args, Language language)
  {
    int nargs = args.length;
    Type[] atypes = new Type[nargs];
    for (int i = nargs;; atypes[i] = args[i].getType()) { i--; if (i < 0) break; }
    return getMethodFor(pproc, decl, atypes, language);
  }
  

  public static PrimProcedure getMethodFor(Procedure pproc, Declaration decl, Type[] atypes, Language language)
  {
    if ((pproc instanceof GenericProc))
    {
      GenericProc gproc = (GenericProc)pproc;
      MethodProc[] methods = methods;
      pproc = null;
      int i = count; for (;;) { i--; if (i < 0)
          break;
        int applic = methods[i].isApplicable(atypes, null);
        if (applic >= 0)
        {
          if (pproc != null)
            return null;
          pproc = methods[i];
        } }
      if (pproc == null)
        return null;
    }
    if ((pproc instanceof PrimProcedure))
    {
      PrimProcedure prproc = (PrimProcedure)pproc;
      if (prproc.isApplicable(atypes, null) >= 0)
        return prproc;
    }
    Class pclass = getProcedureClass(pproc);
    if (pclass == null)
      return null;
    return getMethodFor((ClassType)Type.make(pclass), pproc.getName(), decl, atypes, language);
  }
  

  public static void disassemble$X(Procedure pproc, CallContext ctx)
    throws Exception
  {
    Consumer cons = consumer;
    disassemble(pproc, (cons instanceof Writer) ? (Writer)cons : new ConsumerWriter(cons));
  }
  
  public static void disassemble(Procedure proc, Writer out)
    throws Exception
  {
    disassemble(proc, new ClassTypeWriter(null, out, 0));
  }
  
  public static void disassemble(Procedure proc, ClassTypeWriter cwriter)
    throws Exception
  {
    if ((proc instanceof GenericProc))
    {
      GenericProc gproc = (GenericProc)proc;
      int n = gproc.getMethodCount();
      cwriter.print("Generic procedure with ");
      cwriter.print(n);
      cwriter.println(n == 1 ? " method." : "methods.");
      for (int i = 0; i < n; i++)
      {
        Procedure mproc = gproc.getMethod(i);
        if (mproc != null)
        {
          cwriter.println();
          disassemble(mproc, cwriter);
        }
      }
      return;
    }
    String pname = null;
    Class cl = proc.getClass();
    if ((proc instanceof ModuleMethod)) {
      cl = module.getClass();
    } else if ((proc instanceof PrimProcedure))
    {
      gnu.bytecode.Method pmethod = methodForInvoke;
      if (pmethod != null)
      {
        cl = pmethod.getDeclaringClass().getReflectClass();
        pname = pmethod.getName();
      }
    }
    ClassLoader loader = cl.getClassLoader();
    if (loader == null) loader = ClassLoader.getSystemClassLoader();
    String cname = cl.getName();
    String rname = cname.replace('.', '/') + ".class";
    ClassType ctype = new ClassType();
    InputStream rin = loader.getResourceAsStream(rname);
    if (rin == null)
      throw new RuntimeException("missing resource " + rname);
    ClassFileInput cinput = new ClassFileInput(ctype, rin);
    cwriter.setClass(ctype);
    URL resource = loader.getResource(rname);
    cwriter.print("In class ");
    cwriter.print(cname);
    if (resource != null)
    {
      cwriter.print(" at ");
      cwriter.print(resource);
    }
    cwriter.println();
    if (pname == null)
    {
      pname = proc.getName();
      if (pname == null)
      {
        cwriter.println("Anonymous function - unknown method.");
        return;
      }
      pname = Mangling.mangleName(pname);
    }
    for (gnu.bytecode.Method method = ctype.getMethods(); 
        method != null; method = method.getNext())
    {
      String mname = method.getName();
      if (mname.equals(pname)) {
        cwriter.printMethod(method);
      }
    }
    cwriter.flush();
  }
  
  public static Class getProcedureClass(Object pproc) {
    Class procClass;
    Class procClass;
    if ((pproc instanceof ModuleMethod)) {
      procClass = module.getClass();
    } else {
      procClass = pproc.getClass();
    }
    try {
      if (procClass.getClassLoader() == systemClassLoader) {
        return procClass;
      }
    }
    catch (SecurityException ex) {}
    
    return null;
  }
  



  public static PrimProcedure getMethodFor(Class procClass, String name, Declaration decl, Expression[] args, Language language)
  {
    return getMethodFor((ClassType)Type.make(procClass), name, decl, args, language);
  }
  



  public static PrimProcedure getMethodFor(ClassType procClass, String name, Declaration decl, Expression[] args, Language language)
  {
    int nargs = args.length;
    Type[] atypes = new Type[nargs];
    for (int i = nargs;; atypes[i] = args[i].getType()) { i--; if (i < 0) break; }
    return getMethodFor(procClass, name, decl, atypes, language);
  }
  


  public static PrimProcedure getMethodFor(ClassType procClass, String name, Declaration decl, Type[] atypes, Language language)
  {
    PrimProcedure best = null;
    int bestCode = -1;
    boolean bestIsApply = false;
    try
    {
      if (name == null)
        return null;
      String mangledName = Mangling.mangleName(name);
      String mangledNameV = mangledName + "$V";
      String mangledNameVX = mangledName + "$V$X";
      String mangledNameX = mangledName + "$X";
      boolean applyOk = true;
      for (gnu.bytecode.Method meth = procClass.getDeclaredMethods(); 
          meth != null; meth = meth.getNext())
      {
        int mods = meth.getModifiers();
        if (((mods & 0x9) == 9) || (
        

          (decl != null) && (base != null)))
        {

          String mname = meth.getName();
          boolean isApply;
          boolean isApply; if ((mname.equals(mangledName)) || (mname.equals(mangledNameV)) || (mname.equals(mangledNameX)) || (mname.equals(mangledNameVX)))
          {



            isApply = false;
          } else {
            if ((!applyOk) || ((!mname.equals("apply")) && (!mname.equals("apply$V")))) {
              continue;
            }
            isApply = true;
          }
          

          if (!isApply)
          {

            applyOk = false;
            if (bestIsApply)
            {
              best = null;
              bestCode = -1;
              bestIsApply = false;
            }
          }
          PrimProcedure prproc = new PrimProcedure(meth, language);
          prproc.setName(name);
          int code = prproc.isApplicable(atypes, null);
          if ((code >= 0) && (code >= bestCode))
          {
            if (code > bestCode)
            {
              best = prproc;
            }
            else if (best != null)
            {
              best = (PrimProcedure)MethodProc.mostSpecific(best, prproc);
              if (best == null)
              {
                if (bestCode > 0)
                  return null;
              }
            }
            bestCode = code;
            bestIsApply = isApply;
          }
        }
      }
    }
    catch (SecurityException ex) {}
    return best;
  }
  
  public String getName()
  {
    String name = super.getName();
    if (name != null)
      return name;
    name = getVerboseName();
    setName(name);
    return name;
  }
  
  public String getVerboseName()
  {
    StringBuffer buf = new StringBuffer(100);
    if (method == null)
    {
      buf.append("<op ");
      buf.append(op_code);
      buf.append('>');
    }
    else
    {
      buf.append(getDeclaringClass().getName());
      buf.append('.');
      buf.append(method.getName());
    }
    buf.append('(');
    for (int i = 0; i < argTypes.length; i++)
    {
      if (i > 0)
        buf.append(',');
      buf.append(argTypes[i].getName());
    }
    buf.append(')');
    return buf.toString();
  }
  
  public String toString()
  {
    StringBuffer buf = new StringBuffer(100);
    buf.append(retType == null ? "<unknown>" : retType.getName());
    buf.append(' ');
    buf.append(getVerboseName());
    return buf.toString();
  }
  
  public void print(PrintWriter ps)
  {
    ps.print("#<primitive procedure ");
    ps.print(toString());
    ps.print('>');
  }
}
