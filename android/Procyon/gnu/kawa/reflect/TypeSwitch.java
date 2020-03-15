// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.expr.Declaration;
import gnu.bytecode.Variable;
import gnu.bytecode.CodeAttr;
import gnu.expr.Expression;
import gnu.expr.TypeValue;
import gnu.expr.StackTarget;
import gnu.expr.LambdaExp;
import gnu.expr.ReferenceExp;
import gnu.bytecode.Type;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.expr.Inlineable;
import gnu.mapping.MethodProc;

public class TypeSwitch extends MethodProc implements Inlineable
{
    public static final TypeSwitch typeSwitch;
    
    public TypeSwitch(final String name) {
        this.setName(name);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplyTypeSwitch");
    }
    
    @Override
    public int numArgs() {
        return -4094;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        final Object[] args = ctx.getArgs();
        final Object selector = args[0];
        final int n = args.length - 1;
        for (int i = 1; i < n; ++i) {
            final MethodProc caseProc = (MethodProc)args[i];
            final int m = caseProc.match1(selector, ctx);
            if (m >= 0) {
                return;
            }
        }
        final Procedure defaultProc = (Procedure)args[n];
        defaultProc.check1(selector, ctx);
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        final Expression[] args = exp.getArgs();
        final CodeAttr code = comp.getCode();
        code.pushScope();
        final Variable selector = code.addLocal(Type.pointer_type);
        args[0].compile(comp, Target.pushObject);
        code.emitStore(selector);
        int numCondClauses = 0;
        int i = 1;
        while (i < args.length) {
            Expression arg = args[i++];
            if (Compilation.enableANF && arg instanceof ReferenceExp) {
                arg = ((ReferenceExp)arg).getBinding().getValue();
            }
            if (!(arg instanceof LambdaExp)) {
                throw new Error("not implemented: typeswitch arg not LambdaExp");
            }
            final LambdaExp lambda = (LambdaExp)arg;
            int numConditionsThisLambda = 0;
            for (Declaration param = lambda.firstDecl(); param != null; param = param.nextDecl()) {
                final Type type = param.getType();
                final boolean hasInitExpr = param.getFlag(1099511627776L);
                Type valType = hasInitExpr ? param.getInitValue().getType() : args[0].getType();
                final boolean isConditional = type != Type.objectType && type != Type.toStringType && type != valType;
                if (param.getCanRead() || isConditional) {
                    param.allocateVariable(code);
                }
                if (isConditional) {
                    if (numConditionsThisLambda > 0) {
                        code.emitAndThen();
                    }
                    ++numConditionsThisLambda;
                }
                Variable incoming;
                if (hasInitExpr) {
                    final Expression initExpr = param.getInitValue();
                    final Target ptarget = (isConditional || param.getCanRead()) ? Target.pushValue(valType) : Target.Ignore;
                    initExpr.compile(comp, ptarget);
                    if (ptarget == Target.Ignore) {
                        incoming = null;
                    }
                    else {
                        incoming = param.getContext().getVarScope().addVariable(code, valType.getImplementationType(), null);
                        code.emitStore(incoming);
                    }
                }
                else {
                    incoming = selector;
                }
                if (LazyType.maybeLazy(valType) && !LazyType.maybeLazy(type)) {
                    code.emitLoad(incoming);
                    valType = StackTarget.forceLazy(comp, valType, type);
                    incoming = param.getContext().getVarScope().addVariable(code, valType.getImplementationType(), null);
                    code.emitStore(incoming);
                }
                boolean storeNeeded = param.getCanRead();
                if (isConditional) {
                    if (type instanceof TypeValue) {
                        ((TypeValue)type).emitTestIf(incoming, param, comp);
                        storeNeeded = false;
                    }
                    else {
                        code.emitLoad(incoming);
                        type.emitIsInstance(code);
                        code.emitIfIntNotZero();
                    }
                }
                if (storeNeeded) {
                    code.emitLoad(incoming);
                    if (isConditional || type == Type.toStringType) {
                        type.emitCoerceFromObject(code);
                    }
                    param.compileStore(comp);
                }
            }
            lambda.allocChildClasses(comp);
            lambda.body.compileWithPosition(comp, target);
            if (numConditionsThisLambda == 0) {
                break;
            }
            if (i >= args.length) {
                continue;
            }
            ++numCondClauses;
            code.emitElse();
        }
        while (--numCondClauses >= 0) {
            code.emitFi();
        }
        code.popScope();
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return Type.pointer_type;
    }
    
    static {
        typeSwitch = new TypeSwitch("typeswitch");
    }
}
