// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.ObjectType;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.util.IdentityHashTable;
import java.lang.reflect.InvocationTargetException;
import gnu.mapping.Procedure;
import gnu.kawa.reflect.CompileReflect;
import java.util.List;
import java.lang.annotation.ElementType;
import gnu.bytecode.AnnotationEntry;
import java.lang.reflect.Proxy;
import gnu.kawa.functions.MakePromise;
import gnu.lists.PairWithPosition;
import gnu.lists.EmptyList;
import gnu.lists.SimpleVector;
import gnu.mapping.Values;
import java.util.Stack;
import gnu.text.Char;
import gnu.math.DFloNum;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.math.IntNum;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.ClassType;
import gnu.text.SourceLocator;
import gnu.bytecode.Type;

public class InlineCalls extends ExpExpVisitor<Type>
{
    public static ThreadLocal<InlineCalls> currentVisitor;
    VarValueTracker valueTracker;
    boolean processingAnnotations;
    private static final Class[] inlinerMethodType;
    
    public static Expression inlineCalls(final Expression exp, final Compilation comp) {
        final InlineCalls visitor = new InlineCalls(comp);
        final InlineCalls saved = InlineCalls.currentVisitor.get();
        try {
            InlineCalls.currentVisitor.set(visitor);
            return visitor.visit(exp, (Type)null);
        }
        finally {
            InlineCalls.currentVisitor.set(saved);
        }
    }
    
    public InlineCalls(final Compilation comp) {
        this.valueTracker = new VarValueTracker(this);
        this.setContext(comp);
    }
    
    public Expression visit(Expression exp, Type required) {
        final Expression exp2 = exp;
        if (!exp.getFlag(1)) {
            exp.setFlag(1);
            exp = ExpVisitor.visit((ExpVisitor<Expression, Type>)this, exp, required);
            exp.setFlag(1);
        }
        if (required == ProcedureInCallContext.INSTANCE) {
            required = null;
        }
        if (!(required instanceof ValueNeededType) || !exp.getType().isVoid()) {
            return this.checkType(exp, required);
        }
        if (exp == QuoteExp.voidExp) {
            return QuoteExp.voidObjectExp;
        }
        if (this.comp.warnVoidUsed()) {
            this.comp.error('w', "void-valued expression where value is needed", exp2);
        }
        return new BeginExp(exp, QuoteExp.nullExp);
    }
    
    public Expression checkType(final Expression exp, Type required) {
        Type expType = exp.getType();
        if (expType == Type.toStringType) {
            expType = Type.javalangStringType;
        }
        final int cmp = (required == null || expType == Type.neverReturnsType || required == Type.neverReturnsType) ? 1 : required.isCompatibleWithValue(expType);
        if (cmp < 0 || (cmp == 0 && required.isInterface() && (exp instanceof QuoteExp || exp instanceof LambdaExp))) {
            if (exp instanceof LambdaExp && (required instanceof ClassType || required instanceof ParameterizedType)) {
                final ClassType reqraw = (required instanceof ParameterizedType) ? ((ParameterizedType)required).getRawType() : required;
                final Method amethod = reqraw.checkSingleAbstractMethod();
                if (amethod != null) {
                    if (!ModuleExp.compilerAvailable()) {
                        if (!reqraw.isInterface()) {
                            this.comp.error('e', "cannot convert procedure to abstract class " + reqraw.getClass().getName() + " without bytecode compiler");
                        }
                        Class iface;
                        try {
                            iface = reqraw.getReflectClass();
                        }
                        catch (Exception ex) {
                            iface = null;
                        }
                        if (iface == null) {
                            this.comp.error('e', "cannot find interface " + reqraw.getClass().getName());
                        }
                        final Method makeProxy = ClassType.make("gnu.kawa.reflect.ProceduralProxy").getDeclaredMethod("makeProxy", 2);
                        final Expression[] args = { QuoteExp.getInstance(iface), exp };
                        return this.visit(new ApplyExp(makeProxy, args), required);
                    }
                    final LambdaExp lexp = (LambdaExp)exp;
                    final ObjectExp oexp = new ObjectExp();
                    oexp.setLocation(exp);
                    oexp.supers = new Expression[] { new QuoteExp(required) };
                    oexp.setTypes(this.getCompilation());
                    final Object mname = amethod.getName();
                    oexp.addMethod(lexp, mname);
                    final Declaration mdecl = oexp.addDeclaration(mname, Compilation.typeProcedure);
                    oexp.firstChild = lexp;
                    oexp.declareParts(this.comp);
                    return this.visit(oexp, required);
                }
            }
            if (required instanceof TypeValue) {
                final Expression converted = ((TypeValue)required).convertValue(exp);
                if (converted != null) {
                    return converted;
                }
            }
            final Language language = this.comp.getLanguage();
            this.comp.error(this.processingAnnotations() ? 'e' : 'w', "type " + language.formatType(expType) + " is incompatible with required type " + language.formatType(required), exp);
            if (required instanceof PrimType) {
                required = ((PrimType)required).boxedType();
            }
            final ApplyExp expb = Compilation.makeCoercion(exp, required);
            expb.setType(required);
            expb.setFlag(1);
            return expb;
        }
        return exp;
    }
    
