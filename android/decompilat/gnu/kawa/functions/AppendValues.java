// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.expr.BeginExp;
import gnu.expr.Expression;
import gnu.kawa.reflect.OccurrenceType;
import gnu.bytecode.Type;
import gnu.expr.ConsumerTarget;
import gnu.expr.IgnoreTarget;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.lists.Consumable;
import gnu.expr.Special;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.expr.Inlineable;
import gnu.mapping.MethodProc;

public class AppendValues extends MethodProc implements Inlineable
{
    public static final AppendValues appendValues;
    
    public AppendValues() {
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyAppendValues");
    }
    
    @Override
    public void apply(final CallContext ctx) {
        final Object endMarker = Special.dfault;
        while (true) {
            final Object arg = ctx.getNextArg(endMarker);
            if (arg == endMarker) {
                break;
            }
            if (arg instanceof Consumable) {
                ((Consumable)arg).consume(ctx.consumer);
            }
            else {
                ctx.writeValue(arg);
            }
        }
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        final Expression[] args = exp.getArgs();
        final int nargs = args.length;
        int nonVoid = -1;
        for (int i = 0; i < nargs; ++i) {
            if (!args[i].getType().isVoid()) {
                nonVoid = ((nonVoid == -1) ? i : -2);
            }
        }
        if (nonVoid == -1) {
            nonVoid = nargs - 1;
        }
        if (nonVoid >= 0) {
            for (int i = 0; i < nargs; ++i) {
                args[i].compileWithPosition(comp, (i == nonVoid) ? target : Target.Ignore);
            }
            return;
        }
        boolean simple;
        if (target instanceof IgnoreTarget) {
            simple = true;
        }
        else if (target instanceof ConsumerTarget) {
            final Type type = target.getType();
            simple = (type == Type.objectType || (type instanceof OccurrenceType && ((OccurrenceType)type).minOccurs() == 0));
        }
        else {
            simple = false;
        }
        if (simple) {
            for (int j = 0; j < nargs; ++j) {
                args[j].compileWithPosition(comp, target);
            }
        }
        else {
            Expression nexp;
            if (target instanceof ConsumerTarget) {
                nexp = new BeginExp(new Expression[] { exp });
                nexp.setType(Type.objectType);
            }
            else {
                nexp = exp;
            }
            ConsumerTarget.compileUsingValues(nexp, comp, target);
        }
    }
    
    static {
        appendValues = new AppendValues();
    }
}
