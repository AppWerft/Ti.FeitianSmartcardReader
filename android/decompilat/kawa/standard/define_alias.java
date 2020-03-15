// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.SetExp;
import gnu.expr.QuoteExp;
import gnu.expr.ModuleExp;
import gnu.expr.ClassExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Expression;
import gnu.expr.Declaration;
import kawa.lang.SyntaxForms;
import gnu.lists.LList;
import gnu.mapping.Symbol;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class define_alias extends Syntax
{
    public static final define_alias define_alias;
    public static final define_alias define_private_alias;
    private boolean makePrivate;
    
    public define_alias() {
        this.makePrivate = false;
    }
    
    @Override
    public void scanForm(final Pair st, final ScopeExp defs, final Translator tr) {
        Object formCdr;
        SyntaxForm formSyntax;
        for (formCdr = st.getCdr(), formSyntax = null; formCdr instanceof SyntaxForm; formCdr = formSyntax.getDatum()) {
            formSyntax = (SyntaxForm)formCdr;
        }
        if (formCdr instanceof Pair) {
            final Pair p1 = (Pair)formCdr;
            SyntaxForm nameSyntax;
            Object name;
            for (nameSyntax = formSyntax, name = p1.getCar(); name instanceof SyntaxForm; name = nameSyntax.getDatum()) {
                nameSyntax = (SyntaxForm)name;
            }
            Object f2;
            for (f2 = p1.getCdr(); f2 instanceof SyntaxForm; f2 = formSyntax.getDatum()) {
                formSyntax = (SyntaxForm)f2;
            }
            if ((name instanceof String || name instanceof Symbol) && f2 instanceof Pair && ((Pair)f2).getCdr() == LList.Empty) {
                final Declaration decl = tr.define(name, nameSyntax, defs);
                decl.setIndirectBinding(true);
                decl.setAlias(true);
                if (this.makePrivate) {
                    decl.setFlag(16777216L);
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
    public Expression rewriteForm(final Pair form, final Translator tr) {
        final Object f1 = form.getCdr();
        if (f1 instanceof Pair) {
            final Pair p1 = (Pair)f1;
            final Object f2 = p1.getCar();
            if (f2 instanceof Declaration) {
                final Declaration decl = (Declaration)f2;
                Expression arg = tr.rewrite_car((Pair)p1.getCdr(), false);
                if (arg instanceof ReferenceExp) {
                    final ReferenceExp rarg = (ReferenceExp)arg;
                    final Declaration d = Declaration.followAliases(rarg.getBinding());
                    final Expression dval;
                    if (d != null && ((dval = d.getValue()) instanceof ClassExp || dval instanceof ModuleExp)) {
                        decl.setIndirectBinding(false);
                        decl.setFlag(16384L);
                    }
                    else {
                        rarg.setDontDereference(true);
                    }
                }
                else {
                    if (!(arg instanceof QuoteExp)) {
                        arg = location.rewrite(arg, tr);
                    }
                    if (arg instanceof QuoteExp) {
                        decl.setIndirectBinding(false);
                        decl.setFlag(16384L);
                    }
                }
                decl.setFlag(536870912L);
                tr.mustCompileHere();
                tr.push(decl);
                final SetExp sexp = new SetExp(decl, arg);
                tr.setLineOf(sexp);
                decl.noteValueFromSet(sexp);
                sexp.setDefining(true);
                return sexp;
            }
        }
        return tr.syntaxError(this.getName() + " is only allowed in a <body>");
    }
    
    static {
        define_alias = new define_alias();
        define_private_alias = new define_alias();
        kawa.standard.define_alias.define_alias.setName("define-alias");
        kawa.standard.define_alias.define_private_alias.setName("define-private-alias");
        kawa.standard.define_alias.define_private_alias.makePrivate = true;
    }
}
