// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import java.io.PrintWriter;
import java.net.URL;
import java.io.InputStream;
import gnu.bytecode.ClassFileInput;
import gnu.bytecode.ClassTypeWriter;
import gnu.lists.Consumer;
import gnu.lists.ConsumerWriter;
import java.io.Writer;
import gnu.bytecode.Field;
import gnu.bytecode.TypeVariable;
import gnu.bytecode.Variable;
import gnu.mapping.Procedure;
import gnu.mapping.WrongArguments;
import gnu.bytecode.CodeAttr;
import gnu.kawa.reflect.CompileArrays;
import gnu.bytecode.ObjectType;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.functions.MakeList;
import kawa.SourceMethodType;
import gnu.bytecode.ParameterizedType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;
import gnu.bytecode.PrimType;
import java.lang.reflect.Array;
import gnu.lists.LList;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.ProcedureN;
import gnu.mapping.CallContext;
import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import java.lang.reflect.Member;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.mapping.MethodProc;

public class PrimProcedure extends MethodProc
{
    private Type retType;
    private Type[] argTypes;
    private Method method;
    private Method methodForInvoke;
    private int op_code;
    private char mode;
    private boolean sideEffectFree;
    private boolean doFixUnsigned;
    private LambdaExp source;
    private Member member;
    public static boolean explicitArrayAsVarArgsAllowed;
    private static ClassLoader systemClassLoader;
    
    public final int opcode() {
        return this.op_code;
    }
    
    public Type getReturnType() {
        return this.retType;
    }
    
    public void setReturnType(final Type retType) {
        this.doFixUnsigned = true;
        this.retType = retType;
    }
    
    public boolean isSpecial() {
        return this.mode == 'P';
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return this.retType;
    }
    
    public ClassType getDeclaringClass() {
        return (this.methodForInvoke == null) ? null : this.methodForInvoke.getDeclaringClass();
    }
    
    public Method getMethod() {
        return this.method;
    }
    
    public void setMethodForInvoke(final Method m) {
        this.setOpcode(this.methodForInvoke = m);
    }
    
    @Override
    public boolean isSideEffectFree() {
        return this.sideEffectFree;
    }
    
    public void setSideEffectFree() {
        this.sideEffectFree = true;
    }
    
    public boolean takesVarArgs() {
        return takesVarArgs(this.method);
    }
    
    public static boolean takesVarArgs(final Method method) {
        if (method == null) {
            return false;
        }
        if ((method.getModifiers() & 0x80) != 0x0) {
            return true;
        }
        final String name = method.getName();
        return name.endsWith("$V") || name.endsWith("$V$X");
    }
    
    public boolean takesContext() {
        return this.method != null && takesContext(this.method);
    }
    
    public static boolean takesContext(final Method method) {
        return method.getName().endsWith("$X");
    }
    
    @Override
    public int isApplicable(final Type[] argTypes, final Type restType) {
        final int app = super.isApplicable(argTypes, restType);
        final int nargs = argTypes.length;
        if (PrimProcedure.explicitArrayAsVarArgsAllowed && app == -1 && this.method != null && restType == null && (this.method.getModifiers() & 0x80) != 0x0 && nargs > 0 && argTypes[nargs - 1] instanceof ArrayType) {
            final Type[] tmp = new Type[nargs];
            System.arraycopy(argTypes, 0, tmp, 0, nargs - 1);
            tmp[nargs - 1] = ((ArrayType)argTypes[nargs - 1]).getComponentType();
            return super.isApplicable(tmp, null);
        }
        return app;
    }
    
    public boolean isAbstract() {
        return this.method != null && (this.method.getModifiers() & 0x400) != 0x0;
    }
    
    public final boolean isConstructor() {
        return this.opcode() == 183 && this.mode != 'P';
    }
    
    public boolean takesTarget() {
        return this.mode != '\0';
    }
    
    @Override
    public int numArgs() {
        int num = this.argTypes.length;
        if (this.takesTarget()) {
            ++num;
        }
        if (this.takesContext()) {
            --num;
        }
        return this.takesVarArgs() ? (num - 1 - 4096) : (num + (num << 12));
    }
    
    @Override
    public int match0(final CallContext ctx) {
        return this.matchN(ProcedureN.noArgs, ctx);
    }
    
    @Override
    public int match1(final Object arg1, final CallContext ctx) {
        final Object[] args = { arg1 };
        return this.matchN(args, ctx);
    }
    
    @Override
    public int match2(final Object arg1, final Object arg2, final CallContext ctx) {
        final Object[] args = { arg1, arg2 };
        return this.matchN(args, ctx);
    }
    
