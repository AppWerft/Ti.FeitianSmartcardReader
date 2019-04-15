/*
 * Decompiled with CFR 0.139.
 */
package gnu.commonlisp.lang;

import gnu.commonlisp.lang.CommonLisp;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class defvar
extends Syntax {
    boolean force;

    public defvar(boolean force) {
        this.force = force;
    }

    @Override
    public boolean scanForDefinitions(Pair st, ScopeExp defs2, Translator tr) {
        if (!(st.getCdr() instanceof Pair)) {
            return super.scanForDefinitions(st, defs2, tr);
        }
        Pair p = (Pair)st.getCdr();
        Object name = p.getCar();
        if (name instanceof String || name instanceof Symbol) {
            Declaration decl = defs2.lookup(name, tr.getLanguage(), 1);
            if (decl == null) {
                decl = new Declaration(name);
                decl.setFlag(0x10000000L);
                defs2.addDeclaration(decl);
                tr.push(decl);
            } else {
                tr.error('w', "duplicate declaration for `" + name + "'");
            }
            p = Translator.makePair(p, decl, p.getCdr());
            st = Translator.makePair(st, this, p);
            if (defs2 instanceof ModuleExp) {
                decl.setCanRead(true);
                decl.setCanWrite(true);
            }
        }
        tr.pushForm(st);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Pair p1;
        Object obj = form.getCdr();
        Object name = null;
        Expression value = null;
        Declaration decl = null;
        if (obj instanceof Pair && (p1 = (Pair)obj).getCar() instanceof Declaration) {
            decl = (Declaration)p1.getCar();
            name = decl.getSymbol();
            if (p1.getCdr() instanceof Pair) {
                Pair p2 = (Pair)p1.getCdr();
                value = tr.rewrite(p2.getCar());
                if (p2.getCdr() == LList.Empty) {
                    // empty if block
                }
            } else if (p1.getCdr() != LList.Empty) {
                name = null;
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
        SetExp sexp = new SetExp(name, value);
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

