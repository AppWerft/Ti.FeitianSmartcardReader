// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.io.OutPort;
import gnu.mapping.Procedure;
import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.util.IdentityHashTable;
import gnu.mapping.Location;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Symbol;
import gnu.mapping.Environment;
import gnu.text.SourceLocator;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.CallContext;

public class ReferenceExp extends AccessExp
{
    static int counter;
    int id;
    public static final int DONT_DEREFERENCE = 4;
    public static final int PROCEDURE_NAME = 8;
    public static final int TYPE_NAME = 16;
    public static final int ALLOCATE_ON_STACK_LAST = 32;
    ReferenceExp siblingReferencesNext;
    
    public final boolean getDontDereference() {
        return (this.flags & 0x4) != 0x0;
    }
    
    public final void setDontDereference(final boolean setting) {
        this.setFlag(setting, 4);
    }
    
    public final boolean isUnknown() {
        return Declaration.isUnknown(this.binding);
    }
    
    public final boolean isProcedureName() {
        return (this.flags & 0x8) != 0x0;
    }
    
    public final void setProcedureName(final boolean setting) {
        this.setFlag(setting, 8);
    }
    
    public ReferenceExp(final Object symbol) {
        this.id = ++ReferenceExp.counter;
        this.symbol = symbol;
    }
    
    public ReferenceExp(final Object symbol, final Declaration binding) {
        this.id = ++ReferenceExp.counter;
        this.symbol = symbol;
        this.binding = binding;
    }
    
    public ReferenceExp(final Declaration binding) {
        this(binding.getSymbol(), binding);
    }
    
    public ReferenceExp(final ReferenceExp old) {
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
        if (this.binding != null) {
            final Expression dvalue = this.binding.getValue();
            if (dvalue != null) {
                return dvalue.valueIfConstant();
            }
        }
        return null;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        Object value = null;
        Label_0501: {
            Expression dvalue = null;
            if (this.binding != null && this.binding.isAlias() && !this.getDontDereference() && (dvalue = this.binding.getValueRaw()) instanceof ReferenceExp) {
                final ReferenceExp rexp = (ReferenceExp)dvalue;
                if (rexp.getDontDereference() && rexp.binding != null) {
                    final Expression v = rexp.binding.getValue();
                    if (v instanceof QuoteExp || v instanceof ReferenceExp || v instanceof LambdaExp) {
                        v.apply(ctx);
                        return;
                    }
                }
                value = dvalue.eval(ctx);
            }
            else {
                Label_0272: {
                    if (this.binding != null && this.binding.field != null && this.binding.field.getDeclaringClass().isExisting()) {
                        if (this.getDontDereference()) {
                            if (!this.binding.isIndirectBinding()) {
                                break Label_0272;
                            }
                        }
                        try {
                            final Object instance = this.binding.field.getStaticFlag() ? null : this.contextDecl().getValue().eval(ctx);
                            value = this.binding.field.getReflectField().get(instance);
                            break Label_0501;
                        }
                        catch (Exception ex) {
                            final String msg = "exception evaluating " + this.symbol + " from " + this.binding.field + " - " + ex;
                            throw new UnboundLocationException(msg, this);
                        }
                    }
                }
                if (this.binding != null && ((dvalue = this.binding.getValue()) instanceof QuoteExp || dvalue instanceof LambdaExp) && dvalue != QuoteExp.undefined_exp && (!this.getDontDereference() || this.binding.isIndirectBinding())) {
                    value = dvalue.eval(ctx);
                }
                else {
                    if (this.binding == null || this.binding.context instanceof ModuleExp) {
                        final Environment env = Environment.getCurrent();
                        final Symbol sym = (Symbol)((this.symbol instanceof Symbol) ? this.symbol : env.getSymbol(this.symbol.toString()));
                        final Object property = (this.getFlag(2) && this.isProcedureName()) ? EnvironmentKey.FUNCTION : null;
                        if (this.getDontDereference()) {
                            value = env.getLocation(sym, property);
                        }
                        else {
                            final Object unb = Location.UNBOUND;
                            value = env.get(sym, property, unb);
                            if (value == unb) {
                                throw new UnboundLocationException(sym, this);
                            }
                        }
                        ctx.writeValue(value);
                        return;
                    }
                    value = ctx.evalFrames[ScopeExp.nesting(this.binding.context)][this.binding.evalIndex];
                }
            }
        }
        if (!this.getDontDereference() && this.binding.isIndirectBinding()) {
            value = ((Location)value).get();
        }
        ctx.writeValue(value);
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        if (!(target instanceof ConsumerTarget) || this.binding.getFlag(549755813888L) || !((ConsumerTarget)target).compileWrite(this, comp)) {
            this.binding.load(this, this.flags, comp, target);
        }
    }
    
    @Override
    protected Expression deepCopy(final IdentityHashTable mapper) {
        final Declaration d = mapper.get(this.binding, this.binding);
        final Object s = mapper.get(this.symbol, this.symbol);
        final ReferenceExp copy = new ReferenceExp(s, d);
        copy.flags = this.getFlags();
        return copy;
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitReferenceExp(this, d);
    }
    
    @Override
    public Expression validateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, Declaration decl) {
        decl = this.binding;
        if (decl != null && !decl.getFlag(65536L)) {
            decl = Declaration.followAliases(decl);
            if (!decl.isIndirectBinding()) {
                final Expression dval = decl.getValue();
                if (dval != null) {
                    return dval.validateApply(exp, visitor, required, decl);
                }
                final Type dtype = decl.type;
                if (dtype instanceof ClassType && ((ClassType)dtype).isSubclass("kawa.lang.Continuation")) {
                    exp.setType(Type.neverReturnsType);
                }
            }
        }
        else if (this.getSymbol() instanceof Symbol) {
            final Symbol symbol = (Symbol)this.getSymbol();
            final Object fval = Environment.getCurrent().getFunction(symbol, null);
            if (fval instanceof Procedure) {
                return new QuoteExp(fval).validateApply(exp, visitor, required, null);
            }
        }
        exp.visitArgs(visitor);
        return exp;
    }
    
    @Override
    public void print(final OutPort ps) {
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
        Declaration decl = this.binding;
        if (decl == null) {
            return Type.pointer_type;
        }
        if (!this.getDontDereference()) {
            decl = Declaration.followAliases(decl);
            Type type = (decl.isAlias() && decl.isIndirectBinding()) ? Type.objectType : decl.getType();
            if (type == Type.toStringType) {
                type = Type.javalangStringType;
            }
            return type;
        }
        if (decl.field != null && !decl.isIndirectBinding()) {
            return decl.field.getStaticFlag() ? Compilation.typeStaticFieldLocation : Compilation.typeFieldLocation;
        }
        return Compilation.typeLocation;
    }
    
    @Override
    public boolean isSingleValue() {
        return (this.binding != null && this.binding.getFlag(262144L)) || super.isSingleValue();
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
