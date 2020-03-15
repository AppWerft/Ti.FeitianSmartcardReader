// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.lists.Consumer;
import gnu.expr.ErrorExp;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import gnu.expr.Expression;
import gnu.mapping.Symbol;
import gnu.mapping.Named;
import gnu.kawa.format.Printable;

public abstract class Syntax implements Printable, Named
{
    Object name;
    
    @Override
    public final String getName() {
        return (this.name == null) ? null : ((this.name instanceof Symbol) ? ((Symbol)this.name).getName() : this.name.toString());
    }
    
    @Override
    public Object getSymbol() {
        return this.name;
    }
    
    public void setName(final Object name) {
        this.name = name;
    }
    
    @Override
    public void setName(final String name) {
        this.name = name;
    }
    
    public Syntax() {
    }
    
    public Syntax(final Object name) {
        this.setName(name);
    }
    
    public Expression rewrite(final Object obj, final Translator tr) {
        throw new InternalError("rewrite method not defined");
    }
    
    public Expression rewriteForm(final Pair form, final Translator tr) {
        return this.rewrite(form.getCdr(), tr);
    }
    
    public void scanForm(final Pair st, final ScopeExp defs, final Translator tr) {
        final boolean ok = this.scanForDefinitions(st, defs, tr);
        if (!ok) {
            tr.pushForm(new ErrorExp("syntax error expanding " + this));
        }
    }
    
    public boolean scanForDefinitions(final Pair st, final ScopeExp defs, final Translator tr) {
        tr.pushForm(st);
        return true;
    }
    
    @Override
    public void print(final Consumer out) {
        out.write("#<syntax ");
        final String name = this.getName();
        out.write((name == null) ? "<unnamed>" : name);
        out.write(62);
    }
}