    private void setCanAccess(final LambdaExp exp, final Type required) {
        if (required != ProcedureInCallContext.INSTANCE) {
            exp.setCanRead(true);
        }
    }
    
    protected Expression visitApplyExp(final ApplyExp exp, final Type required) {
        Expression func = exp.func;
        if (func instanceof LambdaExp) {
            final Expression inlined = inlineCall((LambdaExp)func, exp.args, false);
            if (inlined != null) {
                return this.visit(inlined, required);
            }
        }
        func = this.visit(func, typeForCalledFunction(func));
        exp.func = func;
        return func.validateApply(exp, this, required, null);
    }
    
    public static Type typeForCalledFunction(final Expression exp) {
        return ((exp instanceof LambdaExp && !(exp instanceof ClassExp)) || exp instanceof ReferenceExp) ? ProcedureInCallContext.INSTANCE : null;
    }
    
    public final Expression visitApplyOnly(final ApplyExp exp, final Type required) {
        return exp.func.validateApply(exp, this, required, null);
    }
    
    public static Integer checkIntValue(final Expression exp) {
        if (exp instanceof QuoteExp) {
            final QuoteExp qarg = (QuoteExp)exp;
            final Object value = qarg.getValue();
            if (!qarg.isExplicitlyTyped() && value instanceof IntNum) {
                final IntNum ivalue = (IntNum)value;
                if (ivalue.inIntRange()) {
                    return ivalue.intValue();
                }
            }
        }
        return null;
    }
    
    public static Long checkLongValue(final Expression exp) {
        if (exp instanceof QuoteExp) {
            final QuoteExp qarg = (QuoteExp)exp;
            final Object value = qarg.getValue();
            if (!qarg.isExplicitlyTyped() && value instanceof IntNum) {
                final IntNum ivalue = (IntNum)value;
                if (ivalue.inLongRange()) {
                    return ivalue.longValue();
                }
            }
        }
        return null;
    }
    
    public QuoteExp fixIntValue(final Expression exp) {
        final Integer ival = checkIntValue(exp);
        if (ival != null) {
            return new QuoteExp(ival, this.comp.getLanguage().getTypeFor(Integer.TYPE));
        }
        return null;
    }
    
    public QuoteExp fixLongValue(final Expression exp) {
        final Long ival = checkLongValue(exp);
        if (ival != null) {
            return new QuoteExp(ival, this.comp.getLanguage().getTypeFor(Long.TYPE));
        }
        return null;
    }
    
