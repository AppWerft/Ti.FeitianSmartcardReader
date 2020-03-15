// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.mapping.Named;
import gnu.mapping.WrappedException;
import gnu.mapping.Namespace;
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.SourceType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.PrimType;
import gnu.kawa.io.OutPort;
import gnu.bytecode.Scope;
import gnu.bytecode.RuntimeAnnotationsAttr;
import java.lang.annotation.ElementType;
import gnu.bytecode.AttrContainer;
import java.util.ArrayList;
import java.lang.reflect.Proxy;
import gnu.bytecode.AnnotationEntry;
import java.lang.annotation.Annotation;
import gnu.mapping.Location;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.ClassType;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Environment;
import gnu.bytecode.ObjectType;
import gnu.mapping.Symbol;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.CompileArith;
import java.util.List;
import gnu.bytecode.Method;
import gnu.bytecode.Field;
import gnu.bytecode.Variable;
import gnu.bytecode.Type;
import gnu.text.SourceLocator;

public class Declaration implements SourceLocator
{
    static int counter;
    protected int id;
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
    public Field field;
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
    public static final long VOLATILE_ACCESS = 2147483648L;
    public static final long TRANSIENT_ACCESS = 4294967296L;
    public static final long ENUM_ACCESS = 8589934592L;
    public static final long FINAL_ACCESS = 17179869184L;
    public static final long ABSTRACT_ACCESS = 34359738368L;
    public static final long SYNCHRONIZED_ACCESS = 68719476736L;
    public static final long STRICTFP_ACCESS = 137438953472L;
    public static final long CLASS_ACCESS_FLAGS = 60179873792L;
    public static final long FIELD_ACCESS_FLAGS = 32463912960L;
    public static final long METHOD_ACCESS_FLAGS = 223589957632L;
    public static final long MAYBE_UNINITIALIZED_ACCESS = 274877906944L;
    public static final long ALLOCATE_ON_STACK = 549755813888L;
    public static final long PATTERN_NESTED = 1099511627776L;
    public static final long SKIP_FOR_METHOD_PARAMETER = 2199023255552L;
    public static final long IS_REST_PARAMETER = 4398046511104L;
    public static final long IS_PARAMETER = 8796093022208L;
    public static final long DONT_COPY = 1099511627776L;
    protected long flags;
    int numReferences;
    public ApplyExp firstCall;
    List<Expression> annotations;
    Method makeLocationMethod;
    String filename;
    int position;
    private Expression initValue;
    ValueSource[] values;
    int nvalues;
    static final ValueSource unknownValueInstance;
    static final ValueSource[] unknownValueValues;
    
