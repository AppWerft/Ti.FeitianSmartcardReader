// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.expr.Inlineable;
import gnu.mapping.ProcedureN;
import gnu.kawa.reflect.LazyType;
import gnu.kawa.reflect.Throw;
import gnu.expr.TryExp;
import gnu.expr.BeginExp;
import gnu.bytecode.Variable;
import gnu.bytecode.Scope;
import gnu.bytecode.ExitableBlock;
import gnu.expr.ConsumerTarget;
import gnu.expr.IgnoreTarget;
import gnu.expr.Declaration;
import gnu.bytecode.PrimType;
import gnu.bytecode.Label;
import gnu.math.IntNum;
import gnu.expr.ReferenceExp;
import gnu.expr.IfExp;
import gnu.expr.StackTarget;
import gnu.expr.ConditionalTarget;
import gnu.bytecode.CodeAttr;
import gnu.expr.PrimProcedure;
import kawa.standard.Scheme;
import gnu.expr.Target;
import gnu.expr.Keyword;
import gnu.mapping.Namespace;
import gnu.expr.LambdaExp;
import gnu.kawa.reflect.OccurrenceType;
import gnu.mapping.Values;
import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.Language;
import gnu.expr.Compilation;
import gnu.kawa.reflect.CompileReflect;
import gnu.expr.ExpVisitor;
import gnu.expr.QuoteExp;
import gnu.mapping.WrongArguments;
import gnu.expr.Expression;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.expr.ApplyExp;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;

public class CompileMisc
{
    static ClassType typeType;
    static Method coerceMethod;
    public static final ClassType typeContinuation;
    
    public static Expression validateApplyConstantFunction0(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final int nargs = exp.getArgCount();
        if (nargs != 0 && visitor != null) {
            final String message = WrongArguments.checkArgCount(proc, nargs, false);
            return visitor.noteError(message);
        }
        return ((ConstantFunction0)proc).constant;
    }
    
    public static Expression validateApplyConvert(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final Compilation comp = visitor.getCompilation();
        final Language language = comp.getLanguage();
        final Convert cproc = (Convert)proc;
        final Expression[] args = exp.getArgs();
        if (args.length == 2) {
            args[0] = visitor.visit(args[0], (Type)null);
            final Type type = language.getTypeFor(args[0]);
            if (type instanceof Type) {
                args[0] = new QuoteExp(type);
                final Type xtype = cproc.lenient ? InlineCalls.LenientExpectedType.make(type) : type;
                if (!args[1].getFlag(1)) {
                    args[1] = ExpVisitor.visit((ExpVisitor<Expression, Type>)visitor, args[1], xtype);
                }
                args[1] = visitor.checkType(args[1], xtype);
                CompileReflect.checkKnownClass(type, comp);
                exp.setType(type);
                final Type argType = args[1].getType();
                if (argType != Type.nullType && type.isCompatibleWithValue(argType) == 2) {
                    return args[1];
                }
                return exp;
            }
        }
        exp.visitArgs(visitor);
        return exp;
    }
    
    public static Expression validateApplySimpleBoolean(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        exp.setType(visitor.getCompilation().getLanguage().getTypeFor(Boolean.TYPE));
        return exp.inlineIfConstant(proc, visitor);
    }
    
