// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.mapping.PropertySet;
import gnu.bytecode.Variable;
import gnu.kawa.io.OutPort;
import gnu.bytecode.ArrayType;
import gnu.kawa.util.IdentityHashTable;
import gnu.bytecode.ClassType;
import gnu.text.SourceMessages;
import gnu.kawa.reflect.CompileArrays;
import java.util.LinkedList;
import gnu.bytecode.Label;
import gnu.text.SyntaxException;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.bytecode.Method;
import gnu.kawa.functions.AppendValues;
import gnu.kawa.functions.MakeSplice;
import gnu.mapping.Procedure;

public class ApplyExp extends Expression
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
    public int firstSpliceArg;
    private static final Class[] compilerMethodType;
    
    public final Expression getFunction() {
        return this.func;
    }
    
    public final Expression[] getArgs() {
        return this.args;
    }
    
    public final int getArgCount() {
        return this.args.length;
    }
    
    public void setFunction(final Expression func) {
        this.func = func;
    }
    
    public void setFunction(final Procedure proc) {
        this.func = new QuoteExp(proc);
    }
    
    public void setArgs(final Expression[] args) {
        this.args = args;
    }
    
    public Expression getArg(final int i) {
        return this.args[i];
    }
    
    public void setArg(final int i, final Expression arg) {
        this.args[i] = arg;
    }
    
    public final boolean isTailCall() {
        return this.getFlag(2);
    }
    
    public final void setTailCall(final boolean tailCall) {
        this.setFlag(tailCall, 2);
    }
    
    public ApplyExp setFuncArgs(final Expression func, final Expression[] args) {
        this.setFunction(func);
        this.setArgs(args);
        this.setFlag(false, 1);
        return this;
    }
    
    public ApplyExp setFuncArgs(final Procedure proc, final Expression[] args) {
        return this.setFuncArgs(new QuoteExp(proc), args);
    }
    
    public final Object getFunctionValue() {
        return (this.func instanceof QuoteExp) ? ((QuoteExp)this.func).getValue() : null;
    }
    
    public void adjustSplice(final ApplyExp src, final int delta) {
        if (src.firstSpliceArg >= 0) {
            this.firstSpliceArg = src.firstSpliceArg + delta;
        }
        if (src.firstKeywordArgIndex > 0) {
            this.firstKeywordArgIndex = src.firstKeywordArgIndex + delta;
        }
    }
    
    public int spliceCount() {
        int count = 0;
        if (this.firstSpliceArg >= 0) {
            final Expression[] args = this.args;
            for (int nargs = args.length, i = this.firstSpliceArg; i < nargs; ++i) {
                if (MakeSplice.argIfSplice(args[i]) != null) {
                    ++count;
                }
            }
        }
        return count;
    }
    
    public boolean isSimple() {
        return this.firstSpliceArg < 0 && this.firstKeywordArgIndex == 0;
    }
    
    public boolean isSimple(final int min) {
        return this.isSimple() && this.getArgCount() >= min;
    }
    
    public boolean isSimple(final int min, final int max) {
        final int ac = this.getArgCount();
        return this.isSimple() && ac >= min && ac <= max;
    }
    
    public boolean isAppendValues() {
        return this.func instanceof QuoteExp && ((QuoteExp)this.func).getValue() == AppendValues.appendValues;
    }
    
    public ApplyExp(final Expression f, final Expression... a) {
        this.firstSpliceArg = -1;
        this.func = f;
        this.args = a;
    }
    
    public ApplyExp(final Procedure p, final Expression... a) {
        this(new QuoteExp(p), a);
    }
    
    public ApplyExp(final Method m, final Expression... a) {
        this(new QuoteExp(new PrimProcedure(m)), a);
    }
    
    @Override
    protected boolean mustCompile() {
        return false;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        final Object proc = this.func.eval(ctx);
        final int n = this.args.length;
        final Object[] vals = new Object[n];
        for (int i = 0; i < n; ++i) {
            vals[i] = this.args[i].eval(ctx);
        }
        ((Procedure)proc).checkN(vals, ctx);
    }
    
    private static void compileToArray(final Expression[] args, final int start, final Compilation comp) {
        final CodeAttr code = comp.getCode();
        final int argslength = args.length;
        final int nargs = argslength - start;
        if (nargs == 0) {
            code.emitGetStatic(Compilation.noArgsField);
            return;
        }
        code.emitPushInt(nargs);
        code.emitNewArray(Type.pointer_type);
        for (int i = start; i < argslength; ++i) {
            final Expression arg = args[i];
            if (comp.usingCPStyle() && !(arg instanceof QuoteExp) && !(arg instanceof ReferenceExp)) {
                arg.compileWithPosition(comp, Target.pushObject);
                code.emitSwap();
                code.emitDup(1, 1);
                code.emitSwap();
                code.emitPushInt(i);
                code.emitSwap();
            }
            else {
                code.emitDup(Compilation.objArrayType);
                code.emitPushInt(i);
                arg.compileWithPosition(comp, Target.pushObject);
            }
            code.emitArrayStore(Type.pointer_type);
        }
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        compile(this, comp, target, true);
        if (this.getFlag(16)) {
            ((ClassExp)comp.currentScope().currentLambda().getOuter()).compileCallInitMethods(comp);
        }
    }
    
    public static void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        compile(exp, comp, target, false);
    }
    
    static void compile(final ApplyExp exp, final Compilation comp, final Target target, final boolean checkInlineable) {
        final int args_length = exp.args.length;
        final Expression exp_func = exp.func;
        LambdaExp func_lambda = null;
        String func_name = null;
        Declaration owner = null;
        Object quotedValue = null;
        if (exp_func instanceof LambdaExp) {
            func_lambda = (LambdaExp)exp_func;
            func_name = func_lambda.getName();
            if (func_name == null) {
                func_name = "<lambda>";
            }
        }
        else if (exp_func instanceof ReferenceExp) {
            ReferenceExp func_ref = (ReferenceExp)exp_func;
            owner = func_ref.contextDecl();
            Declaration func_decl;
            Expression dval;
            for (func_decl = func_ref.binding; func_decl != null && func_decl.isAlias() && (dval = func_decl.getValueRaw()) instanceof ReferenceExp; func_decl = func_ref.binding, owner = func_ref.contextDecl()) {
                func_ref = (ReferenceExp)dval;
                if (owner != null || func_decl.needsContext()) {
                    break;
                }
                if (func_ref.binding == null) {
                    break;
                }
            }
            if (!func_decl.getFlag(65536L)) {
                final Expression value = func_decl.getValue();
                func_name = func_decl.getName();
                if (value != null && value instanceof LambdaExp) {
                    func_lambda = (LambdaExp)value;
                }
                if (value != null && value instanceof QuoteExp) {
                    quotedValue = ((QuoteExp)value).getValue();
                }
            }
        }
        else if (exp_func instanceof QuoteExp) {
            quotedValue = ((QuoteExp)exp_func).getValue();
        }
        if (checkInlineable && quotedValue instanceof Procedure) {
            final Procedure proc = (Procedure)quotedValue;
            if (target instanceof IgnoreTarget && proc.isSideEffectFree()) {
                for (int i = 0; i < args_length; ++i) {
                    exp.args[i].compile(comp, target);
                }
                return;
            }
            try {
                if (inlineCompile(proc, exp, comp, target)) {
                    return;
                }
            }
            catch (Error ex) {
                throw ex;
            }
            catch (Throwable ex2) {
                final SourceMessages msg = comp.getMessages();
                msg.error('f', "caught exception in inline-compiler for " + quotedValue + " - " + ex2, ex2);
                throw new SyntaxException(msg);
            }
        }
        final CodeAttr code = comp.getCode();
        final boolean tail_recurse = exp.isTailCall() && func_lambda != null && func_lambda == comp.curLambda && func_lambda.opt_args == 0 && func_lambda.keywords == null;
        final int spliceCount = exp.spliceCount();
        final int nonSpliceCount = args_length - spliceCount;
        if (func_lambda != null) {
            if ((func_lambda.max_args >= 0 && nonSpliceCount > func_lambda.max_args) || (nonSpliceCount < func_lambda.min_args && spliceCount == 0)) {
                throw new Error("internal error - wrong number of parameters for " + func_lambda);
            }
            final int conv = func_lambda.getCallConvention();
            if (func_lambda.primMethods == null && !func_lambda.isClassGenerated() && !func_lambda.getInlineOnly()) {
                func_lambda.allocMethod(func_lambda.outerLambda(), comp);
            }
            final Method method;
            if (comp.inlineOk(func_lambda) && !tail_recurse && (conv <= 2 || (conv == 3 && !exp.isTailCall())) && (method = func_lambda.getMethod(nonSpliceCount, spliceCount)) != null && (exp.firstSpliceArg < 0 || (PrimProcedure.takesVarArgs(method) && func_lambda.min_args <= exp.firstSpliceArg))) {
                final PrimProcedure pproc = new PrimProcedure(method, func_lambda);
                final boolean is_static = method.getStaticFlag();
                boolean extraArg = false;
                if (!is_static || func_lambda.declareClosureEnv() != null) {
                    if (is_static) {
                        extraArg = true;
                    }
                    if (comp.curLambda == func_lambda) {
                        code.emitLoad((func_lambda.closureEnv != null) ? func_lambda.closureEnv : func_lambda.thisVariable);
                    }
                    else if (owner != null) {
                        owner.load(null, 0, comp, Target.pushObject);
                    }
                    else {
                        func_lambda.getOwningLambda().loadHeapFrame(comp);
                    }
                }
                pproc.compile(extraArg ? Type.voidType : null, exp, comp, target);
                return;
            }
        }
        if (func_lambda != null && func_lambda.getInlineOnly() && !tail_recurse && func_lambda.min_args == nonSpliceCount) {
            pushArgs(func_lambda, exp.args, exp.args.length, null, comp);
            if (func_lambda.getFlag(128) || (exp.isTailCall() && func_lambda.nameDecl != null && !func_lambda.nestedIn(comp.curLambda))) {
                if (func_lambda.startForInlining == null) {
                    func_lambda.startForInlining = new Label(code);
                    if (comp.curLambda.pendingInlines == null) {
                        comp.curLambda.pendingInlines = new LinkedList<Object>();
                    }
                    comp.curLambda.pendingInlines.add(func_lambda);
                    comp.curLambda.pendingInlines.add(target);
                }
                code.emitTailCall(false, func_lambda.startForInlining);
                return;
            }
            func_lambda.compileAsInlined(comp, target);
        }
        else {
            if (comp.curLambda.isHandlingTailCalls() && (exp.isTailCall() || target instanceof ConsumerTarget) && !comp.curLambda.getInlineOnly()) {
                exp_func.compile(comp, new StackTarget(Compilation.typeProcedure));
                if (args_length <= 4 && exp.isSimple()) {
                    for (int j = 0; j < args_length; ++j) {
                        exp.args[j].compileWithPosition(comp, Target.pushObject);
                    }
                    comp.loadCallContext();
                    code.emitInvoke(Compilation.typeProcedure.getDeclaredMethod("check" + args_length, args_length + 1));
                }
                else {
                    if (exp.firstSpliceArg >= 0) {
                        CompileArrays.createArray(Type.objectType, comp, exp.args, 0, args_length);
                    }
                    else {
                        compileToArray(exp.args, 0, comp);
                    }
                    comp.loadCallContext();
                    code.emitInvoke(Compilation.typeProcedure.getDeclaredMethod("checkN", 2));
                }
                finishTrampoline(exp.isTailCall(), target, comp);
                return;
            }
            if (exp.firstSpliceArg >= 0) {
                final Expression[] args = exp.getArgs();
                exp_func.compile(comp, Target.pushObject);
                CompileArrays.createArray(Type.objectType, comp, args, 0, args.length);
                code.emitInvoke(Compilation.typeProcedure.getDeclaredMethod("applyN", 1));
                target.compileFromStack(comp, Type.pointer_type);
                return;
            }
            if (!tail_recurse) {
                exp_func.compile(comp, new StackTarget(Compilation.typeProcedure));
            }
            final boolean toArray = tail_recurse ? (func_lambda.max_args < 0) : (args_length > 4);
            int[] incValues = null;
            Method method;
            if (tail_recurse) {
                final int fixed = func_lambda.min_args;
                incValues = new int[fixed];
                pushArgs(func_lambda, exp.args, fixed, incValues, comp);
                if (toArray) {
                    compileToArray(exp.args, fixed, comp);
                }
                method = null;
            }
            else if (toArray) {
                compileToArray(exp.args, 0, comp);
                method = Compilation.applyNmethod;
            }
            else {
                for (int k = 0; k < args_length; ++k) {
                    exp.args[k].compileWithPosition(comp, Target.pushObject);
                    if (!code.reachableHere()) {
                        break;
                    }
                }
                method = Compilation.applymethods[args_length];
            }
            if (!code.reachableHere()) {
                if (comp.warnUnreachable()) {
                    comp.error('w', "unreachable code");
                }
                return;
            }
            if (tail_recurse) {
                Label startLabel = func_lambda.startForInlining;
                boolean mustStore = startLabel == null;
                if (incValues != null && !mustStore) {
                    int l = incValues.length;
                    while (--l >= 0) {
                        if (incValues[l] != 65536) {
                            mustStore = true;
                            break;
                        }
                    }
                }
                if (mustStore) {
                    popParams(code, func_lambda, incValues, toArray);
                    startLabel = func_lambda.getVarScope().getStartLabel();
                }
                code.emitTailCall(false, startLabel);
                return;
            }
            code.emitInvokeVirtual(method);
            target.compileFromStack(comp, Type.pointer_type);
        }
    }
    
    static void finishTrampoline(final boolean isTailCall, final Target target, final Compilation comp) {
        final CodeAttr code = comp.getCode();
        final ClassType typeContext = Compilation.typeCallContext;
        if (isTailCall) {
            code.emitReturn();
        }
        else if (target instanceof IgnoreTarget || ((ConsumerTarget)target).isContextTarget()) {
            comp.loadCallContext();
            code.emitInvoke(typeContext.getDeclaredMethod("runUntilDone", 0));
        }
        else {
            comp.loadCallContext();
            code.emitLoad(((ConsumerTarget)target).getConsumerVariable());
            code.emitInvoke(typeContext.getDeclaredMethod("runUntilValue", 1));
        }
    }
    
    public Expression deepCopy(final IdentityHashTable mapper) {
        final Expression f = Expression.deepCopy(this.func, mapper);
        final Expression[] a = Expression.deepCopy(this.args, mapper);
        if ((f == null && this.func != null) || (a == null && this.args != null)) {
            return null;
        }
        final ApplyExp copy = new ApplyExp(f, a);
        copy.flags = this.getFlags();
        return copy;
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitApplyExp(this, d);
    }
    
    public void visitArgs(final InlineCalls visitor) {
        this.visitArgs(visitor, null);
    }
    
    public void visitArgs(final InlineCalls visitor, final LambdaExp lexp) {
        final int nargs = this.args.length;
        final Type dtype = this.isAppendValues() ? null : InlineCalls.ValueNeededType.instance;
        Declaration param = (lexp == null || this.firstKeywordArgIndex != 0 || lexp.keywords != null) ? null : lexp.firstDecl();
        for (int i = 0; i < nargs && visitor.getExitValue() == null; ++i) {
            while (param != null && (param.isThisParameter() || param.getFlag(1099511627776L))) {
                param = param.nextDecl();
            }
            Type ptype = dtype;
            if (param != null && i < lexp.min_args + lexp.opt_args && (this.firstSpliceArg < 0 || i > this.firstSpliceArg)) {
                ptype = param.getType();
            }
            else if (param != null && param.getFlag(4398046511104L)) {
                final Type vtype = param.getType();
                if (vtype instanceof ArrayType) {
                    ptype = ((ArrayType)vtype).getComponentType();
                }
            }
            this.args[i] = ((ExpVisitor<R, D>)visitor).visitAndUpdate(this.args[i], (D)ptype);
            if (param != null && !param.getFlag(4398046511104L)) {
                param = param.nextDecl();
            }
        }
    }
    
    @Override
    protected <R, D> void visitChildren(final ExpVisitor<R, D> visitor, final D d) {
        this.func = visitor.visitAndUpdate(this.func, d);
        if (visitor.exitValue == null) {
            this.args = visitor.visitExps(this.args, this.args.length, d);
        }
    }
    
    @Override
    public void print(final OutPort out) {
        out.startLogicalBlock("(Apply", ")", 2);
        if (this.isTailCall()) {
            out.print(" [tailcall]");
        }
        if (this.type != null && this.type != Type.pointer_type) {
            out.print(" => ");
            out.print(this.type);
        }
        out.writeSpaceFill();
        this.printLineColumn(out);
        this.func.print(out);
        for (int i = 0; this.args != null && i < this.args.length; ++i) {
            out.writeSpaceLinear();
            this.args[i].print(out);
        }
        out.endLogicalBlock(")");
    }
    
    private static void pushArgs(final LambdaExp lexp, final Expression[] args, final int args_length, final int[] incValues, final Compilation comp) {
        Declaration param = lexp.firstDecl();
        for (int i = 0; i < args_length; ++i) {
            final Expression arg = args[i];
            if (param.ignorable()) {
                arg.compile(comp, Target.Ignore);
            }
            else if (incValues == null || (incValues[i] = SetExp.canUseInc(arg, param)) == 65536) {
                arg.compileWithPosition(comp, StackTarget.getInstance(param.getType()));
            }
            param = param.nextDecl();
        }
    }
    
    static void popParams(final CodeAttr code, final LambdaExp lexp, final int[] incValues, final boolean toArray) {
        Variable vars = lexp.getVarScope().firstVar();
        final Declaration decls = lexp.firstDecl();
        if (vars != null && vars.getName() == "this") {
            vars = vars.nextVar();
        }
        if (vars != null && vars.getName() == "$ctx") {
            vars = vars.nextVar();
        }
        if (vars != null && vars.getName() == "$closureEnv") {
            vars = vars.nextVar();
        }
        popParams(code, 0, lexp.min_args, toArray, incValues, decls, vars);
    }
    
    private static void popParams(final CodeAttr code, final int paramNo, int count, final boolean toArray, final int[] incValues, final Declaration decl, final Variable vars) {
        if (count > 0) {
            --count;
            popParams(code, paramNo + 1, count, toArray, incValues, decl.nextDecl(), (decl.getVariable() == null) ? vars : vars.nextVar());
            if (!decl.ignorable()) {
                if (incValues != null && incValues[paramNo] != 65536) {
                    code.emitInc(vars, (short)incValues[paramNo]);
                }
                else {
                    code.emitStore(vars);
                }
            }
        }
        else if (toArray) {
            code.emitStore(vars);
        }
    }
    
    @Override
    public boolean side_effects() {
        final Object value = derefFunc(this.func).valueIfConstant();
        if (value instanceof Procedure && ((Procedure)value).isSideEffectFree()) {
            final Expression[] a = this.args;
            for (int alen = a.length, i = 0; i < alen; ++i) {
                if (a[i].side_effects()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    static Expression derefFunc(Expression afunc) {
        if (afunc instanceof ReferenceExp) {
            Declaration func_decl = ((ReferenceExp)afunc).binding;
            func_decl = Declaration.followAliases(func_decl);
            if (func_decl != null && !func_decl.getFlag(65536L)) {
                afunc = func_decl.getValue();
            }
        }
        return afunc;
    }
    
    @Override
    protected Type calculateType() {
        final Expression afunc = derefFunc(this.func);
        if (afunc instanceof QuoteExp) {
            final Object value = ((QuoteExp)afunc).getValue();
            if (value instanceof Procedure) {
                this.type = ((Procedure)value).getReturnType(this.args);
            }
        }
        else if (afunc instanceof LambdaExp) {
            this.type = ((LambdaExp)afunc).getReturnType();
        }
        return this.type;
    }
    
    public static boolean isInlineable(final Procedure proc) {
        return proc instanceof Inlineable || Procedure.compilerKey.get(proc) != null || proc.getProperty(Procedure.compilerXKey, null) != null;
    }
    
    static boolean inlineCompile(final Procedure proc, final ApplyExp exp, final Compilation comp, final Target target) throws Throwable {
        if (proc instanceof PrimProcedure) {
            return ((PrimProcedure)proc).compile(exp, comp, target);
        }
        Object propval = proc.getProperty(Procedure.compilerXKey, null);
        if (propval instanceof CharSequence) {
            final Object method = InlineCalls.resolveInliner(proc, propval.toString(), ApplyExp.compilerMethodType);
            if (method != null) {
                propval = method;
            }
        }
        if (propval instanceof java.lang.reflect.Method) {
            return (boolean)((java.lang.reflect.Method)propval).invoke(null, exp, comp, target, proc);
        }
        if (propval != null) {
            comp.error('e', "compiler property string for " + proc + " is not of the form CLASS:METHOD");
            return false;
        }
        if (!exp.isSimple()) {
            return false;
        }
        Inlineable compiler;
        if (proc instanceof Inlineable) {
            compiler = (Inlineable)proc;
        }
        else if ((propval = Procedure.compilerKey.get(proc)) != null) {
            compiler = Procedure.compilerKey.get(proc);
        }
        else {
            compiler = null;
        }
        if (compiler == null) {
            return false;
        }
        compiler.compile(exp, comp, target);
        return true;
    }
    
    public final Expression inlineIfConstant(final Procedure proc, final InlineCalls visitor) {
        return this.inlineIfConstant(proc, visitor.getMessages());
    }
    
    public final Expression inlineIfConstant(final Procedure proc, final SourceMessages messages) {
        final int len = this.args.length;
        final Object[] vals = new Object[len];
        int i = len;
        while (--i >= 0) {
            Expression arg = this.args[i];
            if (arg instanceof ReferenceExp) {
                final Declaration decl = ((ReferenceExp)arg).getBinding();
                if (decl != null) {
                    arg = decl.getValue();
                    if (arg == QuoteExp.undefined_exp) {
                        return this;
                    }
                }
            }
            if (!(arg instanceof QuoteExp)) {
                return this;
            }
            vals[i] = ((QuoteExp)arg).getValue();
        }
        try {
            return new QuoteExp(proc.applyN(vals), this.type).setLine(this);
        }
        catch (Error ex) {
            throw ex;
        }
        catch (Throwable ex2) {
            if (messages != null) {
                messages.error('w', "call to " + proc + " throws " + ex2);
            }
            return this;
        }
    }
    
    @Override
    public String toString() {
        if (this == LambdaExp.unknownContinuation) {
            return "ApplyExp[unknownContinuation]";
        }
        return "ApplyExp/" + ((this.args == null) ? 0 : this.args.length) + '[' + this.func + ']';
    }
    
    static {
        compilerMethodType = new Class[] { ApplyExp.class, Compilation.class, Target.class, Procedure.class };
    }
}
