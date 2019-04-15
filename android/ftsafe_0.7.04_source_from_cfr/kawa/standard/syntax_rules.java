/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.Translator;

public class syntax_rules
extends Syntax {
    public static final syntax_rules syntax_rules = new syntax_rules();

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Pair pair1 = (Pair)form.getCdr();
        Object car1 = pair1.getCar();
        Object cdr1 = pair1.getCdr();
        Object ellipsis = SyntaxRule.dots3Symbol;
        if (Translator.stripSyntax(car1) instanceof Symbol && cdr1 instanceof Pair) {
            Pair pair2 = (Pair)cdr1;
            Object car2 = pair2.getCar();
            Object cdr2 = pair2.getCdr();
            if (car2 instanceof LList) {
                ellipsis = car1;
                car1 = car2;
                cdr1 = cdr2;
            }
        }
        Object[] literal_identifiers = SyntaxPattern.getLiteralsList(car1, null, tr);
        SyntaxRules rules = new SyntaxRules(ellipsis, literal_identifiers, cdr1, tr);
        return new QuoteExp(rules);
    }

    static {
        syntax_rules.setName("syntax-rules");
    }
}

