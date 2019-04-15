/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Label;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.AccessExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.InlineCalls;
import gnu.expr.Inlineable;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.functions.AppendValues;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.io.OutPort;
import gnu.kawa.reflect.CompileArrays;
import gnu.kawa.util.IdentityHashTable;
import gnu.mapping.CallContext;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.Symbol;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class ApplyExp
extends Expression {
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
    private static final Class[] compilerMethodType = new Class[]{ApplyExp.class, Compilation.class, Target.class, Procedure.class};

    public final Expression getFunction() {
        return this.func;
    }

    public final Expression[] getArgs() {
        return this.args;
    }

    public final int getArgCount() {
        return this.args.length;
    }

    public void setFunction(Expression func) {
        this.func = func;
    }

    public void setFunction(Procedure proc) {
        this.func = new QuoteExp(proc);
    }

    public void setArgs(Expression[] args) {
        this.args = args;
    }

    public Expression getArg(int i) {
        return this.args[i];
    }

    public void setArg(int i, Expression arg) {
        this.args[i] = arg;
    }

    public final boolean isTailCall() {
        return this.getFlag(2);
    }

    public final void setTailCall(boolean tailCall) {
        this.setFlag(tailCall, 2);
    }

    public ApplyExp setFuncArgs(Expression func, Expression[] args) {
        this.setFunction(func);
        this.setArgs(args);
        this.setFlag(false, 1);
        return this;
    }

    public ApplyExp setFuncArgs(Procedure proc, Expression[] args) {
        return this.setFuncArgs(new QuoteExp(proc), args);
    }

    public final Object getFunctionValue() {
        return this.func instanceof QuoteExp ? ((QuoteExp)this.func).getValue() : null;
    }

    public void adjustSplice(ApplyExp src, int delta) {
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
            Expression[] args = this.args;
            int nargs = args.length;
            for (int i = this.firstSpliceArg; i < nargs; ++i) {
                if (MakeSplice.argIfSplice(args[i]) == null) continue;
                ++count;
            }
        }
        return count;
    }

    public boolean isSimple() {
        return this.firstSpliceArg < 0 && this.firstKeywordArgIndex == 0;
    }

    public boolean isSimple(int min) {
        return this.isSimple() && this.getArgCount() >= min;
    }

    public boolean isSimple(int min, int max) {
        int ac = this.getArgCount();
        return this.isSimple() && ac >= min && ac <= max;
    }

    public boolean isAppendValues() {
        return this.func instanceof QuoteExp && ((QuoteExp)this.func).getValue() == AppendValues.appendValues;
    }

    public /* varargs */ ApplyExp(Expression f, Expression ... a) {
        this.func = f;
        this.args = a;
    }

    public /* varargs */ ApplyExp(Procedure p, Expression ... a) {
        this(new QuoteExp(p), a);
    }

    public /* varargs */ ApplyExp(gnu.bytecode.Method m, Expression ... a) {
        this(new QuoteExp(new PrimProcedure(m)), a);
    }

    @Override
    protected boolean mustCompile() {
        return false;
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        Object proc = this.func.eval(ctx);
        int n = this.args.length;
        Object[] vals = new Object[n];
        for (int i = 0; i < n; ++i) {
            vals[i] = this.args[i].eval(ctx);
        }
        ((Procedure)proc).checkN(vals, ctx);
    }

    private static void compileToArray(Expression[] args, int start, Compilation comp) {
        CodeAttr code = comp.getCode();
        int argslength = args.length;
        int nargs = argslength - start;
        if (nargs == 0) {
            code.emitGetStatic(Compilation.noArgsField);
            return;
        }
        code.emitPushInt(nargs);
        code.emitNewArray(Type.pointer_type);
        for (int i = start; i < argslength; ++i) {
            Expression arg = args[i];
            if (comp.usingCPStyle() && !(arg instanceof QuoteExp) && !(arg instanceof ReferenceExp)) {
                arg.compileWithPosition(comp, Target.pushObject);
                code.emitSwap();
                code.emitDup(1, 1);
                code.emitSwap();
                code.emitPushInt(i);
                code.emitSwap();
            } else {
                code.emitDup(Compilation.objArrayType);
                code.emitPushInt(i);
                arg.compileWithPosition(comp, Target.pushObject);
            }
            code.emitArrayStore(Type.pointer_type);
        }
    }

    @Override
    public void compile(Compilation comp, Target target) {
        ApplyExp.compile(this, comp, target, true);
        if (this.getFlag(16)) {
            ((ClassExp)comp.currentScope().currentLambda().getOuter()).compileCallInitMethods(comp);
        }
    }

    public static void compile(ApplyExp exp, Compilation comp, Target target) {
        ApplyExp.compile(exp, comp, target, false);
    }

    static void compile(ApplyExp exp, Compilation comp, Target target, boolean checkInlineable) {
        gnu.bytecode.Method method;
        int args_length = exp.args.length;
        Expression exp_func = exp.func;
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
        } else if (exp_func instanceof ReferenceExp) {
            Expression dval;
            ReferenceExp func_ref = (ReferenceExp)exp_func;
            owner = func_ref.contextDecl();
            Declaration func_decl = func_ref.binding;
            while (func_decl != null && func_decl.isAlias() && (dval = func_decl.getValueRaw()) instanceof ReferenceExp) {
                func_ref = (ReferenceExp)dval;
                if (owner != null || func_decl.needsContext() || func_ref.binding == null) break;
                func_decl = func_ref.binding;
                owner = func_ref.contextDecl();
            }
            if (!func_decl.getFlag(65536L)) {
                Expression value = func_decl.getValue();
                func_name = func_decl.getName();
                if (value != null && value instanceof LambdaExp) {
                    func_lambda = (LambdaExp)value;
                }
                if (value != null && value instanceof QuoteExp) {
                    quotedValue = ((QuoteExp)value).getValue();
                }
            }
        } else if (exp_func instanceof QuoteExp) {
            quotedValue = ((QuoteExp)exp_func).getValue();
        }
        if (checkInlineable && quotedValue instanceof Procedure) {
            Procedure proc = (Procedure)quotedValue;
            if (target instanceof IgnoreTarget && proc.isSideEffectFree()) {
                for (int i = 0; i < args_length; ++i) {
                    exp.args[i].compile(comp, target);
                }
                return;
            }
            try {
                if (ApplyExp.inlineCompile(proc, exp, comp, target)) {
                    return;
                }
            }
            catch (Error ex) {
                throw ex;
            }
            catch (Throwable ex) {
                SourceMessages msg = comp.getMessages();
                msg.error('f', "caught exception in inline-compiler for " + quotedValue + " - " + ex, ex);
                throw new SyntaxException(msg);
            }
        }
        CodeAttr code = comp.getCode();
        boolean tail_recurse = exp.isTailCall() && func_lambda != null && func_lambda == comp.curLambda && func_lambda.opt_args == 0 && func_lambda.keywords == null;
        int spliceCount = exp.spliceCount();
        int nonSpliceCount = args_length - spliceCount;
        if (func_lambda != null) {
            if (func_lambda.max_args >= 0 && nonSpliceCount > func_lambda.max_args || nonSpliceCount < func_lambda.min_args && spliceCount == 0) {
                throw new Error("internal error - wrong number of parameters for " + func_lambda);
            }
            int conv = func_lambda.getCallConvention();
            if (func_lambda.primMethods == null && !func_lambda.isClassGenerated() && !func_lambda.getInlineOnly()) {
                func_lambda.allocMethod(func_lambda.outerLambda(), comp);
            }
            if (comp.inlineOk(func_lambda) && !tail_recurse && (conv <= 2 || conv == 3 && !exp.isTailCall()) && (method = func_lambda.getMethod(nonSpliceCount, spliceCount)) != null && (exp.firstSpliceArg < 0 || PrimProcedure.takesVarArgs(method) && func_lambda.min_args <= exp.firstSpliceArg)) {
                PrimProcedure pproc = new PrimProcedure(method, func_lambda);
                boolean is_static = method.getStaticFlag();
                boolean extraArg = false;
                if (!is_static || func_lambda.declareClosureEnv() != null) {
                    if (is_static) {
                        extraArg = true;
                    }
                    if (comp.curLambda == func_lambda) {
                        code.emitLoad(func_lambda.closureEnv != null ? func_lambda.closureEnv : func_lambda.thisVariable);
                    } else if (owner != null) {
                        owner.load(null, 0, comp, Target.pushObject);
                    } else {
                        func_lambda.getOwningLambda().loadHeapFrame(comp);
                    }
                }
                pproc.compile(extraArg ? Type.voidType : null, exp, comp, target);
                return;
            }
        }
        if (func_lambda != null && func_lambda.getInlineOnly() && !tail_recurse && func_lambda.min_args == nonSpliceCount) {
            ApplyExp.pushArgs(func_lambda, exp.args, exp.args.length, null, comp);
            if (func_lambda.getFlag(128) || exp.isTailCall() && func_lambda.nameDecl != null && !func_lambda.nestedIn(comp.curLambda)) {
                if (func_lambda.startForInlining == null) {
                    func_lambda.startForInlining = new Label(code);
                    if (comp.curLambda.pendingInlines == null) {
                        comp.curLambda.pendingInlines = new LinkedList();
                    }
                    comp.curLambda.pendingInlines.add(func_lambda);
                    comp.curLambda.pendingInlines.add(target);
                }
                code.emitTailCall(false, func_lambda.startForInlining);
                return;
            }
            func_lambda.compileAsInlined(comp, target);
            return;
        }
        if (comp.curLambda.isHandlingTailCalls() && (exp.isTailCall() || target instanceof ConsumerTarget) && !comp.curLambda.getInlineOnly()) {
            exp_func.compile(comp, new StackTarget(Compilation.typeProcedure));
            if (args_length <= 4 && exp.isSimple()) {
                for (int i = 0; i < args_length; ++i) {
                    exp.args[i].compileWithPosition(comp, Target.pushObject);
                }
                comp.loadCallContext();
                code.emitInvoke(Compilation.typeProcedure.getDeclaredMethod("check" + args_length, args_length + 1));
            } else {
                if (exp.firstSpliceArg >= 0) {
                    CompileArrays.createArray(Type.objectType, comp, exp.args, 0, args_length);
                } else {
                    ApplyExp.compileToArray(exp.args, 0, comp);
                }
                comp.loadCallContext();
                code.emitInvoke(Compilation.typeProcedure.getDeclaredMethod("checkN", 2));
            }
            ApplyExp.finishTrampoline(exp.isTailCall(), target, comp);
            return;
        }
        if (exp.firstSpliceArg >= 0) {
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
        boolean toArray = tail_recurse ? func_lambda.max_args < 0 : args_length > 4;
        int[] incValues = null;
        if (tail_recurse) {
            int fixed = func_lambda.min_args;
            incValues = new int[fixed];
            ApplyExp.pushArgs(func_lambda, exp.args, fixed, incValues, comp);
            if (toArray) {
                ApplyExp.compileToArray(exp.args, fixed, comp);
            }
            method = null;
        } else if (toArray) {
            ApplyExp.compileToArray(exp.args, 0, comp);
            method = Compilation.applyNmethod;
        } else {
            for (int i = 0; i < args_length; ++i) {
                exp.args[i].compileWithPosition(comp, Target.pushObject);
                if (!code.reachableHere()) break;
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
            boolean mustStore;
            Label startLabel = func_lambda.startForInlining;
            boolean bl = mustStore = startLabel == null;
            if (incValues != null && !mustStore) {
                int i = incValues.length;
                while (--i >= 0) {
                    if (incValues[i] == 65536) continue;
                    mustStore = true;
                    break;
                }
            }
            if (mustStore) {
                ApplyExp.popParams(code, func_lambda, incValues, toArray);
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
        } else if (target instanceof IgnoreTarget || ((ConsumerTarget)target).isContextTarget()) {
            comp.loadCallContext();
            code.emitInvoke(typeContext.getDeclaredMethod("runUntilDone", 0));
        } else {
            comp.loadCallContext();
            code.emitLoad(((ConsumerTarget)target).getConsumerVariable());
            code.emitInvoke(typeContext.getDeclaredMethod("runUntilValue", 1));
        }
    }

    @Override
    public Expression deepCopy(IdentityHashTable mapper) {
        Expression f = ApplyExp.deepCopy(this.func, mapper);
        Expression[] a = ApplyExp.deepCopy(this.args, mapper);
        if (f == null && this.func != null || a == null && this.args != null) {
            return null;
        }
        ApplyExp copy = new ApplyExp(f, a);
        copy.flags = this.getFlags();
        return copy;
    }

    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitApplyExp(this, d);
    }

    public void visitArgs(InlineCalls visitor) {
        this.visitArgs(visitor, null);
    }

    public void visitArgs(InlineCalls visitor, LambdaExp lexp) {
        int nargs = this.args.length;
        InlineCalls.ValueNeededType dtype = this.isAppendValues() ? null : InlineCalls.ValueNeededType.instance;
        Declaration param = lexp == null || this.firstKeywordArgIndex != 0 || lexp.keywords != null ? null : lexp.firstDecl();
        for (int i = 0; i < nargs && visitor.getExitValue() == null; ++i) {
            Type vtype;
            while (param != null && (param.isThisParameter() || param.getFlag(0x10000000000L))) {
                param = param.nextDecl();
            }
            Type ptype = dtype;
            if (param != null && i < lexp.min_args + lexp.opt_args && (this.firstSpliceArg < 0 || i > this.firstSpliceArg)) {
                ptype = param.getType();
            } else if (param != null && param.getFlag(0x40000000000L) && (vtype = param.getType()) instanceof ArrayType) {
                ptype = ((ArrayType)vtype).getComponentType();
            }
            this.args[i] = visitor.visitAndUpdate(this.args[i], ptype);
            if (param == null || param.getFlag(0x40000000000L)) continue;
            param = param.nextDecl();
        }
    }

    @Override
    protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
        this.func = visitor.visitAndUpdate(this.func, d);
        if (visitor.exitValue == null) {
            this.args = visitor.visitExps(this.args, this.args.length, d);
        }
    }

    @Override
    public void print(OutPort out) {
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

    private static void pushArgs(LambdaExp lexp, Expression[] args, int args_length, int[] incValues, Compilation comp) {
        Declaration param = lexp.firstDecl();
        for (int i = 0; i < args_length; ++i) {
            Expression arg = args[i];
            if (param.ignorable()) {
                arg.compile(comp, Target.Ignore);
            } else if (incValues == null || (incValues[i] = SetExp.canUseInc(arg, param)) == 65536) {
                arg.compileWithPosition(comp, StackTarget.getInstance(param.getType()));
            }
            param = param.nextDecl();
        }
    }

    static void popParams(CodeAttr code, LambdaExp lexp, int[] incValues, boolean toArray) {
        Variable vars = lexp.getVarScope().firstVar();
        Declaration decls = lexp.firstDecl();
        if (vars != null && vars.getName() == "this") {
            vars = vars.nextVar();
        }
        if (vars != null && vars.getName() == "$ctx") {
            vars = vars.nextVar();
        }
        if (vars != null && vars.getName() == "$closureEnv") {
            vars = vars.nextVar();
        }
        ApplyExp.popParams(code, 0, lexp.min_args, toArray, incValues, decls, vars);
    }

    private static void popParams(CodeAttr code, int paramNo, int count, boolean toArray, int[] incValues, Declaration decl, Variable vars) {
        if (count > 0) {
            ApplyExp.popParams(code, paramNo + 1, --count, toArray, incValues, decl.nextDecl(), decl.getVariable() == null ? vars : vars.nextVar());
            if (!decl.ignorable()) {
                if (incValues != null && incValues[paramNo] != 65536) {
                    code.emitInc(vars, (short)incValues[paramNo]);
                } else {
                    code.emitStore(vars);
                }
            }
        } else if (toArray) {
            code.emitStore(vars);
        }
    }

    @Override
    public boolean side_effects() {
        Object value = ApplyExp.derefFunc(this.func).valueIfConstant();
        if (value instanceof Procedure && ((Procedure)value).isSideEffectFree()) {
            Expression[] a = this.args;
            int alen = a.length;
            for (int i = 0; i < alen; ++i) {
                if (!a[i].side_effects()) continue;
                return true;
            }
            return false;
        }
        return true;
    }

    static Expression derefFunc(Expression afunc) {
        if (afunc instanceof ReferenceExp) {
            Declaration func_decl = ((ReferenceExp)afunc).binding;
            if ((func_decl = Declaration.followAliases(func_decl)) != null && !func_decl.getFlag(65536L)) {
                afunc = func_decl.getValue();
            }
        }
        return afunc;
    }

    @Override
    protected Type calculateType() {
        Expression afunc = ApplyExp.derefFunc(this.func);
        if (afunc instanceof QuoteExp) {
            Object value = ((QuoteExp)afunc).getValue();
            if (value instanceof Procedure) {
                this.type = ((Procedure)value).getReturnType(this.args);
            }
        } else if (afunc instanceof LambdaExp) {
            this.type = ((LambdaExp)afunc).getReturnType();
        }
        return this.type;
    }

    public static boolean isInlineable(Procedure proc) {
        return proc instanceof Inlineable || Procedure.compilerKey.get(proc) != null || proc.getProperty(Procedure.compilerXKey, null) != null;
    }

    static boolean inlineCompile(Procedure proc, ApplyExp exp, Compilation comp, Target target) throws Throwable {
        Method method;
        if (proc instanceof PrimProcedure) {
            return ((PrimProcedure)proc).compile(exp, comp, target);
        }
        Object propval = proc.getProperty(Procedure.compilerXKey, null);
        if (propval instanceof CharSequence && (method = InlineCalls.resolveInliner(proc, propval.toString(), compilerMethodType)) != null) {
            propval = method;
        }
        if (propval instanceof Method) {
            return (Boolean)((Method)propval).invoke(null, exp, comp, target, proc);
        }
        if (propval != null) {
            comp.error('e', "compiler property string for " + proc + " is not of the form CLASS:METHOD");
            return false;
        }
        if (!exp.isSimple()) {
            return false;
        }
        Inlineable compiler = proc instanceof Inlineable ? (Inlineable)((Object)proc) : ((propval = Procedure.compilerKey.get(proc)) != null ? (Inlineable)Procedure.compilerKey.get(proc) : null);
        if (compiler == null) {
            return false;
        }
        compiler.compile(exp, comp, target);
        return true;
    }

    public final Expression inlineIfConstant(Procedure proc, InlineCalls visitor) {
        return this.inlineIfConstant(proc, visitor.getMessages());
    }

    public final Expression inlineIfConstant(Procedure proc, SourceMessages messages) {
        int len = this.args.length;
        Object[] vals = new Object[len];
        int i = len;
        while (--i >= 0) {
            Declaration decl;
            Expression arg = this.args[i];
            if (arg instanceof ReferenceExp && (decl = ((ReferenceExp)arg).getBinding()) != null && (arg = decl.getValue()) == QuoteExp.undefined_exp) {
                return this;
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
        catch (Throwable ex) {
            if (messages != null) {
                messages.error('w', "call to " + proc + " throws " + ex);
            }
            return this;
        }
    }

    @Override
    public String toString() {
        if (this == LambdaExp.unknownContinuation) {
            return "ApplyExp[unknownContinuation]";
        }
        return "ApplyExp/" + (this.args == null ? 0 : this.args.length) + '[' + this.func + ']';
    }
}

