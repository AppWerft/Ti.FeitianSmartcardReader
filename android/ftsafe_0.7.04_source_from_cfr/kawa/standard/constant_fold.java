/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class constant_fold
extends Syntax {
    public static final constant_fold constant_fold = new constant_fold();

    static Object checkConstant(Expression exp, Translator tr) {
        if (exp instanceof QuoteExp) {
            return ((QuoteExp)exp).getValue();
        }
        if (exp instanceof ReferenceExp) {
            ReferenceExp rexp = (ReferenceExp)exp;
            Declaration decl = rexp.getBinding();
            if (decl == null || decl.getFlag(65536L)) {
                return Environment.user().get(rexp.getName(), null);
            }
            return Declaration.followAliases(decl).getConstantValue();
        }
        return null;
    }

    @Override
    public Expression rewrite(Object obj, Translator tr) {
        Expression exp = tr.rewrite(obj);
        if (!(exp instanceof ApplyExp)) {
            return exp;
        }
        ApplyExp aexp = (ApplyExp)exp;
        Object func = constant_fold.checkConstant(aexp.getFunction(), tr);
        if (!(func instanceof Procedure)) {
            return exp;
        }
        Expression[] args = aexp.getArgs();
        int i = args.length;
        Object[] vals = new Object[i];
        while (--i >= 0) {
            Object val = constant_fold.checkConstant(args[i], tr);
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
        catch (Throwable ex) {
            exp = tr.syntaxError("caught exception in constant-fold:");
            tr.syntaxError(ex.toString());
            return exp;
        }
    }

    static {
        constant_fold.setName("constant-fold");
    }
}

