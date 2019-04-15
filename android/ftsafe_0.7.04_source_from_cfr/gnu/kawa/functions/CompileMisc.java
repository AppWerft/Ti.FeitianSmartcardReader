/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ExitableBlock;
import gnu.bytecode.Field;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.ConditionalTarget;
import gnu.expr.ConsumerTarget;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.IgnoreTarget;
import gnu.expr.InlineCalls;
import gnu.expr.Inlineable;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.expr.TryExp;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.AppendValues;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.ConstantFunction0;
import gnu.kawa.functions.Convert;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.MakePromise;
import gnu.kawa.functions.Not;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.functions.NumberPredicate;
import gnu.kawa.functions.ValuesMap;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.LazyType;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.reflect.Throw;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongArguments;
import gnu.math.IntNum;
import kawa.standard.Scheme;

public class CompileMisc {
    static ClassType typeType;
    static Method coerceMethod;
    public static final ClassType typeContinuation;

    public static Expression validateApplyConstantFunction0(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        int nargs = exp.getArgCount();
        if (nargs != 0 && visitor != null) {
            String message = WrongArguments.checkArgCount(proc, nargs, false);
            return visitor.noteError(message);
        }
        return ((ConstantFunction0)proc).constant;
    }

    public static Expression validateApplyConvert(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Compilation comp = visitor.getCompilation();
        Language language = comp.getLanguage();
        Convert cproc = (Convert)proc;
        Expression[] args = exp.getArgs();
        if (args.length == 2) {
            args[0] = visitor.visit(args[0], null);
            Type type = language.getTypeFor(args[0]);
            if (type instanceof Type) {
                Type xtype;
                args[0] = new QuoteExp(type);
                Type type2 = xtype = cproc.lenient ? InlineCalls.LenientExpectedType.make(type) : type;
                if (!args[1].getFlag(1)) {
                    args[1] = ExpVisitor.visit(visitor, args[1], xtype);
                }
                args[1] = visitor.checkType(args[1], xtype);
                CompileReflect.checkKnownClass(type, comp);
                exp.setType(type);
                Type argType = args[1].getType();
                if (argType != Type.nullType && type.isCompatibleWithValue(argType) == 2) {
                    return args[1];
                }
                return exp;
            }
        }
        exp.visitArgs(visitor);
        return exp;
    }

    public static Expression validateApplySimpleBoolean(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        exp.setType(visitor.getCompilation().getLanguage().getTypeFor(Boolean.TYPE));
        return exp.inlineIfConstant(proc, visitor);
    }

    public static Expression validateApplyFormat(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        Type retType = Type.objectType;
        Expression[] args = exp.getArgs();
        if (args.length > 0) {
            ClassType typeFormat = ClassType.make("gnu.kawa.functions.Format");
            Object f = args[0].valueIfConstant();
            Type ftype = args[0].getType();
            if (f == Boolean.FALSE || ftype.isSubtype(LangObjType.stringType)) {
                int skip;
                int n = skip = f == Boolean.FALSE ? 1 : 0;
                if (skip > 0 && args.length > 1) {
                    f = args[1].valueIfConstant();
                }
                if (f instanceof CharSequence && !(f instanceof String)) {
                    f = f.toString();
                    args[skip] = QuoteExp.getInstance(f);
                }
                Expression[] xargs = new Expression[args.length + 1 - skip];
                xargs[0] = new QuoteExp(0, Type.intType);
                System.arraycopy(args, skip, xargs, 1, xargs.length - 1);
                ApplyExp ae = new ApplyExp(typeFormat.getDeclaredMethod("formatToString", 2), xargs);
                ae.setLine(exp);
                ae.setType(Type.javalangStringType);
                return ae;
            }
            if ((f == Boolean.TRUE || ftype.isSubtype(ClassType.make("java.io.Writer"))) && args.length > 1) {
                if (f == Boolean.TRUE) {
                    Expression[] xargs = new Expression[args.length];
                    xargs[0] = QuoteExp.nullExp;
                    System.arraycopy(args, 1, xargs, 1, args.length - 1);
                    args = xargs;
                }
                if ((f = args[1].valueIfConstant()) instanceof CharSequence && !(f instanceof String)) {
                    f = f.toString();
                    args[1] = QuoteExp.getInstance(f);
                }
                ApplyExp ae = new ApplyExp(typeFormat.getDeclaredMethod("formatToWriter", 3), args);
                ae.setLine(exp);
                ae.setType(Type.voidType);
                return ae;
            }
            if (ftype.isSubtype(ClassType.make("java.io.OutputStream"))) {
                retType = Type.voidType;
            }
        }
        exp.setType(retType);
        return null;
    }

