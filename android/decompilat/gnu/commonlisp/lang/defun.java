// 
// Decompiled by Procyon v0.5.36
// 

package gnu.commonlisp.lang;

import gnu.expr.SetExp;
import gnu.text.SourceLocator;
import gnu.lists.PairWithPosition;
import kawa.lang.TemplateScope;
import gnu.expr.LambdaExp;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.Declaration;
import gnu.mapping.Symbol;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Lambda;
import kawa.lang.Syntax;

public class defun extends Syntax
{
    Lambda lambdaSyntax;
    
    public defun(final Lambda lambdaSyntax) {
        this.lambdaSyntax = lambdaSyntax;
    }
    
    @Override
    public boolean scanForDefinitions(Pair st, final ScopeExp defs, final Translator tr) {
        final Pair p;
        if (!(st.getCdr() instanceof Pair) || (!((p = (Pair)st.getCdr()).getCar() instanceof String) && !(p.getCar() instanceof Symbol))) {
            return super.scanForDefinitions(st, defs, tr);
        }
        final Object sym = p.getCar();
        Declaration decl = defs.lookup(sym, tr.getLanguage(), 2);
        if (decl == null) {
            decl = new Declaration(sym);
            decl.setProcedureDecl(true);
            defs.addDeclaration(decl);
            tr.push(decl);
        }
        else {
            tr.error('w', "duplicate declaration for `" + sym + "'");
        }
        if (defs instanceof ModuleExp) {
            decl.setCanRead(true);
        }
        st = Translator.makePair(st, this, Translator.makePair(p, decl, p.getCdr()));
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
            final Object p1_car = p1.getCar();
            if (p1_car instanceof Symbol || p1_car instanceof String) {
                name = p1_car.toString();
            }
            else if (p1_car instanceof Declaration) {
                decl = (Declaration)p1_car;
                name = decl.getSymbol();
            }
            if (name != null && p1.getCdr() instanceof Pair) {
                final Pair p2 = (Pair)p1.getCdr();
                final LambdaExp lexp = new LambdaExp();
                this.lambdaSyntax.rewrite(lexp, p2.getCar(), p2.getCdr(), tr, null);
                lexp.setSymbol(name);
                if (p2 instanceof PairWithPosition) {
                    lexp.setLocation((SourceLocator)p2);
                }
                value = lexp;
                final SetExp sexp = new SetExp(name, value);
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