    @Override
    public int match3(final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        final Object[] args = { arg1, arg2, arg3 };
        return this.matchN(args, ctx);
    }
    
    @Override
    public int match4(final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
        final Object[] args = { arg1, arg2, arg3, arg4 };
        return this.matchN(args, ctx);
    }
    
    @Override
    public int matchN(final Object[] args, final CallContext ctx) {
        int nargs = args.length;
        final boolean takesVarArgs = this.takesVarArgs();
        final int fixArgs = this.minArgs();
        if (nargs < fixArgs) {
            return 0xFFF10000 | fixArgs;
        }
        if (!takesVarArgs && nargs > fixArgs) {
            return 0xFFF20000 | fixArgs;
        }
        int paramCount = this.argTypes.length;
        Type elementType = null;
        Object restArray = null;
        final int extraCount = (this.takesTarget() || this.isConstructor()) ? 1 : 0;
        final boolean takesContext = this.takesContext();
        final Object[] rargs = new Object[paramCount];
        if (takesContext) {
            rargs[--paramCount] = ctx;
        }
        if (takesVarArgs) {
            final Type restType = this.argTypes[paramCount - 1];
            if (restType == Compilation.scmListType || restType == LangObjType.listType) {
                rargs[paramCount - 1] = LList.makeList(args, fixArgs);
                nargs = fixArgs;
                elementType = Type.objectType;
            }
            else {
                final ArrayType restArrayType = (ArrayType)restType;
                elementType = restArrayType.getComponentType();
                final Class elementClass = elementType.getReflectClass();
                restArray = Array.newInstance(elementClass, nargs - fixArgs);
                rargs[paramCount - 1] = restArray;
            }
        }
        Object extraArg = null;
        Label_0245: {
            if (this.isConstructor()) {
                extraArg = args[0];
            }
            else {
                if (extraCount != 0) {
                    try {
                        extraArg = this.getDeclaringClass().coerceFromObject(args[0]);
                        break Label_0245;
                    }
                    catch (ClassCastException ex) {
                        return -786431;
                    }
                }
                extraArg = null;
            }
        }
        for (int i = extraCount; i < args.length; ++i) {
            Object arg = args[i];
            final Type type = (i < fixArgs) ? this.argTypes[i - extraCount] : ((elementType == null) ? null : elementType);
            if (type != Type.objectType) {
                try {
                    arg = type.coerceFromObject(arg);
                }
                catch (ClassCastException ex2) {
                    return 0xFFF40000 | i + 1;
                }
            }
            if (i < fixArgs) {
                rargs[i - extraCount] = arg;
            }
            else if (restArray != null) {
                if (type instanceof PrimType) {
                    arg = ((PrimType)type).convertToRaw(arg);
                }
                Array.set(restArray, i - fixArgs, arg);
            }
        }
        ctx.value1 = extraArg;
        ctx.values = rargs;
        ctx.proc = this;
        return 0;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        final int arg_count = this.argTypes.length;
        final boolean is_constructor = this.isConstructor();
        final boolean slink = is_constructor && this.getDeclaringClass().hasOuterLink();
        try {
            if (this.member == null) {
                final Class clas = this.getDeclaringClass().getReflectClass();
                final Class[] paramTypes = new Class[arg_count + (slink ? 1 : 0)];
                int i = arg_count;
                while (--i >= 0) {
                    paramTypes[i + (slink ? 1 : 0)] = this.argTypes[i].getReflectClass();
                }
                if (slink) {
                    paramTypes[0] = this.getDeclaringClass().getOuterLinkType().getReflectClass();
                }
                if (is_constructor) {
                    this.member = clas.getConstructor((Class[])paramTypes);
                }
                else if (this.method != Type.clone_method) {
                    this.member = clas.getMethod(this.method.getName(), (Class[])paramTypes);
                }
            }
            Object result;
            if (is_constructor) {
                Object[] args = ctx.values;
                if (slink) {
                    final int nargs = args.length + 1;
                    final Object[] xargs = new Object[nargs];
                    System.arraycopy(args, 0, xargs, 1, nargs - 1);
                    xargs[0] = ((PairClassType)ctx.value1).staticLink;
                    args = xargs;
                }
                result = ((Constructor)this.member).newInstance(args);
            }
            else if (this.method == Type.clone_method) {
                final Object arr = ctx.value1;
                final Class elClass = arr.getClass().getComponentType();
                final int n = Array.getLength(arr);
                result = Array.newInstance(elClass, n);
                System.arraycopy(arr, 0, result, 0, n);
            }
            else {
                result = this.retType.coerceToObject(((java.lang.reflect.Method)this.member).invoke(ctx.value1, ctx.values));
            }
            if (!this.takesContext()) {
                ctx.consumer.writeObject(result);
            }
        }
        catch (InvocationTargetException ex) {
            throw ex.getTargetException();
        }
    }
    