    protected Expression visitQuoteExp(QuoteExp exp, final Type required) {
        final Object value = exp.getValue();
        if (exp.getRawType() == null && !exp.isSharedConstant() && value != null) {
            final Language language = this.comp.getLanguage();
            Type vtype = language.getTypeFor(value.getClass());
            if (vtype == Type.toStringType) {
                vtype = Type.javalangStringType;
            }
            exp.type = vtype;
            if (!exp.isExplicitlyTyped()) {
                final Type primRequired;
                if ((primRequired = PrimType.unboxedType(required)) != null) {
                    final char sig1 = primRequired.getSignature().charAt(0);
                    if (value instanceof IntNum && primRequired != LangPrimType.characterType && primRequired != LangPrimType.characterOrEofType) {
                        IntNum ivalue = (IntNum)value;
                        Object ival = null;
                        switch (sig1) {
                            case 'B':
                            case 'I':
                            case 'J':
                            case 'S': {
                                ival = LangPrimType.convertIntegerLiteral(ivalue, (PrimType)primRequired, false);
                                break;
                            }
                            case 'F': {
                                ival = ivalue.floatValue();
                                break;
                            }
                            case 'D': {
                                ival = ivalue.doubleValue();
                                break;
                            }
                            default: {
                                ivalue = null;
                                break;
                            }
                        }
                        if (ival != null) {
                            exp = new QuoteExp(ival, required);
                        }
                        else if (ivalue != null) {
                            this.error('w', "integer " + ivalue + " not in range of " + required.getName());
                        }
                    }
                    if (value instanceof DFloNum) {
                        final DFloNum dvalue = (DFloNum)value;
                        Object dval = null;
                        switch (sig1) {
                            case 'F': {
                                dval = dvalue.floatValue();
                                break;
                            }
                            case 'D': {
                                dval = dvalue.doubleValue();
                                break;
                            }
                            default: {
                                dval = null;
                                break;
                            }
                        }
                        if (dval != null) {
                            exp = new QuoteExp(dval, required);
                        }
                        else {
                            this.error('w', "saw float where " + required.getName() + " expected");
                        }
                    }
                    if (value instanceof Char) {
                        if (sig1 == 'C') {
                            final int ival2 = ((Char)value).intValue();
                            if (ival2 >= 0 && ival2 <= 65535) {
                                exp = new QuoteExp((char)ival2, required);
                            }
                            else {
                                this.error('w', "character scalar value " + ival2 + " not in range of " + required.getName());
                            }
                        }
                        else {
                            exp.setType(LangPrimType.characterType);
                        }
                    }
                }
                else if (value instanceof IntNum && required != null && "java.math.BigInteger".equals(required.getName())) {
                    exp = new QuoteExp(((IntNum)value).asBigInteger(), required);
                }
                else if (value instanceof Char) {
                    exp.setType(LangPrimType.characterType);
                }
            }
        }
        return exp;
    }
    
    protected Expression visitReferenceExp(final ReferenceExp exp, final Type required) {
        Declaration decl = exp.getBinding();
        if (decl != null && !exp.getDontDereference()) {
            final IntNum vals = this.valueTracker.declValueUsage.get(decl);
            if (vals != null && VarValueTracker.maybeUninitialized(vals) && !decl.getFlag(274877906944L)) {
                this.comp.error('w', "variable '" + exp.getName() + "' may be uninitialized here", exp);
                decl.setFlag(274877906944L);
            }
            final LambdaExp lval = decl.getLambdaValue();
            if (lval != null) {
                this.setCanAccess(lval, required);
                this.valueTracker.checkUninitializedVariables(lval, exp, null);
            }
            final Expression dval = decl.getValue();
            if (this.deferableInit(dval) && !dval.getFlag(1)) {
                this.visit(dval, required);
            }
            final Type type = decl.getType();
            if (type != null && type.isVoid()) {
                return QuoteExp.voidExp;
            }
        }
        if (decl != null && decl.field == null && !decl.getCanWrite() && !exp.getDontDereference()) {
            Expression dval2 = decl.getValue();
            if (dval2 instanceof QuoteExp && dval2 != QuoteExp.undefined_exp) {
                return this.visitQuoteExp(new QuoteExp(((QuoteExp)dval2).getValue(), decl.getType()), required);
            }
            if (dval2 != null && decl.nvalues == 1 && decl.values[0].kind == 4) {
                dval2 = null;
            }
            if (dval2 instanceof ReferenceExp && !decl.isAlias()) {
                final ReferenceExp rval = (ReferenceExp)dval2;
                final Declaration rdecl = rval.getBinding();
                final Type dtype = decl.getType();
                if (rdecl != null && !rdecl.getCanWrite() && (dtype == null || dtype == Type.objectType || dtype == rdecl.getType())) {
                    return this.visitReferenceExp(new ReferenceExp(rval), required);
                }
            }
            if (dval2 instanceof ClassExp && this.processingAnnotations()) {
                final ClassExp cval = (ClassExp)dval2;
                if (cval.compiledType != null) {
                    return new QuoteExp(cval.compiledType, required);
                }
            }
            if (!exp.isProcedureName() && decl.isClassMethod()) {
                this.comp.error('e', "unimplemented: reference to method " + decl.getName() + " as variable");
                this.comp.error('e', decl, "here is the definition of ", "");
            }
        }
        decl = Declaration.followAliases(decl);
        if (decl != null) {
            if (required != ProcedureInCallContext.INSTANCE) {
                decl.setCanRead(true);
            }
            else {
                decl.setCanCall(true);
                if (!this.comp.mustCompile) {
                    decl.setCanRead();
                }
            }
            final Declaration ctx = exp.contextDecl();
            if (ctx != null) {
                ctx.setCanRead(true);
            }
        }
        return super.visitReferenceExp(exp, (D)required);
    }
    