    public static Expression validateApplyAppendValues(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        int nargs = args.length;
        if (nargs == 1) {
            return args[0];
        }
        if (nargs == 0) {
            return QuoteExp.voidExp;
        }
        Expression folded = exp.inlineIfConstant(proc, visitor);
        if (folded.valueIfConstant() == Values.empty) {
            folded = QuoteExp.voidObjectExp;
        } else if (folded == exp) {
            args = exp.getArgs();
            Type typeSoFar = Type.voidType;
            for (int i = 0; i < nargs; ++i) {
                Type atype = args[i].getType();
                if (OccurrenceType.itemCountCode(atype) == '0') continue;
                typeSoFar = typeSoFar == Type.voidType ? atype : Type.objectType;
            }
            exp.setType(typeSoFar);
        }
        return folded;
    }

    public static Expression validateApplyMakeProcedure(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        int alen = args.length;
        Expression method = null;
        int countMethods = 0;
        String name = null;
        for (int i = 0; i < alen; ++i) {
            Expression arg = args[i];
            Keyword key = arg.checkLiteralKeyword();
            if (key != null) {
                String keyword = key.getName();
                Expression next = args[++i];
                if (keyword == "name") {
                    if (!(next instanceof QuoteExp)) continue;
                    name = ((QuoteExp)next).getValue().toString();
                    continue;
                }
                if (keyword != "method") continue;
                ++countMethods;
                method = next;
                continue;
            }
            ++countMethods;
            method = arg;
        }
        if (countMethods == 1 && method instanceof LambdaExp) {
            LambdaExp lexp = (LambdaExp)method;
            for (int i = 0; i < alen; ++i) {
                Expression arg = args[i];
                Keyword key = arg.checkLiteralKeyword();
                if (key == null) continue;
                String keyword = key.getName();
                Expression next = args[++i];
                if (keyword == "name") {
                    lexp.setName(name);
                    continue;
                }
                if (keyword == "method") continue;
                lexp.setProperty(Namespace.EmptyNamespace.getSymbol(keyword), next);
            }
            return method;
        }
        return exp;
    }

    public static Expression validateApplyValuesMap(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        LambdaExp lexp = ValuesMap.canInline(exp, (ValuesMap)proc);
        exp.visitArgs(visitor);
        if (lexp != null) {
            lexp.setInlineOnly(exp, visitor.getCurrentLambda());
        }
        return exp;
    }

    public static boolean compileConvert(ApplyExp exp, Compilation comp, Target target, Procedure procedure) {
        Convert proc = (Convert)procedure;
        Expression[] args = exp.getArgs();
        if (args.length != 2 || !exp.isSimple()) {
            return false;
        }
        CodeAttr code = comp.getCode();
        Type type = Scheme.getTypeValue(args[0]);
        if (type == Type.neverReturnsType) {
            args[1].compile(comp, Target.Ignore);
            PrimProcedure.compileReachedUnexpected(code);
        } else if (type != null) {
            args[1].compile(comp, Target.pushValue(type));
            if (code.reachableHere() && !type.isVoid()) {
                target.compileFromStack(comp, type);
            }
        } else {
            if (typeType == null) {
                typeType = ClassType.make("gnu.bytecode.Type");
            }
            if (coerceMethod == null) {
                coerceMethod = typeType.addMethod("coerceFromObject", Compilation.apply1args, Type.pointer_type, 1);
            }
            args[0].compile(comp, LangObjType.typeClassType);
            args[1].compile(comp, Target.pushObject);
            code.emitInvokeVirtual(coerceMethod);
            target.compileFromStack(comp, Type.pointer_type);
        }
        return true;
    }

