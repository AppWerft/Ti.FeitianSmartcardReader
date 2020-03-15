// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.mapping.Location;
import gnu.lists.LList;
import java.lang.reflect.Array;
import gnu.mapping.MethodProc;
import gnu.mapping.PropertySet;
import gnu.kawa.io.OutPort;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrappedException;
import gnu.mapping.CallContext;
import gnu.mapping.Values;
import gnu.bytecode.PrimType;
import gnu.bytecode.Member;
import gnu.bytecode.Scope;
import gnu.bytecode.ExceptionsAttr;
import gnu.text.SourceLocator;
import gnu.bytecode.RuntimeAnnotationsAttr;
import gnu.bytecode.AnnotationEntry;
import kawa.SourceMethodType;
import gnu.bytecode.ArrayType;
import java.util.Stack;
import gnu.bytecode.Filter;
import gnu.bytecode.ObjectType;
import gnu.bytecode.AttrContainer;
import java.lang.annotation.ElementType;
import java.util.HashMap;
import gnu.bytecode.CodeAttr;
import java.util.Iterator;
import gnu.bytecode.Type;
import gnu.mapping.Procedure;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import java.util.Set;
import java.util.LinkedList;
import gnu.bytecode.Label;
import gnu.bytecode.Variable;
import java.util.ArrayList;

public class LambdaExp extends ScopeExp
{
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
    static final ApplyExp unknownContinuation;
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
    ClassType compiledType;
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
    
