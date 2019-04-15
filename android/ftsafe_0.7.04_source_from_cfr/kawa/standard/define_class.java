/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;
import kawa.standard.object;

public class define_class
extends Syntax {
    public static final define_class define_class = new define_class("define-class", false);
    public static final define_class define_simple_class = new define_class("define-simple-class", true);
    boolean isSimple;
    object objectSyntax;

    define_class(object objectSyntax, boolean isSimple) {
        this.objectSyntax = objectSyntax;
        this.isSimple = isSimple;
    }

    define_class(String name, boolean isSimple) {
        super(name);
        this.objectSyntax = object.objectSyntax;
        this.isSimple = isSimple;
    }

    @Override
    public boolean scanForDefinitions(Pair st, ScopeExp defs2, Translator tr) {
        Object name;
        ClassType ctype;
        String mname;
        Object st_cdr = st.getCdr();
        SyntaxForm nameSyntax = null;
        while (st_cdr instanceof SyntaxForm) {
            nameSyntax = (SyntaxForm)st_cdr;
            st_cdr = nameSyntax.getDatum();
        }
        if (st_cdr instanceof Pair) {
            name = ((Pair)st_cdr).getCar();
            while (name instanceof SyntaxForm) {
                nameSyntax = (SyntaxForm)name;
                name = nameSyntax.getDatum();
            }
            name = tr.namespaceResolve(name);
        } else {
            name = null;
        }
        if (!(name instanceof String) && !(name instanceof Symbol)) {
            tr.error('e', "missing class name");
            return false;
        }
        Pair p = (Pair)st_cdr;
        Declaration decl = tr.define(name, nameSyntax, defs2);
        if (p instanceof PairWithPosition) {
            decl.setLocation((PairWithPosition)p);
        }
        ClassExp oexp = new ClassExp(this.isSimple, null);
        decl.noteValue(oexp);
        decl.setFlag(536887296L);
        decl.setType(this.isSimple ? Compilation.typeClass : Compilation.typeClassType);
        tr.mustCompileHere();
        String cname = name instanceof Symbol ? ((Symbol)name).getName() : name.toString();
        int nlen = cname.length();
        if (nlen > 2 && cname.charAt(0) == '<' && cname.charAt(nlen - 1) == '>') {
            cname = cname.substring(1, nlen - 1);
        }
        oexp.setName(cname);
        Object members = p.getCdr();
        while (members instanceof SyntaxForm) {
            nameSyntax = (SyntaxForm)members;
            members = nameSyntax.getDatum();
        }
        if (!(members instanceof Pair)) {
            tr.error('e', "missing class members");
            return false;
        }
        p = (Pair)members;
        ScopeExp save_scope = tr.currentScope();
        if (nameSyntax != null) {
            tr.setCurrentScope(nameSyntax.getScope());
        }
        Object[] saved = this.objectSyntax.scanClassDef(p, oexp, tr);
        if (nameSyntax != null) {
            tr.setCurrentScope(save_scope);
        }
        ClassType mtype = tr.getModule().classFor(tr);
        String clname = oexp.getClassName(tr);
        if (clname.equals(mname = mtype.getName())) {
            ctype = mtype;
            tr.getModule().setFlag(8388608);
        } else {
            ctype = new ClassType(clname);
        }
        oexp.setClassType(ctype);
        oexp.createFields(tr);
        if (saved == null) {
            return false;
        }
        st = Translator.makePair(st, this, Translator.makePair(p, decl, saved));
        tr.pushForm(st);
        return true;
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Object form_car;
        Object form_cdr = form.getCdr();
        if (form_cdr instanceof Pair && (form_car = (form = (Pair)form_cdr).getCar()) instanceof Declaration) {
            Declaration decl = (Declaration)form_car;
            ClassExp oexp = (ClassExp)decl.getValue();
            this.objectSyntax.rewriteClassDef((Object[])form.getCdr(), tr);
            SetExp sexp = new SetExp(decl, (Expression)oexp);
            sexp.setDefining(true);
            return sexp;
        }
        return tr.syntaxError(this.getName() + " can only be used in <body>");
    }
}

