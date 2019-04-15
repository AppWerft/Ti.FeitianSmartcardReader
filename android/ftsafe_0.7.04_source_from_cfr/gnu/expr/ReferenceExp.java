/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.AccessExp;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.expr.Target;
import gnu.kawa.io.OutPort;
import gnu.kawa.util.IdentityHashTable;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;
import gnu.text.SourceLocator;
import java.lang.reflect.Field;

public class ReferenceExp
extends AccessExp {
    static int counter;
    int id = ++counter;
    public static final int DONT_DEREFERENCE = 4;
    public static final int PROCEDURE_NAME = 8;
    public static final int TYPE_NAME = 16;
    public static final int ALLOCATE_ON_STACK_LAST = 32;
    ReferenceExp siblingReferencesNext;

    public final boolean getDontDereference() {
        return (this.flags & 4) != 0;
    }

    public final void setDontDereference(boolean setting) {
        this.setFlag(setting, 4);
    }

    public final boolean isUnknown() {
        return Declaration.isUnknown(this.binding);
    }

    public final boolean isProcedureName() {
        return (this.flags & 8) != 0;
    }

    public final void setProcedureName(boolean setting) {
        this.setFlag(setting, 8);
    }

    public ReferenceExp(Object symbol) {
        this.symbol = symbol;
    }

    public ReferenceExp(Object symbol, Declaration binding) {
        this.symbol = symbol;
        this.binding = binding;
    }

    public ReferenceExp(Declaration binding) {
        this(binding.getSymbol(), binding);
    }

    public ReferenceExp(ReferenceExp old) {
        this(old.symbol, old.binding);
        this.setContextDecl(old.contextDecl());
        this.flags = old.flags;
    }

    @Override
    protected boolean mustCompile() {
        return false;
    }

    @Override
    public final Object valueIfConstant() {
        Expression dvalue;
        if (this.binding != null && (dvalue = this.binding.getValue()) != null) {
            return dvalue.valueIfConstant();
        }
        return null;
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        Object value;
        Expression dvalue;
        if (this.binding != null && this.binding.isAlias() && !this.getDontDereference() && (dvalue = this.binding.getValueRaw()) instanceof ReferenceExp) {
            Expression v;
            ReferenceExp rexp = (ReferenceExp)dvalue;
            if (rexp.getDontDereference() && rexp.binding != null && ((v = rexp.binding.getValue()) instanceof QuoteExp || v instanceof ReferenceExp || v instanceof LambdaExp)) {
                v.apply(ctx);
                return;
            }
            value = dvalue.eval(ctx);
        } else if (this.binding != null && this.binding.field != null && this.binding.field.getDeclaringClass().isExisting() && (!this.getDontDereference() || this.binding.isIndirectBinding())) {
            try {
                Object instance = this.binding.field.getStaticFlag() ? null : this.contextDecl().getValue().eval(ctx);
                value = this.binding.field.getReflectField().get(instance);
            }
            catch (Exception ex) {
                String msg = "exception evaluating " + this.symbol + " from " + this.binding.field + " - " + ex;
                throw new UnboundLocationException((Object)msg, this);
            }
        } else if (this.binding != null && ((dvalue = this.binding.getValue()) instanceof QuoteExp || dvalue instanceof LambdaExp) && dvalue != QuoteExp.undefined_exp && (!this.getDontDereference() || this.binding.isIndirectBinding())) {
            value = dvalue.eval(ctx);
        } else {
            if (this.binding == null || this.binding.context instanceof ModuleExp) {
                Object property;
                Object value2;
                Environment env = Environment.getCurrent();
                Symbol sym = this.symbol instanceof Symbol ? (Symbol)this.symbol : env.getSymbol(this.symbol.toString());
                Object object2 = property = this.getFlag(2) && this.isProcedureName() ? EnvironmentKey.FUNCTION : null;
                if (this.getDontDereference()) {
                    value2 = env.getLocation(sym, property);
                } else {
                    String unb = Location.UNBOUND;
                    value2 = env.get(sym, property, unb);
                    if (value2 == unb) {
                        throw new UnboundLocationException((Object)sym, this);
                    }
                }
                ctx.writeValue(value2);
                return;
            }
            value = ctx.evalFrames[ScopeExp.nesting(this.binding.context)][this.binding.evalIndex];
        }
        if (!this.getDontDereference() && this.binding.isIndirectBinding()) {
            value = ((Location)value).get();
        }
        ctx.writeValue(value);
    }

    @Override
    public void compile(Compilation comp, Target target) {
        if (!(target instanceof ConsumerTarget) || this.binding.getFlag(0x8000000000L) || !((ConsumerTarget)target).compileWrite(this, comp)) {
            this.binding.load(this, this.flags, comp, target);
        }
    }

    @Override
    protected Expression deepCopy(IdentityHashTable mapper) {
        Declaration d = mapper.get(this.binding, this.binding);
        Object s = mapper.get(this.symbol, this.symbol);
        ReferenceExp copy = new ReferenceExp(s, d);
        copy.flags = this.getFlags();
        return copy;
    }

    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitReferenceExp(this, d);
    }

    @Override
    public Expression validateApply(ApplyExp exp, InlineCalls visitor, Type required, Declaration decl) {
        decl = this.binding;
        if (decl != null && !decl.getFlag(65536L)) {
            if (!(decl = Declaration.followAliases(decl)).isIndirectBinding()) {
                Expression dval = decl.getValue();
                if (dval != null) {
                    return dval.validateApply(exp, visitor, required, decl);
                }
                Type dtype = decl.type;
                if (dtype instanceof ClassType && ((ClassType)dtype).isSubclass("kawa.lang.Continuation")) {
                    exp.setType(Type.neverReturnsType);
                }
            }
        } else if (this.getSymbol() instanceof Symbol) {
            Symbol symbol = (Symbol)this.getSymbol();
            Object fval = Environment.getCurrent().getFunction(symbol, null);
            if (fval instanceof Procedure) {
                return new QuoteExp(fval).validateApply(exp, visitor, required, null);
            }
        }
        exp.visitArgs(visitor);
        return exp;
    }

    @Override
    public void print(OutPort ps) {
        ps.print("(Ref/");
        ps.print(this.id);
        if (this.getDontDereference()) {
            ps.print(",dont-deref");
        }
        if (this.symbol != null && (this.binding == null || this.symbol.toString() != this.binding.getName())) {
            ps.print('/');
            ps.print(this.symbol);
        }
        if (this.binding != null) {
            ps.print('/');
            ps.print(this.binding);
        }
        ps.print(")");
    }

    @Override
    protected Type calculateType() {
        Type type;
        Declaration decl = this.binding;
        if (decl == null) {
            return Type.pointer_type;
        }
        if (this.getDontDereference()) {
            if (decl.field != null && !decl.isIndirectBinding()) {
                return decl.field.getStaticFlag() ? Compilation.typeStaticFieldLocation : Compilation.typeFieldLocation;
            }
            return Compilation.typeLocation;
        }
        Type type2 = type = (decl = Declaration.followAliases(decl)).isAlias() && decl.isIndirectBinding() ? Type.objectType : decl.getType();
        if (type == Type.toStringType) {
            type = Type.javalangStringType;
        }
        return type;
    }

    @Override
    public boolean isSingleValue() {
        if (this.binding != null && this.binding.getFlag(262144L)) {
            return true;
        }
        return super.isSingleValue();
    }

    @Override
    public boolean side_effects() {
        return this.binding == null || !this.binding.isLexical();
    }

    @Override
    public String toString() {
        return "RefExp/" + this.symbol + '/' + this.id + '/';
    }
}