    public void capture(final Declaration decl) {
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
    
    public Declaration addParameter(final Object name) {
        ++this.min_args;
        ++this.max_args;
        return super.addDeclaration(name);
    }
    
    public void setExceptions(final Expression[] exceptions) {
        this.throwsSpecification = exceptions;
    }
    
    public final boolean getInlineOnly() {
        return (this.flags & 0x4) != 0x0;
    }
    
    public final void setInlineOnly(final boolean inlineOnly) {
        this.setFlag(inlineOnly, 4);
    }
    
    public final void setInlineOnly(final Expression returnContinuation, final LambdaExp caller) {
        this.setInlineOnly(true);
        this.returnContinuation = returnContinuation;
        this.inlineHome = caller;
    }
    
    public final boolean getNeedsClosureEnv() {
        return (this.flags & 0x18) != 0x0;
    }
    
    public final boolean getNeedsStaticLink() {
        return (this.flags & 0x10) != 0x0;
    }
    
    public final void setNeedsStaticLink(final boolean needsStaticLink) {
        if (needsStaticLink) {
            this.flags |= 0x10;
        }
        else {
            this.flags &= 0xFFFFFFEF;
        }
    }
    
    public final boolean getImportsLexVars() {
        return (this.flags & 0x8) != 0x0;
    }
    
    public final void setImportsLexVars(final boolean importsLexVars) {
        if (importsLexVars) {
            this.flags |= 0x8;
        }
        else {
            this.flags &= 0xFFFFFFF7;
        }
    }
    
    public final void setImportsLexVars() {
        final int old = this.flags;
        this.flags |= 0x8;
        if ((old & 0x8) == 0x0 && this.nameDecl != null) {
            this.setCallersNeedStaticLink();
        }
    }
    
    public final void setNeedsStaticLink() {
        final int old = this.flags;
        this.flags |= 0x10;
        if ((old & 0x10) == 0x0 && this.nameDecl != null) {
            this.setCallersNeedStaticLink();
        }
    }
    
    void setCallersNeedStaticLink() {
        final LambdaExp outer = this.nameDecl.getContext().currentLambda();
        for (ApplyExp app = this.nameDecl.firstCall; app != null; app = app.nextCall) {
            for (LambdaExp caller = app.context; caller != outer && !(caller instanceof ModuleExp); caller = caller.outerLambda()) {
                caller.setNeedsStaticLink();
            }
        }
    }
    
    public final boolean getCanRead() {
        return (this.flags & 0x2) != 0x0;
    }
    
    public final void setCanRead(final boolean read) {
        if (read) {
            this.flags |= 0x2;
        }
        else {
            this.flags &= 0xFFFFFFFD;
        }
    }
    
    public final boolean isClassMethod() {
        return (this.flags & 0x40) != 0x0;
    }
    
    public final void setClassMethod(final boolean isMethod) {
        if (isMethod) {
            this.flags |= 0x40;
        }
        else {
            this.flags &= 0xFFFFFFBF;
        }
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
    
    public void setCallConvention(final Compilation comp) {
        if (this.isClassMethod()) {
            this.callConvention = 1;
        }
        else {
            final int defaultConvention = comp.currentCallConvention();
            this.callConvention = ((defaultConvention < 2 && this.isModuleBody()) ? 2 : ((defaultConvention == 0) ? 1 : defaultConvention));
        }
    }
    
    public boolean usingCallContext() {
        return this.getCallConvention() >= 2;
    }
    
    void notifyCanFinish() {
        final Set<LambdaExp> listeners = this.canFinishListeners;
        if (listeners != null) {
            this.canFinishListeners = null;
            for (final LambdaExp f : listeners) {
                f.checkCanFinish();
            }
        }
    }
    
    void checkCanFinish() {
        final CanFinishMap cond = this.canFinishCondition;
        if (cond != null && !this.getFlag(8192) && cond.canFinish()) {
            this.canFinishCondition = CanFinishMap.CAN_FINISH;
            this.notifyCanFinish();
        }
    }
    
    public final boolean isHandlingTailCalls() {
        return this.isModuleBody() || (this.getCallConvention() >= 3 && !this.isClassMethod());
    }
    
    public final boolean variable_args() {
        return this.max_args < 0;
    }
    
    protected ClassType getCompiledClassType(final Compilation comp) {
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
    
    public void setType(final ClassType type) {
        this.compiledType = type;
        this.type = type;
    }
    
    public int incomingArgs() {
        return (this.min_args == this.max_args && this.max_args <= 4 && this.max_args > 0) ? this.max_args : 1;
    }
    
    int getSelectorValue(final Compilation comp) {
        int s = this.selectorValue;
        if (s == 0) {
            s = comp.maxSelectorValue;
            comp.maxSelectorValue = s + this.primMethods.length;
            this.selectorValue = ++s;
        }
        return s;
    }
    
    public final Method getMethod(final int nonSpliceCount, final int spliceCount) {
        if (this.primMethods == null || (this.max_args >= 0 && nonSpliceCount > this.max_args)) {
            return null;
        }
        final int index = nonSpliceCount - this.min_args;
        if (index < 0) {
            return null;
        }
        final int length = this.primMethods.length;
        if (spliceCount > 0) {
            return (length == 1) ? this.primMethods[0] : null;
        }
        return this.primMethods[(index < length) ? index : (length - 1)];
    }
    
    public final Method getMainMethod() {
        final Method[] methods = this.primBodyMethods;
        return (methods == null) ? null : methods[methods.length - 1];
    }
    
    public final Type restArgType() {
        if (this.min_args == this.max_args) {
            return null;
        }
        if (this.primMethods == null) {
            throw new Error("internal error - restArgType");
        }
        final Method[] methods = this.primMethods;
        if (this.max_args >= 0 && methods.length > this.max_args - this.min_args) {
            return null;
        }
        final Method method = methods[methods.length - 1];
        final Type[] types = method.getParameterTypes();
        int ilast = types.length - 1;
        if (method.getName().endsWith("$X")) {
            --ilast;
        }
        return types[ilast];
    }
    
    public LambdaExp outerLambda() {
        return (this.getOuter() == null) ? null : this.getOuter().currentLambda();
    }
    
    public LambdaExp outerLambdaOrCaller() {
        return this.getInlineOnly() ? this.inlineHome : this.outerLambda();
    }
    
    public LambdaExp outerLambdaNotInline() {
        ScopeExp exp = this;
        while ((exp = exp.getOuter()) != null) {
            if (exp instanceof LambdaExp) {
                final LambdaExp result = (LambdaExp)exp;
                if (!result.getInlineOnly()) {
                    return result;
                }
                continue;
            }
        }
        return null;
    }
    
    boolean inlinedIn(final LambdaExp outer) {
        for (LambdaExp exp = this; exp != outer; exp = exp.getCaller()) {
            if (!exp.getInlineOnly()) {
                return false;
            }
        }
        return true;
    }
    
    public LambdaExp getCaller() {
        return this.inlineHome;
    }
    
    public Variable declareThis(final ClassType clas) {
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
            }
            else if (parent.heapFrame == null && !parent.getNeedsStaticLink() && !(parent instanceof ModuleExp)) {
                this.closureEnv = null;
            }
            else if (!this.isClassGenerated() && !this.getInlineOnly()) {
                final Method primMethod = this.getMainMethod();
                final boolean isInit = "*init*".equals(this.getName());
                if (!primMethod.getStaticFlag() && !isInit) {
                    this.closureEnv = this.declareThis(primMethod.getDeclaringClass());
                }
                else {
                    final Type envType = primMethod.getParameterTypes()[0];
                    this.closureEnv = new Variable("$closureEnv", envType);
                    Variable prev;
                    if (isInit) {
                        prev = this.declareThis(primMethod.getDeclaringClass());
                    }
                    else {
                        prev = null;
                    }
                    this.getVarScope().addVariableAfter(prev, this.closureEnv);
                    this.closureEnv.setParameter(true);
                }
            }
            else {
                if (this.inlineHome != null) {
                    this.inlineHome.declareClosureEnv();
                }
                this.closureEnv = ((parent.heapFrame != null && parent == this.outerLambda()) ? parent.heapFrame : parent.closureEnv);
            }
        }
        return this.closureEnv;
    }
    
    public LambdaExp() {
        this.compiledType = Compilation.typeProcedure;
    }
    
    public LambdaExp(final int args) {
        this.compiledType = Compilation.typeProcedure;
        this.min_args = args;
        this.max_args = args;
    }
    
    public LambdaExp(final Expression body) {
        this.compiledType = Compilation.typeProcedure;
        this.body = body;
    }
    
    public void loadHeapFrame(final Compilation comp) {
        LambdaExp curLambda;
        for (curLambda = comp.curLambda; curLambda != this && curLambda.getInlineOnly(); curLambda = curLambda.getCaller()) {}
        final CodeAttr code = comp.getCode();
        if (curLambda.heapFrame != null && this == curLambda) {
            code.emitLoad(curLambda.heapFrame);
            return;
        }
        ClassType curType;
        if (curLambda.closureEnv != null) {
            code.emitLoad(curLambda.closureEnv);
            curType = (ClassType)curLambda.closureEnv.getType();
        }
        else {
            code.emitPushThis();
            curType = comp.curClass;
        }
        while (curLambda != this) {
            final Field link = curLambda.staticLinkField;
            if (link != null && link.getDeclaringClass() == curType) {
                code.emitGetField(link);
                curType = (ClassType)link.getType();
            }
            curLambda = curLambda.outerLambdaOrCaller();
        }
    }
    
    Declaration getArg(int i) {
        for (Declaration var = this.firstDecl(); var != null; var = var.nextDecl()) {
            if (i == 0) {
                return var;
            }
            --i;
        }
        throw new Error("internal error - getArg");
    }
    
    public void compileEnd(final Compilation comp) {
        final CodeAttr code = comp.getCode();
        final HashMap<String, Variable> varMap = new HashMap<String, Variable>();
        final Label endLabel = new Label(code);
        while (this.pendingInlines != null && !this.pendingInlines.isEmpty()) {
            final LambdaExp child = this.pendingInlines.remove();
            final Target ctarget = this.pendingInlines.remove();
            if (child.getInlineOnly() && !child.getFlag(128) && child.startForInlining != null) {
                if (code.reachableHere()) {
                    code.emitGoto(endLabel);
                }
                child.compileAsInlined(comp, ctarget);
            }
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
        for (LambdaExp child = this.firstChild; child != null; child = child.nextSibling) {
            if (!child.getCanRead() && !child.getInlineOnly() && child.getFlag(1)) {
                child.compileAsMethod(comp);
            }
            else if (child instanceof ClassExp) {
                ((ClassExp)child).compileMembers(comp);
            }
        }
        if (this.heapFrame != null) {
            comp.generateConstructor(this);
        }
    }
    
    public void generateApplyMethods(final Compilation comp) {
        comp.generateMatchMethods(this);
        comp.generateApplyMethodsWithContext(this);
        comp.generateApplyMethodsWithoutContext(this);
    }
    
    Field allocFieldFor(final Compilation comp) {
        if (this.nameDecl != null && this.nameDecl.field != null && this.nameDecl.getValueRaw() == this) {
            return this.nameDecl.field;
        }
        final boolean needsClosure = this.getNeedsClosureEnv();
        final ClassType frameType = needsClosure ? this.getOwningLambda().getHeapFrameType() : comp.mainClass;
        final String name = this.getName();
        String fname = (name == null) ? "lambda" : Mangling.mangleNameIfNeeded(name);
        int fflags = 16;
        if (this.nameDecl != null && this.nameDecl.context instanceof ModuleExp) {
            final boolean external_access = this.nameDecl.needsExternalAccess();
            if (external_access) {
                fname = "$Prvt$" + fname;
            }
            if (this.nameDecl.getFlag(2048L)) {
                fflags |= 0x8;
                if (!((ModuleExp)this.nameDecl.context).isStatic()) {
                    fflags &= 0xFFFFFFEF;
                }
            }
            if (!this.nameDecl.isPrivate() || external_access || comp.immediate) {
                fflags |= 0x1;
            }
            if ((this.flags & 0x800) != 0x0) {
                final String fname2 = fname;
                int suffix = (this.min_args == this.max_args) ? this.min_args : 1;
                do {
                    fname = fname2 + '$' + suffix++;
                } while (frameType.getDeclaredField(fname) != null);
            }
        }
        else {
            fname = fname + "$Fn" + ++comp.localFieldIndex;
            if (!needsClosure) {
                fflags |= 0x8;
            }
        }
        final Type rtype = Compilation.typeModuleMethod;
        final Field field = frameType.addField(fname, rtype, fflags);
        if (this.nameDecl != null) {
            this.nameDecl.field = field;
        }
        return field;
    }
    
    final void addApplyMethod(final Compilation comp, final Field field) {
        LambdaExp owner = this;
        if (field != null && field.getStaticFlag()) {
            owner = comp.getModule();
        }
        else {
            do {
                owner = owner.outerLambda();
            } while (!(owner instanceof ModuleExp) && owner.heapFrame == null);
            final ClassType frameType = owner.getHeapFrameType();
            if (!frameType.getSuperclass().isSubtype(Compilation.typeModuleBody)) {
                owner = comp.getModule();
            }
        }
        if (owner.applyMethods == null) {
            owner.applyMethods = new ArrayList<LambdaExp>();
        }
        owner.applyMethods.add(this);
    }
    
    public Field compileSetField(final Compilation comp) {
        if (this.primMethods == null) {
            this.allocMethod(this.outerLambda(), comp);
        }
        final Field field = this.allocFieldFor(comp);
        if (comp.usingCPStyle()) {
            this.compile(comp, Type.objectType);
        }
        else {
            this.compileAsMethod(comp);
            this.addApplyMethod(comp, field);
        }
        if (this.nameDecl != null) {
            this.nameDecl.compileAnnotations(field, ElementType.FIELD);
        }
        return new ProcInitializer(this, comp, field).field;
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        if (target instanceof IgnoreTarget) {
            return;
        }
        if (this.getInlineOnly()) {
            QuoteExp.nullExp.compile(comp, target);
            return;
        }
        final CodeAttr code = comp.getCode();
        final LambdaExp outer = this.outerLambda();
        final Type rtype = Compilation.typeModuleMethod;
        if ((this.flags & 0x100) != 0x0 || comp.dumpingInitializers || (comp.immediate && outer instanceof ModuleExp && comp.mainClass == comp.moduleClass)) {
            if (this.primMethods == null) {
                this.allocMethod(this.outerLambda(), comp);
            }
            this.compileAsMethod(comp);
            this.addApplyMethod(comp, null);
            final Variable savedInstance = comp.moduleInstanceVar;
            comp.moduleInstanceVar = null;
            ProcInitializer.emitLoadModuleMethod(this, comp);
            comp.moduleInstanceVar = savedInstance;
        }
        else {
            final Field field = this.compileSetField(comp);
            if (field.getStaticFlag()) {
                code.emitGetStatic(field);
            }
            else {
                LambdaExp parent;
                for (parent = comp.curLambda; parent.getInlineOnly() && parent.heapFrame == null; parent = parent.outerLambda()) {}
                final Variable frame = (parent.heapFrame != null) ? parent.heapFrame : parent.closureEnv;
                code.emitLoad(frame);
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
        for (ScopeExp exp = this.getOuter(); exp != null; exp = exp.getOuter()) {
            if (exp instanceof ModuleExp || (exp instanceof ClassExp && this.getNeedsClosureEnv()) || (exp instanceof LambdaExp && ((LambdaExp)exp).heapFrame != null)) {
                return (LambdaExp)exp;
            }
        }
        return null;
    }
    
    void addMethodFor(final Compilation comp, final ObjectType closureEnvType) {
        ScopeExp sc;
        for (sc = this; sc != null && !(sc instanceof ClassExp); sc = sc.getOuter()) {}
        ClassType ctype;
        if (sc != null) {
            ctype = ((ClassExp)sc).instanceType;
        }
        else {
            ctype = this.getOwningLambda().getHeapFrameType();
        }
        this.addMethodFor(ctype, comp, closureEnvType);
    }
    
    void addMethodFor(final ClassType ctype, final Compilation comp, final ObjectType closureEnvType) {
        String name = this.getName();
        final LambdaExp outer = this.outerLambda();
        final int key_args = (this.keywords == null) ? 0 : this.keywords.length;
        final int numStubs = ((this.flags & 0x200) != 0x0) ? 0 : this.opt_args;
        final boolean varArgs = this.max_args < 0 || this.min_args + numStubs < this.max_args;
        final Method[] methods = new Method[numStubs + 1];
        this.primBodyMethods = methods;
        if (this.primMethods == null) {
            this.primMethods = methods;
        }
        char isInitMethod = '\0';
        boolean isStatic;
        if (this.nameDecl != null && this.nameDecl.getFlag(4096L)) {
            isStatic = false;
        }
        else if (this.nameDecl != null && this.nameDecl.getFlag(2048L)) {
            isStatic = true;
        }
        else if (this.isClassMethod()) {
            if (outer instanceof ClassExp) {
                final ClassExp cl = (ClassExp)outer;
                isStatic = (cl.isMakingClassPair() && closureEnvType != null);
                if (this == cl.initMethod) {
                    isInitMethod = 'I';
                }
                else if (this == cl.clinitMethod) {
                    isInitMethod = 'C';
                    isStatic = true;
                }
            }
            else {
                isStatic = false;
            }
        }
        else if (this.thisVariable != null || closureEnvType == ctype) {
            isStatic = false;
        }
        else if (this.nameDecl != null && this.nameDecl.context instanceof ModuleExp) {
            final ModuleExp mexp = (ModuleExp)this.nameDecl.context;
            isStatic = (mexp.getSuperType() == null && mexp.getInterfaces() == null);
        }
        else {
            isStatic = true;
        }
        final StringBuffer nameBuf = new StringBuffer(60);
        int mflags = isStatic ? 8 : 0;
        if (this.nameDecl != null) {
            if (this.nameDecl.needsExternalAccess()) {
                mflags |= 0x1;
            }
            else {
                short defaultFlag = (short)(this.nameDecl.isPrivate() ? 0 : 1);
                if (this.isClassMethod()) {
                    defaultFlag = this.nameDecl.getAccessFlags(defaultFlag);
                }
                mflags |= defaultFlag;
            }
        }
        if (this.getFlag(16384)) {
            mflags |= 0x1;
        }
        if ((!outer.isModuleBody() && !(outer instanceof ClassExp)) || name == null) {
            nameBuf.append("lambda");
            nameBuf.append(++comp.method_counter);
        }
        if (isInitMethod == 'C') {
            nameBuf.append("<clinit>");
        }
        else if (this.getSymbol() != null) {
            nameBuf.append(Mangling.mangleName(name));
        }
        if (this.getFlag(1024)) {
            nameBuf.append("$C");
        }
        final boolean withContext = this.getCallConvention() >= 2 && isInitMethod == '\0';
        if (isInitMethod != '\0') {
            if (isStatic) {
                mflags = (mflags & 0xFFFFFFFD) + 1;
            }
            else {
                mflags = (mflags & 0x2) + 2;
            }
        }
        if (ctype.isInterface() || this.isAbstract()) {
            mflags |= 0x400;
        }
        if (this.isNative()) {
            mflags |= 0x100;
        }
        Label_0855: {
            if (this.isClassMethod() && outer instanceof ClassExp && this.min_args == this.max_args) {
                Method[] inherited = null;
                int iarg = 0;
                Declaration param = this.firstDecl();
                while (true) {
                    Label_0842: {
                        if (param == null) {
                            if (this.returnType != null) {
                                break;
                            }
                        }
                        else {
                            if (param.isThisParameter()) {
                                --iarg;
                                break Label_0842;
                            }
                            if (param.getFlag(8192L)) {
                                break Label_0842;
                            }
                        }
                        if (inherited == null) {
                            final String mangled = nameBuf.toString();
                            final Filter filter = new Filter() {
                                @Override
                                public boolean select(final Object value) {
                                    final Method method = (Method)value;
                                    if (!method.getName().equals(mangled)) {
                                        return false;
                                    }
                                    final Type[] ptypes = method.getParameterTypes();
                                    return ptypes.length == LambdaExp.this.min_args;
                                }
                            };
                            inherited = ctype.getMethods(filter, 2);
                        }
                        Type type = null;
                        int i = inherited.length;
                        while (--i >= 0) {
                            final Method method = inherited[i];
                            final Type ptype = (param == null) ? method.getReturnType() : method.getParameterTypes()[iarg];
                            if (type == null) {
                                type = ptype;
                            }
                            else {
                                if (ptype == type) {
                                    continue;
                                }
                                if (param == null) {
                                    break Label_0855;
                                }
                                break Label_0842;
                            }
                        }
                        if (type != null) {
                            if (param != null) {
                                param.setType(type);
                            }
                            else {
                                this.setCoercedReturnType(type);
                            }
                        }
                        if (param == null) {
                            break;
                        }
                    }
                    param = param.nextDecl();
                    ++iarg;
                }
            }
        }
        final Type rtype = (this.getFlag(1024) || this.getCallConvention() >= 2) ? Type.voidType : this.getReturnType().promoteIfUnsigned().getImplementationType();
        final int extraArg = (closureEnvType != null && closureEnvType != ctype) ? 1 : 0;
        final String rtypeEnc = comp.getLanguage().encodeType(this.getReturnType());
        int ctxArg = 0;
        if (this.getCallConvention() >= 2 && isInitMethod == '\0') {
            ctxArg = 1;
        }
        final int nameBaseLength = nameBuf.length();
        for (int j = 0; j <= numStubs; ++j) {
            nameBuf.setLength(nameBaseLength);
            int numArgs;
            final int plainArgs = numArgs = this.min_args + j;
            if (j == numStubs && varArgs) {
                ++numArgs;
            }
            final Type[] atypes = new Type[extraArg + numArgs + ctxArg];
            if (extraArg > 0) {
                atypes[0] = closureEnvType;
            }
            final Stack<String> encTypes = new Stack<String>();
            int encTypesSize = (rtypeEnc != null) ? 1 : 0;
            encTypes.add((encTypesSize == 0) ? "" : rtypeEnc);
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
                }
                else {
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
                final String lastTypeName = lastType.getName();
                if (ctype.getClassfileVersion() >= 3211264 && lastType instanceof ArrayType) {
                    mflags |= 0x80;
                }
                else {
                    nameBuf.append("$V");
                }
                String encType2 = comp.getLanguage().encodeType(var.getType());
                if (encType2 == null) {
                    encType2 = "";
                }
                else {
                    encTypesSize = encTypes.size() + 1;
                }
                encTypes.add(encType2);
                if (key_args > 0 || numStubs < this.opt_args || (!"gnu.lists.LList".equals(lastTypeName) && !(lastType instanceof ArrayType))) {
                    lastType = Compilation.objArrayType;
                    (this.argsArray = new Variable("argsArray", Compilation.objArrayType)).setParameter(true);
                }
                this.firstArgsArrayArg = var;
                atypes[atypes.length - (withContext ? 2 : 1)] = lastType;
            }
            if (withContext) {
                nameBuf.append("$X");
            }
            final boolean classSpecified = outer instanceof ClassExp || (outer instanceof ModuleExp && ((ModuleExp)outer).getFlag(262144));
            name = nameBuf.toString();
            int renameCount = 0;
            final int len = nameBuf.length();
            final String suffix = nameBuf.substring(nameBaseLength, len);
        Label_1444:
            while (true) {
                for (ClassType t = ctype; t != null; t = t.getSuperclass()) {
                    if (t.getDeclaredMethod(name, atypes) != null) {
                        nameBuf.setLength(nameBaseLength);
                        nameBuf.append('$');
                        nameBuf.append(++renameCount);
                        nameBuf.append(suffix);
                        name = nameBuf.toString();
                        continue Label_1444;
                    }
                    if (classSpecified) {
                        break;
                    }
                }
                break;
            }
            final Method method2 = ctype.addMethod(name, atypes, rtype, mflags);
            if (encTypesSize > 0 && (this.nameDecl == null || this.nameDecl.getAnnotation(SourceMethodType.class) == null)) {
                final AnnotationEntry ae = new AnnotationEntry(ClassType.make("kawa.SourceMethodType"));
                while (encTypes.size() > encTypesSize) {
                    encTypes.pop();
                }
                ae.addMember("value", encTypes, ArrayType.make(Type.javalangStringType));
                RuntimeAnnotationsAttr.maybeAddAnnotation(method2, ae);
            }
            methods[j] = method2;
            if (this.throwsSpecification != null && this.throwsSpecification.length > 0) {
                final int n = this.throwsSpecification.length;
                final ClassType[] exceptions = new ClassType[n];
                for (int k = 0; k < n; ++k) {
                    ClassType exception = null;
                    final Expression throwsExpr = this.throwsSpecification[k];
                    String msg = null;
                    if (throwsExpr instanceof ReferenceExp) {
                        final ReferenceExp throwsRef = (ReferenceExp)throwsExpr;
                        final Declaration decl = throwsRef.getBinding();
                        if (decl != null) {
                            final Expression declValue = decl.getValue();
                            if (declValue instanceof ClassExp) {
                                exception = ((ClassExp)declValue).getCompiledClassType(comp);
                            }
                            else {
                                msg = "throws specification " + decl.getName() + " has non-class lexical binding";
                            }
                        }
                        else {
                            msg = "unknown class " + throwsRef.getName();
                        }
                    }
                    else if (throwsExpr instanceof QuoteExp) {
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
                    exceptions[k] = exception;
                }
                final ExceptionsAttr attr = new ExceptionsAttr(method2);
                attr.setExceptions(exceptions);
            }
        }
    }
    
    public void allocChildClasses(final Compilation comp) {
        final Method main = this.getMainMethod();
        if (main != null && !main.getStaticFlag()) {
            final CodeAttr code = comp.getCode();
            this.scope = code.getCurrentScope();
            this.declareThis(main.getDeclaringClass());
            this.thisVariable.allocateLocal(code);
            this.scope = null;
        }
        Declaration decl = this.firstDecl();
        while (true) {
            if (decl == this.firstArgsArrayArg && this.argsArray != null) {
                this.getVarScope().addVariable(this.argsArray);
            }
            Label_0162: {
                if (!this.getInlineOnly() && this.getCallConvention() >= 2) {
                    if (this.firstArgsArrayArg == null) {
                        if (decl != null) {
                            break Label_0162;
                        }
                    }
                    else if (this.argsArray != null) {
                        if (decl != this.firstArgsArrayArg) {
                            break Label_0162;
                        }
                    }
                    else if (decl != this.firstArgsArrayArg.nextDecl()) {
                        break Label_0162;
                    }
                    final Variable var = this.getVarScope().addVariable(null, Compilation.typeCallContext, "$ctx");
                    var.setParameter(true);
                }
            }
            if (decl == null) {
                break;
            }
            Variable var = decl.var;
            if (var == null && (!this.getInlineOnly() || !decl.ignorable())) {
                if (decl.parameterForMethod()) {
                    if (decl.isSimple() && !decl.isIndirectBinding()) {
                        var = decl.allocateVariable(null);
                    }
                    else {
                        final String vname = Mangling.mangleName(decl.getName()).intern();
                        final Type vtype = decl.getType().getImplementationType();
                        final Declaration declaration = decl;
                        final Variable addVariable = this.getVarScope().addVariable(null, vtype, vname);
                        declaration.var = addVariable;
                        var = addVariable;
                        var.setParameter(true);
                    }
                }
            }
            decl = decl.nextDecl();
        }
        this.declareClosureEnv();
        this.allocFrame(comp);
        this.allocChildMethods(comp);
    }
    
    void allocMethod(final LambdaExp outer, final Compilation comp) {
        if (this.currentModule().info != null) {
            final int state = this.currentModule().info.getState();
            if (state >= 14 && state != 100) {
                comp.error('f', "internal error - allocate method for " + this + " in module " + this.currentModule() + " that has already been compiled\n(Try removing all class files and doing a full re-compile.)");
            }
        }
        ObjectType closureEnvType;
        if (!this.getNeedsClosureEnv()) {
            closureEnvType = null;
        }
        else if (outer.isClassGenerated()) {
            closureEnvType = outer.getCompiledClassType(comp);
        }
        else {
            LambdaExp owner;
            for (owner = outer; owner.heapFrame == null; owner = owner.outerLambda()) {}
            closureEnvType = (ClassType)owner.heapFrame.getType();
        }
        this.addMethodFor(comp, closureEnvType);
    }
    
    public void pushChild(final LambdaExp child) {
        child.nextSibling = this.firstChild;
        this.firstChild = child;
    }
    
    public void reverseChildList() {
        LambdaExp prev = null;
        LambdaExp next;
        for (LambdaExp child = this.firstChild; child != null; child = next) {
            next = child.nextSibling;
            child.nextSibling = prev;
            prev = child;
        }
        this.firstChild = prev;
    }
    
    void allocChildMethods(final Compilation comp) {
        for (LambdaExp child = this.firstChild; child != null; child = child.nextSibling) {
            if (child instanceof ClassExp) {
                final ClassExp cl = (ClassExp)child;
                if (cl.getNeedsClosureEnv()) {
                    ClassType parentFrameType;
                    if (this.isClassGenerated()) {
                        parentFrameType = (ClassType)this.getType();
                    }
                    else {
                        final Variable parentFrame = (this.heapFrame != null) ? this.heapFrame : this.closureEnv;
                        parentFrameType = (ClassType)parentFrame.getType();
                    }
                    final ClassExp classExp = cl;
                    final ClassExp classExp2 = cl;
                    final Field setOuterLink = cl.instanceType.setOuterLink(parentFrameType);
                    classExp2.staticLinkField = setOuterLink;
                    classExp.closureEnvField = setOuterLink;
                }
            }
        }
    }
    
    public void allocFrame(final Compilation comp) {
        if (this.heapFrame != null) {
            ClassType frameType;
            if (this.isClassGenerated()) {
                frameType = this.getCompiledClassType(comp);
            }
            else {
                frameType = new ClassType(comp.generateClassName("frame"));
                frameType.setSuper(comp.getModuleType());
                comp.addClass(frameType);
            }
            this.heapFrame.setType(frameType);
        }
    }
    
    void allocParameters(final Compilation comp) {
        final CodeAttr code = comp.getCode();
        final Scope sc = this.getVarScope();
        code.locals.enterScope(sc);
        final int line = this.getLineNumber();
        if (line > 0) {
            code.putLineNumber(this.getFileName(), line);
        }
    }
    
    void enterFunction(final Compilation comp) {
        final CodeAttr code = comp.getCode();
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
            }
            else if (!this.inlinedIn(this.outerLambda())) {
                this.outerLambdaOrCaller().loadHeapFrame(comp);
                code.emitStore(this.closureEnv);
            }
        }
        if (!comp.usingCPStyle()) {
            final ClassType frameType = (ClassType)((this.heapFrame == null) ? this.currentModule().getCompiledClassType(comp) : this.heapFrame.getType());
            for (Declaration decl = this.capturedVars; decl != null; decl = decl.nextCapturedVar) {
                if (decl.field == null) {
                    decl.makeField(frameType, comp, null);
                }
            }
        }
        if (this.heapFrame != null && !comp.usingCPStyle()) {
            final ClassType frameType = (ClassType)this.heapFrame.getType();
            if (this.closureEnv != null && !(this instanceof ModuleExp)) {
                this.staticLinkField = frameType.addField("staticLink", this.closureEnv.getType());
            }
            if (!this.isClassGenerated()) {
                frameType.setEnclosingMember(comp.method);
                code.emitNew(frameType);
                code.emitDup(frameType);
                final Method constructor = Compilation.getConstructor(frameType, this);
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
        Declaration param = this.firstDecl();
        int i = (param != null && param.isThisParameter()) ? -1 : 0;
        int key_i = 0;
        final int key_args = (this.keywords == null) ? 0 : this.keywords.length;
        if (this instanceof ModuleExp) {
            return;
        }
        int plainArgs = -1;
        int defaultStart = 0;
        final Method mainMethod = this.getMainMethod();
        final Variable callContextSave = comp.callContextVar;
        while (param != null) {
            comp.callContextVar = ((this.getCallConvention() < 2) ? null : this.getVarScope().lookup("$ctx"));
            if (param == this.firstArgsArrayArg && argsArray != null) {
                if (this.primMethods != null) {
                    plainArgs = i;
                    defaultStart = plainArgs - this.min_args;
                }
                else {
                    plainArgs = 0;
                    defaultStart = 0;
                }
            }
            final boolean ignorable = param.ignorable();
            if (plainArgs >= 0 || !param.isSimple() || param.isIndirectBinding()) {
                final Type paramType = param.getType();
                Type stackType = (plainArgs >= 0) ? Type.objectType : paramType;
                if (!param.isSimple() && !ignorable) {
                    param.loadOwningObject(null, comp);
                }
                if (plainArgs < 0) {
                    if (!ignorable) {
                        code.emitLoad(param.getVariable());
                    }
                }
                else if (i < this.min_args) {
                    if (!ignorable) {
                        code.emitLoad(argsArray);
                        code.emitPushInt(i);
                        code.emitArrayLoad(Type.objectType);
                    }
                }
                else if (i < this.min_args + this.opt_args) {
                    final Expression defaultArg = param.getInitValue();
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
                        }
                        else {
                            defaultArg.compile(comp, paramType);
                        }
                        code.emitFi();
                    }
                }
                else if (this.max_args < 0 && i == this.min_args + this.opt_args) {
                    if (!ignorable) {
                        code.emitLoad(argsArray);
                        code.emitPushInt(i - plainArgs);
                        code.emitInvokeStatic(Compilation.makeListMethod);
                    }
                    stackType = Compilation.scmListType;
                }
                else {
                    final Keyword keyword = this.keywords[key_i++];
                    final Expression defaultArg2 = param.getInitValue();
                    if (!ignorable || !(defaultArg2 instanceof QuoteExp)) {
                        code.emitLoad(argsArray);
                        code.emitPushInt(this.min_args + this.opt_args - plainArgs);
                        comp.compileConstant(keyword);
                        final Type boxedParamType = (paramType instanceof PrimType) ? ((PrimType)paramType).boxedType() : paramType;
                        if (defaultArg2 instanceof QuoteExp) {
                            if (LambdaExp.searchForKeywordMethod4 == null) {
                                final Type[] argts = { Compilation.objArrayType, Type.intType, Type.objectType, Type.objectType };
                                LambdaExp.searchForKeywordMethod4 = Compilation.scmKeywordType.addMethod("searchForKeyword", argts, Type.objectType, 9);
                            }
                            defaultArg2.compile(comp, boxedParamType);
                            code.emitInvokeStatic(LambdaExp.searchForKeywordMethod4);
                        }
                        else {
                            if (LambdaExp.searchForKeywordMethod3 == null) {
                                final Type[] argts = { Compilation.objArrayType, Type.intType, Type.objectType };
                                LambdaExp.searchForKeywordMethod3 = Compilation.scmKeywordType.addMethod("searchForKeyword", argts, Type.objectType, 9);
                            }
                            code.emitInvokeStatic(LambdaExp.searchForKeywordMethod3);
                            if (!ignorable) {
                                code.emitDup(1);
                            }
                            comp.compileConstant(Special.dfault);
                            code.emitIfEq();
                            if (ignorable) {
                                defaultArg2.compile(comp, Target.Ignore);
                            }
                            else {
                                code.emitPop(1);
                                defaultArg2.compile(comp, boxedParamType);
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
                        final Variable var = param.getVariable();
                        if (param.isIndirectBinding()) {
                            var.setType(Compilation.typeLocation);
                        }
                        code.emitStore(var);
                    }
                    else {
                        code.emitPutField(param.field);
                    }
                }
            }
            param = param.nextDecl();
            ++i;
        }
        comp.callContextVar = callContextSave;
    }
    
    void compileAsInlined(final Compilation comp, final Target target) {
        this.flags |= 0x80;
        final LambdaExp saveLambda = comp.curLambda;
        (comp.curLambda = this).allocChildClasses(comp);
        this.allocParameters(comp);
        final CodeAttr code = comp.getCode();
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
    
    void compileAsMethod(final Compilation comp) {
        if ((this.flags & 0x80) != 0x0 || this.isAbstract() || this.isNative()) {
            return;
        }
        this.flags |= 0x80;
        if (this.primMethods == null) {
            this.allocMethod(this.outerLambda(), comp);
        }
        final Method save_method = comp.method;
        final LambdaExp save_lambda = comp.curLambda;
        comp.curLambda = this;
        final Method method = this.primMethods[0];
        final boolean isStatic = method.getStaticFlag();
        final int numStubs = this.primMethods.length - 1;
        final Type restArgType = this.restArgType();
        long[] saveDeclFlags = null;
        if (numStubs > 0) {
            saveDeclFlags = new long[this.min_args + numStubs];
            int k = 0;
            for (Declaration decl = this.firstDecl(); k < this.min_args + numStubs; saveDeclFlags[k++] = decl.flags, decl = decl.nextDecl()) {}
        }
        final boolean ctxArg = this.getCallConvention() >= 2;
        for (int i = 0; i <= numStubs; ++i) {
            comp.method = this.primMethods[i];
            if (this.nameDecl != null && !this.isClassMethod()) {
                this.nameDecl.compileAnnotations(comp.method, ElementType.METHOD);
            }
            if (i < numStubs) {
                final CodeAttr code = comp.method.startCode();
                final Variable callContextSave = comp.callContextVar;
                Variable var = code.getArg(0);
                if (!isStatic) {
                    code.emitPushThis();
                    if (this.getNeedsClosureEnv()) {
                        this.closureEnv = var;
                    }
                    var = code.getArg(1);
                }
                Declaration decl2 = this.firstDecl();
                for (int j = 0; j < this.min_args + i; ++j, decl2 = decl2.nextDecl()) {
                    final Declaration declaration = decl2;
                    declaration.flags |= 0x40L;
                    code.emitLoad(decl2.var = var);
                    var = var.nextVar();
                }
                comp.callContextVar = (ctxArg ? var : null);
                int toCall = i + 1;
                for (int l = i; l < toCall; ++l) {
                    final Target paramTarget = StackTarget.getInstance(decl2.getType());
                    final Expression defaultArg = decl2.getInitValue();
                    defaultArg.compile(comp, paramTarget);
                    decl2 = decl2.nextDecl();
                    if (toCall < numStubs && decl2.getInitValue() instanceof QuoteExp) {
                        ++toCall;
                    }
                }
                final boolean varArgs = toCall == numStubs && restArgType != null;
                if (varArgs) {
                    final String lastTypeName = restArgType.getName();
                    Expression arg;
                    if ("gnu.lists.LList".equals(lastTypeName)) {
                        arg = QuoteExp.emptyExp;
                    }
                    else {
                        if (!"java.lang.Object[]".equals(lastTypeName)) {
                            throw new Error("unimplemented #!rest type " + lastTypeName);
                        }
                        arg = new QuoteExp(Values.noArgs);
                    }
                    arg.compile(comp, restArgType);
                }
                if (ctxArg) {
                    code.emitLoad(var);
                }
                if (isStatic) {
                    code.emitInvokeStatic(this.primMethods[toCall]);
                }
                else {
                    code.emitInvokeVirtual(this.primMethods[toCall]);
                }
                code.emitReturn();
                this.closureEnv = null;
                comp.callContextVar = callContextSave;
            }
            else {
                if (saveDeclFlags != null) {
                    int m = 0;
                    for (Declaration decl2 = this.firstDecl(); m < this.min_args + numStubs; decl2.flags = saveDeclFlags[m++], decl2.var = null, decl2 = decl2.nextDecl()) {}
                }
                comp.method.initCode();
                this.allocChildClasses(comp);
                this.allocParameters(comp);
                this.enterFunction(comp);
                this.compileBody(comp);
                this.compileEnd(comp);
                this.generateApplyMethods(comp);
            }
        }
        comp.method = save_method;
        comp.curLambda = save_lambda;
    }
    
    public void compileBody(final Compilation comp) {
        final Variable callContextSave = comp.callContextVar;
        comp.callContextVar = null;
        Target target;
        if (this.getCallConvention() >= 2) {
            final Variable var = this.getVarScope().lookup("$ctx");
            if (var != null && var.getType() == Compilation.typeCallContext) {
                comp.callContextVar = var;
            }
            target = ConsumerTarget.makeContextTarget(comp, this.getReturnType());
        }
        else {
            target = Target.pushValue(this.getReturnType());
        }
        final ScopeExp savedScope = comp.currentScope();
        comp.current_scope = this;
        this.body.compileWithPosition(comp, target, (this.body.getLineNumber() > 0) ? this.body : this);
        comp.current_scope = savedScope;
        comp.callContextVar = callContextSave;
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        final Compilation comp = visitor.getCompilation();
        LambdaExp saveLambda;
        if (comp == null) {
            saveLambda = null;
        }
        else {
            saveLambda = comp.curLambda;
            comp.curLambda = this;
        }
        try {
            return visitor.visitLambdaExp(this, d);
        }
        finally {
            if (comp != null) {
                comp.curLambda = saveLambda;
            }
        }
    }
    
    @Override
    protected <R, D> void visitChildren(final ExpVisitor<R, D> visitor, final D d) {
        this.visitChildrenOnly((ExpVisitor<Object, Object>)visitor, d);
        this.visitProperties((ExpVisitor<Object, Object>)visitor, d);
    }
    
    protected final <R, D> void visitChildrenOnly(final ExpVisitor<R, D> visitor, final D d) {
        final LambdaExp save = visitor.currentLambda;
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
    
    protected final <R, D> void visitProperties(final ExpVisitor<R, D> visitor, final D d) {
        if (this.properties != null) {
            for (int len = this.properties.length, i = 1; i < len; i += 2) {
                final Object val = this.properties[i];
                if (val instanceof Expression) {
                    this.properties[i] = visitor.visitAndUpdate((Expression)val, d);
                }
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
                final Expression defaultArg = p.getInitValue();
                if (defaultArg != null && !(defaultArg instanceof QuoteExp)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        this.setIndexes();
        ctx.writeValue(new Closure(this, ctx));
    }
    
    Object evalDefaultArg(final Declaration param, final CallContext ctx) {
        try {
            return param.getInitValue().eval(ctx);
        }
        catch (Error ex) {
            throw ex;
        }
        catch (Throwable ex2) {
            throw new WrappedException("error evaluating default argument", ex2);
        }
    }
    
    @Override
    public Expression validateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Declaration decl) {
        final Expression[] args = exp.getArgs();
        if (exp.firstSpliceArg >= 0) {
            this.setCanRead(true);
            if (this.nameDecl != null) {
                this.nameDecl.setCanRead(true);
            }
        }
        if ((this.flags & 0x1000) != 0x0) {
            final Expression inlined = InlineCalls.inlineCall(this, args, true);
            if (inlined != null) {
                return visitor.visit(inlined, required);
            }
        }
        exp.visitArgs(visitor, this);
        final int args_length = exp.args.length;
        final int spliceCount = exp.spliceCount();
        final int nonSpliceCount = args_length - spliceCount;
        final String msg = WrongArguments.checkArgCount(this.getName(), (spliceCount > 0) ? 0 : this.min_args, this.max_args, nonSpliceCount);
        if (msg != null) {
            return visitor.noteError(msg);
        }
        return exp;
    }
    
    @Override
    public void print(final OutPort out) {
        out.startLogicalBlock("(Lambda/", ")", 2);
        final Object sym = this.getSymbol();
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
        final int key_args = (this.keywords == null) ? 0 : this.keywords.length;
        Declaration decl = this.firstDecl();
        if (decl != null && decl.isThisParameter()) {
            i = -1;
        }
        while (decl != null) {
            Special mode;
            if (i < this.min_args || (i == this.min_args && decl.getFlag(1099511627776L))) {
                mode = null;
            }
            else if (i < this.min_args + this.opt_args) {
                mode = Special.optional;
            }
            else if (this.max_args < 0 && i == this.min_args + this.opt_args) {
                mode = Special.rest;
            }
            else {
                mode = Special.key;
            }
            if (decl != this.firstDecl()) {
                out.writeSpaceFill();
            }
            if (mode != prevMode) {
                out.print(mode);
                out.writeSpaceFill();
            }
            final Expression defaultArg = decl.getInitValue();
            if (defaultArg != null) {
                out.print('(');
            }
            decl.printInfo(out);
            if (defaultArg != null && defaultArg != QuoteExp.falseExp) {
                out.print(' ');
                defaultArg.print(out);
                out.print(')');
            }
            if (decl.getFlag(8796093022208L)) {
                ++i;
            }
            prevMode = mode;
            decl = decl.nextDecl();
        }
        out.endLogicalBlock(")");
        if (this.properties != null) {
            for (int plen = this.properties.length, j = 0; j < plen; j += 2) {
                final Object key = this.properties[j];
                if (key != null) {
                    out.writeSpaceFill();
                    out.startLogicalBlock("", false, "");
                    out.print(key);
                    out.print(":");
                    out.writeSpaceFill();
                    out.print(this.properties[j + 1]);
                    out.endLogicalBlock("");
                }
            }
        }
        out.writeSpaceLinear();
        if (this.body == null) {
            out.print("<null body>");
        }
        else {
            this.body.print(out);
        }
        out.endLogicalBlock(")");
    }
    
    protected final String getExpClassName() {
        String cname = this.getClass().getName();
        final int index = cname.lastIndexOf(46);
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
    public Object getProperty(final Object key, final Object defaultValue) {
        if (this.properties != null) {
            int i = this.properties.length;
            do {
                i -= 2;
                if (i >= 0) {
                    continue;
                }
                return defaultValue;
            } while (this.properties[i] != key);
            return this.properties[i + 1];
        }
        return defaultValue;
    }
    
    @Override
    public synchronized void setProperty(final Object key, final Object value) {
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
    
    public final void setReturnType(final Type returnType) {
        this.returnType = returnType;
    }
    
    public final void setCoercedReturnType(final Type returnType) {
        this.returnType = returnType;
        if (returnType != null && returnType != Type.objectType && returnType != Type.voidType && this.body != QuoteExp.abstractExp && this.body != QuoteExp.nativeExp) {
            final Expression value = this.body;
            (this.body = Compilation.makeCoercion(value, returnType)).setLine(value);
        }
    }
    
    public static void maybeSetReturnType(final LambdaExp lexp, final Type type) {
        if (lexp.returnType == null && type != null && !(type instanceof InlineCalls.LenientExpectedType) && !(type instanceof InlineCalls.ValueNeededType)) {
            lexp.setCoercedReturnType(type);
        }
    }
    
    public final void setCoercedReturnValue(final Expression type, final Language language) {
        if (!this.isAbstract() && !this.isNative()) {
            final Expression value = this.body;
            (this.body = Compilation.makeCoercion(value, type)).setLine(value);
        }
        final Type rtype = language.getTypeFor(type);
        if (rtype != null) {
            this.setReturnType(rtype);
        }
    }
    
    public Expression getBodyFirstExpression() {
        Expression bodyFirst = this.body;
        while (true) {
            if (bodyFirst instanceof BeginExp) {
                final BeginExp bbody = (BeginExp)bodyFirst;
                if (bbody.length == 0) {
                    bodyFirst = null;
                }
                else {
                    bodyFirst = bbody.exps[0];
                }
            }
            else {
                if (!(bodyFirst instanceof LetExp)) {
                    break;
                }
                bodyFirst = ((LetExp)bodyFirst).getBody();
            }
        }
        return bodyFirst;
    }
    
    public ClassType checkForInitCall(final Expression bodyFirst) {
        ClassType calledInit = null;
        if (bodyFirst instanceof ApplyExp) {
            final Expression exp = ((ApplyExp)bodyFirst).func;
            if (exp instanceof QuoteExp) {
                final Object value = ((QuoteExp)exp).getValue();
                if (value instanceof PrimProcedure) {
                    final PrimProcedure pproc = (PrimProcedure)value;
                    final Method meth = pproc.getMethod();
                    if (pproc.isSpecial() && "<init>".equals(meth.getName())) {
                        calledInit = meth.getDeclaringClass();
                    }
                }
            }
        }
        return calledInit;
    }
    
    static {
        unknownContinuation = new ApplyExp((Expression)null, (Expression[])null);
    }
    
    static class Closure extends MethodProc
    {
        Object[][] evalFrames;
        LambdaExp lambda;
        
        @Override
        public int numArgs() {
            return this.lambda.min_args | this.lambda.max_args << 12;
        }
        
        public Closure(final LambdaExp lexp, final CallContext ctx) {
            this.lambda = lexp;
            final Object[][] oldFrames = ctx.evalFrames;
            if (oldFrames != null) {
                int n;
                for (n = oldFrames.length; n > 0 && oldFrames[n - 1] == null; --n) {}
                System.arraycopy(oldFrames, 0, this.evalFrames = new Object[n][], 0, n);
            }
            this.setSymbol(this.lambda.getSymbol());
        }
        
        @Override
        public int match0(final CallContext ctx) {
            return this.matchN(new Object[0], ctx);
        }
        
        @Override
        public int match1(final Object arg1, final CallContext ctx) {
            return this.matchN(new Object[] { arg1 }, ctx);
        }
        
        @Override
        public int match2(final Object arg1, final Object arg2, final CallContext ctx) {
            return this.matchN(new Object[] { arg1, arg2 }, ctx);
        }
        
        @Override
        public int match3(final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
            return this.matchN(new Object[] { arg1, arg2, arg3 }, ctx);
        }
        
        @Override
        public int match4(final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
            return this.matchN(new Object[] { arg1, arg2, arg3, arg4 }, ctx);
        }
        
        @Override
        public int matchN(final Object[] args, final CallContext ctx) {
            final int num = this.numArgs();
            final int nargs = args.length;
            final int min = num & 0xFFF;
            if (nargs < min) {
                return 0xFFF10000 | min;
            }
            final int max = num >> 12;
            if (nargs > max && max >= 0) {
                return 0xFFF20000 | max;
            }
            final Object[] evalFrame = new Object[this.lambda.frameSize];
            final int key_args = (this.lambda.keywords == null) ? 0 : this.lambda.keywords.length;
            final int opt_args = this.lambda.opt_args;
            int i = 0;
            int key_i = 0;
            final int min_args = this.lambda.min_args;
            for (Declaration decl = this.lambda.firstDecl(); decl != null; decl = decl.nextDecl()) {
                Object value;
                if (i < min_args) {
                    value = args[i++];
                }
                else if (i < min_args + opt_args) {
                    if (i < nargs) {
                        value = args[i++];
                    }
                    else {
                        value = this.lambda.evalDefaultArg(decl, ctx);
                    }
                }
                else if (this.lambda.max_args < 0 && i == min_args + opt_args) {
                    if (decl.type instanceof ArrayType) {
                        final int rem = nargs - i;
                        final Type elementType = ((ArrayType)decl.type).getComponentType();
                        if (elementType == Type.objectType) {
                            final Object[] rest = new Object[rem];
                            System.arraycopy(args, i, rest, 0, rem);
                            value = rest;
                        }
                        else {
                            final Class elementClass = elementType.getReflectClass();
                            value = Array.newInstance(elementClass, rem);
                            for (int j = 0; j < rem; ++j) {
                                Object el;
                                try {
                                    el = elementType.coerceFromObject(args[i + j]);
                                }
                                catch (ClassCastException ex) {
                                    return 0xFFF40000 | i + j;
                                }
                                Array.set(value, j, el);
                            }
                        }
                    }
                    else {
                        value = LList.makeList(args, i);
                    }
                }
                else {
                    final Keyword keyword = this.lambda.keywords[key_i++];
                    final int key_offset = min_args + opt_args;
                    value = Keyword.searchForKeyword(args, key_offset, keyword);
                    if (value == Special.dfault) {
                        value = this.lambda.evalDefaultArg(decl, ctx);
                    }
                }
                if (decl.type != null) {
                    try {
                        value = decl.type.coerceFromObject(value);
                    }
                    catch (ClassCastException ex2) {
                        return 0xFFF40000 | i;
                    }
                }
                if (decl.isIndirectBinding()) {
                    final Location loc = decl.makeIndirectLocationFor();
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
        
        @Override
        public void apply(final CallContext ctx) throws Throwable {
            final int level = ScopeExp.nesting(this.lambda);
            final Object[] evalFrame = ctx.values;
            final Object[][] saveFrames = ctx.evalFrames;
            int numFrames = (this.evalFrames == null) ? 0 : this.evalFrames.length;
            if (level >= numFrames) {
                numFrames = level;
            }
            numFrames += 10;
            final Object[][] newFrames = new Object[numFrames][];
            if (this.evalFrames != null) {
                System.arraycopy(this.evalFrames, 0, newFrames, 0, this.evalFrames.length);
            }
            newFrames[level] = evalFrame;
            ctx.evalFrames = newFrames;
            try {
                if (this.lambda.body == null) {
                    final StringBuffer sbuf = new StringBuffer("procedure ");
                    String name = this.lambda.getName();
                    if (name == null) {
                        name = "<anonymous>";
                    }
                    sbuf.append(name);
                    final int line = this.lambda.getLineNumber();
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
        public Object getProperty(final Object key, final Object defaultValue) {
            Object value = super.getProperty(key, defaultValue);
            if (value == null) {
                value = this.lambda.getProperty(key, defaultValue);
            }
            return value;
        }
    }
}
