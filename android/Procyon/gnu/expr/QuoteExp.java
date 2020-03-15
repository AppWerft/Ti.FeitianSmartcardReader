// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.lists.LList;
import gnu.kawa.format.AbstractFormat;
import gnu.lists.Consumer;
import gnu.kawa.io.OutPort;
import gnu.kawa.reflect.MakeAnnotation;
import gnu.mapping.MethodProc;
import gnu.mapping.WrongArguments;
import gnu.mapping.Procedure;
import gnu.kawa.util.IdentityHashTable;
import gnu.bytecode.PrimType;
import gnu.bytecode.ObjectType;
import gnu.mapping.CallContext;
import gnu.text.SourceLocator;
import gnu.bytecode.ParameterizedType;
import gnu.mapping.Values;
import gnu.bytecode.Type;

public class QuoteExp extends Expression
{
    Object value;
    public static final int EXPLICITLY_TYPED = 2;
    public static final int SHARED_CONSTANT = 4;
    public static final int IS_KEYWORD = 8;
    public static QuoteExp undefined_exp;
    public static QuoteExp abstractExp;
    public static QuoteExp nativeExp;
    public static QuoteExp voidExp;
    public static QuoteExp voidObjectExp;
    public static QuoteExp trueExp;
    public static QuoteExp falseExp;
    public static QuoteExp trueObjExp;
    public static QuoteExp falseObjExp;
    public static QuoteExp emptyExp;
    public static QuoteExp nullExp;
    public static final QuoteExp classObjectExp;
    
    public final Object getValue() {
        return this.value;
    }
    
    @Override
    public final Object valueIfConstant() {
        return this.value;
    }
    
    public final Type getRawType() {
        return this.type;
    }
    
    @Override
    protected final Type calculateType() {
        if (this.value == Values.empty) {
            return Type.voidType;
        }
        if (this.value == null) {
            return Type.nullType;
        }
        if (this.value instanceof Class) {
            return new ParameterizedType(Type.javalangClassType, new Type[] { Type.make((Class)this.value) });
        }
        if (this == QuoteExp.undefined_exp) {
            return Type.pointer_type;
        }
        return Type.make(this.value.getClass());
    }
    
    @Override
    public void setType(final Type type) {
        super.setType(type);
        this.setFlag(2);
    }
    
    public boolean isExplicitlyTyped() {
        return this.getFlag(2);
    }
    
    public boolean isSharedConstant() {
        return this.getFlag(4);
    }
    
    public static QuoteExp getInstance(final Object value) {
        return getInstance(value, null);
    }
    
    public static QuoteExp getInstance(final Object value, final SourceLocator position) {
        if (value == null) {
            return QuoteExp.nullExp;
        }
        if (value == Type.pointer_type) {
            return QuoteExp.classObjectExp;
        }
        if (value == Special.undefined) {
            return QuoteExp.undefined_exp;
        }
        if (value == Values.empty) {
            return QuoteExp.voidExp;
        }
        if (value instanceof Boolean) {
            return value ? QuoteExp.trueObjExp : QuoteExp.falseObjExp;
        }
        final QuoteExp q = new QuoteExp(value);
        if (position != null) {
            q.setLocation(position);
        }
        return q;
    }
    
    static QuoteExp makeShared(final Object value) {
        final QuoteExp exp = new QuoteExp(value);
        exp.setFlag(4);
        return exp;
    }
    
    public static QuoteExp makeShared(final Object value, final Type type) {
        final QuoteExp exp = new QuoteExp(value, type);
        exp.setFlag(4);
        return exp;
    }
    
    public QuoteExp(final Object val) {
        this.value = val;
    }
    
    public QuoteExp(final Object val, final Type type) {
        this.value = val;
        this.setType(type);
    }
    
    @Override
    protected boolean mustCompile() {
        return false;
    }
    
    @Override
    public void apply(final CallContext ctx) {
        ctx.writeValue(this.value);
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        final Type targetType;
        if (this.type == null || this.type == Type.pointer_type || target instanceof IgnoreTarget || (this.type instanceof ObjectType && this.type.isInstance(this.value)) || (this.type instanceof PrimType && ((targetType = target.getType()) == Type.objectType || targetType == ((PrimType)this.type).boxedType()))) {
            comp.compileConstant(this.value, target);
        }
        else {
            final Type vtype = this.type.isVoid() ? Type.objectType : this.type;
            comp.compileConstant(this.value, StackTarget.getInstance(vtype));
            target.compileFromStack(comp, vtype);
        }
    }
    
    public Expression deepCopy(final IdentityHashTable mapper) {
        return this;
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitQuoteExp(this, d);
    }
    
