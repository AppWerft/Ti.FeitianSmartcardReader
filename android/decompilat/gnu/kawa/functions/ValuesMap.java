// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.bytecode.Variable;
import gnu.bytecode.Scope;
import gnu.bytecode.CodeAttr;
import gnu.expr.StackTarget;
import gnu.bytecode.Label;
import gnu.expr.IfExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Mangling;
import gnu.expr.Declaration;
import gnu.bytecode.Type;
import gnu.bytecode.Method;
import gnu.expr.ConsumerTarget;
import gnu.expr.IgnoreTarget;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.ApplyExp;
import gnu.lists.Consumer;
import gnu.math.IntNum;
import gnu.mapping.Values;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.expr.Inlineable;
import gnu.mapping.MethodProc;

public class ValuesMap extends MethodProc implements Inlineable
{
    public static final ValuesMap valuesMap;
    public static final ValuesMap valuesMapWithPos;
    private final int startCounter;
    
    private ValuesMap(final int startCounter) {
        this.startCounter = startCounter;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyValuesMap");
    }
    
    @Override
    public int numArgs() {
        return 8194;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        final Procedure proc = (Procedure)ctx.getNextArg();
        final Consumer out = ctx.consumer;
        final Object val = ctx.getNextArg();
        Procedure.checkArgCount(proc, 1);
        if (val instanceof Values) {
            int ipos = 0;
            int count = this.startCounter;
            final Values values = (Values)val;
            while ((ipos = values.nextPos(ipos)) != 0) {
                final Object v = values.getPosPrevious(ipos);
                if (this.startCounter >= 0) {
                    proc.check2(v, IntNum.make(count++), ctx);
                }
                else {
                    proc.check1(v, ctx);
                }
                ctx.runUntilDone();
            }
        }
        else {
            if (this.startCounter >= 0) {
                proc.check2(val, IntNum.make(this.startCounter), ctx);
            }
            else {
                proc.check1(val, ctx);
            }
            ctx.runUntilDone();
        }
    }
    
    static LambdaExp canInline(final ApplyExp exp, final ValuesMap proc) {
        final Expression[] args = exp.getArgs();
        final Expression arg0;
        if (args.length == 2 && (arg0 = args[0]) instanceof LambdaExp) {
            final LambdaExp lexp = (LambdaExp)arg0;
            if (lexp.min_args == lexp.max_args && lexp.min_args == ((proc.startCounter >= 0) ? 2 : 1)) {
                return lexp;
            }
        }
        return null;
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        final LambdaExp lambda = canInline(exp, this);
        if (lambda == null) {
            ApplyExp.compile(exp, comp, target);
            return;
        }
        final Expression[] args = exp.getArgs();
        if (!(target instanceof IgnoreTarget) && !(target instanceof ConsumerTarget)) {
            ConsumerTarget.compileUsingConsumer(exp, comp, target);
            return;
        }
        final Expression vals = args[1];
        compileInlined(lambda, vals, this.startCounter, null, comp, target);
    }
    
    public static void compileInlined(final LambdaExp lambda, final Expression vals, final int startCounter, final Method matchesMethod, final Compilation comp, final Target target) {
        Declaration param = lambda.firstDecl();
        final CodeAttr code = comp.getCode();
        final Scope scope = code.pushScope();
        final Type paramType = param.getType();
        Variable counter;
        Declaration counterDecl;
        if (startCounter >= 0) {
            counter = scope.addVariable(code, Type.intType, "position");
            code.emitPushInt(startCounter);
            code.emitStore(counter);
            counterDecl = new Declaration(counter);
        }
        else {
            counter = null;
            counterDecl = null;
        }
        if (param.isSimple() && matchesMethod == null) {
            param.allocateVariable(code);
        }
        else {
            final String pname = Mangling.mangleNameIfNeeded(param.getName());
            param = new Declaration(code.addLocal(paramType.getImplementationType(), pname));
        }
        Expression[] args;
        if (startCounter >= 0) {
            args = new Expression[] { new ReferenceExp(param), new ReferenceExp(counterDecl) };
        }
        else {
            args = new Expression[] { new ReferenceExp(param) };
        }
        Expression app = new ApplyExp(lambda, args);
        if (matchesMethod != null) {
            if (app.getType().getImplementationType() != Type.booleanType) {
                app = new ApplyExp(matchesMethod, new Expression[] { app, new ReferenceExp(counterDecl) });
            }
            app = new IfExp(app, new ReferenceExp(param), QuoteExp.voidExp);
        }
        final Variable indexVar = code.addLocal(Type.intType);
        final Variable valuesVar = code.addLocal(Type.pointer_type);
        final Variable nextVar = code.addLocal(Type.intType);
        vals.compileWithPosition(comp, Target.pushObject);
        code.emitStore(valuesVar);
        code.emitPushInt(0);
        code.emitStore(indexVar);
        final Label top = new Label(code);
        final Label doneLabel = new Label(code);
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
    public Type getReturnType(final Expression[] args) {
        return Type.pointer_type;
    }
    
    static {
        valuesMap = new ValuesMap(-1);
        valuesMapWithPos = new ValuesMap(1);
    }
}
