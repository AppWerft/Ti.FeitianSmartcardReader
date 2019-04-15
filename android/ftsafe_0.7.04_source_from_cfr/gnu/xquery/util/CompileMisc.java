/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Target;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.ValuesMap;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.xml.ChildAxis;
import gnu.kawa.xml.CoerceNodes;
import gnu.kawa.xml.DescendantAxis;
import gnu.kawa.xml.DescendantOrSelfAxis;
import gnu.kawa.xml.NodeSetType;
import gnu.kawa.xml.NodeType;
import gnu.kawa.xml.SortNodes;
import gnu.kawa.xml.XDataType;
import gnu.lists.NodePredicate;
import gnu.mapping.Procedure;
import gnu.math.IntNum;
import gnu.text.SourceMessages;
import gnu.xquery.lang.XQuery;
import gnu.xquery.util.BooleanValue;
import gnu.xquery.util.Compare;
import gnu.xquery.util.RelativeStep;
import gnu.xquery.util.ValuesFilter;

public class CompileMisc {
    static final ClassType typeTuples = ClassType.make("gnu.xquery.util.OrderedTuples");
    static final ClassType typeXDataType = ClassType.make("gnu.kawa.xml.XDataType");
    static final Method castMethod = typeXDataType.getDeclaredMethod("cast", 1);
    static final Method castableMethod = typeXDataType.getDeclaredMethod("castable", 1);

    public static Expression validateCompare(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        Expression folded = exp.inlineIfConstant(proc, visitor);
        if (folded != exp) {
            return folded;
        }
        Compare cproc = (Compare)proc;
        if ((cproc.flags & 32) == 0) {
            exp = new ApplyExp(ClassType.make("gnu.xquery.util.Compare").getDeclaredMethod("apply", 4), new QuoteExp(IntNum.make(cproc.flags)), exp.getArg(0), exp.getArg(1), QuoteExp.nullExp);
        }
        if (exp.getTypeRaw() == null) {
            exp.setType(XDataType.booleanType);
        }
        return exp;
    }

    public static Expression validateBooleanValue(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        if (args.length == 1) {
            Expression arg = args[0];
            Type type = arg.getType();
            if (type == XDataType.booleanType) {
                return arg;
            }
            if (type == null) {
                exp.setType(XDataType.booleanType);
            }
            if (arg instanceof QuoteExp) {
                Object value = ((QuoteExp)arg).getValue();
                try {
                    return BooleanValue.booleanValue(value) ? XQuery.trueExp : XQuery.falseExp;
                }
                catch (Exception ex) {
                    String message = "cannot convert to a boolean";
                    visitor.getMessages().error('e', message);
                    return new ErrorExp(message);
                }
            }
        }
        return exp;
    }

    public static Expression validateArithOp(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        return exp;
    }