    public static boolean compileNot(ApplyExp exp, Compilation comp, Target target, Procedure procedure) {
        QuoteExp trueExp;
        QuoteExp falseExp;
        if (!exp.isSimple()) {
            return false;
        }
        Not proc = (Not)procedure;
        Expression arg = exp.getArgs()[0];
        Language language = proc.language;
        if (target instanceof ConditionalTarget) {
            ConditionalTarget ctarget = (ConditionalTarget)target;
            ConditionalTarget sub_target = new ConditionalTarget(ctarget.ifFalse, ctarget.ifTrue, language);
            sub_target.trueBranchComesFirst = !ctarget.trueBranchComesFirst;
            arg.compile(comp, sub_target);
            return true;
        }
        CodeAttr code = comp.getCode();
        Type type = target.getType();
        if (target instanceof StackTarget && type.getSignature().charAt(0) == 'Z') {
            trueExp = QuoteExp.trueExp;
            falseExp = QuoteExp.falseExp;
        } else {
            trueExp = QuoteExp.getInstance(language.booleanObject(true));
            falseExp = QuoteExp.getInstance(language.booleanObject(false));
        }
        IfExp.compile(arg, falseExp, trueExp, comp, target);
        return true;
    }

    public static boolean compileEq(ApplyExp exp, Compilation comp, Target target, Procedure proc) {
        boolean isNull;
        if (!exp.isSimple()) {
            return false;
        }
        Expression[] args = exp.getArgs();
        Language language = ((IsEq)proc).language;
        CodeAttr code = comp.getCode();
        Expression arg0 = args[0];
        Expression arg1 = args[1];
        if (arg0 == QuoteExp.nullExp) {
            Expression tmp = arg1;
            arg1 = arg0;
            arg0 = tmp;
        }
        arg0.compile(comp, Target.pushObject);
        boolean bl = isNull = arg1 == QuoteExp.nullExp;
        if (!isNull) {
            arg1.compile(comp, Target.pushObject);
        }
        if (target instanceof ConditionalTarget) {
            ConditionalTarget ctarget = (ConditionalTarget)target;
            if (ctarget.trueBranchComesFirst) {
                if (isNull) {
                    code.emitGotoIfNonNull(ctarget.ifFalse);
                } else {
                    code.emitGotoIfNE(ctarget.ifFalse);
                }
            } else if (isNull) {
                code.emitGotoIfNull(ctarget.ifTrue);
            } else {
                code.emitGotoIfEq(ctarget.ifTrue);
            }
            ctarget.emitGotoFirstBranch(code);
        } else {
            Type type;
            if (isNull) {
                code.emitIfNull();
            } else {
                code.emitIfEq();
            }
            if (target.getType() instanceof ClassType) {
                Object trueValue = language.booleanObject(true);
                Object falseValue = language.booleanObject(false);
                comp.compileConstant(trueValue, Target.pushObject);
                code.emitElse();
                comp.compileConstant(falseValue, Target.pushObject);
                type = trueValue instanceof Boolean && falseValue instanceof Boolean ? Compilation.scmBooleanType : Type.pointer_type;
            } else {
                code.emitPushInt(1);
                code.emitElse();
                code.emitPushInt(0);
                type = language.getTypeFor(Boolean.TYPE);
            }
            code.emitFi();
            target.compileFromStack(comp, type);
        }
        return true;
    }

