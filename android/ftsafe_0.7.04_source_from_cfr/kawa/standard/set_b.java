/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.functions.CompilationHelpers;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;
import kawa.standard.SchemeCompilation;

public class set_b
extends Syntax {
    public static final set_b set = new set_b();

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Pair p2;
        Object o1 = form.getCdr();
        SyntaxForm syntax2 = null;
        while (o1 instanceof SyntaxForm) {
            syntax2 = (SyntaxForm)o1;
            o1 = syntax2.getDatum();
        }
        if (!(o1 instanceof Pair)) {
            return tr.syntaxError("missing name");
        }
        Pair p1 = (Pair)o1;
        Expression name = tr.rewrite_car(p1, syntax2);
        Object o2 = p1.getCdr();
        while (o2 instanceof SyntaxForm) {
            syntax2 = (SyntaxForm)o2;
            o2 = syntax2.getDatum();
        }
        if (!(o2 instanceof Pair) || (p2 = (Pair)o2).getCdr() != LList.Empty) {
            return tr.syntaxError("missing or extra arguments to set!");
        }
        Expression value = tr.rewrite_car(p2, syntax2);
        if (name instanceof ApplyExp) {
            ApplyExp aexp = (ApplyExp)name;
            Expression[] args = aexp.getArgs();
            int nargs = args.length;
            int skip = 0;
            Expression func = aexp.getFunction();
            if (args.length > 0 && func instanceof ReferenceExp && ((ReferenceExp)func).getBinding() == SchemeCompilation.applyFieldDecl) {
                skip = 1;
                --nargs;
                func = args[0];
            }
            Expression[] setterArgs = new Expression[]{func};
            Expression[] xargs = new Expression[nargs + 1];
            System.arraycopy(args, skip, xargs, 0, nargs);
            xargs[nargs] = value;
            Declaration setter = CompilationHelpers.setterDecl;
            return new ApplyExp(new ApplyExp(new ReferenceExp(setter), setterArgs), xargs);
        }
        if (!(name instanceof ReferenceExp)) {
            return tr.syntaxError("first set! argument is not a variable name");
        }
        ReferenceExp ref = (ReferenceExp)name;
        Declaration decl = ref.getBinding();
        SetExp sexp = new SetExp(ref.getSymbol(), value);
        sexp.setContextDecl(ref.contextDecl());
        if (decl != null) {
            decl.setCanWrite(true);
            sexp.setBinding(decl);
            decl = Declaration.followAliases(decl);
            if (decl != null) {
                decl.noteValueFromSet(sexp);
            }
            if (decl.getFlag(16384L)) {
                return tr.syntaxError("constant variable " + decl.getName() + " is set!");
            }
            if (decl.context != tr.mainLambda && decl.context instanceof ModuleExp && !decl.getFlag(0x10000000L) && !decl.context.getFlag(2097152)) {
                tr.error('w', decl, "imported variable ", " is set!");
            }
        }
        return sexp;
    }

    static {
        set.setName("set!");
    }
}

