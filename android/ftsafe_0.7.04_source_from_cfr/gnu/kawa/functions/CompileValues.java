/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.LetExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.SetExp;
import gnu.kawa.functions.ApplyWithValues;
import gnu.kawa.reflect.MultValuesType;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;

public class CompileValues {
    public static Expression validateCallWithValues(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression[] args = exp.getArgs();
        if (args.length == 2) {
            Expression arg0 = args[0];
            Expression apply = visitor.getCompilation().applyFunction(arg0);
            ApplyExp produce = apply != null ? new ApplyExp(apply, arg0) : new ApplyExp(arg0, Expression.noExpressions);
            ApplyExp ae = new ApplyExp(ApplyWithValues.applyWithValues, produce, args[1]);
            ae.setLine(exp);
            return visitor.visit((Expression)ae, required);
        }
        exp.visitArgs(visitor);
        return exp;
    }

    public static Expression validateApplyWithValues(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression[] args = exp.getArgs();
        if (args.length == 2) {
            Object rconsumer;
            Procedure pconsumer;
            Expression producer = args[0];
            Expression consumer = args[1];
            Type prequired = null;
            boolean singleArgConsumer = false;
            Expression cvalue = consumer;
            if (cvalue instanceof ReferenceExp) {
                Declaration d = ((ReferenceExp)cvalue).getBinding();
                cvalue = Declaration.followAliases(d).getValue();
            }
            if (cvalue instanceof LambdaExp) {
                LambdaExp lconsumer = (LambdaExp)cvalue;
                if (lconsumer.min_args == lconsumer.max_args) {
                    Type[] types = new Type[lconsumer.min_args];
                    int i = 0;
                    for (Declaration param = lconsumer.firstDecl(); param != null; param = param.nextDecl()) {
                        boolean typeSpecified = param.getFlag(8192L);
                        Type type = param.getFlag(8192L) ? param.getType() : null;
                        types[i++] = type;
                    }
                    prequired = MultValuesType.create(types);
                    singleArgConsumer = lconsumer.min_args == 1;
                }
            } else if (cvalue instanceof QuoteExp && (rconsumer = cvalue.valueIfConstant()) instanceof Procedure && (pconsumer = (Procedure)rconsumer).minArgs() == pconsumer.maxArgs()) {
                Type[] types = new Type[pconsumer.minArgs()];
                if (pconsumer instanceof MethodProc) {
                    MethodProc mpconsumer = (MethodProc)pconsumer;
                    for (int i = 0; i < types.length; ++i) {
                        types[i] = mpconsumer.getParameterType(i);
                    }
                } else {
                    for (int i = 0; i < types.length; ++i) {
                        types[i] = Type.objectType;
                    }
                }
                prequired = MultValuesType.create(types);
                singleArgConsumer = pconsumer.minArgs() == 1;
            }
            producer = visitor.visit(producer, prequired);
            if (singleArgConsumer) {
                ApplyExp ae = new ApplyExp(consumer, producer);
                ae.setLine(exp);
                return visitor.visit((Expression)ae, required);
            }
            if (prequired == null) {
                prequired = producer.getType();
            }
            if (prequired instanceof MultValuesType) {
                Expression callCons;
                MultValuesType mprequired = (MultValuesType)prequired;
                int nvalues = mprequired.getValueCount();
                Compilation comp = visitor.getCompilation();
                comp.letStart();
                PrimProcedure incrPosProc = new PrimProcedure(Compilation.typeValues.getDeclaredMethod("incrPos", 2));
                PrimProcedure getFromPosProc = new PrimProcedure(Compilation.typeValues.getDeclaredMethod("getFromPos", 2));
                Expression apply = visitor.getCompilation().applyFunction(consumer);
                int applyAdjust = apply == null ? 0 : 1;
                Expression[] cargs = new Expression[applyAdjust + nvalues];
                Declaration valsDecl = comp.letVariable(null, Type.objectType, producer);
                QuoteExp zero = new QuoteExp(0, Type.intType);
                Declaration iposDecl = nvalues == 0 ? null : comp.letVariable(null, Type.intType, zero);
                comp.letEnter();
                for (int i = 0; i < nvalues; ++i) {
                    SetExp incr = new SetExp(iposDecl, (Expression)new ApplyExp(incrPosProc, new ReferenceExp(valsDecl), new ReferenceExp(iposDecl)));
                    iposDecl.noteValueFromSet(incr);
                    if (i + 1 == nvalues) {
                        getFromPosProc = new PrimProcedure(Compilation.typeValues.getDeclaredMethod("getFromPosFinal", 2));
                    }
                    cargs[applyAdjust + i] = new BeginExp(incr, new ApplyExp(getFromPosProc, new ReferenceExp(valsDecl), new ReferenceExp(iposDecl)));
                }
                if (applyAdjust == 0) {
                    callCons = new ApplyExp(consumer, cargs);
                } else {
                    cargs[0] = consumer;
                    callCons = new ApplyExp(apply, cargs);
                }
                if (nvalues == 0) {
                    Method checkFinalPosMethod = Compilation.typeValues.getDeclaredMethod("checkFinalPos", 2);
                    callCons = new BeginExp(new ApplyExp(checkFinalPosMethod, new ReferenceExp(valsDecl), zero), callCons);
                }
                return visitor.visit((Expression)comp.letDone(callCons), required);
            }
            args[0] = producer;
        }
        exp.visitArgs(visitor);
        return exp;
    }
}