    public static boolean compileNumberCompare(ApplyExp exp, Compilation comp, Target target, Procedure procedure) {
        String mname;
        NumberCompare proc = (NumberCompare)procedure;
        if (!exp.isSimple()) {
            return false;
        }
        CodeAttr code = comp.getCode();
        Expression[] args = exp.getArgs();
        if (args.length == 2) {
            Expression arg0 = args[0];
            Expression arg1 = args[1];
            int kind0 = CompileMisc.classifyForNumCompare(arg0);
            int kind1 = CompileMisc.classifyForNumCompare(arg1);
            if (kind0 > 0 && kind1 > 0 && kind0 <= 12 && kind1 <= 12 && (kind0 != 8 || kind1 != 8)) {
                Label label1;
                QuoteExp signBit;
                PrimType commonType;
                Object value;
                int opcode;
                if (!(target instanceof ConditionalTarget)) {
                    IfExp.compile(exp, QuoteExp.trueExp, QuoteExp.falseExp, comp, target);
                    return true;
                }
                int mask = proc.flags;
                if (mask == 1) {
                    mask = 20;
                }
                if (!(kind0 > 6 || kind1 > 6 || kind0 <= 3 && kind1 <= 3 || kind0 == 4 && kind1 == 4)) {
                    Type[] ctypes = new Type[2];
                    ctypes[0] = Arithmetic.typeIntNum;
                    if (kind1 <= 3) {
                        ctypes[1] = Type.longType;
                    } else if (kind0 <= 3 && (arg0 instanceof QuoteExp || arg1 instanceof QuoteExp || arg0 instanceof ReferenceExp || arg1 instanceof ReferenceExp)) {
                        ctypes[1] = Type.longType;
                        args = new Expression[]{arg1, arg0};
                        if (mask != 8 && mask != 20) {
                            mask ^= 20;
                        }
                    } else {
                        ctypes[1] = Arithmetic.typeIntNum;
                    }
                    Method cmeth = Arithmetic.typeIntNum.getMethod("compare", ctypes);
                    PrimProcedure compare = new PrimProcedure(cmeth, comp.getLanguage());
                    arg0 = new ApplyExp(compare, args);
                    arg1 = new QuoteExp(IntNum.zero());
                    kind1 = 1;
                    kind0 = 1;
                }
                if (kind0 <= 1 && kind1 <= 1) {
                    commonType = Type.intType;
                } else if (kind0 <= 2 && kind1 <= 2) {
                    if (kind0 <= 1 || kind1 <= 1) {
                        commonType = Type.longType;
                        kind1 = 3;
                        kind0 = 3;
                    } else {
                        signBit = QuoteExp.makeShared(Integer.MIN_VALUE, Type.intType);
                        arg0 = new ApplyExp(AddOp.$Pl, arg0, signBit);
                        arg1 = new ApplyExp(AddOp.$Pl, arg1, signBit);
                        kind1 = 1;
                        kind0 = 1;
                        commonType = Type.intType;
                    }
                } else if (kind0 <= 3 && kind1 <= 3) {
                    commonType = Type.longType;
                } else if (kind0 <= 4 && kind1 <= 4) {
                    signBit = QuoteExp.makeShared(Long.MIN_VALUE, Type.longType);
                    arg0 = new ApplyExp(AddOp.$Pl, arg0, signBit);
                    arg1 = new ApplyExp(AddOp.$Pl, arg1, signBit);
                    kind1 = 3;
                    kind0 = 3;
                    commonType = Type.longType;
                } else {
                    commonType = Type.doubleType;
                }
                StackTarget subTarget = new StackTarget(commonType);
                ConditionalTarget ctarget = (ConditionalTarget)target;
                if (arg0 instanceof QuoteExp && !(arg1 instanceof QuoteExp)) {
                    Expression tmp = arg1;
                    arg1 = arg0;
                    arg0 = tmp;
                    if (mask != 8 && mask != 20) {
                        mask ^= 20;
                    }
                }
                Label label = label1 = ctarget.trueBranchComesFirst ? ctarget.ifFalse : ctarget.ifTrue;
                if (ctarget.trueBranchComesFirst) {
                    mask ^= 28;
                }
                switch (mask) {
                    case 16: {
                        opcode = 157;
                        break;
                    }
                    case 8: {
                        opcode = 153;
                        break;
                    }
                    case 4: {
                        opcode = 155;
                        break;
                    }
                    case 20: {
                        opcode = 154;
                        break;
                    }
                    case 24: {
                        opcode = 156;
                        break;
                    }
                    case 12: {
                        opcode = 158;
                        break;
                    }
                    default: {
                        opcode = 0;
                    }
                }
                arg0.compile(comp, subTarget);
                if (kind0 <= 1 && kind1 <= 1 && arg1 instanceof QuoteExp && (value = ((QuoteExp)arg1).getValue()) instanceof IntNum && ((IntNum)value).isZero()) {
                    code.emitGotoIfCompare1(label1, opcode);
                } else {
                    arg1.compile(comp, subTarget);
                    code.emitGotoIfCompare2(label1, opcode);
                }
                ctarget.emitGotoFirstBranch(code);
                return true;
            }
        }
        switch (proc.flags) {
            case 16: {
                mname = "$Gr";
                break;
            }
            case 8: {
                mname = "$Eq";
                break;
            }
            case 4: {
                mname = "$Ls";
                break;
            }
            case 24: {
                mname = "$Gr$Eq";
                break;
            }
            case 12: {
                mname = "$Ls$Eq";
                break;
            }
            default: {
                mname = null;
            }
        }
        if (mname != null) {
            ClassType compclass = ClassType.make("gnu.kawa.functions.NumberCompare");
            Method meth = args.length == 2 ? compclass.getDeclaredMethod(mname, 2) : compclass.getDeclaredMethod(mname + "$V", 4);
            new ApplyExp(meth, args).setLine(exp).compile(comp, target);
            return true;
        }
        return false;
    }

