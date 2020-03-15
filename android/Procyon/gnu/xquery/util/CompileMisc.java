// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.kawa.reflect.CompileReflect;
import gnu.bytecode.Variable;
import gnu.bytecode.Scope;
import gnu.bytecode.CodeAttr;
import gnu.expr.PrimProcedure;
import gnu.expr.ConsumerTarget;
import gnu.expr.Target;
import gnu.expr.Language;
import gnu.kawa.xml.DescendantAxis;
import gnu.kawa.xml.DescendantOrSelfAxis;
import gnu.kawa.xml.ChildAxis;
import gnu.kawa.xml.CoerceNodes;
import gnu.kawa.xml.NodeSetType;
import gnu.kawa.xml.NodeType;
import gnu.expr.LetExp;
import gnu.kawa.functions.ValuesMap;
import gnu.expr.IfExp;
import gnu.kawa.functions.AddOp;
import gnu.expr.Declaration;
import gnu.expr.ReferenceExp;
import gnu.kawa.xml.SortNodes;
import gnu.expr.Compilation;
import gnu.kawa.reflect.OccurrenceType;
import gnu.expr.LambdaExp;
import gnu.expr.ErrorExp;
import gnu.xquery.lang.XQuery;
import gnu.kawa.xml.XDataType;
import gnu.expr.QuoteExp;
import gnu.math.IntNum;
import gnu.expr.Expression;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.expr.ApplyExp;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;

public class CompileMisc
{
    static final ClassType typeTuples;
    static final ClassType typeXDataType;
    static final Method castMethod;
    static final Method castableMethod;
    
    public static Expression validateCompare(ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final Expression folded = exp.inlineIfConstant(proc, visitor);
        if (folded != exp) {
            return folded;
        }
        final Compare cproc = (Compare)proc;
        if ((cproc.flags & 0x20) == 0x0) {
            exp = new ApplyExp(ClassType.make("gnu.xquery.util.Compare").getDeclaredMethod("apply", 4), new Expression[] { new QuoteExp(IntNum.make(cproc.flags)), exp.getArg(0), exp.getArg(1), QuoteExp.nullExp });
        }
        if (exp.getTypeRaw() == null) {
            exp.setType(XDataType.booleanType);
        }
        return exp;
    }
    
    public static Expression validateBooleanValue(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        if (args.length == 1) {
            final Expression arg = args[0];
            final Type type = arg.getType();
            if (type == XDataType.booleanType) {
                return arg;
            }
            if (type == null) {
                exp.setType(XDataType.booleanType);
            }
            if (arg instanceof QuoteExp) {
                final Object value = ((QuoteExp)arg).getValue();
                try {
                    return BooleanValue.booleanValue(value) ? XQuery.trueExp : XQuery.falseExp;
                }
                catch (Exception ex) {
                    final String message = "cannot convert to a boolean";
                    visitor.getMessages().error('e', message);
                    return new ErrorExp(message);
                }
            }
        }
        return exp;
    }
    
    public static Expression validateArithOp(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        return exp;
    }
    
