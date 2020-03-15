// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.mapping.Procedure;
import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.mapping.Environment;
import gnu.expr.ReferenceExp;
import gnu.expr.QuoteExp;
import kawa.lang.Translator;
import gnu.expr.Expression;
import kawa.lang.Syntax;

public class constant_fold extends Syntax
{
    public static final constant_fold constant_fold;
    
    static Object checkConstant(final Expression exp, final Translator tr) {
        if (exp instanceof QuoteExp) {
            return ((QuoteExp)exp).getValue();
        }
        if (!(exp instanceof ReferenceExp)) {
            return null;
        }
        final ReferenceExp rexp = (ReferenceExp)exp;
        final Declaration decl = rexp.getBinding();
        if (decl == null || decl.getFlag(65536L)) {
            return Environment.user().get(rexp.getName(), null);
        }
        return Declaration.followAliases(decl).getConstantValue();
    }
    
    @Override
    public Expression rewrite(final Object obj, final Translator tr) {
        Expression exp = tr.rewrite(obj);
        if (!(exp instanceof ApplyExp)) {
            return exp;
        }
        final ApplyExp aexp = (ApplyExp)exp;
        final Object func = checkConstant(aexp.getFunction(), tr);
        if (!(func instanceof Procedure)) {
            return exp;
        }
        final Expression[] args = aexp.getArgs();
        int i = args.length;
        final Object[] vals = new Object[i];
        while (--i >= 0) {
            final Object val = checkConstant(args[i], tr);
            if (val == null) {
                return exp;
            }
            vals[i] = val;
        }
        try {
            return new QuoteExp(((Procedure)func).applyN(vals));
        }
        catch (Error ex) {
            throw ex;
        }
        catch (Throwable ex2) {
            exp = tr.syntaxError("caught exception in constant-fold:");
            tr.syntaxError(ex2.toString());
            return exp;
        }
    }
    
    static {
        (constant_fold = new constant_fold()).setName("constant-fold");
    }
}