    public PrimProcedure(final String className, final String methodName, final int numArgs) {
        this(ClassType.make(className).getDeclaredMethod(methodName, numArgs));
    }
    
    public PrimProcedure(final java.lang.reflect.Method method, final Language language) {
        this(((ClassType)language.getTypeFor(method.getDeclaringClass())).getMethod(method), language);
    }
    
    public PrimProcedure(final Method method) {
        this.init(method);
        this.retType = (method.getName().endsWith("$X") ? Type.objectType : method.getReturnType());
    }
    
    public PrimProcedure(final Method method, final Type retType, final Type[] argTypes) {
        this.init(method);
        this.retType = retType;
        if (argTypes != null) {
            this.argTypes = argTypes;
        }
    }
    
    public PrimProcedure(final Method method, final Language language) {
        this(method, '\0', language, null);
    }
    
    public PrimProcedure(final Method method, final char mode, final Language language, final ParameterizedType parameterizedType) {
        this.mode = mode;
        this.init(method);
        final Type[] pTypes = this.argTypes;
        final int nTypes = pTypes.length;
        this.argTypes = null;
        String[] annotTypes;
        try {
            final SourceMethodType sourceType = method.getAnnotation(SourceMethodType.class);
            annotTypes = (String[])((sourceType == null) ? null : sourceType.value());
        }
        catch (Throwable ex) {
            annotTypes = null;
        }
        int i = nTypes;
        while (--i >= 0) {
            final Type javaType = pTypes[i];
            final Type langType = decodeType(javaType, annotTypes, i + 1, parameterizedType, language);
            if (javaType != langType) {
                if (this.argTypes == null) {
                    System.arraycopy(pTypes, 0, this.argTypes = new Type[nTypes], 0, nTypes);
                }
                this.argTypes[i] = langType;
            }
        }
        if (this.argTypes == null) {
            this.argTypes = pTypes;
        }
        if (this.isConstructor()) {
            this.retType = this.getDeclaringClass();
        }
        else if (method.getName().endsWith("$X")) {
            this.retType = Type.objectType;
        }
        else {
            this.retType = decodeType(method.getReturnType(), annotTypes, 0, parameterizedType, language);
            if (this.retType == Type.toStringType) {
                this.retType = Type.javalangStringType;
            }
        }
    }
    
    public static Type decodeType(final Type javaType, final String[] annotTypes, final int annotIndex, final ParameterizedType parameterizedType, final Language lang) {
        final String annotType = (annotTypes != null && annotTypes.length > annotIndex) ? annotTypes[annotIndex] : null;
        return lang.decodeType(javaType, annotType, parameterizedType);
    }
    
    private void setOpcode(final Method m) {
        final int flags = m.getModifiers();
        if ((flags & 0x8) != 0x0) {
            this.op_code = 184;
        }
        else {
            final ClassType mclass = m.getDeclaringClass();
            if (this.mode == 'P') {
                this.op_code = 183;
            }
            else {
                this.mode = 'V';
                if ("<init>".equals(m.getName())) {
                    this.op_code = 183;
                }
                else if ((mclass.getModifiers() & 0x200) != 0x0) {
                    this.op_code = 185;
                }
                else {
                    this.op_code = 182;
                }
            }
        }
    }
    
    private void init(final Method method) {
        this.method = method;
        this.setOpcode(this.methodForInvoke = method);
        Type[] mtypes = method.getParameterTypes();
        if (this.isConstructor() && method.getDeclaringClass().hasOuterLink()) {
            final int len = mtypes.length - 1;
            final Type[] types = new Type[len];
            System.arraycopy(mtypes, 1, types, 0, len);
            mtypes = types;
        }
        this.argTypes = mtypes;
    }
    
    public PrimProcedure(final Method method, final LambdaExp source) {
        this(method);
        this.retType = source.getReturnType();
        this.source = source;
    }
    
    public PrimProcedure(final int opcode, final Type retType, final Type[] argTypes) {
        this.op_code = opcode;
        this.retType = retType;
        this.argTypes = argTypes;
    }
    
