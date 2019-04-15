/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.AnnotationEntry;
import gnu.bytecode.AttrContainer;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.PrimType;
import gnu.bytecode.RuntimeAnnotationsAttr;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.AccessExp;
import gnu.expr.ApplyExp;
import gnu.expr.BindingInitializer;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.FluidLetExp;
import gnu.expr.IgnoreTarget;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LitTable;
import gnu.expr.Literal;
import gnu.expr.Mangling;
import gnu.expr.ModuleExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.expr.Target;
import gnu.expr.ThisExp;
import gnu.expr.TypeValue;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.CompileArith;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.io.OutPort;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.SourceLocator;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import kawa.SourceType;

public class Declaration
implements SourceLocator {
    static int counter;
    protected int id = ++counter;
    Object symbol;
    public ScopeExp context;
    protected Type type;
    protected Expression typeExp;
    private Declaration next;
    int evalIndex;
    Variable var;
    int scanNesting;
    Declaration nextCapturedVar;
    public Declaration base;
    public gnu.bytecode.Field field;
    public Method getterMethod;
    public Method setterMethod;
    static final Method getLocationMethod;
    static final String UNKNOWN_PREFIX = "loc$";
    public static final String PRIVATE_PREFIX = "$Prvt$";
    static final int INDIRECT_BINDING = 1;
    static final int CAN_READ = 2;
    static final int CAN_CALL = 4;
    static final int CAN_WRITE = 8;
    static final int IS_FLUID = 16;
    static final int PRIVATE = 32;
    static final int IS_SIMPLE = 64;
    public static final int PROCEDURE = 128;
    public static final int IS_ALIAS = 256;
    public static final int NOT_DEFINING = 512;
    public static final int EXPORT_SPECIFIED = 1024;
    public static final int STATIC_SPECIFIED = 2048;
    public static final int NONSTATIC_SPECIFIED = 4096;
    public static final int TYPE_SPECIFIED = 8192;
    public static final int IS_CONSTANT = 16384;
    public static final int IS_SYNTAX = 32768;
    public static final int IS_UNKNOWN = 65536;
    public static final int IS_IMPORTED = 131072;
    public static final int IS_CAPTURED = 131072;
    public static final int IS_SINGLE_VALUE = 262144;
    public static final int EXTERNAL_ACCESS = 524288;
    public static final int FIELD_OR_METHOD = 1048576;
    public static final int IS_NAMESPACE_PREFIX = 2097152;
    public static final int PRIVATE_ACCESS = 16777216;
    public static final int PRIVATE_SPECIFIED = 16777216;
    public static final int PROTECTED_ACCESS = 33554432;
    public static final int PUBLIC_ACCESS = 67108864;
    public static final int PACKAGE_ACCESS = 134217728;
    public static final int IS_DYNAMIC = 268435456;
    public static final int EARLY_INIT = 536870912;
    public static final int MODULE_REFERENCE = 1073741824;
    public static final long VOLATILE_ACCESS = 0x80000000L;
    public static final long TRANSIENT_ACCESS = 0x100000000L;
    public static final long ENUM_ACCESS = 0x200000000L;
    public static final long FINAL_ACCESS = 0x400000000L;
    public static final long ABSTRACT_ACCESS = 0x800000000L;
    public static final long SYNCHRONIZED_ACCESS = 0x1000000000L;
    public static final long STRICTFP_ACCESS = 0x2000000000L;
    public static final long CLASS_ACCESS_FLAGS = 60179873792L;
    public static final long FIELD_ACCESS_FLAGS = 32463912960L;
    public static final long METHOD_ACCESS_FLAGS = 223589957632L;
    public static final long MAYBE_UNINITIALIZED_ACCESS = 0x4000000000L;
    public static final long ALLOCATE_ON_STACK = 0x8000000000L;
    public static final long PATTERN_NESTED = 0x10000000000L;
    public static final long SKIP_FOR_METHOD_PARAMETER = 0x20000000000L;
    public static final long IS_REST_PARAMETER = 0x40000000000L;
    public static final long IS_PARAMETER = 0x80000000000L;
    public static final long DONT_COPY = 0x10000000000L;
    protected long flags = 64L;
    int numReferences;
    public ApplyExp firstCall;
    List<Expression> annotations;
    Method makeLocationMethod = null;
    String filename;
    int position;
    private Expression initValue;
    ValueSource[] values;
    int nvalues;
    static final ValueSource unknownValueInstance;
    static final ValueSource[] unknownValueValues;

    public void setCode(int code) {
        if (code >= 0) {
            throw new Error("code must be negative");
        }
        this.id = code;
    }

    public int getCode() {
        return this.id;
    }

    public final Expression getTypeExp() {
        if (this.typeExp == null) {
            this.setType(Type.objectType);
        }
        return this.typeExp;
    }

    public final Type getType() {
        if (this.type == null) {
            Type t = Type.objectType;
            this.type = t;
            if (!this.hasUnknownValue() && this.nvalues > 0) {
                int arithCount = 0;
                for (int i = 0; i < this.nvalues; ++i) {
                    Expression oparg;
                    Declaration d;
                    Expression vi = this.values[i].getValue(this);
                    boolean arithOp = false;
                    if (vi != null && !vi.getFlag(1) && (oparg = this.checkArithStepOp(vi)) != null) {
                        arithOp = true;
                        ++arithCount;
                        vi = oparg;
                    }
                    if (vi != null && vi.getFlag(1) || vi instanceof LambdaExp || vi instanceof QuoteExp || vi instanceof ReferenceExp && (d = ((ReferenceExp)vi).getBinding()) != null && d.type != null) {
                        Type vt = vi.getType();
                        if (i == 0) {
                            t = vt;
                            continue;
                        }
                        if (arithOp) {
                            t = CompileArith.combineType(t, vt);
                            continue;
                        }
                        t = Language.unionType(t, vt);
                        continue;
                    }
                    t = Type.objectType;
                    break;
                }
            }
            this.setType(t);
        }
        return this.type;
    }

    private Expression checkArithStepOp(Expression exp) {
        Compilation comp;
        boolean isApplyFunc;
        if (!(exp instanceof ApplyExp)) {
            return null;
        }
        ApplyExp aexp = (ApplyExp)exp;
        Expression func = aexp.getFunction();
        if (aexp.getArgCount() == ((isApplyFunc = (comp = Compilation.getCurrent()).isSimpleApplyFunction(func)) ? 3 : 2)) {
            Object proc;
            Declaration fdecl;
            if (isApplyFunc) {
                func = aexp.getArg(0);
            }
            if (func instanceof ReferenceExp && (fdecl = ((ReferenceExp)func).getBinding()) != null && fdecl.getValue() != null && ((proc = fdecl.getValue().valueIfConstant()) instanceof AddOp || proc instanceof MultiplyOp)) {
                Expression arg1 = aexp.getArg(isApplyFunc ? 1 : 0);
                Expression arg2 = aexp.getArg(isApplyFunc ? 2 : 1);
                if (arg1 instanceof ReferenceExp && ((ReferenceExp)arg1).getBinding() == this) {
                    return arg2;
                }
                if (arg2 instanceof ReferenceExp && ((ReferenceExp)arg2).getBinding() == this) {
                    return arg1;
                }
            }
        }
        return null;
    }

    public Expression getTypeExpRaw() {
        return this.typeExp;
    }

    public final void setType(Type type) {
        if (type.isVoid()) {
            type = Type.objectType;
        }
        this.type = type;
        this.typeExp = QuoteExp.getInstance(type);
    }

    public final void setTypeExp(Expression typeExp) {
        this.typeExp = typeExp;
        Type t = null;
        t = typeExp instanceof TypeValue ? ((TypeValue)((Object)typeExp)).getImplementationType() : Language.getDefaultLanguage().getTypeFor(typeExp, false);
        if (t == null) {
            t = Type.pointer_type;
        }
        this.type = t;
        if (this.var != null) {
            this.var.setType(t);
        }
    }

    public final void setType(Expression typeExp, Type type) {
        this.typeExp = typeExp;
        this.type = type;
    }

    public final String getName() {
        return this.symbol == null ? null : (this.symbol instanceof Symbol ? ((Symbol)this.symbol).getName() : this.symbol.toString());
    }

    public final void setName(Object symbol) {
        this.symbol = symbol;
    }

    public final Object getSymbol() {
        return this.symbol;
    }

    public final void setSymbol(Object symbol) {
        this.symbol = symbol;
    }

    public final Declaration nextDecl() {
        return this.next;
    }

    public final void setNext(Declaration next) {
        this.next = next;
    }

    public Variable getVariable() {
        return this.var;
    }

    public int getScanNesting() {
        return this.scanNesting;
    }

    public void setScanNesting(int value) {
        this.scanNesting = value;
    }

    public final boolean isSimple() {
        return (this.flags & 64L) != 0L;
    }

    public final void setSimple(boolean b) {
        this.setFlag(b, 64L);
        if (this.var != null && !this.var.isParameter()) {
            this.var.setSimple(b);
        }
    }

    public final void setSyntax() {
        this.setSimple(false);
        this.setFlag(536920064L);
    }

    public final ScopeExp getContext() {
        return this.context;
    }

    void loadOwningObject(Declaration owner, Compilation comp) {
        if (owner == null) {
            owner = this.base;
        }
        if (owner != null) {
            owner.load(null, 0, comp, Target.pushObject);
        } else {
            this.getContext().currentLambda().loadHeapFrame(comp);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void load(AccessExp access, int flags, Compilation comp, Target target) {
        Type rtype;
        if (target instanceof IgnoreTarget) {
            if (!access.getFlag(32)) return;
            comp.getCode().emitPop(1);
            return;
        }
        Declaration owner = access == null ? null : access.contextDecl();
        Expression dvalue = this.getValueRaw();
        if (this.isAlias() && dvalue instanceof ReferenceExp) {
            ReferenceExp rexp = (ReferenceExp)dvalue;
            Declaration orig = rexp.binding;
            if (!(orig == null || (flags & 4) != 0 && !orig.isIndirectBinding() || owner != null && orig.needsContext())) {
                orig.load(rexp, flags, comp, target);
                return;
            }
        }
        if (this.isFluid() && this.context instanceof FluidLetExp) {
            this.base.load(access, flags, comp, target);
            return;
        }
        CodeAttr code = comp.getCode();
        boolean dontDeref = (flags & 4) != 0;
        Type type = rtype = dontDeref ? Compilation.typeLocation : this.getType();
        if (!this.isIndirectBinding() && dontDeref) {
            ClassType ltype;
            Method meth;
            if (this.field == null) {
                throw new Error("internal error: cannot take location of " + this);
            }
            boolean immediate = comp.immediate;
            if (this.field.getStaticFlag()) {
                ltype = Compilation.typeStaticFieldLocation;
                meth = ltype.getDeclaredMethod("make", immediate ? 1 : 2);
            } else {
                ltype = Compilation.typeFieldLocation;
                meth = ltype.getDeclaredMethod("make", immediate ? 2 : 3);
                this.loadOwningObject(owner, comp);
            }
            if (immediate) {
                comp.compileConstant(this);
            } else {
                comp.compileConstant(this.field.getDeclaringClass().getName());
                comp.compileConstant(this.field.getName());
            }
            code.emitInvokeStatic(meth);
            rtype = ltype;
        } else if (this.getFlag(0x8000000000L)) {
            int SP = code.getSP();
            if (!access.getFlag(32)) {
                if (SP == this.evalIndex) {
                    code.emitDup();
                } else {
                    if (SP != this.evalIndex + 1) throw new InternalError("allocate-on-stack mismatch");
                    code.emitSwap();
                    code.emitDupX();
                }
            }
        } else {
            Expression value = this.getValueRaw();
            if (this.type == Type.javalangClassType && (value instanceof ClassExp || value instanceof ModuleExp)) {
                comp.loadClassRef(((LambdaExp)value).getCompiledClassType(comp));
            } else if (this.field != null) {
                comp.usedClass(this.field.getDeclaringClass());
                comp.usedClass(this.field.getType());
                if (!this.field.getStaticFlag()) {
                    this.loadOwningObject(owner, comp);
                    code.emitGetField(this.field);
                } else {
                    code.emitGetStatic(this.field);
                }
                code.fixUnsigned(this.getType());
            } else if (this.isClassField()) {
                String getName = ClassExp.slotToMethodName("get", this.getName());
                Method getter = ((ClassExp)this.context).compiledType.getDeclaredMethod(getName, 0);
                comp.usedClass(getter.getDeclaringClass());
                comp.usedClass(getter.getReturnType());
                this.loadOwningObject(owner, comp);
                code.emitInvoke(getter);
            } else if (this.isIndirectBinding() && comp.immediate && this.getVariable() == null) {
                Environment env = Environment.getCurrent();
                Symbol sym = this.symbol instanceof Symbol ? (Symbol)this.symbol : env.getSymbol(this.symbol.toString());
                Object property = null;
                if (this.isProcedureDecl() && comp.getLanguage().hasSeparateFunctionNamespace()) {
                    property = EnvironmentKey.FUNCTION;
                }
                Location loc = env.getLocation(sym, property);
                comp.compileConstant(loc, Target.pushValue(Compilation.typeLocation));
            } else {
                Object val;
                if (comp.immediate && (val = this.getConstantValue()) != null) {
                    comp.compileConstant(val, target);
                    return;
                }
                if (value != QuoteExp.undefined_exp && value != null && this.ignorable() && !(value instanceof LambdaExp)) {
                    value.compile(comp, target);
                    return;
                }
                Variable var = this.getVariable();
                if (var == null) {
                    var = this.allocateVariable(code, true);
                }
                code.emitLoad(var);
            }
            if (this.isIndirectBinding() && !dontDeref) {
                String filename;
                int line;
                if (access != null && (filename = access.getFileName()) != null && (line = access.getLineNumber()) > 0) {
                    ClassType typeUnboundLocationException = ClassType.make("gnu.mapping.UnboundLocationException");
                    boolean isInTry = code.isInTry();
                    int column = access.getColumnNumber();
                    Label startTry = new Label(code);
                    startTry.define(code);
                    code.emitInvokeVirtual(getLocationMethod);
                    Label endTry = new Label(code);
                    endTry.define(code);
                    Label endLabel = new Label(code);
                    endLabel.setTypes(code);
                    if (isInTry) {
                        code.emitGoto(endLabel);
                    } else {
                        code.setUnreachable();
                    }
                    int fragment_cookie = 0;
                    if (!isInTry) {
                        fragment_cookie = code.beginFragment(endLabel);
                    }
                    code.addHandler(startTry, endTry, typeUnboundLocationException);
                    code.emitDup(typeUnboundLocationException);
                    code.emitPushString(filename);
                    code.emitPushInt(line);
                    code.emitPushInt(column);
                    code.emitInvokeVirtual(typeUnboundLocationException.getDeclaredMethod("setLine", 3));
                    code.emitThrow();
                    if (isInTry) {
                        endLabel.define(code);
                    } else {
                        code.endFragment(fragment_cookie);
                    }
                } else {
                    code.emitInvokeVirtual(getLocationMethod);
                }
                if (this.isAlias() || target.getType().getRawType() == Type.objectType) {
                    rtype = Type.objectType;
                } else {
                    this.getType().emitCoerceFromObject(code);
                    rtype = this.getType();
                }
            }
        }
        target.compileFromStack(comp, rtype);
    }

    public void compileStore(Compilation comp) {
        CodeAttr code = comp.getCode();
        if (this.isSimple()) {
            code.emitStore(this.getVariable());
        } else if (!this.field.getStaticFlag()) {
            this.loadOwningObject(null, comp);
            code.emitSwap();
            code.emitPutField(this.field);
        } else {
            code.emitPutStatic(this.field);
        }
    }

    boolean shouldEarlyInit() {
        return this.getFlag(0x20000000L) || this.isCompiletimeConstant();
    }

    public boolean isCompiletimeConstant() {
        return this.getFlag(16384L) && this.hasConstantValue();
    }

    public final boolean needsExternalAccess() {
        return (this.flags & 524320L) == 524320L || (this.flags & 0x200020L) == 0x200020L;
    }

    public final boolean needsContext() {
        return this.base == null && (this.isClassField() && !this.isStatic() || this.field != null && !this.field.getStaticFlag());
    }

    public final boolean getFlag(long flag) {
        return (this.flags & flag) != 0L;
    }

    public final void setFlag(boolean setting, long flag) {
        this.flags = setting ? (this.flags |= flag) : (this.flags &= flag ^ -1L);
    }

    public final void setFlag(long flag) {
        this.flags |= flag;
    }

    public final boolean isPublic() {
        return this.context instanceof ModuleExp && (this.flags & 32L) == 0L;
    }

    public final boolean isPrivate() {
        return (this.flags & 32L) != 0L;
    }

    public final boolean isModuleLocal() {
        return !this.isPublic() && !this.needsExternalAccess();
    }

    public final void setPrivate(boolean isPrivate) {
        this.setFlag(isPrivate, 32L);
    }

    public short getAccessFlags(short defaultFlags) {
        short flags;
        if (this.getFlag(0xF000000L)) {
            flags = 0;
            if (this.getFlag(0x1000000L)) {
                flags = (short)(flags | 2);
            }
            if (this.getFlag(0x2000000L)) {
                flags = (short)(flags | 4);
            }
            if (this.getFlag(0x4000000L)) {
                flags = (short)(flags | 1);
            }
        } else {
            flags = defaultFlags;
        }
        if (this.getFlag(0x80000000L)) {
            flags = (short)(flags | 64);
        }
        if (this.getFlag(0x100000000L)) {
            flags = (short)(flags | 128);
        }
        if (this.getFlag(0x200000000L)) {
            flags = (short)(flags | 16384);
        }
        if (this.getFlag(0x400000000L)) {
            flags = (short)(flags | 16);
        }
        if (this.getFlag(0x1000000000L)) {
            flags = (short)(flags | 32);
        }
        if (this.getFlag(0x2000000000L)) {
            flags = (short)(flags | 2048);
        }
        return flags;
    }

    public final boolean isAlias() {
        return (this.flags & 256L) != 0L;
    }

    public final void setAlias(boolean flag) {
        this.setFlag(flag, 256L);
    }

    public final boolean isFluid() {
        return (this.flags & 16L) != 0L;
    }

    public final void setFluid(boolean fluid) {
        this.setFlag(fluid, 16L);
    }

    public final boolean isProcedureDecl() {
        return (this.flags & 128L) != 0L;
    }

    public final void setProcedureDecl(boolean val) {
        this.setFlag(val, 128L);
    }

    public final boolean isClassMethod() {
        return (this.flags & 1048704L) == 1048704L;
    }

    public final boolean isClassField() {
        return (this.flags & 1048704L) == 0x100000L;
    }

    public final boolean isNamespaceDecl() {
        return (this.flags & 0x200000L) != 0L;
    }

    public final boolean parameterForMethod() {
        return !this.getFlag(0x20000000000L);
    }

    public final boolean isIndirectBinding() {
        return (this.flags & 1L) != 0L;
    }

    public final void setIndirectBinding(boolean indirectBinding) {
        this.setFlag(indirectBinding, 1L);
    }

    public void maybeIndirectBinding(Compilation comp) {
        if (this.isLexical() && !this.inExternalModule(comp) && !this.getFlag(8192L)) {
            this.setIndirectBinding(true);
        }
    }

    public boolean inExternalModule(Compilation comp) {
        return this.context instanceof ModuleExp && this.context != comp.mainLambda;
    }

    public final boolean getCanRead() {
        return (this.flags & 2L) != 0L;
    }

    public final void setCanRead(boolean read2) {
        this.setFlag(read2, 2L);
    }

    public final void setCanRead() {
        this.setFlag(true, 2L);
        if (this.base != null) {
            this.base.setCanRead();
        }
    }

    public final boolean getCanReadOrCall() {
        return (this.flags & 6L) != 0L;
    }

    public final boolean getCanCall() {
        return (this.flags & 4L) != 0L;
    }

    public final void setCanCall(boolean called) {
        this.setFlag(called, 4L);
    }

    public final void setCanCall() {
        this.setFlag(true, 4L);
        if (this.base != null) {
            this.base.setCanRead();
        }
    }

    public final boolean getCanWrite() {
        return (this.flags & 8L) != 0L;
    }

    public final void setCanWrite(boolean written) {
        this.flags = written ? (this.flags |= 8L) : (this.flags &= -9L);
    }

    public final void setCanWrite() {
        this.flags |= 8L;
        if (this.base != null) {
            this.base.setCanRead();
        }
    }

    public final boolean isThisParameter() {
        return this.symbol == ThisExp.THIS_NAME;
    }

    public boolean mayBeAccessedUninitialized() {
        return this.getFlag(0x4000000000L);
    }

    public boolean ignorable() {
        if (this.getCanRead() || this.isPublic()) {
            return false;
        }
        if (this.getCanWrite() && this.getFlag(65536L)) {
            return false;
        }
        if (!this.getCanCall()) {
            return true;
        }
        Expression value = this.getValue();
        if (value == null || !(value instanceof LambdaExp)) {
            return false;
        }
        LambdaExp lexp = (LambdaExp)value;
        return !lexp.isHandlingTailCalls() || lexp.getInlineOnly();
    }

    public boolean isStatic() {
        if (this.field != null) {
            return this.field.getStaticFlag();
        }
        if (this.getFlag(2048L) || this.isCompiletimeConstant()) {
            return true;
        }
        if (this.getFlag(4096L)) {
            return false;
        }
        LambdaExp lambda = this.context.currentLambda();
        return lambda instanceof ModuleExp && ((ModuleExp)lambda).isStatic();
    }

    public final boolean isLexical() {
        return (this.flags & 0x10010010L) == 0L;
    }

    public static final boolean isUnknown(Declaration decl) {
        return decl == null || decl.getFlag(65536L);
    }

    public void addCaller(ApplyExp exp) {
        exp.nextCall = this.firstCall;
        this.firstCall = exp;
    }

    public void clearCallList() {
        ApplyExp exp = this.firstCall;
        while (exp != null) {
            ApplyExp next = exp.nextCall;
            exp.nextCall = null;
            exp = next;
        }
        this.firstCall = null;
    }

    public Declaration(Object name, Type type) {
        this.setName(name);
        if (type != null) {
            this.setType(type);
        }
    }

    public Declaration(Variable var) {
        this((Object)var.getName(), var.getType());
        this.var = var;
    }

    public Declaration(Object name) {
        this(name, (Type)null);
    }

    public Declaration(Object name, gnu.bytecode.Field field) {
        this(name, field.getType());
        this.field = field;
        this.setSimple(false);
    }

    public int numAnnotations() {
        return this.annotations == null ? 0 : this.annotations.size();
    }

    public Expression getAnnotation(int i) {
        return this.annotations.get(i);
    }

    public <T extends Annotation> T getAnnotation(Class<T> clas) {
        int n = this.numAnnotations();
        for (int i = 0; i < n; ++i) {
            Object ann = this.getAnnotation(i).valueIfConstant();
            if (!clas.isInstance(ann)) continue;
            return (T)((Annotation)ann);
        }
        return null;
    }

    public AnnotationEntry getAnnotation(String className) {
        int n = this.numAnnotations();
        for (int i = 0; i < n; ++i) {
            AnnotationEntry ae;
            Object ann = this.getAnnotation(i).valueIfConstant();
            if (!(ann instanceof AnnotationEntry) || !className.equals((ae = (AnnotationEntry)Proxy.getInvocationHandler(ann)).getAnnotationType())) continue;
            return ae;
        }
        return null;
    }

    public void setAnnotation(int i, Expression ann) {
        this.annotations.set(i, ann);
    }

    public void addAnnotation(Expression exp) {
        if (this.annotations == null) {
            this.annotations = new ArrayList<Expression>();
        }
        this.annotations.add(exp);
    }

    public void compileAnnotations(AttrContainer container, ElementType etype) {
        if (container == null) {
            return;
        }
        int n = this.numAnnotations();
        for (int i = 0; i < n; ++i) {
            Object ann = this.getAnnotation(i).valueIfConstant();
            if (ann == null) continue;
            AnnotationEntry ae = (AnnotationEntry)Proxy.getInvocationHandler(ann);
            if (container == null || !ae.hasTarget(etype)) continue;
            RuntimeAnnotationsAttr.maybeAddAnnotation(container, ae);
        }
    }

    public void pushIndirectBinding(Compilation comp) {
        CodeAttr code = comp.getCode();
        code.emitPushString(this.getName());
        if (this.makeLocationMethod == null) {
            Type[] args = new Type[]{Type.pointer_type, Type.string_type};
            this.makeLocationMethod = Compilation.typeLocation.addMethod("make", args, Compilation.typeLocation, 9);
        }
        code.emitInvokeStatic(this.makeLocationMethod);
    }

    public final Variable allocateVariable(CodeAttr code) {
        return this.allocateVariable(code, false);
    }

    public final Variable allocateVariable(CodeAttr code, boolean autoPopScope) {
        if (!this.isSimple() || this.var == null) {
            String vname = null;
            if (this.symbol != null) {
                vname = Mangling.mangleNameIfNeeded(this.getName());
            }
            if (this.isAlias() && this.getValue() instanceof ReferenceExp) {
                Declaration base2 = Declaration.followAliases(this);
                this.var = base2 == null ? null : base2.var;
            } else {
                ClassType type = this.isIndirectBinding() ? Compilation.typeLocation : this.getType().getImplementationType();
                Scope scope = autoPopScope ? code.pushAutoPoppableScope() : this.context.getVarScope();
                this.var = scope.addVariable(code, type, vname);
            }
        }
        return this.var;
    }

    public final void setLocation(SourceLocator location2) {
        this.filename = location2.getFileName();
        this.setLine(location2.getLineNumber(), location2.getColumnNumber());
    }

    public final void setFile(String filename) {
        this.filename = filename;
    }

    public final void setLine(int lineno, int colno) {
        if (lineno < 0) {
            lineno = 0;
        }
        if (colno < 0) {
            colno = 0;
        }
        this.position = (lineno << 12) + colno;
    }

    public final void setLine(int lineno) {
        this.setLine(lineno, 0);
    }

    @Override
    public final String getFileName() {
        return this.filename;
    }

    @Override
    public String getPublicId() {
        return null;
    }

    @Override
    public String getSystemId() {
        return this.filename;
    }

    @Override
    public final int getLineNumber() {
        int line = this.position >> 12;
        return line == 0 ? -1 : line;
    }

    @Override
    public final int getColumnNumber() {
        int column = this.position & 4095;
        return column == 0 ? -1 : column;
    }

    @Override
    public boolean isStableSourceLocation() {
        return true;
    }

    public void printInfo(OutPort out) {
        StringBuffer sbuf = new StringBuffer();
        this.printInfo(sbuf);
        out.startLogicalBlock("", "", 2);
        out.print(sbuf.toString());
        int numAnnotations = this.numAnnotations();
        if (numAnnotations > 0) {
            out.writeSpaceLinear();
            out.print("Annotations:");
            for (int i = 0; i < numAnnotations; ++i) {
                out.writeSpaceLinear();
                this.annotations.get(i).print(out);
            }
        }
        out.endLogicalBlock("");
    }

    public void printInfo(StringBuffer sbuf) {
        sbuf.append(this.symbol);
        sbuf.append('/');
        sbuf.append(this.id);
        sbuf.append("/fl:");
        sbuf.append(Long.toHexString(this.flags));
        if (this.ignorable()) {
            sbuf.append("(ignorable)");
        }
        Expression tx = this.typeExp;
        Type t = this.type;
        if (tx != null && !(tx instanceof QuoteExp)) {
            sbuf.append("::");
            sbuf.append(tx);
        } else if (t != null && t != Type.pointer_type) {
            sbuf.append("::");
            sbuf.append(t.getName());
        }
        if (this.base != null) {
            sbuf.append("(base:#");
            sbuf.append(this.base.id);
            sbuf.append(')');
        }
    }

    public String toString() {
        return "Declaration[" + this.symbol + '/' + this.id + ']';
    }

    public static Declaration followAliases(Declaration decl) {
        Expression declValue;
        while (decl != null && decl.isAlias() && (declValue = decl.getValue()) instanceof ReferenceExp) {
            ReferenceExp rexp = (ReferenceExp)declValue;
            Declaration orig = rexp.binding;
            if (orig == null) break;
            decl = orig;
        }
        return decl;
    }

    public void makeField(Compilation comp, Expression value) {
        this.setSimple(false);
        this.makeField(comp.mainClass, comp, value);
    }

    public void makeField(ClassType frameType, Compilation comp, Expression value) {
        boolean external_access = this.needsExternalAccess();
        int fflags = 0;
        boolean isConstant = this.getFlag(16384L);
        boolean typeSpecified = this.getFlag(8192L);
        if (this.isPublic() || external_access || comp.immediate) {
            fflags |= true;
            if (comp.isInteractive() && this.context == comp.getModule() && !isConstant) {
                this.setIndirectBinding(true);
            }
        }
        if (this.isStatic() || this.getFlag(0x10010010L) && this.isIndirectBinding() && !this.isAlias() || value instanceof ClassExp && !((LambdaExp)value).getNeedsClosureEnv()) {
            fflags |= 8;
        }
        if ((this.isIndirectBinding() || isConstant && (this.shouldEarlyInit() || this.context instanceof ModuleExp && ((ModuleExp)this.context).staticInitRun())) && (this.context instanceof ClassExp || this.context instanceof ModuleExp)) {
            fflags |= 16;
        }
        Type ftype = this.getType().getImplementationType();
        if (this.isIndirectBinding() && !ftype.isSubtype(Compilation.typeLocation)) {
            if (ftype == null || ftype == Type.objectType) {
                ftype = Compilation.typeLocation;
            } else {
                if (ftype instanceof PrimType) {
                    ftype = ((PrimType)ftype).boxedType();
                }
                ftype = new ParameterizedType(Compilation.typeLocation, ftype);
            }
        }
        if (!this.ignorable()) {
            String encType;
            int nlength;
            boolean haveName;
            String dname = this.getName();
            String fname = dname;
            boolean bl = haveName = fname != null;
            if (fname == null) {
                fname = "$unnamed$0";
                nlength = fname.length() - 2;
            } else {
                fname = Mangling.mangleNameIfNeeded(fname);
                if (this.getFlag(65536L)) {
                    fname = UNKNOWN_PREFIX + fname;
                    haveName = false;
                }
                if (external_access && !this.getFlag(0x40000000L)) {
                    fname = PRIVATE_PREFIX + fname;
                    haveName = false;
                }
                nlength = fname.length();
            }
            int counter = 0;
            while (frameType.getDeclaredField(fname) != null) {
                fname = fname.substring(0, nlength) + '$' + ++counter;
            }
            this.field = frameType.addField(fname, ftype, fflags);
            if (this.getAnnotation(SourceType.class) == null && (encType = comp.getLanguage().encodeType(this.getType())) != null && encType.length() > 0) {
                AnnotationEntry ae = new AnnotationEntry(ClassType.make("kawa.SourceType"));
                ae.addMember("value", encType, Type.javalangStringType);
                RuntimeAnnotationsAttr.maybeAddAnnotation(this.field, ae);
            }
            if (haveName) {
                String prefix;
                String uri;
                boolean haveUri;
                boolean havePrefix;
                Object fsymbol = this.getSymbol();
                if (fsymbol instanceof Symbol) {
                    uri = ((Symbol)fsymbol).getNamespaceURI();
                    prefix = ((Symbol)fsymbol).getPrefix();
                    if (uri == null) {
                        uri = "";
                    }
                    haveUri = !"".equals(uri);
                    havePrefix = !"".equals(prefix);
                } else {
                    prefix = "";
                    uri = "";
                    havePrefix = false;
                    haveUri = false;
                }
                if (haveUri || havePrefix || !Mangling.demangleName(fname, true).equals(dname)) {
                    AnnotationEntry ae = new AnnotationEntry(ClassType.make("gnu.expr.SourceName"));
                    ae.addMember("name", dname, Type.javalangStringType);
                    if (haveUri) {
                        ae.addMember("uri", uri, Type.javalangStringType);
                    }
                    if (havePrefix) {
                        ae.addMember("prefix", prefix, Type.javalangStringType);
                    }
                    RuntimeAnnotationsAttr.maybeAddAnnotation(this.field, ae);
                }
            }
            if (value instanceof QuoteExp) {
                Object val = ((QuoteExp)value).getValue();
                if (this.field.getStaticFlag() && val != null && val.getClass().getName().equals(ftype.getName())) {
                    Literal literal = comp.litTable.findLiteral(val);
                    if (literal.field == null) {
                        literal.assign(this.field, comp.litTable);
                    }
                } else if (ftype instanceof PrimType || "java.lang.String".equals(ftype.getName())) {
                    if (val instanceof Char) {
                        val = IntNum.make(((Char)val).intValue());
                    }
                    this.field.setConstantValue(val, frameType);
                    return;
                }
            }
        }
        if (!this.shouldEarlyInit() && this.context instanceof ModuleExp && (this.isIndirectBinding() || value != null && !(value instanceof ClassExp))) {
            BindingInitializer.create(this, value, comp);
        }
    }

    Location makeIndirectLocationFor() {
        Symbol sym = this.symbol instanceof Symbol ? (Symbol)this.symbol : Namespace.EmptyNamespace.getSymbol(this.symbol.toString().intern());
        return Location.make(sym);
    }

    public static Declaration getDeclarationFromStatic(String cname, String fname) {
        ClassType clas = ClassType.make(cname);
        gnu.bytecode.Field fld = clas.getDeclaredField(fname);
        Declaration decl = new Declaration((Object)fname, fld);
        decl.setFlag(18432L);
        return decl;
    }

    public static Declaration getDeclarationValueFromStatic(String className, String fieldName, String name) {
        try {
            Class<?> cls = Class.forName(className);
            Field fld = cls.getDeclaredField(fieldName);
            Object value = fld.get(null);
            Declaration decl = new Declaration((Object)name, ClassType.make(className).getDeclaredField(fieldName));
            decl.noteValue(new QuoteExp(value));
            decl.setFlag(18432L);
            return decl;
        }
        catch (Exception ex) {
            throw new WrappedException(ex);
        }
    }

    public static Declaration getDeclaration(Named proc) {
        return Declaration.getDeclaration(proc, proc.getName());
    }

    public static Declaration getDeclaration(Object proc, String name) {
        Class procClass;
        int fflags;
        gnu.bytecode.Field procField = null;
        if (name != null && (procClass = PrimProcedure.getProcedureClass(proc)) != null) {
            ClassType procType = (ClassType)Type.make(procClass);
            String fname = Mangling.mangleNameIfNeeded(name);
            procField = procType.getDeclaredField(fname);
        }
        if (procField != null && ((fflags = procField.getModifiers()) & 8) != 0) {
            Declaration decl = new Declaration((Object)name, procField);
            decl.noteValue(new QuoteExp(proc));
            if ((fflags & 16) != 0) {
                decl.setFlag(16384L);
            }
            return decl;
        }
        return null;
    }

    public Expression getInitValue() {
        return this.initValue;
    }

    public void setInitValue(Expression init) {
        this.initValue = init;
    }

    public boolean hasUnknownValue() {
        return this.values == unknownValueValues;
    }

    public final Expression getValue() {
        if (this.nvalues == 0) {
            if (this.field != null && this.field.getDeclaringClass().isExisting() && (this.field.getModifiers() & 24) == 24 && !this.isIndirectBinding()) {
                try {
                    QuoteExp value = new QuoteExp(this.field.getReflectField().get(null));
                    this.noteValue(value);
                    return value;
                }
                catch (Exception ex) {
                    // empty catch block
                }
            }
            return QuoteExp.undefined_exp;
        }
        if (this.nvalues == 1) {
            return this.values[0].getValue(this);
        }
        return null;
    }

    public Expression getValueRaw() {
        if (this.nvalues == 0) {
            return QuoteExp.undefined_exp;
        }
        if (this.nvalues == 1) {
            return this.values[0].getValue(this);
        }
        return null;
    }

    public final void setValue(Expression value) {
        this.values = null;
        this.nvalues = 0;
        this.noteValue(value);
    }

    public final Object getConstantValue() {
        Expression v = this.getValue();
        if (!(v instanceof QuoteExp) || v == QuoteExp.undefined_exp) {
            return null;
        }
        return ((QuoteExp)v).getValue();
    }

    public final boolean hasConstantValue() {
        Expression v = this.getValue();
        return v instanceof QuoteExp && v != QuoteExp.undefined_exp;
    }

    public LambdaExp getLambdaValue() {
        Expression val;
        if (!this.isAlias() && this.nvalues == 1 && (val = this.values[0].getValue(this)) != null && val.getClass() == LambdaExp.class) {
            return (LambdaExp)val;
        }
        return null;
    }

    public void noteValue(Expression value) {
        this.checkNameDecl(value);
        if (value == null) {
            this.noteValueUnknown();
        } else if (this.values != unknownValueValues) {
            this.noteValue(new ValueSource(1, value, 0));
        }
    }

    void noteValue(ValueSource value) {
        if (this.values == unknownValueValues) {
            throw new InternalError();
        }
        if (this.values == null) {
            this.values = new ValueSource[4];
        } else if (this.nvalues >= this.values.length) {
            ValueSource[] tmp = new ValueSource[2 * this.nvalues];
            System.arraycopy(this.values, 0, tmp, 0, this.nvalues);
            this.values = tmp;
        }
        this.values[this.nvalues++] = value;
    }

    public void noteValueConstant(Object value) {
        if (this.values != unknownValueValues) {
            this.noteValue(new QuoteExp(value));
        }
    }

    public void noteValueUnknown() {
        this.checkNameDecl(null);
        this.values = unknownValueValues;
        this.nvalues = 1;
    }

    public void noteValueFromSet(SetExp setter) {
        if (this.values != unknownValueValues) {
            this.checkNameDecl(setter.new_value);
            setter.valueIndex = this.nvalues;
            this.noteValue(new ValueSource(2, setter, 0));
        }
    }

    public void noteValueFromLet(ScopeExp letter) {
        Expression init = this.getInitValue();
        if (init != QuoteExp.undefined_exp && this.values != unknownValueValues) {
            this.checkNameDecl(init);
            this.noteValue(new ValueSource(3, letter, 0));
        }
    }

    public void noteValueFromApply(ApplyExp app, int index) {
        if (this.values != unknownValueValues) {
            this.noteValue(new ValueSource(4, app, index));
        }
    }

    public boolean patchSymbolFromSet() {
        if (this.nvalues != 1 || this.values[0].kind != 2) {
            return false;
        }
        SetExp sexp = (SetExp)this.values[0].base;
        this.setSymbol(((SetExp)this.values[0].base).getSymbol());
        return true;
    }

    private void checkNameDecl(Expression value) {
        if (this.nvalues == 1) {
            Expression old = this.values[0].getValue(this);
            if (old == value) {
                return;
            }
            if (old instanceof LambdaExp) {
                ((LambdaExp)old).nameDecl = null;
            }
        }
        if (value instanceof LambdaExp) {
            ((LambdaExp)value).nameDecl = this.nvalues == 0 ? this : null;
        }
    }

    static {
        getLocationMethod = Compilation.typeLocation.addMethod("get", Type.typeArray0, Type.objectType, 1);
        unknownValueInstance = new ValueSource(0, null, 0);
        unknownValueValues = new ValueSource[]{unknownValueInstance};
    }

    public static class ValueSource {
        static final int UNKNOWN_KIND = 0;
        static final int GENERAL_KIND = 1;
        static final int SET_RHS_KIND = 2;
        static final int LET_INIT_KIND = 3;
        static final int APPLY_KIND = 4;
        public int kind;
        public Expression base;
        public int index;

        ValueSource(int kind, Expression base2, int index) {
            this.kind = kind;
            this.base = base2;
            this.index = index;
        }

        Expression getValue(Declaration decl) {
            switch (this.kind) {
                case 0: {
                    return null;
                }
                case 1: {
                    return this.base;
                }
                case 2: {
                    return ((SetExp)this.base).new_value;
                }
                case 3: {
                    return decl.getInitValue();
                }
                case 4: {
                    ApplyExp app = (ApplyExp)this.base;
                    int i = this.index;
                    Compilation comp = Compilation.getCurrent();
                    Expression afunc = app.getFunction();
                    if (comp.isSimpleApplyFunction(afunc)) {
                        ++i;
                    } else if (comp.isApplyFunction(afunc)) {
                        return null;
                    }
                    if (i >= app.getArgCount()) {
                        return null;
                    }
                    return app.getArg(i);
                }
            }
            throw new Error();
        }
    }

}

