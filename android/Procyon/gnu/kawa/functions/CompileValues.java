// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.bytecode.Method;
import gnu.expr.BeginExp;
import gnu.expr.SetExp;
import gnu.expr.PrimProcedure;
import gnu.expr.Compilation;
import gnu.mapping.MethodProc;
import gnu.expr.QuoteExp;
import gnu.kawa.reflect.MultValuesType;
import gnu.expr.LambdaExp;
import gnu.expr.Declaration;
import gnu.expr.ReferenceExp;
import gnu.expr.Expression;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.expr.ApplyExp;

public class CompileValues
{
    public static Expression validateCallWithValues(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final Expression[] args = exp.getArgs();
        if (args.length == 2) {
            final Expression arg0 = args[0];
            final Expression apply = visitor.getCompilation().applyFunction(arg0);
            final Expression produce = (apply != null) ? new ApplyExp(apply, new Expression[] { arg0 }) : new ApplyExp(arg0, Expression.noExpressions);
            final ApplyExp ae = new ApplyExp(ApplyWithValues.applyWithValues, new Expression[] { produce, args[1] });
            ae.setLine(exp);
            return visitor.visit(ae, required);
        }
        exp.visitArgs(visitor);
        return exp;
    }
    
    public static Expression validateApplyWithValues(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final Expression[] args = exp.getArgs();
        if (args.length == 2) {
            Expression producer = args[0];
            final Expression consumer = args[1];
            Type prequired = null;
            boolean singleArgConsumer = false;
            Expression cvalue = consumer;
            if (cvalue instanceof ReferenceExp) {
                final Declaration d = ((ReferenceExp)cvalue).getBinding();
                cvalue = Declaration.followAliases(d).getValue();
            }
            if (cvalue instanceof LambdaExp) {
                final LambdaExp lconsumer = (LambdaExp)cvalue;
                if (lconsumer.min_args == lconsumer.max_args) {
                    final Type[] types = new Type[lconsumer.min_args];
                    int i = 0;
                    for (Declaration param = lconsumer.firstDecl(); param != null; param = param.nextDecl()) {
                        final boolean typeSpecified = param.getFlag(8192L);
                        final Type type = param.getFlag(8192L) ? param.getType() : null;
                        types[i++] = type;
                    }
                    prequired = MultValuesType.create(types);
                    singleArgConsumer = (lconsumer.min_args == 1);
                }
            }
            else if (cvalue instanceof QuoteExp) {
                final Object rconsumer = cvalue.valueIfConstant();
                if (rconsumer instanceof Procedure) {
                    final Procedure pconsumer = (Procedure)rconsumer;
                    if (pconsumer.minArgs() == pconsumer.maxArgs()) {
                        final Type[] types2 = new Type[pconsumer.minArgs()];
                        if (pconsumer instanceof MethodProc) {
                            final MethodProc mpconsumer = (MethodProc)pconsumer;
                            for (int j = 0; j < types2.length; ++j) {
                                types2[j] = mpconsumer.getParameterType(j);
                            }
                        }
                        else {
                            for (int k = 0; k < types2.length; ++k) {
                                types2[k] = Type.objectType;
                            }
                        }
                        prequired = MultValuesType.create(types2);
                        singleArgConsumer = (pconsumer.minArgs() == 1);
                    }
                }
            }
            producer = visitor.visit(producer, prequired);
            if (singleArgConsumer) {
                final ApplyExp ae = new ApplyExp(consumer, new Expression[] { producer });
                ae.setLine(exp);
                return visitor.visit(ae, required);
            }
            if (prequired == null) {
                prequired = producer.getType();
            }
            if (prequired instanceof MultValuesType) {
                final MultValuesType mprequired = (MultValuesType)prequired;
                final int nvalues = mprequired.getValueCount();
                final Compilation comp = visitor.getCompilation();
                comp.letStart();
                final PrimProcedure incrPosProc = new PrimProcedure(Compilation.typeValues.getDeclaredMethod("incrPos", 2));
                PrimProcedure getFromPosProc = new PrimProcedure(Compilation.typeValues.getDeclaredMethod("getFromPos", 2));
                final Expression apply = visitor.getCompilation().applyFunction(consumer);
                final int applyAdjust = (apply != null) ? 1 : 0;
                final Expression[] cargs = new Expression[applyAdjust + nvalues];
                final Declaration valsDecl = comp.letVariable(null, Type.objectType, producer);
                final QuoteExp zero = new QuoteExp(0, Type.intType);
                final Declaration iposDecl = (nvalues == 0) ? null : comp.letVariable(null, Type.intType, zero);
                comp.letEnter();
                for (int l = 0; l < nvalues; ++l) {
                    final SetExp incr = new SetExp(iposDecl, new ApplyExp(incrPosProc, new Expression[] { new ReferenceExp(valsDecl), new ReferenceExp(iposDecl) }));
                    iposDecl.noteValueFromSet(incr);
                    if (l + 1 == nvalues) {
                        getFromPosProc = new PrimProcedure(Compilation.typeValues.getDeclaredMethod("getFromPosFinal", 2));
                    }
                    cargs[applyAdjust + l] = new BeginExp(incr, new ApplyExp(getFromPosProc, new Expression[] { new ReferenceExp(valsDecl), new ReferenceExp(iposDecl) }));
                }
                Expression callCons;
                if (applyAdjust == 0) {
                    callCons = new ApplyExp(consumer, cargs);
                }
                else {
                    cargs[0] = consumer;
                    callCons = new ApplyExp(apply, cargs);
                }
                if (nvalues == 0) {
                    final Method checkFinalPosMethod = Compilation.typeValues.getDeclaredMethod("checkFinalPos", 2);
                    callCons = new BeginExp(new ApplyExp(checkFinalPosMethod, new Expression[] { new ReferenceExp(valsDecl), zero }), callCons);
                }
                return visitor.visit(comp.letDone(callCons), required);
            }
            args[0] = producer;
        }
        exp.visitArgs(visitor);
        return exp;
    }
}
