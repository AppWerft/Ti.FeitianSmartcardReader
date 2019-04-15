/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.InlineCalls;
import gnu.expr.Language;
import gnu.expr.PrimProcedure;
import gnu.expr.ReferenceExp;
import gnu.expr.Special;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.format.AbstractFormat;
import gnu.kawa.io.OutPort;
import gnu.kawa.reflect.MakeAnnotation;
import gnu.kawa.util.IdentityHashTable;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.mapping.WrongArguments;
import gnu.text.SourceLocator;

public class QuoteExp
extends Expression {
    Object value;
    public static final int EXPLICITLY_TYPED = 2;
    public static final int SHARED_CONSTANT = 4;
    public static final int IS_KEYWORD = 8;
    public static QuoteExp undefined_exp = QuoteExp.makeShared(Special.undefined);
    public static QuoteExp abstractExp = QuoteExp.makeShared(Special.abstractSpecial);
    public static QuoteExp nativeExp = QuoteExp.makeShared(Special.nativeSpecial);
    public static QuoteExp voidExp = QuoteExp.makeShared(Values.empty, Type.voidType);
    public static QuoteExp voidObjectExp = QuoteExp.makeShared(Values.empty, Type.objectType);
    public static QuoteExp trueExp = QuoteExp.makeShared(Boolean.TRUE, Type.booleanType);
    public static QuoteExp falseExp = QuoteExp.makeShared(Boolean.FALSE, Type.booleanType);
    public static QuoteExp trueObjExp = QuoteExp.makeShared(Boolean.TRUE);
    public static QuoteExp falseObjExp = QuoteExp.makeShared(Boolean.FALSE);
    public static QuoteExp emptyExp = QuoteExp.makeShared(LList.Empty);
    public static QuoteExp nullExp = QuoteExp.makeShared(null, Type.nullType);
    public static final QuoteExp classObjectExp = QuoteExp.makeShared(Type.objectType);

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
            return new ParameterizedType(Type.javalangClassType, Type.make((Class)this.value));
        }
        if (this == undefined_exp) {
            return Type.pointer_type;
        }
        return Type.make(this.value.getClass());
    }

    @Override
    public void setType(Type type) {
        super.setType(type);
        this.setFlag(2);
    }

    public boolean isExplicitlyTyped() {
        return this.getFlag(2);
    }

    public boolean isSharedConstant() {
        return this.getFlag(4);
    }

    public static QuoteExp getInstance(Object value) {
        return QuoteExp.getInstance(value, null);
    }

    public static QuoteExp getInstance(Object value, SourceLocator position) {
        if (value == null) {
            return nullExp;
        }
        if (value == Type.pointer_type) {
            return classObjectExp;
        }
        if (value == Special.undefined) {
            return undefined_exp;
        }
        if (value == Values.empty) {
            return voidExp;
        }
        if (value instanceof Boolean) {
            return (Boolean)value != false ? trueObjExp : falseObjExp;
        }
        QuoteExp q = new QuoteExp(value);
        if (position != null) {
            q.setLocation(position);
        }
        return q;
    }

    static QuoteExp makeShared(Object value) {
        QuoteExp exp = new QuoteExp(value);
        exp.setFlag(4);
        return exp;
    }

    public static QuoteExp makeShared(Object value, Type type) {
        QuoteExp exp = new QuoteExp(value, type);
        exp.setFlag(4);
        return exp;
    }

    public QuoteExp(Object val) {
        this.value = val;
    }

    public QuoteExp(Object val, Type type) {
        this.value = val;
        this.setType(type);
    }

    @Override
    protected boolean mustCompile() {
        return false;
    }

    @Override
    public void apply(CallContext ctx) {
        ctx.writeValue(this.value);
    }

    @Override
    public void compile(Compilation comp, Target target) {
        Type targetType;
        if (this.type == null || this.type == Type.pointer_type || target instanceof IgnoreTarget || this.type instanceof ObjectType && this.type.isInstance(this.value) || this.type instanceof PrimType && ((targetType = target.getType()) == Type.objectType || targetType == ((PrimType)this.type).boxedType())) {
            comp.compileConstant(this.value, target);
        } else {
            Type vtype = this.type.isVoid() ? Type.objectType : this.type;
            comp.compileConstant(this.value, StackTarget.getInstance(vtype));
            target.compileFromStack(comp, vtype);
        }
    }

    @Override
    public Expression deepCopy(IdentityHashTable mapper) {
        return this;
    }

    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitQuoteExp(this, d);
    }

    @Override
    public Expression validateApply(ApplyExp exp, InlineCalls visitor, Type required, Declaration decl) {
        int spliceCount;
        PrimProcedure mproc;
        if (this == undefined_exp) {
            return exp;
        }
        Object fval = this.getValue();
        if (!(fval instanceof Procedure)) {
            return visitor.noteError(decl == null || fval == null ? "called value is not a procedure" : "calling " + decl.getName() + " which is a " + fval.getClass().getName());
        }
        Procedure proc = (Procedure)fval;
        int nargs = exp.getArgCount();
        String msg = WrongArguments.checkArgCount(proc, nargs - spliceCount, (spliceCount = exp.spliceCount()) > 0);
        if (msg != null) {
            return visitor.noteError(msg);
        }
        Expression inlined = visitor.maybeInline(exp, required, proc);
        if (inlined != null) {
            return inlined;
        }
        Expression[] args = exp.args;
        MethodProc asMProc = proc instanceof MethodProc ? (MethodProc)proc : null;
        for (int i = 0; i < nargs; ++i) {
            Type ptype;
            Type type = ptype = asMProc != null ? asMProc.getParameterType(i) : null;
            if (i == nargs - 1 && ptype != null && asMProc.maxArgs() < 0 && i == asMProc.minArgs()) {
                ptype = null;
            }
            args[i] = visitor.visit(args[i], InlineCalls.ValueNeededType.make(ptype));
        }
        Compilation comp = visitor.getCompilation();
        if (exp.getFlag(4)) {
            Expression e = exp.inlineIfConstant(proc, visitor);
            if (e != exp) {
                return visitor.visit(e, required);
            }
            if (proc == MakeAnnotation.makeMethodProc && nargs == 1 && visitor.processingAnnotations()) {
                String name = null;
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
        if (comp.inlineOk(proc) && exp.isSimple() && !ApplyExp.isInlineable(proc) && (mproc = PrimProcedure.getMethodFor(proc, decl, exp.args, comp.getLanguage())) != null) {
            ApplyExp nexp;
            if (mproc.getStaticFlag() || decl == null) {
                nexp = new ApplyExp(mproc, exp.args);
            } else {
                if (decl.base == null) {
                    return exp;
                }
                Expression[] margs = new Expression[1 + nargs];
                System.arraycopy(exp.getArgs(), 0, margs, 1, nargs);
                margs[0] = new ReferenceExp(decl.base);
                nexp = new ApplyExp(mproc, margs);
            }
            return nexp.setLine(exp);
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
    public void print(OutPort out) {
        AbstractFormat format;
        out.startLogicalBlock("(Quote", ")", 2);
        out.writeSpaceFill();
        Object val = this.value;
        if (val instanceof Expression) {
            val = val.toString();
        }
        if ((format = Language.getDefaultLanguage().getFormat(true)) == null) {
            out.print(val);
        } else {
            format.format(val, out);
        }
        if (this.type != null) {
            out.writeSpaceFill();
            out.print("::");
            out.print(this.type.getName());
        }
        out.endLogicalBlock(")");
    }
}

