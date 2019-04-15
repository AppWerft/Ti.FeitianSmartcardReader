/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.ClassExp;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxForms;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;
import kawa.standard.location;

public class define_alias
extends Syntax {
    public static final define_alias define_alias = new define_alias();
    public static final define_alias define_private_alias = new define_alias();
    private boolean makePrivate = false;

    @Override
    public void scanForm(Pair st, ScopeExp defs2, Translator tr) {
        Object formCdr = st.getCdr();
        SyntaxForm formSyntax = null;
        while (formCdr instanceof SyntaxForm) {
            formSyntax = (SyntaxForm)formCdr;
            formCdr = formSyntax.getDatum();
        }
        if (formCdr instanceof Pair) {
            Pair p1 = (Pair)formCdr;
            SyntaxForm nameSyntax = formSyntax;
            Object name = p1.getCar();
            while (name instanceof SyntaxForm) {
                nameSyntax = (SyntaxForm)name;
                name = nameSyntax.getDatum();
            }
            Object f2 = p1.getCdr();
            while (f2 instanceof SyntaxForm) {
                formSyntax = (SyntaxForm)f2;
                f2 = formSyntax.getDatum();
            }
            if ((name instanceof String || name instanceof Symbol) && f2 instanceof Pair && ((Pair)f2).getCdr() == LList.Empty) {
                Declaration decl = tr.define(name, nameSyntax, defs2);
                decl.setIndirectBinding(true);
                decl.setAlias(true);
                if (this.makePrivate) {
                    decl.setFlag(0x1000000L);
                    decl.setPrivate(true);
                }
                if (formSyntax != null) {
                    f2 = SyntaxForms.makeForm(f2, formSyntax.getScope());
                }
                tr.pushForm(Translator.makePair(st, this, Translator.makePair(p1, decl, f2)));
                return;
            }
        }
        tr.error('e', "invalid syntax for define-alias");
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Object f2;
        Pair p1;
        Object f1 = form.getCdr();
        if (f1 instanceof Pair && (f2 = (p1 = (Pair)f1).getCar()) instanceof Declaration) {
            Declaration decl = (Declaration)f2;
            Expression arg = tr.rewrite_car((Pair)p1.getCdr(), false);
            if (arg instanceof ReferenceExp) {
                Expression dval;
                ReferenceExp rarg = (ReferenceExp)arg;
                Declaration d = Declaration.followAliases(rarg.getBinding());
                if (d != null && ((dval = d.getValue()) instanceof ClassExp || dval instanceof ModuleExp)) {
                    decl.setIndirectBinding(false);
                    decl.setFlag(16384L);
                } else {
                    rarg.setDontDereference(true);
                }
            } else {
                if (!(arg instanceof QuoteExp)) {
                    arg = location.rewrite(arg, tr);
                }
                if (arg instanceof QuoteExp) {
                    decl.setIndirectBinding(false);
                    decl.setFlag(16384L);
                }
            }
            decl.setFlag(0x20000000L);
            tr.mustCompileHere();
            tr.push(decl);
            SetExp sexp = new SetExp(decl, arg);
            tr.setLineOf(sexp);
            decl.noteValueFromSet(sexp);
            sexp.setDefining(true);
            return sexp;
        }
        return tr.syntaxError(this.getName() + " is only allowed in a <body>");
    }

    static {
        define_alias.setName("define-alias");
        define_private_alias.setName("define-private-alias");
        define_alias.define_private_alias.makePrivate = true;
    }
}