    public static Expression validateApplyValuesFilter(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Method sizeMethod;
        LambdaExp lexp2;
        Expression[] args;
        Type baseType;
        OccurrenceType occType;
        ValuesFilter vproc;
        block11 : {
            block10 : {
                vproc = (ValuesFilter)proc;
                exp.visitArgs(visitor);
                args = exp.getArgs();
                Expression exp2 = args[1];
                if (!(exp2 instanceof LambdaExp)) break block10;
                lexp2 = (LambdaExp)exp2;
                if (lexp2.min_args == 3 && lexp2.max_args == 3) break block11;
            }
            return exp;
        }
        Expression seq = args[0];
        Type seqType = seq.getType();
        if (seqType instanceof OccurrenceType && OccurrenceType.itemCountIsOne(baseType = (occType = (OccurrenceType)seqType).getBase())) {
            int min = occType.minOccurs();
            if (min > 0) {
                occType = new OccurrenceType(baseType, min, occType.maxOccurs());
            }
            exp.setType(occType);
        }
        Compilation comp = visitor.getCompilation();
        Declaration dotArg = lexp2.firstDecl();
        Declaration posArg = dotArg.nextDecl();
        Declaration lastArg = posArg.nextDecl();
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
        if (vproc.kind == 'P') {
            sizeMethod = Compilation.typeValues.getDeclaredMethod("countValues", 1);
        } else {
            seqType = SortNodes.typeSortedNodes;
            seq = new ApplyExp(SortNodes.sortNodes, seq);
            sizeMethod = ClassType.make("gnu.lists.AbstractSequence").getDeclaredMethod("size", 0);
        }
        Declaration sequence = comp.letVariable("sequence", seqType, seq);
        comp.letEnter();
        Expression pred = lexp2.body;
        Type predType = lexp2.body.getType();
        if (predType != XDataType.booleanType) {
            pred = new ApplyExp(ValuesFilter.matchesMethod, pred, new ReferenceExp(posArg));
        }
        if (vproc.kind == 'R') {
            Declaration posIncoming = new Declaration(null, Type.intType);
            posIncoming.setCanRead(true);
            ApplyExp init = new ApplyExp(AddOp.$Mn, new ReferenceExp(lastArg), new ReferenceExp(posIncoming));
            init = new ApplyExp(AddOp.$Pl, init, new QuoteExp(IntNum.one()));
            comp.letStart();
            lexp2.replaceFollowing(dotArg, posIncoming);
            comp.letVariable(posArg, init);
            comp.letEnter();
            pred = comp.letDone(pred);
        }
        lexp2.body = pred = new IfExp(pred, new ReferenceExp(dotArg), QuoteExp.voidExp);
        ApplyExp doMap = new ApplyExp(ValuesMap.valuesMapWithPos, lexp2, new ReferenceExp(sequence));
        doMap.setType(OccurrenceType.getInstance(dotArg.getType(), 0, -1));
        lexp2.returnContinuation = doMap;
        ApplyExp lastInit = new ApplyExp(sizeMethod, new ReferenceExp(sequence));
        comp.letStart();
        comp.letVariable(lastArg, lastInit);
        LetExp let2 = comp.letDone(gnu.kawa.functions.CompileMisc.validateApplyValuesMap(doMap, visitor, required, ValuesMap.valuesMapWithPos));
        return comp.letDone(let2);
    }

    public static Expression validateApplyRelativeStep(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Declaration dot2;
        Expression exp1;
        Expression exp2;
        Object proc2;
        Expression vexp2;
        LambdaExp lexp2;
        LambdaExp lvexp2;
        Declaration pos2;
        ApplyExp aexp2;
        Compilation comp;
        block11 : {
            block10 : {
                exp.visitArgs(visitor);
                Expression[] args = exp.getArgs();
                exp1 = args[0];
                exp2 = args[1];
                comp = visitor.getCompilation();
                if (!(exp2 instanceof LambdaExp) || !comp.mustCompile) break block10;
                lexp2 = (LambdaExp)exp2;
                if (lexp2.min_args == 3 && lexp2.max_args == 3) break block11;
            }
            return exp;
        }
        lexp2.setInlineOnly(exp, visitor.getCurrentLambda());
        exp2 = lexp2.body;
        Declaration dotArg = lexp2.firstDecl();
        Declaration posArg = dotArg.nextDecl();
        Declaration lastArg = posArg.nextDecl();
        posArg.setNext(lastArg.nextDecl());
        lastArg.setNext(null);
        lexp2.min_args = 2;
        lexp2.max_args = 2;
        Type type1 = exp1.getType();
        if (type1 != null && NodeType.anyNodeTest.compare(type1) == -3) {
            Language language = visitor.getCompilation().getLanguage();
            String message = "step input is " + language.formatType(type1) + " - not a node sequence";
            visitor.getMessages().error('e', message);
            return new ErrorExp(message);
        }
        Type rtype = exp.getTypeRaw();
        if (rtype == null || rtype == Type.pointer_type) {
            Type type2 = exp2.getType();
            Type rtypePrime = OccurrenceType.itemPrimeType(type2);
            int nodeCompare = NodeType.anyNodeTest.compare(rtypePrime);
            rtype = nodeCompare >= 0 ? NodeSetType.getInstance(rtypePrime) : OccurrenceType.getInstance(rtypePrime, 0, -1);
            exp.setType(rtype);
        }
        if (lastArg.getCanRead()) {
            ClassType typeNodes = CoerceNodes.typeNodes;
            comp.letStart();
            Declaration sequence = comp.letVariable(null, typeNodes, new ApplyExp(CoerceNodes.coerceNodes, exp1));
            comp.letEnter();
            Method sizeMethod = typeNodes.getDeclaredMethod("size", 0);
            ApplyExp lastInit = new ApplyExp(sizeMethod, new ReferenceExp(sequence));
            comp.letStart();
            comp.letVariable(lastArg, lastInit);
            comp.letEnter();
            LetExp lastLet = comp.letDone(new ApplyExp(exp.getFunction(), new ReferenceExp(sequence), lexp2));
            return comp.letDone(lastLet);
        }
        ApplyExp result = exp;
        if (exp2 instanceof ApplyExp && (proc2 = (aexp2 = (ApplyExp)exp2).getFunction().valueIfConstant()) instanceof ValuesFilter && (vexp2 = aexp2.getArgs()[1]) instanceof LambdaExp && (dot2 = (lvexp2 = (LambdaExp)vexp2).firstDecl()) != null && (pos2 = dot2.nextDecl()) != null && pos2.nextDecl() == null && !pos2.getCanRead() && ClassType.make("java.lang.Number").compare(lvexp2.body.getType()) == -3) {
            lexp2.body = exp2 = aexp2.getArg(0);
            aexp2.setArg(0, exp);
            result = aexp2;
        }
        if (exp1 instanceof ApplyExp && exp2 instanceof ApplyExp) {
            Expression exp12;
            ApplyExp aexp1 = (ApplyExp)exp1;
            ApplyExp aexp22 = (ApplyExp)exp2;
            Object p1 = aexp1.getFunction().valueIfConstant();
            Object p2 = aexp22.getFunction().valueIfConstant();
            if (p1 == RelativeStep.relativeStep && p2 instanceof ChildAxis && aexp1.getArgCount() == 2 && (exp12 = aexp1.getArg(1)) instanceof LambdaExp) {
                LambdaExp lexp12 = (LambdaExp)exp12;
                if (lexp12.body instanceof ApplyExp && ((ApplyExp)lexp12.body).getFunction().valueIfConstant() == DescendantOrSelfAxis.anyNode) {
                    exp.setArg(0, aexp1.getArg(0));
                    aexp22.setFunction(new QuoteExp(DescendantAxis.make(((ChildAxis)p2).getNodePredicate())));
                }
            }
        }
        return result;
    }

