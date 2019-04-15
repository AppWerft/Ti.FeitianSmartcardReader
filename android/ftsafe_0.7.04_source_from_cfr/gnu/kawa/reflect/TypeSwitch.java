/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.LambdaExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.kawa.reflect.LazyType;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;

public class TypeSwitch
extends MethodProc
implements Inlineable {
    public static final TypeSwitch typeSwitch = new TypeSwitch("typeswitch");

    public TypeSwitch(String name) {
        this.setName(name);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplyTypeSwitch");
    }

    @Override
    public int numArgs() {
        return -4094;
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        Object[] args = ctx.getArgs();
        Object selector = args[0];
        int n = args.length - 1;
        for (int i = 1; i < n; ++i) {
            MethodProc caseProc = (MethodProc)args[i];
            int m = caseProc.match1(selector, ctx);
            if (m < 0) continue;
            return;
        }
        Procedure defaultProc = (Procedure)args[n];
        defaultProc.check1(selector, ctx);
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        Expression[] args = exp.getArgs();
        CodeAttr code = comp.getCode();
        code.pushScope();
        Variable selector = code.addLocal(Type.pointer_type);
        args[0].compile(comp, Target.pushObject);
        code.emitStore(selector);
        int numCondClauses = 0;
        int i = 1;
        while (i < args.length) {
            Expression arg = args[i++];
            if (Compilation.enableANF && arg instanceof ReferenceExp) {
                arg = ((ReferenceExp)arg).getBinding().getValue();
            }
            if (arg instanceof LambdaExp) {
                LambdaExp lambda = (LambdaExp)arg;
                int numConditionsThisLambda = 0;
                for (Declaration param = lambda.firstDecl(); param != null; param = param.nextDecl()) {
                    boolean isConditional;
                    Variable incoming;
                    Type type = param.getType();
                    boolean hasInitExpr = param.getFlag(0x10000000000L);
                    Type valType = hasInitExpr ? param.getInitValue().getType() : args[0].getType();
                    boolean bl = isConditional = type != Type.objectType && type != Type.toStringType && type != valType;
                    if (param.getCanRead() || isConditional) {
                        param.allocateVariable(code);
                    }
                    if (isConditional) {
                        if (numConditionsThisLambda > 0) {
                            code.emitAndThen();
                        }
                        ++numConditionsThisLambda;
                    }
                    if (hasInitExpr) {
                        Expression initExpr = param.getInitValue();
                        Target ptarget = isConditional || param.getCanRead() ? Target.pushValue(valType) : Target.Ignore;
                        initExpr.compile(comp, ptarget);
                        if (ptarget == Target.Ignore) {
                            incoming = null;
                        } else {
                            incoming = param.getContext().getVarScope().addVariable(code, valType.getImplementationType(), null);
                            code.emitStore(incoming);
                        }
                    } else {
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
                            ((TypeValue)((Object)type)).emitTestIf(incoming, param, comp);
                            storeNeeded = false;
                        } else {
                            code.emitLoad(incoming);
                            type.emitIsInstance(code);
                            code.emitIfIntNotZero();
                        }
                    }
                    if (!storeNeeded) continue;
                    code.emitLoad(incoming);
                    if (isConditional || type == Type.toStringType) {
                        type.emitCoerceFromObject(code);
                    }
                    param.compileStore(comp);
                }
                lambda.allocChildClasses(comp);
                lambda.body.compileWithPosition(comp, target);
                if (numConditionsThisLambda == 0) break;
                if (i >= args.length) continue;
                ++numCondClauses;
                code.emitElse();
                continue;
            }
            throw new Error("not implemented: typeswitch arg not LambdaExp");
        }
        while (--numCondClauses >= 0) {
            code.emitFi();
        }
        code.popScope();
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return Type.pointer_type;
    }
}