    static int classifyForNumCompare(Expression exp) {
        Object value;
        Type type = exp.getType();
        int kind = Arithmetic.classifyType(type);
        if (kind == 6 && exp instanceof QuoteExp && (value = ((QuoteExp)exp).getValue()) instanceof IntNum) {
            int ilength = ((IntNum)value).intLength();
            if (ilength < 32) {
                return 1;
            }
            if (ilength < 64) {
                return 3;
            }
        }
        return kind;
    }

    public static boolean compileNumPredicate(ApplyExp exp, Compilation comp, Target target, Procedure procedure) {
        NumberPredicate proc = (NumberPredicate)procedure;
        if (!exp.isSimple()) {
            return false;
        }
        Expression[] args = exp.getArgs();
        int op = proc.op;
        if (args.length == 1 && (op == 1 || op == 2)) {
            Expression arg0 = args[0];
            int kind = Arithmetic.classifyType(arg0.getType());
            CodeAttr code = comp.getCode();
            if (kind <= 6) {
                PrimType wtype = Type.intType;
                Target wtarget = StackTarget.getInstance(wtype);
                if (op == 2) {
                    code.emitPushInt(1);
                }
                arg0.compile(comp, wtarget);
                code.emitPushInt(1);
                code.emitAnd();
                if (op == 2) {
                    code.emitSub(Type.intType);
                }
            } else {
                arg0.compile(comp, Target.pushObject);
                String mname = op == 2 ? "isEven" : "isOdd";
                Method m = ClassType.make("gnu.kawa.functions.NumberPredicate").getDeclaredMethod(mname, 1);
                code.emitInvokeStatic(m);
            }
            target.compileFromStack(comp, Type.booleanType);
            return true;
        }
        return false;
    }

    public static Expression validateApplyCallCC(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        LambdaExp lexp = CompileMisc.canInlineCallCC(exp);
        if (lexp != null) {
            lexp.setInlineOnly(exp, visitor.getCurrentLambda());
            Declaration contDecl = lexp.firstDecl();
            if (!contDecl.getFlag(8192L)) {
                contDecl.setType(typeContinuation);
            }
            contDecl.setFlag(0x10000000000L);
            LambdaExp.maybeSetReturnType(lexp, required);
        }
        exp.visitArgs(visitor);
        return exp;
    }