    public static Expression validateApplyValuesFilter(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final ValuesFilter vproc = (ValuesFilter)proc;
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        final Expression exp2 = args[1];
        final LambdaExp lexp2;
        if (!(exp2 instanceof LambdaExp) || (lexp2 = (LambdaExp)exp2).min_args != 3 || lexp2.max_args != 3) {
            return exp;
        }
        Expression seq = args[0];
        Type seqType = seq.getType();
        if (seqType instanceof OccurrenceType) {
            OccurrenceType occType = (OccurrenceType)seqType;
            final Type baseType = occType.getBase();
            if (OccurrenceType.itemCountIsOne(baseType)) {
                final int min = occType.minOccurs();
                if (min > 0) {
                    occType = new OccurrenceType(baseType, min, occType.maxOccurs());
                }
                exp.setType(occType);
            }
        }
        final Compilation comp = visitor.getCompilation();
        final Declaration dotArg = lexp2.firstDecl();
        final Declaration posArg = dotArg.nextDecl();
        final Declaration lastArg = posArg.nextDecl();
        dotArg.setCanRead(true);
        posArg.setCanRead(true);
        lexp2.setInlineOnly(exp, visitor.getCurrentLambda());
        lexp2.remove(posArg, lastArg);
        lexp2.min_args = 2;
        lexp2.max_args = 2;
        if (!lastArg.getCanRead() && vproc.kind != 'R') {
            return exp;
        }
        lastArg.setCanRead(true);
        comp.letStart();
        Method sizeMethod;
        if (vproc.kind == 'P') {
            sizeMethod = Compilation.typeValues.getDeclaredMethod("countValues", 1);
        }
        else {
            seqType = SortNodes.typeSortedNodes;
            seq = new ApplyExp(SortNodes.sortNodes, new Expression[] { seq });
            sizeMethod = ClassType.make("gnu.lists.AbstractSequence").getDeclaredMethod("size", 0);
        }
        final Declaration sequence = comp.letVariable("sequence", seqType, seq);
        comp.letEnter();
        Expression pred = lexp2.body;
        final Type predType = lexp2.body.getType();
        if (predType != XDataType.booleanType) {
            pred = new ApplyExp(ValuesFilter.matchesMethod, new Expression[] { pred, new ReferenceExp(posArg) });
        }
        if (vproc.kind == 'R') {
            final Declaration posIncoming = new Declaration(null, Type.intType);
            posIncoming.setCanRead(true);
            Expression init = new ApplyExp(AddOp.$Mn, new Expression[] { new ReferenceExp(lastArg), new ReferenceExp(posIncoming) });
            init = new ApplyExp(AddOp.$Pl, new Expression[] { init, new QuoteExp(IntNum.one()) });
            comp.letStart();
            lexp2.replaceFollowing(dotArg, posIncoming);
            comp.letVariable(posArg, init);
            comp.letEnter();
            pred = comp.letDone(pred);
        }
        pred = new IfExp(pred, new ReferenceExp(dotArg), QuoteExp.voidExp);
        lexp2.body = pred;
        final ApplyExp doMap = new ApplyExp(ValuesMap.valuesMapWithPos, new Expression[] { lexp2, new ReferenceExp(sequence) });
        doMap.setType(OccurrenceType.getInstance(dotArg.getType(), 0, -1));
        lexp2.returnContinuation = doMap;
        final Expression lastInit = new ApplyExp(sizeMethod, new Expression[] { new ReferenceExp(sequence) });
        comp.letStart();
        comp.letVariable(lastArg, lastInit);
        final LetExp let2 = comp.letDone(gnu.kawa.functions.CompileMisc.validateApplyValuesMap(doMap, visitor, required, ValuesMap.valuesMapWithPos));
        return comp.letDone(let2);
    }
    
    public static Expression validateApplyRelativeStep(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        final Expression exp2 = args[0];
        Expression exp3 = args[1];
        final Compilation comp = visitor.getCompilation();
        final LambdaExp lexp2;
        if (!(exp3 instanceof LambdaExp) || !comp.mustCompile || (lexp2 = (LambdaExp)exp3).min_args != 3 || lexp2.max_args != 3) {
            return exp;
        }
        lexp2.setInlineOnly(exp, visitor.getCurrentLambda());
        exp3 = lexp2.body;
        final Declaration dotArg = lexp2.firstDecl();
        final Declaration posArg = dotArg.nextDecl();
        final Declaration lastArg = posArg.nextDecl();
        posArg.setNext(lastArg.nextDecl());
        lastArg.setNext(null);
        lexp2.min_args = 2;
        lexp2.max_args = 2;
        final Type type1 = exp2.getType();
        if (type1 != null && NodeType.anyNodeTest.compare(type1) == -3) {
            final Language language = visitor.getCompilation().getLanguage();
            final String message = "step input is " + language.formatType(type1) + " - not a node sequence";
            visitor.getMessages().error('e', message);
            return new ErrorExp(message);
        }
        Type rtype = exp.getTypeRaw();
        if (rtype == null || rtype == Type.pointer_type) {
            final Type type2 = exp3.getType();
            final Type rtypePrime = OccurrenceType.itemPrimeType(type2);
            final int nodeCompare = NodeType.anyNodeTest.compare(rtypePrime);
            if (nodeCompare >= 0) {
                rtype = NodeSetType.getInstance(rtypePrime);
            }
            else {
                rtype = OccurrenceType.getInstance(rtypePrime, 0, -1);
            }
            exp.setType(rtype);
        }
        if (lastArg.getCanRead()) {
            final ClassType typeNodes = CoerceNodes.typeNodes;
            comp.letStart();
            final Declaration sequence = comp.letVariable(null, typeNodes, new ApplyExp(CoerceNodes.coerceNodes, new Expression[] { exp2 }));
            comp.letEnter();
            final Method sizeMethod = typeNodes.getDeclaredMethod("size", 0);
            final Expression lastInit = new ApplyExp(sizeMethod, new Expression[] { new ReferenceExp(sequence) });
            comp.letStart();
            comp.letVariable(lastArg, lastInit);
            comp.letEnter();
            final LetExp lastLet = comp.letDone(new ApplyExp(exp.getFunction(), new Expression[] { new ReferenceExp(sequence), lexp2 }));
            return comp.letDone(lastLet);
        }
        ApplyExp result = exp;
        if (exp3 instanceof ApplyExp) {
            final ApplyExp aexp2 = (ApplyExp)exp3;
            final Object proc2 = aexp2.getFunction().valueIfConstant();
            final Expression vexp2;
            if (proc2 instanceof ValuesFilter && (vexp2 = aexp2.getArgs()[1]) instanceof LambdaExp) {
                final LambdaExp lvexp2 = (LambdaExp)vexp2;
                final Declaration dot2 = lvexp2.firstDecl();
                final Declaration pos2;
                if (dot2 != null && (pos2 = dot2.nextDecl()) != null && pos2.nextDecl() == null && !pos2.getCanRead() && ClassType.make("java.lang.Number").compare(lvexp2.body.getType()) == -3) {
                    exp3 = aexp2.getArg(0);
                    lexp2.body = exp3;
                    aexp2.setArg(0, exp);
                    result = aexp2;
                }
            }
        }
        if (exp2 instanceof ApplyExp && exp3 instanceof ApplyExp) {
            final ApplyExp aexp3 = (ApplyExp)exp2;
            final ApplyExp aexp4 = (ApplyExp)exp3;
            final Object p1 = aexp3.getFunction().valueIfConstant();
            final Object p2 = aexp4.getFunction().valueIfConstant();
            final Expression exp4;
            if (p1 == RelativeStep.relativeStep && p2 instanceof ChildAxis && aexp3.getArgCount() == 2 && (exp4 = aexp3.getArg(1)) instanceof LambdaExp) {
                final LambdaExp lexp3 = (LambdaExp)exp4;
                if (lexp3.body instanceof ApplyExp && ((ApplyExp)lexp3.body).getFunction().valueIfConstant() == DescendantOrSelfAxis.anyNode) {
                    exp.setArg(0, aexp3.getArg(0));
                    aexp4.setFunction(new QuoteExp(DescendantAxis.make(((ChildAxis)p2).getNodePredicate())));
                }
            }
        }
        return result;
    }
    
