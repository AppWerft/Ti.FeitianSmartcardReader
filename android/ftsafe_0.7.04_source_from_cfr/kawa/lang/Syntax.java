/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.kawa.format.Printable;
import gnu.lists.Consumer;
import gnu.lists.Pair;
import gnu.mapping.Named;
import gnu.mapping.Symbol;
import kawa.lang.Translator;

public abstract class Syntax
implements Printable,
Named {
    Object name;

    @Override
    public final String getName() {
        return this.name == null ? null : (this.name instanceof Symbol ? ((Symbol)this.name).getName() : this.name.toString());
    }

    @Override
    public Object getSymbol() {
        return this.name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Syntax() {
    }

    public Syntax(Object name) {
        this.setName(name);
    }

    public Expression rewrite(Object obj, Translator tr) {
        throw new InternalError("rewrite method not defined");
    }

    public Expression rewriteForm(Pair form, Translator tr) {
        return this.rewrite(form.getCdr(), tr);
    }

    public void scanForm(Pair st, ScopeExp defs2, Translator tr) {
        boolean ok = this.scanForDefinitions(st, defs2, tr);
        if (!ok) {
            tr.pushForm(new ErrorExp("syntax error expanding " + this));
        }
    }

    public boolean scanForDefinitions(Pair st, ScopeExp defs2, Translator tr) {
        tr.pushForm(st);
        return true;
    }

    @Override
    public void print(Consumer out) {
        out.write("#<syntax ");
        String name = this.getName();
        out.write(name == null ? "<unnamed>" : name);
        out.write(62);
    }
}

