// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.SetExp;
import gnu.expr.Declaration;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.bytecode.ClassType;
import gnu.expr.ClassExp;
import gnu.text.SourceLocator;
import gnu.lists.PairWithPosition;
import gnu.mapping.Symbol;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class define_class extends Syntax
{
    public static final define_class define_class;
    public static final define_class define_simple_class;
    boolean isSimple;
    object objectSyntax;
    
    define_class(final object objectSyntax, final boolean isSimple) {
        this.objectSyntax = objectSyntax;
        this.isSimple = isSimple;
    }
    
    define_class(final String name, final boolean isSimple) {
        super(name);
        this.objectSyntax = object.objectSyntax;
        this.isSimple = isSimple;
    }
    
    @Override
    public boolean scanForDefinitions(Pair st, final ScopeExp defs, final Translator tr) {
        Object st_cdr;
        SyntaxForm nameSyntax;
        for (st_cdr = st.getCdr(), nameSyntax = null; st_cdr instanceof SyntaxForm; st_cdr = nameSyntax.getDatum()) {
            nameSyntax = (SyntaxForm)st_cdr;
        }
        Object name;
        if (st_cdr instanceof Pair) {
            for (name = ((Pair)st_cdr).getCar(); name instanceof SyntaxForm; name = nameSyntax.getDatum()) {
                nameSyntax = (SyntaxForm)name;
            }
            name = tr.namespaceResolve(name);
        }
        else {
            name = null;
        }
        if (!(name instanceof String) && !(name instanceof Symbol)) {
            tr.error('e', "missing class name");
            return false;
        }
        Pair p = (Pair)st_cdr;
        final Declaration decl = tr.define(name, nameSyntax, defs);
        if (p instanceof PairWithPosition) {
            decl.setLocation((SourceLocator)p);
        }
        final ClassExp oexp = new ClassExp(this.isSimple, null);
        decl.noteValue(oexp);
        decl.setFlag(536887296L);
        decl.setType(this.isSimple ? Compilation.typeClass : Compilation.typeClassType);
        tr.mustCompileHere();
        String cname = (name instanceof Symbol) ? ((Symbol)name).getName() : name.toString();
        final int nlen = cname.length();
        if (nlen > 2 && cname.charAt(0) == '<' && cname.charAt(nlen - 1) == '>') {
            cname = cname.substring(1, nlen - 1);
        }
        oexp.setName(cname);
        Object members;
        for (members = p.getCdr(); members instanceof SyntaxForm; members = nameSyntax.getDatum()) {
            nameSyntax = (SyntaxForm)members;
        }
        if (!(members instanceof Pair)) {
            tr.error('e', "missing class members");
            return false;
        }
        p = (Pair)members;
        final ScopeExp save_scope = tr.currentScope();
        if (nameSyntax != null) {
            tr.setCurrentScope(nameSyntax.getScope());
        }
        final Object[] saved = this.objectSyntax.scanClassDef(p, oexp, tr);
        if (nameSyntax != null) {
            tr.setCurrentScope(save_scope);
        }
        final ClassType mtype = tr.getModule().classFor(tr);
        final String clname = oexp.getClassName(tr);
        final String mname = mtype.getName();
        ClassType ctype;
        if (clname.equals(mname)) {
            ctype = mtype;
            tr.getModule().setFlag(8388608);
        }
        else {
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
    public Expression rewriteForm(Pair form, final Translator tr) {
        final Object form_cdr = form.getCdr();
        if (form_cdr instanceof Pair) {
            form = (Pair)form_cdr;
            final Object form_car = form.getCar();
            if (form_car instanceof Declaration) {
                final Declaration decl = (Declaration)form_car;
                final ClassExp oexp = (ClassExp)decl.getValue();
                this.objectSyntax.rewriteClassDef((Object[])form.getCdr(), tr);
                final SetExp sexp = new SetExp(decl, oexp);
                sexp.setDefining(true);
                return sexp;
            }
        }
        return tr.syntaxError(this.getName() + " can only be used in <body>");
    }
    
    static {
        define_class = new define_class("define-class", false);
        define_simple_class = new define_class("define-simple-class", true);
    }
}
