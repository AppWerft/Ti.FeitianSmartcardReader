package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.functions.AppendValues;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.io.OutPort;
import gnu.kawa.reflect.CompileArrays;
import gnu.kawa.util.IdentityHashTable;
import gnu.mapping.CallContext;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.util.LinkedList;
















public class ApplyExp
  extends Expression
{
  Expression func;
  Expression[] args;
  public static final int TAILCALL = 2;
  public static final int INLINE_IF_CONSTANT = 4;
  public static final int MAY_CONTAIN_BACK_JUMP = 8;
  public static final int IS_SUPER_INIT = 16;
  LambdaExp context;
  public ApplyExp nextCall;
  public int firstKeywordArgIndex;
  public int numKeywordArgs;
  public int firstSpliceArg = -1;
  
  public final Expression getFunction() { return func; }
  public final Expression[] getArgs() { return args; }
  public final int getArgCount() { return args.length; }
  public void setFunction(Expression func) { this.func = func; }
  public void setFunction(Procedure proc) { func = new QuoteExp(proc); }
  public void setArgs(Expression[] args) { this.args = args; }
  public Expression getArg(int i) { return args[i]; }
  public void setArg(int i, Expression arg) { args[i] = arg; }
  public final boolean isTailCall() { return getFlag(2); }
  
  public final void setTailCall(boolean tailCall) { setFlag(tailCall, 2); }
  
  public ApplyExp setFuncArgs(Expression func, Expression[] args)
  {
    setFunction(func);
    setArgs(args);
    setFlag(false, 1);
    return this;
  }
  
  public ApplyExp setFuncArgs(Procedure proc, Expression[] args)
  {
    return setFuncArgs(new QuoteExp(proc), args);
  }
  

  public final Object getFunctionValue()
  {
    return (func instanceof QuoteExp) ? ((QuoteExp)func).getValue() : null;
  }
  



  public void adjustSplice(ApplyExp src, int delta)
  {
    if (firstSpliceArg >= 0)
      firstSpliceArg += delta;
    if (firstKeywordArgIndex > 0)
      firstKeywordArgIndex += delta;
  }
  
  public int spliceCount() {
    int count = 0;
    if (firstSpliceArg >= 0) {
      Expression[] args = this.args;
      int nargs = args.length;
      for (int i = firstSpliceArg; i < nargs; i++) {
        if (MakeSplice.argIfSplice(args[i]) != null)
          count++;
      }
    }
    return count;
  }
  
  public boolean isSimple() {
    return (firstSpliceArg < 0) && (firstKeywordArgIndex == 0);
  }
  
  public boolean isSimple(int min) {
    return (isSimple()) && (getArgCount() >= min);
  }
  
  public boolean isSimple(int min, int max) {
    int ac = getArgCount();
    return (isSimple()) && (ac >= min) && (ac <= max);
  }
  
  public boolean isAppendValues() {
    return ((func instanceof QuoteExp)) && (((QuoteExp)func).getValue() == AppendValues.appendValues);
  }
  
  public ApplyExp(Expression f, Expression... a)
  {
    func = f;args = a; }
  
  public ApplyExp(Procedure p, Expression... a) { this(new QuoteExp(p), a); }
  
  public ApplyExp(gnu.bytecode.Method m, Expression... a)
  {
    this(new QuoteExp(new PrimProcedure(m)), a);
  }
  
  protected boolean mustCompile() { return false; }
  
  public void apply(CallContext ctx) throws Throwable
  {
    Object proc = func.eval(ctx);
    int n = args.length;
    Object[] vals = new Object[n];
    for (int i = 0; i < n; i++)
      vals[i] = args[i].eval(ctx);
    ((Procedure)proc).checkN(vals, ctx);
  }
  
  private static void compileToArray(Expression[] args, int start, Compilation comp)
  {
    CodeAttr code = comp.getCode();
    int argslength = args.length;
    int nargs = argslength - start;
    if (nargs == 0)
    {
      code.emitGetStatic(Compilation.noArgsField);
      return;
    }
    code.emitPushInt(nargs);
    code.emitNewArray(Type.pointer_type);
    for (int i = start; i < argslength; i++)
    {
      Expression arg = args[i];
      if ((comp.usingCPStyle()) && (!(arg instanceof QuoteExp)) && (!(arg instanceof ReferenceExp)))
      {









        arg.compileWithPosition(comp, Target.pushObject);
        code.emitSwap();
        code.emitDup(1, 1);
        code.emitSwap();
        code.emitPushInt(i);
        code.emitSwap();
      }
      else
      {
        code.emitDup(Compilation.objArrayType);
        code.emitPushInt(i);
        arg.compileWithPosition(comp, Target.pushObject);
      }
      code.emitArrayStore(Type.pointer_type);
    }
  }
  
  public void compile(Compilation comp, Target target)
  {
    compile(this, comp, target, true);
    if (getFlag(16)) {
      ((ClassExp)comp.currentScope().currentLambda().getOuter()).compileCallInitMethods(comp);
    }
  }
  

  public static void compile(ApplyExp exp, Compilation comp, Target target)
  {
    compile(exp, comp, target, false);
  }
  
  static void compile(ApplyExp exp, Compilation comp, Target target, boolean checkInlineable)
  {
    int args_length = exp.args.length;
    Expression exp_func = func;
    LambdaExp func_lambda = null;
    String func_name = null;
    Declaration owner = null;
    Object quotedValue = null;
    if ((exp_func instanceof LambdaExp)) {
      func_lambda = (LambdaExp)exp_func;
      func_name = func_lambda.getName();
      if (func_name == null)
        func_name = "<lambda>";
    } else if ((exp_func instanceof ReferenceExp)) {
      ReferenceExp func_ref = (ReferenceExp)exp_func;
      owner = func_ref.contextDecl();
      Declaration func_decl = binding;
      
      Expression dval;
      while ((func_decl != null) && (func_decl.isAlias()) && (((dval = func_decl.getValueRaw()) instanceof ReferenceExp))) {
        func_ref = (ReferenceExp)dval;
        if ((owner != null) || (func_decl.needsContext()) || (binding == null)) {
          break;
        }
        func_decl = binding;
        owner = func_ref.contextDecl();
      }
      if (!func_decl.getFlag(65536L)) {
        Expression value = func_decl.getValue();
        func_name = func_decl.getName();
        if ((value != null) && ((value instanceof LambdaExp)))
          func_lambda = (LambdaExp)value;
        if ((value != null) && ((value instanceof QuoteExp)))
          quotedValue = ((QuoteExp)value).getValue();
      }
    } else if ((exp_func instanceof QuoteExp)) {
      quotedValue = ((QuoteExp)exp_func).getValue();
    }
    if ((checkInlineable) && ((quotedValue instanceof Procedure))) {
      Procedure proc = (Procedure)quotedValue;
      if (((target instanceof IgnoreTarget)) && (proc.isSideEffectFree())) {
        for (int i = 0; i < args_length; i++)
          exp.args[i].compile(comp, target);
        return;
      }
      try {
        if (inlineCompile(proc, exp, comp, target))
          return;
      } catch (Error ex) {
        throw ex;
      } catch (Throwable ex) {
        SourceMessages msg = comp.getMessages();
        msg.error('f', "caught exception in inline-compiler for " + quotedValue + " - " + ex, ex);
        

        throw new SyntaxException(msg);
      }
    }
    
    CodeAttr code = comp.getCode();
    


    boolean tail_recurse = (exp.isTailCall()) && (func_lambda != null) && (func_lambda == curLambda) && (opt_args == 0) && (keywords == null);
    




    int spliceCount = exp.spliceCount();
    int nonSpliceCount = args_length - spliceCount;
    
    if (func_lambda != null)
    {
      if (((max_args >= 0) && (nonSpliceCount > max_args)) || ((nonSpliceCount < min_args) && (spliceCount == 0)))
      {

        throw new Error("internal error - wrong number of parameters for " + func_lambda);
      }
      int conv = func_lambda.getCallConvention();
      if ((primMethods == null) && (!func_lambda.isClassGenerated()) && (!func_lambda.getInlineOnly()))
      {
        func_lambda.allocMethod(func_lambda.outerLambda(), comp);
      }
      gnu.bytecode.Method method;
      if ((comp.inlineOk(func_lambda)) && (!tail_recurse) && ((conv <= 2) || ((conv == 3) && (!exp.isTailCall()))) && ((method = func_lambda.getMethod(nonSpliceCount, spliceCount)) != null) && ((firstSpliceArg < 0) || ((PrimProcedure.takesVarArgs(method)) && (min_args <= firstSpliceArg))))
      {








        PrimProcedure pproc = new PrimProcedure(method, func_lambda);
        boolean is_static = method.getStaticFlag();
        boolean extraArg = false;
        
        if ((!is_static) || (func_lambda.declareClosureEnv() != null))
        {
          if (is_static)
            extraArg = true;
          if (curLambda == func_lambda) {
            code.emitLoad(closureEnv != null ? closureEnv : thisVariable);

          }
          else if (owner != null) {
            owner.load(null, 0, comp, Target.pushObject);
          } else {
            func_lambda.getOwningLambda().loadHeapFrame(comp);
          }
        }
        pproc.compile(extraArg ? Type.voidType : null, exp, comp, target);
        
        return;
      }
    }
    
























































    if ((func_lambda != null) && (func_lambda.getInlineOnly()) && (!tail_recurse) && (min_args == nonSpliceCount))
    {

      pushArgs(func_lambda, exp.args, exp.args.length, null, comp);
      if ((func_lambda.getFlag(128)) || ((exp.isTailCall()) && (nameDecl != null) && (!func_lambda.nestedIn(curLambda))))
      {



        if (startForInlining == null) {
          startForInlining = new Label(code);
          if (curLambda.pendingInlines == null)
            curLambda.pendingInlines = new LinkedList();
          curLambda.pendingInlines.add(func_lambda);
          curLambda.pendingInlines.add(target);
        }
        code.emitTailCall(false, startForInlining);
        return;
      }
      func_lambda.compileAsInlined(comp, target);
      return;
    }
    
    if ((curLambda.isHandlingTailCalls()) && ((exp.isTailCall()) || ((target instanceof ConsumerTarget))) && (!curLambda.getInlineOnly()))
    {


      exp_func.compile(comp, new StackTarget(Compilation.typeProcedure));
      
      if ((args_length <= 4) && (exp.isSimple()))
      {
        for (int i = 0; i < args_length; i++)
          exp.args[i].compileWithPosition(comp, Target.pushObject);
        comp.loadCallContext();
        code.emitInvoke(Compilation.typeProcedure.getDeclaredMethod("check" + args_length, args_length + 1));

      }
      else
      {

        if (firstSpliceArg >= 0) {
          CompileArrays.createArray(Type.objectType, comp, exp.args, 0, args_length);
        }
        else
          compileToArray(exp.args, 0, comp);
        comp.loadCallContext();
        code.emitInvoke(Compilation.typeProcedure.getDeclaredMethod("checkN", 2));
      }
      
      finishTrampoline(exp.isTailCall(), target, comp);
      return;
    }
    
    if (firstSpliceArg >= 0) {
      Expression[] args = exp.getArgs();
      exp_func.compile(comp, Target.pushObject);
      CompileArrays.createArray(Type.objectType, comp, args, 0, args.length);
      
      code.emitInvoke(Compilation.typeProcedure.getDeclaredMethod("applyN", 1));
      
      target.compileFromStack(comp, Type.pointer_type);
      return;
    }
    
    if (!tail_recurse) {
      exp_func.compile(comp, new StackTarget(Compilation.typeProcedure));
    }
    boolean toArray = max_args < 0;
    

    int[] incValues = null;
    gnu.bytecode.Method method; gnu.bytecode.Method method; if (tail_recurse)
    {
      int fixed = min_args;
      incValues = new int[fixed];
      pushArgs(func_lambda, exp.args, fixed, incValues, comp);
      if (toArray)
        compileToArray(exp.args, fixed, comp);
      method = null;
    } else { gnu.bytecode.Method method;
      if (toArray)
      {
        compileToArray(exp.args, 0, comp);
        method = Compilation.applyNmethod;
      }
      else
      {
        for (int i = 0; i < args_length; i++)
        {
          exp.args[i].compileWithPosition(comp, Target.pushObject);
          if (!code.reachableHere())
            break;
        }
        method = Compilation.applymethods[args_length];
      } }
    if (!code.reachableHere())
    {
      if (comp.warnUnreachable())
        comp.error('w', "unreachable code");
      return;
    }
    if (tail_recurse)
    {
      Label startLabel = startForInlining;
      boolean mustStore = startLabel == null;
      if ((incValues != null) && (!mustStore))
      {
        int i = incValues.length; do { i--; if (i < 0) break;
        } while (incValues[i] == 65536);
        
        mustStore = true;
      }
      

      if (mustStore)
      {
        popParams(code, func_lambda, incValues, toArray);
        startLabel = func_lambda.getVarScope().getStartLabel();
      }
      code.emitTailCall(false, startLabel);
      return;
    }
    code.emitInvokeVirtual(method);
    target.compileFromStack(comp, Type.pointer_type);
  }
  
  static void finishTrampoline(boolean isTailCall, Target target, Compilation comp) {
    CodeAttr code = comp.getCode();
    ClassType typeContext = Compilation.typeCallContext;
    if (isTailCall) {
      code.emitReturn();
    } else if (((target instanceof IgnoreTarget)) || (((ConsumerTarget)target).isContextTarget()))
    {
      comp.loadCallContext();
      code.emitInvoke(typeContext.getDeclaredMethod("runUntilDone", 0));
    } else {
      comp.loadCallContext();
      code.emitLoad(((ConsumerTarget)target).getConsumerVariable());
      code.emitInvoke(typeContext.getDeclaredMethod("runUntilValue", 1));
    }
  }
  
  public Expression deepCopy(IdentityHashTable mapper)
  {
    Expression f = deepCopy(func, mapper);
    Expression[] a = deepCopy(args, mapper);
    if (((f == null) && (func != null)) || ((a == null) && (args != null)))
      return null;
    ApplyExp copy = new ApplyExp(f, a);
    flags = getFlags();
    return copy;
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    return visitor.visitApplyExp(this, d);
  }
  

  public void visitArgs(InlineCalls visitor) { visitArgs(visitor, null); }
  
  public void visitArgs(InlineCalls visitor, LambdaExp lexp) {
    int nargs = args.length;
    Type dtype = isAppendValues() ? null : InlineCalls.ValueNeededType.instance;
    

    Declaration param = (lexp == null) || (firstKeywordArgIndex != 0) || (keywords != null) ? null : lexp.firstDecl();
    



    for (int i = 0; (i < nargs) && (visitor.getExitValue() == null); i++)
    {
      while ((param != null) && ((param.isThisParameter()) || (param.getFlag(1099511627776L))))
      {
        param = param.nextDecl(); }
      Type ptype = dtype;
      if ((param != null) && (i < min_args + opt_args) && ((firstSpliceArg < 0) || (i > firstSpliceArg)))
      {
        ptype = param.getType();
      } else if ((param != null) && (param.getFlag(4398046511104L)))
      {
        Type vtype = param.getType();
        if ((vtype instanceof ArrayType))
          ptype = ((ArrayType)vtype).getComponentType();
      }
      args[i] = visitor.visitAndUpdate(args[i], ptype);
      if ((param != null) && (!param.getFlag(4398046511104L))) {
        param = param.nextDecl();
      }
    }
  }
  
  protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
    func = visitor.visitAndUpdate(func, d);
    if (exitValue == null) {
      args = visitor.visitExps(args, args.length, d);
    }
  }
  
  public void print(OutPort out) {
    out.startLogicalBlock("(Apply", ")", 2);
    if (isTailCall())
      out.print(" [tailcall]");
    if ((type != null) && (type != Type.pointer_type))
    {
      out.print(" => ");
      out.print(type);
    }
    out.writeSpaceFill();
    printLineColumn(out);
    func.print(out);
    for (int i = 0; (args != null) && (i < args.length); i++)
    {
      out.writeSpaceLinear();
      args[i].print(out);
    }
    out.endLogicalBlock(")");
  }
  



  private static void pushArgs(LambdaExp lexp, Expression[] args, int args_length, int[] incValues, Compilation comp)
  {
    Declaration param = lexp.firstDecl();
    for (int i = 0; i < args_length; i++)
    {
      Expression arg = args[i];
      if (param.ignorable()) {
        arg.compile(comp, Target.Ignore);
      } else if ((incValues == null) || ((incValues[i] = SetExp.canUseInc(arg, param)) == 65536))
      {


        arg.compileWithPosition(comp, StackTarget.getInstance(param.getType()));
      }
      param = param.nextDecl();
    }
  }
  

  static void popParams(CodeAttr code, LambdaExp lexp, int[] incValues, boolean toArray)
  {
    Variable vars = lexp.getVarScope().firstVar();
    Declaration decls = lexp.firstDecl();
    if ((vars != null) && (vars.getName() == "this"))
      vars = vars.nextVar();
    if ((vars != null) && (vars.getName() == "$ctx"))
      vars = vars.nextVar();
    if ((vars != null) && (vars.getName() == "$closureEnv"))
      vars = vars.nextVar();
    popParams(code, 0, min_args, toArray, incValues, decls, vars);
  }
  




  private static void popParams(CodeAttr code, int paramNo, int count, boolean toArray, int[] incValues, Declaration decl, Variable vars)
  {
    if (count > 0)
    {
      count--;
      popParams(code, paramNo + 1, count, toArray, incValues, decl.nextDecl(), decl.getVariable() == null ? vars : vars.nextVar());
      
      if (!decl.ignorable())
      {
        if ((incValues != null) && (incValues[paramNo] != 65536)) {
          code.emitInc(vars, (short)incValues[paramNo]);
        } else {
          code.emitStore(vars);
        }
      }
    } else if (toArray) {
      code.emitStore(vars);
    }
  }
  
  public boolean side_effects() {
    Object value = derefFunc(func).valueIfConstant();
    if (((value instanceof Procedure)) && (((Procedure)value).isSideEffectFree()))
    {

      Expression[] a = args;
      int alen = a.length;
      for (int i = 0; i < alen; i++)
      {
        if (a[i].side_effects())
          return true;
      }
      return false;
    }
    return true;
  }
  
  static Expression derefFunc(Expression afunc)
  {
    if ((afunc instanceof ReferenceExp))
    {
      Declaration func_decl = binding;
      func_decl = Declaration.followAliases(func_decl);
      if ((func_decl != null) && (!func_decl.getFlag(65536L)))
        afunc = func_decl.getValue();
    }
    return afunc;
  }
  
  protected Type calculateType()
  {
    Expression afunc = derefFunc(func);
    if ((afunc instanceof QuoteExp))
    {
      Object value = ((QuoteExp)afunc).getValue();
      
      if ((value instanceof Procedure)) {
        type = ((Procedure)value).getReturnType(args);
      }
    } else if ((afunc instanceof LambdaExp))
    {
      type = ((LambdaExp)afunc).getReturnType();
    }
    return type;
  }
  
  public static boolean isInlineable(Procedure proc) {
    return ((proc instanceof Inlineable)) || (Procedure.compilerKey.get(proc) != null) || (proc.getProperty(Procedure.compilerXKey, null) != null);
  }
  



  static boolean inlineCompile(Procedure proc, ApplyExp exp, Compilation comp, Target target)
    throws Throwable
  {
    if ((proc instanceof PrimProcedure))
      return ((PrimProcedure)proc).compile(exp, comp, target);
    Object propval = proc.getProperty(Procedure.compilerXKey, null);
    if ((propval instanceof CharSequence)) {
      Object method = InlineCalls.resolveInliner(proc, propval.toString(), compilerMethodType);
      

      if (method != null) {
        propval = method;
      }
    }
    



    if ((propval instanceof java.lang.reflect.Method)) {
      return ((Boolean)((java.lang.reflect.Method)propval).invoke(null, new Object[] { exp, comp, target, proc })).booleanValue();
    }
    
    if (propval != null) {
      comp.error('e', "compiler property string for " + proc + " is not of the form CLASS:METHOD");
      
      return false;
    }
    if (!exp.isSimple())
      return false;
    Inlineable compiler;
    Inlineable compiler; if ((proc instanceof Inlineable)) {
      compiler = (Inlineable)proc; } else { Inlineable compiler;
      if ((propval = Procedure.compilerKey.get(proc)) != null) {
        compiler = (Inlineable)Procedure.compilerKey.get(proc);
      } else
        compiler = null; }
    if (compiler == null)
      return false;
    compiler.compile(exp, comp, target);
    return true;
  }
  
  public final Expression inlineIfConstant(Procedure proc, InlineCalls visitor)
  {
    return inlineIfConstant(proc, visitor.getMessages());
  }
  






  public final Expression inlineIfConstant(Procedure proc, SourceMessages messages)
  {
    int len = args.length;
    Object[] vals = new Object[len];
    int i = len; for (;;) { i--; if (i < 0)
        break;
      Expression arg = args[i];
      if ((arg instanceof ReferenceExp))
      {
        Declaration decl = ((ReferenceExp)arg).getBinding();
        if (decl != null)
        {
          arg = decl.getValue();
          if (arg == QuoteExp.undefined_exp)
            return this;
        }
      }
      if (!(arg instanceof QuoteExp))
        return this;
      vals[i] = ((QuoteExp)arg).getValue();
    }
    try
    {
      return new QuoteExp(proc.applyN(vals), type).setLine(this);
    }
    catch (Error ex)
    {
      throw ex;
    }
    catch (Throwable ex)
    {
      if (messages != null)
        messages.error('w', "call to " + proc + " throws " + ex);
    }
    return this;
  }
  

  public String toString()
  {
    if (this == LambdaExp.unknownContinuation)
      return "ApplyExp[unknownContinuation]";
    return "ApplyExp/" + (args == null ? 0 : args.length) + '[' + func + ']';
  }
  








  private static final Class[] compilerMethodType = { ApplyExp.class, Compilation.class, Target.class, Procedure.class };
}