    public static PrimProcedure makeBuiltinUnary(final int opcode, final Type type) {
        final Type[] args = { type };
        return new PrimProcedure(opcode, type, args);
    }
    
    public static PrimProcedure makeBuiltinBinary(final int opcode, final Type type) {
        final Type[] args = { type, type };
        return new PrimProcedure(opcode, type, args);
    }
    
    public PrimProcedure(final int op_code, final ClassType classtype, final String name, final Type retType, final Type[] argTypes) {
        this.op_code = op_code;
        this.method = classtype.addMethod(name, (op_code == 184) ? 8 : 0, argTypes, retType);
        this.methodForInvoke = this.method;
        this.retType = retType;
        this.argTypes = argTypes;
        this.mode = ((op_code == 184) ? '\0' : 'V');
    }
    
    public final boolean getStaticFlag() {
        return this.method == null || this.method.getStaticFlag() || this.isConstructor();
    }
    
    public final Type[] getParameterTypes() {
        return this.argTypes;
    }
    
    private void compileArgs(final ApplyExp exp, final Expression[] args, final int startArg, final Type thisType, final Compilation comp) {
        boolean variable = this.takesVarArgs();
        final String name = this.getName();
        Type arg_type = null;
        final CodeAttr code = comp.getCode();
        final int skipArg = (thisType == Type.voidType) ? 1 : 0;
        int arg_count = this.argTypes.length - skipArg;
        if (this.takesContext()) {
            --arg_count;
        }
        final int nargs = args.length - startArg;
        final boolean is_static = thisType == null || skipArg != 0;
        boolean createVarargsArrayIfNeeded = false;
        if (PrimProcedure.explicitArrayAsVarArgsAllowed && variable && (this.method.getModifiers() & 0x80) != 0x0 && exp.firstSpliceArg < 0 && nargs > 0 && this.argTypes.length > 0 && nargs == arg_count + (is_static ? 0 : 1)) {
            final Type lastType = args[args.length - 1].getType();
            final Type lastParam = this.argTypes[this.argTypes.length - 1];
            if (lastParam.isCompatibleWithValue(lastType) >= 0) {
                if (lastParam instanceof ArrayType && ((ArrayType)lastParam).getComponentType().isCompatibleWithValue(lastType) >= 0) {
                    createVarargsArrayIfNeeded = true;
                }
                variable = false;
            }
        }
        final int fix_arg_count = variable ? (arg_count - (is_static ? 1 : 0)) : (args.length - startArg);
        Declaration argDecl = (this.source == null) ? null : this.source.firstDecl();
        if (argDecl != null && argDecl.isThisParameter()) {
            argDecl = argDecl.nextDecl();
        }
        int i;
        for (i = 0; !variable || i != fix_arg_count; ++i) {
            if (i >= nargs) {
                return;
            }
            final boolean createVarargsNow = createVarargsArrayIfNeeded && i + 1 == nargs;
            if (i >= fix_arg_count) {
                code.emitDup(1);
                code.emitPushInt(i - fix_arg_count);
            }
            else {
                arg_type = ((argDecl != null && (is_static || i > 0)) ? argDecl.getType() : (is_static ? this.argTypes[i + skipArg] : ((i == 0) ? thisType : this.argTypes[i - 1])));
            }
            comp.usedClass(arg_type);
            final Type argTypeForTarget = createVarargsNow ? Type.objectType : arg_type;
            final Target target = (this.source == null) ? CheckedTarget.getInstance(argTypeForTarget, name, i + 1) : CheckedTarget.getInstance(argTypeForTarget, this.source, i);
            args[startArg + i].compileWithPosition(comp, target);
            if (createVarargsNow) {
                final Type eltype = ((ArrayType)arg_type).getComponentType();
                code.emitDup();
                code.emitInstanceof(arg_type);
                code.emitIfIntNotZero();
                code.emitCheckcast(arg_type);
                code.emitElse();
                code.emitPushInt(1);
                code.emitNewArray(eltype);
                code.emitDupX();
                code.emitSwap();
                code.emitPushInt(0);
                code.emitSwap();
                eltype.emitCoerceFromObject(code);
                code.emitArrayStore(eltype);
                code.emitFi();
            }
            if (i >= fix_arg_count) {
                code.emitArrayStore(arg_type);
            }
            if (argDecl != null && (is_static || i > 0)) {
                argDecl = argDecl.nextDecl();
            }
        }
        arg_type = this.argTypes[arg_count - 1 + skipArg];
        if (arg_type == Compilation.scmListType || arg_type == LangObjType.listType) {
            MakeList.compile(args, startArg + i, comp);
            return;
        }
        if (startArg + i + 1 == args.length && exp.firstSpliceArg == startArg + i) {
            final Expression spliceArg = MakeSplice.argIfSplice(args[startArg + i]);
            final Type spliceType = spliceArg.getType();
            if (spliceType instanceof ArrayType) {
                final Type spliceElType = ((ArrayType)spliceType).getComponentType();
                final Type argElType = ((ArrayType)arg_type).getComponentType();
                if (spliceElType == argElType || (argElType == Type.objectType && spliceElType instanceof ObjectType) || (argElType instanceof ClassType && spliceElType instanceof ClassType && spliceElType.isSubtype(argElType))) {
                    spliceArg.compileWithPosition(comp, Target.pushObject);
                    i = nargs;
                    return;
                }
            }
        }
        arg_type = ((ArrayType)arg_type).getComponentType();
        CompileArrays.createArray(arg_type, comp, args, startArg + i, args.length);
        i = nargs;
    }
    
