/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.Special;
import gnu.expr.Target;
import gnu.kawa.reflect.OccurrenceType;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;

public class AppendValues
extends MethodProc
implements Inlineable {
    public static final AppendValues appendValues = new AppendValues();

    public AppendValues() {
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyAppendValues");
    }

    @Override
    public void apply(CallContext ctx) {
        Object arg;
        Special endMarker = Special.dfault;
        while ((arg = ctx.getNextArg(endMarker)) != endMarker) {
            if (arg instanceof Consumable) {
                ((Consumable)arg).consume(ctx.consumer);
                continue;
            }
            ctx.writeValue(arg);
        }
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        int i;
        Type type;
        Expression[] args = exp.getArgs();
        int nargs = args.length;
        int nonVoid = -1;
        for (i = 0; i < nargs; ++i) {
            if (args[i].getType().isVoid()) continue;
            nonVoid = nonVoid == -1 ? i : -2;
        }
        if (nonVoid == -1) {
            nonVoid = nargs - 1;
        }
        if (nonVoid >= 0) {
            for (i = 0; i < nargs; ++i) {
                args[i].compileWithPosition(comp, i == nonVoid ? target : Target.Ignore);
            }
            return;
        }
        boolean simple = target instanceof IgnoreTarget ? true : (target instanceof ConsumerTarget ? (type = target.getType()) == Type.objectType || type instanceof OccurrenceType && ((OccurrenceType)type).minOccurs() == 0 : false);
        if (simple) {
            for (int i2 = 0; i2 < nargs; ++i2) {
                args[i2].compileWithPosition(comp, target);
            }
        } else {
            Expression nexp;
            if (target instanceof ConsumerTarget) {
                nexp = new BeginExp(new Expression[]{exp});
                nexp.setType(Type.objectType);
            } else {
                nexp = exp;
            }
            ConsumerTarget.compileUsingValues(nexp, comp, target);
        }
    }
}

