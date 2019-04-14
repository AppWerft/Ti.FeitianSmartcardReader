package gnu.expr;

import gnu.bytecode.AnnotationEntry;
import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ExceptionsAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Filter;
import gnu.bytecode.Label;
import gnu.bytecode.LocalVarsAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.RuntimeAnnotationsAttr;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.io.OutPort;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import java.lang.annotation.ElementType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
import kawa.SourceMethodType;


public class LambdaExp
  extends ScopeExp
{
  public Expression body;
  public int min_args;
  public int max_args;
  public int opt_args;
  ArrayList<LambdaExp> applyMethods;
  Variable argsArray;
  private Declaration firstArgsArrayArg;
  public Keyword[] keywords;
  Declaration capturedVars;
  ReferenceExp siblingReferences;
  Label startForInlining;
  LinkedList<Object> pendingInlines;
  Variable heapFrame;
  public LambdaExp firstChild;
  public LambdaExp nextSibling;
  
  public void capture(Declaration decl)
  {
    if (decl.isSimple()) {
      if ((capturedVars == null) && (!decl.isStatic()) && (!isClassGenerated()))
      {

        heapFrame = new Variable("$heapFrame");
      }
      decl.setSimple(false);
      if (!decl.isPublic()) {
        nextCapturedVar = capturedVars;
        capturedVars = decl;
      }
    }
  }
  
  public Declaration addParameter(Object name) {
    min_args += 1;
    max_args += 1;
    return super.addDeclaration(name);
  }
  















  static final ApplyExp unknownContinuation = new ApplyExp((Expression)null, (Expression[])null);
  
  public Expression returnContinuation;
  
  Set<LambdaExp> tailCallers;
  
  public LambdaExp inlineHome;
  
  Expression[] throwsSpecification;
  
  public Declaration nameDecl;
  
  public static final String CLOSURE_ENV_NAME = "$closureEnv";
  
  public Field closureEnvField;
  
  public Field staticLinkField;
  Variable closureEnv;
  static final int CAN_READ = 2;
  static final int INLINE_ONLY = 4;
  static final int IMPORTS_LEX_VARS = 8;
  static final int NEEDS_STATIC_LINK = 16;
  static final int CANNOT_INLINE = 32;
  
  public void setExceptions(Expression[] exceptions)
  {
    throwsSpecification = exceptions;
  }
  



  static final int CLASS_METHOD = 64;
  


  static final int METHODS_COMPILED = 128;
  


  public static final int NO_FIELD = 256;
  


  static final int DEFAULT_CAPTURES_ARG = 512;
  


  public static final int SEQUENCE_RESULT = 1024;
  


  public static final int OVERLOADABLE_FIELD = 2048;
  

  public static final int ATTEMPT_INLINE = 4096;
  

  public static final int IN_EXPWALKER = 8192;
  

  public static final int PASSES_TAILCALLS = 16384;
  

  public static final int PUBLIC_METHOD = 16384;
  

  protected static final int NEXT_AVAIL_FLAG = 32768;
  

  int callConvention;
  

  CanFinishMap canFinishCondition;
  

  Set<LambdaExp> canFinishListeners;
  

  public final boolean getInlineOnly()
  {
    return (flags & 0x4) != 0; }
  
  public final void setInlineOnly(boolean inlineOnly) { setFlag(inlineOnly, 4); }
  




  public final void setInlineOnly(Expression returnContinuation, LambdaExp caller)
  {
    setInlineOnly(true);
    this.returnContinuation = returnContinuation;
    inlineHome = caller;
  }
  
  public final boolean getNeedsClosureEnv() {
    return (flags & 0x18) != 0;
  }
  



  public final boolean getNeedsStaticLink() { return (flags & 0x10) != 0; }
  
  public final void setNeedsStaticLink(boolean needsStaticLink) {
    if (needsStaticLink) flags |= 0x10; else {
      flags &= 0xFFFFFFEF;
    }
  }
  
  public final boolean getImportsLexVars() {
    return (flags & 0x8) != 0;
  }
  
  public final void setImportsLexVars(boolean importsLexVars) {
    if (importsLexVars) flags |= 0x8; else
      flags &= 0xFFFFFFF7;
  }
  
  public final void setImportsLexVars() {
    int old = flags;
    flags |= 0x8;
    

    if (((old & 0x8) == 0) && (nameDecl != null))
      setCallersNeedStaticLink();
  }
  
  public final void setNeedsStaticLink() {
    int old = flags;
    flags |= 0x10;
    

    if (((old & 0x10) == 0) && (nameDecl != null))
      setCallersNeedStaticLink();
  }
  
  void setCallersNeedStaticLink() {
    LambdaExp outer = nameDecl.getContext().currentLambda();
    for (ApplyExp app = nameDecl.firstCall; app != null; 
        app = nextCall) {
      for (LambdaExp caller = context; 
          (caller != outer) && (!(caller instanceof ModuleExp)); 
          caller = caller.outerLambda()) {
        caller.setNeedsStaticLink();
      }
    }
  }
  
  public final boolean getCanRead() { return (flags & 0x2) != 0; }
  
  public final void setCanRead(boolean read) {
    if (read) flags |= 0x2; else {
      flags &= 0xFFFFFFFD;
    }
  }
  
  public final boolean isClassMethod() {
    return (flags & 0x40) != 0;
  }
  
  public final void setClassMethod(boolean isMethod) {
    if (isMethod) flags |= 0x40; else
      flags &= 0xFFFFFFBF;
  }
  
  public final boolean isModuleBody() {
    return this instanceof ModuleExp;
  }
  
  public boolean isAbstract() { return body == QuoteExp.abstractExp; }
  
  public boolean isNative()
  {
    return body == QuoteExp.nativeExp;
  }
  




  public int getCallConvention() { return callConvention; }
  
  public void setCallConvention(Compilation comp) { if (isClassMethod()) {
      callConvention = 1;
    } else {
      int defaultConvention = comp.currentCallConvention();
      callConvention = (defaultConvention == 0 ? 1 : (defaultConvention < 2) && (isModuleBody()) ? 2 : defaultConvention);
    }
  }
  




  public boolean usingCallContext()
  {
    return getCallConvention() >= 2;
  }
  











  void notifyCanFinish()
  {
    Set<LambdaExp> listeners = canFinishListeners;
    if (listeners != null) {
      canFinishListeners = null;
      for (LambdaExp f : listeners) {
        f.checkCanFinish();
      }
    }
  }
  
  void checkCanFinish() {
    CanFinishMap cond = canFinishCondition;
    if ((cond != null) && (!getFlag(8192)))
    {

      if (cond.canFinish()) {
        canFinishCondition = CanFinishMap.CAN_FINISH;
        notifyCanFinish();
      }
    }
  }
  

  public final boolean isHandlingTailCalls()
  {
    return (isModuleBody()) || ((getCallConvention() >= 3) && (!isClassMethod()));
  }
  


  public final boolean variable_args() { return max_args < 0; }
  
  ClassType compiledType = Compilation.typeProcedure;
  int selectorValue;
  Method[] primMethods;
  
  protected ClassType getCompiledClassType(Compilation comp) { if (compiledType == Compilation.typeProcedure)
      throw new Error("internal error: getCompiledClassType");
    return compiledType;
  }
  
  protected Type calculateType() {
    return compiledType;
  }
  



  public ClassType getClassType() { return compiledType; }
  
  public void setType(ClassType type) {
    compiledType = type;
    this.type = type;
  }
  

  Method[] primBodyMethods;
  Variable thisVariable;
  static Method searchForKeywordMethod3;
  public int incomingArgs()
  {
    return (min_args == max_args) && (max_args <= 4) && (max_args > 0) ? max_args : 1;
  }
  


  int getSelectorValue(Compilation comp)
  {
    int s = selectorValue;
    if (s == 0) {
      s = maxSelectorValue;
      maxSelectorValue = (s + primMethods.length);
      selectorValue = (++s);
    }
    return s;
  }
  

  static Method searchForKeywordMethod4;
  
  Initializer initChain;
  
  Procedure thisValue;
  
  Object[] properties;
  
  public Type returnType;
  public final Method getMethod(int nonSpliceCount, int spliceCount)
  {
    if ((primMethods == null) || ((max_args >= 0) && (nonSpliceCount > max_args)))
      return null;
    int index = nonSpliceCount - min_args;
    if (index < 0)
      return null;
    int length = primMethods.length;
    if (spliceCount > 0)
      return length == 1 ? primMethods[0] : null;
    return primMethods[(length - 1)];
  }
  

  public final Method getMainMethod()
  {
    Method[] methods = primBodyMethods;
    return methods == null ? null : methods[(methods.length - 1)];
  }
  
  public final Type restArgType()
  {
    if (min_args == max_args)
      return null;
    if (primMethods == null)
      throw new Error("internal error - restArgType");
    Method[] methods = primMethods;
    if ((max_args >= 0) && (methods.length > max_args - min_args))
      return null;
    Method method = methods[(methods.length - 1)];
    Type[] types = method.getParameterTypes();
    int ilast = types.length - 1;
    if (method.getName().endsWith("$X"))
      ilast--;
    return types[ilast];
  }
  
  public LambdaExp outerLambda() {
    return getOuter() == null ? null : getOuter().currentLambda();
  }
  
  public LambdaExp outerLambdaOrCaller() {
    return getInlineOnly() ? inlineHome : outerLambda();
  }
  

  public LambdaExp outerLambdaNotInline()
  {
    for (ScopeExp exp = this; (exp = exp.getOuter()) != null;) {
      if ((exp instanceof LambdaExp)) {
        LambdaExp result = (LambdaExp)exp;
        if (!result.getInlineOnly())
          return result;
      }
    }
    return null;
  }
  



  boolean inlinedIn(LambdaExp outer)
  {
    for (LambdaExp exp = this;; exp = exp.getCaller()) {
      if (exp == outer)
        return true;
      if (!exp.getInlineOnly()) {
        return false;
      }
    }
  }
  
  public LambdaExp getCaller() {
    return inlineHome;
  }
  

  public Variable declareThis(ClassType clas)
  {
    if (thisVariable == null) {
      thisVariable = new Variable("this");
      getVarScope().addVariableAfter(null, thisVariable);
      thisVariable.setParameter(true);
    }
    if (thisVariable.getType() == null)
      thisVariable.setType(clas);
    if ((decls != null) && (decls.isThisParameter()))
      decls.var = thisVariable;
    return thisVariable;
  }
  
  public Variable declareClosureEnv() {
    if ((closureEnv == null) && (getNeedsClosureEnv())) {
      LambdaExp parent = outerLambdaOrCaller();
      if ((parent instanceof ClassExp))
        parent = parent.outerLambda();
      if ((isClassMethod()) && (!"*init*".equals(getName()))) {
        closureEnv = declareThis(compiledType);
      } else if ((heapFrame == null) && (!parent.getNeedsStaticLink()) && (!(parent instanceof ModuleExp)))
      {
        closureEnv = null;
      } else if ((!isClassGenerated()) && (!getInlineOnly())) {
        Method primMethod = getMainMethod();
        boolean isInit = "*init*".equals(getName());
        if ((!primMethod.getStaticFlag()) && (!isInit))
        {
          closureEnv = declareThis(primMethod.getDeclaringClass());
        } else {
          Type envType = primMethod.getParameterTypes()[0];
          closureEnv = new Variable("$closureEnv", envType);
          Variable prev;
          Variable prev; if (isInit) {
            prev = declareThis(primMethod.getDeclaringClass());
          } else
            prev = null;
          getVarScope().addVariableAfter(prev, closureEnv);
          closureEnv.setParameter(true);
        }
      } else {
        if (inlineHome != null)
          inlineHome.declareClosureEnv();
        closureEnv = ((heapFrame != null) && (parent == outerLambda()) ? heapFrame : closureEnv);
      }
    }
    


    return closureEnv;
  }
  
  public LambdaExp() {}
  
  public LambdaExp(int args)
  {
    min_args = args;
    max_args = args;
  }
  
  public LambdaExp(Expression body)
  {
    this.body = body;
  }
  
  public void loadHeapFrame(Compilation comp)
  {
    LambdaExp curLambda = curLambda;
    while ((curLambda != this) && (curLambda.getInlineOnly())) {
      curLambda = curLambda.getCaller();
    }
    CodeAttr code = comp.getCode();
    if ((heapFrame != null) && (this == curLambda)) {
      code.emitLoad(heapFrame); return;
    }
    ClassType curType;
    ClassType curType;
    if (closureEnv != null) {
      code.emitLoad(closureEnv);
      curType = (ClassType)closureEnv.getType();
    } else {
      code.emitPushThis();
      curType = curClass;
    }
    while (curLambda != this) {
      Field link = staticLinkField;
      if ((link != null) && (link.getDeclaringClass() == curType)) {
        code.emitGetField(link);
        curType = (ClassType)link.getType();
      }
      curLambda = curLambda.outerLambdaOrCaller();
    }
  }
  
  Declaration getArg(int i)
  {
    for (Declaration var = firstDecl();; var = var.nextDecl()) {
      if (var == null)
        throw new Error("internal error - getArg");
      if (i == 0)
        return var;
      i--;
    }
  }
  
  public void compileEnd(Compilation comp) {
    CodeAttr code = comp.getCode();
    HashMap<String, Variable> varMap = new HashMap();
    
    Label endLabel = new Label(code);
    while ((pendingInlines != null) && (!pendingInlines.isEmpty())) {
      LambdaExp child = (LambdaExp)pendingInlines.remove();
      Target ctarget = (Target)pendingInlines.remove();
      if ((child.getInlineOnly()) && (!child.getFlag(128)) && (startForInlining != null))
      {

        if (code.reachableHere())
          code.emitGoto(endLabel);
        child.compileAsInlined(comp, ctarget);
      }
    }
    if (endLabel.isUsed())
      endLabel.define(code);
    code.getCurrentScope().fixParamNames(varMap);
    popScope(code);
    
    if (!getInlineOnly()) {
      if ((method.reachableHere()) && ((getCallConvention() < 3) || (isModuleBody()) || (isClassMethod()) || (isHandlingTailCalls())))
      {

        code.emitReturn();
      }
      code.getCurrentScope().fixParamNames(varMap);
      code.popScope();
    }
    
    for (LambdaExp child = firstChild; child != null;) {
      if ((!child.getCanRead()) && (!child.getInlineOnly()) && (child.getFlag(1)))
      {
        child.compileAsMethod(comp);
      }
      else if ((child instanceof ClassExp)) {
        ((ClassExp)child).compileMembers(comp);
      }
      child = nextSibling;
    }
    
    if (heapFrame != null) {
      comp.generateConstructor(this);
    }
  }
  
  public void generateApplyMethods(Compilation comp) {
    comp.generateMatchMethods(this);
    comp.generateApplyMethodsWithContext(this);
    comp.generateApplyMethodsWithoutContext(this);
  }
  
  Field allocFieldFor(Compilation comp) {
    if ((nameDecl != null) && (nameDecl.field != null) && (nameDecl.getValueRaw() == this))
    {
      return nameDecl.field; }
    boolean needsClosure = getNeedsClosureEnv();
    ClassType frameType = needsClosure ? getOwningLambda().getHeapFrameType() : mainClass;
    
    String name = getName();
    String fname = name == null ? "lambda" : Mangling.mangleNameIfNeeded(name);
    
    int fflags = 16;
    if ((nameDecl != null) && ((nameDecl.context instanceof ModuleExp))) {
      boolean external_access = nameDecl.needsExternalAccess();
      if (external_access)
        fname = "$Prvt$" + fname;
      if (nameDecl.getFlag(2048L)) {
        fflags |= 0x8;
        


        if (!((ModuleExp)nameDecl.context).isStatic()) {
          fflags &= 0xFFFFFFEF;
        }
      }
      

      if ((!nameDecl.isPrivate()) || (external_access) || (immediate))
        fflags |= 0x1;
      if ((flags & 0x800) != 0) {
        String fname0 = fname;
        int suffix = min_args == max_args ? min_args : 1;
        do { fname = fname0 + '$' + suffix++;
        } while (frameType.getDeclaredField(fname) != null);
      }
    } else {
      fname = fname + "$Fn" + ++localFieldIndex;
      if (!needsClosure)
        fflags |= 0x8;
    }
    Type rtype = Compilation.typeModuleMethod;
    Field field = frameType.addField(fname, rtype, fflags);
    if (nameDecl != null)
      nameDecl.field = field;
    return field;
  }
  
  final void addApplyMethod(Compilation comp, Field field) {
    LambdaExp owner = this;
    if ((field != null) && (field.getStaticFlag())) {
      owner = comp.getModule();
    }
    else
    {
      for (;;) {
        owner = owner.outerLambda();
        if (!(owner instanceof ModuleExp)) if (heapFrame != null) {
            break;
          }
      }
      ClassType frameType = owner.getHeapFrameType();
      if (!frameType.getSuperclass().isSubtype(Compilation.typeModuleBody))
        owner = comp.getModule();
    }
    if (applyMethods == null)
      applyMethods = new ArrayList();
    applyMethods.add(this);
  }
  
  public Field compileSetField(Compilation comp) {
    if (primMethods == null)
      allocMethod(outerLambda(), comp);
    Field field = allocFieldFor(comp);
    if (comp.usingCPStyle()) {
      compile(comp, Type.objectType);
    } else {
      compileAsMethod(comp);
      addApplyMethod(comp, field);
    }
    if (nameDecl != null)
      nameDecl.compileAnnotations(field, ElementType.FIELD);
    return ProcInitializerfield;
  }
  
  public void compile(Compilation comp, Target target) {
    if ((target instanceof IgnoreTarget))
      return;
    if (getInlineOnly())
    {



      QuoteExp.nullExp.compile(comp, target);
      return;
    }
    
    CodeAttr code = comp.getCode();
    































































    LambdaExp outer = outerLambda();
    Type rtype = Compilation.typeModuleMethod;
    if (((flags & 0x100) != 0) || (dumpingInitializers) || ((immediate) && ((outer instanceof ModuleExp)) && (mainClass == moduleClass)))
    {


      if (primMethods == null)
        allocMethod(outerLambda(), comp);
      compileAsMethod(comp);
      addApplyMethod(comp, null);
      Variable savedInstance = moduleInstanceVar;
      moduleInstanceVar = null;
      ProcInitializer.emitLoadModuleMethod(this, comp);
      moduleInstanceVar = savedInstance;
    } else {
      Field field = compileSetField(comp);
      if (field.getStaticFlag()) {
        code.emitGetStatic(field);
      } else {
        LambdaExp parent = curLambda;
        while ((parent.getInlineOnly()) && (heapFrame == null))
          parent = parent.outerLambda();
        Variable frame = heapFrame != null ? heapFrame : closureEnv;
        

        code.emitLoad(frame);
        code.emitGetField(field);
      }
    }
    
    target.compileFromStack(comp, rtype);
  }
  
  public ClassType getHeapFrameType() {
    if (isClassGenerated()) {
      return (ClassType)getType();
    }
    return (ClassType)heapFrame.getType();
  }
  
  public LambdaExp getOwningLambda()
  {
    ScopeExp exp = getOuter();
    for (;; exp = exp.getOuter()) {
      if (exp == null)
        return null;
      if (((exp instanceof ModuleExp)) || (((exp instanceof ClassExp)) && (getNeedsClosureEnv())) || (((exp instanceof LambdaExp)) && (heapFrame != null)))
      {


        return (LambdaExp)exp; }
    }
  }
  
  void addMethodFor(Compilation comp, ObjectType closureEnvType) {
    ScopeExp sc = this;
    while ((sc != null) && (!(sc instanceof ClassExp))) {
      sc = sc.getOuter();
    }
    ClassType ctype;
    ClassType ctype;
    if (sc != null) {
      ctype = instanceType;
    } else
      ctype = getOwningLambda().getHeapFrameType();
    addMethodFor(ctype, comp, closureEnvType);
  }
  
  void addMethodFor(ClassType ctype, Compilation comp, ObjectType closureEnvType)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 84	gnu/expr/LambdaExp:getName	()Ljava/lang/String;
    //   4: astore 4
    //   6: aload_0
    //   7: invokevirtual 29	gnu/expr/LambdaExp:outerLambda	()Lgnu/expr/LambdaExp;
    //   10: astore 5
    //   12: aload_0
    //   13: getfield 199	gnu/expr/LambdaExp:keywords	[Lgnu/expr/Keyword;
    //   16: ifnonnull +7 -> 23
    //   19: iconst_0
    //   20: goto +8 -> 28
    //   23: aload_0
    //   24: getfield 199	gnu/expr/LambdaExp:keywords	[Lgnu/expr/Keyword;
    //   27: arraylength
    //   28: istore 6
    //   30: aload_0
    //   31: getfield 16	gnu/expr/LambdaExp:flags	I
    //   34: sipush 512
    //   37: iand
    //   38: ifeq +7 -> 45
    //   41: iconst_0
    //   42: goto +7 -> 49
    //   45: aload_0
    //   46: getfield 200	gnu/expr/LambdaExp:opt_args	I
    //   49: istore 7
    //   51: aload_0
    //   52: getfield 13	gnu/expr/LambdaExp:max_args	I
    //   55: iflt +17 -> 72
    //   58: aload_0
    //   59: getfield 12	gnu/expr/LambdaExp:min_args	I
    //   62: iload 7
    //   64: iadd
    //   65: aload_0
    //   66: getfield 13	gnu/expr/LambdaExp:max_args	I
    //   69: if_icmpge +7 -> 76
    //   72: iconst_1
    //   73: goto +4 -> 77
    //   76: iconst_0
    //   77: istore 8
    //   79: iload 7
    //   81: iconst_1
    //   82: iadd
    //   83: anewarray 201	gnu/bytecode/Method
    //   86: astore 9
    //   88: aload_0
    //   89: aload 9
    //   91: putfield 59	gnu/expr/LambdaExp:primBodyMethods	[Lgnu/bytecode/Method;
    //   94: aload_0
    //   95: getfield 58	gnu/expr/LambdaExp:primMethods	[Lgnu/bytecode/Method;
    //   98: ifnonnull +9 -> 107
    //   101: aload_0
    //   102: aload 9
    //   104: putfield 58	gnu/expr/LambdaExp:primMethods	[Lgnu/bytecode/Method;
    //   107: iconst_0
    //   108: istore 11
    //   110: aload_0
    //   111: getfield 21	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   114: ifnull +22 -> 136
    //   117: aload_0
    //   118: getfield 21	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   121: ldc2_w 202
    //   124: invokevirtual 155	gnu/expr/Declaration:getFlag	(J)Z
    //   127: ifeq +9 -> 136
    //   130: iconst_0
    //   131: istore 10
    //   133: goto +190 -> 323
    //   136: aload_0
    //   137: getfield 21	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   140: ifnull +22 -> 162
    //   143: aload_0
    //   144: getfield 21	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   147: ldc2_w 153
    //   150: invokevirtual 155	gnu/expr/Declaration:getFlag	(J)Z
    //   153: ifeq +9 -> 162
    //   156: iconst_1
    //   157: istore 10
    //   159: goto +164 -> 323
    //   162: aload_0
    //   163: invokevirtual 35	gnu/expr/LambdaExp:isClassMethod	()Z
    //   166: ifeq +78 -> 244
    //   169: aload 5
    //   171: instanceof 82
    //   174: ifeq +64 -> 238
    //   177: aload 5
    //   179: checkcast 82	gnu/expr/ClassExp
    //   182: astore 12
    //   184: aload 12
    //   186: invokevirtual 204	gnu/expr/ClassExp:isMakingClassPair	()Z
    //   189: ifeq +11 -> 200
    //   192: aload_3
    //   193: ifnull +7 -> 200
    //   196: iconst_1
    //   197: goto +4 -> 201
    //   200: iconst_0
    //   201: istore 10
    //   203: aload_0
    //   204: aload 12
    //   206: getfield 205	gnu/expr/ClassExp:initMethod	Lgnu/expr/LambdaExp;
    //   209: if_acmpne +10 -> 219
    //   212: bipush 73
    //   214: istore 11
    //   216: goto +19 -> 235
    //   219: aload_0
    //   220: aload 12
    //   222: getfield 206	gnu/expr/ClassExp:clinitMethod	Lgnu/expr/LambdaExp;
    //   225: if_acmpne +10 -> 235
    //   228: bipush 67
    //   230: istore 11
    //   232: iconst_1
    //   233: istore 10
    //   235: goto +88 -> 323
    //   238: iconst_0
    //   239: istore 10
    //   241: goto +82 -> 323
    //   244: aload_0
    //   245: getfield 69	gnu/expr/LambdaExp:thisVariable	Lgnu/bytecode/Variable;
    //   248: ifnonnull +8 -> 256
    //   251: aload_3
    //   252: aload_1
    //   253: if_acmpne +9 -> 262
    //   256: iconst_0
    //   257: istore 10
    //   259: goto +64 -> 323
    //   262: aload_0
    //   263: getfield 21	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   266: ifnull +54 -> 320
    //   269: aload_0
    //   270: getfield 21	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   273: getfield 146	gnu/expr/Declaration:context	Lgnu/expr/ScopeExp;
    //   276: instanceof 27
    //   279: ifeq +41 -> 320
    //   282: aload_0
    //   283: getfield 21	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   286: getfield 146	gnu/expr/Declaration:context	Lgnu/expr/ScopeExp;
    //   289: checkcast 27	gnu/expr/ModuleExp
    //   292: astore 12
    //   294: aload 12
    //   296: invokevirtual 207	gnu/expr/ModuleExp:getSuperType	()Lgnu/bytecode/ClassType;
    //   299: ifnonnull +15 -> 314
    //   302: aload 12
    //   304: invokevirtual 208	gnu/expr/ModuleExp:getInterfaces	()[Lgnu/bytecode/ClassType;
    //   307: ifnonnull +7 -> 314
    //   310: iconst_1
    //   311: goto +4 -> 315
    //   314: iconst_0
    //   315: istore 10
    //   317: goto +6 -> 323
    //   320: iconst_1
    //   321: istore 10
    //   323: new 209	java/lang/StringBuffer
    //   326: dup
    //   327: bipush 60
    //   329: invokespecial 210	java/lang/StringBuffer:<init>	(I)V
    //   332: astore 12
    //   334: iload 10
    //   336: ifeq +8 -> 344
    //   339: bipush 8
    //   341: goto +4 -> 345
    //   344: iconst_0
    //   345: istore 13
    //   347: aload_0
    //   348: getfield 21	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   351: ifnull +64 -> 415
    //   354: aload_0
    //   355: getfield 21	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   358: invokevirtual 147	gnu/expr/Declaration:needsExternalAccess	()Z
    //   361: ifeq +12 -> 373
    //   364: iload 13
    //   366: iconst_1
    //   367: ior
    //   368: istore 13
    //   370: goto +45 -> 415
    //   373: aload_0
    //   374: getfield 21	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   377: invokevirtual 157	gnu/expr/Declaration:isPrivate	()Z
    //   380: ifeq +7 -> 387
    //   383: iconst_0
    //   384: goto +4 -> 388
    //   387: iconst_1
    //   388: istore 14
    //   390: aload_0
    //   391: invokevirtual 35	gnu/expr/LambdaExp:isClassMethod	()Z
    //   394: ifeq +14 -> 408
    //   397: aload_0
    //   398: getfield 21	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   401: iload 14
    //   403: invokevirtual 211	gnu/expr/Declaration:getAccessFlags	(S)S
    //   406: istore 14
    //   408: iload 13
    //   410: iload 14
    //   412: ior
    //   413: istore 13
    //   415: aload_0
    //   416: sipush 16384
    //   419: invokevirtual 46	gnu/expr/LambdaExp:getFlag	(I)Z
    //   422: ifeq +9 -> 431
    //   425: iload 13
    //   427: iconst_1
    //   428: ior
    //   429: istore 13
    //   431: aload 5
    //   433: invokevirtual 37	gnu/expr/LambdaExp:isModuleBody	()Z
    //   436: ifne +11 -> 447
    //   439: aload 5
    //   441: instanceof 82
    //   444: ifeq +8 -> 452
    //   447: aload 4
    //   449: ifnonnull +28 -> 477
    //   452: aload 12
    //   454: ldc -112
    //   456: invokevirtual 212	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   459: pop
    //   460: aload 12
    //   462: aload_2
    //   463: dup
    //   464: getfield 213	gnu/expr/Compilation:method_counter	I
    //   467: iconst_1
    //   468: iadd
    //   469: dup_x1
    //   470: putfield 213	gnu/expr/Compilation:method_counter	I
    //   473: invokevirtual 214	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   476: pop
    //   477: iload 11
    //   479: bipush 67
    //   481: if_icmpne +14 -> 495
    //   484: aload 12
    //   486: ldc -41
    //   488: invokevirtual 212	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   491: pop
    //   492: goto +21 -> 513
    //   495: aload_0
    //   496: invokevirtual 216	gnu/expr/LambdaExp:getSymbol	()Ljava/lang/Object;
    //   499: ifnull +14 -> 513
    //   502: aload 12
    //   504: aload 4
    //   506: invokestatic 217	gnu/expr/Mangling:mangleName	(Ljava/lang/String;)Ljava/lang/String;
    //   509: invokevirtual 212	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   512: pop
    //   513: aload_0
    //   514: sipush 1024
    //   517: invokevirtual 46	gnu/expr/LambdaExp:getFlag	(I)Z
    //   520: ifeq +11 -> 531
    //   523: aload 12
    //   525: ldc -38
    //   527: invokevirtual 212	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   530: pop
    //   531: aload_0
    //   532: invokevirtual 38	gnu/expr/LambdaExp:getCallConvention	()I
    //   535: iconst_2
    //   536: if_icmplt +12 -> 548
    //   539: iload 11
    //   541: ifne +7 -> 548
    //   544: iconst_1
    //   545: goto +4 -> 549
    //   548: iconst_0
    //   549: istore 14
    //   551: iload 11
    //   553: ifeq +28 -> 581
    //   556: iload 10
    //   558: ifeq +15 -> 573
    //   561: iload 13
    //   563: bipush -3
    //   565: iand
    //   566: iconst_1
    //   567: iadd
    //   568: istore 13
    //   570: goto +11 -> 581
    //   573: iload 13
    //   575: iconst_2
    //   576: iand
    //   577: iconst_2
    //   578: iadd
    //   579: istore 13
    //   581: aload_1
    //   582: invokevirtual 219	gnu/bytecode/ClassType:isInterface	()Z
    //   585: ifne +10 -> 595
    //   588: aload_0
    //   589: invokevirtual 220	gnu/expr/LambdaExp:isAbstract	()Z
    //   592: ifeq +11 -> 603
    //   595: iload 13
    //   597: sipush 1024
    //   600: ior
    //   601: istore 13
    //   603: aload_0
    //   604: invokevirtual 221	gnu/expr/LambdaExp:isNative	()Z
    //   607: ifeq +11 -> 618
    //   610: iload 13
    //   612: sipush 256
    //   615: ior
    //   616: istore 13
    //   618: aload_0
    //   619: invokevirtual 35	gnu/expr/LambdaExp:isClassMethod	()Z
    //   622: ifeq +233 -> 855
    //   625: aload 5
    //   627: instanceof 82
    //   630: ifeq +225 -> 855
    //   633: aload_0
    //   634: getfield 12	gnu/expr/LambdaExp:min_args	I
    //   637: aload_0
    //   638: getfield 13	gnu/expr/LambdaExp:max_args	I
    //   641: if_icmpne +214 -> 855
    //   644: aconst_null
    //   645: astore 15
    //   647: iconst_0
    //   648: istore 16
    //   650: aload_0
    //   651: invokevirtual 105	gnu/expr/LambdaExp:firstDecl	()Lgnu/expr/Declaration;
    //   654: astore 17
    //   656: aload 17
    //   658: ifnonnull +13 -> 671
    //   661: aload_0
    //   662: getfield 222	gnu/expr/LambdaExp:returnType	Lgnu/bytecode/Type;
    //   665: ifnull +34 -> 699
    //   668: goto +187 -> 855
    //   671: aload 17
    //   673: invokevirtual 77	gnu/expr/Declaration:isThisParameter	()Z
    //   676: ifeq +9 -> 685
    //   679: iinc 16 -1
    //   682: goto +160 -> 842
    //   685: aload 17
    //   687: ldc2_w 223
    //   690: invokevirtual 155	gnu/expr/Declaration:getFlag	(J)Z
    //   693: ifeq +6 -> 699
    //   696: goto +146 -> 842
    //   699: aload 15
    //   701: ifnonnull +31 -> 732
    //   704: aload 12
    //   706: invokevirtual 225	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   709: astore 18
    //   711: new 226	gnu/expr/LambdaExp$1
    //   714: dup
    //   715: aload_0
    //   716: aload 18
    //   718: invokespecial 227	gnu/expr/LambdaExp$1:<init>	(Lgnu/expr/LambdaExp;Ljava/lang/String;)V
    //   721: astore 19
    //   723: aload_1
    //   724: aload 19
    //   726: iconst_2
    //   727: invokevirtual 228	gnu/bytecode/ClassType:getMethods	(Lgnu/bytecode/Filter;I)[Lgnu/bytecode/Method;
    //   730: astore 15
    //   732: aconst_null
    //   733: astore 18
    //   735: aload 15
    //   737: arraylength
    //   738: istore 19
    //   740: iinc 19 -1
    //   743: iload 19
    //   745: iflt +63 -> 808
    //   748: aload 15
    //   750: iload 19
    //   752: aaload
    //   753: astore 20
    //   755: aload 17
    //   757: ifnonnull +11 -> 768
    //   760: aload 20
    //   762: invokevirtual 229	gnu/bytecode/Method:getReturnType	()Lgnu/bytecode/Type;
    //   765: goto +11 -> 776
    //   768: aload 20
    //   770: invokevirtual 61	gnu/bytecode/Method:getParameterTypes	()[Lgnu/bytecode/Type;
    //   773: iload 16
    //   775: aaload
    //   776: astore 21
    //   778: aload 18
    //   780: ifnonnull +10 -> 790
    //   783: aload 21
    //   785: astore 18
    //   787: goto +18 -> 805
    //   790: aload 21
    //   792: aload 18
    //   794: if_acmpeq +11 -> 805
    //   797: aload 17
    //   799: ifnonnull +43 -> 842
    //   802: goto +53 -> 855
    //   805: goto -65 -> 740
    //   808: aload 18
    //   810: ifnull +24 -> 834
    //   813: aload 17
    //   815: ifnull +13 -> 828
    //   818: aload 17
    //   820: aload 18
    //   822: invokevirtual 230	gnu/expr/Declaration:setType	(Lgnu/bytecode/Type;)V
    //   825: goto +9 -> 834
    //   828: aload_0
    //   829: aload 18
    //   831: invokevirtual 231	gnu/expr/LambdaExp:setCoercedReturnType	(Lgnu/bytecode/Type;)V
    //   834: aload 17
    //   836: ifnonnull +6 -> 842
    //   839: goto +16 -> 855
    //   842: aload 17
    //   844: invokevirtual 107	gnu/expr/Declaration:nextDecl	()Lgnu/expr/Declaration;
    //   847: astore 17
    //   849: iinc 16 1
    //   852: goto -196 -> 656
    //   855: aload_0
    //   856: sipush 1024
    //   859: invokevirtual 46	gnu/expr/LambdaExp:getFlag	(I)Z
    //   862: ifne +11 -> 873
    //   865: aload_0
    //   866: invokevirtual 38	gnu/expr/LambdaExp:getCallConvention	()I
    //   869: iconst_2
    //   870: if_icmplt +9 -> 879
    //   873: getstatic 232	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   876: goto +13 -> 889
    //   879: aload_0
    //   880: invokevirtual 233	gnu/expr/LambdaExp:getReturnType	()Lgnu/bytecode/Type;
    //   883: invokevirtual 234	gnu/bytecode/Type:promoteIfUnsigned	()Lgnu/bytecode/Type;
    //   886: invokevirtual 235	gnu/bytecode/Type:getImplementationType	()Lgnu/bytecode/Type;
    //   889: astore 15
    //   891: aload_3
    //   892: ifnull +12 -> 904
    //   895: aload_3
    //   896: aload_1
    //   897: if_acmpeq +7 -> 904
    //   900: iconst_1
    //   901: goto +4 -> 905
    //   904: iconst_0
    //   905: istore 16
    //   907: aload_2
    //   908: invokevirtual 236	gnu/expr/Compilation:getLanguage	()Lgnu/expr/Language;
    //   911: aload_0
    //   912: invokevirtual 233	gnu/expr/LambdaExp:getReturnType	()Lgnu/bytecode/Type;
    //   915: invokevirtual 237	gnu/expr/Language:encodeType	(Lgnu/bytecode/Type;)Ljava/lang/String;
    //   918: astore 17
    //   920: iconst_0
    //   921: istore 18
    //   923: aload_0
    //   924: invokevirtual 38	gnu/expr/LambdaExp:getCallConvention	()I
    //   927: iconst_2
    //   928: if_icmplt +11 -> 939
    //   931: iload 11
    //   933: ifne +6 -> 939
    //   936: iconst_1
    //   937: istore 18
    //   939: aload 12
    //   941: invokevirtual 238	java/lang/StringBuffer:length	()I
    //   944: istore 19
    //   946: iconst_0
    //   947: istore 20
    //   949: iload 20
    //   951: iload 7
    //   953: if_icmpgt +1018 -> 1971
    //   956: aload 12
    //   958: iload 19
    //   960: invokevirtual 239	java/lang/StringBuffer:setLength	(I)V
    //   963: aload_0
    //   964: getfield 12	gnu/expr/LambdaExp:min_args	I
    //   967: iload 20
    //   969: iadd
    //   970: istore 21
    //   972: iload 21
    //   974: istore 22
    //   976: iload 20
    //   978: iload 7
    //   980: if_icmpne +11 -> 991
    //   983: iload 8
    //   985: ifeq +6 -> 991
    //   988: iinc 22 1
    //   991: iload 16
    //   993: iload 22
    //   995: iadd
    //   996: iload 18
    //   998: iadd
    //   999: anewarray 240	gnu/bytecode/Type
    //   1002: astore 23
    //   1004: iload 16
    //   1006: ifle +8 -> 1014
    //   1009: aload 23
    //   1011: iconst_0
    //   1012: aload_3
    //   1013: aastore
    //   1014: new 241	java/util/Stack
    //   1017: dup
    //   1018: invokespecial 242	java/util/Stack:<init>	()V
    //   1021: astore 24
    //   1023: aload 17
    //   1025: ifnonnull +7 -> 1032
    //   1028: iconst_0
    //   1029: goto +4 -> 1033
    //   1032: iconst_1
    //   1033: istore 25
    //   1035: aload 24
    //   1037: iload 25
    //   1039: ifne +8 -> 1047
    //   1042: ldc -13
    //   1044: goto +5 -> 1049
    //   1047: aload 17
    //   1049: invokevirtual 244	java/util/Stack:add	(Ljava/lang/Object;)Z
    //   1052: pop
    //   1053: aload_0
    //   1054: invokevirtual 105	gnu/expr/LambdaExp:firstDecl	()Lgnu/expr/Declaration;
    //   1057: astore 26
    //   1059: aload 26
    //   1061: ifnull +18 -> 1079
    //   1064: aload 26
    //   1066: invokevirtual 77	gnu/expr/Declaration:isThisParameter	()Z
    //   1069: ifeq +10 -> 1079
    //   1072: aload 26
    //   1074: invokevirtual 107	gnu/expr/Declaration:nextDecl	()Lgnu/expr/Declaration;
    //   1077: astore 26
    //   1079: iconst_0
    //   1080: istore 27
    //   1082: iload 27
    //   1084: iload 21
    //   1086: if_icmpge +78 -> 1164
    //   1089: aload 23
    //   1091: iload 16
    //   1093: iload 27
    //   1095: iinc 27 1
    //   1098: iadd
    //   1099: aload 26
    //   1101: invokevirtual 245	gnu/expr/Declaration:getType	()Lgnu/bytecode/Type;
    //   1104: invokevirtual 234	gnu/bytecode/Type:promoteIfUnsigned	()Lgnu/bytecode/Type;
    //   1107: invokevirtual 235	gnu/bytecode/Type:getImplementationType	()Lgnu/bytecode/Type;
    //   1110: aastore
    //   1111: aload_2
    //   1112: invokevirtual 236	gnu/expr/Compilation:getLanguage	()Lgnu/expr/Language;
    //   1115: aload 26
    //   1117: invokevirtual 245	gnu/expr/Declaration:getType	()Lgnu/bytecode/Type;
    //   1120: invokevirtual 237	gnu/expr/Language:encodeType	(Lgnu/bytecode/Type;)Ljava/lang/String;
    //   1123: astore 28
    //   1125: aload 28
    //   1127: ifnonnull +10 -> 1137
    //   1130: ldc -13
    //   1132: astore 28
    //   1134: goto +12 -> 1146
    //   1137: aload 24
    //   1139: invokevirtual 246	java/util/Stack:size	()I
    //   1142: iconst_1
    //   1143: iadd
    //   1144: istore 25
    //   1146: aload 24
    //   1148: aload 28
    //   1150: invokevirtual 244	java/util/Stack:add	(Ljava/lang/Object;)Z
    //   1153: pop
    //   1154: aload 26
    //   1156: invokevirtual 107	gnu/expr/Declaration:nextDecl	()Lgnu/expr/Declaration;
    //   1159: astore 26
    //   1161: goto -79 -> 1082
    //   1164: iload 18
    //   1166: ifeq +14 -> 1180
    //   1169: aload 23
    //   1171: aload 23
    //   1173: arraylength
    //   1174: iconst_1
    //   1175: isub
    //   1176: getstatic 247	gnu/expr/Compilation:typeCallContext	Lgnu/bytecode/ClassType;
    //   1179: aastore
    //   1180: iload 21
    //   1182: iload 22
    //   1184: if_icmpge +182 -> 1366
    //   1187: aload 26
    //   1189: invokevirtual 245	gnu/expr/Declaration:getType	()Lgnu/bytecode/Type;
    //   1192: astore 27
    //   1194: aload 27
    //   1196: invokevirtual 248	gnu/bytecode/Type:getName	()Ljava/lang/String;
    //   1199: astore 28
    //   1201: aload_1
    //   1202: invokevirtual 249	gnu/bytecode/ClassType:getClassfileVersion	()I
    //   1205: ldc -6
    //   1207: if_icmplt +22 -> 1229
    //   1210: aload 27
    //   1212: instanceof 251
    //   1215: ifeq +14 -> 1229
    //   1218: iload 13
    //   1220: sipush 128
    //   1223: ior
    //   1224: istore 13
    //   1226: goto +11 -> 1237
    //   1229: aload 12
    //   1231: ldc -4
    //   1233: invokevirtual 212	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1236: pop
    //   1237: aload_2
    //   1238: invokevirtual 236	gnu/expr/Compilation:getLanguage	()Lgnu/expr/Language;
    //   1241: aload 26
    //   1243: invokevirtual 245	gnu/expr/Declaration:getType	()Lgnu/bytecode/Type;
    //   1246: invokevirtual 237	gnu/expr/Language:encodeType	(Lgnu/bytecode/Type;)Ljava/lang/String;
    //   1249: astore 29
    //   1251: aload 29
    //   1253: ifnonnull +10 -> 1263
    //   1256: ldc -13
    //   1258: astore 29
    //   1260: goto +12 -> 1272
    //   1263: aload 24
    //   1265: invokevirtual 246	java/util/Stack:size	()I
    //   1268: iconst_1
    //   1269: iadd
    //   1270: istore 25
    //   1272: aload 24
    //   1274: aload 29
    //   1276: invokevirtual 244	java/util/Stack:add	(Ljava/lang/Object;)Z
    //   1279: pop
    //   1280: iload 6
    //   1282: ifgt +30 -> 1312
    //   1285: iload 7
    //   1287: aload_0
    //   1288: getfield 200	gnu/expr/LambdaExp:opt_args	I
    //   1291: if_icmplt +21 -> 1312
    //   1294: ldc -3
    //   1296: aload 28
    //   1298: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1301: ifne +40 -> 1341
    //   1304: aload 27
    //   1306: instanceof 251
    //   1309: ifne +32 -> 1341
    //   1312: getstatic 254	gnu/expr/Compilation:objArrayType	Lgnu/bytecode/ArrayType;
    //   1315: astore 27
    //   1317: aload_0
    //   1318: new 5	gnu/bytecode/Variable
    //   1321: dup
    //   1322: ldc -1
    //   1324: getstatic 254	gnu/expr/Compilation:objArrayType	Lgnu/bytecode/ArrayType;
    //   1327: invokespecial 92	gnu/bytecode/Variable:<init>	(Ljava/lang/String;Lgnu/bytecode/Type;)V
    //   1330: putfield 256	gnu/expr/LambdaExp:argsArray	Lgnu/bytecode/Variable;
    //   1333: aload_0
    //   1334: getfield 256	gnu/expr/LambdaExp:argsArray	Lgnu/bytecode/Variable;
    //   1337: iconst_1
    //   1338: invokevirtual 73	gnu/bytecode/Variable:setParameter	(Z)V
    //   1341: aload_0
    //   1342: aload 26
    //   1344: putfield 257	gnu/expr/LambdaExp:firstArgsArrayArg	Lgnu/expr/Declaration;
    //   1347: aload 23
    //   1349: aload 23
    //   1351: arraylength
    //   1352: iload 14
    //   1354: ifeq +7 -> 1361
    //   1357: iconst_2
    //   1358: goto +4 -> 1362
    //   1361: iconst_1
    //   1362: isub
    //   1363: aload 27
    //   1365: aastore
    //   1366: iload 14
    //   1368: ifeq +11 -> 1379
    //   1371: aload 12
    //   1373: ldc 63
    //   1375: invokevirtual 212	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1378: pop
    //   1379: aload 5
    //   1381: instanceof 82
    //   1384: ifne +25 -> 1409
    //   1387: aload 5
    //   1389: instanceof 27
    //   1392: ifeq +21 -> 1413
    //   1395: aload 5
    //   1397: checkcast 27	gnu/expr/ModuleExp
    //   1400: ldc_w 258
    //   1403: invokevirtual 259	gnu/expr/ModuleExp:getFlag	(I)Z
    //   1406: ifeq +7 -> 1413
    //   1409: iconst_1
    //   1410: goto +4 -> 1414
    //   1413: iconst_0
    //   1414: istore 27
    //   1416: aload 12
    //   1418: invokevirtual 225	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1421: astore 4
    //   1423: iconst_0
    //   1424: istore 28
    //   1426: aload 12
    //   1428: invokevirtual 238	java/lang/StringBuffer:length	()I
    //   1431: istore 29
    //   1433: aload 12
    //   1435: iload 19
    //   1437: iload 29
    //   1439: invokevirtual 260	java/lang/StringBuffer:substring	(II)Ljava/lang/String;
    //   1442: astore 30
    //   1444: aload_1
    //   1445: astore 31
    //   1447: aload 31
    //   1449: ifnull +77 -> 1526
    //   1452: aload 31
    //   1454: aload 4
    //   1456: aload 23
    //   1458: invokevirtual 261	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;[Lgnu/bytecode/Type;)Lgnu/bytecode/Method;
    //   1461: ifnull +47 -> 1508
    //   1464: aload 12
    //   1466: iload 19
    //   1468: invokevirtual 239	java/lang/StringBuffer:setLength	(I)V
    //   1471: aload 12
    //   1473: bipush 36
    //   1475: invokevirtual 262	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   1478: pop
    //   1479: aload 12
    //   1481: iinc 28 1
    //   1484: iload 28
    //   1486: invokevirtual 214	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   1489: pop
    //   1490: aload 12
    //   1492: aload 30
    //   1494: invokevirtual 212	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1497: pop
    //   1498: aload 12
    //   1500: invokevirtual 225	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1503: astore 4
    //   1505: goto -61 -> 1444
    //   1508: iload 27
    //   1510: ifeq +6 -> 1516
    //   1513: goto +13 -> 1526
    //   1516: aload 31
    //   1518: invokevirtual 168	gnu/bytecode/ClassType:getSuperclass	()Lgnu/bytecode/ClassType;
    //   1521: astore 31
    //   1523: goto -76 -> 1447
    //   1526: goto +3 -> 1529
    //   1529: aload_1
    //   1530: aload 4
    //   1532: aload 23
    //   1534: aload 15
    //   1536: iload 13
    //   1538: invokevirtual 263	gnu/bytecode/ClassType:addMethod	(Ljava/lang/String;[Lgnu/bytecode/Type;Lgnu/bytecode/Type;I)Lgnu/bytecode/Method;
    //   1541: astore 31
    //   1543: iload 25
    //   1545: ifle +80 -> 1625
    //   1548: aload_0
    //   1549: getfield 21	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   1552: ifnull +16 -> 1568
    //   1555: aload_0
    //   1556: getfield 21	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   1559: ldc_w 264
    //   1562: invokevirtual 265	gnu/expr/Declaration:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   1565: ifnonnull +60 -> 1625
    //   1568: new 266	gnu/bytecode/AnnotationEntry
    //   1571: dup
    //   1572: ldc_w 267
    //   1575: invokestatic 268	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   1578: invokespecial 269	gnu/bytecode/AnnotationEntry:<init>	(Lgnu/bytecode/ClassType;)V
    //   1581: astore 32
    //   1583: aload 24
    //   1585: invokevirtual 246	java/util/Stack:size	()I
    //   1588: iload 25
    //   1590: if_icmple +12 -> 1602
    //   1593: aload 24
    //   1595: invokevirtual 270	java/util/Stack:pop	()Ljava/lang/Object;
    //   1598: pop
    //   1599: goto -16 -> 1583
    //   1602: aload 32
    //   1604: ldc_w 271
    //   1607: aload 24
    //   1609: getstatic 272	gnu/bytecode/Type:javalangStringType	Lgnu/bytecode/ClassType;
    //   1612: invokestatic 273	gnu/bytecode/ArrayType:make	(Lgnu/bytecode/Type;)Lgnu/bytecode/ArrayType;
    //   1615: invokevirtual 274	gnu/bytecode/AnnotationEntry:addMember	(Ljava/lang/String;Ljava/lang/Object;Lgnu/bytecode/Type;)V
    //   1618: aload 31
    //   1620: aload 32
    //   1622: invokestatic 275	gnu/bytecode/RuntimeAnnotationsAttr:maybeAddAnnotation	(Lgnu/bytecode/AttrContainer;Lgnu/bytecode/AnnotationEntry;)V
    //   1625: aload 9
    //   1627: iload 20
    //   1629: aload 31
    //   1631: aastore
    //   1632: aload_0
    //   1633: getfield 15	gnu/expr/LambdaExp:throwsSpecification	[Lgnu/expr/Expression;
    //   1636: ifnull +329 -> 1965
    //   1639: aload_0
    //   1640: getfield 15	gnu/expr/LambdaExp:throwsSpecification	[Lgnu/expr/Expression;
    //   1643: arraylength
    //   1644: ifle +321 -> 1965
    //   1647: aload_0
    //   1648: getfield 15	gnu/expr/LambdaExp:throwsSpecification	[Lgnu/expr/Expression;
    //   1651: arraylength
    //   1652: istore 32
    //   1654: iload 32
    //   1656: anewarray 98	gnu/bytecode/ClassType
    //   1659: astore 33
    //   1661: iconst_0
    //   1662: istore 34
    //   1664: iload 34
    //   1666: iload 32
    //   1668: if_icmpge +279 -> 1947
    //   1671: aconst_null
    //   1672: astore 35
    //   1674: aload_0
    //   1675: getfield 15	gnu/expr/LambdaExp:throwsSpecification	[Lgnu/expr/Expression;
    //   1678: iload 34
    //   1680: aaload
    //   1681: astore 36
    //   1683: aconst_null
    //   1684: astore 37
    //   1686: aload 36
    //   1688: instanceof 276
    //   1691: ifeq +115 -> 1806
    //   1694: aload 36
    //   1696: checkcast 276	gnu/expr/ReferenceExp
    //   1699: astore 38
    //   1701: aload 38
    //   1703: invokevirtual 277	gnu/expr/ReferenceExp:getBinding	()Lgnu/expr/Declaration;
    //   1706: astore 39
    //   1708: aload 39
    //   1710: ifnull +67 -> 1777
    //   1713: aload 39
    //   1715: invokevirtual 278	gnu/expr/Declaration:getValue	()Lgnu/expr/Expression;
    //   1718: astore 40
    //   1720: aload 40
    //   1722: instanceof 82
    //   1725: ifeq +17 -> 1742
    //   1728: aload 40
    //   1730: checkcast 82	gnu/expr/ClassExp
    //   1733: aload_2
    //   1734: invokevirtual 279	gnu/expr/ClassExp:getCompiledClassType	(Lgnu/expr/Compilation;)Lgnu/bytecode/ClassType;
    //   1737: astore 35
    //   1739: goto +35 -> 1774
    //   1742: new 148	java/lang/StringBuilder
    //   1745: dup
    //   1746: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   1749: ldc_w 280
    //   1752: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1755: aload 39
    //   1757: invokevirtual 281	gnu/expr/Declaration:getName	()Ljava/lang/String;
    //   1760: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: ldc_w 282
    //   1766: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1769: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1772: astore 37
    //   1774: goto +29 -> 1803
    //   1777: new 148	java/lang/StringBuilder
    //   1780: dup
    //   1781: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   1784: ldc_w 283
    //   1787: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: aload 38
    //   1792: invokevirtual 284	gnu/expr/ReferenceExp:getName	()Ljava/lang/String;
    //   1795: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1798: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1801: astore 37
    //   1803: goto +96 -> 1899
    //   1806: aload 36
    //   1808: instanceof 285
    //   1811: ifeq +88 -> 1899
    //   1814: aload 36
    //   1816: checkcast 285	gnu/expr/QuoteExp
    //   1819: invokevirtual 286	gnu/expr/QuoteExp:getValue	()Ljava/lang/Object;
    //   1822: astore 38
    //   1824: aload 38
    //   1826: instanceof 287
    //   1829: ifeq +13 -> 1842
    //   1832: aload 38
    //   1834: checkcast 287	java/lang/Class
    //   1837: invokestatic 288	gnu/bytecode/Type:make	(Ljava/lang/Class;)Lgnu/bytecode/Type;
    //   1840: astore 38
    //   1842: aload 38
    //   1844: instanceof 98
    //   1847: ifeq +10 -> 1857
    //   1850: aload 38
    //   1852: checkcast 98	gnu/bytecode/ClassType
    //   1855: astore 35
    //   1857: aload 35
    //   1859: ifnull +40 -> 1899
    //   1862: aload 35
    //   1864: getstatic 289	gnu/bytecode/Type:javalangThrowableType	Lgnu/bytecode/ClassType;
    //   1867: invokevirtual 170	gnu/bytecode/ClassType:isSubtype	(Lgnu/bytecode/Type;)Z
    //   1870: ifne +29 -> 1899
    //   1873: new 148	java/lang/StringBuilder
    //   1876: dup
    //   1877: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   1880: aload 35
    //   1882: invokevirtual 290	gnu/bytecode/ClassType:getName	()Ljava/lang/String;
    //   1885: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1888: ldc_w 291
    //   1891: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1894: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1897: astore 37
    //   1899: aload 35
    //   1901: ifnonnull +13 -> 1914
    //   1904: aload 37
    //   1906: ifnonnull +8 -> 1914
    //   1909: ldc_w 292
    //   1912: astore 37
    //   1914: aload 37
    //   1916: ifnull +18 -> 1934
    //   1919: aload_2
    //   1920: bipush 101
    //   1922: aload 37
    //   1924: aload 36
    //   1926: invokevirtual 293	gnu/expr/Compilation:error	(CLjava/lang/String;Lgnu/text/SourceLocator;)V
    //   1929: getstatic 289	gnu/bytecode/Type:javalangThrowableType	Lgnu/bytecode/ClassType;
    //   1932: astore 35
    //   1934: aload 33
    //   1936: iload 34
    //   1938: aload 35
    //   1940: aastore
    //   1941: iinc 34 1
    //   1944: goto -280 -> 1664
    //   1947: new 294	gnu/bytecode/ExceptionsAttr
    //   1950: dup
    //   1951: aload 31
    //   1953: invokespecial 295	gnu/bytecode/ExceptionsAttr:<init>	(Lgnu/bytecode/Method;)V
    //   1956: astore 34
    //   1958: aload 34
    //   1960: aload 33
    //   1962: invokevirtual 296	gnu/bytecode/ExceptionsAttr:setExceptions	([Lgnu/bytecode/ClassType;)V
    //   1965: iinc 20 1
    //   1968: goto -1019 -> 949
    //   1971: return
    // Line number table:
    //   Java source line #862	-> byte code offset #0
    //   Java source line #863	-> byte code offset #6
    //   Java source line #865	-> byte code offset #12
    //   Java source line #866	-> byte code offset #30
    //   Java source line #868	-> byte code offset #51
    //   Java source line #870	-> byte code offset #79
    //   Java source line #874	-> byte code offset #88
    //   Java source line #875	-> byte code offset #94
    //   Java source line #876	-> byte code offset #101
    //   Java source line #880	-> byte code offset #107
    //   Java source line #881	-> byte code offset #110
    //   Java source line #883	-> byte code offset #130
    //   Java source line #884	-> byte code offset #136
    //   Java source line #886	-> byte code offset #156
    //   Java source line #887	-> byte code offset #162
    //   Java source line #888	-> byte code offset #169
    //   Java source line #889	-> byte code offset #177
    //   Java source line #890	-> byte code offset #184
    //   Java source line #891	-> byte code offset #203
    //   Java source line #892	-> byte code offset #212
    //   Java source line #893	-> byte code offset #219
    //   Java source line #894	-> byte code offset #228
    //   Java source line #895	-> byte code offset #232
    //   Java source line #897	-> byte code offset #235
    //   Java source line #898	-> byte code offset #238
    //   Java source line #899	-> byte code offset #244
    //   Java source line #900	-> byte code offset #256
    //   Java source line #901	-> byte code offset #262
    //   Java source line #902	-> byte code offset #282
    //   Java source line #903	-> byte code offset #294
    //   Java source line #904	-> byte code offset #317
    //   Java source line #905	-> byte code offset #320
    //   Java source line #907	-> byte code offset #323
    //   Java source line #908	-> byte code offset #334
    //   Java source line #909	-> byte code offset #347
    //   Java source line #910	-> byte code offset #354
    //   Java source line #911	-> byte code offset #364
    //   Java source line #913	-> byte code offset #373
    //   Java source line #914	-> byte code offset #390
    //   Java source line #915	-> byte code offset #397
    //   Java source line #916	-> byte code offset #408
    //   Java source line #919	-> byte code offset #415
    //   Java source line #920	-> byte code offset #425
    //   Java source line #921	-> byte code offset #431
    //   Java source line #923	-> byte code offset #452
    //   Java source line #924	-> byte code offset #460
    //   Java source line #926	-> byte code offset #477
    //   Java source line #927	-> byte code offset #484
    //   Java source line #928	-> byte code offset #495
    //   Java source line #929	-> byte code offset #502
    //   Java source line #930	-> byte code offset #513
    //   Java source line #931	-> byte code offset #523
    //   Java source line #932	-> byte code offset #531
    //   Java source line #935	-> byte code offset #551
    //   Java source line #936	-> byte code offset #556
    //   Java source line #940	-> byte code offset #561
    //   Java source line #945	-> byte code offset #573
    //   Java source line #948	-> byte code offset #581
    //   Java source line #949	-> byte code offset #595
    //   Java source line #950	-> byte code offset #603
    //   Java source line #951	-> byte code offset #610
    //   Java source line #955	-> byte code offset #618
    //   Java source line #957	-> byte code offset #644
    //   Java source line #958	-> byte code offset #647
    //   Java source line #960	-> byte code offset #650
    //   Java source line #962	-> byte code offset #656
    //   Java source line #963	-> byte code offset #661
    //   Java source line #964	-> byte code offset #668
    //   Java source line #965	-> byte code offset #671
    //   Java source line #966	-> byte code offset #679
    //   Java source line #967	-> byte code offset #682
    //   Java source line #968	-> byte code offset #685
    //   Java source line #969	-> byte code offset #696
    //   Java source line #970	-> byte code offset #699
    //   Java source line #971	-> byte code offset #704
    //   Java source line #972	-> byte code offset #711
    //   Java source line #982	-> byte code offset #723
    //   Java source line #984	-> byte code offset #732
    //   Java source line #985	-> byte code offset #735
    //   Java source line #986	-> byte code offset #748
    //   Java source line #987	-> byte code offset #755
    //   Java source line #989	-> byte code offset #778
    //   Java source line #990	-> byte code offset #783
    //   Java source line #991	-> byte code offset #790
    //   Java source line #993	-> byte code offset #797
    //   Java source line #994	-> byte code offset #802
    //   Java source line #998	-> byte code offset #805
    //   Java source line #999	-> byte code offset #808
    //   Java source line #1000	-> byte code offset #813
    //   Java source line #1001	-> byte code offset #818
    //   Java source line #1003	-> byte code offset #828
    //   Java source line #1005	-> byte code offset #834
    //   Java source line #1006	-> byte code offset #839
    //   Java source line #961	-> byte code offset #842
    //   Java source line #1010	-> byte code offset #855
    //   Java source line #1015	-> byte code offset #891
    //   Java source line #1017	-> byte code offset #907
    //   Java source line #1019	-> byte code offset #920
    //   Java source line #1020	-> byte code offset #923
    //   Java source line #1022	-> byte code offset #936
    //   Java source line #1024	-> byte code offset #939
    //   Java source line #1025	-> byte code offset #946
    //   Java source line #1026	-> byte code offset #956
    //   Java source line #1027	-> byte code offset #963
    //   Java source line #1028	-> byte code offset #972
    //   Java source line #1029	-> byte code offset #976
    //   Java source line #1030	-> byte code offset #988
    //   Java source line #1031	-> byte code offset #991
    //   Java source line #1032	-> byte code offset #1004
    //   Java source line #1033	-> byte code offset #1009
    //   Java source line #1034	-> byte code offset #1014
    //   Java source line #1035	-> byte code offset #1023
    //   Java source line #1036	-> byte code offset #1035
    //   Java source line #1037	-> byte code offset #1053
    //   Java source line #1038	-> byte code offset #1059
    //   Java source line #1039	-> byte code offset #1072
    //   Java source line #1040	-> byte code offset #1079
    //   Java source line #1041	-> byte code offset #1089
    //   Java source line #1043	-> byte code offset #1111
    //   Java source line #1044	-> byte code offset #1125
    //   Java source line #1045	-> byte code offset #1130
    //   Java source line #1047	-> byte code offset #1137
    //   Java source line #1048	-> byte code offset #1146
    //   Java source line #1040	-> byte code offset #1154
    //   Java source line #1050	-> byte code offset #1164
    //   Java source line #1051	-> byte code offset #1169
    //   Java source line #1052	-> byte code offset #1180
    //   Java source line #1053	-> byte code offset #1187
    //   Java source line #1054	-> byte code offset #1194
    //   Java source line #1055	-> byte code offset #1201
    //   Java source line #1057	-> byte code offset #1218
    //   Java source line #1059	-> byte code offset #1229
    //   Java source line #1060	-> byte code offset #1237
    //   Java source line #1061	-> byte code offset #1251
    //   Java source line #1062	-> byte code offset #1256
    //   Java source line #1064	-> byte code offset #1263
    //   Java source line #1065	-> byte code offset #1272
    //   Java source line #1067	-> byte code offset #1280
    //   Java source line #1075	-> byte code offset #1312
    //   Java source line #1076	-> byte code offset #1317
    //   Java source line #1078	-> byte code offset #1333
    //   Java source line #1080	-> byte code offset #1341
    //   Java source line #1081	-> byte code offset #1347
    //   Java source line #1083	-> byte code offset #1366
    //   Java source line #1084	-> byte code offset #1371
    //   Java source line #1086	-> byte code offset #1379
    //   Java source line #1091	-> byte code offset #1416
    //   Java source line #1098	-> byte code offset #1423
    //   Java source line #1099	-> byte code offset #1426
    //   Java source line #1100	-> byte code offset #1433
    //   Java source line #1103	-> byte code offset #1444
    //   Java source line #1104	-> byte code offset #1452
    //   Java source line #1105	-> byte code offset #1464
    //   Java source line #1106	-> byte code offset #1471
    //   Java source line #1107	-> byte code offset #1479
    //   Java source line #1108	-> byte code offset #1490
    //   Java source line #1109	-> byte code offset #1498
    //   Java source line #1110	-> byte code offset #1505
    //   Java source line #1112	-> byte code offset #1508
    //   Java source line #1114	-> byte code offset #1513
    //   Java source line #1103	-> byte code offset #1516
    //   Java source line #1116	-> byte code offset #1526
    //   Java source line #1119	-> byte code offset #1529
    //   Java source line #1122	-> byte code offset #1543
    //   Java source line #1125	-> byte code offset #1568
    //   Java source line #1127	-> byte code offset #1583
    //   Java source line #1128	-> byte code offset #1593
    //   Java source line #1129	-> byte code offset #1602
    //   Java source line #1131	-> byte code offset #1618
    //   Java source line #1134	-> byte code offset #1625
    //   Java source line #1136	-> byte code offset #1632
    //   Java source line #1137	-> byte code offset #1647
    //   Java source line #1138	-> byte code offset #1654
    //   Java source line #1139	-> byte code offset #1661
    //   Java source line #1140	-> byte code offset #1671
    //   Java source line #1141	-> byte code offset #1674
    //   Java source line #1142	-> byte code offset #1683
    //   Java source line #1143	-> byte code offset #1686
    //   Java source line #1144	-> byte code offset #1694
    //   Java source line #1145	-> byte code offset #1701
    //   Java source line #1146	-> byte code offset #1708
    //   Java source line #1147	-> byte code offset #1713
    //   Java source line #1148	-> byte code offset #1720
    //   Java source line #1149	-> byte code offset #1728
    //   Java source line #1152	-> byte code offset #1742
    //   Java source line #1154	-> byte code offset #1774
    //   Java source line #1156	-> byte code offset #1777
    //   Java source line #1157	-> byte code offset #1803
    //   Java source line #1158	-> byte code offset #1806
    //   Java source line #1159	-> byte code offset #1814
    //   Java source line #1160	-> byte code offset #1824
    //   Java source line #1161	-> byte code offset #1832
    //   Java source line #1162	-> byte code offset #1842
    //   Java source line #1163	-> byte code offset #1850
    //   Java source line #1164	-> byte code offset #1857
    //   Java source line #1166	-> byte code offset #1873
    //   Java source line #1168	-> byte code offset #1899
    //   Java source line #1169	-> byte code offset #1909
    //   Java source line #1170	-> byte code offset #1914
    //   Java source line #1171	-> byte code offset #1919
    //   Java source line #1172	-> byte code offset #1929
    //   Java source line #1174	-> byte code offset #1934
    //   Java source line #1139	-> byte code offset #1941
    //   Java source line #1176	-> byte code offset #1947
    //   Java source line #1177	-> byte code offset #1958
    //   Java source line #1025	-> byte code offset #1965
    //   Java source line #1180	-> byte code offset #1971
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1972	0	this	LambdaExp
    //   0	1972	1	ctype	ClassType
    //   0	1972	2	comp	Compilation
    //   0	1972	3	closureEnvType	ObjectType
    //   4	1527	4	name	String
    //   10	1386	5	outer	LambdaExp
    //   28	1253	6	key_args	int
    //   49	1237	7	numStubs	int
    //   77	907	8	varArgs	boolean
    //   86	1540	9	methods	Method[]
    //   131	3	10	isStatic	boolean
    //   157	3	10	isStatic	boolean
    //   201	33	10	isStatic	boolean
    //   239	3	10	isStatic	boolean
    //   257	3	10	isStatic	boolean
    //   315	3	10	isStatic	boolean
    //   321	236	10	isStatic	boolean
    //   108	824	11	isInitMethod	char
    //   182	39	12	cl	ClassExp
    //   292	11	12	mexp	ModuleExp
    //   332	1167	12	nameBuf	StringBuffer
    //   345	1192	13	mflags	int
    //   388	23	14	defaultFlag	short
    //   549	818	14	withContext	boolean
    //   645	104	15	inherited	Method[]
    //   889	646	15	rtype	Type
    //   648	202	16	iarg	int
    //   905	187	16	extraArg	int
    //   654	194	17	param	Declaration
    //   918	130	17	rtypeEnc	String
    //   709	8	18	mangled	String
    //   733	97	18	type	Type
    //   921	244	18	ctxArg	int
    //   721	4	19	filter	Filter
    //   738	13	19	i	int
    //   944	523	19	nameBaseLength	int
    //   753	16	20	method	Method
    //   947	1019	20	i	int
    //   776	15	21	ptype	Type
    //   970	211	21	plainArgs	int
    //   974	209	22	numArgs	int
    //   1002	531	23	atypes	Type[]
    //   1021	587	24	encTypes	Stack<String>
    //   1033	556	25	encTypesSize	int
    //   1057	286	26	var	Declaration
    //   1080	14	27	itype	int
    //   1192	172	27	lastType	Type
    //   1414	95	27	classSpecified	boolean
    //   1123	26	28	encType	String
    //   1199	98	28	lastTypeName	String
    //   1424	61	28	renameCount	int
    //   1249	26	29	encType	String
    //   1431	7	29	len	int
    //   1442	51	30	suffix	String
    //   1445	77	31	t	ClassType
    //   1541	411	31	method	Method
    //   1581	40	32	ae	AnnotationEntry
    //   1652	15	32	n	int
    //   1659	302	33	exceptions	ClassType[]
    //   1662	280	34	j	int
    //   1956	3	34	attr	ExceptionsAttr
    //   1672	267	35	exception	ClassType
    //   1681	244	36	throwsExpr	Expression
    //   1684	239	37	msg	String
    //   1699	92	38	throwsRef	ReferenceExp
    //   1822	29	38	value	Object
    //   1706	50	39	decl	Declaration
    //   1718	11	40	declValue	Expression
  }
  
  public void allocChildClasses(Compilation comp)
  {
    Method main = getMainMethod();
    
    if ((main != null) && (!main.getStaticFlag())) {
      CodeAttr code = comp.getCode();
      
      scope = code.getCurrentScope();
      declareThis(main.getDeclaringClass());
      thisVariable.allocateLocal(code);
      scope = null;
    }
    
    Declaration decl = firstDecl();
    for (;;) {
      if ((decl == firstArgsArrayArg) && (argsArray != null)) {
        getVarScope().addVariable(argsArray);
      }
      if ((!getInlineOnly()) && (getCallConvention() >= 2)) { if (firstArgsArrayArg == null) if (decl != null) break label162; else { if (argsArray != null ? decl != firstArgsArrayArg : decl != firstArgsArrayArg.nextDecl()) {
            break label162;
          }
        }
        
        Variable var = getVarScope().addVariable(null, Compilation.typeCallContext, "$ctx");
        


        var.setParameter(true); }
      label162:
      if (decl == null)
        break;
      Variable var = var;
      
      if ((var == null) && ((!getInlineOnly()) || (!decl.ignorable())) && (decl.parameterForMethod()))
      {


        if ((decl.isSimple()) && (!decl.isIndirectBinding()))
        {

          var = decl.allocateVariable(null);


        }
        else
        {

          String vname = Mangling.mangleName(decl.getName()).intern();
          Type vtype = decl.getType().getImplementationType();
          var = decl.var = getVarScope().addVariable(null, vtype, vname);
          
          var.setParameter(true);
        }
      }
      decl = decl.nextDecl();
    }
    
    declareClosureEnv();
    
    allocFrame(comp);
    
    allocChildMethods(comp);
  }
  
  void allocMethod(LambdaExp outer, Compilation comp)
  {
    if (currentModuleinfo != null) {
      int state = currentModuleinfo.getState();
      if ((state >= 14) && (state != 100))
        comp.error('f', "internal error - allocate method for " + this + " in module " + currentModule() + " that has already been compiled\n(Try removing all class files and doing a full re-compile.)");
    }
    ObjectType closureEnvType;
    ObjectType closureEnvType;
    if (!getNeedsClosureEnv()) {
      closureEnvType = null; } else { ObjectType closureEnvType;
      if (outer.isClassGenerated()) {
        closureEnvType = outer.getCompiledClassType(comp);
      } else {
        LambdaExp owner = outer;
        while (heapFrame == null)
          owner = owner.outerLambda();
        closureEnvType = (ClassType)heapFrame.getType();
      } }
    addMethodFor(comp, closureEnvType);
  }
  
  public void pushChild(LambdaExp child) {
    nextSibling = firstChild;
    firstChild = child;
  }
  
  public void reverseChildList() {
    LambdaExp prev = null;LambdaExp child = firstChild;
    while (child != null) {
      LambdaExp next = nextSibling;
      nextSibling = prev;
      prev = child;
      child = next;
    }
    firstChild = prev;
  }
  
  void allocChildMethods(Compilation comp) {
    for (LambdaExp child = firstChild; child != null; 
        child = nextSibling) {
      if ((child instanceof ClassExp)) {
        ClassExp cl = (ClassExp)child;
        if (cl.getNeedsClosureEnv()) { ClassType parentFrameType;
          ClassType parentFrameType;
          if (isClassGenerated()) {
            parentFrameType = (ClassType)getType();
          } else {
            Variable parentFrame = heapFrame != null ? heapFrame : closureEnv;
            

            parentFrameType = (ClassType)parentFrame.getType();
          }
          closureEnvField = (cl.staticLinkField = instanceType.setOuterLink(parentFrameType));
        }
      }
    }
  }
  
  public void allocFrame(Compilation comp)
  {
    if (heapFrame != null) { ClassType frameType;
      ClassType frameType;
      if (isClassGenerated()) {
        frameType = getCompiledClassType(comp);
      } else {
        frameType = new ClassType(comp.generateClassName("frame"));
        frameType.setSuper(comp.getModuleType());
        comp.addClass(frameType);
      }
      heapFrame.setType(frameType);
    }
  }
  
  void allocParameters(Compilation comp) {
    CodeAttr code = comp.getCode();
    Scope sc = getVarScope();
    locals.enterScope(sc);
    int line = getLineNumber();
    if (line > 0) {
      code.putLineNumber(getFileName(), line);
    }
  }
  




  void enterFunction(Compilation comp)
  {
    CodeAttr code = comp.getCode();
    

    getVarScope().noteStartFunction(code);
    
    if ((closureEnv != null) && (!closureEnv.isParameter()) && (!comp.usingCPStyle()))
    {
      if (!getInlineOnly()) {
        code.emitPushThis();
        Field field = closureEnvField;
        if (field == null)
          field = outerLambdaclosureEnvField;
        code.emitGetField(field);
        code.emitStore(closureEnv);
      } else if (!inlinedIn(outerLambda())) {
        outerLambdaOrCaller().loadHeapFrame(comp);
        code.emitStore(closureEnv);
      }
    }
    if (!comp.usingCPStyle()) {
      ClassType frameType = heapFrame == null ? currentModule().getCompiledClassType(comp) : (ClassType)heapFrame.getType();
      

      for (Declaration decl = capturedVars; decl != null; 
          decl = nextCapturedVar) {
        if (field == null)
        {
          decl.makeField(frameType, comp, null); }
      }
    }
    if ((heapFrame != null) && (!comp.usingCPStyle())) {
      ClassType frameType = (ClassType)heapFrame.getType();
      if ((closureEnv != null) && (!(this instanceof ModuleExp))) {
        staticLinkField = frameType.addField("staticLink", closureEnv.getType());
      }
      if (!isClassGenerated()) {
        frameType.setEnclosingMember(method);
        code.emitNew(frameType);
        code.emitDup(frameType);
        Method constructor = Compilation.getConstructor(frameType, this);
        code.emitInvokeSpecial(constructor);
        
        if (staticLinkField != null) {
          code.emitDup(frameType);
          code.emitLoad(closureEnv);
          code.emitPutField(staticLinkField);
        }
        heapFrame.allocateLocal(code);
        code.emitStore(heapFrame);
        code.pushAutoPoppableScope().addVariable(heapFrame);
      }
    }
    
    Variable argsArray = this.argsArray;
    if ((min_args == max_args) && (primMethods == null) && (getCallConvention() < 2))
    {

      argsArray = null;
    }
    


    Declaration param = firstDecl();
    
    int i = (param != null) && (param.isThisParameter()) ? -1 : 0;
    int key_i = 0;
    int key_args = keywords == null ? 0 : keywords.length;
    if ((this instanceof ModuleExp)) {
      return;
    }
    int plainArgs = -1;
    int defaultStart = 0;
    Method mainMethod = getMainMethod();
    Variable callContextSave = callContextVar;
    for (; 
        param != null; i++) {
      callContextVar = (getCallConvention() < 2 ? null : getVarScope().lookup("$ctx"));
      

      if ((param == firstArgsArrayArg) && (argsArray != null)) {
        if (primMethods != null) {
          plainArgs = i;
          defaultStart = plainArgs - min_args;
        } else {
          plainArgs = 0;
          defaultStart = 0;
        }
      }
      boolean ignorable = param.ignorable();
      if ((plainArgs >= 0) || (!param.isSimple()) || (param.isIndirectBinding()))
      {
        Type paramType = param.getType();
        Type stackType = plainArgs >= 0 ? Type.objectType : paramType;
        




        if ((!param.isSimple()) && (!ignorable)) {
          param.loadOwningObject(null, comp);
        }
        if (plainArgs < 0)
        {
          if (!ignorable)
            code.emitLoad(param.getVariable());
        } else if (i < min_args)
        {
          if (!ignorable) {
            code.emitLoad(argsArray);
            code.emitPushInt(i);
            code.emitArrayLoad(Type.objectType);
          }
        } else if (i < min_args + opt_args)
        {
          Expression defaultArg = param.getInitValue();
          if ((!ignorable) || (!(defaultArg instanceof QuoteExp))) {
            code.emitPushInt(i - plainArgs);
            code.emitLoad(argsArray);
            code.emitArrayLength();
            code.emitIfIntLt();
            if (!ignorable) {
              code.emitLoad(argsArray);
              code.emitPushInt(i - plainArgs);
              code.emitArrayLoad();
            }
            code.emitElse();
            if (ignorable) {
              defaultArg.compile(comp, Target.Ignore);
            } else
              defaultArg.compile(comp, paramType);
            code.emitFi();
          }
        } else if ((max_args < 0) && (i == min_args + opt_args))
        {

          if (!ignorable) {
            code.emitLoad(argsArray);
            code.emitPushInt(i - plainArgs);
            code.emitInvokeStatic(Compilation.makeListMethod);
          }
          stackType = Compilation.scmListType;
        }
        else {
          Keyword keyword = keywords[(key_i++)];
          Expression defaultArg = param.getInitValue();
          if ((!ignorable) || (!(defaultArg instanceof QuoteExp))) {
            code.emitLoad(argsArray);
            code.emitPushInt(min_args + opt_args - plainArgs);
            comp.compileConstant(keyword);
            Type boxedParamType = (paramType instanceof PrimType) ? ((PrimType)paramType).boxedType() : paramType;
            





            if ((defaultArg instanceof QuoteExp)) {
              if (searchForKeywordMethod4 == null) {
                Type[] argts = new Type[4];
                argts[0] = Compilation.objArrayType;
                argts[1] = Type.intType;
                argts[2] = Type.objectType;
                argts[3] = Type.objectType;
                searchForKeywordMethod4 = Compilation.scmKeywordType.addMethod("searchForKeyword", argts, Type.objectType, 9);
              }
              


              defaultArg.compile(comp, boxedParamType);
              code.emitInvokeStatic(searchForKeywordMethod4);
            } else {
              if (searchForKeywordMethod3 == null) {
                Type[] argts = new Type[3];
                argts[0] = Compilation.objArrayType;
                argts[1] = Type.intType;
                argts[2] = Type.objectType;
                searchForKeywordMethod3 = Compilation.scmKeywordType.addMethod("searchForKeyword", argts, Type.objectType, 9);
              }
              


              code.emitInvokeStatic(searchForKeywordMethod3);
              if (!ignorable)
                code.emitDup(1);
              comp.compileConstant(Special.dfault);
              code.emitIfEq();
              if (ignorable) {
                defaultArg.compile(comp, Target.Ignore);
              } else {
                code.emitPop(1);
                defaultArg.compile(comp, boxedParamType);
                paramType.emitCoerceToObject(code);
              }
              code.emitFi();
            }
          }
        }
        if (!ignorable)
        {


          if (paramType != stackType)
            CheckedTarget.emitCheckedCoerce(comp, this, i + 1, stackType, paramType, null);
          if (param.isIndirectBinding())
            param.pushIndirectBinding(comp);
          if (param.isSimple()) {
            Variable var = param.getVariable();
            if (param.isIndirectBinding())
              var.setType(Compilation.typeLocation);
            code.emitStore(var);
          }
          else {
            code.emitPutField(field);
          }
        }
      }
      param = param.nextDecl();
    }
    









































































































































    callContextVar = callContextSave;
  }
  
  void compileAsInlined(Compilation comp, Target target) {
    flags |= 0x80;
    LambdaExp saveLambda = curLambda;
    curLambda = this;
    allocChildClasses(comp);
    allocParameters(comp);
    CodeAttr code = comp.getCode();
    if (startForInlining == null)
      startForInlining = new Label(code);
    startForInlining.define(code);
    ApplyExp.popParams(code, this, null, false);
    enterFunction(comp);
    body.compileWithPosition(comp, target);
    compileEnd(comp);
    generateApplyMethods(comp);
    curLambda = saveLambda;
  }
  
  void compileAsMethod(Compilation comp) {
    if (((flags & 0x80) != 0) || (isAbstract()) || (isNative()))
      return;
    flags |= 0x80;
    if (primMethods == null)
      allocMethod(outerLambda(), comp);
    Method save_method = method;
    LambdaExp save_lambda = curLambda;
    curLambda = this;
    
    Method method = primMethods[0];
    boolean isStatic = method.getStaticFlag();
    int numStubs = primMethods.length - 1;
    Type restArgType = restArgType();
    
    long[] saveDeclFlags = null;
    if (numStubs > 0) {
      saveDeclFlags = new long[min_args + numStubs];
      int k = 0;
      for (Declaration decl = firstDecl(); 
          k < min_args + numStubs; decl = decl.nextDecl()) {
        saveDeclFlags[(k++)] = flags;
      }
    }
    boolean ctxArg = getCallConvention() >= 2;
    
    for (int i = 0; i <= numStubs; i++) {
      method = primMethods[i];
      if ((nameDecl != null) && (!isClassMethod())) {
        nameDecl.compileAnnotations(method, ElementType.METHOD);
      }
      if (i < numStubs) {
        CodeAttr code = method.startCode();
        
        Variable callContextSave = callContextVar;
        Variable var = code.getArg(0);
        if (!isStatic) {
          code.emitPushThis();
          if (getNeedsClosureEnv())
            closureEnv = var;
          var = code.getArg(1);
        }
        Declaration decl = firstDecl();
        for (int j = 0; j < min_args + i; 
            decl = decl.nextDecl()) {
          flags |= 0x40;
          var = var;
          code.emitLoad(var);
          var = var.nextVar();j++;
        }
        


        callContextVar = (ctxArg ? var : null);
        int toCall = i + 1;
        for (int j = i; j < toCall; j++) {
          Target paramTarget = StackTarget.getInstance(decl.getType());
          Expression defaultArg = decl.getInitValue();
          defaultArg.compile(comp, paramTarget);
          




          decl = decl.nextDecl();
          if ((toCall < numStubs) && ((decl.getInitValue() instanceof QuoteExp)))
          {
            toCall++; }
        }
        boolean varArgs = (toCall == numStubs) && (restArgType != null);
        if (varArgs)
        {
          String lastTypeName = restArgType.getName();
          Expression arg; if ("gnu.lists.LList".equals(lastTypeName)) {
            arg = QuoteExp.emptyExp; } else { Expression arg;
            if ("java.lang.Object[]".equals(lastTypeName)) {
              arg = new QuoteExp(Values.noArgs);
            } else
              throw new Error("unimplemented #!rest type " + lastTypeName); }
          Expression arg; arg.compile(comp, restArgType);
        }
        if (ctxArg)
          code.emitLoad(var);
        if (isStatic) {
          code.emitInvokeStatic(primMethods[toCall]);
        } else
          code.emitInvokeVirtual(primMethods[toCall]);
        code.emitReturn();
        closureEnv = null;
        callContextVar = callContextSave;
      } else {
        if (saveDeclFlags != null) {
          int k = 0;
          for (Declaration decl = firstDecl(); 
              k < min_args + numStubs; decl = decl.nextDecl()) {
            flags = saveDeclFlags[(k++)];
            var = null;
          }
        }
        method.initCode();
        allocChildClasses(comp);
        allocParameters(comp);
        enterFunction(comp);
        
        compileBody(comp);
        compileEnd(comp);
        generateApplyMethods(comp);
      }
    }
    
    method = save_method;
    curLambda = save_lambda;
  }
  
  public void compileBody(Compilation comp)
  {
    Variable callContextSave = callContextVar;
    callContextVar = null;
    Target target; Target target; if (getCallConvention() >= 2) {
      Variable var = getVarScope().lookup("$ctx");
      if ((var != null) && (var.getType() == Compilation.typeCallContext))
        callContextVar = var;
      target = ConsumerTarget.makeContextTarget(comp, getReturnType());
    }
    else {
      target = Target.pushValue(getReturnType()); }
    ScopeExp savedScope = comp.currentScope();
    current_scope = this;
    body.compileWithPosition(comp, target, body.getLineNumber() > 0 ? body : this);
    
    current_scope = savedScope;
    callContextVar = callContextSave;
  }
  


  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    Compilation comp = visitor.getCompilation();
    LambdaExp saveLambda;
    LambdaExp saveLambda; if (comp == null) {
      saveLambda = null;
    } else {
      saveLambda = curLambda;
      curLambda = this;
    }
    try {
      return visitor.visitLambdaExp(this, d);
    } finally {
      if (comp != null)
        curLambda = saveLambda;
    }
  }
  
  protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
    visitChildrenOnly(visitor, d);
    visitProperties(visitor, d);
  }
  
  protected final <R, D> void visitChildrenOnly(ExpVisitor<R, D> visitor, D d) {
    LambdaExp save = currentLambda;
    currentLambda = this;
    try {
      throwsSpecification = visitor.visitExps(throwsSpecification, d);
      visitor.visitDefaultArgs(this, d);
      if ((exitValue == null) && (body != null))
        body = visitor.update(body, visitor.visit(body, d));
    } finally {
      currentLambda = save;
    }
  }
  
  protected final <R, D> void visitProperties(ExpVisitor<R, D> visitor, D d) {
    if (properties != null) {
      int len = properties.length;
      for (int i = 1; i < len; i += 2) {
        Object val = properties[i];
        if ((val instanceof Expression)) {
          properties[i] = visitor.visitAndUpdate((Expression)val, d);
        }
      }
    }
  }
  
  protected boolean mustCompile() {
    if ((keywords != null) && (keywords.length > 0))
      return true;
    if (opt_args != 0) {
      for (Declaration p = firstDecl(); p != null; p = p.nextDecl()) {
        Expression defaultArg = p.getInitValue();
        
        if ((defaultArg != null) && (!(defaultArg instanceof QuoteExp)))
          return true;
      }
    }
    return false;
  }
  


  public void apply(CallContext ctx)
    throws Throwable
  {
    setIndexes();
    ctx.writeValue(new Closure(this, ctx));
  }
  
  Object evalDefaultArg(Declaration param, CallContext ctx) {
    try {
      return param.getInitValue().eval(ctx);
    } catch (Error ex) {
      throw ex;
    } catch (Throwable ex) {
      throw new WrappedException("error evaluating default argument", ex);
    }
  }
  
  public Expression validateApply(ApplyExp exp, InlineCalls visitor, Type required, Declaration decl)
  {
    Expression[] args = exp.getArgs();
    if (firstSpliceArg >= 0)
    {





      setCanRead(true);
      if (nameDecl != null)
        nameDecl.setCanRead(true);
    }
    if ((flags & 0x1000) != 0) {
      Expression inlined = InlineCalls.inlineCall(this, args, true);
      if (inlined != null)
        return visitor.visit(inlined, required);
    }
    exp.visitArgs(visitor, this);
    int args_length = args.length;
    int spliceCount = exp.spliceCount();
    int nonSpliceCount = args_length - spliceCount;
    String msg = WrongArguments.checkArgCount(getName(), spliceCount > 0 ? 0 : min_args, max_args, nonSpliceCount);
    


    if (msg != null)
      return visitor.noteError(msg);
    return exp;
  }
  
  public void print(OutPort out) {
    out.startLogicalBlock("(Lambda/", ")", 2);
    Object sym = getSymbol();
    if (sym != null) {
      out.print(sym);
      out.print('/');
    }
    out.print(id);
    out.print('/');
    out.print("fl:");out.print(Integer.toHexString(flags));
    out.writeSpaceFill();
    printLineColumn(out);
    out.startLogicalBlock("(", false, ")");
    Special prevMode = null;
    int i = 0;
    int key_args = keywords == null ? 0 : keywords.length;
    Declaration decl = firstDecl();
    if ((decl != null) && (decl.isThisParameter()))
      i = -1;
    for (; decl != null; decl = decl.nextDecl()) { Special mode;
      Special mode;
      if ((i < min_args) || ((i == min_args) && (decl.getFlag(1099511627776L))))
      {
        mode = null; } else { Special mode;
        if (i < min_args + opt_args) {
          mode = Special.optional; } else { Special mode;
          if ((max_args < 0) && (i == min_args + opt_args)) {
            mode = Special.rest;
          } else
            mode = Special.key; } }
      if (decl != firstDecl())
        out.writeSpaceFill();
      if (mode != prevMode) {
        out.print(mode);
        out.writeSpaceFill();
      }
      Expression defaultArg = decl.getInitValue();
      if (defaultArg != null)
        out.print('(');
      decl.printInfo(out);
      if ((defaultArg != null) && (defaultArg != QuoteExp.falseExp)) {
        out.print(' ');
        defaultArg.print(out);
        out.print(')');
      }
      if (decl.getFlag(8796093022208L))
        i++;
      prevMode = mode;
    }
    out.endLogicalBlock(")");
    if (properties != null) {
      int plen = properties.length;
      for (int j = 0; j < plen; j += 2) {
        Object key = properties[j];
        if (key != null)
        {
          out.writeSpaceFill();
          out.startLogicalBlock("", false, "");
          out.print(key);
          out.print(":");
          out.writeSpaceFill();
          out.print(properties[(j + 1)]);
          out.endLogicalBlock("");
        }
      } }
    out.writeSpaceLinear();
    if (body == null) {
      out.print("<null body>");
    } else
      body.print(out);
    out.endLogicalBlock(")");
  }
  
  protected final String getExpClassName() {
    String cname = getClass().getName();
    int index = cname.lastIndexOf('.');
    if (index >= 0)
      cname = cname.substring(index + 1);
    return cname;
  }
  
  public boolean side_effects() { return false; }
  
  public String toString() {
    String str = getExpClassName() + ':' + getSymbol() + '/' + id + '/';
    
    int l = getLineNumber();
    if ((l <= 0) && (body != null))
      l = body.getLineNumber();
    if (l > 0) {
      str = str + "l:" + l;
    }
    return str;
  }
  



  public Object getProperty(Object key, Object defaultValue)
  {
    if (properties != null) {
      int i = properties.length; do { i -= 2; if (i < 0) break;
      } while (properties[i] != key);
      return properties[(i + 1)];
    }
    
    return defaultValue;
  }
  
  public synchronized void setProperty(Object key, Object value) {
    properties = PropertySet.setProperty(properties, key, value);
  }
  




  public final Type getReturnType()
  {
    if (returnType == null) {
      returnType = Type.objectType;
      
      if ((body != null) && (!isAbstract()) && (!isNative()) && (body.getFlag(1)))
      {
        returnType = body.getType(); }
    }
    return returnType;
  }
  
  public final void setReturnType(Type returnType)
  {
    this.returnType = returnType;
  }
  
  public final void setCoercedReturnType(Type returnType) {
    this.returnType = returnType;
    if ((returnType != null) && (returnType != Type.objectType) && (returnType != Type.voidType) && (body != QuoteExp.abstractExp) && (body != QuoteExp.nativeExp))
    {



      Expression value = body;
      body = Compilation.makeCoercion(value, returnType);
      body.setLine(value);
    }
  }
  
  public static void maybeSetReturnType(LambdaExp lexp, Type type) {
    if ((returnType == null) && (type != null) && (!(type instanceof InlineCalls.LenientExpectedType)) && (!(type instanceof InlineCalls.ValueNeededType)))
    {

      lexp.setCoercedReturnType(type);
    }
  }
  
  public final void setCoercedReturnValue(Expression type, Language language)
  {
    if ((!isAbstract()) && (!isNative())) {
      Expression value = body;
      body = Compilation.makeCoercion(value, type);
      body.setLine(value);
    }
    Type rtype = language.getTypeFor(type);
    if (rtype != null) {
      setReturnType(rtype);
    }
  }
  


  public Expression getBodyFirstExpression()
  {
    Expression bodyFirst = body;
    for (;;) {
      if ((bodyFirst instanceof BeginExp)) {
        BeginExp bbody = (BeginExp)bodyFirst;
        if (length == 0) {
          bodyFirst = null;
        } else
          bodyFirst = exps[0];
      } else { if (!(bodyFirst instanceof LetExp)) break;
        bodyFirst = ((LetExp)bodyFirst).getBody();
      }
    }
    
    return bodyFirst;
  }
  


  public ClassType checkForInitCall(Expression bodyFirst)
  {
    ClassType calledInit = null;
    if ((bodyFirst instanceof ApplyExp)) {
      Expression exp = func;
      if ((exp instanceof QuoteExp)) {
        Object value = ((QuoteExp)exp).getValue();
        if ((value instanceof PrimProcedure)) {
          PrimProcedure pproc = (PrimProcedure)value;
          Method meth = pproc.getMethod();
          if ((pproc.isSpecial()) && ("<init>".equals(meth.getName())))
          {
            calledInit = meth.getDeclaringClass(); }
        }
      }
    }
    return calledInit;
  }
  
  static class Closure extends MethodProc {
    Object[][] evalFrames;
    LambdaExp lambda;
    
    public int numArgs() { return lambda.min_args | lambda.max_args << 12; }
    
    public Closure(LambdaExp lexp, CallContext ctx) {
      lambda = lexp;
      
      Object[][] oldFrames = evalFrames;
      if (oldFrames != null) {
        int n = oldFrames.length;
        while ((n > 0) && (oldFrames[(n - 1)] == null)) {
          n--;
        }
        evalFrames = new Object[n][];
        System.arraycopy(oldFrames, 0, evalFrames, 0, n);
      }
      setSymbol(lambda.getSymbol());
    }
    
    public int match0(CallContext ctx) {
      return matchN(new Object[0], ctx);
    }
    
    public int match1(Object arg1, CallContext ctx) {
      return matchN(new Object[] { arg1 }, ctx);
    }
    
    public int match2(Object arg1, Object arg2, CallContext ctx) {
      return matchN(new Object[] { arg1, arg2 }, ctx);
    }
    
    public int match3(Object arg1, Object arg2, Object arg3, CallContext ctx) {
      return matchN(new Object[] { arg1, arg2, arg3 }, ctx);
    }
    
    public int match4(Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx)
    {
      return matchN(new Object[] { arg1, arg2, arg3, arg4 }, ctx);
    }
    
    public int matchN(Object[] args, CallContext ctx) {
      int num = numArgs();
      int nargs = args.length;
      int min = num & 0xFFF;
      if (nargs < min)
        return 0xFFF10000 | min;
      int max = num >> 12;
      if ((nargs > max) && (max >= 0)) {
        return 0xFFF20000 | max;
      }
      Object[] evalFrame = new Object[lambda.frameSize];
      int key_args = lambda.keywords == null ? 0 : lambda.keywords.length;
      int opt_args = lambda.opt_args;
      int i = 0;
      int key_i = 0;
      int min_args = lambda.min_args;
      for (Declaration decl = lambda.firstDecl(); decl != null; 
          decl = decl.nextDecl()) { Object value;
        Object value;
        if (i < min_args) {
          value = args[(i++)]; } else { Object value;
          if (i < min_args + opt_args) { Object value;
            if (i < nargs) {
              value = args[(i++)];
            } else
              value = lambda.evalDefaultArg(decl, ctx); } else { Object value;
            if ((lambda.max_args < 0) && (i == min_args + opt_args)) {
              if ((type instanceof ArrayType)) {
                int rem = nargs - i;
                Type elementType = ((ArrayType)type).getComponentType();
                Object value; if (elementType == Type.objectType) {
                  Object[] rest = new Object[rem];
                  System.arraycopy(args, i, rest, 0, rem);
                  value = rest;
                } else {
                  Class elementClass = elementType.getReflectClass();
                  Object value = Array.newInstance(elementClass, rem);
                  
                  for (int j = 0; j < rem; j++) {
                    Object el;
                    try {
                      el = elementType.coerceFromObject(args[(i + j)]);
                    } catch (ClassCastException ex) {
                      return 0xFFF40000 | i + j;
                    }
                    Array.set(value, j, el);
                  }
                }
              }
              else {
                value = LList.makeList(args, i);
              }
            }
            else {
              Keyword keyword = lambda.keywords[(key_i++)];
              int key_offset = min_args + opt_args;
              value = Keyword.searchForKeyword(args, key_offset, keyword);
              if (value == Special.dfault)
                value = lambda.evalDefaultArg(decl, ctx);
            } } }
        if (type != null) {
          try {
            value = type.coerceFromObject(value);
          } catch (ClassCastException ex) {
            return 0xFFF40000 | i;
          }
        }
        if (decl.isIndirectBinding()) {
          Location loc = decl.makeIndirectLocationFor();
          loc.set(value);
          value = loc;
        }
        evalFrame[evalIndex] = value;
      }
      values = evalFrame;
      where = 0;
      next = 0;
      proc = this;
      return 0;
    }
    
    public void apply(CallContext ctx) throws Throwable {
      int level = ScopeExp.nesting(lambda);
      Object[] evalFrame = values;
      Object[][] saveFrames = evalFrames;
      
      int numFrames = evalFrames == null ? 0 : evalFrames.length;
      if (level >= numFrames)
        numFrames = level;
      numFrames += 10;
      Object[][] newFrames = new Object[numFrames][];
      if (evalFrames != null)
        System.arraycopy(evalFrames, 0, newFrames, 0, evalFrames.length);
      newFrames[level] = evalFrame;
      evalFrames = newFrames;
      try
      {
        if (lambda.body == null)
        {

          StringBuffer sbuf = new StringBuffer("procedure ");
          String name = lambda.getName();
          if (name == null)
            name = "<anonymous>";
          sbuf.append(name);
          int line = lambda.getLineNumber();
          if (line > 0) {
            sbuf.append(" at line ");
            sbuf.append(line);
          }
          sbuf.append(" was called before it was expanded");
          throw new RuntimeException(sbuf.toString());
        }
        lambda.body.apply(ctx);
      } finally {
        evalFrames = saveFrames;
      }
    }
    
    public Object getProperty(Object key, Object defaultValue) {
      Object value = super.getProperty(key, defaultValue);
      if (value == null)
        value = lambda.getProperty(key, defaultValue);
      return value;
    }
  }
}
