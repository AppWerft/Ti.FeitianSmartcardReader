// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.QuoteExp;
import gnu.expr.LangExp;
import gnu.lists.LList;
import kawa.lang.BindDecls;
import gnu.expr.Expression;
import gnu.expr.Declaration;
import gnu.expr.SetExp;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class MatchDef extends Syntax
{
    public static final MatchDef matchDef;
    
    @Override
    public void scanForm(Pair st, final ScopeExp defs, final Translator tr) {
        final Object arg = st.getCdr();
        if (!(arg instanceof Pair)) {
            tr.error('e', "missing pattern following '!'");
            return;
        }
        final Pair p1 = (Pair)arg;
        final SetExp sexp = new SetExp(null, null);
        st = Translator.makePair(st, this, sexp);
        tr.pushForm(st);
        final Object[] r = BindDecls.instance.parsePatternCar(p1, 0, defs, tr);
        final Object rest = r[0];
        final Declaration decl = (Declaration)r[1];
        sexp.setBinding(decl);
        Expression init;
        if (rest instanceof Pair) {
            final Pair prest = (Pair)rest;
            if (prest.getCdr() != LList.Empty) {
                tr.error('e', "junk after initializer");
            }
            init = new LangExp(rest);
        }
        else {
            tr.error('e', "missing initializer");
            init = QuoteExp.nullExp;
        }
        sexp.setNewValue(init);
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        final Object arg = form.getCdr();
        if (!(arg instanceof SetExp)) {
            return tr.syntaxError("! definition is only allowed in a <body>");
        }
        final SetExp sexp = (SetExp)arg;
        final Declaration decl = sexp.getBinding();
        Expression init = sexp.getNewValue();
        if (init instanceof LangExp) {
            init = tr.rewrite_car((Pair)((LangExp)init).getLangValue(), false);
            sexp.setNewValue(init);
        }
        decl.noteValueFromSet(sexp);
        sexp.setDefining(true);
        return sexp;
    }
    
    static {
        matchDef = new MatchDef();
    }
}