    public void setCode(final int code) {
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
                    Expression vi = this.values[i].getValue(this);
                    boolean arithOp = false;
                    if (vi != null && !vi.getFlag(1)) {
                        final Expression oparg = this.checkArithStepOp(vi);
                        if (oparg != null) {
                            arithOp = true;
                            ++arithCount;
                            vi = oparg;
                        }
                    }
                    final Declaration d;
                    if ((vi == null || !vi.getFlag(1)) && !(vi instanceof LambdaExp) && !(vi instanceof QuoteExp) && (!(vi instanceof ReferenceExp) || (d = ((ReferenceExp)vi).getBinding()) == null || d.type == null)) {
                        t = Type.objectType;
                        break;
                    }
                    final Type vt = vi.getType();
                    if (i == 0) {
                        t = vt;
                    }
                    else if (arithOp) {
                        t = CompileArith.combineType(t, vt);
                    }
                    else {
                        t = Language.unionType(t, vt);
                    }
                }
            }
            this.setType(t);
        }
        return this.type;
    }
    
    private Expression checkArithStepOp(final Expression exp) {
        if (!(exp instanceof ApplyExp)) {
            return null;
        }
        final ApplyExp aexp = (ApplyExp)exp;
        Expression func = aexp.getFunction();
        final Compilation comp = Compilation.getCurrent();
        final boolean isApplyFunc = comp.isSimpleApplyFunction(func);
        if (aexp.getArgCount() == (isApplyFunc ? 3 : 2)) {
            if (isApplyFunc) {
                func = aexp.getArg(0);
            }
            final Declaration fdecl;
            if (func instanceof ReferenceExp && (fdecl = ((ReferenceExp)func).getBinding()) != null && fdecl.getValue() != null) {
                final Object proc = fdecl.getValue().valueIfConstant();
                if (proc instanceof AddOp || proc instanceof MultiplyOp) {
                    final Expression arg1 = aexp.getArg(isApplyFunc ? 1 : 0);
                    final Expression arg2 = aexp.getArg(isApplyFunc ? 2 : 1);
                    if (arg1 instanceof ReferenceExp && ((ReferenceExp)arg1).getBinding() == this) {
                        return arg2;
                    }
                    if (arg2 instanceof ReferenceExp && ((ReferenceExp)arg2).getBinding() == this) {
                        return arg1;
                    }
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
    
    public final void setTypeExp(final Expression typeExp) {
        this.typeExp = typeExp;
        Type t = null;
        if (typeExp instanceof TypeValue) {
            t = ((TypeValue)typeExp).getImplementationType();
        }
        else {
            t = Language.getDefaultLanguage().getTypeFor(typeExp, false);
        }
        if (t == null) {
            t = Type.pointer_type;
        }
        this.type = t;
        if (this.var != null) {
            this.var.setType(t);
        }
    }
    
    public final void setType(final Expression typeExp, final Type type) {
        this.typeExp = typeExp;
        this.type = type;
    }
    
    public final String getName() {
        return (this.symbol == null) ? null : ((this.symbol instanceof Symbol) ? ((Symbol)this.symbol).getName() : this.symbol.toString());
    }
    
    public final void setName(final Object symbol) {
        this.symbol = symbol;
    }
    
    public final Object getSymbol() {
        return this.symbol;
    }
    
    public final void setSymbol(final Object symbol) {
        this.symbol = symbol;
    }
    
    public final Declaration nextDecl() {
        return this.next;
    }
    
    public final void setNext(final Declaration next) {
        this.next = next;
    }
    
    public Variable getVariable() {
        return this.var;
    }
    
    public int getScanNesting() {
        return this.scanNesting;
    }
    
    public void setScanNesting(final int value) {
        this.scanNesting = value;
    }
    
    public final boolean isSimple() {
        return (this.flags & 0x40L) != 0x0L;
    }
    
    public final void setSimple(final boolean b) {
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
    
    void loadOwningObject(Declaration owner, final Compilation comp) {
        if (owner == null) {
            owner = this.base;
        }
        if (owner != null) {
            owner.load(null, 0, comp, Target.pushObject);
        }
        else {
            this.getContext().currentLambda().loadHeapFrame(comp);
        }
    }
    
    public void load(final AccessExp access, final int flags, final Compilation comp, final Target target) {
        if (target instanceof IgnoreTarget) {
            if (access.getFlag(32)) {
                comp.getCode().emitPop(1);
            }
            return;
        }
        final Declaration owner = (access == null) ? null : access.contextDecl();
        final Expression dvalue = this.getValueRaw();
        if (this.isAlias() && dvalue instanceof ReferenceExp) {
            final ReferenceExp rexp = (ReferenceExp)dvalue;
            final Declaration orig = rexp.binding;
            if (orig != null && ((flags & 0x4) == 0x0 || orig.isIndirectBinding()) && (owner == null || !orig.needsContext())) {
                orig.load(rexp, flags, comp, target);
                return;
            }
        }
        if (this.isFluid() && this.context instanceof FluidLetExp) {
            this.base.load(access, flags, comp, target);
            return;
        }
        final CodeAttr code = comp.getCode();
        final boolean dontDeref = (flags & 0x4) != 0x0;
        Type rtype = dontDeref ? Compilation.typeLocation : this.getType();
        if (!this.isIndirectBinding() && dontDeref) {
            if (this.field == null) {
                throw new Error("internal error: cannot take location of " + this);
            }
            final boolean immediate = comp.immediate;
            ClassType ltype;
            Method meth;
            if (this.field.getStaticFlag()) {
                ltype = Compilation.typeStaticFieldLocation;
                meth = ltype.getDeclaredMethod("make", immediate ? 1 : 2);
            }
            else {
                ltype = Compilation.typeFieldLocation;
                meth = ltype.getDeclaredMethod("make", immediate ? 2 : 3);
                this.loadOwningObject(owner, comp);
            }
            if (immediate) {
                comp.compileConstant(this);
            }
            else {
                comp.compileConstant(this.field.getDeclaringClass().getName());
                comp.compileConstant(this.field.getName());
            }
            code.emitInvokeStatic(meth);
            rtype = ltype;
        }
        else if (this.getFlag(549755813888L)) {
            final int SP = code.getSP();
            if (!access.getFlag(32)) {
                if (SP == this.evalIndex) {
                    code.emitDup();
                }
                else {
                    if (SP != this.evalIndex + 1) {
                        throw new InternalError("allocate-on-stack mismatch");
                    }
                    code.emitSwap();
                    code.emitDupX();
                }
            }
        }
        else {
            final Expression value = this.getValueRaw();
            if (this.type == Type.javalangClassType && (value instanceof ClassExp || value instanceof ModuleExp)) {
                comp.loadClassRef(((LambdaExp)value).getCompiledClassType(comp));
            }
            else if (this.field != null) {
                comp.usedClass(this.field.getDeclaringClass());
                comp.usedClass(this.field.getType());
                if (!this.field.getStaticFlag()) {
                    this.loadOwningObject(owner, comp);
                    code.emitGetField(this.field);
                }
                else {
                    code.emitGetStatic(this.field);
                }
                code.fixUnsigned(this.getType());
            }
            else if (this.isClassField()) {
                final String getName = ClassExp.slotToMethodName("get", this.getName());
                final Method getter = ((ClassExp)this.context).compiledType.getDeclaredMethod(getName, 0);
                comp.usedClass(getter.getDeclaringClass());
                comp.usedClass(getter.getReturnType());
                this.loadOwningObject(owner, comp);
                code.emitInvoke(getter);
            }
            else if (this.isIndirectBinding() && comp.immediate && this.getVariable() == null) {
                final Environment env = Environment.getCurrent();
                final Symbol sym = (Symbol)((this.symbol instanceof Symbol) ? this.symbol : env.getSymbol(this.symbol.toString()));
                Object property = null;
                if (this.isProcedureDecl() && comp.getLanguage().hasSeparateFunctionNamespace()) {
                    property = EnvironmentKey.FUNCTION;
                }
                final Location loc = env.getLocation(sym, property);
                comp.compileConstant(loc, Target.pushValue(Compilation.typeLocation));
            }
            else {
                final Object val;
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
                final String filename;
                final int line;
                if (access != null && (filename = access.getFileName()) != null && (line = access.getLineNumber()) > 0) {
                    final ClassType typeUnboundLocationException = ClassType.make("gnu.mapping.UnboundLocationException");
                    final boolean isInTry = code.isInTry();
                    final int column = access.getColumnNumber();
                    final Label startTry = new Label(code);
                    startTry.define(code);
                    code.emitInvokeVirtual(Declaration.getLocationMethod);
                    final Label endTry = new Label(code);
                    endTry.define(code);
                    final Label endLabel = new Label(code);
                    endLabel.setTypes(code);
                    if (isInTry) {
                        code.emitGoto(endLabel);
                    }
                    else {
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
                    }
                    else {
                        code.endFragment(fragment_cookie);
                    }
                }
                else {
                    code.emitInvokeVirtual(Declaration.getLocationMethod);
                }
                if (this.isAlias() || target.getType().getRawType() == Type.objectType) {
                    rtype = Type.objectType;
                }
                else {
                    this.getType().emitCoerceFromObject(code);
                    rtype = this.getType();
                }
            }
        }
        target.compileFromStack(comp, rtype);
    }
    
    public void compileStore(final Compilation comp) {
        final CodeAttr code = comp.getCode();
        if (this.isSimple()) {
            code.emitStore(this.getVariable());
        }
        else if (!this.field.getStaticFlag()) {
            this.loadOwningObject(null, comp);
            code.emitSwap();
            code.emitPutField(this.field);
        }
        else {
            code.emitPutStatic(this.field);
        }
    }
    
    boolean shouldEarlyInit() {
        return this.getFlag(536870912L) || this.isCompiletimeConstant();
    }
    
    public boolean isCompiletimeConstant() {
        return this.getFlag(16384L) && this.hasConstantValue();
    }
    
    public final boolean needsExternalAccess() {
        return (this.flags & 0x80020L) == 0x80020L || (this.flags & 0x200020L) == 0x200020L;
    }
    
    public final boolean needsContext() {
        return this.base == null && ((this.isClassField() && !this.isStatic()) || (this.field != null && !this.field.getStaticFlag()));
    }
    
    public final boolean getFlag(final long flag) {
        return (this.flags & flag) != 0x0L;
    }
    
    public final void setFlag(final boolean setting, final long flag) {
        if (setting) {
            this.flags |= flag;
        }
        else {
            this.flags &= ~flag;
        }
    }
    
    public final void setFlag(final long flag) {
        this.flags |= flag;
    }
    
    public final boolean isPublic() {
        return this.context instanceof ModuleExp && (this.flags & 0x20L) == 0x0L;
    }
    
    public final boolean isPrivate() {
        return (this.flags & 0x20L) != 0x0L;
    }
    
    public final boolean isModuleLocal() {
        return !this.isPublic() && !this.needsExternalAccess();
    }
    
    public final void setPrivate(final boolean isPrivate) {
        this.setFlag(isPrivate, 32L);
    }
    
    public short getAccessFlags(final short defaultFlags) {
        short flags;
        if (this.getFlag(251658240L)) {
            flags = 0;
            if (this.getFlag(16777216L)) {
                flags |= 0x2;
            }
            if (this.getFlag(33554432L)) {
                flags |= 0x4;
            }
            if (this.getFlag(67108864L)) {
                flags |= 0x1;
            }
        }
        else {
            flags = defaultFlags;
        }
        if (this.getFlag(2147483648L)) {
            flags |= 0x40;
        }
        if (this.getFlag(4294967296L)) {
            flags |= 0x80;
        }
        if (this.getFlag(8589934592L)) {
            flags |= 0x4000;
        }
        if (this.getFlag(17179869184L)) {
            flags |= 0x10;
        }
        if (this.getFlag(68719476736L)) {
            flags |= 0x20;
        }
        if (this.getFlag(137438953472L)) {
            flags |= 0x800;
        }
        return flags;
    }
    
    public final boolean isAlias() {
        return (this.flags & 0x100L) != 0x0L;
    }
    
    public final void setAlias(final boolean flag) {
        this.setFlag(flag, 256L);
    }
    
    public final boolean isFluid() {
        return (this.flags & 0x10L) != 0x0L;
    }
    
    public final void setFluid(final boolean fluid) {
        this.setFlag(fluid, 16L);
    }
    
    public final boolean isProcedureDecl() {
        return (this.flags & 0x80L) != 0x0L;
    }
    
    public final void setProcedureDecl(final boolean val) {
        this.setFlag(val, 128L);
    }
    
    public final boolean isClassMethod() {
        return (this.flags & 0x100080L) == 0x100080L;
    }
    
    public final boolean isClassField() {
        return (this.flags & 0x100080L) == 0x100000L;
    }
    
    public final boolean isNamespaceDecl() {
        return (this.flags & 0x200000L) != 0x0L;
    }
    
    public final boolean parameterForMethod() {
        return !this.getFlag(2199023255552L);
    }
    
    public final boolean isIndirectBinding() {
        return (this.flags & 0x1L) != 0x0L;
    }
    
    public final void setIndirectBinding(final boolean indirectBinding) {
        this.setFlag(indirectBinding, 1L);
    }
    
    public void maybeIndirectBinding(final Compilation comp) {
        if (this.isLexical() && !this.inExternalModule(comp) && !this.getFlag(8192L)) {
            this.setIndirectBinding(true);
        }
    }
    
    public boolean inExternalModule(final Compilation comp) {
        return this.context instanceof ModuleExp && this.context != comp.mainLambda;
    }
    
    public final boolean getCanRead() {
        return (this.flags & 0x2L) != 0x0L;
    }
    
    public final void setCanRead(final boolean read) {
        this.setFlag(read, 2L);
    }
    
    public final void setCanRead() {
        this.setFlag(true, 2L);
        if (this.base != null) {
            this.base.setCanRead();
        }
    }
    
    public final boolean getCanReadOrCall() {
        return (this.flags & 0x6L) != 0x0L;
    }
    
    public final boolean getCanCall() {
        return (this.flags & 0x4L) != 0x0L;
    }
    
    public final void setCanCall(final boolean called) {
        this.setFlag(called, 4L);
    }
    
    public final void setCanCall() {
        this.setFlag(true, 4L);
        if (this.base != null) {
            this.base.setCanRead();
        }
    }
    
    public final boolean getCanWrite() {
        return (this.flags & 0x8L) != 0x0L;
    }
    
    public final void setCanWrite(final boolean written) {
        if (written) {
            this.flags |= 0x8L;
        }
        else {
            this.flags &= 0xFFFFFFFFFFFFFFF7L;
        }
    }
    
    public final void setCanWrite() {
        this.flags |= 0x8L;
        if (this.base != null) {
            this.base.setCanRead();
        }
    }
    
    public final boolean isThisParameter() {
        return this.symbol == ThisExp.THIS_NAME;
    }
    
    public boolean mayBeAccessedUninitialized() {
        return this.getFlag(274877906944L);
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
        final Expression value = this.getValue();
        if (value == null || !(value instanceof LambdaExp)) {
            return false;
        }
        final LambdaExp lexp = (LambdaExp)value;
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
        final LambdaExp lambda = this.context.currentLambda();
        return lambda instanceof ModuleExp && ((ModuleExp)lambda).isStatic();
    }
    
    public final boolean isLexical() {
        return (this.flags & 0x10010010L) == 0x0L;
    }
    
    public static final boolean isUnknown(final Declaration decl) {
        return decl == null || decl.getFlag(65536L);
    }
    
    public void addCaller(final ApplyExp exp) {
        exp.nextCall = this.firstCall;
        this.firstCall = exp;
    }
    
    public void clearCallList() {
        ApplyExp next;
        for (ApplyExp exp = this.firstCall; exp != null; exp = next) {
            next = exp.nextCall;
            exp.nextCall = null;
        }
        this.firstCall = null;
    }
    
    public Declaration(final Object name, final Type type) {
        this.id = ++Declaration.counter;
        this.flags = 64L;
        this.makeLocationMethod = null;
        this.setName(name);
        if (type != null) {
            this.setType(type);
        }
    }
    
    public Declaration(final Variable var) {
        this(var.getName(), var.getType());
        this.var = var;
    }
    
    public Declaration(final Object name) {
        this(name, (Type)null);
    }
    
    public Declaration(final Object name, final Field field) {
        this(name, field.getType());
        this.field = field;
        this.setSimple(false);
    }
    
    public int numAnnotations() {
        return (this.annotations == null) ? 0 : this.annotations.size();
    }
    
    public Expression getAnnotation(final int i) {
        return this.annotations.get(i);
    }
    
    public <T extends Annotation> T getAnnotation(final Class<T> clas) {
        for (int n = this.numAnnotations(), i = 0; i < n; ++i) {
            final Object ann = this.getAnnotation(i).valueIfConstant();
            if (clas.isInstance(ann)) {
                return (T)ann;
            }
        }
        return null;
    }
    
    public AnnotationEntry getAnnotation(final String className) {
        for (int n = this.numAnnotations(), i = 0; i < n; ++i) {
            final Object ann = this.getAnnotation(i).valueIfConstant();
            if (ann instanceof AnnotationEntry) {
                final AnnotationEntry ae = (AnnotationEntry)Proxy.getInvocationHandler(ann);
                if (className.equals(ae.getAnnotationType())) {
                    return ae;
                }
            }
        }
        return null;
    }
    
    public void setAnnotation(final int i, final Expression ann) {
        this.annotations.set(i, ann);
    }
    
    public void addAnnotation(final Expression exp) {
        if (this.annotations == null) {
            this.annotations = new ArrayList<Expression>();
        }
        this.annotations.add(exp);
    }
    
    public void compileAnnotations(final AttrContainer container, final ElementType etype) {
        if (container == null) {
            return;
        }
        for (int n = this.numAnnotations(), i = 0; i < n; ++i) {
            final Object ann = this.getAnnotation(i).valueIfConstant();
            if (ann != null) {
                final AnnotationEntry ae = (AnnotationEntry)Proxy.getInvocationHandler(ann);
                if (container != null && ae.hasTarget(etype)) {
                    RuntimeAnnotationsAttr.maybeAddAnnotation(container, ae);
                }
            }
        }
    }
    
    public void pushIndirectBinding(final Compilation comp) {
        final CodeAttr code = comp.getCode();
        code.emitPushString(this.getName());
        if (this.makeLocationMethod == null) {
            final Type[] args = { Type.pointer_type, Type.string_type };
            this.makeLocationMethod = Compilation.typeLocation.addMethod("make", args, Compilation.typeLocation, 9);
        }
        code.emitInvokeStatic(this.makeLocationMethod);
    }
    
    public final Variable allocateVariable(final CodeAttr code) {
        return this.allocateVariable(code, false);
    }
    
    public final Variable allocateVariable(final CodeAttr code, final boolean autoPopScope) {
        if (!this.isSimple() || this.var == null) {
            String vname = null;
            if (this.symbol != null) {
                vname = Mangling.mangleNameIfNeeded(this.getName());
            }
            if (this.isAlias() && this.getValue() instanceof ReferenceExp) {
                final Declaration base = followAliases(this);
                this.var = ((base == null) ? null : base.var);
            }
            else {
                final Type type = this.isIndirectBinding() ? Compilation.typeLocation : this.getType().getImplementationType();
                final Scope scope = autoPopScope ? code.pushAutoPoppableScope() : this.context.getVarScope();
                this.var = scope.addVariable(code, type, vname);
            }
        }
        return this.var;
    }
    
    public final void setLocation(final SourceLocator location) {
        this.filename = location.getFileName();
        this.setLine(location.getLineNumber(), location.getColumnNumber());
    }
    
    public final void setFile(final String filename) {
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
    
    public final void setLine(final int lineno) {
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
        final int line = this.position >> 12;
        return (line == 0) ? -1 : line;
    }
    
    @Override
    public final int getColumnNumber() {
        final int column = this.position & 0xFFF;
        return (column == 0) ? -1 : column;
    }
    
    @Override
    public boolean isStableSourceLocation() {
        return true;
    }
    
    public void printInfo(final OutPort out) {
        final StringBuffer sbuf = new StringBuffer();
        this.printInfo(sbuf);
        out.startLogicalBlock("", "", 2);
        out.print(sbuf.toString());
        final int numAnnotations = this.numAnnotations();
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
    
    public void printInfo(final StringBuffer sbuf) {
        sbuf.append(this.symbol);
        sbuf.append('/');
        sbuf.append(this.id);
        sbuf.append("/fl:");
        sbuf.append(Long.toHexString(this.flags));
        if (this.ignorable()) {
            sbuf.append("(ignorable)");
        }
        final Expression tx = this.typeExp;
        final Type t = this.type;
        if (tx != null && !(tx instanceof QuoteExp)) {
            sbuf.append("::");
            sbuf.append(tx);
        }
        else if (t != null && t != Type.pointer_type) {
            sbuf.append("::");
            sbuf.append(t.getName());
        }
        if (this.base != null) {
            sbuf.append("(base:#");
            sbuf.append(this.base.id);
            sbuf.append(')');
        }
    }
    
    @Override
    public String toString() {
        return "Declaration[" + this.symbol + '/' + this.id + ']';
    }
    
    public static Declaration followAliases(Declaration decl) {
        while (decl != null && decl.isAlias()) {
            final Expression declValue = decl.getValue();
            if (!(declValue instanceof ReferenceExp)) {
                break;
            }
            final ReferenceExp rexp = (ReferenceExp)declValue;
            final Declaration orig = rexp.binding;
            if (orig == null) {
                break;
            }
            decl = orig;
        }
        return decl;
    }
    
    public void makeField(final Compilation comp, final Expression value) {
        this.setSimple(false);
        this.makeField(comp.mainClass, comp, value);
    }
    
    public void makeField(final ClassType frameType, final Compilation comp, final Expression value) {
        final boolean external_access = this.needsExternalAccess();
        int fflags = 0;
        final boolean isConstant = this.getFlag(16384L);
        final boolean typeSpecified = this.getFlag(8192L);
        if (this.isPublic() || external_access || comp.immediate) {
            fflags |= 0x1;
            if (comp.isInteractive() && this.context == comp.getModule() && !isConstant) {
                this.setIndirectBinding(true);
            }
        }
        if (this.isStatic() || (this.getFlag(268501008L) && this.isIndirectBinding() && !this.isAlias()) || (value instanceof ClassExp && !((LambdaExp)value).getNeedsClosureEnv())) {
            fflags |= 0x8;
        }
        if ((this.isIndirectBinding() || (isConstant && (this.shouldEarlyInit() || (this.context instanceof ModuleExp && ((ModuleExp)this.context).staticInitRun())))) && (this.context instanceof ClassExp || this.context instanceof ModuleExp)) {
            fflags |= 0x10;
        }
        Type ftype = this.getType().getImplementationType();
        if (this.isIndirectBinding() && !ftype.isSubtype(Compilation.typeLocation)) {
            if (ftype == null || ftype == Type.objectType) {
                ftype = Compilation.typeLocation;
            }
            else {
                if (ftype instanceof PrimType) {
                    ftype = ((PrimType)ftype).boxedType();
                }
                ftype = new ParameterizedType(Compilation.typeLocation, new Type[] { ftype });
            }
        }
        if (!this.ignorable()) {
            String fname;
            final String dname = fname = this.getName();
            boolean haveName = fname != null;
            int nlength;
            if (fname == null) {
                fname = "$unnamed$0";
                nlength = fname.length() - 2;
            }
            else {
                fname = Mangling.mangleNameIfNeeded(fname);
                if (this.getFlag(65536L)) {
                    fname = "loc$" + fname;
                    haveName = false;
                }
                if (external_access && !this.getFlag(1073741824L)) {
                    fname = "$Prvt$" + fname;
                    haveName = false;
                }
                nlength = fname.length();
            }
            for (int counter = 0; frameType.getDeclaredField(fname) != null; fname = fname.substring(0, nlength) + '$' + ++counter) {}
            this.field = frameType.addField(fname, ftype, fflags);
            if (this.getAnnotation(SourceType.class) == null) {
                final String encType = comp.getLanguage().encodeType(this.getType());
                if (encType != null && encType.length() > 0) {
                    final AnnotationEntry ae = new AnnotationEntry(ClassType.make("kawa.SourceType"));
                    ae.addMember("value", encType, Type.javalangStringType);
                    RuntimeAnnotationsAttr.maybeAddAnnotation(this.field, ae);
                }
            }
            if (haveName) {
                final Object fsymbol = this.getSymbol();
                String uri;
                String prefix;
                boolean haveUri;
                boolean havePrefix;
                if (fsymbol instanceof Symbol) {
                    uri = ((Symbol)fsymbol).getNamespaceURI();
                    prefix = ((Symbol)fsymbol).getPrefix();
                    if (uri == null) {
                        uri = "";
                    }
                    haveUri = !"".equals(uri);
                    havePrefix = !"".equals(prefix);
                }
                else {
                    prefix = (uri = "");
                    havePrefix = (haveUri = false);
                }
                if (haveUri || havePrefix || !Mangling.demangleName(fname, true).equals(dname)) {
                    final AnnotationEntry ae2 = new AnnotationEntry(ClassType.make("gnu.expr.SourceName"));
                    ae2.addMember("name", dname, Type.javalangStringType);
                    if (haveUri) {
                        ae2.addMember("uri", uri, Type.javalangStringType);
                    }
                    if (havePrefix) {
                        ae2.addMember("prefix", prefix, Type.javalangStringType);
                    }
                    RuntimeAnnotationsAttr.maybeAddAnnotation(this.field, ae2);
                }
            }
            if (value instanceof QuoteExp) {
                Object val = ((QuoteExp)value).getValue();
                if (this.field.getStaticFlag() && val != null && val.getClass().getName().equals(ftype.getName())) {
                    final Literal literal = comp.litTable.findLiteral(val);
                    if (literal.field == null) {
                        literal.assign(this.field, comp.litTable);
                    }
                }
                else if (ftype instanceof PrimType || "java.lang.String".equals(ftype.getName())) {
                    if (val instanceof Char) {
                        val = IntNum.make(((Char)val).intValue());
                    }
                    this.field.setConstantValue(val, frameType);
                    return;
                }
            }
        }
        if (!this.shouldEarlyInit() && this.context instanceof ModuleExp && (this.isIndirectBinding() || (value != null && !(value instanceof ClassExp)))) {
            BindingInitializer.create(this, value, comp);
        }
    }
    
    Location makeIndirectLocationFor() {
        final Symbol sym = (Symbol)((this.symbol instanceof Symbol) ? this.symbol : Namespace.EmptyNamespace.getSymbol(this.symbol.toString().intern()));
        return Location.make(sym);
    }
    
    public static Declaration getDeclarationFromStatic(final String cname, final String fname) {
        final ClassType clas = ClassType.make(cname);
        final Field fld = clas.getDeclaredField(fname);
        final Declaration decl = new Declaration(fname, fld);
        decl.setFlag(18432L);
        return decl;
    }
    
    public static Declaration getDeclarationValueFromStatic(final String className, final String fieldName, final String name) {
        try {
            final Class cls = Class.forName(className);
            final java.lang.reflect.Field fld = cls.getDeclaredField(fieldName);
            final Object value = fld.get(null);
            final Declaration decl = new Declaration(name, ClassType.make(className).getDeclaredField(fieldName));
            decl.noteValue(new QuoteExp(value));
            decl.setFlag(18432L);
            return decl;
        }
        catch (Exception ex) {
            throw new WrappedException(ex);
        }
    }
    
    public static Declaration getDeclaration(final Named proc) {
        return getDeclaration(proc, proc.getName());
    }
    
    public static Declaration getDeclaration(final Object proc, final String name) {
        Field procField = null;
        if (name != null) {
            final Class procClass = PrimProcedure.getProcedureClass(proc);
            if (procClass != null) {
                final ClassType procType = (ClassType)Type.make(procClass);
                final String fname = Mangling.mangleNameIfNeeded(name);
                procField = procType.getDeclaredField(fname);
            }
        }
        if (procField != null) {
            final int fflags = procField.getModifiers();
            if ((fflags & 0x8) != 0x0) {
                final Declaration decl = new Declaration(name, procField);
                decl.noteValue(new QuoteExp(proc));
                if ((fflags & 0x10) != 0x0) {
                    decl.setFlag(16384L);
                }
                return decl;
            }
        }
        return null;
    }
    
    public Expression getInitValue() {
        return this.initValue;
    }
    
    public void setInitValue(final Expression init) {
        this.initValue = init;
    }
    
    public boolean hasUnknownValue() {
        return this.values == Declaration.unknownValueValues;
    }
    
    public final Expression getValue() {
        if (this.nvalues == 0) {
            if (this.field != null && this.field.getDeclaringClass().isExisting() && (this.field.getModifiers() & 0x18) == 0x18 && !this.isIndirectBinding()) {
                try {
                    final Expression value = new QuoteExp(this.field.getReflectField().get(null));
                    this.noteValue(value);
                    return value;
                }
                catch (Exception ex) {}
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
    
    public final void setValue(final Expression value) {
        this.values = null;
        this.nvalues = 0;
        this.noteValue(value);
    }
    
    public final Object getConstantValue() {
        final Object v = this.getValue();
        if (!(v instanceof QuoteExp) || v == QuoteExp.undefined_exp) {
            return null;
        }
        return ((QuoteExp)v).getValue();
    }
    
    public final boolean hasConstantValue() {
        final Object v = this.getValue();
        return v instanceof QuoteExp && v != QuoteExp.undefined_exp;
    }
    
    public LambdaExp getLambdaValue() {
        if (!this.isAlias() && this.nvalues == 1) {
            final Expression val = this.values[0].getValue(this);
            if (val != null && val.getClass() == LambdaExp.class) {
                return (LambdaExp)val;
            }
        }
        return null;
    }
    
    public void noteValue(final Expression value) {
        this.checkNameDecl(value);
        if (value == null) {
            this.noteValueUnknown();
        }
        else if (this.values != Declaration.unknownValueValues) {
            this.noteValue(new ValueSource(1, value, 0));
        }
    }
    
    void noteValue(final ValueSource value) {
        if (this.values == Declaration.unknownValueValues) {
            throw new InternalError();
        }
        if (this.values == null) {
            this.values = new ValueSource[4];
        }
        else if (this.nvalues >= this.values.length) {
            final ValueSource[] tmp = new ValueSource[2 * this.nvalues];
            System.arraycopy(this.values, 0, tmp, 0, this.nvalues);
            this.values = tmp;
        }
        this.values[this.nvalues++] = value;
    }
    
    public void noteValueConstant(final Object value) {
        if (this.values != Declaration.unknownValueValues) {
            this.noteValue(new QuoteExp(value));
        }
    }
    
    public void noteValueUnknown() {
        this.checkNameDecl(null);
        this.values = Declaration.unknownValueValues;
        this.nvalues = 1;
    }
    
    public void noteValueFromSet(final SetExp setter) {
        if (this.values != Declaration.unknownValueValues) {
            this.checkNameDecl(setter.new_value);
            setter.valueIndex = this.nvalues;
            this.noteValue(new ValueSource(2, setter, 0));
        }
    }
    
    public void noteValueFromLet(final ScopeExp letter) {
        final Expression init = this.getInitValue();
        if (init != QuoteExp.undefined_exp && this.values != Declaration.unknownValueValues) {
            this.checkNameDecl(init);
            this.noteValue(new ValueSource(3, letter, 0));
        }
    }
    
    public void noteValueFromApply(final ApplyExp app, final int index) {
        if (this.values != Declaration.unknownValueValues) {
            this.noteValue(new ValueSource(4, app, index));
        }
    }
    
    public boolean patchSymbolFromSet() {
        if (this.nvalues != 1 || this.values[0].kind != 2) {
            return false;
        }
        final SetExp sexp = (SetExp)this.values[0].base;
        this.setSymbol(((SetExp)this.values[0].base).getSymbol());
        return true;
    }
    
    private void checkNameDecl(final Expression value) {
        if (this.nvalues == 1) {
            final Expression old = this.values[0].getValue(this);
            if (old == value) {
                return;
            }
            if (old instanceof LambdaExp) {
                ((LambdaExp)old).nameDecl = null;
            }
        }
        if (value instanceof LambdaExp) {
            ((LambdaExp)value).nameDecl = ((this.nvalues == 0) ? this : null);
        }
    }
    
    static {
        getLocationMethod = Compilation.typeLocation.addMethod("get", Type.typeArray0, Type.objectType, 1);
        unknownValueInstance = new ValueSource(0, null, 0);
        unknownValueValues = new ValueSource[] { Declaration.unknownValueInstance };
    }
    
    public static class ValueSource
    {
        static final int UNKNOWN_KIND = 0;
        static final int GENERAL_KIND = 1;
        static final int SET_RHS_KIND = 2;
        static final int LET_INIT_KIND = 3;
        static final int APPLY_KIND = 4;
        public int kind;
        public Expression base;
        public int index;
        
        ValueSource(final int kind, final Expression base, final int index) {
            this.kind = kind;
            this.base = base;
            this.index = index;
        }
        
        Expression getValue(final Declaration decl) {
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
                    final ApplyExp app = (ApplyExp)this.base;
                    int i = this.index;
                    final Compilation comp = Compilation.getCurrent();
                    final Expression afunc = app.getFunction();
                    if (comp.isSimpleApplyFunction(afunc)) {
                        ++i;
                    }
                    else if (comp.isApplyFunction(afunc)) {
                        return null;
                    }
                    if (i >= app.getArgCount()) {
                        return null;
                    }
                    return app.getArg(i);
                }
                default: {
                    throw new Error();
                }
            }
        }
    }
}