    public static void compileCallCC(ApplyExp exp, Compilation comp, Target target, Procedure proc) {
        LambdaExp lambda = CompileMisc.canInlineCallCC(exp);
        if (lambda == null) {
            ApplyExp.compile(exp, comp, target);
            return;
        }
        CodeAttr code = comp.getCode();
        Declaration param = lambda.firstDecl();
        if (param.isSimple() && !param.getCanRead() && !param.getCanWrite()) {
            ExitableBlock bl;
            param.setCanCall(false);
            CompileTimeContinuation contProxy = new CompileTimeContinuation();
            Type rtype = target instanceof StackTarget ? target.getType() : null;
            boolean runFinallyBlocks = ExitThroughFinallyChecker.check(param, lambda.body);
            contProxy.exitableBlock = bl = code.startExitableBlock(rtype, runFinallyBlocks);
            contProxy.blockTarget = target;
            param.setValue(new QuoteExp(contProxy));
            new ApplyExp(lambda, QuoteExp.nullExp).compile(comp, target);
            code.endExitableBlock();
            return;
        }
        Scope sc = code.pushScope();
        Variable contVar = sc.addVariable(code, typeContinuation, null);
        Declaration contDecl = new Declaration(contVar);
        code.emitNew(typeContinuation);
        code.emitDup(typeContinuation);
        comp.loadCallContext();
        code.emitInvokeSpecial(typeContinuation.getDeclaredMethod("<init>", 1));
        code.emitStore(contVar);
        code.emitTryStart(false, target instanceof IgnoreTarget || target instanceof ConsumerTarget ? null : target.getType().getRawType());
        ApplyExp app = new ApplyExp(lambda, new ReferenceExp(contDecl));
        app.compile(comp, target);
        if (code.reachableHere()) {
            code.emitLoad(contVar);
            code.emitPushInt(1);
            code.emitPutField(typeContinuation.getField("invoked"));
        }
        code.emitCatchStart((ClassType)null);
        code.emitLoad(contVar);
        if (target instanceof ConsumerTarget) {
            comp.loadCallContext();
            Method handleMethod = typeContinuation.getDeclaredMethod("handleException$X", 3);
            code.emitInvokeStatic(handleMethod);
        } else {
            Method handleMethod = typeContinuation.getDeclaredMethod("handleException", 2);
            code.emitInvokeStatic(handleMethod);
            target.compileFromStack(comp, Type.objectType);
        }
        code.emitCatchEnd();
        code.emitTryCatchEnd();
        code.popScope();
    }

    private static LambdaExp canInlineCallCC(ApplyExp exp) {
        Expression arg0;
        Expression[] args = exp.getArgs();
        if (args.length == 1 && (arg0 = args[0]) instanceof LambdaExp && !Compilation.enableANF) {
            LambdaExp lexp = (LambdaExp)arg0;
            if (lexp.min_args == 1 && lexp.max_args == 1 && !lexp.firstDecl().getCanWrite()) {
                return lexp;
            }
        }
        return null;
    }

    public static Expression validateApplyWithExceptionHandler(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression handler;
        Expression[] args = exp.getArgs();
        args[0] = handler = visitor.visit(args[0], null);
        Expression thunk = args[1];
        if (thunk instanceof LambdaExp) {
            LambdaExp lthunk = (LambdaExp)thunk;
            if (lthunk.min_args == 0 && lthunk.max_args == 0) {
                Expression tryClause;
                LambdaExp.maybeSetReturnType(lthunk, required);
                args[1] = thunk = visitor.visit((Expression)lthunk, required);
                Compilation comp = visitor.getCompilation();
                comp.letStart();
                ClassType handlerLinkType = ClassType.make("kawa.lib.HandlerLink");
                Method pushMethod = handlerLinkType.getDeclaredMethod("push", 1);
                Method popMethod = handlerLinkType.getDeclaredMethod("pop", 0);
                Declaration linkDecl = comp.letVariable(null, handlerLinkType, new ApplyExp(pushMethod, handler));
                comp.letEnter();
                Type bodyType = lthunk.getReturnType();
                ApplyExp bodyCall = new ApplyExp(thunk, new Expression[0]);
                ApplyExp popHandler = new ApplyExp(popMethod, new ReferenceExp(linkDecl));
                if (bodyType.isVoid()) {
                    tryClause = new BeginExp(bodyCall, popHandler);
                } else {
                    comp.letStart();
                    Declaration resultDecl = comp.letVariable(null, bodyType, bodyCall);
                    comp.letEnter();
                    tryClause = comp.letDone(new BeginExp(popHandler, new ReferenceExp(resultDecl)));
                }
                TryExp texp = new TryExp(tryClause, null);
                Declaration exDecl = new Declaration(null, Type.javalangThrowableType);
                ApplyExp doHandle = new ApplyExp(handlerLinkType.getDeclaredMethod("handle", 1), new ReferenceExp(linkDecl), new ReferenceExp(exDecl));
                texp.addCatchClause(exDecl, new ApplyExp(Throw.primitiveThrow, doHandle));
                return visitor.visit((Expression)comp.letDone(texp), required);
            }
        }
        args[1] = thunk = visitor.visit(thunk, null);
        return exp;
    }

