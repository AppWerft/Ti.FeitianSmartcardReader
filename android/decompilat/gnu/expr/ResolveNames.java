// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

public class ResolveNames extends ExpExpVisitor<Void>
{
    protected NameLookup lookup;
    
    public ResolveNames() {
    }
    
    public ResolveNames(final Compilation comp) {
        this.setContext(comp);
        this.lookup = comp.lexical;
    }
    
    public void resolveModule(final ModuleExp exp) {
        final Compilation saveComp = Compilation.setSaveCurrent(this.comp);
        try {
            this.push(exp);
            exp.visitChildren((ExpVisitor<Object, Object>)this, null);
        }
        finally {
            Compilation.restoreCurrent(saveComp);
        }
    }
    
    protected void push(final ScopeExp exp) {
        this.lookup.push(exp);
    }
    
    protected Expression visitScopeExp(final ScopeExp exp, final Void ignored) {
        this.visitDeclarationTypes(exp);
        this.push(exp);
        exp.visitChildren((ExpVisitor<Object, Void>)this, ignored);
        this.lookup.pop(exp);
        return exp;
    }
    
    protected Expression visitLetExp(final LetExp exp, final Void ignored) {
        this.visitDeclarationTypes(exp);
        exp.visitInitializers((ExpVisitor<Object, Void>)this, ignored);
        this.push(exp);
        exp.body = this.visit(exp.body, (D)ignored);
        this.lookup.pop(exp);
        return exp;
    }
    
    public Declaration lookup(final Expression exp, final Object symbol, final boolean function) {
        return this.lookup.lookup(symbol, function);
    }
    
    protected Expression visitReferenceExp(final ReferenceExp exp, final Void ignored) {
        Declaration decl = exp.getBinding();
        if (decl == null) {
            decl = this.lookup(exp, exp.getSymbol(), exp.isProcedureName());
            if (decl != null) {
                exp.setBinding(decl);
            }
        }
        return exp;
    }
    
    protected Expression visitSetExp(final SetExp exp, final Void ignored) {
        if (exp.binding == null) {
            final Declaration decl = this.lookup(exp, exp.getSymbol(), exp.isFuncDef());
            if (decl != null) {
                decl.setCanWrite(true);
            }
            exp.binding = decl;
        }
        return super.visitSetExp(exp, (D)ignored);
    }
}