    public static Expression validateApplyFormat(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        Type retType = Type.objectType;
        Expression[] args = exp.getArgs();
        if (args.length > 0) {
            final ClassType typeFormat = ClassType.make("gnu.kawa.functions.Format");
            Object f = args[0].valueIfConstant();
            final Type ftype = args[0].getType();
            if (f == Boolean.FALSE || ftype.isSubtype(LangObjType.stringType)) {
                final int skip = (f == Boolean.FALSE) ? 1 : 0;
                if (skip > 0 && args.length > 1) {
                    f = args[1].valueIfConstant();
                }
                if (f instanceof CharSequence && !(f instanceof String)) {
                    f = f.toString();
                    args[skip] = QuoteExp.getInstance(f);
                }
                final Expression[] xargs = new Expression[args.length + 1 - skip];
                xargs[0] = new QuoteExp(0, Type.intType);
                System.arraycopy(args, skip, xargs, 1, xargs.length - 1);
                final ApplyExp ae = new ApplyExp(typeFormat.getDeclaredMethod("formatToString", 2), xargs);
                ae.setLine(exp);
                ae.setType(Type.javalangStringType);
                return ae;
            }
            if ((f == Boolean.TRUE || ftype.isSubtype(ClassType.make("java.io.Writer"))) && args.length > 1) {
                if (f == Boolean.TRUE) {
                    final Expression[] xargs2 = new Expression[args.length];
                    xargs2[0] = QuoteExp.nullExp;
                    System.arraycopy(args, 1, xargs2, 1, args.length - 1);
                    args = xargs2;
                }
                f = args[1].valueIfConstant();
                if (f instanceof CharSequence && !(f instanceof String)) {
                    f = f.toString();
                    args[1] = QuoteExp.getInstance(f);
                }
                final ApplyExp ae2 = new ApplyExp(typeFormat.getDeclaredMethod("formatToWriter", 3), args);
                ae2.setLine(exp);
                ae2.setType(Type.voidType);
                return ae2;
            }
            if (ftype.isSubtype(ClassType.make("java.io.OutputStream"))) {
                retType = Type.voidType;
            }
        }
        exp.setType(retType);
        return null;
    }
    
    public static Expression validateApplyAppendValues(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        final int nargs = args.length;
        if (nargs == 1) {
            return args[0];
        }
        if (nargs == 0) {
            return QuoteExp.voidExp;
        }
        Expression folded = exp.inlineIfConstant(proc, visitor);
        if (folded.valueIfConstant() == Values.empty) {
            folded = QuoteExp.voidObjectExp;
        }
        else if (folded == exp) {
            args = exp.getArgs();
            Type typeSoFar = Type.voidType;
            for (int i = 0; i < nargs; ++i) {
                final Type atype = args[i].getType();
                if (OccurrenceType.itemCountCode(atype) != '0') {
                    if (typeSoFar == Type.voidType) {
                        typeSoFar = atype;
                    }
                    else {
                        typeSoFar = Type.objectType;
                    }
                }
            }
            exp.setType(typeSoFar);
        }
        return folded;
    }
    
    public static Expression validateApplyMakeProcedure(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        final int alen = args.length;
        Expression method = null;
        int countMethods = 0;
        String name = null;
        for (int i = 0; i < alen; ++i) {
            final Expression arg = args[i];
            final Keyword key = arg.checkLiteralKeyword();
            if (key != null) {
                final String keyword = key.getName();
                final Expression next = args[++i];
                if (keyword == "name") {
                    if (next instanceof QuoteExp) {
                        name = ((QuoteExp)next).getValue().toString();
                    }
                }
                else if (keyword == "method") {
                    ++countMethods;
                    method = next;
                }
            }
            else {
                ++countMethods;
                method = arg;
            }
        }
        if (countMethods == 1 && method instanceof LambdaExp) {
            final LambdaExp lexp = (LambdaExp)method;
            for (int j = 0; j < alen; ++j) {
                final Expression arg2 = args[j];
                final Keyword key2 = arg2.checkLiteralKeyword();
                if (key2 != null) {
                    final String keyword2 = key2.getName();
                    final Expression next2 = args[++j];
                    if (keyword2 == "name") {
                        lexp.setName(name);
                    }
                    else if (keyword2 != "method") {
                        lexp.setProperty(Namespace.EmptyNamespace.getSymbol(keyword2), next2);
                    }
                }
            }
            return method;
        }
        return exp;
    }
    
    public static Expression validateApplyValuesMap(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final LambdaExp lexp = ValuesMap.canInline(exp, (ValuesMap)proc);
        exp.visitArgs(visitor);
        if (lexp != null) {
            lexp.setInlineOnly(exp, visitor.getCurrentLambda());
        }
        return exp;
    }
    
