/*
 * Decompiled with CFR 0.139.
 */
package gnu.commonlisp.lang;

import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import kawa.lang.Lambda;
import kawa.lang.Syntax;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;

public class defun
extends Syntax {
    Lambda lambdaSyntax;

    public defun(Lambda lambdaSyntax) {
        this.lambdaSyntax = lambdaSyntax;
    }

    @Override
    public boolean scanForDefinitions(Pair st, ScopeExp defs2, Translator tr) {
        Pair p;
        if (!(st.getCdr() instanceof Pair) || !((p = (Pair)st.getCdr()).getCar() instanceof String) && !(p.getCar() instanceof Symbol)) {
            return super.scanForDefinitions(st, defs2, tr);
        }
        Object sym = p.getCar();
        Declaration decl = defs2.lookup(sym, tr.getLanguage(), 2);
        if (decl == null) {
            decl = new Declaration(sym);
            decl.setProcedureDecl(true);
            defs2.addDeclaration(decl);
            tr.push(decl);
        } else {
            tr.error('w', "duplicate declaration for `" + sym + "'");
        }
        if (defs2 instanceof ModuleExp) {
            decl.setCanRead(true);
        }
        st = Translator.makePair(st, this, Translator.makePair(p, decl, p.getCdr()));
        tr.pushForm(st);
        return true;
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Object obj = form.getCdr();
        Object name = null;
        LambdaExp value = null;
        Declaration decl = null;
        if (obj instanceof Pair) {
            Pair p1 = (Pair)obj;
            Object p1_car = p1.getCar();
            if (p1_car instanceof Symbol || p1_car instanceof String) {
                name = p1_car.toString();
            } else if (p1_car instanceof Declaration) {
                decl = (Declaration)p1_car;
                name = decl.getSymbol();
            }
            if (name != null && p1.getCdr() instanceof Pair) {
                Pair p2 = (Pair)p1.getCdr();
                LambdaExp lexp = new LambdaExp();
                this.lambdaSyntax.rewrite(lexp, p2.getCar(), p2.getCdr(), tr, null);
                lexp.setSymbol(name);
                if (p2 instanceof PairWithPosition) {
                    lexp.setLocation((PairWithPosition)p2);
                }
                value = lexp;
                SetExp sexp = new SetExp(name, (Expression)value);
                sexp.setDefining(true);
                sexp.setFuncDef(true);
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
        return tr.syntaxError("invalid syntax for " + this.getName());
    }
}