    @Override
    public Expression validateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Declaration decl) {
        if (this == QuoteExp.undefined_exp) {
            return exp;
        }
        final Object fval = this.getValue();
        if (!(fval instanceof Procedure)) {
            return visitor.noteError((decl == null || fval == null) ? "called value is not a procedure" : ("calling " + decl.getName() + " which is a " + fval.getClass().getName()));
        }
        final Procedure proc = (Procedure)fval;
        final int nargs = exp.getArgCount();
        final int spliceCount = exp.spliceCount();
        String msg = WrongArguments.checkArgCount(proc, nargs - spliceCount, spliceCount > 0);
        if (msg != null) {
            return visitor.noteError(msg);
        }
        final Expression inlined = visitor.maybeInline(exp, required, proc);
        if (inlined != null) {
            return inlined;
        }
        final Expression[] args = exp.args;
        final MethodProc asMProc = (proc instanceof MethodProc) ? ((MethodProc)proc) : null;
        for (int i = 0; i < nargs; ++i) {
            Type ptype = (asMProc != null) ? asMProc.getParameterType(i) : null;
            if (i == nargs - 1 && ptype != null && asMProc.maxArgs() < 0 && i == asMProc.minArgs()) {
                ptype = null;
            }
            args[i] = visitor.visit(args[i], InlineCalls.ValueNeededType.make(ptype));
        }
        final Compilation comp = visitor.getCompilation();
        if (exp.getFlag(4)) {
            final Expression e = exp.inlineIfConstant(proc, visitor);
            if (e != exp) {
                return visitor.visit(e, required);
            }
            if (proc == MakeAnnotation.makeMethodProc && nargs == 1 && visitor.processingAnnotations()) {
                Object name = null;
                if (args[0] instanceof ReferenceExp) {
                    name = ((ReferenceExp)args[0]).getName();
                }
                msg = "unknown annotation type";
                if (name != null) {
                    msg = msg + " '" + name + '\'';
                }
                comp.error('e', msg, args[0]);
            }
        }
        if (comp.inlineOk(proc) && exp.isSimple() && !ApplyExp.isInlineable(proc)) {
            final PrimProcedure mproc = PrimProcedure.getMethodFor(proc, decl, exp.args, comp.getLanguage());
            if (mproc != null) {
                ApplyExp nexp;
                if (mproc.getStaticFlag() || decl == null) {
                    nexp = new ApplyExp(mproc, exp.args);
                }
                else {
                    if (decl.base == null) {
                        return exp;
                    }
                    final Expression[] margs = new Expression[1 + nargs];
                    System.arraycopy(exp.getArgs(), 0, margs, 1, nargs);
                    margs[0] = new ReferenceExp(decl.base);
                    nexp = new ApplyExp(mproc, margs);
                }
                return nexp.setLine(exp);
            }
        }
        return exp;
    }
    
    @Override
    public boolean side_effects() {
        return false;
    }
    
    @Override
    public String toString() {
        return "QuoteExp[" + this.value + "]";
    }
    
    @Override
    public void print(final OutPort out) {
        out.startLogicalBlock("(Quote", ")", 2);
        out.writeSpaceFill();
        Object val = this.value;
        if (val instanceof Expression) {
            val = val.toString();
        }
        final AbstractFormat format = Language.getDefaultLanguage().getFormat(true);
        if (format == null) {
            out.print(val);
        }
        else {
            format.format(val, out);
        }
        if (this.type != null) {
            out.writeSpaceFill();
            out.print("::");
            out.print(this.type.getName());
        }
        out.endLogicalBlock(")");
    }
    
    static {
        QuoteExp.undefined_exp = makeShared(Special.undefined);
        QuoteExp.abstractExp = makeShared(Special.abstractSpecial);
        QuoteExp.nativeExp = makeShared(Special.nativeSpecial);
        QuoteExp.voidExp = makeShared(Values.empty, Type.voidType);
        QuoteExp.voidObjectExp = makeShared(Values.empty, Type.objectType);
        QuoteExp.trueExp = makeShared(Boolean.TRUE, Type.booleanType);
        QuoteExp.falseExp = makeShared(Boolean.FALSE, Type.booleanType);
        QuoteExp.trueObjExp = makeShared(Boolean.TRUE);
        QuoteExp.falseObjExp = makeShared(Boolean.FALSE);
        QuoteExp.emptyExp = makeShared(LList.Empty);
        QuoteExp.nullExp = makeShared(null, Type.nullType);
        classObjectExp = makeShared(Type.objectType);
    }
}