    public boolean canCompile(final ApplyExp exp) {
        return exp.firstKeywordArgIndex == 0 && (exp.firstSpliceArg < 0 || (this.takesVarArgs() && this.minArgs() <= exp.firstSpliceArg));
    }
    
    public boolean compile(final ApplyExp exp, final Compilation comp, final Target target) {
        if (!this.canCompile(exp)) {
            return false;
        }
        final CodeAttr code = comp.getCode();
        final ClassType mclass = this.getDeclaringClass();
        final Expression[] args = exp.getArgs();
        if (this.isConstructor()) {
            if (exp.getFlag(8) && Compilation.defaultClassFileVersion <= 3407872) {
                final int nargs = args.length;
                comp.letStart();
                final Expression[] xargs = new Expression[nargs];
                xargs[0] = args[0];
                for (int i = 1; i < nargs; ++i) {
                    Expression argi = args[i];
                    if (!(argi instanceof QuoteExp) && !(argi instanceof LambdaExp) && !(argi instanceof ReferenceExp)) {
                        final Declaration d = comp.letVariable(null, argi.getType(), argi);
                        d.setCanRead(true);
                        argi = new ReferenceExp(d);
                    }
                    xargs[i] = argi;
                }
                comp.letEnter();
                final LetExp let = comp.letDone(new ApplyExp(exp.func, xargs));
                let.compile(comp, target);
                return true;
            }
            code.emitNew(mclass);
            code.emitDup(mclass);
        }
        final int spliceCount = exp.spliceCount();
        final String arg_error = WrongArguments.checkArgCount(this, args.length - spliceCount, spliceCount > 0);
        if (arg_error != null) {
            comp.error('e', arg_error);
        }
        this.compile(this.getStaticFlag() ? null : mclass, exp, comp, target);
        return true;
    }
    
    void compile(Type thisType, final ApplyExp exp, final Compilation comp, final Target target) {
        final Expression[] args = exp.getArgs();
        final CodeAttr code = comp.getCode();
        int startArg = 0;
        if (this.isConstructor()) {
            final ClassType mclass = this.getDeclaringClass();
            if (mclass.hasOuterLink()) {
                ClassExp.loadSuperStaticLink(args[0], mclass, comp);
            }
            thisType = null;
            startArg = 1;
        }
        else if (this.opcode() == 183 && this.mode == 'P' && "<init>".equals(this.method.getName())) {
            final ClassType mclass = this.getDeclaringClass();
            if (mclass.hasOuterLink()) {
                code.emitPushThis();
                code.emitLoad(code.getCurrentScope().getVariable(1));
                thisType = null;
                startArg = 1;
            }
        }
        else if (this.takesTarget() && this.method.getStaticFlag()) {
            startArg = 1;
        }
        this.compileArgs(exp, args, startArg, thisType, comp);
        if (this.method == null) {
            code.emitPrimop(this.opcode(), args.length, this.retType);
            target.compileFromStack(comp, this.retType);
        }
        else {
            compileInvoke(comp, this.methodForInvoke, target, exp.isTailCall(), this.op_code, this.retType, this.doFixUnsigned);
        }
    }
    
