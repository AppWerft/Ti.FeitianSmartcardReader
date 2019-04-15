/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.ModuleExp;

public abstract class ScopeExp
extends Expression {
    Declaration decls;
    Declaration last;
    protected Scope scope;
    private ScopeExp outer;
    protected int frameSize;
    static int counter;
    public int id = ++counter;

    public Declaration firstDecl() {
        return this.decls;
    }

    public Scope getVarScope() {
        Scope sc = this.scope;
        if (sc == null) {
            this.scope = sc = new Scope();
        }
        return sc;
    }

    public void popScope(CodeAttr code) {
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            decl.var = null;
        }
        code.popScope();
        this.scope = null;
    }

    public void add(Declaration decl) {
        if (this.last == null) {
            this.decls = decl;
        } else {
            this.last.setNext(decl);
        }
        this.last = decl;
        decl.context = this;
    }

    public void add(Declaration prev, Declaration decl) {
        if (prev == null) {
            decl.setNext(this.decls);
            this.decls = decl;
        } else {
            decl.setNext(prev.nextDecl());
            prev.setNext(decl);
        }
        if (this.last == prev) {
            this.last = decl;
        }
        decl.context = this;
    }

    public void replaceFollowing(Declaration prev, Declaration newDecl) {
        Declaration oldDecl;
        if (prev == null) {
            oldDecl = this.decls;
            this.decls = newDecl;
        } else {
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

    public void remove(Declaration decl) {
        Declaration prev = null;
        for (Declaration cur = this.firstDecl(); cur != null; cur = cur.nextDecl()) {
            if (cur == decl) {
                this.remove(prev, decl);
                return;
            }
            prev = cur;
        }
    }

    public void remove(Declaration prev, Declaration decl) {
        Declaration next = decl.nextDecl();
        if (prev == null) {
            this.decls = next;
        } else {
            prev.setNext(next);
        }
        if (this.last == decl) {
            this.last = prev;
        }
        decl.setNext(null);
    }

    public ScopeExp getOuter() {
        return this.outer;
    }

    public void setOuter(ScopeExp outer) {
        this.outer = outer;
    }

    public LambdaExp currentLambda() {
        ScopeExp exp = this;
        while (exp != null) {
            if (exp instanceof LambdaExp) {
                return (LambdaExp)exp;
            }
            exp = exp.getOuter();
        }
        return null;
    }

    public ScopeExp topLevel() {
        ScopeExp exp = this;
        ScopeExp outer;
        while ((outer = exp.getOuter()) != null && !(outer instanceof ModuleExp)) {
            exp = outer;
        }
        return exp;
    }

    public ModuleExp currentModule() {
        ScopeExp exp = this;
        while (exp != null) {
            if (exp instanceof ModuleExp) {
                return (ModuleExp)exp;
            }
            exp = exp.getOuter();
        }
        return null;
    }

    public Declaration lookup(Object sym) {
        if (sym != null) {
            for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
                if (!sym.equals(decl.symbol)) continue;
                return decl;
            }
        }
        return null;
    }

    public Declaration lookup(Object sym, Language language, int namespace) {
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (!sym.equals(decl.symbol) || !language.hasNamespace(decl, namespace)) continue;
            return decl;
        }
        return null;
    }

    public Declaration getNoDefine(Object name) {
        Declaration decl = this.lookup(name);
        if (decl == null) {
            decl = this.addDeclaration(name);
            decl.flags |= 66048L;
        }
        return decl;
    }

    public Declaration getDefine(Object name, Compilation parser) {
        Declaration decl = this.lookup(name);
        if (decl == null) {
            decl = this.addDeclaration(name);
        } else if ((decl.flags & 66048L) != 0L) {
            decl.flags &= -66049L;
        } else {
            Declaration newDecl = this.addDeclaration(name);
            ScopeExp.duplicateDeclarationError(decl, newDecl, parser);
            decl = newDecl;
        }
        return decl;
    }

    public static void duplicateDeclarationError(Declaration oldDecl, Declaration newDecl, Compilation comp) {
        comp.error('e', newDecl, "duplicate declaration of '", "'");
        comp.error('e', oldDecl, "(this is the previous declaration of '", "')");
    }

    public final Declaration addDeclaration(Object name) {
        Declaration decl = new Declaration(name);
        this.add(decl);
        return decl;
    }

    public final Declaration addDeclaration(Object name, Type type) {
        Declaration decl = new Declaration(name, type);
        this.add(decl);
        return decl;
    }

    public final void addDeclaration(Declaration decl) {
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
        int n = 0;
        while (sc != null) {
            sc = sc.getOuter();
            ++n;
        }
        return n;
    }

    public boolean nestedIn(ScopeExp outer) {
        for (ScopeExp sc = this; sc != null; sc = sc.getOuter()) {
            if (sc != outer) continue;
            return true;
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
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
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

