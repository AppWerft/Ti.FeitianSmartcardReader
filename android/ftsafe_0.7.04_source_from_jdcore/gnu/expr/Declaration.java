package gnu.expr;

import gnu.bytecode.AnnotationEntry;
import gnu.bytecode.AttrContainer;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.PrimType;
import gnu.bytecode.RuntimeAnnotationsAttr;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.CompileArith;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.io.OutPort;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.SourceLocator;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import kawa.SourceType;











public class Declaration
  implements SourceLocator
{
  static int counter;
  protected int id = ++counter;
  Object symbol;
  public ScopeExp context;
  protected Type type;
  protected Expression typeExp;
  private Declaration next;
  int evalIndex;
  
  public void setCode(int code) { if (code >= 0) throw new Error("code must be negative");
    id = code;
  }
  
  public int getCode() { return id; }
  








  public final Expression getTypeExp()
  {
    if (typeExp == null)
      setType(Type.objectType);
    return typeExp;
  }
  
  public final Type getType() {
    if (type == null)
    {
      Type t = Type.objectType;
      type = t;
      if ((!hasUnknownValue()) && (nvalues > 0))
      {
        int arithCount = 0;
        for (int i = 0; i < nvalues; i++)
        {
          Expression vi = values[i].getValue(this);
          boolean arithOp = false;
          if ((vi != null) && (!vi.getFlag(1)))
          {




            Expression oparg = checkArithStepOp(vi);
            if (oparg != null)
            {

              arithOp = true;
              arithCount++;
              vi = oparg;
            }
          }
          Declaration d;
          if (((vi != null) && (vi.getFlag(1))) || ((vi instanceof LambdaExp)) || ((vi instanceof QuoteExp)) || (((vi instanceof ReferenceExp)) && ((d = ((ReferenceExp)vi).getBinding()) != null) && (type != null)))
          {





            Type vt = vi.getType();
            if (i == 0) {
              t = vt;
            } else if (arithOp) {
              t = CompileArith.combineType(t, vt);
            } else {
              t = Language.unionType(t, vt);
            }
          }
          else {
            t = Type.objectType;
            break;
          }
        }
      }
      setType(t);
    }
    return type;
  }
  
  private Expression checkArithStepOp(Expression exp)
  {
    if (!(exp instanceof ApplyExp))
      return null;
    ApplyExp aexp = (ApplyExp)exp;
    Expression func = aexp.getFunction();
    Compilation comp = Compilation.getCurrent();
    boolean isApplyFunc = comp.isSimpleApplyFunction(func);
    if (aexp.getArgCount() == (isApplyFunc ? 3 : 2))
    {
      if (isApplyFunc)
        func = aexp.getArg(0);
      Declaration fdecl;
      if (((func instanceof ReferenceExp)) && ((fdecl = ((ReferenceExp)func).getBinding()) != null) && (fdecl.getValue() != null))
      {


        Object proc = fdecl.getValue().valueIfConstant();
        if (((proc instanceof AddOp)) || ((proc instanceof MultiplyOp)))
        {
          Expression arg1 = aexp.getArg(isApplyFunc ? 1 : 0);
          Expression arg2 = aexp.getArg(isApplyFunc ? 2 : 1);
          if (((arg1 instanceof ReferenceExp)) && (((ReferenceExp)arg1).getBinding() == this))
          {
            return arg2; }
          if (((arg2 instanceof ReferenceExp)) && (((ReferenceExp)arg2).getBinding() == this))
          {
            return arg1; }
        }
      }
    }
    return null;
  }
  
  public Expression getTypeExpRaw() { return typeExp; }
  
  public final void setType(Type type)
  {
    if (type.isVoid())
      type = Type.objectType;
    this.type = type;
    typeExp = QuoteExp.getInstance(type);
  }
  
  public final void setTypeExp(Expression typeExp)
  {
    this.typeExp = typeExp;
    Type t = null;
    if ((typeExp instanceof TypeValue)) {
      t = ((TypeValue)typeExp).getImplementationType();
    } else
      t = Language.getDefaultLanguage().getTypeFor(typeExp, false);
    if (t == null)
      t = Type.pointer_type;
    type = t;
    if (var != null) var.setType(t);
  }
  
  public final void setType(Expression typeExp, Type type)
  {
    this.typeExp = typeExp;
    this.type = type;
  }
  
  public final String getName()
  {
    return (symbol instanceof Symbol) ? ((Symbol)symbol).getName() : symbol == null ? null : symbol.toString();
  }
  
  public final void setName(Object symbol)
  {
    this.symbol = symbol;
  }
  
  public final Object getSymbol() { return symbol; }
  public final void setSymbol(Object symbol) { this.symbol = symbol; }
  



  public final Declaration nextDecl() { return next; }
  public final void setNext(Declaration next) { this.next = next; }
  


  public Variable getVariable()
  {
    return var;
  }
  




  public int getScanNesting() { return scanNesting; }
  public void setScanNesting(int value) { scanNesting = value; }
  
  public final boolean isSimple()
  {
    return (flags & 0x40) != 0L;
  }
  
  public final void setSimple(boolean b) {
    setFlag(b, 64L);
    if ((var != null) && (!var.isParameter())) var.setSimple(b);
  }
  
  public final void setSyntax()
  {
    setSimple(false);
    setFlag(536920064L);
  }
  
  public final ScopeExp getContext() {
    return context;
  }
  

  Variable var;
  
  int scanNesting;
  
  Declaration nextCapturedVar;
  
  public Declaration base;
  public gnu.bytecode.Field field;
  public Method getterMethod;
  public Method setterMethod;
  void loadOwningObject(Declaration owner, Compilation comp)
  {
    if (owner == null)
      owner = base;
    if (owner != null) {
      owner.load(null, 0, comp, Target.pushObject);
    } else {
      getContext().currentLambda().loadHeapFrame(comp);
    }
  }
  
  public void load(AccessExp access, int flags, Compilation comp, Target target)
  {
    if ((target instanceof IgnoreTarget))
    {
      if (access.getFlag(32))
        comp.getCode().emitPop(1);
      return;
    }
    Declaration owner = access == null ? null : access.contextDecl();
    Expression dvalue = getValueRaw();
    if ((isAlias()) && ((dvalue instanceof ReferenceExp)))
    {
      ReferenceExp rexp = (ReferenceExp)dvalue;
      Declaration orig = binding;
      if ((orig != null) && (((flags & 0x4) == 0) || (orig.isIndirectBinding())) && ((owner == null) || (!orig.needsContext())))
      {



        orig.load(rexp, flags, comp, target);
        return;
      }
    }
    if (isFluid())
    {
      if ((context instanceof FluidLetExp))
      {
        base.load(access, flags, comp, target);
        return;
      }
    }
    CodeAttr code = comp.getCode();
    boolean dontDeref = (flags & 0x4) != 0;
    Type rtype = dontDeref ? Compilation.typeLocation : getType();
    if ((!isIndirectBinding()) && (dontDeref))
    {
      if (field == null) {
        throw new Error("internal error: cannot take location of " + this);
      }
      
      boolean immediate = immediate;
      Method meth; ClassType ltype; Method meth; if (field.getStaticFlag())
      {
        ClassType ltype = Compilation.typeStaticFieldLocation;
        meth = ltype.getDeclaredMethod("make", immediate ? 1 : 2);
      }
      else
      {
        ltype = Compilation.typeFieldLocation;
        meth = ltype.getDeclaredMethod("make", immediate ? 2 : 3);
        
        loadOwningObject(owner, comp);
      }
      if (immediate) {
        comp.compileConstant(this);
      }
      else {
        comp.compileConstant(field.getDeclaringClass().getName());
        comp.compileConstant(field.getName());
      }
      code.emitInvokeStatic(meth);
      rtype = ltype;
    }
    else if (getFlag(549755813888L))
    {
      int SP = code.getSP();
      if (!access.getFlag(32))
      {
        if (SP == evalIndex) {
          code.emitDup();
        } else if (SP == evalIndex + 1)
        {
          code.emitSwap();
          code.emitDupX();
        }
        else {
          throw new InternalError("allocate-on-stack mismatch");
        }
      }
    }
    else {
      Expression value = getValueRaw();
      if ((type == Type.javalangClassType) && (((value instanceof ClassExp)) || ((value instanceof ModuleExp))))
      {

        comp.loadClassRef(((LambdaExp)value).getCompiledClassType(comp));
      }
      else if (field != null)
      {
        comp.usedClass(field.getDeclaringClass());
        comp.usedClass(field.getType());
        if (!field.getStaticFlag())
        {
          loadOwningObject(owner, comp);
          code.emitGetField(field);
        }
        else {
          code.emitGetStatic(field); }
        code.fixUnsigned(getType());
      }
      else if (isClassField())
      {
        String getName = ClassExp.slotToMethodName("get", getName());
        Method getter = context).compiledType.getDeclaredMethod(getName, 0);
        
        comp.usedClass(getter.getDeclaringClass());
        comp.usedClass(getter.getReturnType());
        loadOwningObject(owner, comp);
        code.emitInvoke(getter);
      }
      else if ((isIndirectBinding()) && (immediate) && (getVariable() == null))
      {

        Environment env = Environment.getCurrent();
        Symbol sym = (symbol instanceof Symbol) ? (Symbol)symbol : env.getSymbol(symbol.toString());
        
        Object property = null;
        if ((isProcedureDecl()) && (comp.getLanguage().hasSeparateFunctionNamespace()))
        {
          property = EnvironmentKey.FUNCTION; }
        Location loc = env.getLocation(sym, property);
        comp.compileConstant(loc, Target.pushValue(Compilation.typeLocation));
      } else { Object val;
        if ((immediate) && ((val = getConstantValue()) != null))
        {
          comp.compileConstant(val, target);
          return;
        }
        if ((value != QuoteExp.undefined_exp) && (value != null) && (ignorable()) && (!(value instanceof LambdaExp)))
        {


          value.compile(comp, target);
          return;
        }
        

        Variable var = getVariable();
        if (var == null)
          var = allocateVariable(code, true);
        code.emitLoad(var);
      }
      if ((isIndirectBinding()) && (!dontDeref))
      {
        String filename;
        int line;
        if ((access != null) && ((filename = access.getFileName()) != null) && ((line = access.getLineNumber()) > 0))
        {




          ClassType typeUnboundLocationException = ClassType.make("gnu.mapping.UnboundLocationException");
          

          boolean isInTry = code.isInTry();
          int column = access.getColumnNumber();
          Label startTry = new Label(code);
          startTry.define(code);
          code.emitInvokeVirtual(getLocationMethod);
          Label endTry = new Label(code);
          endTry.define(code);
          Label endLabel = new Label(code);
          endLabel.setTypes(code);
          if (isInTry) {
            code.emitGoto(endLabel);
          } else
            code.setUnreachable();
          int fragment_cookie = 0;
          if (!isInTry)
            fragment_cookie = code.beginFragment(endLabel);
          code.addHandler(startTry, endTry, typeUnboundLocationException);
          
          code.emitDup(typeUnboundLocationException);
          code.emitPushString(filename);
          code.emitPushInt(line);
          code.emitPushInt(column);
          code.emitInvokeVirtual(typeUnboundLocationException.getDeclaredMethod("setLine", 3));
          
          code.emitThrow();
          if (isInTry) {
            endLabel.define(code);
          } else {
            code.endFragment(fragment_cookie);
          }
        } else {
          code.emitInvokeVirtual(getLocationMethod); }
        if ((isAlias()) || (target.getType().getRawType() == Type.objectType))
        {
          rtype = Type.objectType;
        } else {
          getType().emitCoerceFromObject(code);
          rtype = getType();
        }
      }
    }
    target.compileFromStack(comp, rtype);
  }
  
  static final Method getLocationMethod = Compilation.typeLocation.addMethod("get", Type.typeArray0, Type.objectType, 1);
  static final String UNKNOWN_PREFIX = "loc$";
  public static final String PRIVATE_PREFIX = "$Prvt$";
  static final int INDIRECT_BINDING = 1;
  static final int CAN_READ = 2;
  static final int CAN_CALL = 4;
  static final int CAN_WRITE = 8;
  
  public void compileStore(Compilation comp) { CodeAttr code = comp.getCode();
    if (isSimple()) {
      code.emitStore(getVariable());

    }
    else if (!field.getStaticFlag())
    {
      loadOwningObject(null, comp);
      code.emitSwap();
      code.emitPutField(field);
    }
    else {
      code.emitPutStatic(field);
    }
  }
  
  boolean shouldEarlyInit()
  {
    return (getFlag(536870912L)) || (isCompiletimeConstant());
  }
  
  public boolean isCompiletimeConstant()
  {
    return (getFlag(16384L)) && (hasConstantValue());
  }
  


  static final int IS_FLUID = 16;
  

  static final int PRIVATE = 32;
  

  static final int IS_SIMPLE = 64;
  

  public static final int PROCEDURE = 128;
  

  public static final int IS_ALIAS = 256;
  

  public static final int NOT_DEFINING = 512;
  

  public static final int EXPORT_SPECIFIED = 1024;
  

  public static final int STATIC_SPECIFIED = 2048;
  

  public static final int NONSTATIC_SPECIFIED = 4096;
  

  public static final int TYPE_SPECIFIED = 8192;
  

  public static final int IS_CONSTANT = 16384;
  

  public static final int IS_SYNTAX = 32768;
  

  public static final int IS_UNKNOWN = 65536;
  
  public static final int IS_IMPORTED = 131072;
  
  public static final int IS_CAPTURED = 131072;
  
  public static final int IS_SINGLE_VALUE = 262144;
  
  public static final int EXTERNAL_ACCESS = 524288;
  
  public static final int FIELD_OR_METHOD = 1048576;
  
  public static final int IS_NAMESPACE_PREFIX = 2097152;
  
  public final boolean needsExternalAccess()
  {
    return ((flags & 0x80020) == 524320L) || ((flags & 0x200020) == 2097184L);
  }
  



  public final boolean needsContext()
  {
    return (base == null) && (((isClassField()) && (!isStatic())) || ((field != null) && (!field.getStaticFlag())));
  }
  


  public static final int PRIVATE_ACCESS = 16777216;
  

  public static final int PRIVATE_SPECIFIED = 16777216;
  

  public static final int PROTECTED_ACCESS = 33554432;
  

  public static final int PUBLIC_ACCESS = 67108864;
  

  public static final int PACKAGE_ACCESS = 134217728;
  

  public static final int IS_DYNAMIC = 268435456;
  

  public static final int EARLY_INIT = 536870912;
  

  public static final int MODULE_REFERENCE = 1073741824;
  

  public static final long VOLATILE_ACCESS = 2147483648L;
  

  public static final long TRANSIENT_ACCESS = 4294967296L;
  

  public static final long ENUM_ACCESS = 8589934592L;
  
  public static final long FINAL_ACCESS = 17179869184L;
  
  public static final long ABSTRACT_ACCESS = 34359738368L;
  
  public static final long SYNCHRONIZED_ACCESS = 68719476736L;
  
  public static final long STRICTFP_ACCESS = 137438953472L;
  
  public static final long CLASS_ACCESS_FLAGS = 60179873792L;
  
  public static final long FIELD_ACCESS_FLAGS = 32463912960L;
  
  public static final long METHOD_ACCESS_FLAGS = 223589957632L;
  
  public static final long MAYBE_UNINITIALIZED_ACCESS = 274877906944L;
  
  public static final long ALLOCATE_ON_STACK = 549755813888L;
  
  public static final long PATTERN_NESTED = 1099511627776L;
  
  public static final long SKIP_FOR_METHOD_PARAMETER = 2199023255552L;
  
  public static final long IS_REST_PARAMETER = 4398046511104L;
  
  public static final long IS_PARAMETER = 8796093022208L;
  
  public static final long DONT_COPY = 1099511627776L;
  
  protected long flags = 64L;
  int numReferences;
  
  public final boolean getFlag(long flag) {
    return (flags & flag) != 0L;
  }
  
  public final void setFlag(boolean setting, long flag)
  {
    if (setting) flags |= flag; else {
      flags &= (flag ^ 0xFFFFFFFFFFFFFFFF);
    }
  }
  
  public final void setFlag(long flag) {
    flags |= flag;
  }
  

  public final boolean isPublic() { return ((context instanceof ModuleExp)) && ((flags & 0x20) == 0L); }
  
  public final boolean isPrivate() { return (flags & 0x20) != 0L; }
  
  public final boolean isModuleLocal() {
    return (!isPublic()) && (!needsExternalAccess());
  }
  
  public final void setPrivate(boolean isPrivate)
  {
    setFlag(isPrivate, 32L);
  }
  
  public short getAccessFlags(short defaultFlags)
  {
    short flags;
    if (getFlag(251658240L))
    {
      short flags = 0;
      if (getFlag(16777216L))
        flags = (short)(flags | 0x2);
      if (getFlag(33554432L))
        flags = (short)(flags | 0x4);
      if (getFlag(67108864L)) {
        flags = (short)(flags | 0x1);
      }
    } else {
      flags = defaultFlags; }
    if (getFlag(2147483648L))
      flags = (short)(flags | 0x40);
    if (getFlag(4294967296L))
      flags = (short)(flags | 0x80);
    if (getFlag(8589934592L))
      flags = (short)(flags | 0x4000);
    if (getFlag(17179869184L))
      flags = (short)(flags | 0x10);
    if (getFlag(68719476736L))
      flags = (short)(flags | 0x20);
    if (getFlag(137438953472L))
      flags = (short)(flags | 0x800);
    return flags;
  }
  
  public final boolean isAlias() { return (flags & 0x100) != 0L; }
  public final void setAlias(boolean flag) { setFlag(flag, 256L); }
  


  public final boolean isFluid() { return (flags & 0x10) != 0L; }
  
  public final void setFluid(boolean fluid) { setFlag(fluid, 16L); }
  
  public final boolean isProcedureDecl() { return (flags & 0x80) != 0L; }
  
  public final void setProcedureDecl(boolean val) { setFlag(val, 128L); }
  
  public final boolean isClassMethod()
  {
    return (flags & 0x100080) == 1048704L;
  }
  
  public final boolean isClassField()
  {
    return (flags & 0x100080) == 1048576L;
  }
  
  public final boolean isNamespaceDecl()
  {
    return (flags & 0x200000) != 0L;
  }
  






  public final boolean parameterForMethod()
  {
    return !getFlag(2199023255552L);
  }
  

  public final boolean isIndirectBinding()
  {
    return (flags & 1L) != 0L;
  }
  

  public final void setIndirectBinding(boolean indirectBinding)
  {
    setFlag(indirectBinding, 1L);
  }
  
  public void maybeIndirectBinding(Compilation comp) {
    if ((isLexical()) && (!inExternalModule(comp)) && (!getFlag(8192L)))
      setIndirectBinding(true);
  }
  
  public boolean inExternalModule(Compilation comp) {
    return ((context instanceof ModuleExp)) && (context != mainLambda);
  }
  
  public final boolean getCanRead() {
    return (flags & 0x2) != 0L;
  }
  
  public final void setCanRead(boolean read) { setFlag(read, 2L); }
  
  public final void setCanRead()
  {
    setFlag(true, 2L);
    if (base != null)
      base.setCanRead();
  }
  
  public final boolean getCanReadOrCall() {
    return (flags & 0x6) != 0L;
  }
  
  public final boolean getCanCall() { return (flags & 0x4) != 0L; }
  public final void setCanCall(boolean called) { setFlag(called, 4L); }
  
  public final void setCanCall() {
    setFlag(true, 4L);
    if (base != null)
      base.setCanRead();
  }
  
  public final boolean getCanWrite() {
    return (flags & 0x8) != 0L;
  }
  
  public final void setCanWrite(boolean written) {
    if (written) flags |= 0x8; else {
      flags &= 0xFFFFFFFFFFFFFFF7;
    }
  }
  
  public final void setCanWrite() {
    flags |= 0x8;
    if (base != null) {
      base.setCanRead();
    }
  }
  
  public final boolean isThisParameter()
  {
    return symbol == ThisExp.THIS_NAME;
  }
  
  public boolean mayBeAccessedUninitialized()
  {
    return getFlag(274877906944L);
  }
  


  public boolean ignorable()
  {
    if ((getCanRead()) || (isPublic()))
      return false;
    if ((getCanWrite()) && (getFlag(65536L)))
      return false;
    if (!getCanCall())
      return true;
    Expression value = getValue();
    if ((value == null) || (!(value instanceof LambdaExp)))
      return false;
    LambdaExp lexp = (LambdaExp)value;
    return (!lexp.isHandlingTailCalls()) || (lexp.getInlineOnly());
  }
  
  public boolean isStatic()
  {
    if (field != null)
      return field.getStaticFlag();
    if ((getFlag(2048L)) || (isCompiletimeConstant()))
    {
      return true; }
    if (getFlag(4096L))
      return false;
    LambdaExp lambda = context.currentLambda();
    return ((lambda instanceof ModuleExp)) && (((ModuleExp)lambda).isStatic());
  }
  

  public final boolean isLexical()
  {
    return (flags & 0x10010010) == 0L;
  }
  
  public static final boolean isUnknown(Declaration decl)
  {
    return (decl == null) || (decl.getFlag(65536L));
  }
  




  public ApplyExp firstCall;
  


  List<Expression> annotations;
  


  public void addCaller(ApplyExp exp)
  {
    nextCall = firstCall;
    firstCall = exp;
  }
  

  public void clearCallList()
  {
    for (ApplyExp exp = firstCall; exp != null;)
    {
      ApplyExp next = nextCall;
      nextCall = null;
      exp = next;
    }
    firstCall = null;
  }
  
  public Declaration(Object name, Type type)
  {
    setName(name);
    if (type != null) {
      setType(type);
    }
  }
  
  public Declaration(Variable var) {
    this(var.getName(), var.getType());
    this.var = var;
  }
  
  public Declaration(Object name)
  {
    this(name, (Type)null);
  }
  
  public Declaration(Object name, gnu.bytecode.Field field)
  {
    this(name, field.getType());
    this.field = field;
    setSimple(false);
  }
  



  public int numAnnotations()
  {
    return annotations == null ? 0 : annotations.size();
  }
  

  public Expression getAnnotation(int i)
  {
    return (Expression)annotations.get(i);
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> clas)
  {
    int n = numAnnotations();
    for (int i = 0; i < n; i++) {
      Object ann = getAnnotation(i).valueIfConstant();
      if (clas.isInstance(ann))
        return (Annotation)ann;
    }
    return null;
  }
  
  public AnnotationEntry getAnnotation(String className) {
    int n = numAnnotations();
    for (int i = 0; i < n; i++) {
      Object ann = getAnnotation(i).valueIfConstant();
      if ((ann instanceof AnnotationEntry)) {
        AnnotationEntry ae = (AnnotationEntry)Proxy.getInvocationHandler(ann);
        
        if (className.equals(ae.getAnnotationType())) {
          return ae;
        }
      }
    }
    return null;
  }
  

  public void setAnnotation(int i, Expression ann)
  {
    annotations.set(i, ann);
  }
  



  public void addAnnotation(Expression exp)
  {
    if (annotations == null)
      annotations = new ArrayList();
    annotations.add(exp);
  }
  
  public void compileAnnotations(AttrContainer container, ElementType etype)
  {
    if (container == null)
      return;
    int n = numAnnotations();
    for (int i = 0; i < n; i++)
    {
      Object ann = getAnnotation(i).valueIfConstant();
      if (ann != null)
      {
        AnnotationEntry ae = (AnnotationEntry)Proxy.getInvocationHandler(ann);
        if ((container != null) && (ae.hasTarget(etype)))
          RuntimeAnnotationsAttr.maybeAddAnnotation(container, ae);
      }
    }
  }
  
  Method makeLocationMethod = null;
  String filename;
  int position;
  private Expression initValue;
  ValueSource[] values;
  int nvalues;
  
  public void pushIndirectBinding(Compilation comp) { CodeAttr code = comp.getCode();
    code.emitPushString(getName());
    if (makeLocationMethod == null)
    {
      Type[] args = new Type[2];
      args[0] = Type.pointer_type;
      args[1] = Type.string_type;
      makeLocationMethod = Compilation.typeLocation.addMethod("make", args, Compilation.typeLocation, 9);
    }
    


    code.emitInvokeStatic(makeLocationMethod);
  }
  
  public final Variable allocateVariable(CodeAttr code)
  {
    return allocateVariable(code, false);
  }
  
  public final Variable allocateVariable(CodeAttr code, boolean autoPopScope) {
    if ((!isSimple()) || (var == null))
    {
      String vname = null;
      if (symbol != null)
        vname = Mangling.mangleNameIfNeeded(getName());
      if ((isAlias()) && ((getValue() instanceof ReferenceExp)))
      {
        Declaration base = followAliases(this);
        var = (base == null ? null : var);
      }
      else
      {
        Type type = isIndirectBinding() ? Compilation.typeLocation : getType().getImplementationType();
        
        Scope scope = autoPopScope ? code.pushAutoPoppableScope() : context.getVarScope();
        
        var = scope.addVariable(code, type, vname);
      }
    }
    return var;
  }
  



  public final void setLocation(SourceLocator location)
  {
    filename = location.getFileName();
    setLine(location.getLineNumber(), location.getColumnNumber());
  }
  
  public final void setFile(String filename)
  {
    this.filename = filename;
  }
  
  public final void setLine(int lineno, int colno)
  {
    if (lineno < 0)
      lineno = 0;
    if (colno < 0)
      colno = 0;
    position = ((lineno << 12) + colno);
  }
  
  public final void setLine(int lineno)
  {
    setLine(lineno, 0);
  }
  
  public final String getFileName()
  {
    return filename;
  }
  
  public String getPublicId()
  {
    return null;
  }
  
  public String getSystemId()
  {
    return filename;
  }
  


  public final int getLineNumber()
  {
    int line = position >> 12;
    return line == 0 ? -1 : line;
  }
  
  public final int getColumnNumber()
  {
    int column = position & 0xFFF;
    return column == 0 ? -1 : column;
  }
  
  public boolean isStableSourceLocation() { return true; }
  
  public void printInfo(OutPort out)
  {
    StringBuffer sbuf = new StringBuffer();
    printInfo(sbuf);
    out.startLogicalBlock("", "", 2);
    out.print(sbuf.toString());
    int numAnnotations = numAnnotations();
    if (numAnnotations > 0)
    {
      out.writeSpaceLinear();
      out.print("Annotations:");
      for (int i = 0; i < numAnnotations; i++)
      {
        out.writeSpaceLinear();
        ((Expression)annotations.get(i)).print(out);
      }
    }
    out.endLogicalBlock("");
  }
  
  public void printInfo(StringBuffer sbuf)
  {
    sbuf.append(symbol);
    










    sbuf.append('/');
    sbuf.append(id);
    













    sbuf.append("/fl:");
    sbuf.append(Long.toHexString(flags));
    if (ignorable())
      sbuf.append("(ignorable)");
    Expression tx = typeExp;
    Type t = type;
    if ((tx != null) && (!(tx instanceof QuoteExp)))
    {
      sbuf.append("::");
      sbuf.append(tx);
    }
    else if ((t != null) && (t != Type.pointer_type))
    {
      sbuf.append("::");
      sbuf.append(t.getName());
    }
    if (base != null)
    {
      sbuf.append("(base:#");
      sbuf.append(base.id);
      sbuf.append(')');
    }
  }
  

  public String toString()
  {
    return "Declaration[" + symbol + '/' + id + ']';
  }
  







  public static Declaration followAliases(Declaration decl)
  {
    while ((decl != null) && (decl.isAlias()))
    {
      Expression declValue = decl.getValue();
      if (!(declValue instanceof ReferenceExp))
        break;
      ReferenceExp rexp = (ReferenceExp)declValue;
      Declaration orig = binding;
      if (orig == null)
        break;
      decl = orig;
    }
    return decl;
  }
  
  public void makeField(Compilation comp, Expression value)
  {
    setSimple(false);
    makeField(mainClass, comp, value);
  }
  
  public void makeField(ClassType frameType, Compilation comp, Expression value)
  {
    boolean external_access = needsExternalAccess();
    int fflags = 0;
    boolean isConstant = getFlag(16384L);
    boolean typeSpecified = getFlag(8192L);
    


    if ((isPublic()) || (external_access) || (immediate)) {
      fflags |= 0x1;
      

      if ((comp.isInteractive()) && (context == comp.getModule()) && (!isConstant))
      {
        setIndirectBinding(true); }
    }
    if ((isStatic()) || ((getFlag(268501008L)) && (isIndirectBinding()) && (!isAlias())) || (((value instanceof ClassExp)) && (!((LambdaExp)value).getNeedsClosureEnv())))
    {






      fflags |= 0x8; }
    if (((isIndirectBinding()) || ((isConstant) && ((shouldEarlyInit()) || (((context instanceof ModuleExp)) && (((ModuleExp)context).staticInitRun()))))) && (((context instanceof ClassExp)) || ((context instanceof ModuleExp))))
    {



      fflags |= 0x10; }
    Type ftype = getType().getImplementationType();
    if ((isIndirectBinding()) && (!ftype.isSubtype(Compilation.typeLocation))) {
      if ((ftype == null) || (ftype == Type.objectType)) {
        ftype = Compilation.typeLocation;
      } else {
        if ((ftype instanceof PrimType))
          ftype = ((PrimType)ftype).boxedType();
        ftype = new ParameterizedType(Compilation.typeLocation, new Type[] { ftype });
      }
    }
    if (!ignorable())
    {
      String dname = getName();
      String fname = dname;
      boolean haveName = fname != null;
      int nlength;
      int nlength; if (fname == null)
      {
        fname = "$unnamed$0";
        nlength = fname.length() - 2;
      }
      else
      {
        fname = Mangling.mangleNameIfNeeded(fname);
        if (getFlag(65536L))
        {
          fname = "loc$" + fname;
          haveName = false;
        }
        if ((external_access) && (!getFlag(1073741824L)))
        {
          fname = "$Prvt$" + fname;
          haveName = false;
        }
        nlength = fname.length();
      }
      int counter = 0;
      while (frameType.getDeclaredField(fname) != null)
        fname = fname.substring(0, nlength) + '$' + ++counter;
      field = frameType.addField(fname, ftype, fflags);
      if (getAnnotation(SourceType.class) == null) {
        String encType = comp.getLanguage().encodeType(getType());
        if ((encType != null) && (encType.length() > 0)) {
          AnnotationEntry ae = new AnnotationEntry(ClassType.make("kawa.SourceType"));
          ae.addMember("value", encType, Type.javalangStringType);
          RuntimeAnnotationsAttr.maybeAddAnnotation(field, ae);
        }
      }
      if (haveName)
      {
        Object fsymbol = getSymbol();
        boolean havePrefix;
        String prefix;
        String uri;
        boolean havePrefix;
        boolean haveUri;
        if ((fsymbol instanceof Symbol))
        {
          String uri = ((Symbol)fsymbol).getNamespaceURI();
          String prefix = ((Symbol)fsymbol).getPrefix();
          if (uri == null)
            uri = "";
          boolean haveUri = !"".equals(uri);
          havePrefix = !"".equals(prefix);
        }
        else
        {
          uri = prefix = "";
          haveUri = havePrefix = 0;
        }
        
        if ((haveUri) || (havePrefix) || (!Mangling.demangleName(fname, true).equals(dname)))
        {

          AnnotationEntry ae = new AnnotationEntry(ClassType.make("gnu.expr.SourceName"));
          ae.addMember("name", dname, Type.javalangStringType);
          if (haveUri)
            ae.addMember("uri", uri, Type.javalangStringType);
          if (havePrefix)
            ae.addMember("prefix", prefix, Type.javalangStringType);
          RuntimeAnnotationsAttr.maybeAddAnnotation(field, ae);
        }
      }
      if ((value instanceof QuoteExp))
      {
        Object val = ((QuoteExp)value).getValue();
        if ((field.getStaticFlag()) && (val != null) && (val.getClass().getName().equals(ftype.getName())))
        {


          Literal literal = litTable.findLiteral(val);
          if (field == null) {
            literal.assign(field, litTable);
          }
        } else if (((ftype instanceof PrimType)) || ("java.lang.String".equals(ftype.getName())))
        {

          if ((val instanceof Char))
            val = IntNum.make(((Char)val).intValue());
          field.setConstantValue(val, frameType);
          return;
        }
      }
    }
    
    if ((!shouldEarlyInit()) && ((context instanceof ModuleExp)) && ((isIndirectBinding()) || ((value != null) && (!(value instanceof ClassExp)))))
    {



      BindingInitializer.create(this, value, comp);
    }
  }
  

  Location makeIndirectLocationFor()
  {
    Symbol sym = (symbol instanceof Symbol) ? (Symbol)symbol : Namespace.EmptyNamespace.getSymbol(symbol.toString().intern());
    
    return Location.make(sym);
  }
  





  public static Declaration getDeclarationFromStatic(String cname, String fname)
  {
    ClassType clas = ClassType.make(cname);
    gnu.bytecode.Field fld = clas.getDeclaredField(fname);
    Declaration decl = new Declaration(fname, fld);
    decl.setFlag(18432L);
    return decl;
  }
  





  public static Declaration getDeclarationValueFromStatic(String className, String fieldName, String name)
  {
    try
    {
      Class cls = Class.forName(className);
      java.lang.reflect.Field fld = cls.getDeclaredField(fieldName);
      Object value = fld.get(null);
      
      Declaration decl = new Declaration(name, ClassType.make(className).getDeclaredField(fieldName));
      


      decl.noteValue(new QuoteExp(value));
      decl.setFlag(18432L);
      return decl;
    }
    catch (Exception ex)
    {
      throw new WrappedException(ex);
    }
  }
  
  public static Declaration getDeclaration(Named proc)
  {
    return getDeclaration(proc, proc.getName());
  }
  
  public static Declaration getDeclaration(Object proc, String name)
  {
    gnu.bytecode.Field procField = null;
    if (name != null)
    {

























      Class procClass = PrimProcedure.getProcedureClass(proc);
      if (procClass != null)
      {
        ClassType procType = (ClassType)Type.make(procClass);
        String fname = Mangling.mangleNameIfNeeded(name);
        procField = procType.getDeclaredField(fname);
      }
    }
    
    if (procField != null)
    {
      int fflags = procField.getModifiers();
      if ((fflags & 0x8) != 0)
      {
        Declaration decl = new Declaration(name, procField);
        decl.noteValue(new QuoteExp(proc));
        if ((fflags & 0x10) != 0)
          decl.setFlag(16384L);
        return decl;
      }
    }
    return null;
  }
  




  public Expression getInitValue() { return initValue; }
  public void setInitValue(Expression init) { initValue = init; }
  



  static final ValueSource unknownValueInstance = new ValueSource(0, null, 0);
  
  static final ValueSource[] unknownValueValues = { unknownValueInstance };
  
  public boolean hasUnknownValue() { return values == unknownValueValues; }
  











  public final Expression getValue()
  {
    if (nvalues == 0)
    {
      if ((field != null) && (field.getDeclaringClass().isExisting()) && ((field.getModifiers() & 0x18) == 24) && (!isIndirectBinding()))
      {


        try
        {


          Expression value = new QuoteExp(field.getReflectField().get(null));
          noteValue(value);
          return value;
        }
        catch (Exception ex) {}
      }
      

      return QuoteExp.undefined_exp;
    }
    if (nvalues == 1)
      return values[0].getValue(this);
    return null;
  }
  
  public Expression getValueRaw()
  {
    if (nvalues == 0)
      return QuoteExp.undefined_exp;
    if (nvalues == 1)
      return values[0].getValue(this);
    return null;
  }
  


  public final void setValue(Expression value)
  {
    values = null;
    nvalues = 0;
    noteValue(value);
  }
  

  public final Object getConstantValue()
  {
    Object v = getValue();
    if ((!(v instanceof QuoteExp)) || (v == QuoteExp.undefined_exp))
      return null;
    return ((QuoteExp)v).getValue();
  }
  
  public final boolean hasConstantValue()
  {
    Object v = getValue();
    return ((v instanceof QuoteExp)) && (v != QuoteExp.undefined_exp);
  }
  
  public LambdaExp getLambdaValue()
  {
    if ((!isAlias()) && (nvalues == 1))
    {
      Expression val = values[0].getValue(this);
      if ((val != null) && (val.getClass() == LambdaExp.class))
        return (LambdaExp)val;
    }
    return null;
  }
  
  public void noteValue(Expression value)
  {
    checkNameDecl(value);
    if (value == null) {
      noteValueUnknown();
    } else if (values != unknownValueValues) {
      noteValue(new ValueSource(1, value, 0));
    }
  }
  
  void noteValue(ValueSource value) {
    if (values == unknownValueValues)
      throw new InternalError();
    if (values == null) {
      values = new ValueSource[4];
    } else if (nvalues >= values.length)
    {
      ValueSource[] tmp = new ValueSource[2 * nvalues];
      System.arraycopy(values, 0, tmp, 0, nvalues);
      values = tmp;
    }
    values[(nvalues++)] = value;
  }
  
  public void noteValueConstant(Object value)
  {
    if (values != unknownValueValues)
    {
      noteValue(new QuoteExp(value));
    }
  }
  
  public void noteValueUnknown()
  {
    checkNameDecl(null);
    values = unknownValueValues;
    nvalues = 1;
  }
  
  public void noteValueFromSet(SetExp setter)
  {
    if (values != unknownValueValues)
    {
      checkNameDecl(new_value);
      valueIndex = nvalues;
      noteValue(new ValueSource(2, setter, 0));
    }
  }
  
  public void noteValueFromLet(ScopeExp letter)
  {
    Expression init = getInitValue();
    if ((init != QuoteExp.undefined_exp) && (values != unknownValueValues))
    {
      checkNameDecl(init);
      noteValue(new ValueSource(3, letter, 0));
    }
  }
  
  public void noteValueFromApply(ApplyExp app, int index)
  {
    if (values != unknownValueValues) {
      noteValue(new ValueSource(4, app, index));
    }
  }
  

  public boolean patchSymbolFromSet()
  {
    if ((nvalues != 1) || (values[0].kind != 2))
      return false;
    SetExp sexp = (SetExp)values[0].base;
    setSymbol(((SetExp)values[0].base).getSymbol());
    return true;
  }
  
  private void checkNameDecl(Expression value) {
    if (nvalues == 1) {
      Expression old = values[0].getValue(this);
      if (old == value)
        return;
      if ((old instanceof LambdaExp))
        nameDecl = null;
    }
    if ((value instanceof LambdaExp)) {
      nameDecl = (nvalues == 0 ? this : null);
    }
  }
  
  public static class ValueSource
  {
    static final int UNKNOWN_KIND = 0;
    static final int GENERAL_KIND = 1;
    static final int SET_RHS_KIND = 2;
    static final int LET_INIT_KIND = 3;
    static final int APPLY_KIND = 4;
    public int kind;
    public Expression base;
    public int index;
    
    ValueSource(int kind, Expression base, int index) {
      this.kind = kind;
      this.base = base;
      this.index = index;
    }
    
    Expression getValue(Declaration decl)
    {
      switch (kind)
      {
      case 0: 
        return null;
      case 1: 
        return base;
      case 2: 
        return base).new_value;
      case 3: 
        return decl.getInitValue();
      case 4: 
        ApplyExp app = (ApplyExp)base;
        int i = index;
        


        Compilation comp = Compilation.getCurrent();
        Expression afunc = app.getFunction();
        if (comp.isSimpleApplyFunction(afunc)) {
          i++;
        } else if (comp.isApplyFunction(afunc))
          return null;
        if (i >= app.getArgCount())
          return null;
        return app.getArg(i);
      }
      throw new Error();
    }
  }
}