    protected Expression visitIfExp(final IfExp exp, final Type required) {
        Expression test = exp.test.visit((ExpVisitor<Expression, ValueNeededType>)this, ValueNeededType.instance);
        if (test instanceof ReferenceExp) {
            final Declaration decl = ((ReferenceExp)test).getBinding();
            if (decl != null) {
                final Expression value = decl.getValue();
                if (value instanceof QuoteExp && value != QuoteExp.undefined_exp) {
                    test = value;
                }
            }
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
        final int truth = (test instanceof QuoteExp) ? (this.comp.getLanguage().isTrue(((QuoteExp)test).getValue()) ? 1 : 0) : -1;
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
            final boolean voidTrue = this.comp.getLanguage().isTrue(Values.empty);
            if (this.comp.warnVoidUsed()) {
                this.comp.error('w', "void-valued condition is always " + (truth != 0));
            }
            return new BeginExp(test, exp.select(voidTrue));
        }
        return exp;
    }
    
    protected Expression visitBeginExp(final BeginExp exp, final Type required) {
        for (int last = exp.length - 1, i = 0; i <= last; ++i) {
            exp.exps[i] = this.visit(exp.exps[i], (i < last) ? null : required);
        }
        return exp;
    }
    
    protected Expression visitCaseExp(final CaseExp exp, final Type required) {
        Expression key = exp.key.visit((ExpVisitor<Expression, ValueNeededType>)this, ValueNeededType.instance);
        if (key instanceof ReferenceExp) {
            final Declaration decl = ((ReferenceExp)key).getBinding();
            if (decl != null) {
                final Expression value = decl.getValue();
                if (value instanceof QuoteExp && value != QuoteExp.undefined_exp) {
                    key = value;
                }
            }
        }
        exp.key = key;
        if (exp.clauses.length == 0) {
            return new BeginExp(key, this.visit(exp.elseClause.exp, required));
        }
        Expression lastIncomp = null;
        int incomps = 0;
        for (int i = 0; i < exp.clauses.length; ++i) {
            for (int j = 0; j < exp.clauses[i].datums.length; ++j) {
                final Expression dexp = exp.clauses[i].datums[j];
                final Object d = ((QuoteExp)dexp).getValue();
                if (d instanceof SimpleVector || (!(d instanceof EmptyList) && d instanceof PairWithPosition)) {
                    this.comp.error('w', "List and vectors will never be matched in a case clause", dexp);
                }
                else if (d instanceof CharSequence) {
                    this.comp.error('w', "a string in a case clause will never match (except another literal)", dexp);
                }
                if (key.getType().isCompatibleWithValue(dexp.getType()) == -1) {
                    if (incomps < 2) {
                        this.comp.error('w', "datum type incompatible with the key", dexp);
                    }
                    else if (incomps == 2) {
                        lastIncomp = dexp;
                    }
                    ++incomps;
                }
            }
        }
        if (incomps > 2) {
            this.comp.error('w', "there are " + (incomps - 2) + " more datums that are incompatible with the key", lastIncomp);
        }
        VarValueTracker.forkPush(this);
        if (this.exitValue == null) {
            exp.clauses[0].exp = this.visit(exp.clauses[0].exp, required);
            for (int i = 1; i < exp.clauses.length; ++i) {
                if (this.exitValue == null) {
                    this.valueTracker.forkNext();
                    exp.clauses[i].exp = this.visit(exp.clauses[i].exp, required);
                }
            }
        }
        if (this.exitValue == null && exp.elseClause != null) {
            this.valueTracker.forkNext();
            exp.elseClause.exp = this.visit(exp.elseClause.exp, required);
        }
        VarValueTracker.forkPop(this);
        final boolean isKeyKnown = key instanceof QuoteExp;
        final Object keyValue = isKeyKnown ? ((QuoteExp)key).getValue() : null;
        if (exp.elseClause == null && required instanceof ValueNeededType) {
            final boolean missing = !isKeyKnown || !exp.searchValue(keyValue);
            if (missing && this.comp.warnVoidUsed()) {
                this.comp.error('w', "missing else where value is required", exp);
            }
            if (isKeyKnown && missing) {
                return QuoteExp.voidObjectExp;
            }
        }
        if (isKeyKnown) {
            final Expression e = exp.selectCase(keyValue);
            return (e != null) ? e : QuoteExp.voidObjectExp;
        }
        if (key.getType().isVoid()) {
            return new BeginExp(key, exp.selectCase(QuoteExp.voidExp.getValue()));
        }
        return exp;
    }
    