    public static Expression validateApplyMakeDynamic(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        if (exp.isSimple(1, 1)) {
            Expression[] args = exp.getArgs();
            args[0] = visitor.visit(args[0], null);
            exp.setType(LangObjType.dynamicType);
        } else {
            exp.visitArgs(visitor);
        }
        return exp;
    }

    public static boolean compileMakeDynamic(ApplyExp exp, Compilation comp, Target target, Procedure procedure) {
        if (!exp.isSimple()) {
            return false;
        }
        exp.getArg(0).compile(comp, target);
        return true;
    }

    public static Expression validateApplyMakePromise(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression[] args = exp.getArgs();
        if (args.length == 1 && args[0] instanceof LambdaExp) {
            boolean forceValueIfPromise;
            Type bodyRequired;
            boolean bl = forceValueIfPromise = proc == MakePromise.makeLazy;
            if (required instanceof LazyType) {
                Type valueType = ((LazyType)required).getValueType();
                bodyRequired = forceValueIfPromise ? LazyType.getLazyType(valueType) : valueType;
            } else {
                bodyRequired = null;
            }
            LambdaExp lexp = (LambdaExp)args[0];
            lexp.body = visitor.visit(lexp.body, bodyRequired);
            args[0] = visitor.visit((Expression)lexp, null);
            Type rtype = lexp.getReturnType();
            if (forceValueIfPromise) {
                rtype = rtype instanceof LazyType ? ((LazyType)rtype).getValueType() : Type.objectType;
            }
            LazyType type = LazyType.getLazyType(rtype);
            String mname = forceValueIfPromise ? "makePromiseLazy" : "makePromise";
            Method meth = ClassType.make("gnu.kawa.functions.MakePromise").getDeclaredMethod(mname, 1);
            PrimProcedure mproc = new PrimProcedure(meth);
            mproc.setReturnType(type);
            exp = new ApplyExp(mproc, args);
            exp.setType(type);
        } else {
            exp.visitArgs(visitor);
        }
        return exp;
    }

    static {
        typeContinuation = ClassType.make("kawa.lang.Continuation");
    }

    static class CompileTimeContinuation
    extends ProcedureN
    implements Inlineable {
        Target blockTarget;
        ExitableBlock exitableBlock;

        CompileTimeContinuation() {
        }

        @Override
        public Object applyN(Object[] args) throws Throwable {
            throw new Error("internal error");
        }

        @Override
        public void compile(ApplyExp exp, Compilation comp, Target target) {
            Type typeNeeded;
            CodeAttr code = comp.getCode();
            Expression[] args = exp.getArgs();
            int nargs = args.length;
            boolean noStack = this.blockTarget instanceof IgnoreTarget || this.blockTarget instanceof ConsumerTarget;
            Type type = typeNeeded = noStack ? null : target.getType();
            if (noStack || nargs == 1) {
                for (int i = 0; i < nargs; ++i) {
                    args[i].compileWithPosition(comp, this.blockTarget);
                }
            } else {
                AppendValues app = AppendValues.appendValues;
                app.compile(new ApplyExp(app, args), comp, this.blockTarget);
            }
            this.exitableBlock.exit();
        }

        @Override
        public Type getReturnType(Expression[] args) {
            return Type.neverReturnsType;
        }
    }

    static class ExitThroughFinallyChecker
    extends ExpVisitor<Expression, TryExp> {
        Declaration decl;

        ExitThroughFinallyChecker() {
        }

        public static boolean check(Declaration decl, Expression body) {
            ExitThroughFinallyChecker visitor = new ExitThroughFinallyChecker();
            visitor.decl = decl;
            visitor.visit(body, null);
            return visitor.exitValue != null;
        }

        @Override
        protected Expression defaultValue(Expression r, TryExp d) {
            return r;
        }

        @Override
        protected Expression visitReferenceExp(ReferenceExp exp, TryExp currentTry) {
            if (this.decl == exp.getBinding() && currentTry != null) {
                this.exitValue = Boolean.TRUE;
            }
            return exp;
        }

        @Override
        protected Expression visitTryExp(TryExp exp, TryExp currentTry) {
            this.visitExpression(exp, exp.getFinallyClause() != null ? exp : currentTry);
            return exp;
        }
    }

}

