// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.Type;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Scope;

public abstract class ScopeExp extends Expression
{
    Declaration decls;
    Declaration last;
    protected Scope scope;
    private ScopeExp outer;
    protected int frameSize;
    static int counter;
    public int id;
    
    public Declaration firstDecl() {
        return this.decls;
    }
    
    public Scope getVarScope() {
        Scope sc = this.scope;
        if (sc == null) {
            sc = (this.scope = new Scope());
        }
        return sc;
    }
    
    public void popScope(final CodeAttr code) {
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            decl.var = null;
        }
        code.popScope();
        this.scope = null;
    }
    
    public void add(final Declaration decl) {
        if (this.last == null) {
            this.decls = decl;
        }
        else {
            this.last.setNext(decl);
        }
        this.last = decl;
        decl.context = this;
    }
    
    public void add(final Declaration prev, final Declaration decl) {
        if (prev == null) {
            decl.setNext(this.decls);
            this.decls = decl;
        }
        else {
            decl.setNext(prev.nextDecl());
            prev.setNext(decl);
        }
        if (this.last == prev) {
            this.last = decl;
        }
        decl.context = this;
    }
    
    public void replaceFollowing(final Declaration prev, final Declaration newDecl) {
        Declaration oldDecl;
        if (prev == null) {
            oldDecl = this.decls;
            this.decls = newDecl;
        }
        else {
            oldDecl = prev.nextDecl();
            prev.setNext(newDecl);
        }
        newDecl.setNext(oldDecl.nextDecl());
        if (this.last == oldDecl) {
            this.last = newDecl;
        }
        oldDecl.setNext(null);
        newDecl.context = this;
    }
    
    public void remove(final Declaration decl) {
        Declaration prev = null;
        for (Declaration cur = this.firstDecl(); cur != null; cur = cur.nextDecl()) {
            if (cur == decl) {
                this.remove(prev, decl);
                return;
            }
            prev = cur;
        }
    }
    
    public void remove(final Declaration prev, final Declaration decl) {
        final Declaration next = decl.nextDecl();
        if (prev == null) {
            this.decls = next;
        }
        else {
            prev.setNext(next);
        }
        if (this.last == decl) {
            this.last = prev;
        }
        decl.setNext(null);
    }
    
    public ScopeExp() {
        this.id = ++ScopeExp.counter;
    }
    
    public ScopeExp getOuter() {
        return this.outer;
    }
    
    public void setOuter(final ScopeExp outer) {
        this.outer = outer;
    }
    
    public LambdaExp currentLambda() {
        for (ScopeExp exp = this; exp != null; exp = exp.getOuter()) {
            if (exp instanceof LambdaExp) {
                return (LambdaExp)exp;
            }
        }
        return null;
    }
    
    public ScopeExp topLevel() {
        ScopeExp exp = this;
        while (true) {
            final ScopeExp outer = exp.getOuter();
            if (outer == null || outer instanceof ModuleExp) {
                break;
            }
            exp = outer;
        }
        return exp;
    }
    
    public ModuleExp currentModule() {
        for (ScopeExp exp = this; exp != null; exp = exp.getOuter()) {
            if (exp instanceof ModuleExp) {
                return (ModuleExp)exp;
            }
        }
        return null;
    }
    
    public Declaration lookup(final Object sym) {
        if (sym != null) {
            for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
                if (sym.equals(decl.symbol)) {
                    return decl;
                }
            }
        }
        return null;
    }
    
    public Declaration lookup(final Object sym, final Language language, final int namespace) {
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (sym.equals(decl.symbol) && language.hasNamespace(decl, namespace)) {
                return decl;
            }
        }
        return null;
    }
    
    public Declaration getNoDefine(final Object name) {
        Declaration decl = this.lookup(name);
        if (decl == null) {
            final Declaration addDeclaration;
            decl = (addDeclaration = this.addDeclaration(name));
            addDeclaration.flags |= 0x10200L;
        }
        return decl;
    }
    
    public Declaration getDefine(final Object name, final Compilation parser) {
        Declaration decl = this.lookup(name);
        if (decl == null) {
            decl = this.addDeclaration(name);
        }
        else if ((decl.flags & 0x10200L) != 0x0L) {
            final Declaration declaration = decl;
            declaration.flags &= 0xFFFFFFFFFFFEFDFFL;
        }
        else {
            final Declaration newDecl = this.addDeclaration(name);
            duplicateDeclarationError(decl, newDecl, parser);
            decl = newDecl;
        }
        return decl;
    }
    
    public static void duplicateDeclarationError(final Declaration oldDecl, final Declaration newDecl, final Compilation comp) {
        comp.error('e', newDecl, "duplicate declaration of '", "'");
        comp.error('e', oldDecl, "(this is the previous declaration of '", "')");
    }
    
    public final Declaration addDeclaration(final Object name) {
        final Declaration decl = new Declaration(name);
        this.add(decl);
        return decl;
    }
    
    public final Declaration addDeclaration(final Object name, final Type type) {
        final Declaration decl = new Declaration(name, type);
        this.add(decl);
        return decl;
    }
    
    public final void addDeclaration(final Declaration decl) {
        this.add(decl);
    }
    
    public int countDecls() {
        int n = 0;
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            ++n;
        }
        return n;
    }
    
    public void clearCallList() {
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            decl.clearCallList();
        }
    }
    
    public static int nesting(ScopeExp sc) {
        int n;
        for (n = 0; sc != null; sc = sc.getOuter(), ++n) {}
        return n;
    }
    
    public boolean nestedIn(final ScopeExp outer) {
        for (ScopeExp sc = this; sc != null; sc = sc.getOuter()) {
            if (sc == outer) {
                return true;
            }
        }
        return false;
    }
    
    protected void setIndexes() {
        int i = 0;
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            decl.evalIndex = i++;
        }
        this.frameSize = i;
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitScopeExp(this, d);
    }
    
    public final boolean isClassGenerated() {
        return this instanceof ModuleExp || this instanceof ClassExp;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + "#" + this.id;
    }
}
