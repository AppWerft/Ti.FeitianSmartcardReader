/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassFileInput;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.TypeVariable;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.CheckedTarget;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.GenericProc;
import gnu.expr.IgnoreTarget;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.Mangling;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.expr.PairClassType;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Target;
import gnu.kawa.functions.MakeList;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.CompileArrays;
import gnu.lists.Consumer;
import gnu.lists.ConsumerWriter;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongArguments;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.net.URL;
import kawa.SourceMethodType;

public class PrimProcedure
extends MethodProc {
    private Type retType;
    private Type[] argTypes;
    private gnu.bytecode.Method method;
    private gnu.bytecode.Method methodForInvoke;
    private int op_code;
    private char mode;
    private boolean sideEffectFree;
    private boolean doFixUnsigned;
    private LambdaExp source;
    private Member member;
    public static boolean explicitArrayAsVarArgsAllowed = true;
    private static ClassLoader systemClassLoader = PrimProcedure.class.getClassLoader();

    public final int opcode() {
        return this.op_code;
    }

    public Type getReturnType() {
        return this.retType;
    }

    public void setReturnType(Type retType) {
        this.doFixUnsigned = true;
        this.retType = retType;
    }

    public boolean isSpecial() {
        return this.mode == 'P';
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return this.retType;
    }

    public ClassType getDeclaringClass() {
        return this.methodForInvoke == null ? null : this.methodForInvoke.getDeclaringClass();
    }

    public gnu.bytecode.Method getMethod() {
        return this.method;
    }

    public void setMethodForInvoke(gnu.bytecode.Method m) {
        this.methodForInvoke = m;
        this.setOpcode(m);
    }

    @Override
    public boolean isSideEffectFree() {
        return this.sideEffectFree;
    }

    public void setSideEffectFree() {
        this.sideEffectFree = true;
    }

    public boolean takesVarArgs() {
        return PrimProcedure.takesVarArgs(this.method);
    }

    public static boolean takesVarArgs(gnu.bytecode.Method method) {
        if (method != null) {
            if ((method.getModifiers() & 128) != 0) {
                return true;
            }
            String name = method.getName();
            return name.endsWith("$V") || name.endsWith("$V$X");
        }
        return false;
    }

    public boolean takesContext() {
        return this.method != null && PrimProcedure.takesContext(this.method);
    }

    public static boolean takesContext(gnu.bytecode.Method method) {
        return method.getName().endsWith("$X");
    }

    @Override
    public int isApplicable(Type[] argTypes, Type restType) {
        int app = super.isApplicable(argTypes, restType);
        int nargs = argTypes.length;
        if (explicitArrayAsVarArgsAllowed && app == -1 && this.method != null && restType == null && (this.method.getModifiers() & 128) != 0 && nargs > 0 && argTypes[nargs - 1] instanceof ArrayType) {
            Type[] tmp = new Type[nargs];
            System.arraycopy(argTypes, 0, tmp, 0, nargs - 1);
            tmp[nargs - 1] = ((ArrayType)argTypes[nargs - 1]).getComponentType();
            return super.isApplicable(tmp, null);
        }
        return app;
    }

    public boolean isAbstract() {
        return this.method != null && (this.method.getModifiers() & 1024) != 0;
    }

    public final boolean isConstructor() {
        return this.opcode() == 183 && this.mode != 'P';
    }

    public boolean takesTarget() {
        return this.mode != '\u0000';
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
        return this.takesVarArgs() ? num - 1 + -4096 : num + (num << 12);
    }

    @Override
    public int match0(CallContext ctx) {
        return this.matchN(ProcedureN.noArgs, ctx);
    }

    @Override
    public int match1(Object arg1, CallContext ctx) {
        Object[] args = new Object[]{arg1};
        return this.matchN(args, ctx);
    }

    @Override
    public int match2(Object arg1, Object arg2, CallContext ctx) {
        Object[] args = new Object[]{arg1, arg2};
        return this.matchN(args, ctx);
    }

    @Override
    public int match3(Object arg1, Object arg2, Object arg3, CallContext ctx) {
        Object[] args = new Object[]{arg1, arg2, arg3};
        return this.matchN(args, ctx);
    }

    @Override
    public int match4(Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx) {
        Object[] args = new Object[]{arg1, arg2, arg3, arg4};
        return this.matchN(args, ctx);
    }

    @Override
    public int matchN(Object[] args, CallContext ctx) {
        Object extraArg;
        int nargs = args.length;
        boolean takesVarArgs = this.takesVarArgs();
        int fixArgs = this.minArgs();
        if (nargs < fixArgs) {
            return -983040 | fixArgs;
        }
        if (!takesVarArgs && nargs > fixArgs) {
            return -917504 | fixArgs;
        }
        int paramCount = this.argTypes.length;
        Type elementType = null;
        Object restArray = null;
        int extraCount = this.takesTarget() || this.isConstructor() ? 1 : 0;
        boolean takesContext = this.takesContext();
        Object[] rargs = new Object[paramCount];
        if (takesContext) {
            rargs[--paramCount] = ctx;
        }
        if (takesVarArgs) {
            Type restType = this.argTypes[paramCount - 1];
            if (restType == Compilation.scmListType || restType == LangObjType.listType) {
                rargs[paramCount - 1] = LList.makeList(args, fixArgs);
                nargs = fixArgs;
                elementType = Type.objectType;
            } else {
                ArrayType restArrayType = (ArrayType)restType;
                elementType = restArrayType.getComponentType();
                Class elementClass = elementType.getReflectClass();
                rargs[paramCount - 1] = restArray = Array.newInstance(elementClass, nargs - fixArgs);
            }
        }
        if (this.isConstructor()) {
            extraArg = args[0];
        } else if (extraCount != 0) {
            try {
                extraArg = this.getDeclaringClass().coerceFromObject(args[0]);
            }
            catch (ClassCastException ex) {
                return -786431;
            }
        } else {
            extraArg = null;
        }
        for (int i = extraCount; i < args.length; ++i) {
            Type type;
            Object arg = args[i];
            Type type2 = i < fixArgs ? this.argTypes[i - extraCount] : (type = elementType == null ? null : elementType);
            if (type != Type.objectType) {
                try {
                    arg = type.coerceFromObject(arg);
                }
                catch (ClassCastException ex) {
                    return -786432 | i + 1;
                }
            }
            if (i < fixArgs) {
                rargs[i - extraCount] = arg;
                continue;
            }
            if (restArray == null) continue;
            if (type instanceof PrimType) {
                arg = ((PrimType)type).convertToRaw(arg);
            }
            Array.set(restArray, i - fixArgs, arg);
        }
        ctx.value1 = extraArg;
        ctx.values = rargs;
        ctx.proc = this;
        return 0;
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        int arg_count = this.argTypes.length;
        boolean is_constructor = this.isConstructor();
        boolean slink = is_constructor && this.getDeclaringClass().hasOuterLink();
        try {
            Object result;
            if (this.member == null) {
                Class clas = this.getDeclaringClass().getReflectClass();
                Class[] paramTypes = new Class[arg_count + (slink ? 1 : 0)];
                int i = arg_count;
                while (--i >= 0) {
                    paramTypes[i + (slink != false ? 1 : 0)] = this.argTypes[i].getReflectClass();
                }
                if (slink) {
                    paramTypes[0] = this.getDeclaringClass().getOuterLinkType().getReflectClass();
                }
                if (is_constructor) {
                    this.member = clas.getConstructor(paramTypes);
                } else if (this.method != Type.clone_method) {
                    this.member = clas.getMethod(this.method.getName(), paramTypes);
                }
            }
            if (is_constructor) {
                Object[] args = ctx.values;
                if (slink) {
                    int nargs = args.length + 1;
                    Object[] xargs = new Object[nargs];
                    System.arraycopy(args, 0, xargs, 1, nargs - 1);
                    xargs[0] = ((PairClassType)ctx.value1).staticLink;
                    args = xargs;
                }
                result = ((Constructor)this.member).newInstance(args);
            } else if (this.method == Type.clone_method) {
                Object arr = ctx.value1;
                Class<?> elClass = arr.getClass().getComponentType();
                int n = Array.getLength(arr);
                result = Array.newInstance(elClass, n);
                System.arraycopy(arr, 0, result, 0, n);
            } else {
                result = this.retType.coerceToObject(((Method)this.member).invoke(ctx.value1, ctx.values));
            }
            if (!this.takesContext()) {
                ctx.consumer.writeObject(result);
            }
        }
        catch (InvocationTargetException ex) {
            throw ex.getTargetException();
        }
    }

    public PrimProcedure(String className, String methodName, int numArgs) {
        this(ClassType.make(className).getDeclaredMethod(methodName, numArgs));
    }

    public PrimProcedure(Method method, Language language) {
        this(((ClassType)language.getTypeFor(method.getDeclaringClass())).getMethod(method), language);
    }

    public PrimProcedure(gnu.bytecode.Method method) {
        this.init(method);
        this.retType = method.getName().endsWith("$X") ? Type.objectType : method.getReturnType();
    }

    public PrimProcedure(gnu.bytecode.Method method, Type retType, Type[] argTypes) {
        this.init(method);
        this.retType = retType;
        if (argTypes != null) {
            this.argTypes = argTypes;
        }
    }

    public PrimProcedure(gnu.bytecode.Method method, Language language) {
        this(method, '\u0000', language, null);
    }

    public PrimProcedure(gnu.bytecode.Method method, char mode, Language language, ParameterizedType parameterizedType) {
        String[] annotTypes;
        this.mode = mode;
        this.init(method);
        Type[] pTypes = this.argTypes;
        int nTypes = pTypes.length;
        this.argTypes = null;
        try {
            SourceMethodType sourceType = method.getAnnotation(SourceMethodType.class);
            annotTypes = sourceType == null ? null : sourceType.value();
        }
        catch (Throwable ex) {
            annotTypes = null;
        }
        int i = nTypes;
        while (--i >= 0) {
            Type javaType = pTypes[i];
            Type langType = PrimProcedure.decodeType(javaType, annotTypes, i + 1, parameterizedType, language);
            if (javaType == langType) continue;
            if (this.argTypes == null) {
                this.argTypes = new Type[nTypes];
                System.arraycopy(pTypes, 0, this.argTypes, 0, nTypes);
            }
            this.argTypes[i] = langType;
        }
        if (this.argTypes == null) {
            this.argTypes = pTypes;
        }
        if (this.isConstructor()) {
            this.retType = this.getDeclaringClass();
        } else if (method.getName().endsWith("$X")) {
            this.retType = Type.objectType;
        } else {
            this.retType = PrimProcedure.decodeType(method.getReturnType(), annotTypes, 0, parameterizedType, language);
            if (this.retType == Type.toStringType) {
                this.retType = Type.javalangStringType;
            }
        }
    }

    public static Type decodeType(Type javaType, String[] annotTypes, int annotIndex, ParameterizedType parameterizedType, Language lang) {
        String annotType = annotTypes != null && annotTypes.length > annotIndex ? annotTypes[annotIndex] : null;
        return lang.decodeType(javaType, annotType, parameterizedType);
    }

    private void setOpcode(gnu.bytecode.Method m) {
        int flags = m.getModifiers();
        if ((flags & 8) != 0) {
            this.op_code = 184;
        } else {
            ClassType mclass = m.getDeclaringClass();
            if (this.mode == 'P') {
                this.op_code = 183;
            } else {
                this.mode = (char)86;
                this.op_code = "<init>".equals(m.getName()) ? 183 : ((mclass.getModifiers() & 512) != 0 ? 185 : 182);
            }
        }
    }

    private void init(gnu.bytecode.Method method) {
        this.method = method;
        this.methodForInvoke = method;
        this.setOpcode(method);
        Type[] mtypes = method.getParameterTypes();
        if (this.isConstructor() && method.getDeclaringClass().hasOuterLink()) {
            int len = mtypes.length - 1;
            Type[] types = new Type[len];
            System.arraycopy(mtypes, 1, types, 0, len);
            mtypes = types;
        }
        this.argTypes = mtypes;
    }

    public PrimProcedure(gnu.bytecode.Method method, LambdaExp source) {
        this(method);
        this.retType = source.getReturnType();
        this.source = source;
    }

    public PrimProcedure(int opcode, Type retType, Type[] argTypes) {
        this.op_code = opcode;
        this.retType = retType;
        this.argTypes = argTypes;
    }

    public static PrimProcedure makeBuiltinUnary(int opcode, Type type) {
        Type[] args = new Type[]{type};
        return new PrimProcedure(opcode, type, args);
    }

    public static PrimProcedure makeBuiltinBinary(int opcode, Type type) {
        Type[] args = new Type[]{type, type};
        return new PrimProcedure(opcode, type, args);
    }

    public PrimProcedure(int op_code, ClassType classtype, String name, Type retType, Type[] argTypes) {
        this.op_code = op_code;
        this.methodForInvoke = this.method = classtype.addMethod(name, op_code == 184 ? 8 : 0, argTypes, retType);
        this.retType = retType;
        this.argTypes = argTypes;
        this.mode = (char)(op_code == 184 ? 0 : 86);
    }

    public final boolean getStaticFlag() {
        return this.method == null || this.method.getStaticFlag() || this.isConstructor();
    }

    public final Type[] getParameterTypes() {
        return this.argTypes;
    }

    private void compileArgs(ApplyExp exp, Expression[] args, int startArg, Type thisType, Compilation comp) {
        Declaration argDecl;
        Type lastType;
        Type lastParam;
        boolean variable = this.takesVarArgs();
        String name = this.getName();
        Type arg_type = null;
        CodeAttr code = comp.getCode();
        int skipArg = thisType == Type.voidType ? 1 : 0;
        int arg_count = this.argTypes.length - skipArg;
        if (this.takesContext()) {
            --arg_count;
        }
        int nargs = args.length - startArg;
        boolean is_static = thisType == null || skipArg != 0;
        boolean createVarargsArrayIfNeeded = false;
        if (explicitArrayAsVarArgsAllowed && variable && (this.method.getModifiers() & 128) != 0 && exp.firstSpliceArg < 0 && nargs > 0 && this.argTypes.length > 0 && nargs == arg_count + (is_static ? 0 : 1) && (lastParam = this.argTypes[this.argTypes.length - 1]).isCompatibleWithValue(lastType = args[args.length - 1].getType()) >= 0) {
            if (lastParam instanceof ArrayType && ((ArrayType)lastParam).getComponentType().isCompatibleWithValue(lastType) >= 0) {
                createVarargsArrayIfNeeded = true;
            }
            variable = false;
        }
        int fix_arg_count = variable ? arg_count - (is_static ? 1 : 0) : args.length - startArg;
        Declaration declaration = argDecl = this.source == null ? null : this.source.firstDecl();
        if (argDecl != null && argDecl.isThisParameter()) {
            argDecl = argDecl.nextDecl();
        }
        int i = 0;
        do {
            boolean createVarargsNow;
            if (variable && i == fix_arg_count) {
                Type spliceType;
                Type spliceElType;
                Type argElType;
                Expression spliceArg;
                arg_type = this.argTypes[arg_count - 1 + skipArg];
                if (arg_type == Compilation.scmListType || arg_type == LangObjType.listType) {
                    MakeList.compile(args, startArg + i, comp);
                    break;
                }
                if (startArg + i + 1 == args.length && exp.firstSpliceArg == startArg + i && (spliceType = (spliceArg = MakeSplice.argIfSplice(args[startArg + i])).getType()) instanceof ArrayType && ((spliceElType = ((ArrayType)spliceType).getComponentType()) == (argElType = ((ArrayType)arg_type).getComponentType()) || argElType == Type.objectType && spliceElType instanceof ObjectType || argElType instanceof ClassType && spliceElType instanceof ClassType && spliceElType.isSubtype(argElType))) {
                    spliceArg.compileWithPosition(comp, Target.pushObject);
                    i = nargs;
                    break;
                }
                arg_type = ((ArrayType)arg_type).getComponentType();
                CompileArrays.createArray(arg_type, comp, args, startArg + i, args.length);
                i = nargs;
                break;
            }
            if (i >= nargs) break;
            boolean bl = createVarargsNow = createVarargsArrayIfNeeded && i + 1 == nargs;
            if (i >= fix_arg_count) {
                code.emitDup(1);
                code.emitPushInt(i - fix_arg_count);
            } else {
                arg_type = argDecl != null && (is_static || i > 0) ? argDecl.getType() : (is_static ? this.argTypes[i + skipArg] : (i == 0 ? thisType : this.argTypes[i - 1]));
            }
            comp.usedClass(arg_type);
            Type argTypeForTarget = createVarargsNow ? Type.objectType : arg_type;
            Target target = this.source == null ? CheckedTarget.getInstance(argTypeForTarget, name, i + 1) : CheckedTarget.getInstance(argTypeForTarget, this.source, i);
            args[startArg + i].compileWithPosition(comp, target);
            if (createVarargsNow) {
                Type eltype = ((ArrayType)arg_type).getComponentType();
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
            ++i;
        } while (true);
    }

    public boolean canCompile(ApplyExp exp) {
        if (exp.firstKeywordArgIndex != 0) {
            return false;
        }
        return exp.firstSpliceArg < 0 || this.takesVarArgs() && this.minArgs() <= exp.firstSpliceArg;
    }

    public boolean compile(ApplyExp exp, Compilation comp, Target target) {
        String arg_error;
        int spliceCount;
        if (!this.canCompile(exp)) {
            return false;
        }
        CodeAttr code = comp.getCode();
        ClassType mclass = this.getDeclaringClass();
        Expression[] args = exp.getArgs();
        if (this.isConstructor()) {
            if (exp.getFlag(8) && Compilation.defaultClassFileVersion <= 3407872) {
                int nargs = args.length;
                comp.letStart();
                Expression[] xargs = new Expression[nargs];
                xargs[0] = args[0];
                for (int i = 1; i < nargs; ++i) {
                    Expression argi = args[i];
                    if (!(argi instanceof QuoteExp || argi instanceof LambdaExp || argi instanceof ReferenceExp)) {
                        Declaration d = comp.letVariable(null, argi.getType(), argi);
                        d.setCanRead(true);
                        argi = new ReferenceExp(d);
                    }
                    xargs[i] = argi;
                }
                comp.letEnter();
                LetExp let2 = comp.letDone(new ApplyExp(exp.func, xargs));
                let2.compile(comp, target);
                return true;
            }
            code.emitNew(mclass);
            code.emitDup(mclass);
        }
        if ((arg_error = WrongArguments.checkArgCount(this, args.length - spliceCount, (spliceCount = exp.spliceCount()) > 0)) != null) {
            comp.error('e', arg_error);
        }
        this.compile(this.getStaticFlag() ? null : mclass, exp, comp, target);
        return true;
    }

    void compile(Type thisType, ApplyExp exp, Compilation comp, Target target) {
        Expression[] args = exp.getArgs();
        CodeAttr code = comp.getCode();
        int startArg = 0;
        if (this.isConstructor()) {
            ClassType mclass = this.getDeclaringClass();
            if (mclass.hasOuterLink()) {
                ClassExp.loadSuperStaticLink(args[0], mclass, comp);
            }
            thisType = null;
            startArg = 1;
        } else if (this.opcode() == 183 && this.mode == 'P' && "<init>".equals(this.method.getName())) {
            ClassType mclass = this.getDeclaringClass();
            if (mclass.hasOuterLink()) {
                code.emitPushThis();
                code.emitLoad(code.getCurrentScope().getVariable(1));
                thisType = null;
                startArg = 1;
            }
        } else if (this.takesTarget() && this.method.getStaticFlag()) {
            startArg = 1;
        }
        this.compileArgs(exp, args, startArg, thisType, comp);
        if (this.method == null) {
            code.emitPrimop(this.opcode(), args.length, this.retType);
            target.compileFromStack(comp, this.retType);
        } else {
            PrimProcedure.compileInvoke(comp, this.methodForInvoke, target, exp.isTailCall(), this.op_code, this.retType, this.doFixUnsigned);
        }
    }

    public static void compileInvoke(Compilation comp, gnu.bytecode.Method method, Target target, boolean isTailCall, int op_code, Type returnType, boolean doFixUnsigned) {
        CodeAttr code = comp.getCode();
        comp.usedClass(method.getDeclaringClass());
        comp.usedClass(method.getReturnType());
        if (!PrimProcedure.takesContext(method)) {
            code.emitInvokeMethod(method, op_code);
        } else {
            if (target instanceof IgnoreTarget || target instanceof ConsumerTarget && ((ConsumerTarget)target).isContextTarget()) {
                Field consumerFld = null;
                Variable saveCallContext = null;
                comp.loadCallContext();
                if (target instanceof IgnoreTarget) {
                    ClassType typeCallContext = Compilation.typeCallContext;
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
            Variable saveIndex = code.addLocal(Type.intType);
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
            PrimProcedure.compileReachedUnexpected(code);
        } else {
            if (method.getReturnType() instanceof TypeVariable) {
                if (returnType instanceof ClassType) {
                    code.emitCheckcast(returnType);
                } else {
                    returnType = method.getReturnType().getRawType();
                }
            }
            if (doFixUnsigned) {
                code.fixUnsigned(returnType);
            }
            target.compileFromStack(comp, returnType);
        }
    }

    public static void compileReachedUnexpected(CodeAttr code) {
        if (code.reachableHere()) {
            code.emitGetStatic(ClassType.make("gnu.expr.Special").getDeclaredField("reachedUnexpected"));
            code.emitThrow();
        }
    }

    @Override
    public Type getParameterType(int index) {
        int lenTypes;
        if (this.takesTarget()) {
            if (index == 0) {
                return this.isConstructor() ? Type.objectType : this.getDeclaringClass();
            }
            --index;
        }
        if (index < (lenTypes = this.argTypes.length) - 1) {
            return this.argTypes[index];
        }
        boolean varArgs = this.takesVarArgs();
        if (index < lenTypes && !varArgs) {
            return this.argTypes[index];
        }
        Type restType = this.argTypes[lenTypes - 1];
        if (restType instanceof ArrayType) {
            return ((ArrayType)restType).getComponentType();
        }
        return Type.objectType;
    }

    public static int mostSpecific(PrimProcedure[] procs, int length) {
        if (length <= 1) {
            return length - 1;
        }
        int best = 0;
        int[] bests = null;
        int bestn = 0;
        block0 : for (int i = 1; i < length; ++i) {
            PrimProcedure method = procs[i];
            if (best >= 0) {
                PrimProcedure winner = (PrimProcedure)PrimProcedure.mostSpecific(procs[best], method);
                if (winner == null) {
                    if (bests == null) {
                        bests = new int[length];
                    }
                    bests[0] = best;
                    bests[1] = i;
                    bestn = 2;
                    best = -1;
                    continue;
                }
                if (winner != method) continue;
                best = i;
                bestn = i;
                continue;
            }
            for (int j = 0; j < bestn; ++j) {
                PrimProcedure old = procs[bests[j]];
                PrimProcedure winner = (PrimProcedure)PrimProcedure.mostSpecific(old, method);
                if (winner == old) continue block0;
                if (winner != null) continue;
                bests[bestn++] = i;
                continue block0;
            }
            best = i;
            bestn = i;
        }
        if (best < 0 && bestn > 1) {
            PrimProcedure first = procs[bests[0]];
            for (int j = 0; j < bestn; ++j) {
                void m = bests[j];
                PrimProcedure method = procs[m];
                if (j > 0 && !PrimProcedure.overrideEquivalent(first, method)) {
                    return -1;
                }
                if (method.isAbstract()) continue;
                if (best >= 0) {
                    return -1;
                }
                best = m;
            }
            return best >= 0 ? best : bests[0];
        }
        return best;
    }

    public static PrimProcedure getMethodFor(Procedure pproc, Expression[] args) {
        return PrimProcedure.getMethodFor(pproc, null, args, Language.getDefaultLanguage());
    }

    public static PrimProcedure getMethodFor(Procedure pproc, Declaration decl, Expression[] args, Language language) {
        int nargs = args.length;
        Type[] atypes = new Type[nargs];
        int i = nargs;
        while (--i >= 0) {
            atypes[i] = args[i].getType();
        }
        return PrimProcedure.getMethodFor(pproc, decl, atypes, language);
    }

    public static PrimProcedure getMethodFor(Procedure pproc, Declaration decl, Type[] atypes, Language language) {
        PrimProcedure prproc;
        if (pproc instanceof GenericProc) {
            GenericProc gproc = (GenericProc)pproc;
            MethodProc[] methods = gproc.methods;
            pproc = null;
            int i = gproc.count;
            while (--i >= 0) {
                int applic = methods[i].isApplicable(atypes, null);
                if (applic < 0) continue;
                if (pproc != null) {
                    return null;
                }
                pproc = methods[i];
            }
            if (pproc == null) {
                return null;
            }
        }
        if (pproc instanceof PrimProcedure && (prproc = (PrimProcedure)pproc).isApplicable(atypes, null) >= 0) {
            return prproc;
        }
        Class pclass = PrimProcedure.getProcedureClass(pproc);
        if (pclass == null) {
            return null;
        }
        return PrimProcedure.getMethodFor((ClassType)Type.make(pclass), pproc.getName(), decl, atypes, language);
    }

    public static void disassemble$X(Procedure pproc, CallContext ctx) throws Exception {
        Consumer cons = ctx.consumer;
        PrimProcedure.disassemble(pproc, cons instanceof Writer ? (Writer)((Object)cons) : new ConsumerWriter(cons));
    }

    public static void disassemble(Procedure proc, Writer out) throws Exception {
        PrimProcedure.disassemble(proc, new ClassTypeWriter(null, out, 0));
    }

    public static void disassemble(Procedure proc, ClassTypeWriter cwriter) throws Exception {
        gnu.bytecode.Method pmethod;
        if (proc instanceof GenericProc) {
            GenericProc gproc = (GenericProc)proc;
            int n = gproc.getMethodCount();
            cwriter.print("Generic procedure with ");
            cwriter.print(n);
            cwriter.println(n == 1 ? " method." : "methods.");
            for (int i = 0; i < n; ++i) {
                MethodProc mproc = gproc.getMethod(i);
                if (mproc == null) continue;
                cwriter.println();
                PrimProcedure.disassemble((Procedure)mproc, cwriter);
            }
            return;
        }
        String pname = null;
        Class cl = proc.getClass();
        if (proc instanceof ModuleMethod) {
            cl = ((ModuleMethod)proc).module.getClass();
        } else if (proc instanceof PrimProcedure && (pmethod = ((PrimProcedure)proc).methodForInvoke) != null) {
            cl = pmethod.getDeclaringClass().getReflectClass();
            pname = pmethod.getName();
        }
        ClassLoader loader = cl.getClassLoader();
        if (loader == null) {
            loader = ClassLoader.getSystemClassLoader();
        }
        String cname = cl.getName();
        String rname = cname.replace('.', '/') + ".class";
        ClassType ctype = new ClassType();
        InputStream rin = loader.getResourceAsStream(rname);
        if (rin == null) {
            throw new RuntimeException("missing resource " + rname);
        }
        ClassFileInput cinput = new ClassFileInput(ctype, rin);
        cwriter.setClass(ctype);
        URL resource = loader.getResource(rname);
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
        for (gnu.bytecode.Method method = ctype.getMethods(); method != null; method = method.getNext()) {
            String mname = method.getName();
            if (!mname.equals(pname)) continue;
            cwriter.printMethod(method);
        }
        cwriter.flush();
    }

    public static Class getProcedureClass(Object pproc) {
        Class<?> procClass = pproc instanceof ModuleMethod ? ((ModuleMethod)pproc).module.getClass() : pproc.getClass();
        try {
            if (procClass.getClassLoader() == systemClassLoader) {
                return procClass;
            }
        }
        catch (SecurityException ex) {
            // empty catch block
        }
        return null;
    }

    public static PrimProcedure getMethodFor(Class procClass, String name, Declaration decl, Expression[] args, Language language) {
        return PrimProcedure.getMethodFor((ClassType)Type.make(procClass), name, decl, args, language);
    }

    public static PrimProcedure getMethodFor(ClassType procClass, String name, Declaration decl, Expression[] args, Language language) {
        int nargs = args.length;
        Type[] atypes = new Type[nargs];
        int i = nargs;
        while (--i >= 0) {
            atypes[i] = args[i].getType();
        }
        return PrimProcedure.getMethodFor(procClass, name, decl, atypes, language);
    }

    public static PrimProcedure getMethodFor(ClassType procClass, String name, Declaration decl, Type[] atypes, Language language) {
        PrimProcedure best = null;
        int bestCode = -1;
        boolean bestIsApply = false;
        try {
            if (name == null) {
                return null;
            }
            String mangledName = Mangling.mangleName(name);
            String mangledNameV = mangledName + "$V";
            String mangledNameVX = mangledName + "$V$X";
            String mangledNameX = mangledName + "$X";
            boolean applyOk = true;
            for (gnu.bytecode.Method meth = procClass.getDeclaredMethods(); meth != null; meth = meth.getNext()) {
                boolean isApply;
                int mods = meth.getModifiers();
                if ((mods & 9) != 9 && (decl == null || decl.base == null)) continue;
                String mname = meth.getName();
                if (mname.equals(mangledName) || mname.equals(mangledNameV) || mname.equals(mangledNameX) || mname.equals(mangledNameVX)) {
                    isApply = false;
                } else {
                    if (!applyOk || !mname.equals("apply") && !mname.equals("apply$V")) continue;
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
                PrimProcedure prproc = new PrimProcedure(meth, language);
                prproc.setName(name);
                int code = prproc.isApplicable(atypes, null);
                if (code < 0 || code < bestCode) continue;
                if (code > bestCode) {
                    best = prproc;
                } else if (best != null && (best = (PrimProcedure)MethodProc.mostSpecific(best, prproc)) == null && bestCode > 0) {
                    return null;
                }
                bestCode = code;
                bestIsApply = isApply;
            }
        }
        catch (SecurityException ex) {
            // empty catch block
        }
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
        StringBuffer buf = new StringBuffer(100);
        if (this.method == null) {
            buf.append("<op ");
            buf.append(this.op_code);
            buf.append('>');
        } else {
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
        StringBuffer buf = new StringBuffer(100);
        buf.append(this.retType == null ? "<unknown>" : this.retType.getName());
        buf.append(' ');
        buf.append(this.getVerboseName());
        return buf.toString();
    }

    public void print(PrintWriter ps) {
        ps.print("#<primitive procedure ");
        ps.print(this.toString());
        ps.print('>');
    }
}