    public static boolean compileConvert(final ApplyExp exp, final Compilation comp, final Target target, final Procedure procedure) {
        final Convert proc = (Convert)procedure;
        final Expression[] args = exp.getArgs();
        if (args.length != 2 || !exp.isSimple()) {
            return false;
        }
        final CodeAttr code = comp.getCode();
        final Type type = Scheme.getTypeValue(args[0]);
        if (type == Type.neverReturnsType) {
            args[1].compile(comp, Target.Ignore);
            PrimProcedure.compileReachedUnexpected(code);
        }
        else if (type != null) {
            args[1].compile(comp, Target.pushValue(type));
            if (code.reachableHere() && !type.isVoid()) {
                target.compileFromStack(comp, type);
            }
        }
        else {
            if (CompileMisc.typeType == null) {
                CompileMisc.typeType = ClassType.make("gnu.bytecode.Type");
            }
            if (CompileMisc.coerceMethod == null) {
                CompileMisc.coerceMethod = CompileMisc.typeType.addMethod("coerceFromObject", Compilation.apply1args, Type.pointer_type, 1);
            }
            args[0].compile(comp, LangObjType.typeClassType);
            args[1].compile(comp, Target.pushObject);
            code.emitInvokeVirtual(CompileMisc.coerceMethod);
            target.compileFromStack(comp, Type.pointer_type);
        }
        return true;
    }
    
    public static boolean compileNot(final ApplyExp exp, final Compilation comp, final Target target, final Procedure procedure) {
        if (!exp.isSimple()) {
            return false;
        }
        final Not proc = (Not)procedure;
        final Expression arg = exp.getArgs()[0];
        final Language language = proc.language;
        if (target instanceof ConditionalTarget) {
            final ConditionalTarget ctarget = (ConditionalTarget)target;
            final ConditionalTarget sub_target = new ConditionalTarget(ctarget.ifFalse, ctarget.ifTrue, language);
            sub_target.trueBranchComesFirst = !ctarget.trueBranchComesFirst;
            arg.compile(comp, sub_target);
            return true;
        }
        final CodeAttr code = comp.getCode();
        final Type type = target.getType();
        QuoteExp trueExp;
        QuoteExp falseExp;
        if (target instanceof StackTarget && type.getSignature().charAt(0) == 'Z') {
            trueExp = QuoteExp.trueExp;
            falseExp = QuoteExp.falseExp;
        }
        else {
            trueExp = QuoteExp.getInstance(language.booleanObject(true));
            falseExp = QuoteExp.getInstance(language.booleanObject(false));
        }
        IfExp.compile(arg, falseExp, trueExp, comp, target);
        return true;
    }
    