    public static Expression validateApplyOrderedMap(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        if (args.length > 2) {
            final Expression[] rargs = new Expression[args.length - 1];
            System.arraycopy(args, 1, rargs, 0, rargs.length);
            final Expression[] xargs = new Expression[2];
            final Method makeTupleMethod = CompileMisc.typeTuples.getDeclaredMethod("make$V", 2);
            xargs[0] = args[0];
            xargs[1] = new ApplyExp(makeTupleMethod, rargs);
            return new ApplyExp(proc, xargs);
        }
        return exp;
    }
    
    public static void compileOrderedMap(final ApplyExp exp, final Compilation comp, final Target target, final Procedure proc) {
        final Expression[] args = exp.getArgs();
        if (args.length != 2) {
            ApplyExp.compile(exp, comp, target);
            return;
        }
        final CodeAttr code = comp.getCode();
        final Scope scope = code.pushScope();
        final Variable consumer = scope.addVariable(code, CompileMisc.typeTuples, null);
        args[1].compile(comp, Target.pushValue(CompileMisc.typeTuples));
        code.emitStore(consumer);
        final ConsumerTarget ctarget = new ConsumerTarget(consumer);
        args[0].compile(comp, ctarget);
        final Method mm = CompileMisc.typeTuples.getDeclaredMethod("run$X", 1);
        code.emitLoad(consumer);
        PrimProcedure.compileInvoke(comp, mm, target, exp.isTailCall(), 182, Type.pointer_type, false);
        code.popScope();
    }
    
    public static Expression validateApplyCastAs(ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        exp = CompileReflect.inlineClassName(exp, 0, visitor);
        final Expression[] args = exp.getArgs();
        if (args.length != 2 || !(args[0] instanceof QuoteExp)) {
            return exp;
        }
        final Object type = ((QuoteExp)args[0]).getValue();
        if (type instanceof XDataType) {
            return new ApplyExp(CompileMisc.castMethod, args);
        }
        return exp;
    }
    
    public static Expression validateApplyCastableAs(ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        exp = CompileReflect.inlineClassName(exp, 1, visitor);
        final Expression[] args = exp.getArgs();
        if (args.length != 2 || !(args[1] instanceof QuoteExp)) {
            return exp;
        }
        final Object type = ((QuoteExp)args[1]).getValue();
        if (type instanceof XDataType) {
            return new ApplyExp(CompileMisc.castableMethod, new Expression[] { args[1], args[0] });
        }
        return exp;
    }
    
    static {
        typeTuples = ClassType.make("gnu.xquery.util.OrderedTuples");
        typeXDataType = ClassType.make("gnu.kawa.xml.XDataType");
        castMethod = CompileMisc.typeXDataType.getDeclaredMethod("cast", 1);
        castableMethod = CompileMisc.typeXDataType.getDeclaredMethod("castable", 1);
    }
}