    public static Expression validateApplyOrderedMap(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        if (args.length > 2) {
            Expression[] rargs = new Expression[args.length - 1];
            System.arraycopy(args, 1, rargs, 0, rargs.length);
            Expression[] xargs = new Expression[2];
            Method makeTupleMethod = typeTuples.getDeclaredMethod("make$V", 2);
            xargs[0] = args[0];
            xargs[1] = new ApplyExp(makeTupleMethod, rargs);
            return new ApplyExp(proc, xargs);
        }
        return exp;
    }

    public static void compileOrderedMap(ApplyExp exp, Compilation comp, Target target, Procedure proc) {
        Expression[] args = exp.getArgs();
        if (args.length != 2) {
            ApplyExp.compile(exp, comp, target);
            return;
        }
        CodeAttr code = comp.getCode();
        Scope scope = code.pushScope();
        Variable consumer = scope.addVariable(code, typeTuples, null);
        args[1].compile(comp, Target.pushValue(typeTuples));
        code.emitStore(consumer);
        ConsumerTarget ctarget = new ConsumerTarget(consumer);
        args[0].compile(comp, ctarget);
        Method mm = typeTuples.getDeclaredMethod("run$X", 1);
        code.emitLoad(consumer);
        PrimProcedure.compileInvoke(comp, mm, target, exp.isTailCall(), 182, Type.pointer_type, false);
        code.popScope();
    }

    public static Expression validateApplyCastAs(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        exp = CompileReflect.inlineClassName(exp, 0, visitor);
        Expression[] args = exp.getArgs();
        if (args.length != 2 || !(args[0] instanceof QuoteExp)) {
            return exp;
        }
        Object type = ((QuoteExp)args[0]).getValue();
        if (type instanceof XDataType) {
            return new ApplyExp(castMethod, args);
        }
        return exp;
    }

    public static Expression validateApplyCastableAs(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        exp = CompileReflect.inlineClassName(exp, 1, visitor);
        Expression[] args = exp.getArgs();
        if (args.length != 2 || !(args[1] instanceof QuoteExp)) {
            return exp;
        }
        Object type = ((QuoteExp)args[1]).getValue();
        if (type instanceof XDataType) {
            return new ApplyExp(castableMethod, args[1], args[0]);
        }
        return exp;
    }
}

