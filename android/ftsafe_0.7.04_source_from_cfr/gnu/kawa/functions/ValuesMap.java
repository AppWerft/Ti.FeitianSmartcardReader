/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.LambdaExp;
import gnu.expr.Mangling;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class ValuesMap
extends MethodProc
implements Inlineable {
    public static final ValuesMap valuesMap = new ValuesMap(-1);
    public static final ValuesMap valuesMapWithPos = new ValuesMap(1);
    private final int startCounter;

    private ValuesMap(int startCounter) {
        this.startCounter = startCounter;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyValuesMap");
    }

    @Override
    public int numArgs() {
        return 8194;
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        Procedure proc = (Procedure)ctx.getNextArg();
        Consumer out = ctx.consumer;
        Object val = ctx.getNextArg();
        Procedure.checkArgCount(proc, 1);
        if (val instanceof Values) {
            int ipos = 0;
            int count = this.startCounter;
            Values values = (Values)val;
            while ((ipos = values.nextPos(ipos)) != 0) {
                Object v = values.getPosPrevious(ipos);
                if (this.startCounter >= 0) {
                    proc.check2(v, IntNum.make(count++), ctx);
                } else {
                    proc.check1(v, ctx);
                }
                ctx.runUntilDone();
            }
        } else {
            if (this.startCounter >= 0) {
                proc.check2(val, IntNum.make(this.startCounter), ctx);
            } else {
                proc.check1(val, ctx);
            }
            ctx.runUntilDone();
        }
    }

    static LambdaExp canInline(ApplyExp exp, ValuesMap proc) {
        Expression arg0;
        Expression[] args = exp.getArgs();
        if (args.length == 2 && (arg0 = args[0]) instanceof LambdaExp) {
            LambdaExp lexp = (LambdaExp)arg0;
            if (lexp.min_args == lexp.max_args && lexp.min_args == (proc.startCounter >= 0 ? 2 : 1)) {
                return lexp;
            }
        }
        return null;
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        LambdaExp lambda = ValuesMap.canInline(exp, this);
        if (lambda == null) {
            ApplyExp.compile(exp, comp, target);
            return;
        }
        Expression[] args = exp.getArgs();
        if (!(target instanceof IgnoreTarget) && !(target instanceof ConsumerTarget)) {
            ConsumerTarget.compileUsingConsumer(exp, comp, target);
            return;
        }
        Expression vals = args[1];
        ValuesMap.compileInlined(lambda, vals, this.startCounter, null, comp, target);
    }

    public static void compileInlined(LambdaExp lambda, Expression vals, int startCounter, Method matchesMethod, Compilation comp, Target target) {
        Variable counter;
        Declaration counterDecl;
        Declaration param = lambda.firstDecl();
        CodeAttr code = comp.getCode();
        Scope scope = code.pushScope();
        Type paramType = param.getType();
        if (startCounter >= 0) {
            counter = scope.addVariable(code, Type.intType, "position");
            code.emitPushInt(startCounter);
            code.emitStore(counter);
            counterDecl = new Declaration(counter);
        } else {
            counter = null;
            counterDecl = null;
        }
        if (param.isSimple() && matchesMethod == null) {
            param.allocateVariable(code);
        } else {
            String pname = Mangling.mangleNameIfNeeded(param.getName());
            param = new Declaration(code.addLocal(paramType.getImplementationType(), pname));
        }
        Expression[] args = startCounter >= 0 ? new Expression[]{new ReferenceExp(param), new ReferenceExp(counterDecl)} : new Expression[]{new ReferenceExp(param)};
        Expression app = new ApplyExp(lambda, args);
        if (matchesMethod != null) {
            if (app.getType().getImplementationType() != Type.booleanType) {
                app = new ApplyExp(matchesMethod, app, new ReferenceExp(counterDecl));
            }
            app = new IfExp(app, new ReferenceExp(param), QuoteExp.voidExp);
        }
        Variable indexVar = code.addLocal(Type.intType);
        Variable valuesVar = code.addLocal(Type.pointer_type);
        Variable nextVar = code.addLocal(Type.intType);
        vals.compileWithPosition(comp, Target.pushObject);
        code.emitStore(valuesVar);
        code.emitPushInt(0);
        code.emitStore(indexVar);
        Label top = new Label(code);
        Label doneLabel = new Label(code);
        top.define(code);
        code.emitLoad(valuesVar);
        code.emitLoad(indexVar);
        code.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("nextIndex", 2));
        code.emitDup(Type.intType);
        code.emitStore(nextVar);
        code.emitGotoIfIntLtZero(doneLabel);
        code.emitLoad(valuesVar);
        code.emitLoad(indexVar);
        code.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("nextValue", 2));
        StackTarget.convert(comp, Type.objectType, paramType);
        param.compileStore(comp);
        app.compile(comp, target);
        if (startCounter >= 0) {
            code.emitInc(counter, (short)1);
        }
        code.emitLoad(nextVar);
        code.emitStore(indexVar);
        code.emitGoto(top);
        doneLabel.define(code);
        code.popScope();
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return Type.pointer_type;
    }
}

