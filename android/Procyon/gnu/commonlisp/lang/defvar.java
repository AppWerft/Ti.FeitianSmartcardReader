// 
// Decompiled by Procyon v0.5.36
// 

package gnu.commonlisp.lang;

import gnu.expr.SetExp;
import gnu.expr.QuoteExp;
import gnu.lists.LList;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.Declaration;
import gnu.mapping.Symbol;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class defvar extends Syntax
{
    boolean force;
    
    public defvar(final boolean force) {
        this.force = force;
    }
    
    @Override
    public boolean scanForDefinitions(Pair st, final ScopeExp defs, final Translator tr) {
        if (!(st.getCdr() instanceof Pair)) {
            return super.scanForDefinitions(st, defs, tr);
        }
        Pair p = (Pair)st.getCdr();
        final Object name = p.getCar();
        if (name instanceof String || name instanceof Symbol) {
            Declaration decl = defs.lookup(name, tr.getLanguage(), 1);
            if (decl == null) {
                decl = new Declaration(name);
                decl.setFlag(268435456L);
                defs.addDeclaration(decl);
                tr.push(decl);
            }
            else {
                tr.error('w', "duplicate declaration for `" + name + "'");
            }
            p = Translator.makePair(p, decl, p.getCdr());
            st = Translator.makePair(st, this, p);
            if (defs instanceof ModuleExp) {
                decl.setCanRead(true);
                decl.setCanWrite(true);
            }
        }
        tr.pushForm(st);
        return true;
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        final Object obj = form.getCdr();
        Object name = null;
        Expression value = null;
        Declaration decl = null;
        if (obj instanceof Pair) {
            final Pair p1 = (Pair)obj;
            if (p1.getCar() instanceof Declaration) {
                decl = (Declaration)p1.getCar();
                name = decl.getSymbol();
                if (p1.getCdr() instanceof Pair) {
                    final Pair p2 = (Pair)p1.getCdr();
                    value = tr.rewrite(p2.getCar());
                    if (p2.getCdr() != LList.Empty) {}
                }
                else if (p1.getCdr() != LList.Empty) {
                    name = null;
                }
            }
        }
        if (name == null) {
            return tr.syntaxError("invalid syntax for " + this.getName());
        }
        if (value == null) {
            if (!this.force) {
                return new QuoteExp(name);
            }
            value = CommonLisp.nilExpr;
        }
        final SetExp sexp = new SetExp(name, value);
        if (!this.force) {
            sexp.setSetIfUnbound(true);
        }
        sexp.setDefining(true);
        if (decl != null) {
            sexp.setBinding(decl);
            if (decl.context instanceof ModuleExp && decl.getCanWrite()) {
                value = null;
            }
            decl.noteValue(value);
        }
        return sexp;
    }
}