    public static void compileInvoke(final Compilation comp, final Method method, final Target target, final boolean isTailCall, final int op_code, Type returnType, final boolean doFixUnsigned) {
        final CodeAttr code = comp.getCode();
        comp.usedClass(method.getDeclaringClass());
        comp.usedClass(method.getReturnType());
        if (!takesContext(method)) {
            code.emitInvokeMethod(method, op_code);
        }
        else {
            if (target instanceof IgnoreTarget || (target instanceof ConsumerTarget && ((ConsumerTarget)target).isContextTarget())) {
                Field consumerFld = null;
                Variable saveCallContext = null;
                comp.loadCallContext();
                if (target instanceof IgnoreTarget) {
                    final ClassType typeCallContext = Compilation.typeCallContext;
                    consumerFld = typeCallContext.getDeclaredField("consumer");
                    code.pushScope();
                    saveCallContext = code.addLocal(typeCallContext);
                    code.emitDup();
                    code.emitGetField(consumerFld);
                    code.emitStore(saveCallContext);
                    code.emitDup();
                    code.emitGetStatic(ClassType.make("gnu.lists.VoidConsumer").getDeclaredField("instance"));
                    code.emitPutField(consumerFld);
                }
                code.emitInvokeMethod(method, op_code);
                ApplyExp.finishTrampoline(isTailCall, target, comp);
                if (target instanceof IgnoreTarget) {
                    comp.loadCallContext();
                    code.emitLoad(saveCallContext);
                    code.emitPutField(consumerFld);
                    code.popScope();
                }
                return;
            }
            comp.loadCallContext();
            returnType = Type.objectType;
            code.pushScope();
            final Variable saveIndex = code.addLocal(Type.intType);
            comp.loadCallContext();
            code.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("startFromContext", 0));
            code.emitStore(saveIndex);
            code.emitWithCleanupStart();
            code.emitInvokeMethod(method, op_code);
            code.emitWithCleanupCatch(null);
            comp.loadCallContext();
            code.emitLoad(saveIndex);
            code.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("cleanupFromContext", 1));
            code.emitWithCleanupDone();
            comp.loadCallContext();
            code.emitLoad(saveIndex);
            code.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("getFromContext", 1));
            code.popScope();
        }
        if (method.getReturnType() == Type.neverReturnsType) {
            compileReachedUnexpected(code);
        }
        else {
            if (method.getReturnType() instanceof TypeVariable) {
                if (returnType instanceof ClassType) {
                    code.emitCheckcast(returnType);
                }
                else {
                    returnType = method.getReturnType().getRawType();
                }
            }
            if (doFixUnsigned) {
                code.fixUnsigned(returnType);
            }
            target.compileFromStack(comp, returnType);
        }
    }
    
    public static void compileReachedUnexpected(final CodeAttr code) {
        if (code.reachableHere()) {
            code.emitGetStatic(ClassType.make("gnu.expr.Special").getDeclaredField("reachedUnexpected"));
            code.emitThrow();
        }
    }
    
    @Override
    public Type getParameterType(int index) {
        if (this.takesTarget()) {
            if (index == 0) {
                return this.isConstructor() ? Type.objectType : this.getDeclaringClass();
            }
            --index;
        }
        final int lenTypes = this.argTypes.length;
        if (index < lenTypes - 1) {
            return this.argTypes[index];
        }
        final boolean varArgs = this.takesVarArgs();
        if (index < lenTypes && !varArgs) {
            return this.argTypes[index];
        }
        final Type restType = this.argTypes[lenTypes - 1];
        if (restType instanceof ArrayType) {
            return ((ArrayType)restType).getComponentType();
        }
        return Type.objectType;
    }
    
    public static int mostSpecific(final PrimProcedure[] procs, final int length) {
        if (length <= 1) {
            return length - 1;
        }
        int best = 0;
        int[] bests = null;
        int bestn = 0;
    Label_0165:
        for (int i = 1; i < length; ++i) {
            final PrimProcedure method = procs[i];
            if (best >= 0) {
                final PrimProcedure winner = (PrimProcedure)MethodProc.mostSpecific(procs[best], method);
                if (winner == null) {
                    if (bests == null) {
                        bests = new int[length];
                    }
                    bests[0] = best;
                    bests[1] = i;
                    bestn = 2;
                    best = -1;
                }
                else if (winner == method) {
                    best = i;
                    bestn = i;
                }
            }
            else {
                for (int j = 0; j < bestn; ++j) {
                    final PrimProcedure old = procs[bests[j]];
                    final PrimProcedure winner2 = (PrimProcedure)MethodProc.mostSpecific(old, method);
                    if (winner2 == old) {
                        continue Label_0165;
                    }
                    if (winner2 == null) {
                        bests[bestn++] = i;
                        continue Label_0165;
                    }
                }
                best = i;
                bestn = i;
            }
        }
        if (best < 0 && bestn > 1) {
            final PrimProcedure first = procs[bests[0]];
            for (int k = 0; k < bestn; ++k) {
                final int m = bests[k];
                final PrimProcedure method2 = procs[m];
                if (k > 0 && !MethodProc.overrideEquivalent(first, method2)) {
                    return -1;
                }
                if (!method2.isAbstract()) {
                    if (best >= 0) {
                        return -1;
                    }
                    best = m;
                }
            }
            return (best >= 0) ? best : bests[0];
        }
        return best;
    }
    
    public static PrimProcedure getMethodFor(final Procedure pproc, final Expression[] args) {
        return getMethodFor(pproc, null, args, Language.getDefaultLanguage());
    }
    
    public static PrimProcedure getMethodFor(final Procedure pproc, final Declaration decl, final Expression[] args, final Language language) {
        final int nargs = args.length;
        final Type[] atypes = new Type[nargs];
        int i = nargs;
        while (--i >= 0) {
            atypes[i] = args[i].getType();
        }
        return getMethodFor(pproc, decl, atypes, language);
    }
    
    public static PrimProcedure getMethodFor(Procedure pproc, final Declaration decl, final Type[] atypes, final Language language) {
        if (pproc instanceof GenericProc) {
            final GenericProc gproc = (GenericProc)pproc;
            final MethodProc[] methods = gproc.methods;
            pproc = null;
            int i = gproc.count;
            while (--i >= 0) {
                final int applic = methods[i].isApplicable(atypes, null);
                if (applic < 0) {
                    continue;
                }
                if (pproc != null) {
                    return null;
                }
                pproc = methods[i];
            }
            if (pproc == null) {
                return null;
            }
        }
        if (pproc instanceof PrimProcedure) {
            final PrimProcedure prproc = (PrimProcedure)pproc;
            if (prproc.isApplicable(atypes, null) >= 0) {
                return prproc;
            }
        }
        final Class pclass = getProcedureClass(pproc);
        if (pclass == null) {
            return null;
        }
        return getMethodFor((ClassType)Type.make(pclass), pproc.getName(), decl, atypes, language);
    }
    
    public static void disassemble$X(final Procedure pproc, final CallContext ctx) throws Exception {
        final Consumer cons = ctx.consumer;
        disassemble(pproc, (cons instanceof Writer) ? cons : new ConsumerWriter(cons));
    }
    
    public static void disassemble(final Procedure proc, final Writer out) throws Exception {
        disassemble(proc, new ClassTypeWriter(null, out, 0));
    }
    
    public static void disassemble(final Procedure proc, final ClassTypeWriter cwriter) throws Exception {
        if (proc instanceof GenericProc) {
            final GenericProc gproc = (GenericProc)proc;
            final int n = gproc.getMethodCount();
            cwriter.print("Generic procedure with ");
            cwriter.print(n);
            cwriter.println((n == 1) ? " method." : "methods.");
            for (int i = 0; i < n; ++i) {
                final Procedure mproc = gproc.getMethod(i);
                if (mproc != null) {
                    cwriter.println();
                    disassemble(mproc, cwriter);
                }
            }
            return;
        }
        String pname = null;
        Class cl = proc.getClass();
        if (proc instanceof ModuleMethod) {
            cl = ((ModuleMethod)proc).module.getClass();
        }
        else if (proc instanceof PrimProcedure) {
            final Method pmethod = ((PrimProcedure)proc).methodForInvoke;
            if (pmethod != null) {
                cl = pmethod.getDeclaringClass().getReflectClass();
                pname = pmethod.getName();
            }
        }
        ClassLoader loader = cl.getClassLoader();
        if (loader == null) {
            loader = ClassLoader.getSystemClassLoader();
        }
        final String cname = cl.getName();
        final String rname = cname.replace('.', '/') + ".class";
        final ClassType ctype = new ClassType();
        final InputStream rin = loader.getResourceAsStream(rname);
        if (rin == null) {
            throw new RuntimeException("missing resource " + rname);
        }
        final ClassFileInput cinput = new ClassFileInput(ctype, rin);
        cwriter.setClass(ctype);
        final URL resource = loader.getResource(rname);
        cwriter.print("In class ");
        cwriter.print(cname);
        if (resource != null) {
            cwriter.print(" at ");
            cwriter.print(resource);
        }
        cwriter.println();
        if (pname == null) {
            pname = proc.getName();
            if (pname == null) {
                cwriter.println("Anonymous function - unknown method.");
                return;
            }
            pname = Mangling.mangleName(pname);
        }
        for (Method method = ctype.getMethods(); method != null; method = method.getNext()) {
            final String mname = method.getName();
            if (mname.equals(pname)) {
                cwriter.printMethod(method);
            }
        }
        cwriter.flush();
    }
    
    public static Class getProcedureClass(final Object pproc) {
        Class procClass;
        if (pproc instanceof ModuleMethod) {
            procClass = ((ModuleMethod)pproc).module.getClass();
        }
        else {
            procClass = pproc.getClass();
        }
        try {
            if (procClass.getClassLoader() == PrimProcedure.systemClassLoader) {
                return procClass;
            }
        }
        catch (SecurityException ex) {}
        return null;
    }
    
    public static PrimProcedure getMethodFor(final Class procClass, final String name, final Declaration decl, final Expression[] args, final Language language) {
        return getMethodFor((ClassType)Type.make(procClass), name, decl, args, language);
    }
    
    public static PrimProcedure getMethodFor(final ClassType procClass, final String name, final Declaration decl, final Expression[] args, final Language language) {
        final int nargs = args.length;
        final Type[] atypes = new Type[nargs];
        int i = nargs;
        while (--i >= 0) {
            atypes[i] = args[i].getType();
        }
        return getMethodFor(procClass, name, decl, atypes, language);
    }
    
    public static PrimProcedure getMethodFor(final ClassType procClass, final String name, final Declaration decl, final Type[] atypes, final Language language) {
        PrimProcedure best = null;
        int bestCode = -1;
        boolean bestIsApply = false;
        try {
            if (name == null) {
                return null;
            }
            final String mangledName = Mangling.mangleName(name);
            final String mangledNameV = mangledName + "$V";
            final String mangledNameVX = mangledName + "$V$X";
            final String mangledNameX = mangledName + "$X";
            boolean applyOk = true;
            for (Method meth = procClass.getDeclaredMethods(); meth != null; meth = meth.getNext()) {
                final int mods = meth.getModifiers();
                if ((mods & 0x9) != 0x9) {
                    if (decl == null) {
                        continue;
                    }
                    if (decl.base == null) {
                        continue;
                    }
                }
                final String mname = meth.getName();
                boolean isApply;
                if (mname.equals(mangledName) || mname.equals(mangledNameV) || mname.equals(mangledNameX) || mname.equals(mangledNameVX)) {
                    isApply = false;
                }
                else {
                    if (!applyOk || (!mname.equals("apply") && !mname.equals("apply$V"))) {
                        continue;
                    }
                    isApply = true;
                }
                if (!isApply) {
                    applyOk = false;
                    if (bestIsApply) {
                        best = null;
                        bestCode = -1;
                        bestIsApply = false;
                    }
                }
                final PrimProcedure prproc = new PrimProcedure(meth, language);
                prproc.setName(name);
                final int code = prproc.isApplicable(atypes, null);
                if (code >= 0) {
                    if (code >= bestCode) {
                        if (code > bestCode) {
                            best = prproc;
                        }
                        else if (best != null) {
                            best = (PrimProcedure)MethodProc.mostSpecific(best, prproc);
                            if (best == null && bestCode > 0) {
                                return null;
                            }
                        }
                        bestCode = code;
                        bestIsApply = isApply;
                    }
                }
            }
        }
        catch (SecurityException ex) {}
        return best;
    }
    
    @Override
    public String getName() {
        String name = super.getName();
        if (name != null) {
            return name;
        }
        name = this.getVerboseName();
        this.setName(name);
        return name;
    }
    
    public String getVerboseName() {
        final StringBuffer buf = new StringBuffer(100);
        if (this.method == null) {
            buf.append("<op ");
            buf.append(this.op_code);
            buf.append('>');
        }
        else {
            buf.append(this.getDeclaringClass().getName());
            buf.append('.');
            buf.append(this.method.getName());
        }
        buf.append('(');
        for (int i = 0; i < this.argTypes.length; ++i) {
            if (i > 0) {
                buf.append(',');
            }
            buf.append(this.argTypes[i].getName());
        }
        buf.append(')');
        return buf.toString();
    }
    
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer(100);
        buf.append((this.retType == null) ? "<unknown>" : this.retType.getName());
        buf.append(' ');
        buf.append(this.getVerboseName());
        return buf.toString();
    }
    
    public void print(final PrintWriter ps) {
        ps.print("#<primitive procedure ");
        ps.print(this.toString());
        ps.print('>');
    }
    
    static {
        PrimProcedure.explicitArrayAsVarArgsAllowed = true;
        PrimProcedure.systemClassLoader = PrimProcedure.class.getClassLoader();
    }
}
