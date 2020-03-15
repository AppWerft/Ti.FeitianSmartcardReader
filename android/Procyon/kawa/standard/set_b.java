// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.ModuleExp;
import gnu.expr.Declaration;
import gnu.expr.SetExp;
import gnu.kawa.functions.CompilationHelpers;
import gnu.expr.ReferenceExp;
import gnu.expr.ApplyExp;
import gnu.lists.LList;
import kawa.lang.SyntaxForm;
import gnu.expr.Expression;
import kawa.lang.Translator;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class set_b extends Syntax
{
    public static final set_b set;
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        Object o1;
        SyntaxForm syntax;
        for (o1 = form.getCdr(), syntax = null; o1 instanceof SyntaxForm; o1 = syntax.getDatum()) {
            syntax = (SyntaxForm)o1;
        }
        if (!(o1 instanceof Pair)) {
            return tr.syntaxError("missing name");
        }
        final Pair p1 = (Pair)o1;
        final Expression name = tr.rewrite_car(p1, syntax);
        Object o2;
        for (o2 = p1.getCdr(); o2 instanceof SyntaxForm; o2 = syntax.getDatum()) {
            syntax = (SyntaxForm)o2;
        }
        final Pair p2;
        if (!(o2 instanceof Pair) || (p2 = (Pair)o2).getCdr() != LList.Empty) {
            return tr.syntaxError("missing or extra arguments to set!");
        }
        final Expression value = tr.rewrite_car(p2, syntax);
        if (name instanceof ApplyExp) {
            final ApplyExp aexp = (ApplyExp)name;
            final Expression[] args = aexp.getArgs();
            int nargs = args.length;
            int skip = 0;
            Expression func = aexp.getFunction();
            if (args.length > 0 && func instanceof ReferenceExp && ((ReferenceExp)func).getBinding() == SchemeCompilation.applyFieldDecl) {
                skip = 1;
                --nargs;
                func = args[0];
            }
            final Expression[] setterArgs = { func };
            final Expression[] xargs = new Expression[nargs + 1];
            System.arraycopy(args, skip, xargs, 0, nargs);
            xargs[nargs] = value;
            final Declaration setter = CompilationHelpers.setterDecl;
            return new ApplyExp(new ApplyExp(new ReferenceExp(setter), setterArgs), xargs);
        }
        if (!(name instanceof ReferenceExp)) {
            return tr.syntaxError("first set! argument is not a variable name");
        }
        final ReferenceExp ref = (ReferenceExp)name;
        Declaration decl = ref.getBinding();
        final SetExp sexp = new SetExp(ref.getSymbol(), value);
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
            if (decl.context != tr.mainLambda && decl.context instanceof ModuleExp && !decl.getFlag(268435456L) && !decl.context.getFlag(2097152)) {
                tr.error('w', decl, "imported variable ", " is set!");
            }
        }
        return sexp;
    }
    
    static {
        (set = new set_b()).setName("set!");
    }
}