    public static boolean compileEq(final ApplyExp exp, final Compilation comp, final Target target, final Procedure proc) {
        if (!exp.isSimple()) {
            return false;
        }
        final Expression[] args = exp.getArgs();
        final Language language = ((IsEq)proc).language;
        final CodeAttr code = comp.getCode();
        Expression arg0 = args[0];
        Expression arg2 = args[1];
        if (arg0 == QuoteExp.nullExp) {
            final Expression tmp = arg2;
            arg2 = arg0;
            arg0 = tmp;
        }
        arg0.compile(comp, Target.pushObject);
        final boolean isNull = arg2 == QuoteExp.nullExp;
        if (!isNull) {
            arg2.compile(comp, Target.pushObject);
        }
        if (target instanceof ConditionalTarget) {
            final ConditionalTarget ctarget = (ConditionalTarget)target;
            if (ctarget.trueBranchComesFirst) {
                if (isNull) {
                    code.emitGotoIfNonNull(ctarget.ifFalse);
                }
                else {
                    code.emitGotoIfNE(ctarget.ifFalse);
                }
            }
            else if (isNull) {
                code.emitGotoIfNull(ctarget.ifTrue);
            }
            else {
                code.emitGotoIfEq(ctarget.ifTrue);
            }
            ctarget.emitGotoFirstBranch(code);
        }
        else {
            if (isNull) {
                code.emitIfNull();
            }
            else {
                code.emitIfEq();
            }
            Type type;
            if (target.getType() instanceof ClassType) {
                final Object trueValue = language.booleanObject(true);
                final Object falseValue = language.booleanObject(false);
                comp.compileConstant(trueValue, Target.pushObject);
                code.emitElse();
                comp.compileConstant(falseValue, Target.pushObject);
                if (trueValue instanceof Boolean && falseValue instanceof Boolean) {
                    type = Compilation.scmBooleanType;
                }
                else {
                    type = Type.pointer_type;
                }
            }
            else {
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
    
    public static boolean compileNumberCompare(final ApplyExp exp, final Compilation comp, final Target target, final Procedure procedure) {
        final NumberCompare proc = (NumberCompare)procedure;
        if (!exp.isSimple()) {
            return false;
        }
        final CodeAttr code = comp.getCode();
        Expression[] args = exp.getArgs();
        if (args.length == 2) {
            Expression arg0 = args[0];
            Expression arg2 = args[1];
            int kind0 = classifyForNumCompare(arg0);
            int kind2 = classifyForNumCompare(arg2);
            if (kind0 > 0 && kind2 > 0 && kind0 <= 12 && kind2 <= 12 && (kind0 != 8 || kind2 != 8)) {
                if (!(target instanceof ConditionalTarget)) {
                    IfExp.compile(exp, QuoteExp.trueExp, QuoteExp.falseExp, comp, target);
                    return true;
                }
                int mask = proc.flags;
                if (mask == 1) {
                    mask = 20;
                }
                if (kind0 <= 6 && kind2 <= 6 && (kind0 > 3 || kind2 > 3) && (kind0 != 4 || kind2 != 4)) {
                    final Type[] ctypes = { Arithmetic.typeIntNum, null };
                    if (kind2 <= 3) {
                        ctypes[1] = Type.longType;
                    }
                    else if (kind0 <= 3 && (arg0 instanceof QuoteExp || arg2 instanceof QuoteExp || arg0 instanceof ReferenceExp || arg2 instanceof ReferenceExp)) {
                        ctypes[1] = Type.longType;
                        args = new Expression[] { arg2, arg0 };
                        if (mask != 8 && mask != 20) {
                            mask ^= 0x14;
                        }
                    }
                    else {
                        ctypes[1] = Arithmetic.typeIntNum;
                    }
                    final Method cmeth = Arithmetic.typeIntNum.getMethod("compare", ctypes);
                    final PrimProcedure compare = new PrimProcedure(cmeth, comp.getLanguage());
                    arg0 = new ApplyExp(compare, args);
                    arg2 = new QuoteExp(IntNum.zero());
                    kind2 = (kind0 = 1);
                }
                Type commonType;
                if (kind0 <= 1 && kind2 <= 1) {
                    commonType = Type.intType;
                }
                else if (kind0 <= 2 && kind2 <= 2) {
                    if (kind0 <= 1 || kind2 <= 1) {
                        commonType = Type.longType;
                        kind2 = (kind0 = 3);
                    }
                    else {
                        final Expression signBit = QuoteExp.makeShared(Integer.MIN_VALUE, Type.intType);
                        arg0 = new ApplyExp(AddOp.$Pl, new Expression[] { arg0, signBit });
                        arg2 = new ApplyExp(AddOp.$Pl, new Expression[] { arg2, signBit });
                        kind2 = (kind0 = 1);
                        commonType = Type.intType;
                    }
                }
                else if (kind0 <= 3 && kind2 <= 3) {
                    commonType = Type.longType;
                }
                else if (kind0 <= 4 && kind2 <= 4) {
                    final Expression signBit = QuoteExp.makeShared(Long.MIN_VALUE, Type.longType);
                    arg0 = new ApplyExp(AddOp.$Pl, new Expression[] { arg0, signBit });
                    arg2 = new ApplyExp(AddOp.$Pl, new Expression[] { arg2, signBit });
                    kind2 = (kind0 = 3);
                    commonType = Type.longType;
                }
                else {
                    commonType = Type.doubleType;
                }
                final StackTarget subTarget = new StackTarget(commonType);
                final ConditionalTarget ctarget = (ConditionalTarget)target;
                if (arg0 instanceof QuoteExp && !(arg2 instanceof QuoteExp)) {
                    final Expression tmp = arg2;
                    arg2 = arg0;
                    arg0 = tmp;
                    if (mask != 8 && mask != 20) {
                        mask ^= 0x14;
                    }
                }
                final Label label1 = ctarget.trueBranchComesFirst ? ctarget.ifFalse : ctarget.ifTrue;
                if (ctarget.trueBranchComesFirst) {
                    mask ^= 0x1C;
                }
                int opcode = 0;
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
                        break;
                    }
                }
                arg0.compile(comp, subTarget);
                final Object value;
                if (kind0 <= 1 && kind2 <= 1 && arg2 instanceof QuoteExp && (value = ((QuoteExp)arg2).getValue()) instanceof IntNum && ((IntNum)value).isZero()) {
                    code.emitGotoIfCompare1(label1, opcode);
                }
                else {
                    arg2.compile(comp, subTarget);
                    code.emitGotoIfCompare2(label1, opcode);
                }
                ctarget.emitGotoFirstBranch(code);
                return true;
            }
        }
        String mname = null;
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
                break;
            }
        }
        if (mname != null) {
            final ClassType compclass = ClassType.make("gnu.kawa.functions.NumberCompare");
            final Method meth = (args.length == 2) ? compclass.getDeclaredMethod(mname, 2) : compclass.getDeclaredMethod(mname + "$V", 4);
            new ApplyExp(meth, args).setLine(exp).compile(comp, target);
            return true;
        }
        return false;
    }
    
    static int classifyForNumCompare(final Expression exp) {
        final Type type = exp.getType();
        final int kind = Arithmetic.classifyType(type);
        final Object value;
        if (kind == 6 && exp instanceof QuoteExp && (value = ((QuoteExp)exp).getValue()) instanceof IntNum) {
            final int ilength = ((IntNum)value).intLength();
            if (ilength < 32) {
                return 1;
            }
            if (ilength < 64) {
                return 3;
            }
        }
        return kind;
    }
    
    public static boolean compileNumPredicate(final ApplyExp exp, final Compilation comp, final Target target, final Procedure procedure) {
        final NumberPredicate proc = (NumberPredicate)procedure;
        if (!exp.isSimple()) {
            return false;
        }
        final Expression[] args = exp.getArgs();
        final int op = proc.op;
        if (args.length == 1 && (op == 1 || op == 2)) {
            final Expression arg0 = args[0];
            final int kind = Arithmetic.classifyType(arg0.getType());
            final CodeAttr code = comp.getCode();
            if (kind <= 6) {
                final PrimType wtype = Type.intType;
                final Target wtarget = StackTarget.getInstance(wtype);
                if (op == 2) {
                    code.emitPushInt(1);
                }
                arg0.compile(comp, wtarget);
                code.emitPushInt(1);
                code.emitAnd();
                if (op == 2) {
                    code.emitSub(Type.intType);
                }
            }
            else {
                arg0.compile(comp, Target.pushObject);
                final String mname = (op == 2) ? "isEven" : "isOdd";
                final Method m = ClassType.make("gnu.kawa.functions.NumberPredicate").getDeclaredMethod(mname, 1);
                code.emitInvokeStatic(m);
            }
            target.compileFromStack(comp, Type.booleanType);
            return true;
        }
        return false;
    }
    
    public static Expression validateApplyCallCC(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final LambdaExp lexp = canInlineCallCC(exp);
        if (lexp != null) {
            lexp.setInlineOnly(exp, visitor.getCurrentLambda());
            final Declaration contDecl = lexp.firstDecl();
            if (!contDecl.getFlag(8192L)) {
                contDecl.setType(CompileMisc.typeContinuation);
            }
            contDecl.setFlag(1099511627776L);
            LambdaExp.maybeSetReturnType(lexp, required);
        }
        exp.visitArgs(visitor);
        return exp;
    }
    
    public static void compileCallCC(final ApplyExp exp, final Compilation comp, final Target target, final Procedure proc) {
        final LambdaExp lambda = canInlineCallCC(exp);
        if (lambda == null) {
            ApplyExp.compile(exp, comp, target);
            return;
        }
        final CodeAttr code = comp.getCode();
        final Declaration param = lambda.firstDecl();
        if (param.isSimple() && !param.getCanRead() && !param.getCanWrite()) {
            param.setCanCall(false);
            final CompileTimeContinuation contProxy = new CompileTimeContinuation();
            final Type rtype = (target instanceof StackTarget) ? target.getType() : null;
            final boolean runFinallyBlocks = ExitThroughFinallyChecker.check(param, lambda.body);
            final ExitableBlock bl = code.startExitableBlock(rtype, runFinallyBlocks);
            contProxy.exitableBlock = bl;
            contProxy.blockTarget = target;
            param.setValue(new QuoteExp(contProxy));
            new ApplyExp(lambda, new Expression[] { QuoteExp.nullExp }).compile(comp, target);
            code.endExitableBlock();
            return;
        }
        final Scope sc = code.pushScope();
        final Variable contVar = sc.addVariable(code, CompileMisc.typeContinuation, null);
        final Declaration contDecl = new Declaration(contVar);
        code.emitNew(CompileMisc.typeContinuation);
        code.emitDup(CompileMisc.typeContinuation);
        comp.loadCallContext();
        code.emitInvokeSpecial(CompileMisc.typeContinuation.getDeclaredMethod("<init>", 1));
        code.emitStore(contVar);
        code.emitTryStart(false, (target instanceof IgnoreTarget || target instanceof ConsumerTarget) ? null : target.getType().getRawType());
        final ApplyExp app = new ApplyExp(lambda, new Expression[] { new ReferenceExp(contDecl) });
        app.compile(comp, target);
        if (code.reachableHere()) {
            code.emitLoad(contVar);
            code.emitPushInt(1);
            code.emitPutField(CompileMisc.typeContinuation.getField("invoked"));
        }
        code.emitCatchStart((ClassType)null);
        code.emitLoad(contVar);
        if (target instanceof ConsumerTarget) {
            comp.loadCallContext();
            final Method handleMethod = CompileMisc.typeContinuation.getDeclaredMethod("handleException$X", 3);
            code.emitInvokeStatic(handleMethod);
        }
        else {
            final Method handleMethod = CompileMisc.typeContinuation.getDeclaredMethod("handleException", 2);
            code.emitInvokeStatic(handleMethod);
            target.compileFromStack(comp, Type.objectType);
        }
        code.emitCatchEnd();
        code.emitTryCatchEnd();
        code.popScope();
    }
    
    private static LambdaExp canInlineCallCC(final ApplyExp exp) {
        final Expression[] args = exp.getArgs();
        final Expression arg0;
        if (args.length == 1 && (arg0 = args[0]) instanceof LambdaExp && !Compilation.enableANF) {
            final LambdaExp lexp = (LambdaExp)arg0;
            if (lexp.min_args == 1 && lexp.max_args == 1 && !lexp.firstDecl().getCanWrite()) {
                return lexp;
            }
        }
        return null;
    }
    
    public static Expression validateApplyWithExceptionHandler(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final Expression[] args = exp.getArgs();
        final Expression handler = visitor.visit(args[0], (Type)null);
        args[0] = handler;
        Expression thunk = args[1];
        if (thunk instanceof LambdaExp) {
            final LambdaExp lthunk = (LambdaExp)thunk;
            if (lthunk.min_args == 0 && lthunk.max_args == 0) {
                LambdaExp.maybeSetReturnType(lthunk, required);
                thunk = visitor.visit(lthunk, required);
                args[1] = thunk;
                final Compilation comp = visitor.getCompilation();
                comp.letStart();
                final ClassType handlerLinkType = ClassType.make("kawa.lib.HandlerLink");
                final Method pushMethod = handlerLinkType.getDeclaredMethod("push", 1);
                final Method popMethod = handlerLinkType.getDeclaredMethod("pop", 0);
                final Declaration linkDecl = comp.letVariable(null, handlerLinkType, new ApplyExp(pushMethod, new Expression[] { handler }));
                comp.letEnter();
                final Type bodyType = lthunk.getReturnType();
                final Expression bodyCall = new ApplyExp(thunk, new Expression[0]);
                final Expression popHandler = new ApplyExp(popMethod, new Expression[] { new ReferenceExp(linkDecl) });
                Expression tryClause;
                if (bodyType.isVoid()) {
                    tryClause = new BeginExp(bodyCall, popHandler);
                }
                else {
                    comp.letStart();
                    final Declaration resultDecl = comp.letVariable(null, bodyType, bodyCall);
                    comp.letEnter();
                    tryClause = comp.letDone(new BeginExp(popHandler, new ReferenceExp(resultDecl)));
                }
                final TryExp texp = new TryExp(tryClause, null);
                final Declaration exDecl = new Declaration(null, Type.javalangThrowableType);
                final Expression doHandle = new ApplyExp(handlerLinkType.getDeclaredMethod("handle", 1), new Expression[] { new ReferenceExp(linkDecl), new ReferenceExp(exDecl) });
                texp.addCatchClause(exDecl, new ApplyExp(Throw.primitiveThrow, new Expression[] { doHandle }));
                return visitor.visit(comp.letDone(texp), required);
            }
        }
        thunk = visitor.visit(thunk, (Type)null);
        args[1] = thunk;
        return exp;
    }
    
    public static Expression validateApplyMakeDynamic(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        if (exp.isSimple(1, 1)) {
            final Expression[] args = exp.getArgs();
            args[0] = visitor.visit(args[0], (Type)null);
            exp.setType(LangObjType.dynamicType);
        }
        else {
            exp.visitArgs(visitor);
        }
        return exp;
    }
    
    public static boolean compileMakeDynamic(final ApplyExp exp, final Compilation comp, final Target target, final Procedure procedure) {
        if (!exp.isSimple()) {
            return false;
        }
        exp.getArg(0).compile(comp, target);
        return true;
    }
    
    public static Expression validateApplyMakePromise(ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final Expression[] args = exp.getArgs();
        if (args.length == 1 && args[0] instanceof LambdaExp) {
            final boolean forceValueIfPromise = proc == MakePromise.makeLazy;
            Type bodyRequired;
            if (required instanceof LazyType) {
                final Type valueType = ((LazyType)required).getValueType();
                bodyRequired = (forceValueIfPromise ? LazyType.getLazyType(valueType) : valueType);
            }
            else {
                bodyRequired = null;
            }
            final LambdaExp lexp = (LambdaExp)args[0];
            lexp.body = visitor.visit(lexp.body, bodyRequired);
            args[0] = visitor.visit(lexp, (Type)null);
            Type rtype = lexp.getReturnType();
            if (forceValueIfPromise) {
                rtype = ((rtype instanceof LazyType) ? ((LazyType)rtype).getValueType() : Type.objectType);
            }
            final Type type = LazyType.getLazyType(rtype);
            final String mname = forceValueIfPromise ? "makePromiseLazy" : "makePromise";
            final Method meth = ClassType.make("gnu.kawa.functions.MakePromise").getDeclaredMethod(mname, 1);
            final PrimProcedure mproc = new PrimProcedure(meth);
            mproc.setReturnType(type);
            exp = new ApplyExp(mproc, args);
            exp.setType(type);
        }
        else {
            exp.visitArgs(visitor);
        }
        return exp;
    }
    
    static {
        typeContinuation = ClassType.make("kawa.lang.Continuation");
    }
    
    static class ExitThroughFinallyChecker extends ExpVisitor<Expression, TryExp>
    {
        Declaration decl;
        
        public static boolean check(final Declaration decl, final Expression body) {
            final ExitThroughFinallyChecker visitor = new ExitThroughFinallyChecker();
            visitor.decl = decl;
            ((ExpVisitor<Object, TryExp>)visitor).visit(body, null);
            return visitor.exitValue != null;
        }
        
        @Override
        protected Expression defaultValue(final Expression r, final TryExp d) {
            return r;
        }
        
        @Override
        protected Expression visitReferenceExp(final ReferenceExp exp, final TryExp currentTry) {
            if (this.decl == exp.getBinding() && currentTry != null) {
                this.exitValue = Boolean.TRUE;
            }
            return exp;
        }
        
        @Override
        protected Expression visitTryExp(final TryExp exp, final TryExp currentTry) {
            ((ExpVisitor<Object, TryExp>)this).visitExpression(exp, (exp.getFinallyClause() != null) ? exp : currentTry);
            return exp;
        }
    }
    
    static class CompileTimeContinuation extends ProcedureN implements Inlineable
    {
        Target blockTarget;
        ExitableBlock exitableBlock;
        
        @Override
        public Object applyN(final Object[] args) throws Throwable {
            throw new Error("internal error");
        }
        
        @Override
        public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
            final CodeAttr code = comp.getCode();
            final Expression[] args = exp.getArgs();
            final int nargs = args.length;
            final boolean noStack = this.blockTarget instanceof IgnoreTarget || this.blockTarget instanceof ConsumerTarget;
            final Type typeNeeded = noStack ? null : target.getType();
            if (noStack || nargs == 1) {
                for (int i = 0; i < nargs; ++i) {
                    args[i].compileWithPosition(comp, this.blockTarget);
                }
            }
            else {
                final AppendValues app = AppendValues.appendValues;
                app.compile(new ApplyExp(app, args), comp, this.blockTarget);
            }
            this.exitableBlock.exit();
        }
        
        @Override
        public Type getReturnType(final Expression[] args) {
            return Type.neverReturnsType;
        }
    }
}
