/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.AnnotationEntry;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.CanFinishMap;
import gnu.expr.CaseExp;
import gnu.expr.CatchClause;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExpExpVisitor;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.FluidLetExp;
import gnu.expr.IfExp;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.ModuleExp;
import gnu.expr.ObjectExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.expr.TryExp;
import gnu.expr.TypeValue;
import gnu.expr.VarValueTracker;
import gnu.kawa.functions.MakePromise;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.util.IdentityHashTable;
import gnu.lists.EmptyList;
import gnu.lists.PairWithPosition;
import gnu.lists.SimpleVector;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import java.lang.annotation.ElementType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class InlineCalls
extends ExpExpVisitor<Type> {
    public static ThreadLocal<InlineCalls> currentVisitor = new ThreadLocal();
    VarValueTracker valueTracker = new VarValueTracker(this);
    boolean processingAnnotations;
    private static final Class[] inlinerMethodType = new Class[]{ApplyExp.class, InlineCalls.class, Type.class, Procedure.class};

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Expression inlineCalls(Expression exp, Compilation comp) {
        InlineCalls visitor = new InlineCalls(comp);
        InlineCalls saved = currentVisitor.get();
        try {
            currentVisitor.set(visitor);
            Expression expression = visitor.visit(exp, null);
            return expression;
        }
        finally {
            currentVisitor.set(saved);
        }
    }

    public InlineCalls(Compilation comp) {
        this.setContext(comp);
    }

    @Override
    public Expression visit(Expression exp, Type required) {
        Expression exp0 = exp;
        if (!exp.getFlag(1)) {
            exp.setFlag(1);
            exp = ExpVisitor.visit(this, exp, required);
            exp.setFlag(1);
        }
        if (required == ProcedureInCallContext.INSTANCE) {
            required = null;
        }
        if (required instanceof ValueNeededType && exp.getType().isVoid()) {
            if (exp == QuoteExp.voidExp) {
                return QuoteExp.voidObjectExp;
            }
            if (this.comp.warnVoidUsed()) {
                this.comp.error('w', "void-valued expression where value is needed", exp0);
            }
            return new BeginExp(exp, QuoteExp.nullExp);
        }
        return this.checkType(exp, required);
    }

    public Expression checkType(Expression exp, Type required) {
        int cmp;
        Type expType = exp.getType();
        if (expType == Type.toStringType) {
            expType = Type.javalangStringType;
        }
        int n = cmp = required == null || expType == Type.neverReturnsType || required == Type.neverReturnsType ? 1 : required.isCompatibleWithValue(expType);
        if (cmp < 0 || cmp == 0 && required.isInterface() && (exp instanceof QuoteExp || exp instanceof LambdaExp)) {
            gnu.bytecode.Method amethod;
            ClassType reqraw;
            Expression converted;
            if (exp instanceof LambdaExp && (required instanceof ClassType || required instanceof ParameterizedType) && (amethod = (reqraw = required instanceof ParameterizedType ? ((ParameterizedType)required).getRawType() : (ClassType)required).checkSingleAbstractMethod()) != null) {
                if (!ModuleExp.compilerAvailable()) {
                    Class iface;
                    if (!reqraw.isInterface()) {
                        this.comp.error('e', "cannot convert procedure to abstract class " + reqraw.getClass().getName() + " without bytecode compiler");
                    }
                    try {
                        iface = reqraw.getReflectClass();
                    }
                    catch (Exception ex) {
                        iface = null;
                    }
                    if (iface == null) {
                        this.comp.error('e', "cannot find interface " + reqraw.getClass().getName());
                    }
                    gnu.bytecode.Method makeProxy = ClassType.make("gnu.kawa.reflect.ProceduralProxy").getDeclaredMethod("makeProxy", 2);
                    Expression[] args = new Expression[]{QuoteExp.getInstance(iface), exp};
                    return this.visit((Expression)new ApplyExp(makeProxy, args), required);
                }
                LambdaExp lexp = (LambdaExp)exp;
                ObjectExp oexp = new ObjectExp();
                oexp.setLocation(exp);
                oexp.supers = new Expression[]{new QuoteExp(required)};
                oexp.setTypes(this.getCompilation());
                String mname = amethod.getName();
                oexp.addMethod(lexp, mname);
                Declaration mdecl = oexp.addDeclaration(mname, Compilation.typeProcedure);
                oexp.firstChild = lexp;
                oexp.declareParts(this.comp);
                return this.visit((Expression)oexp, required);
            }
            if (required instanceof TypeValue && (converted = ((TypeValue)((Object)required)).convertValue(exp)) != null) {
                return converted;
            }
            Language language = this.comp.getLanguage();
            this.comp.error(this.processingAnnotations() ? (char)'e' : 'w', "type " + language.formatType(expType) + " is incompatible with required type " + language.formatType(required), exp);
            if (required instanceof PrimType) {
                required = ((PrimType)required).boxedType();
            }
            ApplyExp expb = Compilation.makeCoercion(exp, required);
            expb.setType(required);
            expb.setFlag(1);
            return expb;
        }
        return exp;
    }

    private void setCanAccess(LambdaExp exp, Type required) {
        if (required != ProcedureInCallContext.INSTANCE) {
            exp.setCanRead(true);
        }
    }

    @Override
    protected Expression visitApplyExp(ApplyExp exp, Type required) {
        Expression inlined;
        Expression func = exp.func;
        if (func instanceof LambdaExp && (inlined = InlineCalls.inlineCall((LambdaExp)func, exp.args, false)) != null) {
            return this.visit(inlined, required);
        }
        exp.func = func = this.visit(func, InlineCalls.typeForCalledFunction(func));
        return func.validateApply(exp, this, required, null);
    }

    public static Type typeForCalledFunction(Expression exp) {
        return exp instanceof LambdaExp && !(exp instanceof ClassExp) || exp instanceof ReferenceExp ? ProcedureInCallContext.INSTANCE : null;
    }

    public final Expression visitApplyOnly(ApplyExp exp, Type required) {
        return exp.func.validateApply(exp, this, required, null);
    }

    public static Integer checkIntValue(Expression exp) {
        if (exp instanceof QuoteExp) {
            IntNum ivalue;
            QuoteExp qarg = (QuoteExp)exp;
            Object value = qarg.getValue();
            if (!qarg.isExplicitlyTyped() && value instanceof IntNum && (ivalue = (IntNum)value).inIntRange()) {
                return ivalue.intValue();
            }
        }
        return null;
    }

    public static Long checkLongValue(Expression exp) {
        if (exp instanceof QuoteExp) {
            IntNum ivalue;
            QuoteExp qarg = (QuoteExp)exp;
            Object value = qarg.getValue();
            if (!qarg.isExplicitlyTyped() && value instanceof IntNum && (ivalue = (IntNum)value).inLongRange()) {
                return ivalue.longValue();
            }
        }
        return null;
    }

    public QuoteExp fixIntValue(Expression exp) {
        Integer ival = InlineCalls.checkIntValue(exp);
        if (ival != null) {
            return new QuoteExp(ival, this.comp.getLanguage().getTypeFor(Integer.TYPE));
        }
        return null;
    }

    public QuoteExp fixLongValue(Expression exp) {
        Long ival = InlineCalls.checkLongValue(exp);
        if (ival != null) {
            return new QuoteExp(ival, this.comp.getLanguage().getTypeFor(Long.TYPE));
        }
        return null;
    }

    @Override
    protected Expression visitQuoteExp(QuoteExp exp, Type required) {
        Object value = exp.getValue();
        if (exp.getRawType() == null && !exp.isSharedConstant() && value != null) {
            Language language = this.comp.getLanguage();
            Type vtype = language.getTypeFor(value.getClass());
            if (vtype == Type.toStringType) {
                vtype = Type.javalangStringType;
            }
            exp.type = vtype;
            if (!exp.isExplicitlyTyped()) {
                PrimType primRequired = PrimType.unboxedType(required);
                if (primRequired != null) {
                    char sig1 = primRequired.getSignature().charAt(0);
                    if (value instanceof IntNum && primRequired != LangPrimType.characterType && primRequired != LangPrimType.characterOrEofType) {
                        IntNum ivalue = (IntNum)value;
                        Object ival = null;
                        switch (sig1) {
                            case 'B': 
                            case 'I': 
                            case 'J': 
                            case 'S': {
                                ival = LangPrimType.convertIntegerLiteral(ivalue, primRequired, false);
                                break;
                            }
                            case 'F': {
                                ival = Float.valueOf(ivalue.floatValue());
                                break;
                            }
                            case 'D': {
                                ival = ivalue.doubleValue();
                                break;
                            }
                            default: {
                                ivalue = null;
                            }
                        }
                        if (ival != null) {
                            exp = new QuoteExp(ival, required);
                        } else if (ivalue != null) {
                            this.error('w', "integer " + ivalue + " not in range of " + required.getName());
                        }
                    }
                    if (value instanceof DFloNum) {
                        Number dval;
                        DFloNum dvalue = (DFloNum)value;
                        switch (sig1) {
                            case 'F': {
                                dval = Float.valueOf(dvalue.floatValue());
                                break;
                            }
                            case 'D': {
                                dval = dvalue.doubleValue();
                                break;
                            }
                            default: {
                                dval = null;
                            }
                        }
                        if (dval != null) {
                            exp = new QuoteExp(dval, required);
                        } else {
                            this.error('w', "saw float where " + required.getName() + " expected");
                        }
                    }
                    if (value instanceof Char) {
                        if (sig1 == 'C') {
                            int ival = ((Char)value).intValue();
                            if (ival >= 0 && ival <= 65535) {
                                exp = new QuoteExp(Character.valueOf((char)ival), required);
                            } else {
                                this.error('w', "character scalar value " + ival + " not in range of " + required.getName());
                            }
                        } else {
                            exp.setType(LangPrimType.characterType);
                        }
                    }
                } else if (value instanceof IntNum && required != null && "java.math.BigInteger".equals(required.getName())) {
                    exp = new QuoteExp(((IntNum)value).asBigInteger(), required);
                } else if (value instanceof Char) {
                    exp.setType(LangPrimType.characterType);
                }
            }
        }
        return exp;
    }

    @Override
    protected Expression visitReferenceExp(ReferenceExp exp, Type required) {
        Declaration decl = exp.getBinding();
        if (decl != null && !exp.getDontDereference()) {
            Expression dval;
            Type type;
            LambdaExp lval;
            IntNum vals = this.valueTracker.declValueUsage.get(decl);
            if (vals != null && VarValueTracker.maybeUninitialized(vals) && !decl.getFlag(0x4000000000L)) {
                this.comp.error('w', "variable '" + exp.getName() + "' may be uninitialized here", exp);
                decl.setFlag(0x4000000000L);
            }
            if ((lval = decl.getLambdaValue()) != null) {
                this.setCanAccess(lval, required);
                this.valueTracker.checkUninitializedVariables(lval, exp, null);
            }
            if (this.deferableInit(dval = decl.getValue()) && !dval.getFlag(1)) {
                this.visit(dval, required);
            }
            if ((type = decl.getType()) != null && type.isVoid()) {
                return QuoteExp.voidExp;
            }
        }
        if (decl != null && decl.field == null && !decl.getCanWrite() && !exp.getDontDereference()) {
            Expression dval = decl.getValue();
            if (dval instanceof QuoteExp && dval != QuoteExp.undefined_exp) {
                return this.visitQuoteExp(new QuoteExp(((QuoteExp)dval).getValue(), decl.getType()), required);
            }
            if (dval != null && decl.nvalues == 1 && decl.values[0].kind == 4) {
                dval = null;
            }
            if (dval instanceof ReferenceExp && !decl.isAlias()) {
                ReferenceExp rval = (ReferenceExp)dval;
                Declaration rdecl = rval.getBinding();
                Type dtype = decl.getType();
                if (!(rdecl == null || rdecl.getCanWrite() || dtype != null && dtype != Type.objectType && dtype != rdecl.getType())) {
                    return this.visitReferenceExp(new ReferenceExp(rval), required);
                }
            }
            if (dval instanceof ClassExp && this.processingAnnotations()) {
                ClassExp cval = (ClassExp)dval;
                if (cval.compiledType != null) {
                    return new QuoteExp(cval.compiledType, required);
                }
            }
            if (!exp.isProcedureName() && decl.isClassMethod()) {
                this.comp.error('e', "unimplemented: reference to method " + decl.getName() + " as variable");
                this.comp.error('e', decl, "here is the definition of ", "");
            }
        }
        if ((decl = Declaration.followAliases(decl)) != null) {
            if (required != ProcedureInCallContext.INSTANCE) {
                decl.setCanRead(true);
            } else {
                decl.setCanCall(true);
                if (!this.comp.mustCompile) {
                    decl.setCanRead();
                }
            }
            Declaration ctx = exp.contextDecl();
            if (ctx != null) {
                ctx.setCanRead(true);
            }
        }
        return (Expression)super.visitReferenceExp(exp, required);
    }

    @Override
    protected Expression visitIfExp(IfExp exp, Type required) {
        int truth;
        Expression value;
        Declaration decl;
        Expression test = exp.test.visit(this, ValueNeededType.instance);
        if (test instanceof ReferenceExp && (decl = ((ReferenceExp)test).getBinding()) != null && (value = decl.getValue()) instanceof QuoteExp && value != QuoteExp.undefined_exp) {
            test = value;
        }
        exp.test = test;
        VarValueTracker.forkPush(this);
        if (this.exitValue == null) {
            exp.then_clause = this.visit(exp.then_clause, required);
        }
        this.valueTracker.forkNext();
        if (this.exitValue == null && exp.else_clause != null) {
            exp.else_clause = this.visit(exp.else_clause, required);
        }
        VarValueTracker.forkPop(this);
        int n = !(test instanceof QuoteExp) ? -1 : (truth = this.comp.getLanguage().isTrue(((QuoteExp)test).getValue()) ? 1 : 0);
        if (exp.else_clause == null && truth <= 0 && required instanceof ValueNeededType) {
            if (this.comp.warnVoidUsed()) {
                this.comp.error('w', "missing else where value is required", exp);
            }
            if (truth == 0) {
                return QuoteExp.voidObjectExp;
            }
        }
        if (truth >= 0) {
            return exp.select(truth != 0);
        }
        if (test.getType().isVoid()) {
            boolean voidTrue = this.comp.getLanguage().isTrue(Values.empty);
            if (this.comp.warnVoidUsed()) {
                this.comp.error('w', "void-valued condition is always " + (truth != 0));
            }
            return new BeginExp(test, exp.select(voidTrue));
        }
        return exp;
    }

    @Override
    protected Expression visitBeginExp(BeginExp exp, Type required) {
        int last = exp.length - 1;
        for (int i = 0; i <= last; ++i) {
            exp.exps[i] = this.visit(exp.exps[i], i < last ? null : required);
        }
        return exp;
    }

    @Override
    protected Expression visitCaseExp(CaseExp exp, Type required) {
        Expression value;
        int i;
        Object keyValue;
        Declaration decl;
        Expression key = exp.key.visit(this, ValueNeededType.instance);
        if (key instanceof ReferenceExp && (decl = ((ReferenceExp)key).getBinding()) != null && (value = decl.getValue()) instanceof QuoteExp && value != QuoteExp.undefined_exp) {
            key = value;
        }
        exp.key = key;
        if (exp.clauses.length == 0) {
            return new BeginExp(key, this.visit(exp.elseClause.exp, required));
        }
        Expression lastIncomp = null;
        int incomps = 0;
        for (i = 0; i < exp.clauses.length; ++i) {
            for (int j = 0; j < exp.clauses[i].datums.length; ++j) {
                Expression dexp = exp.clauses[i].datums[j];
                Object d = ((QuoteExp)dexp).getValue();
                if (d instanceof SimpleVector || !(d instanceof EmptyList) && d instanceof PairWithPosition) {
                    this.comp.error('w', "List and vectors will never be matched in a case clause", dexp);
                } else if (d instanceof CharSequence) {
                    this.comp.error('w', "a string in a case clause will never match (except another literal)", dexp);
                }
                if (key.getType().isCompatibleWithValue(dexp.getType()) != -1) continue;
                if (incomps < 2) {
                    this.comp.error('w', "datum type incompatible with the key", dexp);
                } else if (incomps == 2) {
                    lastIncomp = dexp;
                }
                ++incomps;
            }
        }
        if (incomps > 2) {
            this.comp.error('w', "there are " + (incomps - 2) + " more datums that are incompatible with the key", lastIncomp);
        }
        VarValueTracker.forkPush(this);
        if (this.exitValue == null) {
            exp.clauses[0].exp = this.visit(exp.clauses[0].exp, required);
            for (i = 1; i < exp.clauses.length; ++i) {
                if (this.exitValue != null) continue;
                this.valueTracker.forkNext();
                exp.clauses[i].exp = this.visit(exp.clauses[i].exp, required);
            }
        }
        if (this.exitValue == null && exp.elseClause != null) {
            this.valueTracker.forkNext();
            exp.elseClause.exp = this.visit(exp.elseClause.exp, required);
        }
        VarValueTracker.forkPop(this);
        boolean isKeyKnown = key instanceof QuoteExp;
        Object object2 = keyValue = isKeyKnown ? ((QuoteExp)key).getValue() : null;
        if (exp.elseClause == null && required instanceof ValueNeededType) {
            boolean missing;
            boolean bl = missing = !isKeyKnown || !exp.searchValue(keyValue);
            if (missing && this.comp.warnVoidUsed()) {
                this.comp.error('w', "missing else where value is required", exp);
            }
            if (isKeyKnown && missing) {
                return QuoteExp.voidObjectExp;
            }
        }
        if (isKeyKnown) {
            Expression e = exp.selectCase(keyValue);
            return e != null ? e : QuoteExp.voidObjectExp;
        }
        if (key.getType().isVoid()) {
            return new BeginExp(key, exp.selectCase(QuoteExp.voidExp.getValue()));
        }
        return exp;
    }

    @Override
    protected Expression visitScopeExp(ScopeExp exp, Type required) {
        exp.visitChildren(this, null);
        this.visitDeclarationTypes(exp);
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (decl.type == null) {
                Expression val = decl.getValue();
                decl.type = Type.objectType;
                decl.setType(val != null && val != QuoteExp.undefined_exp ? val.getType() : Type.objectType);
            }
            this.visitAnnotations(decl);
        }
        return exp;
    }

    protected void visitRemainingDeclaredLambdas(ScopeExp exp) {
        Declaration decl;
        Expression value;
        for (decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            value = decl.getValueRaw();
            if (!(value instanceof LambdaExp) || decl.isModuleLocal()) continue;
            this.visit(value, null);
        }
        for (decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            value = decl.getValueRaw();
            if (!(value instanceof LambdaExp) || value.getFlag(1) || !decl.isModuleLocal() || !this.comp.warnUnused()) continue;
            this.comp.error('w', decl, "no use of ", "");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected Expression visitModuleExp(ModuleExp exp, Type required) {
        LambdaExp saveLambda = this.currentLambda;
        this.currentLambda = exp;
        try {
            super.visitModuleExp(exp, required);
        }
        finally {
            this.currentLambda = saveLambda;
        }
        this.visitRemainingDeclaredLambdas(exp);
        return exp;
    }

    @Override
    protected Expression visitLetExp(LetExp exp, Type required) {
        Declaration decl;
        Expression init;
        if (!(exp instanceof CatchClause) && !(exp instanceof FluidLetExp)) {
            for (decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
                ReferenceExp ref;
                if (exp.body instanceof ReferenceExp && (ref = (ReferenceExp)exp.body).getBinding() == decl && !ref.getDontDereference()) {
                    decl.setFlag(0x8000000000L);
                    ref.setFlag(32);
                }
                if ((init = decl.getInitValue()) == QuoteExp.undefined_exp && decl.getValueRaw() instanceof LambdaExp) {
                    this.valueTracker.noteSet(decl, IntNum.make(-1));
                    continue;
                }
                this.valueTracker.noteUnitialized(decl);
            }
        }
        for (decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            Type dtype;
            boolean typeSpecified;
            init = decl.getInitValue();
            if (decl.nvalues > 0 && decl.values[0].kind == 3 && decl.values[0].base == exp) {
                this.valueTracker.noteSet(decl, IntNum.make(-1));
            }
            Type type = dtype = (typeSpecified = decl.getFlag(8192L)) && init != QuoteExp.undefined_exp ? decl.getType() : null;
            if (!this.deferableInit(init) || decl.getValueRaw() != init) {
                init = this.visit(init, ValueNeededType.make(dtype));
            }
            decl.setInitValue(init);
        }
        if (this.exitValue == null) {
            exp.body = this.visit(exp.body, required);
        }
        this.visitRemainingDeclaredLambdas(exp);
        return exp;
    }

    protected boolean deferableInit(Expression init) {
        Object fun;
        if (init instanceof LambdaExp) {
            return !(init instanceof ClassExp);
        }
        return init instanceof ApplyExp && ((fun = ((ApplyExp)init).getFunctionValue()) == MakePromise.makeDelay || fun == MakePromise.makeLazy);
    }

    @Override
    protected Expression visitFluidLetExp(FluidLetExp exp, Type required) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            decl.setCanRead(true);
            if (decl.base == null) continue;
            decl.base.setCanRead(true);
        }
        return (Expression)super.visitFluidLetExp(exp, required);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected Expression visitLambdaExp(LambdaExp exp, Type required) {
        Declaration firstDecl;
        this.setCanAccess(exp, required);
        if (exp.getCallConvention() == 0) {
            exp.setCallConvention(this.getCompilation());
        }
        if ((firstDecl = exp.firstDecl()) != null && firstDecl.isThisParameter() && !exp.isClassMethod() && firstDecl.type == null) {
            firstDecl.setType(this.comp.mainClass);
        }
        if (exp.getClass() == LambdaExp.class) {
            if (exp.canFinishCondition != CanFinishMap.CAN_FINISH && exp.canFinishCondition != null) {
                exp.setReturnType(Type.neverReturnsType);
            }
            Declaration ldecl = exp.nameDecl;
            boolean unknownCalls = true;
            if (ldecl != null && !exp.isClassMethod() && ldecl.isModuleLocal()) {
                int countApply = 0;
                ApplyExp app = ldecl.firstCall;
                while (app != null) {
                    ++countApply;
                    app = app.nextCall;
                }
                if (countApply == ldecl.numReferences && !Compilation.avoidInline(exp)) {
                    unknownCalls = false;
                    app = ldecl.firstCall;
                    while (app != null) {
                        Expression func = app.getFunction();
                        int nargs = app.getArgCount();
                        Declaration p = firstDecl;
                        if (p != null && p.isThisParameter()) {
                            p = p.nextDecl();
                        }
                        for (int i = 0; p != null && i < exp.min_args; p = p.nextDecl(), ++i) {
                            if (p.hasUnknownValue()) continue;
                            p.noteValueFromApply(app, i);
                        }
                        app = app.nextCall;
                    }
                }
            }
            if (unknownCalls) {
                for (Declaration p = firstDecl; p != null; p = p.nextDecl()) {
                    if (p.isThisParameter()) continue;
                    p.noteValueUnknown();
                }
            }
        }
        LambdaExp saveLambda = this.currentLambda;
        this.currentLambda = exp;
        try {
            this.visitScopeExp((ScopeExp)exp, required);
        }
        finally {
            this.currentLambda = saveLambda;
        }
        if (exp.isClassMethod() && "*init*".equals(exp.getName())) {
            Expression bodyFirst = exp.getBodyFirstExpression();
            ClassType calledInit = exp.checkForInitCall(bodyFirst);
            ClassExp cexp = (ClassExp)exp.getOuter();
            ClassType superClass = cexp.instanceType.getSuperclass();
            if (calledInit != null) {
                if (calledInit != cexp.instanceType && calledInit != superClass) {
                    this.comp.error('e', "call to <init> for not this or super class");
                }
            } else if (superClass != null) {
                cexp.checkDefaultSuperConstructor(superClass, this.comp);
            }
        }
        return exp;
    }

    @Override
    public void visitDefaultArgs(LambdaExp exp, Type required) {
        for (Declaration p = exp.firstDecl(); p != null; p = p.nextDecl()) {
            Expression init = p.getInitValue();
            if (init == null) continue;
            p.setInitValue(this.visitAndUpdate(init, p.getType()));
        }
    }

    @Override
    protected Expression visitClassExp(ClassExp exp, Type required) {
        Expression result = (Expression)super.visitClassExp(exp, required);
        if (!exp.explicitInit && exp.instanceType != null && !exp.instanceType.isInterface()) {
            exp.checkDefaultSuperConstructor(exp.instanceType.getSuperclass(), this.comp);
        }
        return result;
    }

    @Override
    protected Expression visitTryExp(TryExp exp, Type required) {
        if (exp.getCatchClauses() == null && exp.getFinallyClause() == null) {
            return this.visit(exp.try_clause, required);
        }
        VarValueTracker.forkPush(this);
        exp.try_clause = exp.try_clause.visit(this, required);
        for (CatchClause clause = exp.catch_clauses; clause != null; clause = clause.getNext()) {
            this.valueTracker.forkNext();
            clause.visit(this, required);
        }
        if (exp.finally_clause != null) {
            this.valueTracker.forkNext();
        }
        VarValueTracker.forkPop(this);
        if (exp.finally_clause != null) {
            exp.finally_clause = exp.finally_clause.visit(this, null);
        }
        return exp;
    }

    public boolean processingAnnotations() {
        return this.processingAnnotations;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void visitAnnotations(Declaration decl) {
        List<Expression> annotations = decl.annotations;
        if (annotations != null) {
            boolean saveProcessingAnnotations = this.processingAnnotations;
            this.processingAnnotations = true;
            try {
                int num = annotations.size();
                for (int i = 0; i < num; ++i) {
                    Expression before = annotations.get(i);
                    Expression ann = this.visit(before, null);
                    Object aval = ann.valueIfConstant();
                    if (aval instanceof Proxy && (aval = Proxy.getInvocationHandler(aval)) instanceof AnnotationEntry) {
                        AnnotationEntry ae = (AnnotationEntry)aval;
                        if (decl.isClassMethod() && !ae.hasTarget(ElementType.METHOD)) {
                            this.comp.error('e', "annotation " + ae.getAnnotationType().getName() + " allowed on methods", before);
                        }
                        if (decl.isClassField() && !ae.hasTarget(ElementType.FIELD)) {
                            this.comp.error('e', "annotation " + ae.getAnnotationType().getName() + " not allowed on fields", before);
                        }
                        if (decl.getValue() instanceof ClassExp && !ae.hasTarget(ElementType.TYPE) && !ae.hasTarget(ElementType.FIELD)) {
                            this.comp.error('e', "annotation " + ae.getAnnotationType().getName() + " not allowed on classes", before);
                        }
                    }
                    annotations.set(i, ann);
                }
            }
            finally {
                this.processingAnnotations = saveProcessingAnnotations;
            }
        }
    }

    @Override
    protected Expression visitSetExp(SetExp exp, Type required) {
        Declaration ctx;
        Declaration decl = exp.getBinding();
        if (decl != null && decl.values != Declaration.unknownValueValues && exp.valueIndex >= 0) {
            IntNum setterMask = IntNum.make(~exp.valueIndex);
            this.valueTracker.noteSet(decl, setterMask);
        }
        if (decl == null || decl.getValueRaw() != exp.new_value || !this.deferableInit(exp.new_value)) {
            Type dtype = decl == null || decl.isAlias() ? null : decl.type;
            exp.new_value = this.visit(exp.new_value, ValueNeededType.make(dtype));
        }
        if (!exp.isDefining() && decl != null && decl.isClassMethod()) {
            this.comp.error('e', "can't assign to method " + decl.getName(), exp);
        }
        if (decl != null && decl.getFlag(8192L) && CompileReflect.checkKnownClass(decl.getType(), this.comp) < 0) {
            decl.setType(Type.errorType);
        }
        if ((ctx = exp.contextDecl()) != null) {
            ctx.setCanRead(true);
        }
        return exp;
    }

    static Method resolveInliner(Procedure proc, String inliner, Class[] mtype) throws Throwable {
        int colon = inliner.indexOf(58);
        if (colon > 0) {
            String cname = inliner.substring(0, colon);
            String mname = inliner.substring(colon + 1);
            Class<?> clas = Class.forName(cname, true, proc.getClass().getClassLoader());
            return clas.getDeclaredMethod(mname, mtype);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Expression maybeInline(ApplyExp exp, Type required, Procedure proc) {
        try {
            Object inliner;
            Procedure procedure = proc;
            synchronized (procedure) {
                inliner = proc.getProperty(Procedure.validateXApplyKey, null);
                if (inliner == null && exp.firstSpliceArg < 0) {
                    inliner = proc.getProperty(Procedure.validateApplyKey, null);
                }
                if (inliner instanceof CharSequence && (inliner = InlineCalls.resolveInliner(proc, inliner.toString(), inlinerMethodType)) == null) {
                    this.error('e', "inliner property string for " + proc + " is not of the form CLASS:METHOD");
                    return null;
                }
            }
            if (inliner != null) {
                Object[] vargs = new Object[]{exp, this, required, proc};
                if (inliner instanceof Procedure) {
                    return (Expression)((Procedure)inliner).applyN(vargs);
                }
                if (inliner instanceof Method) {
                    return (Expression)((Method)inliner).invoke(null, vargs);
                }
            }
        }
        catch (Error ex) {
            throw ex;
        }
        catch (Throwable ex) {
            if (ex instanceof InvocationTargetException) {
                ex = ((InvocationTargetException)ex).getTargetException();
            }
            this.messages.error('e', "caught exception in inliner for " + proc + " - " + ex, ex);
        }
        return null;
    }

    public static Expression inlineCall(LambdaExp lexp, Expression[] args, boolean makeCopy) {
        if (lexp.keywords != null) {
            return null;
        }
        boolean varArgs = lexp.max_args < 0;
        int fixed = lexp.min_args;
        if (fixed == lexp.max_args && fixed == args.length || varArgs && args.length >= fixed) {
            IdentityHashTable<Declaration, Declaration> mapper;
            Expression[] cargs;
            Declaration prev = null;
            if (makeCopy) {
                mapper = new IdentityHashTable<Declaration, Declaration>();
                cargs = Expression.deepCopy(args, mapper);
                if (cargs == null && args != null) {
                    return null;
                }
            } else {
                mapper = null;
                cargs = args;
            }
            if (varArgs) {
                cargs = new Expression[fixed + 1];
                System.arraycopy(args, 0, cargs, 0, fixed);
                Expression[] xargs = new Expression[args.length - fixed + 1];
                Declaration restArg = lexp.firstDecl();
                int i = fixed;
                while (--i >= 0) {
                    restArg = restArg.nextDecl();
                }
                xargs[0] = QuoteExp.getInstance(restArg.type);
                System.arraycopy(args, fixed, xargs, 1, args.length - fixed);
                cargs[fixed] = new ApplyExp(Invoke.make, xargs);
            }
            int i = 0;
            LetExp let2 = new LetExp();
            Declaration param = lexp.firstDecl();
            while (param != null) {
                Declaration next = param.nextDecl();
                param.setInitValue(cargs[i]);
                if (makeCopy) {
                    Declaration ldecl = let2.addDeclaration(param.symbol, param.type);
                    if (param.typeExp != null) {
                        ldecl.typeExp = Expression.deepCopy(param.typeExp);
                        if (ldecl.typeExp == null) {
                            return null;
                        }
                    }
                    mapper.put(param, ldecl);
                } else {
                    lexp.remove(prev, param);
                    let2.add(prev, param);
                }
                if (!param.getCanWrite()) {
                    param.nvalues = 0;
                    param.values = null;
                }
                param.noteValueFromLet(let2);
                prev = param;
                param = next;
                ++i;
            }
            Expression body = lexp.body;
            if (makeCopy && (body = Expression.deepCopy(body, mapper)) == null && lexp.body != null) {
                return null;
            }
            let2.body = body;
            lexp.body = null;
            lexp.setFlag(1);
            lexp.setInlineOnly(true);
            return let2;
        }
        return null;
    }

    public static class ValueNeededType
    extends ObjectType {
        static final ValueNeededType instance = new ValueNeededType(null);
        Type actualType;

        ValueNeededType(Type actualType) {
            super("value-needed-type:" + actualType);
            this.actualType = actualType;
        }

        public static Type make(Type type) {
            if (type == null) {
                return instance;
            }
            if (type instanceof ValueNeededType || type == Type.objectType) {
                return type;
            }
            return type;
        }

        @Override
        public Type getImplementationType() {
            return this.actualType;
        }

        @Override
        public int compare(Type other) {
            return other.isVoid() ? -1 : 1;
        }
    }

    public static class ProcedureInCallContext
    extends ObjectType {
        public static final ProcedureInCallContext INSTANCE = new ProcedureInCallContext();

        ProcedureInCallContext() {
            super("procedure-in-call-context");
        }

        @Override
        public Type getImplementationType() {
            return Compilation.typeProcedure;
        }

        @Override
        public int compare(Type other) {
            return this.getImplementationType().compare(other.getImplementationType());
        }
    }

    public static class LenientExpectedType
    extends Type {
        Type base;

        public static LenientExpectedType make(Type type) {
            return new LenientExpectedType(type);
        }

        LenientExpectedType(Type type) {
            super(type);
            this.base = type;
        }

        @Override
        public int compare(Type other) {
            return this == other ? 0 : -3;
        }

        @Override
        public Object coerceFromObject(Object obj) {
            return obj;
        }

        @Override
        public int isCompatibleWithValue(Type valueType) {
            if (this.base.getRawType().equals(this.base.getRawType())) {
                return 1;
            }
            return this.base.isCompatibleWithValue(valueType);
        }

        @Override
        public String toString() {
            return "LenientExpectedType[" + this.base + ']';
        }
    }

}

