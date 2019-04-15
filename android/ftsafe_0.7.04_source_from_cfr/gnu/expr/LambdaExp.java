/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.AnnotationEntry;
import gnu.bytecode.ArrayType;
import gnu.bytecode.AttrContainer;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ExceptionsAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Filter;
import gnu.bytecode.Label;
import gnu.bytecode.LocalVarsAttr;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.RuntimeAnnotationsAttr;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.CanFinishMap;
import gnu.expr.CheckedTarget;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.Initializer;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.Mangling;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.PrimProcedure;
import gnu.expr.ProcInitializer;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.Special;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.io.OutPort;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import gnu.text.SourceLocator;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
import kawa.SourceMethodType;

public class LambdaExp
extends ScopeExp {
    public Expression body;
    public int min_args;
    public int max_args;
    public int opt_args;
    ArrayList<LambdaExp> applyMethods;
    Variable argsArray;
    private Declaration firstArgsArrayArg;
    public Keyword[] keywords;
    Declaration capturedVars;
    ReferenceExp siblingReferences;
    Label startForInlining;
    LinkedList<Object> pendingInlines;
    Variable heapFrame;
    public LambdaExp firstChild;
    public LambdaExp nextSibling;
    static final ApplyExp unknownContinuation = new ApplyExp((Expression)null, (Expression[])null);
    public Expression returnContinuation;
    Set<LambdaExp> tailCallers;
    public LambdaExp inlineHome;
    Expression[] throwsSpecification;
    public Declaration nameDecl;
    public static final String CLOSURE_ENV_NAME = "$closureEnv";
    public Field closureEnvField;
    public Field staticLinkField;
    Variable closureEnv;
    static final int CAN_READ = 2;
    static final int INLINE_ONLY = 4;
    static final int IMPORTS_LEX_VARS = 8;
    static final int NEEDS_STATIC_LINK = 16;
    static final int CANNOT_INLINE = 32;
    static final int CLASS_METHOD = 64;
    static final int METHODS_COMPILED = 128;
    public static final int NO_FIELD = 256;
    static final int DEFAULT_CAPTURES_ARG = 512;
    public static final int SEQUENCE_RESULT = 1024;
    public static final int OVERLOADABLE_FIELD = 2048;
    public static final int ATTEMPT_INLINE = 4096;
    public static final int IN_EXPWALKER = 8192;
    public static final int PASSES_TAILCALLS = 16384;
    public static final int PUBLIC_METHOD = 16384;
    protected static final int NEXT_AVAIL_FLAG = 32768;
    int callConvention;
    CanFinishMap canFinishCondition;
    Set<LambdaExp> canFinishListeners;
    ClassType compiledType = Compilation.typeProcedure;
    int selectorValue;
    Method[] primMethods;
    Method[] primBodyMethods;
    Variable thisVariable;
    static Method searchForKeywordMethod3;
    static Method searchForKeywordMethod4;
    Initializer initChain;
    Procedure thisValue;
    Object[] properties;
    public Type returnType;

    public void capture(Declaration decl) {
        if (decl.isSimple()) {
            if (this.capturedVars == null && !decl.isStatic() && !this.isClassGenerated()) {
                this.heapFrame = new Variable("$heapFrame");
            }
            decl.setSimple(false);
            if (!decl.isPublic()) {
                decl.nextCapturedVar = this.capturedVars;
                this.capturedVars = decl;
            }
        }
    }

    public Declaration addParameter(Object name) {
        ++this.min_args;
        ++this.max_args;
        return super.addDeclaration(name);
    }

    public void setExceptions(Expression[] exceptions2) {
        this.throwsSpecification = exceptions2;
    }

    public final boolean getInlineOnly() {
        return (this.flags & 4) != 0;
    }

    public final void setInlineOnly(boolean inlineOnly) {
        this.setFlag(inlineOnly, 4);
    }

    public final void setInlineOnly(Expression returnContinuation, LambdaExp caller) {
        this.setInlineOnly(true);
        this.returnContinuation = returnContinuation;
        this.inlineHome = caller;
    }

    public final boolean getNeedsClosureEnv() {
        return (this.flags & 24) != 0;
    }

    public final boolean getNeedsStaticLink() {
        return (this.flags & 16) != 0;
    }

    public final void setNeedsStaticLink(boolean needsStaticLink) {
        this.flags = needsStaticLink ? (this.flags |= 16) : (this.flags &= -17);
    }

    public final boolean getImportsLexVars() {
        return (this.flags & 8) != 0;
    }

    public final void setImportsLexVars(boolean importsLexVars) {
        this.flags = importsLexVars ? (this.flags |= 8) : (this.flags &= -9);
    }

    public final void setImportsLexVars() {
        int old = this.flags;
        this.flags |= 8;
        if ((old & 8) == 0 && this.nameDecl != null) {
            this.setCallersNeedStaticLink();
        }
    }

    public final void setNeedsStaticLink() {
        int old = this.flags;
        this.flags |= 16;
        if ((old & 16) == 0 && this.nameDecl != null) {
            this.setCallersNeedStaticLink();
        }
    }

    void setCallersNeedStaticLink() {
        LambdaExp outer = this.nameDecl.getContext().currentLambda();
        ApplyExp app = this.nameDecl.firstCall;
        while (app != null) {
            for (LambdaExp caller = app.context; caller != outer && !(caller instanceof ModuleExp); caller = caller.outerLambda()) {
                caller.setNeedsStaticLink();
            }
            app = app.nextCall;
        }
    }

    public final boolean getCanRead() {
        return (this.flags & 2) != 0;
    }

    public final void setCanRead(boolean read2) {
        this.flags = read2 ? (this.flags |= 2) : (this.flags &= -3);
    }

    public final boolean isClassMethod() {
        return (this.flags & 64) != 0;
    }

    public final void setClassMethod(boolean isMethod) {
        this.flags = isMethod ? (this.flags |= 64) : (this.flags &= -65);
    }

    public final boolean isModuleBody() {
        return this instanceof ModuleExp;
    }

    public boolean isAbstract() {
        return this.body == QuoteExp.abstractExp;
    }

    public boolean isNative() {
        return this.body == QuoteExp.nativeExp;
    }

    public int getCallConvention() {
        return this.callConvention;
    }

    public void setCallConvention(Compilation comp) {
        int defaultConvention;
        this.callConvention = this.isClassMethod() ? 1 : ((defaultConvention = comp.currentCallConvention()) < 2 && this.isModuleBody() ? 2 : (defaultConvention == 0 ? 1 : defaultConvention));
    }

    public boolean usingCallContext() {
        return this.getCallConvention() >= 2;
    }

    void notifyCanFinish() {
        Set<LambdaExp> listeners = this.canFinishListeners;
        if (listeners != null) {
            this.canFinishListeners = null;
            for (LambdaExp f : listeners) {
                f.checkCanFinish();
            }
        }
    }

    void checkCanFinish() {
        CanFinishMap cond = this.canFinishCondition;
        if (cond != null && !this.getFlag(8192) && cond.canFinish()) {
            this.canFinishCondition = CanFinishMap.CAN_FINISH;
            this.notifyCanFinish();
        }
    }

    public final boolean isHandlingTailCalls() {
        return this.isModuleBody() || this.getCallConvention() >= 3 && !this.isClassMethod();
    }

    public final boolean variable_args() {
        return this.max_args < 0;
    }

    protected ClassType getCompiledClassType(Compilation comp) {
        if (this.compiledType == Compilation.typeProcedure) {
            throw new Error("internal error: getCompiledClassType");
        }
        return this.compiledType;
    }

    @Override
    protected Type calculateType() {
        return this.compiledType;
    }

    public ClassType getClassType() {
        return this.compiledType;
    }

    public void setType(ClassType type) {
        this.compiledType = type;
        this.type = type;
    }

    public int incomingArgs() {
        return this.min_args == this.max_args && this.max_args <= 4 && this.max_args > 0 ? this.max_args : 1;
    }

    int getSelectorValue(Compilation comp) {
        int s = this.selectorValue;
        if (s == 0) {
            s = comp.maxSelectorValue;
            comp.maxSelectorValue = s + this.primMethods.length;
            this.selectorValue = ++s;
        }
        return s;
    }

    public final Method getMethod(int nonSpliceCount, int spliceCount) {
        if (this.primMethods == null || this.max_args >= 0 && nonSpliceCount > this.max_args) {
            return null;
        }
        int index = nonSpliceCount - this.min_args;
        if (index < 0) {
            return null;
        }
        int length = this.primMethods.length;
        if (spliceCount > 0) {
            return length == 1 ? this.primMethods[0] : null;
        }
        return this.primMethods[index < length ? index : length - 1];
    }

    public final Method getMainMethod() {
        Method[] methods = this.primBodyMethods;
        return methods == null ? null : methods[methods.length - 1];
    }

    public final Type restArgType() {
        if (this.min_args == this.max_args) {
            return null;
        }
        if (this.primMethods == null) {
            throw new Error("internal error - restArgType");
        }
        Method[] methods = this.primMethods;
        if (this.max_args >= 0 && methods.length > this.max_args - this.min_args) {
            return null;
        }
        Method method = methods[methods.length - 1];
        Type[] types = method.getParameterTypes();
        int ilast = types.length - 1;
        if (method.getName().endsWith("$X")) {
            --ilast;
        }
        return types[ilast];
    }

    public LambdaExp outerLambda() {
        return this.getOuter() == null ? null : this.getOuter().currentLambda();
    }

    public LambdaExp outerLambdaOrCaller() {
        return this.getInlineOnly() ? this.inlineHome : this.outerLambda();
    }

    public LambdaExp outerLambdaNotInline() {
        ScopeExp exp = this;
        while ((exp = exp.getOuter()) != null) {
            ScopeExp result;
            if (!(exp instanceof LambdaExp) || ((LambdaExp)(result = exp)).getInlineOnly()) continue;
            return result;
        }
        return null;
    }

    boolean inlinedIn(LambdaExp outer) {
        LambdaExp exp = this;
        while (exp != outer) {
            if (!exp.getInlineOnly()) {
                return false;
            }
            exp = exp.getCaller();
        }
        return true;
    }

    public LambdaExp getCaller() {
        return this.inlineHome;
    }

    public Variable declareThis(ClassType clas) {
        if (this.thisVariable == null) {
            this.thisVariable = new Variable("this");
            this.getVarScope().addVariableAfter(null, this.thisVariable);
            this.thisVariable.setParameter(true);
        }
        if (this.thisVariable.getType() == null) {
            this.thisVariable.setType(clas);
        }
        if (this.decls != null && this.decls.isThisParameter()) {
            this.decls.var = this.thisVariable;
        }
        return this.thisVariable;
    }

    public Variable declareClosureEnv() {
        if (this.closureEnv == null && this.getNeedsClosureEnv()) {
            LambdaExp parent = this.outerLambdaOrCaller();
            if (parent instanceof ClassExp) {
                parent = parent.outerLambda();
            }
            if (this.isClassMethod() && !"*init*".equals(this.getName())) {
                this.closureEnv = this.declareThis(this.compiledType);
            } else if (parent.heapFrame == null && !parent.getNeedsStaticLink() && !(parent instanceof ModuleExp)) {
                this.closureEnv = null;
            } else if (!this.isClassGenerated() && !this.getInlineOnly()) {
                Method primMethod = this.getMainMethod();
                boolean isInit = "*init*".equals(this.getName());
                if (!primMethod.getStaticFlag() && !isInit) {
                    this.closureEnv = this.declareThis(primMethod.getDeclaringClass());
                } else {
                    Type envType = primMethod.getParameterTypes()[0];
                    this.closureEnv = new Variable(CLOSURE_ENV_NAME, envType);
                    Variable prev = isInit ? this.declareThis(primMethod.getDeclaringClass()) : null;
                    this.getVarScope().addVariableAfter(prev, this.closureEnv);
                    this.closureEnv.setParameter(true);
                }
            } else {
                if (this.inlineHome != null) {
                    this.inlineHome.declareClosureEnv();
                }
                this.closureEnv = parent.heapFrame != null && parent == this.outerLambda() ? parent.heapFrame : parent.closureEnv;
            }
        }
        return this.closureEnv;
    }

    public LambdaExp() {
    }

    public LambdaExp(int args) {
        this.min_args = args;
        this.max_args = args;
    }

    public LambdaExp(Expression body) {
        this.body = body;
    }

    public void loadHeapFrame(Compilation comp) {
        ClassType curType;
        LambdaExp curLambda;
        for (curLambda = comp.curLambda; curLambda != this && curLambda.getInlineOnly(); curLambda = curLambda.getCaller()) {
        }
        CodeAttr code = comp.getCode();
        if (curLambda.heapFrame != null && this == curLambda) {
            code.emitLoad(curLambda.heapFrame);
            return;
        }
        if (curLambda.closureEnv != null) {
            code.emitLoad(curLambda.closureEnv);
            curType = (ClassType)curLambda.closureEnv.getType();
        } else {
            code.emitPushThis();
            curType = comp.curClass;
        }
        while (curLambda != this) {
            Field link = curLambda.staticLinkField;
            if (link != null && link.getDeclaringClass() == curType) {
                code.emitGetField(link);
                curType = (ClassType)link.getType();
            }
            curLambda = curLambda.outerLambdaOrCaller();
        }
    }

    Declaration getArg(int i) {
        Declaration var = this.firstDecl();
        do {
            if (var == null) {
                throw new Error("internal error - getArg");
            }
            if (i == 0) {
                return var;
            }
            --i;
            var = var.nextDecl();
        } while (true);
    }

    public void compileEnd(Compilation comp) {
        LambdaExp child;
        CodeAttr code = comp.getCode();
        HashMap<String, Variable> varMap = new HashMap<String, Variable>();
        Label endLabel = new Label(code);
        while (this.pendingInlines != null && !this.pendingInlines.isEmpty()) {
            child = (LambdaExp)this.pendingInlines.remove();
            Target ctarget = (Target)this.pendingInlines.remove();
            if (!child.getInlineOnly() || child.getFlag(128) || child.startForInlining == null) continue;
            if (code.reachableHere()) {
                code.emitGoto(endLabel);
            }
            child.compileAsInlined(comp, ctarget);
        }
        if (endLabel.isUsed()) {
            endLabel.define(code);
        }
        code.getCurrentScope().fixParamNames(varMap);
        this.popScope(code);
        if (!this.getInlineOnly()) {
            if (comp.method.reachableHere() && (this.getCallConvention() < 3 || this.isModuleBody() || this.isClassMethod() || this.isHandlingTailCalls())) {
                code.emitReturn();
            }
            code.getCurrentScope().fixParamNames(varMap);
            code.popScope();
        }
        child = this.firstChild;
        while (child != null) {
            if (!child.getCanRead() && !child.getInlineOnly() && child.getFlag(1)) {
                child.compileAsMethod(comp);
            } else if (child instanceof ClassExp) {
                ((ClassExp)child).compileMembers(comp);
            }
            child = child.nextSibling;
        }
        if (this.heapFrame != null) {
            comp.generateConstructor(this);
        }
    }

    public void generateApplyMethods(Compilation comp) {
        comp.generateMatchMethods(this);
        comp.generateApplyMethodsWithContext(this);
        comp.generateApplyMethodsWithoutContext(this);
    }

    Field allocFieldFor(Compilation comp) {
        if (this.nameDecl != null && this.nameDecl.field != null && this.nameDecl.getValueRaw() == this) {
            return this.nameDecl.field;
        }
        boolean needsClosure = this.getNeedsClosureEnv();
        ClassType frameType = needsClosure ? this.getOwningLambda().getHeapFrameType() : comp.mainClass;
        String name = this.getName();
        String fname = name == null ? "lambda" : Mangling.mangleNameIfNeeded(name);
        int fflags = 16;
        if (this.nameDecl != null && this.nameDecl.context instanceof ModuleExp) {
            boolean external_access = this.nameDecl.needsExternalAccess();
            if (external_access) {
                fname = "$Prvt$" + fname;
            }
            if (this.nameDecl.getFlag(2048L)) {
                fflags |= 8;
                if (!((ModuleExp)this.nameDecl.context).isStatic()) {
                    fflags &= -17;
                }
            }
            if (!this.nameDecl.isPrivate() || external_access || comp.immediate) {
                fflags |= 1;
            }
            if ((this.flags & 2048) != 0) {
                int suffix;
                String fname0 = fname;
                int n = suffix = this.min_args == this.max_args ? this.min_args : 1;
                while (frameType.getDeclaredField(fname = fname0 + '$' + suffix++) != null) {
                }
            }
        } else {
            fname = fname + "$Fn" + ++comp.localFieldIndex;
            if (!needsClosure) {
                fflags |= 8;
            }
        }
        ClassType rtype = Compilation.typeModuleMethod;
        Field field = frameType.addField(fname, rtype, fflags);
        if (this.nameDecl != null) {
            this.nameDecl.field = field;
        }
        return field;
    }

    final void addApplyMethod(Compilation comp, Field field) {
        LambdaExp owner = this;
        if (field != null && field.getStaticFlag()) {
            owner = comp.getModule();
        } else {
            while (!((owner = owner.outerLambda()) instanceof ModuleExp) && owner.heapFrame == null) {
            }
            ClassType frameType = owner.getHeapFrameType();
            if (!frameType.getSuperclass().isSubtype(Compilation.typeModuleBody)) {
                owner = comp.getModule();
            }
        }
        if (owner.applyMethods == null) {
            owner.applyMethods = new ArrayList();
        }
        owner.applyMethods.add(this);
    }

    public Field compileSetField(Compilation comp) {
        if (this.primMethods == null) {
            this.allocMethod(this.outerLambda(), comp);
        }
        Field field = this.allocFieldFor(comp);
        if (comp.usingCPStyle()) {
            this.compile(comp, Type.objectType);
        } else {
            this.compileAsMethod(comp);
            this.addApplyMethod(comp, field);
        }
        if (this.nameDecl != null) {
            this.nameDecl.compileAnnotations(field, ElementType.FIELD);
        }
        return new ProcInitializer((LambdaExp)this, (Compilation)comp, (Field)field).field;
    }

    @Override
    public void compile(Compilation comp, Target target) {
        if (target instanceof IgnoreTarget) {
            return;
        }
        if (this.getInlineOnly()) {
            QuoteExp.nullExp.compile(comp, target);
            return;
        }
        CodeAttr code = comp.getCode();
        LambdaExp outer = this.outerLambda();
        ClassType rtype = Compilation.typeModuleMethod;
        if ((this.flags & 256) != 0 || comp.dumpingInitializers || comp.immediate && outer instanceof ModuleExp && comp.mainClass == comp.moduleClass) {
            if (this.primMethods == null) {
                this.allocMethod(this.outerLambda(), comp);
            }
            this.compileAsMethod(comp);
            this.addApplyMethod(comp, null);
            Variable savedInstance = comp.moduleInstanceVar;
            comp.moduleInstanceVar = null;
            ProcInitializer.emitLoadModuleMethod(this, comp);
            comp.moduleInstanceVar = savedInstance;
        } else {
            Field field = this.compileSetField(comp);
            if (field.getStaticFlag()) {
                code.emitGetStatic(field);
            } else {
                LambdaExp parent = comp.curLambda;
                while (parent.getInlineOnly() && parent.heapFrame == null) {
                    parent = parent.outerLambda();
                }
                Variable frame41 = parent.heapFrame != null ? parent.heapFrame : parent.closureEnv;
                code.emitLoad(frame41);
                code.emitGetField(field);
            }
        }
        target.compileFromStack(comp, rtype);
    }

    public ClassType getHeapFrameType() {
        if (this.isClassGenerated()) {
            return (ClassType)this.getType();
        }
        return (ClassType)this.heapFrame.getType();
    }

    public LambdaExp getOwningLambda() {
        ScopeExp exp = this.getOuter();
        while (exp != null) {
            if (exp instanceof ModuleExp || exp instanceof ClassExp && this.getNeedsClosureEnv() || exp instanceof LambdaExp && ((LambdaExp)exp).heapFrame != null) {
                return (LambdaExp)exp;
            }
            exp = exp.getOuter();
        }
        return null;
    }

    void addMethodFor(Compilation comp, ObjectType closureEnvType) {
        ScopeExp sc;
        for (sc = this; sc != null && !(sc instanceof ClassExp); sc = sc.getOuter()) {
        }
        ClassType ctype = sc != null ? ((ClassExp)sc).instanceType : this.getOwningLambda().getHeapFrameType();
        this.addMethodFor(ctype, comp, closureEnvType);
    }

    void addMethodFor(ClassType ctype, Compilation comp, ObjectType closureEnvType) {
        LambdaExp outer;
        int isInitMethod;
        String name;
        int numStubs;
        boolean varArgs;
        StringBuffer nameBuf;
        int mflags;
        int key_args;
        boolean withContext;
        block72 : {
            boolean isStatic;
            name = this.getName();
            outer = this.outerLambda();
            key_args = this.keywords == null ? 0 : this.keywords.length;
            numStubs = (this.flags & 512) != 0 ? 0 : this.opt_args;
            varArgs = this.max_args < 0 || this.min_args + numStubs < this.max_args;
            Method[] methods = new Method[numStubs + 1];
            this.primBodyMethods = methods;
            if (this.primMethods == null) {
                this.primMethods = methods;
            }
            isInitMethod = 0;
            if (this.nameDecl != null && this.nameDecl.getFlag(4096L)) {
                isStatic = false;
            } else if (this.nameDecl != null && this.nameDecl.getFlag(2048L)) {
                isStatic = true;
            } else if (this.isClassMethod()) {
                if (outer instanceof ClassExp) {
                    ClassExp cl = (ClassExp)outer;
                    boolean bl = isStatic = cl.isMakingClassPair() && closureEnvType != null;
                    if (this == cl.initMethod) {
                        isInitMethod = 73;
                    } else if (this == cl.clinitMethod) {
                        isInitMethod = 67;
                        isStatic = true;
                    }
                } else {
                    isStatic = false;
                }
            } else {
                ModuleExp mexp;
                isStatic = this.thisVariable != null || closureEnvType == ctype ? false : (this.nameDecl != null && this.nameDecl.context instanceof ModuleExp ? (mexp = (ModuleExp)this.nameDecl.context).getSuperType() == null && mexp.getInterfaces() == null : true);
            }
            nameBuf = new StringBuffer(60);
            int n = mflags = isStatic ? 8 : 0;
            if (this.nameDecl != null) {
                if (this.nameDecl.needsExternalAccess()) {
                    mflags |= 1;
                } else {
                    short defaultFlag;
                    short s = defaultFlag = this.nameDecl.isPrivate() ? (short)0 : 1;
                    if (this.isClassMethod()) {
                        defaultFlag = this.nameDecl.getAccessFlags(defaultFlag);
                    }
                    mflags |= defaultFlag;
                }
            }
            if (this.getFlag(16384)) {
                mflags |= 1;
            }
            if (!outer.isModuleBody() && !(outer instanceof ClassExp) || name == null) {
                nameBuf.append("lambda");
                nameBuf.append(++comp.method_counter);
            }
            if (isInitMethod == 67) {
                nameBuf.append("<clinit>");
            } else if (this.getSymbol() != null) {
                nameBuf.append(Mangling.mangleName(name));
            }
            if (this.getFlag(1024)) {
                nameBuf.append("$C");
            }
            boolean bl = withContext = this.getCallConvention() >= 2 && isInitMethod == 0;
            if (isInitMethod != 0) {
                mflags = isStatic ? (mflags & -3) + 1 : (mflags & 2) + 2;
            }
            if (ctype.isInterface() || this.isAbstract()) {
                mflags |= 1024;
            }
            if (this.isNative()) {
                mflags |= 256;
            }
            if (!this.isClassMethod() || !(outer instanceof ClassExp) || this.min_args != this.max_args) break block72;
            Method[] inherited = null;
            int iarg = 0;
            Declaration param = this.firstDecl();
            block0 : do {
                block71 : {
                    block74 : {
                        block75 : {
                            block73 : {
                                if (param != null) break block73;
                                if (this.returnType != null) {
                                    break;
                                }
                                break block74;
                            }
                            if (!param.isThisParameter()) break block75;
                            --iarg;
                            break block71;
                        }
                        if (param.getFlag(8192L)) break block71;
                    }
                    if (inherited == null) {
                        final String mangled = nameBuf.toString();
                        Filter filter = new Filter(){

                            public boolean select(Object value) {
                                Method method = (Method)value;
                                if (!method.getName().equals(mangled)) {
                                    return false;
                                }
                                Type[] ptypes = method.getParameterTypes();
                                return ptypes.length == LambdaExp.this.min_args;
                            }
                        };
                        inherited = ctype.getMethods(filter, 2);
                    }
                    Type type = null;
                    int i = inherited.length;
                    while (--i >= 0) {
                        Type ptype;
                        void method = inherited[i];
                        Type type2 = ptype = param == null ? method.getReturnType() : method.getParameterTypes()[iarg];
                        if (type == null) {
                            type = ptype;
                            continue;
                        }
                        if (ptype == type) continue;
                        if (param == null) {
                            break block0;
                        }
                        break block71;
                    }
                    if (type != null) {
                        if (param != null) {
                            param.setType(type);
                        } else {
                            this.setCoercedReturnType(type);
                        }
                    }
                    if (param == null) break;
                }
                param = param.nextDecl();
                ++iarg;
            } while (true);
        }
        PrimType rtype = this.getFlag(1024) || this.getCallConvention() >= 2 ? Type.voidType : this.getReturnType().promoteIfUnsigned().getImplementationType();
        int extraArg = closureEnvType != null && closureEnvType != ctype ? 1 : 0;
        String rtypeEnc = comp.getLanguage().encodeType(this.getReturnType());
        int ctxArg = 0;
        if (this.getCallConvention() >= 2 && isInitMethod == 0) {
            ctxArg = 1;
        }
        int nameBaseLength = nameBuf.length();
        for (int i = 0; i <= numStubs; ++i) {
            int plainArgs;
            nameBuf.setLength(nameBaseLength);
            int numArgs = plainArgs = this.min_args + i;
            if (i == numStubs && varArgs) {
                ++numArgs;
            }
            Type[] atypes = new Type[extraArg + numArgs + ctxArg];
            if (extraArg > 0) {
                atypes[0] = closureEnvType;
            }
            Stack<String> encTypes = new Stack<String>();
            int encTypesSize = rtypeEnc == null ? 0 : 1;
            encTypes.add(encTypesSize == 0 ? "" : rtypeEnc);
            Declaration var = this.firstDecl();
            if (var != null && var.isThisParameter()) {
                var = var.nextDecl();
            }
            int itype = 0;
            while (itype < plainArgs) {
                atypes[extraArg + itype++] = var.getType().promoteIfUnsigned().getImplementationType();
                String encType = comp.getLanguage().encodeType(var.getType());
                if (encType == null) {
                    encType = "";
                } else {
                    encTypesSize = encTypes.size() + 1;
                }
                encTypes.add(encType);
                var = var.nextDecl();
            }
            if (ctxArg != 0) {
                atypes[atypes.length - 1] = Compilation.typeCallContext;
            }
            if (plainArgs < numArgs) {
                Type lastType = var.getType();
                String lastTypeName = lastType.getName();
                if (ctype.getClassfileVersion() >= 3211264 && lastType instanceof ArrayType) {
                    mflags |= 128;
                } else {
                    nameBuf.append("$V");
                }
                String encType = comp.getLanguage().encodeType(var.getType());
                if (encType == null) {
                    encType = "";
                } else {
                    encTypesSize = encTypes.size() + 1;
                }
                encTypes.add(encType);
                if (key_args > 0 || numStubs < this.opt_args || !"gnu.lists.LList".equals(lastTypeName) && !(lastType instanceof ArrayType)) {
                    lastType = Compilation.objArrayType;
                    this.argsArray = new Variable("argsArray", Compilation.objArrayType);
                    this.argsArray.setParameter(true);
                }
                this.firstArgsArrayArg = var;
                atypes[atypes.length - (withContext != false ? 2 : 1)] = lastType;
            }
            if (withContext) {
                nameBuf.append("$X");
            }
            boolean classSpecified = outer instanceof ClassExp || outer instanceof ModuleExp && ((ModuleExp)outer).getFlag(262144);
            name = nameBuf.toString();
            int renameCount = 0;
            int len = nameBuf.length();
            String suffix = nameBuf.substring(nameBaseLength, len);
            block4 : do {
                for (ClassType t = ctype; t != null; t = t.getSuperclass()) {
                    if (t.getDeclaredMethod(name, atypes) != null) {
                        nameBuf.setLength(nameBaseLength);
                        nameBuf.append('$');
                        nameBuf.append(++renameCount);
                        nameBuf.append(suffix);
                        name = nameBuf.toString();
                        continue;
                    }
                    if (classSpecified) break block4;
                }
                break;
            } while (true);
            Method method = ctype.addMethod(name, atypes, rtype, mflags);
            if (encTypesSize > 0 && (this.nameDecl == null || this.nameDecl.getAnnotation(SourceMethodType.class) == null)) {
                AnnotationEntry ae = new AnnotationEntry(ClassType.make("kawa.SourceMethodType"));
                while (encTypes.size() > encTypesSize) {
                    encTypes.pop();
                }
                ae.addMember("value", encTypes, ArrayType.make(Type.javalangStringType));
                RuntimeAnnotationsAttr.maybeAddAnnotation(method, ae);
            }
            methods[i] = method;
            if (this.throwsSpecification == null || this.throwsSpecification.length <= 0) continue;
            int n = this.throwsSpecification.length;
            ClassType[] exceptions2 = new ClassType[n];
            for (int j = 0; j < n; ++j) {
                ClassType exception = null;
                Expression throwsExpr = this.throwsSpecification[j];
                String msg = null;
                if (throwsExpr instanceof ReferenceExp) {
                    ReferenceExp throwsRef = (ReferenceExp)throwsExpr;
                    Declaration decl = throwsRef.getBinding();
                    if (decl != null) {
                        Expression declValue = decl.getValue();
                        if (declValue instanceof ClassExp) {
                            exception = ((ClassExp)declValue).getCompiledClassType(comp);
                        } else {
                            msg = "throws specification " + decl.getName() + " has non-class lexical binding";
                        }
                    } else {
                        msg = "unknown class " + throwsRef.getName();
                    }
                } else if (throwsExpr instanceof QuoteExp) {
                    Object value = ((QuoteExp)throwsExpr).getValue();
                    if (value instanceof Class) {
                        value = Type.make((Class)value);
                    }
                    if (value instanceof ClassType) {
                        exception = (ClassType)value;
                    }
                    if (exception != null && !exception.isSubtype(Type.javalangThrowableType)) {
                        msg = exception.getName() + " does not extend Throwable";
                    }
                }
                if (exception == null && msg == null) {
                    msg = "invalid throws specification";
                }
                if (msg != null) {
                    comp.error('e', msg, throwsExpr);
                    exception = Type.javalangThrowableType;
                }
                exceptions2[j] = exception;
            }
            ExceptionsAttr attr = new ExceptionsAttr(method);
            attr.setExceptions(exceptions2);
        }
    }

    public void allocChildClasses(Compilation comp) {
        Method main = this.getMainMethod();
        if (main != null && !main.getStaticFlag()) {
            CodeAttr code = comp.getCode();
            this.scope = code.getCurrentScope();
            this.declareThis(main.getDeclaringClass());
            this.thisVariable.allocateLocal(code);
            this.scope = null;
        }
        Declaration decl = this.firstDecl();
        do {
            Variable var;
            if (decl == this.firstArgsArrayArg && this.argsArray != null) {
                this.getVarScope().addVariable(this.argsArray);
            }
            if (!this.getInlineOnly() && this.getCallConvention() >= 2 && (this.firstArgsArrayArg == null ? decl == null : (this.argsArray != null ? decl == this.firstArgsArrayArg : decl == this.firstArgsArrayArg.nextDecl()))) {
                var = this.getVarScope().addVariable(null, Compilation.typeCallContext, "$ctx");
                var.setParameter(true);
            }
            if (decl == null) break;
            var = decl.var;
            if (!(var != null || this.getInlineOnly() && decl.ignorable() || !decl.parameterForMethod())) {
                if (decl.isSimple() && !decl.isIndirectBinding()) {
                    var = decl.allocateVariable(null);
                } else {
                    String vname = Mangling.mangleName(decl.getName()).intern();
                    Type vtype = decl.getType().getImplementationType();
                    var = decl.var = this.getVarScope().addVariable(null, vtype, vname);
                    var.setParameter(true);
                }
            }
            decl = decl.nextDecl();
        } while (true);
        this.declareClosureEnv();
        this.allocFrame(comp);
        this.allocChildMethods(comp);
    }

    void allocMethod(LambdaExp outer, Compilation comp) {
        ClassType closureEnvType;
        int state;
        if (this.currentModule().info != null && (state = this.currentModule().info.getState()) >= 14 && state != 100) {
            comp.error('f', "internal error - allocate method for " + this + " in module " + this.currentModule() + " that has already been compiled\n(Try removing all class files and doing a full re-compile.)");
        }
        if (!this.getNeedsClosureEnv()) {
            closureEnvType = null;
        } else if (outer.isClassGenerated()) {
            closureEnvType = outer.getCompiledClassType(comp);
        } else {
            LambdaExp owner = outer;
            while (owner.heapFrame == null) {
                owner = owner.outerLambda();
            }
            closureEnvType = (ClassType)owner.heapFrame.getType();
        }
        this.addMethodFor(comp, closureEnvType);
    }

    public void pushChild(LambdaExp child) {
        child.nextSibling = this.firstChild;
        this.firstChild = child;
    }

    public void reverseChildList() {
        LambdaExp prev = null;
        LambdaExp child = this.firstChild;
        while (child != null) {
            LambdaExp next = child.nextSibling;
            child.nextSibling = prev;
            prev = child;
            child = next;
        }
        this.firstChild = prev;
    }

    void allocChildMethods(Compilation comp) {
        LambdaExp child = this.firstChild;
        while (child != null) {
            ClassExp cl;
            if (child instanceof ClassExp && (cl = (ClassExp)child).getNeedsClosureEnv()) {
                ClassType parentFrameType;
                if (this.isClassGenerated()) {
                    parentFrameType = (ClassType)this.getType();
                } else {
                    Variable parentFrame = this.heapFrame != null ? this.heapFrame : this.closureEnv;
                    parentFrameType = (ClassType)parentFrame.getType();
                }
                cl.closureEnvField = cl.staticLinkField = cl.instanceType.setOuterLink(parentFrameType);
            }
            child = child.nextSibling;
        }
    }

    public void allocFrame(Compilation comp) {
        if (this.heapFrame != null) {
            ClassType frameType;
            if (this.isClassGenerated()) {
                frameType = this.getCompiledClassType(comp);
            } else {
                frameType = new ClassType(comp.generateClassName("frame"));
                frameType.setSuper(comp.getModuleType());
                comp.addClass(frameType);
            }
            this.heapFrame.setType(frameType);
        }
    }

    void allocParameters(Compilation comp) {
        CodeAttr code = comp.getCode();
        Scope sc = this.getVarScope();
        code.locals.enterScope(sc);
        int line = this.getLineNumber();
        if (line > 0) {
            code.putLineNumber(this.getFileName(), line);
        }
    }

    void enterFunction(Compilation comp) {
        ClassType frameType;
        Declaration param;
        int key_args;
        CodeAttr code = comp.getCode();
        this.getVarScope().noteStartFunction(code);
        if (this.closureEnv != null && !this.closureEnv.isParameter() && !comp.usingCPStyle()) {
            if (!this.getInlineOnly()) {
                code.emitPushThis();
                Field field = this.closureEnvField;
                if (field == null) {
                    field = this.outerLambda().closureEnvField;
                }
                code.emitGetField(field);
                code.emitStore(this.closureEnv);
            } else if (!this.inlinedIn(this.outerLambda())) {
                this.outerLambdaOrCaller().loadHeapFrame(comp);
                code.emitStore(this.closureEnv);
            }
        }
        if (!comp.usingCPStyle()) {
            frameType = this.heapFrame == null ? this.currentModule().getCompiledClassType(comp) : (ClassType)this.heapFrame.getType();
            Declaration decl = this.capturedVars;
            while (decl != null) {
                if (decl.field == null) {
                    decl.makeField(frameType, comp, null);
                }
                decl = decl.nextCapturedVar;
            }
        }
        if (this.heapFrame != null && !comp.usingCPStyle()) {
            frameType = (ClassType)this.heapFrame.getType();
            if (this.closureEnv != null && !(this instanceof ModuleExp)) {
                this.staticLinkField = frameType.addField("staticLink", this.closureEnv.getType());
            }
            if (!this.isClassGenerated()) {
                frameType.setEnclosingMember(comp.method);
                code.emitNew(frameType);
                code.emitDup(frameType);
                Method constructor = Compilation.getConstructor(frameType, this);
                code.emitInvokeSpecial(constructor);
                if (this.staticLinkField != null) {
                    code.emitDup(frameType);
                    code.emitLoad(this.closureEnv);
                    code.emitPutField(this.staticLinkField);
                }
                this.heapFrame.allocateLocal(code);
                code.emitStore(this.heapFrame);
                code.pushAutoPoppableScope().addVariable(this.heapFrame);
            }
        }
        Variable argsArray = this.argsArray;
        if (this.min_args == this.max_args && this.primMethods == null && this.getCallConvention() < 2) {
            argsArray = null;
        }
        int i = (param = this.firstDecl()) != null && param.isThisParameter() ? -1 : 0;
        int key_i = 0;
        int n = key_args = this.keywords == null ? 0 : this.keywords.length;
        if (this instanceof ModuleExp) {
            return;
        }
        int plainArgs = -1;
        int defaultStart = 0;
        Method mainMethod = this.getMainMethod();
        Variable callContextSave = comp.callContextVar;
        while (param != null) {
            Variable variable = comp.callContextVar = this.getCallConvention() < 2 ? null : this.getVarScope().lookup("$ctx");
            if (param == this.firstArgsArrayArg && argsArray != null) {
                if (this.primMethods != null) {
                    plainArgs = i;
                    defaultStart = plainArgs - this.min_args;
                } else {
                    plainArgs = 0;
                    defaultStart = 0;
                }
            }
            boolean ignorable = param.ignorable();
            if (plainArgs >= 0 || !param.isSimple() || param.isIndirectBinding()) {
                Type stackType;
                Type paramType = param.getType();
                Type type = stackType = plainArgs >= 0 ? Type.objectType : paramType;
                if (!param.isSimple() && !ignorable) {
                    param.loadOwningObject(null, comp);
                }
                if (plainArgs < 0) {
                    if (!ignorable) {
                        code.emitLoad(param.getVariable());
                    }
                } else if (i < this.min_args) {
                    if (!ignorable) {
                        code.emitLoad(argsArray);
                        code.emitPushInt(i);
                        code.emitArrayLoad(Type.objectType);
                    }
                } else if (i < this.min_args + this.opt_args) {
                    Expression defaultArg = param.getInitValue();
                    if (!ignorable || !(defaultArg instanceof QuoteExp)) {
                        code.emitPushInt(i - plainArgs);
                        code.emitLoad(argsArray);
                        code.emitArrayLength();
                        code.emitIfIntLt();
                        if (!ignorable) {
                            code.emitLoad(argsArray);
                            code.emitPushInt(i - plainArgs);
                            code.emitArrayLoad();
                        }
                        code.emitElse();
                        if (ignorable) {
                            defaultArg.compile(comp, Target.Ignore);
                        } else {
                            defaultArg.compile(comp, paramType);
                        }
                        code.emitFi();
                    }
                } else if (this.max_args < 0 && i == this.min_args + this.opt_args) {
                    if (!ignorable) {
                        code.emitLoad(argsArray);
                        code.emitPushInt(i - plainArgs);
                        code.emitInvokeStatic(Compilation.makeListMethod);
                    }
                    stackType = Compilation.scmListType;
                } else {
                    Keyword keyword = this.keywords[key_i++];
                    Expression defaultArg = param.getInitValue();
                    if (!ignorable || !(defaultArg instanceof QuoteExp)) {
                        Type boxedParamType;
                        Type[] argts;
                        code.emitLoad(argsArray);
                        code.emitPushInt(this.min_args + this.opt_args - plainArgs);
                        comp.compileConstant(keyword);
                        Type type2 = boxedParamType = paramType instanceof PrimType ? ((PrimType)paramType).boxedType() : paramType;
                        if (defaultArg instanceof QuoteExp) {
                            if (searchForKeywordMethod4 == null) {
                                argts = new Type[]{Compilation.objArrayType, Type.intType, Type.objectType, Type.objectType};
                                searchForKeywordMethod4 = Compilation.scmKeywordType.addMethod("searchForKeyword", argts, Type.objectType, 9);
                            }
                            defaultArg.compile(comp, boxedParamType);
                            code.emitInvokeStatic(searchForKeywordMethod4);
                        } else {
                            if (searchForKeywordMethod3 == null) {
                                argts = new Type[]{Compilation.objArrayType, Type.intType, Type.objectType};
                                searchForKeywordMethod3 = Compilation.scmKeywordType.addMethod("searchForKeyword", argts, Type.objectType, 9);
                            }
                            code.emitInvokeStatic(searchForKeywordMethod3);
                            if (!ignorable) {
                                code.emitDup(1);
                            }
                            comp.compileConstant(Special.dfault);
                            code.emitIfEq();
                            if (ignorable) {
                                defaultArg.compile(comp, Target.Ignore);
                            } else {
                                code.emitPop(1);
                                defaultArg.compile(comp, boxedParamType);
                                paramType.emitCoerceToObject(code);
                            }
                            code.emitFi();
                        }
                    }
                }
                if (!ignorable) {
                    if (paramType != stackType) {
                        CheckedTarget.emitCheckedCoerce(comp, this, i + 1, stackType, paramType, null);
                    }
                    if (param.isIndirectBinding()) {
                        param.pushIndirectBinding(comp);
                    }
                    if (param.isSimple()) {
                        Variable var = param.getVariable();
                        if (param.isIndirectBinding()) {
                            var.setType(Compilation.typeLocation);
                        }
                        code.emitStore(var);
                    } else {
                        code.emitPutField(param.field);
                    }
                }
            }
            param = param.nextDecl();
            ++i;
        }
        comp.callContextVar = callContextSave;
    }

    void compileAsInlined(Compilation comp, Target target) {
        this.flags |= 128;
        LambdaExp saveLambda = comp.curLambda;
        comp.curLambda = this;
        this.allocChildClasses(comp);
        this.allocParameters(comp);
        CodeAttr code = comp.getCode();
        if (this.startForInlining == null) {
            this.startForInlining = new Label(code);
        }
        this.startForInlining.define(code);
        ApplyExp.popParams(code, this, null, false);
        this.enterFunction(comp);
        this.body.compileWithPosition(comp, target);
        this.compileEnd(comp);
        this.generateApplyMethods(comp);
        comp.curLambda = saveLambda;
    }

    void compileAsMethod(Compilation comp) {
        if ((this.flags & 128) != 0 || this.isAbstract() || this.isNative()) {
            return;
        }
        this.flags |= 128;
        if (this.primMethods == null) {
            this.allocMethod(this.outerLambda(), comp);
        }
        Method save_method = comp.method;
        LambdaExp save_lambda = comp.curLambda;
        comp.curLambda = this;
        Method method = this.primMethods[0];
        boolean isStatic = method.getStaticFlag();
        int numStubs = this.primMethods.length - 1;
        Type restArgType = this.restArgType();
        long[] saveDeclFlags = null;
        if (numStubs > 0) {
            saveDeclFlags = new long[this.min_args + numStubs];
            int k = 0;
            Declaration decl = this.firstDecl();
            while (k < this.min_args + numStubs) {
                saveDeclFlags[k++] = decl.flags;
                decl = decl.nextDecl();
            }
        }
        boolean ctxArg = this.getCallConvention() >= 2;
        for (int i = 0; i <= numStubs; ++i) {
            Declaration decl;
            comp.method = this.primMethods[i];
            if (this.nameDecl != null && !this.isClassMethod()) {
                this.nameDecl.compileAnnotations(comp.method, ElementType.METHOD);
            }
            if (i < numStubs) {
                boolean varArgs;
                CodeAttr code = comp.method.startCode();
                Variable callContextSave = comp.callContextVar;
                Variable var = code.getArg(0);
                if (!isStatic) {
                    code.emitPushThis();
                    if (this.getNeedsClosureEnv()) {
                        this.closureEnv = var;
                    }
                    var = code.getArg(1);
                }
                decl = this.firstDecl();
                int j = 0;
                while (j < this.min_args + i) {
                    decl.flags |= 64L;
                    decl.var = var;
                    code.emitLoad(var);
                    var = var.nextVar();
                    ++j;
                    decl = decl.nextDecl();
                }
                comp.callContextVar = ctxArg ? var : null;
                int toCall = i + 1;
                for (int j2 = i; j2 < toCall; ++j2) {
                    Target paramTarget = StackTarget.getInstance(decl.getType());
                    Expression defaultArg = decl.getInitValue();
                    defaultArg.compile(comp, paramTarget);
                    decl = decl.nextDecl();
                    if (toCall >= numStubs || !(decl.getInitValue() instanceof QuoteExp)) continue;
                    ++toCall;
                }
                boolean bl = varArgs = toCall == numStubs && restArgType != null;
                if (varArgs) {
                    QuoteExp arg;
                    String lastTypeName = restArgType.getName();
                    if ("gnu.lists.LList".equals(lastTypeName)) {
                        arg = QuoteExp.emptyExp;
                    } else if ("java.lang.Object[]".equals(lastTypeName)) {
                        arg = new QuoteExp(Values.noArgs);
                    } else {
                        throw new Error("unimplemented #!rest type " + lastTypeName);
                    }
                    arg.compile(comp, restArgType);
                }
                if (ctxArg) {
                    code.emitLoad(var);
                }
                if (isStatic) {
                    code.emitInvokeStatic(this.primMethods[toCall]);
                } else {
                    code.emitInvokeVirtual(this.primMethods[toCall]);
                }
                code.emitReturn();
                this.closureEnv = null;
                comp.callContextVar = callContextSave;
                continue;
            }
            if (saveDeclFlags != null) {
                int k = 0;
                decl = this.firstDecl();
                while (k < this.min_args + numStubs) {
                    decl.flags = saveDeclFlags[k++];
                    decl.var = null;
                    decl = decl.nextDecl();
                }
            }
            comp.method.initCode();
            this.allocChildClasses(comp);
            this.allocParameters(comp);
            this.enterFunction(comp);
            this.compileBody(comp);
            this.compileEnd(comp);
            this.generateApplyMethods(comp);
        }
        comp.method = save_method;
        comp.curLambda = save_lambda;
    }

    public void compileBody(Compilation comp) {
        Target target;
        Variable callContextSave = comp.callContextVar;
        comp.callContextVar = null;
        if (this.getCallConvention() >= 2) {
            Variable var = this.getVarScope().lookup("$ctx");
            if (var != null && var.getType() == Compilation.typeCallContext) {
                comp.callContextVar = var;
            }
            target = ConsumerTarget.makeContextTarget(comp, this.getReturnType());
        } else {
            target = Target.pushValue(this.getReturnType());
        }
        ScopeExp savedScope = comp.currentScope();
        comp.current_scope = this;
        this.body.compileWithPosition(comp, target, this.body.getLineNumber() > 0 ? this.body : this);
        comp.current_scope = savedScope;
        comp.callContextVar = callContextSave;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        LambdaExp saveLambda;
        Compilation comp = visitor.getCompilation();
        if (comp == null) {
            saveLambda = null;
        } else {
            saveLambda = comp.curLambda;
            comp.curLambda = this;
        }
        try {
            R r = visitor.visitLambdaExp(this, d);
            return r;
        }
        finally {
            if (comp != null) {
                comp.curLambda = saveLambda;
            }
        }
    }

    @Override
    protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
        this.visitChildrenOnly(visitor, d);
        this.visitProperties(visitor, d);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final <R, D> void visitChildrenOnly(ExpVisitor<R, D> visitor, D d) {
        LambdaExp save = visitor.currentLambda;
        visitor.currentLambda = this;
        try {
            this.throwsSpecification = visitor.visitExps(this.throwsSpecification, d);
            visitor.visitDefaultArgs(this, d);
            if (visitor.exitValue == null && this.body != null) {
                this.body = visitor.update(this.body, visitor.visit(this.body, d));
            }
        }
        finally {
            visitor.currentLambda = save;
        }
    }

    protected final <R, D> void visitProperties(ExpVisitor<R, D> visitor, D d) {
        if (this.properties != null) {
            int len = this.properties.length;
            for (int i = 1; i < len; i += 2) {
                Object val = this.properties[i];
                if (!(val instanceof Expression)) continue;
                this.properties[i] = visitor.visitAndUpdate((Expression)val, d);
            }
        }
    }

    @Override
    protected boolean mustCompile() {
        if (this.keywords != null && this.keywords.length > 0) {
            return true;
        }
        if (this.opt_args != 0) {
            for (Declaration p = this.firstDecl(); p != null; p = p.nextDecl()) {
                Expression defaultArg = p.getInitValue();
                if (defaultArg == null || defaultArg instanceof QuoteExp) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        this.setIndexes();
        ctx.writeValue(new Closure(this, ctx));
    }

    Object evalDefaultArg(Declaration param, CallContext ctx) {
        try {
            return param.getInitValue().eval(ctx);
        }
        catch (Error ex) {
            throw ex;
        }
        catch (Throwable ex) {
            throw new WrappedException("error evaluating default argument", ex);
        }
    }

    @Override
    public Expression validateApply(ApplyExp exp, InlineCalls visitor, Type required, Declaration decl) {
        Expression inlined;
        Expression[] args = exp.getArgs();
        if (exp.firstSpliceArg >= 0) {
            this.setCanRead(true);
            if (this.nameDecl != null) {
                this.nameDecl.setCanRead(true);
            }
        }
        if ((this.flags & 4096) != 0 && (inlined = InlineCalls.inlineCall(this, args, true)) != null) {
            return visitor.visit(inlined, required);
        }
        exp.visitArgs(visitor, this);
        int args_length = exp.args.length;
        int spliceCount = exp.spliceCount();
        int nonSpliceCount = args_length - spliceCount;
        String msg = WrongArguments.checkArgCount(this.getName(), spliceCount > 0 ? 0 : this.min_args, this.max_args, nonSpliceCount);
        if (msg != null) {
            return visitor.noteError(msg);
        }
        return exp;
    }

    @Override
    public void print(OutPort out) {
        out.startLogicalBlock("(Lambda/", ")", 2);
        Object sym = this.getSymbol();
        if (sym != null) {
            out.print(sym);
            out.print('/');
        }
        out.print(this.id);
        out.print('/');
        out.print("fl:");
        out.print(Integer.toHexString(this.flags));
        out.writeSpaceFill();
        this.printLineColumn(out);
        out.startLogicalBlock("(", false, ")");
        Special prevMode = null;
        int i = 0;
        int key_args = this.keywords == null ? 0 : this.keywords.length;
        Declaration decl = this.firstDecl();
        if (decl != null && decl.isThisParameter()) {
            i = -1;
        }
        while (decl != null) {
            Expression defaultArg;
            Special mode = i < this.min_args || i == this.min_args && decl.getFlag(0x10000000000L) ? null : (i < this.min_args + this.opt_args ? Special.optional : (this.max_args < 0 && i == this.min_args + this.opt_args ? Special.rest : Special.key));
            if (decl != this.firstDecl()) {
                out.writeSpaceFill();
            }
            if (mode != prevMode) {
                out.print(mode);
                out.writeSpaceFill();
            }
            if ((defaultArg = decl.getInitValue()) != null) {
                out.print('(');
            }
            decl.printInfo(out);
            if (defaultArg != null && defaultArg != QuoteExp.falseExp) {
                out.print(' ');
                defaultArg.print(out);
                out.print(')');
            }
            if (decl.getFlag(0x80000000000L)) {
                ++i;
            }
            prevMode = mode;
            decl = decl.nextDecl();
        }
        out.endLogicalBlock(")");
        if (this.properties != null) {
            int plen = this.properties.length;
            for (int j = 0; j < plen; j += 2) {
                Object key = this.properties[j];
                if (key == null) continue;
                out.writeSpaceFill();
                out.startLogicalBlock("", false, "");
                out.print(key);
                out.print(":");
                out.writeSpaceFill();
                out.print(this.properties[j + 1]);
                out.endLogicalBlock("");
            }
        }
        out.writeSpaceLinear();
        if (this.body == null) {
            out.print("<null body>");
        } else {
            this.body.print(out);
        }
        out.endLogicalBlock(")");
    }

    protected final String getExpClassName() {
        String cname = this.getClass().getName();
        int index = cname.lastIndexOf(46);
        if (index >= 0) {
            cname = cname.substring(index + 1);
        }
        return cname;
    }

    @Override
    public boolean side_effects() {
        return false;
    }

    @Override
    public String toString() {
        String str = this.getExpClassName() + ':' + this.getSymbol() + '/' + this.id + '/';
        int l = this.getLineNumber();
        if (l <= 0 && this.body != null) {
            l = this.body.getLineNumber();
        }
        if (l > 0) {
            str = str + "l:" + l;
        }
        return str;
    }

    @Override
    public Object getProperty(Object key, Object defaultValue) {
        if (this.properties != null) {
            int i = this.properties.length;
            while ((i -= 2) >= 0) {
                if (this.properties[i] != key) continue;
                return this.properties[i + 1];
            }
        }
        return defaultValue;
    }

    @Override
    public synchronized void setProperty(Object key, Object value) {
        this.properties = PropertySet.setProperty(this.properties, key, value);
    }

    public final Type getReturnType() {
        if (this.returnType == null) {
            this.returnType = Type.objectType;
            if (this.body != null && !this.isAbstract() && !this.isNative() && this.body.getFlag(1)) {
                this.returnType = this.body.getType();
            }
        }
        return this.returnType;
    }

    public final void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    public final void setCoercedReturnType(Type returnType) {
        this.returnType = returnType;
        if (returnType != null && returnType != Type.objectType && returnType != Type.voidType && this.body != QuoteExp.abstractExp && this.body != QuoteExp.nativeExp) {
            Expression value = this.body;
            this.body = Compilation.makeCoercion(value, returnType);
            this.body.setLine(value);
        }
    }

    public static void maybeSetReturnType(LambdaExp lexp, Type type) {
        if (lexp.returnType == null && type != null && !(type instanceof InlineCalls.LenientExpectedType) && !(type instanceof InlineCalls.ValueNeededType)) {
            lexp.setCoercedReturnType(type);
        }
    }

    public final void setCoercedReturnValue(Expression type, Language language) {
        Type rtype;
        if (!this.isAbstract() && !this.isNative()) {
            Expression value = this.body;
            this.body = Compilation.makeCoercion(value, type);
            this.body.setLine(value);
        }
        if ((rtype = language.getTypeFor(type)) != null) {
            this.setReturnType(rtype);
        }
    }

    public Expression getBodyFirstExpression() {
        Expression bodyFirst = this.body;
        do {
            if (bodyFirst instanceof BeginExp) {
                BeginExp bbody = (BeginExp)bodyFirst;
                if (bbody.length == 0) {
                    bodyFirst = null;
                    continue;
                }
                bodyFirst = bbody.exps[0];
                continue;
            }
            if (!(bodyFirst instanceof LetExp)) break;
            bodyFirst = ((LetExp)bodyFirst).getBody();
        } while (true);
        return bodyFirst;
    }

    public ClassType checkForInitCall(Expression bodyFirst) {
        Object value;
        Expression exp;
        ClassType calledInit = null;
        if (bodyFirst instanceof ApplyExp && (exp = ((ApplyExp)bodyFirst).func) instanceof QuoteExp && (value = ((QuoteExp)exp).getValue()) instanceof PrimProcedure) {
            PrimProcedure pproc = (PrimProcedure)value;
            Method meth = pproc.getMethod();
            if (pproc.isSpecial() && "<init>".equals(meth.getName())) {
                calledInit = meth.getDeclaringClass();
            }
        }
        return calledInit;
    }

    static class Closure
    extends MethodProc {
        Object[][] evalFrames;
        LambdaExp lambda;

        @Override
        public int numArgs() {
            return this.lambda.min_args | this.lambda.max_args << 12;
        }

        public Closure(LambdaExp lexp, CallContext ctx) {
            this.lambda = lexp;
            Object[][] oldFrames = ctx.evalFrames;
            if (oldFrames != null) {
                int n;
                for (n = oldFrames.length; n > 0 && oldFrames[n - 1] == null; --n) {
                }
                this.evalFrames = new Object[n][];
                System.arraycopy(oldFrames, 0, this.evalFrames, 0, n);
            }
            this.setSymbol(this.lambda.getSymbol());
        }

        @Override
        public int match0(CallContext ctx) {
            return this.matchN(new Object[0], ctx);
        }

        @Override
        public int match1(Object arg1, CallContext ctx) {
            return this.matchN(new Object[]{arg1}, ctx);
        }

        @Override
        public int match2(Object arg1, Object arg2, CallContext ctx) {
            return this.matchN(new Object[]{arg1, arg2}, ctx);
        }

        @Override
        public int match3(Object arg1, Object arg2, Object arg3, CallContext ctx) {
            return this.matchN(new Object[]{arg1, arg2, arg3}, ctx);
        }

        @Override
        public int match4(Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx) {
            return this.matchN(new Object[]{arg1, arg2, arg3, arg4}, ctx);
        }

        @Override
        public int matchN(Object[] args, CallContext ctx) {
            int nargs = args.length;
            int num = this.numArgs();
            int min = num & 4095;
            if (nargs < min) {
                return -983040 | min;
            }
            int max = num >> 12;
            if (nargs > max && max >= 0) {
                return -917504 | max;
            }
            Object[] evalFrame = new Object[this.lambda.frameSize];
            int key_args = this.lambda.keywords == null ? 0 : this.lambda.keywords.length;
            int opt_args = this.lambda.opt_args;
            int i = 0;
            int key_i = 0;
            int min_args = this.lambda.min_args;
            for (Declaration decl = this.lambda.firstDecl(); decl != null; decl = decl.nextDecl()) {
                Object value;
                if (i < min_args) {
                    value = args[i++];
                } else if (i < min_args + opt_args) {
                    value = i < nargs ? args[i++] : this.lambda.evalDefaultArg(decl, ctx);
                } else if (this.lambda.max_args < 0 && i == min_args + opt_args) {
                    if (decl.type instanceof ArrayType) {
                        int rem = nargs - i;
                        Type elementType = ((ArrayType)decl.type).getComponentType();
                        if (elementType == Type.objectType) {
                            Object[] rest = new Object[rem];
                            System.arraycopy(args, i, rest, 0, rem);
                            value = rest;
                        } else {
                            Class elementClass = elementType.getReflectClass();
                            value = Array.newInstance(elementClass, rem);
                            for (int j = 0; j < rem; ++j) {
                                Object el;
                                try {
                                    el = elementType.coerceFromObject(args[i + j]);
                                }
                                catch (ClassCastException ex) {
                                    return -786432 | i + j;
                                }
                                Array.set(value, j, el);
                            }
                        }
                    } else {
                        value = LList.makeList(args, i);
                    }
                } else {
                    Keyword keyword;
                    int key_offset = min_args + opt_args;
                    if ((value = Keyword.searchForKeyword(args, key_offset, keyword = this.lambda.keywords[key_i++])) == Special.dfault) {
                        value = this.lambda.evalDefaultArg(decl, ctx);
                    }
                }
                if (decl.type != null) {
                    try {
                        value = decl.type.coerceFromObject(value);
                    }
                    catch (ClassCastException ex) {
                        return -786432 | i;
                    }
                }
                if (decl.isIndirectBinding()) {
                    Location loc = decl.makeIndirectLocationFor();
                    loc.set(value);
                    value = loc;
                }
                evalFrame[decl.evalIndex] = value;
            }
            ctx.values = evalFrame;
            ctx.where = 0;
            ctx.next = 0;
            ctx.proc = this;
            return 0;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void apply(CallContext ctx) throws Throwable {
            int numFrames;
            int level = ScopeExp.nesting(this.lambda);
            Object[] evalFrame = ctx.values;
            Object[][] saveFrames = ctx.evalFrames;
            int n = numFrames = this.evalFrames == null ? 0 : this.evalFrames.length;
            if (level >= numFrames) {
                numFrames = level;
            }
            Object[][] newFrames = new Object[numFrames += 10][];
            if (this.evalFrames != null) {
                System.arraycopy(this.evalFrames, 0, newFrames, 0, this.evalFrames.length);
            }
            newFrames[level] = evalFrame;
            ctx.evalFrames = newFrames;
            try {
                if (this.lambda.body == null) {
                    StringBuffer sbuf = new StringBuffer("procedure ");
                    String name = this.lambda.getName();
                    if (name == null) {
                        name = "<anonymous>";
                    }
                    sbuf.append(name);
                    int line = this.lambda.getLineNumber();
                    if (line > 0) {
                        sbuf.append(" at line ");
                        sbuf.append(line);
                    }
                    sbuf.append(" was called before it was expanded");
                    throw new RuntimeException(sbuf.toString());
                }
                this.lambda.body.apply(ctx);
            }
            finally {
                ctx.evalFrames = saveFrames;
            }
        }

        @Override
        public Object getProperty(Object key, Object defaultValue) {
            Object value = super.getProperty(key, defaultValue);
            if (value == null) {
                value = this.lambda.getProperty(key, defaultValue);
            }
            return value;
        }
    }

}