    protected Expression visitScopeExp(final ScopeExp exp, final Type required) {
        exp.visitChildren((ExpVisitor<Object, Object>)this, null);
        this.visitDeclarationTypes(exp);
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (decl.type == null) {
                final Expression val = decl.getValue();
                decl.type = Type.objectType;
                decl.setType((val != null && val != QuoteExp.undefined_exp) ? val.getType() : Type.objectType);
            }
            this.visitAnnotations(decl);
        }
        return exp;
    }
    
    protected void visitRemainingDeclaredLambdas(final ScopeExp exp) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            final Expression value = decl.getValueRaw();
            if (value instanceof LambdaExp && !decl.isModuleLocal()) {
                this.visit(value, (Type)null);
            }
        }
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            final Expression value = decl.getValueRaw();
            if (value instanceof LambdaExp && !value.getFlag(1) && decl.isModuleLocal() && this.comp.warnUnused()) {
                this.comp.error('w', decl, "no use of ", "");
            }
        }
    }
    
    protected Expression visitModuleExp(final ModuleExp exp, final Type required) {
        final LambdaExp saveLambda = this.currentLambda;
        this.currentLambda = exp;
        try {
            super.visitModuleExp(exp, (D)required);
        }
        finally {
            this.currentLambda = saveLambda;
        }
        this.visitRemainingDeclaredLambdas(exp);
        return exp;
    }
    
    protected Expression visitLetExp(final LetExp exp, final Type required) {
        if (!(exp instanceof CatchClause) && !(exp instanceof FluidLetExp)) {
            for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
                if (exp.body instanceof ReferenceExp) {
                    final ReferenceExp ref = (ReferenceExp)exp.body;
                    if (ref.getBinding() == decl && !ref.getDontDereference()) {
                        decl.setFlag(549755813888L);
                        ref.setFlag(32);
                    }
                }
                final Expression init = decl.getInitValue();
                if (init == QuoteExp.undefined_exp && decl.getValueRaw() instanceof LambdaExp) {
                    this.valueTracker.noteSet(decl, IntNum.make(-1));
                }
                else {
                    this.valueTracker.noteUnitialized(decl);
                }
            }
        }
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            Expression init = decl.getInitValue();
            if (decl.nvalues > 0 && decl.values[0].kind == 3 && decl.values[0].base == exp) {
                this.valueTracker.noteSet(decl, IntNum.make(-1));
            }
            final boolean typeSpecified = decl.getFlag(8192L);
            final Type dtype = (typeSpecified && init != QuoteExp.undefined_exp) ? decl.getType() : null;
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
    
    protected boolean deferableInit(final Expression init) {
        if (init instanceof LambdaExp) {
            return !(init instanceof ClassExp);
        }
        if (init instanceof ApplyExp) {
            final Object fun = ((ApplyExp)init).getFunctionValue();
            if (fun == MakePromise.makeDelay || fun == MakePromise.makeLazy) {
                return true;
            }
        }
        return false;
    }
    
    protected Expression visitFluidLetExp(final FluidLetExp exp, final Type required) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            decl.setCanRead(true);
            if (decl.base != null) {
                decl.base.setCanRead(true);
            }
        }
        return super.visitFluidLetExp(exp, (D)required);
    }
    
    protected Expression visitLambdaExp(final LambdaExp exp, final Type required) {
        this.setCanAccess(exp, required);
        if (exp.getCallConvention() == 0) {
            exp.setCallConvention(this.getCompilation());
        }
        final Declaration firstDecl = exp.firstDecl();
        if (firstDecl != null && firstDecl.isThisParameter() && !exp.isClassMethod() && firstDecl.type == null) {
            firstDecl.setType(this.comp.mainClass);
        }
        if (exp.getClass() == LambdaExp.class) {
            if (exp.canFinishCondition != CanFinishMap.CAN_FINISH && exp.canFinishCondition != null) {
                exp.setReturnType(Type.neverReturnsType);
            }
            final Declaration ldecl = exp.nameDecl;
            boolean unknownCalls = true;
            if (ldecl != null && !exp.isClassMethod() && ldecl.isModuleLocal()) {
                int countApply = 0;
                for (ApplyExp app = ldecl.firstCall; app != null; app = app.nextCall) {
                    ++countApply;
                }
                if (countApply == ldecl.numReferences && !Compilation.avoidInline(exp)) {
                    unknownCalls = false;
                    for (ApplyExp app = ldecl.firstCall; app != null; app = app.nextCall) {
                        final Expression func = app.getFunction();
                        final int nargs = app.getArgCount();
                        Declaration p = firstDecl;
                        if (p != null && p.isThisParameter()) {
                            p = p.nextDecl();
                        }
                        for (int i = 0; p != null && i < exp.min_args; p = p.nextDecl(), ++i) {
                            if (!p.hasUnknownValue()) {
                                p.noteValueFromApply(app, i);
                            }
                        }
                    }
                }
            }
            if (unknownCalls) {
                for (Declaration p2 = firstDecl; p2 != null; p2 = p2.nextDecl()) {
                    if (!p2.isThisParameter()) {
                        p2.noteValueUnknown();
                    }
                }
            }
        }
        final LambdaExp saveLambda = this.currentLambda;
        this.currentLambda = exp;
        try {
            this.visitScopeExp(exp, required);
        }
        finally {
            this.currentLambda = saveLambda;
        }
        if (exp.isClassMethod() && "*init*".equals(exp.getName())) {
            final Expression bodyFirst = exp.getBodyFirstExpression();
            final ClassType calledInit = exp.checkForInitCall(bodyFirst);
            final ClassExp cexp = (ClassExp)exp.getOuter();
            final ClassType superClass = cexp.instanceType.getSuperclass();
            if (calledInit != null) {
                if (calledInit != cexp.instanceType && calledInit != superClass) {
                    this.comp.error('e', "call to <init> for not this or super class");
                }
            }
            else if (superClass != null) {
                cexp.checkDefaultSuperConstructor(superClass, this.comp);
            }
        }
        return exp;
    }
    
    public void visitDefaultArgs(final LambdaExp exp, final Type required) {
        for (Declaration p = exp.firstDecl(); p != null; p = p.nextDecl()) {
            final Expression init = p.getInitValue();
            if (init != null) {
                p.setInitValue(((ExpVisitor<R, D>)this).visitAndUpdate(init, (D)p.getType()));
            }
        }
    }
    
    protected Expression visitClassExp(final ClassExp exp, final Type required) {
        final Expression result = super.visitClassExp(exp, (D)required);
        if (!exp.explicitInit && exp.instanceType != null && !exp.instanceType.isInterface()) {
            exp.checkDefaultSuperConstructor(exp.instanceType.getSuperclass(), this.comp);
        }
        return result;
    }
    
    protected Expression visitTryExp(final TryExp exp, final Type required) {
        if (exp.getCatchClauses() == null && exp.getFinallyClause() == null) {
            return this.visit(exp.try_clause, required);
        }
        VarValueTracker.forkPush(this);
        exp.try_clause = exp.try_clause.visit((ExpVisitor<Expression, Type>)this, required);
        for (CatchClause clause = exp.catch_clauses; clause != null; clause = clause.getNext()) {
            this.valueTracker.forkNext();
            clause.visit((ExpVisitor<Object, Type>)this, required);
        }
        if (exp.finally_clause != null) {
            this.valueTracker.forkNext();
        }
        VarValueTracker.forkPop(this);
        if (exp.finally_clause != null) {
            exp.finally_clause = exp.finally_clause.visit((ExpVisitor<Expression, Object>)this, null);
        }
        return exp;
    }
    
    public boolean processingAnnotations() {
        return this.processingAnnotations;
    }
    
    protected void visitAnnotations(final Declaration decl) {
        final List<Expression> annotations = decl.annotations;
        if (annotations != null) {
            final boolean saveProcessingAnnotations = this.processingAnnotations;
            this.processingAnnotations = true;
            try {
                for (int num = annotations.size(), i = 0; i < num; ++i) {
                    final Expression before = annotations.get(i);
                    final Expression ann = this.visit(before, (Type)null);
                    Object aval = ann.valueIfConstant();
                    if (aval instanceof Proxy && (aval = Proxy.getInvocationHandler(aval)) instanceof AnnotationEntry) {
                        final AnnotationEntry ae = (AnnotationEntry)aval;
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
    
    protected Expression visitSetExp(final SetExp exp, final Type required) {
        final Declaration decl = exp.getBinding();
        if (decl != null && decl.values != Declaration.unknownValueValues && exp.valueIndex >= 0) {
            final IntNum setterMask = IntNum.make(~exp.valueIndex);
            this.valueTracker.noteSet(decl, setterMask);
        }
        if (decl == null || decl.getValueRaw() != exp.new_value || !this.deferableInit(exp.new_value)) {
            final Type dtype = (decl == null || decl.isAlias()) ? null : decl.type;
            exp.new_value = this.visit(exp.new_value, ValueNeededType.make(dtype));
        }
        if (!exp.isDefining() && decl != null && decl.isClassMethod()) {
            this.comp.error('e', "can't assign to method " + decl.getName(), exp);
        }
        if (decl != null && decl.getFlag(8192L) && CompileReflect.checkKnownClass(decl.getType(), this.comp) < 0) {
            decl.setType(Type.errorType);
        }
        final Declaration ctx = exp.contextDecl();
        if (ctx != null) {
            ctx.setCanRead(true);
        }
        return exp;
    }
    
    static java.lang.reflect.Method resolveInliner(final Procedure proc, final String inliner, final Class[] mtype) throws Throwable {
        final int colon = inliner.indexOf(58);
        if (colon > 0) {
            final String cname = inliner.substring(0, colon);
            final String mname = inliner.substring(colon + 1);
            final Class clas = Class.forName(cname, true, proc.getClass().getClassLoader());
            return clas.getDeclaredMethod(mname, (Class[])mtype);
        }
        return null;
    }
    
    public Expression maybeInline(final ApplyExp exp, final Type required, final Procedure proc) {
        try {
            Object inliner;
            synchronized (proc) {
                inliner = proc.getProperty(Procedure.validateXApplyKey, null);
                if (inliner == null && exp.firstSpliceArg < 0) {
                    inliner = proc.getProperty(Procedure.validateApplyKey, null);
                }
                if (inliner instanceof CharSequence) {
                    inliner = resolveInliner(proc, inliner.toString(), InlineCalls.inlinerMethodType);
                    if (inliner == null) {
                        this.error('e', "inliner property string for " + proc + " is not of the form CLASS:METHOD");
                        return null;
                    }
                }
            }
            if (inliner != null) {
                final Object[] vargs = { exp, this, required, proc };
                if (inliner instanceof Procedure) {
                    return (Expression)((Procedure)inliner).applyN(vargs);
                }
                if (inliner instanceof java.lang.reflect.Method) {
                    return (Expression)((java.lang.reflect.Method)inliner).invoke(null, vargs);
                }
            }
        }
        catch (Error ex) {
            throw ex;
        }
        catch (Throwable ex2) {
            if (ex2 instanceof InvocationTargetException) {
                ex2 = ((InvocationTargetException)ex2).getTargetException();
            }
            this.messages.error('e', "caught exception in inliner for " + proc + " - " + ex2, ex2);
        }
        return null;
    }
    
    public static Expression inlineCall(final LambdaExp lexp, final Expression[] args, final boolean makeCopy) {
        if (lexp.keywords != null) {
            return null;
        }
        final boolean varArgs = lexp.max_args < 0;
        final int fixed = lexp.min_args;
        if ((fixed == lexp.max_args && fixed == args.length) || (varArgs && args.length >= fixed)) {
            Declaration prev = null;
            IdentityHashTable mapper;
            Expression[] cargs;
            if (makeCopy) {
                mapper = new IdentityHashTable();
                cargs = Expression.deepCopy(args, mapper);
                if (cargs == null && args != null) {
                    return null;
                }
            }
            else {
                mapper = null;
                cargs = args;
            }
            if (varArgs) {
                cargs = new Expression[fixed + 1];
                System.arraycopy(args, 0, cargs, 0, fixed);
                final Expression[] xargs = new Expression[args.length - fixed + 1];
                Declaration restArg = lexp.firstDecl();
                int i = fixed;
                while (--i >= 0) {
                    restArg = restArg.nextDecl();
                }
                xargs[0] = QuoteExp.getInstance(restArg.type);
                System.arraycopy(args, fixed, xargs, 1, args.length - fixed);
                cargs[fixed] = new ApplyExp(Invoke.make, xargs);
            }
            int j = 0;
            final LetExp let = new LetExp();
            Declaration next;
            for (Declaration param = lexp.firstDecl(); param != null; param = next, ++j) {
                next = param.nextDecl();
                param.setInitValue(cargs[j]);
                if (makeCopy) {
                    final Declaration ldecl = let.addDeclaration(param.symbol, param.type);
                    if (param.typeExp != null) {
                        ldecl.typeExp = Expression.deepCopy(param.typeExp);
                        if (ldecl.typeExp == null) {
                            return null;
                        }
                    }
                    mapper.put(param, ldecl);
                }
                else {
                    lexp.remove(prev, param);
                    let.add(prev, param);
                }
                if (!param.getCanWrite()) {
                    param.nvalues = 0;
                    param.values = null;
                }
                param.noteValueFromLet(let);
                prev = param;
            }
            Expression body = lexp.body;
            if (makeCopy) {
                body = Expression.deepCopy(body, mapper);
                if (body == null && lexp.body != null) {
                    return null;
                }
            }
            let.body = body;
            lexp.body = null;
            lexp.setFlag(1);
            lexp.setInlineOnly(true);
            return let;
        }
        return null;
    }
    
    static {
        InlineCalls.currentVisitor = new ThreadLocal<InlineCalls>();
        inlinerMethodType = new Class[] { ApplyExp.class, InlineCalls.class, Type.class, Procedure.class };
    }
    
    public static class LenientExpectedType extends Type
    {
        Type base;
        
        public static LenientExpectedType make(final Type type) {
            return new LenientExpectedType(type);
        }
        
        LenientExpectedType(final Type type) {
            super(type);
            this.base = type;
        }
        
        @Override
        public int compare(final Type other) {
            return (this == other) ? 0 : -3;
        }
        
        @Override
        public Object coerceFromObject(final Object obj) {
            return obj;
        }
        
        @Override
        public int isCompatibleWithValue(final Type valueType) {
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
    
    public static class ProcedureInCallContext extends ObjectType
    {
        public static final ProcedureInCallContext INSTANCE;
        
        ProcedureInCallContext() {
            super("procedure-in-call-context");
        }
        
        @Override
        public Type getImplementationType() {
            return Compilation.typeProcedure;
        }
        
        @Override
        public int compare(final Type other) {
            return this.getImplementationType().compare(other.getImplementationType());
        }
        
        static {
            INSTANCE = new ProcedureInCallContext();
        }
    }
    
    public static class ValueNeededType extends ObjectType
    {
        static final ValueNeededType instance;
        Type actualType;
        
        ValueNeededType(final Type actualType) {
            super("value-needed-type:" + actualType);
            this.actualType = actualType;
        }
        
        public static Type make(final Type type) {
            if (type == null) {
                return ValueNeededType.instance;
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
        public int compare(final Type other) {
            return other.isVoid() ? -1 : 1;
        }
        
        static {
            instance = new ValueNeededType((Type)null);
        }
    }
}
